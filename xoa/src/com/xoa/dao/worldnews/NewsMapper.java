package com.xoa.dao.worldnews;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.worldnews.News;
/**
 * 
 * @ClassName (类名):  NewsMapper
 * @Description(简述): 新闻DAO
 * @author(作者):      wyq
 * @date(日期):        2017-4-17 下午5:53:28
 *
 */
public interface NewsMapper extends BaseMapper<News> {
	/**
	 * 
	 * @Title: selectNews
	 * @Description:条件新闻信息查询并返回
	 * @author(作者):      wyq
	 * @param: @param maps
	 * @param: @return   
	 * @return: List<News>   
	 * @throws
	 */
	public List<News> selectNews(Map<String, Object> maps);
	/**
	 * 
	 * @Title: selectNewsManage
	 * @Description: 条件新闻管理信息查询并返回
	 * @author(作者):      wyq
	 * @param: @param maps
	 * @param: @return   
	 * @return: List<News>   
	 * @throws
	 */
	public List<News> selectNewsManage(Map<String, Object> maps);
	/**
	 * 
	 * @Title: unreadNews
	 * @Description: 未读新闻
	 * @author(作者):      wyq
	 * @param: @param maps
	 * @param: @return   
	 * @return: List<News>   
	 * @throws
	 */
	public List<News> unreadNews(Map<String, Object> maps);
	/**
	 * 
	 * @Title: detailedNews
	 * @Description: 详细新闻
	 * @author(作者):      wyq
	 * @param: @param maps
	 * @param: @return   
	 * @return: News   
	 * @throws
	 */
	public News detailedNews(Map<String, Object> maps);
	/**
	 * 
	 * @Title: deleteNews
	 * @Description: 删除新闻
	 * @author(作者):      wyq
	 * @param: @param newsId   
	 * @return: void   
	 * @throws
	 */
	public void deleteNews(@Param("newsId") Integer newsId);
	/**
	 * 
	 * @Title: updateNews
	 * @Description: 修改未读新闻
	 * @author(作者):      wyq
	 * @param: @param news   
	 * @return: void   
	 * @throws
	 */
	public void updateNews(News news);
	/**
	 * 
	 * @Title: updateclickCount
	 * @Description: 修改新闻点击数
	 * @author(作者):      wyq
	 * @param: @param news   
	 * @return: void   
	 * @throws
	 */
	public void updateclickCount(News news);
	/**
	 * 
	 * @Title: showCountNews
	 * @Description: 共计多少条信息
	 * @author(作者):      wyq
	 * @param: @param typeId
	 * @param: @param newsTime
	 * @param: @return   
	 * @return: List<News>   
	 * @throws
	 */
	public List<News> showCountNews(@Param("typeId") String typeId,
			@Param("newsTime") Date newsTime);

	/**
	 * 
	 * @Title: showAllNews
	 * @Description: 条件新闻信息查询并返回
	 * @author(作者):      wyq
	 * @param: @param start
	 * @param: @param pagesize
	 * @param: @return   
	 * @return: List<News>   
	 * @throws
	 */
	public List<News> showAllNews(@Param("start") int start,
			@Param("pagesize") int pagesize);

	/**
	 * 
	 * @Title: showAllCountNews
	 * @Description: 共计多少条信息
	 * @author(作者):      wyq
	 * @param: @return   
	 * @return: List<News>   
	 * @throws
	 */
	public List<News> showAllCountNews();

}