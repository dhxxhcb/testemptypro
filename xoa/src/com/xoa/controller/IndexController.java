package com.xoa.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.xoa.model.menu.SysMenu;
import com.xoa.model.users.Users;
import com.xoa.service.menu.MenuService;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;

@Controller
@Scope(value = "prototype")
public class IndexController {
	private Logger loger = Logger.getLogger(IndexController.class);
	@Resource
	private UsersService usersService;
	@Resource
	private MenuService menuService;
	private int flag;
	private String msg;

	@RequestMapping("/index")
	// 登录窗口
	public String login() {
		loger.info("成功登录！");
		return "login/index";
	}

	/**
	 * 分公司登录窗口
	 * 
	 * @return 登录窗口
	 */
	@RequestMapping("/login1001")
	// 登录窗口
	public String logins() {
		loger.info("进入登录页面！");
		return "login/1001/login2";
	}

	/**
	 * 登录窗口
	 * 
	 * @return 登录窗口
	 */
	@RequestMapping("/main")
	// 登录窗口
	public String loginSuccess() {
		loger.info("成功登录！");
		return "app/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String loginsuccess(@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Users user = usersService.findUserByName(username);
		if (user == null) {
			loger.info("登录用户名不存在");
			request.getSession().setAttribute("message", "用户名不存在，请重新登录");
			flag = 1;
			msg = "失败";
		} else {
			if (user.getByname().equals(username)) {
				request.getSession().setAttribute("user", user);
			}
			flag = 0;
			msg = "成功";
		}
		ToJson<Users> json = new ToJson<Users>(0, null);
		json.setObject(user);
		Map<String, String> map = new HashMap<String, String>();
		map.put("/login",
				JSON.toJSONStringWithDateFormat(json, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(json, "yyyy-MM-dd HH:mm:ss");

	}
	@RequestMapping(value = "/showMenu", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String showNew(HttpServletRequest request, HttpServletResponse response) {
		loger.info("进入显示信息页面");
		Users user=(Users) request.getSession().getAttribute("user");
		List<SysMenu> munuList = menuService.getAll(4);
		if (munuList.size() > 0) {
			flag = 0;
			msg = "成功";
		} else {
			flag = 1;
			msg = "失败";
		}
		ToJson<SysMenu> menuJson = new ToJson<SysMenu>(flag, msg);
		menuJson.setObj(munuList);
		Map<String, String> map = new HashMap<String, String>();
		map.put("showMenu", JSON.toJSONStringWithDateFormat(menuJson,
				"yyyy-MM-dd HH:mm:ss"));
		loger.info("结果信息："
				+ JSON.toJSONStringWithDateFormat(menuJson,
						"yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
	}

}
