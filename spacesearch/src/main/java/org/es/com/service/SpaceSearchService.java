package org.es.com.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.es.com.es.SpaceSearch;
import org.es.com.utils.ESClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by on 2017/6/27.
 * Author Aaron.Wang
 */
@Service
public class SpaceSearchService implements SpaceSearch {

    private static Logger logger = LoggerFactory.getLogger(SpaceSearchService.class) ;

    public String querySearch(String request,String index) throws Exception {

        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(index).setTypes(null) ;//type为查询类型
        if (StringUtils.isNotEmpty(request)){
            JSONObject object = JSONObject.fromObject(request) ;
            Object[] header = object.keySet().toArray() ;
            Object[] data = object.values().toArray() ;
            BoolQueryBuilder query = QueryBuilders.boolQuery() ;
            for (int i=0;i<header.length;i++){
                query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));
            }
            builder.setQuery(query) ;
        }
        /*设置过滤条件*/
        builder.setPostFilter(QueryBuilders.geoDistanceRangeQuery("",new GeoPoint(123.0,123.0)).from("0km").to("").geoDistance(GeoDistance.ARC)) ;//设置查询范围
        builder.addSort(null) ;//排序
        /*builder.setFrom((pageno-1)*pagesize) ;分页
        builder.setSize(pagesize) ;*/
        SearchResponse result = builder.execute().actionGet() ;//向elasticsearch发起查询
        float usetime = result.getTookInMillis() ; //查询使用时间
        long count = result.getHits().getTotalHits() ;//查询获得的总条数
        SearchHit[] hits = result.getHits().getHits() ;
        JSONArray array = new JSONArray() ;
        for (SearchHit hit:hits){
            String object = JSONObject.fromObject(hit.getSourceAsString()).toString() ;
            array.add(object) ;
        }
        if (logger.isDebugEnabled()){
            logger.debug("共找到{}条结果",count);
            logger.debug("使用es耗时{}",usetime);
        }

        return array.toString();
    }




}
