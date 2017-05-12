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
		<title><fmt:message code="global.lang.reply" /></title>
		<meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<link rel="stylesheet" type="text/css" href="../css/email/writeMail.css"/>
		<script src="../lib/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/email/writeMail.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/ajaxupload.js" type="text/javascript" charset="utf-8"></script>
		<style>
			table{margin-top:10px;}
			table tr td{padding-left:10px;}
			.files a{text-decoration: none;}
		</style>
	</head>
	<body>
		<table class="TABLE" border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
			<tr class="append_tr">
				<td width="10%"><fmt:message code="email.th.recipients" />：</td>
				<td width="89%">
					<div class="inPole">
						<textarea name="txt" id="senduser" user_id='admin' value="" disabled></textarea>
						<span class="add_img">
							<%--<span class="addImg">
								<img src="../img/org_select.png" class="addIcon"/>
							</span>--%>
							<a href="javascript:;" id="selectUser" class="Add"><fmt:message code="global.lang.add" /></a>
						</span>
						<span class="add_img">
							<%--<span class="addImg">
								<img src="../img/org_select2.png" class="clearIcon"/>
							</span>--%>
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
					<!-- <p class="Color"><fmt:message code="email.th.countnumber" />：<span>0</span></p> -->
					<!-- <p class="Color"><fmt:message code="global.lang.empty" /></p> -->
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
					
					<form id="uploadimgform" target="uploadiframe"  action="../upload?module=email" enctype="multipart/form-data" method="post" >
						<input type="file" name="file" id="uploadinputimg"  class="w-icon5" style="display:none;">
						<a href="javascript:;" id="uploadimg">上传</a>
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
       		 var ue = UE.getEditor('container');
       		 user = 'senduser';
			user_id='senduser';
       		 //获取输入框内容
       	 $(function () {
       	 	$("#selectUser").on("click",function(){
       		 		$.popWindow("../common/selectUser");
       		 	});

       		 ue.ready(function(){
       		 	var sId=$.getQueryString('sId');
				var TYPE=$.getQueryString('type');
       		 	$.ajax({
						type:'get',
						url:'queryByID',
						dataType:'json',
						data:{'emailId':sId,'flag':''},
						success:function(rsp){
							var data2=rsp.object;
							var sendTime=new Date((data2.sendTime)*1000).Format('yyyy-MM-dd hh:mm');
							var str='';
							var str1='';
							var stra='';
							var arr=new Array();
							arr=data2.attachmentName.split('*');
							$('#txt').val('');
							ue.setContent('');
							$('#senduser').val('');
							if(data2.attachmentName!='' && data2.copyName!=''){
								for(var i=0;i<(arr.length-1);i++){
									stra+='<span><a href="<%=basePath %>download?'+arr[i].attUrl+'" style="text-decoration:none;"><img src="../img/icon_print_07.png"/>'+arr[i]+'</a></span>';
							}
								str='<br><br><div class="div_Re" style="padding:5px 15px;border-bottom: 1px #cccccc solid;background: #edf6db;font-size: 12px;"><p><span>主题：</span><span>'+data2.subject+'</span></p><p><span>发件人：</span><span>'+data2.users.userName+'</span></p><p><span>收件人：</span><span>'+data2.emailList[0].toName+'</span></p><p><span>抄送人：</span><span>'+data2.copyName+'</span></p><p><span>时间：</span><span>'+sendTime+'</span></p><p><span>附件：</span><span>'+stra+'</span></p></div>';
								
							} else if(data2.attachmentName=='' && data2.copyName!=''){
								str='<br><br><div class="div_Re" style="padding:5px 15px;border-bottom: 1px #cccccc solid;background: #edf6db;font-size: 12px;"><p><span>主题：</span><span>'+data2.subject+'</span></p><p><span>发件人：</span><span>'+data2.users.userName+'</span></p><p><span>收件人：</span><span>'+data2.emailList[0].toName+'</span></p><p><span>抄送人：</span><span>'+data2.copyName+'</span></p><p><span>时间：</span><span>'+sendTime+'</span></p></div>';
								
							} else if(data2.attachmentName!='' && data2.copyName ==''){
								for(var i=0;i<(arr.length-1);i++){
									stra+='<span><a href="<%=basePath %>download?'+arr[i].attUrl+'" style="text-decoration:none;"><img src="../img/icon_print_07.png"/>'+arr[i]+'</a></span>';
								}
								str='<br><br><div class="div_Re" style="padding:5px 15px;border-bottom: 1px #cccccc solid;background: #edf6db;font-size: 12px;"><p><span>主题：</span><span>'+data2.subject+'</span></p><p><span>发件人：</span><span>'+data2.users.userName+'</span></p><p><span>收件人：</span><span>'+data2.emailList[0].toName+'</span></p><p><span>时间：</span><span>'+sendTime+'</span></p><p><span>附件：</span><span>'+stra+'</span></p></div>';
								
							} else{
								str='<br><br><div class="div_Re" style="padding:5px 15px;border-bottom: 1px #cccccc solid;background: #edf6db;font-size: 12px;"><p><span>主题：</span><span>'+data2.subject+'</span></p><p><span>发件人：</span><span>'+data2.users.userName+'</span></p><p><span>收件人：</span><span>'+data2.emailList[0].toName+'</span></p><p><span>时间：</span><span>'+sendTime+'</span></p></div>';
								
							}
							if (TYPE==1&&data2.copyName!=''){
                                var str1='<tr class="tian"><td>抄送：</td><td><textarea name="txt" id="copyName" disabled></textarea><span class="add_img"><span class="addImg"></span><a href="javascript:;" id="selectUserO" class="Add">添加</a><span class="add_img"><span class="addImg"><img src="img/org_select2.png" class="clearIcon"/></span><a href="javascript:;" class="clear">清除</a></span></td></tr>';
                                $('.append_tr').after(str1);
								$('.a1').text('隐藏抄送');
							}
							str1='<p>'+data2.content+'</p>';
							ue.setContent(str+str1);
							$('#txt').val('Re:'+data2.subject);
							if (TYPE!=2){
                                $('#senduser').val(data2.emailList[0].toName);
							}else{
                                $('#senduser').val('');
							}

							$('#copyName').val(data2.copyName)
						}
					});
				})
					
				//附件上传方法	
				$('#uploadimg').on('click', function(ele) {
                    user_id='senduser';
					$('#uploadinputimg').click();    
				})
				 $('.TABLE').on('click','#selectUserO',function(){
					 user_id='copeNameText';
					 $.popWindow("../common/selectUser");
				 })
				 $('.TABLE').on('click','#selectUserT',function(){
					 user_id='secritText';
					 $.popWindow("../common/selectUser");
				 })
       		 	$('#uploadinputimg').change(function(e){
					var target = $(e.target);
					var file;
					if(target[0].files && target[0].files[0]){
						file=target[0].files[0];
					}
					
					if(file){
						$.upload($('#uploadimgform'),function(res){
							//console.log(res);
							var data=res.obj;
							var str='';
							var str1='';
							 for(var i=0;i<data.length;i++){
								str+='<a href="<%=basePath %>download?'+data[i].attUrl+'" NAME="'+data[i].attachName+'*">'+data[i].attachName+'</a>';
								str1+='<input type="hidden" class="inHidden" value="'+data[i].aid+'@'+data[i].ym+'_'+data[i].attachId+',">';
							} 
							
							$('.Attachment td').eq(1).append(str+str1);
							
						});
					}
				});	
				
       		 	//点击立即发送
       		 	$("#btn1").on("click",function(){
                    var dataId1=$('.inPole').find('#senduser').attr('dataid');
                    var dataId2=$('.tian').find('#copeNameText').attr('dataid');
                    var dataId3=$('.mis').find('#secritText').attr('dataid');
                    var TYPE=$.getQueryString('type');
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
                         'toId2': dataId1,
                         'copyToId':dataId2,
                         'secretToId':dataId3,
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
						 success:function(){
							 if (TYPE!=2){
                                 alert('回复成功');
							 }else{
                                 alert('转发成功');
							 }

                             window.close()
                             parent.opener.location.reload()
						}
					}); 
				}) 
				
				//点击保存到草稿箱按钮
				$("#btn2").on("click",function(){
                    var dataId1=$('.inPole').find('#senduser').attr('dataid');
                    var dataId2=$('.tian').find('#copeNameText').attr('dataid');
                    var dataId3=$('.mis').find('#secritText').attr('dataid');
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
							window.location.href='index';
						}
					});
				});
       		 })
       		 
       	
				
    	</script>
	</body>
</html>

