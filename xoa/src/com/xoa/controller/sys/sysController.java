package com.xoa.controller.sys;

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
 * 
 * 创建作者:   朱振宇
 * 创建日期:   2017-4-27 上午11:42:15
 * 类介绍:     系统设置页面
 * 构造参数: 
 *
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/sys")
public class sysController {
	private Logger loger = Logger.getLogger(sysController.class);

	@RequestMapping("/companyInfo")
	public String companyInfo(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/sys/companyInfo";
	}
}
