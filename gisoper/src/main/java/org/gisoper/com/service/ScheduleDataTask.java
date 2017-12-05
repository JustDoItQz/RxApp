package org.gisoper.com.service;

import org.common.com.dao.MyBatisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ScheduleDataTask {

    @Autowired
    private MyBatisDao myBatisDao ;

    private Runnable t1;
    private Runnable t2;

    private ExecutorService pool;

    //执行定时任务
    public void workTask() {
        t1 = new Runnable() {
            @Override
            public void run() {
            }
        };
        t2 = new Runnable() {
            @Override
            public void run() {

            }
        } ;

        pool = Executors.newFixedThreadPool(2) ;
        pool.submit(t1) ;
        pool.submit(t2) ;

    }

}
