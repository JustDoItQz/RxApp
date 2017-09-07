package org.gisoper.com.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.common.com.constant.ConstantUtils;
import org.common.com.constant.SystemConstant;
import org.common.com.dao.MyBatisDao;
import org.common.com.redis.RedisOper;
import org.common.com.utils.DateUtils;
import org.common.com.utils.ESBOper;
import org.common.com.utils.HttpclientUtil;
import org.gisoper.com.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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





}
