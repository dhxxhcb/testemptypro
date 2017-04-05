package com.xoa.service.users;

import java.util.List;


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

}
