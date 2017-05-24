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
        var workForm = {
            formhtmlurl : '../../form/formType',
            render:function(){
                this.bindDateEvent();
            },
            bindDateEvent:function(){
                console.log( $('img.DATE').length);
                //过滤老版本数据

                var olddata = $('img.DATE');
                for(var i=0;i< olddata.length;i++){
                    var obj = olddata.eq(i);
                    var objprev = obj.prev();
                    var date_format =  obj.attr('date_format');
                    var name = objprev.attr('name')
                   // var laydate = 'laydate({istime: true,format:"YYYY-MM-DD hh:mm:ss"})';
                    var laydate = 'laydate({istime: true})';
                    //var inputObj = '<div id="'+name+'" date_format="'+date_format+'" name="'+name+'"  style="'+objprev.attr('style')+'" title="'+objprev.attr('title')+'" class="laydate-icon form_item" onclick="'+laydate+'"></div>';
                    var inputObj = '<div id="'+name+'" date_format="'+date_format+'" name="'+name+'"  style="'+objprev.attr('style')+'" title="'+objprev.attr('title')+'" class="laydate-icon form_item" onclick="laydate({istime: true,format:"'+date_format+'"})"></div>';

                    olddata.eq(i).prev().remove();
                    olddata.eq(i).before(inputObj);
                    olddata.eq(i).remove();

                }
                $('img.DATE').prev().on("click",function(){
                    console.log(22);
                    laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})
                })
            },
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
                        that.render();
                    }
                });
            }
        }
        workForm.buildHTML($('.formDesign'),formid);

    })



</script>
</body>
</html>
