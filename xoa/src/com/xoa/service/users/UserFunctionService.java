package com.xoa.service.users;



import com.xoa.model.department.Department;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.users.Users;
import com.xoa.util.ToJson;

public interface UserFunctionService {
	
	
	
	
	public ToJson<SysFunction> getMenu(int uid);
	
	public ToJson<Department> getDep();
	
	public ToJson<Users> getUser(int uid);
	
	

}
