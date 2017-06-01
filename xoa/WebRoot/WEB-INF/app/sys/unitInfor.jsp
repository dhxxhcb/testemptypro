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
    <title>单位信息查询</title>
</head>
<body>
<div class="content">
    <div class="headDiv">
        <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
        <div class="divP">单位信息</div>
    </div>
    <div class="tab">
        <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
            <tr>
                <td>单位名称：</td>
                <td></td>
            </tr>
            <tr>
                <td class="blue_text">电话：</td>
                <td></td>
            </tr>
            <tr>
                <td class="blue_text">传真：</td>
                <td></td>
            </tr>
            <tr>
                <td class="blue_text">邮编：</td>
                <td></td>
            </tr>
            <tr>
                <td class="blue_text">地址：</td>
                <td></td>
            </tr>
            <tr>
                <td class="blue_text">网站：</td>
                <td></td>
            </tr>
            <tr>
                <td class="blue_text">电子信箱：</td>
                <td></td>
            </tr>
            <tr>
                <td class="blue_text">开户行：</td>
                <td></td>
            </tr>
            <tr>
                <td class="blue_text">账号：</td>
                <td></td>
            </tr>
            <tr>
                <td colspan="2">单位简介</td>
            </tr>
            <tr>
                <td>附件文档：</td>
                <td class="enclosure"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="container" style="width: 99.9%;min-height: 300px;" name="content" type="text/plain"></div>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>

