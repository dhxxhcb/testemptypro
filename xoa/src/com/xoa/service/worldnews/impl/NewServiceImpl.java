package com.xoa.service.worldnews.impl;

import com.xoa.dao.worldnews.NewsMapper;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.Page;
import com.xoa.util.ToJson;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;


@Service
public class NewServiceImpl implements NewService {
	
	
	@Resource
	private NewsMapper newsMapper;

	@Override
	public Page<News> showNews(String typeId, Date newsTime, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		Integer pageNum = 0;
		if (currentPage > 1) {
			pageNum = (currentPage - 1) * pageSize;
		}
		Page<News> page = new Page<News>(currentPage, pageSize);
		if (typeId != null && typeId.length() > 0 || newsTime != null) {
			page.setTotalsCount(newsMapper.showCountNews(typeId, newsTime).size());
			page.setResult(newsMapper.showNews(typeId, newsTime, pageNum, pageSize));
		} else {
			page.setTotalsCount(newsMapper.showAllCountNews().size());
			page.setResult(newsMapper.showAllNews(pageNum, pageSize));
		}
		return page;
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
