package com.xoa.dao.department;

import java.util.List;
import java.util.Map;

import com.xoa.model.department.Department;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:22:35
 * 类介绍  :    部门
 * 构造参数:   
 *
 */
public interface DepartmentMapper {
	

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:22:51
 * 方法介绍:   获取所有部门
 * 参数说明:   @return
 * @return     List<Department>
 */
public List<Department> getDatagrid();
  
 
/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:23:02
 * 方法介绍:   根据部门id获取部门
 * 参数说明:   @param deptId
 * 参数说明:   @return
 * @return     String
 */
public String getDeptNameById(int deptId);
  
/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:23:21
 * 方法介绍:   根据部门id获取部门
 * 参数说明:   @param deptId
 * 参数说明:   @return
 * @return     Department
 */
public Department getDeptById(int deptId);
  

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:23:42
 * 方法介绍:   根据部门id删除部门
 * 参数说明:   @param deptId
 * @return     void
 */
public void deleteDept(int deptId);
  
  
/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:23:56
 * 方法介绍:   新增部门
 * 参数说明:   @param department
 * @return     void
 */
public void insertDept(Department department);


/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:24:17
 * 方法介绍:   修改部门
 * 参数说明:   @param department
 * @return     void
 */
public void editDept(Department department);
  
 
/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午8:24:35
 * 方法介绍:   多条件获取部门
 * 参数说明:   @param department
 * 参数说明:   @return
 * @return     List<Department>
 */
public List<Department> getDeptByMany(Department department); 

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月20日 下午5:47:07
 * 方法介绍:   获取子目录
 * 参数说明:   @param maps
 * 参数说明:   @return
 * @return     List<Department>
 */
public List<Department> getChDept(Map<String,Object> maps);
}