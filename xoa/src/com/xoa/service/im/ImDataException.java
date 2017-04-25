package com.xoa.service.im;

import com.xoa.util.common.L;

/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-4-24 下午5:31:23 
 * @类介绍 Im数据异常类
 * @构造参数 无
 *
 */
public class ImDataException extends RuntimeException {
    public ImDataException() {
		// TODO Auto-generated constructor stub
    	super();
	}
    public ImDataException(String messsage) {
		// TODO Auto-generated constructor stub
    	super(messsage);
    	L.e(messsage);
	}
}
