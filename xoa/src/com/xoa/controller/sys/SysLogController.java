package com.xoa.controller.sys;


import com.xoa.model.common.SysCode;
import com.xoa.model.common.Syslog;
import com.xoa.service.common.SysCodeService;
import com.xoa.service.sys.SysLogService;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;
import com.xoa.util.common.log.FileUtils;
import com.xoa.util.dataSource.ContextHolder;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Resource
    private UsersService userService;

    /**
     * @创建作者: 王曰岂
     * @创建日期: 2017/5/31 14:57
     * @函数介绍: 无
     * @参数说明: @param paramname paramintroduce
     * @return: XXType(value introduce)
     **/
    @RequestMapping("/journal")
    public String journal(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa"
                + (String) request.getSession().getAttribute("loginDateSouse"));
        return "app/sys/journal";
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 9:58
     * @函数介绍: 查询日志概况
     * @参数说明: @param request
     * @return: Json
     **/
    @ResponseBody
    @RequestMapping(value = "/getLogMessage", produces = {"application/json;charset=UTF-8"})
    public ToJson<Map> getLogMessage(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
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
    @RequestMapping(value = "/getTenLog", produces = {"application/json;charset=UTF-8"})
    public ToJson<Syslog> getTenLog(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
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
    @RequestMapping(value = "/getEachMouthLogData", produces = {"application/json;charset=UTF-8"})
    public ToJson<Object> getEachMouthLogData(String year, String month, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<Object> tojson = new ToJson<Object>(0, "");
        //ArrayList<Object> monthDayData = new ArrayList<Object>();

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Object> monthDataList = sysLogService.getEachMouthLogData(year);
            List<Object> dayDataList = sysLogService.getEachDayLogData(year, month);
            map.put("monthData", monthDataList);
            map.put("dayData", dayDataList);
           /* monthDayData.add(monthDataList);
            monthDayData.add(dayDataList);*/

            tojson.setObject(map);
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
    @RequestMapping(value = "/getYear", produces = {"application/json;charset=UTF-8"})
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
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
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

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 9:47
     * @函数介绍: 时段统计
     * @参数说明: @param HttpServletRequest
     * @return: json
     **/
    @ResponseBody
    @RequestMapping(value = "/getHourLog", produces = {"application/json;charset=UTF-8"})
    public ToJson<Object> getHourLog(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
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

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 9:48
     * @函数介绍: 获取日志所有类型
     * @参数说明: @param HttpServletRequest
     * @return: json
     **/
    @ResponseBody
    @RequestMapping(value = "/getLogType", produces = {"application/json;charset=UTF-8"})
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

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 9:49
     * @函数介绍: 日志管理
     * param type      日志类型id
     * param uid       多个用户的id数组
     * param startTime 日志开始时间
     * param endTime   日志结束时间
     * param syslog    属性中的ip,备注
     * param request
     * return: json
     **/
    @ResponseBody
    @RequestMapping(value = "/logManage", produces = {"application/json;charset=UTF-8"})
    public ToJson<Syslog> findLogManage(HttpServletRequest request,
                                        @RequestParam(value = "type", required = false) Integer type,
                                        @RequestParam(value = "uid", required = false) String uid,
                                        @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") @RequestParam(value = "startTime", required = false) Date startTime,
                                        @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") @RequestParam(value = "endTime", required = false) Date endTime,
                                        @RequestParam(value = "syslog", required = false) Syslog syslog) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));

        ToJson<Syslog> toJson = new ToJson<Syslog>(0, "");
        //查询成功
        List<Syslog> syslogList;
        try {
            syslogList = sysLogService.logManage(type, uid, startTime, endTime, syslog);
            List<Syslog> syslogList1 = new ArrayList<Syslog>();
            if (syslogList.size() > 300) {
                for (int i = 0; i < 300; i++) {
                    syslogList1.add(syslogList.get(i));
                }
                toJson.setObj(syslogList1);

            } else {
                toJson.setObj(syslogList);
            }
            toJson.setMsg("OK");
            toJson.setFlag(0);

        } catch (Exception e) {
            toJson.setMsg(e.getMessage());
        }
        return toJson;
    }

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
     * @return: json
     **/
    @ResponseBody
    @RequestMapping(value = "/deleteSyslog", produces = {"application/json;charset=UTF-8"})
    public ToJson<Syslog> deleteSyslog(HttpServletRequest request,
                                       @RequestParam(value = "type", required = false) Integer type,
                                       @RequestParam(value = "uid", required = false) String uid,
                                       @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") @RequestParam(value = "startTime", required = false) Date startTime,
                                       @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") @RequestParam(value = "endTime", required = false) Date endTime,
                                       @RequestParam(value = "syslog", required = false) Syslog syslog) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));

        ToJson<Syslog> toJson = new ToJson<Syslog>(0, "");

        try {
            sysLogService.deleteSyslog(type, uid, startTime, endTime, syslog);
            toJson.setMsg("OK");
            toJson.setFlag(0);
        } catch (Exception e) {
            toJson.setMsg(e.getMessage());
        }
        return toJson;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 10:36
     * @函数介绍: 导出日志
     * param type      日志类型id
     * param uid       多个用户的id数组
     * param startTime 日志开始时间
     * param endTime   日志结束时间
     * param syslog    属性中的ip,备注
     * param request
     * @return: json
     **/
    @ResponseBody
    @RequestMapping(value = "/exportLogXls", produces = {"application/json;charset=UTF-8"})
    public String exportLogXls(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam(value = "type", required = false) Integer type,
                               @RequestParam(value = "uid", required = false) String uid,
                               @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") @RequestParam(value = "startTime", required = false) Date startTime,
                               @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") @RequestParam(value = "endTime", required = false) Date endTime,
                               @RequestParam(value = "syslog", required = false) Syslog syslog) throws IOException, ParseException {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));

/*        syslog = new Syslog();
        syslog.setIp("192.168.0.204");
        syslog.setRemark("");
        String uid = "admin,asdkafjdfasfsd";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:SS");
        startTime = sdf.parse("2017-02-02 00:00:00");
        endTime = sdf.parse("2017-05-30 00:00:00");*/


        // 查询所有的分区数据
        List<Syslog> syslogList = sysLogService.logManage(type, uid, startTime, endTime, syslog);
        // 将list集合中的数据写到一个Excel文件中
        HSSFWorkbook workbook = new HSSFWorkbook();// 创建一个Excel文件，当前这个文件在内存中
        HSSFSheet sheet = workbook.createSheet("日志数据");// 创建一个sheet页
        HSSFRow headRow = sheet.createRow(0);// 创建标题行
        headRow.createCell(0).setCellValue("用户姓名");
        headRow.createCell(1).setCellValue("时间");
        headRow.createCell(2).setCellValue("IP地址");
        headRow.createCell(3).setCellValue("ip所在地");
        headRow.createCell(4).setCellValue("日志类型");
        headRow.createCell(5).setCellValue("备注");

        for (Syslog log : syslogList) {// 循环list，将数据写到Excel文件中
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);

            //根据用户的id找的用户的name，每条数据都要查询一次，
            // 以后可以把user的id和name匹配到一个map，每次遍历匹配，来优化
            String userName = userService.getUserNameById(log.getUserId());
            dataRow.createCell(0).setCellValue(userName);

            SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
            String timeString = sdfTime.format(log.getTime());

            dataRow.createCell(1).setCellValue(timeString);
            dataRow.createCell(2).setCellValue(log.getIp());
            dataRow.createCell(3).setCellValue("");
            dataRow.createCell(4).setCellValue(log.getTypeName());
            dataRow.createCell(5).setCellValue(log.getRemark());

        }

        // 文件下载：一个流（输出流）、两个头
        ServletOutputStream out = response.getOutputStream();

        String filename = "系统日志.xls";
        filename = FileUtils.encodeDownloadFilename(filename,
                request.getHeader("user-agent"));
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-disposition",
                "attachment;filename=" + filename);
        workbook.write(out);

        return null;

    }


    /**
    *@创建作者:  韩成冰
    *@创建日期:  2017/6/1 19:23
    *@函数介绍:  根据多个id,(id之间用逗号分隔,删除日志)
    *@参数说明:  @param ids
    *@return:   json
    **/
    @ResponseBody
    @RequestMapping(value = "/deleteLogByIds")
    public ToJson<Object> deleteLogByIds(HttpServletRequest request, String[] ids) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));

        ToJson<Object> toJson = new ToJson<Object>(0, "");

        try {
            sysLogService.deleteLogByIds(ids);
            toJson.setMsg("OK");
            toJson.setFlag(0);
        } catch (Exception e) {
            toJson.setMsg(e.getMessage());
        }
        return toJson;

    }
}



