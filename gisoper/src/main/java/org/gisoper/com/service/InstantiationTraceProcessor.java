package org.gisoper.com.service;

import org.common.com.redis.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by on 2017/6/23.
 * Author Aaron.Wang
 */
public class InstantiationTraceProcessor implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LoggerFactory.getLogger(InstantiationTraceProcessor.class) ;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (event.getApplicationContext().getParent()==null){
            //redis初始化
            RedisClient.init();
            onApplicationEvent();
        }

    }
    public void onApplicationEvent() {

        logger.info("开始初始化地址库！");
        long start = System.currentTimeMillis() ;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                //执行所有耗时操作
                try {
                    /*initBaseLocalCode () ;*/
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("地址库初始化失败！");
                }

            }
        }) ;

        t.start();
        long end = System.currentTimeMillis() ;
        long useTime = (start-end)/1000 ;

        logger.info("初始化地址库耗时:{}毫秒",useTime);

    }



}