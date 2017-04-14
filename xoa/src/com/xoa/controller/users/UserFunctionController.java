package com.xoa.controller.users;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xoa.controller.menu.MenuController;
import com.xoa.service.users.UserFunctionService;


@Controller
@Scope(value="prototype")
public class UserFunctionController {
	
	private Logger loger = Logger.getLogger(MenuController.class);
	
	@Resource
	private UserFunctionService  userFunctionService;
	
	/*@RequestMapping("/showUser2")
	@ResponseBody
	public String show(){
		ToJson<SysFunction> sysList=userFunctionService.getMenu(63);
		Map<String, String> map = new HashMap<String, String>();
		map.put("showmenus", JSON.toJSONStringWithDateFormat(sysList, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(sysList, "yyyy-MM-dd HH:mm:ss");
		
	}*/
	/*@RequestMapping("/showUser4")
	@ResponseBody
	public String dep(){
		ToJson<Department> sysList=userFunctionService.getDep();
		Map<String, String> map = new HashMap<String, String>();
		map.put("showmenus", JSON.toJSONStringWithDateFormat(sysList, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(sysList, "yyyy-MM-dd HH:mm:ss");
		
	}
	@RequestMapping("/showUser5")
	@ResponseBody
	public String getUserAll(){
		ToJson<Users> sysList=userFunctionService.getUser(12);
		Map<String, String> map = new HashMap<String, String>();
		map.put("showmenus", JSON.toJSONStringWithDateFormat(sysList, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(sysList, "yyyy-MM-dd HH:mm:ss");
		
	}*/

}
