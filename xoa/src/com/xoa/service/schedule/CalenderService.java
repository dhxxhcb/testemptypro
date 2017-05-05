package com.xoa.service.schedule;

import java.util.List;
import java.util.Map;

import com.xoa.model.schedule.Calendar;
import com.xoa.util.dataSource.DynDatasource;

public interface CalenderService {
	@DynDatasource
	public List<Calendar> getschedule(int calTime,int endTime);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月4日 下午5:24:26
	 * 方法介绍:   根据userId 查询日程安排
	 * 参数说明:   @param Map<String, Object> maps 用户userId和当天时间戳
	 * 参数说明:   @return
	 * @return     List<Calendar>  返回日程安排
	 * @throws Exception 
	 */
	@DynDatasource
	public List<Calendar> getscheduleBycId(String userId,int calTime) throws Exception;
	
	 /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月4日 下午5:46:54
     * 方法介绍:   新增日程安排
     * 参数说明:   @param record 日程安排
     * 参数说明:   @return
     * @return     int 插入条数
     */
	@DynDatasource
	public int insertSelective(Calendar record);

}
