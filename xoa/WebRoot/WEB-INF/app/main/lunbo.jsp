<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script src="js/base/base.js"></script>
 <title>Document</title>
 <style>
 *{
 margin:0;
 padding:0;
 font-family:'微软雅黑';
 }
 .lunbo{
 position: relative;
/*  width: 600px; */
 height: 50px;

 overflow: hidden;
 }
 ul{
 position:absolute;
 left: 0;
 top:0;
 width: 600px;
 height: auto;
 }
 ul li{
 width: 600px;
 height: 30px;
 line-height: 30px;
 font-size:16px;
 color:#fff;
 text-align: center
 }
 </style>
</head>
<body>
 <div class="lunbo">
	 <ul id="status_text">					
		<li><fmt:message code="title.login.txt" /></li>
		<li><fmt:message code="title.login.tex" /></li>
		<li><fmt:message code="title.login.text" /></li>
	</ul>
 </div>
   
<script>
    $(function(){
        //轮播的文字和秒数的接口
        $.ajax({
            type: "get",
            url: "<%=basePath%>/sys/getStatusText",
            dataType: 'JSON',
            success: function (obj) {

            }
        })
        //轮播功能
        function lunbo(id,height){
            var ul=$(id);
            var liFirst=ul.find('li:first');
            $(id).animate({top:height}).animate({"top":0},0,function(){
                var clone=liFirst.clone();
                $(id).append(clone);
                liFirst.remove();
            })
        }
        setInterval("lunbo('ul','-30px')",3000);
    })

</script>
</body>
</html>
