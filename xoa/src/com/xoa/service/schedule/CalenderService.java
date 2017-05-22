package com.xoa.service.schedule;

import java.util.List;

import com.xoa.model.schedule.Calendar;

public interface CalenderService {
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
	public List<Calendar> getscheduleBycId(String userId) throws Exception;
	
	 /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月4日 下午5:46:54
     * 方法介绍:   新增日程安排
     * 参数说明:   @param record 日程安排
     * 参数说明:   @return
     * @return     int 插入条数
     */
	public void insertSelective(Calendar record);
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月5日 下午6:17:56
	 * 方法介绍:   根据calId删除日程安排
	 * 参数说明:   @param calId 主键
	 * @return     void 无
	 */
	public void delete(int calId);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月8日 下午5:41:36
	 * 方法介绍:   修改
	 * 参数说明:   @param calendar
	 * @return     void  无
	 */
	public void update(Calendar calendar);
	
	public List<Calendar> getscheduleByDay(String userId,int time);

}
