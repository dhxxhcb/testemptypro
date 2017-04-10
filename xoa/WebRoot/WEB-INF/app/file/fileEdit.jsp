<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function submit(){
   
    }
    
    function closeCurrentWindow(){
 		 window.form1.submit();
 		window.opener.location.href = window.opener.location.href;     
 		if (window.opener.progressWindow)     
 		{         
 		window.opener.progressWindow.close();     
 		}     
 		window.close(); 
 	} 
</script>
</head>
<body>
<h1>文件夹编辑</h1>
<form id="form1" action="${pageContext.request.contextPath }/fileUpdate" method="post">
排序号:  <input id="sortno" name="sort_no" type="text" value="${sortno }"/><br>
   文件夹名称：<input id="sortname" name="sort_name" type="text" value="${sortname }"/><br>
  <!--  <input id="qr" type="button" value="确认" onclick="submit()"/> -->
   <input id="fh" type="button" value="确认" onclick="closeCurrentWindow()"/>
   <input id="sortid" type="hidden" name="sort_id" value="${sortid}"/>
</form>
</body>
</html>