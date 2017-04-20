package com.xoa.service.users.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.xoa.dao.users.UsersMapper;
import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
import com.xoa.util.page.PageParams;

 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:29:38
 * 类介绍  :    用户service接口实现类
 * 构造参数:   
 *
 */
@Service
public class UsersServiceImpl implements UsersService {
	
	@Resource
	private UsersMapper usersMapper;

	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午4:44:24
	 * 方法介绍:   添加用户
	 * 参数说明:   @param user
	 * @return     void   
	 */
	@Override
	public void addUser(Users user) {
		usersMapper.addUser(user);
	}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午4:44:34
	 * 方法介绍:   修改用户
	 * 参数说明:   @param user
	 * @return     void   
	 */
	@Override
	public void editUser(Users user) {
		usersMapper.editUser(user);
	}


	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:44:51
	 * 方法介绍:   删除用户
	 * 参数说明:   @param uid
	 * @return     void   
	 */
	@Override
	public void deleteUser(int uid) {
		usersMapper.deleteUser(uid);
	}
	
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午4:46:36
	 * 方法介绍:   获取所有用户
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * @return     List<Users>   
	 */
	@Override
	public List<Users> getAlluser(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag) {
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		return usersMapper.getAlluser(maps);	
	}

	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午4:46:52
	 * 方法介绍:   多条件查询
	 * 参数说明:   @param user
	 * 参数说明:   @return
	 * @return     List<Users>   
	 */
	@Override
	public List<Users> getUserByMany(Users user) {
		List<Users> list=usersMapper.getUserByMany(user);
		return list;
	}

	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午4:18:08
	 * 方法介绍:   获取用户信息和部门信息
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * @return     List<Users>   
	 */
	@Override
	public List<Users> getUserAndDept(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag) {
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		return usersMapper.getUserAndDept(maps);
	}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:01:06
	 * 方法介绍:   格局uid获取用户信息
	 * 参数说明:   @param uid
	 * 参数说明:   @return
	 * @return     Users   
	 */
	@Override
	public Users findUserByuid(int uid) {
		Users user=usersMapper.findUserByuid(uid);
		return user;
	}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:48:51
	 * 方法介绍:   根据别名获取用户信息
	 * 参数说明:   @param byname
	 * 参数说明:   @return
	 * @return     Users   
	 */
	@Override
	public Users findUserByName(String byname) {
		Users user=usersMapper.findUserByName(byname);
		return user;
	}
	@Override
	public List<Users> getBySearch(Map<String, Object> maps, Integer page, Integer pageSize, boolean useFlag) {
		// TODO Auto-generated method stub
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		return usersMapper.getBySearch(maps);
	}


}
