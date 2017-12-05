package org.gisoper.com.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task2 implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(Task2.class) ;

    @Override
    public void run() {
        logger.info("------定时任务2开始执行-----------");
    }
}
