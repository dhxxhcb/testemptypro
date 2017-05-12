package com.xoa.controller.notify;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.alibaba.fastjson.JSON;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.notify.Notify;
import com.xoa.model.users.Users;
import com.xoa.model.worldnews.News;


import com.xoa.service.notify.NotifyService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;
import com.xoa.util.common.L;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.dataSource.ContextHolder;

/**
 * 
 * 创建作者:   张丽军
 * 创建日期:   2017-4-18 下午6:30:01
 * 类介绍  :    公告控制器
 * 构造参数:   无
 *
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/notice")
public class NotifyController {
    
	private Logger loger = Logger.getLogger(NotifyController.class);
	@Resource
	private NotifyService notifyService;
	private String err = "err";
	private String ok = "ok";
	
	
	@RequestMapping("/index")
	public String clickNews(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/notice/notice";
	}
	@RequestMapping("/manage")
	public String manage(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/notice/noticeManage";
	}
	@RequestMapping("/detail")
	public String details(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/notice/noticeDerail";
	}
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/notice/add";
	}
	@RequestMapping("/noticeQuery")
	public String noticeQuery(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/notice/noticeQuery";
	}
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午8:03:18
	 * 方法介绍:   公告处理过程
	 * 参数说明:   @param page   当前页面
	 * 参数说明:   @param pageSize  页面数
	 * 参数说明:   @param useFlag  是否启用分页插件
	 * 参数说明:   @return
	 * @return     String(true:seccess   false：fail)
	 */
	
	@RequestMapping(value = "/notifyManage", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	  public @ResponseBody ToJson<Notify> notifyManage(
			    @RequestParam(value = "format", required = false) String format,
				@RequestParam(value = "typeId", required = false) String typeId,
				@RequestParam(value = "top", required = false) String top,
				@RequestParam(value = "publish", required = false) String publish,
				@RequestParam(value = "subject", required = false) String subject,
				@RequestParam(value = "lastEditTime", required = false) String lastEditTime,
				@RequestParam(value = "content", required = false) String content,
				@RequestParam(value = "fromDept", required = false) String fromDept,
				@RequestParam(value = "sendTime", required = false) String sendTime,
				@RequestParam(value = "fromId", required = false) String fromId,
				@RequestParam(value = "toId", required = false) String toId,
				@RequestParam(value ="beginDate", required = false) String beginDate,
			    @RequestParam(value ="endDate", required = false) String endDate,
			    @RequestParam("page") Integer page,
				@RequestParam("pageSize") Integer pageSize,
				@RequestParam("useFlag") Boolean useFlag,HttpServletRequest request) {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("format", format);
			if("0".equals(typeId)){
				typeId=null;
			}else{
				maps.put("typeId", typeId);
			}
			maps.put("top", top);
			maps.put("publish", publish);
			maps.put("subject", subject);
			maps.put("lastEditTime", lastEditTime);
			maps.put("content",content);
			maps.put("fromDept", fromDept);
			maps.put("sendTime", sendTime);
			maps.put("fromId", fromId);
			maps.put("toId", toId);
			maps.put("beginDate", beginDate);
			maps.put("endDate", endDate);
			ToJson<Notify> tojson = new ToJson<Notify>(0, "");
			try {
				List<Notify> list =notifyService.selectNotifyManage(maps, page, pageSize, useFlag);
				tojson.setObj(list);
			    tojson.setTotleNum(list.size());
				if (list.size() > 0) {
					err = "seccess";
				} else {
					err = "fail";
					tojson.setFlag(1);
				}
			} catch (Exception e) {
				loger.debug("notifyManage:" + e);
				err = "fail";
				tojson.setFlag(1);
			}
			tojson.setMsg(err);
			return tojson;
		}
    /**
     * 
     * 创建作者:   张丽军
     * 创建日期:   2017-4-18 下午8:12:18
     * 方法介绍:   公告通知查询列表
     * 参数说明:   @param typeId  公告类型
     * 参数说明:   @param sendTime 发送时间
     * 参数说明:   @param subject  公告标题
     * 参数说明:   @param content  公告内容
     * 参数说明:   @param format   公告格式
     * 参数说明:   @param page     当前页面
     * 参数说明:   @param pageSize  页面数
     * 参数说明:   @param useFlag  是否启用分页插件
     * 参数说明:   @return  Json
     * @return     String(true:seccess  false：fail)
     */
	@RequestMapping(value = "/notifyList",method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	 public @ResponseBody
	 ToJson<Notify> notifyList(@RequestParam(value = "format", required = false) String format,
				@RequestParam(value = "typeId", required = false) String typeId,
				@RequestParam(value = "top", required = false) String top,
				@RequestParam(value = "publish", required = false) String publish,
				@RequestParam(value = "subject", required = false) String subject,
				@RequestParam(value = "lastEditTime", required = false) String lastEditTime,
				@RequestParam(value = "content", required = false) String content,
				@RequestParam(value = "fromDept", required = false) String fromDept,
				@RequestParam(value = "sendTime", required = false) String sendTime,
				@RequestParam(value = "fromId", required = false) String fromId,
			    @RequestParam(value = "toId", required = false) String toId,
			    @RequestParam(value ="read", required = false) String read,
			    @RequestParam(value ="beginDate", required = false) String beginDate,
			    @RequestParam(value ="endDate", required = false) String endDate,
			    @RequestParam("page") Integer page,
				@RequestParam("pageSize") Integer pageSize,
				@RequestParam("useFlag") Boolean useFlag,
				HttpServletRequest request, HttpServletResponse response) {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
	  Map<String, Object> maps = new HashMap<String, Object>();
	  maps.put("format", format);
	  if ("0".equals(typeId)) {
			typeId=null;
		}
	  maps.put("typeId", typeId);
	  maps.put("top", top);
	  maps.put("publish", publish);
	  maps.put("subject", subject);
	  maps.put("lastEditTime", lastEditTime);
	  maps.put("content",content);
	  maps.put("fromDept", fromDept);
	  maps.put("sendTime", sendTime);
	  maps.put("fromId", fromId);
	  maps.put("toId", toId);
	  maps.put("beginDate", beginDate);
	  maps.put("endDate", endDate);
	  ToJson<Notify> returnReslt=new ToJson(1,"");
	  Users name=SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users());	 
	  try {
		  if (read.equals("0")) {
				ToJson<Notify> tojson= notifyService.unreadNotify(maps, page, pageSize, useFlag, name.getUserId());
				if (tojson.getObj().size() > 0) {
					tojson.setMsg("ok");
				} else {
					tojson.setFlag(1);
				}
				returnReslt=tojson;
			}else if (read.equals("1")) {//已读
				ToJson<Notify> tojson= notifyService.readNotify(maps, page, pageSize, useFlag, name.getUserId());
				if (tojson.getObj().size() > 0) {
					tojson.setMsg("ok");
				} else {
					tojson.setFlag(1);
				}
				returnReslt=tojson;
			}
				else 
				{
				ToJson<Notify> tojson= notifyService.selectNotify(maps, page, pageSize, useFlag, name.getUserId());
				if (tojson.getObj().size() > 0) {
					tojson.setMsg("ok");	
				} else {
					tojson.setFlag(1);
				}
				returnReslt=tojson;
			} 
	  }catch (Exception e) {
	   loger.debug("notifyMessage:"+e);	   
	  }
	  return returnReslt;
	 }	
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午8:16:20
	 * 方法介绍:   未读信息
	 * 参数说明:   @param request  请求
	 * 参数说明:   @param response 响应
	 * 参数说明:   @param page   当前页
	 * 参数说明:   @param pageSize 页面数
	 * 参数说明:   @param useFlag  是否启用分页插件
	 * 参数说明:   @return Json
	 * @return     String(true：success false：fail)
	 */
	/*@RequestMapping(value = "/unreadNotify", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String unreadNotify(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("useFlag") Boolean useFlag) {
		Map<String, Object> maps = new HashMap<String, Object>();
		String name = (String) request.getSession().getAttribute("byname");
		String returnReslt = null;
		String err = null;
		try {
			List<Notify> list = notifyService.unreadNotify(maps, page, pageSize, useFlag, name);
			System.out.println(list);
			ToJson<Notify> tojson = new ToJson<Notify>(0, err);
			tojson.setObj(list);
			if (list.size() > 0) {
				err = "seccess";
				returnReslt = JSON.toJSONStringWithDateFormat(tojson,
						"yyyy-MM-dd HH:mm:ss");
			} else {
				err = "fail";
				returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<Notify>(
						1, ""), "yyyy-MM-dd HH:mm:ss");
			}
		} catch (Exception e) {
			loger.debug("/notifyList:" + e);
			returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<Notify>(1,
					""), "yyyy-MM-dd HH:mm:ss");
		}

		return returnReslt;
	}*/
	
	

	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午8:19:13
	 * 方法介绍:   公告查询详情
	 * 参数说明:   @param notifyId 
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     String
	 */
	@RequestMapping(value = "/getOneById",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
	public @ResponseBody ToJson<Notify> getOneById(@RequestParam("notifyId") Integer notifyId,HttpServletRequest request){
			String sqlType = "xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse");
			ContextHolder.setConsumerType(sqlType);
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("notifyId", notifyId);
		ToJson<Notify> toJson=new ToJson<Notify>(0, "");
		String name=SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
			//String name="www";
		loger.debug("transfersID"+notifyId);
	try {
		    Notify notify=notifyService.queryById(maps, 1, 20, false, name,sqlType);
			toJson.setMsg("success");
			toJson.setObject(notify);
			return toJson;
		} catch (Exception e) {
			toJson.setMsg("fail");
			loger.debug("ERROR:"+e);
			return toJson;
		}
	}

	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午8:19:48
	 * 方法介绍:   修改公告信息
	 * 参数说明:   @param notifyId  主键(公告)
	 * 参数说明:   @param fromId   发布用户USER_ID
	 * 参数说明:   @param typeId  公告型
	 * 参数说明:   @param subject  公告标题
	 * 参数说明:   @param content  公告通知内容
	 * 参数说明:   @param format  公告通知格式(0-普通格式,1-mht格式,2-超链接)
	 * 参数说明:   @param fromDept 发布部门ID
	 * 参数说明:   @param sendTime  发送时间
	 * 参数说明:   @param beginDate  开始日期
	 * 参数说明:   @param endDate   结束日期
	 * 参数说明:   @param print  是否允许打印office附件(0-不允许,1-允许)
	 * 参数说明:   @param top  是否置顶(0-否,1-是)
	 * 参数说明:   @param topDays  置顶天数
	 * 参数说明:   @param publish   发布标识(0-未发布,1-已发布,2-待审批,3-未通过)
	 * 参数说明:   @param auditer  审核人用户ID
	 * 参数说明:   @param auditDate  审核时间
	 * 参数说明:   @param download  是否允许下载office附件(0-不允许,1-允许)
	 * 参数说明:   @param lastEditor  最后编辑人
	 * 参数说明:   @param lastEditTime  最后编辑时间
	 * 参数说明:   @param subjectColor  公告标题颜色
	 * 参数说明:   @param keyword  内容关键字
	 * 参数说明:   @param isFw  是否转发
	 * 参数说明:   @param toId  按部门发布
	 * 参数说明:   @param attachmentId  附件ID串
	 * 参数说明:   @param attachmentName  附件名称串
	 * 参数说明:   @param readers  阅读人员用户ID串
	 * 参数说明:   @param privId  按角色发布
	 * 参数说明:   @param userId  用户id
	 * 参数说明:   @param reason  审核人不同意的原因
	 * 参数说明:   @param compressContent  压缩后的公告通知内容
	 * 参数说明:   @param summary  内容简介
	 * 参数说明:   @return
	 * @param notifyId 
	 * @return     String
	 */
	
	@ResponseBody
	@RequestMapping(value = "/updateNotify", produces = { "application/json;charset=UTF-8" })
	public String updateNotify(Notify notify, HttpServletRequest request,
			@RequestParam("notifyId") Integer notifyId,
			@RequestParam(name = "lastEditTime", required = false) String lastEditTime) {
		ContextHolder.setConsumerType("xoa"
				+ (String) request.getSession().getAttribute("loginDateSouse"));
		L.a("0==||>>>>>>>>>>>>>>>" + notify.getToId());
		notify.setNotifyId(notifyId);
		notify.setLastEditTime(DateFormat.getDate(lastEditTime));
		try {
			notifyService.updateNotify(notify);
			return JSON.toJSONStringWithDateFormat(new ToJson<Notify>(
					0, ok), "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			loger.debug("addNotify:" + e);
			return JSON.toJSONStringWithDateFormat(new ToJson<Notify>(
					1, err), "yyyy-MM-dd HH:mm:ss");
		}
	}
	/*public ToJson<Notify> updateNotify(
			@RequestParam(value="fromId",required=false)String fromId,
			@RequestParam(value="typeId",required=false)String typeId,
			@RequestParam(value="subject",required=false)String subject,
			@RequestParam(value="content",required=false)String content,
			@RequestParam(value="format",required=false)String format,
			@RequestParam(value="fromDept",required=false) String fromDept,
			@RequestParam(value="sendTime",required=false) String sendTime,
			@RequestParam(value="beginDate",required=false) String beginDate,
			@RequestParam(value="endDate",required=false) String endDate,
			@RequestParam(value="print",required=false) String print,
			@RequestParam(value="top",required=false) String top,
			@RequestParam(value="topDays",required=false) String topDays,
			@RequestParam(value="publish",required=false) String publish,
			@RequestParam(value="auditer",required=false) String auditer,
			@RequestParam(value="auditDate",required=false) String auditDate,
			@RequestParam(value="download",required=false) String download,
			@RequestParam(value="lastEditor",required=false) String lastEditor,
			@RequestParam(value="lastEditTime",required=false) String lastEditTime,
			@RequestParam(value="subjectColor",required=false) String subjectColor,
			@RequestParam(value="keyword",required=false) String keyword,
			@RequestParam(value="isFw",required=false) String isFw,
			@RequestParam(value="toId",required=false) String toId,
			@RequestParam(value="attachmentId",required=false) String attachmentId,
			@RequestParam(value="attachmentName",required=false) String attachmentName,
			@RequestParam(value="readers",required=false) String readers,
			@RequestParam(value="privId",required=false) String privId,
			@RequestParam(value="userId",required=false) String userId,
			@RequestParam(value="reason",required=false) String reason,
			@RequestParam(value="compressContent",required=false) String compressContent,
			@RequestParam(value="summary",required=false) String summary,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		Notify notify=new Notify();	
		notify.setNotifyId(0);
		notify.setFromId(this.returnValue(fromId));
		notify.setTypeId(this.returnValue(typeId));
		notify.setSubject(this.returnValue(subject));
		notify.setContent(this.returnValue(content));
		notify.setFormat(this.returnValue(format));
		notify.setFromDept(Integer.valueOf(fromDept));
		notify.setSendTime(DateFormat.getDate(sendTime));
		notify.setBeginDate(DateFormat.getTime(beginDate));
		notify.setEndDate(DateFormat.getTime(endDate));
	    notify.setPrint(this.returnValue(print));
	    notify.setTop(this.returnValue(top));
	    notify.setTopDays( DateFormat.getTime(topDays));
	    notify.setPublish(this.returnValue(publish));
	    notify.setAuditer(this.returnValue(auditer));
	    notify.setAuditDate(auditDate);
	    notify.setDownload(this.returnValue(download));
	    notify.setLastEditor(this.returnValue(lastEditor));
	    notify.setLastEditTime(DateFormat.getDate(lastEditTime));
	    notify.setSubjectColor(this.returnValue(subjectColor));
	    notify.setKeyword(this.returnValue(keyword));
	    notify.setIsFw(this.returnValue(isFw));
	    notify.setToId(this.returnValue(toId));
	    notify.setAttachmentId(this.returnValue(attachmentId));
	    notify.setAttachmentName(this.returnValue(attachmentName));
	    notify.setReaders(this.returnValue(readers));
	    notify.setPrivId(this.returnValue(privId));
	    notify.setUserId(this.returnValue(userId));
	    notify.setReason(this.returnValue(reason));
	    notify.setCompressContent(compressContent.getBytes());
	    notify.setSummary(this.returnValue(summary));	
	    try {
	    	notifyService.updateNotify(notify);
	    	return 
					new ToJson<Notify>(0, "");
		} catch (Exception e) {
			loger.debug("notifyMessage:" + e);
			return 
					new ToJson<Notify>(1, "");
		}
		
	}*/

	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午8:20:09
	 * 方法介绍:   保存公告信息
	 * 参数说明:   @param fromId   发布用户USER_ID
	 * 参数说明:   @param typeId  公告型
	 * 参数说明:   @param subject  公告标题
	 * 参数说明:   @param content  公告通知内容
	 * 参数说明:   @param format  公告通知格式(0-普通格式,1-mht格式,2-超链接)
	 * 参数说明:   @param fromDept 发布部门ID
	 * 参数说明:   @param sendTime  发送时间
	 * 参数说明:   @param beginDate  开始日期
	 * 参数说明:   @param endDate   结束日期
	 * 参数说明:   @param print  是否允许打印office附件(0-不允许,1-允许)
	 * 参数说明:   @param top  是否置顶(0-否,1-是)
	 * 参数说明:   @param topDays  置顶天数
	 * 参数说明:   @param publish   发布标识(0-未发布,1-已发布,2-待审批,3-未通过)
	 * 参数说明:   @param auditer  审核人用户ID
	 * 参数说明:   @param auditDate  审核时间
	 * 参数说明:   @param download  是否允许下载office附件(0-不允许,1-允许)
	 * 参数说明:   @param lastEditor  最后编辑人
	 * 参数说明:   @param lastEditTime  最后编辑时间
	 * 参数说明:   @param subjectColor  公告标题颜色
	 * 参数说明:   @param keyword  内容关键字
	 * 参数说明:   @param isFw  是否转发
	 * 参数说明:   @param toId  按部门发布
	 * 参数说明:   @param attachmentId  附件ID串
	 * 参数说明:   @param attachmentName  附件名称串
	 * 参数说明:   @param readers  阅读人员用户ID串
	 * 参数说明:   @param privId  按角色发布
	 * 参数说明:   @param userId  用户id
	 * 参数说明:   @param reason  审核人不同意的原因
	 * 参数说明:   @param compressContent  压缩后的公告通知内容
	 * 参数说明:   @param summary  内容简介
	 * 参数说明:   @return
	 * @return     String
	 */

	@RequestMapping(value = "/addNotify", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	ToJson addNotify(Notify notify, @RequestParam("sendTimes") String sendTimes,
			
			HttpServletRequest request) {
		ToJson toJson = new ToJson();
		ContextHolder.setConsumerType("xoa"
				+ (String) request.getSession().getAttribute("loginDateSouse"));
		Users name=SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users());
		notify.setPrivId(name.getUserId());
		notify.setReaders(name.getUserId() + ",");
		Long a=	(Long)DateFormat.getDate(sendTimes).getTime();

	//	notify.setEndDate(DateFormat.getTime(notify.getNotifyDateTime()));
	//	notify.setBeginDate(DateFormat.getTime(notify.getNotifyDateTime()));
		notify.setSendTime(DateFormat.getDate(sendTimes));
		Date  curDate=new Date(System.currentTimeMillis());
		notify.setLastEditTime((curDate));
/*	 ToJson<Notify> addNotify(
			@RequestParam(value="fromId",required=false)String fromId,
			@RequestParam(value="typeId",required=false)String typeId,
			@RequestParam(value="subject",required=false)String subject,
			@RequestParam(value="content",required=false)String content,
			@RequestParam(value="format",required=false)String format,
			@RequestParam(value="fromDept",required=false) String fromDept,
			@RequestParam(value="sendTime",required=false) String sendTime,
			@RequestParam(value="beginDate",required=false) String beginDate,
			@RequestParam(value="endDate",required=false) String endDate,
			//@RequestParam(value="print",required=false) String print,
			@RequestParam(value="top",required=false) String top,
			@RequestParam(value="topDays",required=false) String topDays,
			@RequestParam(value="publish",required=false) String publish,
			@RequestParam(value="auditer",required=false) String auditer,
			@RequestParam(value="auditDate",required=false) String auditDate,
			@RequestParam(value="download",required=false) String download,
			@RequestParam(value="lastEditor",required=false) String lastEditor,
			@RequestParam(value="lastEditTime",required=false) String lastEditTime,
			@RequestParam(value="subjectColor",required=false) String subjectColor,
			@RequestParam(value="keyword",required=false) String keyword,
			@RequestParam(value="isFw",required=false) String isFw,
			@RequestParam(value="toId",required=false) String toId,
			@RequestParam(value="attachmentId",required=false) String attachmentId,
			@RequestParam(value="attachmentName",required=false) String attachmentName,
			//@RequestParam(value="readers",required=false) String readers,
			@RequestParam(value="privId",required=false) String privId,
			@RequestParam(value="userId",required=false) String userId,
			//@RequestParam(value="reason",required=false) String reason,
			@RequestParam(value="compressContent",required=false) String compressContent,
			@RequestParam(value="summary",required=false) String summary,HttpServletRequest request) {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
			String name=SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
		Notify notify=new Notify();
		notify.setNotifyId(0);
		notify.setFromId(this.returnValue(fromId));
		notify.setTypeId(this.returnValue(typeId));
		notify.setSubject(this.returnValue(subject));
		notify.setContent(this.returnValue(content));
		notify.setFormat(this.returnValue(format));
		notify.setFromDept(Integer.valueOf(fromDept));
		notify.setSendTime(DateFormat.getDate(sendTime));
		notify.setBeginDate(DateFormat.getTime(beginDate));
		notify.setEndDate(DateFormat.getTime(endDate));
	   // notify.setPrint(this.returnValue(print));
	    notify.setTop(this.returnValue(top));
	    notify.setTopDays( DateFormat.getTime(topDays));
	    notify.setPublish(this.returnValue(publish));
	    notify.setAuditer(this.returnValue(auditer));
	    notify.setAuditDate(auditDate);
	    notify.setDownload(this.returnValue(download));
	    notify.setLastEditor(this.returnValue(lastEditor));
	    notify.setLastEditTime(DateFormat.getDate(lastEditTime));
	    notify.setSubjectColor(this.returnValue(subjectColor));
	    notify.setKeyword(this.returnValue(keyword));
	    notify.setIsFw(this.returnValue(isFw));
	    notify.setToId(this.returnValue(toId));
	    notify.setAttachmentId(this.returnValue(attachmentId));
	    notify.setAttachmentName(this.returnValue(attachmentName));
	    notify.setReaders(name+",");
	    notify.setPrivId(this.returnValue(privId));
	    notify.setUserId(this.returnValue(userId));
	   // notify.setReason(this.returnValue(reason));
	    notify.setCompressContent(compressContent.getBytes());
	    notify.setSummary(this.returnValue(summary));
		try {
			notifyService.addNotify(notify);
			return new ToJson<Notify>(0, "");
		} catch (Exception e) {
			loger.debug("addNotify:"+e);
			return new ToJson<Notify>(1, "");
		}*/
		try {
		 int b=	notifyService.addNotify(notify);
          if(b>0){
			  toJson.setFlag(0);
			  toJson.setMsg("success");
		  }else{
			  toJson.setFlag(1);
			  toJson.setMsg("success");
		  }
		} catch (Exception e) {
			loger.debug("addNotify:" + e);
			e.printStackTrace();
		}
      return toJson;
	}
	
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午8:20:30
	 * 方法介绍:   根据ID删除公告
	 * 参数说明:   @param notifyId
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/deleteById", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody ToJson<Notify> deleteById(@RequestParam("notifyId") Integer notifyId,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<Notify> toJson = new ToJson<Notify>(0,"");
		//loger.debug("transfersID"+notifyId);
		try{
			notifyService.delete(notifyId);
			toJson.setMsg("delete success");
			return toJson;
		}catch(Exception e){
			toJson.setMsg("delete fail");
			return toJson;
		}
	}
	
	
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午8:52:53
	 * 方法介绍:   为null时转换为""
	 * 参数说明:   @param value
	 * 参数说明:   @return
	 * @return     String
	 */
	public static String returnValue(String value) {
		if (value != null) {
			return value;
		} else {
			return "";
		}
	}



}
