package com.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:config/spring/springs-beans.xml"}) 
public class Ctest {

	@Resource  
	private NewService newService;
	@Test
	public void test() throws Exception {
		
		 Map<String,Object> maps = new HashMap<String, Object>();
	     maps.put("typeId", null);
	     maps.put("newsTime", null);
	    List<News> page = newService.selectNews(maps);
		System.out.println(JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss"));
		
	}

}
