package org.gisoper.com.service;

import org.apache.commons.lang.StringUtils;
import org.common.com.utils.MapDistance;
import org.gisoper.com.vo.LoadBillVo;
import org.gisoper.com.vo.VehiclePosition;
import org.gisoper.com.vo.WebsitePointVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FenceService {

    private static Logger logger = LoggerFactory.getLogger(FenceService.class) ;

    public void triggerFence(){

        List<VehiclePosition> positionList = getVehiclePhsition() ;
        List<LoadBillVo> loadBillVoList = getLoadBill(positionList) ;
        List<WebsitePointVo> websitePointVoList = getWebsiteList() ;
        for (LoadBillVo loadBillVo:loadBillVoList){
            try{
                String vehicleNo = loadBillVo.getVehicleNo() ;
                String status = loadBillVo.getStatus() ;
                String loadId = loadBillVo.getLoadingId() ;
                List<VehiclePosition> listVehicleOnly = getVehicleByNo(positionList,vehicleNo) ;
                if (status.equals("12")){//触发发车
                    String departurePointId = loadBillVo.getDeparturePointId() ;
                    WebsitePointVo pointVo = getWebsitePoint(websitePointVoList,departurePointId) ;
                    Map<String,Object> map = istrigger(listVehicleOnly,pointVo,1) ;
                    boolean isTrigger = (Boolean) map.get("isTrigger") ;
                    String triggerTime = (String) map.get("triggerTime") ;
                    String vehiclePhone = (String) map.get("vehiclePhone") ;
                    String vehicleNum = (String) map.get("vehicleNum") ;
                    if (isTrigger){
                        //保存到数据库
                        Map<String,String> mapTrigger = new HashMap<String, String>() ;
                        mapTrigger = sendFence(loadId,departurePointId,triggerTime) ;
                        saveDBLog(mapTrigger,1,vehicleNum,vehiclePhone) ;//保存到数据库
                    }
                }else if (status.equals("13")){//触发签到
                    List<String> list_point = loadBillVo.getArrivePointId() ;
                    if (list_point!=null&&list_point.size()>0){
                        for (String arrivePointId:list_point){
                            WebsitePointVo websitePointVo = getWebsitePoint(websitePointVoList,arrivePointId) ;
                            Map<String,Object> map = istrigger(listVehicleOnly,websitePointVo,2) ;
                            boolean isTrigger = (Boolean) map.get("isTrigger") ;
                            String triggerTime = (String) map.get("triggerTime") ;
                            String vehiclePhone = (String) map.get("vehiclePhone") ;
                            String vehicleNum = (String) map.get("vehicleNum") ;
                            if (isTrigger){
                                //保存到数据库
                                Map<String,String> mapTrigger = new HashMap<String, String>() ;
                                mapTrigger = fenceSign(loadId,arrivePointId,triggerTime) ;
                                saveDBLog(mapTrigger,2,vehicleNum,vehiclePhone);
                            }
                        }
                    }
                }
            }catch (Exception e){
                continue;
            }

        }

    }
    public List<VehiclePosition> getVehiclePhsition(){
        List<VehiclePosition> list = new ArrayList<VehiclePosition>() ;

        return list ;
    }
    public List<LoadBillVo> getLoadBill(List<VehiclePosition> listposition){
        List<LoadBillVo> list = new ArrayList<LoadBillVo>() ;

        return list ;
    }
    public List<WebsitePointVo> getWebsiteList(){
        List<WebsitePointVo> list = new ArrayList<WebsitePointVo>() ;

        return list ;
    }
    private List<VehiclePosition> getVehicleByNo(List<VehiclePosition> list,String vehicleNo){
        List<VehiclePosition> temp = new ArrayList<VehiclePosition>() ;
        for (VehiclePosition vehiclePosition:list){
            if (vehicleNo.equals(vehiclePosition.getVehiclenum())){
                temp.add(vehiclePosition) ;
            }
        }
        Collections.sort(temp, new Comparator<VehiclePosition>() {
            @Override
            public int compare(VehiclePosition o1, VehiclePosition o2) {

                return 0;
            }
        });

        return temp ;
    }

    private WebsitePointVo getWebsitePoint(List<WebsitePointVo> list,String id){

        for (WebsitePointVo websitePointVo:list){
            if (id.endsWith(websitePointVo.getId())){
                return websitePointVo ;
            }
        }
        return null ;
    }
    public Map<String,Object> istrigger(List<VehiclePosition> list, WebsitePointVo pointVo, int type){
        Map<String,Object> map = new HashMap<String, Object>() ;
        boolean isTrigger= false ;
        String triggerTime ="" ;
        String vehicleNum = "" ;
        String vehiclePhone = "" ;
        map.put("isTrigger",isTrigger) ;
        map.put("triggerTime",triggerTime) ;
        if (pointVo==null){
            return map ;
        }

        String lat1 = pointVo.getLat() ;
        String lng1 = pointVo.getLng() ;
        String lat2 = pointVo.getLat2() ;
        String lng2 = pointVo.getLng2() ;

        boolean flag1 = false ;
        boolean flag2 = false ;
        String lat1Str = "" ;
        String lng1Str = "" ;

        if (StringUtils.isNotBlank(lat1)&&StringUtils.isNotBlank(lng1)&&lat1!="0"&&lng1!="0"){
            flag1 = true ;
        }
        if (StringUtils.isNotBlank(lat2)&&StringUtils.isNotBlank(lng2)&&lat2!="0"&&lat2!="0"){
            flag2 = true ;
        }
        if (flag1==false&&flag2==false){
            return map ;
        }

        if (flag2){
            lat1Str = lat2 ;
            lng1Str = lng2 ;
        }else{
            lat1Str = lat1 ;
            lng1Str = lng1 ;
        }
        double radius = 1 ;//触发区域半径1 km
        if (pointVo.getWebsiteType()==14){//枢纽类型
            radius = 2 ;
        }
        if (type==1||type==2){
            for (VehiclePosition vehiclePosition:list){
                String lat2Str = vehiclePosition.getVahiclelat() ;
                String lng2Str = vehiclePosition.getVahiclelng() ;
                double distance = MapDistance.GetDistance(lng1Str,lat1Str,lat2Str,lng2Str) ;
                if (type==1){//发车
                    if (distance>=radius){
                        isTrigger=true ;
                        triggerTime = vehiclePosition.getVahicletime() ;
                        vehiclePhone = vehiclePosition.getVehiclephone() ;
                        vehicleNum = vehiclePosition.getVehiclenum() ;
                        break;
                    }
                }else if (type==2){
                    if (distance<=radius){
                        isTrigger = true ;
                        triggerTime = vehiclePosition.getVahicletime() ;
                        vehiclePhone = vehiclePosition.getVehiclephone() ;
                        vehicleNum = vehiclePosition.getVehiclenum() ;
                        break;
                    }
                }
            }

        }else {
            return map ;
        }

        logger.info("是否触发：{}",isTrigger);
        map.put("isTrigger",isTrigger) ;
        map.put("triggerTime",triggerTime) ;
        map.put("vehiclePhone",vehiclePhone) ;
        map.put("vehicleNum",vehicleNum) ;

        return map ;
    }
    public Map<String,String> sendFence(String loadId,String departurePointId,String triggerTime){
        Map<String,String> map = new HashMap<String, String>() ;

        return map ;
    }
    public void saveDBLog(Map<String,String> map,int type,String vehicleNum,String vehicelPhone){

    }
    public Map<String,String> fenceSign(String loadId,String arrivePonitId,String triggerTime){
        Map<String,String> map = new HashMap<String, String>() ;

        return map ;
    }


}
