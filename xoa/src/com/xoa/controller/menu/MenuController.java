package com.xoa.controller.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sun.istack.internal.logging.Logger;
import com.xoa.model.menu.MobileApp;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.service.menu.MenuService;
import com.xoa.service.menu.MobileAppService;
import com.xoa.util.ToJson;
/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-18 下午6:34:34
 * 类介绍   :    菜单控制器
 * 构造参数:    无
 *
 */
@Controller
@Scope(value = "prototype")
public class MenuController {
	private Logger loger = Logger.getLogger(MenuController.class);
	@Resource
	private MenuService menuService;
	@Resource
	private MobileAppService mobileAppService;
	private int flag; 
	private	String err="err";
	private	String  ok="ok";
	

	
	 /**
	  * 
	  * 创建作者:   王曰岐
	  * 创建日期:   2017-4-18 下午6:35:04
	  * 方法介绍:   获取菜单和下面的子菜单
	  * 参数说明:   @return
	  * @return     String 返回JSON类型的菜单
	  */
	@RequestMapping(value = "/showMenu", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String showNew() {
		List<SysMenu> munuList = menuService.getAll();

		String msg;
		if (munuList.size() > 0) {
			flag = 0;
			msg = ok;
		} else {
			flag = 1;
			msg = err;
		}

		ToJson<SysMenu> menuJson = new ToJson<SysMenu>(flag, msg);
		menuJson.setObj(munuList);
		Map<String, String> map = new HashMap<String, String>();
		map.put("showMenu", JSON.toJSONStringWithDateFormat(menuJson,
				"yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
	}

	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:57:41
	 * 方法介绍:   获取一级菜单下面的子类菜单
	 * 参数说明:   @param request
	 * 参数说明:   @param response
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/showSubclassesMenu", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String showDadMenu(HttpServletRequest request, HttpServletResponse response) {
		String menuId = request.getParameter("menuId");
		List<SysFunction> list = menuService.getDadMenu(menuId);
		String msg;
		if (list.size() > 0) {
			flag = 0;
			msg = ok;
		} else {
			flag = 1;
			msg = err;
		}
		ToJson<SysFunction> menuJson = new ToJson<SysFunction>(flag, msg);
		menuJson.setObj(list);
		Map<String, String> map = new HashMap<String, String>();
		map.put("showSubclassesMenu", JSON.toJSONStringWithDateFormat(menuJson,
				"yyyy-MM-dd HH:mm:ss"));

		return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:59:56
	 * 方法介绍:   移动对应菜单
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/getMenu", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String getMenu() {
		List<MobileApp> munuList = mobileAppService.getMobileAppList();
		String msg;
		if (munuList.size() > 0) {
			flag = 0;
			msg = ok;
		} else {
			flag = 1;
			msg = err;
		}

		ToJson<MobileApp> menuJson = new ToJson<MobileApp>(flag, msg);
		menuJson.setObj(munuList);
		return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
		
		
		
	}

}
