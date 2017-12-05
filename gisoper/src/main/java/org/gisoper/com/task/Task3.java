package org.gisoper.com.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task3 implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(Task3.class) ;

    @Override
    public void run() {
        logger.info("------定时任务3开始执行-----------");
    }
}
