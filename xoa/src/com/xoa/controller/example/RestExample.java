package com.xoa.controller.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.dataSource.ContextHolder;
/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-4-26 下午4:57:54 
 * @类介绍  纯数据接口示例类
 * @构造参数 无
 *
 */

@RestController
@RequestMapping("/example")
public class RestExample {
	
	@RequestMapping("/test")
	public BaseWrapper test(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return new BaseWrapper();
	}
}
