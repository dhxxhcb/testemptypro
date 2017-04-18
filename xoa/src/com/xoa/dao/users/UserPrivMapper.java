package com.xoa.dao.users;

import java.util.List;
import java.util.Map;

import com.xoa.model.users.UserPriv;

 /**
 * @ClassName (类名):  UserPrivMapper
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午4:07:10
 *
 */
public interface UserPrivMapper {
    /**
     * @Title: deleteByPrimaryKey
     * @Description: TODO
     * @author(作者):      zlf
     * @param: @param userPriv   
     * @return: void   
     * @throws
     */
    void deleteByPrimaryKey(Integer userPriv);
    /**
     * @Title: insert
     * @Description: TODO
     * @author(作者):      zlf
     * @param: @param record
     * @param: @return   
     * @return: int   
     * @throws
     */
    int insert(UserPriv record);
    
    /**
     * @Title: insertSelective
     * @Description: TODO
     * @author(作者):      zlf
     * @param: @param record   
     * @return: void   
     * @throws
     */
    void insertSelective(UserPriv record);   
    /**
     * @Title: selectByPrimaryKey
     * @Description: TODO
     * @author(作者):      zlf
     * @param: @param userPriv
     * @param: @return   
     * @return: UserPriv   
     * @throws
     */
    UserPriv selectByPrimaryKey(int userPriv);
    /**
     * @Title: updateByPrimaryKeySelective
     * @Description: TODO
     * @author(作者):      zlf
     * @param: @param record
     * @param: @return   
     * @return: int   
     * @throws
     */
    int updateByPrimaryKeySelective(UserPriv record);
    /**
     * @Title: updateByPrimaryKey
     * @Description: TODO
     * @author(作者):      zlf
     * @param: @param record
     * @param: @return   
     * @return: int   
     * @throws
     */
    int updateByPrimaryKey(UserPriv record);   
    /**
     * @Title: getPrivNameById
     * @Description: TODO
     * @author(作者):      zlf
     * @param: @param userPriv
     * @param: @return   
     * @return: String   
     * @throws
     */
    String getPrivNameById(Integer userPriv);  
    /**
     * @Title: getAlluserPriv
     * @Description: TODO
     * @author(作者):      zlf
     * @param: @param maps
     * @param: @return   
     * @return: List<UserPriv>   
     * @throws
     */
    List<UserPriv> getAlluserPriv(Map<String,Object> maps); 
    /**
     * @Title: getPrivByMany
     * @Description: TODO
     * @author(作者):      zlf
     * @param: @param userPriv
     * @param: @return   
     * @return: List<UserPriv>   
     * @throws
     */
    List<UserPriv> getPrivByMany(UserPriv userPriv); 
}