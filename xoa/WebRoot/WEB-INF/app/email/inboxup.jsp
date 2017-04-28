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
								<li class="on Inbox"><a href="javascript:;"><img src="../img/icon_inbox_07.png"/><fmt:message code="email.title.inbox" /><span>32</span></a></li>
								<li><a href="javascript:;"><img src="../img/icon_drafts_07.png"/><fmt:message code="email.title.draftbox" /><span>2</span></a></li>
								<li><a href="javascript:;"><img src="../img/icon_sent_07.png"/><fmt:message code="email.title.sent" /></a></li>
								<li><a href="javascript:;"><img src="../img/icon_dustbin_07.png"/><fmt:message code="email.title.wastebasket" /></a></li>
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
					<!-- <div class="back">
						<ul>
							<li class="replay"><img src="../img/icon_replay_03.png"/>回复</li>
							<li class="replayAll"><img src="../img/icon_replay_03.png"/>回复全部</li>
							<li><img src="../img/icon_print_07.png"/>打印邮件<img src="../img/icon_more_06.png" class="more_im" /></li>
						</ul>
						<div class="pages">
							<ul>
								<li class="fulls"><img src="../img/icon_fullscreen_03.png" alt="" /></li>
								<li>
									<img src="../img/icon_left_03.png" class="s_im"/>
									<span class="one">上一封</span>
									<span>下一封</span>
									<img src="../img/icon_right_03.png" class="s_im"/>
								</li>
								
							</ul>
						</div>
					</div>
				</div> -->
				<!-- <div class="details">
					<table cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
						<tr>
							<td width="8%">主&nbsp;&nbsp;&nbsp;题：</td>
							<td width="72%">通达全新OA可选组件-知己者费用管控系统</td>
							
						</tr>
						<tr>
							<td>发件人：</td>
							<td>张兰</td>
							
						</tr>
						<tr>
							<td>收件人：</td>
							<td>
								<span><img src="../img/icon_read_3_07.png"/>李佳</span>
								<span><img src="../img/icon_notread_1_03.png"/>王云</span>
								<span><img src="../img/icon_read_3_07.png"/>王德</span>
								<span><img src="../img/icon_notread_1_03.png"/>赵敏</span>
								<span><img src="../img/icon_read_3_07.png"/>刘娜</span>
							</td>
							
						</tr>
						<tr>
							<td>时&nbsp;&nbsp;&nbsp;间：</td>
							<td>2017年3月30日13:31（星期四）</td>
							
						</tr>
						<tr>
							<td>附&nbsp;&nbsp;&nbsp;件：</td>
							<td>
								<p>1个&nbsp;<img src="../img/icon_accessory_03.png"/><span>智能OA移动产品部3月23日任务工单.rar&nbsp;</span>(19.81KB)</p>
							</td>
							
						</tr>
						<tr>
							<td>关键词：</td>
							<td>财务&nbsp;业务&nbsp;信息&nbsp;数据&nbsp;预算&nbsp;&nbsp;&nbsp;(正文共536字)</td>
							
						</tr>
					</table>
					<span class="span_hr">
						<div><img src="../img/p1.jpg"/></div>
						<p>张兰&nbsp;&nbsp;研发总监</p>
						<p>研发部</p>
					</span>
					<div class="article">
						<p>随着企业的发展和不断壮大，企业的决策者对如何防止支付风险，加强费用控制，降低企业成本提出了更高的要求。为了满足用户的需求，通达成都研发中心研发了知己者费用管控系统，这款通达OA可选组件把管理制度，报销标准和审批制度相结合，支持第三方CRM、ERP、财务软件数据的调用，支持按预算、按申请单金额、按报销制度标准控制费用。为企业打造统一的财务共享服务信息系统平台，帮助企业实现操作模式标准化、业务流程标准化和财务制度标准化。</p>
						<p>知己者费用管控系统将企业的财务控制前移至业务前端，强化了事前的预算控制和业务控制，减少了人为的判断和控制，降低了企业对财务人员数量和质量的需求。系统提供了丰富的决策信息，通过与内外部系统的无缝对接，保证业务信息和财务信息在系统间及时准确的传递，减少业务流程步骤，提高数据传输效率，提升财务质量，便于管理层在流程中控制和监督业务执行情况，及时发现执行中存在的偏差。
</p>
					</div>
				</div>
			</div> -->
			<!--右侧侧边栏 结束-->
		</div>
		
		<script type="text/javascript">
    		
    		$(function(){
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
									for(var i=0;i<data1.length;i++){
										var sendTime=new Date(data1[i].sendTime).Format('yyyy-MM-dd hh:mm:ss');
										//alert(data1[i].sendTime);
										if(data1[i].emailList[0].readFlag==1){
											str+='<tr class="Hover"><td><input type="checkbox" name="checkbox" id="checkbox" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:center;"><a href="javascript:;">'+data1[i].subject+'</a></td><td>'+sendTime+'</td><td><img src="../img/icon_accessory_03.png"/></td></tr>';
										} else if(data1[i].emailList[0].readFlag==0){
											str+='<tr class="Hover"><td><input type="checkbox" name="checkbox" id="checkbox" value="" /></td><td><img src="../img/icon_notread_1_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:center;"><a href="javascript:;">'+data1[i].subject+'</a></td><td>'+sendTime+'</td><td><img src="../img/icon_accessory_03.png"/></td></tr>';
										}
										
									}
									$('.befor').after(str);
								}
				});
				
	    		
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
	    			var Ifrmae='<div class="div_iframe" style="width: 85%;overflow-y: auto;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="mailQuery" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
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
	    		
    		});
    		
    	</script>
	</body>
</html>