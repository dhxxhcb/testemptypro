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
		<title>收件箱</title>
		<meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<link rel="stylesheet" type="text/css" href="../css/email/inbox.css"/>
		<link rel="stylesheet" type="text/css" href="../css/email/inbox-upright.css"/>
		<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/email/inbox.js" type="text/javascript" charset="utf-8"></script>
		
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
							<div class="inbox_btn_tim div_down">邮件箱</div>
						</a>
						<div class="ul_show" style="display: block;">
							<ul>
								<li class="on Inbox"><a href="javascript:;"><img src="../img/inbox.png"/>收件箱<span>32</span></a></li>
								<li><a href="javascript:;"><img src="../img/icon_drafts_07.png"/>草稿箱<span>2</span></a></li>
								<li><a href="javascript:;"><img src="../img/icon_sent_07.png"/>已发送</a></li>
								<li><a href="javascript:;"><img src="../img/icon_dustbin_07.png"/>废纸篓</a></li>
								<li><a href="javascript:;"><img src="../img/icon_search_03.png"/>查询邮件</a></li>
							</ul>
						</div>
					</div>
					<!--其他邮件箱-->
					<div class="other">
						<a href="javascript:;" class="inbox_btn">
							<div class="inbox_btn_tim div_up">其他邮件箱</div>
						</a>
						<div class="ul_show">
							<ul>
								<li><a href="javascript:;"><img src="../img/icon_file_11.png"/>自己文件夹</a></li>
							</ul>
						</div>
						
					</div>
					<!--邮件智能分类-->
					<div class="classify">
						<a href="javascript:;" class="inbox_btn">
							<div class="inbox_btn_tim div_up">邮件智能分类</div>
						</a>
						<div class="ul_show spac_show">
							<ul>
								<li><a href="javascript:;"><span>关键词Tag云图</span></a></li>
								<li><a href="javascript:;"><span>日程</span></a></li>
								<li><a href="javascript:;"><span>会议</span></a></li>
								<li><a href="javascript:;"><span>日志</span></a></li>
								<li><a href="javascript:;"><span>汇报</span></a></li>
								<li><a href="javascript:;"><span>计划</span></a></li>
								<li><a href="javascript:;"><span>通知</span></a></li>
								<li><a href="javascript:;"><span>新闻</span></a></li>
								<li><a href="javascript:;"><span>公文</span></a></li>
								<li><a href="javascript:;"><span>项目</span></a></li>
								<li><a href="javascript:;"><span>人事</span></a></li>
								<li><a href="javascript:;"><span>考核</span></a></li>
								<li><a href="javascript:;"><span>报表</span></a></li>
								<li><a href="javascript:;"><span>工作流</span></a></li>
								<li><a href="javascript:;"><span>客户</span></a></li>
								<li><a href="javascript:;"><span>合同</span></a></li>
							</ul>
						</div>
					</div>
					<!--邮箱设置-->
					<div class="setUp">
						<a href="javascript:;">
							<img class="setUp_img" src="../img/icon_setmail_11.png"/>
							<span>邮箱设置</span>
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
						<div class="up_format">
							<ul>
								<li><img src="../img/icon_list_nor_06.png"/></li>
								<li><img src="../img/icon_shangxia_nor_06.png"/></li>
								<li class="for_on"><img src="../img/icon_zuoyou_sel_03.png"/></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="main">
					<div class="main_left">
						<ul>
							<li>
								<div class="sort">
									<img src="../img/icon_search_03(1).png"/>
									<img src="../img/icon_shuaxin_03.png"/>
									<img src="../img/icon_duoxuan_03.png"/>
									
								</div>
								<div class="sort_right">
									<img src="../img/icon_shaixuan_03.png"/>排序
								</div>
							</li>
							<li class="tile">今日</li>
							<li>
								<div class="shang">
									<span>张兰</span>
									<img src="../img/icon_read_3_07.png"/>
									<img src="../img/icon_collect_nor_03.png"/>
									<span class="time">13:31</span>
								</div>
								<div class="xia">
									<span class="xia_txt">通达全新OA可选组件-知己者费用管控系统</span>
									<img src="../img/icon_accessory_03.png"/>
								</div>
							</li>
							<li>
								<div class="shang">
									<span>张兰</span>
									<img src="../img/icon_read_3_07.png"/>
									<img src="../img/icon_collect_nor_03.png"/>
									<span class="time">13:31</span>
								</div>
								<div class="xia">
									<span class="xia_txt">通达全新OA可选组件-知己者费用管控系统</span>
									<img src="../img/icon_accessory_03.png"/>
								</div>
							</li>
							<li class="tile">更早</li>
							<li>
								<div class="shang">
									<span>张兰</span>
									<img src="../img/icon_read_3_07.png"/>
									<img src="../img/icon_collect_nor_03.png"/>
									<span class="time">13:31</span>
								</div>
								<div class="xia">
									<span class="xia_txt">通达全新OA可选组件-知己者费用管控系统</span>
									<img src="../img/icon_accessory_03.png"/>
								</div>
							</li>
						</ul>
					</div>
					<div class="main_right">
					
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
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			$(function () {
				//与写邮件页面互调
				$('.d_im img').click(function(){
	    			var Ifrmae='<div class="div_iframe" style="width: 85%;overflow-y: auto;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="writeMail" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			$('.page_right').css('display','none');
	    			$('.page').append(Ifrmae);
	    		});
	    		$('.Inbox').click(function(){
	    			$('.page').find('.div_iframe').remove();
	    			$('.page_right').css('display','block');
	    		})
			
				//不同风格页面互调
				var oLI=$('.up_format ul li').eq(1);
				oLI.click(function () {
					$(this).addClass('for_on').find('img').attr('src','img/icon_shangxia_sel_06.png');
					
					$(this).siblings().removeClass('for_on');
					$(this).parent().find('li').eq(2).find('img').attr('src','img/icon_zuoyou_nor_06.png');
					window.location.href='index';
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
								data:data1,
								success:function(rsp){
									
								}
				})
				
			});
		</script>
		
	</body>
</html>

