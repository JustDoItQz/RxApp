package org.es.com.index;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.WKTReader;
import net.sf.json.JSONObject;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequestBuilder;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.es.com.constant.Config;
import org.es.com.utils.Constant;
import org.es.com.utils.ESClient;
import org.es.com.utils.GeoHashGeometry;
import org.es.com.utils.GeoJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class EsSpaceSearchIndex extends AbstractSpaceSearchIndex {

    public static Logger logger = LoggerFactory.getLogger(AbstractSpaceSearchIndex.class) ;

    private BulkRequestBuilder builder ;

    public EsSpaceSearchIndex(){
        init();
    }

    @Override
    public void importData(String dataset, String id, Object[] header, Object[] values) throws Exception {
        if (ESClient.getInstance()!=null){
            JSONObject data = new JSONObject() ;
            for (int i=0;i<header.length;i++){
                data.put(header[i],values[i]) ;
            }
            bulkRequestBuilder(dataset,id,data.toString());
        }

    }
    @Override
    public void importPointData(String dataset, String id,String geo, Object[] header, Object[] values) throws Exception {
        if (ESClient.getInstance()!=null){
            WKTReader fromText = new WKTReader() ;
            Geometry geometry = fromText.read("POINT ("+geo+")") ;
            JSONObject data = new JSONObject() ;
            for (int i=0;i<header.length;i++){
                data.put(header[i],values[i]) ;
            }
            GeoJson geoJson = new GeoJson();
            String geohash = new GeoHashGeometry(Config.INDEX_GEO_TREELEVEL).encodePoint((Point)geometry) ;
            data.put(Config.INDEX_GEO_FIELDS,geoJson.encodeGeometry(geometry)) ;
            data.put(Config.INDEX_GEOHASH,geohash) ;
            bulkRequestBuilder(dataset,id,data.toString());

        }
    }

    @Override
    public void importGeomData(String dataset, String id, String geo, Object[] header, Object[] values, String geomcode) throws Exception {
        if (ESClient.getInstance()!=null){
            WKTReader fromText = new WKTReader() ;
            Geometry geometry = (Geometry) fromText.read("POINT ("+geomcode+")") ;
            String[] polygonsStrs = geo.split(Config.LINESTRING_SPLITE) ;
            Polygon [] polygons = new Polygon[polygonsStrs.length] ;
            for (int i=0;i<polygonsStrs.length;i++){
                String polygonJson = polygonsStrs[i] ;
                String [] pointStrs = polygonJson.split(Config.POINT_SPLITE) ;
                Coordinate[] coordinates = new Coordinate[pointStrs.length] ;
                for (int j=0;j<pointStrs.length;j++){
                    String [] point = pointStrs[j].split(Config.LOCATION_SPLITE) ;
                    coordinates[j]=new Coordinate(Double.parseDouble(point[0]),Double.parseDouble(point[1])) ;
                }
                Polygon polygon = new GeometryFactory().createPolygon(coordinates) ;
                polygons[i]=polygon ;
            }
            MultiPolygon multiPolygon = new GeometryFactory().createMultiPolygon(polygons) ;
            JSONObject data = new JSONObject() ;
            for (int i=0;i<header.length;i++){
                data.put(header[i],values[i]) ;
            }
            GeoJson geoJson = new GeoJson() ;
            String geohash = new GeoHashGeometry(Config.INDEX_GEO_TREELEVEL).encodePoint((Point) geometry) ;
            data.put(Config.INDEX_GEOHASH,geohash) ;
            data.put(Config.INDEX_GEO_FIELDS,geoJson.encodeGeometry(multiPolygon)) ;
            bulkRequestBuilder(dataset,id,data.toString());
        }

    }
    public void deleteDataStr(String dataset, String fromDate, String toDate) throws Exception {

        BoolQueryBuilder query = QueryBuilders.boolQuery() ;
        query.must(QueryBuilders.rangeQuery(Config.CREATED_AT).gte(fromDate)) ;
        query.must(QueryBuilders.rangeQuery(Config.CREATED_AT).lte(toDate)) ;
        SearchResponse result = ESClient.getInstance().prepareSearch(dataset).setTypes(Config.INDEX_TEST_TYPE).setQuery(query).addFieldDataField("_id").setSize(1000).get() ;
        SearchHit[] hits = result.getHits().getHits() ;
        if (hits.length>0){
            for (SearchHit hit:hits){
                builder.add(ESClient.getInstance().prepareDelete(dataset,Config.INDEX_TEST_TYPE,hit.getId())) ;
            }
            builder.get() ;
            deleteDataStr(dataset,fromDate,toDate);
        }
    }

    //创建索引
    @Override
    public void createIndex(String fieldIndex, String dataSet) throws Exception {

        try {
            Settings settings = Settings.builder()
                    .put("client.transport.sniff",false)
                    .put("node.client",true)
                    .put("cluster.name", Constant.getES_CLUSTERNAME())
                    .put("index.refresh_interval",120)
                    .put("node.name","es_node")
                    .put("number_of_replicas",Integer.valueOf(Constant.getNUMBER_OF_REPLICAS()))
                    .put("number_of_shards",Integer.valueOf(Constant.getNUMBER_OF_SHARDS()))
                    .build() ;
            CreateIndexRequestBuilder cib = ESClient.getInstance().admin().indices().prepareCreate(dataSet).setSettings(settings).addMapping(Config.INDEX_GEO_TYPE,fieldIndex) ;
            cib.execute().actionGet() ;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("创建索引失败:{}",e.getMessage());
        }
    }

    public void insert(String dataset, String id, Object[] header, Object[] values)throws Exception {
        if (ESClient.getInstance()!=null){
            JSONObject data = new JSONObject() ;
            for (int i=0;i<header.length;i++){
                data.put(header[i],values[i]) ;
            }
            bulkRequestBuilder(dataset,id,data.toString());
        }
    }

    @Override
    public void deleteData(String dataset, Date fromDate, Date toDate) throws Exception {

        BoolQueryBuilder query = QueryBuilders.boolQuery() ;
        query.must(QueryBuilders.rangeQuery(Config.INDEX_GEO_TIME).gte(fromDate)) ;
        query.must(QueryBuilders.rangeQuery(Config.INDEX_GEO_TIME).lte(toDate)) ;
        SearchResponse result = ESClient.getInstance().prepareSearch(dataset).setTypes(Config.INDEX_GEO_TYPE).setQuery(query).addField("_id").setSize(Config.MAX_DATA).get() ;
        SearchHit[] hits = result.getHits().getHits() ;
        //递归删除
        if (hits.length>0){
            for (SearchHit searchHit:hits){
                builder.add(ESClient.getInstance().prepareDelete(dataset,Config.INDEX_GEO_TYPE,searchHit.getId())) ;
            }
            builder.get() ;
            deleteData(dataset,fromDate,toDate);
        }
    }

    @Override
    public void deleteIndex(String dataset) throws Exception {
        DeleteIndexRequestBuilder dib = ESClient.getInstance().admin().indices().prepareDelete(dataset) ;
        dib.execute().actionGet() ;
    }

    @Override
    public void deleteData(String dataset, String id) throws Exception {

        ESClient.getInstance().prepareDelete(dataset,Config.INDEX_GEO_TYPE,id) ;
    }

    @Override
    public void clearAllData(String dataSet) throws Exception {
        SearchResponse result = ESClient.getInstance().prepareSearch(dataSet).setTypes(Config.INDEX_GEO_TYPE)
                .setQuery(QueryBuilders.matchAllQuery()).addField("_id").setSize(Config.MAX_DATA).get() ;
        SearchHit[] hits = result.getHits().getHits() ;
        //递归删除
        if (hits.length>0){
            for (SearchHit searchHit:hits){
                builder.add(ESClient.getInstance().prepareDelete(dataSet,Config.INDEX_GEO_TYPE,searchHit.getId())) ;
            }
            builder.get() ;
            clearAllData(dataSet);
        }
    }

    public void bulkRequestBuilder(String dataset, String id, String data){
        UpdateRequest request = new UpdateRequest(dataset,"user",id) ;
        request.doc(data.toString()).upsert(data.toString()) ;
        builder.add(request) ;
    }

    @Override
    public void init() {
        builder = ESClient.getInstance().prepareBulk() ;
    }

    @Override
    public void commit() {
        BulkResponse response = builder.execute().actionGet() ;
        if (response.hasFailures()){
        }
        builder = ESClient.getInstance().prepareBulk() ;
    }

    @Override
    public void complete() {
        if (builder.numberOfActions()!=0){
            commit();
        }
    }

}
