package org.gisoper.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by on 2017/7/5.
 * Author Aaron.Wang
 */
@Controller
@RequestMapping("/push")
public class JPushController {

    /**
     *  推送消息到安卓设备
     * @param
     * @return
     */
    @RequestMapping(value = "/SendMsgToAndroid.do",method = RequestMethod.GET)
    public void SendMsgToAndroid(){

    }
    /**
     *  推送消息到IOS设备
     * @param
     * @return
     */

    @RequestMapping(value = "/SendMsgToIos.do",method = RequestMethod.GET)
    public void SendMsgToIos(){


    }


}
