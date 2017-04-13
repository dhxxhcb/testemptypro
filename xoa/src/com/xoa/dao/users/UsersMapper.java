package com.xoa.dao.users;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xoa.model.users.Users;

public interface UsersMapper {

	public Users findUserByName(@Param("byname") String byname);

	public String getUsernameById(@Param("uid") int uid);
	
	public String getUsernameByUserId(int uid);

	public  List<Users> getDatagrid();

	public void addUser(Users user);

	public void editUser(Users user);

	public void deleteUser(int uid);

	public List<Users> getdepId(int depId);

	public List<Users> getRoleId(int userPriv);
	
	public List<Users> getAlluser();


}
