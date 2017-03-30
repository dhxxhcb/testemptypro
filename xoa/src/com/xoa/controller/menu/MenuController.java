package com.xoa.controller.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.model.worldnews.News;
import com.xoa.service.menu.MenuService;
import com.xoa.util.ToJson;

@Controller
@Scope(value="prototype")
public class MenuController {
	private Logger loger = Logger.getLogger(MenuController.class);
	@Resource
	private MenuService menuService;
	private SysMenu sysmenu;
	private SysFunction sysFunction;


	@RequestMapping("/showmenu")
	@ResponseBody
	public String showNew() {
		loger.info("进入显示信息页面");
		ToJson<SysMenu> toJson = menuService.getAll();
		loger.info("结果信息："+ JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("showmenus", JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss");
	}

	@RequestMapping("/showmenu1")
	@ResponseBody
	public String showDadMenu(){
		loger.info("进入显示信息页面");
		ToJson<SysFunction> list = menuService.getDadMenu(sysmenu.getMenuId(),sysFunction.getMenuId());
		loger.info("结果信息："+ JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("showmenus", JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));

		return JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss");
		}




	}







