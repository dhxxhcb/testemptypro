<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../css/news/news_query.css"/>
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script>
        $(function(){
            $("li").click(function(){
                $(this).siblings('li').removeClass('one');  // 删除其他兄弟元素的样式
                $(this).addClass("one");
//            $(".news").html($(this).text());
                /* alert($(this).text());*/
            })
        })

    </script>

</head>
<body>
<!--head通栏开始-->
<div class="head w clearfix">
    <ul>
        <li class="one">全部新闻</li>
        <li style="width:2px;"><img src="images/02query.png" alt=""/></li>
        <li>未读新闻</li>
        <li style="width:2px;"><img src="images/02query.png" alt=""/></li>
        <li>新闻查询</li>
    </ul>
</div>
<!--head通栏结束-->
<!--center内容部分开始-->
<div class="center w">
    <div class="title clearfix">
        <img src="images/01query.png" alt=""/>
        <div class="news">新闻查询</div>
    </div>

    <div class="login">
        <div class="header">输入查询条件</div>
        <div class="middle">
            <div class="le publisher">
                <div class="color">发布人：</div>
                <div><input style="height:50px;width:279px;margin-left:56px;margin-right: 15px;" type="text" /></div>
                <div style="margin-right:23px; color:#207BD6">添加</div>
                <div>清空</div>
            </div>
            <div class="le subject">
                <div class="color">标题：</div>
                <div><input style="height:26px;width:279px;margin-left:69px;margin-right: 15px;" type="text"/></div>
            </div>
            <div class="le date">
                <div class="color">发布日期：</div>
                <div><input style="height:24px;width:119px;margin-left:38px;margin-right: 11px;" type="text"/></div>
                <div class="color">至</div>
                <div> <input  style="height:24px;width:119px;margin-left:11px;" type="text"/></div>
            </div>
            <div class="le ce1">
                <div class="color">内容：</div>
                <div><input  style="height:25px;width:279px;margin-left:70px;"   type="text"/></div>

            </div>
            <div class="le ce2">
                <div class="color">内容:</div>
                <div><input   style="height:25px;width:279px;margin-left:80px;" type="text"/></div>

            </div>
        </div>
        <div class="icons">
            <img style="margin-right:30px; cursor: pointer;" src="images/3query.png" alt=""/>
            <img style="margin-right:30px; cursor: pointer;"  src="images/4query.png" alt=""/>
            <img style=" cursor: pointer;" src="images/5query.png" alt=""/>
        </div>
    </div>

</div>
<!--center内容部分结束-->

</body>
</html>