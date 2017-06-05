package com.xoa.controller.common;

import com.xoa.model.common.SysCode;
import com.xoa.service.common.SysCodeService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 创建作者:   王曰岐
 * 创建日期:   2017-5-2 下午4:59:25
 * 类介绍  :    系统代码表控制器
 * 构造参数:
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/code")

public class SysCodeController {
    private Logger loger = Logger.getLogger(SysCodeController.class);

    @Resource
    private SysCodeService sysCodeService;//系统代码Service

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-2 下午4:59:42
     * 方法介绍:   得到系统类型信息
     * 参数说明:   @param parentNo
     * 参数说明:   @return
     *
     * @return ToJson<SysCode>
     */
    @RequestMapping("/getCode")
    public
    @ResponseBody
    ToJson<SysCode> getCode(String parentNo, HttpServletRequest request, HttpServletResponse response) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return sysCodeService.getSysCode(parentNo);
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月4日 上午9:28:13
     * 方法介绍:   获取所有代码主分类
     * 参数说明:   @param request	请求
     * 参数说明:   @return
     *
     * @return ToJson<SysCode> 返回代码主分类
     */
    @ResponseBody
    @RequestMapping(value = "/syscode/getAllSysCode", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ToJson<SysCode> getAllSysCode(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<SysCode> json = new ToJson<SysCode>(0, null);
        try {
            List<SysCode> list = sysCodeService.getAllSysCode();
            json.setObj(list);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月4日 上午10:12:05
     * 方法介绍:   修改系统代码设置表主分类
     * 参数说明:   @param request 请求
     * 参数说明:   @param sysCode 系统代码设置表主分类
     * 参数说明:   @return
     *
     * @return ToJson<SysCode> 系统代码设置表主分类
     */
    @ResponseBody
    @RequestMapping(value = "/syscode/update", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ToJson<SysCode> update(HttpServletRequest request, SysCode sysCode) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<SysCode> json = new ToJson<SysCode>(0, null);
        try {
            sysCodeService.update(sysCode);
            json = sysCodeService.getSysCode(sysCode.getParentNo());
            json.setObject(sysCode);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * 创建作者:  韩成冰
     * 创建日期:  2017/6/3 13:22
     * 函数介绍:   删除日志
     * 参数说明:   @param request 请求
     * 参数说明:   @param Syscode 请求
     *
     * @return: json
     **/
    @ResponseBody
    @RequestMapping("/deleteSysCode")
    public ToJson<SysCode> deleteSysCode(HttpServletRequest request, SysCode sysCode) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<SysCode> json = new ToJson<SysCode>(0, null);
        try {
            sysCodeService.deleteSysCode(sysCode);
            json = sysCodeService.getSysCode(sysCode.getParentNo());
            json.setObject(sysCode);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;

    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/3 13:38
     * @函数介绍: 增加代码主分类
     * @参数说明: @param paramname paramintroduce
     * @return: XXType(value introduce)
     **/
    @ResponseBody
    @RequestMapping(value = "/addSysMainCode", produces = {"application/json;charset=UTF-8"})
    public ToJson<SysCode> addSysMainCode(HttpServletRequest request, SysCode sysCode) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<SysCode> json = new ToJson<SysCode>(0, null);
        try {
            sysCodeService.addSysMainCode(sysCode);
            json.setObject(sysCode);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/3 14:11
     * @函数介绍: 判断系统代码排序是否存在
     * @参数说明: @param paramname paramintroduce
     * @return: json
     **/
    @ResponseBody
    @RequestMapping(value = "isCodeOrderExits", produces = {"application/json;charset=UTF-8"})
    public ToJson<Object> isCodeOrderExits(HttpServletRequest request, SysCode sysCode) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Object> json = new ToJson<Object>(0, null);
        try {
            Boolean isExits = sysCodeService.isCodeOrderExits(sysCode);
            json.setMsg("OK");
            if (isExits) {
                json.setFlag(0);
            } else {
                json.setFlag(1);
            }
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/3 14:11
     * @函数介绍: 判断系统代码CODE_NO是否存在
     * @参数说明: @param paramname paramintroduce
     * @return: json
     **/
    @ResponseBody
    @RequestMapping(value = "/isCodeNoExits", produces = {"application/json;charset=UTF-8"})
    public ToJson<Object> isCodeNoExits(HttpServletRequest request, SysCode sysCode) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Object> json = new ToJson<Object>(0, null);
        try {
            Boolean isExits = sysCodeService.isCodeNoExits(sysCode);
            json.setMsg("OK");
            if (isExits) {
                json.setFlag(0);
            } else {
                json.setFlag(1);
            }
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }


    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/3 14:34
     * @函数介绍: 添加子代码
     * @参数说明: @param SysCode
     * @return: json
     **/
    @ResponseBody
    @RequestMapping(value = "addChildSysCode", produces = {"application/json;charset=UTF-8"})
    public ToJson<SysCode> addChildSysCode(HttpServletRequest request, SysCode sysCode) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<SysCode> json = new ToJson<SysCode>(0, null);
        try {
            sysCodeService.addChildSysCode(sysCode);
            List<SysCode> sysCodeList = sysCodeService.getChildSysCode(sysCode);
            json.setObject(sysCode);
            json.setMsg("OK");
            json.setFlag(0);
        } catch (Exception e) {
            json.setMsg(e.getMessage());
        }
        return json;
    }

}
