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
		<link rel="stylesheet" type="text/css" href="css/vintage_css/index.css"/>
		<script type="text/javascript" src="js/jquery-1.9.1.js"></script>  
		<script type="text/javascript" src="js/main_js/index.js"></script>  
		<script src="js/jQuery.js"></script>
	</head>
	<body>
		<div class="wrap">
			<div class="head">
				<div class="head_left"><img src="img/main_img/LOGO.png" style="margin-top:1.5%;margin-top:5%;width: 62%;
    height: 70%;"></div>
				<div class="head_mid">
					<ul class="main_title">
						<!-- <li style="background:#eef1f8;"><h1>首页标签</h1><img src="img/main_img/icon.png"></li> -->
						<li class="gongzuoliu" id='t_0'><h1>我的桌面</h1><img class="close" src="img/main_img/icon.png"></li>
					</ul>
				</div>
				<!-- 右侧的小logo -->
				<div id="taskbar_right" class="head_rig">
			         <a id="task_center" href="javascript:;" hidefocus="hidefocus" title="任务中心" data-step="5" data-intro="<b style='display:block'>任务中心</b>点击进入“任务中心”，可以看到按时间和紧急程度排序的待办任务，并可快速建立任务" data-position="left"></a>
			         <a id="sns" href="javascript:;" hidefocus="hidefocus" title="企业社区" data-step="6" data-intro="<b style='display:block'>企业社区</b>点击进入“企业社区”，促进企业信息交流与知识共享" data-position="left"></a>
			         <a id="help" href="/module/help/" hidefocus="hidefocus" title="通达OA在线帮助" data-step="7" data-intro="<b style='display:block'>通达OA在线帮助</b>“通达OA在线帮助”汇集了常见的用户问题，帮助用户快速掌握软件各项功能的使用" data-position="left" target="_blank"></a>
			         <a id="person_info" href="javascript:;" hidefocus="hidefocus" title="控制面板" data-step="8" data-intro="<b style='display:block'>控制面板</b>点击进入“控制面板”，可以进行界面设置、个人信息设置、账号与安全设置" data-position="left"></a>
			         <a id="theme" href="javascript:;" hidefocus="hidefocus" title="更换界面主题" data-step="9" data-intro="<b style='display:block'>更换皮肤</b>通达OA为您提供了完备的界面换肤功能，通过“更换皮肤”按钮，一触即换" data-position="left"></a>
			         
		      	</div>
			</div>
			<div class="cont">
				<div class="cont_left">
					<ul class="all_ul">
						<div class="tab_t">
							<ul class="top_ul">
								<li class="yingy">应用</li>
								<li>组织</li>
							</ul>
						</div>
						<div class="tab_c list">
						
								<ul class="tab_cone a yiji" >
								
								</ul>
						
							<ul class="tab_ctwo a" style="display:none;">
								
								 <div class="person">
									<img class="person_logo" src="img/main_img/zhishi.png">
									<h1>知识管理</h1>
									<img style="" src="img/main_img/down.png" class="person_down">
								</div>
								<div class="person">
									<img class="person_logo" src="img/main_img/renli.png">
									<h1>人力资源</h1>
									<img src="img/main_img/down.png" class="person_down">
								</div>
								<div class="person">
									<img class="person_logo" src="img/main_img/xingzheng.png">
									<h1>行政办公</h1>
									<img src="img/main_img/down.png" class="person_down">
								</div>
								<div class="person">
									<img class="person_logo" src="img/main_img/xiangmu.png">
									<h1>项目管理</h1>
									<img src="img/main_img/down.png" class="person_down">
								</div>
							</ul>
							
						</div>
						
					</ul>
				</div>
				<div class="cont_rig">
					<div class="cont_nav">
						<ul class="three_title">
							<li class="three infame" url_three="asset/config">参数设置</li>
							<li class="three" url_three="asset/manage">固定资产管理</li>
							<li class="three" url_three="asset/query">固定资产查询</li>
						</ul>
					</div>
					<div class="all_content" style="width:100%;height:97%;">
						
							<div id='f_0' class="iItem" style="width:100%;height:100%;"><iframe  id="every_module" src="cont" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div>
							
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
				"notify/show":"notice/index",
				"news/show":"news/index",
				"file_folder/index2.php":"fileHome",
				"system/file_folder":"showFileBySort_id"
			}
			
			$('.cont_nav').on('click','li',function(){
				$(".cont_nav li").removeClass("infame");
				$(this).addClass('infame');
				
			});
			//鼠标移入，右边logo变颜色，移出变回。
			//one
			$('#task_center').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_one.png) 0px 0px no-repeat')
			});
			$('#task_center').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_two.png) 0px 0px no-repeat')
			});
			//two
			$('#sns').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_one.png) -331px 0px no-repeat')
			});
			$('#sns').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_two.png) -331px 0px no-repeat')
			});
			//three
			$('#help').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_one.png) -73px 0px no-repeat')
			});
			$('#help').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_two.png) -73px 0px no-repeat')
			});
			//four
			$('#person_info').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_one.png) -233px -1px no-repeat')
			});
			$('#person_info').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_two.png) -233px -1px no-repeat')
			});
			//five
			$('#theme').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_one.png)  -313px 0px no-repeat')
			});
			$('#theme').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_two.png)  -313px 0px no-repeat')
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

		var menu = {
			"email":"email/index",
			"notify/manage":"notice/index",
			"news/show":"news/index",
			"file_folder/index2.php":"fileHome",
			"system/file_folder":"showFileBySort_id"
		}


		
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
								 			three +='<li class="three" menu_tid='+data[i].child[j].child[k].id+' url_three='+data[i].child[j].child[k].url+'><h1 style="margin-left:25%;">'+data[i].child[j].child[k].name+'</h1></li>' ; 	
								 		}
								 		er += '<li class="two"  menu_tid='+data[i].child[j].id+'><div url='+data[i].child[j].url+'  class="two_all click_erji"><h1>'+data[i].child[j].name+'</h1><img class="er_img" src="img/main_img/down.png"></div><ul class="sanji" style="display:none;">'+three+'</ul></li>';
									/*  console.log($('er').find().attr('url')); */
									}else{
										/* console.log(data[i].child[j].id); */
										er += '<li class="two" menu_tid='+data[i].child[j].id+'><div url='+data[i].child[j].url+' class="two_all"><h1>'+data[i].child[j].name+'</h1></div></li>';
										
									} 
								} 
								str+='<li class="one person" id="administ"><div class="one_all" style="width:100%;height:55px;border-bottom: 2px solid #e3e3e5;"><img class="one_logo" src="img/main_img/'+data[i].img+'.png"><h1 class="one_name" id="administ">'+data[i].name+'</h1><img class="one_down_img" src="img/main_img/down.png" style="margin-top: 10%;"></div><div class="two_menu"><ul class="erji b"  style="width:100%;display:none;"><li class="two"><div class="two_all">'+er+'</div></li></ul></div></li>'; 
							}   
							

						$(".tab_cone").html(str);
						
						//二级
					 	$('.one_all').on('click',function () {
							
							if ($(this).siblings().find('.erji').css('display')=='none') {
								$(this).find('.one_down_img').attr('src','img/main_img/up.png');
								$(this).siblings().find('.erji').show();	
								
							}else{
								$(this).find('.one_down_img').attr('src','img/main_img/down.png');
								$(this).siblings().find('.erji').hide();
							}
										
						}); 
					
						//点击应用或者组织，tab切换
							//tab切换
							 var currentIndex=0;
							/*  var index; */
						$('.tab_t').on('click','li',function(){
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
													
						});

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
							
								$('.two_menu li .two_all').removeClass('xuan');
								$(this).addClass('xuan');
						});
						$('.two_menu li').on('mouseout','.two_all',function(){
							
								$('.two_menu li .two_all').removeClass('xuan');
								
						});
						var tid=0;
						//点击二级菜单
						$('.two_menu li').on('click','.two_all',function(){
							var url=$(this).attr('url'); 
							var menu_tid=$(this).parent().attr('menu_tid'); 
							//console.log(url);
							if(menu[url]){
								url = menu[url];
							}else{
								url='http://192.168.0.17:81/gotophp.php?uid=admin&url='+url;
							}
							
						
							//判断id是否相同
							//console.log(url);
							console.log($('#f_'+menu_tid).length>0);
							if($('#f_'+menu_tid).length>0){
								//页面一打开，切换显示
								$('.all_content .iItem').hide();
								$('#f_'+menu_tid).show();
							}else{
								if($(this).siblings('.sanji').length>0){
										/* return  false; */
									//console.log($(this).siblings('.sanji').length>0);
								}else{
									//页面不存在，新增 title和iframe
									var titlestr = '<li class="gongzuoliu" index="0;" id="t_'+menu_tid+'"><h1>'+$(this).find('h1').html()+'</h1><img class="close" src="img/main_img/icon.png"></li>';
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
								}else{ 
									
									//页面不存在，新增 title和iframe
									var titlestr = '<li class="gongzuoliu" index="0;" id="t_'+menu_tid+'"><h1>'+$(this).html()+'</h1><img class="close" src="img/main_img/icon.png"></li>';
									var iframestr = '<div id="f_'+menu_tid+'" class="iItem" style="width:100%;height:100%;"><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';
									$('.main_title').append(titlestr);
									$('.all_content').append(iframestr);
									$('.all_content .iItem').hide();
									$('#f_'+menu_tid).show();
								}
								
					        });
								
						
						//三级菜单切换
						$('.three_title').on('click','li',function(){
							var bbb=$(this).attr('url_three');
							$('.three_title li').removeClass('xuan');
							$(this).addClass('xuan');
						})
						 
						$('.sanji').on('mouseover','li',function(){
							$('.sanji li').removeClass('xuan');
							$(this).addClass('xuan');
						});
						$('.sanji').on('mouseout','li',function(){
							
								$('.sanji li').removeClass('xuan');
								
						});
						//点击标题栏
						$('.main_title ').on('click','li',function(){
						    $('.main_title li').removeClass('choose');
							$(this).addClass('choose');
							var t_this=$(this).attr('id');
						
							var num=t_this.split('_')[1];
							  if($('#f_'+num).length>0){
							 	console.log($('#f_'+num).length);
							 	$('.all_content .iItem').hide();
								$('#f_'+num).show();
					
							}  
						})
						
						//删除
						$('.main_title').on('click','.close',function(){
							var re=$(this).parent().attr('id');
							var delet=re.split('_')[1];
							console.log(delet);
						 	/*  $(this).parent().remove();
						 	 $('#f_'+delet).remove(); */
						 	var new_delet=delet+1;
						 	 console.log(new_delet);
						}) ;
					}			
				});
				
		
		})
	</script>
	
</html>
