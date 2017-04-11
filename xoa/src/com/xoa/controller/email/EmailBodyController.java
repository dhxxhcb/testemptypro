package com.xoa.controller.email;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xoa.model.email.Email;
import com.xoa.model.email.EmailBody;
import com.xoa.model.users.Users;
import com.xoa.service.email.EmailBodyService;
import com.xoa.util.ToJson;
import com.xoa.util.email.EmailUtil;

@Controller
@Scope(value = "prototype")
public class EmailBodyController {
	private Logger loger = Logger.getLogger(EmailBodyController.class);
	
	@Resource
	private EmailBodyService emailBodyService;

	/**
	 * 创建邮件
	 * 
	 */
	@RequestMapping(value = "/insertEmailBody", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody void insertEmailBody(HttpServletRequest request, HttpServletResponse response,
			  EmailBody emailBody,Email email) {
		EmailBody eb=new EmailBody();
		eb.setFromId("");
		eb.setContent("邮件内容");
	    eb.setToId2("wangyun");
	    eb.setCopyToId("zhouzhou");
	    eb.setSecretToId("misongrenid");
	    eb.setSubject("");
	    eb.setAttachmentId("");
	    Date date=new Date();
		Integer dt = new Integer((int) (date.getTime()));
	    eb.setSendTime(dt);
		eb.setAttachmentId("2");
		eb.setAttachmentName("fjn");
		eb.setFromWebmailId(45);
		eb.setFromId("sq");
		eb.setFromWebmail("qw");
		eb.setToWebmail("03");
		eb.setCompressContent(new byte[2048]);
		eb.setWebmailContent(new byte[2048]);
		eb.setRecvFromName("d");
		eb.setRecvFrom("sa");
		eb.setRecvToId(5);
		eb.setRecvTo("op");
		eb.setKeyword("邮件");
		eb.setAuditMan("f");
		eb.setAuditRemark("5");
		eb.setCopyToWebmail("fe");
		eb.setCopyToWebmail("l");
		eb.setSecretToWebmail("ed");
		eb.setPraise("ki");
		eb.setSendFlag("");
		eb.setSmsRemind("");
		eb.setImportant("");
		eb.setSize(1l);
		eb.setWebmailFlag("");
		eb.setWebmailContent(new byte[1024]);
		eb.setIsWebmail("");
		eb.setIsWf("");
		Email e=new Email();
		e.setDeleteFlag("");
		e.setBoxId(0);
		e.setIsF("0");
		e.setIsR("0");
		e.setReadFlag("0");
		e.setReceipt("0");
		e.setSign("0");
		e.setToId("wew");
		e.setBodyId(eb.getBodyId());
		emailBodyService.insert(eb,e);
	}


	/**
	 * 根据ID删除一条邮件`
	 */
	@RequestMapping(value = "/deleteEmailBody", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody void deleteEmailBody(HttpServletRequest request, HttpServletResponse response) {
		Integer bodyId = Integer.parseInt(request.getParameter("bodyId"));
		emailBodyService.deleteByPrimaryKey(bodyId);
	}
	
	/**
	 * 草稿箱查询
	 * @throws Exception 
	 */
	@RequestMapping(value="/listDrafts", produces={"application/json;charset=UTF-8"})
	public @ResponseBody String listDrafts(HttpServletRequest request, HttpServletResponse response) throws Exception{
	    Map<String,Object> maps = new HashMap<String, Object>();
		List<EmailBody> listSelectDrafts = emailBodyService.listDrafts(maps,1,3,true);
		ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
		tojson.setObj(listSelectDrafts);
		loger.info("结果信息：" + JSON.toJSONStringWithDateFormat(listSelectDrafts, "yyyy-MM-dd HH:mm:ss"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("selectAllEmail", JSON.toJSONStringWithDateFormat(listSelectDrafts, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 已发送查询
	 * @throws Exception 
	 */
	@RequestMapping(value="/selectSendEmail", produces={"application/json;charset=UTF-8"})
	public @ResponseBody String selectSendEmail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> maps = new HashMap<String, Object>();

		List<EmailBody> listSendEmail=emailBodyService.listDrafts(maps, 1, 3, true);
		ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
		tojson.setObj(listSendEmail);
		loger.info("结果信息：" + JSON.toJSONStringWithDateFormat(listSendEmail, "yyyy-MM-dd HH:mm:ss"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("selectAllEmail", JSON.toJSONStringWithDateFormat(listSendEmail, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**     
     * 废纸篓查询
	 * @throws Exception 
     */
	
	@RequestMapping(value="/listWastePaperbasket", produces={"application/json;charset=UTF-8"})
	public @ResponseBody String listWastePaperbasket(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> maps = new HashMap<String, Object>();
		List<EmailBody> listWastePaperbasketEmail=emailBodyService.listWastePaperbasket(maps, 1, 3, true);
		ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "返回结果正确");
		tojson.setObj(listWastePaperbasketEmail);
		loger.info("结果信息：" + JSON.toJSONStringWithDateFormat(listWastePaperbasketEmail, "yyyy-MM-dd HH:mm:ss"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("selectAllEmail", JSON.toJSONStringWithDateFormat(listWastePaperbasketEmail, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 多条件查询邮件
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(value = "/querylistEmailBody", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String querylistEmailBody() throws Exception {
	   /**
	    * 对传进来的时间进行转换
	    */
	   SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	   Date	date1 = format.parse("2010-01-06 11:45:55");
	   Date date2=format.parse("2011-01-06 11:45:55");
	   Integer starttime = new Integer((int) (date1.getTime()));
       Integer endtime=new Integer((int)(date2.getTime()));
       /**
        * 将条件参数存入map集合
        */
	   Map<String,Object> maps = new HashMap<String, Object>();
       maps.put("startTime",starttime);
       maps.put("endTime", endtime);
       maps.put("readFlag",1);
       maps.put("boxId",0);
       maps.put("userName","李佳");
       maps.put("sign","");
       maps.put("keyword","通知");
	   List<EmailBody> listEmailBody = emailBodyService.selectEmailBody(maps, 1,10, true);
	   loger.info("结果信息：" + JSON.toJSONStringWithDateFormat(listEmailBody, "yyyy-MM-dd HH:mm:ss"));
	   if(listEmailBody.size()>0){
		    ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "查询成功");
			tojson.setObj(listEmailBody);
			Map<String, String> map = new HashMap<String, String>();
			map.put("listqueryEmailBody", JSON.toJSONStringWithDateFormat(listEmailBody, "yyyy-MM-dd HH:mm:ss"));
			return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	   }else{
	    ToJson<EmailBody> tojson = new ToJson<EmailBody>(1, "查询失败");
		tojson.setObj(listEmailBody);
		Map<String, String> map = new HashMap<String, String>();
		map.put("listqueryEmailBody", JSON.toJSONStringWithDateFormat(listEmailBody, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(tojson, "yyyy-MM-dd HH:mm:ss");
	   }
	}

	/**
	 * 邮件发送
	 * 
	 */
	@RequestMapping(value = "/sendEmailMessage", produces = { "application/json;charset=UTF-8" })
	private @ResponseBody boolean sendEmailMessage(EmailBody emailBody,Email email) {
		// 实体类
		Email e=new Email();
		EmailBody eb = new EmailBody();
		eb.setSubject("邮件标题:呃呃呃");
		eb.setContent("本邮件为测试邮件不必回复，本邮件为测试邮件不必回复");
		eb.setToId2("373712896@qq.com");
		eb.setFromId("17310878569@163.com");
		eb.setCopyToId("179699220@qq.com");
		eb.setSecretToId("1665933493@qq.com");
		// 将Date转long，long转integer
		Date date = new Date();
		Integer dt = new Integer((int) (date.getTime()));
		eb.setSendTime(dt);
		eb.setAttachmentId("2");
		eb.setAttachmentName("fjn");
		eb.setFromWebmailId(45);
		eb.setFromId("sq");
		eb.setFromWebmail("qw");
		eb.setToWebmail("03");
		eb.setCompressContent(new byte[2048]);
		eb.setWebmailContent(new byte[2048]);
		eb.setRecvFromName("d");
		eb.setRecvFrom("sa");
		eb.setRecvToId(5);
		eb.setRecvTo("op");
		eb.setKeyword("邮件");
		eb.setAuditMan("f");
		eb.setAuditRemark("5");
		eb.setCopyToWebmail("fe");
		eb.setCopyToWebmail("l");
		eb.setSecretToWebmail("ed");
		eb.setPraise("ki");
		Users user=new Users();
		user.setEmail("17310878569@163.com");
		user.setPassword("zlx2608877911");
		eb.setUsers(user);
		EmailUtil eamilUtil=new EmailUtil();
		
		if (eamilUtil.sendEmailBody(eb,e)) {
			// 保存
			emailBodyService.insert(emailBody, email);
			return true;
		} 
		return false;
	}
}
