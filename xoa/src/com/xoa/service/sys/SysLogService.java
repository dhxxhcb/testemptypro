package com.xoa.service.sys;

import com.xoa.model.common.Syslog;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @创建作者: 韩成冰
 * @创建日期: 2017/5/25 20:15
 * @类介绍: 系统日志
 * @构造参数: 无
 **/
public interface SysLogService {
    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 9:59
     * @函数介绍: 查询日志概况
     * @参数说明: @param map
     * @return: void
     **/
    void getLogMessage(Map<String, Long> map) throws ParseException;

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 10:20
     * @函数介绍: 查询最近10条记录
     * @参数说明: 无
     * @return: List<Syslog></>
     **/
    List<Syslog> getTenLog();

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 12:45
     * @函数介绍: 统计每月日志记录
     * @参数说明: @param String year
     * @return: List<Object></OBject>
     **/
    List<Object> getEachMouthLogData(String year);

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 10:40
     * @函数介绍: 获取记录日志的年
     * @参数说明: @param void
     * @return: List<String></String>
     **/
    List<Integer> getYear();

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 11:14
     * @函数介绍: 获取月份，如果是今年就是到本月月份值，如果是去年（以前）就是12
     * @参数说明: @param year 年份
     * @return: Integer
     **/
    Integer getMonth(String year);

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 9:56
     * @函数介绍: 获取某月每天的日志信息
     * @参数说明: @param String year
     * @参数说明: @param String month
     * @return: List
     **/
    List<Object> getEachDayLogData(String year, String month);

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 9:55
     * @函数介绍: 获取日志时段信息
     * @参数说明: 无
     * @return: List<Object></Object>
     **/
    List<Object> getHourLog();


    /**
     * @param type
     * @param uid       多个用户的id数组
     * @param startTime 日志开始时间
     * @param endTime   日志结束时间
     * @param syslog    属性中的ip,备注
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/30 11:35
     * @函数介绍: 日志管理
     * @return: List<Syslog></Syslog>
     **/

    List<Syslog> logManage(Integer type, String[] uid, Date startTime, Date endTime, Syslog syslog);

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 10:36
     * @函数介绍: 删除日志
     * param type      日志类型id
     * param uid       多个用户的id数组
     * param startTime 日志开始时间
     * param endTime   日志结束时间
     * param syslog    属性中的ip,备注
     * param request
     * @return: 无
     **/
    void deleteSyslog(Integer type, String[] uid, Date startTime, Date endTime, Syslog syslog);



}
