package org.es.com.index;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequestBuilder;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.WKTReader;
import org.es.com.utils.Conf;
import org.es.com.utils.ESClient;
import org.es.com.utils.GeoHashGeometry;
import org.es.com.utils.GeoJson;

public class ESSpaceSearchIndex extends AbstractSpaceSearchIndex {

	private BulkRequestBuilder builder;
	
	public ESSpaceSearchIndex(){
		init();
	}

	@Override
	public void insertPoint(String dataset,String id,String geo, Object[] header, Object[] values) throws Exception{
		if (ESClient.getInstance() != null) {
				WKTReader fromText = new WKTReader();
				Geometry geometry = (Geometry) fromText.read("POINT ("+geo+")");//封装点对象
				JSONObject data = new JSONObject();
				for (int i = 0; i < header.length; i++) {
					data.put(header[i],values[i]);
				}
//				if(dataset.equals(Conf.INDEX_GEO_DATASET)){
//					data.put(Conf.HASH_VEHICLE_SOURCE,Conf.NO_VEHICLE_SOURCE_VALUE);
//				}
				GeoJson geoJson=new GeoJson();
				String geohash = new GeoHashGeometry(Conf.INDEX_GEO_TREELEVEL).encodePoint((Point)geometry);
				data.put(Conf.INDEX_GEO_FIELDS,geoJson.encodeGeometry(geometry));
				data.put(Conf.INDEX_GEOHASH,geohash);
				bulkRequestBuilder(dataset,id,data.toString());
			
		}
	}
	
	@Override
	public void insertGeom(String dataset,String id,String geo, Object[] header, Object[] values,String geomcode) throws Exception {
		if (ESClient.getInstance() != null) {
				WKTReader fromText = new WKTReader();
				Geometry geometry = (Geometry) fromText.read("POINT ("+geomcode+")");//封装点对象
				String[] polygonsStrs=geo.split(Conf.LINESTRING_SPLITE);
			    Polygon[] polygons=new Polygon[polygonsStrs.length];
				for (int i = 0; i < polygonsStrs.length; i++) {
					String polygonJson=polygonsStrs[i];
					String[] pointStrs=polygonJson.split(Conf.POINT_SPLITE);
					Coordinate[] coordinates=new Coordinate[pointStrs.length];//
					for (int j = 0; j < pointStrs.length; j++) {
						String[] point=pointStrs[j].split(Conf.LATLON_SPLITE);
						coordinates[j]=new Coordinate(Double.parseDouble(point[0]), Double.parseDouble(point[1]));//点对象
					}
					Polygon polygon=new GeometryFactory().createPolygon(coordinates);//由点对象封装成面对象
					polygons[i]=polygon;
				}
				MultiPolygon multiPolygon=new GeometryFactory().createMultiPolygon(polygons);
				JSONObject data = new JSONObject();
				for (int i = 0; i < header.length; i++) {
					data.put(header[i],values[i]);
				}
				GeoJson geoJson=new GeoJson();
				String geohash = new GeoHashGeometry(Conf.INDEX_GEO_TREELEVEL).encodePoint((Point)geometry);
				data.put(Conf.INDEX_GEOHASH,geohash);
				data.put(Conf.INDEX_GEO_FIELDS,geoJson.encodeGeometry(multiPolygon));
				bulkRequestBuilder(dataset,id,data.toString());//插入elasticsearch
		}
	}
	
	@Override
	public void insert(String dataset,String id,Object[] header, Object[] values) throws Exception{
		if (ESClient.getInstance() != null) {
				JSONObject data = new JSONObject();
				for (int i = 0; i < header.length; i++) {
					data.put(header[i],values[i]);
				}
				bulkRequestBuilder(dataset,id,data.toString());
			
		}
	}

	public void bulkRequestBuilder(String dataset,String id,String data) {
		//builder.add(ESClient.getInstance().prepareIndex(Conf.INDEX_GEO_DATASET, Conf.INDEX_GEO_TYPE).setSource(data.toString()).setId(id));
		UpdateRequest request=new UpdateRequest(dataset, Conf.INDEX_GEO_TYPE, id);
		request.doc(data.toString()).upsert(data.toString());
		builder.add(request);
	}

	public void commite() {
		BulkResponse bulkResponse = builder.execute().actionGet();
		if (bulkResponse.hasFailures()) {
			// 处理错误
		}
		builder = ESClient.getInstance().prepareBulk();
	}

	@Override
	public void init() {
		builder = ESClient.getInstance().prepareBulk();
	}

	@Override
	public void complete() {
		if(builder.numberOfActions()!=0){
			commite();
		}
		
	}

	@Override
	public String createIndex(String indexField, String dataSet,String id) throws Exception {
		Map<String,Object> resultMap = new HashMap<String, Object>() ;
		try {
			/*第一种创建方法*/
			/*Settings settings = Settings.settingsBuilder()
					.put("client.transport.sniff", true)
					//每两分钟将数据刷新到elasticsearch索引
					.put("index.refresh_interval", 120)
					//ES名称
					.put("cluster.name", Constant.getES_CLUSTERNAME())
					//副本
					.put("number_of_replicas", Integer.valueOf(Constant.getNUMBER_OF_REPLICAS()))
					//数据分片
					.put("number_of_shards", Integer.valueOf(Constant.getNUMBER_OF_SHARDS()))
					.build();
			CreateIndexRequestBuilder cib = ESClient.getInstance().admin().indices().prepareCreate(dataSet).setSettings(settings).addMapping(Conf.INDEX_GEO_TYPE, indexField);
			cib.get() ;*/

			/*第二种创建方法*/
			//批量创建索引
			BulkRequestBuilder bulkRequestBuilder = ESClient.getInstance().prepareBulk() ;
			Map<String,Object> paramMap = new HashMap<String, Object>() ;
			JSONObject object = JSONObject.fromObject(indexField) ;
			Object[] data = object.values().toArray() ;
			Object[] header = object.keySet().toArray() ;
			if (header!=null&&header.length>0){
				for (int i=0;i<header.length;i++){
					paramMap.put((String)header[i],data[i]) ;
				}
			}
			if (paramMap!=null&&paramMap.size()>0){
				IndexRequest request = ESClient.getInstance().prepareIndex(dataSet, Conf.INDEX_GEO_TYPE,id).setSource(paramMap).request() ;
				bulkRequestBuilder.add(request) ;
				BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
				if (bulkResponse.hasFailures()){
					resultMap.put("msg","创建索引失败!") ;
					resultMap.put("success",false) ;
				}else{
					resultMap.put("msg","创建索引成功！!") ;
					resultMap.put("success",true) ;
				}
			}

			/**
			 * XContentBuilder mapping = XContentFactory.jsonBuilder()
			 * .startObject() .startObject(DEFAULT_GEO_TYPES)
			 * .startObject("properties") .startObject(DEFAULT_GEO_FIELDS)
			 * .field("type", "geo_shape").field("store",
			 * "yes").field("tree_levels", "11") .endObject().endObject()
			 * .endObject().endObject();
			 
			PutMappingRequest mappingRequest = Requests.putMappingRequest(Conf.INDEX_GEO_DATASET).type(Conf.INDEX_GEO_TYPE).source(indexField);
			ESClient.getInstance().admin().indices().putMapping(mappingRequest).actionGet();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.fromObject(resultMap).toString() ;
	}
	

	public static void main(String[] args) {
		SpaceSearchIndex index = new ESSpaceSearchIndex();
		try {
			index.importData("/home/dell/下载/门址.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDate(String dataset, Date fromeDate, Date toDate) throws Exception {
//		DeleteByQueryResponse response = new DeleteByQueryRequestBuilder(ESClient.getInstance(), DeleteByQueryAction.INSTANCE)
//				.setIndices(dataset)
//				.setTypes(Conf.INDEX_GEO_TYPE)
//		        .setQuery(QueryBuilders.rangeQuery(Conf.INDEX_GEO_TIME)
//		        .from(fromeDate).to(toDate))
//		        .execute()
//		        .actionGet();//根据时间范围删除数据
		BoolQueryBuilder query=QueryBuilders.boolQuery();
		query.must(QueryBuilders.rangeQuery(Conf.INDEX_GEO_TIME).gte(fromeDate));
		query.must(QueryBuilders.rangeQuery(Conf.INDEX_GEO_TIME).lte(toDate));
		SearchResponse result = ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE)
				.setQuery(query).addField("_id").setSize(Conf.MAX_DATA).get();
		SearchHit[] hits = result.getHits().getHits();
		//递归删除
		if(hits.length>0){
			for (SearchHit searchHit : hits) {
				builder.add(ESClient.getInstance().prepareDelete(dataset,Conf.INDEX_GEO_TYPE,searchHit.getId()));
			}
			builder.get();
			deleteDate(dataset, fromeDate, toDate);
		}
		
	}
	
	@Override
	public void deleteDateStr(String dataset, String fromeDate, String toDate) throws Exception {
//		DeleteByQueryResponse response = new DeleteByQueryRequestBuilder(ESClient.getInstance(), DeleteByQueryAction.INSTANCE)
//				.setIndices(dataset)
//				.setTypes(Conf.INDEX_GEO_TYPE)
//		        .setQuery(QueryBuilders.rangeQuery(Conf.INDEX_GEO_TIME)
//		        .from(fromeDate).to(toDate))
//		        .execute()
//		        .actionGet();//根据时间范围删除数据
		BoolQueryBuilder query=QueryBuilders.boolQuery();
		query.must(QueryBuilders.rangeQuery(Conf.INDEX_GEO_TIME).gte(fromeDate));
		query.must(QueryBuilders.rangeQuery(Conf.INDEX_GEO_TIME).lte(toDate));
		SearchResponse result = ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE)
				.setQuery(query).addField("_id").setSize(Conf.MAX_DATA).get();
		SearchHit[] hits = result.getHits().getHits();
		//递归删除
		if(hits.length>0){
			for (SearchHit searchHit : hits) {
				builder.add(ESClient.getInstance().prepareDelete(dataset,Conf.INDEX_GEO_TYPE,searchHit.getId()));
			}
			builder.get();
			deleteDateStr(dataset, fromeDate, toDate);
		}
	}

	@Override
	public void deleteIndex(String dataset) throws Exception {
		DeleteIndexRequestBuilder dib = ESClient.getInstance().admin().indices().prepareDelete(dataset);
		dib.execute().actionGet();
	}

	@Override
	public void deleteData(String dataset, String id) throws Exception {
//		DeleteByQueryResponse response = new DeleteByQueryRequestBuilder(ESClient.getInstance(), DeleteByQueryAction.INSTANCE)
//				.setIndices(dataset)
//				.setTypes(Conf.INDEX_GEO_TYPE)
//		        .setQuery(QueryBuilders.termQuery(Conf.INDEX_GEOID, id))
//		        .execute()
//		        .actionGet();
		ESClient.getInstance().prepareDelete(dataset, Conf.INDEX_GEO_TYPE, id);
	}

	@Override
	public void deleteData(String dataset, String field, String value) throws Exception {
//		DeleteByQueryResponse response = new DeleteByQueryRequestBuilder(ESClient.getInstance(), DeleteByQueryAction.INSTANCE)
//				.setIndices(dataset)
//				.setTypes(Conf.INDEX_GEO_TYPE)
//		        .setQuery(QueryBuilders.termQuery(field, value))
//		        .execute()
//		        .actionGet();
		BoolQueryBuilder query=QueryBuilders.boolQuery();
		query.must(QueryBuilders.commonTermsQuery(field,value));
		SearchResponse result = ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE)
				.setQuery(query).addField("_id").setSize(Conf.MAX_DATA).get();
		SearchHit[] hits = result.getHits().getHits();
		//递归删除
		if(hits.length>0){
			for (SearchHit searchHit : hits) {
				builder.add(ESClient.getInstance().prepareDelete(dataset,Conf.INDEX_GEO_TYPE,searchHit.getId()));
			}
			builder.get();
			deleteData(dataset, field, value);
		}
	}
	
	/**
	 * 清除节点下的值
	 * @param dataset
	 * @throws Exception
	 */
	public void clearAllData(String dataset) throws Exception{
//		DeleteByQueryResponse response = new DeleteByQueryRequestBuilder(ESClient.getInstance(), DeleteByQueryAction.INSTANCE)
//				.setIndices(dataset)
//				.setTypes(Conf.INDEX_GEO_TYPE)
//		        .setQuery(QueryBuilders.matchAllQuery())
//		        .execute()
//		        .actionGet();
		SearchResponse result = ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE)
				.setQuery(QueryBuilders.matchAllQuery()).addField("_id").setSize(Conf.MAX_DATA).get();
		SearchHit[] hits = result.getHits().getHits();
		//递归删除
		if(hits.length>0){
			for (SearchHit searchHit : hits) {
				builder.add(ESClient.getInstance().prepareDelete(dataset,Conf.INDEX_GEO_TYPE,searchHit.getId()));
			}
			builder.get();
			clearAllData(dataset);
		}
	}
}
