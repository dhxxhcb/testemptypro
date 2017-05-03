package com.xoa.service.department.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.xoa.dao.department.DepartmentMapper;
import com.xoa.model.department.Department;
import com.xoa.service.department.DepartmentService;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月19日 上午9:41:51
 * 类介绍  :    部门实现类
 * 构造参数:   无
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentMapper departmentMapper;
	
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:42:08
	 * 方法介绍:   根据部门id串获取部门名称
	 * 参数说明:   @param deptID 部门id
	 * 参数说明:   @return
	 * @return     List<String>    返回部门名称
	 */
	@Override
	public List<String> getDeptNameById(int... deptID){
		//定义返回的list
		List<String> list=new ArrayList<String>();
		//定义用户拼接部门名称的字符串
		StringBuffer sb=new StringBuffer();
		  for (int i = 0; i < deptID.length; i++) { 			  
			     if(deptID.length==1){
			            String deptName=departmentMapper.getDeptNameById(deptID[i]);
			            list.add(deptName);
			            return list;
			            }else{
			            String deptName=departmentMapper.getDeptNameById(deptID[i]);
			            if(i<deptID.length-1){
			            sb.append(deptName).append(",");
			            }else{
			            sb.append(deptName);
			            } 
			            } 
			        }  
		     list.add(sb.toString());
				return list;		
	}

	
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:42:36
	 * 方法介绍:   获取所有部门
	 * 参数说明:   @return 
	 * @return     List<Department>   返回所有部门 
	 */
	@Override
	public List<Department> getDatagrid() {	
		return departmentMapper.getDatagrid();
	}

	
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:42:50
	 * 方法介绍:   根据部门id获取部门
	 * 参数说明:   @param deptId  部门id
	 * 参数说明:   @return
	 * @return     Department   返回部门信息
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
	 * 参数说明:   @param deptId  部门id
	 * @return     void   无
	 */
	@Override
	public void deleteDept(int deptId) {
		departmentMapper.deleteDept(deptId);
		
	}

	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:43:23
	 * 方法介绍:   修改部门
	 * 参数说明:   @param department 部门信息
	 * @return     void   无
	 */
	@Override
	public void editDept(Department department) {
		departmentMapper.editDept(department);
		
	}

	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:43:34
	 * 方法介绍:   保存部门
	 * 参数说明:   @param department 部门信息
	 * @return     void    无
	 */ 
	@Override
	public void insertDept(Department department) {
		departmentMapper.insertDept(department);	
	}

	
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:43:51
	 * 方法介绍:   多条件查询部门信息
	 * 参数说明:   @param department  部门信息
	 * 参数说明:   @return
	 * @return     List<Department>    返回部门信息
	 */
	@Override
	public List<Department> getDeptByMany(Department department) {
		List<Department> list=departmentMapper.getDeptByMany(department);
		return list;
	}
	

	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月21日 上午10:50:37
	 * 方法介绍:   获取子目录
	 * 参数说明:   @param maps 集合
	 * 参数说明:   @param page 当前页面
	 * 参数说明:   @param pageSize 页面大小
	 * 参数说明:   @param useFlag  是否开启分页
	 * 参数说明:   @return
	 * @return     List<Department>   返回子目录
	 */
	@Override
	public List<Department> getChDept(int deptId) {
	    List<Department> list=departmentMapper.getChDept(deptId);  
	    
		return list;
	}


	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月21日 下午1:55:52
	 * 方法介绍:   递归获取所有父级部门信息
	 * 参数说明:   @param deptParent 部门
	 * 参数说明:   @param list 用于存储父级部门信息
	 * 参数说明:   @return
	 * @return     List<Department>  返回父级部门信息
	 */
	@Override
	public List<Department> getFatherDept(int deptParent,List<Department> list) {
		 Department dep=departmentMapper.getFatherDept(deptParent);
		if(dep.getDeptParent()!=0){
			list.add(dep);
		}else{
			list.add(dep);
			return list;
		}
		return getFatherDept(dep.getDeptParent(),list);
	}


	public List<Department> getChDeptByNo(String deptNo,List<Department> list){
		return list;
//		list=new ArrayList<Department>(); 
//		List<Department> list1=departmentMapper.getChDeptByNo(deptNo);
//		if(list!=null){
//			for( Department d:list1){
//				list1=new ArrayList<Department>();
//				list1= departmentMapper.getChDeptByNo(d.getDeptNo());
//				//d.setChild(list1);
//			}
//			return getChDeptByNo(list.get(0).getDeptNo(), list);
//		}else{
//			return list;
//		}		
	}
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月2日 下午3:52:49
	 * 方法介绍:   获取部门人员
	 * 参数说明:   @param deptId 部门id
	 * 参数说明:   @return
	 * @return     List<Department> 返回部门信息
	 */
	public List<Department> getChDtUser(int deptId){
		List<Department> list=departmentMapper.getChDeptUser(deptId);
		
		return list;
		
	}

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月25日 下午2:13:28
	 * 方法介绍:   获取当前部门下子部门与部门人员
	 * 参数说明:   @param deptId 部门id
	 * 参数说明:   @return
	 * @return     List<Department> 返回部门编号
	 */
	@Override
	public List<Department> getChDeptUser(int deptId) {
		List<Department> list=departmentMapper.getChDeptUser(deptId);
		List<Department> list1=departmentMapper.getChDept(deptId); 	
		if(list.size()!=0&&list1.size()!=0){
		for(int i=0;i<list1.size();i++){
			list.add(list1.get(i));
		}
		return list;
		}
		if(list.size()!=0&&list1.size()==0){
			return list;
		}
		if(list.size()==0&&list1.size()!=0){
			return list1;
		}
		if(list.size()==0&&list1.size()==0){
			return list;
		}
		return list;
	}
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月3日 上午9:04:34
	 * 方法介绍:   获取部门下人数
	 * 参数说明:   @param deptNo 部门排序号
	 * 参数说明:   @return
	 * @return     int 数量
	 */
	@Override
	public int getCountChDeptUser(String deptNo) {
		int count=departmentMapper.getCountChDeptUser(deptNo);
		return count;
	}
	

}
