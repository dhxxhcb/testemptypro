<%--
  Created by IntelliJ IDEA.
  User: 王曰岐
  Date: 2017/5/20
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../../css/workflow/flowsetting/style.css">
    <%--<link rel="stylesheet" href="../../css/base.css">--%>
</head>
<body>
<div class="content clearfix">
    <div class="title">
        请假申请流程设计
    </div>
    <ul id="cont_list" class="cont_list">
        <li><a href="javascript:void(0)" class="btn_click btn_h btn"><img
                src="../../img/workflow/flowsetting/icon_workprocess_03.png" alt="">流程主页</a>
        </li>
        <li class="list1">
            <a href="javascript:void(0)" class="btn_click btn_h btn1">
                <img
                        src="../../img/workflow/flowsetting/icon_workprocess_03.png" alt="">设计流程<i
                    class="icon_d"></i></a>
            <ul class="hide_list1 hide">
                <li><a href="javascript:void(0)" class="btn_h btn_h_1"><i class="icon"></i>定义流程属性</a>
                </li>
                <li><a href="javascript:void(0)" class="btn_h btn_h_2"><i class="icon"></i>设计流程步骤</a>
                </li>
                <li><a href="javascript:void(0)" class="btn_h btn_h_3"><i class="icon"></i>预览表单</a>
                </li>
                <li><a href="javascript:void(0)" class="btn_h btn_h_4"><i class="icon"></i>导入</a></li>
            </ul>
        </li>
        <li>
            <a href="javascript:void(0)" class="btn_click btn_h btn2">
                <img src="../../img/workflow/flowsetting/icon_authoritymanagement_03.png" alt="">管理权限</a>
        </li>
        <li><a href="javascript:void(0)" class="btn_click btn_h btn3"><img
                src="../../img/workflow/flowsetting/icon_timedtask_03.png" alt="">定时任务</a>
        </li>
        <li><a href="javascript:void(0)" class="btn_click btn_h btn4"><img
                src="../../img/workflow/flowsetting/icon_searchtemplate_03.png" alt="">配置查询模板</a>
        </li>
        <li><a href="javascript:void(0)" class="btn_click btn_h btn5"><img
                src="../../img/workflow/flowsetting/icon_layoutfiles_03.png" alt="">应用版式文件</a>
        </li>
        <li><a href="javascript:void(0)" class="btn_click btn_h btn6"><img
                src="../../img/workflow/flowsetting/icon_others_03.png" alt="">其他 <i class="icon_d"></i></a></li>
    </ul>

    <div class="cont_r">
        <div class="item"></div>
        <div class="item"></div>
        <%--定义流程属性--%>
        <div class="item">
            <div class="con_flow">
                <div class="define_r clearfix">
                    <h3>定义流程属性</h3>
                    <span><a href="javascript:void(0)" class="keepmsg">保存</a></span>
                </div>
                <p class="define_p">基本属性</p>
                <form class="pro_flow ">
                    <div class="con_form">
                        <div class="form_group">
                            <label for="projectName" class="flowName">流程名称<span class="save">*</span></label>
                            <input type="hidden" id="flowId">
                            <input type="text" id="projectName">

                        </div>
                        <div class="form_group">
                            <label for="orderID" class="flowName">流程排序号 <span class="save">*</span></label>
                            <input type="text" id="orderID">

                        </div>
                        <div class="form_group">
                            <label for="deptName" class="flowName">所属部门 <span class="save">*</span></label>
                            <select name="" id="deptName" class="depName">
                                <option value="1"><%--系统(仅有系统管理员管理)--%></option>
                                <option value="2"><%--系统(仅有系统管理员管理--%></option>
                                <option value="3"><%--系统(仅有系统管理员管理)--%></option>
                            </select>

                        </div>
                        <div class="form_group">
                            <label for="classfiy" class="flowName">流程分类 <span class="save">*</span></label>
                            <select name="" id="classfiy" class="depName">
                                <option value="">考勤管理</option>
                            </select>
                        </div>
                        <div class="form_group">
                            <label for="class_f" class="flowName">流程类型 <span class="save">*</span></label>
                            <select name="" id="class_f" class="depName">
                                <option value="">固定流程</option>
                            </select>
                        </div>
                        <div class="form_group">
                            <label for="leave" class="flowName">表单 <span class="save">*</span></label>
                            <select name="" id="leave" class="depName">
                                <option value="">请假登记</option>
                            </select>
                        </div>
                        <div class="form_group">
                            <label for="delegate-type" class="flowName">委托类型<span class="save">*</span></label>
                            <select name="" id="delegate-type" class="depName">
                                <option value="">自由委托</option>
                            </select>
                        </div>
                        <div class="form_group sex_r">
                            <label class="flowName">是否允许传阅<span class="save">*</span></label>
                            <input type="radio" name="sex" value="是" checked><label class="sex_n">是</label>
                            <input type="radio" name="sex" value="否"><label class="sex_save">否</label>

                        </div>
                        <div class="form_group sex_r">
                            <label class="flowName">是否允许上传附件<span class="save">*</span></label>
                            <input type="radio" name="sex" value="是" checked><label class="sex_n">是</label>
                            <input type="radio" name="sex" value="否"><label class="sex_save">否</label>

                        </div>
                        <div class="form_group sex_r">
                            <label class="flowName">是否启用版本控制<span class="save">*</span></label>
                            <input type="radio" name="sex" value="是" checked><label class="sex_n">是</label>
                            <input type="radio" name="sex" value="否"><label class="sex_save">否</label>

                        </div>
                        <div class="form_group sex_r">
                            <label class="flowName">更多操作项设置<span class="save">*</span></label>
                            <input type="checkbox"><label class="label_f">公告通知</label>
                            <input type="checkbox"><label class="label_f">内部邮件</label>
                            <input type="checkbox"><label class="label_f">转存</label>
                            <input type="checkbox"><label class="placeFile">归档</label>
                            <p class="set_form">设置表单打印页面更多操作以及工作办理页面分享和更多的操作</p>

                        </div>

                    </div>

                </form>
                <div class="jobName">工作名称/文好</div>
                <form class="pro_flow flow_r">
                    <div class="con_form">
                        <div class="form_group">
                            <label for="reference" class="flowName">文号表达式<span class="save">*</span></label>
                            <input type="text" id="reference">
                        </div>
                        <div class="form_group">
                            <label for="counteer" class="flowName">编号计数器<span class="save">*</span></label>
                            <input type="text" id="counteer">
                        </div>
                        <div class="form_group">
                            <label for="figure" class="flowName">编号位数<span class="save">*</span></label>
                            <input type="text" id="figure">
                        </div>
                        <div class="form_group">
                            <label for="update_n" class="flowName">是否允许修改<span class="save">*</span></label>
                            <select name="" id="update_n" class="depName">
                                <option value="">允许修改</option>
                            </select>
                        </div>
                    </div>

                    <div class="form_r">
                        <div class="conForm_r">
                            <p>一，文号表达式说明</p>
                            <p>表达式中可以使用一下特殊标记</p>
                        </div>

                    </div>
                </form>
                <div class="jobName">流程说明</div>
                <form class="pro_flow flow_r">
                    <div class="con_form">
                        <div class="form_group">
                            <label for="reference" class="flowName">说明文档<span class="save">*</span></label><span
                                class="notable">暂无</span>

                        </div>
                        <div class="form_group form_icon">
                            <label for="counteer" class="flowName">上传附件<span class="save">*</span></label>
                            <i class="icon_plus"></i><input type="text" value="上传附件" class="addfile">
                            <i class="icon_plus"></i><input type="text" value="从文件柜选择附件" class="appendfile">
                        </div>

                    </div>
                </form>

            </div>
        </div>
        <%--设计流程步骤--%>
        <div class="item">
            <table class="table" cellspacing="0" id="table_form">
                <caption>
            <table class="table" cellspacing="0">
                <caption style="position: relative">
                    <a href="/flowSetting/processDesignTool" class="processDesigner" target="_blank">流程设计器</a>
                    <a href="javascript:void (0)" class="newbuilt">新建</a>
                    <a href="javascript:void (0)" class="delete_c">删除</a>
                </caption>

                <thead>
                <%-- <tr>
                     <th class="check">序号</th>
                     <th>名称</th>
                     <th>下一步骤</th>
                     <th>编辑该步骤的各项属性</th>
                     <th>操作</th>
                 </tr>--%>
                </thead>
                <%-- <tr>
                     <td>1</td>
                     <td class="manage">督办内容填写</td>
                     <td class="ordernum">2,4</td>
                     <td class="cutout">基本属性 经办权限 可写字段 保密字段 必填字段 条件设置</td>
                     <td class="opp">
                         <a href="javascript:void(0)">克隆</a>
                         <a href="javascript:void(0)">删除</a>
                     </td>
                 </tr>--%>
                <%-- <tr>
                     <td>2</td>
                     <td class="management" style="text-align: center">部门负责人审批</td>
                     <td>3,</td>
                     <td style="text-align: center">基本属性 经办权限 可写字段 保密字段 必填字段 条件设置</td>
                     <td>
                         <a href="javascript:void(0)">克隆</a>
                         <a href="javascript:void(0)">删除</a>
                     </td>
                 </tr>--%>
                <%--<tr>
                    <td>3</td>
                    <td class="management" style="text-align: center">总经理审核</td>
                    <td>4</td>
                    <td style="text-align: center">基本属性&nbsp;经办权限&nbsp;可写字段&nbsp;保密字段&nbsp;必填字段&nbsp;条件设置</td>
                    <td>
                        <a href="javascript:void(0)">克隆</a>
                        <a href="javascript:void(0)">删除</a>
                    </td>
                </tr>--%>
            </table>
        </div>

        <div class="item"></div>
        <div class="item"></div>
        <%--管理权限表格--%>
        <div class="item">
            <table class="table" cellspacing="0">
                <caption>
                    <a href="javascript:void (0)" class="newbuilt">新建</a>
                    <a href="javascript:void (0)" class="delete_c">删除</a>
                </caption>

                <thead>
                <tr>
                    <th class="check"><input type="checkbox" class="checkAll">全选</th>
                    <th>权限类型</th>
                    <th>授权范围</th>
                    <th>管理范围</th>
                    <th>操作</th>
                </tr>

                </thead>
                <tr>
                    <td><input type="checkbox" class="one"></td>
                    <td class="manage">管理</td>
                    <td class="management">用户：系统管理员</td>
                    <td class="sector">所有部门</td>
                    <td class="opp">
                        <a href="javascript:void(0)">修改</a>
                        <a href="javascript:void(0)">删除</a>
                    </td>
                </tr>
                <tr>
                    <td><input type="checkbox" class="one"></td>
                    <td>监控</td>
                    <td class="management">用户：系统管理员</td>
                    <td class="sector">所有部门</td>
                    <td>
                        <a href="javascript:void(0)">修改</a>
                        <a href="javascript:void(0)">删除</a>
                    </td>
                </tr>
            </table>
        </div>
        <div class="item">
            <table class="table" cellspacing="0">
                <caption>
                    <a href="javascript:void (0)" class="newbuilt">新建</a>
                    <a href="javascript:void (0)" class="delete_c">删除</a>
                </caption>

                <thead>
                <tr>
                    <th class="check"><input type="checkbox" class="checkAll">全选</th>
                    <th>权限类型</th>
                    <th>授权范围</th>
                    <th>管理范围</th>
                    <th>操作</th>
                </tr>

                </thead>
                <tr>
                    <td><input type="checkbox" class="one"></td>
                    <td class="manage">管理</td>
                    <td class="management">用户：系统管理员</td>
                    <td class="sector">所有部门</td>
                    <td class="opp">
                        <a href="javascript:void(0)">修改</a>
                        <a href="javascript:void(0)">删除</a>
                    </td>
                </tr>
                <tr>
                    <td><input type="checkbox" class="one"></td>
                    <td>监控</td>
                    <td class="management">用户：系统管理员</td>
                    <td class="sector">所有部门</td>
                    <td>
                        <a href="javascript:void(0)">修改</a>
                        <a href="javascript:void(0)">删除</a>
                    </td>
                </tr>
            </table>
        </div>
        <div class="item">
            <table class="table" cellspacing="0">
                <caption>
                    <a href="javascript:void (0)" class="newbuilt">新建</a>
                    <a href="javascript:void (0)" class="delete_c">删除</a>
                </caption>

                <thead>
                <tr>
                    <th class="check"><input type="checkbox" id="checkAll">全选</th>
                    <th>权限类型</th>
                    <th>授权范围</th>
                    <th>管理范围</th>
                    <th>操作</th>
                </tr>

                </thead>
                <tr>
                    <td><input type="checkbox" class="one"></td>
                    <td class="manage">管理</td>
                    <td class="management">用户：系统管理员</td>
                    <td class="sector">所有部门</td>
                    <td class="opp">
                        <a href="javascript:void(0)">修改</a>
                        <a href="javascript:void(0)">删除</a>
                    </td>
                </tr>
                <tr>
                    <td><input type="checkbox" class="one"></td>
                    <td>监控</td>
                    <td class="management">用户：系统管理员</td>
                    <td class="sector">所有部门</td>
                    <td>
                        <a href="javascript:void(0)">修改</a>
                        <a href="javascript:void(0)">删除</a>
                    </td>
                </tr>
            </table>
        </div>
        <div class="item">
            <table class="table" cellspacing="0">
                <caption>
                    <a href="javascript:void (0)" class="newbuilt">新建</a>
                    <a href="javascript:void (0)" class="delete_c">删除</a>
                </caption>

                <thead>
                <tr>
                    <th class="check"><input type="checkbox" class="checkAll">全选</th>
                    <th>权限类型</th>
                    <th>授权范围</th>
                    <th>管理范围</th>
                    <th>操作</th>
                </tr>

                </thead>
                <tr>
                    <td><input type="checkbox" class="one"></td>
                    <td class="manage">管理</td>
                    <td class="management">用户：系统管理员</td>
                    <td class="sector">所有部门</td>
                    <td class="opp">
                        <a href="javascript:void(0)">修改</a>
                        <a href="javascript:void(0)">删除</a>
                    </td>
                </tr>
                <tr>
                    <td><input type="checkbox" class="one"></td>
                    <td>监控</td>
                    <td class="management">用户：系统管理员</td>
                    <td class="sector">所有部门</td>
                    <td>
                        <a href="javascript:void(0)">修改</a>
                        <a href="javascript:void(0)">删除</a>
                    </td>
                </tr>
            </table>
        </div>


    </div>

</div>

</body>
<script src="../../js/jquery-1.9.1.js"></script>

<script type="text/javascript">
    $(function () {
        var $list = $('.cont_list li a');
        /*设计步骤流程*/
        $.ajax({
            type: "get",
            url: "<%=basePath%>flowProcess/findFlowId",
            dataType: "json",
            data: {
                flowId: 120
            },
            success: function (data) {
                if (data.flag) {
                    var data = data.obj;
                    var html = "<tr><th>序号</th><th>名称</th><th>下一步骤</th><th>编辑该步骤的各项属性</th><th>操作</th></tr>";
                    for (var i = 0; i < data.length; i++) {

                        html = html + "<tr>" + "<td>" + data[i].prcsId + "</td>" + "<td>" + data[i].prcsName + "</td>" +
                            "<td></td>" + "<td style='text-align: center'>基本属性 经办权限 可写字段 保密字段 必填字段 条件设置</td>" + "<td>修改 删除</td>" + "</tr>";

                    }
                    $('#table_form').append(html);

                }


            }
        });

        /*定义流程属性查询*/

        var flowId = '${flowId}';

        if(flowId != null || flowId.length>0) {
            $.ajax({
                type: "GET",
                url: "<%=basePath%>flow/selectAllFlow",
                dataType: "JSON",
                data: {
                    flowId: flowId
                },
                success: function (data) {
                    console.log(data)
                    if (data.flag) {
                        $("#flowId").val(data.object.flowId);
                        $("#projectName").val(data.object.flowName);
                        $('#orderID').val(data.object.flowNo);
                        //$('#deptName').find("option:selected").text(data.object.deptId)
                        //$('#deptName option:selected').text(data.object.deptId);
//                    $('#deptName').find('option').eq(0).text()
//                    console.log($('#deptName option:selected'))
                    }
                }
            });
        }
        $('.keepmsg').on('click', function () {
//            var flowId = $("#flowId").val();
//            alert(flowId);

            if (flowId == null || flowId == "") {
                //保存
                var data = {
                    flowName: $('#projectName').val(),
                    flowNo: $('#orderID').val(),
                    deptId: 1,
                    flowSort: 1,
                    flowType: '1',
                    formId: 117,
                    freeOther: '2',
                    flowDoc:0,
                    autoNum:$('#counteer').val(),
                    autoLen:$('#figure').val(),
                };
                $.ajax({
                    type: 'POST',
                    url: '<%=basePath%>flow/newFlow',
                    dataType: 'json',
                    data: data,
                    success: function (data) {
                        console.log(data)
                        if (data.flag) {
                            alert("保存成功");
                        } else {
                            alert("保存失败");
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert("数据源连接异常,请联系管理员");
                    }
                })
            } else {
                //修改|编辑
                var data = {
                    flowId: flowId,
                    flowName: $('#projectName').val(),
                    flowNo: $('#orderID').val(),
                    deptId: 1,
                    flowSort: 1,
                    flowType: '1',
                    formId: 117,
                    freeOther: '2'
                };
//                        ajax  补充完全
                $.ajax({
                    type: "post",
                    url: "<%=basePath%>flow/updateFlow",
                    dataType: 'json',
                    data: data,
                    success:function (data) {
                    alert(data.flag);
                    }
                })
            }
        })

        $list.each(function (index, item) {
            $(item).click(function () {
//                $("#cont_list li a").addClass('clickBack').siblings().removeClass("clickBack");
//                e.preventDefault();
                if (index == 1) $('.hide_list1').toggle();
                $('.cont_r .item').eq(index).show().siblings().hide();

            })
        });
        /*管理权限查询*/
        $.ajax({
            type:'get',
            url:"",
            dataType:"json",
            success:function (data) {
                console.log(data);

            }
        })
        /*全选非全选*/
        $('.checkAll').on('click', function () {
            $('.one').prop('checked', $(this).prop('checked'));
        });
        $('.one').click(function () {
            $('.checkAll').prop('checked', $('.one').length == $('.one:checked').length ? true : false);
        })
    })


</script>

</html>
