package com.xoa.service.notify;

import java.util.List;
import java.util.Map;

import com.xoa.model.notify.Notify;
import com.xoa.model.worldnews.News;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;
/**
 * 
 * 创建作者:   吴道全
 * 创建日期:   2017-4-18 下午11:58:21
 * 类介绍  :   公告接口
 * 构造参数:   无
 *
 */
public interface NotifyService {

	/**
	 * 
	 * 创建作者:   吴道全
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
	@DynDatasource
   public  List<Notify>  selectNotify(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;
	/**
	 * 
	 * 创建作者:   吴道全
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
	@DynDatasource
	public List<Notify> selectNotifyManage(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag) throws Exception;
	/**
	 * 
	 * 创建作者:   吴道全
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
	@DynDatasource
	public List<Notify> unreadNotify(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;

  /**
   * 
   * @Title: getNotifyById
   * @Description: 根据ID获取公告信息
   * @author(作者):     张丽军
   * @date(日期):        2017-4-18 上午9:36:01
   * @param: @param id
   * @param: @return   
   * @return: List<Notify>   
   * @throws
   */
   public List<Notify> getNotifyById(String id);
   
   /**
    * 
    * @Title: updateNotify
    * @Description: 更新公告信息
    * @author(作者):      张丽军
    * @date(日期):        2017-4-18 上午9:36:01
    * @param: @param notify   
    * @return: void   
    * @throws
    */
   @DynDatasource
   public  void updateNotify(Notify notify);
   
   /**
    * 
    * @Title: getNotifyById
    * @Description: 更新公告信息
    * @author(作者):      张丽军
    * @date(日期):        2017-4-18 上午9:36:01
    * @param: @param id
    * @param: @return   
    * @return: Notify   
    * @throws
    */
   public Notify getNotifyById(Integer id);
  /**
   * 
   * @Title: addNotify
   * @Description: 新增公告信息
   * @author(作者):     张丽军
   * @date(日期):        2017-4-18 上午9:36:01
   * @param: @param notify   
   * @return: void   
   * @throws
   */
   @DynDatasource
   public  void addNotify(Notify notify);
   
   /**
    * 
    * @Title: delete
    * @Description: 删除公告信息
    * @author(作者):     张丽军
    * @date(日期):        2017-4-18 上午9:36:01
    * @param: @param notifyId   
    * @return: void   
    * @throws
    */
   @DynDatasource
   public void delete(Integer notifyId);
   /**
    * 
    * @Title: queryById
    * @Description: 根据ID查找公告详情
    * @author(作者):     张丽军
    * @date(日期):        2017-4-18 上午9:36:01
    * @param: @param maps
    * @param: @param page
    * @param: @param pageSize
    * @param: @param useFlag
    * @param: @param name
    * @param: @return
    * @param: @throws Exception   
    * @return: Notify   
    * @throws
    */
   @DynDatasource
public Notify queryById(Map<String, Object> maps, Integer page, Integer pageSize,boolean useFlag, String name) throws Exception;

 
}
