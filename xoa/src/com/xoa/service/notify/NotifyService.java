package com.xoa.service.notify;

import java.util.List;
import java.util.Map;

import com.xoa.model.notify.Notify;


import com.xoa.util.ToJson;
/**
 * 
 * 创建作者:   张丽军
 * 创建日期:   2017-4-18 下午11:58:21
 * 类介绍  :   公告接口
 * 构造参数:   无
 *
 */
public interface NotifyService {

	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午11:59:41
	 * 方法介绍:   查询公告信息
	 * 参数说明:   @param maps  map条件参数
	 * 参数说明:   @param page  当前页
	 * 参数说明:   @param pageSize  每页显示条数
	 * 参数说明:   @param useFlag   是否开启分页插件
	 * 参数说明:   @param name
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<Notify>
	 */
	public ToJson<Notify>  selectNotify(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;

	
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-19 上午12:03:43
	 * 方法介绍:   查询公告管理信息
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<Notify>
	 */
	public List<Notify> selectNotifyManage(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name,String sqlType) throws Exception;
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-19 上午12:03:54
	 * 方法介绍:   未读信息
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @param name
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<Notify>
	 */
	public ToJson<Notify>  unreadNotify(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name,String sqlType) throws Exception;
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-19 上午12:03:54
	 * 方法介绍:   已读信息
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @param name
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<Notify>
	 */
	public ToJson<Notify>  readNotify(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name,String sqlType) throws Exception;
   /**
   * 
   * 创建作者:   张丽军
   * 创建日期:   2017-4-19 上午11:48:39
   * 方法介绍:   根据ID获取公告信息
   * 参数说明:   @param id
   * 参数说明:   @return
   * @return     List<Notify>
   */
	public List<Notify> getNotifyById(String id);
   
   /**
    * 
    * 创建作者:   张丽军
    * 创建日期:   2017-4-19 上午11:49:31
    * 方法介绍:   更新公告信息
    * 参数说明:   @param notify
    * @return     void
    */
   public  void updateNotify(Notify notify);
   
   /**
    * 
    * 创建作者:   张丽军
    * 创建日期:   2017-4-19 上午11:51:03
    * 方法介绍:   根据ID获取一条公告信息
    * 参数说明:   @param id
    * 参数说明:   @return
    * @return     Notify
    */
   public Notify getNotifyById(Integer id);
  /**
   * 
   * 创建作者:   张丽军
   * 创建日期:   2017-4-19 上午11:51:20
   * 方法介绍:   新增公告信息
   * 参数说明:   @param notify
   * @return     void
   */
   public  int addNotify(Notify notify);
   
   /**
    * 
    * 创建作者:   张丽军
    * 创建日期:   2017-4-19 上午11:51:31
    * 方法介绍:   删除公告信息
    * 参数说明:   @param notifyId
    * @return     void
    */
   public void delete(Integer notifyId);
   /**
    * 
    * 创建作者:   张丽军
    * 创建日期:   2017-4-19 上午11:51:50
    * 方法介绍:   根据ID查找公告详情
    * 参数说明:   @param maps
    * 参数说明:   @param page
    * 参数说明:   @param pageSize
    * 参数说明:   @param useFlag
    * 参数说明:   @param name
    * 参数说明:   @return
    * 参数说明:   @throws Exception
    * @return     Notify
    */
   public Notify queryById(Map<String, Object> maps, Integer page, Integer pageSize,boolean useFlag, String name,String sqlType) throws Exception;

 
}
