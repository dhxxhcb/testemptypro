package com.xoa.dao.notify;

import java.util.List;
import java.util.Map;

import com.xoa.model.notify.Notify;
import com.xoa.model.worldnews.News;

/**
 * 
 * @ClassName (类名):  NotifyMapper
 * @Description(简述): 公告接口类
 * @author(作者):      张丽军
 * @date(日期):        2017-4-18 上午9:34:56
 *
 */
public interface NotifyMapper {
	
   /**
    * 
    * @Title: selectNotify
    * @Description: 条件公告信息查询并返回
    * @author(作者):     张丽军
    * @date(日期):        2017-4-18 上午9:34:56
    * @param: @param maps
    * @param: @return   
    * @return: List<Notify>   
    * @throws
    */
    List<Notify> selectNotify(Map<String,Object> maps);
    /**
     * 
     * @Title: selectNotifyManage
     * @Description: 条件公告管理信息查询并返回
     * @author(作者):     张丽军
     * @date(日期):        2017-4-18 上午9:34:56
     * @param: @param maps
     * @param: @return   
     * @return: List<Notify>   
     * @throws
     */
	public List<Notify> selectNotifyManage(Map<String, Object> maps);
    
    /**
     * 
     * @Title: unreadNotify
     * @Description: 未读信息
     * @author(作者):     张丽军
     * @date(日期):        2017-4-18 上午9:34:56
     * @param: @param maps
     * @param: @return   
     * @return: List<Notify>   
     * @throws
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
	 * @Title: detailedNotify
	 * @Description: 公告详情 
	 * @author(作者):     张丽军
	 * @date(日期):        2017-4-18 上午9:34:56
	 * @param: @param maps
	 * @param: @return   
	 * @return: Notify   
	 * @throws
	 */
	public Notify detailedNotify(Map<String, Object> maps);
    
    /**
     * 
     * @Title: addNotify
     * @Description: 新增公告信息
     * @author(作者):      张丽军
     * @date(日期):        2017-4-18 上午9:34:56
     * @param: @param notify   
     * @return: void   
     * @throws
     */
   public void addNotify (Notify notify);
    /**
     * 
     * 创建作者:   吴道全
     * 创建日期:   2017-4-19 上午10:29:05
     * 方法介绍:   根据ID更新一条信息
     * 参数说明:   @param notify
     * @return     void
     */
   void updateReaders(Notify notify);
   /**
    * 
    * @Title: updateNotify
    * @Description: 更新公告信息
    * @author(作者):     张丽军
    * @date(日期):        2017-4-18 上午9:34:56
    * @param: @param notify   
    * @return: void   
    * @throws
    */
   public void  updateNotify (Notify notify);
  
	 /**
	  * 
	  * @Title: deleteById
	  * @Description: 根据ID删除一条公告信息
	  * @author(作者):     张丽军
	  * @date(日期):        2017-4-18 上午9:34:56
	  * @param: @param notifyId   
	  * @return: void   
	  * @throws
	  */
   public void deleteById(Integer notifyId);
	
}