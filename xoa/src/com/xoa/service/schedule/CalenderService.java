package com.xoa.service.schedule;

import java.util.List;

import com.xoa.model.schedule.Calendar;
import com.xoa.util.dataSource.DynDatasource;

public interface CalenderService {
	@DynDatasource
	public List<Calendar> getschedule(int calTime,int endTime);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月4日 下午5:24:26
	 * 方法介绍:   根据userId 查询日程安排
	 * 参数说明:   @param userId 用户userId
	 * 参数说明:   @return
	 * @return     List<Calendar>  返回日程安排
	 */
	@DynDatasource
	public List<Calendar> getscheduleBycId(String userId);

}
