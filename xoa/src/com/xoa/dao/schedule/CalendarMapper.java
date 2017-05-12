package com.xoa.dao.schedule;

import java.util.List;
import java.util.Map;

import com.xoa.model.schedule.Calendar;

 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月5日 下午6:19:35
 * 类介绍  :   
 * 构造参数:   
 *
 */
public interface CalendarMapper {
	
	
    int insert(Calendar record);

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月4日 下午5:46:54
     * 方法介绍:   新增日程安排
     * 参数说明:   @param record 日程安排
     * 参数说明:   @return
     * @return     void 无
     */
    void insertSelective(Calendar record);
    
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月4日 下午5:24:08
     * 方法介绍:   根据日程安排的起始和结束时间查询日程
     * 参数说明:   @param maps 起始和结束时间
     * 参数说明:   @return
     * @return     List<Calendar> 返回日程安排
     */
    List<Calendar> getschedule(Map<String, Object> maps);
    
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月4日 下午5:24:15
     * 方法介绍:   根据userId 查询日程安排
     * 参数说明:   @param userId 用户userId
     * 参数说明:   @return
     * @return     List<Calendar> 返回日程安排
     */
    List<Calendar> getscheduleBycId(Map<String, Object> maps);
    
    
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月5日 下午6:19:39
     * 方法介绍:   根据calId删除
     * 参数说明:   @param calId
     * @return     void 无
     */
    void delete(int calId);

    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月8日 下午6:09:18
     * 方法介绍:   修改
     * 参数说明:   @param calendar
     * @return     void 无
     */
    void update(Calendar calendar);
    
    List<Calendar> getscheduleByDay(Map<String, Object> maps);
}