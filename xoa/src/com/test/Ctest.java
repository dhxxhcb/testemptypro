package com.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:config/spring/springs-beans.xml"}) 
public class Ctest {

	@Resource  
	private NewService newService;
	@Test
	public void test() {
		fail("Not yet implemented");
//		News news = newService.showNews();
//		System.out.println(JSONArray.toJSON(news));
	}

}
