package org.gisoper.com.controller;

import net.sf.json.JSONObject;
import org.common.com.redis.RedisOper;
import org.gisoper.com.es.SpaceSearch;
import org.gisoper.com.vo.AccountRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by on 2017/6/26.
 * Author Aaron.Wang
 */
@Controller
@RequestMapping("/es")
public class SpaceSearchController {
    private static Logger logger = LoggerFactory.getLogger(SpaceSearchController.class) ;

    @Autowired
    private SpaceSearch searchService ;

    @RequestMapping("/querySearch")
    @ResponseBody
    private String querySearch(@ModelAttribute AccountRequest request){

        logger.info("请求参数{}", JSONObject.fromObject(request).toString());
        String result = null ;
        try {
            result = searchService.querySearch(request) ;
            if (!RedisOper.existsKey("Ratliff")){
                RedisOper.save("Ratliff",request);
                logger.info("redis插入数据成功!");
            }
            logger.info("查询es数据：{}",request);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询es数据失败:{}",e.getMessage());
        }

        logger.info("返回参数{}",request);

        return result ;
    }



}
