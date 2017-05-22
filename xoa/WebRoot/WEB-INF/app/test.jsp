<%--
  Created by IntelliJ IDEA.
  User: 王曰岐
  Date: 2017/5/8
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../lib/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../../lib/pagination/style/pagination.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/news/center.css"/>
    <script type="text/javascript" src="../../js/news/jquery-1.9.1.js"></script>

    <script src="../../js/news/page.js"></script>
    <script src="../lib/laydate.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/layer/layer.js"></script>
</head>

<body>

</body>

<script>
    function items(){
        $.ajax({
            url:'/department/getAlldept',
            type:'get',
            dataType:'json',
            success:function(obj){
                var data=obj.obj;
                console.log(data);
                console.log( digui(data,0));
            }
        });
    }
    items()
    function digui(datas,departId) {
        var data=new Array();
        for(var i=0;i<datas.length;i++){
           if(datas[i].deptParent==departId){
               datas[i]["childs"]=digui(datas,datas[i].deptId);
               data.push(datas[i]);
           }
        }
        return data;
    }
</script>

</html>
