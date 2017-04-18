package com.xoa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName (类名):  DateFormat
 * @Description(简述): 日期格式化转换 
 * @author(作者):      zy
 * @date(日期):        2017-4-17 下午2:49:50
 *
 */
public class DateFormat {

	/**
	 * 
	 * @Title: getTime
	 * @Description: 字符串转换为时间戳
	 * @author(作者):      zy
	 * @param: @param time 需转换时间
	 * @param: @return   
	 * @return: Integer   时间戳
	 * @throws
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
	 * 
	 * @Title: getStrTime
	 * @Description: 将时间戳转为字符串
	 * @author(作者):      zy
	 * @param: @param time 需转换的时间
	 * @param: @return   
	 * @return: String   字符串
	 * @throws
	 */
	public static String getStrTime(Integer time) {
		String re_StrTime = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lcc_time = Long.valueOf(time);
		re_StrTime = sdf.format(new Date(lcc_time * 1000L));
		return re_StrTime;
	}
	
	/**
	 * 
	 * @Title: getDate
	 * @Description: 字符串转换为Date型
	 * @author(作者):      zy
	 * @param: @param time 需转换时间
	 * @param: @return   
	 * @return: Date   日期类型
	 * @throws
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
	 * 
	 * @Title: getStrDate
	 * @Description: date型转换为String 格式化
	 * @author(作者):      zy
	 * @param: @param time 需转换时间
	 * @param: @return   
	 * @return: String   转换为字符串
	 * @throws
	 */
	public static String getStrDate(Date time){
		String re_StrTime = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		re_StrTime = sdf.format(time);
		return re_StrTime;
	}
	
	

}
