package com.xoa.service.department;

import java.util.List;

import com.xoa.model.department.Department;
import com.xoa.util.dataSource.DynDatasource;

 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月19日 上午9:36:46
 * 类介绍  :    部门
 * 构造参数:    无
 *
 */
public interface DepartmentService {
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 下午2:51:12
	 * 方法介绍:   根据部门id串获取部门名称
	 * 参数说明:   @param deptIds  部门id数组
	 * 参数说明:   @return
	 * @return     List<String>  部门名称集合
	 */
	@DynDatasource
	public List<String> getDeptNameById(int... deptIds);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月3日 上午11:39:25
	 * 方法介绍:   根据部门id串获取部门名称串
	 * 参数说明:   @param deptIds
	 * 参数说明:   @return
	 * @return     String 部门名称串
	 */
	@DynDatasource
	public String getDpNameById(int... deptIds);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:37:25
	 * 方法介绍:   获取所有部门
	 * 参数说明:   @return
	 * @return     List<Department>  所有部门的集合
	 */
	@DynDatasource
    public List<Department> getDatagrid();
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:37:39
	 * 方法介绍:   根据部门id获取
	 * 参数说明:   @param deptId  部门id
	 * 参数说明:   @return
	 * @return     Department  部门信息
	 */
	@DynDatasource
	public Department getDeptById(int deptId);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:40:51
	 * 方法介绍:   删除部门
	 * 参数说明:   @param deptId  部门id
	 * @return     void   无返回值
	 */
	@DynDatasource 
	public void deleteDept(int deptId);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:41:02
	 * 方法介绍:   插入部门
	 * 参数说明:   @param department  部门信息
	 * @return     void  无返回值
	 */
	@DynDatasource 
	public void insertDept(Department department);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:41:21
	 * 方法介绍:   修改部门
	 * 参数说明:   @param department  部门信息
	 * @return     void  无返回值
	 */
	@DynDatasource 
	public void editDept(Department department);	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:41:31
	 * 方法介绍:   多条件查询部门信息
	 * 参数说明:   @param department 部门信息
	 * 参数说明:   @return
	 * @return     List<Department>  部门信息集合
	 */
	@DynDatasource 
	public List<Department> getDeptByMany(Department department);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月20日 下午5:46:02
	 * 方法介绍:   获取子级目录
	 * 参数说明:   @param maps  
	 * 参数说明:   @param page  当前页面
	 * 参数说明:   @param pageSize  页面显示数据条数
	 * 参数说明:   @param useFlag  是否开启分页
	 * 参数说明:   @return
	 * @return     List<Department>  部门集合
	 */
	@DynDatasource 
	public List<Department> getChDept(int deptId);	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月21日 下午1:12:18
	 * 方法介绍:   获得上级部门
	 * 参数说明:   @return
	 * @return     List<Department> 返回上级部门信息
	 */
	@DynDatasource
	public List<Department> getFatherDept(int deptParent,List<Department> list);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月24日 下午8:59:24
	 * 方法介绍:   根据部门排序号获得部门信息接口
	 * 参数说明:   @param deptNo 部门编号
	 * 参数说明:   @param list 部门信息
	 * 参数说明:   @return  
	 * @return     List<Department>  部门信息
	 */
	@DynDatasource
	public List<Department> getChDeptByNo(String deptNo,List<Department> list);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月25日 下午2:13:28
	 * 方法介绍:   获取当前部门下子部门与部门人员
	 * 参数说明:   @param deptId 部门id
	 * 参数说明:   @return
	 * @return     List<Department> 返回部门信息
	 */
	@DynDatasource
	public List<Department> getChDeptUser(int deptId);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月2日 下午3:52:49
	 * 方法介绍:   获取部门人员
	 * 参数说明:   @param deptId 部门id
	 * 参数说明:   @return
	 * @return     List<Department> 返回部门信息
	 */
	@DynDatasource
	public List<Department> getChDtUser(int deptId);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月3日 上午9:04:34
	 * 方法介绍:   获取部门下人数
	 * 参数说明:   @param deptNo 部门排序号
	 * 参数说明:   @return
	 * @return     int 数量
	 */
	@DynDatasource
	public int getCountChDeptUser(String deptNo);

}
