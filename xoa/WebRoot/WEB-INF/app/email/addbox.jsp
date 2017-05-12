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
		<title><fmt:message code="email.title.waitmail" /></title><!-- 写邮件 -->
		<meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<link rel="stylesheet" type="text/css" href="../css/email/writeMail.css"/>
		<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
		 <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/email/writeMail.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/ajaxupload.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<table class="TABLE" border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
			<tr class="append_tr">
				<td width="10%"><fmt:message code="email.th.recipients" />：</td>
				<td width="89%">
					<div class="inPole">
						<textarea name="txt" id="senduser" user_id='admin' value="admin" disabled></textarea>
						<span class="add_img" style="margin-left: 10px">
							<!-- <span class="addImg">
								<img src="../img/org_select.png" class="addIcon"/>
							</span> -->
							<a href="javascript:;" id="selectUser" class="Add "><fmt:message code="global.lang.add" /></a>
						</span>
						<span class="add_img">
							<!-- <span class="addImg">
								<img src="../img/org_select2.png" class="clearIcon"/>
							</span> -->
							<a href="javascript:;" class="clear"><fmt:message code="notice.th.delete1" /></a>
						</span>
						<!--<input type="checkbox" name="check" id="check" value="向此人发送外部邮件" />
						<span>向此人发送外部邮件</span>-->
					</div>
					<div class="addPepl">
						<!--<a href="javascript:;" class="outside">添加外部收件人</a>-->
						<a href="javascript:;" class="a1"><fmt:message code="email.th.addwait" /></a>
						<a href="javascript:;" class="a2"><fmt:message code="email.th.addbcc" /></a>
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
				<td><fmt:message code="email.th.major" />：</td>
				<td>
					<input type="text" id="txt" value="" class="input_txt" />
					<!-- <span class="import">一般邮件</span> -->
				</td>
			</tr>
			<tr>
				<td width="10%">
					<p><fmt:message code="email.th.content" />：</p>
					<!-- <p class="Color"><fmt:message code="email.th.countnumber" />：<span>0</span></p> -->
					<p class="Color"><a href="javascript:;" onclick="empty()"><fmt:message code="global.lang.empty" /></a></p>
				</td>
				<td width="89%">
					<script id="container" style="width: 99.9%;min-height: 300px;" name="content" type="text/plain"></script>
				</td>
			</tr>
			<tr class="Attachment" style="width:100%;">
				<td width="10%">附件：</td>
				<td width="89%"   class="files" id="files_txt"></td>
			</tr>
			<tr>
				<td><fmt:message code="email.th.filechose" />：</td>
				<td class="files">
					<!-- <fmt:message code="email.th.addfile" /> -->
					<form id="uploadimgform" target="uploadiframe"  action="../upload?module=email" enctype="multipart/form-data" method="post" >
						<input type="file" name="file" id="uploadinputimg"  class="w-icon5" style="display:none;">
						<button id="uploadimg">上传</button>
					</form>
					
				</td>
			</tr>
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
			
			user_id='senduser';
       		 var ue = UE.getEditor('container');
       		 var res
       		 //获取输入框内容
       		 $(function(){
				 //选人控件
       		 	$("#selectUser").on("click",function(){
       		 		user_id='senduser';
       		 		$.popWindow("../common/selectUser");
       		 	});
				 $('.TABLE').on('click','#selectUserO',function(){
				 	user_id='copeNameText';
                    $.popWindow("../common/selectUser");
				 })
                 $('.TABLE').on('click','#selectUserT',function(){
                 	user_id='secritText';
                    $.popWindow("../common/selectUser");
                 })
				 //附件上传
       		 	$('#uploadimg').on('click', function(ele) {
					$('#uploadinputimg').click();    
				})
       		 	$('#uploadinputimg').change(function(e){
					var target = $(e.target);
					var file;
					if(target[0].files && target[0].files[0]){
						file=target[0].files[0];
					}
					console.log(file);
					if(file){
						$.upload($('#uploadimgform'),function(res){
							//console.log(res);
							var data=res.obj;
							var str='';
							var str1='';
							 for(var i=0;i<data.length;i++){
								str+='<a href="javascript:;" NAME="'+data[i].attachName+'*">'+data[i].attachName+'</a>';
								str1+='<input type="hidden" class="inHidden" value="'+data[i].aid+'@'+data[i].ym+'_'+data[i].attachId+',">';
							}
							$('.Attachment td').eq(1).append(str+str1);
						});
					}
				});
       		 	//点击立即发送按钮
       		 	$("#btn1").on("click",function(){
					var userId=$('textarea[name="txt"]').attr('user_id');
					var txt = ue.getContentTxt();
					var html = ue.getContent();
					var val=$('#txt').val();
					var attach=$('.Attachment td').eq(1).find('a');
					var aId='';
					var uId='';
					for(var i=0;i<$('.Attachment td .inHidden').length;i++){
						aId += $('.Attachment td .inHidden').eq(i).val();
					}
					for(var i=0;i<$('.Attachment td .inHidden').length;i++){
						uId += attach.eq(i).attr('NAME');
					}
					var data={
					 	'fromId':'admin',
					 	'toId2': 'admin,',
						'copyToId':'admin',
						'subject':val,
						'content':html,
						'attachmentId':aId,
						'attachmentName':uId
					};
					$.ajax({
						 type:'post',    
						 url:'sendEmail',
						 dataType:'json',
						 data:data,
						 success:function(rsp){
							 if(rsp.flag == true){
								 alert('发送成功');
								 parent.location.reload();
							 }else{
								 alert('发送失败');
							 }
						}
					});
				});
				
				//点击保存到草稿箱按钮
				$("#btn2").on("click",function(){
					var userId=$('textarea[name="txt"]').attr('user_id');
					var txt = ue.getContentTxt();
					var html = ue.getContent();
					var val=$('#txt').val();
					var attach=$('.Attachment td').eq(1).find('a');
					var aId='';
					var uId='';
					for(var i=0;i<$('.Attachment td .inHidden').length;i++){
						aId += $('.Attachment td .inHidden').eq(i).val();
					}
					for(var i=0;i<$('.Attachment td .inHidden').length;i++){
						uId += attach.eq(i).attr('NAME');
					}
					var data={
					 	'fromId':'admin',
					 	'toId2': 'admin,',
						'subject':val,
						'content':html,
						'attachmentId':aId,
						'attachmentName':uId
					};
					$.ajax({
						 type:'post',    
						 url:'saveEmail',
						 dataType:'json',
						 data:data,
						 success:function(){
							alert('已保存到草稿箱');
                             parent.location.reload()
						}
					});
				});
				 
       		 });

       		//清空UE内容
       		function empty(){
       			ue.setContent('');
       		}
    	</script>
	</body>
</html>

