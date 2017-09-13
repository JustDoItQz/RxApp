package org.gisoper.com.vo;

import java.io.Serializable;

public class RegisterPartnerBeanVo implements Serializable {

    private String msid ;
    private String driverName ;
    private String idcard ;
    private String carNo ;
    private String carType ;
    private String carLength ;
    private String carTonnage ;
    private String carWidth ;
    private String carHeight ;
    private String direction ;
    private String createId ;
    private String updateId ;

    public String getMsid() {
        return msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarLength() {
        return carLength;
    }

    public void setCarLength(String carLength) {
        this.carLength = carLength;
    }

    public String getCarTonnage() {
        return carTonnage;
    }

    public void setCarTonnage(String carTonnage) {
        this.carTonnage = carTonnage;
    }

    public String getCarWidth() {
        return carWidth;
    }

    public void setCarWidth(String carWidth) {
        this.carWidth = carWidth;
    }

    public String getCarHeight() {
        return carHeight;
    }

    public void setCarHeight(String carHeight) {
        this.carHeight = carHeight;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }
}
