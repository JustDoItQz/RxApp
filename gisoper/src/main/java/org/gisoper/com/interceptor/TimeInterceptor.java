package org.gisoper.com.interceptor;

import org.common.com.utils.DateUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TimeInterceptor implements HandlerInterceptor {

    private List<String> notFilters ;
    boolean isSecurity = false ;

    public boolean isSecurity() {
        return isSecurity;
    }

    public void setSecurity(boolean security) {
        isSecurity = security;
    }

    public List<String> getNotFilters() {
        return notFilters;
    }

    public void setNotFilters(List<String> notFilters) {
        this.notFilters = notFilters;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI() ;
        for (String url:notFilters){
            if (uri.indexOf(url)>-1){
                isSecurity = true ;
                break;
            }
        }
        if (isSecurity){
            return true;
        }
        long startTime = System.currentTimeMillis() ;
        String requestTime = DateUtils.getNowTime("yyyy-MM-dd HH:mm:ss.S") ;
        httpServletRequest.setAttribute("startTime",startTime);
        httpServletRequest.setAttribute("request",requestTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
