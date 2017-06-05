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
		<link rel="stylesheet" type="text/css" href="../lib/pagination/style/pagination.css"/>
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
		<script src="../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
		<style>
			.main_left .BTN:hover{background:#c5e9fb;}
			.attachment a{text-decoration: none;}
			.attachment a img{vertical-align: middle;}
			.befor .searchTxt{width:90%;height:30px;padding-left:5px;margin-bottom:5px;}
			/*.Hover{cursor: pointer;}*/
			/*.Hover  a{text-decoration: none;}*/
			.UP_INBOX .tab table .Hover:hover{background-color:#c5e9fb;}
			.Hover img{width:16px;}
			.on_tr{background-color: #c5e9fb !important;}
			.UP_INBOX,.UP_INBOX .tab,.UP_INBOX .tab table{width: 99%;}
			.UP_INBOX .tab table tr{border: 1px solid #c0c0c0;}
			.UP_INBOX .tab table tr th{color: #2F5C8F;font-weight: normal;}
			.UP_INBOX .tab table tr:nth-child(odd){background-color: #fff;}
			.UP_INBOX .tab table tr:nth-child(even){background-color: #F6F7F9;}
			.UP_INBOX .tab table tr th,.UP_INBOX .tab table tr td{padding:10px;}
			.UP_INBOX,.UP_INBOX .tab,.UP_INBOX .tab table tr th.theme{text-align: center}
			.UP_INBOX .tab table .theme_a a{text-decoration: none;text-align: left;display: block;color:#2B7FE0;}
			.M-box3{margin-top:10px;float:right;margin-right: 7px;}
			.M-box3 a{margin: 0 3px;width: 29px;height: 29px;line-height: 29px;font-size: 12px;text-decoration: none;}
			.M-box3 .active{margin: 0px 3px;width: 29px;height: 29px;line-height: 29px;background: #2b7fe0;font-size: 12px;border: 1px solid #2b7fe0;}
			.jump-ipt{margin: 0 3px;width: 29px;height: 29px;line-height: 29px;font-size: 12px;}
			.M-box3 a:hover{background: #2b7fe0;}
			.set_up_ul{font-size: 14px;border: #ccc 1px solid;border-radius: 5px;width: 80%;background-color: #fff;position: absolute;bottom: 42px;margin-left: 5px}
			.set_up_ul ul{list-style: none;}
			.set_up_ul ul li{width: 100%;text-align: center;color: #000;height:25px;line-height:25px;}
			.set_up_ul ul li:hover{background-color: #6ea1d5;color:#fff;cursor: pointer;}
			.RemoveTo_div{font-size: 12px;border: #ccc 1px solid;border-radius: 5px;min-width:160px;background-color: #fff;position: absolute;right: 23.3%;top: 45px;z-index: 9999;}
			.RemoveTo_div ul li{padding: 5px 10px;display:block;clear: both;}
			.RemoveTo_div .RemoveTo_child:hover{background-color: #6ea1d5;color:#fff;cursor: pointer;}
		</style>
		<script>
			$(function(){
                $('.setUp').click(function(e){
                    e.stopPropagation();
                    $('.set_up_ul').toggle();
                })
                $(document).click(function(){
                    if($('.set_up_ul').css('display')=='block'){
                        $('.set_up_ul').css('display','none');
                    }
                })
                //其他邮件箱
                otherMail();
				$('.page_left').on('click','li',function(){
                    $('.page_left li').removeClass('on');
                    $(this).addClass('on');
				})
				//其他邮件箱下的文件夹点击事件
				$('.divUlShow').on('click','li',function(){
                    if ($('.UP_INBOX').css('display')=='block'){
                        $('.UP_INBOX').hide();
                        $('.main').show().find('.otherMailFolder').show().siblings().hide();
                    }
                    $('.otherMailFolder').css('display','block').siblings().css('display','none');
					//console.log($('.otherMailFolder').siblings());
				    var id=$(this).attr('boxId');
                    otherList(id);
				})
				//其他邮件箱下的文件夹中列表邮件点击事件展示详情
				$('.main_left').on('click','.folderBtn',function(){
				    var emailId=$(this).find('input').attr('id');
                    folderDetails(emailId);
				})

				//点击移动按钮事件
				$('#RemoveTo').click(function(e){
                    e.stopPropagation();
				   	$('.RemoveTo_div').toggle();
				})
				$(document).click(function(){
				    if ($('.RemoveTo_div').css('display')=='block'){
                        $('.RemoveTo_div').css('display','none');
					}
				})
				//点击移动按钮下的文件夹
				$('.RemoveTo_div').on('click','.RemoveTo_child',function(){
				    var id=$(this).attr('boxId');
                    var MailId=$('.main_left .backing input').attr('id');
                    RemoveToMail(id,MailId);
				    //alert(MailId);
				})

			})
			function otherMail (){
			    var data={
			        'page':1,
					'pageSize':10,
					'useFlag':true
				}
			    $.ajax({
					type:'GET',
					url:'showEmailBox',
					dataType:'json',
					data:data,
					success:function(rsp){
					    var data1=rsp.obj;
					    var str='';
					    var str1='';
					    for(var i=0;i<data1.length;i++){
					        str+='<li boxId="'+data1[i].boxId+'"><a href="javascript:;"><img src="../img/icon_file_11.png"/>'+data1[i].boxName+'</a></li>';
							str1+='<li class="RemoveTo_child" boxId="'+data1[i].boxId+'">'+data1[i].boxName+'</li>';
						}
						$('.other .ul_show ul').append(str);
						$('.up_nav .RemoveTo_div ul').append(str1);
					}
				})
			}
			//其他邮件箱中文件夹的邮件列表展示
			function otherList(id){
                $('.BTN').remove();
			    var data={
			        'page':1,
					'pageSize':10,
					'useFlag':false,
					'boxId':id
				}
				$.ajax({
					type:'GET',
					url:'selectBoxEmail',
					dataType:'json',
					data:data,
					success:function(rsp){
                        var data1=rsp.obj;
                        ///console.log(data1);
                        var str='';
                        if (data1!=''){
                            $('.up_page_right').css('display','block');
                            for(var i=0;i<data1.length;i++){
                                var sendTime=new Date((data1[i].sendTime)*1000).Format('yyyy-MM-dd hh:mm');
                                if(data1[i].emailList[0].readFlag==1){
                                    if(data1[i].attachmentId!=''){
                                        str+='<li class="BTN folderBtn" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
                                    }else{
                                        str+='<li class="BTN folderBtn" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a></div></li>';
                                    }

                                } else if(data1[i].emailList[0].readFlag==0){
                                    if(data1[i].attachmentId!=''){
                                        str+='<li class="BTN folderBtn" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_notread_1_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
                                    }else{
                                        str+='<li class="BTN folderBtn" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_notread_1_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a></div></li>';
                                    }

                                }

                            }
                            $('.befor').after(str);
							$('li.BTN').eq(0).addClass('backing')
                            var emailId=$('.main_left .backing').find('input').attr('id');
                            folderDetails(emailId);
						}else{
                            $('.up_page_right').css('display','none');
                            var Ifrmaes='<div class="div_iframe" style="width: 82%;overflow: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="emptyFolder" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
							$('.page').append(Ifrmaes);
                        }

					}
				})
			}
			function folderDetails(eId){
                $.ajax({
                    type:'get',
                    url:'queryByID',
                    dataType:'json',
                    data:{'emailId':eId,'flag':''},
                    success:function(rsp){
                        var data2=rsp.object;
                        var sendTime=new Date((data2.sendTime)*1000).Format('yyyy-MM-dd hh:mm');
                        var str='';
                        var stra='';
                        var arr=new Array();
                        arr=data2.attachment;
                        $('#TAE').find('tr').remove();
                        $('.article3').find('p').remove();

                        $('.article3').find('div').remove();

                        if(data2.attachmentName!='' && data2.copyName!=''){
                            for(var i=0;i<arr.length;i++){
                                stra+='<div><a href="<%=basePath %>download?'+arr[i].attUrl+'"><img src="../img/icon_print_07.png"/>'+arr[i].attachName+'</a></div>';
                            }
                            str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td>抄送人：</td><td>'+data2.copyName+'</td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr><tr><td>附件：</td><td class="attachment">'+stra+'</td></tr>';
                        } else if(data2.attachmentName=='' && data2.copyName!=''){
                            str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td>抄送人：</td><td>'+data2.copyName+'</td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr>';
                        } else if(data2.attachmentName!='' && data2.copyName ==''){
                            for(var i=0;i<arr.length;i++){
                                stra+='<div><a href="<%=basePath %>download?'+arr[i].attUrl+'"><img src="../img/icon_print_07.png"/>'+arr[i].attachName+'</a></div>';
                            }
                            str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr><tr><td>附件：</td><td class="attachment">'+stra+'</td></tr>';
                        } else{
                            str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr>';
                        }

                        $('#TAE').append(str);
                        $('.article3').append('<p>'+data2.content+'</p>');
                    }
                });
			}
			function RemoveToMail (id,emailId){
			    var data={
			        'boxId':id,
					'emailId':emailId
				}
				$.ajax({
					type:'post',
					url:'updateEmailBox',
					dataType:'json',
					data:data,
					success:function(){
					    location.reload();
					}
				})
			}
		</script>
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
								<li id="InBox" class="on Inbox"><a href="javascript:;"><img src="../img/icon_inbox_07.png"/><fmt:message code="email.title.inbox" /><span></span></a></li>
								<li id="drafts"><a href="javascript:;"><img src="../img/icon_drafts_07.png"/><fmt:message code="email.title.draftbox" /><span></span></a></li>
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
						<div class="ul_show divUlShow">
							<ul>
								<%--<li><a href="javascript:;"><img src="../img/icon_file_11.png"/><fmt:message code="email.title.oneselffile" /></a></li>--%>
							</ul>
						</div>
						
					</div>
					<!--邮件智能分类-->
					<%--<div class="classify">
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
					</div>--%>
					<!--邮箱设置-->
					<div class="setUp">
						<a href="javascript:;">
							<img class="setUp_img" src="../img/icon_setmail_11.png"/>
							<span><fmt:message code="email.th.mailimpost" /></span>
							<img class="loding" src="../img/icon_refresh_11.png"/>
						</a>
						<div class="set_up_ul" style="display:none;">
							<ul>
								<li class="exceptLi">管理邮件箱</li>
								<%--<li>Internet邮箱</li>
								<li>导入Internet邮箱</li>
								<li>邮箱整理</li>
								<li>POP3设置</li>--%>
							</ul>
						</div>
					</div>
				</div>
			
			<!--左侧侧边栏 结束-->
			
			<!--右侧侧边栏 开始-->
			<div class="up_page_right">
				<div class="up_header">
					<div class="up_nav">
						<ul>
							<li id="allEmail" style="margin-right: 25%;"><img src="../img/icon_allmail_06.png" class="im"/><fmt:message code="email.th.allmail" /><img src="../img/icon_more_06.png" class="more_im"/></li>
							<%--<li onclick="clicked()"><img src="../img/icon_notread_06.png" class="im"/><fmt:message code="email.th.unread" /><span>3</span></li>--%>
							<li id="Replay"><img src="../img/icon_replay_03.png" class="im"/><fmt:message code="global.lang.reply" /></li>
							<li id="ReplayAll"><img src="../img/icon_replay_03.png" class="im"/><fmt:message code="email.th.replyall" /></li>
							<li id="Forward"><img src="../img/icon_transmit_06.png" class="im"/><fmt:message code="email.th.transmit" /></li>
							<li id="RemoveTo"><img src="../img/icon_move_06.png" class="im"/><fmt:message code="email.th.remove" /><img src="../img/icon_more_06.png" class="more_im"/></li>
							<li id="delete"><img src="../img/icon_delete_06.png" class="im"/><fmt:message code="global.lang.delete" /></li><%--<img src="../img/icon_more_06.png" class="more_im"/>--%>
							<%--<li onclick="clicked()"><fmt:message code="email.th.more" /><img src="../img/icon_more_06.png" class="am"/></li>--%>
						</ul>
						<div class="RemoveTo_div" style="display:none;">
							<ul>

							</ul>
						</div>
					</div>
					<div class="up_pages">
						<%--<div class="up_div_pages">
							<ul>
								<li onclick="clicked()"><img src="../img/icon_left_03.png"/><fmt:message code="email.th.beforemail" /><span>|</span></li>
								<li onclick="clicked()"><fmt:message code="email.th.nextmail" /><img src="../img/icon_right_03.png"/></li>
							</ul>
						</div>--%>
						<div class="up_format">
							<ul>
								<li class="for_on"><img src="../img/icon_zuoyou_sel_03.png"/></li>
								<li><img src="../img/iCon_list_003.png"/></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="main" style="display: block">
					<div class="main_left">
						<ul>
							<li class="befor">
								<div class="sort">
									<img class="Search" src="../img/icon_search_03(1).png"/>
									<img src="../img/icon_shuaxin_03.png"/>
									<img src="../img/icon_duoxuan_03.png"/>
								</div>
								<div class="sort_right">
									<img src="../img/icon_shaixuan_03.png"/><fmt:message code="email.th.order" />
								</div>
								<div style="display:none;" class="search_div">
									<input type="text" name="text" value="" class="searchTxt">
								</div>
							</li>
						</ul>
					</div>
					<div>
						<!-- 收件箱 -->
						<div class="main_right InBox">
						
							<table id="TAB" cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
								
							</table>
							<span class="span_hr">
								<div><img src="../img/p1.jpg"/></div>
								<p><span></span>&nbsp;&nbsp;<span class="zong"><fmt:message code="email.th.subject" /></span></p>
								<p><fmt:message code="email.th.dept" /></p>
							</span>
							<div class="article"></div>
						</div>

						<!-- 草稿箱 -->
						<div class="main_right drafts" style="display:none;">
						
							<table border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
								<tr class="append_tr">
									<td width="15%"><fmt:message code="email.th.recipients" />：</td>
									<td width="84%">
										<div class="inPole">
											<textarea name="txt" id="senduser" user_id='admin' value="" disabled></textarea>
											<span class="add_img">
												<!-- <span class="addImg">
													<img src="../img/org_select.png" class="addIcon"/>
												</span> -->
												<a href="javascript:;" id="selectUser" class="Add"><fmt:message code="global.lang.add" /></a>
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
										<input style="width: 153px;height: 30px;color:#000;" type="text" id="txt" value="" class="input_txt" />
										<%--<span class="import"><fmt:message code="email.th.conmmemail" /></span>--%>
									</td>
								</tr>
								<tr>
									<td width="15%">
										<p><fmt:message code="email.th.content" />：</p>
										<!-- <p class="Color"><fmt:message code="email.th.countnumber" />：<span>0</span></p> -->
										<p class="Color"><a href="javascript:;" onclick="empty()"><fmt:message code="global.lang.empty" /></a></p>
									</td>
									<td width="84%">
										<script id="container" style="width: 99.9%;min-height: 200px;" name="content" type="text/plain"></script>
									</td>
								</tr>
                                 <tr class="Attachmen" style="width:100%;">
                                     <td width="10%">附件：</td>
                                    <td width="89%"   class="files" id="files_txt"></td>
								</tr>
								<tr>
									<td><fmt:message code="email.th.filechose" />：</td>
									<td>
                                    	<form id="uploadimgform" target="uploadiframe" action="../upload?module=email" enctype="multipart/form-data" method="post" >
                                        	<input type="file" name="file" id="uploadinputimg"  class="w-icon5" style="display:none;">
                                        	<a href="javascript:;" id="uploadimg">上传</a>
                                        </form>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div class="div_btn" style="margin-left:46%;">
											<input type="button" id="btn1" style="cursor: pointer;width: 70px;border-radius: 5px;height: 30px;line-height: 30px;color: #000;" value="<fmt:message code="email.th.transmitimmediate" />" />
                                        	<input type="button" id="btn2" style="cursor: pointer;width: 90px;border-radius: 5px;height: 30px;line-height: 30px;color: #000;" value="<fmt:message code="email.th.savedraftbox" />" />
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
								
							</table>
	 							<div class="article2">
									
								</div>
						</div>

                        <!-- 其他邮件箱 -->
                        <div class="main_right otherMailFolder" style="display:none;">

                             <table id="TAE" cellspacing="0" cellpadding="0" style="border-collapse:collapse;">

                              </table>
                              <div class="article3">

                               </div>
                         </div>
					</div>
				</div>

                 <%--横版收件箱列表--%>
				<div class="main_right UP_INBOX" style="display:none;">
                       <div class="tab">
                             <table cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
                                   <tr class='tr_befor'>
                                        <th width="6%">
                                        <input type="checkbox" name="checkbox" id="checkbox" value="" style="width:13px;height:13px;" />
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
						<div>
                              <div class="M-box3"></div>
						</div>
                    </div>
			</div>
		</div>
		
		<script type="text/javascript">
             var user = 'senduser';
             var user_id='senduser';
			 var ue = UE.getEditor('container');
			 var res
			$(function () {
                var data={
                    "flag":"inbox",
                    "page":1,
                    "pageSize":10,
                    "useFlag":true
                }
                //选人控件
                $("#selectUser").on("click",function(){
                    $.popWindow("../common/selectUser");
                });
				//切换横版收件箱页面
				var oLI=$('.up_format ul li').eq(1);
				oLI.click(function () {
					$(this).addClass('for_on').find('img').attr('src','../img/icon_list_sel_03.png');
					$(this).siblings().removeClass('for_on');
					$(this).parent().find('li').eq(0).find('img').attr('src','../img/icon_zuoyou_03.png');

					$('.main').hide();
					$('.UP_INBOX').show();
                    $('.UP_INBOX').find('tr.Hover').remove();
                    HVersion (function(pageCount){
                        initPagination(pageCount,data.pageSize);
					});
                });
                //横版数据展示方法
                function HVersion(cb) {

                    $.ajax({
                        type:'get',
                        url:'showEmail',
                        dataType:'json',
                        data:data,
                        success:function(rsp){
                            var data1=rsp.obj;
                            var str='';
							$('.tab').find('.Hover').remove();
                            for(var i=0;i<data1.length;i++){
                                var sendTime=new Date((data1[i].sendTime)*1000).Format('yyyy-MM-dd');
                                if(data1[i].emailList[0].readFlag==1){
                                    if(data1[i].attachmentId!=''){
                                        str+='<tr class="Hover" Attr="'+data1[i].emailList[0].emailId+'" uId="'+data1[i].emailList[0].deleteFlag+'"><td><input type="checkbox" name="checkbox" id="checkbox" style="width:13px;height:13px;" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:left;"><a href="javascript:;">'+data1[i].subject+'</a></td><td>'+sendTime+'</td><td><img src="../img/icon_accessory_03.png"/></td></tr>';
                                    }else{
                                        str+='<tr class="Hover" Attr="'+data1[i].emailList[0].emailId+'" uId="'+data1[i].emailList[0].deleteFlag+'"><td><input type="checkbox" name="checkbox" id="checkbox" style="width:13px;height:13px;" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:left;"><a href="javascript:;">'+data1[i].subject+'</a></td><td>'+sendTime+'</td><td>&nbsp</td></tr>';
                                    }

                                } else if(data1[i].emailList[0].readFlag==0){
                                    if(data1[i].attachmentId!=''){
                                        str+='<tr class="Hover" Attr="'+data1[i].emailList[0].emailId+'" uId="'+data1[i].emailList[0].deleteFlag+'"><td><input type="checkbox" name="checkbox" id="checkbox" style="width:13px;height:13px;" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:left;"><a href="javascript:;">'+data1[i].subject+'</a></td><td>'+sendTime+'</td><td><img src="../img/icon_accessory_03.png"/></td></tr>';
                                    }else{
                                        str+='<tr class="Hover" Attr="'+data1[i].emailList[0].emailId+'" uId="'+data1[i].emailList[0].deleteFlag+'"><td><input type="checkbox" name="checkbox" id="checkbox" style="width:13px;height:13px;" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:left;"><a href="javascript:;">'+data1[i].subject+'</a></td><td>'+sendTime+'</td><td>&nbsp</td></tr>';
                                    }
                                }

                            }
                            $('.tr_befor').after(str);
                            if(cb){
                                cb(rsp.totleNum);
                            }
                            //initPagination(rsp.totleNum,data.pageSize);
                        }
                    });
                }
                //分页
                function initPagination(totalData,pageSize){
                    $('.M-box3').pagination({
                        totalData:totalData, //数据总条数
                        showData:pageSize,   //每页条目数
                        jump:true,
                        coping:true,
                        homePage:'<fmt:message code="global.page.first" />',
                        endPage:'<fmt:message code="global.page.last" />',
                        prevContent:'<fmt:message code="global.page.pre" />',
                        nextContent:'<fmt:message code="global.page.next" />',
                        jumpBtn:'<fmt:message code="global.page.jump" />',
                        callback:function(index){
                            data.page = index.getCurrent();
                            console.log(index.getCurrent());
                            HVersion();
                        }
                    });
                }
				//横版列表页面的列表详情
                $('.tab').on('click','tr.Hover',function () {
                    $(this).addClass('on_tr').siblings().removeClass('on_tr');
					var sId=$(this).attr('Attr');
					var flagId=$(this).attr('uId');
                    $('#delete').attr({'uId':sId,'del':flagId});

                })
				$('.tab').on('click','.theme_a',function(){

                    var atr=$(this).parents('tr').attr('Attr');
                    $.popWindow('details?id='+atr);
				})

                //切换竖版收件箱页面
                $('.up_format ul li:first-of-type').click(function () {
                    $(this).addClass('for_on').find('img').attr('src','../img/icon_zuoyou_sel_03.png');

                    $(this).siblings().removeClass('for_on');
                    $(this).parent().find('li').eq(1).find('img').attr('src','../img/iCon_list_003.png');
                    $('.main').show();
                    $('.UP_INBOX').hide();

                })
				if ($('.main').css('display')=='block'){
                    $('.up_format ul li:first-of-type').addClass('for_on').find('img').attr('src','../img/icon_zuoyou_sel_03.png');

                    $('.up_format ul li:first-of-type').siblings().removeClass('for_on');
                    $('.up_format ul li:first-of-type').parent().find('li').eq(1).find('img').attr('src','../img/iCon_list_003.png');
				}

				
				//与写邮件页面互调
				$('.d_im img').click(function(){
					var Ifrmae='<div class="div_iframe" style="width: 82%;overflow: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="addbox" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			//var Ifrmae='<div class="div_iframe" style="width: 82%;overflow-y: auto;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="addbox" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			$('.up_page_right').css('display','none');
	    			$('.page').append(Ifrmae);
	    		});
	    		$('.Inbox').click(function(){
	    			$('.page').find('.div_iframe').remove();
	    			$('.up_page_right').css('display','block');
	    		});

				//点击切换邮件箱管理页面
				$('.exceptLi').click(function(){
					//alert('1');
					$('.up_page_right').css('display','none');
                    var Ifrmae='<div class="div_iframe" style="width: 82%;overflow-y: hidden;overflow-x: hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="manageMail" frameborder="0" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
                    $('.page').append(Ifrmae);
					//$('.set_up_ul').css('display','none');
				})
				
				//查询邮件点击事件
				$('.liSearch').click(function(){
	    			var Ifrmae='<div class="div_iframe" style="width: 82%;overflow:hidden;float: left;height: 100%;"><div id="iframe1" class="iframe1" style="width: 100%;height: 100%;"><iframe  id="iframe_id" src="mailQuery" frameborder="0" height="100%" width="100%" noresize="noresize"></iframe></div></div>';
	    			$('.up_page_right').css('display','none');
	    			$('.page').append(Ifrmae);
	    		});
				
				
				//页面初始化
                showAjax('inbox','#TAB','.article');


				
				
				//收件箱点击事件
				$('#InBox').click(function(){
					$('.up_nav').find('li').css('display','block');
					$('.InBox').css('display','block').siblings().css('display','none');
					showAjax('inbox','#TAB','.article');
					
				});
				
				showAjax2('drafts');
				//草稿箱点击事件
				$('#drafts').click(function(){
					$('#allEmail').css('display','block');
					$('#delete').css('display','block');
                    $('#Replay').css('display','none');
                    $('#ReplayAll').css('display','none');
                    $('#Forward').css('display','none');
					$('#RemoveTo').css('display','none');
					if ($('.UP_INBOX').css('display')=='block'){
						$('.UP_INBOX').hide();
						$('.main').show().find('.drafts').show().siblings().hide();
					}
					$('.drafts').css('display','block').siblings().css('display','none');
					showAjax2('drafts');
					$('.main_left').on('click','.BTN',function(){
						var nId=$(this).find('input').attr('nId');
						$.ajax({
									type:'get',
									url:'queryByID',
									dataType:'json',
									data:{'bodyId':nId,'flag':''},
									success:function(rsp){
										var data2=rsp.object;
										var atta=data2.attachment;
										var str='';
                                        $('textarea').val('');
                                        $('#txt').val('');
                                        ue.setContent('');
                                        $('#senduser').val('');
                                        $('.Attachmen td').eq(1).find('a').remove();
										for(var i=0;i<atta.length;i++){
											str+='<a href="<%=basePath %>download?'+atta[i].attUrl+'" style="text-decoration: none;margin-left: 5px">'+atta[i].attachName+'</a>';
										}
                                        $('#senduser').val(data2.toName);
										$('#txt').val(data2.subject);
										ue.setContent(data2.content);
										$('.Attachmen td').eq(1).append(str);
									}
						});
						
						$('#delete').attr('uId',nId);
						
					});	
				});
				
				//已发送点击事件
				$('#hasBeenSend').click(function(){
					$('#Forward').css('display','block');
                    $('#delete').css('display','block');
                    $('#Replay').css('display','none');
                    $('#ReplayAll').css('display','none');
                    $('#RemoveTo').css('display','none');
                    if ($('.UP_INBOX').css('display')=='block'){
                        $('.UP_INBOX').hide();
                        $('.main').show().find('.hasBeenSend').show().siblings().hide();
                    }
					
					$('.hasBeenSend').css('display','block').siblings().css('display','none');
					showAjax3("outbox");
					
					$('.main_left').on('click','.BTN',function(){
						var nId=$(this).find('input').attr('nId');
						init3(nId);
						var dele=$(this).find('input').attr('ueId');
						$('#delete').attr({'uId':nId,'del':dele});
					});
				});
				
				//废纸篓点击事件
				$('#wastebasket').click(function(){
                    $('#allEmail').css('display','block');
                    $('#delete').css('display','block');
                    $('#Replay').css('display','none');
                    $('#ReplayAll').css('display','none');
                    $('#Forward').css('display','none');
                    $('#RemoveTo').css('display','none');
                    if ($('.UP_INBOX').css('display')=='block'){
                        $('.UP_INBOX').hide();
                        $('.main').show().find('.wastebasket').show().siblings().hide();
                    }

					$('.wastebasket').css('display','block').siblings().css('display','none');
					
					showAjax1('recycle','#TAD','.article2');
					$('.main_left').on('click','.BTN',function(){
						var nId=$(this).find('input').attr('id');
						var dele=$(this).find('input').attr('ueId');
						init(nId,'#TAD','.article2');
						$('#delete').attr({'uId':nId,'del':dele});
					});
					
				});
				
				 //详情点击事件
				$('.main_left').on('click','.BTN',function(){
				
					$(this).addClass("backing").siblings("li").removeClass("backing");
					var nId=$(this).find('input').attr('id');
					var dele=$(this).find('input').attr('ueId');
					init(nId,'#TAB','.article');
					$('#delete').attr({'uId':nId,'del':dele});
				}); 
				
				//删除事件
				 $('#delete').click(function(){

                     var sId=$('.main_left .backing input').attr('id');
                     var ueID=$('.main_left .backing input').attr('ueId');
					 var bodyId=$('.main_left .backing input').attr('nId');

					if($('.InBox').css('display')=='block'){
						deleted('inbox',sId,ueID);
						$('.InBox').css('display','block').siblings().css('display','none');
					} else if($('.hasBeenSend').css('display')=='block'){
						deleted('outbox',bodyId,ueID);
						$('.hasBeenSend').css('display','block').siblings().css('display','none');
					} else if($('.wastebasket').css('display')=='block'){
						deleted('recycle',sId,ueID);
						$('.wastebasket').css('display','block').siblings().css('display','none');
					} else if($('.drafts').css('display')=='block'){
						deleted1(bodyId);
						$('.drafts').css('display','block').siblings().css('display','none');
					} else if($('.UP_INBOX').css('display')=='block'){
                        deleted('inbox',sId,ueID);
                        $('.UP_INBOX').show();
                        $('.main').hide();
					}
				})
				
				//回复事件
				$('#Replay').click(function(){
					var sId=$('.main_left .backing input').attr('id');
					$.popWindow('writeEmail?sId=' + sId+'&type=0','<fmt:message code="global.lang.reply" />','0','0','1500px','800px');
				});
				//回复全部事件
				$('#ReplayAll').click(function(){
                   var sId=$('.main_left .backing input').attr('id');
                    $.popWindow('writeEmail?sId=' + sId+'&type=1','<fmt:message code="global.lang.reply" />','0','0','1500px','800px');
				})
				//转发事件
				$('#Forward').click(function(){
                    var sId=$('.main_left .backing input').attr('id');
					var nId=$('.main_left .backing input').attr('nId');
                    if($('.InBox').css('display')=='block'){
                        $.popWindow('writeEmail?sId=' + sId+'&type=2','<fmt:message code="global.lang.reply" />','0','0','1500px','800px');
					}else if($('.hasBeenSend').css('display')=='block'){
                        $.popWindow('writeEmail?sId=' + nId+'&type=3','<fmt:message code="global.lang.reply" />','0','0','1500px','800px');
					}

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
                    if(file){
                        $.upload($('#uploadimgform'),function(res){
                            var data=res.obj;
                            var str='';
                            var str1='';
                            for(var i=0;i<data.length;i++){
                                str+='<a href="<%=basePath %>download?'+data[i].attUrl+'" NAME="'+data[i].attachName+'*" style="text-decoration: none;margin-left: 5px">'+data[i].attachName+'</a>';
                                str1+='<input type="hidden" class="inHidden" value="'+data[i].aid+'@'+data[i].ym+'_'+data[i].attachId+',">';
                            }
                            $('.Attachmen td').eq(1).append(str+str1);
                        });
                    }
                });
					//草稿箱点击立即发送
					$('#btn1').click(function(){
						var bodyId=$('.main_left .backing').find('input').attr('nId');
                        var dataId1=$('.inPole').find('#senduser').attr('user_id');
                        var dataId2=$('.tian').find('#copeNameText').attr('user_id');
                        var dataId3=$('.mis').find('#secritText').attr('user_id');
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
							'bodyId':bodyId,
                            'sendFlag':0,
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
                            success:function(rsp){
                                if(rsp.flag == true){
                                    alert('发送成功');
                                    location.reload();
                                }else{
                                    alert('发送失败');
                                }
                            }
                        });
					})
				//草稿箱点击保存到草稿箱
				$('#btn2').click(function(){
                    var bodyId=$('.main_left .backing').find('input').attr('nId');
                    var dataId1=$('.inPole').find('#senduser').attr('user_id');
                    var dataId2=$('.tian').find('#copeNameText').attr('user_id');
                    var dataId3=$('.mis').find('#secritText').attr('user_id');
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
						'bodyId':bodyId,
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
                        url:'saveEmail',
                        dataType:'json',
                        data:data,
                        success:function(){
                            alert('已保存到草稿箱');
                            location.reload()
                        }
                    });
				})
				
			});
			
			
				
				//收件箱列表初始化展示方法
				function showAjax(flag,obj,cName){
					$('.BTN').remove();
					var data1={
						"flag":flag,
						"page":1,
						"pageSize":100,
						"useFlag":true
					};	
					
					$.ajax({
									type:'get',
									url:'showEmail',
									dataType:'json',
									data:data1,
									success:function(rsp){
										var data1=rsp.obj;
										var str='';
										$('#InBox a span').text('');
										$('#InBox a span').append(rsp.totleNum);
										for(var i=0;i<data1.length;i++){
											var sendTime=new Date((data1[i].sendTime)*1000).Format('yyyy-MM-dd hh:mm');
											
											if(data1[i].emailList[0].readFlag==1){
												if(data1[i].attachmentId!=''){
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
												}else{
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a></div></li>';
												}
												
											} else if(data1[i].emailList[0].readFlag==0){
												if(data1[i].attachmentId!=''){
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_notread_1_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
												}else{
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_notread_1_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a></div></li>';
												}
												
											}
											
										}
										$('.befor').after(str);
										$('li.BTN').eq(0).addClass("backing");
										var mId=$('li.BTN').eq(0).find('input').attr('id');
										
										init(mId,obj,cName);
									}
					});
				}
				
				//废纸篓列表展示方法
				function showAjax1(flag,obj,cName){
					$('.BTN').remove();
					var data1={
						"flag":flag,
						"page":1,
						"pageSize":100,
						"useFlag":true
					};	
					
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
											
											if(data1[i].emailList[0].readFlag==1){
												if(data1[i].attachmentId!=''){
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
												}else{
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a></div></li>';
												}
												
											} else if(data1[i].emailList[0].readFlag==0){
												if(data1[i].attachmentId!=''){
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_notread_1_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
												}else{
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_notread_1_03.png"/><img src="../img/icon_star_kong_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a></div></li>';
												}
												
											}
											
										}
										$('.befor').after(str);
										$('li.BTN').eq(0).addClass("backing");
										var mId=$('li.BTN').eq(0).find('input').attr('id');
										
										init(mId,obj,cName);
									}
					});
				}
				
				//草稿箱列表展示方法
				function showAjax2(flag){
					$('.BTN').remove();
							var data={
								"flag":flag,
								"page":1,
								"pageSize":100,
								"useFlag":true
						};
						$.ajax({
									type:'get',
									url:'showEmail',
									dataType:'json',
									data:data,
									success:function(rsp){
										var data1=rsp.obj;
										var str='';
										$('#drafts a span').text('');
										$('#drafts a span').append(rsp.totleNum);
										
										for(var i=0;i<data1.length;i++){
											var sendTime=new Date((data1[i].sendTime)*1000).Format('yyyy-MM-dd hh:mm');
												if(data1[i].attachmentId!=''){
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_collect_nor_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
												}else{
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_collect_nor_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a></div></li>';
												}
										}
										$('.main_left ul .befor').after(str);
										$('li.BTN').eq(0).addClass("backing");
										var nID=$('li.BTN').eq(0).find('input').attr('nId');
										//init3(nID);
									}
						});
				}
				
				//已发送列表展示方法
				function showAjax3(flag){
					$('.BTN').remove();
							var data={
								"flag":flag,
								"page":1,
								"pageSize":100,
								"useFlag":true
						};
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
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_collect_nor_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a><img src="../img/icon_accessory_03.png"/></div></li>';
												}else{
													str+='<li class="BTN" style="cursor: pointer;"><input type="hidden" nId="'+data1[i].bodyId+'" id="'+data1[i].emailList[0].emailId+'" ueId="'+data1[i].emailList[0].deleteFlag+'"><div class="shang"><span>'+data1[i].users.userName+'</span><img src="../img/icon_read_2_03.png"/><img src="../img/icon_collect_nor_03.png"/><span class="time">'+sendTime+'</span></div><div class="xia"><a href="javascript:;" class="xia_txt">'+data1[i].subject+'</a></div></li>';
												}
										}
										$('.main_left ul .befor').after(str);
										$('li.BTN').eq(0).addClass("backing");
										var nID=$('li.BTN').eq(0).find('input').attr('nId');
										init3(nID);
									}
						});
				}
				
				
			//收件箱、废纸篓详情展示方法
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
									var stra='';
									var arr=new Array();
									arr=data2.attachment;
									$(obj).find('tr').remove();
									$(cName).find('p').remove();

                                    $(cName).find('div').remove();
									$('.span_hr').find('p').find('span').eq(0).html('');
									
									if(data2.attachmentName!='' && data2.copyName!=''){
										for(var i=0;i<arr.length;i++){
											stra+='<div><a href="<%=basePath %>download?'+arr[i].attUrl+'"><img src="../img/icon_print_07.png"/>'+arr[i].attachName+'</a></div>';
										}
										str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td>抄送人：</td><td>'+data2.copyName+'</td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr><tr><td>附件：</td><td class="attachment">'+stra+'</td></tr>';
									} else if(data2.attachmentName=='' && data2.copyName!=''){
										str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td>抄送人：</td><td>'+data2.copyName+'</td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr>';
									} else if(data2.attachmentName!='' && data2.copyName ==''){
										for(var i=0;i<arr.length;i++){
											stra+='<div><a href="<%=basePath %>download?'+arr[i].attUrl+'"><img src="../img/icon_print_07.png"/>'+arr[i].attachName+'</a></div>';
										}
										str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr><tr><td>附件：</td><td class="attachment">'+stra+'</td></tr>';
									} else{
										str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr>';
									}

									$(obj).append(str);
									$(cName).append('<p>'+data2.content+'</p>');
									$('.span_hr').find('p').find('span').eq(0).html(data2.users.userName);
								}
					});
				}
				
				//已发送详情展示方法
				function init3(id){
					//alert(id)
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
										$('.article1').find('div').remove();
										
										$('#TAC').find('tr').eq(0).append('<td width="72%">'+data2.subject+'</td>');
										$('#TAC').find('tr').eq(1).append('<td><span><img src="../img/icon_read_3_07.png"/>'+data2.toName+'</span></td>');
										$('#TAC').find('tr').eq(2).append('<td>'+sendTime+'</td>');
										$('.article1').append('<p>'+data2.content+'</p>');
									}
						});
				} 
				
				//单条数据删除事件
				function deleted(flag,sId,ueID){
					 var data={
						"flag":flag,
						"emailID":sId,
						"deleteFlag":ueID
					}
					var msg='<fmt:message code="global.lang.sure" />';
					if (confirm(msg)==true){
					  	$.ajax({
							type:'get',
							url:'deleteEmail',
							dataType:'json',
							data:data,
							success:function(){
								location.reload();
							}
						}) ; 
						return true;
					 }else{ 
					 	return false; 
					 }
				}
				
				//草稿箱删除单条数据
				function deleted1(bId){
					 var data={
						"bodyId":bId,
					}
					var msg='<fmt:message code="global.lang.sure" />';
					if (confirm(msg)==true){
					  	$.ajax({
							type:'get',
							url:'deleteDraftsEmail',
							dataType:'json',
							data:data,
							success:function(){
								location.reload();
							}
						}) ; 
						return true;
					 }else{ 
					 	return false; 
					 }
				}



				//ue编辑器清空方法
				function empty(){
					ue.setContent('');
				}
				
				//正在开发中
				function clicked(){
					layer.msg('<fmt:message code="global.lang.doing" />', {icon: 6});
				}
		</script>
		
	</body>
</html>

