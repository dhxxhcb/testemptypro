package com.xoa.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 创建作者:   朱振宇
 * 创建日期:   2017-4-27 上午11:42:15
 * 类介绍:     公共选人页面 
 * 构造参数: 
 *
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/diary")
public class CommonController {
	private Logger loger = Logger.getLogger(CommonController.class);

	/**
	 * 日志
	 * 
	 * @return
	 */
	@RequestMapping("/index")

	public String inboxPage() {
		return "app/diary/index";
	}

	/**
	 * 写日志
	 * 
	 * @return
	 */
	@RequestMapping("/addbox")
	public String addboxPage() {
		return "app/diary/writeMail";
	}
	/**
	 * 根据ID删除一条邮件`
	 */
	

}
