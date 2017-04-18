package com.xoa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化转换 
 * @author zy
 * @version 1.0
 *
 */
public class DateFormat {
	/**
	 * 字符串转换为时间戳
	 * 
	 * @param time
	 * @return
	 */
	public static Integer getTime(String time) {
		String re_time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
	 * 将时间戳转为字符串
	 */
	public static String getStrTime(Integer time) {
		String re_StrTime = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lcc_time = Long.valueOf(time);
		re_StrTime = sdf.format(new Date(lcc_time * 1000L));
		return re_StrTime;
	}
	
	/**
	 * 字符串转换为Date型
	 * @param time
	 * @return
	 */
	public static Date getDate(String time){
		Date re_time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			re_time = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return re_time;
	}
	
	/**
	 * date型转换为String 格式化
	 * @param time
	 * @return
	 */
	public static String getStrDate(Date time){
		String re_StrTime = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		re_StrTime = sdf.format(time);
		return re_StrTime;
	}
	
	

}
