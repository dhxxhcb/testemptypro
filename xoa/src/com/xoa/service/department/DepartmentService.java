package com.xoa.service.department;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.xoa.model.department.Department;
import com.xoa.util.dataSource.DynDatasource;

 /**
 * @ClassName (类名):  DepartmentService
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午3:45:51
 *
 */
public interface DepartmentService {
	/**
	 * @Title: getDeptNameById
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param dept_id_str
	 * @param: @return   
	 * @return: JSONObject   
	 * @throws
	 */
	@DynDatasource
	public JSONObject getDeptNameById(int... dept_id_str);
	/**
	 * @Title: getDatagrid
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @return   
	 * @return: List<Department>   
	 * @throws
	 */
	@DynDatasource
    public List<Department> getDatagrid();
	/**
	 * @Title: getDeptById
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param deptId
	 * @param: @return   
	 * @return: Department   
	 * @throws
	 */
	@DynDatasource
	public Department getDeptById(int deptId);
	/**
	 * @Title: deleteDept
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param deptId   
	 * @return: void   
	 * @throws
	 */
	@DynDatasource 
	public void deleteDept(int deptId);
	/**
	 * @Title: insertDept
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param department   
	 * @return: void   
	 * @throws
	 */
	@DynDatasource 
	public void insertDept(Department department);
	/**
	 * @Title: editDept
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param department   
	 * @return: void   
	 * @throws
	 */
	@DynDatasource 
	public void editDept(Department department);
	/**
	 * @Title: getDeptByMany
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param department
	 * @param: @return   
	 * @return: List<Department>   
	 * @throws
	 */
	@DynDatasource 
	public List<Department> getDeptByMany(Department department);
	

}
