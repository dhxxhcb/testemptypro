package com.xoa.dao.user;

import com.xoa.model.user.User;
import com.xoa.model.user.UserWithBLOBs;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(User record);
}