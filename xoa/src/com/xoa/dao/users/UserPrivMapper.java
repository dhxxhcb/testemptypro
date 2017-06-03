package com.xoa.dao.users;

import com.xoa.model.users.UserPriv;

import java.util.List;
import java.util.Map;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:38:35
 * 类介绍  :    角色权限表
 * 构造参数:   无
 *
 */
public interface UserPrivMapper {
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:38:41
     * 方法介绍:   根据userpriv删除角色
     * 参数说明:   @param userPriv 角色编号
     * @return     void  无
     */
    void deleteByPrimaryKey(Integer userPriv);
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:38:47
     * 方法介绍:   新增userpriv
     * 参数说明:   @param record 角色信息
     * 参数说明:   @return
     * @return     int 插入条数
     */
    int insert(UserPriv record);
  
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:38:53
     * 方法介绍:   新增角色
     * 参数说明:   @param record 角色信息
     * @return     void  无
     */
    void insertSelective(UserPriv record);   
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:38:59
     * 方法介绍:   根据userpriv查询userpriv
     * 参数说明:   @param userPriv  角色
     * 参数说明:   @return
     * @return     UserPriv  角色
     */
    UserPriv selectByPrimaryKey(int userPriv);
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:39:05
     * 方法介绍:   更新
     * 参数说明:   @param record 角色信息
     * 参数说明:   @return
     * @return     int 
     */
    int updateByPrimaryKeySelective(UserPriv record);
  
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:39:11
     * 方法介绍:   更新
     * 参数说明:   @param record  角色信息
     * 参数说明:   @return
     * @return     int  插入记录
     */
    int updateByPrimaryKey(UserPriv record);   
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:39:17
     * 方法介绍:   根据userpriv获取privname
     * 参数说明:   @param userPriv  角色
     * 参数说明:   @return
     * @return     String 角色名称
     */
    String getPrivNameById(Integer userPriv);  
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:39:24
     * 方法介绍:   获取所有userpriv
     * 参数说明:   @param maps 集合
     * 参数说明:   @return
     * @return     List<UserPriv>  返回角色集合
     */
    List<UserPriv> getAlluserPriv(Map<String,Object> maps); 
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:39:31
     * 方法介绍:   多条件获取userpriv
     * 参数说明:   @param userPriv  角色信息
     * 参数说明:   @return
     * @return     List<UserPriv>  返回角色信息
     */
    List<UserPriv> getPrivByMany(UserPriv userPriv);


     List<UserPriv> getUserPrivNameByFuncId(String fid);


     String getUserPrivfuncIdStr(String id);


     void updateUserPrivFuncIdStr(Map<String, Object> hashMap);

     /**
      * 创建作者:   张勇
      * 创建日期:   2016年6月3日 下午4:02:05
      * 方法介绍:   根据privid串获取privName
      * 参数说明:   @param uids  用户uid串
      * 参数说明:   @return
      *
      * @return List<String>  返回部门串
      */
     public String getPrivNameByPrivId(Integer userPriv);

 }