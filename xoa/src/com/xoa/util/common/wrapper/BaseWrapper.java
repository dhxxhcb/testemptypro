package com.xoa.util.common.wrapper;

import java.util.Date;

/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-4-24 下午3:28:59
 * @类介绍 基本包装类
 * @构造参数 无 或者带必要参数
 * 
 */
public class BaseWrapper {
	boolean status;
	boolean flag;
	String msg;
	Date time;

	public BaseWrapper() {
		super();
		this.time = new Date();
		
	}

	public BaseWrapper(boolean status, boolean flag, String msg) {
		super();
		this.status = status;
		this.flag = flag;
		this.msg = msg;
		this.time = new Date();
		;
	}

	public boolean getStatus() {
		return status; 
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getTime() {
		if (time == null) {
			time = new Date();
		}
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
