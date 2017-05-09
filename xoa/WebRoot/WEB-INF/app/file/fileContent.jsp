<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
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
	<link rel="stylesheet" type="text/css" href="css/cabinet.css">

<script type="text/javascript" src="js/easyui/jquery.min.js"></script>

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
.ss{margin-top: 10px;}
.boto{margin-top: 7px;}
</style>
<script type="text/javascript">
$(function(){
	$.ajax({
						type:'post',
						url:'<%=basePath%>file/catalog',
						dataType:'json',
						data:{'sortId':${sortId},'sortType':${sortType},'postType':${postType}},
						success:function(data){
						var files='';
							for(var i=0;i<data.length;i++){
							if(data[i].fileType=="folder"){
							files+="  <tr><td><input type=\"checkbox\" name=\"\" value=\"\" > <a href=\"${pageContext.request.contextPath }/file/temp\">"+data[i].sortName+ "  </a></td>  <td><img src=\"img/file/cabinet@.png\" alt=\"\"/>"+''+ "  </td> <td> "+''+ "  </td><td> "+data[i].sortNo+ "  </td><td> <img src=\"img/file/cabinet8.png\" alt=\"\"/> </td></tr>" 
							   }else{
							   files+="  <tr><td><input type=\"checkbox\" name=\"\" value=\"\" > <a href=\"${pageContext.request.contextPath }/file/catContent?contentId="+data[i].contentId+"\">"+data[i].subject+ "  </a></td>  <td><img src=\"img/file/cabinet@.png\" alt=\"\"/>"+''+ "  </td> <td> "+data[i].sendTime+ "  </td><td> "+data[i].contentId+ "  </td><td> <img src=\"img/file/cabinet8.png\" alt=\"\"/> </td></tr>" 
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

<body style="background-color: #EBEBEB">
<div class="head w clearfix">
    <div class="ss"> <a href="${pageContext.request.contextPath }/file/temp"><img src="img/file/cabinet01.png" alt="新建文件"/></a></div>
    <div class="ss"> <a href="${pageContext.request.contextPath }/file/temp"><img src="img/file/cabinet02.png" alt="批量上传"/></a></div>
    <div class="ss"> <a href="${pageContext.request.contextPath }/file/temp"><img src="img/file/cabinet03.png" alt="查询"/></a></div>
    <div class="ss"> <a href="${pageContext.request.contextPath }/file/temp"><img src="img/file/cabinet04.png" alt="全局搜索"/></a></div>
</div>
<!--middle部分开始-->
<div class="w">
    <div class="wrap">
        <table class="w">
            <thead>
            <tr>
                <td class="th"><fmt:message code="file.th.name"/></td>
                <td class="th"><fmt:message code="email.th.file"/></td>
                <td class="th" style="position: relative">
                    <fmt:message code="notice.th.PostedTime"/>
                    <img style="position: absolute;margin-left:9px;cursor: pointer;" src="img/file/cabinet05.png" alt=""/>
                    <img style="position: absolute;margin-top:13px;margin-left:9px;cursor: pointer;"
                         src="img/file/cabinet06.png " alt=""/>
                </td>
                <td class="th" style="position: relative">
                    <fmt:message code="file.th.Sort"/>
                    <img style="position: absolute;margin-left:9px;cursor: pointer;" src="img/file/cabinet05.png" alt=""/>
                    <img style="position: absolute;margin-top:13px;margin-left:9px;cursor: pointer;"
                         src="img/file/cabinet06.png " alt=""/>
                </td>
                <td class="th"><fmt:message code="notice.th.operation"/></td>
            </tr>
            </thead>
            <tbody id="file_Tachr">
            </tbody>
        </table>
    </div>
</div>
	<!--bottom 部分开始-->
<div class="bottom w">
    <div>
        <input type="checkbox" name="" value="" >
        <fmt:message code="notice.th.allchose"/>

    </div>
    <div class="boto">
        <img src="img/file/cabinet9.png" alt=""/>
    </div>
    <div class="boto">
        <img src="img/file/cabinet10.png" alt=""/>
    </div>
    <div class="boto">
        <img src="img/file/cabinet11.png" alt=""/>
    </div>
    <div class="boto">
        <img src="img/file/cabinet12.png" alt=""/>
    </div>

</div>

<!--bottom 部分结束-->
</body>
</html>
