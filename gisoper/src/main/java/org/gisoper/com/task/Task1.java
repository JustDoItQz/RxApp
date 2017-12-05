package org.gisoper.com.task;

import org.common.com.redis.RedisOper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Task1 implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(Task1.class) ;
    @Override
    public void run() {
        System.out.println("------定时任务1开始执行-----------");
    }


}
