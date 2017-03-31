package com.xoa.service.worldnews;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xoa.model.worldnews.News;
import com.xoa.util.page.Page;
import com.xoa.util.ToJson;

public interface NewService {
	
	
	/**
	 * 新闻信息查询展示
	 * @return
	 * @throws Exception 
	 */
//	public Page<News> showNews(String typeId,Date newsTime,Integer currentPage, Integer pageSize);
	public Page<News> selectNews(Map<String, Object> maps) throws Exception;
//	public ToJson<News> showNews();

}
