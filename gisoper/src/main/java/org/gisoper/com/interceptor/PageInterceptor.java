package org.gisoper.com.interceptor;

import org.common.com.utils.SessionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PageInterceptor implements HandlerInterceptor {
    /**
     * class: PageInterceptor
     * description: 页面拦截器
     * autour: Aaron Wang
     * date: 2017/11/16 14:04
     * update: 2017/11/16
     * version: 1.0
     */
    private List<String> allowPages ;

    public List<String> getAllowPages() {
        return allowPages;
    }

    public void setAllowPages(List<String> allowPages) {
        this.allowPages = allowPages;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURL().toString() ;
        for (String strUrl:allowPages){
            if (url.contains(strUrl)){
                String parentPath = httpServletRequest.getContextPath() ;
                boolean isSession = SessionUtils.checkSession(httpServletRequest,SessionUtils.SESSION_USER) ;
                if (!isSession){
                    httpServletResponse.sendRedirect(parentPath+"/page/login");
                    return false ;
                }else{
                    return true ;
                }
            }else{
                return true ;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
