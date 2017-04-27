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
		<title>写邮件</title>
		<meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<link rel="stylesheet" type="text/css" href="../css/email/writeMail.css"/>
		<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
		 <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/email/writeMail.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<table border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
			<tr class="append_tr">
				<td width="10%">收件人：</td>
				<td width="89%">
					<div class="inPole">
						<textarea name="txt" value="admin" disabled></textarea>
						<span class="add_img">
							<span class="addImg">
								<img src="../img/org_select.png" class="addIcon"/>
							</span>
							<a href="javascript:;" id="selectUser" class="Add ">添加</a>
						</span>
						<span class="add_img">
							<span class="addImg">
								<img src="../img/org_select2.png" class="clearIcon"/>
							</span>
							<a href="javascript:;" class="clear">清除</a>
						</span>
						<!--<input type="checkbox" name="check" id="check" value="向此人发送外部邮件" />
						<span>向此人发送外部邮件</span>-->
					</div>
					<div class="addPepl">
						<!--<a href="javascript:;" class="outside">添加外部收件人</a>-->
						<a href="javascript:;" class="a1">添加抄送</a>
						<a href="javascript:;" class="a2">添加密送</a>
						<!-- <a href="javascript:;" class="a3">最近联系人&nbsp;</a> -->
						<!-- <span class="day">
							<ul>
								<li>系统管理员</li>
								<li>王德</li>
								<li>王云</li>
							</ul>
						</span> -->
					</div>
				</td>
			</tr>
			<tr>
				<td>邮件主题：</td>
				<td>
					<input type="text" id="txt" value="" class="input_txt" />
					<!-- <span class="import">一般邮件</span> -->
				</td>
			</tr>
			<tr>
				<td width="10%">
					<p>邮件内容：</p>
					<p class="Color">计算字数：<span>0</span></p>
					<p class="Color">清空</p>
				</td>
				<td width="89%">
					<script id="container" style="width: 99.9%;min-height: 300px;" name="content" type="text/plain"></script>
				</td>
			</tr>
			<tr>
				<td>附件选择：</td>
				<td>
					添加附件
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="div_btn">
						<input type="button" id="btn1" value="立即发送" />
						<input type="button" id="btn2" value="保存到草稿箱" />
					</div>
					
				</td>
			</tr>
		</table>
		
		
		<script type="text/javascript">
       		 var ue = UE.getEditor('container');
       		 //获取输入框内容
       		 $(function(){
       		 	$("#selectUser").on("click",function(){
       		 		$.popWindow("../common/selectUser");
       		 	});
       		 	$("#btn1").on("click",function(){
					
					var userId=$('textarea[name="txt"]').val();
					var txt = ue.getContentTxt();
					var val=$('#txt').val();

					 var data={
					 	'fromId':'admin',
					 	'toId2': 'admin,',
						'subject':val,
						'content':txt
					}
					
					$.ajax({
						 type:'post',    
						 url:'sendEmail',
						 dataType:'json',
						 data:data,
						 success:function(){
							alert('发送成功');
							$('.page').find('.div_iframe').remove();
							$('.up_page_right').css('display','block');
						}
					})
				}) 
       		 })
       		
    	</script>
	</body>
</html>

