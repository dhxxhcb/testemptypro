package com.xoa.controller.email;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xoa.model.email.EmailModel;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.service.email.EmailService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;

/**
 * 
 * @ClassName (类名):  EmailUtilController
 * @Description(简述): 邮件
 * @author(作者):      zy
 * @date(日期):        2017-4-17 下午5:34:30
 *
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/email")
public class EmailController {
	private Logger loger = Logger.getLogger(EmailController.class);

	@Resource
	private EmailService emailService;

	/**
	 * 
	 * @Title: insertEmailBody
	 * @Description: 发送邮件并保存
	 * @author(作者): zy
	 * @param: @param fromId 发件人USER_ID,如(lisi,zhangsan,)
	 * @param: @param toId2 收件人 USER_ID串，每个ID后带一个逗号，如：(lisi,zhangsan,)
	 * @param: @param copyToId 抄送人USER_ID串,如(lisi,zhangsan,)
	 * @param: @param subject 邮件主题
	 * @param: @param content 邮件内容
	 * @param: @param sendTime 发送时间,如：2017-04-04 10:20:35
	 * @param: @param attachmentName 附件文件名串
	 * @param: @param secretToId 密送人USER_ID串,如(lisi,zhangsan,)
	 * @param: @param attachmentId 附件ID串
	 * @param: @param sendFlag 是否已发送(0-未发送,1-已发送)
	 * @param: @param smsRemind 是否使用短信提醒(0-不提醒,1-提醒)
	 * @param: @param important 重要程度(空-一般邮件,1-重要,2-非常重要)
	 * @param: @param size 邮件大小
	 * @param: @param fromWebmailId 从自己的哪个外部邮箱ID对应emailbox中id
	 * @param: @param fromWebmail 从自己的哪个外部邮箱向外发送
	 * @param: @param toWebmail 外部收件人邮箱串
	 * @param: @param compressContent 压缩后的邮件内容
	 * @param: @param webmailContent 外部邮件内容
	 * @param: @param webmailFlag 外部邮件标记(0-未发送,1-正在准备发送,2-发送成功,3-发送失败)
	 * @param: @param recvFromName 接收外部邮箱名称
	 * @param: @param recvFrom 接收外部邮箱ID
	 * @param: @param recvToId 发送外部邮件ID
	 * @param: @param recvTo 发送外部邮箱名称
	 * @param: @param isWebmail 是否为外部邮件(0-内部邮件,1-外部邮件)
	 * @param: @param isWf 是否同时外发(0-不外发,1-勾选向此人发送外部邮件)
	 * @param: @param keyword 内容关键词
	 * @param: @param secretLevel 邮件密级等级
	 * @param: @param auditMan 审核人USER_ID
	 * @param: @param auditRemark 审核不通过备注
	 * @param: @param copyToWebmail 抄送外部邮箱串
	 * @param: @param secretToWebmail 抄送外部邮箱串
	 * @param: @param praise 点赞人user_id串
	 * @param: @return
	 * @return: String Json串
	 * @throws
	 */
	@RequestMapping(value = "/sendEmail", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String insertEmailBody(
			@RequestParam(value = "fromId") String fromId,
			@RequestParam(value = "toId2", required = false) String toId2,
			@RequestParam(value = "copyToId", required = false) String copyToId,
			@RequestParam(value = "subject", required = false) String subject,
			@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "attachmentName", required = false) String attachmentName,
			@RequestParam(value = "secretToId", required = false) String secretToId,
			@RequestParam(value = "attachmentId", required = false) String attachmentId,
			@RequestParam(value = "smsRemind", required = false) String smsRemind,
			@RequestParam(value = "important", required = false) String important,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "fromWebmailId", required = false) String fromWebmailId,
			@RequestParam(value = "fromWebmail", required = false) String fromWebmail,
			@RequestParam(value = "toWebmail", required = false) String toWebmail,
			@RequestParam(value = "compressContent", required = false) String compressContent,
			@RequestParam(value = "webmailContent", required = false) String webmailContent,
			@RequestParam(value = "webmailFlag", required = false) String webmailFlag,
			@RequestParam(value = "recvFromName", required = false) String recvFromName,
			@RequestParam(value = "recvFrom", required = false) String recvFrom,
			@RequestParam(value = "recvToId", required = false) String recvToId,
			@RequestParam(value = "recvTo", required = false) String recvTo,
			@RequestParam(value = "isWebmail", required = false) String isWebmail,
			@RequestParam(value = "isWf", required = false) String isWf,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "secretLevel", required = false) String secretLevel,
			@RequestParam(value = "auditMan", required = false) String auditMan,
			@RequestParam(value = "auditRemark", required = false) String auditRemark,
			@RequestParam(value = "copyToWebmail", required = false) String copyToWebmail,
			@RequestParam(value = "secretToWebmail", required = false) String secretToWebmail,
			@RequestParam(value = "praise", required = false) String praise) {
		try {
				emailService.sendEmail(this.returnObj(fromId, toId2, copyToId, subject, content, attachmentName, new Date(), "1", secretToId, attachmentId, smsRemind, important, size, fromWebmailId, fromWebmail, toWebmail, compressContent, webmailContent, webmailFlag, recvFromName, recvFrom, recvToId, recvTo, isWebmail, isWf, keyword, secretLevel, auditMan, auditRemark, copyToWebmail, secretToWebmail, praise)
						, new EmailModel());
			return JSON.toJSONStringWithDateFormat(new ToJson<EmailBodyModel>(0,
					"ok"), "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			loger.debug("sendMail:" + e);
			return JSON.toJSONStringWithDateFormat(new ToJson<EmailBodyModel>(1,
					"errorSendEmail"), "yyyy-MM-dd HH:mm:ss");
		}
	}

	//草稿箱
	@RequestMapping(value = "/saveEmail", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String saveEmailBody(
			@RequestParam(value = "fromId") String fromId,
			@RequestParam(value = "toId2", required = false) String toId2,
			@RequestParam(value = "copyToId", required = false) String copyToId,
			@RequestParam(value = "subject", required = false) String subject,
			@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "attachmentName", required = false) String attachmentName,
			@RequestParam(value = "secretToId", required = false) String secretToId,
			@RequestParam(value = "attachmentId", required = false) String attachmentId,
			@RequestParam(value = "smsRemind", required = false) String smsRemind,
			@RequestParam(value = "important", required = false) String important,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "fromWebmailId", required = false) String fromWebmailId,
			@RequestParam(value = "fromWebmail", required = false) String fromWebmail,
			@RequestParam(value = "toWebmail", required = false) String toWebmail,
			@RequestParam(value = "compressContent", required = false) String compressContent,
			@RequestParam(value = "webmailContent", required = false) String webmailContent,
			@RequestParam(value = "webmailFlag", required = false) String webmailFlag,
			@RequestParam(value = "recvFromName", required = false) String recvFromName,
			@RequestParam(value = "recvFrom", required = false) String recvFrom,
			@RequestParam(value = "recvToId", required = false) String recvToId,
			@RequestParam(value = "recvTo", required = false) String recvTo,
			@RequestParam(value = "isWebmail", required = false) String isWebmail,
			@RequestParam(value = "isWf", required = false) String isWf,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "secretLevel", required = false) String secretLevel,
			@RequestParam(value = "auditMan", required = false) String auditMan,
			@RequestParam(value = "auditRemark", required = false) String auditRemark,
			@RequestParam(value = "copyToWebmail", required = false) String copyToWebmail,
			@RequestParam(value = "secretToWebmail", required = false) String secretToWebmail,
			@RequestParam(value = "praise", required = false) String praise) {
		try {
				emailService.saveEmail(this.returnObj(fromId, toId2, copyToId, subject, content, attachmentName, new Date(), "0", secretToId, attachmentId, smsRemind, important, size, fromWebmailId, fromWebmail, toWebmail, compressContent, webmailContent, webmailFlag, recvFromName, recvFrom, recvToId, recvTo, isWebmail, isWf, keyword, secretLevel, auditMan, auditRemark, copyToWebmail, secretToWebmail, praise)
						);
			return JSON.toJSONStringWithDateFormat(new ToJson<EmailBodyModel>(0,
					"ok"), "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			loger.debug("sendMail:" + e);
			return JSON.toJSONStringWithDateFormat(new ToJson<EmailBodyModel>(1,
					"errorSendEmail"), "yyyy-MM-dd HH:mm:ss");
		}
	}
	
	
	/**
	 * 
	 * @Title: queryEmail
	 * @Description: 邮件查询
	 * @author(作者):      zy
	 * @param: @param  request inbox 收件箱 drafts 草稿箱 outbox 发件箱 recycle 废纸篓 noRead 未读
	 * @param: @return 字符串
	 * @param: @throws Exception   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/showEmail", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String queryEmail(HttpServletRequest request) throws Exception {
		String flag = ServletRequestUtils.getStringParameter(request, "flag");
		Integer page = ServletRequestUtils.getIntParameter(request, "page");
		Integer pageSize = ServletRequestUtils.getIntParameter(request,
				"pageSize");
		boolean useFlag = ServletRequestUtils.getBooleanParameter(request,
				"useFlag");
		String userId = ServletRequestUtils.getStringParameter(request,
				"userID");
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("fromId", userId);
		List<EmailBodyModel> list = new ArrayList<EmailBodyModel>();
		if (flag.trim().equals("inbox")) {
			list = emailService.selectInbox(maps, page, pageSize, useFlag);
		} else if (flag.trim().equals("drafts")) {
			list = emailService.listDrafts(maps, page, pageSize, useFlag);
		} else if (flag.trim().equals("outbox")) {
			list = emailService.listSendEmail(maps, page, pageSize, useFlag);
		} else if (flag.trim().equals("recycle")) {
			list = emailService.listWastePaperbasket(maps, page, pageSize,
					useFlag);
		} else if (flag.trim().equals("noRead")) {
			list = emailService.selectIsRead(maps, page, pageSize, useFlag);
		}
		String returnRes = null;
		int length = list.size();
		if (length > 0) {
			ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(0, "有数据");
			tojson.setObj(list);
			returnRes = JSON.toJSONStringWithDateFormat(tojson,
					"yyyy-MM-dd HH:mm:ss");
		} else {
			ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(1, "无数据");
			returnRes = JSON.toJSONStringWithDateFormat(tojson,
					"yyyy-MM-dd HH:mm:ss");
		}
		return returnRes;
	}

	/**
	 * 
	 * @Title: queryByID
	 * @Description: 根据ID查询内容
	 * @author(作者):      zy
	 * @param: @param request Http请求
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/queryByID", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String queryByID(HttpServletRequest request) throws Exception {
		String userId = ServletRequestUtils.getStringParameter(request,
				"userID");
		Integer bodyId = ServletRequestUtils.getIntParameter(request, "bodyId");
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("fromId", userId);
		maps.put("bodyId", bodyId);
		EmailBodyModel emailBody = emailService.queryById(maps, 1, 5, false);
		String returnRes = null;
		if (emailBody.getBodyId() != null) {
			ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(0, "查询成功");
			tojson.setObject(emailBody);
			returnRes = JSON.toJSONStringWithDateFormat(tojson,
					"yyyy-MM-dd HH:mm:ss");
		} else {
			ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(1, "查询失败");
			returnRes = JSON.toJSONStringWithDateFormat(tojson,
					"yyyy-MM-dd HH:mm:ss");
		}
		return returnRes;
	}

	
	/**
	 * 
	 * @Title: isRead
	 * @Description: 未读更新为已读
	 * @author(作者):      zy
	 * @param: @param request Http请求
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/isRead", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String isRead(HttpServletRequest request) throws Exception {
		String userId = ServletRequestUtils.getStringParameter(request,
				"userID");
		Integer bodyId = ServletRequestUtils.getIntParameter(request, "bodyId");
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("fromId", userId);
		maps.put("bodyId", bodyId);
		EmailBodyModel emailBody = emailService.queryById(maps, 1, 5, false);
		String returnRes = null;
		if (emailBody.getBodyId() != null) {
			ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(0, "查询成功");
			tojson.setObject(emailBody);
			returnRes = JSON.toJSONStringWithDateFormat(tojson,
					"yyyy-MM-dd HH:mm:ss");
		} else {
			ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(1, "查询失败");
			returnRes = JSON.toJSONStringWithDateFormat(tojson,
					"yyyy-MM-dd HH:mm:ss");
		}
		return returnRes;
	}

	/**
	 * 
	 * @Title: querylistEmailBody
	 * @Description: 多条件查询邮件
	 * @author(作者):      zy
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: String   
	 * @throws
	 */
	@RequestMapping(value = "/querylistEmailBody", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String querylistEmailBody() throws Exception {
		Map<String, Object> maps = new HashMap<String, Object>();
		// maps.put("startTime",starttime);
		// maps.put("endTime", endtime);
		maps.put("readFlag", 1);
		maps.put("boxId", 0);
		maps.put("userName", "李佳");
		maps.put("sign", "");
		maps.put("keyword", "通知");
		List<EmailBodyModel> listEmailBody = emailService.selectEmailBody(maps, 1,
				10, true);
		loger.info("结果信息："
				+ JSON.toJSONStringWithDateFormat(listEmailBody,
						"yyyy-MM-dd HH:mm:ss"));
		if (listEmailBody.size() > 0) {
			ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(0, "查询成功");
			tojson.setObj(listEmailBody);
			Map<String, String> map = new HashMap<String, String>();
			map.put("listqueryEmailBody", JSON.toJSONStringWithDateFormat(
					listEmailBody, "yyyy-MM-dd HH:mm:ss"));
			return JSON.toJSONStringWithDateFormat(tojson,
					"yyyy-MM-dd HH:mm:ss");
		} else {
			ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(1, "查询失败");
			tojson.setObj(listEmailBody);
			Map<String, String> map = new HashMap<String, String>();
			map.put("listqueryEmailBody", JSON.toJSONStringWithDateFormat(
					listEmailBody, "yyyy-MM-dd HH:mm:ss"));
			return JSON.toJSONStringWithDateFormat(tojson,
					"yyyy-MM-dd HH:mm:ss");
		}
	}

	/**
	 * 
	 * @Title: returnValue
	 * @Description: 为null时转换为""
	 * @author(作者):      zy
	 * @param: @param value  需转换字符串
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public static String returnValue(String value) {
		if (value != null) {
			return value;
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @Title: returnObj
	 * @Description: 邮件获取参数封装方法
	 * @author(作者): zy
	 * @param: @param fromId 发件人USER_ID,如(lisi,zhangsan,)
	 * @param: @param toId2 收件人 USER_ID串，每个ID后带一个逗号，如：(lisi,zhangsan,)
	 * @param: @param copyToId 抄送人USER_ID串,如(lisi,zhangsan,)
	 * @param: @param subject 邮件主题
	 * @param: @param content 邮件内容
	 * @param: @param sendTime 发送时间,如：2017-04-04 10:20:35
	 * @param: @param attachmentName 附件文件名串
	 * @param: @param secretToId 密送人USER_ID串,如(lisi,zhangsan,)
	 * @param: @param attachmentId 附件ID串
	 * @param: @param sendFlag 是否已发送(0-未发送,1-已发送)
	 * @param: @param smsRemind 是否使用短信提醒(0-不提醒,1-提醒)
	 * @param: @param important 重要程度(空-一般邮件,1-重要,2-非常重要)
	 * @param: @param size 邮件大小
	 * @param: @param fromWebmailId 从自己的哪个外部邮箱ID对应emailbox中id
	 * @param: @param fromWebmail 从自己的哪个外部邮箱向外发送
	 * @param: @param toWebmail 外部收件人邮箱串
	 * @param: @param compressContent 压缩后的邮件内容
	 * @param: @param webmailContent 外部邮件内容
	 * @param: @param webmailFlag 外部邮件标记(0-未发送,1-正在准备发送,2-发送成功,3-发送失败)
	 * @param: @param recvFromName 接收外部邮箱名称
	 * @param: @param recvFrom 接收外部邮箱ID
	 * @param: @param recvToId 发送外部邮件ID
	 * @param: @param recvTo 发送外部邮箱名称
	 * @param: @param isWebmail 是否为外部邮件(0-内部邮件,1-外部邮件)
	 * @param: @param isWf 是否同时外发(0-不外发,1-勾选向此人发送外部邮件)
	 * @param: @param keyword 内容关键词
	 * @param: @param secretLevel 邮件密级等级
	 * @param: @param auditMan 审核人USER_ID
	 * @param: @param auditRemark 审核不通过备注
	 * @param: @param copyToWebmail 抄送外部邮箱串
	 * @param: @param secretToWebmail 抄送外部邮箱串
	 * @param: @param praise 点赞人user_id串
	 * @return: EmailBody   
	 * @throws
	 */
	@SuppressWarnings("static-access")
	public  EmailBodyModel returnObj(String fromId, String toId2, String copyToId,
			 String subject,String content,String attachmentName,
			 Date sendTime,String sendFlag,String secretToId,
			 String attachmentId, String smsRemind,String important,
			 String size,String fromWebmailId,String fromWebmail, String toWebmail,
			 String compressContent,String webmailContent,String webmailFlag,
			 String recvFromName,String recvFrom, String recvToId,
			 String recvTo,String isWebmail, String isWf, String keyword,
			 String secretLevel, String auditMan, String auditRemark,
			 String copyToWebmail,String secretToWebmail,String praise){
		EmailBodyModel emailBody = new EmailBodyModel();
		emailBody.setFromId(this.returnValue(fromId));
		emailBody.setToId2(this.returnValue(toId2));
		emailBody.setCopyToId(this.returnValue(copyToId));
		emailBody.setSecretToId(this.returnValue(secretToId));
		emailBody.setSubject(this.returnValue(subject));
		emailBody.setContent(this.returnValue(content));
		emailBody.setSendTime(DateFormat.getTime(DateFormat.getStrDate(sendTime)));
		emailBody.setAttachmentId(this.returnValue(attachmentId));
		emailBody.setAttachmentName(this.returnValue(attachmentName));
		emailBody.setSendFlag(this.returnValue(sendFlag));
		emailBody.setSmsRemind("0");
		emailBody.setImportant(this.returnValue(important));
		emailBody.setSize(0L);
		emailBody.setFromWebmailId(0);
		emailBody.setFromWebmail(this.returnValue(fromWebmail));
		emailBody.setToWebmail(this.returnValue(toWebmail));
		emailBody.setCompressContent(new byte[0]);
		emailBody.setWebmailContent(new byte[0]);
		emailBody.setWebmailFlag("0");
		emailBody.setRecvFromName(this.returnValue(recvFromName));
		emailBody.setRecvFrom(this.returnValue(recvFrom));
		emailBody.setRecvToId(0);
		emailBody.setRecvTo(this.returnValue(recvTo));
		emailBody.setIsWebmail("0");
		emailBody.setIsWf("0");
		emailBody.setKeyword(this.returnValue(keyword));
		if (secretLevel == null) {
			emailBody.setSecretLevel(0);
		} else {
			emailBody.setSecretLevel(Integer.valueOf(secretLevel));
		}
		emailBody.setAuditMan(this.returnValue(auditMan));
		emailBody.setAuditRemark(this.returnValue(auditRemark));
		emailBody.setCopyToWebmail(this.returnValue(copyToWebmail));
		emailBody.setSecretToWebmail(this.returnValue(secretToWebmail));
		emailBody.setPraise(this.returnValue(praise));
		return emailBody;
	}
	

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
	// public @ResponseBody
	// String queryById(HttpServletRequest request, HttpServletResponse
	// response) {
	// EmailBody emailBody = emailService.queryById(1);
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
	// tojson.setObject(emailBody);
	// loger.info("结果信息："
	// + JSON.toJSONStringWithDateFormat(emailBody,
	// "yyyy-MM-dd HH:mm:ss"));
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("queryById", JSON.toJSONStringWithDateFormat(emailBody,
	// "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }

	// /**
	// * 草稿箱查询
	// *
	// * @throws Exception
	// */
	// @RequestMapping(value = "/listDrafts", produces = {
	// "application/json;charset=UTF-8" })
	// public @ResponseBody
	// String listDrafts(HttpServletRequest request, HttpServletResponse
	// response)
	// throws Exception {
	// Map<String, Object> maps = new HashMap<String, Object>();
	// List<EmailBody> listSelectDrafts = emailService.listDrafts(maps, 1, 3,
	// true);
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
	// tojson.setObj(listSelectDrafts);
	// loger.info("结果信息："
	// + JSON.toJSONStringWithDateFormat(listSelectDrafts,
	// "yyyy-MM-dd HH:mm:ss"));
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("selectAllEmail", JSON.toJSONStringWithDateFormat(
	// listSelectDrafts, "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }
	//
	// /**
	// * 发件箱查询
	// *
	// * @throws Exception
	// */
	// @RequestMapping(value = "/selectInbox", produces = {
	// "application/json;charset=UTF-8" })
	// public @ResponseBody
	// String selectInbox(HttpServletRequest request, HttpServletResponse
	// response)
	// throws Exception {
	// Map<String, Object> maps = new HashMap<String, Object>();
	//
	// List<EmailBody> listInbox = emailService.selectInbox(maps, 1, 3, true);
	//
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
	// tojson.setObj(listInbox);
	// loger.info("结果信息："
	// + JSON.toJSONStringWithDateFormat(listInbox,
	// "yyyy-MM-dd HH:mm:ss"));
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("selectAllEmail", JSON.toJSONStringWithDateFormat(listInbox,
	// "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }
	//
	// /**
	// * 已发送查询
	// *
	// * @throws Exception
	// */
	// @RequestMapping(value = "/selectSendEmail", produces = {
	// "application/json;charset=UTF-8" })
	// public @ResponseBody
	// String selectSendEmail(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// Map<String, Object> maps = new HashMap<String, Object>();
	//
	// List<EmailBody> listSendEmail = emailService.listSendEmail(maps, 1, 3,
	// true);
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
	// tojson.setObj(listSendEmail);
	// loger.info("结果信息："
	// + JSON.toJSONStringWithDateFormat(listSendEmail,
	// "yyyy-MM-dd HH:mm:ss"));
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("selectAllEmail", JSON.toJSONStringWithDateFormat(
	// listSendEmail, "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }
	//
	// /**
	// * 废纸篓查询
	// *
	// * @throws Exception
	// */
	// @RequestMapping(value = "/listWastePaperbasket", produces = {
	// "application/json;charset=UTF-8" })
	// public @ResponseBody
	// String listWastePaperbasket(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// Map<String, Object> maps = new HashMap<String, Object>();
	// List<EmailBody> listWastePaperbasketEmail = emailService
	// .listWastePaperbasket(maps, 1, 3, true);
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
	// tojson.setObj(listWastePaperbasketEmail);
	// loger.info("结果信息："
	// + JSON.toJSONStringWithDateFormat(listWastePaperbasketEmail,
	// "yyyy-MM-dd HH:mm:ss"));
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("selectAllEmail", JSON.toJSONStringWithDateFormat(
	// listWastePaperbasketEmail, "yyyy-MM-dd HH:mm:ss"));
	// return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	// }

	// /**
	// * 邮件查询
	// * fromId 发件人USER_ID
	// * sendFlag 是否已发送(0-未发送,1-已发送)
	// * deleteFlag 删除标识符
	// * startTime 开始时间区间
	// * endTime 结束时间区间
	// * readFlag 是否已读 boxId 邮件箱分类ID sign
	// * 星标标记(0-无,1-灰,2-绿,3-黄,4-红)
	// * keyword 内容关键词
	// */
	// @RequestMapping(value = "/showEmail", produces = {
	// "application/json;charset=UTF-8" })
	// public @ResponseBody String queryEmail(HttpServletRequest request) throws
	// Exception {
	// Integer page = ServletRequestUtils.getIntParameter(request, "page");
	// Integer pageSize =
	// ServletRequestUtils.getIntParameter(request,"pageSize");
	// boolean useFlag =
	// ServletRequestUtils.getBooleanParameter(request,"useFlag");
	// Map<String, Object> maps = new HashMap<String, Object>();
	// maps.put("fromId",ServletRequestUtils.getStringParameter(request,
	// "fromId"));
	// maps.put("sendFlag",ServletRequestUtils.getStringParameter(request,
	// "sendFlag"));
	// maps.put("firstFlag",ServletRequestUtils.getStringParameter(request,
	// "firstFlag"));
	// maps.put("secondFlag",ServletRequestUtils.getStringParameter(request,
	// "secondFlag"));
	// String startTime =
	// ServletRequestUtils.getStringParameter(request,"startTime");
	// String endTime =
	// ServletRequestUtils.getStringParameter(request,"endTime");
	// if (startTime != null && startTime != "" && endTime != null && endTime !=
	// "") {
	// maps.put("startTime", DateFormat.getTime(startTime));
	// maps.put("endTime", DateFormat.getTime(endTime));
	// }
	// maps.put("readFlag",ServletRequestUtils.getStringParameter(request,
	// "readFlag"));
	// maps.put("boxId", ServletRequestUtils.getIntParameter(request, "boxId"));
	// maps.put("sign",ServletRequestUtils.getStringParameter(request, "sign"));
	// maps.put("keyword", ServletRequestUtils.getStringParameter(request,
	// "keyword"));
	// List<EmailBody> list = emailService.selectEmail(maps, page,
	// pageSize,useFlag);
	// int listLength = list.size();
	// if (listLength > 0) {
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "查询成功");
	// tojson.setObj(list);
	// return JSON.toJSONStringWithDateFormat(tojson,"yyyy-MM-dd HH:mm:ss");
	// } else {
	// ToJson<EmailBody> tojson = new ToJson<EmailBody>(1, "查询失败");
	// return JSON.toJSONStringWithDateFormat(tojson,"yyyy-MM-dd HH:mm:ss");
	// }
	// }

}