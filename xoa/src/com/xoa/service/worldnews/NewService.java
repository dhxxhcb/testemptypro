package com.xoa.service.worldnews;

import java.util.List;
import java.util.Map;


import com.xoa.model.worldnews.News;
import com.xoa.util.dataSource.DynDatasource;

public interface NewService {
	
	
	/**
	 * 新闻信息查询展示
	 * @return
	 * @throws Exception 
	 */
	@DynDatasource
	public List<News> selectNews(Map<String, Object> maps) throws Exception;

}
