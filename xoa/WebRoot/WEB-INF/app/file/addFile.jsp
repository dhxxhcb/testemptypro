<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新建文件夹</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <script type="text/javascript">
     function closeCurrentWindow(){
 		  document.form1.submit();
 		window.opener.location.href = window.opener.location.href;     
 		if (window.opener.progressWindow)     
 		{         
 		window.opener.progressWindow.close();     
 		}     
 		window.close(); 
 	} 
    </script>
  </head>
  <body>
  <h1>新建文件夹</h1>
  <form id="form1" name="form1" action="${pageContext.request.contextPath }/fileAdd">
      排序号:    <input id="fileNoid" name="sort_no" type="text"/><br>
   文件夹名称：    <input id="fileNameid" name="sort_name" type="text"/><br>
  <!--  <input id="qr" type="button" value="" onclick="submit()"/><br> -->
   <input id="fh" type="button" value="确认" onclick="closeCurrentWindow()"/>
   </form>
  </body>
</html>
