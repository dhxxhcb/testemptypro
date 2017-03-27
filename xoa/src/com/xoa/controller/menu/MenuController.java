package com.xoa.controller.menu;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xoa.controller.news.NewsController;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.model.worldnews.News;
import com.xoa.service.menu.MenuService;

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
		List<SysMenu> list = menuService.getAll();
		for(SysMenu news:list){
			loger.info("结果信息："+JSONArray.toJSONString(news));
		}
		return null;
	}

	@RequestMapping("/showmenu1")
	@ResponseBody
	public String showDadMenu(){
		loger.info("进入显示信息页面");
		List<SysFunction> list = menuService.getDadMenu(sysmenu.getMenuId());
		for (SysFunction sysFunction : list) {
			loger.info("结果信息："+JSONArray.toJSONString(sysFunction));
		
		}
		List<SysFunction> list1 = menuService.getChildMenu(sysFunction.getMenuId());
		if (list1.size()>0) {
			
		for (SysFunction sysFunction2 : list1) {
			loger.info("结果信息："+JSONArray.toJSONString(sysFunction2));
		}
		
			
		}
		return null;
		
		
		
		
	}
	
		
	
	
	
	
}
