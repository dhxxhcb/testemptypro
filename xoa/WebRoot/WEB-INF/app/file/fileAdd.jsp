<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/fileAdd" method="post">
<input type="hidden" name="sort_parent" value="0"/>
文件夹名称：<input type="text" name="sort_name"/><br>
<input type="button" value="提交"/>
</form>
</body>
</html>