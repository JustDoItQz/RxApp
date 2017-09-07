package org.gisoper.com.vo;

import net.sf.json.JSONObject;

import java.io.Serializable;

public class OpenAPIResultVo implements Serializable {
    private String success ;
    private String msgcode ;
    private String msg ;
    private JSONObject data ;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsgcode() {
        return msgcode;
    }

    public void setMsgcode(String msgcode) {
        this.msgcode = msgcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
