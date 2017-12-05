package org.gisoper.com.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.common.com.constant.ConstantUtils;
import org.common.com.constant.SystemConstant;
import org.common.com.dao.MyBatisDao;
import org.common.com.utils.GsonUtil;
import org.common.com.utils.HttpclientUtil;
import org.gisoper.com.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*地址库操作服务层*/
@Service
public class PointLocalService {

    @Autowired
    private MyBatisDao myBatisDao;

    /*查询所有省数据*/
    public String searchAddressByKey(String locationLevel, String locationId, String page, String pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        BasLocation basLocation = new BasLocation();
        if (StringUtils.isNotBlank(page) || StringUtils.isNotBlank(pageSize)) {
            int pages = Integer.parseInt(page);
            int pagesizes = Integer.parseInt(pageSize);
            basLocation.setPage(pages);
            basLocation.setPageSize(pagesizes);
        }
        if (StringUtils.isNotBlank(locationLevel)) {
            if (locationLevel.equals("province")) {
                basLocation.setLocationLevel(locationLevel);
                basLocation.setLocationId("");
                List<BasLocation> basLocationList = myBatisDao.getList("org.gisoper.com.mapper.BasLocationMapper.searchAddressByLocationId", basLocation);
                map.put("data", basLocationList);
            } else if (locationLevel.equals("city")) {
                basLocation.setLocationLevel(locationLevel);
                if (StringUtils.isNotBlank(locationId)) {
                    basLocation.setLocationId(locationId.substring(0, 2) + "%");
                    List<BasLocation> basLocationList = myBatisDao.getList("org.gisoper.com.mapper.BasLocationMapper.searchAddressByLocationId", basLocation);
                    map.put("data", basLocationList);
                } else {
                    map.put("msg", "locationId不能为空！");
                    return GsonUtil.objToStr(map);
                }
            } else if (locationLevel.equals("district")) {
                basLocation.setLocationLevel(locationLevel);
                if (StringUtils.isNotBlank(locationId)) {
                    basLocation.setLocationId(locationId.substring(0, 4) + "%");
                    List<BasLocation> basLocationList = myBatisDao.getList("org.gisoper.com.mapper.BasLocationMapper.searchAddressByLocationId", basLocation);
                    map.put("data", basLocationList);
                } else {
                    map.put("msg", "locationId不能为空！");
                    return GsonUtil.objToStr(map);
                }
            } else if (locationLevel.equals("street")) {
                basLocation.setLocationLevel(locationLevel);
                if (StringUtils.isNotBlank(locationId)) {
                    basLocation.setLocationId(locationId.substring(0, 6) + "%");
                    List<BasLocation> basLocationList = myBatisDao.getList("org.gisoper.com.mapper.BasLocationMapper.searchAddressByLocationId", basLocation);
                    map.put("data", basLocationList);
                } else {
                    map.put("msg", "locationId不能为空！");
                    return GsonUtil.objToStr(map);
                }
            }
        } else {
            map.put("msg", "locationLevel不能为空！");
        }
        return GsonUtil.objToStr(map);
    }

    //根据经纬度查询地址
    public String searchAddressByLatLng(String request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        LatLngToAddressVo.Request requestVo = null;
        if (StringUtils.isNotBlank(request)) {
            requestVo = GsonUtil.strToObj(request, LatLngToAddressVo.Request.class);
            if (StringUtils.isBlank(requestVo.getLat()) || StringUtils.isBlank(requestVo.getLng())) {
                resultMap.put("msg", "经纬度不能为空！");
                return GsonUtil.objToStr(resultMap);
            } else {
                Map<String, String> paramMap = new HashMap<String, String>();
                LatLngToAddressVo.Response responseVo = new LatLngToAddressVo.Response();
                paramMap.put("location", requestVo.getLat() + "," + requestVo.getLng());
                if (StringUtils.isNotBlank(requestVo.getRadius())) {
                    paramMap.put("radius", requestVo.getRadius());
                }
                paramMap.put("key", SystemConstant.getGAODE_KEY());
                paramMap.put("extensions", "all");
                paramMap.put("output", "json");
                String result = HttpclientUtil.postMSG(paramMap, ConstantUtils.ADDRESS_TO_LOCATION_URL_PREFIX);
                if (StringUtils.isNotBlank(result)) {
                    JSONObject object = JSONObject.fromObject(result);
                    if (object != null && object.size() > 0) {
                        String status = object.getString("status");
                        if ("1".equals(status)) {
                            JSONObject regeocode = object.getJSONObject("regeocode");
                            if (regeocode != null && regeocode.size() > 0) {
                                String formatted_address = regeocode.getString("formatted_address");
                                responseVo.setAddress(formatted_address);
                                responseVo.setStatus(status);
                                resultMap.put("data", responseVo);
                                resultMap.put("msg", "请求数据成功！");
                            }
                        } else {
                            resultMap.put("msg", "请求数据出错,请检查网络！");
                            resultMap.put("status", status);
                        }
                    }
                }
            }
        }
        return GsonUtil.objToStr(resultMap);
    }

    //根据地址查询经纬度
    public String searchLatLngByAddress(String request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, String> paramMap = new HashMap<String, String>();
        AddressToLatLngVo.Request requestVo = null;
        AddressToLatLngVo.Response responseVo = new AddressToLatLngVo.Response();
        if (StringUtils.isNotBlank(request)) {
            requestVo = GsonUtil.strToObj(request, AddressToLatLngVo.Request.class);
            if (StringUtils.isNotBlank(requestVo.getAddress())) {
                paramMap.put("key", SystemConstant.getGAODE_KEY());
                paramMap.put("address", requestVo.getAddress());
                paramMap.put("output", "json");
                String result = HttpclientUtil.postMSG(paramMap, ConstantUtils.GAODE_URL + ConstantUtils.ADDRESS_GEO);
                JSONObject object = JSONObject.fromObject(result);
                if (object != null && object.size() > 0) {
                    String status = object.getString("status");
                    if ("1".equals(status)) {
                        JSONArray geocodes = object.getJSONArray("geocodes");
                        if (geocodes != null && geocodes.size() > 0) {
                            for (int i = 0; i < geocodes.size(); i++) {
                                JSONObject jsonObject = geocodes.getJSONObject(i);
                                String address = jsonObject.getString("formatted_address");
                                String location = jsonObject.getString("location");
                                responseVo.setAddress(address);
                                String[] locations = location.split(",");
                                responseVo.setLat(locations[0]);
                                responseVo.setLng(locations[1]);
                                resultMap.put("data", responseVo);
                                resultMap.put("msg", "数据请求成功！");
                            }
                        }

                    } else {
                        resultMap.put("msg", "请求数据异常，请检查网络连接！");
                        resultMap.put("status", status);
                    }

                }
            } else {
                resultMap.put("msg", "请求参数不能为空！");
                return GsonUtil.objToStr(resultMap);
            }
        }

        return GsonUtil.objToStr(resultMap);
    }

    //车辆路径规划
    public String drivingPlan(String request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, String> paramMap = new HashMap<String, String>();
        DrivingPlanVo.Request requestVo = GsonUtil.strToObj(request, DrivingPlanVo.Request.class);
        List<DrivingPlanVo.Response> responseList = new ArrayList<DrivingPlanVo.Response>();
        if (StringUtils.isNotBlank(requestVo.getOrigin()) && StringUtils.isNotBlank(requestVo.getDestination())) {
            paramMap.put("key", SystemConstant.getGAODE_KEY());
            paramMap.put("origin", requestVo.getOrigin());
            paramMap.put("destination", requestVo.getDestination());
            paramMap.put("extensions", "all");
            paramMap.put("output", "json");
            if (StringUtils.isNotBlank(requestVo.getStrategy())) {
                paramMap.put("strategy", requestVo.getStrategy());
            }
            String result = HttpclientUtil.postMSG(paramMap, ConstantUtils.GAODE_URL + ConstantUtils.ADDRESS_DIRECTION_PLAN);
            if (StringUtils.isNotBlank(result)) {
                JSONObject object = JSONObject.fromObject(result);
                if (object != null && object.size() > 0) {
                    String status = object.getString("status");
                    if ("1".equals(status)) {
                        JSONObject route = object.getJSONObject("route");
                        if (route != null && route.size() > 0) {
                            DrivingPlanVo.Response responseVo = new DrivingPlanVo.Response();
                            String origin = route.getString("origin");
                            String destination = route.getString("destination");
                            responseVo.setDestination(destination);
                            responseVo.setOrigin(origin);
                            JSONArray paths = route.getJSONArray("paths");
                            if (paths != null && paths.size() > 0) {
                                for (int i = 0; i < paths.size(); i++) {
                                    JSONObject jsonObject = paths.getJSONObject(i);
                                    String totalDistance = jsonObject.getString("distance");
                                    String totalDuration = jsonObject.getString("duration");
                                    responseVo.setTotalDistance(totalDistance);
                                    responseVo.setTotalDuration(totalDuration);
                                    JSONArray array = jsonObject.getJSONArray("steps");
                                    if (array != null && array.size() > 0) {
                                        for (int j = 0; j < array.size(); j++) {
                                            JSONObject objectChild = array.getJSONObject(j);
                                            String instruction = objectChild.getString("instruction");
                                            String distance = objectChild.getString("distance");
                                            String duration = objectChild.getString("duration");
                                            String polyline = objectChild.getString("polyline");
                                            String action = objectChild.getString("action");
                                            String assistant_action = objectChild.getString("assistant_action");
                                            responseVo.setInstruction(instruction);
                                            responseVo.setDistance(distance);
                                            responseVo.setDuration(duration);
                                            responseVo.setPolyline(polyline);
                                            responseVo.setAction(action);
                                            responseVo.setAssistant_action(assistant_action);
                                            responseList.add(responseVo);

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                resultMap.put("data", responseList);
                resultMap.put("msg", "true！");
            } else {
                resultMap.put("msg", "请求数据失败,请检查网络连接！");
            }

        } else {
            resultMap.put("msg", "起始点或结束点不能为空");
            return GsonUtil.objToStr(resultMap);
        }

        return GsonUtil.objToStr(resultMap);
    }

    //根据起始点和结束点查询距离
    public String searchDistanceByStartAndEndAddress(String request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(request)) {
            DistanceByStartAndEndAddress.Request requestVo = GsonUtil.strToObj(request, DistanceByStartAndEndAddress.Request.class);
            List<String> origins = requestVo.getOrigins();
            String orignss = "";
            if (origins != null && origins.size() > 0 && StringUtils.isNotBlank(requestVo.getDestination())) {
                Map<String, String> paramMap = new HashMap<String, String>();
                DistanceByStartAndEndAddress.Response responseVo = new DistanceByStartAndEndAddress.Response();
                for (int i = 0; i < origins.size(); i++) {
                    if (i == (origins.size() - 1)) {
                        orignss = orignss + origins.get(i);
                    } else {
                        orignss = orignss + origins.get(i) + "|";
                    }
                }
                paramMap.put("origins", orignss.substring(0, orignss.lastIndexOf("|")));
                paramMap.put("destination", requestVo.getDestination());
                paramMap.put("key", SystemConstant.getGAODE_KEY());
                String str = HttpclientUtil.postMSG(paramMap, ConstantUtils.ADDRESS_DISTANCE_URL_PREFIX);
                if (StringUtils.isNotBlank(str)) {
                    JSONObject object = JSONObject.fromObject(str);
                    String status = object.getString("status");
                    if ("1".equals(status)) {
                        JSONArray array = object.getJSONArray("results");
                        if (array != null && array.size() > 0) {
                            for (int i = 0; i < array.size(); i++) {
                                JSONObject jsonObject = array.getJSONObject(i);
                                String duration = jsonObject.getString("duration");
                                String distance = jsonObject.getString("distance");
                                responseVo.setDistance(distance);
                                responseVo.setDuration(duration);
                                responseVo.setStatus(status);
                            }
                            resultMap.put("data", responseVo);
                        }
                    } else {
                        resultMap.put("msg", "请求失败！");
                    }
                }
            } else {
                resultMap.put("msg", "经纬度不能为空！");
            }
        } else {
            resultMap.put("msg", "经纬度不能为空！");
        }
        return GsonUtil.objToStr(resultMap);
    }

    //根据ip定位
    public String locationByIp(String request) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, String> paramMap = new HashMap<String, String>();

        if (StringUtils.isNotBlank(request)) {
            LocationByIp.Request requestVo = GsonUtil.strToObj(request, LocationByIp.Request.class);
            if (StringUtils.isNotBlank(requestVo.getIp())) {
                LocationByIp.Response responseVo = new LocationByIp.Response();
                paramMap.put("key", SystemConstant.getGAODE_KEY());
                paramMap.put("ip", requestVo.getIp());
                paramMap.put("output", "json");
                String result = HttpclientUtil.postMSG(paramMap, ConstantUtils.GAODE_URL + ConstantUtils.IP_URL);
                if (StringUtils.isNotBlank(result)) {
                    JSONObject object = JSONObject.fromObject(result);
                    String status = object.getString("status");
                    if ("1".equals(status)) {
                        String province = object.getString("province");
                        String city = object.getString("city");
                        String adcode = object.getString("adcode");
                        String rectangle = object.getString("rectangle");
                        responseVo.setAdcode(adcode);
                        responseVo.setProvince(province);
                        responseVo.setCity(city);
                        responseVo.setRectangle(rectangle);
                    }
                    resultMap.put("data", responseVo);
                    resultMap.put("msg", "请求数据成功！");
                }
            } else {
                resultMap.put("msg", "查询参数ip不能为空！");
            }
        } else {
            resultMap.put("msg", "请求参数不能为空！");
        }
        return GsonUtil.objToStr(resultMap);
    }

    //
    public String searchLatLngByAddressBatch(String request){
        Map<String,Object> resultMap = new HashMap<String, Object>() ;
        List<AddressInfoVo> errorAddress = new ArrayList<AddressInfoVo>() ;
        List<AddressInfoVo> listAddressVo = new ArrayList<AddressInfoVo>() ;
        if (StringUtils.isNotBlank(request)){
            AddressToLatLngBatchVo.Request requestVo = GsonUtil.strToObj(request,AddressToLatLngBatchVo.Request.class) ;
            List<String> requestList = requestVo.getList() ;
            String url = ConstantUtils.ADDRESS_BATCH_URL_PREFIX+"?key="+ SystemConstant.getGAODE_KEY() ;
            JSONObject json = new JSONObject() ;
            if (requestList!=null&&requestList.size()>0){
                JSONArray jsonArray = new JSONArray() ;
                for (String reqStr:requestList){
                    JSONObject addressCapa = new JSONObject() ;
                    addressCapa.put("url",ConstantUtils.ADDRESS_GEO+"?address="+reqStr+"&output=json&key="+SystemConstant.getGAODE_KEY()) ;
                    jsonArray.add(addressCapa) ;
                }
                json.put("ops",jsonArray.toString()) ;
                if (!json.isEmpty()){
                    String result = HttpclientUtil.postJson(url,json.toString()) ;
                    JSONArray arrayResult = JSONArray.fromObject(result) ;
                    if (arrayResult!=null&&arrayResult.size()>0){
                        for (int i=0;i<arrayResult.size();i++){
                            JSONObject resultJson = arrayResult.getJSONObject(i) ;
                            AddressInfoVo addressVoBean = new AddressInfoVo() ;
                            //addressVoBean.setDetail(addressInfoCapas.get(i).getDetail());
                            //addressVoBean.setAddId(addressInfoCapas.get(i).getAddId());
                            //addressVoBean.setType(addressInfoCapas.get(i).getType());
                            try{
                                int status = resultJson.getInt("status") ;
                                if (status==200){
                                    JSONObject resultBody = resultJson.getJSONObject("body") ;
                                    if (resultBody!=null&&resultBody.containsKey("geocodes")){
                                        if (resultBody.get("geocodes") instanceof String){
                                            errorAddress.add(addressVoBean) ;
                                        }else{
                                            JSONArray jsonArrays = resultBody.getJSONArray("geocodes") ;
                                            JSONObject geocode = (JSONObject) jsonArrays.get(0) ;
                                            String location = geocode.getString("location") ;
                                            String address = geocode.getString("formatted_address") ;
                                            String province = geocode.getString("province") ;
                                            String city = geocode.getString("city") ;
                                            String district = geocode.getString("district") ;
                                            String [] locations = location.split(",") ;
                                            addressVoBean.setLat(locations[1]);
                                            addressVoBean.setLng(locations[0]);
                                            addressVoBean.setProvince(province);
                                            addressVoBean.setCity(city);
                                            addressVoBean.setDistrict(district);
                                            addressVoBean.setAddress(address);
                                            String level = geocode.getString("level") ;
                                            if (level.contains("乡镇")||level.contains("村庄")||level.contains("热点商圈")||level.contains("兴趣点")||level.contains("门牌号")||level.contains("单元号")||level.contains("道路")) {
                                                addressVoBean.setDelete(false);
                                            }else{
                                                addressVoBean.setDelete(true);
                                            }

                                        }
                                        listAddressVo.add(addressVoBean) ;

                                    }
                                }
                            }catch (Exception e){
                                errorAddress.add(addressVoBean) ;
                            }
                        }
                    }
                }
            }

        }
        resultMap.put("listAddressVo",listAddressVo) ;
        resultMap.put("errorList",errorAddress) ;
        return GsonUtil.objToStr(resultMap) ;
    }

    public String searchAddressByLatLngBatch(String request){
        Map<String,Object> resultMap = new HashMap<String, Object>() ;
        List<AddressInfoVo> errorAddress = new ArrayList<AddressInfoVo>() ;
        List<AddressInfoVo> listAddressVo = new ArrayList<AddressInfoVo>() ;
        if (StringUtils.isNotBlank(request)){
            AddressToLatLngBatchVo.Request requestVo = GsonUtil.strToObj(request,AddressToLatLngBatchVo.Request.class) ;
            List<String> requestList = requestVo.getList() ;
            String url = ConstantUtils.ADDRESS_BATCH_URL_PREFIX+"?key="+ SystemConstant.getGAODE_KEY() ;
            JSONObject json = new JSONObject() ;
            if (requestList!=null&&requestList.size()>0){
                JSONArray jsonArray = new JSONArray() ;
                for (String reqStr:requestList){
                    JSONObject addressCapa = new JSONObject() ;
                    addressCapa.put("url",ConstantUtils.ADDRESS_REGEO+"?address="+reqStr+"&output=json&key="+SystemConstant.getGAODE_KEY()) ;
                    jsonArray.add(addressCapa) ;
                }
                json.put("ops",jsonArray.toString()) ;
                if (!json.isEmpty()){
                    String result = HttpclientUtil.postJson(url,json.toString()) ;
                    JSONArray arrayResult = JSONArray.fromObject(result) ;
                    if (arrayResult!=null&&arrayResult.size()>0){
                        for (int i=0;i<arrayResult.size();i++){
                            JSONObject resultJson = arrayResult.getJSONObject(i) ;
                            AddressInfoVo addressVoBean = new AddressInfoVo() ;
                            //addressVoBean.setDetail(addressInfoCapas.get(i).getDetail());
                            //addressVoBean.setAddId(addressInfoCapas.get(i).getAddId());
                            //addressVoBean.setType(addressInfoCapas.get(i).getType());
                            try{
                                int status = resultJson.getInt("status") ;
                                if (status==200){
                                    JSONObject resultBody = resultJson.getJSONObject("body") ;
                                    if (resultBody!=null&&resultBody.containsKey("geocodes")){
                                        if (resultBody.get("geocodes") instanceof String){
                                            errorAddress.add(addressVoBean) ;
                                        }else{
                                            JSONArray jsonArrays = resultBody.getJSONArray("geocodes") ;
                                            JSONObject geocode = (JSONObject) jsonArrays.get(0) ;
                                            String location = geocode.getString("location") ;
                                            String address = geocode.getString("formatted_address") ;
                                            String province = geocode.getString("province") ;
                                            String city = geocode.getString("city") ;
                                            String district = geocode.getString("district") ;
                                            String [] locations = location.split(",") ;
                                            addressVoBean.setLat(locations[1]);
                                            addressVoBean.setLng(locations[0]);
                                            addressVoBean.setProvince(province);
                                            addressVoBean.setCity(city);
                                            addressVoBean.setDistrict(district);
                                            addressVoBean.setAddress(address);
                                        }
                                        listAddressVo.add(addressVoBean) ;

                                    }
                                }
                            }catch (Exception e){
                                errorAddress.add(addressVoBean) ;
                            }
                        }
                    }
                }
            }

        }
        resultMap.put("listAddressVo",listAddressVo) ;
        resultMap.put("errorList",errorAddress) ;
        return GsonUtil.objToStr(resultMap) ;
    }








}
