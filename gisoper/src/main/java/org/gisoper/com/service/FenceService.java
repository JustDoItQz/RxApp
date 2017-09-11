package org.gisoper.com.service;

import org.gisoper.com.vo.LoadBillVo;
import org.gisoper.com.vo.VehiclePosition;
import org.gisoper.com.vo.WebsitePointVo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FenceService {

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
                }else if (status.equals("13")){//触发签到

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

        return map ;
    }


}
