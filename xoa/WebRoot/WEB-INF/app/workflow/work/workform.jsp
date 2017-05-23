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
    <script type="text/javascript" src="../../js/news/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/base/base.js"></script>
</head>
<body>
<div>
    <div class="content">
        <div class="formDesign">
往往
        </div>
    </div>
</div>

<script>
    $(function(){
        var workForm = {
            formhtmlurl : '../../form/formType',
            buildHTML:function(target,formid){
                var that = this;
                $.ajax({
                    type: "get",
                    url: that.formhtmlurl,
                    dataType: 'JSON',
                    data: {
                        fromId :formid
                    },
                    success: function (res) {

                        target.html(res.object.printModel);
                    }
                });
            }
        }
        workForm.buildHTML($('.formDesign'),116)
    })



</script>
</body>
</html>
