package com.xoa.dao.notify;

import java.util.List;
import java.util.Map;

import com.xoa.model.notify.Notify;


/**
 * 
 * 创建作者:   张丽军
 * 创建日期:   2017-4-19 上午11:39:21
 * 类介绍  :   公告接口类
 * 构造参数:   无
 *
 */
public interface NotifyMapper {
	
   /**
    * 
    * 创建作者:   张丽军
    * 创建日期:   2017-4-19 上午11:39:53
    * 方法介绍:   条件公告信息查询并返回
    * 参数说明:   @param maps
    * 参数说明:   @return
    * @return     List<Notify>
    */
    List<Notify> selectNotify(Map<String,Object> maps);
    /**
     * 
     * 创建作者:   张丽军
     * 创建日期:   2017-4-19 上午11:40:09
     * 方法介绍:   条件公告管理信息查询并返回
     * 参数说明:   @param maps
     * 参数说明:   @return
     * @return     List<Notify>
     */
	public List<Notify> selectNotifyManage(Map<String, Object> maps);
    
    /**
     * 
     * 创建作者:   张丽军
     * 创建日期:   2017-4-19 上午11:40:18
     * 方法介绍:   未读信息
     * 参数说明:   @param maps
     * 参数说明:   @return
     * @return     List<Notify>
     */
   	public List<Notify> unreadNotify(Map<String, Object> maps);
    
    /**
    * 
    * @Title: getNotifyById
    * @Description: 根据ID获取对象
    * @author(作者):   张丽军
    * @date(日期):        2017-4-18 上午9:34:56
    * @param: @param id
    * @param: @return   
    * @return: List<Notify>   
    * @throws
    */
    List<Notify> getNotifyById(String id);
    
    Notify getNotifyById(Integer id);
    
   
	
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-19 上午11:41:09
	 * 方法介绍:   公告详情信息
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     Notify
	 */
	public Notify detailedNotify(Map<String, Object> maps);
    
    /**
     * 
     * 创建作者:   张丽军
     * 创建日期:   2017-4-19 上午11:41:35
     * 方法介绍:   新增公告信息
     * 参数说明:   @param notify
     * @return     void
     */
   public void addNotify (Notify notify);
    /**
     * 
     * 创建作者:   张丽军
     * 创建日期:   2017-4-19 上午10:29:05
     * 方法介绍:   根据ID更新一条信息
     * 参数说明:   @param notify
     * @return     void
     */
   void updateReaders(Notify notify);
   /**
    * 
    * 创建作者:   张丽军
    * 创建日期:   2017-4-19 上午11:42:49
    * 方法介绍:   更新公告信息
    * 参数说明:   @param notify
    * @return     void
    */
   public void  updateNotify (Notify notify);
  
	 /**
	  * 
	  * 创建作者:   张丽军
	  * 创建日期:   2017-4-19 上午11:43:11
	  * 方法介绍:   根据ID删除一条公告信息
	  * 参数说明:   @param notifyId
	  * @return     void
	  */
   public void deleteById(Integer notifyId);
	
}