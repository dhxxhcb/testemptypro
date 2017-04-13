package com.xoa.service.worldnews.impl;

import com.xoa.dao.worldnews.NewsMapper;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.dataSource.DynDatasource;
import com.xoa.util.page.PageParams;
import com.xoa.util.ToJson;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
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
	public List<News> selectNews(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception{
		PageParams pageParams = new PageParams();  
         pageParams.setUseFlag(useFlag);  
         pageParams.setPage(page);  
         pageParams.setPageSize(pageSize);  
         maps.put("page", pageParams);  
         List<News> list = newsMapper.selectNews(maps);
         for (News news : list) {
			if (news.getReaders().indexOf(name)!=-1) {
				news.setRead(1);
			}else {
				news.setRead(0);
			}
		}
         return list;
	}

	@Override
	public List<News> unreadNews(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name) throws Exception {
		PageParams pageParams = new PageParams();  
        pageParams.setUseFlag(useFlag);  
        pageParams.setPage(page);  
        pageParams.setPageSize(pageSize);  
        maps.put("page", pageParams);  
        List<News> list = newsMapper.unreadNews(maps);
        List<News> list1 =new ArrayList<News>();
        	for (News news : list) {
    			if (news.getReaders().indexOf(name)==-1) {
    				list1.add(news);
				}
		}
        return list1;
	}
	
}
	


