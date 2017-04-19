package com.xoa.dao.users;

import java.util.List;
import java.util.Map;

import com.xoa.model.users.UserPriv;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:38:35
 * 类介绍  :    角色权限表
 * 构造参数:   
 *
 */
public interface UserPrivMapper {
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:38:41
     * 方法介绍:   根据userpriv删除角色
     * 参数说明:   @param userPriv
     * @return     void
     */
    void deleteByPrimaryKey(Integer userPriv);
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:38:47
     * 方法介绍:   新增userpriv
     * 参数说明:   @param record
     * 参数说明:   @return
     * @return     int
     */
    int insert(UserPriv record);
  
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:38:53
     * 方法介绍:   新增userpriv
     * 参数说明:   @param record
     * @return     void
     */
    void insertSelective(UserPriv record);   
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:38:59
     * 方法介绍:   根据userpriv查询userpriv
     * 参数说明:   @param userPriv
     * 参数说明:   @return
     * @return     UserPriv
     */
    UserPriv selectByPrimaryKey(int userPriv);
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:39:05
     * 方法介绍:   更新
     * 参数说明:   @param record
     * 参数说明:   @return
     * @return     int
     */
    int updateByPrimaryKeySelective(UserPriv record);
  
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:39:11
     * 方法介绍:   更新
     * 参数说明:   @param record
     * 参数说明:   @return
     * @return     int
     */
    int updateByPrimaryKey(UserPriv record);   
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:39:17
     * 方法介绍:   根据userpriv获取privname
     * 参数说明:   @param userPriv
     * 参数说明:   @return
     * @return     String
     */
    String getPrivNameById(Integer userPriv);  
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:39:24
     * 方法介绍:   获取所有userpriv
     * 参数说明:   @param maps
     * 参数说明:   @return
     * @return     List<UserPriv>
     */
    List<UserPriv> getAlluserPriv(Map<String,Object> maps); 
   
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年4月18日 下午6:39:31
     * 方法介绍:   多条件获取userpriv
     * 参数说明:   @param userPriv
     * 参数说明:   @return
     * @return     List<UserPriv>
     */
    List<UserPriv> getPrivByMany(UserPriv userPriv); 
}