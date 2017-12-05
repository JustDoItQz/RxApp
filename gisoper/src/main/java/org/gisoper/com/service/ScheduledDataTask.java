package org.gisoper.com.service;

import org.common.com.redis.RedisOper;
import org.gisoper.com.task.Task1;
import org.gisoper.com.task.Task2;
import org.gisoper.com.task.Task3;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("locationService")
public class ScheduledDataTask {

    private Runnable t1;
    private Runnable t2;
    private Runnable t3;
    private ExecutorService pool;

    public void workTask() {

        t1 = new Task1();
        t2 = new Task2();
        t3 = new Task3();

        pool = Executors.newFixedThreadPool(3);
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);

        pool.shutdown();

    }

    public void startTask() {
        RedisOper.save("TaskA","Y");
    }
}