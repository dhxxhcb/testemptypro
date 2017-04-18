package com.xoa.service.users;

import java.util.List;
import java.util.Map;

import com.xoa.model.users.Users;
import com.xoa.util.dataSource.DynDatasource;


 /**
 * @ClassName (类名):  UsersService
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午2:57:01
 *
 */
public interface UsersService {
	

	/**
	 * @Title: findUserByName
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param byname
	 * @param: @return   
	 * @return: Users   
	 * @throws
	 */
	@DynDatasource
    public Users findUserByName( String byname);
    
	/**
	 * @Title: getUsernameById
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param uid
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@DynDatasource
	public String getUsernameById( int uid);	
	/**
	 * @Title: getDatagrid
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @return   
	 * @return: List<Users>   
	 * @throws
	 */
	@DynDatasource
	public  List<Users> getDatagrid();	
	/**
	 * @Title: addUser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param user   
	 * @return: void   
	 * @throws
	 */
	@DynDatasource
	public void addUser(Users user);
	/**
	 * @Title: editUser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param user   
	 * @return: void   
	 * @throws
	 */
	@DynDatasource
	public void editUser(Users user);	
	/**
	 * @Title: deleteUser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param uid   
	 * @return: void   
	 * @throws
	 */
	@DynDatasource
	public void deleteUser(int uid);
	
	  /**
     * 根据用户user_id获取用户姓名
     * 
     * @param  user_id_str
     *            user_id串
     * @return JSONObject
     *  		  用户姓名串
     * @throws IOException
     */
	@DynDatasource
	public String getUserNameById(int user_id);
	/**
	 * @Title: getAlluser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param maps
	 * @param: @param page
	 * @param: @param pageSize
	 * @param: @param useFlag
	 * @param: @return   
	 * @return: List<Users>   
	 * @throws
	 */
	@DynDatasource
	public List<Users> getAlluser(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag);
	/**
	 * @Title: findUserByuid
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param uid
	 * @param: @return   
	 * @return: Users   
	 * @throws
	 */
	@DynDatasource
    public Users findUserByuid(int uid);
	/**
	 * @Title: getUserByMany
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param user
	 * @param: @return   
	 * @return: List<Users>   
	 * @throws
	 */
	@DynDatasource
	public List<Users> getUserByMany(Users user); 


}
