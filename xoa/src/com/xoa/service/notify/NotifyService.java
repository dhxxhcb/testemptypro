package com.xoa.service.notify;

import java.util.List;
import java.util.Map;

import com.xoa.model.notify.Notify;
import com.xoa.model.worldnews.News;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;
/**
 * 
 * @ClassName (类名):  NotifyService
 * @Description(简述): 公告接口
 * @author(作者):     张丽军
 * @date(日期):        2017-4-18 上午9:36:01
 *
 */
public interface NotifyService {

	/**
	 * 
	 * @Title: selectNotify
	 * @Description: 查询接口
	 * @author(作者):    张丽军
	 * @date(日期):        2017-4-18 上午9:36:01
	 * @param: @param maps
	 * @param: @param page
	 * @param: @param pageSize
	 * @param: @param useFlag
	 * @param: @param name
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: List<Notify>   
	 * @throws
	 */
	@DynDatasource
   public  List<Notify>  selectNotify(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception;
	/**
     * 
     * @Title: selectNotifyManage
     * @Description: 查询公告管理信息
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param maps  map条件参数
     * @param: @param page  当前页
     * @param: @param pageSize  每页显示条数
     * @param: @param useFlag  是否开启分页插件
     * @param: @return
     * @param: @throws Exception   
     * @return: List<Notify>   
     * @throws
     */
	@DynDatasource
	public List<Notify> selectNotifyManage(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag) throws Exception;
	/**
	 * 
	 * @Title: unreadNotify
	 * @Description: 未读信息
	 * @author(作者):    张丽军
	 * @param: @param maps
	 * @date(日期):        2017-4-18 上午9:36:01
	 * @param: @param page
	 * @param: @param pageSize
	 * @param: @param useFlag
	 * @param: @param name
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: List<Notify>   
	 * @throws
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
public Notify queryById(Map<String, Object> maps, Integer page, Integer pageSize,boolean useFlag, String name) throws Exception;

 
}
