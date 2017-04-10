package com.xoa.service.users;



import java.util.List;

import com.xoa.model.department.Department;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.users.Users;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;

public interface UserFunctionService {
	
	
	
	@DynDatasource
	public List<SysFunction> getMenu(int uid);
	
	@DynDatasource
	public List<Department> getDep();
	
	@DynDatasource
	public ToJson<Users> getUser(int uid);
	
	

}
