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
    <link rel="stylesheet" type="text/css" href="../../css/easyui/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/easyui/icon.css"/>
    <script type="text/javascript" src="../../js/jquery-1.9.1.js" ></script>
    <script type="text/javascript" src="../../js/easyui/jquery.easyui.min.js" ></script>
    <script type="text/javascript" src="../../js/easyui/tree.js" ></script>
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
                <div class="ul_all" id="li_parent">
                    <%--<li><img src="/../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                </div>
            </div>

        </div>

        <div class="cont_rig">
            <%--<div class="rig_every"></div>--%>
            <%--<div class="rig_every"></div>--%>
            <%--<div class="rig_every"></div>--%>
            <%--<div class="rig_every"></div>--%>
            <%--<div class="rig_every"></div>--%>
            <%--<div class="rig_every"></div>--%>
        </div>





    </div>



    <div class="footer">

    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
       //获取左侧分类
        var data=[{"dataId":"1","children":[{"dataId":"13","children":[],"checked":false,"attributes":{"id":13,"type":"0"},"id":"13","state":null,"text":"行政办公制度","url":null,"parentId":"1"},{"dataId":"43","children":[],"checked":false,"attributes":{"id":43,"type":"0"},"id":"43","state":null,"text":"人力资源开发与管理制度","url":null,"parentId":"1"},{"dataId":"44","children":[],"checked":false,"attributes":{"id":44,"type":"0"},"id":"44","state":null,"text":"采购报销和备用金制度","url":null,"parentId":"1"}],"checked":false,"attributes":{"id":1,"type":"0"},"id":"1","state":null,"text":"公司管理制度","url":null,"parentId":"0"},{"dataId":"39","children":[{"dataId":"45","children":[],"checked":false,"attributes":{"id":45,"type":"0"},"id":"45","state":null,"text":"综合管理部职能分配","url":null,"parentId":"39"},{"dataId":"46","children":[],"checked":false,"attributes":{"id":46,"type":"0"},"id":"46","state":null,"text":"财务管理制度","url":null,"parentId":"39"},{"dataId":"47","children":[],"checked":false,"attributes":{"id":47,"type":"0"},"id":"47","state":null,"text":"项目部项目管理规范","url":null,"parentId":"39"}],"checked":false,"attributes":{"id":39,"type":"0"},"id":"39","state":null,"text":"部门管理制度","url":null,"parentId":"0"},{"dataId":"3","children":[],"checked":false,"attributes":{"id":3,"type":"0"},"id":"3","state":null,"text":"公司大事记","url":null,"parentId":"0"},{"dataId":"40","children":[{"dataId":"41","children":[],"checked":false,"attributes":{"id":41,"type":"0"},"id":"41","state":null,"text":"系统使用","url":null,"parentId":"40"},{"dataId":"42","children":[],"checked":false,"attributes":{"id":42,"type":"0"},"id":"42","state":null,"text":"公司知识库","url":null,"parentId":"40"}],"checked":false,"attributes":{"id":40,"type":"0"},"id":"40","state":null,"text":"学习资料","url":null,"parentId":"0"},{"dataId":"10","children":[],"checked":false,"attributes":{"id":10,"type":"0"},"id":"10","state":null,"text":"文档标准","url":null,"parentId":"0"}]
        $('#li_parent').tree({
            url: '../../workflow/flowclassify/flowJsTree',
            animate:true,
            lines:true,
            loadFilter: function(rows){
                console.log(rows);
                return convert(rows.datas);
            },
            onClick:function(node){
                getFlowList(node.id);
            }
        });



        //处理树结构
        function convert(rows){
            function exists(rows, parentId){
                for(var i=0; i<rows.length; i++){
                    if (rows[i].sortId == parentId) return true;
                }
                return false;
            }
            var nodes = [];
            // get the top level nodes
            for(var i=0; i<rows.length; i++){
                var row = rows[i];
                if (!exists(rows, row.sortParent)){
                    nodes.push({
                        id:row.sortId,
                        text:row.sortName
                    });
                }
            }
            var toDo = [];
            for(var i=0; i<nodes.length; i++){
                toDo.push(nodes[i]);
            }
            while(toDo.length){
                var node = toDo.shift();	// the parent node
                // get the children nodes
                for(var i=0; i<rows.length; i++){
                    var row = rows[i];
                    if (row.sortParent == node.id){
                        var child = {id:row.sortId,text:row.sortName};
                        if (node.children){
                            node.children.push(child);
                        } else {
                            node.children = [child];
                        }
                        toDo.push(child);
                    }
                }
            }
            return nodes;
        }

        function getFlowList(sortId) {
            $.post("../../flow/flowlistbysort",{flowId:sortId} ,function (ret) {
                console.log(ret);
                if(ret.flag==true){
                   renderDatas(ret.obj);
                }
            },"json");
        }

        function renderDatas(data) {
            var html="";
            for(var i =0 ;i<data.length;i++){
                
            }
        }






    })
</script>

</html>

