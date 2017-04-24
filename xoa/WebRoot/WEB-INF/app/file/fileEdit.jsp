<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #D6E4EF;
}

h1 {
	font-size: 18px;
	text-align: center;
}

table {
	margin: 0 auto;
	border-color: #ddd;
}

table tr td {
	padding: 5px 5px;
	font-size: 14px;
	border-color: #ddd;
}

table tr td input:not (#fh ){
	width: 80%;
}

#fh {
	display: block;
	margin: 0 auto;
	outline: none;
	border-radius: 3px;
	border: none;
	background-color: #9be9fc;
	padding: 2px 5px;
}
</style>
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
	<form id="form1"
		action="${pageContext.request.contextPath }/file/update" method="post">
		<table border="1" cellspacing="0" cellpadding="0"
			style="border-collapse: collapse;" width="50%">
			<tr>
				<td width="30%">排序号:</td>
				<td width="70%"><input id="sortno" name="sortNo" type="text"
					value="${sortno }" />
				</td>
			</tr>
			<tr>
				<td width="30%">文件夹名称：</td>
				<td width="70%"><input id="sortname" name="sortName"
					type="text" value="${sortname }" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><input id="fh" type="button" value="确认"
					onclick="closeCurrentWindow()" />
				</td>
			</tr>
			<!-- 排序号:  <input id="sortno" name="sort_no" type="text" value="${sortno }"/><br>
   文件夹名称：<input id="sortname" name="sort_name" type="text" value="${sortname }"/><br> --!>
  <!--  <input id="qr" type="button" value="确认" onclick="submit()"/> -->
			<!--   <input id="fh" type="button" value="确认" onclick="closeCurrentWindow()"/>-->
			<input id="sortid" type="hidden" name="sortId" value="${sortid}" />
		</table>
	</form>
</body>
</html>