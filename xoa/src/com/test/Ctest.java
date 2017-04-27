package com.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
import com.xoa.util.dataSource.ContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.alibaba.fastjson.JSON;
import com.xoa.model.email.EmailModel;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.worldnews.News;
import com.xoa.service.email.EmailService;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;

@RunWith(SpringJUnit4ClassRunner.class)     
@ContextConfiguration(locations = {"classpath:config/spring/springs-beans.xml"}) 
public class Ctest {

//	@Resource  
//	private NewService newService;
	@Resource
	private EmailService emailUtilService;

    @Resource
    private UsersService usersService;
	
//	@Test
//	public void test() throws Exception {
//		Integer page = 1;
//		Integer pageSize = 5;
//		boolean useFlag = true;
//		Map<String, Object> maps = new HashMap<String, Object>();
//		maps.put("fromId","zhanglan");
//		maps.put("sendFlag","1");
//		maps.put("firstFlag","");
//		maps.put("secondFlag","");
////			maps.put("startTime", DateFormat.getTime("2015-10-10 10:10:10"));
////			maps.put("endTime", DateFormat.getTime("2017-04-12 10:10:10"));
////		maps.put("readFlag","");
////		maps.put("boxId", "");
////		maps.put("sign","");
////		maps.put("keyword","");
//		List<EmailBody> list = emailUtilService.selectEmail(maps, page, pageSize,
//				useFlag);
//		int listLength = list.size();
//		if (listLength > 0) {
//			ToJson<EmailBody> tojson = new ToJson<EmailBody>(0, "查询成功");
//			tojson.setObj(list);
//			System.out.println(JSON.toJSONStringWithDateFormat(tojson,
//					"yyyy-MM-dd HH:mm:ss"));
//		} else {
//			ToJson<EmailBody> tojson = new ToJson<EmailBody>(1, "查询失败");
//			System.out.println(JSON.toJSONStringWithDateFormat(tojson,
//					"yyyy-MM-dd HH:mm:ss"));
//		}
//	
//	}
//	
	
	@Test
	public void test() throws Exception {
		
//		ResourceBundle rb =  ResourceBundle.getBundle("jdbc-sql");
//		String name = rb.getString("mysql.driverClassName");
//		System.out.println("jieguo:"+name);
		
//        ContextHolder.setConsumerType("xoa");
//        System.out.println("类型："+ContextHolder.getConsumerType());
//                Users user=usersService.findUserByName("zhangyong");
//        ToJson<Users> json=new ToJson<Users>(0, null);
//        try {
//            if (user.getBpNo()=="") {
//                System.out.println("登录失败");
//            }else {
//                System.out.println("登录成功");
//            }
//
//        } catch (Exception e) {
//            json.setMsg(e.getMessage());
//
//        }
        
        
        
        
        
//		Map<String,Object> maps = new HashMap<String, Object>();
//		maps.put("bodyId", Integer.valueOf("11"));
//		maps.put("fromId", "zhanglan");
//		EmailBodyModel emailBody = emailUtilService.queryById(maps, 1, 5, false);
//		EmailBodyModel emailbo = new EmailBodyModel();
//
//		System.out.println("emailBody:"+!StringUtils.isEmpty(emailBody));
//		System.out.println("\n emailbo:"+emailBody.getBodyId());
//
//		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(0, "查询成功");
//		tojson.setObject(emailBody);
//
//		System.out.println(JSON.toJSONStringWithDateFormat(tojson,
//					"yyyy-MM-dd HH:mm:ss"));
		
		
//		
//		 Map<String,Object> maps = new HashMap<String, Object>();
//	     maps.put("typeId", null);
//	     maps.put("newsTime", null);
//	    List<News> page = newService.selectNews(maps, 1, 5, true);
//		System.out.println(JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss"));
		
		
		EmailBodyModel emailBody = new EmailBodyModel();
		emailBody.setFromId("admin");
		emailBody.setToId2(
				"liumingcai,liuyingwu,wangyun,changbai,chenchangliu,chenqiang,lichang,liuyongkang,liuna,wangde,litian,wuhai,lihai,zhangshan,");
		emailBody.setCopyToId("wangde,zhaomin,");
		emailBody.setSecretToId("liuna,");
		emailBody.setSubject("会议：13增强版内部发布测试大会");
		emailBody.setContent("通知您于2013-10-22 13:30在一号大会议室开会，会议名称：13增强版内部发布测试大会");
		emailBody.setSendTime(DateFormat.getTime(DateFormat.getStrDate(new Date())));
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
		EmailModel email = new EmailModel();
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
		emailUtilService.sendEmail(emailBody,null, email);
		
	}

}
