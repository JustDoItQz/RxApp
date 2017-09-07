package org.common.com.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BeanOper {

    public static HashMap<String,Class> getBeanListClass(Class clazz){
        HashMap<String,Class> tempMap = new HashMap<String, Class>() ;
        HashMap<String,Class> resMap = new HashMap<String, Class>() ;

        return resMap ;
    }
    private static HashMap<String,Class> getBeanListClass(Class clazz,HashMap<String,Class> map){

        HashMap<String,Class> mapTemp = map ;
        Field[] fields = clazz.getDeclaredFields() ;
        for (int i=0;i<fields.length;i++){
            Field field = fields[i] ;
            try{
                if (field.getType().equals(ArrayList.class)||field.getType().equals(List.class)){
                    Type genericFieldType = field.getGenericType() ;
                    String fieldName = field.getName() ;
                    Class fieldClass =  (Class) getClass(field);
                    mapTemp.put(fieldName,fieldClass) ;
                    if (genericFieldType instanceof ParameterizedType){
                        ParameterizedType aType = (ParameterizedType) genericFieldType ;
                        Type[] fieldArgTypes = aType.getActualTypeArguments() ;
                        for (Type fieldArgType:fieldArgTypes){
                            Class fieldArgClass = (Class) fieldArgType ;
                            getBeanListClass(fieldArgClass,mapTemp) ;
                        }
                    }

                }
            }catch (Exception e){
                continue;
            }
        }
        return map ;
    }
    private static Object getClass(Field field){
        Type genericFieldType = field.getGenericType() ;
        if (genericFieldType instanceof ParameterizedType){
            try{
                ParameterizedType aType = (ParameterizedType) genericFieldType ;
                Type[] fieldArgTypes = aType.getActualTypeArguments() ;
                return (Class)fieldArgTypes[0] ;
            }catch (Exception e){
                return Object.class ;
            }
        }else {
            return Object.class ;
        }
    }
}
