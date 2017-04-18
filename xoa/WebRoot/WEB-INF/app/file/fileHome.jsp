<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>Insert title here</title>
<!-- <script type="text/javascript">
$(function(){
alert("我进来了!");
$("#fileTree").tree({
	onClick : function(node){
		alert(node.id);  // 在用户点击的时候提示
		$.POST("/",{"id": node.id});
	}
});
});
</script> -->
</head>
<FRAMESET id="main_parent" border="1" frameSpacing="1" rows="60,*" frameBorder="0" >
<FRAME name=topFrame src="${pageContext.request.contextPath}/topFrame" noResize scrolling=no>
<FRAME name=downFrame src="${pageContext.request.contextPath}/fileHomeOne" noResize scrolling=no>
</FRAMESET>
</html>