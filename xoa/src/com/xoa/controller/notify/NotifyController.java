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
import com.xoa.model.email.Email;
import com.xoa.model.email.EmailBody;
import com.xoa.model.notify.Notify;
import com.xoa.model.worldnews.News;
import com.xoa.service.notify.NotifyService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;

@Controller
@Scope(value = "prototype")
public class NotifyController {

	private Logger loger = Logger.getLogger(NotifyController.class);
	@Resource
	private NotifyService notifyService;

	/**
	 * 查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/notifyList",method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	 public @ResponseBody
	 String notifyList(@RequestParam(value="typeId",required=false)String typeId,
			 @RequestParam(value="sendTime",required=false)String sendTime,
			 @RequestParam(value="subject",required=false)String subject,
			 @RequestParam(value="content",required=false)String content,
			 @RequestParam(value="format",required=false)String format,
			 @RequestParam(value="page",required=false)String page,
			 @RequestParam(value="pageSize",required=false)String pageSize) {
	  Map<String, Object> maps = new HashMap<String, Object>();
	  maps.put("typeId", typeId);
	  maps.put("sendTime", DateFormat.getDate(sendTime));
	  maps.put("subject", subject);
	  maps.put("content", content);
	  maps.put("format", format);
	   String returnReslt= null;
	  try {
	   List<Notify> list=notifyService.selectNotify(maps, Integer.valueOf(page), Integer.valueOf(pageSize), true);
	   ToJson<Notify> tojson = new ToJson<Notify>(0, "");
	   tojson.setObj(list);
	   returnReslt= JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	  } catch (Exception e) {
	   loger.debug("NewsMessage:"+e);
	   returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<Notify>(1, ""), "yyyy-MM-dd HH:mm:ss");
	  }
	  return returnReslt;
	 }

	
	/**
	 * 修改
	 * 
	 * @return
	 */
	@RequestMapping(value = "/notifyMessage")
	public String notifyMessage(HttpServletRequest request) {
		loger.info("进入添加页面！");
		String notifyId = request.getParameter("notfyId");
		if (null != notifyId && !"".equals(notifyId)) {
			List<Notify> n = notifyService.getNotifyById(notifyId);
			
			Notify notify = n.get(0);
			request.setAttribute("notify", notify);
		} else {
			request.setAttribute("notify", null);
		}
		
		return "app/notify/notifyMssage";
	}

	/**
	 * 保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addNotify", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String addNotify(@RequestParam(value="fromId",required=false)String fromId,
			@RequestParam(value="typeId",required=false)String typeId,
			@RequestParam(value="subjec",required=false)String subjec,
			@RequestParam(value="content",required=false)String content,
			@RequestParam(value="format",required=false)String format,
			@RequestParam("fromDept") String fromDept,
			@RequestParam("sendTime") String sendTime,
			@RequestParam("beginDate") String beginDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("print") String print,
			@RequestParam("top") String top,
			@RequestParam("topDays") String topDays,
			@RequestParam("publish") String publish,
			@RequestParam("auditer") String auditer,
			@RequestParam("auditDate") String auditDate,
			@RequestParam("download") String download,
			@RequestParam("lastEditor") String lastEditor,
			@RequestParam("lastEditTime") String lastEditTime,
			@RequestParam("subjectColor") String subjectColor,
			@RequestParam("keyword") String keyword,
			@RequestParam("isFw") String isFw,
			@RequestParam("toId") String toId,
			@RequestParam("attachmentId") String attachmentId,
			@RequestParam("attachmentName") String attachmentName,
			@RequestParam("readers") String readers,
			@RequestParam("privId") String privId,
			@RequestParam("userId") String userId,
			@RequestParam("reason") String reason,
			@RequestParam("compressContent") String compressContent,
			@RequestParam("summary") String summary){
		Notify notify=new Notify();
		notify.setFromId(fromId);
		notify.setTypeId(typeId);
		notify.setSubject(subjec);
		notify.setContent(content);
		notify.setFormat(format);
		notify.setFromDept(Integer.valueOf(fromDept));
		notify.setSendTime(DateFormat.getDate(sendTime));
		notify.setBeginDate(DateFormat.getTime(beginDate));
		notify.setEndDate(DateFormat.getTime(endDate));
	    notify.setPrint(print);
	    notify.setTop(top);
	    notify.setTopDays( DateFormat.getTime(topDays));
	    notify.setPublish(publish);
	    notify.setAuditer(auditer);
	    notify.setAuditDate(DateFormat.getDate(auditDate));
	    notify.setDownload(download);
	    notify.setLastEditor(lastEditor);
	    notify.setLastEditTime(DateFormat.getDate(lastEditTime));
	    notify.setSubjectColor(subjectColor);
	    notify.setKeyword(keyword);
	    notify.setIsFw(isFw);
	    notify.setToId(toId);
	    notify.setAttachmentId(attachmentId);
	    notify.setAttachmentName(attachmentName);
	    notify.setReaders(readers);
	    notify.setPrivId(privId);
	    notify.setUserId(userId);
	    notify.setReason(reason);
	    notify.setCompressContent(compressContent.getBytes());
	    notify.setSummary(summary);
		try {
			notifyService.addNotify(notify);
			return JSON.toJSONStringWithDateFormat(new ToJson<Notify>(0, ""), "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			loger.debug("sendMail:"+e);
			return JSON.toJSONStringWithDateFormat(new ToJson<Notify>(1, ""), "yyyy-MM-dd HH:mm:ss");
		}
		
	}
	
	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/deleteMessage", produces = { "application/json;charset=UTF-8" })
	public void deleteMessage(HttpServletRequest request,
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
	}

}
