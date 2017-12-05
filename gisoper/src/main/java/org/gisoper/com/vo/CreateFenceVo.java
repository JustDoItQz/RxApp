package org.gisoper.com.vo;

import java.io.Serializable;

public class CreateFenceVo implements Serializable {

    public static class Request{
        private String name ;
        private String center ;
        private String radius ;
        private String enable ;
        private String valid_time  ;
        private String repeat ;
        private String desc ;
        //触发动作分号分割 enter;leave（进入、离开触发）
        private String alert_condition ;
        private String fixed_date  ;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCenter() {
            return center;
        }

        public void setCenter(String center) {
            this.center = center;
        }

        public String getRadius() {
            return radius;
        }

        public void setRadius(String radius) {
            this.radius = radius;
        }

        public String getEnable() {
            return enable;
        }

        public void setEnable(String enable) {
            this.enable = enable;
        }

        public String getValid_time() {
            return valid_time;
        }

        public void setValid_time(String valid_time) {
            this.valid_time = valid_time;
        }

        public String getRepeat() {
            return repeat;
        }

        public void setRepeat(String repeat) {
            this.repeat = repeat;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getAlert_condition() {
            return alert_condition;
        }

        public void setAlert_condition(String alert_condition) {
            this.alert_condition = alert_condition;
        }

        public String getFixed_date() {
            return fixed_date;
        }

        public void setFixed_date(String fixed_date) {
            this.fixed_date = fixed_date;
        }
    }
    public static class Response{

        private String gid ;
        private String id ;
        private String message ;

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
