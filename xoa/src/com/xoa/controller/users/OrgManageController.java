package com.xoa.controller.users;

import com.xoa.model.users.OrgManage;
import com.xoa.service.users.OrgManageService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @创建作者: 韩成冰
 * @创建日期: 2017/5/22 10:39
 * @类介绍: 多企业管理
 * @构造参数: 无
 **/
@Controller
@Scope(value = "prototype")
@RequestMapping("/users")
public class OrgManageController {

    @Resource
    private OrgManageService orgManageService;

    /**
     * 创建作者: 韩成冰
     * 创建日期: 2017/5/22 11:49
     * 函数介绍: 查询所有的（OrgManage）信息
     * 参数说明:
     *
     * @return: String
     **/
    @ResponseBody
    @RequestMapping(value = "/getOrgManage", produces = {"application/json;charset=UTF-8"})
    public ToJson<OrgManage> getOrgManage(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<OrgManage> toJson = new ToJson<OrgManage>(0, "");
        List<OrgManage> orgManageList = orgManageService.getOrgManage();
        if (orgManageList != null) {
            toJson.setMsg("ok");
            toJson.setObject(orgManageList);
        } else {
            toJson.setMsg("err");
        }
        return toJson;
    }

    /**
     * 创建作者: 韩成冰
     * 创建日期: 2017/5/22 13:34
     * 函数介绍: 修改OrgManage
     * 参数说明: @param orgManage 修改为orgManage对象
     *
     * @return: String(页面跳转)
     **/
    @ResponseBody
    @RequestMapping(value = "/editOrgManage", produces = {"application/json;charset=UTF-8"})
    public ToJson<OrgManage> editOrgManage(OrgManage orgManage, HttpServletRequest request) throws UnsupportedEncodingException {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        if (orgManage != null && orgManage.getOid() != null) {

            //解决编码问题
            if(orgManage.getName() != null){
                orgManage.setName(new String(orgManage.getName().getBytes("iso8859-1"), "utf-8"));
            }
            if(orgManage.getIsOrg() != null){
                orgManage.setIsOrg(new String(orgManage.getIsOrg().getBytes("iso8859-1"), "utf-8"));
            }
            if(orgManage.getVersion() != null){
                orgManage.setVersion(new String (orgManage.getVersion().getBytes("iso8859-1"), "utf-8"));
            }

            orgManageService.editOrgManage(orgManage);
        }

        ToJson<OrgManage> toJson = new ToJson<OrgManage>(0, "");
        List<OrgManage> orgManageList = orgManageService.getOrgManage();
        if (orgManageList != null) {
            toJson.setMsg("ok");
            toJson.setObject(orgManageList);
        } else {
            toJson.setMsg("err");
        }
        return toJson;

    }

    /**
     * 创建作者: 韩成冰
     * 创建日期: 2017/5/22 11:51
     * 函数介绍: 根据oid查询公司, 返回json到页面
     * 参数说明: @param oid OrderManage的id
     *
     * @return: Json (返回Orgmanage的json对象)
     **/
    @ResponseBody
    @RequestMapping(value = "/getOrgManageById", produces = {"application/json;charset=UTF-8"})
    public ToJson<OrgManage> getOrgManageById(Integer oid, HttpServletRequest request) throws IOException {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));

        ToJson<OrgManage> toJson = new ToJson<OrgManage>(0, "");
        OrgManage orgManage = null;
        if (oid != null) {
            orgManage = orgManageService.getOrgManageById(oid);
        }
        if (orgManage != null) {
            toJson.setMsg("ok");
            toJson.setObject(orgManage);
        } else {
            toJson.setMsg("err");
        }

        return toJson;
    }

}
