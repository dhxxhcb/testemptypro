package com.xoa.controller.users;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
 * @ClassName (类名):  UsersController
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午2:55:40
 *
 */
@Controller
@Scope(value="prototype")
public class UsersController {
	private Logger loger = Logger.getLogger(UsersController.class);
	@Resource
	private UsersService usersService;
	
	/**
	 * @Title: addUser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param user
	 * @param: @return   
	 * @return: ToJson<Users>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/user/addUser",method = RequestMethod.POST)
    public ToJson<Users> addUser(Users user) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		try {
			usersService.addUser(user);
            json.setObject(user);
            json.setMsg("用户新增成功！");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	/**
	 * @Title: editUser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param user
	 * @param: @return   
	 * @return: ToJson<Users>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/user/editUser",method = RequestMethod.POST)
    public ToJson<Users> editUser(Users user) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		loger.debug("传过来的ID为"+user.getUid());
		try {
			usersService.editUser(user);
            json.setObject(user);
            json.setMsg("用户修改成功！");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	/**
	 * @Title: deletesUser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param user
	 * @param: @return   
	 * @return: ToJson<Users>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/user/deleteUser",method = RequestMethod.POST)
    public ToJson<Users> deletesUser(Users user) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		loger.debug("传过来的ID为"+user.getUid());
		try {
			usersService.deleteUser(user.getUid());
            json.setObject(user);
            json.setMsg("用户删除成功！");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	

	/**
	 * @Title: findUserByuid
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param uid
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/user/findUserByuid",method = RequestMethod.POST)
    public String findUserByuid(int uid) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		try {
			Users users=usersService.findUserByuid(uid);  
			json.setObject(users);;
            json.setMsg("查询用户成功！");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss");
    }
	
	/**
	 * @Title: getAllUser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param maps
	 * @param: @param page
	 * @param: @param pageSize
	 * @param: @param useFlag
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/user/getAlluser",produces = {"application/json;charset=UTF-8"})
    public String getAllUser( Map<String, Object> maps,Integer page,
			Integer pageSize, boolean useFlag) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		try {
			List<Users> list=usersService.getAlluser(maps,page,pageSize,useFlag);  
			json.setObj(list);
            json.setMsg("所有用户查询成功！");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
			System.out.println(e.getMessage());
		}
        return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss");
    }
	/**
	 * @Title: getDeptByMany
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param users
	 * @param: @return   
	 * @return: ToJson<Users>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/user/getDeptByMany",method = RequestMethod.POST)
    public ToJson<Users> getDeptByMany(Users users) {
		ToJson<Users> json=new ToJson<Users>(0, null);
		try {
			List<Users> list=usersService.getUserByMany(users);
            json.setObj(list);
            json.setMsg("多条件查询成功！");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
}
