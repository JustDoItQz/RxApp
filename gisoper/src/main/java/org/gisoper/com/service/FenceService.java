package org.gisoper.com.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.common.com.constant.ConstantUtils;
import org.common.com.constant.SystemConstant;
import org.common.com.dao.MyBatisDao;
import org.common.com.utils.DateUtils;
import org.common.com.utils.GsonUtil;
import org.common.com.utils.HttpclientUtil;
import org.common.com.utils.MapDistance;
import org.gisoper.com.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class FenceService {

    private static Logger logger = LoggerFactory.getLogger(FenceService.class) ;

    @Autowired
    private MyBatisDao myBatisDao ;

    public void triggerFence(){

        List<VehiclePosition> positionList = getVehiclePhsition() ;
        List<LoadBillVo> loadBillVoList = getLoadBill(positionList) ;
        List<WebsitePointVo> websitePointVoList = getWebsiteList() ;
        for (LoadBillVo loadBillVo:loadBillVoList){
            try{
                String vehicleNo = loadBillVo.getVehicleNo() ;
                String status = loadBillVo.getStatus() ;
                String loadId = loadBillVo.getLoadingId() ;
                List<VehiclePosition> listVehicleOnly = getVehicleByNo(positionList,vehicleNo) ;
                if (status.equals("12")){//触发发车
                    String departurePointId = loadBillVo.getDeparturePointId() ;
                    WebsitePointVo pointVo = getWebsitePoint(websitePointVoList,departurePointId) ;
                    Map<String,Object> map = istrigger(listVehicleOnly,pointVo,1) ;
                    boolean isTrigger = (Boolean) map.get("isTrigger") ;
                    String triggerTime = (String) map.get("triggerTime") ;
                    String vehiclePhone = (String) map.get("vehiclePhone") ;
                    String vehicleNum = (String) map.get("vehicleNum") ;
                    if (isTrigger){
                        //保存到数据库
                        Map<String,String> mapTrigger = new HashMap<String, String>() ;
                        mapTrigger = sendFence(loadId,departurePointId,triggerTime) ;
                        saveDBLog(mapTrigger,1,vehicleNum,vehiclePhone) ;//保存到数据库
                    }
                }else if (status.equals("13")){//触发签到
                    List<String> list_point = loadBillVo.getArrivePointId() ;
                    if (list_point!=null&&list_point.size()>0){
                        for (String arrivePointId:list_point){
                            WebsitePointVo websitePointVo = getWebsitePoint(websitePointVoList,arrivePointId) ;
                            Map<String,Object> map = istrigger(listVehicleOnly,websitePointVo,2) ;
                            boolean isTrigger = (Boolean) map.get("isTrigger") ;
                            String triggerTime = (String) map.get("triggerTime") ;
                            String vehiclePhone = (String) map.get("vehiclePhone") ;
                            String vehicleNum = (String) map.get("vehicleNum") ;
                            if (isTrigger){
                                //保存到数据库
                                Map<String,String> mapTrigger = new HashMap<String, String>() ;
                                mapTrigger = fenceSign(loadId,arrivePointId,triggerTime) ;
                                saveDBLog(mapTrigger,2,vehicleNum,vehiclePhone);
                            }
                        }
                    }
                }
            }catch (Exception e){
                continue;
            }

        }
        System.out.println("--------------------------电子围栏end------------------------------");

    }

    public void fenceCompensate(){
        Map<String,String> map = new HashMap<String, String>() ;
        List<TriggerLog> list = getByStatusAndTimes(2,3) ;
        for (TriggerLog log:list){
            try{
                int type = log.getTriggerType() ;
                String loadingId = log.getLoadingId() ;
                String routeId = log.getRouteId() ;
                String triggerTime = DateUtils.convert(log.getTriggerTime()) ;
                if (type==1){
                    map = sendFence(loadingId,routeId,triggerTime) ;
                }else {
                    map = fenceSign(loadingId,routeId,triggerTime) ;
                }
                int times = log.getTimes()+1 ;
                int triggerStatus = Integer.parseInt(map.get("triggerStatus")) ;
                log.setTimes(times);
                log.setTriggerStatus(triggerStatus);
                log.setLasteTime(new Date());
                triggerStatusUpdate(log);
            }catch (Exception e){
                continue;
            }
        }
        System.out.println("------------电子围栏补偿机制执行结束-------------");
    }

    public List<VehiclePosition> getVehiclePhsition(){
        List<VehiclePosition> list = new ArrayList<VehiclePosition>() ;

        return list ;
    }
    public List<LoadBillVo> getLoadBill(List<VehiclePosition> listposition){
        List<LoadBillVo> list = new ArrayList<LoadBillVo>() ;

        return list ;
    }
    public List<WebsitePointVo> getWebsiteList(){
        List<WebsitePointVo> list = new ArrayList<WebsitePointVo>() ;

        return list ;
    }
    private List<VehiclePosition> getVehicleByNo(List<VehiclePosition> list,String vehicleNo){
        List<VehiclePosition> temp = new ArrayList<VehiclePosition>() ;
        for (VehiclePosition vehiclePosition:list){
            if (vehicleNo.equals(vehiclePosition.getVehiclenum())){
                temp.add(vehiclePosition) ;
            }
        }
        Collections.sort(temp, new Comparator<VehiclePosition>() {
            @Override
            public int compare(VehiclePosition o1, VehiclePosition o2) {

                return 0;
            }
        });

        return temp ;
    }

    private WebsitePointVo getWebsitePoint(List<WebsitePointVo> list,String id){

        for (WebsitePointVo websitePointVo:list){
            if (id.endsWith(websitePointVo.getId())){
                return websitePointVo ;
            }
        }
        return null ;
    }
    public Map<String,Object> istrigger(List<VehiclePosition> list, WebsitePointVo pointVo, int type){
        Map<String,Object> map = new HashMap<String, Object>() ;
        boolean isTrigger= false ;
        String triggerTime ="" ;
        String vehicleNum = "" ;
        String vehiclePhone = "" ;
        map.put("isTrigger",isTrigger) ;
        map.put("triggerTime",triggerTime) ;
        if (pointVo==null){
            return map ;
        }

        String lat1 = pointVo.getLat() ;
        String lng1 = pointVo.getLng() ;
        String lat2 = pointVo.getLat2() ;
        String lng2 = pointVo.getLng2() ;

        boolean flag1 = false ;
        boolean flag2 = false ;
        String lat1Str = "" ;
        String lng1Str = "" ;

        if (StringUtils.isNotBlank(lat1)&&StringUtils.isNotBlank(lng1)&&lat1!="0"&&lng1!="0"){
            flag1 = true ;
        }
        if (StringUtils.isNotBlank(lat2)&&StringUtils.isNotBlank(lng2)&&lat2!="0"&&lat2!="0"){
            flag2 = true ;
        }
        if (flag1==false&&flag2==false){
            return map ;
        }

        if (flag2){
            lat1Str = lat2 ;
            lng1Str = lng2 ;
        }else{
            lat1Str = lat1 ;
            lng1Str = lng1 ;
        }
        double radius = 1 ;//触发区域半径1 km
        if (pointVo.getWebsiteType()==14){//枢纽类型
            radius = 2 ;
        }
        if (type==1||type==2){
            for (VehiclePosition vehiclePosition:list){
                String lat2Str = vehiclePosition.getVahiclelat() ;
                String lng2Str = vehiclePosition.getVahiclelng() ;
                double distance = MapDistance.GetDistance(lng1Str,lat1Str,lat2Str,lng2Str) ;
                if (type==1){//发车
                    if (distance>=radius){
                        isTrigger=true ;
                        triggerTime = vehiclePosition.getVahicletime() ;
                        vehiclePhone = vehiclePosition.getVehiclephone() ;
                        vehicleNum = vehiclePosition.getVehiclenum() ;
                        break;
                    }
                }else if (type==2){
                    if (distance<=radius){
                        isTrigger = true ;
                        triggerTime = vehiclePosition.getVahicletime() ;
                        vehiclePhone = vehiclePosition.getVehiclephone() ;
                        vehicleNum = vehiclePosition.getVehiclenum() ;
                        break;
                    }
                }
            }

        }else {
            return map ;
        }

        logger.info("是否触发：{}",isTrigger);
        map.put("isTrigger",isTrigger) ;
        map.put("triggerTime",triggerTime) ;
        map.put("vehiclePhone",vehiclePhone) ;
        map.put("vehicleNum",vehicleNum) ;

        return map ;
    }
    public Map<String,String> sendFence(String loadId,String departurePointId,String triggerTime){
        Map<String,String> map = new HashMap<String, String>() ;

        return map ;
    }
    public void saveDBLog(Map<String,String> map,int type,String vehicleNum,String vehicelPhone){

    }
    public Map<String,String> fenceSign(String loadId,String arrivePonitId,String triggerTime){
        Map<String,String> map = new HashMap<String, String>() ;

        return map ;
    }
    private List<TriggerLog> getByStatusAndTimes(int status,int times){
        List<TriggerLog> logList = new ArrayList<TriggerLog>() ;
        Map<String,Object> map = new HashMap<String, Object>() ;
        map.put("triggerStatus",status) ;
        map.put("times",times) ;
        logList = myBatisDao.getList("","") ;

        return logList ;
    }

    private void triggerStatusUpdate(TriggerLog triggerLog){

        myBatisDao.update("",triggerLog);
    }

    //创建电子围栏
    public String createFence(String request){
        Map<String,Object> resultMap = new HashMap<String, Object>() ;
        Map<String,String> paramMap = new HashMap<String, String>() ;
        CreateFenceVo.Response responseVo = new CreateFenceVo.Response() ;
        if (StringUtils.isNotBlank(request)){
            CreateFenceVo.Request requestVo = GsonUtil.strToObj(request, CreateFenceVo.Request.class) ;
            if (StringUtils.isNotBlank(requestVo.getName())){

                paramMap.put("name",requestVo.getName()) ;
                if (StringUtils.isNotBlank(requestVo.getCenter())){
                    paramMap.put("center",requestVo.getCenter()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getRadius())){
                    paramMap.put("radius",requestVo.getRadius()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getEnable())){
                    paramMap.put("enable",requestVo.getEnable()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getValid_time())){
                    paramMap.put("valid_time",requestVo.getValid_time()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getRepeat())){
                    paramMap.put("repeat",requestVo.getRepeat()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getDesc())){
                    paramMap.put("desc",requestVo.getDesc()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getAlert_condition())){
                    paramMap.put("alert_condition",requestVo.getAlert_condition()) ;
                }
                String url = ConstantUtils.GAODE_URL+ConstantUtils.GEOFENCE_URL+"?key="+ SystemConstant.getGAODE_KEY();
                String paramObject = JSONObject.fromObject(paramMap).toString() ;
                String result = HttpclientUtil.postJson(url,paramObject) ;
                if (StringUtils.isNotBlank(result)){
                    JSONObject object = JSONObject.fromObject(result) ;
                    if (object!=null&&object.size()>0){
                        JSONObject data = object.getJSONObject("data") ;
                        String gid = data.getString("gid") ;
                        String id = data.getString("id") ;
                        String message = data.getString("message") ;
                        responseVo.setGid(gid);
                        responseVo.setId(id);
                        responseVo.setMessage(message);
                        resultMap.put("data",responseVo) ;
                        resultMap.put("message","创建电子围栏成功！") ;

                    }
                }
            }else {
                resultMap.put("msg","围栏名称不能为空！") ;
            }

        }else{
            resultMap.put("msg","请求参数不能为空！") ;
        }
        return GsonUtil.objToStr(resultMap) ;
    }

    //查询电子围栏
    public String queryFence(HttpServletRequest request){
        Map<String,Object> resultMap = new HashMap<String, Object>() ;
        Map<String,String> paramMap = new HashMap<String, String>() ;
        List<QuaryFenceVo.Response> responseList = new ArrayList<QuaryFenceVo.Response>() ;
        String id = request.getParameter("id") ;
        String gid= request.getParameter("gid") ;
        String name= request.getParameter("name") ;
        String page_no = request.getParameter("page_no") ;
        String page_size = request.getParameter("page_size") ;
        String enable = request.getParameter("enable") ;
        Boolean enables = Boolean.parseBoolean(enable) ;
        String start_time = request.getParameter("start_time") ;
        String end_time = request.getParameter("end_time") ;
        if (StringUtils.isNotBlank(id)||StringUtils.isNotBlank(gid)||StringUtils.isNotBlank(name)){
            if (StringUtils.isNotBlank(id)){
                paramMap.put("id",id) ;
            }
            if (StringUtils.isNotBlank(gid)){
                paramMap.put("gid",gid) ;
            }
            if (StringUtils.isNotBlank(name)){
                paramMap.put("name",name) ;
            }
            if (StringUtils.isNotBlank(page_no)){
                paramMap.put("page_no",page_no) ;
            }
            if (StringUtils.isNotBlank(page_size)){
                paramMap.put("page_size",page_size) ;
            }
            /*if (StringUtils.isNotBlank(enable)){
                paramMap.put("enable",enables) ;
            }*/
            if (StringUtils.isNotBlank(start_time)){
                paramMap.put("start_time",start_time) ;
            }
            if (StringUtils.isNotBlank(end_time)){
                paramMap.put("end_time",end_time) ;
            }
            if (StringUtils.isNotBlank(gid)){
                paramMap.put("gid",gid) ;
            }
            String url = ConstantUtils.GAODE_URL+ConstantUtils.GEOFENCE_URL+"?key="+SystemConstant.getGAODE_KEY() ;
            String result = "" ;
            if (paramMap!=null&&paramMap.size()>0){
                result = HttpclientUtil.sendGet(url,JSONObject.fromObject(paramMap).toString()) ;
            }else{
                result= HttpclientUtil.getMSG(url) ;
            }
            if (StringUtils.isNotBlank(result)){
                JSONObject object = JSONObject.fromObject(result) ;
                if (object!=null&&object.size()>0){
                    QuaryFenceVo.Response responseVo = new QuaryFenceVo.Response() ;
                    JSONObject data = object.getJSONObject("data") ;
                    String errCode = object.getString("errcode") ;
                    String errmsg = object.getString("errmsg") ;
                    if (data!=null&&data.size()>0){
                        JSONArray array = data.getJSONArray("rs_list") ;
                        String total_records = data.getString("total_record") ;
                        responseVo.setTotal_record(total_records);
                        responseVo.setErrcode(errCode);
                        responseVo.setErrmsg(errmsg);
                        if (array!=null&&array.size()>0){
                            for (int i=0;i<array.size();i++){
                                JSONObject jsonObject = array.getJSONObject(i) ;
                                String adcode = jsonObject.getString("adcode") ;
                                String alert_condition = jsonObject.getString("alert_condition") ;
                                String create_time = jsonObject.getString("create_time") ;
                                String enabless = jsonObject.getString("enable") ;
                                String fixed_date = jsonObject.getString("fixed_date") ;
                                String gids = jsonObject.getString("gid") ;
                                String ids = jsonObject.getString("id") ;
                                String names = jsonObject.getString("name") ;
                                String radiuss = jsonObject.getString("radius") ;
                                String repeats = jsonObject.getString("repeat") ;
                                String times = jsonObject.getString("time") ;
                                String valid_times = jsonObject.getString("valid_time") ;
                                responseVo.setAdcode(adcode);
                                responseVo.setAlert_condition(alert_condition);
                                responseVo.setCreate_time(create_time);
                                responseVo.setEnable(enabless);
                                responseVo.setFixed_date(fixed_date);
                                responseVo.setGid(gids);
                                responseVo.setId(ids);
                                responseVo.setName(names);
                                responseVo.setRedius(radiuss);
                                responseVo.setRepeat(repeats);
                                responseVo.setTime(times);
                                responseVo.setValid_time(valid_times);
                                responseList.add(responseVo) ;
                            }
                        }
                    }
                }
                resultMap.put("data",responseList) ;
            }
        }else{
            resultMap.put("msg","查询参数不能为空！") ;
        }

        return GsonUtil.objToStr(resultMap) ;
    }

    //更新电子围栏
    public String updateFence(String request){
        Map<String,Object> resultMap = new HashMap<String, Object>() ;
        Map<String,String> paramMap = new HashMap<String, String>() ;
        if (StringUtils.isNotBlank(request)){
            UpdateFenceVo.Request requestVo = GsonUtil.strToObj(request,UpdateFenceVo.Request.class) ;
            if (StringUtils.isNotBlank(requestVo.getGid())){
                if (StringUtils.isNotBlank(requestVo.getCenter())){
                    paramMap.put("center",requestVo.getCenter()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getRadius())){
                    paramMap.put("radius",requestVo.getRadius()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getEnable())){
                    paramMap.put("enable",requestVo.getEnable()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getValid_time())){
                    paramMap.put("valid_time",requestVo.getValid_time()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getRepeat())){
                    paramMap.put("repeat",requestVo.getRepeat()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getDesc())){
                    paramMap.put("desc",requestVo.getDesc()) ;
                }
                if (StringUtils.isNotBlank(requestVo.getName())){
                    paramMap.put("name",requestVo.getName()) ;
                }

                String url = ConstantUtils.GAODE_URL+ConstantUtils.GEOFENCE_URL+"?key="+ SystemConstant.getGAODE_KEY()+"&gid="+requestVo.getGid();
                String paramObject = JSONObject.fromObject(paramMap).toString() ;
                String result = HttpclientUtil.postJson(url,paramObject) ;
                if (StringUtils.isNotBlank(result)){
                    resultMap.put("data",result) ;
                }
            }
        }
        return GsonUtil.objToStr(resultMap) ;
    }



}
