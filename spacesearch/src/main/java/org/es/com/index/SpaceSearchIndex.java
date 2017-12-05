package org.es.com.index;

import java.util.Date;

public interface SpaceSearchIndex {
    void deleteDataStr(String dataset,String fromDate,String toDate) throws Exception;
    void createIndex(String fieldIndex,String dataSet) throws Exception ;
    void importData(String dataset, String id, Object[] header, Object[] values) throws Exception ;
    void importPointData(String dataset, String id, String geo,Object[] header, Object[] values) throws Exception ;
    void importGeomData(String dataset, String id, String geo, Object[] header, Object[] values, String geomcode) throws Exception ;
    void insert(String dataset,String id,Object[] header,Object[] values) throws Exception;
    void deleteData(String dataset, Date fromDate,Date toDate) throws Exception ;
    void deleteIndex(String dataset) throws Exception ;
    void deleteData(String dataset,String id) throws Exception ;
    void clearAllData(String dataSet) throws Exception ;
    void init() throws Exception ;
    void commit() throws Exception ;
    void complete() throws Exception ;


}
