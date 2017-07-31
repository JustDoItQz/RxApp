package org.gisoper.com.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.common.com.constant.ConstantUtils;
import org.common.com.constant.SystemConstant;
import org.common.com.dao.MyBatisDao;
import org.common.com.redis.RedisOper;
import org.common.com.utils.DateUtils;
import org.common.com.utils.HttpclientUtil;
import org.common.com.utils.Pinyin4JUtils;
import org.gisoper.com.vo.BasLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by on 2017/6/23.
 * Author Aaron.Wang
 */
@Service
public class GisOpertService {
    private static Logger logger = LoggerFactory.getLogger(GisOpertService.class) ;

    @Autowired
    private  MyBatisDao myBatisDao;

    public  void initBaseLocalCode () throws  Exception{

        Map<String,String> paramters =  new HashMap<String,String>() ;
        List<BasLocation> baseLocationCodes = new ArrayList<BasLocation>() ;
        paramters.put("output","json") ;
        paramters.put("lavel","contry") ;
        paramters.put("subdistrict","4") ;
        paramters.put("key", SystemConstant.getGAODE_KEY()) ;
        String str = HttpclientUtil.postMSG(paramters, ConstantUtils.ADDRESS_DISTRICT_URL_PREFIX) ;
        logger.info("获取到的高德数据{}",str);
        if (str!=null){
            JSONObject json = JSONObject.fromObject(str) ;
            String info = (String) json.get("info") ;
            String status = (String) json.get("status") ;
            if ("OK".equals(info)&&"1".equals(status)){
                JSONArray jsonArray = json.getJSONArray("districts") ;
                if (jsonArray!=null&&jsonArray.size()>0){
                    for (int i=0;i<jsonArray.size();i++){
                        JSONObject object = (JSONObject) jsonArray.get(i) ;
                        String adcode = object.getString("adcode") ;
                        if ("100000".equals(adcode)){
                            JSONArray jsonChina = object.getJSONArray("districts") ;
                            //初始化省级别
                            insertProvinceAddressCode(jsonChina,baseLocationCodes);
                        }
                    }
                }
            }
        }
      /*  //更新数据
        List<BasLocation> updateBasLocationCode = new ArrayList<BasLocation>() ;
        //增加数据
        List<BasLocation> addBasLocationCode = new ArrayList<BasLocation>() ;
        for (BasLocation basLocationCode:baseLocationCodes){

            BasLocation locationCode = RedisOper.get(ConstantUtils.ADDRESS_AREA_CODE_REDIS+basLocationCode.getLocationId(),BasLocation.class) ;
            if (basLocationCode!=null){ //更新地址
                if (!basLocationCode.getLocationFullname().equals(locationCode.getLocationFullname())||
                        !basLocationCode.getLocationCode().equals(locationCode.getLocationCode())){
                    updateBasLocationCode.add(basLocationCode) ;
                    //更新到redis缓存
                }
            }else{ //新增地址
                addBasLocationCode.add(basLocationCode) ;
                //更新到redis缓存
            }
        }*/

        logger.info("高德获取到的数据：{}",baseLocationCodes.toString());
        if (baseLocationCodes!=null&&baseLocationCodes.size()>0){
            myBatisDao.save("org.gisoper.com.mapper.BasLocationMapper.insertLocationAreaCode",baseLocationCodes);

        }
    }
    //省province
    public void insertProvinceAddressCode(JSONArray jsonArray, List<BasLocation> baseLocationCodes){
        if (jsonArray!=null&&jsonArray.size()>0){

            for (int i=0;i<jsonArray.size();i++){
                BasLocation baseLocationCode = new BasLocation() ;
                JSONObject object = (JSONObject) jsonArray.get(i) ;
                String addressName = object.getString("name") ;
                String level = object.getString("level") ;
                String provinceCodeId = object.get("adcode").toString() ;
                if ("province".equals(level)){
                    //设置城市信息
                    setBasLocationCodeByJson(object,baseLocationCode,addressName,"","") ;
                    baseLocationCodes.add(baseLocationCode) ;
                    JSONArray jsonDiss = object.getJSONArray("districts") ;
                    if (jsonDiss!=null&&jsonDiss.size()>0){

                        insertCityAddressCode(jsonDiss,baseLocationCodes,addressName,provinceCodeId);
                    }

                }
            }
        }
    }

    //市 city
    public void insertCityAddressCode(JSONArray jsonArray,List<BasLocation> baseLocationCodes,String provinceName,String provinceCodeId){
        if (jsonArray!=null&&jsonArray.size()>0){
            for (int i=0;i<jsonArray.size();i++){
                BasLocation baseLocationCode = new BasLocation() ;
                JSONObject object = (JSONObject)jsonArray.get(i) ;
                String cityName = object.getString("name") ;
                if (cityName.contains("市辖区")){
                    cityName = cityName.substring(0,cityName.lastIndexOf("市辖区")) ;
                }
                if (cityName.contains("城区")){
                    cityName = cityName.substring(0,cityName.lastIndexOf("城区"))+"市" ;
                }

                String level = object.getString("level") ;
                String pcityName = provinceName+"|"+cityName ;
                if ("city".equals(level)){
                    String cityCodeId = object.get("adcode").toString() ;
                    //设置地区信息
                    setBasLocationCodeByJson(object,baseLocationCode,pcityName,provinceCodeId,provinceCodeId);
                    //对于县级市需要补充上一级
                    String adcode = object.get("adcode").toString() ;
                    if (!adcode.substring(4,6).equals("00")){
                        baseLocationCode.setLocationLevel("district");
                    }
                    baseLocationCodes.add(baseLocationCode) ;
                    JSONArray jsonDiss = object.getJSONArray("districts") ;
                    String pcdistricts = provinceCodeId+"|"+cityCodeId ;
                    if (jsonDiss!=null&&jsonDiss.size()>0){
                        insertDistrictAddressCode(jsonDiss,baseLocationCodes,pcityName,cityCodeId,pcdistricts);
                    }

                }
            }
        }

    }
    public void insertDistrictAddressCode(JSONArray jsonArray,List<BasLocation> baseLocationCodes,String pcityName,String cityCodeId,String pcdistricts){
        if (jsonArray!=null&&jsonArray.size()>0){
            for (int i=0;i<jsonArray.size();i++){
                BasLocation baseLocationCode = new BasLocation() ;
                JSONObject jsonObject = (JSONObject) jsonArray.get(i) ;
                String districtName = jsonObject.getString("name") ;
                String level = jsonObject.getString("level") ;
                String pcdistrict = pcityName+"|"+districtName ;
                if ("district".equals(level)){
                    JSONArray jsonDiss = jsonObject.getJSONArray("districts") ;
                    String districtCode = jsonObject.getString("adcode") ;
                    String districtCodeId = cityCodeId+"|"+districtCode ;
                    setBasLocationCodeByJson(jsonObject,baseLocationCode,pcdistrict,districtCode,districtCodeId);
                    insertStreetAddressCode(jsonDiss,baseLocationCodes,pcdistrict,districtCode,districtCodeId) ;
                    //baseLocationCodes.add(baseLocationCode) ;
                }
            }
        }
    }

    public void insertStreetAddressCode(JSONArray jsonDiss,List<BasLocation> baseLocationCodes,String pcdistrict,String districtCodeId,String pcdistricts){
        if (jsonDiss!=null&&jsonDiss.size()>0){
            for (int i=0;i<jsonDiss.size();i++){
                BasLocation baseLocationCode = new BasLocation() ;
                JSONObject jsonObject = (JSONObject) jsonDiss.get(i) ;
                String streerName = jsonObject.getString("name") ;
                String level = jsonObject.getString("level") ;
                String pcdstreet = pcdistrict+streerName ;
                if ("street".equals(level)){
                    String streetCode = jsonObject.getString("adcode") ;
                    String streetCodeId = districtCodeId+streetCode ;
                    setBasLocationCodeByJson(jsonObject,baseLocationCode,pcdstreet,streetCode,streetCodeId);
                    baseLocationCodes.add(baseLocationCode) ;

                }
            }
        }

    }
    public void setBasLocationCodeByJson(JSONObject object,BasLocation baseLocationCode,String addressName,String parentCodeId,String parentLocationFullId){
        String adcode = object.get("adcode").toString() ;
        String localName = object.get("name").toString() ;
        String level = object.get("level").toString() ;
        if (localName.contains("市辖区")){
            localName = localName.substring(0,localName.lastIndexOf("市辖区")) ;
        }
        if (level.equals("city")){
            if (localName.contains("城区")){
                localName = localName.substring(0,localName.lastIndexOf("城区"))+"市" ;
            }
        }
        //地址主键Id
        if (StringUtils.isBlank(adcode)){
            baseLocationCode.setLocationId(DateUtils.nextSequence());
        }else{
            baseLocationCode.setLocationId(adcode);
        }
        //城市编码
        Object citycode = object.get("citycode") ;
        if (citycode instanceof String){
            baseLocationCode.setLocationCityCode(object.get("citycode").toString());
            baseLocationCode.setLocationCode(object.get("citycode").toString());
        }else{
            baseLocationCode.setLocationCityCode("0"+adcode.substring(0,2));
            baseLocationCode.setLocationCode("0"+adcode.substring(0,2));
        }
        baseLocationCode.setParentLocationId(parentCodeId);
        baseLocationCode.setParentLocationFullId(parentLocationFullId);
        baseLocationCode.setLocationCenter(object.get("center").toString());
        baseLocationCode.setCreateTime(new Date());
        baseLocationCode.setUpdateTime(new Date());
        baseLocationCode.setFullSpell(Pinyin4JUtils.cn2PY(localName));
        baseLocationCode.setShortSpell(Pinyin4JUtils.cn2PYInitial(localName));
        baseLocationCode.setLocationLevel(level);
        baseLocationCode.setLocationName(localName);
        baseLocationCode.setLocationFullname(addressName.replaceAll("\\|",""));
        baseLocationCode.setLocationFullnameSpell(addressName);
        baseLocationCode.setCreaterId("0");
        baseLocationCode.setDeleteFlg("0");

    }


    /**
     *  查询所有数据（数据库）
     * @param
     * @return
     */
    public List<BasLocation> selectAllArea(){

        List<BasLocation> basLocations = myBatisDao.getList("org.gisoper.com.mapper.BasLocationMapper.selectAllArea") ;
        return basLocations ;
    }

    /**
     *  将查询到的乡镇(街道)数据插入数据库
     * @param
     * @return
     */
    public void insertLocalAreaCode(){

        List<BasLocation> basLocationList = selectAllArea() ;
        List<BasLocation> basLocations = new ArrayList<BasLocation>() ;
        if (basLocationList!=null&&basLocationList.size()>0){
            for (BasLocation basLocation:basLocationList){
                getBaseCodeArea(basLocations,basLocation,1);
            }
        }
        if (basLocations!=null&&basLocations.size()>0){
            myBatisDao.save("org.gisoper.com.mapper.BasLocationMapper.insertLocationAreaCode",basLocations);
        }
    }

    /**
     *  将查询到的乡镇(街道)输入插入到redis
     * @param
     * @return
     */
    public void insertLocalAreaCodeToRedis(){

        List<BasLocation> basLocationList = selectAllArea() ;
        List<BasLocation> basLocations = new ArrayList<BasLocation>() ;
        if (basLocationList!=null&&basLocationList.size()>0){
            for (BasLocation basLocation:basLocationList){
                getBaseCodeArea(basLocations,basLocation,0);
            }
        }
        if (basLocations!=null&&basLocations.size()>0){

            logger.info("地址库数据开始插入到redis！");
            for (BasLocation basLocation:basLocations){
                RedisOper.save(ConstantUtils.ADDRESS_AREA_CODE_REDIS+basLocation.getLocationId(),basLocation);
            }
        }else{
            logger.info("","");
        }
        logger.info("地址库数据插入redis成功！");
    }


    /**
     *  初始化街道数据，将数据缓存到redis
     *   index=0将数据插入到redis，index=1将数据插入到数据库
     * @param
     * @return
     */

    public  void getBaseCodeArea(List<BasLocation> basLocations,BasLocation basLocationCode,int index){

        try{
            String requestUrl = ConstantUtils.ADDRESS_TENGCENT_DISTRICT_URL_PREFIX+"?key="+SystemConstant.getTENGCENT_KEY()+"&output=json"+"&id="+basLocationCode.getLocationId() ;
            String str = HttpclientUtil.getMSG(requestUrl) ;
            if (str!=null&&str!=""){

                JSONObject json = JSONObject.fromObject(str) ;
                String status = json.getString("status") ;
                if (status.equals("0")){
                    JSONArray array = json.getJSONArray("result").getJSONArray(0) ;
                    if (array!=null&&array.size()>0){
                        for (int i=0;i<array.size();i++){
                            JSONObject jsonObject = (JSONObject) array.get(i) ;
                            String areaName = jsonObject.getString("fullname") ;
                            String padistrict = basLocationCode.getLocationFullnameSpell()+"|"+areaName ;
                            String cityCode = basLocationCode.getLocationCityCode() ;
                            String locationCodeId = basLocationCode.getLocationId() ;
                            String pcestreet = basLocationCode.getParentLocationFullId()+"|"+locationCodeId ;
                            BasLocation basLocation = new BasLocation() ;
                            setLocationCodeTengXunByJson(jsonObject,basLocation,padistrict,cityCode,locationCodeId,pcestreet,index) ;
                            basLocations.add(basLocation) ;
                        }
                    }

                }

            }
        }catch (Exception e){
            e.printStackTrace();


        }
    }


    public void setLocationCodeTengXunByJson(JSONObject object,BasLocation basLocation,String addressName,String cityCode,String parentCodeId,String pcastreet,int index){
        String localName = object.get("fullname").toString() ;
        String locationId = object.get("id").toString() ;
        JSONObject latlngjson = object.getJSONObject("location") ;
        double lat = latlngjson.getDouble("lat") ;
        double lng = latlngjson.getDouble("lng") ;
        String locationCenter = lng+","+lat ;
        if (index==0){
            basLocation.setLocationId(locationId);
        }
        basLocation.setLocationCenter(locationCenter);
        basLocation.setCreateTime(new Date());
        basLocation.setUpdateTime(new Date());
        basLocation.setFullSpell(Pinyin4JUtils.cn2PY(localName));
        basLocation.setShortSpell(Pinyin4JUtils.cn2PYInitial(localName));
        basLocation.setLocationLevel("street");
        basLocation.setLocationCode(cityCode);
        basLocation.setLocationCityCode(cityCode);
        basLocation.setParentLocationFullId(parentCodeId);
        basLocation.setParentLocationFullId(pcastreet);
        basLocation.setLocationName(localName);
        basLocation.setLocationFullname(addressName.replaceAll("\\|",""));
        basLocation.setLocationFullnameSpell(addressName);
        basLocation.setCreaterId("0");
        basLocation.setUpdaterId("0");
        basLocation.setDeleteFlg("0");

    }

    /**
     *  根据locationId获取redis数据
     * @param
     * @return
     */
    public BasLocation getRedisDataByLocationId(String locationId){
        BasLocation basLocation = new BasLocation() ;
        basLocation = RedisOper.get(ConstantUtils.ADDRESS_AREA_CODE_REDIS+locationId,BasLocation.class) ;
        return basLocation ;
    }

}
