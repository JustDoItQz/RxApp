package org.gisoper.com.vo;

import java.io.Serializable;
import java.util.List;

public class AddressToLatLngBatchVo implements Serializable {
    public static class Request{
        private List<String> list ;

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
    public static class Response{
        private List<String> resultList ;

        public List<String> getResultList() {
            return resultList;
        }

        public void setResultList(List<String> resultList) {
            this.resultList = resultList;
        }
    }
}
