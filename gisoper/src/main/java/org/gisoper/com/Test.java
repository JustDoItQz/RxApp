package org.gisoper.com;

import org.gisoper.com.mq.AlarmQuenueListener;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by on 2017/7/24.
 * Author Aaron.Wang
 */
public class Test {

    public static void main(String [] args){
/*
        String str = "北京市北京城区" ;
        if (str.endsWith("城区")){
            str = str.substring(0,(str.length()-2))+"市" ;
        }
        System.out.println(str) ;*/

        /*int sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += 1;
            System.out.println("1到100累加的和为：" + sum);

        }*/
       /* Date dNow = new Date();   //当前时间
        Date dBefore = new Date();

        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
        dBefore = calendar.getTime();   //得到前一天的时间


        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
        String defaultStartDate = sdf.format(dBefore);    //格式化前一天
        String defaultEndDate = sdf.format(dNow); //格式化当前时间


        System.out.println("前一天的时间是：" + defaultStartDate);

        System.out.println("生成的时间是：" + defaultEndDate);*/
        /*long curren = System.currentTimeMillis();
        curren -= 30 * 60 * 1000;
        Date da = new Date(curren);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(da));*/

       /* ApplicationContext context = new ClassPathXmlApplicationContext("spring-rabbitmq.xml");
        AmqpTemplate amqpTemplate  = context.getBean(RabbitTemplate.class) ;

        for (int i=0;i<100;i++){
            amqpTemplate.convertAndSend("test spring async=>"+i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

       long currentTime = System.currentTimeMillis() ;
       long twoMinutes = currentTime-(2*60*1000) ;
       Date currentDate = new Date(currentTime) ;
       Date twoMinutesDate = new Date(twoMinutes) ;
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
       String cuttentTimeStr = sdf.format(currentDate) ;
       String twoMinutesStr = sdf.format(twoMinutesDate) ;
       System.out.println("当前时间："+cuttentTimeStr+"两分钟内："+twoMinutesStr);




    }
}
