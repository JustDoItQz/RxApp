package org.es.com.spacesearch;

public interface SpaceSearch {

    String searchKeyword(String keyword,String dataset,int page,int pagesize) throws Exception ;
    String searchKeyword(String keyword,String dataset,String sortField,int page,int pagesize) throws Exception ;
    String searchKeyword(String keyword,String dataset,String sortField,String startTime,String endTime,int page,int pagesize) throws Exception ;
    String searchKeywordByFirst(String keyword,String dataset) throws Exception ;
    String vehicleLastLocation(String[] vehicleNums,String dataset) throws Exception ;
    String searchKeyword(String keyword, String dataset, String sortField) throws Exception ;
    String searchKeyword(String keyword, String dataset) throws Exception  ;
    String searchGeometryNearBy(double lon, double lat, String distance, String keyword, String dataset, String pageNo, String pageSize) throws Exception ;

}
