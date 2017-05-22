package com.xoa.service.users;

import java.util.List;
import java.util.Map;

import com.xoa.model.users.UserPriv;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:30:48
 * 类介绍  :    角色权限service层接口
 * 构造参数:   无
 *
 */
public interface UsersPrivService {
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:31:24
	 * 方法介绍:   根据角色编号数组获取角色
	 * 参数说明:   @param privId
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getPrivNameById(int... privId);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:31:32
	 * 方法介绍:    根据主键获取角色
	 * 参数说明:   @param up
	 * 参数说明:   @return
	 * @return     UserPriv
	 */
	public UserPriv selectByPrimaryKey(int up);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:31:39
	 * 方法介绍:   根据主键删除角色
	 * 参数说明:   @param userPriv
	 * @return     void
	 */
	public void deleteByPrimaryKey(int userPriv);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:31:45
	 * 方法介绍:    角色插入
	 * 参数说明:   @param record
	 * @return     void
	 */
	public void insertSelective(UserPriv record);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:31:53
	 * 方法介绍:   获取所有角色
	 * 参数说明:   @param maps  集合
	 * 参数说明:   @param page  当前页面
	 * 参数说明:   @param pageSize  页面大小
	 * 参数说明:   @param useFlag   是否开启分页
	 * 参数说明:   @return
	 * @return     List<UserPriv>  返回所有角色
	 */
	public List<UserPriv> getAllPriv(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:32:00
	 * 方法介绍:   多条件查询角色
	 * 参数说明:   @param priv  角色信息
	 * 参数说明:   @return 
	 * @return     List<UserPriv>  所有角色信息
	 */
	public List<UserPriv> getPrivByMany(UserPriv priv);

}
