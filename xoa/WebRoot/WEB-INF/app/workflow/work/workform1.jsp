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
    <title>表单预览</title>
    <link rel="stylesheet" href="../../css/workflow/work/form.css">
    <%--<link rel="stylesheet" href="../../lib/easyui/themes/easyui.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="../lib/laydate.css"/>--%>
    <script type="text/javascript" src="../../js/news/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/base/base.js"></script>
    <script src="../../lib/laydate/laydate.js"></script>
    <script src="../../lib/layer/layer.js"></script>
    <%--<script src="../../lib/easyui/jquery.easyui.min.js"></script>--%>
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
//    $('#cc').combotree({
//        url: domain+'/department/getChDept?deptId=20',
//        loadFilter: function(node){
//            console.log(conver(node.obj))
//            alert("33");
//            return conver(node.obj);
//        },
//        onBeforeExpand:function(node,param){
//            $(this).tree('options').url = domain+'/department/getChDept?deptId='+node.id;
//            console.log($(this).tree('options').url )
//           alert("33");
//        }
//
//    });
    function comboTree(id,text,state,children){
        this.id = id;
        this.text = text;
        this.state = state;
        this.children = children;

    }
    function conver(data){
        console.log(data);
        var arr = [];
        data.forEach(function(v,i){
            arr.push(new comboTree(v.deptId,v.deptName,'close',[new comboTree()]));
        })
        return arr;
    }
    $(function(){
        var formid = $.getQueryString("formId");
        workForm.init({
            formhtmlurl:'../../form/formType',
            resdata:{
                fromId:formid
            },
            target:$('.formDesign')},
            function(data){
                console.log(data);
        });
    })



</script>
</body>
</html>
