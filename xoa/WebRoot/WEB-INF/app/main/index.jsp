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
		<title>首页</title>
		<meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		
		<link rel="stylesheet" type="text/css" href="css/main/theme1/bootstrap-responsive.min.css"/>
		
		<link rel="stylesheet" type="text/css" href="css/main/theme1/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/main/theme1/index.css"/>
		<script type="text/javascript" src="js/jquery-1.9.1.js"></script>  
		<script type="text/javascript" src="js/main_js/index.js"></script>  
		<!-- <script src="js/jquery.js"></script> -->
		<script src="js/base/base.js"></script>
	</head>
	<body>
		<div class="wrap">
			<div class="head">
				<div class="head_left"><img src="img/main_img/LOGO.png" style="margin-top:2%;width:72%;height:75%;
    margin-left: 8%;"></div>
				<div class="head_mid">
					<div class="left_scroll"></div>
					<ul class="main_title">
						<!-- <li style="background:#eef1f8;"><h1>首页标签</h1><img src="img/main_img/icon.png"></li> -->
						<li class="gongzuoliu" left='0' id='t_0'><div class="img"><img class="close" src="img/main_img/icon.png"></div><h1>我的桌面</h1></li>
					</ul>
					<div class="right_scroll"></div>
				</div>
				<!-- 右侧的小logo -->
				<div id="taskbar_right" class="head_rig">
			         <a id="task_center" href="javascript:;" hidefocus="hidefocus" title="搜索" data-step="5" data-intro="<b style='display:block'>搜索</b>点击进入“任务中心”，可以看到按时间和紧急程度排序的待办任务，并可快速建立任务" data-position="left"></a>
			         <a id="sns" href="javascript:;" hidefocus="hidefocus" title="提醒" data-step="6" data-intro="<b style='display:block'>提醒 </b>点击进入“企业社区”，促进企业信息交流与知识共享" data-position="left"></a>
			         <a id="help" href="/module/help/" hidefocus="hidefocus" title="主题 " data-step="7" data-intro="<b style='display:block'>主题 </b>“通达OA在线帮助”汇集了常见的用户问题，帮助用户快速掌握软件各项功能的使用" data-position="left" target="_blank"></a>
			         <a id="person_info" href="javascript:;" hidefocus="hidefocus" title="设置" data-step="8" data-intro="<b style='display:block'>设置</b>点击进入“控制面板”，可以进行界面设置、个人信息设置、账号与安全设置" data-position="left"></a>
			         <a id="theme" href="javascript:;" hidefocus="hidefocus" title="注销" data-step="9" data-intro="<b style='display:block'>更换皮肤</b>通达OA为您提供了完备的界面换肤功能，通过“更换皮肤”按钮，一触即换" data-position="left"></a>
			         
		      	</div>
			</div>
			<div class="cont" id="client">
				<div class="cont_left">
					<ul class="all_ul">
						<div class="tab_t">
							<ul class="top_ul">
								<li class="yingy" id="use">应用</li>
								<li id="orgnize">组织</li>
							</ul>
						</div>
						<div class="tab_c list">
						
								<ul class="tab_cone a yiji" >
								
								</ul>
						
							<ul class="tab_ctwo a" style="display:none;">
								<li>
									<span class="dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span class="dynatree-checkbox"></span><img src="img/main_img/company_logo.png" alt=""><a href="#" class="dynatree-title" title="中国兵器工业集团">中国兵器工业集团</a></span>
									<ul style="margin-left:10%;">
										<li><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-exp-cd dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="中国兵器工业信息中心">中国兵器工业信息中心</a></span>
											<ul style="margin-left:10%;">
												<li><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-lastsib dynatree-exp-cdl dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="北京通达信科科技有限公司">北京通达信科科技有限公司</a></span>
													<ul style="margin-left:10%;">
														<li class="dynatree-lastsib"><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-lastsib dynatree-exp-cdl dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="总经理">总经理</a></span>
															<ul style="margin-left:10%;">
																<li class=""><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-exp-cd dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="综合管理部">综合管理部</a></span>
																	<ul style="margin-left:10%;">
																		<li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="人力资源部">人力资源部</a></span>
																		</li>
																		<li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="财务部">财务部</a></span>
																		</li>
																		<li class="dynatree-lastsib"><span class="dynatree-node dynatree-folder dynatree-lastsib dynatree-exp-cl dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="行政部">行政部</a></span>
																		</li>
																	</ul>
																</li>
																<li class=""><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-exp-cd dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="市场营销部">市场营销部</a></span>
																	<ul style="margin-left:10%;">
																		<li class=""><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-exp-c dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="市场部">市场部</a></span>
																			<ul style="display: none;">
																				<li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="品牌部">品牌部</a></span>
																				</li>
																				<li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="网络营销中心">网络营销中心</a></span>
																				</li>
																				<li class="dynatree-lastsib"><span class="dynatree-node dynatree-folder dynatree-lastsib dynatree-exp-cl dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="商务中心">商务中心</a></span>
																				</li>
																			</ul>
																			</li>
																			<li class="dynatree-lastsib"><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-lastsib dynatree-exp-cdl dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="销售部">销售部</a></span>
																			</li>
																	</ul>
																</li>
																<li class=""><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-exp-cd dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="研发部">研发部</a></span>
																	<ul style="margin-left:10%;">
																		<li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="产品部">产品部</a></span>
																		</li>
																		<li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="开发一部">开发一部</a></span>
																		</li>
																		<li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="开发二部">开发二部</a></span>
																		</li>
																		<li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="质量保证部">质量保证部</a></span>
																		</li>
																		<li class="dynatree-lastsib"><span class="dynatree-node dynatree-folder dynatree-lastsib dynatree-exp-cl dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="设计部">设计部</a></span>
																		</li>
																	</ul>
																</li>
																<li class=""><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-exp-cd dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="项目部">项目部</a></span>
																	<ul style="margin-left:10%;">
																		<li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="项目一部">项目一部</a></span>
																		</li>
																		<li class="dynatree-lastsib"><span class="dynatree-node dynatree-folder dynatree-lastsib dynatree-exp-cl dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="项目二部">项目二部</a></span>
																		</li>
																	</ul>
																</li>
																<li class="dynatree-lastsib"><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-lastsib dynatree-exp-cdl dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="生产部">生产部</a></span>
																	<ul style="margin-left:10%;">
																		<li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="采购部">采购部</a></span></li><li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="生产一部">生产一部</a></span>
																		</li>
																		<li class=""><span class="dynatree-node dynatree-folder dynatree-exp-c dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="生产二部">生产二部</a></span>
																		</li>
																		<li class="dynatree-lastsib"><span class="dynatree-node dynatree-folder dynatree-lastsib dynatree-exp-cl dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="质检部">质检部</a></span>
																		</li>
																	</ul>
																</li>
															</ul>
														</li>
													</ul>
												</li>
											</ul>
										</li>
										<li><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-lastsib dynatree-exp-cdl dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="北方测试研究公司">北方测试研究公司</a></span>
											<ul style="margin-left:10%;">
												<li><span class="dynatree-node dynatree-folder dynatree-lastsib dynatree-exp-cl dynatree-ico-cf"><span class="dynatree-connector"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="北一测试研究院">北一测试研究院</a></span></li>
											</ul>
										</li>
									</ul>
								</li>
							
							</ul>
							
						</div>
						
					</ul>
				</div>
				<div class="cont_rig">
					<!-- <div class="cont_nav">
						<ul class="three_title">
							<li class="three infame" url_three="asset/config">参数设置</li>
							<li class="three" url_three="asset/manage">固定资产管理</li>
							<li class="three" url_three="asset/query">固定资产查询</li>
						</ul>
					</div> -->
					<div class="all_content" style="width:100%;height:100%;">
						
							<div id='f_0' class="iItem" style="width:100%;height:100%;overflow:hidden;"><iframe  id="every_module" src="cont" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div>
							
					</div>
				</div>
			</div>
			<div class="foot">
				 <!-- <div class="foot_left"><a href="download.html" target="_blank"><h1>点击下载PC客户端</h1></a></div> -->
				
				<!-- <div class="lunbo">
					 <ul id="status_text">					
						 <li>Office　Anywhere　 &nbsp2015版</li>
						 <li>中国协同OA软件领跑者</li>
						 <li>体验科技关怀   共创美好未来</li>
					</ul>			
				 </div> -->
				<div style="margin-left:30%;"><iframe  id="every_module" src="lunbo" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div>
				
		<!-- 		<div class="foot_rig"><a href="xitong.html" target="_blank"><h2>心通达 &nbsp 年付版本</h2></a></div> -->
				
				
				  
		</div>
			
	</body>
	<script>
		$(function(){

			var menu = {
				"email":"email/index",
				"notify_show":"notice/index",
				"news_show":"news/index",
				"file_folder/index2.php":"fileHome",
				"system/file_folder":"showFileBySort_id",
				"diary_show":"diary/index",
				"news_manage":"news/manage"
			}
			
			$('.cont_nav').on('click','li',function(){
				$(".cont_nav li").removeClass("infame");
				$(this).addClass('infame');
				
			});
			//鼠标移入，右边logo变颜色，移出变回。
			//one
			$('#task_center').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_two.png) 0px 0px no-repeat')
			});
			$('#task_center').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_one.png) 0px 0px no-repeat')
			});
			//two
			$('#sns').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_two.png) -60px 0px no-repeat')
			});
			$('#sns').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_one.png) -60px 0px no-repeat')
			});
			//three
			$('#help').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_two.png) -115px 0px no-repeat')
			});
			$('#help').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_one.png) -115px 0px no-repeat')
			});
			//four
			$('#person_info').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_two.png) -174px -1px no-repeat')
			});
			$('#person_info').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_one.png) -174px -1px no-repeat')
			});
			//five
			$('#theme').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_two.png)  -233px 0px no-repeat')
			});
			$('#theme').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_one.png)  -233px 0px no-repeat')
			});
			
			
			
		//底部文字滚动
	/* 	var lunbo='';
		  function lunbo(id,height){
			  var ul=$(id);
			  var liFirst=ul.find('li:first');
			  $(id).animate({top:height}).animate({"top":0},0,function(){
			  var clone=liFirst.clone();
			  $(id).append(clone);
			  liFirst.remove();
			  })
		} 
		 	 setInterval("lunbo('#status_text','-50px')",3000);  */
		function init(){
			 $.ajax({
					url:'showMenu',
					type:'get',						
					dataType:'json',
					success:function(obj){
							var data= obj.obj;
							var str=''; 
						
							for(var i=0;i<data.length;i++){
								var er='';
								/* http://192.168.0.17:88/general/system/user/index.php?uid=admin */
								for(var j=0;j<data[i].child.length;j++){
									/* var url=data[i].child[j].url; */
									if(data[i].child[j].child.length>0){
										var three='';
										for(var k=0;k<data[i].child[j].child.length;k++){						
								 			three +='<li class="three" menu_tid='+data[i].child[j].child[k].id+' url_three='+data[i].child[j].child[k].url+'><img class="sanji_circle" src="img/main_img/hei.png"><h1 style="margin-left:6%;">'+data[i].child[j].child[k].name+'</h1></li>' ; 	
								 		}
								 		er += '<li class="two"  menu_tid='+data[i].child[j].id+'><div url='+data[i].child[j].url+'  class="two_all click_erji"><img class="erji_circle" src="img/main_img/hei.png"><h1>'+data[i].child[j].name+'</h1><img class="er_img" src="img/main_img/down.png"></div><ul class="sanji" style="display:none;">'+three+'</ul></li>';
									/*  console.log($('er').find().attr('url')); */
									}else{
										/* console.log(data[i].child[j].id); */
										er += '<li class="two" menu_tid='+data[i].child[j].id+'><div url='+data[i].child[j].url+' class="two_all"><img class="erji_circle" src="img/main_img/hei.png"><h1 class="erji_h1">'+data[i].child[j].name+'</h1></div></li>';
										
									} 
								} 
								str+='<li class="one person" id="administ"><div class="one_all" ><img class="one_logo" src="img/main_img/'+data[i].img+'.png"><h1 class="one_name" id="administ">'+data[i].name+'</h1></div><div class="two_menu"><ul class="erji b"  style="width:100%;display:none;"><li class="two"><div class="two_all">'+er+'</div></li></ul></div></li>'; 
							}   
							/* style="width:100%;height:55px;border-bottom: 2px solid #e3e3e5;" */

						$(".tab_cone").html(str);
						
						 
						
						//鼠标移动到一级菜单变样式，移出变回
						$('.one_all').on('mouseover',function () {
							$(this).css({
									'background':'url(img/main_img/first_yes.png) 0px 2px no-repeat',
									'color':'#006bb8',
									/* 'border':'1px solid #999', */
									'cursor':'pointer'
								});
						});
						//移出
						$('.one_all').on('mouseout',function () {
							$(this).css({
									'background':'url(img/main_img/first_no.png) 0px -0px no-repeat',
									'color':'#000'
								});
						});
							
						//点击一级菜单。显示二级
					 	$('.one_all').on('click',function () {
							
							if ($(this).siblings().find('.erji').css('display')=='none') {
								/* $(this).find('.one_down_img').attr('src','img/main_img/up.png'); */
								
								/* $(this).css('background','#cde2fa'); */
								$(this).siblings().find('.erji').show();
								$(this).siblings().find('.erji').css('background','#e8f4fc');
								
							}else{
								/* $(this).css('background','cc'); */
								
								$(this).siblings().find('.erji').hide();
							}
										
						});
					
						//点击应用或者组织，tab切换
							//tab切换
						/* 	 var currentIndex=0;
							/*  var index; */
					/* 	$('.tab_t').on('click','li',function(){
								var index=$(this).index();
								//console.log(inedx);
								if(currentIndex!=index){
								 
									currentIndex=index;
									$(".tab_t li").removeClass("yingy");
									$(this).addClass('yingy');
									//内容
									 var contents=$(".list").find("ul");
									
					                $(contents[index]).show();
					                $(contents[index]).siblings().hide();
								}
													
						}); */
						
						

							//点击二级，出现三级
						$('.click_erji').on('click',function () {
							var san= $(this).siblings().html();
							//console.log(san);
							/* $('.three_title').html(san); */
							
							 if ($(this).siblings('.sanji').css('display')=='none') {
								$(this).find('.er_img').attr('src','img/main_img/up.png');
								$(this).siblings('.sanji').show();	
								
							}else{
								$(this).find('.er_img').attr('src','img/main_img/down.png');
								$(this).siblings('.sanji').hide();
							}
									
						});
						
					
						//二级菜单切换
						$('.two_menu li').on('mouseover','.two_all',function(){
							
								/* $('.two_menu li .two_all').removeClass('xuan');
								$(this).addClass('xuan'); */
								$(this).find('h1').css({
									'color':'#2f8ae3',
									 'cursor':'pointer'
								});
								 $(this).find('.erji_circle').attr('src','img/main_img/lan.png'); 
								
						});
						$('.two_menu li').on('mouseout','.two_all',function(){
							
								$('.two_menu li .two_all').removeClass('xuan');
								$(this).find('h1').css('color','#000');
								 $(this).find('.erji_circle').attr('src','img/main_img/hei.png'); 
						});
						
						
						//点击二级菜单
						$('.two_menu li').on('click','.two_all',function(){
							var url=$(this).attr('url'); 
							var menu_tid=$(this).parent().attr('menu_tid'); 
							//console.log(url);
							if(menu[url.replace('/','_')]){
								url = menu[url.replace('/','_')];
							}else{
								url='http://192.168.0.17:81/gotophp.php?uid=admin&url='+url;
							}

							//判断标题id与iframeid是否相同
							//console.log(url);
							console.log($('#f_'+menu_tid).length>0);
							if($('#f_'+menu_tid).length>0){
								//页面一打开，切换显示
								$('.all_content .iItem').hide();
								$('#f_'+menu_tid).show();
								
								$('#t_'+menu_tid).css({
									'background':'url(img/main_img/title_yes.png) 5px 2px no-repeat',
									'position':'relative',
									'z-index':99999
								})
								$('#t_'+menu_tid).siblings().css({
									'background':'url(img/main_img/title_no.png) 5px 2px no-repeat',
									'position':'relative',
									'z-index':999
								})
							}else{
								if($(this).siblings('.sanji').length>0){
										/* return  false; */
									//console.log($(this).siblings('.sanji').length>0);
								}else{
									//页面不存在，新增 title和iframe
									
									var titlestr = '<li class="choose" index="0;" id="t_'+menu_tid+'"><div class="img"><img class="close" src="img/main_img/icon.png"></div><h1>'+$(this).find('h1').html()+'</h1></li>';
									var iframestr = '<div id="f_'+menu_tid+'" class="iItem" style="width:100%;height:100%;"><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';
									$('.main_title').append(titlestr);
									$('.all_content').append(iframestr);
									$('.all_content .iItem').hide();
									$('#f_'+menu_tid).show();
								
								}
								
							}
							
								
						});		
						
						
							//点击三级菜单，跳转页面。
							$('.sanji').on('click','li',function(){
								var url=$(this).attr('url_three'); 
								
							 var menu_tid=$(this).attr('menu_tid');  
								console.log(url);
								if(menu[url]){
									url = menu[url];
								}else{
								url='http://192.168.0.17:81/gotophp.php?uid=admin&url='+url;
								}
								
								console.log(menu_tid);
								if($('#f_'+menu_tid).length>0){
									//页面一打开，切换显示
									$('.all_content .iItem').hide();
									$('#f_'+menu_tid).show();
										$('#t_'+menu_tid).css({
										'background':'url(img/main_img/title_yes.png) 5px 2px no-repeat',
										'position':'relative',
										'z-index':99999
									})
									$('#t_'+menu_tid).siblings().css({
										'background':'url(img/main_img/title_no.png) 5px 2px no-repeat',
										'position':'relative',
										'z-index':999
									})
								
								}else{ 
									
									//页面不存在，新增 title和iframe
									var titlestrs = '<li class="choose " index="0;" id="t_'+menu_tid+'"><div><img class="close" src="img/main_img/icon.png"></div><h1>'+$(this).find('h1').html()+'</h1></li>';
									var iframestr = '<div id="f_'+menu_tid+'" class="iItem" style="width:100%;height:100%;"><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';
									$('.main_title').append(titlestrs);
									$('.all_content').append(iframestr);
									$('.all_content .iItem').hide();
									$('#f_'+menu_tid).show();
								}
								
					        });
								
						
						//三级菜单切换
						/* $('.three_title').on('click','li',function(){
							var bbb=$(this).attr('url_three');
							$('.three_title li').removeClass('xuan');
							$(this).addClass('xuan');
						}) */
						 //三级菜单移入变样式
						$('.sanji').on('mouseover','li',function(){
							/* $('.sanji li').removeClass('xuan');
							$(this).addClass('xuan'); */
							$(this).css({
									/* 'background':'url(img/main_img/first_yes.png) 0px 1.4px no-repeat', */
									'color':'#006bb8',
									'cursor':'pointer'
								});
							 $(this).find('img').attr('src','img/main_img/lan.png'); 
							
						});
						//三级菜单移出
						$('.sanji').on('mouseout','li',function(){
							
								/* $('.sanji li').removeClass('xuan'); */
								$(this).css({
									/* 'background':'url(img/main_img/first_no.png) 0px 0px no-repeat', */
									'color':'#000'
								});
								 $(this).find('img').attr('src','img/main_img/hei.png'); 
						});
						

					//success的后括号
					}		
				});//ajax传入应用数据结束括号 
			  
		}//init方法结束
		
			init();//调用init()方法
			var data = {
						deptId:0
			};
			//init_orgnize()方法
			/* function init_orgnize(){
			
				 $.ajax({
					url:'department/getChDept',
					type:'get',	
					data:data, 		
					dataType:'json',					
					success:function(obj){
					var data=obj.obj;
						console.log(data);
						var li='';
						for(var i=0;i<data.length;i++){
							li +='<li class="orangize_one" style="height:36px;"><div><img src="img/main_img/company_logo.png" alt=""><a style="line-height:36px;" href="#" class="dynatree-title" title="'+data[i].deptName+'">'+data[i].deptName+'</a></div><ul class="ul_two"></ul></li>' ;
							
						}
						
						$(".tab_cone").html(li);
					}
					
				});
				
				
			}
			init_orgnize(); */
			//组织二级
			var data1 = {
						deptId:1
				};
			var data2 = {
						deptId:2
				};
				
	/* 		$(".tab_cone").on('click','.orangize_one:nth-child(2)',function(){
				 
					  $.ajax({
							url:'department/getChDept',
							type:'get',	
							data:data1,		
							dataType:'json',
							success:function(obj){
								 console.log(obj.obj);
								var data=obj.obj;
								var li_two='';
								for(var i=0;i<obj.obj.length;i++){
									li_two='<li><span class="dynatree-expander"></span><a href="#" class="dynatree-title" title="'+data[i].deptName+'">'+data[i].deptName+'</a></span><ul class="three_ul"></ul></li>'
								}
								
								 $(".tab_cone li:eq(0) .ul_two").html(li_two);
								/* $('.orangize_one').find('.ul_two').html(li_two); */
					/* 		}
					});  */
					
				 	
					/* init_orgnize();
					data.deptId=1;
					for(var i=0;i<obj.obj.length;i++){
						li_two='<li><span class="dynatree-expander"></span><a href="#" class="dynatree-title" title="'+data[i].deptName+'">'+data[i].deptName+'</a></span><ul class="three_ul"></ul></li>'
					}
								
					$(this).find('.ul_two').html(li_two);  */
					
					/* if($('.ul_two li').css('display')=='none'){
						$('.ul_two li').show();
					}else{
						$('.ul_two li').hide();
					} */
	/* 		}); */
			
			//第二个二级
			
			/* 	$(".tab_cone").on('click','.orangize_one:nth-child(2)',function(){
				 
					  $.ajax({
							url:'department/getChDept',
							type:'get',	
							data:data2,		
							dataType:'json',
							success:function(obj){
								 console.log(obj.obj);
								var data=obj.obj;
								var li_two='';
								for(var i=0;i<obj.obj.length;i++){
									li_two='<li><span class="dynatree-expander"></span><a href="#" class="dynatree-title" title="'+data[i].deptName+'">'+data[i].deptName+'</a></span><ul class="three_ul"></ul></li>'
								}
								
								 $(".tab_cone li:eq(0) .ul_two").html(li_two);
								/* $('.orangize_one').find('.ul_two').html(li_two); */
					/* 		}
					});  */
					
				 	
					/* init_orgnize();
					data.deptId=1;
					for(var i=0;i<obj.obj.length;i++){
						li_two='<li><span class="dynatree-expander"></span><a href="#" class="dynatree-title" title="'+data[i].deptName+'">'+data[i].deptName+'</a></span><ul class="three_ul"></ul></li>'
					}
								
					$(this).find('.ul_two').html(li_two);  */
					
					/* if($('.ul_two li').css('display')=='none'){
						$('.ul_two li').show();
					}else{
						$('.ul_two li').hide();
					} */
			/* }); */
			//组织三级
		
				/*  $.ajax({
							url:'department/getChDept',
							type:'get',	
							data:data2,		
							dataType:'json',
							success:function(obj){ */
								/* console.log(obj.obj); */
							/* 	var data=obj.obj; */
								/* var li_three=''; */
							/* 	console.log(data); */
							/* 	for(var i=0;i<obj.obj.length;i++){
									li_three='<li><span class="dynatree-expander"></span><a href="#" class="dynatree-title" title="'+data[i].deptName+'">'+data[i].deptName+'</a></span></li>'
								}
								$(".tab_cone li:eq(0) .ul_two").html(li_two); */
					/* 		}
					});
			 */
						//点击标题栏
						$('.main_title ').on('click','li',function(){
							
						    $('.main_title li').removeClass('change');
							$(this).addClass('change');
							var t_this=$(this).attr('id');
						
							var num=t_this.split('_')[1];
							  if($('#f_'+num).length>0){
							 	console.log($('#f_'+num).length);
							 	$('.all_content .iItem').hide();
								$('#f_'+num).show();
					
							} 
							$(this).siblings().css({
										'background':'url(img/main_img/title_no.png) 5px 2px no-repeat',
										'position':'relative',
										'z-index':999
									})
							$(this).css({
										'background':'url(img/main_img/title_yes.png) 5px 2px no-repeat',
										'position':'relative',
										'z-index':99999
							})
							
						});
						//删除
						//移入
						$('.main_title').on('mouseover','.close',function(){
							
							$(this).attr('src','img/main_img/delet_yuan.png');
						 
						}) ;
						//移出
						$('.main_title').on('mouseout','.close',function(){
							
							$(this).attr('src','img/main_img/icon.png');
						 
						}) ;
			
					//点击删除
						$('.main_title').on('click','.close',function(){
							/* alert('111'); */
							var re=$(this).parent().parent().attr('id');
							console.log(re);
							var delet=re.split('_')[1];
							console.log(delet);
					
						 	$(this).parent().parent().remove();
						 /* 	console.log($(this).parent().parent()); */
						 	 $('#f_'+delet).remove();
						 	  $('#f_'+delet).next().show(); 
						 	 /*  console.log( $('#re'));
						 	  console.log( $('#f_'+delet).next()); */
						 	/* console.log($(this).siblings('li').length>0); */
						 	var  li= $(this).parents('li');
						 	/* console.log(li);
						 	console.log($(this).parents('li').next()); */
						 	
						 	/*  if($(this).siblings('li').length>0){
						 		 $('#f_'+delet).siblings().show();
						 		 
						 	}else{
						 		
						 	}   */
						}) ;
				
				//tab 切换
					$('.tab_t').on('click','li',function(){
						
							$(".tab_t li").removeClass("yingy");
							$(this).addClass('yingy');
							 if($(this).attr('id')=='use'){
								/* init(); */
								$('.tab_cone').css("display","block");
								$('.tab_ctwo').css("display","none");
							}else{
								$('.tab_cone').css("display","none");
								$('.tab_ctwo').css("display","block");
							} 
							
					})
				//向左移动
				$('.right_scroll').on('click',function(){
					console.log($('.main_title li').length>=8);
					if($('.main_title li').length>=8){
						$('.main_title li').animate({left:"-=100px"});
					}
				})
				//向右移动
					$('.left_scroll').on('click',function(){
					console.log($('.main_title li').length>=8);
					if($('.main_title li').length>=8){
						$('.main_title li').animate({left:"+=100px"});
						if($('.main_title li:nth-child(1)').attr('left')==0){
							$('.main_title li:nth-child(1)').css('left','0px');
						}
					}
				})
				function getChDept(){
					$.ajax({
						
					})
				}
		
		});
	</script>
	<script>
		autodivheight();
		function autodivheight(){ 
		  var winHeight=0;
		  if (window.innerHeight)
		   winHeight = window.innerHeight;
		  else if ((document.body) && (document.body.clientHeight))
		   winHeight = document.body.clientHeight;
		  if (document.documentElement && document.documentElement.clientHeight)
		   winHeight = document.documentElement.clientHeight;
		   winWidth = document.documentElement.clientWidth;
		  document.getElementById("client").style.height= winHeight - 110 +"px";
		  document.getElementById("client").style.width= winWidth  +"px";
		  
		 }
 window.onresize=autodivheight; 
	</script>
</html>
