package org.common.com.utils;

public class RequetESB<T> {

    private T body ;
    public RequestHeader header ;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public RequestHeader getHeader() {
        return header;
    }

    public void setHeader(RequestHeader header) {
        this.header = header;
    }
}
