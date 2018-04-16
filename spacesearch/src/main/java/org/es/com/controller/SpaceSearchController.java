package org.es.com.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.es.com.index.ESSpaceSearchIndex;
import org.es.com.utils.Conf;
import org.es.com.utils.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/es-operator")
public class SpaceSearchController {
    public static Logger logger = LoggerFactory.getLogger(SpaceSearchController.class);

    /**
     * method:importdata.do
     * description: 批量导入数据
     * date: 2017/12/4 17:49
     * param:dataset 索引
     * param:geomData 数据集
     */
    @RequestMapping("/importdata.do")
    public ResponseEntity<String> importdata(Map<String, Object> model, @RequestParam("dataset") String dataset, @RequestParam("geomData") String geomData) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug(geomData);
        }
        Map<String, Object> resultMap = new HashMap<String, Object>();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        try {
            logger.info("请求参数：{}", GsonUtil.objToStr("geomData=" + geomData));
            ESSpaceSearchIndex index = new ESSpaceSearchIndex();
            JSONArray array = JSONArray.fromObject(geomData);
            for (Object o : array) {
                JSONObject object = (JSONObject) o;
                Object[] header = object.keySet().toArray();
                Object[] data = object.values().toArray();
                String id = object.getString(Conf.IMPORT_GEO_ID);
                String geom = object.getString(Conf.INDEX_GEO_FIELDS);
                if (StringUtils.isNotEmpty(geom) && StringUtils.isNotEmpty(id)) {
                    index.importPointData(dataset, id, geom, header, data);
                }
            }
            index.commite();
            resultMap.put("msg", "插入数据成功！");
            resultMap.put("success", "true");
            logger.info("返回参数：{}", GsonUtil.objToStr(resultMap.toString()));

        } catch (Exception e) {
            resultMap.put("插入数据异常:", e.getMessage());
        }
        return new ResponseEntity<String>(resultMap.toString(), headers, HttpStatus.OK);
    }

    //根据起始时间和结束时间删除数据
    @RequestMapping("/deleteData.do")
    public ResponseEntity<String> deleteData(Map<String, Object> model, @RequestParam("dataset") String dataset, @RequestParam("fromDate") String fromdate, @RequestParam("toDate") String toDate) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fd = sdf.parse(fromdate);
            Date td = sdf.parse(toDate);
            ESSpaceSearchIndex index = new ESSpaceSearchIndex();
            //index.deleteData(dataset, fd, td);
            resultMap.put("msg", "删除数据成功！");
            resultMap.put("success", true);

        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("msg", "删除数据异常！");
            resultMap.put("success", false);
            logger.error("删除数据异常：{}", e.getMessage());
        }
        return new ResponseEntity<String>(resultMap.toString(), headers, HttpStatus.OK);
    }

    /**
     * method: deleteDataStr.do
     * description: 删除时间范围内的数据
     * date: 2017/12/4 17:26
     * param:fromDate 起始时间
     * param:toDate 结束时间
     */
    @RequestMapping(value = "/deleteDataStr.do")
    public ResponseEntity<String> deleteDataStr(Map<String, Object> model, @RequestParam("dataset") String dataset, @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        try {
            logger.info("请求参数：{}", GsonUtil.objToStr("fromDate:" + fromDate + ",toDate:" + toDate));
            ESSpaceSearchIndex index = new ESSpaceSearchIndex();
            index.deleteDateStr(dataset, fromDate, toDate);
            resultMap.put("msg", "删除数据成功!");
            resultMap.put("success", true);
            logger.info("返回参数:{}", GsonUtil.objToStr(resultMap.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("msg", "删除数据异常");
            resultMap.put("success", false);
            logger.error("删除数据异常：{}", e.getMessage());
        }
        return new ResponseEntity<String>(resultMap.toString(), headers, HttpStatus.OK);
    }

    /**
     * method:deleteDateById.do
     * description:  根据ID删除数据
     * date: 2017/12/4 17:31
     * param:dataset 索引
     * param:id 指定ID
     */
    @RequestMapping(value = "/deleteDateById.do")
    public ResponseEntity<String> deleteDateById(Map<String, Object> model, @RequestParam("dataset") String dataset, @RequestParam("id") String id) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        try {
            logger.info("请求参数:{}", GsonUtil.objToStr("dataset:" + dataset + ",id=" + id));
            ESSpaceSearchIndex index = new ESSpaceSearchIndex();
            index.deleteData(dataset, id);
            resultMap.put("msg", "删除数据成功!");
            resultMap.put("success", true);
            logger.info("返回参数：{}", GsonUtil.objToStr(resultMap.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("msg", "删除数据异常！");
            resultMap.put("success", false);
            logger.error("删除数据异常：{}", e.getMessage());
        }
        return new ResponseEntity<String>(resultMap.toString(), headers, HttpStatus.OK);
    }

    /**
     * method: createIndex.do
     * description:创建索引及字段
     * date: 2017/12/5 11:01
     * param:dataset 索引
     * param:index  数据集
     */

    @RequestMapping(value = "/createIndex.do")
    public ResponseEntity<String> createIndex(Map<Model, String> model, @RequestParam(value = "dataset", required = false, defaultValue = "kxtx.history.geomery") String dataset,
                                              @RequestParam(value = "index", required = true) String index) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        try {
            logger.info("请求参数：{}", GsonUtil.objToStr("dataset:" + dataset + ",index:" + index));
            ESSpaceSearchIndex searchIndex = new ESSpaceSearchIndex();
            searchIndex.createIndex(index, dataset,"");
            searchIndex.commite();
            resultMap.put("msg", "创建索引成功！");
            resultMap.put("success", true);
            logger.info("返回参数：{}", GsonUtil.objToStr(resultMap.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("msg", "创建索引异常！");
            resultMap.put("success", false);
            logger.error("创建索引异常：{}", e.getMessage());
        }
        return new ResponseEntity<String>(resultMap.toString(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/insertData.do")
    public ResponseEntity<String> insertData(Map<Model, String> model, @RequestParam(value = "dataset", required = false, defaultValue = "kxtx.history.geomery") String dataset,
                                             @RequestParam(value = "index", required = true) String index, @RequestParam(value = "id", required = false) String id, @RequestParam(value = "keyword", required = false) String keyword) {

            Map<String, Object> resultMap = new HashMap<String, Object>();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json;charset=utf-8");
            try {
                logger.info("请求参数：{}",GsonUtil.objToStr("dataset:"+dataset+",index:"+index+",id:"+id+",keyword:"+keyword));
                ESSpaceSearchIndex esSpaceSearchIndex = new ESSpaceSearchIndex() ;
                JSONObject object = JSONObject.fromObject(keyword) ;
                Object[] header = object.keySet().toArray();
                Object[] data = object.values().toArray();
                esSpaceSearchIndex.insert(dataset,id,header,data);
                esSpaceSearchIndex.commite();
                resultMap.put("msg","插入数据成功！") ;
                resultMap.put("success",true) ;
                logger.info("返回参数：{}",GsonUtil.objToStr(resultMap.toString()));
            }catch (Exception e){
                e.printStackTrace();
                resultMap.put("msg","插入数据异常") ;
                resultMap.put("success",false) ;
                logger.error("插入数据异常：{}",e.getMessage());
            }
            return new ResponseEntity<String>(resultMap.toString(),headers,HttpStatus.OK) ;

    }


}
