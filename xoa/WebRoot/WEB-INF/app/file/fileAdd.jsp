<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
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
	<style type="text/css">
		body{background-color:#D6E4EF;}
		h1{font-size:18px;text-align:center;}
		table{margin:0 auto;border-color:#ddd;}
		table tr td{padding:5px 5px;font-size:14px;border-color:#ddd;}
		table tr td input:not(#fh){width:80%;}
		#fh{display:block;margin:0 auto;outline: none;border-radius:3px;border:none;background-color:#9be9fc;padding:2px 5px;}
	</style>
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
  <form id="form1" name="form1" action="${pageContext.request.contextPath }/file/add">
  <table border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse;" width="50%">
	<tr>
		<td width="30%">排序号:  </td>
		<td width="70%"><input id="fileNoid" name="sortNo" type="text"/></td>
	</tr>
	<tr>
		<td width="30%">文件夹名称：</td>
		<td width="70%"> <input id="fileNameid" name="sortName" type="text"/></td>
	</tr>
	<tr>
		<td colspan="2"><input id="fh" type="button" value="确认" onclick="closeCurrentWindow()"/></td>
	</tr>
   </table>
  <!--     排序号:    <input id="fileNoid" name="sort_no" type="text"/><br>
   文件夹名称：    <input id="fileNameid" name="sort_name" type="text"/><br>
   <input id="qr" type="button" value="" onclick="submit()"/><br>
   <input id="fh" type="button" value="确认" onclick="closeCurrentWindow()"/> -->
   </form>
  </body>
</html>
