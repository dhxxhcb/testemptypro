package com.xoa.controller.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:42:39
 * 类介绍  :    用户
 * 构造参数:   
 *
 */
@Controller
@Scope(value="prototype")
public class UsersController {
	private Logger loger = Logger.getLogger(UsersController.class);
	@Resource
	private UsersService usersService;
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:43:04
	 * 方法介绍:   添加用户
	 * 参数说明:   @param user
	 * 参数说明:   @return
	 * @return     ToJson<Users>
	 */
	@ResponseBody
	@RequestMapping(value = "/user/addUser",method = RequestMethod.POST)
    public ToJson<Users> addUser(Users user) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		try {
			usersService.addUser(user);
            json.setObject(user);
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:53:11
	 * 方法介绍:   修改用户
	 * 参数说明:   @param user
	 * 参数说明:   @return
	 * @return     ToJson<Users>
	 */
	@ResponseBody
	@RequestMapping(value = "/user/editUser",method = RequestMethod.POST)
    public ToJson<Users> editUser(Users user) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		loger.debug("ID"+user.getUid());
		try {
			usersService.editUser(user);
            json.setObject(user);
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:53:19
	 * 方法介绍:   删除用户
	 * 参数说明:   @param user
	 * 参数说明:   @return
	 * @return     ToJson<Users>
	 */
	@ResponseBody
	@RequestMapping(value = "/user/deleteUser",method = RequestMethod.POST)
    public ToJson<Users> deletesUser(Users user) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		loger.debug("ID"+user.getUid());
		try {
			usersService.deleteUser(user.getUid());
            json.setObject(user);
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:53:27
	 * 方法介绍:   根据uid查询用户
	 * 参数说明:   @param uid
	 * 参数说明:   @return
	 * @return     String
	 */
	@ResponseBody
	@RequestMapping(value = "/user/findUserByuid",method = RequestMethod.POST)
    public String findUserByuid(int uid) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		try {
			Users users=usersService.findUserByuid(uid);  
			json.setObject(users);;
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss");
    }
	

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:53:36
	 * 方法介绍:   获取所有用户
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * @return     String
	 */
	@ResponseBody
	@RequestMapping(value = "/user/getAlluser",produces = {"application/json;charset=UTF-8"})
    public String getAllUser( Map<String, Object> maps,Integer page,
			Integer pageSize, boolean useFlag) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		try {
			List<Users> list=usersService.getAlluser(maps,page,pageSize,useFlag);  
			json.setObj(list);
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
			System.out.println(e.getMessage());
		}
        return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss");
    }
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:53:43
	 * 方法介绍:   根据多条件查询部门
	 * 参数说明:   @param users
	 * 参数说明:   @return
	 * @return     ToJson<Users>
	 */
	@ResponseBody
	@RequestMapping(value = "/user/getDeptByMany",method = RequestMethod.POST)
    public ToJson<Users> getDeptByMany(Users users) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		try {
			List<Users> list=usersService.getUserByMany(users);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午7:16:57
	 * 方法介绍:   获取用户名称以及用户信息
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * @return     String
	 */
	@ResponseBody
	@RequestMapping(value = "/user/getUserAndDept" ,produces = {"application/json;charset=UTF-8"})
    public String getUserAndDept( Map<String, Object> maps,Integer page,
			Integer pageSize, boolean useFlag) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		try {
			List<Users> list=usersService.getUserAndDept(maps,page,pageSize,useFlag);  
			json.setObj(list);
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
			System.out.println(e.getMessage());
		}
        return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss");
    }
	
	
	@ResponseBody
	@RequestMapping(value = "/user/getBySearch" ,produces = {"application/json;charset=UTF-8"})
    public String getBySearch(HttpServletRequest request,Map<String, Object> maps,Integer page,
			Integer pageSize, boolean useFlag) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		try {
			request.setCharacterEncoding("UTF-8");
			String search=new String(request.getParameter("search").getBytes("ISO-8859-1"),"UTF-8");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("search", search);
			List<Users> list=usersService.getBySearch(maps,page,pageSize,useFlag);  
			json.setObj(list);
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
			System.out.println(e.getMessage());
		}
        return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss");
    }
	
	
}
