package com.test;

import javax.annotation.Resource;

import com.xoa.dao.work.WorkMapper;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.service.workflow.flowtype.FlowRunPrcsService;
import com.xoa.util.ToJson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.xoa.service.department.DepartmentService;
import com.xoa.service.users.UsersPrivService;
import com.xoa.service.users.UsersService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/*	@Resource
		private UsersPrivService usersPrivService;
		@Test
		public void test() throws Exception {

			JSONObject js= usersPrivService.getPrivNameById(new int[] {1, 3, 4});
			System.out.println("根据角色Id取角色名称");
			System.out.println(js.get("privName").toString());
		}*/

	/*	@Resource
		private DepartmentService departmentService;
		@Test
		public void test() throws Exception {

			JSONObject js= departmentService.getDeptNameById(new int[] {3, 4});
			System.out.println("vcc");
			System.out.println(js.get("deptName").toString());


		}*/
	@Resource
	private WorkMapper workMapper;

	@Resource
	private FlowRunPrcsService flowRunPrcsService;

	@Test
	public void test()throws  Exception {
		/*String fils = "2615@1310_598983059";
		String names = fils.substring(0,fils.lastIndexOf("@"));
		String nmas1 = fils.substring(fils.indexOf("@")+1,fils.lastIndexOf("_"));
		String nma = fils.substring(fils.indexOf("_")+1,fils.length());

		System.out.println(names+"||||"+nmas1+"||||"+nma);*/

		/*Map<String,Object> maps=new HashMap<String,Object>();
		maps.put("tableName","flow_data_27");
		maps.put("runId","1012");
		Map<String,Object> map=workMapper.select(maps);
		List<String> key =new ArrayList<String>();
		List<String> value =new ArrayList<String>();

		System.out.println(key.toString());
		System.out.println(value.toString());*/

//		String name = "2615@1310_598983059";
//		String
		Map<String,Object> maps=new HashMap<String,Object>();
		maps.put("tableName","flow_data_24");
		maps.put("runId",4444);
		Map<String, Object> m = workMapper.select(maps);
		System.out.println(m.size());


		/*Map<String,Object> maps=new HashMap<String,Object>();
		//maps.put("userId","admin");
		maps.put("prcsId",1);
		maps.put("runId",1060);

		ToJson<FlowRunPrcs> toJson = new ToJson<FlowRunPrcs>();
		List<FlowRunPrcs> l=flowRunPrcsService.findByRunId(maps);

		FlowRunPrcs f=l.get(0);*/


	}

}
