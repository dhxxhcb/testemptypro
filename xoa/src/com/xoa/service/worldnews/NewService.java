package com.xoa.service.worldnews;

import com.xoa.model.worldnews.News;
import com.xoa.util.ToJson;

public interface NewService {
	
	
	/**
	 * 新闻信息查询展示
	 * @return
	 */
	public ToJson<News> showNews();

}
