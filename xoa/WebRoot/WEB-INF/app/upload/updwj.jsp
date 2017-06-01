<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    function doUpload() {
         var file = new FormData($( "#uploadForm" )[1]);
         console.log($( "#uploadForm" ).serialize());
         $.ajax({
              url: 'http://localhost:8080/xoa/upload'+'?module=email',
              type: 'POST',
              data: new FormData($('#uploadForm')[1]),
              dataType:"text",
              success: function (returndata) {
              	console.log(returndata.innerHTML);

              },
              error: function (XMLHttpRequest, textStatus, errorThrown) {
                  console.log(XMLHttpRequest.status);
				console.log(XMLHttpRequest.readyState);
				console.log(textStatus);
              }
         });
    }

</script>
</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<body>
<form action="upload?module=email" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="file" name="file" />
    <input type="file" name="file" />
    <input type="submit" value="Submit" />
</form>

    <a href="<%=basePath%>WEB-INF/app/updanwenjian.jsp">批量</a>

    <form id= "uploadForm">
      <p >指定文件名： <input type="text" name="filename" value= ""/></p >
      <p >上传文件： <input type="file" name="file"/></ p>
      <input type="button" value="上传" onclick="doUpload()" />
</form>


</body>
</html>