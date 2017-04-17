package com.xoa.dao.users;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.xoa.model.users.Users;

 /**
 * @ClassName (类名):  UsersMapper
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午2:58:55
 *
 */
public interface UsersMapper {

	/**
	 * @Title: findUserByName
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param byname
	 * @param: @return   
	 * @return: Users   
	 * @throws
	 */
	public Users findUserByName(@Param("byname") String byname);

	/**
	 * @Title: getUsernameById
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param uid
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getUsernameById(@Param("uid") int uid);
	
	/**
	 * @Title: getUsernameByUserId
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param uid
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getUsernameByUserId(int uid);

	/**
	 * @Title: getDatagrid
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @return   
	 * @return: List<Users>   
	 * @throws
	 */
	public  List<Users> getDatagrid();

	/**
	 * @Title: addUser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param user   
	 * @return: void   
	 * @throws
	 */
	public void addUser(Users user);

	/**
	 * @Title: editUser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param user   
	 * @return: void   
	 * @throws
	 */
	public void editUser(Users user);

	/**
	 * @Title: deleteUser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param uid   
	 * @return: void   
	 * @throws
	 */
	public void deleteUser(int uid);

	/**
	 * @Title: getdepId
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param depId
	 * @param: @return   
	 * @return: List<Users>   
	 * @throws
	 */
	public List<Users> getdepId(int depId);

	/**
	 * @Title: getRoleId
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param userPriv
	 * @param: @return   
	 * @return: List<Users>   
	 * @throws
	 */
	public List<Users> getRoleId(int userPriv);
	
	/**
	 * @Title: getAlluser
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param maps
	 * @param: @return   
	 * @return: List<Users>   
	 * @throws
	 */
	public List<Users> getAlluser(Map<String,Object> maps);
	
	/**
	 * @Title: findUserByuid
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param uid
	 * @param: @return   
	 * @return: Users   
	 * @throws
	 */
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
	public List<Users> getUserByMany(Users user); 


}
