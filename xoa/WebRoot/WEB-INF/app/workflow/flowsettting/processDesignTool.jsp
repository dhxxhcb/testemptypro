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
    <script src="https://cdn.bootcss.com/jquery.form/4.2.1/jquery.form.min.js"></script>
    <script src="../../js/workflow/flowtype/processDesignTool.js"></script>
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
    <form action="/flowProcess/saveFlow" class="layui-form" id="datasave" method="post">
        <input type="hidden" id="ele_id">
        <input type="hidden" id="ele_model">
        <input type="hidden" id="ele_designerId" name="id">
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
                        <input type="text" name="prcsId" style="width: 100%">
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
                                <select name="prcsType" lay-verify="">
                                    <option value="0">步骤节点</option>
                                    <option value="1">自流程节点</option>
                                    <option value="2">外部流转节点</option>
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
                        <input type="text" name="prcsName"  style="width: 100%">
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        下一步骤
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <ul id="candidatesPoneli" style="height: 126px;">

                        </ul>
                        <div style="float:left;">
                            <a href="javascript:;" class="bottomsteps" data-field="0">选择</a>
                            <input type="hidden" name="prcsTo">
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
                    <div class="candidatesPTwoall" style="margin-bottom: 4px;">
                        <%--<input type="text" id="" readonly="true">--%>
                        <textarea name="prcsUserName" class="theControlData" id="query_userId" readonly="true"></textarea>
                        <input type="hidden" name="prcsUser">
                        <div style="float:left;">
                            <a href="javascript:;" data-num="1" class="theCandidates">添加</a>
                        </div>
                    </div>
                </li>
                <li>
                    <p class="candidatesPone">
                        授权范围（部门）
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 4px;">
                        <%--<input type="text" id="" readonly="true">--%>
                        <textarea name="prcsDeptName" class="theControlData" id="department" readonly="true" ></textarea>
                        <input type="hidden" name="prcsDept">
                        <div style="float:left;">
                            <a href="javascript:;" data-num="2" class="theCandidates">添加</a>
                        </div>
                    </div>
                </li>
                <li>
                    <p class="candidatesPone">
                        授权范围（角色）
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 4px;">
                        <%--<input type="text" id="" readonly="true">--%>
                        <textarea name="prcsPrivName" class="theControlData" id="theScopeOf" readonly="true"></textarea>
                        <input type="hidden" name="prcsPriv">
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

                        <input type="radio" name="signType" value="0" title="不允许">

                    </p>
                    <p class="candidatesPothree">

                            <input type="radio" name="signType" value="1" title="本步骤经办人">

                    </p>
                    <p class="candidatesPothree">

                            <input type="radio" name="signType" value="2" title="全部人员">

                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否允许会签人加签
                    </p>
                    <p class="candidatesPothree">

                            <input type="radio" name="countersign" value="0" title="不允许">

                    </p>
                    <p class="candidatesPothree" style="margin-bottom: 10px">

                            <input type="radio" name="countersign"  value="1" title="允许">

                    </p>
                </li>
            </ul>
            <div class="setUpThe">
                <span class="candidates"></span>
                <label>智能选人</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl hiddenul" style="display: none">
                <li>
                    <p class="candidatesPone">
                        选人过滤规则
                    </p>
                    <p class="candidatesPTwo">
                    <%--<input type="text" readonly="true" value="允许选择全部指定的经办人"><span class="xiala"><b></b></span>--%>
                        <select name="userFilter"  lay-filter="candidatesfilters"  lay-verify="">
                            <option value="">允许选择全部指定的经办人</option>
                            <option value="1">只允许选择本部门经办人</option>
                            <option value="1">只允许选择本辅助部门经办人</option>
                            <option value="5">只允许选择同级部门经办人</option>
                            <option value="3">只允许选择上级部门经办人</option>
                            <option value="4">只允许选择下级部门经办人</option>
                            <option value="12">只允许选择本部门和下级部门经办人</option>
                            <option value="6">只允许选择指定部门经办人</option>
                            <option value="9">只允许选择指定辅助部门经办人</option>
                            <option value="2">只允许选择本角色经办人</option>
                            <option value="10">只允许选择本辅助角色经办人</option>
                            <option value="7">只允许选择指定角色经办人</option>
                            <option value="11">只允许选择指定辅助角色经办人</option>
                        </select>
                    </p>
                    <div class="departmentAgent">
                        <p class="candidatesPone">指定部门</p>
                        <div class="candidatesPTwoall">
                            <textarea name="" class="theControlData" id="departmentAgent" readonly="true"></textarea>
                            <input type="hidden" name="userFilterPrcsDept">
                            <div style="float: left;line-height: 25px;">
                                <a href="javascript:;" style="display: block" class="theCandidates" data-num="2">添加</a>
                                <a href="javascript:;" style="display: block" class="emptyTwo">清空</a>
                            </div>
                        </div>
                    </div>
                    <div class="auxiliaryDepartmentAgent">
                        <p class="candidatesPone">指定辅助部门</p>
                        <div class="candidatesPTwoall">
                            <textarea name="" class="theControlData" id="auxiliaryDepartmentAgent" readonly="true"></textarea>
                            <input type="hidden" name="userFilterPrcsDeptOther">
                            <div style="float: left;line-height: 25px" >
                                <a href="javascript:;" style="display: block" class="theCandidates" data-num="2">添加</a>
                                <a href="javascript:;" style="display: block" class="emptyTwo">清空</a>
                            </div>
                        </div>
                    </div>
                    <div class="theSpecifiedRole">
                        <p class="candidatesPone">指定角色</p>
                        <div class="candidatesPTwoall">
                            <textarea name="" class="theControlData" id="theSpecifiedRole" readonly="true"></textarea>
                            <input type="hidden" name="userFilterPrcsPriv">
                            <div style="float: left;line-height: 25px">
                                <a href="javascript:;" style="display: block" class="theCandidates" data-num="3">添加</a>
                                <a href="javascript:;" style="display: block" class="emptyTwo">清空</a>
                            </div>
                        </div>
                    </div>
                    <div class="assignRole">
                        <p class="candidatesPone">指定辅助角色</p>
                        <div class="candidatesPTwoall">
                            <textarea name="" class="theControlData" id="assignRole" readonly="true"></textarea>
                            <input type="hidden" name="userFilterPrcsPrivOther">
                            <div style="float: left;line-height: 25px">
                                <a href="javascript:;" style="display: block" class="theCandidates" data-num="3">添加</a>
                                <a href="javascript:;" style="display: block" class="emptyTwo">清空</a>
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <p class="candidatesPone">
                        自动选择人规则
                    </p>
                    <p class="candidatesPTwo" style="margin-bottom: 20px">
                        <%--<input type="text" readonly="true" value="不进行自动选择"><span class="xiala"><b></b></span>--%>
                            <select name="autoType" lay-filter="automaticCandidateTwo" lay-verify="">
                                <option value="">不进行自动选择</option>
                                <option value="1">自动选择流程发起人</option>
                                <option value="2">自动选择本部门主管</option>
                                <option value="3">指定自动选择默认人员</option>
                                <option value="4">自动选择上级主管领导</option>
                                <option value="5">自动选择一级部门主管</option>
                                <option value="6">自动选择上级分管领导</option>
                                <option value="7">按表单字段选择</option>
                                <option value="8">自动选择指定步骤主办人</option>
                                <option value="9">自动选择本部门助理</option>
                                <option value="10">自动选择本部门内符合条件所有人员</option>
                                <option value="11">自动选择本一级部门内符合条件所有人员</option>
                                <option value="12">自动选择指定部门主管</option>
                                <option value="13">自动选择指定部门助理</option>
                                <option value="14">自动选择指定部门上级主管领导</option>
                                <option value="15">自动选择指定部门上级分管领导</option>

                            </select>
                    </p>
                    <div class="autoBaseUser">
                        <p class="candidatesPone">
                            部门针对对象
                        </p>
                        <p class="candidatesPTwo" style="margin-bottom: 20px">
                            <%--<input type="text" readonly="true" value="不进行自动选择"><span class="xiala"><b></b></span>--%>
                            <select name="autoBaseUser" lay-verify="">
                                <option value="0">当前步骤</option>
                            </select>
                        </p>
                    </div>
                    <div class="optionalDepartmentAgent" >
                            <p class="candidatesPone">指定部门</p>
                            <div class="candidatesPTwoall" style="margin-bottom: 20px">
                                <textarea name="" class="theControlData" id="optionalDepartmentAgent" readonly="true"></textarea>
                                <input type="hidden" name="autoDept">
                                <div style="float: left;line-height: 25px;">
                                    <a href="javascript:;" style="display: block" class="theCandidates" data-num="2">选择</a>
                                    <a href="javascript:;" class="emptyTwo">清空</a>
                                </div>
                            </div>
                    </div>
                    <div class="specifyTheHost">
                        <p class="candidatesPone">主办人</p>
                        <input type="text" readonly="true" name="autoUserOp" style="margin-bottom: 12px;background: #eee;border: 1px solid #ccc;border-radius: 4px">
                        <div class="candidatesPTwoall">
                            <textarea name="" class="theControlData" id="specifyTheHost" readonly="true"></textarea>
                            <input type="hidden" name="autoUser">
                            <div style="float: left;line-height: 25px;">
                                <a href="javascript:;"  style="margin-right: 24px;" class="theCandidates" data-num="2">指定经办/主办人</a>
                                <a href="javascript:;">清空</a>
                            </div>
                        </div>
                    </div>
                    <div class="oneTheHost">
                        <p class="candidatesPone">根据表单字段决定默认办理人(第一个作为主办人)</p>
                        <div class="candidatesPTwoall">
                            <ul style="height: 126px;margin-bottom: 20px"></ul>
                            <div style="float: left">
                                <a href="javascript:;" class="bottomsteps" data-field="1">选择</a>
                                <input type="hidden" name="ITEM_ID">
                            </div>
                        </div>
                    </div>
                    <div class="stepsTwos">
                        <p class="candidatesPone">
                            请指定步骤
                        </p>
                        <p class="candidatesPTwo" style="margin-bottom: 20px">
                            <%--<input type="text" readonly="true" value="不进行自动选择"><span class="xiala"><b></b></span>--%>
                            <select name="AUTO_PRCS_USER" lay-verify="">
                                <option value="">请选择</option>

                            </select>
                        </p>
                    </div>
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
                        <label><input name="topDefault" type="radio" value="0"  title="明确指定主办人"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input name="topDefault" type="radio" value="2" title="无主办人会签">	</label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input name="topDefault" type="radio" value="1" title="先接收者为主办人">	</label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否允许修改主办人相关选项
                    </p>
                    <p class="candidatesPothree">
                        <label><input name="userLock" type="radio" value="0" title="不允许"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input name="userLock" type="radio" value="1" title="允许">	</label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否允许会签
                    </p>
                    <p class="candidatesPothree">
                        <label><input name="feedback" type="radio" value="0" title="允许会签"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input name="feedback" type="radio" value="1" title="禁止会签"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input name="feedback" type="radio" value="2" title="强制会签"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        会签意见可见性
                    </p>
                    <p class="candidatesPothree">
                        <label><input name="signlook" type="radio" value="0" title="总是可见"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input name="signlook" type="radio" value="1" title="本步骤经办人之间不可见"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input name="signlook" type="radio" value="2" title="针对其他步骤不可见"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        经办人未办理完毕时是否允许主办人强制转交
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" value="1" name="turnPriv" title="允许"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="turnPriv" value="0" title="不允许"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否允许退回
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="allowBack" value="0" title="不允许"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="allowBack" value="1" title="允许退回上一步骤"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="allowBack" value="2" title="允许退回之前步骤"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否允许并发
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="syncDeal" value="0" title="禁止并发"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="syncDeal" value="1" title="允许并发"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="syncDeal" value="2" title="强制并发"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        并发合并选项
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="gatherNode" value="0" title="非强制合并"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="gatherNode" value="1" title="强制合并"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        传阅设置
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="viewPriv" value="0" title="允许"></label>
                    </p>
                    <p class="candidatesPothree" style="margin-bottom: 10px">
                        <label><input type="radio" name="viewPriv" value="1" title="不允许"></label>
                    </p>
                </li>
            </ul>

            <div class="setUpThe" id="canWriteField">
                <span class="canWriteField"></span>
                <label>可写字段</label>
                <input type="hidden" name="prcsItemTwo">
                <b class="notstart"></b>
            </div>
            <div class="setUpThe">
                <span class="confidentialFields"></span>
                <label>保密字段</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl">
                <li>
                    <p class="candidatesPone">
                        编辑保密字段
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <ul style="height: 126px" id="hiddenItem"></ul>
                        <div style="float: left">
                            <a href="javascript:;" class="bottomsteps" data-field="1">选择</a>
                            <input type="hidden" name="hiddenItem">
                        </div>
                    </div>
                </li>
            </ul>
            <div class="setUpThe">
                <span class="requiredFields"></span>
                <label>必填字段</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl">
                <li>
                    <p class="candidatesPone">
                        编辑必填字段
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <ul style="height: 126px" id="requiredItem"></ul>

                        <div style="float: left">
                            <a href="javascript:;" class="bottomsteps" data-field="1">选择</a>
                            <input type="hidden" name="requiredItem">
                        </div>
                    </div>
                </li>
            </ul>
            <div class="setUpThe" id="conditions">
                <span class="conditionsSet"></span>
                <label>条件设置</label>
                <input type="hidden" name="settlementOfCondition">
                <b class="notstart"></b>
            </div>
            <div class="setUpThe">
                <span class="dealWithTime"></span>
                <label>办理时限</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl" style="display: none">
                <li>
                    <p class="candidatesPoform" style="padding-top: 20px;">
                        <input type="text" name="timeOut"><span>小时</span>
                    </p>
                    <p class="candidatesPone">
                        是否允许转交时设置办理时限
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="timeOutModify" value="0" title="允许"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="timeOutModify" value="1" title="不允许"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        超时计算方法
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="timeOutType" value="0" title="本步骤接收后开始计时"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="timeOutType" value="1" title="上一步骤转交后开始计时"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        工作天数换算方式
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="workingdaysType" value="0" title="24小时为一天"></label>
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="workingdaysType" value="1" title="按个人排班类型工作时长为一天"></label>
                    </p>
                </li>
                <li>
                    <p class="candidatesPone">
                        是否排除非工作时段(按排班类型)
                    </p>
                    <p class="candidatesPothree">
                        <label><input type="radio" name="timeOutAttend" value="0" title="否"></label>
                    </p>
                    <p class="candidatesPothree" style="margin-bottom: 10px">
                        <label><input type="radio" name="timeOutAttend" value="1" title="是"></label>
                    </p>
                </li>
            </ul>
            <div class="setUpThe" id="theTrigger">
                <span class="theTrigger"></span>
                <label>触发器</label>
                <b class="notstart"></b>
            </div>
            <div class="setUpThe">
                <span class="remindSet"></span>
                <label>提醒设置</label>
                <b class="notstart"></b>
            </div>
            <ul class="candidatesUl" style="display: none">
                <li>
                    <p class="candidatesPone">
                        事务提醒设置
                    </p>
                    <p class="candidatesPothree">
                      <input type="checkbox"  title="此步骤是否独立设置提醒方式">

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
                    <p class="candidatesPothree activeall" style="margin-top: 10px;">
                        <label>全部经办人</label><br>
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
                        <%--<input type="text" readonly="true" id="">--%>
                        <textarea name="" class="theControlData" id="query_userIds" readonly="true"></textarea>
                        <div style="float: left;line-height: 25px">
                            <a href="javascript:;" style="display: block" data-num="1" class="theCandidates">添加</a>
                            <a href="javascript:;" style="display: block" data-num="1" class="theCandidates">清空</a>
                        </div>
                    </div>
                    <p class="candidatesPone activeall">
                        通知范围（部门）
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <%--<input type="text" readonly="true" id="">--%>
                        <textarea name="" class="theControlData" id="departments" readonly="true"></textarea>
                        <div style="float: left;line-height: 25px">
                            <a href="javascript:;" style="display: block" data-num="2" class="theCandidates">添加</a>
                            <a href="javascript:;" style="display: block" data-num="1" class="theCandidates">清空</a>
                        </div>
                    </div>
                    <p class="candidatesPone activeall">
                        通知范围（角色）
                    </p>
                    <div class="candidatesPTwoall" style="margin-bottom: 20px;">
                        <%--<input type="text" readonly="true" id="">--%>
                        <textarea name="" class="theControlData" id="theScopeOfs" readonly="true"></textarea>
                        <div style="float: left;line-height: 25px">
                            <a href="javascript:;" style="display: block" data-num="3" class="theCandidates">添加</a>
                            <a href="javascript:;" style="display: block" data-num="1" class="theCandidates">清空</a>
                        </div>
                    </div>
                </li>
            </ul>

            <div class="setUpThe">
                <span class="groupOfSingleSet"></span>
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
                            <select name="" lay-verify="">
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
            <a href="javascript:;" class="closebtns" style="background: #ff880a">关闭</a>
            <a href="javascript:;"  class="savetwo" style="background: #5ab65a">保存</a>
        </div>
    </form>
</body>

</html>
