package com.xoa.dao.users;

import org.apache.ibatis.annotations.Param;

import com.xoa.model.users.OrgManage;

public interface OrgManageMapper {
      public OrgManage queryId(@Param("oid")Integer oid);
}