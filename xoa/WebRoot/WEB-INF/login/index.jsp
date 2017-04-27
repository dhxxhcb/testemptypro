<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <script type="text/javascript" src="js/news/jquery-1.9.1.js"></script>
<head>
		<title>心通达OA-登录</title>
		<style type="text/css">
			*{margin: 0;padding: 0;}
			body{font-family: "微软雅黑";}
			html,body{width:100%;height:100%;}
			.content{width: 100%;height:100%;overflow: hidden;background: url(img/all.png) no-repeat;background-size:cover;}
			.content .left{width: 55%;min-height:800px;float: left;position: relative;}
			.content .left .logo{width: 350px;position: absolute;top: 20%;left: 25%;}
			.content .left .logo img{display: block;width: 100%;}
			
			.content .right{width: 45%;float: left;}
			.content .right ul{list-style: none;margin-top: 26%;margin-left: 15%;position: relative;}
			.content .right ul li.total{width: 384px;height: 50px;background: url(img/1.png) no-repeat;position: relative;border-radius: 25px;background-position:center;margin-bottom: 42px;z-index: 999;}
			.content .right ul li a{text-decoration: none;display: block;width: 100%;}
			.content .right ul li.total .round{display: block;width: 16px;height: 16px;border-radius: 50%;background-color: #fff;;margin-left: 25px;position: absolute;top: 17px;}
			.content .right ul li.total .bord{display: block;color: #fff;margin-left: 50px;width: 1%;font-size: 20px;line-height: 45px;margin-left: 75px;margin-right: 30px;}
			.content .right ul li.total .txt{display: block;width: 60%;margin: -34px auto;text-align: center;font-size: 20px;color: #fff;letter-spacing: 3px;float: right;margin-right: 22%;}
			.content .right ul li.div_li{width: 320px;height: 44px;border-radius: 22px;margin-left: 60px;position: relative;margin-bottom: 42px;}
			.content .right ul li.div_li .round{display: block;width: 14px;height: 14px;border-radius: 50%;background-color: #fff;;margin-left: 25px;position: absolute;top: 15px;}
			.content .right ul li.div_li .bord{display: block;color: #fff;margin-left: 50px;width: 1%;font-size: 18px;line-height: 40px;margin-left: 75px;margin-right: 30px;}
			.content .right ul li.div_li .txt{display: block;width: 60%;margin: -32px auto;text-align: center;font-size: 18px;color: #fff;letter-spacing: 3px;float: right;margin-right: 15%;}
			.content .right .div_im{width: 30px;height: 360px;position: absolute;top: 16px;left: 30px;}
			.content .right .div_im img{display: block;width: 100%;height: 100%;}
			
			.content .right ul li.one{background: url(img/2.png) no-repeat;background-position:center;}
			.content .right ul li.tow{background: url(img/3.png) no-repeat;background-position:center;}
			.content .right ul li.three{background: url(img/4.png) no-repeat;background-position:center;}
			.content .right ul li.four{background: url(img/5.png) no-repeat;background-position:center;}
			
		   @media screen and (min-width: 1680px) and (max-width: 1920px) {
				.content .left .logo{width: 410px;}
			}
		   @media screen and (min-width: 1921px) {
		 		.content .left .logo{width: 478px;}
		 }
		 #lg {
		 width: 250px;
   		 height: 50px;
   		 margin-left:75px;
   		 margin-top: 48px;

		 }
		 #zt {
		 	margin-right:45px;
		 	margin-top:30px;
		 	float: right;
		
		 
		 }
		 
		 
		</style>
<script type="text/javascript">
		$(function () {
			$("#lg").click(function(){
				$("#tp").slideToggle();
			});
		
		}
</script> 
		
	</head>
	<body>
		<div class="content">
			<div class="left">
				<div class="logo">
					<img  src="img/logo.png"/>
					<img id="lg" src="img/sy01.png"/>
					<img id="lg" src="img/sy02.png"/>
					<img id="lg" src="img/sy04.png"/>
				</div>
				<!-- <img id="tp" src="img/sy05.png"/> -->
			
			</div>
			<div class="right">
				<div id="zt">
					<fmt:message code="language" />:
					 <a href="?lang=zh_CN"><fmt:message code="language.cn" /></a>
					  &nbsp;&nbsp;
					  <a href="?lang=en_US"><fmt:message code="language.en" /></a>
					  &nbsp;&nbsp;
					  <!-- <a href="?lang=en_US">繁体</a> -->
				</div>
				<ul>
					<li class="total">
						<a href="login?loginId=1001">
							<span class="round"></span>
							<span class="bord">|</span>
							<span class="txt">
							<fmt:message code="headQuarters" />
							</span>
						</a>
					</li>
					<li class="div_li one">
						<a href="login?loginId=1002">
							<span class="round"></span>
							<span class="bord">|</span>
							<span class="txt">
							<fmt:message code="branchOfficeOne" />
							</span>
						</a>
					</li>
					<li class="div_li tow">
						<a href="login?loginId=1003">
							<span class="round"></span>
							<span class="bord">|</span>
							<span class="txt">
							<fmt:message code="branchOfficeTwo"/></span>
						</a>
					</li>
					<li class="div_li three">
						<a href="login?loginId=1004">
							<span class="round"></span>
							<span class="bord">|</span>
							<span class="txt">
							<fmt:message code="branchOfficeThree"/>
							</span>
						</a>
					</li>
					<li class="div_li four">
						<a href="login?loginId=1005">
							<span class="round"></span>
							<span class="bord">|</span>
							<span class="txt">
							<fmt:message code="branchOfficeFore"/>
							</span>
						</a>
					</li>
					<li class="div_im">
						<img src="img/lianxian.png" alt="" />
					</li>
				</ul>
			</div>
		</div>
	</body>
</html>
