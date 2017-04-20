package com.xoa.dao.users;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.xoa.model.users.Users;

 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:33:32
 * 类介绍  :    用户
 * 构造参数:   
 *
 */
public interface UsersMapper {

	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:36:50
	 * 方法介绍:   根据别名查找用户
	 * 参数说明:   @param byname
	 * 参数说明:   @return
	 * @return     Users
	 */
	public Users findUserByName(@Param("byname") String byname);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:36:57
	 * 方法介绍:   根据uid查找用户姓名
	 * 参数说明:   @param uid
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getUsernameById(@Param("uid") int uid);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:37:25
	 * 方法介绍:   添加用户
	 * 参数说明:   @param user
	 * @return     void
	 */
	public void addUser(Users user);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:37:34
	 * 方法介绍:   修改用户
	 * 参数说明:   @param user
	 * @return     void
	 */
	public void editUser(Users user);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:37:44
	 * 方法介绍:   删除用户
	 * 参数说明:   @param uid
	 * @return     void
	 */
	public void deleteUser(int uid);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:37:53
	 * 方法介绍:   根据部门id查找部门信息
	 * 参数说明:   @param depId
	 * 参数说明:   @return
	 * @return     List<Users>
	 */
	public List<Users> getdepId(int depId);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:37:59
	 * 方法介绍:   格局userPriv查找用户
	 * 参数说明:   @param userPriv
	 * 参数说明:   @return
	 * @return     List<Users>
	 */
	public List<Users> getRoleId(int userPriv);
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:38:08
	 * 方法介绍:   获取所有用户
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     List<Users>
	 */
	public List<Users> getAlluser(Map<String,Object> maps);
		
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:38:15
	 * 方法介绍:   根据uid获取用户
	 * 参数说明:   @param uid
	 * 参数说明:   @return
	 * @return     Users
	 */
	public Users findUserByuid(int uid);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:38:23
	 * 方法介绍:   多条件查询用户
	 * 参数说明:   @param user
	 * 参数说明:   @return
	 * @return     List<Users>
	 */
	public List<Users> getUserByMany(Users user); 
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午7:19:41
	 * 方法介绍:   获取用户信息和部门名称
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     List<Users>
	 */
	public List<Users> getUserAndDept(Map<String,Object> maps);
	
	

	public List<Users> getBySearch(Map<String,Object> maps);


}
