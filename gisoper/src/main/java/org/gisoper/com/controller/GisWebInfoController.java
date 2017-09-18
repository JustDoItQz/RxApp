package org.gisoper.com.controller;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.gisoper.com.service.GisWebInfoService;
import org.gisoper.com.vo.TVehicleWebsite;
import org.gisoper.com.vo.WebsiteRequestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GisWebInfoController {

    private static final Logger logger = LoggerFactory.getLogger(GisWebInfoController.class) ;

    @Autowired
    private GisWebInfoService gisWebInfoService ;

    @ResponseBody
    @RequestMapping(value = "/searchWebsiteList",method = RequestMethod.POST)
    public String searchWebsiteList(HttpServletRequest request, HttpServletResponse response){

        Map<String,Object> resultMap = new HashMap<String, Object>() ;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type","application/json");
        try{
            WebsiteRequestVo requestVo = new WebsiteRequestVo() ;
            if (StringUtils.isNotBlank(request.getParameter("websiteName"))){
                requestVo.setWebsiteName(request.getParameter("websiteName"));
                requestVo.setId(request.getParameter("websiteId"));
                requestVo.setOpearState(request.getParameter("opearState"));
                requestVo.setPage((Integer.valueOf(request.getParameter("page"))-1)*Integer.valueOf(request.getParameter("pageSize")));
                requestVo.setPageSize(Integer.valueOf(request.getParameter("pageSize")));
                List<TVehicleWebsite>  list = gisWebInfoService.searchWebsiteList(requestVo) ;
                resultMap.put("data",list) ;
                resultMap.put("success","true") ;
            }else {
                resultMap.put("msg","查询网点名称不能为空！") ;
                resultMap.put("success","false") ;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查询异常",e.getMessage());
            resultMap.put("查询异常",e.getMessage()) ;
        }
        return JSONObject.fromObject(resultMap).toString() ;
    }


}
