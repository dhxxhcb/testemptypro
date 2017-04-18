package com.xoa.service.department.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xoa.dao.department.DepartmentMapper;
import com.xoa.service.department.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentMapper departmentMapper;
	
	/*@Override
	public List<Department> getdeptParent(int deptParent) {
		  
		return departmentMapper.getdeptParent(deptParent);
	}

	@Override
	public List<Department> getdeptId(int deptId) {
		// TODO Auto-generated method stub
		return departmentMapper.getdeptId(deptId);
	}*/
	
	@Override
	public JSONObject getDeptNameById(int... dept_id_str){
		//定义返回的json字符串
		JSONObject json=new JSONObject();
		//定义用户拼接部门名称的字符串
		StringBuffer sb=new StringBuffer();
		  for (int i = 0; i < dept_id_str.length; i++) { 			  
			     if(dept_id_str.length==1){
			            String deptName=departmentMapper.getDeptNameById(dept_id_str[i]);
			            json.put("deptName", deptName);	 
			            return json;
			            }else{
			            String deptName=departmentMapper.getDeptNameById(dept_id_str[i]);
			            if(i<dept_id_str.length-1){
			            sb.append(deptName).append("-");
			            }else{
			            sb.append(deptName);
			            }
				        json.put("deptName", sb.toString());	 
			            } 
			        }  
				return json;		
	}
	

}
