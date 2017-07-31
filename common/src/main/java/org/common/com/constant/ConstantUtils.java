package org.common.com.constant;

/**
 * Created by on 2017/6/23.
 * Author Aaron.Wang
 */
public class ConstantUtils {

    /*高德相关请求地址*/

    //高德行政区域查询
    public static final String ADDRESS_DISTRICT_URL_PREFIX = "http://restapi.amap.com/v3/config/district" ;
    //腾讯地址库查询(街道)
    public static final String ADDRESS_TENGCENT_DISTRICT_URL_PREFIX = "http://apis.map.qq.com/ws/district/v1/getchildren" ;
    //地址库街道数据
    public static final String ADDRESS_AREA_CODE_REDIS="ADDRESS_AREA_CODE_REDIS" ;

    /*百度相关请求地址*/

    //百度鹰眼seviceId
    public static final int YINGYAN_SERVICE_ID=146098 ;
    //百度鹰眼AK
    public static String YINGYAN_AK ="qC2p7KRwPDxI5ffPTyiRt4kGtBsEqxWu" ;

    //entity 管理类接口实现 entity 的创建、更新、删除、查询
    public static final String YINGYAN_ENTITY_URL = "http://yingyan.baidu.com/api/v3/entity" ;
    public static final String ENTITY_ADD = "/add" ;//创建entity，并赋属性信息
    public static final String ENTITY_DELETE = "/delete" ;//删除entity
    public static final String ENTITY_UPDATE = "/update" ;//更新entity
    public static final String ENTITY_LIST = "/list" ;//检索符合过滤条件的entity，返回entity属性信息和最新位置

    public static final String ENTITY_SEARCH = "/search" ;//根据关键字搜索entity
    public static final String ENTITY_BOUNDSEARCH = "/boundsearch" ;//根据矩形范围搜索entity
    public static final String ENTITY_AROUNDSEARCH = "/aroundsearch" ;//周边搜索，根据圆心和半径搜索entity
    public static final String ENTITY_POLYGONSEARCH = "/polygonsearch" ;//多边形搜索，搜索多边形范围内的entity
    public static final String ENTITY_DISTRICTSEARCH = "/districtsearch" ;//行政区搜索，搜索中国范围内、国家、省、市、区/县中的entity

    /*轨迹点上传类接口支持开发者实时上传单个或批量轨迹点*/

    public static final String YINGYAN_TRACE_URL = "http://yingyan.baidu.com/api/v3/track" ;
    //上传单个轨迹点
    public static String TRACE_ADDPOINT = "/addpoint" ;
    //批量上传多个entity的多个轨迹点。 1、轨迹点采用json格式 2、一次请求可上传多个entity的轨迹点，而非一个entity的多个轨迹点
    public static final String TRACE_ADDPOINTS = "/addpoints" ;
    public static final String TRACE_GETLATESTPOINT = "/getlatestpoint" ;//查询某entity的实时位置，支持纠偏
    public static final String TRACE_GETDISTANCE = "/getdistance" ;//查询某entity一段时间内的轨迹里程，支持纠偏
    public static final String TRACE_GETTRACK = "/gettrack" ;//查询某entity一段时间内的轨迹点，支持纠偏

    /*鹰眼轨迹分析接口是一套开发者自有轨迹数据挖掘的接口服务*/

    public static final String YINGYAN_ANALYSIS_URL= "http://yingyan.baidu.com/api/v3/analysis" ;
    public static final String ANALYSIS_STAYPOINT = "/staypoint" ;//停留点分析
    public static final String ANALYSIS_DRIVINGBEHAVIOUR = "/drivingbehaviour" ;//驾驶行为分析

    /*围栏管理类接口包括圆形、多边形、线型、行政区划4类围栏的增、删、改、查接口*/
    public static final String YINGYAN_FENCE_URL = "http://yingyan.baidu.com/api/v3/fence" ;
    public static final String FENCE_CREATECIRCLEFENCE="/createcirclefence" ; //创建圆形围栏
    public static final String FENCE_CREATEPOLYGONFENCE="/createpolygonfence" ;//创建多边形围栏
    public static final String FENCE_CREATEPOLYLINEFENCE="/createpolylinefence" ;//创建线性围栏
    public static final String FENCE_CREATEDISTRICTFENCE="/createdistrictfence" ;//创建行政区域围栏
    public static final String FENCE_UPDATECIRCLEFENCE="/updatecirclefence" ;//更新圆形围栏
    public static final String FENCE_UPDATEPOLYGONFENCE="/updatepolygonfence" ;//更新多边形围栏
    public static final String FENCE_UPDATEPOLYLINEFENCE="/updatepolylinefence" ;//更新线性围栏
    public static final String FENCE_UPDATEDISTRICTFENCE="/updatedistrictfence" ;//更新行政区域围栏
    public static final String FENCE_DELETE="/delete" ;//删除围栏
    public static final String FENCE_LIST="/list" ;//查询围栏信息
    public static final String FENCE_QUERYSTATUS="/querystatus" ;//查询监控对象在围栏内外
    public static final String FENCE_HISTORYALARM="/historyalarm" ;//查询监控对象的历史报警信息
    public static final String FENCE_BATCHHISTORYALARM="/batchhistoryalarm" ;//批量查询某service下时间段内的所有报警信息，用于服务端报警同步






}
