package org.gisoper.com.vo;

import java.io.Serializable;

public class QuaryFenceVo implements Serializable {
    public static class Request {
        private String id;
        private String gid;
        private String name;
        private String page_no;
        private String page_size;
        private String enable;
        private String start_time;
        private String end_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPage_no() {
            return page_no;
        }

        public void setPage_no(String page_no) {
            this.page_no = page_no;
        }

        public String getPage_size() {
            return page_size;
        }

        public void setPage_size(String page_size) {
            this.page_size = page_size;
        }

        public String getEnable() {
            return enable;
        }

        public void setEnable(String enable) {
            this.enable = enable;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }
    }

    public static class Response {
        private String page_no;
        //当前页码
        private String page_size;
        // 每页记录数
        private String adcode;
        //围栏所在地区adcode
        private String alert_condition;
        //围栏监控触发条件
        private String center;
        //圆形围栏中心点
        private String create_time;
        //围栏创建时间
        private String enable;
        //围栏激活状态
        private String fixed_date;
        //指定日期
        private String gid;
        //围栏全局id
        private String id;
        //围栏id
        private String name;
        //围栏名称
        private String points;
        //多边形围栏点
        private String radius;
        //圆形围栏半径
        private String repeat;
        //一周内围栏监控的重复星期
        private String time;
        //一天内监控的具体时段
        private String valid_time;
        //过期日期
        private String total_record;
        //总记录数
        private String errcode;
        //错误码
        private String errmsg;
        private String redius;

        public String getPage_no() {
            return page_no;
        }

        public void setPage_no(String page_no) {
            this.page_no = page_no;
        }

        public String getPage_size() {
            return page_size;
        }

        public void setPage_size(String page_size) {
            this.page_size = page_size;
        }

        public String getAdcode() {
            return adcode;
        }

        public void setAdcode(String adcode) {
            this.adcode = adcode;
        }

        public String getAlert_condition() {
            return alert_condition;
        }

        public void setAlert_condition(String alert_condition) {
            this.alert_condition = alert_condition;
        }

        public String getCenter() {
            return center;
        }

        public void setCenter(String center) {
            this.center = center;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getEnable() {
            return enable;
        }

        public void setEnable(String enable) {
            this.enable = enable;
        }

        public String getFixed_date() {
            return fixed_date;
        }

        public void setFixed_date(String fixed_date) {
            this.fixed_date = fixed_date;
        }

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }

        public String getRadius() {
            return radius;
        }

        public void setRadius(String radius) {
            this.radius = radius;
        }

        public String getRepeat() {
            return repeat;
        }

        public void setRepeat(String repeat) {
            this.repeat = repeat;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getValid_time() {
            return valid_time;
        }

        public void setValid_time(String valid_time) {
            this.valid_time = valid_time;
        }

        public String getTotal_record() {
            return total_record;
        }

        public void setTotal_record(String total_record) {
            this.total_record = total_record;
        }

        public String getErrcode() {
            return errcode;
        }

        public void setErrcode(String errcode) {
            this.errcode = errcode;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        public String getRedius() {
            return redius;
        }

        public void setRedius(String redius) {
            this.redius = redius;
        }
    }
}
