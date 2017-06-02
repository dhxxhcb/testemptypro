package com.xoa.controller.department;

import com.xoa.model.department.Department;
import com.xoa.service.department.DepartmentService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月19日 上午9:21:53
 * 类介绍  :    部门控制器
 * 构造参数:    无
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/department")
public class DepartmentController {

    private Logger loger = Logger.getLogger(DepartmentController.class);

    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/deptQuery")
    public String  deptQuery(){
//        D:\git\xoa\xoa\WebRoot\WEB-INF\app\department\deptQuery.jsp
       return  "app/department/deptQuery";
    }

    @RequestMapping("/newDeptManagement")
    public String companyInfo(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/sys/new_deptManagement";
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午8:20:25
     * 方法介绍:   添加部门
     * 参数说明:   @param department  部门信息
     * 参数说明:   @return
     *
     * @return ToJson<Department> 返回部门信息
     */
    @ResponseBody
    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    public ToJson<Department> addDept(Department department, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Department> json = new ToJson<Department>(0, null);
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
     * 参数说明:   @param department 部门信息
     * 参数说明:   @return
     *
     * @return ToJson<Department> 返回显示信息
     */
    @ResponseBody
    @RequestMapping(value = "/deletedept", method = RequestMethod.POST)
    public ToJson<Department> deletedept(Department department, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Department> json = new ToJson<Department>(0, null);
        loger.debug("ID" + department.getDeptId());
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
     * 参数说明:   @param deptid  部门id名称
     * 参数说明:   @return
     *
     * @return String 返回单个部门信息
     */
    @ResponseBody
    @RequestMapping(value = "/getDeptById", method = RequestMethod.GET)
    public ToJson<Department> getDeptByid(int deptId, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Department> json = new ToJson<Department>(0, null);
        try {
            Department department = departmentService.getDeptById(deptId);
            json.setObject(department);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
            System.out.println(e);
        }
        return json;
    }


    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午8:21:17
     * 方法介绍:   获取所有部门信息
     * 参数说明:   @return
     *
     * @return String  返回所有部门信息
     */
    @ResponseBody
    @RequestMapping(value = "/getAlldept", produces = {"application/json;charset=UTF-8"})
    public ToJson<Department> getAlldept(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Department> json = new ToJson<Department>(0, null);
        try {
            List<Department> list = departmentService.getDatagrid();
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return json;
    }


    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午8:21:32
     * 方法介绍:   修改部门信息
     * 参数说明:   @param department  部门信息
     * 参数说明:   @return
     *
     * @return ToJson<Department>   返回显示信息
     */
    @ResponseBody
    @RequestMapping(value = "/editDept", method = RequestMethod.POST)
    public ToJson<Department> editDept(Department department, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Department> json = new ToJson<Department>(0, null);
        loger.debug("ID" + department.getDeptId());
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
     * 参数说明:   @param department 部门信息
     * 参数说明:   @return
     *
     * @return ToJson<Department> 返回符合条件部门信息
     */
    @ResponseBody
    @RequestMapping(value = "/getDeptByMany", method = RequestMethod.POST)
    public ToJson<Department> getDeptByMany(Department department, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Department> json = new ToJson<Department>(0, null);
        try {
            List<Department> list = departmentService.getDeptByMany(department);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月20日 下午6:14:43
     * 方法介绍:   获取下级部门
     * 参数说明:   @param request 请求
     * 参数说明:   @param maps  存储分页对象
     * 参数说明:   @param page 当前页
     * 参数说明:   @param pageSize 页面数
     * 参数说明:   @param useFlag  是否启用分页插件
     * 参数说明:   @return
     *
     * @return String  返回下级部门信息
     */
    @ResponseBody
    @RequestMapping(value = "/getChDeptfq", produces = {"application/json;charset=UTF-8"})
    public ToJson<Department> getChDept(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Department> json = new ToJson<Department>(0, null);
        try {
            request.setCharacterEncoding("UTF-8");
            int deptId = Integer.parseInt(new String(request.getParameter("deptId").getBytes("ISO-8859-1"), "UTF-8"));
            List<Department> list = departmentService.getChDept(deptId);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }


    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月21日 下午2:52:46
     * 方法介绍:   获得多部门名
     * 参数说明:   @param request 请求
     * 参数说明:   @return
     * @return String 返回长部门名
     */
    @ResponseBody
    @RequestMapping(value = "/getFatherDept", produces = {"application/json;charset=UTF-8"})
    public ToJson<Department> getFatherDept(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Department> json = new ToJson<Department>(0, null);
        try {
            request.setCharacterEncoding("UTF-8");
            int deptParent = Integer.parseInt(new String(request.getParameter("deptParent").getBytes("ISO-8859-1"), "UTF-8"));
            List<Department> list = new ArrayList<Department>();
            list = departmentService.getFatherDept(deptParent, list);
            StringBuffer sb = new StringBuffer();
            for (int i = list.size() - 1; i >= 0; i--) {
                sb.append(list.get(i).getDeptName());
                if (i > 0) {
                    sb.append("/");
                }
            }
            json.setObject(sb);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return json;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月24日 下午8:58:05
     * 方法介绍:   根据部门排序号获得部门信息接口
     * 参数说明:   @param request 请求
     * 参数说明:   @param maps 集合
     * 参数说明:   @param page 当前页面
     * 参数说明:   @param pageSize 页面大小
     * 参数说明:   @param useFlag 是否开启分页
     * 参数说明:   @return
     *
     * @return String  返回部门信息
     */
    @ResponseBody
    @RequestMapping(value = "/getChDeptByNo", produces = {"application/json;charset=UTF-8"})
    public ToJson<Department> getChDeptByNo(HttpServletRequest request, Map<String, Object> maps, Integer page,
                                            Integer pageSize, boolean useFlag) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Department> json = new ToJson<Department>(0, null);
        try {
            request.setCharacterEncoding("UTF-8");
            String deptNo = new String(request.getParameter("deptNo").getBytes("ISO-8859-1"), "UTF-8");
            maps.put("deptNo", deptNo);
            List<Department> list = new ArrayList<Department>();
            list = departmentService.getChDeptByNo(deptNo, list);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }


    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月25日 下午2:12:15
     * 方法介绍:   获取当前部门下子部门与部门人员
     * 参数说明:   @param request
     * 参数说明:   @return
     *
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/getChDept", produces = {"application/json;charset=UTF-8"})
    public ToJson<Department> getChDeptUser(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Department> json = new ToJson<Department>(0, null);
        try {
            request.setCharacterEncoding("UTF-8");
            int deptId = Integer.parseInt(new String(request.getParameter("deptId").getBytes("ISO-8859-1"), "UTF-8"));
            List<Department> list = departmentService.getChDeptUser(deptId);

            Department dep = departmentService.getDeptById(deptId);
            int count = departmentService.getCountChDeptUser(dep.getDeptNo());
            json.setTotleNum(count);
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }


    @ResponseBody
    @RequestMapping(value = "/listDept", produces = {"application/json;charset=UTF-8"})
    public ToJson<Department> listDept(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Department> json = new ToJson<Department>(0, null);
        try {
            List<Department> list = departmentService.listDept();
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


    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/30 7:59
     * @函数介绍: 查询所有部门，子部门存储在父部门的list属性集合中
     * @参数说明: @param HttpServletRequest request
     * @return: Json
     **/
    @ResponseBody
    @RequestMapping("/getFatherChildDep")
    public ToJson<Department> getFatherChildDept(HttpServletRequest request) {


        ToJson<Department> toJson = new ToJson<Department>(0, "");
        try {
        List<Department> depList = departmentService.getFatherChildDept();
            toJson.setMsg("OK");
            toJson.setFlag(0);
            toJson.setObject(depList);
        } catch (Exception e) {
            toJson.setMsg(e.getMessage());
        }
        return toJson;

    }
}
