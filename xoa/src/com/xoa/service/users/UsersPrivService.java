package com.xoa.service.users;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.xoa.model.users.UserPriv;
import com.xoa.util.dataSource.DynDatasource;

 /**
 * @ClassName (类名):  UsersPrivService
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午3:59:16
 *
 */
public interface UsersPrivService {
	/**
	 * @Title: getPrivNameById
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param priv_id_str
	 * @param: @return   
	 * @return: JSONObject   
	 * @throws
	 */
	@DynDatasource
	public JSONObject getPrivNameById(int... priv_id_str);
	/**
	 * @Title: selectByPrimaryKey
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param up
	 * @param: @return   
	 * @return: UserPriv   
	 * @throws
	 */
	@DynDatasource
    public UserPriv selectByPrimaryKey(int up);	
	/**
	 * @Title: deleteByPrimaryKey
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param userPriv   
	 * @return: void   
	 * @throws
	 */
	@DynDatasource
    public void deleteByPrimaryKey(int userPriv);
	/**
	 * @Title: insertSelective
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param record   
	 * @return: void   
	 * @throws
	 */
	@DynDatasource
    public void insertSelective(UserPriv record);
	/**
	 * @Title: getAllPriv
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param maps
	 * @param: @param page
	 * @param: @param pageSize
	 * @param: @param useFlag
	 * @param: @return   
	 * @return: List<UserPriv>   
	 * @throws
	 */
	@DynDatasource
	public List<UserPriv> getAllPriv(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag);
	/**
	 * @Title: getPrivByMany
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param priv
	 * @param: @return   
	 * @return: List<UserPriv>   
	 * @throws
	 */
	@DynDatasource
	public List<UserPriv> getPrivByMany(UserPriv priv); 

}
