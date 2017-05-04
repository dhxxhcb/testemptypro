package com.xoa.service.schedule;

import java.util.List;

import com.xoa.model.schedule.Calendar;
import com.xoa.util.dataSource.DynDatasource;

public interface CalenderService {
	@DynDatasource
	public List<Calendar> getschedule(int calTime,int endTime);
	
	@DynDatasource
	public List<Calendar> getscheduleBycId(String userId);

}
