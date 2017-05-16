package com.xoa.controller.schedule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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
	private Logger loger = Logger.getLogger(CalenderController.class);
	
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
	 * 创建日期:   2017年5月12日 上午10:47:22
	 * 方法介绍:   获取当天的日程安排
	 * 参数说明:   @param request 请求
	 * 参数说明:   @param userId 用户id
	 * 参数说明:   @param time 当天时间
	 * 参数说明:   @return 
	 * @return     ToJson<Calendar>
	 */
	@ResponseBody
	@RequestMapping(value = "/schedule/getscheduleByDay",produces = {"application/json;charset=UTF-8"})
	public ToJson<Calendar> getscheduleByDay(HttpServletRequest request,String userId,int time){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
	ToJson<Calendar> json=new ToJson<Calendar>(0, null);
	try{		
		List<Calendar> list= calenderService.getscheduleByDay(userId, time);
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
			@RequestParam("calTime") String calTime ,
			@RequestParam("endTime") String endTime ,
			@RequestParam("userId") String userId ,
			@RequestParam("calLevel") String calLevel
//			@RequestParam(value="managerId",required = false) String managerId ,
//			@RequestParam(value="overStatus",required = false) String overStatus ,
//			@RequestParam(value="beforeRemaind",required = false) String beforeRemaind,
//			@RequestParam(value="addTime",required = false,defaultValue="") Date addTime,			
//			@RequestParam(value="owner",required = false,defaultValue="") String owner,
//			@RequestParam(value="taker",required = false,defaultValue="") String taker,
//			@RequestParam(value="allday",required = false,defaultValue="") byte allday,
//			@RequestParam(value="fromModule",required = false,defaultValue="") byte fromModule,
//			@RequestParam(value="url",required = false,defaultValue="") String url,
//			@RequestParam(value="mId",required = false,defaultValue="") Integer mId,
//			@RequestParam(value="resId",required = false,defaultValue="") Integer resId
						){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<Calendar> json=new ToJson<Calendar>(0, null);
		try{
			Calendar c=new Calendar();
			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
			//String addTime = format.format((long) (Integer.parseInt(calTime)*1000L)); 
			//Date d=format.parse(addTime);
			c.setUserId(userId);
			c.setEndTime(Integer.parseInt(endTime));
			c.setCalTime(Integer.parseInt(calTime));
			c.setContent(content);
			c.setCalType(calType);
			c.setCalLevel(calLevel);
			c.setManagerId("");
			c.setOverStatus("");
			c.setBeforeRemaind("");
			c.setAddTime(new Date());
			c.setOwner("");
			c.setTaker("");
			byte a=0;
			c.setAllday(a);
			c.setFromModule(a);
			c.setUrl("");
			c.setmId(1);
			c.setResId(1);
			calenderService.insertSelective(c);
			json.setObject(c);
			json.setMsg("OK");
			json.setFlag(0);
		}catch(Exception e){
			json.setMsg(e.getMessage());
		}
		return json;
		}
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月5日 下午6:21:28
	 * 方法介绍:   根据主键删除
	 * 参数说明:   @param request 请求
	 * 参数说明:   @param calId 主键
	 * 参数说明:   @return
	 * @return     ToJson<Calendar> 信息
	 */
	@ResponseBody
	@RequestMapping(value = "/schedule/delete",produces = {"application/json;charset=UTF-8"})
	public ToJson<Calendar> delete(HttpServletRequest request,String calId){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
	ToJson<Calendar> json=new ToJson<Calendar>(0, null);
	try{		
		calenderService.delete(Integer.parseInt(calId));
		json.setMsg("OK");
		json.setFlag(0);
	}catch(Exception e){
		json.setMsg(e.getMessage());
	}
	return json;
	}
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月8日 下午4:17:59
	 * 方法介绍:   编辑日程
	 * 参数说明:   @param request 请求
	 * 参数说明:   @param calType 类型
	 * 参数说明:   @param content 食物内容
	 * 参数说明:   @param calTime 开始时间
	 * 参数说明:   @param endTime 结束时间
	 * 参数说明:   @param userId 用户id
	 * 参数说明:   @param calLevel 优先级
	 * 参数说明:   @param calId 主键
	 * 参数说明:   @return
	 * @return     ToJson<Calendar> 日程信息
	 */
	@ResponseBody
	@RequestMapping(value = "/schedule/editCalender",produces = {"application/json;charset=UTF-8"})
	public ToJson<Calendar> editCalender(HttpServletRequest request,
			@RequestParam("calType") String calType ,
			@RequestParam("content") String content ,
			@RequestParam("calTime") String calTime ,
			@RequestParam("endTime") String endTime ,
			@RequestParam("userId") String userId ,
			@RequestParam("calLevel") String calLevel ,
			@RequestParam("calId") String calId 
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
			c.setCalLevel(calLevel);
			c.setCalId(Integer.parseInt(calId));
			calenderService.update(c);
			json.setObject(c);
			json.setMsg("OK");
			json.setFlag(0);
		}catch(Exception e){
			json.setMsg(e.getMessage());
		}
		return json;
		}
	
	
	@ResponseBody
	@RequestMapping(value = "/schedule/getscheduleByDate",produces = {"application/json;charset=UTF-8"})
	public ToJson<Calendar> getscheduleByDate(HttpServletRequest request,Date date){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<Calendar> json=new ToJson<Calendar>(0, null);
		try{
			//int a= calenderService.insertSelective(c);
			//json.setObject(c);
			//json.setMsg("OK");
			//json.setFlag(0);
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
	@RequestMapping(value = "/schedule/addMCalender",produces = {"application/json;charset=UTF-8"})
	public ToJson<Calendar> addMCalender(HttpServletRequest request,
			@RequestParam("calType") String calType ,
			@RequestParam("content") String content ,
			@RequestParam("calTime") String calTime ,
			@RequestParam("endTime") String endTime ,
			@RequestParam("userId") String userId ,
			@RequestParam("calLevel") String calLevel
						){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<Calendar> json=new ToJson<Calendar>(0, null);
		List<Calendar> list=new ArrayList<Calendar>();
		try{ 
		    String [] calTypes = calType.split("\\*");
		    String [] contents = content.split("\\*");
		    String [] calTimes = calTime.split("\\*");
		    String [] endTimes = endTime.split("\\*");
		    String [] userIds = userId.split("\\*");
		    String [] calLevels = calLevel.split("\\*");
			for(int i=0;i<calTypes.length;i++){
				Calendar c=new Calendar();
				//SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
				c.setUserId(userIds[i]);
				c.setEndTime(Integer.parseInt(endTimes[i]));
				c.setCalTime(Integer.parseInt(calTimes[i]));
				c.setContent(contents[i]);
				c.setCalType(calTypes[i]);
				c.setCalLevel(calLevels[i]);
				c.setManagerId("");
				c.setOverStatus("");
				c.setBeforeRemaind("");
				c.setAddTime(new Date());
				c.setOwner("");
				c.setTaker("");
				byte a=0;
				c.setAllday(a);
				c.setFromModule(a);
				c.setUrl("");
				c.setmId(1);
				c.setResId(1);
				calenderService.insertSelective(c);
				list.add(c);
			}
			json.setObj(list);
			json.setMsg("OK");
			json.setFlag(0);
		}catch(Exception e){
			json.setMsg(e.getMessage());
		}
		return json;
		}
	
	
}

