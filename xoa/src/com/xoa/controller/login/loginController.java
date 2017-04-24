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
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.alibaba.fastjson.JSON;
import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;

@Controller
@Scope(value="prototype")

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
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-18 下午3:15:40
	 * 方法介绍:   处理登录过程
	 * 参数说明:   @return
	 * @return     String 返回登录的jsp路径
	 */
	@RequestMapping("/index") //URL的/index
	public String login() {
		return "login/index";
	}
	
	@RequestMapping("/cont") //URL的/cont
	public String cont() {
		return "app/main/cont";
	}
	
	@RequestMapping("/lunbo") //URL的/lunbo
	public String lunbo() {
		return "app/main/lunbo";
	}

	/**
	 * 分公司登录窗口
	 * @return 登录窗口
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET) //登录窗口
	public String logins(@RequestParam("loginId") String loginId,HttpServletRequest request,HttpServletResponse response) {
		String LOCALE_SESSION_ATTRIBUTE_NAME = SessionLocaleResolver.class.getName() + ".LOCALE";
		Object locale = request.getSession().getAttribute(LOCALE_SESSION_ATTRIBUTE_NAME);
		
		loger.info("----------"+locale); 
		return "login/"+loginId+"/login";
	}
	
	/**
	 * 
	 * 创建作者:   吴道全
	 * 创建日期:   2017-4-18 下午3:42:00
	 * 方法介绍:   跳转登录
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping("/main") // 登录窗口
	public String loginSuccess() {
		return "app/main/index";
	}

	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:51:00
	 * 方法介绍:   匹配用户名和用户密码
	 * 参数说明:   @param username 用户名
	 * 参数说明:   @param password 密码
	 * 参数说明:   @param request 
	 * 参数说明:   @param response
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     String
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public @ResponseBody  String loginEnter(@RequestParam("username") String username, @RequestParam("password") String password,
            HttpServletRequest request,HttpServletResponse response) throws Exception{
		ToJson<Users> json=new ToJson<Users>(0, null);
		Users user=usersService.findUserByName(username);
		try {
			if (user==null) {
			request.getSession().setAttribute("message", "errOne");
			    json.setObject(user);
	            json.setMsg("err");
	            json.setFlag(1);
			
			
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
	            json.setMsg("OK");
	            json.setFlag(0);
		   
		}
			
		} catch (Exception e) {
			json.setMsg(e.getMessage());

		}
		return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss"); 
		
	}
	
}