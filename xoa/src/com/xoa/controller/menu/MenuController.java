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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sun.istack.internal.logging.Logger;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.service.menu.MenuService;
import com.xoa.util.ToJson;

@Controller
@Scope(value = "prototype")
public class MenuController {
	private Logger loger = Logger.getLogger(MenuController.class);
	@Resource
	private MenuService menuService;
	private int flag;
	private String msg;

	/**
	 * 一级菜单列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/showMenu", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String showNew() {
		loger.info("进入显示信息页面");
		List<SysMenu> munuList = menuService.getAll();

		if (munuList.size() > 0) {
			flag = 0;
			msg = "成功";
		} else {
			flag = 1;
			msg = "失敗";
		}

		ToJson<SysMenu> menuJson = new ToJson<SysMenu>(flag, msg);
		menuJson.setObj(munuList);
		Map<String, String> map = new HashMap<String, String>();
		map.put("showMenu", JSON.toJSONStringWithDateFormat(menuJson,
				"yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取一级菜单下面的子类菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/showSubclassesMenu", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String showDadMenu(HttpServletRequest request, HttpServletResponse response) {
		loger.info("进入显示信息页面");
		String menuId = request.getParameter("menuId");
		String funId = request.getParameter("funId");
		List<SysFunction> list = menuService.getDadMenu(menuId, funId);
		if (list.size() > 0) {
			flag = 0;
			msg = "成功";
		} else {
			flag = 1;
			msg = "失敗";
		}
		ToJson<SysFunction> menuJson = new ToJson<SysFunction>(flag, msg);
		menuJson.setObj(list);
		loger.info("结果信息："
				+ JSON.toJSONStringWithDateFormat(menuJson,
						"yyyy-MM-dd HH:mm:ss"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("showSubclassesMenu", JSON.toJSONStringWithDateFormat(menuJson,
				"yyyy-MM-dd HH:mm:ss"));

		return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
	}
	@RequestMapping("/content")
	//公告通知list
	public String noticeIndexPage() {
		return "app/main/notify";
	}

}
