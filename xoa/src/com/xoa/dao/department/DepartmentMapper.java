package com.xoa.dao.department;

import java.util.List;
import java.util.Map;

import com.xoa.model.department.Department;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:22:35
 * 类介绍  :    部门
 * 构造参数:   无
 *
 */
public interface DepartmentMapper {
	

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:22:51
 * 方法介绍:   获取所有部门
 * 参数说明:   @return
 * @return     List<Department> 返回部门信息
 */
public List<Department> getDatagrid();
  
 
/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:23:02
 * 方法介绍:   根据部门id获取部门
 * 参数说明:   @param deptId 部门deptid
 * 参数说明:   @return
 * @return     String  返回部门名称
 */
public String getDeptNameById(int deptId);
  
/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:23:21
 * 方法介绍:   根据部门id获取部门
 * 参数说明:   @param deptId 部门编号
 * 参数说明:   @return
 * @return     Department  返回部门信息
 */
public Department getDeptById(int deptId);
  

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:23:42
 * 方法介绍:   根据部门id删除部门
 * 参数说明:   @param deptId  部门编号
 * @return     void  无
 */
public void deleteDept(int deptId);
  
  
/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:23:56
 * 方法介绍:   新增部门
 * 参数说明:   @param department  部门信息
 * @return     void  无
 */
public void insertDept(Department department);


/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:24:17
 * 方法介绍:   修改部门
 * 参数说明:   @param department  部门信息
 * @return     void  无
 */
public void editDept(Department department);
  
 
/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:24:35
 * 方法介绍:   多条件获取部门
 * 参数说明:   @param department 部门信息
 * 参数说明:   @return
 * @return     List<Department>  返回部门集合
 */
public List<Department> getDeptByMany(Department department); 

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月20日 下午5:47:07
 * 方法介绍:   获取子目录
 * 参数说明:   @param maps  集合
 * 参数说明:   @return
 * @return     List<Department>  返回部门集合
 */
public List<Department> getChDept(Map<String,Object> maps);


/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月21日 下午1:10:00
 * 方法介绍:   获得上级部门
 * 参数说明:   @param deptId 下级部门编号
 * 参数说明:   @return
 * @return     Department 返回部门信息
 */
public Department getFatherDept(int deptId);
}