package org.es.com.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

/**
 * 日期工具类
 * 
 */
public class DateUtils {

    // 087584-foss-lijun
    public static final String DATE_SHORT_FORMAT = "yyyyMMdd";

    public static final String DATE_CH_FORMAT    = "yyyy年MM月dd日";

    public static final String DATE_TIME_FORMAT  = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_NO_SECOND  = "yyyy-MM-dd HH:mm";

    public static final String TIMESTAMP_FORMAT  = "yyyy-MM-dd HH:mm:ss.S";

    public static final String DATE_FORMAT       = "yyyy-MM-dd";

    public static final String TIME_FORMAT       = "HH:mm:ss";

    public static final String DAYTIME_START     = "00:00:00";

    public static final String DAYTIME_END       = "23:59:59";
    
    public static final String TIME_UTC="yyyy-MM-dd'T'HH:mm:ss'Z'";

    private DateUtils() {
    }

    private static final String[] FORMATS = {"yyyy-MM-dd","yyyy-MM-dd HH:mm","yyyy-MM-dd HH:mm:ss","HH:mm","HH:mm:ss","yyyy-MM","yyyy-MM-dd HH:mm:ss.S"};

    public static String[] getCurrentMonth() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        String lastDay = sf.format(cal.getTime());
        String aDay = "";
        int i = 1;
        String[] sd = new String[2];
        while (!lastDay.equals(aDay)) {
            cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), i);
            aDay = sf.format(cal.getTime());
            if (i == 1) {
                sd[0] = aDay;
            }
            sd[1] = aDay;
            i++;
        }
        return sd;
    }

    public static String[] getLastMonth() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
        cal.add(Calendar.DATE, -1);
        String lastDay = sf.format(cal.getTime());
        String aDay = "";
        int i = 1;
        String[] sd = new String[2];
        while (!lastDay.equals(aDay)) {
            cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), i);
            aDay = sf.format(cal.getTime());
            if (i == 1) {
                sd[0] = aDay;
            }
            sd[1] = aDay;
            i++;
        }
        return sd;
    }

    /**
     * 
     * @description 将字符转换成日期
     * @author helong
     * @2014-9-18
     */
    public static Date convert(String str) {
        if (str != null && str.length() > 0) {
            if (str.length() > 10 && str.charAt(10) == 'T') {
                str = str.replace('T', ' '); // 去掉json-lib加的T字母
            }
            for (String format : FORMATS) {
                if (str.length() == format.length()) {
                    try {
                        Date date = new SimpleDateFormat(format).parse(str);
                        return date;
                    } catch (ParseException e) {
                        // logger.warn(e.getMessage());
                    }
                }
            }
        }
        return null;
    }

    /**
     * 
     * @description 将字符串转换成指定格式的日期类型
     * @author helong
     * @2014-9-18
     */
    public static Date convert(String str, String format) {
        if (!StringUtils.isEmpty(str)) {
            try {
                Date date = new SimpleDateFormat(format).parse(str);
                return date;
            } catch (ParseException e) {
                // logger.warn(e.getMessage());
            }
        }
        return null;
    }
    
    
    public static final Date str2Date(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			return null;
		}

		return (date);
	}

    /**
     * 
     * @description 时间拼接 将日期和实现拼接 ymd 如2012-05-15 hm 如0812
     * @author helong
     * @2014-9-18
     */
    public static Date concat(String ymd, String hm) {
        if (StringUtils.isNotBlank(ymd) && StringUtils.isNotBlank(hm)) {
            try {
                String dateString = ymd.concat(" ").concat(hm.substring(0, 2).concat(":").concat(hm.substring(2, 4)).concat(":00"));
                Date date = DateUtils.convert(dateString, DateUtils.DATE_TIME_FORMAT);
                return date;
            } catch (NullPointerException e) {}
        }
        return null;
    }

    /**
     * 
     * @description 根据传入的日期返回年月日的6位字符串，例：20101203
     * @author helong
     * @2014-9-18
     */
    public static String getDay(Date date) {
        return convert(date, DATE_SHORT_FORMAT);
    }

    /**
     * 
     * @description 根据传入的日期返回中文年月日字符串，例：2010年12月03日
     * @author helong
     * @2014-9-18
     */
    public static String getChDate(Date date) {
        return convert(date, DATE_CH_FORMAT);
    }

    /**
     * 
     * @description 将传入的时间格式的字符串转成时间对象
     * @author helong
     * @2014-9-18
     */
    public static Date strToDate(String dateStr) {
        SimpleDateFormat formatDate = new SimpleDateFormat(DATE_TIME_FORMAT);
        Date date = null;
        try {
            date = formatDate.parse(dateStr);
        } catch (Exception e) {}
        return date;
    }

    /**
     * 
     * @description 将日期转换成字符串
     * @author helong
     * @2014-9-18
     */
    public static String convert(Date date) {
        return convert(date, DATE_TIME_FORMAT);
    }

    /**
     * 
     * @description 将日期转换成制定格式字符串
     * @author helong
     * @2014-9-18
     */
    public static String convert(Date date, String dateFormat) {
        if (date == null) {
            return null;
        }
        int h=  date.getHours();
        int m = date.getMinutes();
        int s = date.getSeconds();
        int sum = h+m+s;
       
        if (null == dateFormat||dateFormat.equals("")) {
        	if(sum>0)
        	{
        		dateFormat = DATE_TIME_FORMAT;
        	}
        	else
        	{
        		dateFormat = DATE_FORMAT;
        	}
        }
        
        
        
      
        SimpleDateFormat df = new SimpleDateFormat(dateFormat, Locale.US);
        return df.format(date);
       // return new SimpleDateFormat(dateFormat).format(date);
    }

    /**
     * 
     * @description 返回该天从00:00:00开始的日期
     * @author helong
     * @2014-9-18
     */
    public static Date getStartDatetime(Date date) {
        String thisdate = convert(date, DATE_FORMAT);
        return convert(thisdate + " " + DAYTIME_START);
    }

    /**
     * 
     * @description 返回n天后从00:00:00开始的日期
     * @author helong
     * @2014-9-18
     */
    public static Date getStartDatetime(Date date, Integer diffDays) {
        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
        String thisdate = df.format(date.getTime() + 1000l * 24 * 60 * 60 * diffDays);
        return convert(thisdate + " " + DAYTIME_START);
    }

    /**
     * 
     * @description 返回该天到23:59:59结束的日期
     * @author helong
     * @2014-9-18
     */
    public static Date getEndDatetime(Date date) {
        String thisdate = convert(date, DATE_FORMAT);
        return convert(thisdate + " " + DAYTIME_END);
    }

    /**
     * 
     * @description 返回n天到23:59:59结束的日期
     * @author helong
     * @2014-9-18
     */
    public static Date getEndDatetime(Date date, Integer diffDays) {
        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
        String thisdate = df.format(date.getTime() + 1000l * 24 * 60 * 60 * diffDays);
        return convert(thisdate + " " + DAYTIME_END);
    }

    /**
     * 
     * @description 返回该日期的最后一刻，精确到纳秒
     * @author helong
     * @2014-9-18
     */
    public static Timestamp getLastEndDatetime(Date endTime) {
        Timestamp ts = new Timestamp(endTime.getTime());
        ts.setNanos(999999999);
        return ts;
    }

    /**
     * 
     * @description 返回该日期加1秒
     * @author helong
     * @2014-9-18
     */
    public static Timestamp getEndTimeAdd(Date endTime) {
        Timestamp ts = new Timestamp(endTime.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(ts);
        c.add(Calendar.MILLISECOND, 1000);
        c.set(Calendar.MILLISECOND, 0);
        return new Timestamp(c.getTimeInMillis());
    }

    /**
     * 
     * @description 返回该日期加 millisecond 毫秒，正数为加，负数为减
     * @author helong
     * @2014-9-18
     */
    public static Timestamp getDateAdd(Date date, int millisecond) {
        Timestamp ts = new Timestamp(date.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(ts);
        c.add(Calendar.MILLISECOND, millisecond);
        c.set(Calendar.MILLISECOND, 0);
        return new Timestamp(c.getTimeInMillis());
    }

    /**
     * 
     * @description 相对当前日期，增加或减少天数，返回字符串类型
     * @author helong
     * @2014-9-18
     */
    public static String addDay(Date date, int day) {
        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(new Date(date.getTime() + 1000l * 24 * 60 * 60 * day));
    }

    /**
     * 
     * @description 相对当前日期，增加或减少天数，返回 日期类型
     * @author helong
     * @2014-9-18
     */
    public static Date addDayToDate(Date date, int day) {
        return new Date(date.getTime() + 1000l * 24 * 60 * 60 * day);
    }

    /**
     * 
     * @description 返回两个时间的相差天数
     * @author helong
     * @2014-9-18
     */
    public static Long getTimeDiff(String startTime, String endTime) {
        Long days = null;
        Date startDate = null;
        Date endDate = null;
        try {
            if (startTime.length() == 10 && endTime.length() == 10) {
                startDate = new SimpleDateFormat(DATE_FORMAT).parse(startTime);
                endDate = new SimpleDateFormat(DATE_FORMAT).parse(endTime);
            } else {
                startDate = new SimpleDateFormat(DATE_TIME_FORMAT).parse(startTime);
                endDate = new SimpleDateFormat(DATE_TIME_FORMAT).parse(endTime);
            }
            days = getTimeDiff(startDate, endDate);
        } catch (ParseException e) {
            days = null;
        }
        return days;
    }

    /**
     * 
     * @description 返回两个时间的相差天数
     * @author helong
     * @2014-9-18
     */
    public static Long getTimeDiff(Date startTime, Date endTime) {
        Long days = null;
        Calendar c = Calendar.getInstance();
        c.setTime(startTime);
        long l_s = c.getTimeInMillis();
        c.setTime(endTime);
        long l_e = c.getTimeInMillis();
        days = (l_e - l_s) / 86400000;
        return days;
    }

    /**
     * 
     * @description 返回两个时间的相差分钟数
     * @author helong
     * @2014-9-18
     */
    public static Long getMinuteDiff(Date startTime, Date endTime) {
        Long minutes = null;
        Calendar c = Calendar.getInstance();
        c.setTime(startTime);
        long l_s = c.getTimeInMillis();
        c.setTime(endTime);
        long l_e = c.getTimeInMillis();
        minutes = (l_e - l_s) / (1000l * 60);
        return minutes;
    }

    /**
     * 
     * @description 返回当月的前三天
     * @author helong
     * @2014-9-18
     */
    public static String getPidFromDate(Date date) {
        if (date == null) {
            return "";
        }
        String m = convert(date, "yyyyMM");
        String d = convert(date, "dd");
        if (Integer.valueOf(d) <= 10) {
            d = "01";
        } else if (Integer.valueOf(d) <= 20) {
            d = "02";
        } else {
            d = "03";
        }
        return m.concat(d);
    }

    /**
     * 
     * @return
     */
    public static String getCurrentDateStr() {
        return convert(new Date(), DATE_FORMAT);
    }
    
    /*
     * yyyy-mm-dd HH:mm:ss
     */
    public static String getNowTime() {
        return convert(new Date(),DATE_TIME_FORMAT );
    }
    
    //12:00:00
    public static String getNowTimeWithoutDate() {
        return convert(new Date(),TIME_FORMAT );
    }
    
    public static String getNowTime(String format) {
        return convert(new Date(),format );
    }
    
    public static String longStrFormat(String longStr)
    {
    	return longStrFormat(longStr,DATE_TIME_FORMAT);
    }

    
    public static String longStrFormat(String longStr,String dateFormat)
    {
    	return convertStrDate(longStr,dateFormat);
    }

	public static String shortStrFormat(String createTime) {
		return longStrFormat(createTime,DATE_FORMAT);
	}
	
	
	public static String convertStr(String dateStr)
	{
		return convertStrDate(dateStr);
	}
	
	public static String convertStrDate(String dateStr)
	{
		return convertStrDate(dateStr,null);
	}
	public static String convertStrDate(String dateStr,String format)
	{
		if(dateStr==null||dateStr.isEmpty())
		{
			return "";
		}
		try
		{
		dateStr =dateStr.trim();
		String f = "yyyy-MM-dd HH:mm:ss";
		
		if(format!=null&&format.length()>=10)
		{
			
			f = format;
		}
		else
		{
			f=null;
		}
		
		
		
		int timeType = getStrDateType(dateStr);
		if(timeType>10||timeType==0)
		{
			return dateStr;
		}
		
		switch (timeType) {
		case 1://UTC时间类型
			Date d = convertUtcTime(dateStr);
			dateStr = convert(d,f);
			break;
			
		case 2: 
			
			try
	    	{
	    		BigDecimal db = new BigDecimal(dateStr);
	    		Date date =null;
	    		Long ll=null;
	    		try
	    		{
		    		ll = db.longValue();
		    		date= new Date(ll);
		    		dateStr = convert(date,f);
	    		}catch(Exception e)
	    		{
	    			break;
	    		}
	    	
	    	}catch(Exception e)
	    	{
	    		break;
	    	}
			
			break;
		case 3: 
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
			try {
				Date date = (Date) sdf.parse(dateStr);
				dateStr = convert(date, "EEE MMM dd HH:mm:ss zzz yyyy");
				//dateStr = df.format(date);
				
			} catch (ParseException e) {
			    e.printStackTrace();
				break;
			
			}
			break;

		default:
			
			break;
		}
		
		
		return dateStr;
		}catch(Exception e)
		{
			return dateStr;
		}
		
	}
	
	
	private static int getStrDateType(String strDate)
	{
		if(isValidDate(strDate,TIME_UTC))
		{
			return 1;
		}
		if(isValidLong(strDate))
		{
			return 2;//long型时间
		}
		
		if(isValidDate(strDate,"EEE MMM dd HH:mm:ss zzz yyyy"))
		{
			return 3;
		}
		
		if(isValidDate(strDate, "yyyy-MM-dd"))
		{
			return 11;//时间类型
		}
	
		
		return 0;
	}
	
	private static boolean isValidLong(String str){
	   try{
	       long _v = Long.parseLong(str);
	       return true;
	   }catch(NumberFormatException e){
	     return false;
	   }
	}
	
	public static Date convertUtcTime(String strTime)
	{
		try
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			df.setTimeZone(TimeZone.getTimeZone("UTC"));
			return df.parse(strTime);
		}catch(Exception e)
		{
			return null;
		}
		
	}
	
	
	
	  public static boolean isValidDate(String inDate,String format) {

		    if (inDate == null)
		      return false;

		    SimpleDateFormat dateFormat = new SimpleDateFormat(format,Locale.US);

//		    if (inDate.trim().length() != dateFormat.toPattern().length())
//		      return false;
//
//		    dateFormat.setLenient(false);

		    try {
		      dateFormat.parse(inDate.trim());
		    }
		    catch (ParseException pe) {
		      return false;
		    }
		    return true;
		  }
	  
	  
	  public static Date strToUTCDate(String dateStr,String format)
	  {
		  SimpleDateFormat df = new SimpleDateFormat(format);
			df.setTimeZone(TimeZone.getTimeZone("UTC"));
			
			try {
				return df.parse(dateStr);
			} catch (ParseException e) {
				return null;
			}
	  }
	  
	/*public static String convertEachother(String time, String oldFormat, String newFormat) {
		if(!CharUtils.isNotNullEmpty(time)) {
			return null;
		}
		SimpleDateFormat oldSdf = new SimpleDateFormat(oldFormat);
		SimpleDateFormat newSdf = new SimpleDateFormat(newFormat);
		Date date = null;
		try {
			date = oldSdf.parse(time);
		} catch (ParseException e) {
			return null;
		}
		return newSdf.format(date);
	}*/
	
	/**
	 * 判断当前时间是否为上午
	 * @author chengdaolin
	 * @date 2016-01-13
	 */
	public static boolean nowTimeIsAM() {  
		GregorianCalendar ca = new GregorianCalendar();  
		System.out.println();
		return ca.get(GregorianCalendar.AM_PM)==0?true:false;
	}
	
}
