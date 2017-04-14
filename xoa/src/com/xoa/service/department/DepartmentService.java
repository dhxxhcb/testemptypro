package com.xoa.service.department;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.xoa.model.department.Department;
import com.xoa.util.dataSource.DynDatasource;

public interface DepartmentService {
	
	
	  /*public List<Department> getdeptParent(int deptParent);
	  public List<Department> getdeptId(int deptId);*/
	@DynDatasource
	public JSONObject getDeptNameById(int... dept_id_str);
	@DynDatasource
    public List<Department> getDatagrid();
	@DynDatasource
	public Department getDeptById(int deptId);
	@DynDatasource 
	public void deleteDept(int deptId);
	@DynDatasource 
	public void insertDept(Department department);
	@DynDatasource 
	public void editDept(Department department);
	@DynDatasource 
	public List<Department> getDeptByMany(Department department);
	

}
