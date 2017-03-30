package com.xoa.controller.users;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.xoa.controller.menu.MenuController;
import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;

@Controller
@Scope(value="prototype")
public class UsersController {
	private Logger loger = Logger.getLogger(MenuController.class);
	@Resource
	private UsersService usersService;
	

	/**
	 * 新增用户
	 * @return
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
	 * 修改用户
     * 
     * @param user
     * @return
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
	 * 删除某个用户
	 * @param userId
	 * @param out
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
}
