package com.xoa.dao.worldnews;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.worldnews.News;

/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-19 下午3:30:59
 * 类介绍  :    新闻DAO
 * 构造参数:    无
 *
 */
public interface NewsMapper extends BaseMapper<News> {
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:31:13
	 * 方法介绍:   条件新闻信息查询并返回
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     List<News>
	 */
	public List<News> selectNews(Map<String, Object> maps);
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:31:25
	 * 方法介绍:   条件新闻管理信息查询并返回
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     List<News>
	 */
	public List<News> selectNewsManage(Map<String, Object> maps);
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:31:44
	 * 方法介绍:   未读新闻
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     List<News>
	 */
	public List<News> unreadNews(Map<String, Object> maps);
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:31:52
	 * 方法介绍:   详细新闻
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     News
	 */
	public News detailedNews(Map<String, Object> maps);
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:33:43
	 * 方法介绍:   删除新闻
	 * 参数说明:   @param newsId
	 * @return     void
	 */
	public void deleteNews(@Param("newsId") Integer newsId);
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:33:51
	 * 方法介绍:   修改未读新闻
	 * 参数说明:   @param news
	 * @return     void
	 */
	public void updateNews(News news);
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:34:00
	 * 方法介绍:   修改新闻点击数
	 * 参数说明:   @param news
	 * @return     void
	 */
	public void updateclickCount(News news);
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:34:09
	 * 方法介绍:   共计多少条信息
	 * 参数说明:   @param typeId
	 * 参数说明:   @param newsTime
	 * 参数说明:   @return
	 * @return     List<News>
	 */
	public List<News> showCountNews(@Param("typeId") String typeId,
			@Param("newsTime") Date newsTime);

	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:34:18
	 * 方法介绍:   条件新闻信息查询并返回
	 * 参数说明:   @param start
	 * 参数说明:   @param pagesize
	 * 参数说明:   @return
	 * @return     List<News>
	 */
	public List<News> showAllNews(@Param("start") int start,
			@Param("pagesize") int pagesize);

	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:34:27
	 * 方法介绍:   共计多少条信息
	 * 参数说明:   @return
	 * @return     List<News>
	 */
	public List<News> showAllCountNews();

}