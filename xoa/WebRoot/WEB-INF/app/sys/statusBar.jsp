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
<head>
    <meta charset="UTF-8">
    <title>状态栏设置</title>
    <style type="text/css">
        *{margin: 0;padding: 0;}
        body{font-family: "微软雅黑";position: relative;top: 0;left: 0;width: 100%;height: 100%;}
        a{text-decoration: none;color: #2B7FE0;}
        ul{list-style: none;}
        .content{width: 100%;height: 100%;overflow: hidden;}
        .content .headDiv{width: 100%;height: 50px;border-bottom: #999 1px solid;font-weight: bold;}
        .content .header{display: block;height: 50px;line-height: 50px;font-size: 20px;margin-left: 30px;}
        .content .main{width: 95%;margin: 20px auto;border: #ccc 1px solid;}
        .content .main .title{width: 100%;height: 34px;border-bottom: #ccc 1px solid;}
        .content .main .title span{height: 100%;line-height: 34px;font-size: 14px;margin-left: 10px;}
        .content .main .text{width: 100%;border-bottom: #ccc 1px solid;}
        .content .main .text textarea{width: 99%;min-height: 300px;margin: 4px;outline: none;border: #ccc 1px solid;}
        .content .main .text p{font-size: 14px;color: #666;margin: 6px 0 10px 10px;}
        .content .main .time{width: 100%;border-bottom: #ccc 1px solid;padding: 10px 0;}
        .content .main .time span{font-size: 14px;margin-left: 10px;color: #666;}
        .content .main .sureBtn{width: 100%;}
        .content .main .sureBtn .btn{border: #ddd 1px solid;width: 50px;height: 24px;margin: 5px auto;text-align: center;line-height: 24px;font-size: 14px;border-radius: 5px;background-color: #fafafa;cursor: pointer;}
    </style>

</head>
<body>
<div class="content">
    <div class="headDiv">
        <p class="header">状态栏设置</p>
    </div>
    <div class="main">
        <div class="title">
            <span>状态栏文字设置</span>
        </div>
        <div class="text">
            <textarea name="txt" ></textarea>
            <p>提示：多行文字可以实现轮换显示</p>
        </div>
        <div class="time">
            <span>滚动时间设置为：</span>
            <input type="text" />
            <span>秒</span>
        </div>
        <div class="sureBtn">
            <div class="btn" id="btn">确定</div>
        </div>
    </div>
</div>
</body>
</html>
