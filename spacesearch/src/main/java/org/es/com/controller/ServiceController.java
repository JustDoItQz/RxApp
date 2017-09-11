package org.es.com.controller;

import org.apache.commons.lang.StringUtils;
import org.es.com.constant.Config;
import org.es.com.spacesearch.ESSpaceSearch;
import org.es.com.spacesearch.SpaceSearch;
import org.es.com.utils.DateUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @RequestMapping(value = "/searchVehicleInfoByVehicleNum.do")
    public ResponseEntity<String> searchVehicleInfoByVehicleNum(Map<Model,String> model, @RequestParam(value = "dataset",required = false,defaultValue = "kxtx.truckinfo")String dataset,@RequestParam(value = "keyword",required = true)String keyword)
    {
        String result = null ;
        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json;chatset=utf-8");
        try{
            SpaceSearch search = new ESSpaceSearch() ;
            result = search.searchKeyword(keyword,dataset) ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>(result.toString(),headers, HttpStatus.OK) ;
    }

    @RequestMapping(value = "/searchHistoryTrace.do")
    public ResponseEntity<String> searchHistoryTrace(Map<Model,String> model, @RequestParam(value = "dataset",required = false,defaultValue = "kxtx.history.geomery")String dataset,@RequestParam(value = "keyword",required = true)String keyword,@RequestParam(value = "page",required = false) String page,@RequestParam(value = "pagesize",required = false) String pagesize,@RequestParam(value = "startTime")String startTime,@RequestParam(value = "endTime")String endTime){
        String result = null ;
        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json;charset=utf-8");
        try{
            SpaceSearch search = new ESSpaceSearch() ;
            int pageno=Integer.parseInt(page) ;
            int pagesizes = Integer.parseInt(pagesize) ;
            if (StringUtils.isNotBlank(startTime)){
                Calendar calendar = Calendar.getInstance() ;
                calendar.add(Calendar.DATE,-1);
                startTime = DateUtil.dateToStr(calendar.getTime(),"yyyy-MM-dd HH:mm:ss") ;
            }
            if (StringUtils.isNotBlank(endTime)){
                endTime = DateUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss") ;
            }
            result = search.searchKeyword(keyword,dataset, Config.INDEX_GEO_TIME,startTime,endTime,pageno,pagesizes) ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>(result.toString(),headers,HttpStatus.OK) ;
    }
    @RequestMapping(value = "/searchLastLocation.do")
    public ResponseEntity<String> searchLastLocation(Map<String,Object> model, @RequestParam(value = "dataset",required = false,defaultValue = "kxtx.history.geomery")String dataset,
                                                     @RequestParam(value = "keyword",required = true)String keyword){
        String result = null ;
        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json;charset=utf-8");
        SpaceSearch search = new ESSpaceSearch() ;
        try{
            /*JSONArray array = JSONArray.fromObject(keyword) ;
            List<String> list = new ArrayList<String>() ;
            for (Object o:array){
                list.add(array.toString()) ;
            }*/
            String[] list = keyword.split(",") ;
            search.vehicleLastLocation(list,dataset) ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>(result.toString(),headers,HttpStatus.OK) ;
    }

    @RequestMapping("/searchGeometryNearBy.do")
    public ResponseEntity<String> searchGeometryNearBy(Map<String,Object> model, @RequestParam(value = "dataset",required = false,defaultValue = "kxtx.history.geomery")String dataset,
                                                       @RequestParam(value = "keyword",required = true)String keyword,@RequestParam(value = "page",required = false) String page,
                                                       @RequestParam(value = "pagesize",required = false) String pagesize,@RequestParam(value = "distance")String distance,
                                                       @RequestParam(value = "lon")String lon,@RequestParam(value = "lat")String lat){
        String result = null ;
        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json;charset=utf-8");
        SpaceSearch search = new ESSpaceSearch() ;
        try{
            result = search.searchGeometryNearBy(Double.parseDouble(lon),Double.parseDouble(lat),distance,keyword,dataset,page,pagesize) ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>(result.toString(),headers,HttpStatus.OK) ;
    }

    @RequestMapping("/deleteWebsiteById.do")
    public ResponseEntity<String> deleteWebsiteById(){
        String result = null ;
        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json;charset=utf-8");

        return new ResponseEntity<String>(result,headers,HttpStatus.OK) ;
    }


}
