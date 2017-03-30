<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		<title>登录2</title>
		<style type="text/css">
			*{margin: 0;padding: 0;}
			body{font-family: "微软雅黑";}
			html,body{width:100%;height:100%;}
			.content{width: 100%;height:100%;background: url(${path}/img/111.png) no-repeat;background-size:cover;position: relative;}
			.content .entry{/*width: 360px;*/width: 22.5%;/*height: 430px;*/border-radius: 6px;box-shadow: -1px 1px 3px #ccc;background-color: #fff;position: absolute;top: 20%;left: 37.5%;}
			.content .entry .div_img{width: 98px;height: 98px;border-radius: 50%;margin: 25px auto;}
			.content .entry .div_img img{display: block;width: 100%;}
			.content .entry p{width: 90%;text-align: center;font-size: 18px;color: #808080;display: block;margin: 0 auto;}
			.content .entry .txt{width: 80%;margin: 20px auto 0;border-bottom: #bfbfbf 1px solid;padding-bottom: 5px;}
			.txt img{vertical-align:middle}
			.content .entry .txt input{border: none;font-size: 16px;padding-left: 5px;line-height: 29px;}
			.content .entry .div_log{width: 80%;margin: 30px auto;height: 52px;}
			.content .entry .div_log a{text-decoration: none;display: block;width: 100%;height: 100%;text-align: center;background-color: #3696ff;color: #fff;border-radius: 6px;letter-spacing: 3px;line-height: 52px;font-size: 18px;box-shadow: -1px 1px 3px #aaa;}
		</style>

  </head>
  
  	<body>
  	<form action="login" method="post" name="form1">
		<div class="content">
			<div class="entry">
				<div class="div_img"><img src="img/logo.png"/></div>
				<p>北京分公司网络办公智能平台</p>
				<div class="txt">
					<img src="img/account.png" alt="用户名" />
					<input type="text" name="username" placeholder="用户名" />
				</div>
				<div class="txt">
					<img src="img/password.png" alt="密码" />
					<input type="password" name="password" placeholder="密码" />
				</div>
				<div class="div_log">
					<a href="javascript:document.form1.submit();">登录</a>
				</div>
			</div>
		</div>
		</form>
	</body>
</html>
