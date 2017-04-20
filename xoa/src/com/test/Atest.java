package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xoa.model.department.Department;
import com.xoa.model.users.Users;
import com.xoa.service.department.DepartmentService;
import com.xoa.service.users.UsersPrivService;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:config/spring/springs-beans.xml"})
public class Atest {
	
	 
	

	/*	@Resource  
		private NewService newService;
		@Test
		public void test() throws Exception {
			
			 Map<String,Object> maps = new HashMap<String, Object>();
		     maps.put("typeId", null);
		     maps.put("newsTime", null);
		    List<News> page = newService.selectNews(maps, 1, 5, true);
			System.out.println(JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss"));

		}*/
		/*
		@Resource  
		private UsersService usersService;
		@Test
		public void test() throws Exception {
			
			JSONObject js= usersService.getUserNameById(new int[] {1, 3, 4});
			System.out.println("根据用户id取姓名");
			System.out.println(js.get("userName").toString());
		}*/
		
	/*@Resource  
		private UsersPrivService usersPrivService;
		@Test
		public void test() throws Exception {
			
			JSONObject js= usersPrivService.getPrivNameById(new int[] {1, 3, 4});
			System.out.println("根据角色Id取角色名称");
			System.out.println(js.get("privName").toString());
		}*/
		
		@Resource  
		private DepartmentService departmentService;
		
		@Resource
		private UsersService userSerice;
		
		@Test
		public void test() throws Exception {
//			List<Department> list1 =departmentService.getDatagrid();
//			
//			
//			List<Department> list =departmentService.getDatagrid();
//			//List<String> list = departmentService.getDeptNameById(new int[] {3,4,5});
//			System.out.println("vcc");
//			System.out.println(list.get(0).toString());
			
			ToJson<Users> json=new ToJson<Users>(0, null);
			try {
				//Users user=new Users();
				//maps=new HashMap<String, Object>();
				Map<String, Object> maps = new HashMap<String, Object>();
				maps.put("userName", "刘同");
				maps.put("userPrivName", null);
				maps.put("deptName", null);
				List<Users> list=userSerice.getBySearch(maps,1,5,false);  
				json.setObj(list);
	            json.setMsg("OK");
	            //json.setFlag(true);
			} catch (Exception e) {
				System.out.println("错误信息："+e);
				
			}
			System.out.println(JSON.toJSONStringWithDateFormat(json,"yyyy-MM-dd HH:mm:ss"));
		
		
		}
	

}
