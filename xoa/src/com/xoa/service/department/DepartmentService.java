package com.xoa.service.department;

import java.util.List;



import com.xoa.model.department.Department;

public interface DepartmentService {
	
	
	  public List<Department> getdeptParent(int deptParent);
	  public List<Department> getdeptId(int deptId);
	

}
