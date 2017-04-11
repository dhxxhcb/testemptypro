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
<script type="text/javascript" src="/ui/easyui/tree.js"></script>
<script type="text/javascript">
$('#tree').tree({    
    url: '/showFile',    
    loadFilter: function(data){    
        if (data.d){    
            return data.d;    
        } else {    
            return data;    
        }    
    }    
});  
</script>
</head>
<body>
 <ul id="tree" class="easyui-tree">  
 
  
 </ul>
</body>
</html>
