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
		<title><fmt:message code="email.title.inbox" /></title><!-- 收件箱 -->
		<meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<link rel="stylesheet" type="text/css" href="../css/email/inbox.css"/>
		<link rel="stylesheet" type="text/css" href="../css/email/inbox-upright.css"/>
		<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/laydate.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/email/writeMail.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/email/inbox.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<style>
			.main_left .BTN:hover{
				background:#c5e9fb;
			}
		</style>
	</head>
	<body>
		<div class="page">
			
				<!--左侧侧边栏 开始-->
				<div class="page_left">
					<!--写邮件-->
					<div class="write">
						<div class="d_im">
							<img src="../img/btn_writeletter_03.png"/>
						</div>
					</div>
					<!--收件箱-->
					<div class="inBox">
						<a href="javascript:;" class="inbox_btn">
							<div class="inbox_btn_tim div_down"><fmt:message code="email.title.mailbox" /></div>
						</a>
						<div class="ul_show" style="display: block;">
							<ul>
								<li id="InBox" class="on Inbox"><a href="javascript:;"><img src="../img/icon_inbox_07.png"/><fmt:message code="email.title.inbox" /><span>32</span></a></li>
								<li id="drafts"><a href="javascript:;"><img src="../img/icon_drafts_07.png"/><fmt:message code="email.title.draftbox" /><span>2</span></a></li>
								<li id="hasBeenSend"><a href="javascript:;"><img src="../img/icon_sent_07.png"/><fmt:message code="email.title.sent" /></a></li>
								<li id="wastebasket"><a href="javascript:;"><img src="../img/icon_dustbin_07.png"/><fmt:message code="email.title.wastebasket" /></a></li>
								<li class='liSearch'><a href="javascript:;"><img src="../img/icon_search_03.png"/><fmt:message code="email.title.querymail" /></a></li>
							</ul>
						</div>
					</div>
					<!--其他邮件箱-->
					<div class="other">
						<a href="javascript:;" class="inbox_btn">
							<div class="inbox_btn_tim div_up"><fmt:message code="email.title.othermailbox" /></div>
						</a>
						<div class="ul_show">
							<ul>
								<li><a href="javascript:;"><img src="../img/icon_file_11.png"/><fmt:message code="email.title.oneselffile" /></a></li>
							</ul>
						</div>
						
					</div>
					<!--邮件智能分类-->
					<div class="classify">
						<a href="javascript:;" class="inbox_btn">
							<div class="inbox_btn_tim div_up"><fmt:message code="email.title.mailsort" /></div>
						</a>
						<div class="ul_show spac_show">
							<ul>
								<li><a href="javascript:;"><span><fmt:message code="email.th.keywordchart" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.agenda" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.meeting" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.log" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.report" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.plan" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.notify" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.news" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.document" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.Project" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.personnel" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.assessment" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.Report" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.workflow" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.client" /></span></a></li>
								<li><a href="javascript:;"><span><fmt:message code="email.th.contract" /></span></a></li>
							</ul>
						</div>
					</div>
					<!--邮箱设置-->
					<div class="setUp">
						<a href="javascript:;">
							<img class="setUp_img" src="../img/icon_setmail_11.png"/>
							<span><fmt:message code="email.th.mailimpost" /></span>
							<img class="loding" src="../img/icon_refresh_11.png"/>
						</a>
					</div>
				</div>
			
			<!--左侧侧边栏 结束-->
			
			<!--右侧侧边栏 开始-->
			<div class="up_page_right">
				<div class="up_header">
					<div class="up_nav">
						<ul>
							<li onclick="clicked()"><img src="../img/icon_allmail_06.png" class="im"/><fmt:message code="email.th.allmail" /><img src="../img/icon_more_06.png" class="more_im"/></li>
							<li onclick="clicked()"><img src="../img/icon_notread_06.png" class="im"/><fmt:message code="email.th.unread" /><span>3</span></li>
							<li onclick="clicked()"><img src="../img/icon_transmit_06.png" class="im"/><fmt:message code="email.th.transmit" /></li>
							<li onclick="clicked()"><img src="../img/icon_move_06.png" class="im"/><fmt:message code="email.th.remove" /><img src="../img/icon_more_06.png" class="more_im"/></li>
							<li onclick="clicked()"><img src="../img/icon_delete_06.png" class="im"/><fmt:message code="global.lang.delete" /><img src="../img/icon_more_06.png" class="more_im"/></li>
							<li onclick="clicked()"><fmt:message code="email.th.more" /><img src="../img/icon_more_06.png" class="am"/></li>
						</ul>
					</div>
					<div class="up_pages">
						<div class="up_div_pages">
							<ul>
								<li onclick="clicked()"><img src="../img/icon_left_03.png"/><fmt:message code="email.th.beforemail" /><span>|</span></li>
								<li onclick="clicked()"><fmt:message code="email.th.nextmail" /><img src="../img/icon_right_03.png"/></li>
							</ul>
						</div>
						<div class="up_format">
							<ul>
								<li><img src="../img/icon_list_03.png"/></li>
								<li class="for_on"><img src="../img/icon_zuoyou_sel_03.png"/></li>
							</ul>
						</div>
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
									<img src="../img/icon_shaixuan_03.png"/><fmt:message code="email.th.order" />
								</div>
							</li>
						</ul>
					</div>
					<div>
						<!-- 收件箱 -->
						<div class="main_right InBox">
						
							<table id="TAB" cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
								<!-- <tr class="MAIN">
									<td width="8%"><fmt:message code="email.th.main" />：</td>
									<td width="72%">通达全新OA可选组件-知己者费用管控系统</td>
									
								</tr>
								<tr class="SEND">
									<td><fmt:message code="email.th.sender" />：</td>
									<td>张兰</td>
									
								</tr>
								<tr class="IN">
									<td><fmt:message code="email.th.recipients" />：</td>
									
								</tr>
								<tr class="DATE">
									<td><fmt:message code="email.th.time" />：</td>
									<td>2017年3月30日13:31（星期四）</td>
									
								</tr> -->
								
							</table>
							<span class="span_hr">
								<div><img src="../img/p1.jpg"/></div>
								<p><span></span>&nbsp;&nbsp;<span class="zong"><fmt:message code="email.th.subject" /></span></p>
								<p><fmt:message code="email.th.dept" /></p>
							</span>
							<div class="article">
								
							</div>
				
						</div>
						
						<!-- 草稿箱 -->
						<div class="main_right drafts" style="display:none;">
						
							<table border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
								<tr class="append_tr">
									<td width="15%"><fmt:message code="email.th.recipients" />：</td>
									<td width="84%">
										<div class="inPole">
											<textarea name="txt" disabled></textarea>
											<span class="add_img">
												<!-- <span class="addImg">
													<img src="../img/org_select.png" class="addIcon"/>
												</span> -->
												<a href="javascript:;" class="Add"><fmt:message code="global.lang.add" /></a>
											</span>
											<span class="add_img">
												<span class="addImg">
													<img src="../img/org_select2.png" class="clearIcon"/>
												</span>
												<a href="javascript:;" class="clear"><fmt:message code="notice.th.delete1" /></a>
											</span>
											
										</div>
										<div class="addPepl">
											<!--<a href="javascript:;" class="outside">添加外部收件人</a>-->
											<a href="javascript:;" class="a1"><fmt:message code="email.th.addwait" /></a>
											<a href="javascript:;" class="a2"><fmt:message code="email.th.addbcc" /></a>
											<a href="javascript:;" class="a3"><fmt:message code="email.th.recentcontacts" />&nbsp;</a>
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
										<span class="import"><fmt:message code="email.th.conmmemail" /></span>
									</td>
								</tr>
								<tr>
									<td width="15%">
										<p><fmt:message code="email.th.content" />：</p>
										<p class="Color"><fmt:message code="email.th.countnumber" />：<span>0</span></p>
										<p class="Color"><fmt:message code="global.lang.empty" /></p>
									</td>
									<td width="84%">
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
									<td colspan="2">
										<div class="div_btn">
											<input type="button" id="btn1" value="<fmt:message code="email.th.transmitimmediate" />" />
											<input type="button" id="btn2" value="<fmt:message code="email.th.savedraftbox" />" />
										</div>
										
									</td>
								</tr>
							</table>
				
						</div>
						
						<!-- 已发送 -->
						<div class="main_right hasBeenSend" style="display:none;">
						
							<table id="TAC" cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
								 <tr class="MAIN2">
									<td width="8%"><fmt:message code="email.th.main" />：</td>
									<!-- <td width="72%">通达全新OA可选组件-知己者费用管控系统</td> -->
									
								</tr>
								<tr class="SEND2">
									<td><fmt:message code="email.th.recipients" />：</td>
									<!-- <td>
										<span><img src="../img/icon_read_3_07.png"/>李佳</span>
										<span><img src="../img/icon_notread_1_03.png"/>王云</span>
										<span><img src="../img/icon_read_3_07.png"/>王德</span>
										<span><img src="../img/icon_notread_1_03.png"/>赵敏</span>
										<span><img src="../img/icon_read_3_07.png"/>刘娜</span>
									</td> -->
									
								</tr>
								<tr class="DATE2">
									<td><fmt:message code="email.th.time" />：</td>
									<!-- <td>2017年3月30日13:31（星期四）</td> -->
									
								</tr>
							</table>
							<div class="article1">
							
							</div>
						</div>
						
						<!-- 废纸篓 -->
						<div class="main_right wastebasket" style="display:none;">
						
							<table id="TAD" cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
								<!-- <tr class="MAIN3">
									<td width="8%"><fmt:message code="email.th.main" />：</td>
									<td width="72%">通达全新OA可选组件-知己者费用管控系统</td>
									
								</tr>
								<tr class="SEND3">
									<td><fmt:message code="email.th.sender" />：</td>
									<td>张兰</td>
									
								</tr>
								<tr class="IN3">
									<td><fmt:message code="email.th.recipients" />：</td>
								</tr>
								<tr class="DATE3">
									<td><fmt:message code="email.th.time" />：</td>
									<td>2017年3月30日13:31（星期四）</td>
									
								</tr>
								<tr>
									<td>附&nbsp;&nbsp;&nbsp;件：</td>
									<td>
										<p>1个&nbsp;<img src="../img/icon_accessory_03.png"/><span>智能OA移动产品部3月23日任务工单.rar&nbsp;</span>(19.81KB)</p>
									</td>
									
								</tr> -->
							</table>
	 							<div class="article2">
									
								</div>
						</div>
						
						
						
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			 var ue = UE.getEditor('container');
			$(function () {
			
				//不同风格页面互调
				var oLI=$('.up_format ul li').eq(0);
				oLI.click(function () {
					$(this).addClass('for_on').find('img').attr('src','img/icon_list_sel_03.png');
					
					$(this).siblings().removeClass('for_on');
					$(this).parent().find('li').eq(1).find('img').attr('src','img/icon_zuoyou_03.png');
					window.location.href='inboxup';
				});
				
				//与写邮件页面互调
				$('.d_im img').click(function(){
					var Ifrmae='<div class="div_iframe" style="width: 85%;overflow-y: auto;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="addbox" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			//var Ifrmae='<div class="div_iframe" style="width: 85%;overflow-y: auto;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="addbox" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			$('.up_page_right').css('display','none');
	    			$('.page').append(Ifrmae);
	    		});
	    		$('.Inbox').click(function(){
	    			$('.page').find('.div_iframe').remove();
	    			$('.up_page_right').css('display','block');
	    		})
	    	
	    		//页面初始化
				
				showAjax('inbox','#TAB','.article');
			
				
				
				//查询邮件点击事件
				$('.liSearch').click(function(){
	    			var Ifrmae='<div class="div_iframe" style="width: 85%;overflow-y: auto;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="development" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			$('.up_page_right').css('display','none');
	    			$('.page').append(Ifrmae);
	    		})
				
				
					//收件箱点击事件
				$('#InBox').click(function(){
					$('.InBox').css('display','block').siblings().css('display','none');
					showAjax('inbox','#TAB','.article');
				})
				
				
				//草稿箱点击事件
				$('#drafts').click(function(){		
						$('.drafts').css('display','block').siblings().css('display','none');
						showAjax2('drafts');
						
				})
				
				//已发送点击事件
				$('#hasBeenSend').click(function(){
					
					$('.hasBeenSend').css('display','block').siblings().css('display','none');
					showAjax2("outbox");
					init3('146');
					
					$('.main_left').on('click','.BTN',function(){
						var nId=$(this).find('input').attr('nId');
						init3(nId);
						
					}) 
				})
				
				//废纸篓点击事件
				$('#wastebasket').click(function(){
					//alert('123')
					$('.wastebasket').css('display','block').siblings().css('display','none');
					//showAjax("recycle")
					showAjax('recycle','#TAD','.article2')
					$('.main_left').on('click','.BTN',function(){
						var nId=$(this).find('input').attr('id');
						init(nId,'#TAD','.article2')
					}) 
					
				})
				
			
				
				//鼠标移入移出事件
				/* $('.main_left').on('hover','.BTN',function(){
					$(this).css('background-color','#c5e9fb');
				}) */
				/* $('.main_left').on('mouseout','.BTN',function(){
					$(this).css('background-color','#fff');
				})  */
				
				 //详情点击事件
				$('.main_left').on('click','.BTN',function(){
					//$('.BTN').removeClass('backing');
					$(this).addClass("backing").siblings("li").removeClass("backing");
					var nId=$(this).find('input').attr('id');
					init(nId,'#TAB','.article');
				}) 
				
				
			});
			
			
			//详情展示方法
			function init(id,obj,cName){
				
					$.ajax({
								type:'get',
								url:'queryByID',
								dataType:'json',
								data:{'emailId':id,'flag':''},
								success:function(rsp){
									var data2=rsp.object;
									var sendTime=new Date((data2.sendTime)*1000).Format('yyyy-MM-dd hh:mm');
									var str='';
									$(obj).find('tr').remove();
									$(cName).find('p').remove();
									$('.span_hr').find('p').find('span').eq(0).html('');
									if(data2.attachmentName!='' && data2.copyName!=''){
										str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td>抄送人：</td><td>'+data2.copyName+'</td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr><tr><td>附件：</td><td>'+data2.attachmentName+'</td></tr>';
									} else if(data2.attachmentName=='' && data2.copyName!=''){
										str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td>抄送人：</td><td>'+data2.copyName+'</td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr>';
									} else if(data2.attachmentName!='' && data2.copyName ==''){
										str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr><tr><td>附件：</td><td>'+data2.attachmentName+'</td></tr>';
									} else{
										str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr>';
									}
									
									$(obj).append(str);
									$(cName).append('<p>'+data2.content+'</p>');
									$('.span_hr').find('p').find('span').eq(0).html(data2.users.userName);
								}
					});
				}
				
				
				//列表展示方法
				function showAjax(flag,obj,cName){
					$('.BTN').remove();
					var data1={
						"flag":flag,
						"page":1,
						"pageSize":10,
						"useFlag":true,
						"userID":"admin"
					}	
					
					$.ajax({
									type:'get',
									url:'showEmail',
									dataType:'json',
									data:data1,
									success:function(rsp){
										var data1=rsp.obj;
										var str='';
										for(var i=0;i<data1.length;i++){
											var sendTime=new Date((data1[i].sendTime)*1000).Format('yyyy-MM-dd hh:mm');
											//alert(data1[i].sendTime);
											if(data1[i].emailList[0].readFlag==1){
												if(data1[i].attachmentId!=''){
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" id="'+data1[i].emailList[0].emailId+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
												}else{
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" id="'+data1[i].emailList[0].emailId+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a></div></li>';
												}
												
											} else if(data1[i].emailList[0].readFlag==0){
												if(data1[i].attachmentId!=''){
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_notread_1_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
												}else{
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_notread_1_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a></div></li>';
												}
												
											}
											
										}
										$('.befor').after(str);
										
										var mId=$('li.BTN').eq(0).find('input').attr('id');
										
										init(mId,obj,cName);
									}
					});
				}
				
				function showAjax2(flag){
					$('.BTN').remove();
							var data={
								"flag":flag,
								"page":1,
								"pageSize":10,
								"useFlag":true,
								"userID":"admin"
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
											var sendTime=new Date((data1[i].sendTime)*1000).Format('yyyy-MM-dd hh:mm');
												if(data1[i].attachmentId!=''){
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_collect_nor_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
												}else{
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_collect_nor_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a></div></li>';
												}
												
											
										}
										$('.main_left ul .befor').after(str);
										
									}
						});
				}
				
				function init3(id){
					$.ajax({
									type:'get',
									url:'queryByID',
									dataType:'json',
									data:{'bodyId':id,'flag':''},
									success:function(rsp){
										var data2=rsp.object;
										var sendTime=new Date((data2.sendTime)*1000).Format('yyyy-MM-dd hh:mm');
										$('#TAC').find('tr').eq(0).find('td').eq(1).remove();
										$('#TAC').find('tr').eq(1).find('td').eq(1).remove();
										$('#TAC').find('tr').eq(2).find('td').eq(1).remove();
										$('.article1').find('p').remove();
										
										$('#TAC').find('tr').eq(0).append('<td width="72%">'+data2.subject+'</td>')
										$('#TAC').find('tr').eq(1).append('<td><span><img src="../img/icon_read_3_07.png"/>'+data2.toName+'</span></td>')
										$('#TAC').find('tr').eq(2).append('<td>'+sendTime+'</td>')
										$('.article1').append('<p>'+data2.content+'</p>');
									}
						});
				} 
				function clicked(){
					layer.msg('开发中', {icon: 6});
				}
		</script>
		
	</body>
</html>

