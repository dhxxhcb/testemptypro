package com.xoa.controller.department;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.alibaba.fastjson.JSON;
import com.xoa.model.department.Department;
import com.xoa.service.users.UserFunctionService;


@Controller
@Scope(value="prototype")
public class DepartmentController {
	@Resource
	private UserFunctionService DepartmentService;
	
	 /**
     * 部门列表-树
     * @return
     */
	    @RequestMapping(value = "/dep", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	    public  @ResponseBody String treegrid(HttpServletResponse response) {
	        List<Department> menuList = DepartmentService.getDep();
	        System.out.println(menuList.size());
	       String json = createTreeJson(menuList);
	        return JSON.toJSONStringWithDateFormat(json, "yyyy-MM-dd HH:mm:ss");
	    }
	    
	   
	
	
	 ////////////////////////////////////////////////////////////////////////////////////////////
    /**
      * 创建一颗树，以json字符串形式返回
      * @param list 原始数据列表
      * @return 树
      */
	 private String createTreeJson(List<Department> list){
		  JSONArray rootArray = new JSONArray();
		  for (Department dept : list) {
			  if (dept.getDeptParent()==0) {//有父节点
				  
				  JSONObject rootObj = createBranch(list, dept);
				  rootArray.add(rootObj);
			}
			
		}
		 
		return rootArray.toString();
		 
		 
		 
	 }
	
	
	 /**
     * 递归创建分支节点Json对象
     * @param list 创建树的原始数据
     * @param deptParent 当前节点
     * @return 当前节点与该节点的子节点json对象
     */
	  private JSONObject createBranch(List<Department> list, Department deptParent) {
		     /*
	         * 将javabean对象解析成为JSON对象
	         */
		  JSONObject currentObj = JSONObject.fromObject(deptParent);
		  JSONArray childArray = new JSONArray();
		    /*
	         * 循环遍历原始数据列表，判断列表中某对象的父id值是否等于当前节点的id值，
	         * 如果相等，进入递归创建新节点的子节点，直至无子节点时，返回节点，并将该
	         * 节点放入当前节点的子节点列表中
	         */
		  for (Department department : list) {
			if ((department.getDeptParent() == 0)&&
					(department.getDeptParent().compareTo(deptParent.getDeptId()) == 0)) {
				JSONObject childObj= createBranch(list, department);
				childArray.add(childObj);
			}
		}
		    /*
	         * 判断当前子节点数组是否为空，不为空将子节点数组加入children字段中
	         */
		  if (!childArray.isEmpty()) {
	            currentObj.put("children", childArray);
	        }
		  return currentObj;
	  
	  }
}
