package com.xoa.service.users.impl;

import com.xoa.dao.users.OrgManageMapper;
import com.xoa.model.users.OrgManage;
import com.xoa.service.users.OrgManageService;
import com.xoa.util.ToJson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
/**
 * 创建作者: 韩成冰
 * 创建日期: 2017/5/22 14:12
 * 类介绍: 对Orgmanage操作
 * 构造参数: 无
 **/
@Transactional
@Service
public class OrgManageServiceImpl implements OrgManageService {

    @Resource
    private OrgManageMapper orgManageMapper;
    @Override
    public ToJson<OrgManage> queryId() {
        ToJson<OrgManage>  toJson=new ToJson<OrgManage>(0, "");
        List<OrgManage> org=orgManageMapper.queryId();
        if (org!=null) {
            toJson.setMsg("ok");
            toJson.setObject(org);
        }else {
            toJson.setMsg("err");
        }

        return toJson;
    }




    /**
     *创建作者:  韩成冰
     *创建日期:  2017/5/22 14:14
     *函数介绍:  获取所有OrgManage
     *参数说明:  无
     *@return:   List<OrgManage>(OrgManage 的List集合)
     **/
    @Override
    public List<OrgManage> getOrgManage() {

        List<OrgManage> orgManageList = orgManageMapper.getOrgManage();
        return orgManageList;
    }
    /**
     *创建作者:  韩成冰
     *创建日期:  2017/5/22 14:15
     *函数介绍:  根据oid查询某个OrgManage
     *参数说明:  @param
     *@return:   OrgManage
     **/
    @Override
    public OrgManage getOrgManageById(Integer oid) {

        return orgManageMapper.getOrgManageById(oid);
    }

    /**
     *创建作者:  韩成冰
     *创建日期:  2017/5/22 14:17
     *函数介绍:  修改某个OrgManage
     *参数说明:  @param OrgManage对象
     *@return:   void
     **/
    @Override
    public void editOrgManage(OrgManage orgManage) {

        orgManageMapper.editOrgManage(orgManage);
    }

}
