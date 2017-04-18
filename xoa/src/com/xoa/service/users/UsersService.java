package com.xoa.service.users;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.xoa.model.users.Users;
import com.xoa.util.dataSource.DynDatasource;


public interface UsersService {
	

	@DynDatasource
    public Users findUserByName( String byname);
    
	@DynDatasource
	public String getUsernameById( int uid);
	
	@DynDatasource
	public  List<Users> getDatagrid();
	
	@DynDatasource
	public void addUser(Users user);

	@DynDatasource
	public void editUser(Users user);
	
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
	public JSONObject getUserNameById(int... user_id_str);

}
