package com.xoa.controller.email;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xoa.model.email.Email;
import com.xoa.model.email.EmailBody;
import com.xoa.service.email.EmailUtilService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;

/**
 * 邮件
 * 
 * @author gaosubo
 * @version 1.0
 */
@Controller
@Scope(value = "prototype")
public class EmailUtilController {
	private Logger loger = Logger.getLogger(EmailUtilController.class);

	@Resource
	private EmailUtilService emailService;

	/**
	 * 发送邮件并保存
	 */
	@RequestMapping(value = "/sendEmail", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String insertEmailBody(@RequestParam("bodyId") String bodyId,
			@RequestParam(value = "fromId", required = false) String fromId,
			@RequestParam("toId2") String toId2,
			@RequestParam(value = "copyToId") String copyToId,
			@RequestParam("secretToId") String secretToId,
			@RequestParam("subject") String subject,
			@RequestParam("content") String content,
			@RequestParam("sendTime") String sendTime,
			@RequestParam("attachmentId") String attachmentId,
			@RequestParam("attachmentName") String attachmentName,
			@RequestParam("sendFlag") String sendFlag,
			@RequestParam("smsRemind") String smsRemind,
			@RequestParam("important") String important,
			@RequestParam("size") String size,
			@RequestParam("fromWebmailId") String fromWebmailId,
			@RequestParam("fromWebmail") String fromWebmail,
			@RequestParam("toWebmail") String toWebmail,
			@RequestParam("compressContent") String compressContent,
			@RequestParam("webmailContent") String webmailContent,
			@RequestParam("webmailFlag") String webmailFlag,
			@RequestParam("recvFromName") String recvFromName,
			@RequestParam("recvFrom") String recvFrom,
			@RequestParam("recvToId") String recvToId,
			@RequestParam("recvTo") String recvTo,
			@RequestParam("isWebmail") String isWebmail,
			@RequestParam("isWf") String isWf,
			@RequestParam("keyword") String keyword,
			@RequestParam("secretLevel") String secretLevel,
			@RequestParam("auditMan") String auditMan,
			@RequestParam("auditRemark") String auditRemark,
			@RequestParam("copyToWebmail") String copyToWebmail,
			@RequestParam("secretToWebmail") String secretToWebmail,
			@RequestParam("praise") String praise) {
		// emailBody.setSendTime(DateFormat.getTime("2017-4-9 10:20:36"));
		EmailBody emailBody = new EmailBody();
		emailBody.setBodyId(Integer.valueOf(bodyId));
		emailBody.setFromId(this.returnValue(fromId));
		emailBody.setToId2(toId2);
		emailBody.setCopyToId(this.returnValue(copyToId));
		emailBody.setSecretToId(this.returnValue(secretToId));
		emailBody.setSubject(this.returnValue(subject));
		emailBody.setContent(this.returnValue(content));
		emailBody.setSendTime(DateFormat.getTime(sendTime));
		emailBody.setAttachmentId(this.returnValue(attachmentId));
		emailBody.setAttachmentName(this.returnValue(attachmentName));
		emailBody.setSendFlag(this.returnValue(sendFlag));
		emailBody.setSmsRemind(this.returnValue(smsRemind));
		emailBody.setImportant(this.returnValue(important));
		emailBody.setSize(Long.valueOf(size));
		emailBody.setFromWebmailId(Integer.valueOf(fromWebmailId));
		emailBody.setFromWebmail(this.returnValue(fromWebmail));
		emailBody.setToWebmail(this.returnValue(toWebmail));
		emailBody.setCompressContent(compressContent.getBytes());
		emailBody.setWebmailContent(webmailContent.getBytes());
		emailBody.setWebmailFlag(this.returnValue(webmailFlag));
		emailBody.setRecvFromName(this.returnValue(recvFromName));
		emailBody.setRecvFrom(this.returnValue(recvFrom));
		emailBody.setRecvToId(Integer.valueOf(recvToId));
		emailBody.setRecvTo(this.returnValue(recvTo));
		emailBody.setIsWebmail(this.returnValue(isWebmail));
		emailBody.setIsWf(this.returnValue(isWf));
		emailBody.setKeyword(this.returnValue(keyword));
		emailBody.setSecretLevel(Integer.valueOf(secretLevel));
		emailBody.setAuditMan(this.returnValue(auditMan));
		emailBody.setAuditRemark(this.returnValue(auditRemark));
		emailBody.setCopyToWebmail(this.returnValue(copyToWebmail));
		emailBody.setSecretToWebmail(this.returnValue(secretToWebmail));
		emailBody.setPraise(this.returnValue(praise));
		try {
			emailService.sendEmail(emailBody, new Email());
			return JSON.toJSONStringWithDateFormat(
					new ToJson<EmailBody>(0, ""), "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			loger.debug("sendMail:" + e);
			return JSON.toJSONStringWithDateFormat(
					new ToJson<EmailBody>(1, ""), "yyyy-MM-dd HH:mm:ss");
		}

	}

	/**
	 * 根据ID删除一条邮件`
	 */
	/*
	 * @RequestMapping(value = "/deleteEmailBody", produces = {
	 * "application/json;charset=UTF-8" }) public @ResponseBody void
	 * deleteEmailBody(HttpServletRequest request, HttpServletResponse response)
	 * { Integer bodyId = Integer.parseInt(request.getParameter("bodyId"));
	 * emailService.deleteByPrimaryKey(bodyId); }
	 */

	// /**
	// * 根据ID查询一条邮件
	// */
	// @RequestMapping(value = "/queryById", produces = {
	// "application/json;charset=UTF-8" })
	// public @ResponseBody String queryById(HttpServletRequest request,
	// HttpServletResponse response) {
	// EmailBody emailBody=emailService.queryById(1);
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
	// tojson.setObject(emailBody);
	// loger.info("结果信息：" + JSON.toJSONStringWithDateFormat(emailBody,
	// "yyyy-MM-dd HH:mm:ss"));
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("queryById", JSON.toJSONStringWithDateFormat(emailBody,
	// "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }
	//
	//
	// /**
	// * 草稿箱查询
	// * @throws Exception
	// */
	// @RequestMapping(value="/listDrafts",
	// produces={"application/json;charset=UTF-8"})
	// public @ResponseBody String listDrafts(HttpServletRequest request,
	// HttpServletResponse response) throws Exception{
	// Map<String,Object> maps = new HashMap<String, Object>();
	// List<EmailBody> listSelectDrafts =
	// emailService.listDrafts(maps,1,3,true);
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
	// tojson.setObj(listSelectDrafts);
	// loger.info("结果信息：" + JSON.toJSONStringWithDateFormat(listSelectDrafts,
	// "yyyy-MM-dd HH:mm:ss"));
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("selectAllEmail",
	// JSON.toJSONStringWithDateFormat(listSelectDrafts,
	// "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }
	//
	// /**
	// * 发件箱查询
	// * @throws Exception
	// */
	// @RequestMapping(value="/selectInbox",
	// produces={"application/json;charset=UTF-8"})
	// public @ResponseBody String selectInbox(HttpServletRequest request,
	// HttpServletResponse response) throws Exception{
	// Map<String,Object> maps = new HashMap<String, Object>();
	// List<EmailBody> listInbox = emailService.selectInbox(maps,1,3,true);
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
	// tojson.setObj(listInbox);
	// loger.info("结果信息：" + JSON.toJSONStringWithDateFormat(listInbox,
	// "yyyy-MM-dd HH:mm:ss"));
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("selectAllEmail", JSON.toJSONStringWithDateFormat(listInbox,
	// "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }
	//
	//
	// /**
	// * 已发送查询
	// * @throws Exception
	// */
	// @RequestMapping(value="/selectSendEmail",
	// produces={"application/json;charset=UTF-8"})
	// public @ResponseBody String selectSendEmail(HttpServletRequest request,
	// HttpServletResponse response) throws Exception{
	// Map<String,Object> maps = new HashMap<String, Object>();
	//
	// List<EmailBody> listSendEmail=emailService.listSendEmail(maps, 1, 3,
	// true);
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
	// tojson.setObj(listSendEmail);
	// loger.info("结果信息：" + JSON.toJSONStringWithDateFormat(listSendEmail,
	// "yyyy-MM-dd HH:mm:ss"));
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("selectAllEmail", JSON.toJSONStringWithDateFormat(listSendEmail,
	// "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }
	//
	// /**
	// * 废纸篓查询
	// * @throws Exception
	// */
	// @RequestMapping(value="/listWastePaperbasket",
	// produces={"application/json;charset=UTF-8"})
	// public @ResponseBody String listWastePaperbasket(HttpServletRequest
	// request, HttpServletResponse response) throws Exception{
	// Map<String,Object> maps = new HashMap<String, Object>();
	// List<EmailBody>
	// listWastePaperbasketEmail=emailService.listWastePaperbasket(maps, 1, 3,
	// true);
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
	// tojson.setObj(listWastePaperbasketEmail);
	// loger.info("结果信息：" +
	// JSON.toJSONStringWithDateFormat(listWastePaperbasketEmail,
	// "yyyy-MM-dd HH:mm:ss"));
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("selectAllEmail",
	// JSON.toJSONStringWithDateFormat(listWastePaperbasketEmail,
	// "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }
	//
	// /**
	// * 多条件查询邮件
	// * @throws Exception
	// *
	// */
	// @RequestMapping(value = "/querylistEmailBody", produces = {
	// "application/json;charset=UTF-8" })
	// public @ResponseBody String querylistEmailBody() throws Exception {
	// /**
	// * 对传进来的时间进行转换
	// */
	// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// Date date1 = format.parse("2010-01-06 11:45:55");
	// Date date2=format.parse("2011-01-06 11:45:55");
	// Integer starttime = new Integer((int) (date1.getTime()));
	// Integer endtime=new Integer((int)(date2.getTime()));
	// /**
	// * 将条件参数存入map集合
	// */
	// Map<String,Object> maps = new HashMap<String, Object>();
	// maps.put("startTime",starttime);
	// maps.put("endTime", endtime);
	// maps.put("readFlag",1);
	// maps.put("boxId",0);
	// maps.put("userName","李佳");
	// maps.put("sign","");
	// maps.put("keyword","通知");
	// List<EmailBody> listEmailBody = emailService.selectEmailBody(maps, 1,10,
	// true);
	// loger.info("结果信息：" + JSON.toJSONStringWithDateFormat(listEmailBody,
	// "yyyy-MM-dd HH:mm:ss"));
	// if(listEmailBody.size()>0){
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "查询成功");
	// tojson.setObj(listEmailBody);
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("listqueryEmailBody",
	// JSON.toJSONStringWithDateFormat(listEmailBody, "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }else{
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(1, "查询失败");
	// tojson.setObj(listEmailBody);
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("listqueryEmailBody",
	// JSON.toJSONStringWithDateFormat(listEmailBody, "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }
	// }

	/**
	 * 为null时转换为""
	 * 
	 * @param value
	 * @return
	 */
	public static String returnValue(String value) {
		if (value != null) {
			return value;
		} else {
			return "";
		}
	}

}
