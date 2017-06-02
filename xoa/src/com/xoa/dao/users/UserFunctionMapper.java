package com.xoa.dao.users;

import com.xoa.model.users.UserFunction;

import java.util.List;
import java.util.Map;

public interface UserFunctionMapper {
	
	public List<UserFunction> getDatagrid();
	
	public UserFunction  getMenuByUserId(int uid);

    List<UserFunction> getUserByFuncId(String fid);

    String getUserFuncIdStr(String userId);

    void updateUserFuncIdStr(Map<String, String> hashMap);
}
