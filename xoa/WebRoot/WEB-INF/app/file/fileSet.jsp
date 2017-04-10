<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
function openWindow(sHref,strWidth,strHeight) {
  var strLeft=(screen.availWidth-strWidth)/2;
  var strTop=(screen.availHeight-strHeight)/2;
  var strRef="";
  strRef=strRef+"width="+strWidth+"px,height="+strHeight+"px,";
  strRef=strRef+"left="+strLeft+"px,top="+strTop+"px,";
  strRef=strRef+"resizable=yes,scrollbars=yes,status=yes,toolbar=no,systemmenu=no,location=no,borderSize=thin";//channelmode,fullscreen
  var openerobj= window.open(sHref,'newwin',strRef,false);
  openerobj.focus();
}
/* 
 function submitDelete(data){
   document.form2.action="${pageContext.request.contextPath}/fileDelete?sort_id="+"'"+data+"'";
   document.form2.submit();
 } */
 
	</script>
  </head>
  <body>
  <h1>文件柜设置</h1>
   <form id="form2" name="form2" method="get">
   <input id="newFile" type="button" onclick="openWindow('${pageContext.request.contextPath }/fileAdd','700','500')" value="新建文件夹"/>
   <table id="table">
    <tr> <td> 排序号  </td> <td>文件夹名称  </td><td> 操作</td></tr>
    <c:forEach items="${parentList}" var="parent">
    <tr> 
    <td>  ${parent.sort_no}</td> 
    <td>  ${parent.sort_name}</td>
                    <td>&nbsp;&nbsp; <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="克隆" name="BT_find" 
						 onclick="openWindow('${pageContext.request.contextPath }/fileClone?sort_no=${parent.sort_no }&sort_name=${parent.sort_name}','700','500')"/>&nbsp;&nbsp;
						 <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="编辑" name="BT_find" 
						 onclick="openWindow('${pageContext.request.contextPath }/fileEdit?sort_id=${parent.sort_id}','700','500')"/>&nbsp;&nbsp;
						 <a href="${pageContext.request.contextPath}/fileDelete?sort_id=${parent.sort_id}">
						 <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="删除" name="BT_find" />
						 </a>&nbsp;&nbsp;
						 <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="权限设置" name="BT_find" 
						 onclick="openWindow('${pageContext.request.contextPath }/filePermissionSet','700','500')"/>&nbsp;&nbsp;
						 <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="权限报表" name="BT_find" 
						 onclick="openWindow('${pageContext.request.contextPath }/fileAdd','700','500')"/>&nbsp;&nbsp;
						 <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="菜单定义指南啊" name="BT_find" 
						 onclick="openWindow('${pageContext.request.contextPath }/fileAdd','700','500')"/>&nbsp;&nbsp;
				    </td>
				    <!-- <input id="sort_id" name="sort_id" type="hidden" value="${parent.sort_id }"/>  -->
	</tr>
    </c:forEach>
   </table>
   </form>
  </body>
</html>
