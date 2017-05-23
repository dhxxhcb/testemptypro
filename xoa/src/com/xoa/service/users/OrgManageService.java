package com.xoa.service.users;

import com.xoa.model.users.OrgManage;
import com.xoa.util.ToJson;

import java.util.List;

public interface OrgManageService {
	
	public ToJson<OrgManage> queryId();

    /**
     *创建作者:  韩成冰
     *创建日期:  2017/5/22 14:14
     *函数介绍:  获取所有OrgManage
     *参数说明:  无
     *@return:   List<OrgManage>(OrgManage 的List集合)
     **/
    List<OrgManage> getOrgManage();

    /**
     *创建作者:  韩成冰
     *创建日期:  2017/5/22 14:15
     *函数介绍:  根据oid查询某个OrgManage
     *参数说明:  @param oid OrgManage的oid
     *@return:   OrgManage
     **/
    OrgManage getOrgManageById(Integer oid);

    /**
     *创建作者:  韩成冰
     *创建日期:  2017/5/22 14:17
     *函数介绍:  修改某个OrgManage
     *参数说明:  @param OrgManage对象
     *@return:   void
     **/
    void editOrgManage(OrgManage orgManage);

}
