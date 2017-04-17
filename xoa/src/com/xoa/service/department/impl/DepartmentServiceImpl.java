package com.xoa.service.department.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xoa.dao.department.DepartmentMapper;
import com.xoa.model.department.Department;
import com.xoa.service.department.DepartmentService;

 /**
 * @ClassName (类名):  DepartmentServiceImpl
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午3:46:48
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentMapper departmentMapper;
	
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
	 * <p>Title: getDatagrid</p>
	 * <p>Description: </p>
	 * @return
	 * @author(作者):  zlf
	 * @see com.xoa.service.department.DepartmentService#getDatagrid()
	 */
	@Override
	public List<Department> getDatagrid() {	
		return departmentMapper.getDatagrid();
	}

	 /**
	 * <p>Title: getDeptById</p>
	 * <p>Description: </p>
	 * @param deptId
	 * @return
	 * @author(作者):  zlf
	 * @see com.xoa.service.department.DepartmentService#getDeptById(int)
	 */
	@Override
	public Department getDeptById(int deptId) {
		Department department =departmentMapper.getDeptById(deptId);
		return department;
	}

	 /**
	 * <p>Title: deleteDept</p>
	 * <p>Description: </p>
	 * @param deptId
	 * @author(作者):  zlf
	 * @see com.xoa.service.department.DepartmentService#deleteDept(int)
	 */
	@Override
	public void deleteDept(int deptId) {
		departmentMapper.deleteDept(deptId);
		
	}

	 /**
	 * <p>Title: editDept</p>
	 * <p>Description: </p>
	 * @param department
	 * @author(作者):  zlf
	 * @see com.xoa.service.department.DepartmentService#editDept(com.xoa.model.department.Department)
	 */
	@Override
	public void editDept(Department department) {
		departmentMapper.editDept(department);
		
	}

	 /**
	 * <p>Title: insertDept</p>
	 * <p>Description: </p>
	 * @param department
	 * @author(作者):  zlf
	 * @see com.xoa.service.department.DepartmentService#insertDept(com.xoa.model.department.Department)
	 */
	@Override
	public void insertDept(Department department) {
		departmentMapper.insertDept(department);	
	}

	 /**
	 * <p>Title: getDeptByMany</p>
	 * <p>Description: </p>
	 * @param department
	 * @return
	 * @author(作者):  zlf
	 * @see com.xoa.service.department.DepartmentService#getDeptByMany(com.xoa.model.department.Department)
	 */
	@Override
	public List<Department> getDeptByMany(Department department) {
		List<Department> list=departmentMapper.getDeptByMany(department);
		return list;
	}
	

}
