package com.xoa.controller.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.regexp.internal.recompile;
import com.xoa.util.common.wrapper.BaseWrapper;

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
  
	@ResponseBody
	@RequestMapping("/json")
	public BaseWrapper test(){
		return new BaseWrapper();
	}
	@RequestMapping("/view")
	public String testView(Model model){
		model.addAttribute("name", "hahaha");
		return "index";
	}
}
