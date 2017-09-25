package org.gisoper.com.controller.test;

import net.sf.json.JSONObject;
import org.gisoper.com.vo.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

       /*long currentTime = System.currentTimeMillis() ;
       long twoMinutes = currentTime-(2*60*1000) ;
       Date currentDate = new Date(currentTime) ;
       Date twoMinutesDate = new Date(twoMinutes) ;
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
       String cuttentTimeStr = sdf.format(currentDate) ;
       String twoMinutesStr = sdf.format(twoMinutesDate) ;
       System.out.println("当前时间："+cuttentTimeStr+"两分钟内："+twoMinutesStr);*/

        /*SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss"); //设置时间格式
        String dateStr = sdf.format(new Date()) ;
        Random random = new Random() ;
        int lg=random.nextInt(100000000) ;
        System.out.println("最后时间为："+dateStr+lg);*/

        Map<String,Object> map = new HashMap<String,Object>() ;
        Account account = new Account() ;
        account.setAccount_number(1);
        account.setAddress("汤泉国际");
        account.setAge(12);
        account.setBalance(59939494);
        account.setCity("上海");
        account.setEmail("123456@gmail.com");
        account.setFirstname("hahahhah");
        String str=JSONObject.fromObject(account).toString() ;
        System.out.println("使用前=============="+str+"=================");
        map.put("param",str) ;
        JSONObject getStr = JSONObject.fromObject(map.get("param")) ;
        Object[] header = getStr.keySet().toArray() ;
        Object [] values = getStr.values().toArray() ;
        for (int i=0;i<header.length;i++){
            System.out.println("header="+header[i]);
            System.out.println("values="+values[i]);
        }
        Account account1 = (Account) JSONObject.toBean(getStr,Account.class) ;
        System.out.println("使用后=============="+account1.getAddress()+"=================");

        List<JSONObject> list = new ArrayList<JSONObject>() ;
        JSONObject object = new JSONObject() ;
        JSONObject object1 = new JSONObject() ;
        object.put("name","aaron") ;
        object.put("password","123456") ;
        object1.put("name","aaron2") ;
        object1.put("password2","123456") ;
        list.add(object) ;
        list.add(object1) ;
        Map<String,List<JSONObject>> map1 = new HashMap<String, List<JSONObject>>() ;
        map1.put("data",list) ;
        String result = JSONObject.fromObject(map1).toString() ;
        System.out.println("包装后的值=============="+result+"=================");

        Map<String,Object> mapVo = new HashMap<String, Object>() ;
        Account accountVo = new Account() ;
        accountVo.setFirstname("aaronwang");
        accountVo.setEmail("123456@gmail.com");
        accountVo.setCity("上海");
        accountVo.setAccount_number(111111);
        Account accountVo2 = new Account() ;
        accountVo2.setFirstname("aaronwang");
        accountVo2.setEmail("123456@gmail.com");
        accountVo2.setCity("上海");
        accountVo2.setAccount_number(111111);
        mapVo.put("vo1",accountVo) ;
        mapVo.put("vo2",accountVo2) ;
        String accountResult = JSONObject.fromObject(mapVo).toString() ;
        System.out.println("accountResult包装后的值=============="+accountResult+"=================");
    }
}
