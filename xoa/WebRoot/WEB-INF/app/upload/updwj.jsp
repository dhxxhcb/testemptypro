<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">  
    <input type="file" name="file" /> 
    <input type="file" name="file" />
    <input type="file" name="file" />
    <input type="submit" value="Submit" /></form> 
   
    <a href="<%=basePath%>WEB-INF/app/updanwenjian.jsp">批量</a>
    
    
</body>
</html>