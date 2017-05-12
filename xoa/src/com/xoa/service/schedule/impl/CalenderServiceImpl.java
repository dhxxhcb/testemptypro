package com.xoa.service.schedule.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.schedule.CalendarMapper;
import com.xoa.model.schedule.Calendar;
import com.xoa.model.schedule.CalendarAll;
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
	 * 创建日期:   2017年5月5日 下午5:24:26
	 * 方法介绍:   根据userId 查询日程安排
	 * 参数说明:   @param Map<String, Object> maps 用户userId和当天时间戳
	 * 参数说明:   @return
	 * @return     List<Calendar>  返回日程安排
	 * @throws Exception 
	 */
	@Override
	public List<Calendar> getscheduleBycId(String userId) throws Exception {
		Map<String, Object> maps =new HashMap<String, Object>();
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
		cal.set(java.util.Calendar.SECOND, 0);
		cal.set(java.util.Calendar.MINUTE, 0);
		cal.set(java.util.Calendar.MILLISECOND, 0);
		int calTime=(int) (cal.getTimeInMillis()/1000);
		maps.put("userId", userId);
		maps.put("calTime", calTime);
		List<Calendar> list =calendarMapper.getscheduleBycId(maps);
		//当前时间戳
		//Long day=Long.valueOf(calTime);
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd hh:mm");
		List<Calendar> listAll=new ArrayList<Calendar>();
		for(int i=0;i<30;i++){
			Calendar Allcal=new Calendar();		  
			int pd=calTime+86400*i;
			Long t=(long) (pd*1000L);
			List<CalendarAll> list1=new ArrayList<CalendarAll>();
			String data = format.format(t); 	
			for(int j=0;j<list.size();j++){
				Calendar calendar=list.get(j);
				CalendarAll ca=new CalendarAll();
				int cT=calendar.getCalTime();
				int eT=calendar.getEndTime();
				Long ct=(long) (cT*1000L);
				Long et=(long) (eT*1000L);
				String s=f.format(ct);
				String e=f.format(et);
				calendar.setStim(s);
				calendar.setEtim(e);
				if(pd<=cT&&cT<=pd+86400||pd<=eT&&pd>=cT){	
					ca.setAddTime(calendar.getAddTime());
					ca.setCalId(calendar.getCalId());
					ca.setEndTime(calendar.getEndTime());
					ca.setContent(calendar.getContent());
					ca.setCalLevel(calendar.getCalLevel());
					ca.setCalTime(calendar.getCalTime());
					ca.setTaker(calendar.getTaker());
					ca.setStim(calendar.getStim());
					ca.setEtim(calendar.getEtim());
					list1.add(ca);
				}
			}
			Allcal.setCalData(data);
			Allcal.setCalMessage(list1);
			listAll.add(Allcal);
		}
		return listAll;
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
	public void insertSelective(Calendar record) {
		calendarMapper.insertSelective(record);
	}
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月5日 下午6:17:56
	 * 方法介绍:   根据calId删除日程安排
	 * 参数说明:   @param calId 主键
	 * @return     void 无
	 */
	public void delete(int calId){
	calendarMapper.delete(calId);	
	}
	
	/**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月4日 下午5:46:54
     * 方法介绍:   更新日程安排
     * 参数说明:   @param record 日程安排
     * 参数说明:   @return
     * @return     int 插入条数
     */
	@Override
	public void update(Calendar calendar) {
		calendarMapper.update(calendar);
		
	}
	
	
	@Override
	public List<Calendar> getscheduleByDay(String userId, int time) {
		Map<String, Object> maps =new HashMap<String, Object>();
		maps.put("userId", userId);
		maps.put("calTime", time);
		List<Calendar> list =calendarMapper.getscheduleByDay(maps);
 		for(int i=0;i<list.size();i++){
 			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Calendar cal=list.get(i);
			int cT=cal.getCalTime();
			int eT=cal.getEndTime();
			Long ct=(long) (cT*1000L);
			Long et=(long) (eT*1000L);
			String s=format.format(ct);
			String e=format.format(et);
			cal.setStim(s);
			cal.setEtim(e);
		}
		
	   
		//当前时间戳
	/*	Long t=(long) (time*1000L);
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
		String data = format.format(t); 
		List<Calendar> listAll=new ArrayList<Calendar>();
			Calendar Allcal=new Calendar();				
			Allcal.setCalData(data);
			Allcal.setCalMessage(list1);
			listAll.add(Allcal);
		*/
		return list;
	}


}
