package com.xoa.service.worldnews.impl;

import com.xoa.dao.worldnews.NewsMapper;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.dataSource.DynDatasource;
import com.xoa.util.page.PageParams;
import com.xoa.util.ToJson;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class NewServiceImpl implements NewService {
	
	
	@Resource
	private NewsMapper newsMapper;

	@Override
	public List<News> selectNews(Map<String, Object> maps) throws Exception{
		PageParams pageParams = new PageParams();  
         pageParams.setUseFlag(true);  
         pageParams.setCheckFlag(false);  
         pageParams.setPage(1);  
         pageParams.setPageSize(5);  
//         maps.put("roleName", "test");  
         maps.put("page_drsdsd2233", pageParams);  
         List<News> list = newsMapper.selectNews(maps);
         System.out.println("新闻查询结果："+list.size());
         return list;
	}

	
//	
//	@Override
//	public ToJson<News> showNews() {
//        ToJson<News> toJson = new ToJson<News>(0,"显示结果");
//        List<News> list = newsMapper.showNews();
//        toJson.setObj(list);
//		return toJson;
//	}

	

}
