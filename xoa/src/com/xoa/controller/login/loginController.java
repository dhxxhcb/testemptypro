package com.xoa.controller.login;

import com.xoa.model.users.OrgManage;
import com.xoa.model.users.Users;
import com.xoa.service.users.OrgManageService;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;
import com.xoa.util.common.L;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.dataSource.ContextHolder;
import com.xoa.util.http.HttpClientUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
	@Resource
	private OrgManageService  orgManageService;
	@Value("${app_login_path_php}")
	private String url;
	private String charset = "utf-8";
	

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
	public String cont() {
		return "app/main/cont";
	}

	@RequestMapping("/lunbo")
	// URL的/lunbo
	public String lunbo() {
		return "app/main/lunbo";
	}

	/**
	 * 分公司登录窗口
	 * 
	 * @return 登录窗口
	 */
	@RequestMapping(value = "/branchOfLanding", method = RequestMethod.GET)
	// 登录窗口
	public String getCompanyAll(@RequestParam("loginId") String loginId,
			HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("loginDateSouse", loginId);
		String LOCALE_SESSION_ATTRIBUTE_NAME = SessionLocaleResolver.class
				.getName() + ".LOCALE";
		Object locale = request.getSession().getAttribute(
				LOCALE_SESSION_ATTRIBUTE_NAME);
		return "login/" + loginId + "/login";
	}
	/**
	 * 分公司登录窗口
	 * 
	 * @return 登录窗口
	 */
	@RequestMapping(value = "/getCompanyAll", method = RequestMethod.GET)
	// 登录窗口
	public @ResponseBody ToJson<OrgManage> logins() {
		   return  orgManageService.queryId();
	}

	/**
	 * 
	 * 创建作者: 吴道全 创建日期: 2017-4-18 下午3:42:00 方法介绍: 跳转登录 参数说明: @return
	 * 
	 * @return String
	 */
	@RequestMapping("/main")
	// 登录窗口
	public String loginSuccess() {
		return "app/main/index";
	}

	/**
	 * 
	 * 创建作者: 王曰岐 创建日期: 2017-4-19 下午3:51:00 方法介绍: 匹配用户名和用户密码 参数说明: @param
	 * username 用户名 参数说明: @param password 密码
     * 参数说明: @param request 
     * 参数说明: @param userAgent mobile 移动   pc 网页
	 * response 参数说明: @return 参数说明: @throws Exception
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/login", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	ToJson<Users> loginEnter(@RequestParam("username") String username,
			@RequestParam("password") String password, String loginId,String userAgent,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(StringUtils.checkNull(loginId)){
			loginId = (String) request.getSession().getAttribute(
					"loginDateSouse");
		}else if ("mobile".equals(userAgent)){
			SessionUtils.putSession(request.getSession(), "loginDateSouse", loginId);
//			request.getSession().setAttribute("loginDateSouse", loginId);
		}
		ToJson<Users> json = new ToJson<Users>(0, null);
		if(StringUtils.checkNull(username)){
			json.setFlag(1);
			json.setMsg("err");
			return json;
		}
		
		ContextHolder.setConsumerType("xoa" + loginId);
		String httpOrgCreateTest = url;
		Map<String, String> createMap = new HashMap<String, String>();
		createMap.put("userid", username);
		createMap.put("password", password);
		String httpOrgCreateTestRtn = HttpClientUtil.doPost(httpOrgCreateTest,
				createMap, charset);
		L.a("Http response" + httpOrgCreateTestRtn);
		 if (httpOrgCreateTestRtn.trim().equals("ok")) {
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
				/*request.getSession().setAttribute("uid", user.getUid());
				request.getSession().setAttribute("userId", user.getUserId());
				request.getSession().setAttribute("userName", username);
				request.getSession().setAttribute("byname", user.getByname());
				request.getSession().setAttribute("password",
						user.getPassword());
				request.getSession().setAttribute("userPriv",
						user.getUserPriv());
				request.getSession().setAttribute("userPrivNo",
						user.getUserPriv());
				request.getSession().setAttribute("deptId", user.getDeptId());
				request.getSession().setAttribute("deptIdOther",
						user.getDeptIdOther());*/
				SessionUtils.putSession(request.getSession(), user);
				Map<String, Object> params =new HashMap<String, Object>();
				params.put("paraName", user.getPara().getParaName());
				params.put("paraValue", user.getPara().getParaValue());
				SessionUtils.putSession(request.getSession(), params);
				// }
				json.setObject(user);
				json.setMsg("OK");
				json.setFlag(0);

			}
		}else if (httpOrgCreateTestRtn.trim().equals("err")) {
			request.getSession().setAttribute("message", "errOne");
			json.setMsg("err");
			json.setFlag(1);
		} 
		return json;

	}
	@RequestMapping(value = "/logOut", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
   public String logOut(HttpServletRequest request){
	   request.getSession().invalidate();
	   request.getSession().removeAttribute("user");
	    return null;
	   
   }
}
