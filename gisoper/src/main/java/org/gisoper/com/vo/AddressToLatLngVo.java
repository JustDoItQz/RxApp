package org.gisoper.com.vo;

import java.io.Serializable;

public class AddressToLatLngVo implements Serializable {
    public static class Request{
        private String address ;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
    public static class Response{
        private String lat ;
        private String lng ;
        private String address ;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
