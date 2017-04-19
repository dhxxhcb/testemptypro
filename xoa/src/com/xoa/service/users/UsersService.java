package com.xoa.service.users;

import java.util.List;
import java.util.Map;

import com.xoa.model.users.Users;
import com.xoa.util.dataSource.DynDatasource;


 
 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:29:57
 * 类介绍  :    用户service层接口
 * 构造参数:   
 *
 */
public interface UsersService {	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午4:25:08
	 * 方法介绍:   添加用户
	 * 参数说明:   @param user
	 * @return     void
	 */
	@DynDatasource
	public void addUser(Users user);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:25:14
	 * 方法介绍:   修改用户
	 * 参数说明:   @param user
	 * @return     void
	 */
	@DynDatasource
	public void editUser(Users user);	

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:25:20
	 * 方法介绍:   删除用户
	 * 参数说明:   @param uid
	 * @return     void
	 */
	@DynDatasource
	public void deleteUser(int uid);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:25:35
	 * 方法介绍:   获取所有用户
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * @return     List<Users>
	 */
	@DynDatasource
	public List<Users> getAlluser(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:29:25
	 * 方法介绍:   多条件查询用户
	 * 参数说明:   @param user
	 * 参数说明:   @return
	 * @return     List<Users>
	 */
	@DynDatasource
	public List<Users> getUserByMany(Users user); 
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:17:43
	 * 方法介绍:   获取用户信息和部门信息
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * @return     List<Users>
	 */
	@DynDatasource
	public List<Users> getUserAndDept(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:00:12
	 * 方法介绍:   格局uid查询用户
	 * 参数说明:   @param uid
	 * 参数说明:   @return
	 * @return     Users
	 */
	@DynDatasource
	public Users findUserByuid(int uid);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:18:08
	 * 方法介绍:   根据别名查找用户
	 * 参数说明:   @param byname
	 * 参数说明:   @return
	 * @return     Users
	 */
	@DynDatasource
    public Users findUserByName( String byname);

}
