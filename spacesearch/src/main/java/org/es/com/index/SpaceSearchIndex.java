package org.es.com.index;

public interface SpaceSearchIndex {

    void importData(String dataset,String id,Object[] header,Object[] values) ;
    void deleteDataStr(String dataset,String fromDate,String toDate) throws Exception;

}
