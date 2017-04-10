package com.test;

import java.util.Date;

import com.xoa.util.DateFormat;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(DateFormat.getStrTime(1378024916));
		System.out.println(DateFormat.getTime("2013-09-01 16:41:56"));
		System.out.println(DateFormat.getDate("2013-09-01 16:41:56"));
		System.out.println(DateFormat.getStrDate(new Date()));
		
	}
	

}
