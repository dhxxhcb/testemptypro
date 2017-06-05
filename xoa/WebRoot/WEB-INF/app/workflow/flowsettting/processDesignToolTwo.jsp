<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2017/5/23
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>流程设计器</title>
    <link rel="stylesheet" type="text/css" href="../../lib/GooFlow/GooFlow.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/workflow/flowtype/default.css"/>
    <link rel="stylesheet" href="../../css/workflow/flowsetting/processDesignTool.css">
    <%--<link rel="stylesheet" type="text/css" href="../../lib/layer/mobile/need/layer.css" media="all"/>--%>
    <link rel="stylesheet" href="../../lib/layui-v1.0.9_rls/layui/css/layui.css">

    <script>
        var changeTheValue=true;
    </script>
    <script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/base/base.js"></script>
    <script type="text/javascript" src="../../lib/GooFlow/GooFunc.js"></script>
    <script type="text/javascript" src="../../lib/GooFlow/GooFlow.js"></script>

    <!-- <script type="text/javascript" src="../../js/workflow/json2.js"></script> -->
    <script src="../../js/workflow/work/workform.js"></script>
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
    </style>
    <script type="text/javascript">


    </script>
</head>
<body>



<div id="flowDesignTable" ></div>
<script>
    var flowidurl=window.location.href;
    var flowstr=flowidurl.substring(flowidurl.indexOf('=')+1)
    var numId={};
    var $width=$('body').width();
    var $height=$(document).height();
    var numIds={};
    function savemobile() {
        return;
    }

    var property = {
        width: $width,
        height: $height,
        toolBtns: ["chat", "end round"],
//                "start round", "end round", "task round", "node","state", "plug", "join", "fork", "complex mix"
        haveHead: true,
        headBtns: [ ],//如果haveHead=true，则定义HEAD区的按钮
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
    $('.GooFlow_head').hide();
    $('.GooFlow_tool').hide();
    $('.GooFlow_work').css({'width':'100%','height':'100%'})
    $.ajax({
        type: 'get',
        url: '/flowProcess/flowview',
        dataType: 'json',
        data: {"flowId":flowstr},
        success: function (json) {
            // debugger;
//                    获取数据并添加到流程设计器的插件中
            if (json.flag) {
                var designdata = json.object.designdata;
                var connections = json.object.connections;
                jsondata={
                    "title": "",
                    "nodes": {},
                    "lines": {},
                    "areas": {},
                    "initNum": 0
                }
                console.log(json)
                jsondata.title = json.object.designdata[0].flowTypeModel.flowName;
                jsondata.initNum = designdata.length;
                designdata.forEach(function (v, i) {
                    console.log(v)
                    jsondata.nodes['node_' + v.prcsId] = {
                        designerId:v.id,
                        name: v.prcsName,
                        left: v.setLeft,
                        type: v.setType,
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
               return;
            };


            flowDesign.loadData(jsondata);
            flowDesign.moveNode=function () {
                alert('预览模式不允许修改')
                return;
            }
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

                }




//                $("#ele_name").val(obj.name);
                return true;
            };
        },
    });


</script>
</body>

</html>
