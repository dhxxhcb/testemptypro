<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>公告详情</title>
		<script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			body{padding: 0;margin: 0;font-family: "微软雅黑";width: 100%;}
			.detailsContent{width: 100%;overflow: hidden;background-color: #f6f7f9;}
			.detailsContent .title{width: 100%;text-align: center;height: 60px;line-height: 60px;color: #2a588c;font-size: 25px;font-weight: bold;}
			.infor{width: 100%;overflow: hidden;height: 40px;background-color: #d3e7fa;}
			.infor ul{list-style: none;overflow: hidden;float: right;margin-top: 10px;}
			.infor ul li{float: left;margin-right: 20px;}
			.infor ul li span{font-size: 14px;}
			.divContent{width: 100%;}
			.divContent .divTxt{width: 500px;margin: 50px auto;}
			.divContent .divTxt p{font-size: 18px;color: #444;}
			.divContent .keyWord{margin: 0 0 10px 50px;}
			.divContent .keyWord span{margin-right: 10px;color: #2b7fe0;}
			.btnImg{width: 100%;}
			.btnImg .margin{width: 370px;margin: 20px auto;}
			.btnImg .margin a{margin-right: 20px;}
			
		</style>
	</head>
	<body>
		<div class="detailsContent">
			<div class="title">成立项目部销售部及主管任命通知</div>
			<div class="infor">
				<ul>
					<li><span>高波</span></li>
					<li><span>发布于：</span><span>2017-03-23 10:17</span></li>
					<li><span>点击次数<span>92</span>次</span></li>
				</ul>
			</div>
			<div class="divContent">
				<div class="divTxt">
					<p>即日起，原项目部商务部改组为项目部销售部，任命郝雪为项目部销售部主管，同事担任项目部副总监。</p>
					<p>特此通知。</p>
				</div>
				<div class="keyWord">
					<b>本文关键词：</b><span>时间</span><span>团队</span><span>效率</span><span>浪费</span><span>方法</span>
				</div>
			</div>
		</div>
		<div class="btnImg">
			<div class="margin">
				<a href="javascript:;"><img src="../img/forward_btn.png"/></a>
				<a href="javascript:;"><img src="../img/up_btn.png"/></a>
				<a href="javascript:;"><img src="../img/next_btn.png"/></a>
				<a href="javascript:;"><img src="../img/close_btn.png"/></a>
			</div>
		</div>
	</body>
</html>

