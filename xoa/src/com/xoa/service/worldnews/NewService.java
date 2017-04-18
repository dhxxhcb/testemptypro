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
	public List<News> selectNews(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;
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
	public List<News> unreadNews(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;
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
	public List<News> selectNewsManage(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag) throws Exception;
	/**
	 * 添加新闻
	 * 
	 * @param news
	 *           
	 */
	 @DynDatasource
    public void sendNews(News news);
    /**
	 * 修改新闻
	 * 
	 * @param news
	 *            邮件Id
	 */
    @DynDatasource
    public void updateNews(News news);
    /**
	 * 根据ID查找新闻详情
	 * 
	 * @param newsId
	 *            新闻Id
	 */
    @DynDatasource
    public News queryById(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;
    /**
	 * 根据ID删除一条
	 * 
	 * @param newsId
	 *            新闻Id
	 */
    @DynDatasource
    public void deleteByPrimaryKey(Integer newsId);
}
