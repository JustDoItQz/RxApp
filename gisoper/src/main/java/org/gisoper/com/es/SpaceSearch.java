package org.gisoper.com.es;

import org.gisoper.com.vo.AccountRequest;

/**
 * Created by on 2017/6/26.
 * Author Aaron.Wang
 */
public interface SpaceSearch {

    String querySearch(AccountRequest request) throws Exception ;

    //根据索引查询所有数据
    String querySearchByIndex(String request,String index) ;

}
