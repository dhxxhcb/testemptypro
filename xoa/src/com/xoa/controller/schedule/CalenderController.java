package com.xoa.controller.schedule;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.schedule.Calendar;
import com.xoa.service.schedule.CalenderService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
@Controller
public class CalenderController {
	
	@Resource
	private CalenderService calenderService;
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月4日 下午5:28:10
	 * 方法介绍:   根据日程安排的起始和结束时间查询日程
	 * 参数说明:   @param request 请求
	 * 参数说明:   @param calTime 起始时间
	 * 参数说明:   @param endime 结束时间
	 * 参数说明:   @return
	 * @return     ToJson<Calendar>  返回日程安排
	 */
	@ResponseBody
	@RequestMapping(value = "/schedule/getschedule",produces = {"application/json;charset=UTF-8"})
	public ToJson<Calendar> getschedule(HttpServletRequest request,String calTime,String endime){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
	ToJson<Calendar> json=new ToJson<Calendar>(0, null);
	try {
		List<Calendar> list=calenderService.getschedule(Integer.parseInt(calTime), Integer.parseInt(endime));
        json.setObj(list);
        json.setMsg("OK");
        json.setFlag(0);
	} catch (Exception e) {
		json.setMsg(e.getMessage());
	}
    return json;
}
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月4日 下午5:02:21
	 * 方法介绍:   根据userId 查询日程安排
	 * 参数说明:   @param request 请求
	 * 参数说明:   @param userId 用户Id
	 * 参数说明:   @return
	 * @return     ToJson<Calendar> 返回用户信息
	 */
	@ResponseBody
	@RequestMapping(value = "/schedule/getscheduleBycId",produces = {"application/json;charset=UTF-8"})
	public ToJson<Calendar> getscheduleBycId(HttpServletRequest request,String userId){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
	ToJson<Calendar> json=new ToJson<Calendar>(0, null);
	try{
		List<Calendar> list= calenderService.getscheduleBycId(userId);
		json.setObj(list);
		json.setMsg("OK");
		json.setFlag(0);
	}catch(Exception e){
		json.setMsg(e.getMessage());
	}
	return json;
	}
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月4日 下午6:10:50
	 * 方法介绍:   添加日程
	 * 参数说明:   @param request 请求
	 * 参数说明:   @param calType 事务类型
	 * 参数说明:   @param content 事物内容
	 * 参数说明:   @param calTime 开始时间
	 * 参数说明:   @param endTime 结束时间
	 * 参数说明:   @param userId 用户id
	 * 参数说明:   @return
	 * @return     ToJson<Calendar> 返回日程信息
	 */
	@ResponseBody
	@RequestMapping(value = "/schedule/addCalender",produces = {"application/json;charset=UTF-8"})
	public ToJson<Calendar> addCalender(HttpServletRequest request,
			@RequestParam("calType") String calType ,
			@RequestParam("content") String content ,
			@RequestParam("calTime") String calTime,
			@RequestParam("endTime") String endTime ,
			@RequestParam("userId") String userId 
						){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<Calendar> json=new ToJson<Calendar>(0, null);
		try{
			Calendar c=new Calendar();
			c.setUserId(userId);
			c.setEndTime(Integer.parseInt(endTime));
			c.setCalTime(Integer.parseInt(calTime));
			c.setContent(content);
			c.setCalType(calType);			
			int a= calenderService.insertSelective(c);
			json.setObject(c);
			json.setMsg("OK");
			json.setFlag(0);
		}catch(Exception e){
			json.setMsg(e.getMessage());
		}
		return json;
		}
}
