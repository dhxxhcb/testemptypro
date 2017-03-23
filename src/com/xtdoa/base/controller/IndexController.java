package com.xtdoa.base.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xtdoa.base.service.UserService;




@Controller
@Scope(value="prototype")
public class IndexController {
	private Logger loger = Logger.getLogger(IndexController.class);
//	@Resource
//	private UserService userService;

	
	/**
	 * 登录窗口
	 * @return 登录窗口
	 */
	@RequestMapping("/login") //登录窗口
	public String login() {
		loger.info("进入登录页面！");
		return "login";
	}
	
	/**
	 * 登录窗口
	 * @return 登录窗口
	 */
	@RequestMapping("/mainemp") //登录窗口
	public String loginSuccess() {
		loger.info("成功登录！");
		return "login/mainemp";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView loginsuccess(@RequestParam("username") String username, @RequestParam("password") String password,
            HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
//		String userName = request.getParameter("username");
//		String passWord = request.getParameter("password");
		loger.info("用户名："+username+"\t 密码："+password);
		if("admin".trim().equals(username) && "admin".trim().equals(password)){
			loger.info("成功登录");
			request.setAttribute("userName", username);
			modelAndView.setViewName("redirect:/mainemp");
		}else{
			loger.info("登录失败");
			modelAndView.setViewName("redirect:/login");
		}
		return modelAndView;
	}
	
}
