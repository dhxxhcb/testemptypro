package com.xoa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午11:13:34
 * 类介绍  :   日期格式化转换 
 * 构造参数:   
 *
 */
public class DateFormat {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:13:34
	 * 类介绍  :   字符串转换为时间戳
	 * 构造参数:  @param time 需转换时间
	 * @return: Integer   时间戳
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
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:13:34
	 * 类介绍  :    将时间戳转为字符串
	 * 构造参数:  @param time 需转换时间
	 * @return: String   时间戳
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
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:13:34
	 * 类介绍  :    字符串转换为Date型
	 * 构造参数:  @param time 需转换时间
	 * @return: Date   date型
	 *
	 */
	public static Date getDate(String time){
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
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:13:34
	 * 类介绍  :    date型转换为String 格式化
	 * 构造参数:  @param time 需转换时间
	 * @return: String   转换为字符串
	 *
	 */
	public static String getStrDate(Date time){
		String re_StrTime = null;
		re_StrTime = sdf.format(time);
		return re_StrTime;
	}
	
	public static void main(String[] args) {
		System.out.println(DateFormat.getStrTime(1492592887));
	}
	
	
	

}
