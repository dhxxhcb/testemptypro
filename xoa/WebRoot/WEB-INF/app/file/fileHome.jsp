<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
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
<FRAMESET id="main_parent" border="1"frameSpacing="1" rows="20,*" frameBorder="0" >
<FRAME name=topFrame src="" noResize scrolling=no>
<FRAMESET id="main" border="0" frameSpacing="0" frameBorder="0" cols="300,1%,*">
<FRAME name="leftFrame" src="${pageContext.request.contextPath}/fileIndex" noResize>
<frame name="" src="" frameBorder=0 marginHeight=0 marginWidth=0 scrolling=no noresize>
<FRAME name="mainFrame" src="" >
</FRAMESET>
</FRAMESET>

</html>