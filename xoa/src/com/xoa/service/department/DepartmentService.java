package com.xoa.service.department;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.xoa.model.department.Department;
import com.xoa.util.dataSource.DynDatasource;

 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月19日 上午9:36:46
 * 类介绍  :    部门
 * 构造参数:   
 *
 */
public interface DepartmentService {
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 下午2:51:12
	 * 方法介绍:   根据部门id串获取部门名称
	 * 参数说明:   @param dept_id_str
	 * 参数说明:   @return
	 * @return     List<String>
	 */
	@DynDatasource
	public List<String> getDeptNameById(int... dept_id_str);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:37:25
	 * 方法介绍:   获取所有部门
	 * 参数说明:   @return
	 * @return     List<Department>
	 */
	@DynDatasource
    public List<Department> getDatagrid();
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:37:39
	 * 方法介绍:   根据部门id获取
	 * 参数说明:   @param deptId
	 * 参数说明:   @return
	 * @return     Department
	 */
	@DynDatasource
	public Department getDeptById(int deptId);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:40:51
	 * 方法介绍:   删除部门
	 * 参数说明:   @param deptId
	 * @return     void
	 */
	@DynDatasource 
	public void deleteDept(int deptId);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:41:02
	 * 方法介绍:   插入部门
	 * 参数说明:   @param department
	 * @return     void
	 */
	@DynDatasource 
	public void insertDept(Department department);

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:41:21
	 * 方法介绍:   修改部门
	 * 参数说明:   @param department
	 * @return     void
	 */
	@DynDatasource 
	public void editDept(Department department);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:41:31
	 * 方法介绍:   多条件查询部门信息
	 * 参数说明:   @param department
	 * 参数说明:   @return
	 * @return     List<Department>
	 */
	@DynDatasource 
	public List<Department> getDeptByMany(Department department);
	

}
