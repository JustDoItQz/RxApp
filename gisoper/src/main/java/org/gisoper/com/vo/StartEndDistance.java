package org.gisoper.com.vo;

public class StartEndDistance {

    public static class Request{
        private String origin ;
        private String destination ;

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
    }
}
