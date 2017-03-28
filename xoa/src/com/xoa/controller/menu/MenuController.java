package com.xoa.controller.menu;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
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
	public SysMenu showNew() {
		loger.info("进入显示信息页面");
		List<SysMenu> list = menuService.getAll();
		SysMenu sMenu=new SysMenu();
		sMenu.setMenuList(list);
		return sMenu;
	}

	@RequestMapping("/showmenu1")
	@ResponseBody
	public SysFunction showDadMenu(){
		loger.info("进入显示信息页面");
		SysFunction function=new SysFunction();
		List<SysFunction> list = menuService.getDadMenu(sysmenu.getMenuId());
		
		List<SysFunction> list1 = menuService.getChildMenu(sysFunction.getMenuId());
		if (list1.size()>0) {
			
		for (SysFunction sysFunction2 : list1) {
			list.add(sysFunction2);
		}
		function.setFunctionList(list);
			
		}
		return function;
		
		
		
		
	}
	
		
	
	
	
	
}
