<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><fmt:message code="email.title.waitmail" /></title>
		<meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<link rel="stylesheet" type="text/css" href="../css/writeMail.css"/>
		<script src="../lib/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/writeMail.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<table border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
			<tr class="append_tr">
				<td width="10%"><fmt:message code="email.th.sender" />：</td>
				<td width="89%">
					<div class="inPole">
						<textarea name="txt" disabled></textarea>
						<span class="add_img">
							<span class="addImg">
								<img src="../img/org_select.png" class="addIcon"/>
							</span>
							<a href="javascript:;" class="Add"><fmt:message code="global.lang.add" /></a>
						</span>
						<span class="add_img">
							<span class="addImg">
								<img src="../img/org_select2.png" class="clearIcon"/>
							</span>
							<a href="javascript:;" class="clear"><fmt:message code="notice.th.delete1" /></a>
						</span>
						<!--<input type="checkbox" name="check" id="check" value="向此人发送外部邮件" />
						<span>向此人发送外部邮件</span>-->
					</div>
					<div class="addPepl">
						<!--<a href="javascript:;" class="outside">添加外部收件人</a>-->
						<a href="javascript:;" class="a1"><fmt:message code="email.th.addwait" /></a>
						<a href="javascript:;" class="a2"><fmt:message code="email.th.addbcc" /></a>
						<a href="javascript:;" class="a3"><fmt:message code="email.th.recentcontacts" />&nbsp;</a>
						<span class="day">
							<ul>
								<li><fmt:message code="email.th.systemmanager" /></li>
								<li><fmt:message code="email.th.wangde" /></li>
								<li><fmt:message code="email.th.wangyun" /></li>
							</ul>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td><fmt:message code="email.th.major" />：</td>
				<td>
					<input type="text" id="txt" value="" class="input_txt" />
					<span class="import"><fmt:message code="email.title.waitmail" /></span>
				</td>
			</tr>
			<tr>
				<td width="10%">
					<p><fmt:message code="email.th.content" />：</p>
					<p class="Color"><fmt:message code="email.th.countnumber" />：<span>0</span></p>
					<p class="Color"><fmt:message code="global.lang.empty" /></p>
				</td>
				<td width="89%">
					<script id="container" style="width: 99.9%;min-height: 300px;" name="content" type="text/plain"></script>
				</td>
			</tr>
			<tr>
				<td><fmt:message code="email.th.filechose" />：</td>
				<td>
					<fmt:message code="email.th.addfile" />
				</td>
			</tr>
			<tr>
				<!--<td>提醒：</td>
				<td class="sendReady">
					<input type="checkbox" name="remind" id="remind" value="" />
					<span>发送事物提醒消息</span>
					<input type="checkbox" name="read" id="read" value="" />
					<span>请求阅读收条</span>
				</td>
			</tr>-->
			<tr>
				<td colspan="2">
					<div class="div_btn">
						<input type="button" id="btn1" value="<fmt:message code="email.th.transmitimmediate" />" />
						<input type="button" id="btn2" value="<fmt:message code="email.th.savedraftbox" />" />
					</div>
					
				</td>
			</tr>
		</table>
		
		
		<script type="text/javascript">
       		 var ue = UE.getEditor('container');
       		 //获取输入框内容
       		$("#btn1").on("click",function(){
					//获取html内容，返回: <p>hello</p>
					//var html = ue.getContent();
					//获取纯文本内容，返回: hello
					var txt = ue.getContentTxt();
					var val=$('#txt').val();
					/* if(val==''){
						alert('请输入邮件主题');
						return;
					} 
					if(txt==''){
						alert('请输入邮件内容');
						return;
					} */
					
					 var data={
					 	'bodyId':'18',
					 	'fromId':'2,',
					 	'toId2':'3,',
						'subject':val,
						'content':txt,
						'sendTime':'2017-04-11 10:20:35',
						'fromWebmailId':'1',
						'recvToId':'0',
						'secretLevel':'1',
						'size':'0'
					}
					
				//alert(data.subject);
					
					$.ajax({
						 type:'post',    
						 url:"sendEmail",
						 dataType:'json',
						 async:false,
						 data:data,
						 success:function(){
							alert('123');
						}
					})
				}) 
    	</script>
	</body>
</html>

