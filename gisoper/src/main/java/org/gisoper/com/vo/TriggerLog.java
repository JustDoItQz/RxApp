package org.gisoper.com.vo;

import java.util.Date;

public class TriggerLog {
    private int id ;//uuid
    private Date triggerTime ;//触发时间
    private int triggerType ;//1、发车 2、签到
    private String loadingId ;
    private String routeId ;
    private int triggerStatus ;//1、触发成功 2、触发失败 3、已触发
    private int times ;//触发次数
    private Date lasteTime ;
    private String vehicleNum ;
    private String vehiclePhone ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }

    public int getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(int triggerType) {
        this.triggerType = triggerType;
    }

    public String getLoadingId() {
        return loadingId;
    }

    public void setLoadingId(String loadingId) {
        this.loadingId = loadingId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public int getTriggerStatus() {
        return triggerStatus;
    }

    public void setTriggerStatus(int triggerStatus) {
        this.triggerStatus = triggerStatus;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Date getLasteTime() {
        return lasteTime;
    }

    public void setLasteTime(Date lasteTime) {
        this.lasteTime = lasteTime;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getVehiclePhone() {
        return vehiclePhone;
    }

    public void setVehiclePhone(String vehiclePhone) {
        this.vehiclePhone = vehiclePhone;
    }
}
