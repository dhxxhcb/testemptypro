package com.xoa.dao.worldnews;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.worldnews.News;

public interface NewsMapper extends BaseMapper<News> {
	/**
	 * 条件新闻信息查询并返回
	 * 
	 * @return
	 */
	public List<News> selectNews(Map<String, Object> maps);

	/**
	 * 共计多少条信息
	 * 
	 * @param typeId
	 * @param newsTime
	 * @return
	 */
	public List<News> showCountNews(@Param("typeId") String typeId,
			@Param("newsTime") Date newsTime);

	/**
	 * 条件新闻信息查询并返回
	 * 
	 * @return
	 */
	public List<News> showAllNews(@Param("start") int start,
			@Param("pagesize") int pagesize);

	/**
	 * 共计多少条信息
	 * 
	 * @param typeId
	 * @param newsTime
	 * @return
	 */
	public List<News> showAllCountNews();

}