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
		<title>草稿箱</title>
		<meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<link rel="stylesheet" type="text/css" href="../css/email/inbox.css"/>
		<link rel="stylesheet" type="text/css" href="../css/email/inbox-upright.css"/>
		<link rel="stylesheet" type="text/css" href="../css/email/writeMail.css"/>
		<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/email/writeMail.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/email/inbox.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="page">
			<div class="up_page_right">
				<div class="up_header">
					<div class="up_nav">
						<ul>
							<li><img src="../img/icon_allmail_06.png" class="im"/>全部邮件<img src="../img/icon_more_06.png" class="am"/></li>
							<li><img src="../img/icon_notread_06.png" class="im"/>未读<span>3</span></li>
							<li><img src="../img/icon_replay_03.png" class="im"/>回复<span>3</span></li>
							<li><img src="../img/icon_replay_03.png" class="im"/>回复全部<span>3</span></li>
							<li><img src="../img/icon_transmit_06.png" class="im"/>转发</li>
							<li><img src="../img/icon_move_06.png" class="im"/>移动到<img src="../img/icon_more_06.png" class="am"/></li>
							<li><img src="../img/icon_delete_06.png" class="im"/>删除<img src="../img/icon_more_06.png" class="am"/></li>
							<li>更多<img src="../img/icon_more_06.png" class="am"/></li>
						</ul>
					</div>
					<div class="up_pages">
						<div class="up_div_pages">
							<ul>
								<li><img src="../img/icon_left_03.png"/>上一封<span>|</span></li>
								<li>下一封<img src="../img/icon_right_03.png"/></li>
							</ul>
						</div>
						<!-- <div class="up_format">
							<ul>
								<li><img src="../img/icon_list_nor_06.png"/></li>
								<li><img src="../img/icon_shangxia_nor_06.png"/></li>
								<li class="for_on"><img src="../img/icon_zuoyou_sel_03.png"/></li>
							</ul>
						</div> -->
					</div>
				</div>
				<div class="main">
					<div class="main_left">
						<ul>
							<li class="befor">
								<div class="sort">
									<img src="../img/icon_search_03(1).png"/>
									<img src="../img/icon_shuaxin_03.png"/>
									<img src="../img/icon_duoxuan_03.png"/>
									
								</div>
								<div class="sort_right">
									<img src="../img/icon_shaixuan_03.png"/>排序
								</div>
							</li>
							
						</ul>
					</div>
					<div class="main_right">
					
						<table border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
							<tr class="append_tr">
								<td width="10%">收件人：</td>
								<td width="89%">
									<div class="inPole">
										<textarea name="txt" disabled></textarea>
										<span class="add_img">
											<span class="addImg">
												<img src="../img/org_select.png" class="addIcon"/>
											</span>
											<a href="javascript:;" class="Add">添加</a>
										</span>
										<span class="add_img">
											<span class="addImg">
												<img src="../img/org_select2.png" class="clearIcon"/>
											</span>
											<a href="javascript:;" class="clear">清除</a>
										</span>
										
									</div>
									<div class="addPepl">
										<!--<a href="javascript:;" class="outside">添加外部收件人</a>-->
										<a href="javascript:;" class="a1">添加抄送</a>
										<a href="javascript:;" class="a2">添加密送</a>
										<a href="javascript:;" class="a3">最近联系人&nbsp;</a>
										<span class="day">
											<ul>
												<li>系统管理员</li>
												<li>王德</li>
												<li>王云</li>
											</ul>
										</span>
									</div>
								</td>
							</tr>
							<tr>
								<td>邮件主题：</td>
								<td>
									<input type="text" id="txt" value="" class="input_txt" />
									<span class="import">一般邮件</span>
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
			
					</div>
				</div>
			</div>
		</div>
		
		<!-- <script type="text/javascript">
			 var ue = UE.getEditor('container');
			$(function () {
				//与写邮件页面互调
				$('.d_im img').click(function(){
					var Ifrmae='<div class="div_iframe" style="width: 85%;overflow-y: auto;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="addbox" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			//var Ifrmae='<div class="div_iframe" style="width: 85%;overflow-y: auto;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="addbox" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			$('.page_right').css('display','none');
	    			$('.page').append(Ifrmae);
	    		});
	    		$('.Inbox').click(function(){
	    			$('.page').find('.div_iframe').remove();
	    			$('.page_right').css('display','block');
	    		})
			
				$('.liSearch').click(function(){
	    			var Ifrmae='<div class="div_iframe" style="width: 85%;overflow-y: auto;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="addbox" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			$('.page_right').css('display','none');
	    			$('.page').append(Ifrmae);
	    		})
				
				//不同风格页面互调
				var oLI=$('.up_format ul li').eq(1);
				oLI.click(function () {
					$(this).addClass('for_on').find('img').attr('src','img/icon_shangxia_sel_06.png');
					
					$(this).siblings().removeClass('for_on');
					$(this).parent().find('li').eq(2).find('img').attr('src','img/icon_zuoyou_nor_06.png');
					window.location.href='inboxup';
				});
				
				var data={
					"flag":"inbox",
					"page":1,
					"pageSize":10,
					"useFlag":true,
					"userID":"lijia"
				}
				
				$.ajax({
								type:'get',
								url:'showEmail',
								dataType:'json',
								data:data,
								success:function(rsp){
									var data1=rsp.obj;
									var str='';
									for(var i=0;i<data1.length;i++){
										var sendTime=new Date(data1[i].sendTime).Format('yyyy-MM-dd hh:mm:ss');
										//alert(data1[i].sendTime);
										if(data1[i].emailList[0].readFlag==1){
											str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" id="'+data1[i].emailList[0].emailId+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_3_07.png"/><img src="../img/icon_collect_nor_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
										} else if(data1[i].emailList[0].readFlag==0){
											str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" id="'+data1[i].emailList[0].emailId+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_notread_1_03.png"/><img src="../img/icon_collect_nor_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
										}
										
									}
									$('.main_left ul .befor').after(str);
								}
				});
				
				$('.main_left').on('click','.BTN',function(){
					var nId=$(this).find('input').attr('id');
					//alert(nId);
					init(nId,'#TAB','.article');
					
				})
				
				init('181','#TAB','.article');
				
			});
			
			function init(id,obj,sName){
					$.ajax({
								type:'get',
								url:'queryByID',
								dataType:'json',
								data:{'emailId':id,'flag':''},
								success:function(rsp){
									var data2=rsp.object;
									var sendTime=new Date(data2.sendTime).Format('yyyy-MM-dd hh:mm:ss');
									$(obj).find('tr').eq(0).find('td').eq(1).remove();
									$(obj).find('tr').eq(1).find('td').eq(1).remove();
									$(obj).find('tr').eq(2).find('td').eq(1).remove();
									$(obj).find('tr').eq(3).find('td').eq(1).remove();
									$(obj).find('tr').eq(4).find('td').eq(1).remove();
									$(sName).find('p').remove();
									
									$(obj).find('tr').eq(0).append('<td width="72%">'+data2.subject+'</td>');
									$(obj).find('tr').eq(1).append('<td>'+data2.users.userName+'</td>');
									$(obj).find('tr').eq(2).append('<td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toId+'</span></td>');
									$(obj).find('tr').eq(3).append('<td>'+sendTime+'</td>');
									$(obj).find('tr').eq(4).append('<td>&nbsp</td>');
									$(sName).append('<p>'+data2.content+'</p>');
									
									
								}
					});
				}
			
		</script> -->
		
	</body>
</html>
