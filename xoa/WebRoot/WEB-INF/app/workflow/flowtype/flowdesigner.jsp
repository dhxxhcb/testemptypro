<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>流程图DEMO</title>
    <link rel="stylesheet" type="text/css" href="../../lib/GooFlow/GooFlow.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/workflow/flowtype/default.css"/>
    <script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../lib/GooFlow/GooFunc.js"></script>
    <script type="text/javascript" src="../../lib/GooFlow/GooFlow.js"></script>
    <!-- <script type="text/javascript" src="../../js/workflow/json2.js"></script> -->
    <style>
        .myForm {
            display: block;
            margin: 0px;
            padding: 0px;
            line-height: 1.5;
            border: #ccc 1px solid;
            font: 12px Arial, Helvetica, sans-serif;
            margin: 5px 5px 0px 0px;
            border-radius: 4px;
        }

        .myForm .form_title {
            background: #428bca;
            padding: 4px;
            color: #fff;
            border-radius: 3px 3px 0px 0px;
        }

        .myForm .form_content {
            padding: 4px;
            background: #fff;
        }

        .myForm .form_content table {
            border: 0px
        }

        .myForm .form_content table td {
            border: 0px
        }

        .myForm .form_content table .th {
            text-align: right;
            font-weight: bold
        }

        .myForm .form_btn_div {
            text-align: center;
            border-top: #ccc 1px solid;
            background: #f5f5f5;
            padding: 4px;
            border-radius: 0px 0px 3px 3px;
        }

        #propertyForm {
            z-index: 12;
            float: right;
            width: 260px
        }
    </style>
    <script type="text/javascript">
        var flowDesign;
        var jsondata = {
            "title": "",
            "nodes": {},
            "lines": {},
            "areas": {},
            "initNum": 0
        }
        $(function () {
            var property = {
                width: 1500,
                height: 800,
                toolBtns: ["start round", "end round", "task round", "node", "chat", "state", "plug", "join", "fork", "complex mix"],
                haveHead: true,
                headBtns: ["new", "open", "save", "undo", "redo", "reload"],//如果haveHead=true，则定义HEAD区的按钮
                haveTool: true,
                haveGroup: true,
                useOperStack: true
            };
            var remark = {
                cursor: "选择指针",
                direct: "结点连线",
                start: "入口结点",
                end: "结束结点",
                task: "任务结点",
                node: "自动结点",
                chat: "决策结点",
                state: "状态结点",
                plug: "附加插件",
                fork: "分支结点",
                join: "联合结点",
                "complex mix": "复合结点",
                group: "组织划分框编辑开关"
            };
            flowDesign = $.createGooFlow($("#flowDesignTable"), property);
            flowDesign.setNodeRemarks(remark);
            $.ajax({
                type: 'get',
                url: '<%=basePath%>flowProcess/flowview',
                dataType: 'json',
                data: {"flowId":${formId}},
                success: function (json) {
                    // debugger;
//                    获取数据并添加到流程设计器的插件中
                    if (json.flag) {
                        var designdata = json.object.designdata;
                        var connections = json.object.connections;
                        jsondata.title = json.object.designdata[0].flowName;
                        jsondata.initNum = designdata.length;
                        designdata.forEach(function (v, i) {
                            jsondata.nodes['node_' + v.prcsId] = {
                                designerId:v.id,
                                name: v.prcsName,
                                left: v.setLeft,
                                type: "chat",
                                top: v.setTop

                            }
                        });
                        connections.forEach(function (v, i) {
                            jsondata.lines['line_' + i] = {
                                type: "sl",
                                from: "node_" + v.from,
                                to: "node_" + v.to,
                                name: "",
                                "M": 41.5,
                                alt: true
                            }
                        });
                    }
                    flowDesign.onItemDel = function (id, type) {
                        if (confirm("确定要删除该单元吗?")) {
                            this.blurItem();
                            return true;
                        } else {
                            return false;
                        }
                    };
                    flowDesign.loadData(jsondata);
                    flowDesign.onItemFocus = function (id, model) {
                        var obj;
                        $("#ele_model").val(model);
                        $("#ele_id").val(id);
                        if (model == "line") {
                            obj = this.$lineData[id];
                            $("#ele_type").val(obj.M);
                            $("#ele_left").val("");
                            $("#ele_top").val("");
                            $("#ele_width").val("");
                            $("#ele_height").val("");
                            $("#ele_designerId").val("");
                            $("#ele_from").val(obj.from);
                            $("#ele_to").val(obj.to);
                            $("#ele_flow").val("");

                        } else if (model == "node") {
                            obj = this.$nodeData[id];
                            $("#ele_type").val(obj.type);
                            $("#ele_designerId").val(obj.designerId);
                            $("#ele_left").val(obj.left);
                            $("#ele_top").val(obj.top);
                            $("#ele_width").val(obj.width);
                            $("#ele_height").val(obj.height);
                            $("#ele_from").val("");
                            $("#ele_to").val("");
                            $("#ele_flow").val('${formId}');
                        }
                        $("#ele_name").val(obj.name);
                        return true;
                    };
//                    $("#submit").click(function () {
//                        document.getElementById("result").value = JSON.stringify(flowDesign.exportData());
//                    });
                },
            });
        });
    </script>
</head>
<body>

<div id="flowDesignTable" style="margin:10px"></div>
<%--<input id="submit" type="button" value='导出结果'/>--%>
<%--<textarea id="result" row="6"></textarea>--%>
<div id="propertyForm">
    <form class="myForm">
        <div class="form_title">属性设置</div>
        <div class="form_content">
            <table>
                <tr>
                    <td class="th">Id：</td>
                    <td><input type="text" style="width:120px" id="ele_id"/>
                        <input type="hidden" style="width:120px" id="ele_designerId"/></td>
                </tr>
                <%--<tr>
                    <td class="th">FlowId：</td>
                    <td><input type="hidden" style="width:120px" id="ele_flowId"/></td>
                </tr>--%>
                <tr>
                    <td class="th">Name：</td>
                    <td>
                        <input type="text" style="width:120px" id="ele_name"/>
                        <input type="hidden" style="width:120px" id="ele_flow"/>
                    </td>
                </tr>
                <tr>
                    <td class="th">Type：</td>
                    <td><input type="text" style="width:120px" id="ele_type"/></td>
                </tr>
                <tr>
                    <td class="th">Model：</td>
                    <td><input type="text" style="width:120px" id="ele_model"/></td>
                </tr>
                <tr>
                    <td class="th">Left-r：</td>
                    <td><input type="text" style="width:120px" id="ele_left"/></td>
                </tr>
                <tr>
                    <td class="th">Top-r：</td>
                    <td><input type="text" style="width:120px" id="ele_top"/></td>
                </tr>
                <tr>
                    <td class="th">Width：</td>
                    <td><input type="text" style="width:120px" id="ele_width"/></td>
                </tr>
                <tr>
                    <td class="th">Height：</td>
                    <td><input type="text" style="width:120px" id="ele_height"/></td>
                </tr>
                <!-- 步骤关系需用箭头控制 -->
                <tr>
                    <td class="th">From：</td>
                    <td><input type="text" style="width:120px" id="ele_from"/></td>
                </tr>
                <tr>
                    <td class="th">To：</td>
                    <td><input type="text" style="width:120px" id="ele_to"/></td>
                </tr>
            </table>
        </div>
        <div class="form_btn_div">
            <input type="reset" value="重置"/>
            <input type="button" value="确定" id="saveOrUpdate" />
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    $("#saveOrUpdate").click(function () {
        var id = $("#ele_designerId").val();
       // 保存和修改需调试字段
        if(id == "" || id == null){
           var prcssId = $("#ele_id").val().substring(5,$("#ele_id").val().length);
            var data={
                "prcsId":prcssId,
                "flowId":$("#ele_flow").val(),
                "prcsName":$("#ele_name").val(),
                "setLeft" : $("#ele_left").val(),
                "setTop" : $("#ele_top").val()
            };
            alert("进入新建方法");
            //保存
            $.ajax({
                type: 'POST',
                url: '<%=basePath%>flowProcess/insert',
                dataType: 'json',
                data: data,
                success: function (json) {
//                alert(json.flag);
                    if (json.flag) {
                        alert("新建流程节点成功");
                    }else{
                        alert("新建流程节点失败");
                    }
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("数据库连接异常，请联系管理员");
                }
            });
        }else{
            var data={
                "id":id,
                "prcsName":$("#ele_name").val(),
                "setLeft" : $("#ele_left").val(),
                "setTop" : $("#ele_top").val()
            };
            //修改
        $.ajax({
            type: 'POST',
            url: '<%=basePath%>flowProcess/saveFlow',
            dataType: 'json',
            data: data,
            success: function (json) {
//                alert(json.flag);
                if (json.flag) {
                    alert("修改成功");
                }else{
                    alert("修改失败");
                }
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("数据库连接异常，请联系管理员");
            }
        });
    }
    })


</script>



</html>

