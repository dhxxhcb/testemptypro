package com.xoa.dao.users;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xoa.model.users.OrgManage;

public interface OrgManageMapper {
      public List<OrgManage> queryId();
      
      
      void editOrgManage(OrgManage orgManage);
}