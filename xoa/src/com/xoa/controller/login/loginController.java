package com.xoa.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;
import com.xoa.util.common.L;
import com.xoa.util.dataSource.ContextHolder;
import com.xoa.util.http.HttpClientUtil;

@Controller
@Scope(value = "prototype")
/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-18 下午3:11:29
 * 类介绍    :   登录控制器
 * 构造参数:   无
 *
 */
public class loginController {
	private Logger loger = Logger.getLogger(loginController.class);
	@Resource
	private UsersService usersService;
	@Value("${app_login_path_php}")
	private String url;
	private String charset = "utf-8";
	private HttpClientUtil httpClientUtil = null;

	/**
	 * 
	 * 创建作者: 王曰岐 创建日期: 2017-4-18 下午3:15:40 方法介绍: 处理登录过程 参数说明: @return
	 * 
	 * @return String 返回登录的jsp路径
	 */
	@RequestMapping("/index")
	// URL的/index
	public String login() {
		return "login/index";
	}

	@RequestMapping("/cont")
	// URL的/cont
	public String cont(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/main/cont";
	}

	@RequestMapping("/lunbo")
	// URL的/lunbo
	public String lunbo(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/main/lunbo";
	}

	/**
	 * 分公司登录窗口
	 * 
	 * @return 登录窗口
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	// 登录窗口
	public String logins(@RequestParam("loginId") String loginId,
			HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("loginDateSouse", loginId);
		String LOCALE_SESSION_ATTRIBUTE_NAME = SessionLocaleResolver.class
				.getName() + ".LOCALE";
		Object locale = request.getSession().getAttribute(
				LOCALE_SESSION_ATTRIBUTE_NAME);
		return "login/" + loginId + "/login";
	}

	/**
	 * 
	 * 创建作者: 吴道全 创建日期: 2017-4-18 下午3:42:00 方法介绍: 跳转登录 参数说明: @return
	 * 
	 * @return String
	 */
	@RequestMapping("/main")
	// 登录窗口
	public String loginSuccess(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/main/index";
	}

	/**
	 * 
	 * 创建作者: 王曰岐 创建日期: 2017-4-19 下午3:51:00 方法介绍: 匹配用户名和用户密码 参数说明: @param
	 * username 用户名 参数说明: @param password 密码 参数说明: @param request 参数说明: @param
	 * response 参数说明: @return 参数说明: @throws Exception
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	ToJson<Users> loginEnter(@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String loginId = (String) request.getSession().getAttribute(
				"loginDateSouse");
		ToJson<Users> json = new ToJson<Users>(0, null);
		ContextHolder.setConsumerType("xoa" + loginId);
		// String httpOrgCreateTest = url + "httpOrg/create";
		// Map<String,String> createMap = new HashMap<String,String>();
		// createMap.put("userid","username");
		// createMap.put("password","password");
		// String httpOrgCreateTestRtn =
		// httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);
		// L.a("信息"+httpOrgCreateTestRtn);
		// if (httpOrgCreateTestRtn.equals("err")) {
		// request.getSession().setAttribute("message", "errOne");
		// json.setMsg("err");
		// json.setFlag(1);
		// }else if (httpOrgCreateTestRtn.equals("ok"))

		Users user = usersService.findUserByName(username, request);
		if (user == null) {
			L.a("login erro");
			request.getSession().setAttribute("message", "errOne");
			json.setObject(user);
			json.setMsg("err");
			json.setFlag(1);
		} else {
			// if (user.getByname().equals(username)) {
			// L.a("login success");
			request.getSession().setAttribute("uid", user.getUid());
			request.getSession().setAttribute("userId", user.getUserId());
			request.getSession().setAttribute("userName", username);
			request.getSession().setAttribute("byname", user.getByname());
			request.getSession().setAttribute("password", user.getPassword());
			request.getSession().setAttribute("userPriv", user.getUserPriv());
			request.getSession().setAttribute("userPrivNo", user.getUserPriv());
			request.getSession().setAttribute("deptId", user.getDeptId());
			request.getSession().setAttribute("deptIdOther",
					user.getDeptIdOther());
			// }
			json.setObject(user);
			json.setMsg("OK");
			json.setFlag(0);

		}

		return json;

	}

	/*
	 * public loginController(){ httpClientUtil = new HttpClientUtil(); }
	 */

	/*
	 * public void loginCheck(@RequestParam("username") String username,
	 * @RequestParam("password") String password ){ String httpOrgCreateTest =
	 * url + "httpOrg/create"; Map<String,String> createMap = new
	 * HashMap<String,String>(); createMap.put("userid","username");
	 * createMap.put("password","password"); String httpOrgCreateTestRtn =
	 * httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);
	 * System.out.println("result:"+httpOrgCreateTestRtn); }
	 */

}
