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

	/**
	 * 
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<News> selectNews(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag) throws Exception{
		PageParams pageParams = new PageParams();  
         pageParams.setUseFlag(useFlag);  
         pageParams.setPage(page);  
         pageParams.setPageSize(pageSize);  
         maps.put("page", pageParams);  
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
