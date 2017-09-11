package org.gisoper.com.vo;

import java.util.List;

public class LoadBillVo {
    private String loadingId ;
    private String loadingNo ;
    private String status ;
    private String statusDesc ;
    private String vehicleNo ;
    private String driverPhone ;
    private String departurePointId ;
    private List<String> arrivePointId ;

    public String getLoadingId() {
        return loadingId;
    }

    public void setLoadingId(String loadingId) {
        this.loadingId = loadingId;
    }

    public String getLoadingNo() {
        return loadingNo;
    }

    public void setLoadingNo(String loadingNo) {
        this.loadingNo = loadingNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDeparturePointId() {
        return departurePointId;
    }

    public void setDeparturePointId(String departurePointId) {
        this.departurePointId = departurePointId;
    }

    public List<String> getArrivePointId() {
        return arrivePointId;
    }

    public void setArrivePointId(List<String> arrivePointId) {
        this.arrivePointId = arrivePointId;
    }
}
