package com.xoa.util.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.xoa.model.email.EmailModel;
import com.xoa.model.email.EmailBodyModel;

/**
 * 
 * 创建作者:   周丽霞
 * 创建日期:   2017-4-20 上午11:05:18
 * 类介绍  :   邮箱对外发送
 * 构造参数:   
 *
 */
public class EmailUtil {
  public  Boolean sendEmailBody(EmailBodyModel emailBody,EmailModel email){
	Properties properties = new Properties();  
    properties.setProperty("mail.smtp.auth", "true");//接受服务器认证  
    properties.setProperty("mail.transport.protocol", "smtp");//设置发送协议  
    properties.setProperty("mail.host", "smtp.163.com");//设置要连接的服务器地址，端口默认25  
    Session session = Session.getInstance(properties,new Authenticator() {  //策略模式  
        @Override  
        protected PasswordAuthentication getPasswordAuthentication() { //返回用户名和密码  
            return new PasswordAuthentication("17310878569@163.com", "zlx2608877911"); //设置用户名和密码  
        }  
    });  
    session.setDebug(true); //显示调试信息  
    /** 
     * 构建邮件 
     */  
    Message msg = new MimeMessage(session); 
    try {
		//发送内容
        msg.setFrom(new InternetAddress("17310878569@163.com"));//设置发送方地址  
        msg.setSubject(emailBody.getSubject());//标题
        msg.setRecipients(RecipientType.TO, InternetAddress.parse(emailBody.getToId2())); //设置收件人的类型：TO:收件人;CC:抄送;BCC:密送送;  
        msg.setContent(emailBody.getContent(), "text/html;charset=utf-8");//设置发送内容，以及内容的类型和编码  
        /** 
         * 发送邮件 
         */  
        Transport transport=session.getTransport();
        transport.connect("smtp.163.com",25,"17310878569@163.com","zlx2608877911");//设置要连接的服务器地址、端口、用户名、密码  
        //发送
        transport.sendMessage(msg,msg.getAllRecipients());
        transport.close();
        return true;
	} catch (MessagingException e){
		e.printStackTrace();
	}
        return false;  
}
 
}
