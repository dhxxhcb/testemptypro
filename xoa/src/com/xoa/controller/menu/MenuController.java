package com.xoa.controller.menu;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
@Scope(value="prototype")
public class MenuController {
	private Logger loger = Logger.getLogger(MenuController.class);
	@Resource
	private MenuService menuService;
	private SysMenu sysmenu;
	private SysFunction sysFunction;
	private int flag;
	private String msg;
	


	@RequestMapping(value="/showMenu",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public @ResponseBody String  showNew() {
		loger.info("进入显示信息页面");
		List<SysMenu> munuList= menuService.getAll();
		
		if (munuList.size()>0) {
			flag=0;
			msg="成功";
		}else {
			flag=1;
			msg="失敗";
		}
		
		ToJson<SysMenu> menuJson=new ToJson<SysMenu>(flag, msg);
		menuJson.setObj(munuList);
		Map<String, String> map = new HashMap<String, String>();
		map.put("showMenu", JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
	}

	@RequestMapping(value="/showSubclassesMenu",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String showDadMenu(){
		loger.info("进入显示信息页面");
		List<SysFunction> list = menuService.getDadMenu(sysmenu.getMenuId(),sysFunction.getMenuId());
		if (list.size()>0) {
			flag=0;
			msg="成功";
		}else {
			flag=1;
			msg="失敗";
		}
		ToJson<SysFunction> menuJson=new ToJson<SysFunction>(flag, msg);
		   menuJson.setObj(list);
		loger.info("结果信息："+ JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("showSubclassesMenu", JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss"));

		return JSON.toJSONStringWithDateFormat(menuJson, "yyyy-MM-dd HH:mm:ss");
		}




	}







