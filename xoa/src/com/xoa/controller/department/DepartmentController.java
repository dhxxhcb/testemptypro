package com.xoa.controller.department;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.alibaba.fastjson.JSON;
import com.xoa.model.department.Department;
import com.xoa.service.department.DepartmentService;
import com.xoa.util.ToJson;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月19日 上午9:21:53
 * 类介绍  :    部门
 * 构造参数:   
 *
 */
@Controller
@Scope(value="prototype")
public class DepartmentController {
	
	private Logger loger = Logger.getLogger(DepartmentController.class);
	
	@Resource
	private DepartmentService departmentService;
	

	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午8:20:25
	 * 方法介绍:   添加部门
	 * 参数说明:   @param department
	 * 参数说明:   @return
	 * @return     ToJson<Department>
	 */
	@ResponseBody
	@RequestMapping(value = "/department/addDept",method = RequestMethod.POST)
    public ToJson<Department> addDept(Department department) {
		ToJson<Department> json=new ToJson<Department>(0, null);
		try {
			departmentService.insertDept(department);
            json.setObject(department);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午8:20:42
	 * 方法介绍:   删除部门
	 * 参数说明:   @param department
	 * 参数说明:   @return
	 * @return     ToJson<Department>
	 */
	@ResponseBody
	@RequestMapping(value = "/department/deletedept",method = RequestMethod.POST)
    public ToJson<Department> deletedept(Department department) {
		ToJson<Department> json=new ToJson<Department>(0, null);
		loger.debug("ID"+department.getDeptId());
		try {
			departmentService.deleteDept(department.getDeptId());
            json.setObject(department);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 下午3:20:56
	 * 方法介绍:   根据部门id获取部门
	 * 参数说明:   @param deptid
	 * 参数说明:   @return
	 * @return     String
	 */
	@ResponseBody
	@RequestMapping(value = "/department/getDeptByid" ,method = RequestMethod.POST)
    public String getDeptByid(int deptid) {
		ToJson<Department> json=new ToJson<Department>(0, null);
		try {
			Department department =departmentService.getDeptById(deptid);
			json.setObject(department);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
			System.out.println(e);
		}
        return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss");
    }
	

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午8:21:17
	 * 方法介绍:   获取所有部门信息
	 * 参数说明:   @return
	 * @return     String
	 */
	@ResponseBody
	@RequestMapping(value = "/department/getAlldept",produces = {"application/json;charset=UTF-8"})
    public String getAlldept() {
		ToJson<Department> json=new ToJson<Department>(0, null);
		try {
			List<Department> list=departmentService.getDatagrid();  
			json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
			System.out.println(e.getMessage());
		}
        return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss");
    }
	

	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午8:21:32
	 * 方法介绍:   修改部门信息
	 * 参数说明:   @param department
	 * 参数说明:   @return
	 * @return     ToJson<Department>
	 */
	@ResponseBody
	@RequestMapping(value = "/department/editDept",method = RequestMethod.POST)
    public ToJson<Department> editDept(Department department) {
		ToJson<Department> json=new ToJson<Department>(0, null);
		loger.debug("ID"+department.getDeptId());
		try {
			departmentService.editDept(department);
            json.setObject(department);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午8:21:55
	 * 方法介绍:   多条件查询部门信息
	 * 参数说明:   @param department
	 * 参数说明:   @return
	 * @return     ToJson<Department>
	 */
	@ResponseBody
	@RequestMapping(value = "/department/getDeptByMany",method = RequestMethod.POST)
    public ToJson<Department> getDeptByMany(Department department) {
		ToJson<Department> json=new ToJson<Department>(0, null);
		try {
			List<Department> list=departmentService.getDeptByMany(department);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
	 /**
     * 部门列表-树111
     * @return
     */
	   /* @RequestMapping(value = "/dep", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	    public  @ResponseBody String treegrid(HttpServletResponse response) {
	        List<Department> menuList = DepartmentService.getDep();
	        System.out.println(menuList.size());
	       String json = createTreeJson(menuList);
	        return JSON.toJSONStringWithDateFormat(json, "yyyy-MM-dd HH:mm:ss");
	    }*/
	    
	   
	
	
	 ////////////////////////////////////////////////////////////////////////////////////////////
    /**
      * 创建一颗树，以json字符串形式返回
      * @param list 原始数据列表
      * @return 树
      */
	/* private String createTreeJson(List<Department> list){
		  JSONArray rootArray = new JSONArray();
		  for (Department dept : list) {
			  if (dept.getDeptParent()==0) {//有父节点
				  
				  JSONObject rootObj = createBranch(list, dept);
				  rootArray.add(rootObj);
			}
			
		}
		 
		return rootArray.toString();
		 
		 
		 
	 }*/
	
	
	 /**
     * 递归创建分支节点Json对象
     * @param list 创建树的原始数据
     * @param deptParent 当前节点
     * @return 当前节点与该节点的子节点json对象
     */
	 /* private JSONObject createBranch(List<Department> list, Department deptParent) {
		     
	         * 将javabean对象解析成为JSON对象
	         
		  JSONObject currentObj = JSONObject.fromObject(deptParent);
		  JSONArray childArray = new JSONArray();
		    
	         * 循环遍历原始数据列表，判断列表中某对象的父id值是否等于当前节点的id值，
	         * 如果相等，进入递归创建新节点的子节点，直至无子节点时，返回节点，并将该
	         * 节点放入当前节点的子节点列表中
	         
		  for (Department department : list) {
			if ((department.getDeptParent() == 0)&&
					(department.getDeptParent().compareTo(deptParent.getDeptId()) == 0)) {
				JSONObject childObj= createBranch(list, department);
				childArray.add(childObj);
			}
		}
		    
	         * 判断当前子节点数组是否为空，不为空将子节点数组加入children字段中
	         
		  if (!childArray.isEmpty()) {
	            currentObj.put("children", childArray);
	        }
		  return currentObj;
	  
	  }*/
}
