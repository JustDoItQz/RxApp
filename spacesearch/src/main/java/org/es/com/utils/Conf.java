package org.es.com.utils;

public class Conf {
	
	public static final String LATLON_SPLITE=",";
	
	public static final String POINT_SPLITE=";";
	
	public static final String LINESTRING_SPLITE="\\|";
	
	public static final String POLYGON_SPLITE="\\|";
	
	public static final String IMPORT_GEO_SHAPE_ID="id";
	
	public static final String IMPORT_GEO_ID="vehiclenum";//以车牌号作为唯一主键
	
	public static final String IMPORT_GEO_FIELDS="geom";
	
	public static final String IMPORT_GEO_TYPE="type";
	
	public static final String IMPORT_GEO_AREA="area";
	
	public static final String INDEX_GEOID="_id";
	
	public static final String INDEX_GEOHASH="geohash";
	
	public static final String INDEX_GEO_FIELDS = "geom";
	
	public static final String INDEX_GEO_BRANCHES = "geomcode";
	
	public static final String INDEX_GEO_DATASET = "kxtx.geomery";
	
	public static final String INDEX_GEO_HISTORY_DATASET = "kxtx.history.geomery";
	
	public static final String INDEX_GEO_SOURCE_DATASET = "kxtx.source.geomery";
	
	public static final String INDEX_GEO_SHAPE_DATASET = "kxtx.branches";
	public static final String INDEX_GEO_ORDERINFO_DATASET = "kxtx.orderinfo.geomery";

	public static final String INDEX_GEO_TIME = "vehicletime";
	
	public static final String INDEX_GEO_TYPE = "point";
	public static final String INDEX_ORDER_ID = "order_No";

	public static final int INDEX_GEO_TREELEVEL = 8;
	//索引搜索最大数量
	public static final int MAX_NUMBER_ES = 200;
	//一次性最大获取数据量
	public static final int MAX_DATA = 10000;
	
	public static final String LUCENE_INDEXPATH = "/home/dell/temp";
	
	public static final String SEARCH_GROUPBY = "villageCode";
	//标记车辆中存在车源信息
	public static final String HASH_VEHICLE_SOURCE = "hashvehiclesource";
	//车辆中存储车源
	public static final String HASH_VEHICLE_SOURCE_VALUE = "1";
	//车辆中不存在车源
	public static final String NO_VEHICLE_SOURCE_VALUE = "0";
	//上班时间
	public static final String STARTWORK = "startWork";
	//下班时间 
	public static final String ENDWORK = "endWork";
	//是否上班时间  0:上班，1：下班
	public static final String WORKSTATUS = "workStatus";
	//是否市内配送  0:默认，1：市内配
	public static final String ISCITYDIS = "isCityDis";
	//车型
	public static final String VEHICLEMODEL = "vehicleModel";
	//最小车长
	public static final String MINVLENGTH = "minVlength";
	//最大车长
	public static final String MAXVLENGTH = "maxVlength";
	//最小载重
	public static final String MINVLOAD = "minVload";
	//最大载重
	public static final String MAXVLOAD = "maxVload";
	//容积
	public static final String VVOLUME = "vVolume";
	//ES中的值
	public static final String VVOLUMEES = "vvolume";
	//车长 
	public static final String VEHICLELENGTH = "vehicleLength";
	//载重
	public static final String VLOAD = "vload";
	//是否认证
	public static final String AUTHENCATIOINSTATE = "authencatioinstate";
	//未承运中
	public static final String TRANSPORTSTATE = "transportstate";
	//上传位置时间
	public static final String VEHICLETIME = "vehicletime";
	
	public static final String TIMEDISTANCES = "timedistances";
	//纬度
	public static final String VEHICLELAT = "vehiclelat";
	//经度
	public static final String VEHICLELNG = "vehiclelng";
}
