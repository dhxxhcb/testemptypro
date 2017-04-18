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
import com.xoa.model.menu.MobileAppModel;
import com.xoa.model.menu.SysFunctionModel;
import com.xoa.model.menu.SysMenuModel;
import com.xoa.service.menu.MenuService;
import com.xoa.service.menu.MobileAppService;
import com.xoa.util.ToJson;

@Controller
@Scope(value = "prototype")
public class MenuController {
	private Logger loger = Logger.getLogger(MenuController.class);
	@Resource
	private MenuService menuService;
	@Resource
	private MobileAppService mobileAppService;
	private int flag; 
	private String msg;

	
	/**
	 * 一级菜单列表
	 * @Title: showNew
	 * @Description: TODO
	 * @author(作者):      wyq
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/showMenu", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String showNew() {
		loger.info("进入显示信息页面");
		List<SysMenuModel> munuList = menuService.getAll();

		if (munuList.size() > 0) {
			flag = 0;
			msg = "成功";
		} else {
			flag = 1;
			msg = "失敗";
		}

		ToJson<SysMenuModel> menuJson = new ToJson<SysMenuModel>(flag, msg);
		menuJson.setObj(munuList);
		Map<String, String> map = new HashMap<String, String>();
		map.put("showMenu", JSON.toJSONStringWithDateFormat(menuJson,
				"yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
	}

	
	/**
	 * 获取一级菜单下面的子类菜单
	 * @Title: showDadMenu
	 * @Description: TODO
	 * @author(作者):      wyq
	 * @param: @param request
	 * @param: @param response
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/showSubclassesMenu", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String showDadMenu(HttpServletRequest request, HttpServletResponse response) {
		loger.info("进入显示信息页面");
		String menuId = request.getParameter("menuId");
		List<SysFunctionModel> list = menuService.getDadMenu(menuId);
		if (list.size() > 0) {
			flag = 0;
			msg = "成功";
		} else {
			flag = 1;
			msg = "失敗";
		}
		ToJson<SysFunctionModel> menuJson = new ToJson<SysFunctionModel>(flag, msg);
		menuJson.setObj(list);
		loger.info("结果信息："
				+ JSON.toJSONStringWithDateFormat(menuJson,
						"yyyy-MM-dd HH:mm:ss"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("showSubclassesMenu", JSON.toJSONStringWithDateFormat(menuJson,
				"yyyy-MM-dd HH:mm:ss"));

		return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 移动对应菜单
	 * @Title: getMenu
	 * @Description: TODO
	 * @author(作者):      wyq
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/getMenu", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String getMenu() {
		loger.info("进入显示信息页面");
		List<MobileAppModel> munuList = mobileAppService.getMobileAppList();
		if (munuList.size() > 0) {
			flag = 0;
			msg = "成功";
		} else {
			flag = 1;
			msg = "失敗";
		}

		ToJson<MobileAppModel> menuJson = new ToJson<MobileAppModel>(flag, msg);
		menuJson.setObj(munuList);
		Map<String, String> map = new HashMap<String, String>();
		map.put("showMenu", JSON.toJSONStringWithDateFormat(menuJson,
				"yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
		
		
		
	}

}
