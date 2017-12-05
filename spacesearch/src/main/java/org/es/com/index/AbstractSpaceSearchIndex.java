package org.es.com.index;

public abstract class AbstractSpaceSearchIndex implements SpaceSearchIndex {
    abstract public void init() ;
    abstract public void commit() ;
    abstract public void complete() ;

}
