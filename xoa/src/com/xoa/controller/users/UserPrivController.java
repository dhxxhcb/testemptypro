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

import com.xoa.model.users.UserPriv;
import com.xoa.service.users.UsersPrivService;
import com.xoa.util.ToJson;
 /**
 * @ClassName (类名):  UserPrivController
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午3:56:52
 *
 */
@Controller
@Scope(value="prototype")
public class UserPrivController {
	
	private Logger loger = Logger.getLogger(UserPrivController.class);
	
	@Resource
	UsersPrivService usersPrivService;
	
	/**
	 * @Title: addPriv
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param userPriv
	 * @param: @return   
	 * @return: ToJson<UserPriv>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/userPriv/addUser",method = RequestMethod.POST)
    public ToJson<UserPriv> addPriv(UserPriv userPriv) {
		ToJson<UserPriv> json=new ToJson<UserPriv>(0, null);
		try {
			usersPrivService.insertSelective(userPriv);
            json.setObject(userPriv);
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	/**
	 * @Title: deletePriv
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param userPriv
	 * @param: @return   
	 * @return: ToJson<UserPriv>   
	 * @throws
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
	 * @param: @param userPriv
	 * @param: @return   
	 * @return: ToJson<UserPriv>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/userPriv/findByuserPriv")
    public ToJson<UserPriv> findUserByuid(int userPriv) {
		ToJson<UserPriv> json=new ToJson<UserPriv>(0, null);
		try {
			UserPriv priv=usersPrivService.selectByPrimaryKey(userPriv);
			json.setObject(priv);;
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	/**
	 * @Title: getAllPriv
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param maps
	 * @param: @param page
	 * @param: @param pageSize
	 * @param: @param useFlag
	 * @param: @return   
	 * @return: ToJson<UserPriv>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/userPriv/getAllPriv",produces = {"application/json;charset=UTF-8"})
    public ToJson<UserPriv> getAllPriv(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) {
		ToJson<UserPriv> json=new ToJson<UserPriv>(0, null);
		try {
			List<UserPriv> list=usersPrivService.getAllPriv(maps,page,pageSize,useFlag);  
			json.setObj(list);
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
	/**
	 * @Title: getPrivByMany
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param userPriv
	 * @param: @return   
	 * @return: ToJson<UserPriv>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/userPriv/getPrivByMany")
    public ToJson<UserPriv> getPrivByMany(UserPriv userPriv) {
		ToJson<UserPriv> json=new ToJson<UserPriv>(0, null);
		try {
			List<UserPriv> list=usersPrivService.getPrivByMany(userPriv);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
	

}
