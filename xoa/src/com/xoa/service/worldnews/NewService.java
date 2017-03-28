package com.xoa.service.worldnews;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.xoa.model.worldnews.News;
import com.xoa.util.Page;
import com.xoa.util.ToJson;

public interface NewService {
	
	
	/**
	 * 新闻信息查询展示
	 * @return
	 */
	public Page<News> showNews(String typeId,Date newsTime,Integer currentPage, Integer pageSize);
//	public ToJson<News> showNews();

}
