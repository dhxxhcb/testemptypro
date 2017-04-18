<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
	<style type="text/css">
		body{background-color:#D6E4EF;}
		h1{font-size:20px;}
		#newFile{display:block;margin:20px auto;padding:5px 10px;border-radius:5px;}
		hr{width:100%;border:#fff 1px dashed;border-top:none;margin-bottom:20px;}
		table{margin:0 auto;border-color:#ddd;width:80%;}
		table tr td{border-right:#ccc 1px solid;padding:5px 5px;font-size:14px;border-bottom:#ccc 1px solid;background:#fff;}
		table tr td:last-of-type{border-right:none;text-align:center;}
		table tr th{background-color:#ddd;padding:5px 5px;font-size:14px;} 
		a{text-decoration: none;}
		input{outline: none;border:0;background:#fff;color:#2788ea;}
		input:hover{color:#0867c5;}
	</style>
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
   <input id="newFile" type="button" onclick="openWindow('${pageContext.request.contextPath }/file/add','700','500')" value="新建文件夹"/>
   <hr>
   <table id="table" cellspacing="0" cellpadding="0">
    <tr> <th class="css_td"> 排序号  </th> <th class="css_td">文件夹名称  </th><th class="css_td"> 操作</th></tr>
    <c:forEach items="${parentList}" var="parent">
    <tr> 
    <td>  ${parent.sortNo}</td> 
    <td>  ${parent.sortName}</td>
                    <td>&nbsp;&nbsp; <input style="font-size:12px;height=20;width=80" id="BT_Add" type="button" value="克隆" name="BT_find" 
						 onclick="openWindow('${pageContext.request.contextPath }/file/clone?sortNo=${parent.sortNo }&sortName=${parent.sortName}','700','500')"/>&nbsp;&nbsp;
						 <input style="font-size:12px;height=20;width=80" id="BT_Add" type="button" value="编辑" name="BT_find" 
						 onclick="openWindow('${pageContext.request.contextPath }/file/edit?sortId=${parent.sortId}','700','500')"/>&nbsp;&nbsp;
						 <a href="${pageContext.request.contextPath}/file/deleteAll?sortId=${parent.sortId}">
						 <input style="font-size:12px;height=20;width=80" id="BT_Add" type="button" value="删除" name="BT_find" />
						 </a>&nbsp;&nbsp;
						 <input style="font-size:12px;height=20;width=80" id="BT_Add" type="button" value="权限设置" name="BT_find" 
						 onclick="openWindow('${pageContext.request.contextPath }/file/','700','500')"/>&nbsp;&nbsp;
						 <input style="font-size:12px;height=20;width=80" id="BT_Add" type="button" value="权限报表" name="BT_find" 
						 onclick="openWindow('${pageContext.request.contextPath }/file/','700','500')"/>&nbsp;&nbsp;
						 <input style="font-size:12px;height=20;width=80" id="BT_Add" type="button" value="菜单定义指南" name="BT_find" 
						 onclick="openWindow('${pageContext.request.contextPath }/file/','700','500')"/>&nbsp;&nbsp;
				    </td>
	</tr>
    </c:forEach>
   </table>
   </form>
  </body>
</html>
