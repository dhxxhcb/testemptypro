package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.xoa.model.email.Email;
import com.xoa.model.email.EmailBody;
import com.xoa.model.worldnews.News;
import com.xoa.service.email.EmailUtilService;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.DateFormat;

@RunWith(SpringJUnit4ClassRunner.class)     
@ContextConfiguration(locations = {"classpath:config/spring/springs-beans.xml"}) 
public class Ctest {

//	@Resource  
//	private NewService newService;
	@Resource
	private EmailUtilService emailUtilService;
	
	@Test
	public void test() throws Exception {
//		
//		 Map<String,Object> maps = new HashMap<String, Object>();
//	     maps.put("typeId", null);
//	     maps.put("newsTime", null);
//	    List<News> page = newService.selectNews(maps, 1, 5, true);
//		System.out.println(JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss"));
		
		
		EmailBody emailBody = new EmailBody();
		emailBody.setBodyId(17);
		emailBody.setFromId("admin");
		emailBody.setToId2(
				"liumingcai,liuyingwu,wangyun,changbai,chenchangliu,chenqiang,lichang,liuyongkang,liuna,wangde,litian,wuhai,lihai,zhangshan,");
		emailBody.setCopyToId("wangde,zhaomin,");
		emailBody.setSecretToId("liuna,");
		emailBody.setSubject("会议：13增强版内部发布测试大会");
		emailBody.setContent("通知您于2013-10-22 13:30在一号大会议室开会，会议名称：13增强版内部发布测试大会");
		emailBody.setSendTime(DateFormat.getTime("2017-4-9 10:20:36"));
		emailBody.setAttachmentId("");
		emailBody.setAttachmentName("");
		emailBody.setSendFlag("1");
		emailBody.setSmsRemind("0");
		// 重要程度(空-一般邮件,1-重要,2-非常重要)
		emailBody.setImportant("");
		emailBody.setSize((long) 0);
		emailBody.setFromWebmailId(0);
		emailBody.setFromWebmail("");
		emailBody.setToWebmail("");
		emailBody.setCompressContent(new byte[0]);
		emailBody.setWebmailContent(new byte[0]);
		emailBody.setWebmailFlag("0");
		emailBody.setRecvFromName("");
		emailBody.setRecvFrom("");
		emailBody.setRecvToId(0);
		emailBody.setRecvTo("");
		emailBody.setIsWebmail("0");
		emailBody.setIsWf("0");
		emailBody.setKeyword("项目,项目,训练营,精英,魔鬼");
		// 标识符 未定义
		emailBody.setSecretLevel(0);
		// 审核人 需要明确关系
		emailBody.setAuditMan("");
		// 审核不通过备注 需明确
		emailBody.setAuditRemark("");
		// 抄送外部邮箱串 需明确
		emailBody.setCopyToWebmail("");
		// 密送外部邮箱串 需明确
		emailBody.setSecretToWebmail("");
		// 点赞人 需明确
		emailBody.setPraise("");
		Email email = new Email();
		email.setEmailId(241);
		email.setReadFlag("");
		// 邮件删除状态
		email.setDeleteFlag("");
		// 邮件箱分类ID 需明确
		email.setBoxId(0);
		// 邮件体ID 需明确
		email.setBodyId(0);
		email.setReceipt("");
		// 需明确关系 显示不能为空
		email.setIsF("");
		// 需明确关系 显示不能为空
		email.setIsR("");
		// 显示不能为空
		email.setSign("");
		emailUtilService.sendEmail(emailBody, email);
		
	}

}
