package org.gisoper.com.vo;

import java.io.Serializable;
import java.util.Date;

public class TVehicleRecords implements Serializable {
    private Integer vehicleRecordId ;
    private String vehicleNum ;
    private Byte recordStatus ;
    private String sourceSys ;
    private Date createTiime ;
    private Date latestTime ;
    private String vehiclePhone ;
    private String createTimeStr ;
    private String curmonth ;
    private Byte recordType ;
    private int page ;
    private int pageSize ;

    public Integer getVehicleRecordId() {
        return vehicleRecordId;
    }

    public void setVehicleRecordId(Integer vehicleRecordId) {
        this.vehicleRecordId = vehicleRecordId;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getSourceSys() {
        return sourceSys;
    }

    public void setSourceSys(String sourceSys) {
        this.sourceSys = sourceSys;
    }

    public Date getCreateTiime() {
        return createTiime;
    }

    public void setCreateTiime(Date createTiime) {
        this.createTiime = createTiime;
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }

    public String getVehiclePhone() {
        return vehiclePhone;
    }

    public void setVehiclePhone(String vehiclePhone) {
        this.vehiclePhone = vehiclePhone;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getCurmonth() {
        return curmonth;
    }

    public void setCurmonth(String curmonth) {
        this.curmonth = curmonth;
    }

    public Byte getRecordType() {
        return recordType;
    }

    public void setRecordType(Byte recordType) {
        this.recordType = recordType;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
