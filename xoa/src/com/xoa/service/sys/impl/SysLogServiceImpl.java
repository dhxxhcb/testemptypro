package com.xoa.service.sys.impl;

import com.xoa.dao.sys.SysLogMapper;
import com.xoa.model.common.Syslog;
import com.xoa.service.common.SysCodeService;
import com.xoa.service.sys.SysLogService;
import com.xoa.service.users.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class SysLogServiceImpl implements SysLogService {


    @Resource
    private SysLogMapper sysLogMapper;

    @Resource
    private UsersService usersService;
    @Resource
    private SysCodeService sysCodeService;

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 9:59
     * @函数介绍: 查询日志概况
     * @参数说明: @param map
     * @return: void
     **/
    @Override
    public void getLogMessage(Map<String, Long> map) throws ParseException {


        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(date);
        String year = dateString.substring(0, 4);
        String yearmouth = dateString.substring(0, 7);
        String yearmouthday = dateString.concat(" 00:00:00");

        long totalDay = 0;
        List<Syslog> totalDayList = sysLogMapper.findTotalDay();
        if (totalDayList != null && totalDayList.size() == 1) {
            Syslog statSysLog = totalDayList.get(0);
            Date logStartTime = statSysLog.getTime();
            totalDay = getDay(logStartTime);
        }


        Long totalCount = sysLogMapper.findTotalCount();
        Long yearCount = sysLogMapper.findYearCount(year);
        Long mouthCount = sysLogMapper.findMouthCount("2017-04");
        Long dayCount = sysLogMapper.findDayCount(yearmouthday);
        Long averageDayCount = totalCount / totalDay;

        map.put("totalDay", totalDay);
        map.put("totalCount", totalCount);
        map.put("yearCount", yearCount);
        map.put("mouthCount", mouthCount);
        map.put("dayCount", dayCount);
        map.put("averageDayCount", averageDayCount);


    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 10:20
     * @函数介绍: 查询最近10条记录
     * @参数说明: 无
     * @return: List<Syslog></>
     **/
    @Override
    public List<Syslog> getTenLog() {
        List<Syslog> list = sysLogMapper.getTenLog();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                String username = usersService.getUserNameById(list.get(i).getUserId());
                list.get(i).setUserName(username);
                String typeName = sysCodeService.getLogNameByNo("" + list.get(i).getType());
                list.get(i).setTypeName(typeName);
            }
        }
        return list;

    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 12:45
     * @函数介绍: 统计每月日志记录
     * @参数说明: @param String year
     * @return: List<Object></OBject>
     **/
    @Override
    public List<Object> getEachMouthLogData(String year) {

        List<Object> yearDataList = new ArrayList<Object>();
        List<Integer> eachMonthCount = new ArrayList<Integer>();
        List<String> monthInYearCount = new ArrayList<String>();
        Integer thisYearTotalCount = 0;

        Integer monthCount = getMonth(year);
        if (year != null && year.trim().length() == 4) {
            for (int i = 1; i <= monthCount; i++) {
                Integer thisMonthCount;
                String monthTime;
                if (i < 9) {
                    monthTime = year + "-0" + i;
                } else {
                    monthTime = year + "-" + i;
                }
                thisMonthCount = sysLogMapper.getThisMonthCount(monthTime);
                thisYearTotalCount += thisMonthCount;
                eachMonthCount.add(thisMonthCount);
            }

        }

        for (int i = 0; i < monthCount; i++) {
            //求百分比
            Double percentage = (Double.valueOf(eachMonthCount.get(i)) / Double.valueOf(thisYearTotalCount)) * 100;

            String percentageStr = String.format("%.2f", percentage);
            String[] dataArr = percentageStr.split("\\.");
            String intStr = dataArr[0];
            String floatStr = dataArr[1].concat("%");
            percentageStr = intStr.concat(".").concat(floatStr);
            monthInYearCount.add(percentageStr);
        }

        yearDataList.add(eachMonthCount);
        yearDataList.add(monthInYearCount);
        return yearDataList;


    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/27 10:40
     * @函数介绍: 获取记录日志的年
     * @参数说明: void
     * @return: List<Stirng></Stirng>
     **/
    @Override
    public List<Integer> getYear() {

        //获取日志开始的时间
        List<Syslog> startLogTime = sysLogMapper.findTotalDay();
        ArrayList<Integer> startEndYearList = new ArrayList<Integer>();
        if (startLogTime != null && startLogTime.size() == 1) {
            Date startDate = startLogTime.get(0).getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String startDateStr = sdf.format(startDate);
            String startYear = startDateStr.substring(0, 4);
            Date thisDate = new Date();
            String thisDateStr = sdf.format(thisDate);
            String thisYear = thisDateStr.substring(0, 4);

            Integer startYearInt = Integer.parseInt(startYear);
            Integer endYearInt = Integer.parseInt(thisYear);

            if (startYearInt.equals(endYearInt)) {

                startEndYearList.add(startYearInt);
            } else {
                for (int i = startYearInt; i <= endYearInt; i++) {
                    startEndYearList.add(i);
                }
            }


            return startEndYearList;
        }


        return null;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/29 11:07
     * @函数介绍: 获取月份个数，如果查询的是今年，那么月份个数就是到这个月，不是12
     * @参数说明: @param String
     * @return: Integer 某年月份的个数，如果是今年，那么月份个数就是到这个月，不是12
     **/
    @Override
    public Integer getMonth(String year) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String thisYearStr = sdf.format(date);
        String thisyear = thisYearStr.substring(0, 4);

        //如果年份是今年，月份就返回当前月，否则返回12
        if (year != null && year.equals(thisyear)) {
            String thisMonthStr = thisYearStr.substring(5, 7);
            return Integer.parseInt(thisMonthStr);
        } else {
            return 12;
        }

    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 9:56
     * @函数介绍: 获取某月每天的日志信息
     * @参数说明: @param String year
     * @参数说明: @param String month
     * @return: List
     **/
    @Override
    public List<Object> getEachDayLogData(String year, String month) {

        //记录每天的信息
        List<Object> dayLogDataList = new ArrayList<Object>();
        //记录每天的访问量
        List<Integer> dayCountList = new ArrayList<Integer>();
        //记录每天占的百分比
        List<String> percentageList = new ArrayList<String>();

        int theYear = Integer.parseInt(year);
        int theMonth = Integer.parseInt(month);
        String dayTime = null;
        //本月每天的日志的累加
        int totalDayCount = 0;


        //判断是否是本月
        Map<String, String> map = isThisMonth(year, month);
        String isThisMonth = map.get("isThisMonth");

        int endDay = 0;
        //是否查询的是系统的当前月。
        boolean flag = false;
        if (isThisMonth != null) {
            endDay = Integer.parseInt(map.get("thisMonthdayCount"));
            flag = true;
        }


        //闰年，2月有29天
        if (theYear % 4 == 0 && theYear % 100 != 0 || theYear % 400 == 0) {
            //31天
            if (theMonth == 1 || theMonth == 3 || theMonth == 5 || theMonth == 7 || theMonth == 8 ||
                    theMonth == 10 || theMonth == 12) {
                int monthTotalDay = 31;
                if (flag) {
                    monthTotalDay = endDay;
                }
                for (int i = 1; i <= monthTotalDay; i++) {


                    if (i < 10) {
                        if (Integer.parseInt(month) < 10) {
                            dayTime = year + "-0" + month + "-0" + i;
                        } else {
                            dayTime = year + "-" + month + "-0" + i;
                        }


                    } else {
                        if (Integer.parseInt(month) < 10) {
                            dayTime = year + "-0" + month + "-" + i;
                        } else {
                            dayTime = year + "-" + month + "-" + i;
                        }
                    }
                    Integer theDayCount = sysLogMapper.getEachDayLogData(dayTime);
                    totalDayCount += theDayCount;
                    dayCountList.add(theDayCount);
                }


            } else if (theMonth == 2) {
                int monthTotalDay = 29;
                if (flag) {
                    monthTotalDay = endDay;
                }

                for (int i = 1; i <= endDay; i++) {

                    if (i < 10) {
                        if (Integer.parseInt(month) < 10) {
                            dayTime = year + "-0" + month + "-0" + i;
                        } else {
                            dayTime = year + "-" + month + "-0" + i;
                        }
                    } else {

                        if (Integer.parseInt(month) < 10) {
                            dayTime = year + "-0" + month + "-" + i;
                        } else {
                            dayTime = year + "-" + month + "-" + i;
                        }
                    }
                    Integer theDayCount = sysLogMapper.getEachDayLogData(dayTime);
                    totalDayCount += theDayCount;
                    dayCountList.add(theDayCount);
                    System.out.println(dayTime + "  2");

                }

                //30天的月
            } else {

                int monthTotalDay = 30;
                if (flag) {
                    monthTotalDay = endDay;
                }
                for (int i = 1; i <= endDay; i++) {

                    if (i < 10) {
                        if (Integer.parseInt(month) < 10) {

                            dayTime = year + "-0" + month + "-0" + i;
                        } else {
                            dayTime = year + "-" + month + "-0" + i;
                        }

                    } else {
                        if (Integer.parseInt(month) < 10) {

                            dayTime = year + "-0" + month + "-" + i;
                        } else {
                            dayTime = year + "-" + month + "-" + i;
                        }
                    }
                    Integer theDayCount = sysLogMapper.getEachDayLogData(dayTime);
                    totalDayCount += theDayCount;
                    dayCountList.add(theDayCount);
                }
            }

            //平年，2月有28天
        } else {

            //31天
            if (theMonth == 1 || theMonth == 3 || theMonth == 5 || theMonth == 7 || theMonth == 8 ||
                    theMonth == 10 || theMonth == 12) {
                int monthTotalDay = 31;
                if (flag) {
                    monthTotalDay = endDay;
                }
                for (int i = 1; i <= endDay; i++) {

                    if (i < 10) {
                        if (Integer.parseInt(month) < 10) {

                            dayTime = year + "-0" + month + "-0" + i;
                        } else {
                            dayTime = year + "-" + month + "-0" + i;
                        }
                    } else {
                        if (Integer.parseInt(month) < 10) {
                            dayTime = year + "-0" + month + "-" + i;
                        } else {
                            dayTime = year + "-" + month + "-" + i;
                        }
                    }
                    Integer theDayCount = sysLogMapper.getEachDayLogData(dayTime);
                    dayCountList.add(theDayCount);
                    totalDayCount += theDayCount;
                }
            } else if (theMonth == 2) {
                int monthTotalDay = 28;
                if (flag) {
                    monthTotalDay = endDay;
                }
                for (int i = 1; i <= monthTotalDay; i++) {

                    if (i < 10) {
                        if (Integer.parseInt(month) < 10) {

                            dayTime = year + "-0" + month + "-0" + i;
                        } else {
                            dayTime = year + "-" + month + "-0" + i;
                        }
                    } else {
                        if (Integer.parseInt(month) < 10) {

                            dayTime = year + "-0" + month + "-" + i;
                        } else {
                            dayTime = year + "-" + month + "-" + i;
                        }
                    }
                    Integer theDayCount = sysLogMapper.getEachDayLogData(dayTime);
                    dayCountList.add(theDayCount);
                    totalDayCount += theDayCount;
                }

                //30天的
            } else {
                int monthTotalDay = 30;
                if (flag) {
                    monthTotalDay = endDay;
                }
                for (int i = 1; i <= monthTotalDay; i++) {

                    if (i < 10) {
                        if (Integer.parseInt(month) < 10) {

                            dayTime = year + "-0" + month + "-0" + i;
                        } else {
                            dayTime = year + "-" + month + "-0" + i;
                        }
                    } else {
                        if (Integer.parseInt(month) < 10) {

                            dayTime = year + "-0" + month + "-" + i;
                        } else {
                            dayTime = year + "-" + month + "-" + i;
                        }
                    }
                    Integer theDayCount = sysLogMapper.getEachDayLogData(dayTime);
                    dayCountList.add(theDayCount);
                    totalDayCount += theDayCount;
                }
            }

        }

        for (int i = 0; i < dayCountList.size(); i++) {
            //double用科学计数法，所以不能随便转换double为字符串。
            //获取当前天所占百分比
            Double percentage = (Double.valueOf(dayCountList.get(i))) / (Double.valueOf(totalDayCount)) * 100;
            String percentageStr = String.format("%.3f", percentage);

            String[] splitArr = percentageStr.split("\\.");
            String intStr = splitArr[0];
            //避免百分比有效数字太短，后面截取索引越界
            String floatStr = (splitArr[1].concat("000000").substring(0, 2));

            String wholeStr = intStr.concat(".").concat(floatStr).concat("%");

    /*        percentageStr = percentageStr + "000000";//保留多位小数,否则字符串substring(0,4)会报错。
            percentageStr = percentageStr.substring(0, 5);*/

            percentageList.add(wholeStr);
        }

        dayLogDataList.add(dayCountList);
        dayLogDataList.add(percentageList);

        return dayLogDataList;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 9:55
     * @函数介绍: 获取日志时段信息
     * @参数说明: 无
     * @return: List<Object></Object>
     **/
    @Override
    public List<Object> getHourLog() {
        List<Object> hourDataList = new ArrayList<Object>();

        String hourTime = "";
        List<Integer> hourCountList = new ArrayList<Integer>();
        List<String> countpercentList = new ArrayList<String>();
        int totalCount = 0;

        for (int i = 0; i <= 23; i++) {

            if (i < 10) {
                hourTime = "0" + i;
            } else {
                hourTime = "" + i;
            }


            int theHourCount = sysLogMapper.getHourLog(hourTime);
            hourCountList.add(theHourCount);
            totalCount += theHourCount;

        }

        for (int i = 0; i <= 23; i++) {
            Double percentage = Double.valueOf(hourCountList.get(i)) / Double.valueOf((totalCount)) * 100;
            String percentageStr = String.format("%.2f", percentage);
            percentageStr = percentageStr.concat("%");
            countpercentList.add(percentageStr);
        }


        hourDataList.add(hourCountList);
        hourDataList.add(countpercentList);
        return hourDataList;
    }

    /**
     * @param type
     * @param uid       多个用户的id数组
     * @param startTime 日志开始时间
     * @param endTime   日志结束时间
     * @param syslog    属性中的ip,备注     @创建作者: 韩成冰
     * @创建日期: 2017/5/30 11:35
     * @函数介绍: 日志管理
     * @return: List<Syslog></Syslog>
     **/
    @Override
    public List<Syslog> logManage(Integer type, String uid, Date startTime, Date endTime, Syslog syslog) {
        String[] uidArr = null;

        if (uid != null && !"".equals(uid)) {
            uidArr = uid.split(",");
        }

        //查询
        List<Syslog> syslogList;

        Map<String, Object> hashMap = new HashMap<String, Object>();
        if (uidArr != null && uidArr.length > 0) {
            hashMap.put("ids", uidArr);
        }
        if (startTime != null) {

            hashMap.put("startTime", startTime);
        }
        if (endTime != null) {

            hashMap.put("endTime", endTime);
        }

        if (syslog != null && syslog.getIp() != null) {
            hashMap.put("ip", syslog.getIp());
        }
        if (syslog != null && syslog.getRemark() != null) {
            hashMap.put("remark", syslog.getRemark());
        }
        if (type != null) {
            hashMap.put("type", type);
        }


        syslogList = sysLogMapper.findLogOption(hashMap);
        if (syslogList != null) {
            for (Syslog syslog1 : syslogList) {
                String username = usersService.getUserNameById(syslog1.getUserId());
                syslog1.setUserName(username);
                String logTypeName = sysCodeService.getLogNameByNo("" + syslog1.getType());
                syslog1.setTypeName(logTypeName);
                syslog1.setIpLocation("--");
            }

        }


        return syslogList;

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
     * @return: 无
     */
    @Override
    public void deleteSyslog(Integer type, String uid, Date startTime, Date endTime, Syslog syslog) {

        String[] uidArr = null;
        if (uid != null && !"".equals(uid)) {
            uidArr = uid.split(",");
        }

        Map<String, Object> hashMap = new HashMap<String, Object>();
        if (uidArr != null && uidArr.length > 0) {
            hashMap.put("ids", uidArr);
        }
        if (startTime != null) {

            hashMap.put("startTime", startTime);
        }
        if (endTime != null) {

            hashMap.put("endTime", endTime);
        }
        if (syslog.getIp() != null) {
            hashMap.put("ip", syslog.getIp());
        }
        if (syslog.getRemark() != null) {
            hashMap.put("remark", syslog.getRemark());
        }
        if (type != null) {
            hashMap.put("type", type);
        }

        sysLogMapper.deleteLogOption(hashMap);

    }


    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/29 10:39
     * @函数介绍: 判断用户传入的时间是否是本月的某天，如果是就返回当前的日期所在天
     * @参数说明: @param String year
     * @参数说明: @param String month
     * @return: map<String, String></> map的两个key=isThisMonth， value = isThisMonth/null,
     * key = thisMonthdayCount value=null/1-31
     **/
    public Map<String, String> isThisMonth(String year, String month) {

        if (month != null && month.trim().length() == 1) {
            month = "0" + month;
        }

        Map<String, String> map = new HashMap<String, String>();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String thisDay = sdf.format(date);
        String thisMonth = sdf.format(date).substring(0, 6);
        if (year != null && month != null) {
            if (year.concat(month).equals(thisMonth)) {
                map.put("isThisMonth", "yes");
                int dayCount = Integer.parseInt(thisDay.substring(6, 8));
                map.put("thisMonthdayCount", "" + dayCount);
            }
        }
        return map;

    }


    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 20:32
     * @函数介绍: 计算两个时间之间的天数，比如处理2017-5-27:22:22:22 到2017-5-28:22:22:22之间是2天。
     * @参数说明: @param startDay 日志开始的时间
     * @return: int
     **/
    public int getDay(Date startDay) throws ParseException {

        int totalDay = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDayStr = sdf.format(startDay);
        String[] startDateArr = startDayStr.split(" ");
        String day = startDateArr[0];
        day = day.concat(" 00:00:00");

        Date startDate = sdf.parse(day);
        long startSeconds = startDate.getTime();

        Date date = new Date();
        String endTodayStr = sdf.format(date);
        String[] todayDateArr = endTodayStr.split(" ");

        endTodayStr = todayDateArr[0].concat(" 23:59:59");
        long endSeconds = sdf.parse(endTodayStr).getTime();


        if ((endSeconds - startSeconds) % (24 * 60 * 60 * 1000) == 0) {
            totalDay = (int) ((endSeconds - startSeconds) / (24 * 60 * 60 * 1000));
        } else {
            totalDay = (int) ((endSeconds - startSeconds) / (24 * 60 * 60 * 1000)) + 1;

        }
        return totalDay;
    }
}
