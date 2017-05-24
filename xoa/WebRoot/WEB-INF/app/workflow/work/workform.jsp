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
    <title>新建工作</title>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8 ? MYOA_CHARSET : htmlspecialchars($HTML_PAGE_CHARSET))?>" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../../css/workflow/m_reset.css">
    <link rel="stylesheet" type="text/css" href="../../css/workflow/work/new_work.css">
    <script type="text/javascript" src="../../js/news/jquery-1.9.1.js"></script>
    <script src="../../js/base/base.js"></script>
    <script src="../../js/workflow/work/workform.js"></script>
</head>

<style type="text/css">
</style>

<body>
<div class="body">
    <div class="head">
        <div id="title" class="abs_left">
            <h1 class="num">NO.767 督查督办</h1>
            <h1 class="step">主办（第一步 : 督查内容填写 2017-5-24 13:58）</h1>
            <select>
                <option>普通</option>
                <option>紧急</option>
            </select>
        </div>

        <div class="abs_right">
            <ul>
                <li id="check">附件</li>
                <li>会签</li>
                <li>流程</li>
                <li>关联</li>
            </ul>
        </div>
    </div>
    <div class="cont" id="client">
        <div class="cont_form">

        </div>
    </div>
    <div class="foot">
        <div class="foot_left">
            <ul>
                <li class="left_li"><img class="left_img" src="../../img/workflow/work/add_work/sheji.png"><h1 class="left_h1">流程图</h1></li>
                <li class="left_li"><img class="left_img" src="../../img/workflow/work/add_work/sheji.png"><h1 class="left_h1">委托</h1></li>
                <li class="left_li"><img class="left_img" src="../../img/workflow/work/add_work/sheji.png"><h1 class="left_h1">打印</h1></li>
                <li class="left_li"><img class="left_img" src="../../img/workflow/work/add_work/sheji.png"><h1 class="left_h1">其他</h1></li>
            </ul>
        </div>
        <div class="foot_rig">
            <ul>
                <li class="rig_li"><img class="rig_img" src="../../img/workflow/work/add_work/sheji.png"><h1 class="rig_h1">转交下一步</h1></li>
                <li class="rig_li"><img class="rig_img" src="../../img/workflow/work/add_work/sheji.png"><h1 class="rig_h1">保存</h1></li>
                <li class="rig_li"><img class="rig_img" src="../../img/workflow/work/add_work/sheji.png"><h1 class="rig_h1">保存返回</h1></li>
                <li class="rig_li"><img class="rig_img" src="../../img/workflow/work/add_work/sheji.png"><h1 class="rig_h1">其他</h1></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function(){
        var formid = $.getQueryString("formId");

        workForm.buildHTML($('.cont_form'),formid);

    });
</script>
<script>
    autodivheight();
    function autodivheight(){
        var winHeight=0;
        if (window.innerHeight)
            winHeight = window.innerHeight;
        else if ((document.body) && (document.body.clientHeight))
            winHeight = document.body.clientHeight;
        if (document.documentElement && document.documentElement.clientHeight)
            winHeight = document.documentElement.clientHeight;
        winWidth = document.documentElement.clientWidth;
        document.getElementById("client").style.height= winHeight - 104 +"px";
        document.getElementById("client").style.width= winWidth  +"px";

    }
    window.onresize=autodivheight;

</script>




