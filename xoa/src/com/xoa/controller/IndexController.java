package com.xoa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;


@Controller
@Scope(value="prototype")
public class IndexController {
	private Logger loger = Logger.getLogger(IndexController.class);
	@Resource
	private UsersService usersService;
	
	@RequestMapping("/index") //登录窗口
	public String login() {
		loger.info("成功登录！");
		return "login/index";
	}
	
	/**
	 * 分公司登录窗口
	 * @return 登录窗口
	 */
	@RequestMapping("/login1001") //登录窗口
	public String logins() {
		loger.info("进入登录页面！");
		return "login/1001/login2";
	}
	
	/**
	 * 登录窗口
	 * @return 登录窗口
	 */
	@RequestMapping("/main")
	// 登录窗口
	public String loginSuccess() {
		loger.info("成功登录！");
		return "app/main/index";
	}

	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public @ResponseBody  String loginsuccess(@RequestParam("username") String username, @RequestParam("password") String password,
            HttpServletRequest request,HttpServletResponse response) throws Exception{
		ToJson<Users> json=new ToJson<Users>(0, null);
		Users user=usersService.findUserByName(username);
		try {
			if (user==null) {
			loger.info("登录用户名不存在");
			request.getSession().setAttribute("message", "用户名不存在，请重新登录");
			    json.setObject(user);
	            json.setMsg("用户登录失败！");
	            json.setFlag(false);
			
			
		}else {
			if (user.getByname().equals(username)) {
				request.getSession().setAttribute("userName", username);
			}
			    json.setObject(user);
	            json.setMsg("用户登录成功！");
	            json.setFlag(true);
		   
		}
			
		} catch (Exception e) {
			json.setMsg(e.getMessage());

		}
		return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss"); 
		
	}
	
}
