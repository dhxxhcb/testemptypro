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
import com.xoa.model.users.UserPriv;
import com.xoa.service.users.UsersPrivService;
import com.xoa.util.ToJson;
 
 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:05:02
 * 类介绍  :    用户角色权限表
 * 构造参数:   
 *
 */
@Controller
@Scope(value="prototype")
public class UserPrivController {
	
	private Logger loger = Logger.getLogger(UserPrivController.class);
	
	@Resource
	UsersPrivService usersPrivService;
	

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午8:05:22
	 * 方法介绍:   添加角色
	 * 参数说明:   @param userPriv
	 * 参数说明:   @return
	 * @return     ToJson<UserPriv>
	 */
	@ResponseBody
	@RequestMapping(value = "/userPriv/addUser",method = RequestMethod.POST)
    public ToJson<UserPriv> addPriv(UserPriv userPriv) {
		ToJson<UserPriv> json=new ToJson<UserPriv>(0, null);
		try {
			usersPrivService.insertSelective(userPriv);
            json.setObject(userPriv);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:28:46
	 * 方法介绍:   删除角色
	 * 参数说明:   @param userPriv
	 * 参数说明:   @return
	 * @return     ToJson<UserPriv>
	 */
	@ResponseBody
	@RequestMapping(value = "/userPriv/deletePriv",method = RequestMethod.POST)
    public ToJson<UserPriv> deletePriv(UserPriv userPriv) {
		ToJson<UserPriv> json=new ToJson<UserPriv>(0, null);
		loger.debug("ID"+userPriv.getUserPriv());
		try {
			usersPrivService.deleteByPrimaryKey(userPriv.getUserPriv());
            json.setObject(userPriv);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:28:59
	 * 方法介绍:   根据角色名称查找角色
	 * 参数说明:   @param userPriv
	 * 参数说明:   @return
	 * @return     ToJson<UserPriv>
	 */
	@ResponseBody
	@RequestMapping(value = "/userPriv/findByuserPriv")
    public ToJson<UserPriv> findUserByuid(int userPriv) {
		ToJson<UserPriv> json=new ToJson<UserPriv>(0, null);
		try {
			UserPriv priv=usersPrivService.selectByPrimaryKey(userPriv);
			json.setObject(priv);;
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:29:29
	 * 方法介绍:   获取所有角色
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * @return     ToJson<UserPriv>
	 */
	@ResponseBody
	@RequestMapping(value = "/userPriv/getAllPriv",produces = {"application/json;charset=UTF-8"})
    public String getAllPriv(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) {
		ToJson<UserPriv> json=new ToJson<UserPriv>(0, null);
		try {
			List<UserPriv> list=usersPrivService.getAllPriv(maps,page,pageSize,useFlag);  
			json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss");
    }
	
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:29:42
	 * 方法介绍:   多条件查找角色
	 * 参数说明:   @param userPriv
	 * 参数说明:   @return
	 * @return     ToJson<UserPriv>
	 */
	@ResponseBody
	@RequestMapping(value = "/userPriv/getPrivByMany")
    public ToJson<UserPriv> getPrivByMany(UserPriv userPriv) {
		ToJson<UserPriv> json=new ToJson<UserPriv>(0, null);
		try {
			List<UserPriv> list=usersPrivService.getPrivByMany(userPriv);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
	

}
