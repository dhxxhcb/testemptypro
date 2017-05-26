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
    <script type="text/javascript" src="../../lib/layer/layer.js"></script>
    <script type="text/javascript" src="../../lib/layui-v1.0.9_rls/layui/layui.js"></script>
    <script type="text/javascript" src="../../lib/GooFlow/GooFunc.js"></script>
    <script type="text/javascript" src="../../lib/GooFlow/GooFlow.js"></script>
    <script src="../../js/workflow/flowtype/processDesignTool.js"></script>
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
            var $width=$('body').width();
            var $height=$('body').height();
            console.log($width)
            var property = {
                width: $width,
                height: $height,
                toolBtns: ["chat"],
//                "start round", "end round", "task round", "node","state", "plug", "join", "fork", "complex mix"
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
                url: 'flowProcess/flowview',
                dataType: 'json',
                data: {"flowId":''},
                success: function (json) {
                    // debugger;
//                    获取数据并添加到流程设计器的插件中
                    if (json.flag) {
                        var designdata = json.object.designdata;
                        var connections = json.object.connections;
                        jsondata.title = json.object.designdata[0].flowName;
                        jsondata.initNum = designdata.length;
                        designdata.forEach(function (v, i) {
                            jsondata.nodes['步骤_' + v.prcsId] = {
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
                },
            });


        });
    </script>
</head>
<body>
    <div id="flowDesignTable" ></div>
    <form action="" class="layui-form">
        <div id="propertyForm" >
            <div class="setUpThe">
                <span class="basic"></span>
                <label>基本设置</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl" style="display: none">
                <li>
                    <p class="candidatesPone">
                        序号
                    </p>
                    <p class="candidatesPTwo">
                        <input type="text" value="">
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        节点类型
                    </p>
                    <div class="dropDownDiv">
                        <p class="candidatesPTwo">
                            <%--<input type="text" readonly="true" value="不进行自动选择" style="cursor: pointer;"><span class="xiala"><b></b></span>--%>
                            <%--<input type="hidden">--%>
                                <select name="city" lay-verify="">
                                    <option value="">不进行自动选择</option>
                                    <option value="010">北京</option>
                                    <option value="021">上海</option>
                                    <option value="0571">杭州</option>
                                </select>
                        </p>
                        <%--<ol class="dropDown">--%>
                            <%--<li>--%>
                                <%--<span>步骤节点</span>--%>
                                <%--<input type="hidden" value="1">--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<span>子流程节点</span>--%>
                                <%--<input type="hidden" value="2">--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<span>柔性节点</span>--%>
                                <%--<input type="hidden" value="3">--%>
                            <%--</li>--%>
                        <%--</ol>--%>
                    </div>
                </li>
                <li>
                    <p class="candidatesPone">
                        步骤名称
                    </p>
                    <p class="candidatesPTwo" style="margin-bottom: 20px">
                        <input type="text"  value="提交出差申请">
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        下一步骤
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <ul>

                        </ul>
                        <div style="float:left;">
                            <a href="javascript:;" class="bottomsteps">选择</a>
                        </div>
                    </div>

                </li>
            </ul>
            <div class="setUpThe">
                <span class="agent"></span>
                <label>经办人</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl">
                <li>
                    <p class="candidatesPone">
                        授权范围（人员）
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <input type="text" id="query_userId" readonly="true">
                        <div style="float:left;">
                            <a href="javascript:;" data-num="1" class="theCandidates">添加</a>
                        </div>
                    </div>
                </li>
                <li>
                    <p class="candidatesPone">
                        授权范围（部门）
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <input type="text" id="department" readonly="true">
                        <div style="float:left;">
                            <a href="javascript:;" data-num="2" class="theCandidates">添加</a>
                        </div>
                    </div>
                </li>
                <li>
                    <p class="candidatesPone">
                        授权范围（角色）
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <input type="text" id="theScopeOf" readonly="true">
                        <div style="float:left;">
                            <a href="javascript:;" data-num="3" class="theCandidates">添加</a>
                        </div>
                    </div>
                </li>
                <li>
                    <p class="candidatesPone">
                        会签人设置
                    </p>
                   <p class="candidatesPothree">
                       <label>
                               <input type="radio" name="" value="男" title="不允许">
                               <input type="radio" name="" value="女" title="本步骤经办人">
                               <input type="radio" name="" value="禁" title="全部人员">
                       </label>
                   </p>
                    <p class="candidatesPothree">
                        <label>
                            <input type="radio" title="本步骤经办人">
                        </label>
                    </p>
                    <p class="candidatesPothree">
                        <label>
                            <input type="radio" title="全部人员">
                        </label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否允许会签人加签
                    </p>
                    <p class="candidatesPothree">
                        <label>
                            <input type="radio" title="不允许">
                        </label>
                    </p>
                    <p class="candidatesPothree">
                        <label>
                            <input type="radio" title="允许">
                        </label>
                    </p>
                </li>
            </ul>
            <div class="setUpThe">
                <span class="candidates"></span>
                <label>智能选人</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl" style="display: none">
                <li>
                    <p class="candidatesPone">
                        选人过滤规则
                    </p>
                    <p class="candidatesPTwo">
                    <%--<input type="text" readonly="true" value="允许选择全部指定的经办人"><span class="xiala"><b></b></span>--%>
                        <select name="city" lay-verify="">
                            <option value="010">北京</option>
                            <option value="021" disabled>上海（禁用效果）</option>
                            <option value="0571" selected>杭州</option>
                        </select>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        自动选择人规则
                    </p>
                    <p class="candidatesPTwo" style="margin-bottom: 20px">
                        <%--<input type="text" readonly="true" value="不进行自动选择"><span class="xiala"><b></b></span>--%>
                            <select name="city" lay-verify="">
                                <option value="010">北京</option>
                                <option value="021" disabled>上海（禁用效果）</option>
                                <option value="0571" selected>杭州</option>
                            </select>
                    </p>
                </li>
            </ul>
            <div class="setUpThe">
                <span class="flowSet"></span>
                <label>流转设置</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl" style="display: none">
                <li>
                    <p class="candidatesPone">
                        主办人相关选项
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio"title="明确指定主办人"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="无主办人会签">	</label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="先接收者为主办人">	</label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否允许修改主办人相关选项
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="不允许"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="允许"	</label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否允许会签
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="允许会签"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="禁止会签"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="强制会签"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        会签意见可见性
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="总是可见"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="本步骤经办人之间不可见"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="针对其他步骤不可见"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        经办人未办理完毕时是否允许主办人强制转交
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="允许"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="不允许"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否允许退回
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="不允许"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="允许退回上一步骤"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="允许退回之前步骤"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否允许并发
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="禁止并发"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="允许并发"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="强制并发"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        并发合并选项
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="非强制合并"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="强制合并"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        传阅设置
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="允许"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="不允许"></label>
                    </p>
                </li>
            </ul>

            <div class="setUpThe" id="canWriteField">
                <span class="conditionsSet"></span>
                <label>可写字段</label>
                <b class="notstart"></b>
            </div>
            <div class="setUpThe">
                <span class="conditionsSet"></span>
                <label>保密字段</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl">
                <li>
                    <p class="candidatesPone">
                        编辑保密字段
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <ul></ul>
                        <div style="float: left">
                            <a href="javascript:;" class="bottomsteps">选择</a>
                        </div>
                    </div>
                </li>
            </ul>
            <div class="setUpThe">
                <span class="conditionsSet"></span>
                <label>必填字段</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl">
                <li>
                    <p class="candidatesPone">
                        编辑必填字段
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <ul></ul>
                        <div style="float: left">
                            <a href="javascript:;" class="bottomsteps">选择</a>
                        </div>
                    </div>
                </li>
            </ul>
            <div class="setUpThe" id="conditions">
                <span class="conditionsSet"></span>
                <label>条件设置</label>
                <b class="notstart"></b>
            </div>
            <div class="setUpThe">
                <span class="dealWithTime"></span>
                <label>办理时限</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl" style="display: none">
                <li>
                    <p class="candidatesPoform" style="margin-top: 20px;">
                        <%--<input type="text"><span>小时</span>--%>
                            <select name="city" lay-verify="">
                                <option value="">小时</option>
                                <option value="010">北京</option>
                                <option value="021">上海</option>
                                <option value="0571">杭州</option>
                            </select>
                    </p>
                    <p class="candidatesPone">
                        是否允许转交时设置办理时限
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="允许"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="不允许"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        超时计算方法
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="本步骤接收后开始计时"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="上一步骤转交后开始计时"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        工作天数换算方式
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="24小时为一天"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="按个人排班类型工作时长为一天"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否排除非工作时段(按排班类型)
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="否"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" title="是"></label>
                    </p>
                </li>
            </ul>
            <div class="setUpThe" id="theTrigger">
                <span class="dealWithTime"></span>
                <label>触发器</label>
                <b class="notstart"></b>
            </div>
            <div class="setUpThe">
                <span class="dealWithTime"></span>
                <label>提醒设置</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl" style="display: none">
                <li>
                    <p class="candidatesPone">
                        事务提醒设置
                    </p>
                    <p class="candidatesPothree">
                      <input type="checkbox" title="此步骤是否独立设置提醒方式">

                    </p>
                    <p class="candidatesPone activeall">
                        提醒开启状态
                    </p>
                    <p class="candidatesPothree activeall">
                        <label>下一步骤</label><br><input type="checkbox" lay-skin="primary"><i></i>
                        <input type="checkbox" lay-skin="primary"><i></i>
                        <input type="checkbox"lay-skin="primary"><i></i>
                    </p>
                    <p class="candidatesPothree activeall" style="margin-top: 10px;">
                        <label>发起人</label><br>
                        <input type="checkbox" lay-skin="primary"><i></i>
                        <input type="checkbox" lay-skin="primary"><i></i>
                        <input type="checkbox" lay-skin="primary"><i></i>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        转交时内部邮件通知以下人员
                    </p>
                    <p class="candidatesPone activeall">
                        通知范围（人员）
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <input type="text" readonly="true" id="query_userIds">
                        <div style="float: left;line-height: 25px">
                            <a href="javascript:;" style="display: block" data-num="1" class="theCandidates">添加</a>
                            <a href="javascript:;" style="display: block" data-num="1" class="theCandidates">清空</a>
                        </div>
                    </div>
                    <p class="candidatesPone activeall">
                        通知范围（部门）
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <input type="text" readonly="true" id="">
                        <div style="float: left;line-height: 25px">
                            <a href="javascript:;" style="display: block" data-num="1" class="theCandidates">添加</a>
                            <a href="javascript:;" style="display: block" data-num="1" class="theCandidates">清空</a>
                        </div>
                    </div>
                    <p class="candidatesPone activeall">
                        通知范围（角色）
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <input type="text" readonly="true" id="">
                        <div style="float: left;line-height: 25px">
                            <a href="javascript:;" style="display: block" data-num="1" class="theCandidates">添加</a>
                            <a href="javascript:;" style="display: block" data-num="1" class="theCandidates">清空</a>
                        </div>
                    </div>
                </li>
            </ul>

            <div class="setUpThe">
                <span class="dealWithTime"></span>
                <label>呈批单设置</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl" style="display: none;border-bottom: none">
                <li>
                    <p class="candidatesPone">
                        选择呈批单
                    </p>
                    <div class="dropDownDiv">
                        <p class="candidatesPTwo">
                            <select name="city" lay-verify="">
                                <option value="">请选择一个城市</option>
                                <option value="010">北京</option>
                                <option value="021">上海</option>
                                <option value="0571">杭州</option>
                            </select>
                        </p>

                    </div>
                </li>
            </ul>
        </div>
        <div class="btnstorage">
            <a href="javascript:;" class="closebtns" style="background: #5ab65a">关闭</a>
            <a href="javascript:;"  style="background: #ff880a">保存</a>
        </div>
    </form>
</body>
</html>
