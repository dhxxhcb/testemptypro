package com.xoa.service.department;

import com.alibaba.fastjson.JSONObject;
import com.xoa.util.dataSource.DynDatasource;

public interface DepartmentService {
	
	
	  /*public List<Department> getdeptParent(int deptParent);
	  public List<Department> getdeptId(int deptId);*/
	@DynDatasource
	public JSONObject getDeptNameById(int... dept_id_str);

}
