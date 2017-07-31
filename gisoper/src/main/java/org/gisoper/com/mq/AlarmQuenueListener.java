package org.gisoper.com.mq;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by on 2017/7/27.
 * Author Aaron.Wang
 */
public class AlarmQuenueListener  {

    private static Logger logger = LoggerFactory.getLogger(AlarmQuenueListener.class) ;

    public void onMessageDB(Object object) throws Exception{

        JSONObject.fromObject(object).toString() ;
        logger.info("获取到MQ数据DB:"+object);

    }
    public void onMessageES(Object object) throws Exception{

        logger.info("获取到MQ数据ES:"+object);


    }
}
