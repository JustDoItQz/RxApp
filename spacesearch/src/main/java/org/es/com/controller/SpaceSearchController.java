package org.es.com.controller;

import net.sf.json.JSONObject;
import org.es.com.es.SpaceSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Created by on 2017/6/27.
 * Author Aaron.Wang
 */
@Controller
public class SpaceSearchController {
    private static Logger logger = LoggerFactory.getLogger(SpaceSearchController.class) ;

    @Autowired
    private SpaceSearch searchService ;

    @RequestMapping("/querySearch.do")
    private ResponseEntity<String> querySearch(@RequestParam(value = "request") String request, @RequestParam(value = "index", required = false,defaultValue = "account")String index){

        logger.info("请求参数{}", JSONObject.fromObject(request).toString());
        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        String result = null ;
        try {
            result = searchService.querySearch(request,index) ;
            logger.info("查询es数据：{}",result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("返回参数{}",result);

        return new ResponseEntity<String>(result,headers, HttpStatus.OK) ;
    }

}
