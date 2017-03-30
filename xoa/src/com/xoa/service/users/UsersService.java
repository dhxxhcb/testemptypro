package com.xoa.service.users;

import java.util.List;


import com.xoa.model.users.Users;


public interface UsersService {
	

    public Users findUserByName( String byname);
    
	public String getUsernameById( int uid);
	
	public  List<Users> getDatagrid();
	
	public void addUser(Users user);

	public void editUser(Users user);
	
	public void deleteUser(int uid);

}
