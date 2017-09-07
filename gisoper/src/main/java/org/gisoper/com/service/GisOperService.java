package org.gisoper.com.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.common.com.constant.ConstantUtils;
import org.common.com.constant.SystemConstant;
import org.common.com.utils.HttpclientUtil;
import org.gisoper.com.vo.AddressInfoCapaVo;
import org.gisoper.com.vo.AddressInfoVo;
import org.gisoper.com.vo.BeanDistanceVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GisOperService {

    public Map<String,List<AddressInfoVo>> addressInfoBatch(List<AddressInfoCapaVo> addressInfoCapas){
        Map<String,List<AddressInfoVo>> map = new HashMap<String, List<AddressInfoVo>>() ;
        List<AddressInfoVo> errorAddress = new ArrayList<AddressInfoVo>() ;
        List<AddressInfoVo> listAddressVo = new ArrayList<AddressInfoVo>() ;
        JSONObject json = new JSONObject() ;
        //拼装高德访问格式
        String url = ConstantUtils.ADDRESS_BATCH_URL_PREFIX+"?key="+ SystemConstant.getGAODE_KEY() ;
        if (addressInfoCapas!=null&&addressInfoCapas.size()>0){
            JSONArray jsonArray = new JSONArray() ;
            for (AddressInfoCapaVo addressInfoCapaVo:addressInfoCapas){
                JSONObject addressCapa = new JSONObject() ;
                addressCapa.put("url",ConstantUtils.ADDRESS_GEO+"?address="+addressInfoCapaVo.getDetail()+"&output=json&key="+SystemConstant.getGAODE_KEY()) ;
                jsonArray.add(addressCapa) ;
            }
            json.put("ops",jsonArray) ;
        }

        if (!json.isEmpty()){
            String result = HttpclientUtil.postJson(url,json.toString()) ;
            JSONArray arrayResult = JSONArray.fromObject(result) ;
            if (arrayResult!=null&&arrayResult.size()>0){
                for (int i=0;i<arrayResult.size();i++){
                    JSONObject resultJson = arrayResult.getJSONObject(i) ;
                    AddressInfoVo addressVoBean = new AddressInfoVo() ;
                    addressVoBean.setDetail(addressInfoCapas.get(i).getDetail());
                    addressVoBean.setAddId(addressInfoCapas.get(i).getAddId());
                    addressVoBean.setType(addressInfoCapas.get(i).getType());
                    try{
                        int status = resultJson.getInt("status") ;
                        if (status==200){
                            JSONObject resultBody = resultJson.getJSONObject("body") ;
                            if (resultBody!=null&&resultBody.containsKey("geocodes")){
                                if (resultBody.get("geocodes") instanceof String){
                                    errorAddress.add(addressVoBean) ;
                                }else{
                                    JSONArray jsonArray = resultBody.getJSONArray("geocodes") ;
                                    JSONObject geocode = (JSONObject) jsonArray.get(0) ;
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
        map.put("listAddressVo",listAddressVo) ;
        map.put("errorList",errorAddress) ;
        return map ;
    }
    public List<BeanDistanceVo> searchDistance(List<AddressInfoVo> origins,AddressInfoVo destination){

        List<BeanDistanceVo> beanDistanceVos = new ArrayList<BeanDistanceVo>() ;
        Map<String,String> params = new HashMap<String, String>() ;
        params.put("key",SystemConstant.getGAODE_KEY());
        String origin = "" ;
        params.put("destination",destination.getLocation()) ;
        params.put("type","1") ;
        params.put("output","json") ;
        if (origins!=null&&origins.size()>0){
            for (int i=0;i<origins.size();i++){
                if (i==(origins.size()-1)){
                    origin+=origins.get(i).getLocation() ;
                }else{
                    origin+=origins.get(i).getLocation()+"|" ;
                }
            }
        }
        params.put("origins",origin) ;
        String result = HttpclientUtil.postMSG(params,ConstantUtils.ADDRESS_DISTANCE_URL_PREFIX) ;
        JSONObject object = JSONObject.fromObject(result) ;
        if (object.getString("status").equals("1")&&object.getString("info").equals("OK")){
            JSONArray jsonArray = object.getJSONArray("results") ;
            for (int i=0;i<jsonArray.size();i++){
                JSONObject pathObject = jsonArray.getJSONObject(i) ;
                BeanDistanceVo beanDistanceVo = new BeanDistanceVo() ;
                beanDistanceVo.setDestId(pathObject.getString("dest_id"));
                beanDistanceVo.setOriginId(pathObject.getString("origin_id"));
                beanDistanceVo.setDistance(pathObject.getString("distance"));
                beanDistanceVo.setDuration(pathObject.getString("duration"));
                beanDistanceVos.add(beanDistanceVo) ;
            }
        }
        return beanDistanceVos ;
    }

}
