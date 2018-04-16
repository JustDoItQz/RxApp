package org.es.com.spacesearch;


import java.util.List;

import net.sf.json.JSONObject;

import com.vividsolutions.jts.geom.Geometry;

public interface SpaceSearch {
	
	/**
	 * 查询在geometry内的所有点数据
	 * @param geometry
	 * @param dataset
	 * @param geofield
	 * @return
	 * @throws Exception
	 */
	public String searchGeometry(Geometry geometry, String dataset, boolean geofield) throws Exception;
	
	/**
	 * 查询在geometry内的所有点数据，并至返回ID
	 * @param geometry
	 * @param dataset
	 * @param geofield
	 * @return
	 * @throws Exception
	 */
	public String searchGeometryReturnId(Geometry geometry, String dataset, boolean geofield) throws Exception;
	
	/**
	 * 根据distance查询范围内的所有点数据
	 * @param geometry
	 * @param dataset
	 * @param geofield
	 * @return
	 * @throws Exception
	 */
	public String searchGeometry(double lon, double lat, String distance, String keyword, String dataset, int pageno, int pagesize) throws Exception;
	
	/**
	 * 附近车源搜索
	 * @param geometry
	 * @param dataset
	 * @param geofield
	 * @return
	 * @throws Exception
	 */
	public String searchGeometryNearby(double lon, double lat, String distance, String keyword, String dataset, int pageno, int pagesize) throws Exception;
	/**
	 * 根据distance查询范围内的所有点数据
	 * @param geometry
	 * @param dataset
	 * @param geofield
	 * @return
	 * @throws Exception
	 */
	public String searchGeometry(double lon, double lat, String distance, String keyword, String dataset) throws Exception;
	
	/**
	 * 根据关键词和分页数据查询
	 * @param keyword
	 * @param dataset
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public String searchKeyword(String keyword, String dataset, int pageno, int pagesize) throws Exception;
	
	/**
	 * 根据关键词和分页数据查询,并根据sortField排序
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public String searchKeyword(String keyword, String dataset, String sortField, int pageno, int pagesize) throws Exception;
	
	/**
	 * 根据关键词和分页数据查询可以根据时间范围过滤,并根据sortField排序
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public String searchKeyword(String keyword, String dataset, String sortField, String timeField, String startTime, String stopTime, int pageno, int pagesize) throws Exception;
	
	
	/**
	 * 根据关键词和分页数据查询可以根据时间范围过滤,并根据sortField排序
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 * 
	 * @author Aaron
	 */
	public String searchKeywords(String keyword, String dataset, String sortField, String timeField, String startTime, String stopTime, int pageno, int pagesize) throws Exception;

	
	/**
	 * 根据关键词返回第一条数据
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public String searchKeywordByFirst(String keyword, String dataset) throws Exception;
	
	/**
	 * 根据关键词返回车辆集合
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public String searchKeywordByVehicleNum(List<String> keywords, String dataset) throws Exception;
	
	/**
	 * 获取车辆信息
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public String searchVehicleInfoForVehicleNum(String vehicleNum, String dataset) throws Exception;
	
	
	/**
	 * 根据关键词集合返回第一条数据
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public String searchKeywordByLocal(List<String> keyword, String dataset) throws Exception;
	
	
	/**
	 * 获取多车辆最后位置
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public String vehiclesLastLocation(String[] vehicleNums, String dataset) throws Exception;
	
	
	/**
	 * 搜索网点信息
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> searchBranchesGeometry(double lon, double lat, String dataset, String distance) throws Exception;

	/**
	 * 根据distance查询范围内的所有点数据
	 * @param geometry
	 * @param dataset
	 * @param geofield
	 * @return
	 * @throws Exception
	 */
	public String searchNearCityVehicle(double lon, double lat, String distance, String keyword, String dataset) throws Exception;
	
	/****************************************************测试********************************************************/
	public String searchGeometryBranches(Geometry geometry, String dataset, boolean geofield) throws Exception;
	
	/**
	 * 根据时间段获取该时间段内上传位置的车辆
	 * @param keyword
	 * @param dataset
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public String searchVehicleKeyword(String keyword, String dataset, String startTime, String endTime) throws Exception;
	
	/**
	 * 获取网点信息
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> searchAllBranchesList(String dataset) throws Exception;
	
	
	/**
	 * 根据网点ID获取网点信息
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> searchAllBranchesList(String id, String dataset) throws Exception;
	
	
	
	/**
	 * 获取所有网点ID信息
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public List<String> searchAllBranchesId(String dataset) throws Exception;
	
	/**
	 * 根据车牌号、开始时间、结束时间查询车辆经纬度
	 * @param keyword
	 * @param dataset
	 * @param sortField
	 * @param startTime
	 * @param stopTime
	 * @return
	 * @throws Exception
	 * 
	 * @author Aaron
	 */
	
	public String searchLatLngByVehicleNum(String keyword, String dataset, String sortField, String timeField, String startTime, String stopTime) throws Exception;




	
}
