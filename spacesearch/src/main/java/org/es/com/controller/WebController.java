package org.es.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by on 2017/6/28.
 * Author Aaron.Wang
 */
@Controller
@RequestMapping("/page")
public class WebController {

    private Logger logger = LoggerFactory.getLogger(WebController.class) ;

    @RequestMapping(value = "/keywordserach.do" ,method = RequestMethod.GET)
    public ModelAndView keywordserach(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("keywordserach") ;

        return view ;
    }
    @RequestMapping(value = "/districtsearch.do",method = RequestMethod.GET)
    public ModelAndView districtsearch(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("districtsearch") ;

        return view ;
    }
    @RequestMapping(value = "/buslinesearch.do",method = RequestMethod.GET)
    public ModelAndView buslinesearch(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("buslinesearch") ;

        return view ;
    }
    @RequestMapping(value = "/markerclusterer.do",method = RequestMethod.GET)
    public ModelAndView markerclusterer(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("markerclusterer") ;

        return view ;
    }

    @RequestMapping(value = "/replayhistory.do",method = RequestMethod.GET)
    public ModelAndView replayhistory(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("replayhistory") ;

        return view ;
    }

    @RequestMapping(value = "/infowindow.do",method = RequestMethod.GET)
    public ModelAndView infowindow(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("infowindow") ;

        return view ;
    }
    @RequestMapping(value = "/calculatedistance.do",method = RequestMethod.GET)
    public ModelAndView calculatedistance(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("calculatedistance") ;

        return view ;
    }
    @RequestMapping(value = "/poisearch.do",method = RequestMethod.GET)
    public ModelAndView poisearch(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("poisearch") ;

        return view ;
    }

    @RequestMapping(value = "/dotarea.do",method = RequestMethod.GET)
    public ModelAndView dotarea(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("dotarea") ;

        return view ;
    }

    @RequestMapping(value = "/dottoline.do",method = RequestMethod.GET)
    public ModelAndView dottoline(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("dottoline") ;

        return view ;
    }
    @RequestMapping(value = "/cloudlayer.do",method = RequestMethod.GET)
    public ModelAndView cloudlayer(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("cloudlayer") ;

        return view ;

    }
    @RequestMapping(value = "/trafffic.do",method = RequestMethod.GET)
    public ModelAndView trafffic(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("trafffic") ;

        return view ;

    }
    @RequestMapping(value = "/satellite.do",method = RequestMethod.GET)
    public ModelAndView satellite(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("satellite") ;

        return view ;

    }
    @RequestMapping(value = "/imagelayer.do",method = RequestMethod.GET)
    public ModelAndView imagelayer(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("imagelayer") ;

        return view ;
    }

    @RequestMapping(value = "/googleandamaplayer.do",method = RequestMethod.GET)
    public ModelAndView googleandamaplayer(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("googleandamaplayer") ;

        return view ;
    }
    @RequestMapping(value = "/customlayer.do",method = RequestMethod.GET)
    public ModelAndView customlayer(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("customlayer") ;

        return view ;
    }
    @RequestMapping(value = "/threedbuilding.do",method = RequestMethod.GET)
    public ModelAndView threedbuilding(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("threedbuilding") ;

        return view ;

    }
    @RequestMapping(value = "/browserlocation.do",method = RequestMethod.GET)
    public ModelAndView browserlocation(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("browserlocation") ;

        return view ;
    }

}
