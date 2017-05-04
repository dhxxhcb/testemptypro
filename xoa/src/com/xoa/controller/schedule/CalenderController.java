package com.xoa.controller.schedule;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.schedule.Calendar;
import com.xoa.service.schedule.CalenderService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
@Controller
public class CalenderController {
	
	@Resource
	private CalenderService calenderService;
	
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
	 * 方法介绍:   根据userId 查询用户
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
	
}
