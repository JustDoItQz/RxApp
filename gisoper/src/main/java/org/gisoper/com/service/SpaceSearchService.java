package org.gisoper.com.service;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.common.com.utils.ESClient;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.geo.builders.ShapeBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.gisoper.com.es.SpaceSearch;
import org.gisoper.com.vo.AccountRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by on 2017/6/26.
 * Author Aaron.Wang
 */
@Service
public class SpaceSearchService implements SpaceSearch {

    private static Logger logger = LoggerFactory.getLogger(SpaceSearchService.class) ;

    @Override
    public String querySearch(AccountRequest request) throws Exception {

        logger.info("开始调用ES引擎！");
        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(request.getIndex()).setTypes(request.getType()) ;
        builder.setQuery(QueryBuilders.commonTermsQuery(request.getTerm(),request.getQueryString())) ;

        SearchResponse result = builder.execute().actionGet() ;
        long count = result.getHits().getTotalHits() ;
        long useTime = result.getTookInMillis() ;
        SearchHit[] hits = result.getHits().getHits() ;
        String object = null ;
        for (SearchHit t:hits){
            object = JSONObject.fromObject(t.getSourceAsString()).toString() ;

        }
        if (logger.isDebugEnabled()){
            logger.debug("查询共找到：{}条结果！",count);
            logger.debug("ES耗时：{}毫秒",useTime);
        }

        return object;
    }

    @Override
    public String querySearchByIndex(String request,String index) {

        logger.info("开始调用es引擎！");
        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(index) ;
        String jsonObj = null ;
        if (StringUtils.isNotEmpty(request)){
            JSONObject object = JSONObject.fromObject(request) ;
            Object[] header = object.keySet().toArray() ;
            Object[] data = object.values().toArray() ;
            BoolQueryBuilder query = QueryBuilders.boolQuery() ;
            for (int i=0;i<header.length;i++){
                query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i])) ;
            }
            builder.setQuery(query) ;
            builder.setFrom(0) ;
            builder.setPostFilter(null) ; //设置过滤条件
            SearchResponse result =builder.execute().actionGet() ;//发起查询
            long count = result.getHits().getTotalHits() ;
            long useTime = result.getTookInMillis() ;
            SearchHit[] hits = result.getHits().getHits() ;
            for (SearchHit hit:hits){
                jsonObj = JSONObject.fromObject(hit.getSourceAsString()).toString() ;
            }
            logger.info("查到{}条数据",count);
            logger.info("查询耗时：{}",useTime);

        }
        return jsonObj;
    }


}
