package com.xoa.service.department.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xoa.dao.department.DepartmentMapper;
import com.xoa.model.department.Department;
import com.xoa.service.department.DepartmentService;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月19日 上午9:41:51
 * 类介绍  :    部门实现类
 * 构造参数:   
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentMapper departmentMapper;
	
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:42:08
	 * 方法介绍:   根据部门id串获取部门
	 * 参数说明:   @param dept_id_str
	 * 参数说明:   @return
	 * @return     JSONObject   
	 */
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

	
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:42:36
	 * 方法介绍:   获取所有部门
	 * 参数说明:   @return
	 * @return     List<Department>   
	 */
	@Override
	public List<Department> getDatagrid() {	
		return departmentMapper.getDatagrid();
	}

	
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:42:50
	 * 方法介绍:   根据部门id获取部门
	 * 参数说明:   @param deptId
	 * 参数说明:   @return
	 * @return     Department   
	 */
	@Override
	public Department getDeptById(int deptId) {
		Department department =departmentMapper.getDeptById(deptId);
		return department;
	}

	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:43:07
	 * 方法介绍:   根据部门id删除部门
	 * 参数说明:   @param deptId
	 * @return     void   
	 */
	@Override
	public void deleteDept(int deptId) {
		departmentMapper.deleteDept(deptId);
		
	}

	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:43:23
	 * 方法介绍:   修改部门
	 * 参数说明:   @param department
	 * @return     void   
	 */
	@Override
	public void editDept(Department department) {
		departmentMapper.editDept(department);
		
	}

	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:43:34
	 * 方法介绍:   保存部门
	 * 参数说明:   @param department
	 * @return     void   
	 */
	@Override
	public void insertDept(Department department) {
		departmentMapper.insertDept(department);	
	}

	
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:43:51
	 * 方法介绍:   多条件查询部门信息
	 * 参数说明:   @param department
	 * 参数说明:   @return
	 * @return     List<Department>   
	 */
	@Override
	public List<Department> getDeptByMany(Department department) {
		List<Department> list=departmentMapper.getDeptByMany(department);
		return list;
	}
	

}
