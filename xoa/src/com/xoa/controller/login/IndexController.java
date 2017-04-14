package com.xoa.controller.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping(value="/login",method=RequestMethod.GET) //登录窗口
	public String logins(@RequestParam("loginId") String loginId) {
		return "login/"+loginId+"/login";
	}
	
	/**
	 * 登录窗口
	 * @return 登录窗口
	 */
	@RequestMapping("/main")
	// 登录窗口
	public String loginSuccess1() {
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
				request.getSession().setAttribute("uid", user.getUid());
				request.getSession().setAttribute("userId", user.getUserId());
				request.getSession().setAttribute("userName", username);
				request.getSession().setAttribute("byname", user.getByname());
				request.getSession().setAttribute("password", user.getPassword());
				request.getSession().setAttribute("userPriv", user.getUserPriv());
				request.getSession().setAttribute("userPrivNo", user.getUserPriv());
				request.getSession().setAttribute("deptId", user.getDeptId());
				request.getSession().setAttribute("deptIdOther", user.getDeptIdOther());
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
