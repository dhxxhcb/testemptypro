package com.xoa.controller.email;

import com.alibaba.fastjson.JSON;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.email.EmailModel;
import com.xoa.service.email.EmailService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;
import com.xoa.util.common.L;
import com.xoa.util.common.StringUtils;
import com.xoa.util.dataSource.ContextHolder;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午10:32:14
 * 类介绍  :   邮件
 * 构造参数:   
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
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:33:59
	 * 方法介绍:   发送邮件并保存
	 * 参数说明:	   @param fromId 发件人USER_ID,如(lisi,zhangsan,)
	 * 参数说明:      @param toId2 收件人 USER_ID串，每个ID后带一个逗号，如：(lisi,zhangsan,)
	 * 参数说明:      @param copyToId 抄送人USER_ID串,如(lisi,zhangsan,)
	 * 参数说明:      @param subject 邮件主题
	 * 参数说明:      @param content 邮件内容
	 * 参数说明:      @param sendTime 发送时间,如：2017-04-04 10:20:35
	 * 参数说明:      @param attachmentName 附件文件名串
	 * 参数说明:      @param secretToId 密送人USER_ID串,如(lisi,zhangsan,)
	 * 参数说明:      @param attachmentId 附件ID串
	 * 参数说明:      @param sendFlag 是否已发送(0-未发送,1-已发送)
	 * 参数说明:      @param smsRemind 是否使用短信提醒(0-不提醒,1-提醒)
	 * 参数说明:      @param important 重要程度(空-一般邮件,1-重要,2-非常重要)
	 * 参数说明:      @param size 邮件大小
	 * 参数说明:      @param fromWebmailId 从自己的哪个外部邮箱ID对应emailbox中id
	 * 参数说明:      @param fromWebmail 从自己的哪个外部邮箱向外发送
	 * 参数说明:      @param toWebmail 外部收件人邮箱串
	 * 参数说明:      @param compressContent 压缩后的邮件内容
	 * 参数说明:      @param webmailContent 外部邮件内容
	 * 参数说明:      @param webmailFlag 外部邮件标记(0-未发送,1-正在准备发送,2-发送成功,3-发送失败)
	 * 参数说明:      @param recvFromName 接收外部邮箱名称
	 * 参数说明:      @param recvFrom 接收外部邮箱ID
	 * 参数说明:      @param recvToId 发送外部邮件ID
	 * 参数说明:      @param recvTo 发送外部邮箱名称
	 * 参数说明:      @param isWebmail 是否为外部邮件(0-内部邮件,1-外部邮件)
	 * 参数说明:      @param isWf 是否同时外发(0-不外发,1-勾选向此人发送外部邮件)
	 * 参数说明:      @param keyword 内容关键词
	 * 参数说明:      @param secretLevel 邮件密级等级
	 * 参数说明:      @param auditMan 审核人USER_ID
	 * 参数说明:      @param auditRemark 审核不通过备注
	 * 参数说明:      @param copyToWebmail 抄送外部邮箱串
	 * 参数说明:      @param secretToWebmail 抄送外部邮箱串
	 * 参数说明:      @param praise 点赞人user_id串
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/sendEmail", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	ToJson<EmailBodyModel> insertEmailBody(
			@RequestParam(value = "fromId") String fromId,
			@RequestParam(value = "toId2", required = false) String toId2,
			@RequestParam(value = "copyToId", required = false) String copyToId,
			@RequestParam(value = "subject", required = false) String subject,
			@RequestParam(value = "content", required = false) String content,
//			@RequestParam(value = "file",required = false) MultipartFile[] files,
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
			@RequestParam(value = "praise", required = false) String praise,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		try {
				emailService.sendEmail(
						this.returnObj(fromId, toId2, copyToId, subject, content, attachmentName, attachmentId, new Date(), "1", secretToId, smsRemind, important, size, fromWebmailId, fromWebmail, toWebmail, compressContent, webmailContent, webmailFlag, recvFromName, recvFrom, recvToId, recvTo, isWebmail, isWf, keyword, secretLevel, auditMan, auditRemark, copyToWebmail, secretToWebmail, praise)
						, new EmailModel());
			return new ToJson<EmailBodyModel>(0,
					"ok");
		} catch (Exception e) {
			loger.debug("sendMail:" + e);
			return new ToJson<EmailBodyModel>(1,
					"errorSendEmail");
		}
	}

	/**
	 * 
	 * 创建作者:      张勇
	 * 创建日期:      2017-4-18 下午2:11:13
	 * 类介绍:       保存草稿箱
	 * 参数说明:	   @param fromId 发件人USER_ID,如(lisi,zhangsan,)
	 * 参数说明:      @param toId2 收件人 USER_ID串，每个ID后带一个逗号，如：(lisi,zhangsan,)
	 * 参数说明:      @param copyToId 抄送人USER_ID串,如(lisi,zhangsan,)
	 * 参数说明:      @param subject 邮件主题
	 * 参数说明:      @param content 邮件内容
	 * 参数说明:      @param sendTime 发送时间,如：2017-04-04 10:20:35
	 * 参数说明:      @param attachmentName 附件文件名串
	 * 参数说明:      @param secretToId 密送人USER_ID串,如(lisi,zhangsan,)
	 * 参数说明:      @param attachmentId 附件ID串
	 * 参数说明:      @param sendFlag 是否已发送(0-未发送,1-已发送)
	 * 参数说明:      @param smsRemind 是否使用短信提醒(0-不提醒,1-提醒)
	 * 参数说明:      @param important 重要程度(空-一般邮件,1-重要,2-非常重要)
	 * 参数说明:      @param size 邮件大小
	 * 参数说明:      @param fromWebmailId 从自己的哪个外部邮箱ID对应emailbox中id
	 * 参数说明:      @param fromWebmail 从自己的哪个外部邮箱向外发送
	 * 参数说明:      @param toWebmail 外部收件人邮箱串
	 * 参数说明:      @param compressContent 压缩后的邮件内容
	 * 参数说明:      @param webmailContent 外部邮件内容
	 * 参数说明:      @param webmailFlag 外部邮件标记(0-未发送,1-正在准备发送,2-发送成功,3-发送失败)
	 * 参数说明:      @param recvFromName 接收外部邮箱名称
	 * 参数说明:      @param recvFrom 接收外部邮箱ID
	 * 参数说明:      @param recvToId 发送外部邮件ID
	 * 参数说明:      @param recvTo 发送外部邮箱名称
	 * 参数说明:      @param isWebmail 是否为外部邮件(0-内部邮件,1-外部邮件)
	 * 参数说明:      @param isWf 是否同时外发(0-不外发,1-勾选向此人发送外部邮件)
	 * 参数说明:      @param keyword 内容关键词
	 * 参数说明:      @param secretLevel 邮件密级等级
	 * 参数说明:      @param auditMan 审核人USER_ID
	 * 参数说明:      @param auditRemark 审核不通过备注
	 * 参数说明:      @param copyToWebmail 抄送外部邮箱串
	 * 参数说明:      @param secretToWebmail 抄送外部邮箱串
	 * 参数说明:      @param praise 点赞人user_id串
	 * 参数说明:      @return 
	 * @return  String json
	 */
	@RequestMapping(value = "/saveEmail", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	ToJson<EmailBodyModel> saveEmailBody(
			@RequestParam(value = "fromId") String fromId,
			@RequestParam(value = "toId2", required = false) String toId2,
			@RequestParam(value = "copyToId", required = false) String copyToId,
			@RequestParam(value = "subject", required = false) String subject,
			@RequestParam(value = "content", required = false) String content,
//			@RequestParam(value = "file",required = false) MultipartFile[] files,
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
			@RequestParam(value = "praise", required = false) String praise,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		try {
				emailService.saveEmail(
						this.returnObj(fromId, toId2, copyToId, subject, content, attachmentName, attachmentId, new Date(), "0", secretToId, smsRemind, important, size, fromWebmailId, fromWebmail, toWebmail, compressContent, webmailContent, webmailFlag, recvFromName, recvFrom, recvToId, recvTo, isWebmail, isWf, keyword, secretLevel, auditMan, auditRemark, copyToWebmail, secretToWebmail, praise)
						);
			return new ToJson<EmailBodyModel>(0,
					"ok");
		} catch (Exception e) {
			loger.debug("sendMail:" + e);
			return new ToJson<EmailBodyModel>(1,
					"errorSendEmail");
		}
	}
	
	
	
	
	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:35:16
	 * 方法介绍:   查询列表
	 * 参数说明:   @param  request inbox 收件箱 drafts 草稿箱 outbox 发件箱 recycle 废纸篓 noRead 未读
	 * 参数说明:   @return json
	 * 参数说明:   @throws Exception
	 * @return     String
	 */
	@RequestMapping(value = "/showEmail", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	ToJson<EmailBodyModel> queryEmail(HttpServletRequest request) throws Exception {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
		String flag = ServletRequestUtils.getStringParameter(request, "flag");
		Integer page = ServletRequestUtils.getIntParameter(request, "page");
		Integer pageSize = ServletRequestUtils.getIntParameter(request,
				"pageSize");
		boolean useFlag = ServletRequestUtils.getBooleanParameter(request,
				"useFlag");
		String userId= "";
		String userFrom = ServletRequestUtils.getStringParameter(request,
				"userID");
		if(StringUtils.checkNull(userFrom)){
			userId = (String)request.getSession().getAttribute("userId");
		}else{
			userId = userFrom.trim();
		}
		L.e("userId:"+userId);
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("fromId", userId);
		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
		if (flag.trim().equals("inbox")) {
			tojson = emailService.selectInbox(maps, page, pageSize, useFlag);
		} else if (flag.trim().equals("drafts")) {
			tojson = emailService.listDrafts(maps, page, pageSize, useFlag);
		} else if (flag.trim().equals("outbox")) {
			tojson = emailService.listSendEmail(maps, page, pageSize, useFlag);
		} else if (flag.trim().equals("recycle")) {
			tojson = emailService.listWastePaperbasket(maps, page, pageSize,
					useFlag);
		} else if (flag.trim().equals("noRead")) {
			tojson = emailService.selectIsRead(maps, page, pageSize, useFlag);
		}
		if (tojson.getObj().size()>0) {
			tojson.setFlag(0);
			tojson.setMsg("ok");
		} else {
			tojson.setFlag(1);
			tojson.setMsg("error");
		}
		return tojson;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:35:48
	 * 方法介绍:   根据ID查询内容
	 * 参数说明:   @param request HTTP请求
	 * 参数说明:   @return Json
	 * 参数说明:   @throws Exception
	 * @return     String
	 */
	@RequestMapping(value = "/queryByID", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
		ToJson<EmailBodyModel> queryByID(HttpServletRequest request,@RequestParam(value = "emailId",required = false) Integer emailId,@RequestParam("flag")String flag,@RequestParam(value = "bodyId",required = false) Integer bodyId) throws Exception {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));	
		Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("emailId", emailId);
			maps.put("bodyId", bodyId);
			EmailBodyModel emailBody = emailService.queryById(maps, 1, 5, false);
			ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
			if(!flag.trim().equals("isRead")){
				if (emailBody.getBodyId() != null) {
					tojson.setFlag(0);
					tojson.setMsg("ok");
					tojson.setObject(emailBody);
				} else {
					tojson.setFlag(1);
					tojson.setMsg("errorQueryByID");
				}
			}else{
				EmailModel email = new EmailModel();
				email.setEmailId(emailId);
				email.setReadFlag("1");
				emailService.updateIsRead(email);
				tojson.setFlag(0);
				tojson.setMsg("ok");
				tojson.setObject(emailBody);
			}
			return tojson;
	}

	
	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:35:16
	 * 方法介绍:   删除列表
	 * 参数说明:   @param  request inbox 收件箱  outbox 发件箱 recycle 废纸篓
	 * 参数说明:   @return json
	 * 参数说明:   @throws Exception
	 * @return     String
	 */
	@RequestMapping(value = "/deleteEmail", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody ToJson<EmailBodyModel> deleteEmail(@RequestParam("flag")String flag,@RequestParam("deleteFlag") String deleteFlag,
			@RequestParam("emailID") Integer emailId,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
		String returnRes = "";
		if (flag.trim().equals("inbox")) {
			returnRes = emailService.deleteInEmail(emailId, deleteFlag);
		} else if (flag.trim().equals("outbox")) {
			returnRes = emailService.deleteOutEmail(emailId, deleteFlag);
		} else if (flag.trim().equals("recycle")) {
			returnRes = emailService.deleteRecycleEmail(emailId, deleteFlag);
		} 
//		else if (flag.trim().equals("drafts")) {
//			emailService.deleteRecycleEmail(emailBodyModel, deleteFlag);
//		}
		if (returnRes.equals("0")) {
			tojson.setFlag(0);
			tojson.setMsg("ok");
		} else {
			tojson.setFlag(1);
			tojson.setMsg("error");
		}
		return tojson;
	}

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:35:16
     * 方法介绍:   草稿箱删除
     * 参数说明:   @param  bodyId 邮箱内容ID
     * 参数说明:   @return json
     * @return     String
     */
    @RequestMapping(value = "/deleteDraftsEmail", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ToJson<EmailBodyModel> deleteDraftsEmail(@RequestParam("bodyId") Integer bodyId,
    	HttpServletRequest request) {
    		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
    				"loginDateSouse"));
    	try {
            ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel> (0,"ok");
            emailService.deleteByID(bodyId);
           return tojson;
        }catch (Exception e){
            ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel> (1,"error");
            return  tojson;
        }
    }



	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:38:04
	 * 方法介绍:   多条件查询邮件
	 * 参数说明:   @return Json
	 * 参数说明:   @throws Exception
	 * @return     String
	 */
	@RequestMapping(value = "/querylistEmailBody", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	ToJson<EmailBodyModel> querylistEmailBody(HttpServletRequest request) throws Exception {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
		Map<String, Object> maps = new HashMap<String, Object>();
		// maps.put("startTime",starttime);
		// maps.put("endTime", endtime);
		maps.put("readFlag", 1);
		maps.put("boxId", 0);
		maps.put("userName", "李佳");
		maps.put("sign", "");
		maps.put("keyword", "通知");
		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
		tojson = emailService.selectEmailBody(maps, 1,10, true);
		if (tojson.getObj().size() > 0) {
			tojson.setFlag(0);
			tojson.setMsg("ok");
			Map<String, String> map = new HashMap<String, String>();
		} else {
			tojson.setFlag(1);
			tojson.setMsg("error");
		}
		return tojson;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:39:24
	 * 方法介绍:   为null时转换为""
	 * 参数说明:   @param value 需转换字符串
	 * 参数说明:   @return Json
	 * @return     String
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
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:40:01
	 * 方法介绍:   参数获取方法
	 * 参数说明:	   @param fromId 发件人USER_ID,如(lisi,zhangsan,)
	 * 参数说明:      @param toId2 收件人 USER_ID串，每个ID后带一个逗号，如：(lisi,zhangsan,)
	 * 参数说明:      @param copyToId 抄送人USER_ID串,如(lisi,zhangsan,)
	 * 参数说明:      @param subject 邮件主题
	 * 参数说明:      @param content 邮件内容
	 * 参数说明:      @param sendTime 发送时间,如：2017-04-04 10:20:35
	 * 参数说明:      @param attachmentName 附件文件名串
	 * 参数说明:      @param secretToId 密送人USER_ID串,如(lisi,zhangsan,)
	 * 参数说明:      @param attachmentId 附件ID串
	 * 参数说明:      @param sendFlag 是否已发送(0-未发送,1-已发送)
	 * 参数说明:      @param smsRemind 是否使用短信提醒(0-不提醒,1-提醒)
	 * 参数说明:      @param important 重要程度(空-一般邮件,1-重要,2-非常重要)
	 * 参数说明:      @param size 邮件大小
	 * 参数说明:      @param fromWebmailId 从自己的哪个外部邮箱ID对应emailbox中id
	 * 参数说明:      @param fromWebmail 从自己的哪个外部邮箱向外发送
	 * 参数说明:      @param toWebmail 外部收件人邮箱串
	 * 参数说明:      @param compressContent 压缩后的邮件内容
	 * 参数说明:      @param webmailContent 外部邮件内容
	 * 参数说明:      @param webmailFlag 外部邮件标记(0-未发送,1-正在准备发送,2-发送成功,3-发送失败)
	 * 参数说明:      @param recvFromName 接收外部邮箱名称
	 * 参数说明:      @param recvFrom 接收外部邮箱ID
	 * 参数说明:      @param recvToId 发送外部邮件ID
	 * 参数说明:      @param recvTo 发送外部邮箱名称
	 * 参数说明:      @param isWebmail 是否为外部邮件(0-内部邮件,1-外部邮件)
	 * 参数说明:      @param isWf 是否同时外发(0-不外发,1-勾选向此人发送外部邮件)
	 * 参数说明:      @param keyword 内容关键词
	 * 参数说明:      @param secretLevel 邮件密级等级
	 * 参数说明:      @param auditMan 审核人USER_ID
	 * 参数说明:      @param auditRemark 审核不通过备注
	 * 参数说明:      @param copyToWebmail 抄送外部邮箱串
	 * 参数说明:      @param secretToWebmail 抄送外部邮箱串
	 * 参数说明:      @param praise 点赞人user_id串
	 * 参数说明:      @return 对象
	 * @return     EmailBodyModel
	 */
	@SuppressWarnings("static-access")
	public  EmailBodyModel returnObj(String fromId, String toId2, String copyToId,
			 String subject,String content, String attachmentName, String attachmentId,
			 Date sendTime,String sendFlag,String secretToId,
			 String smsRemind,String important,
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
	
	
//	/**
//	 * 
//	 * @Title: isRead
//	 * @Description: 未读更新为已读
//	 * @author(作者):      zy
//	 * @param: @param request Http请求
//	 * @param: @return
//	 * @param: @throws Exception   
//	 * @return: String   
//	 * @throws
//	 */
//	@RequestMapping(value = "/isRead", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
//	public @ResponseBody
//	String isRead(HttpServletRequest request) throws Exception {
//		String userId = ServletRequestUtils.getStringParameter(request,
//				"userID");
//		Integer bodyId = ServletRequestUtils.getIntParameter(request, "bodyId");
//		Map<String, Object> maps = new HashMap<String, Object>();
//		maps.put("fromId", userId);
//		maps.put("bodyId", bodyId);
//		EmailBodyModel emailBody = emailService.queryById(maps, 1, 5, false);
//		String returnRes = null;
//		if (emailBody.getBodyId() != null) {
//			ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(0, "查询成功");
//			tojson.setObject(emailBody);
//			returnRes = JSON.toJSONStringWithDateFormat(tojson,
//					"yyyy-MM-dd HH:mm:ss");
//		} else {
//			ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(1, "查询失败");
//			returnRes = JSON.toJSONStringWithDateFormat(tojson,
//					"yyyy-MM-dd HH:mm:ss");
//		}
//		return returnRes;
//	}

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
	
	@RequestMapping("/inboxup")
	public String inboxUp(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/email/inboxup";
	}
	@RequestMapping("/addbox")
	public String writeMail(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/email/addbox";
	}
	@RequestMapping("/index")
	public String emailIndex(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/email/index";
	}
	@RequestMapping("/mailQuery")
	public String mailQuery(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/email/mailQuery";
	}
	@RequestMapping("/development")
	public String develOpment(HttpServletRequest request)
			throws Exception {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/common/development";
				}
	
}
