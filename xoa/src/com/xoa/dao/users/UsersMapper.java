package com.xoa.dao.users;

import com.xoa.model.users.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:33:32
 * 类介绍  :    用户
 * 构造参数:   无
 *
 */
public interface UsersMapper {

	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:36:50
	 * 方法介绍:   根据别名查找用户
	 * 参数说明:   @param byname 别名
	 * 参数说明:   @return
	 * @return     Users  用户信息
	 */
	public Users findUserByName(@Param("byname") String byname);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:36:57
	 * 方法介绍:   根据uid查找用户姓名
	 * 参数说明:   @param uid  用户uid
	 * 参数说明:   @return
	 * @return     String  用户姓名
	 */
	public String getUsernameById(int uid);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:37:25
	 * 方法介绍:   添加用户
	 * 参数说明:   @param user  用户信息
	 * @return     void  无
	 */
	public void addUser(Users user);
	
	
	public void insert(Users user);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:37:34
	 * 方法介绍:   修改用户
	 * 参数说明:   @param user  用户信息
	 * @return     void  无
	 */
	public void editUser(Users user);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:37:44
	 * 方法介绍:   删除用户
	 * 参数说明:   @param uid 用户编号
	 * @return     void 无
	 */
	public void deleteUser(int uid);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:37:53
	 * 方法介绍:   根据部门id查找部门信息
	 * 参数说明:   @param depId  部门id
	 * 参数说明:   @return
	 * @return     List<Users>  返回用户信息
	 */
	public List<Users> getdepId(int depId);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:37:59
	 * 方法介绍:   根据userPriv查找用户
	 * 参数说明:   @param userPriv  角色编号
	 * 参数说明:   @return
	 * @return     List<Users>  返回用户信息
	 */
	public List<Users> getRoleId(int userPriv);
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:38:08
	 * 方法介绍:   获取所有用户
	 * 参数说明:   @param maps 集合
	 * 参数说明:   @return
	 * @return     List<Users>   返回所有用户
	 */
	public List<Users> getAlluser(Map<String,Object> maps);
		
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:38:15
	 * 方法介绍:   根据uid获取用户
	 * 参数说明:   @param uid 用户编号
	 * 参数说明:   @return
	 * @return     Users  获取所有用户
	 */
	public Users findUserByuid(int uid);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:38:23
	 * 方法介绍:   多条件查询用户
	 * 参数说明:   @param user  用户 信息
	 * 参数说明:   @return
	 * @return     List<Users>  返回所有用户
	 */
	public List<Users> getUserByMany(Users user); 
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午7:19:41
	 * 方法介绍:   获取用户信息和部门名称
	 * 参数说明:   @param maps  集合
	 * 参数说明:   @return
	 * @return     List<Users>  返回用户信息
	 */
	public List<Users> getUserAndDept(Map<String,Object> maps);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月21日 上午10:43:52
	 * 方法介绍:   根据输入条件查找用户信息
	 * 参数说明:   @param maps  集合（封装条件）
	 * 参数说明:   @return
	 * @return     List<Users>  返回用户信息
	 */
	public List<Users> getBySearch(Map<String,Object> maps);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月21日 上午10:56:22
	 * 方法介绍:   根据部门编号查询用户信息
	 * 参数说明:   @param maps 集合（封装部门编号）
	 * 参数说明:   @return
	 * @return     List<Users> 返回部门信息
	 */
	public List<Users> getByDeptId(Map<String,Object> maps);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月25日 上午10:03:52
	 * 方法介绍:   根据uid查询用户姓名、部门、角色信息
	 * 参数说明:   @return
	 * @return     User
	 */
	public Users getByUid(int uid);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月26日 下午6:21:47
	 * 方法介绍:   根据userId串获取用户姓名
	 * 参数说明:   @param userId 用户userId串
	 * 参数说明:   @return
	 * @return     String 返回用户姓名拼接串
	 */
	public String getUsernameByUserId(String userId);

     List<Users> getUserByDeptId(Users user);

     List<Users> getUserByRoleId(Users user);

     List<Users> getUserOnline();

	 List<Users> getUserbyCondition(Map<String,Object> maps);
     List<Users> getUserNameByFuncId(String fid);

     List<String> getUserByFuncId(String fid);

     List<String> findUsersByIds(Map<String, List> hashMap);
     List<Users> checkPassWord(String userName);

 }
