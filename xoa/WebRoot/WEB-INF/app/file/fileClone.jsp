<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'fileClone.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script type="text/javascript">
    function submit(){
    document.form1.submit();
    }
    function close(){
    window.close();
    }
    </script>
<body>
	<h1>克隆文件夹</h1>
	<form id="form1" name="form1"
		action="${pageContext.request.contextPath }/fileUpdate">
		排序号: <input id="fileNoid" name="sort_no" type="text"
			value="${sort_no}" /><br> 文件夹名称：<input id="fileNameid"
			name="sort_name" type="text" value="${sort_name }" /><br> <input
			id="qr" type="button" value="确认" onclick="submit()" /><br> <input
			id="fh" type="button" value="返回" onclick="close()" />
	</form>
</body>
</html>
