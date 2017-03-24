package com.xoa.service.worldnews;

import java.util.List;

import com.xoa.model.worldnews.News;

public interface NewService {
	
	
	/**
	 * 新闻信息查询展示
	 * @return
	 */
	public List<News> showNews();

}
