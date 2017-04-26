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
	  * 创建日期:   2017年4月21日 上午10:27:07
	  * 方法介绍:   根据输入条件进行查询
	  * 参数说明:   @param maps 集合
	  * 参数说明:   @param page 当前页面
	  * 参数说明:   @param pageSize  页面大小
	  * 参数说明:   @param useFlag  是否开启分页
	  * 参数说明:   @return
	  * @return     List<Users>   返回用户信息   
	  */
	@DynDatasource
	public List<Users> getAlluser(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:29:25
	 * 方法介绍:   多条件查询用户
	 * 参数说明:   @param user 用户信息
	 * 参数说明:   @return
	 * @return     List<Users>  返回用户信息
	 */
	@DynDatasource
	public List<Users> getUserByMany(Users user); 
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:17:43
	 * 方法介绍:   获取用户信息和部门信息
	 * 参数说明:   @param maps  集合
	 * 参数说明:   @param page  当前页面
	 * 参数说明:   @param pageSize  页面大小
	 * 参数说明:   @param useFlag  是否开启分页
	 * 参数说明:   @return 
	 * @return     List<Users>   返回用户信息
 	 */
	@DynDatasource
	public List<Users> getUserAndDept(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:00:12
	 * 方法介绍:   格局uid查询用户
	 * 参数说明:   @param uid 用户uid
	 * 参数说明:   @return
	 * @return     Users  返回用户信息
	 */
	@DynDatasource
	public Users findUserByuid(int uid);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:18:08
	 * 方法介绍:   根据别名查找用户
	 * 参数说明:   @param byname  别名
	 * 参数说明:   @return
	 * @return     Users  返回用户信息
	 */
//	@DynDatasource
    public Users findUserByName( String byname);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 下午6:40:15
	 * 方法介绍:   根据查询条件查找用户
	 * 参数说明:   @param maps  集合
	 * 参数说明:   @param page  当前页面
	 * 参数说明:   @param pageSize  页面大小
	 * 参数说明:   @param useFlag  是否开启分页
	 * 参数说明:   @return
	 * @return     List<Users>  返回用户信息
	 */
	@DynDatasource
	public List<Users> getBySearch(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月21日 上午11:00:05
	 * 方法介绍:   根据部门id查询用户信息
	 * 参数说明:   @param maps  集合
	 * 参数说明:   @param page  当前页面
	 * 参数说明:   @param pageSize  页面大小
	 * 参数说明:   @param useFlag  是否开启分页
	 * 参数说明:   @return
	 * @return     List<Users>  返回用户信息
	 */
	@DynDatasource
	public List<Users> getByDeptId(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag);	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月25日 上午10:06:33
	 * 方法介绍:   根据uid查询用户姓名、部门、角色信息
	 * 参数说明:   @param uid 用户uid
	 * 参数说明:   @return
	 * @return     Users 返回用户信息
	 */
	@DynDatasource
	public Users getByUid(int uid);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月21日 上午11:00:05
	 * 方法介绍:   根据uid串获取用户姓名
	 * 参数说明:   @param userIds 用户userid串
	 * 参数说明:   @return
	 * @return     List<String>  返回用户姓名集合
	 */
	@DynDatasource
	public List<String> getUserNameById(String userIds);
}
