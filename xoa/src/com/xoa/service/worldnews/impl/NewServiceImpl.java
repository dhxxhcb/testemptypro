package com.xoa.service.worldnews.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.worldnews.NewsMapper;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;



@Service
public class NewServiceImpl implements NewService {
	
	
	@Resource
	private NewsMapper newsMapper;

	@Override
	public List<News> showNews() {
		// TODO Auto-generated method stub
		return newsMapper.showNews();
	}

	

}
