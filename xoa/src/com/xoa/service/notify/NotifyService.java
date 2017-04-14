package com.xoa.service.notify;

import java.util.List;
import java.util.Map;

import com.xoa.model.notify.Notify;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;

public interface NotifyService {

	/**
	 * 查询公告
	 * @param 
	 * @return
	 * @throws Exception 
	 */
	@DynDatasource
   public  List<Notify>  selectNotify(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;
	/**
	 * 未读公告
	 * @param 
	 * @return
	 * @throws Exception 
	 */
	@DynDatasource
	public List<Notify> unreadNotify(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;

  /**
    * 根据ID获取数据
    * @param id
    * @return
    */
   public List<Notify> getNotifyById(String id);
   
   
   /**
    * 修改
    * @param notify
    */
   @DynDatasource
   public  void updateNotify(Notify notify);
   
   
   public Notify getNotifyById(Integer id);
   /**
    * 保存
    * @param notify
    */
   @DynDatasource
   public  void addNotify(Notify notify);
   
   /**
    * 删除
    * @param id
    */
   @DynDatasource
   public void delete(String id);
}
