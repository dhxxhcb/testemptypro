package com.xoa.service.notify;

import java.util.List;
import java.util.Map;

import com.xoa.model.notify.Notify;
import com.xoa.model.worldnews.News;
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
	 * 
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@DynDatasource
	public List<Notify> selectNotifyManage(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag) throws Exception;
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
    * @param notifyId
    */
   @DynDatasource
   public void delete(Integer notifyId);
   /**
  	 * 根据ID查找公告详情
  	 * 
  	 * @param notifyId
  	 *          
  	 */
public Notify queryById(Map<String, Object> maps, Integer page, Integer pageSize,boolean useFlag, String name) throws Exception;

 
}
