package com.xoa.service.department.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.department.DepartmentMapper;
import com.xoa.model.department.Department;
import com.xoa.service.department.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<Department> getdeptParent(int deptParent) {
		  
		return departmentMapper.getdeptParent(deptParent);
	}

	@Override
	public List<Department> getdeptId(int deptId) {
		// TODO Auto-generated method stub
		return departmentMapper.getdeptId(deptId);
	}

}
