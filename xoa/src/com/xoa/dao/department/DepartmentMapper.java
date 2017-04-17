package com.xoa.dao.department;

import java.util.List;

import com.xoa.model.department.Department;

 /**
 * @ClassName (类名):  DepartmentMapper
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午3:00:25
 *
 */
 /**
 * @ClassName (类名):  DepartmentMapper
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午3:00:51
 *
 */
public interface DepartmentMapper {
	
  /**
 * @Title: getDatagrid
 * @Description: TODO
 * @author(作者):      zlf
 * @param: @return   
 * @return: List<Department>   
 * @throws
 */
public List<Department> getDatagrid();
  
  /**
 * @Title: getDeptNameById
 * @Description: TODO
 * @author(作者):      zlf
 * @param: @param deptId
 * @param: @return   
 * @return: String   
 * @throws
 */
public String getDeptNameById(int deptId);
  
  /**
 * @Title: getDeptById
 * @Description: TODO
 * @author(作者):      zlf
 * @param: @param deptId
 * @param: @return   
 * @return: Department   
 * @throws
 */
public Department getDeptById(int deptId);
  
  /**
 * @Title: deleteDept
 * @Description: TODO
 * @author(作者):      zlf
 * @param: @param deptId   
 * @return: void   
 * @throws
 */
public void deleteDept(int deptId);
  
  /**
 * @Title: insertDept
 * @Description: TODO
 * @author(作者):      zlf
 * @param: @param department   
 * @return: void   
 * @throws
 */
public void insertDept(Department department);

  /**
 * @Title: editDept
 * @Description: TODO
 * @author(作者):      zlf
 * @param: @param department   
 * @return: void   
 * @throws
 */
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
public List<Department> getDeptByMany(Department department); 
}