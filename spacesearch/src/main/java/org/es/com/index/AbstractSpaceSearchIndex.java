package org.es.com.index;

import au.com.bytecode.opencsv.CSVReader;
import org.es.com.exception.GeoDataException;
import org.es.com.utils.Conf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;




public abstract class AbstractSpaceSearchIndex implements SpaceSearchIndex{
	
	private static final String DEFAULT_GEO_LONGITUDE="xCoor";
	
	private static final String DEFAULT_GEO_LATITUDE="yCoor";
	
	private int count;
	
	public void importData(String filePath) throws FileNotFoundException, GeoDataException {
		CSVReader csvReader=new CSVReader(new BufferedReader(new FileReader(new File(filePath))));
		try {
			String[] header=csvReader.readNext();
			int xInd=-1;
			int yInd=-1;
			for (int i = 0; i < header.length; i++) {
				if(header[i].equals(DEFAULT_GEO_LONGITUDE)){
					xInd=i;
				}
				
				if(header[i].equals(DEFAULT_GEO_LATITUDE)){
					yInd=i;
				}
			}
			
			if(xInd<0||yInd<0){
				throw new GeoDataException("不存在经纬度数据");
			}
			//init();
			String[] data=null;
			while ((data=csvReader.readNext())!=null) {
				count++;
				String id=UUID.randomUUID().toString();
				//insert(id,data[yInd] + ", " + data[xInd],header,data);
				insertPoint(Conf.INDEX_GEO_DATASET,id,data[xInd]+" "+data[yInd],header,data);
				if(count%10000==0){
					commite();
				}
			}
			complete();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				csvReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void importPointData(String dataset,String id,String geo,Object[] header,Object[] values) throws  Exception{
		insertPoint(dataset,id,geo, header, values);
	}
	
	public void importGeomData(String dataset,String id,String geo,Object[] header,Object[] values,String geomcode) throws  Exception{
		insertGeom(dataset,id,geo, header, values,geomcode);
	}
	
	public void importData(String dataset,String id,Object[] header,Object[] values) throws  Exception{
		insert(dataset,id,header, values);
	}
	
	/**
	 * 插入包含位置的记录
	 * @param geo
	 */
	abstract public void insertPoint(String dataset,String id,String geo,Object[] header,Object[] values) throws Exception; 
	
	/**
	 * 插入记录
	 * @param geo
	 */
	abstract public void insert(String dataset,String id,Object[] header,Object[] values)  throws Exception; 
	
	
	
	abstract void insertGeom(String dataset,String id,String geo, Object[] header, Object[] values,String geomcode) throws Exception;
	
	
	/**
	 * 初始化
	 */
	abstract public void init();
	
	
	/**
	 * 提交数据
	 */
	abstract public void commite();
	
	/**
	 * 完成后用于清理工作
	 */
	abstract public void complete(); 

}
