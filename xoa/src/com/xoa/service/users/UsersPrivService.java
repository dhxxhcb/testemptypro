package com.xoa.service.users;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.xoa.model.users.UserPriv;
import com.xoa.util.dataSource.DynDatasource;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:30:48
 * 类介绍  :    角色权限service层接口
 * 构造参数:   
 *
 */
public interface UsersPrivService {
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:31:24
	 * 方法介绍:   
	 * 参数说明:   @param priv_id_str
	 * 参数说明:   @return
	 * @return     JSONObject
	 */
	@DynDatasource
	public JSONObject getPrivNameById(int... priv_id_str);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:31:32
	 * 方法介绍:   
	 * 参数说明:   @param up
	 * 参数说明:   @return
	 * @return     UserPriv
	 */
	@DynDatasource
    public UserPriv selectByPrimaryKey(int up);	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:31:39
	 * 方法介绍:   
	 * 参数说明:   @param userPriv
	 * @return     void
	 */
	@DynDatasource
    public void deleteByPrimaryKey(int userPriv);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:31:45
	 * 方法介绍:   
	 * 参数说明:   @param record
	 * @return     void
	 */
	@DynDatasource
    public void insertSelective(UserPriv record);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:31:53
	 * 方法介绍:   
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * @return     List<UserPriv>
	 */
	@DynDatasource
	public List<UserPriv> getAllPriv(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:32:00
	 * 方法介绍:   
	 * 参数说明:   @param priv
	 * 参数说明:   @return
	 * @return     List<UserPriv>
	 */
	@DynDatasource
	public List<UserPriv> getPrivByMany(UserPriv priv); 

}
