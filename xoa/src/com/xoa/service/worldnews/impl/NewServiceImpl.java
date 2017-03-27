package com.xoa.service.worldnews.impl;

import com.xoa.dao.worldnews.NewsMapper;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.ToJson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class NewServiceImpl implements NewService {
	
	
	@Resource
	private NewsMapper newsMapper;

	@Override
	public ToJson<News> showNews() {
        ToJson<News> toJson = new ToJson<>(0,"显示结果");
        List<News> list = newsMapper.showNews();
        toJson.setObj(list);
		return toJson;
	}

	

}
