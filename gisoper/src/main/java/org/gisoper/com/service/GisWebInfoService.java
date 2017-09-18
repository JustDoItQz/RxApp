package org.gisoper.com.service;

import org.apache.commons.lang.StringUtils;
import org.common.com.dao.MyBatisDao;
import org.gisoper.com.vo.TVehicleWebsite;
import org.gisoper.com.vo.WebsiteRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GisWebInfoService {

    @Autowired
    private MyBatisDao myBatisDao ;

    public List<TVehicleWebsite> searchWebsiteList(WebsiteRequestVo tVehicleWebsite){
        List<TVehicleWebsite> vehicleWebsiteList = new ArrayList<TVehicleWebsite>() ;
        try{
            if (StringUtils.isNotBlank(tVehicleWebsite.getWebsiteName())){
                tVehicleWebsite.setWebsiteName("'%"+tVehicleWebsite.getWebsiteName()+"%'");
                vehicleWebsiteList = myBatisDao.getList("org.gisoper.com.mapper.TVehicleWebsiteMapper.searchWebSiteList",tVehicleWebsite) ;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return vehicleWebsiteList ;
    }

}
