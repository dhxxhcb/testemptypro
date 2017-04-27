package com.xoa.controller.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.regexp.internal.recompile;
import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.dataSource.ContextHolder;

/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-4-26 下午4:58:41 
 * @类介绍  混合view试图类
 * @构造参数 无
 *
 */

@Controller
@RequestMapping("/bexa")
public class BodyExample {
	@Value("${app_login_path_php}")
	String b;
	@ResponseBody
	@RequestMapping("/json")
	public BaseWrapper test(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return new BaseWrapper();
	}
	@RequestMapping("/view")
	public String testView(Model model,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
//		model.addAttribute("name", "hahaha");
		model.addAttribute("name", b);
		return "index";
	}
}
