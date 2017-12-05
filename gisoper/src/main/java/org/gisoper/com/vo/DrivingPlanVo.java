package org.gisoper.com.vo;

import java.io.Serializable;

public class DrivingPlanVo implements Serializable {
    public static class Request{
        private String origin ;
        private String destination ;
        private String strategy ;


        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getStrategy() {
            return strategy;
        }

        public void setStrategy(String strategy) {
            this.strategy = strategy;
        }
    }
    public static class Response{

        private String instruction ;
        private String distance ;
        private String duration ;
        private String action ;
        private String assistant_action ;
        private String traffic_lights ;
        //0 代表限行已规避或未限行，即该路线没有限行路段代表限行无法规避，1、即该线路有限行路段
        private String restriction ;
        private String origin ;
        private String destination ;
        private String totalDistance ;
        private String totalDuration ;
        private String polyline ;

        public String getInstruction() {
            return instruction;
        }

        public void setInstruction(String instruction) {
            this.instruction = instruction;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getPolyline() {
            return polyline;
        }

        public void setPolyline(String polyline) {
            this.polyline = polyline;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getAssistant_action() {
            return assistant_action;
        }

        public void setAssistant_action(String assistant_action) {
            this.assistant_action = assistant_action;
        }

        public String getTraffic_lights() {
            return traffic_lights;
        }

        public void setTraffic_lights(String traffic_lights) {
            this.traffic_lights = traffic_lights;
        }

        public String getRestriction() {
            return restriction;
        }

        public void setRestriction(String restriction) {
            this.restriction = restriction;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getTotalDistance() {
            return totalDistance;
        }

        public void setTotalDistance(String totalDistance) {
            this.totalDistance = totalDistance;
        }

        public String getTotalDuration() {
            return totalDuration;
        }

        public void setTotalDuration(String totalDuration) {
            this.totalDuration = totalDuration;
        }

    }
}
