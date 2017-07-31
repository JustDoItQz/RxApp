package org.common.com.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;

import java.io.UnsupportedEncodingException;

/**
 * Created by on 2017/7/26.
 * Author Aaron.Wang
 */
public class MqMessageJsonConvert extends AbstractMessageConverter {

    public static final String DEFAULT_CHARSET="UTF-8" ;
    public MqMessageJsonConvert(){
        super();
    }
    @Override
    protected Message createMessage(Object o, MessageProperties messageProperties) {
        byte[] bytes = null ;
        String json = JSON.toJSONString(o) ;
        try{
            bytes = json.getBytes(DEFAULT_CHARSET) ;
        }catch (UnsupportedEncodingException e){
            throw new MessageConversionException("消息转换为JSON失败",e) ;
        }
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setContentEncoding(DEFAULT_CHARSET);
        if (bytes!=null){
            messageProperties.setContentLength(bytes.length);
        }
        return new Message(bytes,messageProperties);
    }

    public <T> T fromMessage(Message message,T t) throws MessageConversionException{
        String json="" ;
        try {
            json = new String(message.getBody(),DEFAULT_CHARSET) ;
        }catch (UnsupportedEncodingException e){
            throw new MessageConversionException("JSON消息转换异常",e) ;
        }
        return (T)JSON.parseObject(json,t.getClass()) ;
    }
    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        String json="" ;
        try {
            json = new String(message.getBody(),DEFAULT_CHARSET) ;
        }catch (UnsupportedEncodingException e){
            new MessageConversionException("JSON消息转换异常",e) ;
        }
        return json ;
    }
}
