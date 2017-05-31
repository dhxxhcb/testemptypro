package com.xoa.controller.sys;


import com.xoa.model.common.SysCode;
import com.xoa.model.common.Syslog;
import com.xoa.service.common.SysCodeService;
import com.xoa.service.sys.SysLogService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @创建作者: 韩成冰
 * @创建日期: 2017/5/25 20:15
 * @类介绍: 系统日志
 * @构造参数: 无
 **/

@Service
@RequestMapping("/sys")
public class SysLogController {
    @Resource
    private SysLogService sysLogService;
    @Resource
    private SysCodeService sysCodeService;


    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 9:58
     * @函数介绍: 查询日志概况
     * @参数说明: @param request
     * @return: Json
     **/
    @ResponseBody
    @RequestMapping(value = "/getLogMessage")
    public ToJson<Map> getLogMessage(HttpServletRequest request) {
  /*      ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));*/
        ToJson<Map> tojson = new ToJson<Map>(0, "");
        HashMap<String, Long> logMap = new HashMap<String, Long>();

        try {
            sysLogService.getLogMessage(logMap);
            if (logMap.size() == 6) {
                tojson.setMsg("ok");
                tojson.setFlag(0);
                tojson.setObject(logMap);
            }
        } catch (Exception e) {
            tojson.setMsg(e.getMessage());
        }

        return tojson;

    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 10:09
     * @函数介绍: 查询最近的10条日志
     * @参数说明: @param request HttpServletRequest
     * @return: json
     **/
    @ResponseBody
    @RequestMapping(value = "/getTenLog")
    public ToJson<Syslog> getTenLog(HttpServletRequest request) {
 /*       ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));*/
        ToJson<Syslog> tojson = new ToJson<Syslog>(0, "");
        try {

            List<Syslog> list = sysLogService.getTenLog();
            tojson.setObject(list);
            tojson.setMsg("ok");
            tojson.setFlag(0);
        } catch (Exception e) {
            tojson.setMsg(e.getMessage());
        }
        return tojson;
    }


    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 12:45
     * @函数介绍: 统计每月/每天日志记录
     * @参数说明: @param String year
     * @参数说明: @param String month
     * @return: json
     **/
    @ResponseBody
    @RequestMapping("/getEachMouthLogData")
    public ToJson<Object> getEachMouthLogData(String year, String month, HttpServletRequest request) {
       /* ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));*/
        ToJson<Object> tojson = new ToJson<Object>(0, "");
        ArrayList<Object> monthDayData = new ArrayList<Object>();
        try {
            List<Object> monthDataList = sysLogService.getEachMouthLogData(year);
            List<Object> dayDataList = sysLogService.getEachDayLogData(year, month);

            monthDayData.add(monthDataList);
            monthDayData.add(dayDataList);

            tojson.setObj(monthDataList);
            tojson.setMsg("OK");
            tojson.setFlag(0);
        } catch (ClassCastException e) {
            tojson.setMsg(e.getMessage());
        }
        return tojson;

    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 10:40
     * @函数介绍: 获取记录日志的年（前端要判断是否开始结束都是一年）
     * @参数说明: @param HttpServletRequest
     * @return: json
     **/
    @ResponseBody
    @RequestMapping("/getYear")
    public ToJson<Integer> getYear(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));

        ToJson<Integer> tojson = new ToJson<Integer>(0, "");
        try {
            List<Integer> yearList = sysLogService.getYear();
            if (yearList != null && yearList.size() == 2) {
                tojson.setObj(yearList);
                tojson.setMsg("ok");
                tojson.setFlag(0);
            }
        } catch (Exception e) {
            tojson.setMsg(e.getMessage());
        }

        return tojson;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 11:03
     * @函数介绍: 获取月份
     * @参数说明: @param HttpServletRequest String
     * @return: json
     **/
    @ResponseBody
    @RequestMapping(value = "/getMonth", produces = {"application/json;charset=UTF-8"})
    public ToJson<Integer> getMonth(HttpServletRequest request, String year) {
    /*    ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));*/
        ToJson<Integer> toJson = new ToJson<Integer>(0, "");
        try {
            Integer endMonth = sysLogService.getMonth(year);
            toJson.setMsg("OK");
            toJson.setFlag(0);
            toJson.setObject(endMonth);
        } catch (Exception e) {
            toJson.setMsg(e.getMessage());
        }
        return toJson;
    }

    @ResponseBody
    @RequestMapping(value = "/getHourLog")
    public ToJson<Object> getHourLog(HttpServletRequest request) {
    /*    ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));*/
        List<Object> hourDataList = new ArrayList<Object>();

        ToJson<Object> toJson = new ToJson<Object>(0, "");
        try {
            hourDataList = sysLogService.getHourLog();
            toJson.setMsg("OK");
            toJson.setFlag(0);
            toJson.setObj(hourDataList);
        } catch (Exception e) {
            toJson.setMsg(e.getMessage());
        }
        return toJson;

    }

    @ResponseBody
    @RequestMapping("/getLogType")
    public ToJson<SysCode> getLogType(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<SysCode> toJson = new ToJson<SysCode>(0, "");

        try {
            List<SysCode> logTypeList = sysCodeService.getLogType();
            toJson.setMsg("OK");
            toJson.setFlag(0);
            toJson.setObj(logTypeList);
        } catch (Exception e) {
            toJson.setMsg(e.getMessage());
        }
        return toJson;

    }

    @ResponseBody
    @RequestMapping(value = "/logManage")
    public ToJson<Syslog> logManage(HttpServletRequest request, String optionType,Integer type, String[] uid, Date startTime, Date endTime, Syslog syslog) {
 /*       ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));*/

       List<Syslog> syslogList = sysLogService.logManage(optionType,type, uid, startTime, endTime, syslog);

        return null;
    }
}
