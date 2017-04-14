package com.xoa.dao.notify;

import java.util.List;
import java.util.Map;

import com.xoa.model.notify.Notify;


public interface NotifyMapper {
	
    /**
     * 查询
     * @return
     */
    List<Notify> selectNotify(Map<String,Object> maps);
    
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
	  * @param id
	  */
   public void deleteById(String id);
}