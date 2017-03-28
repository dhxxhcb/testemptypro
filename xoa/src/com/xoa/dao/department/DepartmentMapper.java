package com.xoa.dao.department;

import java.util.List;

import com.xoa.model.department.Department;
import com.xoa.model.users.Users;

public interface DepartmentMapper {
	
  public List<Department> getDatagrid();
  
  public List<Users> getUserAll(int deptId);
   
}