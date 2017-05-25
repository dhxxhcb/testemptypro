<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>处理表单</title>
    <link rel="stylesheet" href="../../css/workflow/work/form.css">
    <%--<link rel="stylesheet" type="text/css" href="../lib/laydate.css"/>--%>
    <script type="text/javascript" src="../../js/news/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/base/base.js"></script>
    <script src="../../lib/laydate/laydate.js"></script>
    <script src="../../js/workflow/work/workform.js"></script>
</head>
<body>
<div>
    <div class="content">
        <div class="formDesign">

        </div>
    </div>
</div>

<script>
    $(function(){
        var formid = $.getQueryString("formId");


        workForm.init({
            formhtmlurl:'../../form/formType',
            formid:formid,
            target:$('.formDesign')},
            function(data){
                console.log(data);
        });
    })



</script>
</body>
</html>
