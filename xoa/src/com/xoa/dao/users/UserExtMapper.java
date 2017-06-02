package com.xoa.dao.users;


import java.util.Map;

public interface UserExtMapper {

    String getUserFuncIdStr(String userId);

    void updateUserFuncIdStr(Map<String, String> hashMap);
}