<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title><fmt:message code="title.shanghai" /></title>
<style type="text/css">
 *{margin: 0;padding: 0;}
			body{font-family: "微软雅黑";}
			html,body{width:100%;height:100%;}
			.content{width: 100%;height:100%;  position: relative;}
			.content .entry{
				width:320px;
				max-height: 400px;
				border-radius: 6px;
				box-shadow: -1px 1px 3px #ccc;
				background-color: #fff;
				position: absolute;
				top: 0;
				bottom: 0;
				left: 65%;
				margin: auto;
			}
			.content .entry .div_img{width: 98px;height: 98px;border-radius: 50%;margin: 25px auto;}
			.content .entry .div_img img{display: block;width: 100%;}
			.content .entry p{width: 90%;text-align: center;font-size: 18px;color: #808080;display: block;margin: 0 auto;}
			.content .entry .txt{width: 80%;margin: 20px auto 0;border-bottom: #bfbfbf 1px solid;padding-bottom: 5px;}
			.content .entry .txt input{font-family:微软雅黑;}
			.txt img{vertical-align:middle}
			.content .entry .txt input{border: none;font-size: 16px;padding-left: 5px;line-height: 29px;}
			.content .entry .div_log{width: 80%;margin: 30px auto;height: 52px;}
			.content .entry .div_log a{text-decoration: none;display: block;width: 100%;height: 100%;text-align: center;background-color: #3696ff;color: #fff;border-radius: 6px;letter-spacing: 3px;line-height: 52px;font-size: 18px;box-shadow: -1px 1px 3px #aaa;}
	
			.content .ban{
				width: 100%;
				height: 17%;
				max-height: 148px;
				background: url(img/login/bjjt_head.png) no-repeat;
				background-size: 100% 100%;
			}
			#loginbtn:hover{background-color:#59a8ff;}
			.content .ban1{ width:100%; height:83%; background: url(img/login/background_3_02_02.jpg) no-repeat;background-size:100% 100%; position: relative;}
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<script type="text/javascript">
	$(function() {
	
		$('#loginbtn').click(function() {
			
			login();
			$(this).css({"cursor":"default","background":"#1f7de4"});
		});
		 $(document).keypress(function(e) {  
		    // 回车键事件  
		 	if(e.which == 13) {  
		 		$('#loginbtn').click();  
		    }  
		 }); 
		function login(){
			$.ajax({
				type : "post",
				url : "login",
				data : {
					username:$("#username").val(),
					password:$("#password").val()
				},
				dataType:'json',
				success : function(data) {
				
					if (data.flag == true) {
						window.location.href = "main";
					} else {
						alert("用户名密码不对!");
						window.location.reload(true);
					}
				}
			})
		}

	})
</script>
<body>
	<form name="form1">
		<div class="content">
			<div  class="ban"></div>
			<div class="ban1">
					<div class="entry">
						<div class="div_img"><img src="img/login/logo2.png"/></div>
						<p><fmt:message code="title.shanghai" /></p>
						<div class="txt">
							<img src="img/login/account.png" alt="用户名" />
							<input type="text" id="username" name="txt" placeholder="<fmt:message code="userName" />" />
						</div>
						<div class="txt">
							<img src="img/login/password.png" alt="密码" />
							<input type="password" id="password" name="password" placeholder="<fmt:message code="passWord"/>" />
						</div>
						<div class="div_log">
							<a href="javascript:void(0);" id="loginbtn"><fmt:message code="loging" /></a>
						</div>
					</div>
			</div>
		</div>
	
	</form>
	<script>
			$(document).ready(function(){
				var conh=$(".content").height();
				var banh=$(".ban").height();
				$(".ban1").height(conh - banh +'px');
				$(window).resize(function(){
					var conh=$(".content").height();
					var banh=$(".ban").height();
					$(".ban1").height(conh - banh +'px');
				});
			});
				
			//});
			
		</script>
</body>
</html>
