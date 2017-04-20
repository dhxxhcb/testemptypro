package com.xoa.service.worldnews;

import java.util.List;
import java.util.Map;


import com.xoa.model.worldnews.News;
import com.xoa.util.dataSource.DynDatasource;
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-19 下午3:35:07
     * 类介绍  :    新闻Service(逻辑层)
     * 构造参数:    无 
     *
     */
public interface NewService {
	
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:35:41
	 * 方法介绍:   查询新闻列表
	 * 参数说明:   @param maps map条件参数
	 * 参数说明:   @param page  当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @param name 名字
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<News> 返回新闻列表List
	 */
	@DynDatasource
	public List<News> selectNews(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:38:49
	 * 方法介绍:   查询未读新闻列表
	 * 参数说明:   @param maps map条件参数
	 * 参数说明:   @param page  当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @param name 名字
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<News>
	 */
	@DynDatasource
	public List<News> unreadNews(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:39:06
	 * 方法介绍:   
	 * 参数说明:   @param maps map条件参数
	 * 参数说明:   @param page  当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<News>
	 */
	@DynDatasource
	public List<News> selectNewsManage(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag) throws Exception;
	
	/**
	 * 
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:39:24
	 * 方法介绍:   添加新闻
	 * 参数说明:   @param news
	 * @return     void
	 */
	 @DynDatasource
    public void sendNews(News news);
    
	 /**
	  * 
	  * 创建作者:   王曰岐
	  * 创建日期:   2017-4-19 下午3:39:48
	  * 方法介绍:   修改新闻
	  * 参数说明:   @param news
	  * @return     void
	  */
    @DynDatasource
    public void updateNews(News news);
    
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-19 下午3:39:57
     * 方法介绍:   
     * 参数说明:   @param maps map条件参数
	 * 参数说明:   @param page  当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
     * 参数说明:   @param name
     * 参数说明:   @return
     * 参数说明:   @throws Exception
     * @return     News
     */
    @DynDatasource
    public News queryById(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;
    
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-19 下午3:40:16
     * 方法介绍:   根据ID删除一条
     * 参数说明:   @param newsId
     * @return     void
     */
    @DynDatasource
    public void deleteByPrimaryKey(Integer newsId);
}
