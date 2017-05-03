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
		<title><fmt:message code="global.lang.doing"/></title>
		<style type="text/css">
			*{margin: 0;padding: 0;}
			html,body{width: 100%;height: 100%;font-family: "微软雅黑";}
			.developo{width: 100%;height: 100%;}
			.developo .text{width: 100%;position: relative;height: 100%;}
			.developo .text img{display: block;position: absolute;left: 50%;top: 50%;margin-left: -169px;margin-top: -82px;}
			
		</style>
	</head>
	<body>
		<div class="developo">
			<div class="text">
				<img src="../img/common/development.png"/>
			</div>
		</div>
	</body>
</html>
