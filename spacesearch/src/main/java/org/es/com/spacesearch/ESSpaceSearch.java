package org.es.com.spacesearch;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.lucene.spatial3d.geom.GeoDistance;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.es.com.constant.Config;
import org.es.com.utils.ESClient;
import org.slf4j.LoggerFactory;

public class ESSpaceSearch implements SpaceSearch{

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ESSpaceSearch.class) ;

    public String searchKeyword(String keyword, String dataset, int page, int pagesize) throws Exception {
        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(dataset).setTypes(Config.INDEX_GEO_TYPE) ;
        JSONArray array = new JSONArray() ;
        if (StringUtils.isNotBlank(keyword)){
            JSONObject object = JSONObject.fromObject(keyword) ;
            Object[] header = object.keySet().toArray() ;
            Object[] values  = object.values().toArray() ;
            BoolQueryBuilder query = QueryBuilders.boolQuery() ;
            for (int i=0;i<header.length;i++){
                query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)values[i])) ;
            }
            builder.setQuery(query) ;
            builder.setFrom((page-1)*pagesize) ;
            builder.setSize(pagesize) ;

            SearchResponse result = builder.execute().actionGet() ;
            float usetime = result.getTookInMillis() ;
            long count = result.getHits().getTotalHits() ;
            SearchHit[] hits = result.getHits().getHits() ;
            for (SearchHit hit:hits){
                array.add(JSONObject.fromObject(hit.getSourceAsString().toString()).toString()) ;
            }
            logger.info("查询耗时:{}",usetime);
            logger.info("查询到{}条数据",count);
        }
        return array.toString();
    }

    public String searchKeyword(String keyword, String dataset, String sortField, int page, int pagesize) throws Exception {
        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(dataset).setTypes(Config.INDEX_GEO_TYPE) ;
        JSONArray array = new JSONArray() ;
        if (StringUtils.isNotBlank(keyword)){
            JSONObject object = JSONObject.fromObject(keyword) ;
            Object[] header = object.keySet().toArray() ;
            Object[] values  = object.values().toArray() ;
            BoolQueryBuilder query = QueryBuilders.boolQuery() ;
            for (int i=0;i<header.length;i++){
                query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)values[i])) ;
            }
            builder.setQuery(query) ;
            builder.setFrom((page-1)*pagesize) ;
            builder.setSize(pagesize) ;
            builder.addSort(sortField,SortOrder.DESC) ;

            SearchResponse result = builder.execute().actionGet() ;
            float usetime = result.getTookInMillis() ;
            long count = result.getHits().getTotalHits() ;
            SearchHit[] hits = result.getHits().getHits() ;
            for (SearchHit hit:hits){
                array.add(JSONObject.fromObject(hit.getSourceAsString().toString()).toString()) ;
            }
            logger.info("查询耗时:{}",usetime);
            logger.info("查询到{}条数据",count);
        }
        return array.toString();
    }

    public String searchKeyword(String keyword, String dataset, String sortField) throws Exception {
        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(dataset).setTypes(Config.INDEX_GEO_TYPE) ;
        JSONArray array = new JSONArray() ;
        if (StringUtils.isNotBlank(keyword)){
            JSONObject object = JSONObject.fromObject(keyword) ;
            Object[] header = object.keySet().toArray() ;
            Object[] values = object.values().toArray() ;
            BoolQueryBuilder query = QueryBuilders.boolQuery() ;
            for (int i=0;i<header.length;i++){
                query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)values[i])) ;
            }
            builder.setQuery(query) ;
            builder.addSort(sortField, SortOrder.DESC) ;

            SearchResponse result = builder.execute().actionGet() ;
            float usetime = result.getTookInMillis() ;
            long count = result.getHits().getTotalHits() ;
            SearchHit[] hits = result.getHits().getHits() ;
            for (SearchHit hit:hits){
                array.add(JSONObject.fromObject(hit.getSourceAsString().toString()).toString()) ;
            }
            logger.info("查询耗时：{}秒",(usetime/1000));
            logger.info("共查到{}条数据",count);


        }
        return array.toString();
    }
    public String searchKeyword(String keyword, String dataset) throws Exception {
        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(dataset).setTypes("") ;
        JSONArray array = new JSONArray() ;
        if (StringUtils.isNotBlank(keyword)){
            JSONObject object = JSONObject.fromObject(keyword) ;
            Object[] header = object.keySet().toArray() ;
            Object[] values = object.values().toArray() ;
            BoolQueryBuilder query = QueryBuilders.boolQuery() ;
            for (int i=0;i<header.length;i++){
                query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)values[i])) ;
            }
            builder.setQuery(query) ;
            SearchResponse result = builder.execute().actionGet() ;
            float usetime = result.getTookInMillis() ;
            long count = result.getHits().getTotalHits() ;
            SearchHit[] hits = result.getHits().getHits() ;
            for (SearchHit hit:hits){
                array.add(JSONObject.fromObject(hit.getSourceAsString().toString()).toString()) ;
            }
            logger.info("查询耗时：{}秒",(usetime/1000));
            logger.info("共查到{}条数据",count);


        }
        return array.toString();
    }

    public String searchGeometryNearBy(double lon, double lat, String distance, String keyword, String dataset, String pageNo, String pageSize) throws Exception {
        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(dataset).setTypes(Config.INDEX_GEO_TYPE) ;
        JSONArray array = new JSONArray() ;
        distance = String.valueOf((Double.valueOf(distance)/1000)) ;
        if (StringUtils.isNotBlank(keyword)){
            JSONObject object = JSONObject.fromObject(keyword) ;
            Object[] header = object.keySet().toArray() ;
            Object[] values = object.values().toArray() ;
            BoolQueryBuilder query = QueryBuilders.boolQuery() ;
            for (int i=0;i<header.length;i++){
                query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)values[i])) ;
            }
            builder.setQuery(query) ;
        }
        Object[] headerGeomo = new Object[]{Config.HASH_VEHICLE_SOURCE} ;
        Object[] dataGemo = new Object[]{Config.HASH_VEHICLE_SOURCE_VELUES} ;
        BoolQueryBuilder query = QueryBuilders.boolQuery() ;
        query.must(QueryBuilders.commonTermsQuery((String)headerGeomo[0],(String)dataGemo[0])) ;
        builder.setQuery(query) ;

        builder.setPostFilter(QueryBuilders.geoDistanceRangeQuery(Config.INDEX_GEOHASH,lat,lon).from("0km").to(distance+"km").geoDistance(org.elasticsearch.common.geo.GeoDistance.ARC)) ;
        builder.setFrom(((Integer.parseInt(pageNo))-1)*Integer.parseInt(pageSize)) ;
        builder.setSize(Integer.parseInt(pageSize)) ;
        SearchResponse result = builder.execute().actionGet() ;
        float usetime = result.getTookInMillis() ;
        long count = result.getHits().getTotalHits() ;
        SearchHit[] hits = result.getHits().getHits() ;
        for (SearchHit hit:hits){
            array.add(JSONObject.fromObject(hit.getSourceAsString().toString()).toString()) ;
        }
        logger.info("查询耗时{}秒",usetime);
        logger.info("共查到{}条数据",count);

        return array.toString();
    }

    public String searchKeyword(String keyword, String dataset, String timeField,String sortField, String startTime, String endTime, int page, int pagesize) throws Exception {
        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(dataset).setTypes(Config.INDEX_GEO_TYPE) ;
        JSONArray array = new JSONArray() ;
        if (StringUtils.isNotBlank(keyword)){
            JSONObject object = JSONObject.fromObject(keyword) ;
            Object[] header = object.keySet().toArray() ;
            Object[] values = object.values().toArray() ;
            BoolQueryBuilder query = QueryBuilders.boolQuery() ;
            for (int i=0;i<header.length;i++){
                query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)values[i])) ;
                //query.must(QueryBuilders.rangeQuery(timeField).gte(startTime).lte(endTime)) ;//设置查询范围
            }

            builder.setQuery(query) ;
            builder.addSort(sortField,SortOrder.DESC) ;
            RangeQueryBuilder rangeQueryBuilder = null ;
            if (StringUtils.isNotBlank(startTime)&&StringUtils.isNotBlank(endTime)){
                rangeQueryBuilder = QueryBuilders.rangeQuery(timeField).from(startTime).to(endTime) ;
                builder.setQuery(rangeQueryBuilder) ;
            }else if (StringUtils.isNotBlank(startTime)){
                rangeQueryBuilder = QueryBuilders.rangeQuery(timeField).from(startTime) ;
                builder.setQuery(rangeQueryBuilder) ;
            }else if (StringUtils.isNotBlank(endTime)){
                rangeQueryBuilder = QueryBuilders.rangeQuery(timeField).to(endTime) ;
                query.must(rangeQueryBuilder) ;
            }
            builder.setQuery(query) ;
            builder.setSize(1000) ;//ES查询超过1000条数据，对优化不好
            SearchResponse result = builder.execute().actionGet() ;
            float usetime = result.getTookInMillis() ;
            long count = result.getHits().getTotalHits() ;
            SearchHit[] hits = result.getHits().getHits() ;
            for (SearchHit hit:hits){
                array.add(JSONObject.fromObject(hit.getSourceAsString().toString()).toString()) ;
            }
            logger.info("查询耗时{}秒",(usetime/1000));
            logger.info("共查到{}条数据",count);
        }
        return array.toString();
    }

    public String searchKeywordByFirst(String keyword, String dataset) throws Exception {
        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(dataset).setTypes(Config.INDEX_GEO_TYPE) ;
        JSONArray array = new JSONArray() ;
        if (StringUtils.isNotBlank(keyword)){
            JSONObject object = JSONObject.fromObject(keyword) ;
            Object[] header = object.keySet().toArray() ;
            Object[] values = object.values().toArray() ;
            BoolQueryBuilder query = QueryBuilders.boolQuery() ;
            for (int i=0;i<header.length;i++){
                query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)values[i])) ;
            }
            query.must(QueryBuilders.existsQuery(Config.VEHICLELNG)) ;
            query.must(QueryBuilders.existsQuery(Config.VEHICLELAT)) ;
            query.mustNot(QueryBuilders.commonTermsQuery(Config.VEHICLELNG,0)) ;
            query.mustNot(QueryBuilders.commonTermsQuery(Config.VEHICLELAT,0)) ;
            builder.setQuery(query) ;
            builder.setSize(1) ;//查询一条数据
            SearchResponse result = builder.execute().actionGet() ;
            float usetime = result.getTookInMillis() ;
            long count = result.getHits().getTotalHits() ;
            SearchHit[] hits = result.getHits().getHits() ;
            for (SearchHit hit:hits){
                array.add(JSONObject.fromObject(hit.getSourceAsString().toString()).toString()) ;
            }
            logger.info("查询耗时{}秒",(usetime/1000));
            logger.info("共查到{}条数据",count);
        }

        return array.toString();
    }

    public String searchKeyword(String keyword, String dataset, String sortField, String startTime, String endTime, int page, int pagesize) throws Exception {
        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(dataset).setTypes(Config.INDEX_GEO_TYPE) ;
        JSONArray array = new JSONArray() ;
        if (StringUtils.isNotBlank(keyword)){
            JSONObject object = JSONObject.fromObject(keyword) ;
            Object[] header = object.keySet().toArray() ;
            Object[] values = object.values().toArray() ;
            BoolQueryBuilder query = QueryBuilders.boolQuery() ;
            for (int i=0;i<header.length;i++){
                query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)values[i])) ;
            }
            builder.setQuery(query) ;
            builder.setFrom((page-1)*pagesize) ;//分页操作
            builder.setSize(pagesize) ;
            SearchResponse result = builder.execute().actionGet() ;
            float usetime = result.getTookInMillis() ;
            long count = result.getHits().getTotalHits() ;
            SearchHit[] hits = result.getHits().getHits() ;
            for (SearchHit hit:hits){
                array.add(JSONObject.fromObject(hit.getSourceAsString().toString()).toString()) ;
            }
            logger.info("查询耗时{}秒",(usetime/1000));
            logger.info("共查到{}条数据",count);
        }
        return array.toString();
    }

    public String vehicleLastLocation(String[] vehicleNums, String dataset) throws Exception {
        SearchRequestBuilder builder = ESClient.getInstance().prepareSearch(dataset).setTypes(Config.INDEX_GEO_TYPE) ;
        JSONArray array = new JSONArray() ;
        BoolQueryBuilder query = QueryBuilders.boolQuery() ;
        BoolQueryBuilder chileQuery = QueryBuilders.boolQuery() ;
        if (vehicleNums.length>0&&vehicleNums!=null){
            for (int i=0;i<vehicleNums.length;i++){
                if (StringUtils.isNotBlank(vehicleNums[i])){
                    chileQuery.should(QueryBuilders.commonTermsQuery("vehiclenum",vehicleNums[i])) ;
                }
            }
            query.must(chileQuery) ;
            query.must(QueryBuilders.existsQuery(Config.VEHICLELAT)) ;
            query.must(QueryBuilders.existsQuery(Config.VEHICLELNG)) ;
            query.mustNot(QueryBuilders.commonTermsQuery(Config.VEHICLELAT,0)) ;
            query.mustNot(QueryBuilders.commonTermsQuery(Config.VEHICLELNG,0)) ;
            SearchResponse  result = builder.execute().actionGet() ;
            float usetime = result.getTookInMillis() ;
            long count = result.getHits().getTotalHits() ;
            SearchHit[]  hits = result.getHits().getHits() ;
            for (SearchHit hit:hits){
                array.add(JSONObject.fromObject(hit.getSourceAsString().toString()).toString()) ;
            }
            logger.info("查询耗时{}",(usetime/1000));
            logger.info("共查到{}条数据",count);
        }else{
            array.add(new JSONObject().put("msg","传入参数为空！")) ;
        }
        return array.toString();
    }

}
