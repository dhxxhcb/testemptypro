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
					<div class="img_all">
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/main_img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/main_img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/main_img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/main_img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/main_img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/main_img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/main_img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
						<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/main_img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="foot">
				<a href="download.html" target="_blank"><h1>点击下载PC客户端</h1></a>
				<div class="lunbo">
					 <ul>
						 <li style="    margin-left: 34%; margin-top: -2%;font-size: 14px;color: #fff;">心通达OA软件领跑者</li>
						 <li>我寄愁心与明月，随风直到夜郎西</li>
						 <li>不是花中偏爱菊，此花开尽更无花</li>
						 <li>辛苦遭逢起一经，干戈寥落四周星</li>
					 </ul>
				 </div>
				
				<a href="xitong.html" target="_blank"><h2>心通达 &nbsp 年付版本</h2></a>
			</div>
		</div>
			
	</body>
	<script>
		$(function(){
			$.ajax({
					url:'showMenu',
					type:'get',						
					dataType:'json',
					success:function(obj){
							var data= obj.obj;
								var str=''; 
							console.log(data);
							 for(var i=0;i<data.length;i++){

								var er='';
								console.log(data[i].child.child);
								 for(var j=0;j<data[i].child.length;j++){
								 
							
								var three='';
								if(data[i].child[j].child.length>0){
									er += '<li class="two"><div class="two_all" style="width: 72%;"><h1>'+data[i].child[j].name+'</h1><img src="img/main_img/down.png"></div></li>';
									for(var k=0;k<data[i].child[j].child.length;k++){						
								 		 three +='<li class="three">'+data[i].child[j].child[k].name+'</li>' ; 	
								 	}
								}else{
									er += '<li class="two"><div class="two_all" style="width: 72%;"><h1>'+data[i].child[j].name+'</h1></div></li>';
								} 
									
								} 

								 str+='<li class="one person" id="administ"><div class="one_all" style="width:100%;height:55px;border-bottom: 2px solid #e3e3e5;"><img class="one_logo" src="'+data[i].img+'"><h1 class="one_name" id="administ">'+data[i].name+'</h1><img class="one_down_img" src="img/main_img/down.png" style="margin-top: 10%;"></div><ul class="erji b"  style="margin-left:20%;width:100%;display:none;"><li class="two"><div class="two_all">'+er+'</div><ul class="sanji" style="margin-left:25%;display:none;"><li class="three">'+three+'</li></ul></li></ul></li>'; 
								
							}  
							
						console.log(three);
						$(".tab_cone").html(str);
						//二级
						$('.one_all').on('click',function () {
							/* alert('aaa'); */
							if ($(this).siblings('.erji').css('display')=='none') {
								$(this).find('.one_down_img').attr('src','img/main_img/up.png');
								$(this).siblings('.erji').show();	
								
							}else{
								$(this).find('.one_down_img').attr('src','img/main_img/down.png');
								$(this).siblings('.erji').hide();
							}
										
						});
						
							//三级
						$('.two_all').on('click',function () {
				
							if ($(this).parent().siblings('.sanji').css('display')=='none') {
								$(this).find('.one_down_img').attr('src','img/main_img/up.png');
								$(this).parent().siblings('.sanji').show();	
								
							}else{
								$(this).find('.one_down_img').attr('src','img/main_img/down.png');
								$(this).parent().siblings('.sanji').hide();
							}
										
						});
						 
					}			
				});
				
				var contents=$(".tab_c").find("ul");
				console.log(contents);
		})
	</script>
	
</html>
