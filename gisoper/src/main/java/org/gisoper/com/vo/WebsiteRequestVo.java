package org.gisoper.com.vo;

import java.io.Serializable;

public class WebsiteRequestVo implements Serializable {

    private String websiteName ;
    private String websiteType ;
    private String opearState ;
    private String id ;
    private int page=0;
    private int pageSize = 10 ;

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteType() {
        return websiteType;
    }

    public void setWebsiteType(String websiteType) {
        this.websiteType = websiteType;
    }

    public String getOpearState() {
        return opearState;
    }

    public void setOpearState(String opearState) {
        this.opearState = opearState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
