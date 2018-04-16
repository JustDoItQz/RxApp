package org.es.com.utils;

public class Page {
	
	private long count;
	
	private int pageNo;
	
	private int pageSize;
	
	public Page(int pageNo,int pageSize,long count){
		this.pageNo=pageNo;
		this.pageSize=pageSize;
		this.count=count;
		if(pageNo<=0){
			this.pageNo=1;
		}
		if(pageSize<=0){
			this.pageSize=1;
		}
		if(count<=0){
			this.count=0;
		}
	}

	public long getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

}
