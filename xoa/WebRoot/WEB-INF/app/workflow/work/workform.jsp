<%--
  Created by IntelliJ IDEA.
  User: zhuzy
  Date: 2017/5/23
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理表单</title>
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../js/base/base.js"></script>
</head>
<body>
<div>
    <div class="content">
        <div class="formDesign">

        </div>
    </div>
</div>
<
<script>
    $(function(){
        var workForm = {
            formhtmlurl : '../form/formType',
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
                        console.log(res);

                    }
                });
            }
        }
        workForm.buildHTML($('#formDesign'),116)
    })



</script>
</body>
</html>
