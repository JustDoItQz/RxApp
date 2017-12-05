package org.gisoper.com.vo;

import java.io.Serializable;
import java.util.List;

public class DistanceByStartAndEndAddress implements Serializable {
    public static class Request{
        private List<String> origins ;
        private String destination ;

        public List<String> getOrigins() {
            return origins;
        }

        public void setOrigins(List<String> origins) {
            this.origins = origins;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }
    }
    public static class Response{

        private String distance ;
        private String duration ;
        private String status ;

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
