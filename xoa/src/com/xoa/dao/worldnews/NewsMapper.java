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
	 * 条件新闻管理信息查询并返回
	 * 
	 * @return
	 */
	public List<News> selectNewsManage(Map<String, Object> maps);
	
	/**
	 * 未读新闻
	 * 
	 * @return
	 */
	public List<News> unreadNews(Map<String, Object> maps);
	/**
	 * 详细新闻
	 * 
	 * @return
	 */
	public News detailedNews(Map<String, Object> maps);
	
	/**
	 * 删除新闻
	 * 
	 * @return
	 */
	public void deleteNews(@Param("newsId") Integer newsId);
	/**
	 * 修改未读新闻
	 * 
	 * @return
	 */
	public void updateNews(News news);
	/**
	 * 修改新闻点击数
	 * 
	 * @return
	 */
	public void updateclickCount(News news);

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