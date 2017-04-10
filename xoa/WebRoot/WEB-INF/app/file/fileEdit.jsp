<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function submit(data){
alert(data);
document.form1.action="${pageContext.request.contextPath }/fileUpdate?sort_id="+data;
    document.form1.submit();
    closeCurrentWindow();
    }
    
    function closeCurrentWindow(){
 		
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
<form method="post">
<input type="hidden" name="sort_parent" value="0"/>
排序号:  <input id="fileNoid" name="sort_no" type="text" value="${sortno }"/><br>
   文件夹名称：<input id="fileNameid" name="sort_name" type="text" value="${sortname }"/><br>
   <input id="qr" type="button" value="确认" onclick="submit(${sortid})"/><br>
   <input id="fh" type="button" value="返回" onclick="window.close()"/>
</form>
</body>
</html>