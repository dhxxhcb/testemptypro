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
		
	</head>
	<body>
		<div class="wrap">
			<div class="head">
				<div class="head_left"><img src="img/main_img/LOGO.png" style="margin-top:1.5%;margin-top:5%;width: 62%;
    height: 70%;"></div>
				<div class="head_mid">
					<ul>
						<li style="background:#eef1f8;"><h1>首页标签</h1><img src="img/main_img/icon.png"></li>
						<li class="gongzuoliu" style="background:#ccd2e0;"><h1>工作流</h1><img class="close" src="img/icon.png"></li>
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
						<div class="tab_c">
							<ul class="tab_cone">
							<!-- 	<div class="person">
									<img class="person_logo" src="img/main_img/ren.png">
									<h1>个人事务</h1>
									<img src="img/main_img/down.png" class="person_down">
								</div>
								<div class="person">
									<img class="person_logo" src="img/main_img/work.png">
									<h1>工作流</h1>
									<img style="margin-left:41%;margin-top: 10%;" src="img/main_img/down.png">
								</div>
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
								<div class="person " id="administ">
									<img class="person_logo" src="img/main_img/xingzheng.png">
									<h1>行政办公</h1>
									<img src="img/down.png" class="person_down">	
								</div>
								<div class="erji" style="height:106px;display:none;">
									<div class="person">
										<img class="person_logo" src="img/xingzheng.png">
										<h1 style="margin-left:30%;">工作计划</h1>
										<img src="img/down.png" class="person_down">	
									</div>
									<div class="person" id="office">
										<img class="person_logo" src="img/xingzheng.png">
										<h1 style="margin-left:30%;">办公用品</h1>
										<img src="img/down.png" style="margin-left:32%;margin-top: 10%;" class="office_img">	
									</div>
								</div>
								
								<div class="sanji" style="height:106px;display:none;">
									<div class="person">
										<img class="person_logo" src="img/xingzheng.png">
										<h1 style="margin-left:40%;">办公用品申请</h1>
										<img src="img/down.png" class="person_down">	
									</div>
									<div class="person">
										<img class="person_logo" src="img/xingzheng.png">
										<h1 style="margin-left:40%;">办公用品审批</h1>
											
									</div>
								</div>
								
								<div class="person">
									<img class="person_logo" src="img/xiangmu.png">
									<h1>系统管理</h1>
									<img src="img/down.png" class="person_down">
								</div> -->
							</ul>
							<ul class="tab_ctwo" style="display:none;">
								
								<div class="person">
									<img class="person_logo" src="img/zhishi.png">
									<h1>知识管理</h1>
									<img style="" src="img/down.png" class="person_down">
								</div>
								<div class="person">
									<img class="person_logo" src="img/renli.png">
									<h1>人力资源</h1>
									<img src="img/down.png" class="person_down">
								</div>
								<div class="person">
									<img class="person_logo" src="img/xingzheng.png">
									<h1>行政办公</h1>
									<img src="img/down.png" class="person_down">
								</div>
								<div class="person">
									<img class="person_logo" src="img/xiangmu.png">
									<h1>项目管理</h1>
									<img src="img/down.png" class="person_down">
								</div>
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
								<img src="img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
							<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/big.png">
							</div>
							<div class="r_one_bot">
								<h1>公告通知</h1>
								<h2>模块管理布局内容模块管理布局内容模块管理布局内容模块管理布局内容</h2>
							</div>
						</div>
						<!-- 第二个 -->
						<div class="right_one">
							<div class="r_one_top">
								<img src="img/big.png">
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
				<a href="xitong.html" target="_blank"><h2>心通达 &nbsp 年付版本</h2></a>
			</div>
		</div>
			
	</body>
	<script>
		$(function(){
			$.ajax({
					url:'http://192.168.1.116:8080/xoa/showMenu',
					type:'post',			
					
					dataType:'json',
					success:function(obj){
								var data= obj.data;
								console.log(data);
								var li='';
							/* 	for(var i=0;i<data.length;i++){
								var data2='<div><img src="images/circle.png"></div>';
								
								
								li+='<li nid='+data[i].nid+'><table border="0" cellpadding="" cellspacing=""><tr><td  class="td1">'+data[i].fname+'</td>'+'<td style="color:#138eee;">'+data[i].stime2+'</td></tr>'+'<tr><td>'+data[i].mtitle+'</td>'+'<td class="td2"><img src="images/GG_1.png"><img src="images/GG_2.png" style="margin-left:30px;"></td></tr>'+'<tr><td>'+data[i].message+'</td>'+'<td></td></tr>'+'</table></li>'			
							} */
								
											
					}			
				});
		})
	</script>
</html>
