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
 * @ClassName (类名):  DepartmentController
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午2:51:45
 *
 */
@Controller
@Scope(value="prototype")
public class DepartmentController {
	
	private Logger loger = Logger.getLogger(DepartmentController.class);
	
	@Resource
	private DepartmentService departmentService;
	

	/**
	 * @Title: addDept
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param department
	 * @param: @return   
	 * @return: ToJson<Department>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/department/addDept",method = RequestMethod.POST)
    public ToJson<Department> addDept(Department department) {
		ToJson<Department> json=new ToJson<Department>(0, null);
		try {
			departmentService.insertDept(department);
            json.setObject(department);
            json.setMsg("部门新增成功！");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
	/**
	 * @Title: deletedept
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param department
	 * @param: @return   
	 * @return: ToJson<Department>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/department/deletedept",method = RequestMethod.POST)
    public ToJson<Department> deletedept(Department department) {
		ToJson<Department> json=new ToJson<Department>(0, null);
		loger.debug("传过来的ID为"+department.getDeptId());
		try {
			departmentService.deleteDept(department.getDeptId());
            json.setObject(department);
            json.setMsg("部门删除成功！");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	/**
	 * @Title: getDeptByid
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param deptid
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/department/getDeptByid" ,method = RequestMethod.POST)
    public String getDeptByid(int deptid) {
		ToJson<Department> json=new ToJson<Department>(0, null);
		try {
			Department department =departmentService.getDeptById(deptid);
			json.setObject(department);
            json.setMsg("查询部门成功！");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
			System.out.println(e);
		}
        return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss");
    }
	
	
	
	/**
	 * @Title: getAlldept
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/department/getAlldept",produces = {"application/json;charset=UTF-8"})
    public String getAlldept() {
		ToJson<Department> json=new ToJson<Department>(0, null);
		try {
			List<Department> list=departmentService.getDatagrid();  
			json.setObj(list);
            json.setMsg("所有部门查询成功！");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
			System.out.println(e.getMessage());
		}
        return JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss");
    }
	

	/**
	 * @Title: editDept
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param department
	 * @param: @return   
	 * @return: ToJson<Department>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/department/editDept",method = RequestMethod.POST)
    public ToJson<Department> editDept(Department department) {
		ToJson<Department> json=new ToJson<Department>(0, null);
		loger.debug("传过来的ID为"+department.getDeptId());
		try {
			departmentService.editDept(department);
            json.setObject(department);
            json.setMsg("修改成功！");
            json.setFlag(true);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }
	
	
	/**
	 * @Title: getDeptByMany
	 * @Description: TODO
	 * @author(作者):      zlf
	 * @param: @param department
	 * @param: @return   
	 * @return: ToJson<Department>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/department/getDeptByMany",method = RequestMethod.POST)
    public ToJson<Department> getDeptByMany(Department department) {
		ToJson<Department> json=new ToJson<Department>(0, null);
		try {
			List<Department> list=departmentService.getDeptByMany(department);
            json.setObj(list);
            json.setMsg("部门查询成功！");
            json.setFlag(true);
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
