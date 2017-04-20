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
 * 
 * 创建作者:   朱振宇
 * 创建日期:   2017-4-20 上午11:55:52
 * 类介绍:     精灵对应页面控制器
 * 构造参数: 
 *
 */
@Controller
@Scope(value="prototype")
public class SpiritController {
	private Logger loger = Logger.getLogger(SpiritController.class);
	@Resource
	private UsersService usersService;
	
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

	
}
