package org.common.com.utils;

import java.util.HashMap;

public class ResponseHeader {

    private String serviceCode ;
    private String reqSysCode ;
    private String returnMessage ;
    private int returnCode ;
    private String serialNumber ;
    private HashMap<String,Object> exceptionInfo ;
    private HashMap<String,Object> properties ;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getReqSysCode() {
        return reqSysCode;
    }

    public void setReqSysCode(String reqSysCode) {
        this.reqSysCode = reqSysCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public HashMap<String, Object> getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(HashMap<String, Object> exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }
}
