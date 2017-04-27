package com.xoa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xoa.util.common.L;

/**
 * 
 * 创建作者: 张勇 创建日期: 2017-4-20 上午11:13:34 类介绍 : 日期格式化转换 构造参数:
 * 
 */
public class DateFormat {

	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdf_hour = new SimpleDateFormat("HH:mm");
	private static SimpleDateFormat sdf_mouth = new SimpleDateFormat(
			"MM月dd日 HH:mm");
	private static SimpleDateFormat sdf_year = new SimpleDateFormat(
			"yyyy年MM月dd日 HH:mm");
	private static final Long THREE_MINUTE_TIME = 1000 * 3 * 60L;
	private static final Long ONE_HOUR_TIME = 1000 * 3600L;
	private static final Long ONE_DAY_TIME = 1000 * 3600 * 24L;
	private static final Long TWO_DAY_TIME = 1000 * 3600 * 24 * 2L;

	/**
	 * 
	 * 创建作者: 张勇 创建日期: 2017-4-20 上午11:13:34 类介绍 : 字符串转换为时间戳 构造参数: @param time
	 * 需转换时间
	 * 
	 * @return: Integer 时间戳
	 * 
	 */
	public static Integer getTime(String time) {
		String re_time = null;
		Date d;
		try {
			d = sdf.parse(time);
			long l = d.getTime();
			String str = String.valueOf(l);
			re_time = str.substring(0, 10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(re_time);
	}

	/**
	 * 
	 * 创建作者: 张勇 创建日期: 2017-4-20 上午11:13:34 类介绍 : 将时间戳转为字符串 构造参数: @param time
	 * 需转换时间
	 * 
	 * @return: String 时间戳
	 * 
	 */
	public static String getStrTime(Integer time) {
		String re_StrTime = null;
		long lcc_time = Long.valueOf(time);
		re_StrTime = sdf.format(new Date(lcc_time * 1000L));
		return re_StrTime;
	}

	/**
	 * 
	 * 创建作者: 张勇 创建日期: 2017-4-20 上午11:13:34 类介绍 : 字符串转换为Date型 构造参数: @param time
	 * 需转换时间
	 * 
	 * @return: Date date型
	 * 
	 */
	public static Date getDate(String time) {
		Date re_time = null;
		try {
			re_time = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return re_time;
	}

	/**
	 * 
	 * 创建作者: 张勇 创建日期: 2017-4-20 上午11:13:34 类介绍 : date型转换为String 格式化 构造参数: @param
	 * time 需转换时间
	 * 
	 * @return: String 转换为字符串
	 * 
	 */
	public static String getStrDate(Date time) {
		String re_StrTime = null;
		re_StrTime = sdf.format(time);
		return re_StrTime;
	}

	public static void main(String[] args) {
		System.out.println(DateFormat.getStrTime(1492592887));
		System.out.println(DateFormat.getProbablyDate(new Date()));
		System.out.println(DateFormat.getProbablyDate("2016-12-03 23:11:22"));
	}
    
	/**
	 * 
	 * @作者 韩东堂
	 * @创建日期 2017-4-27 上午10:24:27 
	 * @方法介绍 格式化时间类
	 * @参数说明 @param obj 时间类型的类 例如 String："2016-12-03 23:11:22" ，Date，Integer ,Long 都可以
	 * @参数说明 @return
	 * @return
	 */
	public static String getProbablyDate(Object obj){
		if(obj==null) return null;
	    Date nowDate=	new Date();
		Long nowTime = nowDate.getTime();
		Long formatTime =null;
		if (obj instanceof String) {
			//String 转成 Date
			String dateStr = (String) obj;
			
			formatTime = getDate(dateStr).getTime();
		}
		if (obj instanceof Date) {
			//不用转了
			Date date = (Date) obj;
			formatTime=date.getTime();
			
		}
		if (obj instanceof Integer) {
			//数据库要成1000L
			Integer dateInt = (Integer) obj;
			formatTime=dateInt*1000L;
		}
		if (obj instanceof Long){
			//不用转了
			formatTime =(Long)obj;
		}
		if(formatTime==null) return null;
		L.w("formatTime is :",formatTime);
		Date formatDate=new Date(formatTime);
		String hourFat= sdf_hour.format(formatTime);
		String mouthFat= sdf_mouth.format(formatTime);
		String yearFat= sdf_year.format(formatTime);
		String ret = null;
		
		if(THREE_MINUTE_TIME<=1000*3*60L) {
			ret = "刚刚";
		}
		if(THREE_MINUTE_TIME<nowTime-formatTime&&nowTime-formatTime<=ONE_HOUR_TIME) {
			int minutes = (int) ((nowTime - formatTime)/(1000 * 60));  
			ret = minutes+"分钟前";
		}
		if(ONE_HOUR_TIME<nowTime-formatTime&&nowTime-formatTime<=ONE_DAY_TIME) {
			ret = "今天 "+hourFat;
		}
		if(ONE_DAY_TIME<nowTime-formatTime&&nowTime-formatTime<=TWO_DAY_TIME) {
			ret = "昨天 "+hourFat;
		}
		if(TWO_DAY_TIME<nowTime-formatTime) {
			ret = mouthFat;
		}
		Calendar fotCalendar =Calendar.getInstance();
		fotCalendar.setTime(formatDate);
		int forYear=fotCalendar.get(Calendar.YEAR);
		fotCalendar.setTime(nowDate);
		int nowYear=fotCalendar.get(Calendar.YEAR);
		if(nowYear-forYear>0){
			ret = yearFat;
		}
		return ret;
	}
}
