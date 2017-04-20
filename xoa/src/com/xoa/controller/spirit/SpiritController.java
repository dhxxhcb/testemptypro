package com.xoa.controller.spirit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:42:39
 * 类介绍  :    用户
 * 构造参数:   
 *
 */
@Controller
@Scope(value="prototype")
@RequestMapping("/email")
public class SpiritController {
	private Logger loger = Logger.getLogger(SpiritController.class);
	@Resource
	private UsersService usersService;
	
	@RequestMapping("/index") //URL的/index
	public String login() {
		return "login/index";
	}
	
	
}
