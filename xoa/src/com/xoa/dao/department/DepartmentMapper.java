package com.xoa.dao.department;

import java.util.List;

import com.xoa.model.department.Department;

public interface DepartmentMapper {
	
  public List<Department> getDatagrid();
  
  public String getDeptNameById(int deptId);
  
  public Department getDeptById(int deptId);
  
  public void deleteDept(int deptId);
  
  public void insertDept(Department department);

  public void editDept(Department department);
  
  public List<Department> getDeptByMany(Department department); 
}