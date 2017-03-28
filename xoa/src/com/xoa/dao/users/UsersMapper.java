package com.xoa.dao.users;

import org.apache.ibatis.annotations.Param;

import com.xoa.model.users.Users;

public interface UsersMapper {
	
    public Users getRegister(@Param("byname") String byname);
}
