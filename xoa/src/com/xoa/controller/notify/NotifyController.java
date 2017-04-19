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
import com.xoa.model.notify.Notify;
import com.xoa.model.worldnews.News;
import com.xoa.service.notify.NotifyService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;

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

	
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午8:03:18
	 * 方法介绍:   公告处理过程
	 * 参数说明:   @param page   当前页面
	 * 参数说明:   @param pageSize  页面数
	 * 参数说明:   @param useFlag  是否启用分页插件
	 * 参数说明:   @return
	 * @return     String(true:成功   false：失败)
	 */
	
	@RequestMapping(value = "/notifyManage", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	  public @ResponseBody String selectNotifyManage(
			  @RequestParam("page") Integer page,
				@RequestParam("pageSize") Integer pageSize,
				@RequestParam("useFlag") Boolean useFlag){
			Map<String, Object> maps = new HashMap<String, Object>();
			String returnReslt = null;
			String err="";
			try {
				List<Notify> list =notifyService.selectNotifyManage(maps, page, pageSize, useFlag);
				System.out.println(list.size()+"111111");
				ToJson<Notify> tojson = new ToJson<Notify>(0, "");
				tojson.setObj(list);
				if (list.size() > 0) {
					err = "成功";
					returnReslt = JSON.toJSONStringWithDateFormat(tojson,
							"yyyy-MM-dd HH:mm:ss");
				} else {
					err = "失败";
					returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<Notify>(
							1, ""), "yyyy-MM-dd HH:mm:ss");
				}
			} catch (Exception e) {
				loger.debug("notifyManage:" + e);
				returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<Notify>(1,
						""), "yyyy-MM-dd HH:mm:ss");
			}

			return returnReslt;
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
     * @return     String(true:成功  false：失败)
     */
	@RequestMapping(value = "/notifyList",method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	 public @ResponseBody
	 String notifyList(@RequestParam(value = "typeId", required = false)String typeId,
			 @RequestParam(value = "sendTime", required = false) String sendTime,
			 @RequestParam(value = "subject", required = false) String subject,
			 @RequestParam(value = "content", required = false) String content,
			 @RequestParam(value = "format", required = false) String format,
			 @RequestParam("page") Integer page,
				@RequestParam("pageSize") Integer pageSize,
				@RequestParam("useFlag") Boolean useFlag) {
	  Map<String, Object> maps = new HashMap<String, Object>();
	  maps.put("typeId", typeId);
	  maps.put("sendTime", sendTime);
	  maps.put("subject", subject);
	  maps.put("content", content);
	  maps.put("format", format);
	   String returnReslt= null;
	   String name="admin";
	   String err;
	  try {
	   List<Notify> list=notifyService.selectNotify(maps, page,pageSize, useFlag, name);
	   ToJson<Notify> tojson = new ToJson<Notify>(0, "");
	   tojson.setObj(list);
	   if (list.size() > 0) {
			err = "成功";
			returnReslt = JSON.toJSONStringWithDateFormat(tojson,
					"yyyy-MM-dd HH:mm:ss");
		} else {
			err = "失败";
			returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<Notify>(
					1, ""), "yyyy-MM-dd HH:mm:ss");
		}
	  }catch (Exception e) {
	   loger.debug("notifyList:"+e);
	   returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<Notify>(1, ""), "yyyy-MM-dd HH:mm:ss");
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
	 * @return     String(true：成功 false：失败)
	 */
	@RequestMapping(value = "/unreadNotify", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String unreadNotify(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("useFlag") Boolean useFlag) {
		Map<String, Object> maps = new HashMap<String, Object>();
		String name = "wangyun";
		String returnReslt = null;
		String err = null;
		try {
			List<Notify> list = notifyService.unreadNotify(maps, page, pageSize, useFlag, name);
			System.out.println(list);
			ToJson<Notify> tojson = new ToJson<Notify>(0, err);
			tojson.setObj(list);
			if (list.size() > 0) {
				err = "成功";
				returnReslt = JSON.toJSONStringWithDateFormat(tojson,
						"yyyy-MM-dd HH:mm:ss");
			} else {
				err = "失败";
				returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<Notify>(
						1, ""), "yyyy-MM-dd HH:mm:ss");
			}
		} catch (Exception e) {
			loger.debug("/notifyList:" + e);
			returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<Notify>(1,
					""), "yyyy-MM-dd HH:mm:ss");
		}

		return returnReslt;
	}
	
	
	
    
	/*@RequestMapping(value = "/getNotifyById", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String getNotifyById(HttpServletRequest request, HttpServletResponse response) {
		Notify notify = notifyService.getNotifyById(1);
		ToJson<Notify> tojson = new ToJson<Notify>(0, "返回结果正确");
		tojson.setObject(notify);
		loger.info("结果信息："
				+ JSON.toJSONStringWithDateFormat(notify,
						"yyyy-MM-dd HH:mm:ss"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("getNotifyById", JSON.toJSONStringWithDateFormat(notify,
				"yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	}
*/
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
	@RequestMapping(value = "/queryNotify",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String queryNotify(
			@RequestParam("notifyId") Integer notifyId) throws Exception{
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("notifyId", notifyId);
		ToJson<Notify> toJson=new ToJson<Notify>(0, "");
		String name="wangyun";
		loger.debug("ID"+notifyId);
	try {
		    Notify notify=notifyService.queryById(maps, 1, 5, false, name);
			toJson.setMsg("seccess");
			toJson.setObject(notify);
			return JSON.toJSONStringWithDateFormat(toJson,
					"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			toJson.setMsg("fail");
			loger.debug("ERROR:"+e);
			return JSON.toJSONStringWithDateFormat(toJson,
					"yyyy-MM-dd HH:mm:ss");
		}
	}
	
	
	
	
	
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午8:19:48
	 * 方法介绍:   修改公告信息
	 * 参数说明:   @param notifyId
	 * 参数说明:   @param fromId
	 * 参数说明:   @param typeId
	 * 参数说明:   @param subject
	 * 参数说明:   @param content
	 * 参数说明:   @param format
	 * 参数说明:   @param fromDept
	 * 参数说明:   @param sendTime
	 * 参数说明:   @param beginDate
	 * 参数说明:   @param endDate
	 * 参数说明:   @param print
	 * 参数说明:   @param top
	 * 参数说明:   @param topDays
	 * 参数说明:   @param publish
	 * 参数说明:   @param auditer
	 * 参数说明:   @param auditDate
	 * 参数说明:   @param download
	 * 参数说明:   @param lastEditor
	 * 参数说明:   @param lastEditTime
	 * 参数说明:   @param subjectColor
	 * 参数说明:   @param keyword
	 * 参数说明:   @param isFw
	 * 参数说明:   @param toId
	 * 参数说明:   @param attachmentId
	 * 参数说明:   @param attachmentName
	 * 参数说明:   @param readers
	 * 参数说明:   @param privId
	 * 参数说明:   @param userId
	 * 参数说明:   @param reason
	 * 参数说明:   @param compressContent
	 * 参数说明:   @param summary
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/updateNotify", produces = { "application/json;charset=UTF-8" })
	public String updateNotify(
			@RequestParam(value="notifyId",required=false)Integer notifyId,
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
			@RequestParam(value="summary",required=false) String summary) {
		
		Notify notify=new Notify();
		notify.setNotifyId(notifyId);
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
	    notify.setAuditDate(DateFormat.getDate(auditDate));
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
	    	return JSON.toJSONStringWithDateFormat(
					new ToJson<Notify>(0, ""), "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			loger.debug("notifyList:" + e);
			return JSON.toJSONStringWithDateFormat(
					new ToJson<Notify>(1, ""), "yyyy-MM-dd HH:mm:ss");
		}
		
	}

	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午8:20:09
	 * 方法介绍:   保存公告信息
	 * 参数说明:   @param fromId
	 * 参数说明:   @param typeId
	 * 参数说明:   @param subject
	 * 参数说明:   @param content
	 * 参数说明:   @param format
	 * 参数说明:   @param fromDept
	 * 参数说明:   @param sendTime
	 * 参数说明:   @param beginDate
	 * 参数说明:   @param endDate
	 * 参数说明:   @param print
	 * 参数说明:   @param top
	 * 参数说明:   @param topDays
	 * 参数说明:   @param publish
	 * 参数说明:   @param auditer
	 * 参数说明:   @param auditDate
	 * 参数说明:   @param download
	 * 参数说明:   @param lastEditor
	 * 参数说明:   @param lastEditTime
	 * 参数说明:   @param subjectColor
	 * 参数说明:   @param keyword
	 * 参数说明:   @param isFw
	 * 参数说明:   @param toId
	 * 参数说明:   @param attachmentId
	 * 参数说明:   @param attachmentName
	 * 参数说明:   @param readers
	 * 参数说明:   @param privId
	 * 参数说明:   @param userId
	 * 参数说明:   @param reason
	 * 参数说明:   @param compressContent
	 * 参数说明:   @param summary
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/addNotify", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String addNotify(
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
			@RequestParam(value="summary",required=false) String summary){
		Notify notify=new Notify();
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
	    notify.setAuditDate(DateFormat.getDate(auditDate));
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
			notifyService.addNotify(notify);
			return JSON.toJSONStringWithDateFormat(new ToJson<Notify>(0, ""), "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			loger.debug("notifyList:"+e);
			return JSON.toJSONStringWithDateFormat(new ToJson<Notify>(1, ""), "yyyy-MM-dd HH:mm:ss");
		}
		
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
	/*public void deleteById(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String id = request.getParameter("id");
			if (null != id && !"".equals(id)) {// 删除成功
				notifyService.delete(id);
				out.print("1");
			} else {// 删除失败
				out.print("0");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();
	}*/
	public @ResponseBody String deleteById(@RequestParam("notifyId") Integer notifyId){
		ToJson<Notify> toJson = new ToJson<Notify>(0,"");
		loger.debug("传过来的ID"+notifyId);
		try{
			notifyService.delete(notifyId);
			toJson.setMsg("删除成功");
			return JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss");
		}catch(Exception e){
			toJson.setMsg("删除失败");
			return JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss");
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
