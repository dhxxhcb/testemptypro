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

import com.xoa.util.dataSource.ContextHolder;



/**
 * 日志
 * 
 * @author gaosubo
 * @version 1.0
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/diary")
public class LogUtilController {
	private Logger loger = Logger.getLogger(LogUtilController.class);

	/**
	 * 日志
	 * 
	 * @return
	 */
	@RequestMapping("/index")

	public String inboxPage(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/diary/index";
	}

	/**
	 * 写日志
	 * 
	 * @return
	 */
	@RequestMapping("/addbox")
	public String addboxPage(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/diary/writeMail";
	}
	/**
	 * 根据ID删除一条邮件`
	 */
	

}
