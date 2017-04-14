<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="css/easyui/icon.css">
<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
function submitrequest(action){
eval("document.location='"+action+"'");
}

$(function(){
alert("我进来了!");
$("#fileTree").tree({
	onClick : function(node){
		alert(node.id);  // 在用户点击的时候提示
		$.POST("/",{"id": node.id});
	}
});
});
</script>

</head>
<body>
<FRAMESET id="main" border="0" frameSpacing="0" frameBorder="0" cols="30%,*">
<iframe id="tree" src="${pageContext.request.contextPath}/fileIndex" width=100% marginwidth=0 marginheight=0 scrolling="no"  designMode='on' >

<!-- <TABLE border=0 width="700">
	<TR>
	 <TD width=340px align=left valign=top>
      <ul id="fileTree" class="easyui-tree" data-options="url:'showFile',method:'get',animate:true,dnd:true">
      </ul>
    </TD>
 </TR>
</TABLE> -->

</iframe>
<%-- <FRAME name="leftFrame" src="${pageContext.request.contextPath}/fileIndex" noResize> --%>

<iframe name="mainFrame" src="${pageContext.request.contextPath}/fileContent">
</FRAMESET>
</body>
</html>