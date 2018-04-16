package org.es.com.exception;

public class GeoDataException extends Exception {

    public GeoDataException(){
        super();
    }
    public GeoDataException(String message){
        super(message);
    }
    public GeoDataException(Throwable cause){
        super(cause);
    }
    public GeoDataException(String message,Throwable cause){
        super(message,cause);
    }
}
