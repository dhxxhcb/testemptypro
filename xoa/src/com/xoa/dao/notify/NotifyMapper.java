package com.xoa.dao.notify;

import java.util.List;
import java.util.Map;

import com.xoa.model.notify.Notify;
import com.xoa.model.worldnews.NewsModel;


public interface NotifyMapper {
	
    /**
     * 条件公告信息查询并返回
     * @return
     */
    List<Notify> selectNotify(Map<String,Object> maps);
    /**
	 * 条件公告管理信息查询并返回
	 * 
	 * @return
	 */
	public List<Notify> selectNotifyManage(Map<String, Object> maps);
    
    /**
   	 * 未读信息
   	 * 
   	 * @return
   	 */
   	public List<Notify> unreadNotify(Map<String, Object> maps);
    
    /**
     * 根据ID获取对象
     * @param id
     * @return
     */
    List<Notify> getNotifyById(String id);
    
    Notify getNotifyById(Integer id);
    
    /**
	 * 修改公告点击数
	 * 
	 * @return
	 */
	public void updateclickCount(Notify notify);
    /**
     * 
     * 未读变已读，点击数加1
     */
	public void updateclickNotify(Notify notify);
	
    /**
	 * 详细公告
	 * 
	 * @return
	 */
	public Notify detailedNotify(Map<String, Object> maps);
    
    /**
     * 增加
     * @param notify
     */
   public void addNotify (Notify notify);
    
   /**
    * 更新
    * @param notify
    */
   public void  updateNotify (Notify notify);
  
	 /**
	  * 删除
	  * @param notifyId
	  */
   public void deleteById(Integer notifyId);
}