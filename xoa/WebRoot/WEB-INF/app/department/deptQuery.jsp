<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>部门信息查询</title>
    <link rel="stylesheet" type="text/css" href="../css/base.css"/>
    <link rel="stylesheet" type="text/css" href="../css/news/new_news.css"/>
    <link rel="stylesheet" type="text/css" href="../css/dept/deptQuery.css"/>
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
<div class="headDept clearfix">
    <img src="../img/la2.png">
    <div class="">
        部门/成员单位查询
    </div>
</div>
<!--content部分开始-->

<table id="tr_td">
    <thead>
    <tr>
        <td class="th">部门/成员单位</td>
        <td class="th">部门主管</td>
        <td class="th">部门助理</td>
        <td class="th">主管领导</td>
        <td class="th">分管领导</td>
        <td class="th">电话</td>
        <td class="th">传真</td>
        <td class="th">地址</td>
        <td class="th">职能</td>
    </tr>
    </thead>
    <tbody id="j_tb">
    <tr class="">
        <td>1</td>
        <td class="">系统管理员</td>
        <td class="">公司动态</td>
        <td>管理部</td>
        <td>
            <div>提供一个ebXML框架</div>
       </td>
        <td class="">2017-05-12 18:11:46</td>
        <td class="">53</td>
        <td class="">119</td>
        <td>1</td>
    </tr>
    <tr class="">
        <td>1</td>
        <td class="">系统管理员</td>
        <td class="">公司动态</td>
        <td>管理部</td>
        <td>
            <div>提供一个ebXML框架</div>
        </td>
        <td class="">2017-05-12 18:11:46</td>
        <td class="">53</td>
        <td class="">119</td>
        <td>1</td>
    </tr>
    <tr class="">
        <td>1</td>
        <td class="">系统管理员</td>
        <td class="">公司动态</td>
        <td>管理部</td>
        <td>
            <div>提供一个ebXML框架</div>
        </td>
        <td class="">2017-05-12 18:11:46</td>
        <td class="">53</td>
        <td class="">119</td>
        <td>1</td>
    </tr>


    </tbody>
</table>
<!--content部分结束-->


</body>
</html>
