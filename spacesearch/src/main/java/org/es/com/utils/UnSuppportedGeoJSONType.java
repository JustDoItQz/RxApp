package org.es.com.utils;

import java.io.IOException;

public class UnSuppportedGeoJSONType extends IOException {
    public UnSuppportedGeoJSONType(String message){
        super(message);
    }
}
