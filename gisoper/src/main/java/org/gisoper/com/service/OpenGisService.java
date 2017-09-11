package org.gisoper.com.service;

import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.common.com.constant.ConstantUtils;
import org.common.com.constant.SystemConstant;
import org.common.com.dao.MyBatisDao;
import org.common.com.redis.RedisOper;
import org.common.com.utils.DateUtils;
import org.common.com.utils.ESBOper;
import org.common.com.utils.HttpclientUtil;
import org.common.com.utils.ResponseESB;
import org.gisoper.com.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.common.com.constant.ConstantUtils.VEHICLE_WEBSITE_DELETE_PREFIX;

@Service
public class OpenGisService {

    private static Logger logger = LoggerFactory.getLogger(OpenGisService.class) ;

    @Autowired
    private MyBatisDao myBatisDao ;
    @Autowired
    private GisOperService gisOperService ;

    //新增设备信息
    public String insertVehicleDevice(TVehicleDevice tVehicleDevice){
        JSONObject result = new JSONObject() ;
        try{
            String id = tVehicleDevice.getId() ;
            if (id!=null&&!id.equals("")){
                myBatisDao.update("org.gisoper.com.mapper.TVehicleDeviceMapper.updateByPrimaryKey",tVehicleDevice);
            }else {
                tVehicleDevice.setId(DateUtils.nextSequence());
                myBatisDao.save("org.gisoper.com.mapper.TVehicleDeviceMapper.insert",tVehicleDevice);
            }
            RedisOper.save(ConstantUtils.vehicle_device_redis+tVehicleDevice.getId(),tVehicleDevice);
            result.put("success","true") ;
            result.put("msgcode","") ;
            result.put("msg","保存成功") ;
            logger.info("保存成功！",tVehicleDevice.getUploadname());
        }catch (Exception e){
            result.put("success","false") ;
            result.put("msg","保存失败") ;
            logger.error("保存失败");
        }

        return result.toString() ;
    }
    public String deleteVehicleDeviceById(String vehicleDeviceId){
        JSONObject result = new JSONObject() ;
        try{
            Map<String,String> map = new HashMap<String, String>() ;
            map.put("id",vehicleDeviceId) ;
            myBatisDao.delete("org.gisoper.com.mapper.TVehicleDeviceMapper.deleteByPrimaryKey",map);
            RedisOper.del(ConstantUtils.vehicle_device_redis+vehicleDeviceId);
            result.put("success","true") ;
            result.put("msg","删除成功") ;
            logger.info("删除成功：id={}",vehicleDeviceId);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success","false") ;
            result.put("msg","删除失败") ;
            logger.error("删除失败:id={}",vehicleDeviceId);
        }
        return result.toString() ;
    }

    public OpenAPIResultVo searchStartEndDistance(String startAddress,String endAddress) throws Exception{

        OpenAPIResultVo result = new OpenAPIResultVo() ;
        JSONObject object = new JSONObject() ;
        //组装对象
        List<AddressInfoCapaVo> addressInfoCapas = new ArrayList<AddressInfoCapaVo>() ;
        //组装开始对象
        AddressInfoCapaVo startAds = new AddressInfoCapaVo() ;
        startAds.setDetail(startAddress);
        addressInfoCapas.add(startAds) ;
        //组装结束对象
        AddressInfoCapaVo endAds = new AddressInfoCapaVo() ;
        endAds.setDetail(endAddress);
        addressInfoCapas.add(endAds) ;
        Map<String,List<AddressInfoVo>>  mapAddress = gisOperService.addressInfoBatch(addressInfoCapas) ;
        List<AddressInfoVo> errorList = mapAddress.get("errorList") ;
        if (errorList!=null&&errorList.size()>0){
            result.setSuccess("false");
            result.setMsgcode("");
            result.setMsg("地址转换异常");
            return result ;
        }
        List<AddressInfoVo> listAddressVo = mapAddress.get("listAddressVo") ;
        if (listAddressVo!=null&&listAddressVo.size()>0){
            AddressInfoVo origin = new AddressInfoVo() ;
            origin.setLocation(listAddressVo.get(0).getLocation());
            AddressInfoVo destination = new AddressInfoVo() ;
            destination.setLocation(listAddressVo.get(1).getLocation());
            List<AddressInfoVo> origins = new ArrayList<AddressInfoVo>() ;
            origins.add(origin) ;
            List<BeanDistanceVo>  beanDistanceVos = gisOperService.searchDistance(origins,destination) ;
            result.setData(JSONObject.fromObject(beanDistanceVos.get(0)));
            result.setMsg("查询两点间距离成功！");
            result.setSuccess("true");

        }
        return result ;


    }

    public List<LngLatVo.ListResponse> lngLatConvertAddressBatchESB(LngLatVo.ListRequest listRequests){
        List<LngLatVo.ListResponse> listResponses = new ArrayList<LngLatVo.ListResponse>() ;
        try{
            List<String> requestList = new ArrayList<String>() ;
            requestList = listRequests.getList() ;
            String lnglat = "" ;
            Map<String,String> param = new HashMap<String, String>() ;
            param.put("output","json") ;
            param.put("radius","1000") ;
            param.put("extensions","base") ;
            param.put("batch","true") ;
            if (requestList!=null&&requestList.size()>0){
                for (int i=0;i<requestList.size();i++){
                    if (i==(requestList.size()-1)){
                        lnglat+= requestList.get(i) ;
                    }else {
                        lnglat+=requestList.get(i)+"|" ;
                    }
                }

            }
            param.put("location",lnglat) ;
            param.put("key", SystemConstant.getGAODE_KEY()) ;
            String str = HttpclientUtil.postMSG(param,ConstantUtils.ADDRESS_TO_LOCATION_URL_PREFIX) ;
            JSONObject object = JSONObject.fromObject(str) ;
            if (object.getString("infocode").equals("10000")&&object.getString("info").equals("OK")){
                JSONArray jsonArray = object.getJSONArray("regeocodes") ;
                if (jsonArray!=null&&jsonArray.size()>0){
                    for (int i=0;i<jsonArray.size();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i) ;
                        String address = (String) jsonObject.get("formatted_address") ;
                        JSONObject addressComponent = jsonObject.getJSONObject("addressComponent") ;
                        String province =addressComponent.getString("province") ;
                        String city = addressComponent.getString("city") ;
                        String district = addressComponent.getString("district") ;
                        String township= addressComponent.getString("township") ;
                        String country= addressComponent.getString("country") ;
                        LngLatVo.ListResponse  response = new LngLatVo.ListResponse() ;
                        response.setAddress(address);
                        response.setCity(city);
                        response.setProvince(province);
                        response.setCountry(country);
                        response.setDistrict(district);
                        response.setTownship(township);
                        listResponses.add(response) ;
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listResponses ;
    }

    public String leaveWebsiteVehicle(String leavePointId,String vehicleNo){
        JSONObject result = new JSONObject() ;
        Map<String,String> logMap = new HashMap<String, String>() ;
        logMap.put("start","车牌号："+vehicleNo+"车辆发车开始----------------------网点ID为"+leavePointId) ;
        try{
            Map<String,Object>  map = new HashMap<String, Object>() ;
            map.put("vehicleNo",vehicleNo) ;
            map.put("leavePointId",leavePointId) ;
            String leaveWebsitrMap = ESBOper.callESB("TMS_S_10004","TMS",map) ;
            if (leaveWebsitrMap!=null){
                JSONObject object = JSONObject.fromObject(leaveWebsitrMap) ;
                if (object.get("body")!=null&&!object.get("body").equals("")){
                    JSONObject body = (JSONObject) object.get("body") ;
                    if (object.getBoolean("success")==true){
                        result.put("success","true") ;
                        result.put("msg","车牌号："+vehicleNo+",网点编号："+leavePointId+",发车成功") ;
                        logMap.put("车辆发车","车牌号："+vehicleNo+",网点编号："+leavePointId+",发车成功") ;
                    }else{
                        result.put("success","false") ;
                        result.put("msg","车牌号："+vehicleNo+",网点编号："+leavePointId+",发车失败") ;
                        logMap.put("车辆发车","车牌号："+vehicleNo+",网点编号："+leavePointId+",发车失败") ;
                    }
                }
            }
            result.put("msgcode","") ;
            result.put("message",leaveWebsitrMap) ;
            logMap.put("end","车牌号："+vehicleNo+"车辆网点发车请求---------------end--------------------"+leavePointId) ;
            logger.info("车牌号："+vehicleNo+",网点"+leavePointId+",车辆发车：{}"+logMap);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("车牌号："+vehicleNo+"车辆发车失败:{},{}",e,logMap);
            result.put("success","false") ;
            result.put("msg","车牌号："+vehicleNo+"发车失败") ;
        }
        return result.toString() ;
    }

    public String signInVehicle(String arrivePointId,String vehicleNo){

        JSONObject result = new JSONObject() ;
        Map<String,String> logMap = new HashMap<String, String>() ;
        logger.info("车辆网点开始签到");
        try{
            Map<String,Object> map = new HashMap<String, Object>() ;
            map.put("arrivePointId",arrivePointId) ;
            map.put("vehicleNo",vehicleNo) ;
            String str = ESBOper.callESB("TMS_S_SIGNUP","S25",map) ;
            JSONObject object = JSONObject.fromObject(str) ;
            if (object.getBoolean("body")==true){
                result.put("succes","true") ;
                result.put("msg","车牌号："+vehicleNo+"签到成功,签到网点"+arrivePointId) ;
                logMap.put("车辆签到","车牌号："+vehicleNo+"签到成功,签到网点"+arrivePointId) ;
            }else {
                result.put("succes","false") ;
                result.put("msg","车牌号："+vehicleNo+"签到失败,签到网点"+arrivePointId) ;
                logMap.put("车辆签到","车牌号："+vehicleNo+"签到失败,签到网点"+arrivePointId) ;
            }
            result.put("msgcode","") ;
            result.put("message",str) ;

        }catch (Exception e){
            e.printStackTrace();
            result.put("success","false") ;
            result.put("msg","车牌号："+vehicleNo+"签到失败,签到网点"+arrivePointId) ;
            logger.info("车牌号：{}签到失败,签到网点{}，{}",vehicleNo,arrivePointId,e.getMessage());
        }

        return result.toString() ;
    }
    public String deleteVehicleWebsiteById(String websiteId){
        Map<String,String> param = new HashMap<String,String>() ;
        Map<String,String> logMap = new HashMap<String, String>() ;
        JSONObject result = new JSONObject() ;
        try{
            param.put("id",websiteId) ;
            String str = HttpclientUtil.postMSG(param,ConstantUtils.VEHICLE_WEBSITE_DELETE_PREFIX) ;
            logger.info("删除电子围栏","删除"+websiteId+"上传到高德地图");
            logMap.put("删除电子围栏","删除"+websiteId+"上传到高德地图") ;
            JSONObject jsonObject = JSONObject.fromObject(str) ;
            ResultVo resultVo = (ResultVo)JSONObject.toBean(jsonObject,ResultVo.class) ;
            if (resultVo.getMsg().equals("success")){
                myBatisDao.delete("org.gisoper.com.mapper.TVehicleWebsiteMapper.deleteWebsitById",websiteId);//从数据库删除数据
            }else{
                param.put("opearType","D") ;
                param.put("opearStatus","0") ;
                myBatisDao.update("org.gisoper.com.mapper.TVehicleWebsiteMapper,updateOperatStatePrimaryKey",param);
            }
            result.put("success","true") ;
            result.put("msgcode","") ;
            result.put("msg",websiteId+"删除网点成功！") ;
            logMap.put("提示",websiteId+"网点删除成功!") ;
        }catch (Exception e){
            e.printStackTrace();
            result.put("success","false") ;
            result.put("msg",websiteId+"网点删除失败！") ;
            logger.error(websiteId+"删除网点信息失败,{},{},",e,logMap);
        }

        return result.toString() ;
    }
    public String insertVehicleWebsite(TVehicleWebsite vehicleWebsite){
        JSONObject result = new JSONObject() ;
        Map<String,String> param = new HashMap<String, String>() ;
        try{
            TVehicleWebsite website = new TVehicleWebsite() ;
            if (vehicleWebsite.getWebsiteType()!=null&&vehicleWebsite.getWebsiteType().equals("")){
                website.setWebsiteType(vehicleWebsite.getWebsiteType());
            }else {
                result.put("msg","网点类型不能为空") ;
                result.put("success","false") ;
                return result.toString() ;
            }
            if (vehicleWebsite.getLat()!=null&&vehicleWebsite.getLat().equals("")&&
                    vehicleWebsite.getLng()!=null&&vehicleWebsite.getLng().equals("")){

            }else {
                result.put("success","false") ;
                result.put("msg","网点的经纬度不能为空") ;
                return result.toString() ;
            }
            TVehicleWebsite tVehicleWebsite = myBatisDao.get("",vehicleWebsite.getId()) ;

            //新增网点信息上传es
            JSONObject data = JSONObject.fromObject(website) ;
            param.put("geodata",data.toString()) ;
            String str = HttpclientUtil.postMSG(param,"") ;
            JSONObject jsonObject = JSONObject.fromObject(str) ;
            String status = null  ;
            if (jsonObject!=null&&jsonObject.equals("")){
                status=jsonObject.getString("status") ;
                if (status.equals("success")){
                    website.setOperStatus("1");
                }else {
                    website.setOperStatus("0");
                }
            }

            if (tVehicleWebsite!=null){
                website.setOperType("U");
                myBatisDao.update("执行更新操作",website);
            }else {
                website.setOperType("A");
                myBatisDao.save("重新保存",website);
            }
            result.put("success","true") ;
            result.put("msg",vehicleWebsite.getWebsitName()+"保存成功") ;

        }catch (Exception e){
            e.printStackTrace();
            result.put("msg","网点保存失败") ;
            result.put("success","false") ;
            logger.error("网点信息保存失败,{}",e.getMessage());
        }
        return result.toString() ;
    }

    public void initWebsite(){
        saveWebsite();

    }

    public void saveWebsite(){
        List<TVehicleWebsite> listESB = getALlWebsite() ;
        Map<String,TVehicleWebsite> mapESB = findAllDBWebsite() ;
        List<TVehicleWebsite> updateWebsite = new ArrayList<TVehicleWebsite>() ;
        List<TVehicleWebsite> addWebsite = new ArrayList<TVehicleWebsite>() ;
        Map<String,TVehicleWebsite> websiteMap = new HashMap<String, TVehicleWebsite>() ;
        List<String> deleteWebsite = new ArrayList<String>() ;
        if (listESB!=null&&listESB.size()>0){
            for (TVehicleWebsite vehicleWebsite:listESB){
                if (mapESB.containsKey(vehicleWebsite.getId())){
                    if (isCompareWebsite(vehicleWebsite,mapESB.get(vehicleWebsite.getId()))){
                        vehicleWebsite.setOperType("U");
                        updateWebsite.add(vehicleWebsite) ;//需更新
                    }else {
                        vehicleWebsite.setOperType("A");
                        addWebsite.add(vehicleWebsite) ;
                    }
                }
                websiteMap.put(vehicleWebsite.getId(),vehicleWebsite) ;
            }

            //遍历esb中的数据
            for (Map.Entry<String,TVehicleWebsite> entry:websiteMap.entrySet()){
                if (!websiteMap.containsKey(entry.getKey())){
                    deleteWebsite.add(entry.getKey()) ;
                }
            }
            //执行新增操作
            if (addWebsite!=null&&addWebsite.size()>0){
               websiteInit(addWebsite,"A");
            }
            //执行更新操作
            if (updateWebsite!=null&&updateWebsite.size()>0){
                websiteInit(updateWebsite,"U");
            }
            //执行删除操作
            if (deleteWebsite!=null&&deleteWebsite.size()>0){
                websiteDelete(deleteWebsite,"D");
            }
        }

    }
    public List<TVehicleWebsite> getALlWebsite(){
        List<TVehicleWebsite> list = new ArrayList<TVehicleWebsite>() ;
        String str = ESBOper.callESB("","","") ;
        TypeToken<List<TVehicleWebsite>> token = new TypeToken<List<TVehicleWebsite>>(){} ;
        ResponseESB<List<TVehicleWebsite>> responseESB = ESBOper.getResponseESB(str,token) ;
        list = responseESB.getBody() ;
        return list ;
    }
    public Map<String,TVehicleWebsite> findAllDBWebsite(){
        Map<String,TVehicleWebsite> tVehicleWebsiteMap = new HashMap<String, TVehicleWebsite>() ;
        List<TVehicleWebsite> vehicleWebsites = myBatisDao.getList("") ;
        if (vehicleWebsites!=null&&vehicleWebsites.size()>0){
            for (TVehicleWebsite vehicleWebsite:vehicleWebsites){
                tVehicleWebsiteMap.put(vehicleWebsite.getId(),vehicleWebsite) ;
            }
        }
        return tVehicleWebsiteMap ;
    }
    public boolean isCompareWebsite(TVehicleWebsite vehicleWebsite,TVehicleWebsite tVehicleWebsite){
        boolean isTrue = true ;

        return isTrue ;
    }
    public void websiteInit(List<TVehicleWebsite> vehicleWebsites,String type){

    }
    public void websiteDelete(List<String> deleteList,String type){

    }

    public RouteDriverVo.Response antoRouteDriver(RouteDriverVo.Request request){
        RouteDriverVo.Response response = new RouteDriverVo.Response() ;
        try{
            String gisId = DateUtils.nextSequence() ;
            response.setGisId(gisId);
            //RouteDriverVo.Response routeDriverVo = addressInfos(s)

        }catch (Exception e){

        }
        return response ;

    }
    public RouteDriverVo.Response addInfoList(RouteDriverVo.Request requestVo,RouteDriverVo.Response response){
        List<String> errorAddressInfoVos = new ArrayList<String>() ;
        AddressInfoCapaVo startAddress = requestVo.getStartAddress() ;
        if (startAddress!=null&&StringUtils.isNotBlank(startAddress.getDetail())){
            AddressInfoVo startInfoVo = addressInfos(startAddress) ;
        }
        return null ;

    }

    public AddressInfoVo addressInfos(AddressInfoCapaVo infoCapaVo){
        AddressInfoVo addressInfoVo = new AddressInfoVo() ;
        Map<String,String> param = new HashMap<String, String>() ;
        param.put("key",SystemConstant.getGAODE_KEY()) ;
        param.put("address",infoCapaVo.getDetail()) ;
        if (StringUtils.isNotBlank(infoCapaVo.getCityName())){
            param.put("city",infoCapaVo.getCityName()) ;
        }
        param.put("output","json") ;
        String result = HttpclientUtil.postMSG(param,"") ;
        JSONObject object = JSONObject.fromObject(result) ;
        try{
            if (object.containsKey("geocodes")){
                JSONArray array = object.getJSONArray("geocodes") ;
                StringBuilder sb = new StringBuilder() ;
                JSONObject geocode = (JSONObject) array.get(0) ;


            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return addressInfoVo ;
    }

}
