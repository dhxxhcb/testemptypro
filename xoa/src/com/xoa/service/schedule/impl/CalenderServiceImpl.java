package com.xoa.service.schedule.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	  /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月4日 下午5:24:08
     * 方法介绍:   根据日程安排的起始和结束时间查询日程
     * 参数说明:   @param calTime 起始时间
     * 参数说明:   @param endTime 结束时间
     * 参数说明:   @return
     * @return     List<Calendar> 返回日程安排
     */
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
	 * 创建日期:   2017年5月4日 下午5:24:26+-
	 * 方法介绍:   根据userId 查询日程安排
	 * 参数说明:   @param Map<String, Object> maps 用户userId和当天时间戳
	 * 参数说明:   @return
	 * @return     List<Calendar>  返回日程安排
	 * @throws Exception 
	 */
	@Override
	public List<Calendar> getscheduleBycId(String userId,int calTime) throws Exception {
		Map<String, Object> maps =new HashMap<String, Object>();
		maps.put("userId", userId);
		maps.put("calTime", calTime);
		List<Calendar> list =calendarMapper.getscheduleBycId(maps);
		Long day=Long.valueOf(calTime);
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String d = format.format(day);  
		Date date=format.parse(d);  
		date.setMonth(date.getMonth()+1);
		//System.out.println(date.toString());
		//下个月的时间戳
		Long time=date.getTime();
		for(int i=0;i<list.size();i++){
			
			Calendar calendar=list.get(i);
			int cT=calendar.getCalTime();
			int eT=calendar.getEndTime();
			
			
			
			
			
			
			
			
		}
		
		
		return list;
	}
	/**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月4日 下午5:46:54
     * 方法介绍:   新增日程安排
     * 参数说明:   @param record 日程安排
     * 参数说明:   @return
     * @return     int 插入条数
     */
	@Override
	public int insertSelective(Calendar record) {
		int count=calendarMapper.insertSelective(record);
		return count;
	}

}
