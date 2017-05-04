package com.xoa.dao.schedule;

import java.util.List;
import java.util.Map;

import com.xoa.model.schedule.Calendar;

public interface CalendarMapper {
    int insert(Calendar record);

    int insertSelective(Calendar record);
    
    List<Calendar> getschedule(Map<String, Object> maps);
    
    List<Calendar> getscheduleBycId(String userId);
}