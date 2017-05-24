package com.xoa.dao.users;

import com.xoa.model.users.OrgManage;

import java.util.List;

public interface OrgManageMapper {
    public List<OrgManage> queryId();


    void editOrgManage(OrgManage orgManage);


    List<OrgManage> getOrgManage();


    OrgManage getOrgManageById(Integer oid);

    void addOrgManage(OrgManage orgManage);
}