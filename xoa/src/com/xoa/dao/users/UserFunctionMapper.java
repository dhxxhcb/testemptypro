package com.xoa.dao.users;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xoa.model.menu.SysFunction;
import com.xoa.model.users.UserFunction;

public interface UserFunctionMapper {
	
	public List<UserFunction> getDatagrid();
	
	public List<SysFunction>  getMenuByUserId(@Param("uid") int uid);

}
