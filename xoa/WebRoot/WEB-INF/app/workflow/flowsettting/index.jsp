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
    <link rel="stylesheet" href="../../css/base.css">
    <link rel="stylesheet" href="../../css/workflow/flowsetting/style.css">

</head>
<body>
<div class="content clearfix">
    <div class="title">
        请假申请流程设计
    </div>
    <ul id="cont_list" class="cont_list">
        <li><a href="javascript:void(0)" class="btn_click btn_h btn"><img
                src="../../img/workflow/flowsetting/icon_mainprocess_03.png" alt="">流程主页</a>
        </li>
        <li class="list1">
            <a href="javascript:void(0)" class="btn_click btn_h btn1">
                <img src="../../img/workflow/flowsetting/icon_process_leftbar_03.png" alt="">设计流程<i
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
                <img src="../../img/workflow/flowsetting/icon_management_03.png" alt="">管理权限</a>
        </li>
        <div class="pop_up">
            <div class="new_b">新建</div>
            <div class="pop_con">
                <div class="con_t">
                    <div class="con_l">
                        <div class="con_title">
                            <div class="title_1">
                                <div class="title_label"></div>
                                <span class="title_s">表单名称:</span>
                                <div class="title_put">
                                    <input type="text">
                                </div>
                            </div>
                            <sapn class="title_s">表单父分类:</sapn>
                            <div class="title_2">
                                <select name="" id="" class="select_t"></select>
                                <span class>(为空为一级分类)</span>
                            </div>
                            <div class="title_3">
                                <div class="title3_label">
                                    <span class="title_s">所属部门:</span>
                                </div>
                                <div class="select_put">
                                    <select name="" class="select_t">
                                        <option value="1">所有部门</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="con_footer">
                <a href="javascript:void(0)" class="footer_btn1">保存</a>
                <a href="javascript:void(0)" class="footer_btn2">关闭</a>
            </div>

        </div>
        <li><a href="javascript:void(0)" class="btn_click btn_h btn3"><img
                src="../../img/workflow/flowsetting/icon_timedtask_03.png" alt="">定时任务</a>
        </li>
        <li><a href="javascript:void(0)" class="btn_click btn_h btn4"><img
                src="../../img/workflow/flowsetting/icon_search_03.png" alt="">配置查询模板</a>
        </li>
        <li><a href="javascript:void(0)" class="btn_click btn_h btn5"><img
                src="../../img/workflow/flowsetting/icon_article_03.png" alt="">应用版式文件</a>
        </li>

        <li><a href="javascript:void(0)" class="btn_click btn_h btn6"><img
                src="../../img/workflow/flowsetting/icon_more_03.png" alt="">其他 <i class="icon_d"></i></a>
            <ul class="hide_list2 hide">
                <li><a href="javascript:void(0)" class="btn_h btn_h_1"><i class="icon"></i>清空</a>
                </li>
                <li><a href="javascript:void(0)" class="btn_h btn_h_2"><i class="icon"></i>删除</a>
                </li>
                <li><a href="javascript:void(0)" class="btn_h btn_h_3"><i class="icon"></i>数据匹配</a>
                </li>
                <li><a href="javascript:void(0)" class="btn_h btn_h_4"><i class="icon"></i>数据迁移</a></li>
                <li><a href="javascript:void(0)" class="btn_h btn_h_4"><i class="icon"></i>菜单定义</a></li>
                <li><a href="javascript:void(0)" class="btn_h btn_h_4"><i class="icon"></i>查询字段</a></li>
                <li><a href="javascript:void(0)" class="btn_h btn_h_4"><i class="icon"></i>校验</a></li>
                <li><a href="javascript:void(0)" class="btn_h btn_h_4"><i class="icon"></i>导出</a></li>
            </ul>
        </li>


    </ul>

    <div class="cont_r">
        <%--流程主页--%>
        <div class="item item_s">
            <div class="homePage">
                <div class="define_r define_flow clearfix">
                    <h3>流程主页</h3>
                    <span><a href="javascript:void(0)" class="flow_des">流程设计器</a></span>
                </div>
                <div class="home_mid">
                    <ul class="mid_f clearfix">
                        <li><a class="expont_num" href="javascript:void(0)">
                            <p class="expont_r">
                                <span class="num">10</span>
                                <span class="exponent">全部流程数</span>
                            </p>
                        </a>
                        </li>
                        <li><a class="expont_num" href="javascript:void(0)">
                            <p class="expont_r">
                                <span class="num" style="color: #d68b2f24">10</span>
                                <span class="exponent" style="color: #d68b2f24">正在执行流程数</span>
                            </p>
                        </a>
                        </li>
                        <li><a class="expont_num" href="javascript:void(0)">
                            <p class="expont_r">
                                <span class="num" style="color: #287a55">10</span>
                                <span class="exponent" style="color: #287a55">已经结束流程数</span>
                            </p>
                        </a>
                        </li>
                        <li><a class="expont_num" href="javascript:void(0)">
                            <p class="expont_r">
                                <span class="num" style="color: #966f31">10</span>
                                <span class="exponent" style="color: #966f31">已归档流程数</span>
                            </p>
                        </a>
                        </li>

                    </ul>
                </div>
                <div class="home_con">
                    <div class="conLeft">
                        <h3 class="con_t">流程基本信息</h3>
                        <ul class="con_c">
                            <li class="conLeft_list">
                                <i class="bg"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID" style="color: #8f000000">流程名称/ID号</span>
                                    <p class="flow_p">请假申请</p>
                                </a>
                            </li>
                            <li class="conLeft_list">
                                <i class="bg"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程名称/ID号</span>
                                    <p class="flow_p">请假申请</p>
                                </a>
                            </li>
                            <li class="conLeft_list">
                                <i class="bg"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程名称/ID号</span>
                                    <p class="flow_p">请假申请</p>
                                </a>
                            </li>
                            <li class="conLeft_list">
                                <i class="bg"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程名称/ID号</span>
                                    <p class="flow_p">请假申请</p>
                                </a>
                            </li>
                            <li class="conLeft_list">
                                <i class="bg"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程名称/ID号</span>
                                    <p class="flow_p">请假申请</p>
                                </a>
                            </li>
                            <li class="conLeft_list">
                                <i class="bg"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程名称/ID号</span>
                                    <p class="flow_p">请假申请</p>
                                </a>
                            </li>
                            <li class="conLeft_list">
                                <i class="bg"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程名称/ID号</span>
                                    <p class="flow_p">请假申请</p>
                                </a>
                            </li>


                        </ul>


                    </div>
                </div>
            </div>
        </div>
        <div class="item" item_s></div>
        <%--定义流程属性--%>
        <div class="item item1">
            <div class="con_flow clearfix">
                <div class="define_r clearfix">
                    <h3>定义流程属性</h3>
                    <span><a href="javascript:void(0)" class="keepmsg">保存</a></span>
                </div>

                <div class="over_f">
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
                                    <option value="1">系统(仅有系统管理员管理)</option>
                                </select>
                            </div>
                            <div class="form_group">
                                <label for="classfiy" class="flowName">流程分类 <span class="save">*</span></label>
                                <select name="" id="classfiy" class="depName">
                                    <option value="1">考勤管理</option>

                                </select>
                            </div>
                            <div class="form_group">
                                <label for="class_f" class="flowName">流程类型 <span class="save">*</span></label>
                                <select name="" id="class_f" class="depName">
                                    <option value="1">固定流程</option>
                                    <option value="2">自由流程</option>
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
                            <div class="form_group sex_r sex_r_f">
                                <label class="flowName">更多操作项设置<span class="save">*</span></label>
                                <input type="checkbox"><label class="label_f">公告通知</label>
                                <input type="checkbox"><label class="label_f">内部邮件</label>
                                <input type="checkbox"><label class="label_f">转存</label>
                                <input type="checkbox"><label class="label_f placeFile">归档</label>
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
                        <div id="container" style="width: 96%;min-height: 300px;margin: 30px 20px 100px 20px"
                             name="content"
                             type="text/plain"></div>
                    </form>
                </div>

            </div>
        </div>
        <%--设计流程步骤--%>
        <div class="item item_s">
            <table class="table" cellspacing="0" id="table_form">
                <%-- <caption>
                     <a href="javascript:void (0)" class="newbuilt">新建</a>
                     <a href="javascript:void (0)" class="delete_c">删除</a>
                 </caption>
 --%>
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
        <div class="item item_s"></div>
        <div class="item item_s"></div>
        <%--管理权限表格--%>
        <div class="item item_s">
            <table class="table" cellspacing="0" id="table_power">

                <%-- <thead>
                  <tr>
                      <th class="check"><input type="checkbox" class="checkAll">全选</th>
                      <th>权限类型</th>
                      <th>授权范围</th>
                      <th>管理范围</th>
                      <th>操作</th>
                  </tr>
                  </thead>
                 <tbody>
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
                 </tbody>--%>

            </table>
        </div>
        <%--定时任务--%>
        <div class="item item_s">
            <table class="table" cellspacing="0" id="table_task">
                <%--<caption>
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
                </tr>--%>
            </table>
        </div>
        <%--配置查询模板--%>
        <div class="item item_s">
            <table class="table table_temp" cellspacing="0">
                <%--  <caption>
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
                  </tr>--%>
            </table>
        </div>
        <%--应用版式文件--%>
        <div class="item item_s">
            <table class="table table_prc" cellspacing="0">
                <%-- <caption>
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
                 </tr>--%>
            </table>
        </div>
    </div>

</div>


</body>
<script src="../../js/jquery-1.9.1.js"></script>
<script src="../../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
<script src="../../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
<script src="../../lib/layer/layer.js"></script>
<script src="../../js/base/base.js"></script>

<script type="text/javascript">

    var ue = UE.getEditor('container');

    $(function () {
        var flowIdFromPage = '${flowId}';
        /*设计步骤流程*/
        $('.btn_h_2').click(function () {
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
                        var html = '<caption class="clearfix"> <span class="priv_t">设计流程步骤</span> ' +
                            '<a href="<%=basePath %>flowSetting/processDesignTool?flowId=${flowId}" class="flowJpdl">流程设计器</a> ' +
                            '</caption>' +
                            "<tr><th>序号</th><th>名称</th><th>下一步骤</th><th>编辑该步骤的各项属性</th><th>操作</th></tr>";
                        for (var i = 0; i < data.length; i++) {
                            html = html + "<tr>" + "<td>" + data[i].prcsId + "</td>" + "<td>" + data[i].prcsName + "</td>" +
                                "<td></td>" + "<td style='text-align: center'>基本属性 经办权限 可写字段 保密字段 必填字段 条件设置</td>" + "<td>" + "<a href='javascript:void(0)'>修改</a><a href='javascript:void(0)'>删除</a>" + "</td>" + "</tr>";

                        }
                    }
                    $('#table_form').html(html);
                }
            });
        })

        /*定义流程属性查询*/
        var flowId = '${flowId}';
        if (flowId != "") {
            $.ajax({
                type: "GET",
                url: "<%=basePath%>flow/selectAllFlow",
                dataType: "JSON",
                data: {
                    flowId: flowId
                },
                success: function (data) {
                    if (data.flag) {
                        $("#flowId").val(data.object.flowId);
                        $("#projectName").val(data.object.flowName);
                        $('#orderID').val(data.object.flowNo);
                        $('#class_f').html('<option value="1">固定流程<option/>' + '<option value="2">自由流程<option/>');

                    }
                }
            });
        }

        $('.keepmsg').on('click', function () {
            var flowId = '${flowId}';
            alert(flowId);

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
                    flowDoc: 0,
                    autoNum: $('#counteer').val(),
                    autoLen: $('#figure').val()
                };
                $.ajax({
                    type: 'POST',
                    url: '<%=basePath%>flow/newFlow',
                    dataType: 'json',
                    data: data,
                    success: function (data) {
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
                $.ajax({
                    type: "post",
                    url: "<%=basePath%>flow/updateFlow",
                    dataType: 'json',
                    data: data,
                    success: function (data) {
                        alert(data.flag);
                    }
                })
            }
        });

        var $list = $('.cont_list li a');
        $list.each(function (index, item) {
            $(item).click(function () {
                $('.cont_r .item').eq(index).show().siblings().hide();
                if (index == 1) {
                    $('.hide_list1').toggle();
                } else if (index == 10) {
                    $('.hide_list2').toggle();
                }
            })
        });
        /*点击绑定颜色*/
        $('.btn_h').on('click', function () {
            $('.btn_h').removeClass('clickBack');
            $(this).addClass('clickBack');
        });
        /*管理权限查询*/
        var priv_type = ['管理', '监控', '查询', '编辑', '点评']
        $(".btn2").click(function () {
            renderPriv();
        });

        function renderPriv() {
            var html = '<caption class="clearfix"> <span class="priv_t">管理权限</span> ' +
                '<a href="javascript:void (0)" class="newbuilt" id="new">新建</a> ' +
                '<a href="javascript:void (0)" id="deleteAll" class="delete_c" >删除</a> ' +
                '</caption>' +
                "<tr><th><input type='checkbox' class='checkAll'>全选</th><th>权限类型</th><th>授权范围</th><th>管理范围</th><th>操作</th></tr>";
            $.ajax({
                type: 'get',
                url: "<%=basePath%>flowSetDatas/getFlowPrivList",
                dataType: "json",
                data: {
                    flowId: flowIdFromPage
                },
                success: function (data) {
                    var datas = data.datas;
                    if (data.flag) {
                        for (var i = 0; i < datas.length; i++) {
                            var type = (datas[i].privType) * 1;
                            var typeStr = "未知类型";
                            if (i >= 1 && i <= 5) {
                                typeStr = priv_type[type - 1];
                            }
                            var u_d_r_Str = "";
                            if (datas[i].userName) {
                                u_d_r_Str += "用户:" + datas[i].userName + "</br>";
                            }
                            if (datas[i].roleName) {
                                u_d_r_Str += "角色:" + datas[i].roleName + "</br>";
                            }
                            if (datas[i].deptName) {
                                u_d_r_Str += "部门:" + datas[i].deptName + "</br>";
                            }
                            html += "<tr>" + "<td style='display: none'>" + datas[i].id + "</td>" + "<td>" + "<input type='checkbox' privId='" + datas[i].id + "' class='one'>" + "</td>" + "<td>" + typeStr + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + u_d_r_Str + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + datas[i].privScopeName + "</td>" + "<td>" + '<a href="javascript:void(0)" class="powerUpdate" privId="' + datas[i].id + '">修改</a>' + '<a href="javascript:void(0)" class="delete_d" privId="' + datas[i].id + '">删除</a>' + "</td>" + "</tr>";
                        }
                    }
                    $('#table_power').html(html);
                    /*全选非全选*/
                    checkAll();
                }
            })
        }


        /*管理权限多选删除*/
        $('#table_power').on('click', '#deleteAll', function () {
            alert('确定要删除吗!');
            //获取选中项ID
            var privId = [];
            var checkBs = $(".one:checked");
            if (checkBs) {
                for (var i = 0; i < checkBs.length; i++) {
                    privId.push($(checkBs[i]).attr("privId"));
                }
            }
            $.ajax({
                type: 'get',
                url: '<%=basePath%>/flowSetDatas/deleteFlowPriv',
                dataType: 'json',
                data: {
                    'privId[]': privId
                },
                success: function (ret) {
                    if (ret.flag) {
                        alert('删除成功')
                        renderPriv();
                    } else {
                        alert('删除失败')
                    }
                }
            })
        })

        /*管理权限单个删除*/
        $('#table_power').on('click', '.delete_d', function () {
            alert('确定要删除吗!');
            //获取选中项ID
            var privId = [];
            var pId = $(this).attr("privId");
            privId.push(pId);
            console.log(privId)
            $.ajax({
                type: 'get',
                url: '<%=basePath%>/flowSetDatas/deleteFlowPriv',
                dataType: 'json',
                data: {
                    'privId[]': privId
                },
                success: function (ret) {
                    if (ret.flag) {
                        alert('删除成功')
                        renderPriv();
                    } else {
                        alert('删除失败')
                    }

                }
            })

        });

        /*定时任务*/
        $('.btn3').click(function () {
            dele();
        });
        function dele() {
            var strData = '<caption class="clearfix"> <span class="priv_t">定时任务</span> ' +
                '<a href="javascript:void (0)" class="newbuilt task_n">新建</a> ' +
                '<a href="javascript:void (0)" class="delete_c del" id="del">删除</a> ' +
                '</caption>' +
                "<t><th><input type='checkbox' class='checkAll'>全选</th><th>定时类型</th><th>流程发起人</th><th>发起日期</th><th>发起时间</th><th>操作</th></t>";
            $.ajax({
                type: 'get',
                url: '<%=basePath%>flowSetDatas/getFlowTimerList',
                dataType: 'json',
                data: {
                    flowId: flowIdFromPage
                },
                success: function (data) {
                    var data_d = data.datas;
                    if (data.flag) {
                        for (var i = 0; i < data_d.length; i++) {
                            strData += "<tbody>" + "<tr>" + "<td>" + "<input type='checkbox' class='one'  timerId='" + data_d[i].tid + "'>" + "</td>" + "<td>" + data_d[i].typeName + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + data_d[i].userName + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + data_d[i].remindDate + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + data_d[i].lastTime + "</td>" + "<td>" + '<a href="javascript:void(0)" timerId="' + data_d[i].tid + '" class="privUp">修改</a>' + '<a class="del" href="javascript:void(0)" timerId="' + data_d[i].tid + '" >删除</a>' + "</td>" + "</tr>" + "</tbody>";
                        }
                    }
                    $('#table_task').html(strData);
                    checkAll();
                }
            })
        }

        /*定时任务删除*/
        $('#table_task').on('click', '.del', function () {
            alert('确定要删除吗');
            var timerId = [];
            var pId = $(this).attr("timerId");
            timerId.push(pId);
            console.log(timerId)
            $.ajax({
                type: 'get',
                url: '<%=basePath%>/flowSetDatas/deleteFlowTimer',
                dataType: 'json',
                data: {
                    'timerId[]': timerId
                },
                success: function (ret) {
                    console.log(ret)
                    if (ret.flag) {
                        dele();
                    }

                }
            })
        });
        /*定时任务多选删除*/
        $('#table_task').on('click', '#del', function () {
            alert('确定全部删除吗！');
            var timerId = [];
            var checkAlls = $('.one:checked');
            if (checkAlls) {
                for (var i = 0; i < checkAlls.length; i++) {
                    timerId.push($(checkAlls[i]).attr('timerId'));
                }
            }
            console.log(timerId)
            $.ajax({
                type: 'get',
                url: '<%=basePath%>/flowSetDatas/deleteFlowTimer',
                dataType: 'json',
                data: {
                    'timerId[]': timerId
                },
                success: function (ret) {
                    console.log(ret)
                    if (ret.flag) {
                        dele();
                    }

                }
            })


        })
        /*配置查询模板*/
        $('.btn4').click(function () {
            TempPriv();
        });
        function TempPriv() {
            var html = '<caption class="clearfix"> <span class="priv_t">配置查询模板</span> ' +
                '<a href="javascript:void (0)" class="newbuilt file_n">新建</a> ' +
                '<a href="javascript:void (0)" class="delete_c">删除</a> ' +
                '</caption>' +
                "<t><th><input type='checkbox' class='checkAll'>全选</th><th>模板名称</th><th>创建日期</th><th>操作</th></t>";
            $.ajax({
                type: 'get',
                url: '<%=basePath%>/flowSetDatas/getFlowQueryTplList',
                dataType: 'json',
                data: {
                    flowId: flowIdFromPage
                },
                success: function (data) {
                    var data = data.datas;
                    console.log(data);
                    for (var i = 0; i < data.length; i++) {
                        html += "<tbody>" + "<tr>" + "<td>" + "<input type='checkbox' class='one'  seqId='" + data[i].seqId + "'>" + "</td>" + "<td>" + data[i].tplName + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + data[i].createTime + "</td>" + "<td>" + '<a href="javascript:void(0)">修改</a>' + '<a class="del_temp" href="javascript:void(0)" seqId="' + data[i].seqId + '" >删除</a>' + "</td>" + "</tr>" + "</tbody>";
                    }

                    $('.table_temp').html(html);
                    checkAll();

                }
            })
        }

        /*配置查询模板删除*/
        $('.table_temp').on('click', '.del_temp', function () {
            alert('确定要删除吗!')
            var seqId = [];
            var tempId = $(this).attr('seqId');
            console.log(tempId)
            seqId.push(tempId);
            $.ajax({
                type: 'get',
                url: '<%=basePath%>flowSetDatas/deleteFlowQuertTpl',
                dataType: "json",
                data: {
                    'tplId[]': seqId
                },
                success: function (data) {
                    TempPriv();
                }
            })

        });

        /*应用版式文件*/
        $('.btn5').click(function () {
            privFile();
        });
        function privFile() {
            var html = '<caption class="clearfix"> <span class="priv_t">应用版式文件</span> ' +
                '<a href="javascript:void (0)" class="newbuilt file_n">新建</a> ' +
                '<a href="javascript:void (0)" class="delete_c">删除</a> ' +
                '</caption>' +
                "<t><th><input type='checkbox' class='checkAll'>全选</th><th>模板名称</th><th>模板类别</th><th>创建日期</th><th>操作</th></t>";
            $.ajax({
                type: 'get',
                url: '<%=basePath%>/flowSetDatas/getFlowPrintTpl',
                dataType: 'json',
                data: {
                    flowId: flowIdFromPage
                },
                success: function (data) {
                    if (data.flag) {
                        var data = data.datas;
                        for (var i = 0; i < data.length; i++) {
                            html += "<tbody>" + "<tr>" + "<td>" + "<input type='checkbox' class='one' tId='" + data[i].tId + "'>" + "</td>" + "<td>" + data[i].content + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + data[i].flowPrcs + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + data[i].createTime + "</td>" + "<td>" + '<a href="javascript:void(0)"  tId="' + data[i].tId + '" class="fileUpdate">修改</a>' + '<a href="javascript:void(0)" class="del_priv"  tId="' + data[i].tId + '">删除</a>' + "</td>" + "</tr>" + "</tbody>";
                        }
                    }
                    $('.table_prc').html(html);
                    checkAll();
                }

            })
        }

        /*应用版式文件删除*/
        $('.table_prc').on('click', '.del_priv', function () {
            alert('确定要删除吗！');
            var seqId = [];
            var tempId = $(this).attr('tId');
            seqId.push(tempId);

            $.ajax({
                url: '<%=basePath%>/flowSetDatas/deleteFlowPrintTpl',
                type: 'get',
                dataType: 'json',
                data: {
                    'tId[]': seqId
                },
                success: function (data) {
                    if (data.flag) {
                        privFile();
                        alert('删除成功！')
                    }

                },

            })
        })
        /*应用版式文件多选删除*/
        $('.table_prc').on('click', '.delete_c', function () {
            alert('确定删除吗！')
            var seqId = [];
            var checkAttr = $('.one:checked')
            if (checkAttr) {
                for (var i = 0; i < checkAttr.length; i++) {
                    seqId.push($(checkAttr[i]).attr('tId'))
                }
            }
            $.ajax({
                url: '<%=basePath%>/flowSetDatas/deleteFlowPrintTpl',
                type: 'get',
                dataType: 'json',
                data: {
                    'tId[]': seqId
                },
                success: function (data) {
                    if (data.flag) {
                        alert('删除成功！')
                        privFile();
                    }

                },

            })

        })

        /*管理权限新建弹窗*/
        $('.table').on('click', '#new', function () {
            layer.open({
                title: '<p style="background: #2b7fe0;height: 43px;width: 100%;font-size: 16px;padding-left: 10px;color: #fff">新建</p>',
                shade: 0,
                content: '<div class="pop_con">' +
                '<div class="con_t">' +
                '<div class="con_l">' +
                '<div class="con_title">' +
                '<div class="title_1">' +
                '<div class="title_label"></div>' +
                '<span class="title_s">授权类型 *</span>' +
                '<div class="title_put"><select name="" id="select_t" class="select_t"><option value="1">管理</option><option value="2">监控</option><option value="3">查询</option><option value="4">编辑</option><option value="5">点评</option></select></div></div>' +
                '<sapn class="title_s">管理范围 *</sapn>' +
                '<div class="title_2">' +
                '<select name="" id="select_ment" class="select_t"><option value="-2">所有部门</option><option value="-3">本机构</option><option value="-1">本部门</option></select></div>' +
                '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">授权范围(人员)</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="senduser" user_id="admin" value="admin" disabled></textarea><a style="margin-left: 10px;cursor: pointer" id="selectUser">添加</a><a>清空</a></div></div>' + '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">授权范围(部门)</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="sendept" dept_id="admin" value="admin" disabled></textarea><span style="margin-left: 10px;cursor: pointer" id="selectUser_t">添加</span><span>清空</span></div></div>' + '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">授权范围(角色)</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="sendRole" user_id="admin" value="admin" disabled></textarea><span style="margin-left: 10px;cursor: pointer" id="selectUser_s">添加</span><span>清空</span></div></div>' +
                '</div></div></div>' +
                '</div>',
                area: ['600px', '450px'],
                btn: ['保存', '关闭'],
                scrolling: 'no',
                yes: function () {
                    var userId = $("#senduser").attr("dataid");
                    userId=userId.split(',');
                    var deptId = $('#sendept').attr('deptid');
                    var deptIdAry = [];
                    deptIdAry.push(deptId);
                    var privid = $('#sendRole').attr('privid');
                    var privIdAry = [];
                    privIdAry.push(privid);

                    var scopeVal = [];
                    scopeVal.push($('#select_ment').val());
                    var data = {
                        privType: $('#select_t').val(),
                        'scope[]': scopeVal,
                        'user[]': userId,
                        'role[]': privIdAry,
                        'dept[]': deptIdAry,
                        'flowId': 1,
                    };
                    $.ajax({
                        type: 'GET',
                        url: '/flowSetDatas/newFlowPriv',
                        dataType: 'json',
                        data: data,
                        success: function (data) {
                            if (data.flag) {
                                alert('新建成功')
                                renderPriv();
                            } else {
                                alert('新建失败')
                            }
                        }
                    })
                }
            })
            /*弹窗控件*/
            $("#selectUser").click(function () {
                user_id = 'senduser';
                $.popWindow("../common/selectUser");
            });
            $("#selectUser_t").click(function () {
                dept_id = 'sendept';
                $.popWindow("../common/selectDept");
            })
            $("#selectUser_s").click(function () {
                priv_id = 'sendRole';
                $.popWindow("../common/selectPriv");
            })
            checkAll();
        });
        /*管理权限修改*/
        $('.table').on('click', '.powerUpdate', function () {
            var privId = $(this).attr("privId");
            layer.open({
                title: '<p style="background: #2b7fe0;height: 43px;width: 100%;font-size: 16px;padding-left: 10px;color: #fff">修改</p>',
                shade: 0,
                content: '<div class="pop_con">' +
                '<div class="con_t">' +
                '<div class="con_l">' +
                '<div class="con_title">' +
                '<div class="title_1">' +
                '<div class="title_label"></div>' +
                '<span class="title_s">授权类型 *</span>' +
                '<div class="title_put"><select name="" id="select_t" class="select_t"><option value="1">管理</option><option value="2">监控</option><option value="3">查询</option><option value="4">编辑</option><option value="5">点评</option></select></div></div>' +
                '<sapn class="title_s">管理范围 *</sapn>' +
                '<div class="title_2">' +
                '<select name="" id="select_ment" class="select_t"><option value="-2">所有部门</option><option value="-3">本机构</option><option value="-1">本部门</option></select></div>' +
                '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">授权范围(人员)</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="senduser" user_id="admin" value="admin" disabled></textarea><a style="margin-left: 10px;cursor: pointer" id="selectUser">添加</a><a>清空</a></div></div>' + '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">授权范围(部门)</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="sendept" dept_id="admin" value="admin" disabled></textarea><span style="margin-left: 10px;cursor: pointer" id="selectUser_t">添加</span><span>清空</span></div></div>' + '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">授权范围(角色)</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="sendRole" user_id="admin" value="admin" disabled></textarea><span style="margin-left: 10px;cursor: pointer" id="selectUser_s">添加</span><span>清空</span></div></div>' +
                '</div></div></div>' +
                '</div>',
                area: ['600px', '450px'],
                btn: ['保存', '关闭'],
                scrolling: 'no',
                yes: function () {
                    var userId = $("#senduser").attr("dataid");
                    userId=userId.split(',');
                    var deptId = $('#sendept').attr('deptid');
                    var deptIdAry = [];
                    deptIdAry.push(deptId);
                    var privid = $('#sendRole').attr('privid');
                    var privIdAry = [];
                    privIdAry.push(privid);

                    var scopeVal = [];
                    scopeVal.push($('#select_ment').val());
                    var data = {
                        privType: $('#select_t').val(),
                        'scope[]': scopeVal,
                        'user[]': userId,
                        'role[]': privIdAry,
                        'dept[]': deptIdAry,
                        'flowId': 1,
                        'privId': privId
                    };
                    $.ajax({
                        type: 'GET',
                        url: '/flowSetDatas/updateFlowPriv',
                        dataType: 'json',
                        data: data,
                        success: function (data) {
                            if (data.flag) {
                                alert('修改成功');
                                renderPriv();
                            } else {
                                alert('修改失败')
                            }
                        }
                    })
                }
            })
            /*弹窗控件*/
            $("#selectUser").click(function () {
                user_id = 'senduser';
                $.popWindow("../common/selectUser");
            });
            $("#selectUser_t").click(function () {
                dept_id = 'sendept';
                $.popWindow("../common/selectDept");
            })
            $("#selectUser_s").click(function () {
                priv_id = 'sendRole';
                $.popWindow("../common/selectPriv");
            })
            checkAll();
        })

        /*定时任务新建弹窗*/
        $('.table').on('click', '.task_n', function () {
            layer.open({
                title: '<p style="background: #2b7fe0;height: 43px;width: 100%;font-size: 16px;padding-left: 15px;color: #fff">新建</p>',
                shade: 0,
                content: '<div class="pop_con">' +
                '<div class="con_t">' +
                '<div class="con_l">' +
                '<div class="con_title">' +
                '<div class="title_1">' +
                '<div class="title_label"></div>' +
                '<span class="title_s">发起频率 *</span>' +
                '<div class="title_put"><select name="" id="" class="select_t"><option value="1">1</option></select></div></div>' +
                '<sapn class="title_s">发起时间 *</sapn>' +
                '<div class="title_2">' +
                '<select name="" id="" class="select_t"><option value=""></option></select></div>' +
                '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">发起人 *</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="addUser" user_id="admin" value="admin" disabled></textarea><a style="margin-left: 10px;cursor: pointer" id="addSave_u">添加</a><a>清空</a></div></div>' + '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">发起部门 *</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="addDep" user_id="admin" value="admin" disabled></textarea><a style="margin-left: 10px;cursor: pointer" id="addSave_d">添加</a><a>清空</a></div>' + '</div>' + '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">发起角色 *</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="addRole" user_id="admin" value="admin" disabled></textarea><a style="margin-left: 10px;cursor: pointer" id="addSave_r">添加</a><a>清空</a></div>' + '</div>' +
                '</div></div></div>' +
                '</div>',
                area: ['600px', '500px'],
                btn: ['保存', '关闭'],
                yes: function () {
                    var userId = $("#addUser").attr("dataid");
                    userId=userId.split(',');
                    var deptId = $('#addDep').attr('deptid');
                    var deptIdAry = [];
                    deptIdAry.push(deptId);
                    var privid = $('#addRole').attr('privid');
                    var privIdAry = [];
                    privIdAry.push(privid);
                    var data = {
                        type: 1,
                        'date': "2017-03-21 11:55:33",
                        'user[]': userId,
                        'role[]': privIdAry,
                        'dept[]': deptIdAry,
                        'flowId': 1
                    }
                    $.ajax({
                        type: 'GET',
                        url: '<%=basePath%>/flowSetDatas/newFlowTimer',
                        dataType: 'json',
                        data: data,
                        success: function (data) {
                            if (data.flag) {
                                alert('新建成功');
                            } else {
                                alert('新建失败');
                            }
                        }
                    })
                }
            })
            /*弹窗控件*/
            $("#addSave_u").click(function () {
                user_id = 'addUser';
                $.popWindow("../common/selectUser");
            });
            $("#addSave_d").click(function () {
                dept_id = 'addDep';
                $.popWindow("../common/selectDept");
            })
            $("#addSave_r").click(function () {
                priv_id = 'addRole';
                $.popWindow("../common/selectPriv");
            })
            checkAll();
        });
        /*定时任务修改*/
        $('.table').on('click', '.privUp', function () {
            alert('确定要修改吗！');
            var timerId = $(this).attr('timerId');

            layer.open({
                title: '<p style="background: #2b7fe0;height: 43px;width: 100%;font-size: 16px;padding-left: 15px;color: #fff">新建</p>',
                shade: 0,
                content: '<div class="pop_con">' +
                '<div class="con_t">' +
                '<div class="con_l">' +
                '<div class="con_title">' +
                '<div class="title_1">' +
                '<div class="title_label"></div>' +
                '<span class="title_s">发起频率 *</span>' +
                '<div class="title_put"><select name="" id="" class="select_t"><option value="1">1</option></select></div></div>' +
                '<sapn class="title_s">发起时间 *</sapn>' +
                '<div class="title_2">' +
                '<select name="" id="" class="select_t"><option value=""></option></select></div>' +
                '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">发起人 *</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="addUser" user_id="admin" value="admin" disabled></textarea><a style="margin-left: 10px;cursor: pointer" id="addSave_u">添加</a><a>清空</a></div></div>' + '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">发起部门 *</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="addDep" user_id="admin" value="admin" disabled></textarea><a style="margin-left: 10px;cursor: pointer" id="addSave_d">添加</a><a>清空</a></div>' + '</div>' + '<div class="title_3">' +
                '<div class="title3_label">' +
                '<span class="title_s">发起角色 *</span></div>' +
                '<div class="select_put">' +
                '<textarea name="txt" id="addRole" user_id="admin" value="admin" disabled></textarea><a style="margin-left: 10px;cursor: pointer" id="addSave_r">添加</a><a>清空</a></div>' + '</div>' +
                '</div></div></div>' +
                '</div>',
                area: ['600px', '500px'],
                btn: ['保存', '关闭'],
                yes: function () {
                    var data = {
                        type: 1,
                        'date': "2017-03-21 11:55:33",
                        'user[]': [1, 2, 3],
                        'role[]': [1, 2, 3],
                        'dept[]': [1, 2, 3],
                        'flowId': 1,
                        'timerId': timerId
                    }
                    $.ajax({
                        type: 'GET',
                        url: '<%=basePath%>/flowSetDatas/updateFlowTimer',
                        dataType: 'json',
                        data: data,
                        success: function (data) {
                            if (data.flag) {
                                alert('修改成功');
                                dele();
                            } else {
                                alert('修改失败');
                            }
                        }
                    })

                }
            })
            /*弹窗控件*/
            $("#addSave_u").click(function () {
                user_id = 'addUser';
                $.popWindow("../common/selectUser");
            });
            $("#addSave_d").click(function () {
                dept_id = 'addDep';
                $.popWindow("../common/selectDept");
            })
            $("#addSave_r").click(function () {
                priv_id = 'addRole';
                $.popWindow("../common/selectPriv");
            })
            checkAll();
        });

        /*配置模板查询新建弹窗*/
        $('.table').on('click', '.temp_n', function () {
            layer.open({
                title: '<p style="background: #2b7fe0;height: 43px;width: 100%;font-size: 16px;padding-left: 15px;color: #fff">新建</p>',
                shade: 0,
                content: '<div class="pop_con">' +
                '<div class="con_t">' +
                '<div class="con_l">' +
                '<div class="con_title">' +
                '<div class="title_1">' +
                '<div class="title_label"></div>' +
                '<span class="title_s">模板名称 *</span>' +
                '<div class="title_put"><select name="" id="" class="select_t"></select></div></div>' +
                '</div></div></div>' +
                '</div>',
                area: ['600px', '500px'],
                btn: ['保存', '关闭'],
                /*  yes: function () {
                 var data = {
                 'tplName':
                 'viewFields':
                 'groupFields':
                 'flowId': 1
                 };
                 $.ajax({
                 type: 'GET',
                 url: '<%=basePath%>/flowSetDatas//newFlowQuertTpl',
                 dataType: 'json',
                 data: data,
                 success: function (data) {
                 if (data.flag) {
                 alert('新建成功');
                 } else {
                 alert('新建失败');
                 }
                 }
                 });
                 }*/

            })
        });
        /*应用版式文件弹窗*/
        $('.table').on('click', '.file_n', function () {
            layer.open({
                title: '<p style="background: #2b7fe0;height: 43px;width: 100%;font-size: 16px;padding-left: 15px;color: #fff">新建</p>',
                shade: 0,
                content: '<div class="pop_con">' +
                '<div class="con_t">' +
                '<div class="con_l">' +
                '<div class="con_title">' +
                '<div class="title_1">' +
                '<div class="title_label"></div>' +
                '<span class="title_s">模板名称 *</span>' +
                '<div class="title_put"><input type="text" id="select_con" class="select_t"></div></div>' +
                '<div class="title_2">' +
                '<div class="title_label"></div>' +
                '<span class="title_s">模板类别 *</span>' +
                '<div class="title_put"><select name="" id="select_type" class="select_t"><option value="1" selected="selected">打印模板</option></select></div></div>' + '<div class="title_1">' +
                '<div class="title_label"></div>' +
                '<span class="title_s">模板文件 *</span>' +
                '<textarea name="" id="addtext" disabled>选择模板文件</textarea></div>' +
                '</div></div></div>' +
                '</div>',

                area: ['600px', '500px'],
                btn: ['保存', '关闭'],
                yes: function () {
                    var data = {
                        'tName': $('#select_con').val(),
                        'tType': $('#select_type option:selected').val(),
                        'flowId': 1,
                    }
                    $.ajax({
                        type: 'GET',
                        url: '/flowSetDatas/newFlowPrintTpl',
                        dataType: 'json',
                        data: data,
                        success: function (data) {
                            console.log(data)
                            if (data.flag) {
                                alert('新建成功');
                                privFile();
                            } else {
                                alert('新建失败');
                            }
                        }
                    });
                }
            })
        });
        /*应用版式文件修改*/
        $('.table').on('click', '.fileUpdate', function () {
            alert('确定修改吗！')
            var tId = $(this).attr('tId');
            layer.open({
                title: '<p style="background: #2b7fe0;height: 43px;width: 100%;font-size: 16px;padding-left: 15px;color: #fff">新建</p>',
                shade: 0,
                content: '<div class="pop_con">' +
                '<div class="con_t">' +
                '<div class="con_l">' +
                '<div class="con_title">' +
                '<div class="title_1">' +
                '<div class="title_label"></div>' +
                '<span class="title_s">模板名称 *</span>' +
                '<div class="title_put"><input type="text" id="select_con" class="select_t"></div></div>' +
                '<div class="title_2">' +
                '<div class="title_label"></div>' +
                '<span class="title_s">模板类别 *</span>' +
                '<div class="title_put"><select name="" id="select_type" class="select_t"><option value="1" selected="selected">打印模板</option></select></div></div>' + '<div class="title_1">' +
                '<div class="title_label"></div>' +
                '<span class="title_s">模板文件 *</span>' +
                '<textarea name="" id="addtext" disabled>选择模板文件</textarea></div>' +
                '</div></div></div>' +
                '</div>',

                area: ['600px', '500px'],
                btn: ['保存', '关闭'],
                yes: function () {
                    var data = {
                        'tName': $('#select_con').val(),
                        'tType': $('#select_type option:selected').val(),
                        'flowId': 1,
                        'tId': tId
                    }
                    $.ajax({
                        type: 'GET',
                        url: '/flowSetDatas/updateFlowPrintTpl',
                        dataType: 'json',
                        data: data,
                        success: function (data) {
                            console.log(data)
                            if (data.flag) {
                                alert('修改成功');
                                checkAll();
                            } else {
                                alert('修改失败');
                            }
                        }
                    });

                }

            })
        });

        /*全选非全选*/
        function checkAll() {
            $('.checkAll').on('click', function () {
                $('.one').prop('checked', $(this).prop('checked'));
            });
            $('.one').click(function () {
                $('.checkAll').prop('checked', $('.one').length == $('.one:checked').length ? true : false);
            })
        }

        checkAll();
    });

</script>

</html>
