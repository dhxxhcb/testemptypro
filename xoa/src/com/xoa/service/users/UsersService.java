package com.xoa.service.users;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xoa.model.users.Users;
import com.xoa.util.ToJson;


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
	public ToJson<Users> addUser(Users user);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:25:14
	 * 方法介绍:   修改用户
	 * 参数说明:   @param user
	 * @return     ToJson<Users>
	 */
	public ToJson<Users> editUser(Users user);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月22日 下午1:28:01
	 * 方法介绍:   修改
	 * 参数说明:   @param uid 主键
	 * 参数说明:   @param userName 用户名
	 * 参数说明:   @param sex 性别
	 * 参数说明:   @param birthday 生日
	 * 参数说明:   @param email 邮箱
	 * 参数说明:   @param oicqNo qq号
	 * 参数说明:   @param mobilNo 电话号码
	 * 参数说明:   @param telNoDept 工作号码
	 * 参数说明:   @param avatar 头像
	 * @return     void 无
	 */
	public ToJson<Users> edit(Integer uid,String userName,String sex,String birthday,String email,String oicqNo,String mobilNo,String telNoDept,String avatar);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:25:20
	 * 方法介绍:   删除用户
	 * 参数说明:   @param uid
	 * @return     void
	 */
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
    public Users findUserByName( String byname,HttpServletRequest req);
	
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
	public Users getByUid(int uid);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月21日 上午11:00:05
	 * 方法介绍:   根据userid串获取用户姓名
	 * 参数说明:   @param userIds 用户userid串
	 * 参数说明:   @return
	 * @return     List<String>  返回用户姓名集合
	 */
	public String getUserNameById(String userIds);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月3日 下午12:48:12
	 * 方法介绍:   根据uid串获取用户姓名
	 * 参数说明:   @param uid 用户uid串
	 * 参数说明:   @return
	 * @return     String 用户姓名串
	 */
	public String findUsersByuid(int... uid);
}
