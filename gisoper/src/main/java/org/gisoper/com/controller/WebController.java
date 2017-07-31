package org.gisoper.com.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by on 2017/6/23.
 * Author Aaron.Wang
 */
@Controller
@RequestMapping("/page")
public class WebController {

    @RequestMapping(value = "/keywordserach.do" ,method = RequestMethod.GET)
    public ModelAndView keywordserach(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("keywordserach") ;

        return view ;
    }
    @RequestMapping(value = "/error.do",method = RequestMethod.GET)
    public ModelAndView error(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("admin/400") ;

        return view ;
    }

}
