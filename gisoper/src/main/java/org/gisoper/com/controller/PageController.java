package org.gisoper.com.controller;

import net.sf.json.JSONObject;
import org.common.com.utils.SessionUtils;
import org.common.com.vo.UserSessionVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/page")
@Controller
public class PageController {

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response){
        JSONObject result = new JSONObject() ;
        try{
            String username = request.getParameter("username").trim() ;
            String password = request.getParameter("password").trim() ;
            String loginType = request.getParameter("loginType").trim() ;
            if ("1".equals(loginType)){
                if ("user123".equals(username)&&"pwd123".equals(password)){
                    UserSessionVo userSessionVo = new UserSessionVo() ;
                    userSessionVo.setUsername(username);
                    userSessionVo.setPassword(password);
                    userSessionVo.setLoginType(loginType);
                    SessionUtils.addSession(request,SessionUtils.SESSION_USER,userSessionVo);
                    result.put("success","true") ;
                }
            }else if ("2".equals(loginType)){
                if ("user123".equals(username)&&"pwd123".equals(password)){
                    UserSessionVo userSessionVo = new UserSessionVo() ;
                    userSessionVo.setUsername(username);
                    userSessionVo.setPassword(password);
                    userSessionVo.setLoginType(loginType);
                    SessionUtils.addSession(request,SessionUtils.SESSION_USER,userSessionVo);
                    result.put("success","true") ;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("success","false") ;
            result.put("msg",e.getMessage()) ;
        }
        return JSONObject.fromObject(result).toString() ;

    }
}
