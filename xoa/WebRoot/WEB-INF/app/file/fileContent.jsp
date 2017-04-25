<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'fileContent.jsp' starting page</title>

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
<style>
input {
	border: none;
	outline: none;
	display: inline-block;
	background: #fff;
}

input:hover {
	background: #eaf2ff;
	padding: 5px;
}
</style>
<script type="text/javascript">
$(function(){
	$.ajax({
						type:'post',
						url:'<%=basePath%>/file/catalog',
						dataType:'json',
						data:{'sortId':${sortId},'sortType':${sortType},'postType':"1"},
						success:function(data){
						var files='';
							for(var i=0;i<data.length;i++){
							if(data[i].fileType=="folder"){
							files+="  <tr><td> <a href=\"${pageContext.request.contextPath }\">"+data[i].sortName+ "  </a></td>  <td>"+data[i].sortNo+ "  </td> <td> "+''+ "  </td><td> "+''+ "  </td></tr>" 
							   }else{
							files+="<tr><td> <a href=\"${pageContext.request.contextPath }/file/catContent?contentId="+data[i].contentId+"\">"
							+data[i].subject+
							"</a></td><td>"+data[i].contentId+ "</td><td>"+data[i].sendTime+ "  </td><td> "
							+''+ 
							"</td></tr>" 
							   }
							}
							$("#file_Tachr").html(files);
						}
				}); 
});



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
	</script>
</head>

<body>
	<form id="form1" action="">
	<hr>
		&nbsp;&nbsp; <input style="font-size:12px;height=40;width=160"
			id="BT_Add" type="button" value="+ 新建文件" name="BT_new"
			onclick="openWindow('${pageContext.request.contextPath }','700','500')" />&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp; <input style="font-size:12px;height=40;width=160"
			id="BT_Upload" type="button" value="+ 批量上传" name="BT_new"
			onclick="openWindow('${pageContext.request.contextPath }','700','500')" />&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp; <input style="font-size:12px;height=40;width=160"
			id="BT_Select" type="button" value="查询" name="BT_new"
			onclick="openWindow('${pageContext.request.contextPath }','700','500')" />&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp; <input style="font-size:12px;height=40;width=160;"
			id="BT_AllSelect" type="button" value="全局搜索" name="BT_new"
			onclick="openWindow('${pageContext.request.contextPath }','700','500')" />&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;
		<div style="padding:5px;width:110px;display:inline-block;">
			<a href="#" class="easyui-menubutton"
				data-options="menu:'#mm1',iconCls:'icon-edit'">文件夹操作</a>
		</div>
		<div id="mm1" style="width:150px;">
			<div data-options="iconCls:'icon-add'">新增子文件夹</div>
			<div data-options="iconCls:'icon-remove'">删除目录</div>
			<div class="menu-sep"></div>
			<div>设置权限</div>
			<div class="menu-sep"></div>
			<div>
				<span>编辑文件夹</span>
				<div style="width:150px;">
					<div>编辑</div>
					<div>复制</div>
					<div>剪切</div>
				</div>
			</div>
		</div>
	<br>
	<hr>
	<span>${text}</span>
	<hr>
	<br>
</form>
<table id="file_Ta" class="w" border="0">
            <thead>
            <tr>
                <td class="th">--------文件名称-------------------</td>
                <td class="th">-----------排序号-----------</td>
                <td class="th" >-----------发布时间-----------</td>
                <td class="th">--------操作--------</td>
            </tr>
            </thead>
            <tbody id="file_Tachr">
            
            </tbody>
        </table>
        
	
</body>
</html>
