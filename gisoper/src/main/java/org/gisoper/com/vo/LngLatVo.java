package org.gisoper.com.vo;

import java.util.List;

public class LngLatVo {

    public static class Request{
        private String lng ;
        private String lat ;

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }
    }
    public static class ListRequest{
        private List<String> list ;

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }

    public static class ListResponse{
        private String address ;
        private String country;
        private String city ;
        private String township ;
        private String district ;
        private String province ;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getTownship() {
            return township;
        }

        public void setTownship(String township) {
            this.township = township;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }
    }
    public static class ListAddress{

        private List<AddressInfoCapaVo> list ;

        public List<AddressInfoCapaVo> getList() {
            return list;
        }

        public void setList(List<AddressInfoCapaVo> list) {
            this.list = list;
        }
    }
    public static class Response{

    }
}
