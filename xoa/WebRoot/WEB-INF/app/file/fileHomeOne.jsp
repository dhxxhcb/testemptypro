<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<SCRIPT type="text/javascript">
function submitrequest(action){
eval("document.location='"+action+"'");
}
</SCRIPT>
</head>
<FRAMESET id="main" border="0" frameSpacing="0" frameBorder="0" cols="300,1%,*">
<FRAME name="leftFrame" src="${pageContext.request.contextPath}/fileIndex" noResize>
<frame name="borderFrame" src="" frameBorder=1  scrolling=no noresize>
<FRAME name="mainFrame" src="" >
</FRAMESET>
</html>