package com.xoa.dao.users;

import com.xoa.model.users.UserPriv;

public interface UserPrivMapper {
    int deleteByPrimaryKey(Integer userPriv);

    int insert(UserPriv record);

    int insertSelective(UserPriv record);

    UserPriv selectByPrimaryKey(Integer userPriv);

    int updateByPrimaryKeySelective(UserPriv record);

    int updateByPrimaryKey(UserPriv record);
    
    String getPrivNameById(Integer userPriv);
}