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
<link rel="stylesheet" type="text/css" href="css/easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="css/easyui/icon.css">
<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui/easyui-lang-zh_CN.js"></script>
<!-- <script type="text/javascript" src="/ui/easyui/tree.js"></script> -->
<script type="text/javascript">
$(function(){
alert("我进来了!");
$("#fileTree").tree({
	onClick : function(node){
		alert(node.id);  // 在用户点击的时候提示
		$.POST("/",{"id": node.id},function(data){
		
		});
	}
});
});
</script>
</head>
<body style="margin: 0">
<TABLE border=0 width="700">
	<TR>
	 <TD width=340px align=left valign=top>
      <ul id="fileTree" class="easyui-tree" data-options="url:'showFile',method:'get',animate:true">
      </ul>
    </TD>
 </TR>
</TABLE>
</body>
</html>