package org.es.com.index;

import java.util.Date;

public interface SpaceSearchIndex {
	
	/**
	 * 根据文件路径导入点数据
	 * @param filePath
	 * @throws Exception
	 */
	public void importData(String filePath)throws Exception;
	
	/**
	 * 根据dataSet名称和indexField映射字段属性创建索引集合
	 * @param indexField
	 * @param dataSet
	 * @throws Exception
	 */
	public String createIndex(String indexField, String dataSet, String id)throws Exception;
	
	/**
	 * 根据header和values对应的key:value映射插入点数据
	 * @param dataset
	 * @param id
	 * @param geo
	 * @param header
	 * @param values
	 * @throws Exception
	 */
	public void importPointData(String dataset, String id, String geo, Object[] header, Object[] values) throws  Exception;
	
	/**
	 * 根据header和values对应的key:value映射插入面数据
	 * @param dataset
	 * @param id
	 * @param geo
	 * @param header
	 * @param values
	 * @throws Exception
	 */
	public void importGeomData(String dataset, String id, String geo, Object[] header, Object[] values, String geomcode) throws  Exception;
	
	/**
	 * 根据header和values对应的key:value映射插入数据
	 * @param dataset
	 * @param id
	 * @param geo
	 * @param header
	 * @param values
	 * @throws Exception
	 */
	public void importData(String dataset, String id, Object[] header, Object[] values) throws  Exception;
	
	/**
	 * 根据时间范围删除数据
	 * @param dataset
	 * @param fromeDate
	 * @param toDate
	 * @throws Exception
	 */
	public void deleteDate(String dataset, Date fromeDate, Date toDate) throws  Exception;
	
	/**
	 * 根据时间范围删除数据(字符串时间类型)
	 * @param dataset
	 * @param fromeDate
	 * @param toDate
	 * @throws Exception
	 */
	public void deleteDateStr(String dataset, String fromeDate, String toDate) throws  Exception;
	
	/**
	 * 根据ID删除数据
	 * @param dataset
	 * @param fromeDate
	 * @param toDate
	 * @throws Exception
	 */
	public void deleteData(String dataset, String id) throws  Exception;
	
	/**
	 * 根据指定字段的value删除数据
	 * @param dataset
	 * @param fromeDate
	 * @param toDate
	 * @throws Exception
	 */
	public void deleteData(String dataset, String field, String value) throws  Exception;
	
	/**
	 * 删除指定索引
	 * @param dataset
	 * @throws Exception
	 */
	public void deleteIndex(String dataset) throws  Exception;
	
	/**
	 * 批量提交动作
	 */
	public void commite();

}
