package com.xoa.service.worldnews.impl;

import com.xoa.dao.worldnews.NewsMapper;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.page.Page;
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

//	@Override
//	public Page<News> showNews(String typeId, Date newsTime, Integer currentPage, Integer pageSize) {
//		// TODO Auto-generated method stub
//		Integer pageNum = 0;
//		if (currentPage > 1) {
//			pageNum = (currentPage - 1) * pageSize;
//		}
//		Page<News> page = new Page<News>(currentPage, pageSize);
//		if (typeId != null && typeId.length() > 0 || newsTime != null) {
//			page.setTotalsCount(newsMapper.showCountNews(typeId, newsTime).size());
//			page.setResult(newsMapper.showNews(typeId, newsTime, pageNum, pageSize));
//		} else {
//			page.setTotalsCount(newsMapper.showAllCountNews().size());
//			page.setResult(newsMapper.showAllNews(pageNum, pageSize));
//		}
//		return page;
//	}
	@Override
	public Page<News> selectNews(Map<String, Object> maps) throws Exception{
         Page<News> pageParams = new Page<News>();  
         pageParams.setUseFlag(true);  
         pageParams.setCheckFlag(false);  
         pageParams.setCurrentPage(2);  
         pageParams.setPageSize(5);  
         maps.put("roleName", "test");  
         maps.put("page_drsdsd2233", pageParams);  
         List<News> list = newsMapper.selectNews(maps);
         System.out.println("新闻查询结果："+list.size());
         
         pageParams.setResult(list);
//         pageParams.setResult();
         return pageParams;
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
