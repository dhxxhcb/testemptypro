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

		</style>
	</head>
	<body>
		<div class="content">
			<div  class="cabinet_left">

			</div>
			<div  class="cabinet_right">

			</div>
		</div>
	</body>
</html>
