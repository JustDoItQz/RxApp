package org.gisoper.com.vo;

import java.io.Serializable;
import java.util.List;

public class RouteDriverVo implements Serializable {

    public static class Request{

        private AddressInfoCapaVo startAddress ;
        private AddressInfoCapaVo endAddress ;
        private List<AddressInfoCapaVo> wayPointsAddress ;
        private String cityName ;

        public AddressInfoCapaVo getStartAddress() {
            return startAddress;
        }

        public void setStartAddress(AddressInfoCapaVo startAddress) {
            this.startAddress = startAddress;
        }

        public AddressInfoCapaVo getEndAddress() {
            return endAddress;
        }

        public void setEndAddress(AddressInfoCapaVo endAddress) {
            this.endAddress = endAddress;
        }

        public List<AddressInfoCapaVo> getWayPointsAddress() {
            return wayPointsAddress;
        }

        public void setWayPointsAddress(List<AddressInfoCapaVo> wayPointsAddress) {
            this.wayPointsAddress = wayPointsAddress;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }
    }
    public static class Response{
        private String gisId ;
        private long distance ;
        private long duration ;
        private AddressInfoVo startAddress ;
        private AddressInfoVo endAddress ;
        private List<AddressInfoVo> waypointsAddress ;
        private List<String> errorAddressList ;
        private String errorMessage ;

        public String getGisId() {
            return gisId;
        }

        public void setGisId(String gisId) {
            this.gisId = gisId;
        }

        public long getDistance() {
            return distance;
        }

        public void setDistance(long distance) {
            this.distance = distance;
        }

        public long getDuration() {
            return duration;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }

        public AddressInfoVo getStartAddress() {
            return startAddress;
        }

        public void setStartAddress(AddressInfoVo startAddress) {
            this.startAddress = startAddress;
        }

        public AddressInfoVo getEndAddress() {
            return endAddress;
        }

        public void setEndAddress(AddressInfoVo endAddress) {
            this.endAddress = endAddress;
        }

        public List<AddressInfoVo> getWaypointsAddress() {
            return waypointsAddress;
        }

        public void setWaypointsAddress(List<AddressInfoVo> waypointsAddress) {
            this.waypointsAddress = waypointsAddress;
        }

        public List<String> getErrorAddressList() {
            return errorAddressList;
        }

        public void setErrorAddressList(List<String> errorAddressList) {
            this.errorAddressList = errorAddressList;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
