<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<link rel="stylesheet" type="text/css" href="../css/inbox.css"/>
		<script src="../lib/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/inbox.js" type="text/javascript" charset="utf-8"></script>
		
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
								<li class="on"><a href="javascript:;"><img src="../img/inbox.png"/>收件箱<span>32</span></a></li>
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
			<div class="page_right">
				<div class="header">
					<div class="nav">
						<ul>
							<li><img src="../img/icon_allmail_06.png"/>全部邮件<img src="../img/icon_more_06.png" class="more_im"/></li>
							<li><img src="../img/icon_notread_06.png"/>未读<span>3</span></li>
							<li><img src="../img/icon_transmit_06.png"/>转发</li>
							<li><img src="../img/icon_move_06.png"/>移动到<img src="../img/icon_more_06.png" class="more_im"/></li>
							<li><img src="../img/icon_delete_06.png"/>删除<img src="../img/icon_more_06.png" class="more_im"/></li>
							<li>更多<img src="../img/icon_more_06.png" class="more_im"/></li>
						</ul>
					</div>
					<div class="searchs">
						<div class="search_div">
							<img src="../img/icon_search_2_06.png"/>
							<input type="search" name="search" id="search" placeholder="搜索" />
							
						</div>
						<div class="format">
							<ul>
								<li><img src="../img/icon_list_nor_06.png"/></li>
								<li class="for_on"><img src="../img/icon_shangxia_sel_06.png"/></li>
								<li><img src="../img/icon_zuoyou_nor_06.png"/></li>
							</ul>
						</div>
						
					</div>
				</div>
				<div class="tab">
					<table cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
						<tr>
							<th width="6%">
								<input type="checkbox" name="checkbox" id="checkbox" value="" />
							</th>
							<th width="6%">
								<img src="../img/icon_read_1_07.png"/>
							</th>
							<th width="6%">
								<img src="../img/icon_collect_07.png"/>
							</th>
							<th width="6%">发件人</th>
							<th width="58%" class="theme">主题</th>
							<th width="12%">日期</th>
							<th width="6%">附件</th>
						</tr>
						<tr>
							<td class="title" colspan="7">今日</td>
						</tr>
						<tr class="Hover">
							<td width="6%">
								<input type="checkbox" name="checkbox" id="checkbox" value="" />
							</td>
							<td width="6%">
								<img src="../img/icon_read_3_07.png"/>
							</td>
							<td width="6%">
								<img src="../img/icon_collect_nor_03.png"/>
							</td>
							<td width="6%">张兰</td>
							<td width="58%" class="theme">通达全新OA可选组件-知己者费用管控系统</td>
							<td width="12%">2017年3月30日</td>
							<td width="6%">
								<img src="../img/icon_accessory_03.png"/>
							</td>
						</tr>
						<tr class="Hover">
							<td width="6%">
								<input type="checkbox" name="checkbox" id="checkbox" value="" />
							</td>
							<td width="6%">
								<img src="../img/icon_notread_1_03.png"/>
							</td>
							<td width="6%">
								<img src="../img/icon_collect_nor_03.png"/>
							</td>
							<td width="6%">张兰</td>
							<td width="58%" class="theme">诚邀您参与通达密信试用并提出宝贵意见建议</td>
							<td width="12%">2017年3月30日</td>
							<td width="6%"></td>
						</tr>
						<tr>
							<td class="title" colspan="7">更早</td>
						</tr>
						<tr class="Hover">
							<td width="6%">
								<input type="checkbox" name="checkbox" id="checkbox" value="" />
							</td>
							<td width="6%">
								<img src="../img/icon_read_3_07.png"/>
							</td>
							<td width="6%">
								<img src="../img/icon_collect_07.png"/>
							</td>
							<td width="6%">张兰</td>
							<td width="58%" class="theme">通达IT精英魔鬼训练营，招募中！</td>
							<td width="12%">2017年3月17日</td>
							<td width="6%">
								<img src="../img/icon_accessory_03.png"/>
							</td>
						</tr>
					</table>
					<div class="back">
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
				</div>
				<div class="details">
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
			<!--右侧侧边栏 结束-->
		</div>
		<script type="text/javascript">
    		
    		$(function(){
	    			$.ajax({
							type:"post",
							url:"deleteMessage",
							dataType:'json',
							success:function(){
								console.log('12');	
						}
					});
	    		
	    		$('.d_im img').click(function(){
	    			 window.location.href="email/addbox";
	    		});
    		});
    		
    	</script>
	</body>
</html>

