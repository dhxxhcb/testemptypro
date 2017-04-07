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
    var fileNoid=documnent.getElementById("#fileNoid");
    function fileNoidBlur(){
    var fileNoidString=fileNoid.val();
    if(Trim(fileNoidString)==""){
			alert("排序号不能为空");
		}
    $.post("/checkfileNoid",{'id':fileNoidString},function(data){
       if(data.id=="1"){
       
       }
    });
    }
    </script>
  </head>
  
  <body>
  <form id="forma1" action="/fileAdd">
  <span ></span>
   排序号:<input id="fileNoid" name="sort_no" type="text" onblur="fileNoidBlur()"/>
   文件夹名称：<input id="fileNameid" name="sort_name" type="text"/>
   <input id="qr" type="button" value="确认"/>
   <input id="fh" type="button" value="返回"/>
   </form>
  </body>
</html>
