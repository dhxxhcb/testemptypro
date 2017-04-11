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
	 String notifyList(@RequestParam(value="typeId",required=false)String typeId,@RequestParam(value="sendTime",required=false)String sendTime) {
	  Map<String, Object> maps = new HashMap<String, Object>();
	  maps.put("typeId", typeId);
	  maps.put("sendTime", sendTime);
	   String returnReslt= null;
	  try {
	   List<Notify> list=notifyService.selectNotify(maps, 1, 5, true);
	   ToJson<Notify> tojson = new ToJson<Notify>(0, "");
	   tojson.setObj(list);
	   returnReslt= JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	  } catch (Exception e) {
	   loger.debug("NewsMessage:"+e);
	   returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<Notify>(1, ""), "yyyy-MM-dd HH:mm:ss");
	  }
	  return returnReslt;
	 }

	// @RequestMapping(value = "/notifyList")
	// public String notifyList(HttpServletRequest request) {
	// loger.info("进入列表页面！");
	// try {
	// Notify notify = new Notify();
	// // notify.setTypeId(request.getParameter("type_id"));
	// notify.setTypeId("sss");
	// if(null!=request.getParameter("date1")&&!"".equals(request.getParameter("date1"))){
	// notify.setSendTime(new
	// SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date1")+" 00:00:00"));
	// }else{
	// notify.setSendTime(null);
	// }
	// List<Notify> n= notifyService.showNotify(notify);
	// request.setAttribute("list", n);
	// request.setAttribute("type_id",request.getParameter("type_id"));
	// request.setAttribute("date1", request.getParameter("date1"));
	// } catch (ParseException e) {
	// e.printStackTrace();
	// }
	// return "app/notify/notifyList";
	// }

	/**
	 * 增加/修改
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
	@RequestMapping(value = "/addNotify")
	public @ResponseBody
	void addNotify(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println("获取的id：" + id);

		boolean flag = !"".equals(id);
		System.out.println("获取结果：" + flag);
		Notify n = new Notify();
		n.setNotifyId(flag ? Integer.valueOf(id) : -1);
		n.setSubject(request.getParameter("subject"));
		n.setAuditDate(new Date());
		n.setAuditer("ss");
		n.setBeginDate(1);
		n.setDownload("1");
		n.setEndDate(22);
		n.setFormat("sss");
		n.setFromDept(1);
		n.setFromId("55");
		n.setIsFw("1");
		n.setKeyword("2");
		n.setLastEditor("2");
		n.setLastEditTime(new Date());
		n.setPrint("1");
		n.setPublish("1");
		n.setSendTime(new Date());
		n.setSubjectColor("ssd");
		n.setTop("1");
		n.setTopDays(1);
		n.setTypeId("11");
		n.setAttachmentId("1");
		n.setAttachmentName("ssss");
		n.setUserId("1");
		n.setToId("1");
		n.setSummary("ss");
		n.setReason("asad");
		n.setContent("adasdas");
		n.setReaders("ASDASD");
		n.setPrivId("11");
		byte[] b = {};
		n.setCompressContent(b);

		PrintWriter out = null;
		try {
			out = response.getWriter();
			notifyService.addNotify(n);
			out.print("1");
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();

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
