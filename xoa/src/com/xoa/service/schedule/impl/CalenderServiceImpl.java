package com.xoa.service.schedule.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.schedule.CalendarMapper;
import com.xoa.model.schedule.Calendar;
import com.xoa.service.schedule.CalenderService;
@Service
public class CalenderServiceImpl implements CalenderService {
	@Resource
	private CalendarMapper calendarMapper;
	@Override
	public List<Calendar> getschedule(int calTime,int endTime) {
		Map<String, Object> maps =new HashMap<String, Object>();
		maps.put("calTime", calTime);
		maps.put("endTime", endTime);
		List<Calendar> list= calendarMapper.getschedule(maps);
		return list;
	}
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月4日 下午5:24:26
	 * 方法介绍:   根据userId 查询日程安排
	 * 参数说明:   @param userId 用户userId
	 * 参数说明:   @return
	 * @return     List<Calendar>  返回日程安排
	 */
	@Override
	public List<Calendar> getscheduleBycId(String userId) {
		List<Calendar> list =calendarMapper.getscheduleBycId(userId);
		return list;
	}

}
