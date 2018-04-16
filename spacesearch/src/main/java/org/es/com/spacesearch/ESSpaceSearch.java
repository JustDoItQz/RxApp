package org.es.com.spacesearch;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.ListenableActionFuture;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.geo.builders.ShapeBuilder;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import com.vividsolutions.jts.geom.Geometry;
import org.es.com.utils.*;

public class ESSpaceSearch implements SpaceSearch {
	
	private Log log = LogFactory.getLog(this.getClass());


	@Override
	public String searchGeometry(Geometry geometry, String dataset,boolean geofield) throws Exception {
		long start=System.currentTimeMillis();
		SearchRequestBuilder builder=ESClient.getInstance().prepareSearch(dataset);
		builder.setTypes(Conf.INDEX_GEO_TYPE);
		builder.setPostFilter(QueryBuilders.geoIntersectionQuery(Conf.INDEX_GEO_FIELDS, ShapeBuilder.newPoint(geometry.getCoordinate())));
		builder.setSize(Conf.MAX_NUMBER_ES);//在没有分页的情况下最多返回1000条数据，防止内存溢出
		builder.addField(Conf.INDEX_GEOID);
		if(geofield){
			builder.addField(Conf.INDEX_GEO_FIELDS);
		}
		
		SearchResponse result =builder.execute().actionGet();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
				array.add(t.isSourceEmpty()?t.getId():t.getSourceAsString());
		}
		long stop=System.currentTimeMillis();
		if(log.isDebugEnabled()){
			log.debug("空间查询使用es耗费:"+(stop-start)+"毫秒");
		}
		return array.toString();
	}
	
	public String searchGeometry(double lon,double lat,String distance,String keyword, String dataset, int  pageno,int pagesize) throws Exception {
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		distance = String.valueOf((Double.valueOf(distance))/1000);
		if(StringUtils.isNotEmpty(keyword)){
			JSONObject object=JSONObject.fromObject(keyword);
			Object[] header=object.keySet().toArray();//key集合
			Object[] data=object.values().toArray();//vlaue集合
			BoolQueryBuilder query=QueryBuilders.boolQuery();
			for (int i = 0; i < header.length; i++) {
				query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));//多个关键词之间并的关系
			}
			builder.setQuery(query);
		}
		
		builder.setPostFilter(QueryBuilders.geoDistanceRangeQuery(Conf.INDEX_GEOHASH).point(lat, lon).from("0km").to(distance+"km").geoDistance(GeoDistance.ARC));//查询空间字段
		builder.addSort(new GeoDistanceSortBuilder(Conf.INDEX_GEOHASH).point(lat,lon).unit(DistanceUnit.KILOMETERS));//根据距离字段排序
		builder.setFrom((pageno-1)*pagesize);
		builder.setSize(pagesize);
		
		SearchResponse result = builder.execute().actionGet();//向elasticsearch发起查询
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		Page page=new Page(pageno, pagesize,count);
		String rep=JsonResult.success("success",  array.toString(), page);
		return rep;
	}
	/**
	 * 查询附近车源信息
	 */
	public String searchGeometryNearby(double lon,double lat,String distance,String keyword, String dataset, int  pageno,int pagesize) throws Exception {
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		distance = String.valueOf((Double.valueOf(distance))/1000);
		if(StringUtils.isNotEmpty(keyword)){
			JSONObject object=JSONObject.fromObject(keyword);
			Object[] header=object.keySet().toArray();//key集合
			Object[] data=object.values().toArray();//vlaue集合
			BoolQueryBuilder query=QueryBuilders.boolQuery();
			for (int i = 0; i < header.length; i++) {
				query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));//多个关键词之间并的关系
			}
			builder.setQuery(query);
		}
		//过滤只有车源信息的车辆列表
		Object[] headergemo = new Object[]{Conf.HASH_VEHICLE_SOURCE};
		Object[] datagemo = new Object[]{Conf.HASH_VEHICLE_SOURCE_VALUE};
		BoolQueryBuilder query=QueryBuilders.boolQuery();
		query.must(QueryBuilders.commonTermsQuery((String)headergemo[0],(String)datagemo[0]));//多个关键词之间并的关系
		builder.setQuery(query);
		
		builder.setPostFilter(QueryBuilders.geoDistanceRangeQuery(Conf.INDEX_GEOHASH).point(lat, lon).from("0km").to(distance+"km").geoDistance(GeoDistance.ARC));//查询空间字段
		builder.addSort(new GeoDistanceSortBuilder(Conf.INDEX_GEOHASH).point(lat,lon).unit(DistanceUnit.KILOMETERS));//根据距离字段排序
		builder.setFrom((pageno-1)*pagesize);
		builder.setSize(pagesize);
		
		SearchResponse result = builder.execute().actionGet();//向elasticsearch发起查询
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		Page page=new Page(pageno, pagesize,count);
		String rep=JsonResult.success("success",  array.toString(), page);
		return rep;
	}
	
	public String searchGeometry(double lon,double lat,String distance,String keyword, String dataset) throws Exception {
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		distance = String.valueOf((Double.valueOf(distance))/1000);
		if(StringUtils.isNotEmpty(keyword)){
			JSONObject object=JSONObject.fromObject(keyword);
			Object[] header=object.keySet().toArray();//key集合
			Object[] data=object.values().toArray();//vlaue集合
			BoolQueryBuilder query=QueryBuilders.boolQuery();
			for (int i = 0; i < header.length; i++) {
				query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));//多个关键词之间并的关系
			}
			builder.setQuery(query);
		}
		
		builder.setPostFilter(QueryBuilders.geoDistanceRangeQuery(Conf.INDEX_GEOHASH).point(lat, lon).from("0km").to(distance+"km").geoDistance(GeoDistance.ARC));//查询空间字段
		builder.addSort(new GeoDistanceSortBuilder(Conf.INDEX_GEOHASH).point(lat,lon).unit(DistanceUnit.KILOMETERS));//根据距离字段排序
		//搜索200辆车
		builder.setSize(Conf.MAX_NUMBER_ES);
		SearchResponse result = builder.execute().actionGet();//向elasticsearch发起查询
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		String rep=JsonResult.success("success",  array.toString());
		return rep;
	}

	@Override
	public String searchKeyword(String keyword, String dataset,int pageno, int pagesize) throws Exception {
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		if(StringUtils.isNotEmpty(keyword)){
			JSONObject object=JSONObject.fromObject(keyword);
			Object[] header=object.keySet().toArray();
			Object[] data=object.values().toArray();
			BoolQueryBuilder query=QueryBuilders.boolQuery();
			for (int i = 0; i < header.length; i++) {
				query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));
			}
			builder.setQuery(query);
		}
		builder.setFrom((pageno-1)*pagesize);
		builder.setSize(pagesize);
		
		SearchResponse result = builder.execute().actionGet();
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		Page page=new Page(pageno, pagesize,count);
		String rep=JsonResult.success("success",  array.toString(), page);
		return rep;
	}
	
	@Override
	public String searchKeywordByFirst(String keyword, String dataset) throws Exception {
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		if(StringUtils.isNotEmpty(keyword)){
			JSONObject object=JSONObject.fromObject(keyword);
			Object[] header=object.keySet().toArray();
			Object[] data=object.values().toArray();
			BoolQueryBuilder query=QueryBuilders.boolQuery();
			for (int i = 0; i < header.length; i++) {
				query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));
			}
			builder.setQuery(query);
		}
//		builder.setFrom((pageno-1)*pagesize);
		builder.setSize(1);
		
		SearchResponse result = builder.execute().actionGet();
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		String geom=null;
		if(hits.length>0){
			geom=JSONObject.fromObject(hits[0].getSourceAsString()).toString();
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		String rep=JsonResult.success("success",  geom, null);
		return rep;
	}

	@Override
	public String searchKeyword(String keyword, String dataset,
			String sortField, int pageno, int pagesize) throws Exception {
		SearchRequestBuilder builder = ESClient.getInstance()
				.prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		if (StringUtils.isNotEmpty(keyword)) {
			JSONObject object = JSONObject.fromObject(keyword);
			Object[] header = object.keySet().toArray();
			Object[] data = object.values().toArray();
			BoolQueryBuilder query = QueryBuilders.boolQuery();
			for (int i = 0; i < header.length; i++) {
				query.must(QueryBuilders.commonTermsQuery((String) header[i],
						(String) data[i]));
			}
			builder.setQuery(query);
		}
		builder.setFrom((pageno - 1) * pagesize);
		builder.setSize(pagesize);

		builder.addSort(SortBuilders.fieldSort(sortField));

		SearchResponse result = builder.execute().actionGet();

		float usetime = result.getTookInMillis();
		long count = result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom = JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}

		if (log.isDebugEnabled()) {
			log.debug("查询共找到:" + count + "条结果");
			log.debug("空间查询使用es耗费:" + usetime + "毫秒");
		}
		Page page = new Page(pageno, pagesize, count);
		String rep = JsonResult.success("success", array.toString(), page);
		return rep;
	}

	@Override
	public String searchKeyword(String keyword, String dataset,String sortField, String timeField, String startTime, String stopTime,int pageno, int pagesize) throws Exception {
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		//搜索关键字不为空
		if(StringUtils.isNotEmpty(keyword)){
			JSONObject object=JSONObject.fromObject(keyword);
			Object[] header=object.keySet().toArray();
			Object[] data=object.values().toArray();
			BoolQueryBuilder query=QueryBuilders.boolQuery();
			//匹配所有key -value
			for (int i = 0; i < header.length; i++) {
				query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));
			}
			RangeQueryBuilder rangeQueryBuilder=null;
			//开始时间 结束时间不为空
			if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(stopTime)){
				rangeQueryBuilder=QueryBuilders.rangeQuery(timeField).from(startTime).to(stopTime);
				query.must(rangeQueryBuilder);
			}else if(StringUtils.isNotEmpty(startTime)){
				//开始时间不为空
				rangeQueryBuilder=QueryBuilders.rangeQuery(timeField).from(startTime);
				query.must(rangeQueryBuilder);
			}else if(StringUtils.isNotEmpty(stopTime)){
				//结束时间不为空
				rangeQueryBuilder=QueryBuilders.rangeQuery(timeField).to(stopTime);
				query.must(rangeQueryBuilder);
			}
			//搜索结果
			builder.setQuery(query);
		}
		//排序
		builder.addSort(SortBuilders.fieldSort(sortField));
		//分页
		//builder.setFrom((pageno-1)*pagesize);
		//builder.setSize(pagesize);
		
		builder.setSize(1000);
		SearchResponse result = builder.execute().actionGet();
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		//分页
		//Page page=new Page(pageno, pagesize,count);
		String rep=JsonResult.success("success",  array.toString());
		return rep;
	}
	
	@Override
	public String searchKeywords(String keyword, String dataset,String sortField, String timeField, String startTime, String stopTime,int pageno, int pagesize) throws Exception {
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		//搜索关键字不为空
		if(StringUtils.isNotEmpty(keyword)){
			JSONObject object=JSONObject.fromObject(keyword);
			Object[] header=object.keySet().toArray();
			Object[] data=object.values().toArray();
			BoolQueryBuilder query=QueryBuilders.boolQuery();
			//匹配所有key -value
			for (int i = 0; i < header.length; i++) {
				query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));
			}
			RangeQueryBuilder rangeQueryBuilder=null;
			//开始时间 结束时间不为空
			if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(stopTime)){
				rangeQueryBuilder=QueryBuilders.rangeQuery(timeField).from(startTime).to(stopTime);
				query.must(rangeQueryBuilder);
			}else if(StringUtils.isNotEmpty(startTime)){
				//开始时间不为空
				rangeQueryBuilder=QueryBuilders.rangeQuery(timeField).from(startTime);
				query.must(rangeQueryBuilder);
			}else if(StringUtils.isNotEmpty(stopTime)){
				//结束时间不为空
				rangeQueryBuilder=QueryBuilders.rangeQuery(timeField).to(stopTime);
				query.must(rangeQueryBuilder);
			}
			//搜索结果
			builder.setQuery(query);
		}
		//排序
		//builder.addSort(SortBuilders.fieldSort(sortField));
		builder.addSort(sortField, SortOrder.DESC) ;
		//分页
		builder.setFrom((pageno-1)*pagesize);
		builder.setSize(pagesize);
		
		//builder.setSize(1000);
		SearchResponse result = builder.execute().actionGet();
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		//分页
		Page page=new Page(pageno, pagesize,count);
		String rep=JsonResult.success("success",  array.toString(),page);
		return rep;
	}
	
	/**
	 * 搜索车辆列表信息
	 * @param keywords
	 * @param dataset
	 * @return
	 * @throws Exception
	 */
	@Override
	public String searchKeywordByVehicleNum(List<String> keywords, String dataset) throws Exception {
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		if(keywords!=null&&keywords.size()>0){
			BoolQueryBuilder query=QueryBuilders.boolQuery();
			for (String keyword:keywords) {
				JSONObject object=JSONObject.fromObject(keyword);
				Object[] header=object.keySet().toArray();
				Object[] data=object.values().toArray();
				BoolQueryBuilder childQuery=QueryBuilders.boolQuery();
				for (int i = 0; i < header.length; i++) {
					childQuery.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));
				}
				query.should(childQuery);
			}
			builder.setQuery(query);
		}
		builder.setSize(Conf.MAX_NUMBER_ES);
		SearchResponse result = builder.execute().actionGet();
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		String rep=JsonResult.success("success",  array.toArray(), null);
		return rep;
	}
	
	
	/**
	 * 搜索单个车辆信息
	 * @param dataset
	 * @return
	 * @throws Exception
	 */
	@Override
	public String searchVehicleInfoForVehicleNum(String vehicleNum, String dataset) throws Exception {
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		BoolQueryBuilder query=QueryBuilders.boolQuery();
		query.must(QueryBuilders.commonTermsQuery(Conf.IMPORT_GEO_ID,vehicleNum));
		builder.setQuery(query);
		builder.setSize(Conf.MAX_NUMBER_ES);
		SearchResponse result = builder.execute().actionGet();
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		String rep=JsonResult.success("success",  array.toArray(), null);
		return rep;
	}

	/**
	 * 搜索车辆位置信息
	 */
	@Override
	public String searchKeywordByLocal(List<String> keywords, String dataset) throws Exception {
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		if(keywords!=null&&keywords.size()>0){
			BoolQueryBuilder query=QueryBuilders.boolQuery();
			BoolQueryBuilder querybool=QueryBuilders.boolQuery();
			for (String keyword:keywords) {
				JSONObject object=JSONObject.fromObject(keyword);
				Object[] header=object.keySet().toArray();
				Object[] data=object.values().toArray();
				BoolQueryBuilder childQuery=QueryBuilders.boolQuery();
				for (int i = 0; i < header.length; i++) {
					childQuery.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));
				}
				querybool.should(childQuery);
			}
			query.must(querybool);
			query.must(QueryBuilders.existsQuery(Conf.VEHICLELAT));
			query.must(QueryBuilders.existsQuery(Conf.VEHICLELNG));
			query.mustNot(QueryBuilders.commonTermsQuery(Conf.VEHICLELAT,0));
			query.mustNot(QueryBuilders.commonTermsQuery(Conf.VEHICLELNG,0));
			builder.setQuery(query);
		}
		builder.setSize(Conf.MAX_NUMBER_ES);
		SearchResponse result = builder.execute().actionGet();
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		String rep=JsonResult.success("success",  array.toArray(), null);
		return rep;
	}
	
	
	/**
	 * 获取多车辆最后位置
	 * @return
	 * @throws Exception
	 */
	@Override
	public String vehiclesLastLocation(String[] vehicleNums, String dataset) throws Exception{
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		BoolQueryBuilder query=QueryBuilders.boolQuery();
		BoolQueryBuilder queryvehicle=QueryBuilders.boolQuery();
		for (int i = 0; i < vehicleNums.length; i++) {
			if(StringUtils.isNotBlank(vehicleNums[i])){
				queryvehicle.should(QueryBuilders.commonTermsQuery(Conf.IMPORT_GEO_ID,vehicleNums[i]));
			}
		}
		query.must(queryvehicle);
		query.must(QueryBuilders.existsQuery(Conf.VEHICLELAT));
		query.must(QueryBuilders.existsQuery(Conf.VEHICLELNG));
		query.mustNot(QueryBuilders.commonTermsQuery(Conf.VEHICLELAT,0));
		query.mustNot(QueryBuilders.commonTermsQuery(Conf.VEHICLELNG,0));
		builder.setQuery(query);
		builder.setSize(Conf.MAX_NUMBER_ES);
		SearchResponse result = builder.execute().actionGet();
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		String rep=JsonResult.success("success",  array.toArray(), null);
		return rep;
	}

	@Override
	public String searchGeometryReturnId(Geometry geometry, String dataset,boolean geofield) throws Exception {
		long start=System.currentTimeMillis();
		String id=null;
		SearchRequestBuilder builder=ESClient.getInstance().prepareSearch(dataset);
		builder.setTypes(Conf.INDEX_GEO_TYPE);
		builder.setPostFilter(QueryBuilders.geoIntersectionQuery(Conf.INDEX_GEO_FIELDS, ShapeBuilder.newPoint(geometry.getCoordinate())));
		builder.setSize(Conf.MAX_NUMBER_ES);
		builder.addField(Conf.INDEX_GEOID);
		if(geofield){
			builder.addField(Conf.INDEX_GEO_FIELDS);
		}
		
		SearchResponse result =builder.execute().actionGet();
		SearchHit[] hits = result.getHits().getHits();
		
		for (SearchHit t : hits) {
				id=t.getId();
		}
		long stop=System.currentTimeMillis();
		if(log.isDebugEnabled()){
			log.debug("空间查询使用es耗费:"+(stop-start)+"毫秒");
		}
		return id;
	}
	/**
	 * 搜索网点信息
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> searchBranchesGeometry(double lon,double lat,String dataset,String distance) throws Exception{
		long start=System.currentTimeMillis();
		distance = String.valueOf((Double.valueOf(distance))/1000);
		SearchRequestBuilder builder=ESClient.getInstance().prepareSearch(dataset);
		builder.setTypes(Conf.INDEX_GEO_TYPE);
		builder.setPostFilter(QueryBuilders.geoDistanceRangeQuery(Conf.INDEX_GEOHASH).point(lat, lon).from("0km").to(distance+"km").geoDistance(GeoDistance.ARC));//查询空间字段
		builder.addSort(new GeoDistanceSortBuilder(Conf.INDEX_GEOHASH).point(lat,lon).unit(DistanceUnit.KILOMETERS));//根据距离字段排序
		builder.setSize(Conf.MAX_NUMBER_ES);//在没有分页的情况下最多返回1000条数据，防止内存溢出
		builder.addField("address").addField("companyname").addField("contact").addField("geomcode")
		.addField("id").addField("lat").addField("lng").addField("name").addField("phone").addField("plane")
		.addField("time").addField("type");
		SearchResponse result =builder.execute().actionGet();
		long ing=System.currentTimeMillis();
		if(log.isDebugEnabled()){
			log.debug("空间查询使用es耗费为----------ing:"+(ing-start)+"毫秒");
		}
		SearchHits hits = result.getHits();
		List<JSONObject> array = new ArrayList<JSONObject>();
		long inggg=System.currentTimeMillis();
		if(log.isDebugEnabled()){
			log.debug("空间查询使用es耗费为----------:"+(inggg-start)+"毫秒");
		}
		for (SearchHit t : hits) {
			JSONObject json = new JSONObject();
			json.put("address", t.getFields().get("address").getValue());
			json.put("companyname", t.getFields().get("companyname").getValue());
			json.put("contact", t.getFields().get("contact").getValue());
			json.put("geomcode", t.getFields().get("geomcode").getValue());
			json.put("id", t.getFields().get("id").getValue());
			json.put("lat", t.getFields().get("lat").getValue());
			json.put("lng", t.getFields().get("lng").getValue());
			json.put("name", t.getFields().get("name").getValue());
			json.put("phone", t.getFields().get("phone").getValue());
			json.put("plane", t.getFields().get("plane").getValue());
			json.put("time", t.getFields().get("time").getValue());
			json.put("type", t.getFields().get("type").getValue());
			array.add(json);
		}
		long stop=System.currentTimeMillis();
		if(log.isDebugEnabled()){
			log.debug("空间查询使用es耗费:"+(stop-start)+"毫秒"+array.size());
		}
		return array;
	}
	
	
	/**
	 * 获取网点信息
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> searchAllBranchesList(String dataset) throws Exception{
		SearchRequestBuilder builder=ESClient.getInstance().prepareSearch(dataset);
		builder.setTypes(Conf.INDEX_GEO_TYPE);
		builder.addField("address").addField("companyname").addField("contact").addField("geomcode")
		.addField("id").addField("lat").addField("lng").addField("name").addField("phone").addField("plane")
		.addField("time").addField("type");
		builder.setSize(Conf.MAX_DATA);
		SearchResponse result =builder.execute().actionGet();
		SearchHits hits = result.getHits();
		List<JSONObject> array = new ArrayList<JSONObject>();
		for (SearchHit t : hits) {
			JSONObject json = new JSONObject();
			json.put("address", t.getFields().get("address").getValue());
			json.put("companyname", t.getFields().get("companyname").getValue());
			json.put("contact", t.getFields().get("contact").getValue());
			json.put("geomcode", t.getFields().get("geomcode").getValue());
			json.put("id", t.getFields().get("id").getValue());
			json.put("lat", t.getFields().get("lat").getValue());
			json.put("lng", t.getFields().get("lng").getValue());
			json.put("name", t.getFields().get("name").getValue());
			json.put("phone", t.getFields().get("phone").getValue());
			json.put("plane", t.getFields().get("plane").getValue());
			json.put("time", t.getFields().get("time").getValue());
			json.put("type", t.getFields().get("type").getValue());
			array.add(json);
		}
		return array;
	}
	
	
	/**
	 * 根据id获取网点信息
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> searchAllBranchesList(String id,String dataset) throws Exception{
		SearchRequestBuilder builder=ESClient.getInstance().prepareSearch(dataset);
		builder.setTypes(Conf.INDEX_GEO_TYPE);
		builder.addField("address").addField("companyname").addField("contact").addField("geomcode")
		.addField("id").addField("lat").addField("lng").addField("name").addField("phone").addField("plane")
		.addField("time").addField("type");
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		boolQueryBuilder.must(QueryBuilders.commonTermsQuery("id",id));
		builder.setQuery(boolQueryBuilder);
		builder.setSize(Conf.MAX_DATA);
		SearchResponse result =builder.execute().actionGet();
		SearchHits hits = result.getHits();
		List<JSONObject> array = new ArrayList<JSONObject>();
		for (SearchHit t : hits) {
			JSONObject json = new JSONObject();
			json.put("address", t.getFields().get("address").getValue());
			json.put("companyname", t.getFields().get("companyname").getValue());
			json.put("contact", t.getFields().get("contact").getValue());
			json.put("geomcode", t.getFields().get("geomcode").getValue());
			json.put("id", t.getFields().get("id").getValue());
			json.put("lat", t.getFields().get("lat").getValue());
			json.put("lng", t.getFields().get("lng").getValue());
			json.put("name", t.getFields().get("name").getValue());
			json.put("phone", t.getFields().get("phone").getValue());
			json.put("plane", t.getFields().get("plane").getValue());
			json.put("time", t.getFields().get("time").getValue());
			json.put("type", t.getFields().get("type").getValue());
			array.add(json);
		}
		return array;
	}
	
	
	
	/**
	 * 获取网点信息
	 * @return
	 * @throws Exception
	 */
	public List<String> searchAllBranchesId(String dataset) throws Exception{
		SearchRequestBuilder builder=ESClient.getInstance().prepareSearch(dataset);
		builder.setTypes(Conf.INDEX_GEO_TYPE);
		builder.addField("id");
		builder.setSize(Conf.MAX_DATA);
		SearchResponse result =builder.execute().actionGet();
		SearchHits hits = result.getHits();
		List<String> array = new ArrayList<String>();
		for (SearchHit t : hits) {
			array.add(t.getFields().get("id").getValue().toString());
		}
		return array;
	}
	
	/********************************************************************************************/
	@Override
	public String searchGeometryBranches(Geometry geometry, String dataset,boolean geofield) throws Exception {
		long start=System.currentTimeMillis();
		String id=null;
		SearchRequestBuilder builder=ESClient.getInstance().prepareSearch(dataset);
		builder.setTypes(Conf.INDEX_GEO_TYPE);
		builder.setPostFilter(QueryBuilders.geoIntersectionQuery(Conf.INDEX_GEO_FIELDS, ShapeBuilder.newPoint(geometry.getCoordinate())));
		builder.setSize(Conf.MAX_NUMBER_ES);
		builder.addField(Conf.INDEX_GEOID);
		if(geofield){
			builder.addField(Conf.INDEX_GEO_FIELDS);
		}
		SearchResponse result =builder.execute().actionGet();
		SearchHit[] hits = result.getHits().getHits();
		
		for (SearchHit t : hits) {
				id=t.getId();
		}
		long stop=System.currentTimeMillis();
		if(log.isDebugEnabled()){
			log.debug("空间查询使用es耗费:"+(stop-start)+"毫秒");
		}
		return id;
	}

	/**
	 * 市内配搜索附近车辆
	 */
	@Override
	public String searchNearCityVehicle(double lon, double lat,
			String distance, String keyword, String dataset) throws Exception {
		distance = String.valueOf((Double.valueOf(distance))/1000);
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		
		BoolQueryBuilder query=QueryBuilders.boolQuery();
		if(StringUtils.isNotEmpty(keyword)){
			JSONObject object=JSONObject.fromObject(keyword);
			//判断 车型 容积
			if(object.containsKey(Conf.VEHICLEMODEL)&&StringUtils.isNotEmpty(object.getString(Conf.VEHICLEMODEL))){
				query.must(QueryBuilders.commonTermsQuery(Conf.VEHICLEMODEL,object.getString(Conf.VEHICLEMODEL)));
			}
			if(object.containsKey(Conf.VVOLUME)&&StringUtils.isNotEmpty(object.getString(Conf.VVOLUME))){
				query.must(QueryBuilders.commonTermsQuery(Conf.VVOLUMEES,object.getString(Conf.VVOLUME)));
			}
			//判断最小车长
			if(object.containsKey(Conf.MINVLENGTH)&&StringUtils.isNotEmpty(object.getString(Conf.MINVLENGTH))){
				query.must(QueryBuilders.rangeQuery(Conf.VEHICLELENGTH).gte(object.getString(Conf.MINVLENGTH)));
			}
			//判断最大车长
			if(object.containsKey(Conf.MAXVLENGTH)&&StringUtils.isNotEmpty(object.getString(Conf.MAXVLENGTH))){
				query.must(QueryBuilders.rangeQuery(Conf.VEHICLELENGTH).lte(object.getString(Conf.MAXVLENGTH)));
			}
//			//判断最小载重
//			if(object.containsKey(Conf.MINVLOAD)&&StringUtils.isNotEmpty(object.getString(Conf.MINVLOAD))){
//				query.must(QueryBuilders.rangeQuery(Conf.VLOAD).gte(object.getString(Conf.MINVLOAD)));
//			}
//			//判断最大载重
//			if(object.containsKey(Conf.MAXVLOAD)&&StringUtils.isNotEmpty(object.getString(Conf.MAXVLOAD))){
//				query.must(QueryBuilders.rangeQuery(Conf.VLOAD).lte(object.getString(Conf.MAXVLOAD)));
//			}
			
			//五分钟之前的时间地点
			Calendar calendar = Calendar.getInstance();
			String distanceTime = object.getString(Conf.TIMEDISTANCES);
			if(StringUtils.isNotEmpty(distanceTime)){
				int time = Integer.valueOf(distanceTime);
				calendar.add(Calendar.MINUTE, -time);
			}else{
				calendar.add(Calendar.MINUTE, -5);
			}
			Date date = calendar.getTime();
			String datetime = DateUtils.convert(date);
			//上传位置在五分钟之内
			query.must(QueryBuilders.rangeQuery(Conf.VEHICLETIME).gte(datetime));
		}
		//司机在上班 车辆是市内配
		query.must(QueryBuilders.commonTermsQuery(Conf.WORKSTATUS,"0"));
		query.must(QueryBuilders.commonTermsQuery(Conf.ISCITYDIS,"1"));
		//空车状态
		//query.must(QueryBuilders.commonTermsQuery(Conf.TRANSPORTSTATE,"0"));
		//认证通过
		query.must(QueryBuilders.commonTermsQuery(Conf.AUTHENCATIOINSTATE,"1"));
		//工作中
		query.must(QueryBuilders.rangeQuery(Conf.STARTWORK).lte(DateUtils.getNowTimeWithoutDate()));
		query.must(QueryBuilders.rangeQuery(Conf.ENDWORK).gte(DateUtils.getNowTimeWithoutDate()));
		builder.setQuery(query);
		
		builder.setPostFilter(QueryBuilders.geoDistanceRangeQuery(Conf.INDEX_GEOHASH).point(lat, lon).from("0km").to(distance+"km").geoDistance(GeoDistance.ARC));//查询空间字段
		builder.addSort(new GeoDistanceSortBuilder(Conf.INDEX_GEOHASH).point(lat,lon).unit(DistanceUnit.KILOMETERS));//根据距离字段排序
		//搜索200辆车
		builder.setSize(Conf.MAX_NUMBER_ES);
		System.out.println(builder.toString());
		ListenableActionFuture<SearchResponse> actionFuture =builder.execute();
		SearchResponse result =actionFuture.actionGet();//向elasticsearch发起查询
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		String rep=JsonResult.success("success",  array.toString());
		return rep;
	}

	/**
	 * 根据时间段获取该时间段内上传位置的车辆
	 */
	@Override
	public String searchVehicleKeyword(String keyword, String dataset,
			String startTime, String endTime) throws Exception {
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		
		BoolQueryBuilder query=QueryBuilders.boolQuery();
		if(StringUtils.isNotEmpty(keyword)){
			JSONObject object=JSONObject.fromObject(keyword);
			Object[] header=object.keySet().toArray();
			Object[] data=object.values().toArray();
			BoolQueryBuilder childQuery=QueryBuilders.boolQuery();
			for (int i = 0; i < header.length; i++) {
				childQuery.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));
			}
		}
		//规定时间内上传位置的车辆
		query.must(QueryBuilders.rangeQuery(Conf.VEHICLETIME).gte(startTime).lte(endTime));
		builder.setQuery(query);
		builder.setSize(Conf.MAX_DATA);
		SearchResponse result =builder.execute().actionGet();
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		for (SearchHit t : hits) {
			String geom=JSONObject.fromObject(t.getSourceAsString()).toString();
			array.add(geom);
		}
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		Page page = new Page(1, 10, count);
		String rep=JsonResult.success("success",  array.toString(),page);
		return rep;
	}
	
	/**
	 * 通过车牌号查询车辆信息
	 * @param keyword
	 * @param timeField
	 * @param startTime
	 * @param stopTime
	 * 
	 * @author Aaron
	 */
	
	@Override
	public String searchLatLngByVehicleNum(String keyword, String dataset,
			String sortField, String timeField, String startTime,
			String stopTime) throws Exception {
		// TODO Auto-generated method stub
		
		SearchRequestBuilder builder= ESClient.getInstance().prepareSearch(dataset).setTypes(Conf.INDEX_GEO_TYPE);
		//搜索关键字不为空
		if(StringUtils.isNotEmpty(keyword)){
			JSONObject object=JSONObject.fromObject(keyword);
			Object[] header=object.keySet().toArray();
			Object[] data=object.values().toArray();
			BoolQueryBuilder query=QueryBuilders.boolQuery();
			//匹配所有key -value
			for (int i = 0; i < header.length; i++) {
				query.must(QueryBuilders.commonTermsQuery((String)header[i],(String)data[i]));
			}
			RangeQueryBuilder rangeQueryBuilder=null;
			//开始时间 结束时间不为空
			if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(stopTime)){
				rangeQueryBuilder=QueryBuilders.rangeQuery(timeField).from(startTime).to(stopTime);
				query.must(rangeQueryBuilder);
			}else if(StringUtils.isNotEmpty(startTime)){
				//开始时间不为空
				rangeQueryBuilder=QueryBuilders.rangeQuery(timeField).from(startTime);
				query.must(rangeQueryBuilder);
			}else if(StringUtils.isNotEmpty(stopTime)){
				//结束时间不为空
				rangeQueryBuilder=QueryBuilders.rangeQuery(timeField).to(stopTime);
				query.must(rangeQueryBuilder);
			}
			//搜索结果
			builder.setQuery(query);
			builder.setExplain(false);
			builder.addFields(new String[]{"vehiclelat","vehiclelng"}) ;
		}
		//排序
		//builder.addSort(SortBuilders.fieldSort(sortField),SortOrder.DESC);
		builder.addSort(sortField, SortOrder.DESC) ;
		//分页
		/*builder.setFrom((pageno-1)*pagesize);
		builder.setSize(pagesize);*/
		
		builder.setSize(1000);
		SearchResponse result = builder.execute().actionGet();
		
		float usetime = result.getTookInMillis();
		long count=result.getHits().getTotalHits();
		SearchHit[] hits = result.getHits().getHits();
		JSONArray array = new JSONArray();
		Map<String,Object> resMap = new HashMap<String,Object>();
		Iterator<SearchHitField> is = null;
		 SearchHitField shf = null;
		for (SearchHit t : hits) {
				 is = t.iterator();
				while(is.hasNext()){
					shf =  is.next();
					resMap.put(shf.getName(), shf.getValue());
				}
			String geom=JSONObject.fromObject(resMap).toString();
			array.add(geom);
		}
		
		if(log.isDebugEnabled()){
			log.debug("查询共找到:"+count+"条结果");
			log.debug("空间查询使用es耗费:"+usetime+"毫秒");
		}
		//分页
		//Page page=new Page(1, 20,count);
		String rep=JsonResult.success("success", array.toString());
		return rep;

	}
	

	
	
	public static void main(String[] args) {
		String distance = "20000.0";
		System.out.println(Double.valueOf(distance));
		distance = String.valueOf((Double.valueOf(distance))/1000);
		System.out.println(distance);
	}
}
