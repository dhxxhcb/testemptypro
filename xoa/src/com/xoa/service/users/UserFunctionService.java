package com.xoa.service.users;



import com.xoa.model.menu.SysFunction;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;

public interface UserFunctionService {
	
	
	
	@DynDatasource
	public ToJson<SysFunction> getMenu(int uid);
	
	/*@DynDatasource
	public ToJson<Department> getDep();*/
	
	/*@DynDatasource
	public ToJson<Users> getUser(int uid);*/
	
	

}
