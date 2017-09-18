package org.common.com.utils;

import org.common.com.redis.RedisOper;
import org.common.com.vo.UserSessionVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionUtils {

    public static final String SESSION_USER ="SESSION_USER_" ;
    public static void addSession(HttpServletRequest request, String sessionName, UserSessionVo userSessionVo){

        HttpSession session = request.getSession() ;
        session.removeAttribute(sessionName);
        session.setMaxInactiveInterval(60*30);
        session.setAttribute(sessionName,userSessionVo);
        RedisOper.save(sessionName,userSessionVo,60*30);
    }
    public static UserSessionVo getSession(HttpServletRequest request,String sessionName){
        try{
            HttpSession session = request.getSession() ;
            UserSessionVo userSessionVo = (UserSessionVo)session.getAttribute(sessionName) ;
            return userSessionVo ;

        }catch (Exception e){
            return null ;
        }
    }
    public static void delSession(HttpServletRequest request,String sessionName){
        RedisOper.del(sessionName);
        HttpSession session = request.getSession() ;
        session.removeAttribute(sessionName);
    }
    public static boolean checkSession(HttpServletRequest request,String sessionName){
        HttpSession session = request.getSession() ;
        if (session!=null&&session.getAttribute(sessionName)!=null){
             return true ;
            }else {
            if (RedisOper.get(sessionName)!=null){
                UserSessionVo userSessionVo = RedisOper.get(sessionName,UserSessionVo.class) ;
                session.removeAttribute(sessionName);
                session.setMaxInactiveInterval(60*30);
                session.setAttribute(sessionName,userSessionVo);
                return true ;
            }else {
                return false ;
            }
        }
    }
 }
