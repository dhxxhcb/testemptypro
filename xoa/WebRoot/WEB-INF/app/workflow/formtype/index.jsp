<%--
  Created by IntelliJ IDEA.
  User: 王曰岐
  Date: 2017/5/11
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
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
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <link rel="stylesheet" type="text/css" href="../../css/workflow/index.css"/>
    <script type="text/javascript" src="../../js/jquery-1.9.1.js" ></script>
    <script type="text/javascript" src="../js/index.js" ></script>
    <title>s首页</title>
</head>
<body>

<div class="wrap">
    <div class="head">
        <div class="head_left"><h1>流程设计</h1></div>
        <div class="head_mid">
            <input class="inp" type="text" placeholder="输入表名称搜索">
            <div class="search"><h1>搜索</h1></div>
        </div>
        <div class="head_rig"><h1>新建</h1></div>
    </div>

    <div class="cont">
        <div class="cont_left">
            <div class="left_all">
                <h1 class="sort">流程分类</h1>
                <ul class="ul_all">
                    <li><img src="/../img/workflow/wenjian.png"><h1>公文管理</h1></li>
                    <li><img src="../img/workflow/wenjian.png"><h1>公文管理</h1>
                        <!-- <ul class="two_ul> -->

                        <!-- <li><img src="img/wenjian.png"><h1>差旅管理</h1></li> -->
                        <!-- <li><img src="img/wenjian.png"><h1>差旅管理</h1></li> -->

                        <!-- </ul> -->
                    </li>
                    <li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>
                    <li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>
                    <li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>
                    <li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>
                </ul>
            </div>

        </div>

        <div class="cont_rig">
            <div class="rig_every"></div>
            <div class="rig_every"></div>
            <div class="rig_every"></div>
            <div class="rig_every"></div>
            <div class="rig_every"></div>
            <div class="rig_every"></div>
        </div>





    </div>



    <div class="footer">

    </div>
</div>
</body>
</html>

