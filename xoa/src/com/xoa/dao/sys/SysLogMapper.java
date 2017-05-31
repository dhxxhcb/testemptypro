package com.xoa.dao.sys;

import com.xoa.model.common.Syslog;

import java.util.List;
import java.util.Map;


public interface SysLogMapper {
    List<Syslog> findTotalDay();

    Long findTotalCount();

    Long findYearCount(String year);

    Long findMouthCount(String yearmouth);

    Long findDayCount(String yearmouthday);

    List<Syslog> getTenLog();

    Integer getThisMonthCount(String monthTime);

    Integer getEachDayLogData(String dayTime);

    int getHourLog(String hourTime);

    List<Syslog> findLogOption(Map<String, Object> hashMap);

    void deleteLogOption(Map<String, Object> hashMap);

    String getLogNameByNo(String codeNo);
}
