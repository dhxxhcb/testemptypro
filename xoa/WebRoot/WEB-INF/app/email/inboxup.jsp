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
		<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/email/inbox.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
		<style>
			.Hover{cursor: pointer;}
			.Hover:hover{background-color:#c5e9fb;}
			.on_tr{background-color: #c5e9fb;}
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
								<li class="on Inbox"><a href="javascript:;"><img src="../img/icon_inbox_07.png"/><fmt:message code="email.title.inbox" /><span></span></a></li>
								<li id="drafts"><a href="javascript:;"><img src="../img/icon_drafts_07.png"/><fmt:message code="email.title.draftbox" /><span></span></a></li>
								<li id="outbox"><a href="javascript:;"><img src="../img/icon_sent_07.png"/><fmt:message code="email.title.sent" /></a></li>
								<li id="recycle"><a href="javascript:;"><img src="../img/icon_dustbin_07.png"/><fmt:message code="email.title.wastebasket" /></a></li>
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
			<div class="page_right">
				
				<div class="header">
					<div class="nav">
						<ul>
							<li><img src="../img/icon_allmail_06.png"/><fmt:message code="email.th.allmail" /><img src="../img/icon_more_06.png" class="more_im"/></li>
							<li><img src="../img/icon_notread_06.png"/><fmt:message code="email.th.unread" /><span>3</span></li>
							<li><img src="../img/icon_transmit_06.png"/><fmt:message code="email.th.transmit" /></li>
							<li><img src="../img/icon_move_06.png"/><fmt:message code="email.th.remove" /><img src="../img/icon_more_06.png" class="more_im"/></li>
							<li><img src="../img/icon_delete_06.png"/><fmt:message code="global.lang.delete" /><img src="../img/icon_more_06.png" class="more_im"/></li>
							<li><fmt:message code="email.th.more" /><img src="../img/icon_more_06.png" class="more_im"/></li>
						</ul>
					</div>
					<div class="searchs">
						<div class="search_div">
							<img src="../img/icon_search_2_06.png"/>
							<input type="search" name="search" id="search" placeholder="搜索" />
							
						</div>
						<div class="format">
							<ul>
								<li class="for_on"><img src="../img/icon_list_sel_03.png"/></li>
								<li><img src="../img/icon_zuoyou_03.png"/></li>
							</ul>
						</div>
						
					</div>
				</div>
				<div class="tab">
					<table cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
						<tr class='befor'>
							<th width="6%">
								<input type="checkbox" name="checkbox" id="checkbox" value="" />
							</th>
							<th width="6%"><fmt:message code="notice.th.state" /></th>
							<th width="6%"><fmt:message code="email.th.sign" /></th>
							<th width="16%"><fmt:message code="email.th.sender" /></th>
							<th width="40%" class="theme"><fmt:message code="email.th.main" /></th>
							<th width="16%"><fmt:message code="global.lang.date" /></th>
							<th width="10%"><fmt:message code="email.th.file" /></th>
						</tr>
						
					</table>
				</div>

		</div>
				<!--右侧侧边栏 结束-->
		<script type="text/javascript">
    		
    		$(function(){
	    			
				init();
	    		
	    		//与写邮件页面互调
	    		$('.d_im img').click(function(){
	    			var Ifrmae='<div class="div_iframe" style="width: 85%;overflow-y: auto;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="addbox" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			$('.page_right').css('display','none');
	    			$('.page').append(Ifrmae);
	    		});
	    		$('.Inbox').click(function(){
	    			$('.page').find('.div_iframe').remove();
	    			$('.page_right').css('display','block');
	    		})
	    		
	    		$('.liSearch').click(function(){
	    			var Ifrmae='<div class="div_iframe" style="width: 85%;overflow-y: auto;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="development" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			$('.page_right').css('display','none');
	    			$('.page').append(Ifrmae);
	    		})
	    		
	    		//不同风格页面互调
	    		$('.format ul li:last-of-type').click(function () {
					$(this).addClass('for_on').find('img').attr('src','img/icon_zuoyou_sel_03.png');
					
					$(this).siblings().removeClass('for_on');
					$(this).parent().find('li').eq(1).find('img').attr('src','img/icon_list_03.png');
					window.location.href='index';
				})


				$('.tab').on('click','tr.Hover',function () {
					$(this).addClass('on_tr').siblings().removeClass('on_tr');
					var atr=$(this).attr('Attr');
                    $.popWindow('details?id='+atr);
                })

    		});
    		
    		
    		
    		
    		
    		function init(){
    			var data={
						"flag":"inbox",
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
									$('#InBox a span').text('');
									$('#InBox a span').append(rsp.totleNum);
									for(var i=0;i<data1.length;i++){
										var sendTime=new Date((data1[i].sendTime)*1000).Format('yyyy-MM-dd');
										//alert(data1[i].sendTime);
										if(data1[i].emailList[0].readFlag==1){
											if(data1[i].attachmentId!=''){
												str+='<tr class="Hover" Attr="'+data1[i].emailList[0].emailId+'"><td><input type="checkbox" name="checkbox" id="checkbox" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:center;">'+data1[i].subject+'</td><td>'+sendTime+'</td><td><img src="../img/icon_accessory_03.png"/></td></tr>';
											}else{
												str+='<tr class="Hover" Attr="'+data1[i].emailList[0].emailId+'"><td><input type="checkbox" name="checkbox" id="checkbox" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:center;">'+data1[i].subject+'</td><td>'+sendTime+'</td><td>&nbsp</td></tr>';
											}
											
										} else if(data1[i].emailList[0].readFlag==0){
											if(data1[i].attachmentId!=''){
												str+='<tr class="Hover" Attr="'+data1[i].emailList[0].emailId+'"><td><input type="checkbox" name="checkbox" id="checkbox" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:center;">'+data1[i].subject+'</td><td>'+sendTime+'</td><td><img src="../img/icon_accessory_03.png"/></td></tr>';
											}else{
												str+='<tr class="Hover" Attr="'+data1[i].emailList[0].emailId+'"><td><input type="checkbox" name="checkbox" id="checkbox" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:center;">'+data1[i].subject+'</td><td>'+sendTime+'</td><td>&nbsp</td></tr>';
											}
										}
										
									}
									$('.befor').after(str);
								}
				});
    		}
    		
    	</script>
	</body>
</html>