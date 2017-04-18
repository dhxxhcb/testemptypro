<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showFile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="/ui/easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="/ui/easyui/icon.css">
<script type="text/javascript" src="/ui/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/ui/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/ui/easyui/easyui-lang-zh_CN.js"></script>
<!-- <script type="text/javascript" src="/ui/easyui/tree.js"></script> -->
<script type="text/javascript">

$(document).ready(function(){
alert("进来了"); 
$('#tree').tree({   
    url: '${pageContext.request.contextPath }/showFile', 
       
});  

}); 

</script>
</head>
<body>
 <ul id="tree" class="easyui-tree" style="width: 180px;">   
 </ul>
 <br>
 <ul class="easyui-tree" data-options="url:'${pageContext.request.contextPath }/showFile'">
 </ul>
</body>
</html>
