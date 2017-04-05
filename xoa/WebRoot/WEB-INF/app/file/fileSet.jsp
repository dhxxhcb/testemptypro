<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fileSet.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
	</script>
  </head>
  <body>
   <form action="" method="get">
   <a href="openWindow('','700','500')" >新建文件夹</a>
   <table id="table">
    <tr> <td> 排序号  </td> <td>文件夹名称  </td><td> 操作</td></tr>
    <!--  <c:forEach items="" var=""> -->
    <tr> 
    <td>   </td> 
    <td>   </td>
                    <td>&nbsp;&nbsp; <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="克隆" name="BT_find" 
						 onclick="openWindow('','700','500')"/>&nbsp;&nbsp;
						 <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="编辑" name="BT_find" 
						 onclick="openWindow('','700','500')"/>&nbsp;&nbsp;
						 <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="删除" name="BT_find" 
						 onclick="openWindow('','700','500')"/>&nbsp;&nbsp;
						 <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="权限设置" name="BT_find" 
						 onclick="openWindow('','700','500')"/>&nbsp;&nbsp;
						 <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="权限报表" name="BT_find" 
						 onclick="openWindow('','700','500')"/>&nbsp;&nbsp;
						 <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="菜单定义指南啊" name="BT_find" 
						 onclick="openWindow('','700','500')"/>&nbsp;&nbsp;
				    </td>
	</tr>
   <!-- </c:forEach> -->
   </table>
   </form>
  </body>
</html>
