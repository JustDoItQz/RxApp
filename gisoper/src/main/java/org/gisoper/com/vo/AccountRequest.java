package org.gisoper.com.vo;

/**
 * Created by on 2017/6/21.
 * Author Aaron.Wang
 */
public class AccountRequest {
    private String index;
    private String term;
    private String type;
    private String queryString;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
