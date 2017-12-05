package org.gisoper.com.vo;

import java.io.Serializable;

public class LocationByIp implements Serializable {
    public static class Request{
        private String ip ;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }
    public static class Response{
        private String province ;
        private String city ;
        private String adcode ;
        private String rectangle ;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAdcode() {
            return adcode;
        }

        public void setAdcode(String adcode) {
            this.adcode = adcode;
        }

        public String getRectangle() {
            return rectangle;
        }

        public void setRectangle(String rectangle) {
            this.rectangle = rectangle;
        }
    }
}
