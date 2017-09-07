package org.gisoper.com.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by on 2017/8/18.
 * Author Aaron.Wang
 */
@Controller
@RequestMapping("/page")
public class WebController {

    @RequestMapping(value = "/error.do",method = RequestMethod.GET)
    public ModelAndView error(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/404") ;

        return view ;
    }
    @RequestMapping(value = "/blank.do",method = RequestMethod.GET)
    public ModelAndView blank(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/_blank") ;

        return view ;
    }
    @RequestMapping(value = "/footer.do",method = RequestMethod.GET)
    public ModelAndView footer(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/_footer") ;

        return view ;
    }
    @RequestMapping(value = "/header.do",method = RequestMethod.GET)
    public ModelAndView header(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/_header") ;

        return view ;
    }
    @RequestMapping(value = "/menu.do",method = RequestMethod.GET)
    public ModelAndView menu(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/_menu") ;

        return view ;
    }
    @RequestMapping(value = "/meta.do",method = RequestMethod.GET)
    public ModelAndView meta(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/_meta") ;

        return view ;
    }
    @RequestMapping(value = "/adminadd.do",method = RequestMethod.GET)
    public ModelAndView adminadd(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/adminadd") ;

        return view ;
    }
    @RequestMapping(value = "/adminlist.do",method = RequestMethod.GET)
    public ModelAndView adminlist(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/adminlist") ;

        return view ;
    }
    @RequestMapping(value = "/adminpermission.do",method = RequestMethod.GET)
    public ModelAndView adminpermission(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/adminpermission") ;

        return view ;
    }
    @RequestMapping(value = "/adminrole.do",method = RequestMethod.GET)
    public ModelAndView adminrole(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/adminrole") ;

        return view ;
    }
    @RequestMapping(value = "/adminroleadd.do",method = RequestMethod.GET)
    public ModelAndView adminroleadd(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/adminroleadd") ;

        return view ;
    }
    @RequestMapping(value = "/articleadd.do",method = RequestMethod.GET)
    public ModelAndView articleadd(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/articleadd") ;

        return view ;
    }
    @RequestMapping(value = "/articlelist.do",method = RequestMethod.GET)
    public ModelAndView articlelist(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/articlelist") ;

        return view ;
    }
    @RequestMapping(value = "/changepassword.do",method = RequestMethod.GET)
    public ModelAndView changepassword(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/changepassword") ;

        return view ;
    }
    @RequestMapping(value = "/charts1.do",method = RequestMethod.GET)
    public ModelAndView charts1(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/charts1") ;

        return view ;
    }
    @RequestMapping(value = "/charts2.do",method = RequestMethod.GET)
    public ModelAndView charts2(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/charts2") ;

        return view ;
    }
    @RequestMapping(value = "/charts3.do",method = RequestMethod.GET)
    public ModelAndView charts3(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/charts3") ;

        return view ;
    }
    @RequestMapping(value = "/charts4.do",method = RequestMethod.GET)
    public ModelAndView charts4(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/charts4") ;

        return view ;
    }
    @RequestMapping(value = "/charts5.do",method = RequestMethod.GET)
    public ModelAndView charts5(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/charts5") ;

        return view ;
    }
    @RequestMapping(value = "/charts6.do",method = RequestMethod.GET)
    public ModelAndView charts6(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/charts6") ;

        return view ;
    }
    @RequestMapping(value = "/charts7.do",method = RequestMethod.GET)
    public ModelAndView charts7(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/charts7") ;

        return view ;
    }
    @RequestMapping(value = "/codeing.do",method = RequestMethod.GET)
    public ModelAndView codeing(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/codeing") ;

        return view ;
    }
    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
    public ModelAndView login(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/login") ;

        return view ;
    }
    @RequestMapping(value = "/main.do",method = RequestMethod.GET)
    public ModelAndView main(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/main") ;

        return view ;
    }
    @RequestMapping(value = "/memberadd.do",method = RequestMethod.GET)
    public ModelAndView memberadd(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/memberadd") ;

        return view ;
    }
    @RequestMapping(value = "/memberdel.do",method = RequestMethod.GET)
    public ModelAndView memberdel(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/memberdel") ;

        return view ;
    }
    @RequestMapping(value = "/memberlist.do",method = RequestMethod.GET)
    public ModelAndView memberlist(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/memberlist") ;

        return view ;
    }
    @RequestMapping(value = "/memberrecordbrowse.do",method = RequestMethod.GET)
    public ModelAndView memberrecordbrowse(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/memberrecordbrowse") ;

        return view ;
    }
    @RequestMapping(value = "/memberrecorddownload.do",method = RequestMethod.GET)
    public ModelAndView memberrecorddownload(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/memberrecorddownload") ;

        return view ;
    }
    @RequestMapping(value = "/memberrecordshare.do",method = RequestMethod.GET)
    public ModelAndView memberrecordshare(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/memberrecordshare") ;

        return view ;
    }

    @RequestMapping(value = "/membershow.do",method = RequestMethod.GET)
    public ModelAndView membershow(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/membershow") ;

        return view ;
    } @RequestMapping(value = "/pictureadd.do",method = RequestMethod.GET)
    public ModelAndView pictureadd(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/pictureadd") ;

        return view ;
    } @RequestMapping(value = "/picturelist.do",method = RequestMethod.GET)
    public ModelAndView picturelist(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/picturelist") ;

        return view ;
    } @RequestMapping(value = "/pictureshow.do",method = RequestMethod.GET)
    public ModelAndView pictureshow(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/pictureshow") ;

        return view ;
    } @RequestMapping(value = "/productadd.do",method = RequestMethod.GET)
    public ModelAndView productadd(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/productadd") ;

        return view ;
    } @RequestMapping(value = "/productbrand.do",method = RequestMethod.GET)
    public ModelAndView productbrand(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/productbrand") ;

        return view ;
    } @RequestMapping(value = "/productcategory.do",method = RequestMethod.GET)
    public ModelAndView productcategory(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/productcategory") ;

        return view ;
    } @RequestMapping(value = "/productcategoryadd.do",method = RequestMethod.GET)
    public ModelAndView productcategoryadd(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/productcategoryadd") ;

        return view ;
    } @RequestMapping(value = "/productlist.do",method = RequestMethod.GET)
    public ModelAndView productlist(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/productlist") ;

        return view ;
    } @RequestMapping(value = "/systembase.do",method = RequestMethod.GET)
    public ModelAndView systembase(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/systembase") ;

        return view ;
    } @RequestMapping(value = "/systemcategory.do",method = RequestMethod.GET)
    public ModelAndView systemcategory(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/systemcategory") ;

        return view ;
    } @RequestMapping(value = "/systemcategoryadd.do",method = RequestMethod.GET)
    public ModelAndView systemcategoryadd(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/systemcategoryadd") ;

        return view ;
    } @RequestMapping(value = "/systemdata.do",method = RequestMethod.GET)
    public ModelAndView systemdata(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/systemdata") ;

        return view ;
    } @RequestMapping(value = "/systemlog.do",method = RequestMethod.GET)
    public ModelAndView systemlog(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/systemlog") ;

        return view ;
    } @RequestMapping(value = "/systemshielding.do",method = RequestMethod.GET)
    public ModelAndView systemshielding(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/systemshielding") ;

        return view ;
    }
    @RequestMapping(value = "/index.do",method = RequestMethod.GET)
    public ModelAndView index(){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json");
        ModelAndView view = new ModelAndView("view/index") ;

        return view ;
    }

}
