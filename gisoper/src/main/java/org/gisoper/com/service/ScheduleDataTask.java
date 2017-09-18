package org.gisoper.com.service;

import org.common.com.dao.MyBatisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleDataTask {

    @Autowired
    private MyBatisDao myBatisDao ;

    //执行定时任务
    public void workTask(){

    }
}
