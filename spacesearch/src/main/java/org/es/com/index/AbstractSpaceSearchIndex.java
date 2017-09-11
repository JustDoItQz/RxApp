package org.es.com.index;

public abstract class AbstractSpaceSearchIndex implements SpaceSearchIndex {

    public void importData(String dataset, String id, Object[] header, Object[] values) {

    }

    abstract public void deleteDataStr(String dataset, String fromDate, String toDate) throws Exception ;
    abstract public void insert(String dataset,String id,Object[] header,Object[] values) throws Exception;

    abstract public void init() ;
    abstract public void commit() ;
    abstract public void complete() ;

}
