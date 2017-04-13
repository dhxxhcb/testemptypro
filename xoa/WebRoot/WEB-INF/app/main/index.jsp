<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<script type="text/javascript" src="js/index.js"></script>  
		<script src="js/jQuery.js"></script>
	</head>
	<body>
		<div class="wrap">
			<div class="head">
				<div class="head_left"><img src="img/main_img/LOGO.png" style="margin-top:1.5%;margin-top:5%;width: 62%;
    height: 70%;"></div>
				<div class="head_mid">
					<ul>
						<li style="background:#eef1f8;"><h1>首页标签</h1><img src="img/main_img/icon.png"></li>
						<li class="gongzuoliu" style="background:#ccd2e0;"><h1>工作流</h1><img class="close" src="img/main_img/icon.png"></li>
					</ul>
				</div>
				<div class="head_rig">
					<img src="img/main_img/sousuo.png">
					<img src="img/main_img/ling.png">
					<img src="img/main_img/ti.png">
					<img src="img/main_img/shezhi.png">
					<img src="img/main_img/zhuxiao.png">
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
								
								<!-- <div class="person">
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
								</div> -->
							</ul>
							
						</div>
						
					</ul>
				</div>
				<div class="cont_rig">
					<div class="cont_nav">
						<ul>
							<li>消息管理</li>
							<li>消息管理</li>
							<li class="infame">消息管理</li>
						</ul>
					</div>
					<div class="all_content" style="width:100%;height:97%;">
						<div class="every_cont" style="width:100%;height:100%;">
							<div><iframe id="every_module" src="WebRoot/WEB-INF/app/main/cont.jsp" frameborder="0" scrolling="yes" height="60%" width="100%" noresize="noresize"></iframe></div>
						</div>
					</div>
				</div>
			</div>
			<div class="foot">
				<!-- <div class="foot_left"><a href="download.html" target="_blank"><h1>点击下载PC客户端</h1></a></div>
				<div class="lunbo">
					 <ul>
						 <li style="margin-left: 34%; margin-top: -2%;font-size: 14px;color: #fff;">心通达OA软件领跑者</li>
						 <li>我寄愁心与明月，随风直到夜郎西</li>
						 <li>不是花中偏爱菊，此花开尽更无花</li>
						 <li>辛苦遭逢起一经，干戈寥落四周星</li>
					 </ul> 
				 </div>
				
				<div class="foot_rig"><a href="xitong.html" target="_blank"><h2>心通达 &nbsp 年付版本</h2></a></div> -->
				<div id="south">
				    <table>
				        <tr>
				            <td class="left"><div id="online_link" onClick="ViewOnlineUser()" title="共 43 人，2 人在线">在线<span id="user_count">2</span>人</div></td>
				            <td class="left"><span id="new_sms"></span><span id="new_sms_sound" style="width:1px;height:1px;"></span></td>
				            <td class="center">
				            	<div id="status_text">Office Anywhere 2015版<br>中国协同OA软件领跑者<br>体验科技关怀   共创美好未来<br></div>
				            </td>        
				                        <td class="right">
				                            </td>
				        </tr>
				    </table>
				</div>
				
				<div id="on_status_list">
				    <ul id="on_status_ul">
				        <li><a id="on_status_1" href="javascript:set_status(1);" title="">在线</a></li>
				        <li><a id="on_status_2" href="javascript:set_status(2);" title="">忙碌</a></li>
				        <li><a id="on_status_3" href="javascript:set_status(3);" title="">离开</a></li>
				    </ul>
				</div>
				   <div id="overlay"></div>
				   <div style="display:none;"></div>
		</div>
			
	</body>
	<script>
		$(function(){
			//-- 状态栏文字 --
		function StatusTextScroll(){
		    var obj = jQuery('#status_text');
		    var scrollTo = obj.scrollTop() + obj.height();
		    if(scrollTo >= obj.attr('scrollHeight'))
		       scrollTo = 0;
		    obj.animate({scrollTop: scrollTo}, 300);
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
								 			three +='<li class="three">'+data[i].child[j].child[k].name+'</li>' ; 	
								 		}
								 		er += '<li class="two" url=http://192.168.0.17:88/general/system/'+data[i].child[j].url+'/index.php?uid=admin ><div  class="two_all click_erji" style="width: 72%;"><h1>'+data[i].child[j].name+'</h1><img class="er_img" src="img/main_img/down.png"></div><ul class="sanji" style="margin-left:25%;display:none;">'+three+'</ul></li>';
									/*  console.log($('er').find().attr('url')); */
									}else{
										er += '<li class="two" url=http://192.168.0.17:88/general/system/'+data[i].child[j].url+'/index.php?uid=admin><div class="two_all" style="width: 72%;"><h1>'+data[i].child[j].name+'</h1></div></li>';
										
									} 
								} 
								str+='<li class="one person" id="administ"><div class="one_all" style="width:100%;height:55px;border-bottom: 2px solid #e3e3e5;"><img class="one_logo" src="'+data[i].img+'"><h1 class="one_name" id="administ">'+data[i].name+'</h1><img class="one_down_img" src="img/main_img/down.png" style="margin-top: 10%;"></div><div class="two_menu"><ul class="erji b"  style="margin-left:20%;width:100%;display:none;"><li class="two"><div class="two_all">'+er+'</div></li></ul></div></li>'; 
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

							//三级
						$('.click_erji').on('click',function () {
					
							if ($(this).siblings('.sanji').css('display')=='none') {
								$(this).find('.er_img').attr('src','img/main_img/up.png');
								$(this).siblings('.sanji').show();	
								
							}else{
								$(this).find('.er_img').attr('src','img/main_img/down.png');
								$(this).siblings('.sanji').hide();
							}
										
						});
						
						 var contIndex=0;
						//菜单切换
						$('.two_menu').on('click','li',function(){
							var aaa=$(this).attr('url'); 
							alert(aaa);
						
						
							var index=$(this).index();
							if(contIndex!=index){
								contIndex=index;
								$(this).addClass('xuan').siblings().removeClass('xuan');
								$(this).pratent().siblings().find().removeClass('xuan');
								//跳转页面
								$('#every_module').attr('src',aaa);
								
								var content=$(".every_cont").find("div");
								console.log(content)
					            $(content[index]).show();
					            $(content[index]).siblings().hide();
							}
							
					
						});
						 
					}			
				});
				
		
		})
	</script>
	
</html>
