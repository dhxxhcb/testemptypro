package com.xoa.service.worldnews;

import java.util.List;
import java.util.Map;


import com.xoa.model.worldnews.News;
import com.xoa.util.dataSource.DynDatasource;

public interface NewService {
	
	
	/**
	 * 
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@DynDatasource
	public List<News> selectNews(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag) throws Exception;

}
