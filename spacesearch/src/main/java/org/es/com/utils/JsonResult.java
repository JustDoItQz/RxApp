package org.es.com.utils;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import net.sf.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResult {
	
	private static final int DEFAULT_SUCCESS=0;
	
	private Status status;
	
	private Object data;
	
	private Page page;
	
	public JsonResult(Status status,Object data){
		this.status=status;
		this.data=data;
	}
	
	public JsonResult(Status status,Object data,Page page){
		this.status=status;
		this.data=data;
		this.page=page;
	}
	
	public long getCount() {
		return page!=null?page.getCount():0;
	}
	
	public Page getPage() {
		return page;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}



	static public class Status{
		
		private int code;
		
		private String msg;
		
		Status(int code,String msg){
			this.code=code;
			this.msg=msg;
		}

		public int getCode() {
			return code;
		}

		public String getMsg() {
			return msg;
		} 
		
	}
	
	public static String success(String msg,Object data,Page page){
		Status status=new Status(DEFAULT_SUCCESS, msg);
		JsonResult result=new JsonResult(status, data==null?new Object():data,page==null?null:page);
		return JSONObject.fromObject(result).toString();
	}
	
	public static String success(String msg,Object data){
		Status status=new Status(DEFAULT_SUCCESS, msg);
		JsonResult result=new JsonResult(status, data==null?new Object():data);
		return JSONObject.fromObject(result).toString();
	}
	
	public static String failure(int code,String msg){
		Status status=new Status(code, msg);
		JsonResult result=new JsonResult(status, new Object());
		return JSONObject.fromObject(result).toString();
	}
	
	public static String failure(int code,String msg,Object data){
		Status status=new Status(code, msg);
		JsonResult result=new JsonResult(status, data==null?new Object():data);
		return JSONObject.fromObject(result).toString();
	}
	
	public static void main(String[] args) {
		System.out.println(JsonResult.failure(-1,"sucess", null));
	}

}
