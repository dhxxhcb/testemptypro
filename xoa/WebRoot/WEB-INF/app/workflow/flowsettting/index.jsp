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
    <link rel="stylesheet" href="../../lib/laydate.css">

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
                <li><a href="<%=basePath %>workflow/work/workform1?formId=122" class="btn_h btn_h_3"><i
                        class="icon"></i>预览表单</a>
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
        <div class="item item_s item_con">
            <div class="homePage">
                <div class="define_r define_flow clearfix">
                    <h3>流程主页</h3>
                    <span><a href="<%=basePath %>flowSetting/processDesignTool?flowId=${flowId}"
                             class="flowJpdl flow_des">流程设计器</a></span>
                </div>
                <div class="home_mid">
                    <ul class="mid_f clearfix">
                        <li><a class="expont_num" href="javascript:void(0)">
                            <img src="../../img/workflow/flowsetting/icon_processing_03.png" alt="">
                            <p class="expont_r">
                                <span class="num">10</span>
                                <span class="exponent">全部流程数</span>
                            </p>
                        </a>
                        </li>
                        <li><a class="expont_num" href="javascript:void(0)">
                            <img src="../../img/workflow/flowsetting/icon_allprocess_03.png" alt="">
                            <p class="expont_r">
                                <span class="num" style="color: #d68b2f24">10</span>
                                <span class="exponent" style="color: #d68b2f24">正在执行流程数</span>
                            </p>
                        </a>
                        </li>
                        <li><a class="expont_num" href="javascript:void(0)">
                            <img src="../../img/workflow/flowsetting/icon_finish_03.png" alt="">
                            <p class="expont_r">
                                <span class="num" style="color: #287a55">10</span>
                                <span class="exponent" style="color: #287a55">已经结束流程数</span>
                            </p>
                        </a>
                        </li>
                        <li><a class="expont_num" href="javascript:void(0)">
                            <img src="../../img/workflow/flowsetting/icon_orige_04.png" alt="">
                            <p class="expont_r">
                                <span class="num" style="color: #966f31">10</span>
                                <span class="exponent" style="color: #966f31">已归档流程数</span>
                            </p>
                        </a>
                        </li>

                    </ul>
                </div>
                <div class="home_con clearfix">
                    <div class="conLeft">
                        <h3 class="con_t">流程基本信息</h3>
                        <ul class="con_c">
                            <li class="conLeft_list clearfix">
                                <i class="bg bg1"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID" style="color: #8f000000">流程名称/ID号</span>
                                    <p class="flow_p">请假申请</p>
                                </a>
                            </li>
                            <li class="conLeft_list clearfix">
                                <i class="bg bg2"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程所属分类</span>
                                    <p class="flow_p">考勤管理</p>
                                </a>
                            </li>
                            <li class="conLeft_list clearfix">
                                <i class="bg bg3"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程所有表单</span>
                                    <p class="flow_p">请假登记单</p>
                                </a>
                            </li>
                            <li class="conLeft_list clearfix">
                                <i class="bg bg4"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程类型</span>
                                    <p class="flow_p">固定类型</p>
                                </a>
                            </li>
                            <li class="conLeft_list clearfix">
                                <i class="bg bg1"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程所属部门</span>
                                    <p class="flow_p">人力资源部</p>
                                </a>
                            </li>
                            <li class="conLeft_list clearfix">
                                <i class="bg bg2"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程名称/ID号</span>
                                    <p class="flow_p">张三</p>
                                    <%-- <p class="flow_z">张三</p><span class="flow_q">请假流程</span>
                                     <p class="flow_date">2017年6月1号 10:30</p>--%>
                                </a>
                            </li>
                            <li class="conLeft_list clearfix">
                                <i class="bg bg3"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">工作名称/文号</span>
                                    <p class="flow_p">4</p>
                                </a>
                            </li>
                            <li class="conLeft_list clearfix">
                                <i class="bg bg4"></i>
                                <a href="javascript:;" class="list_click">
                                    <span class="flow_ID">流程名称/ID号</span>
                                    <p class="flow_p">0</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="conRight">
                        <h3 class="con_t">流程支持的功能</h3>
                        <ul style="background: #f5f7f8;">
                            <li><a href="javascript:;" class="btn_c">是否支持回退</a><span class="save">是</span></li>
                            <li><a href="javascript:;" class="btn_c">是否支持会签</a><span class="save save_r">否</span></li>
                            <li><a href="javascript:;" class="btn_c">是否允许并发</a><span class="save">是</span></li>
                            <li><a href="javascript:;" class="btn_c">是否可以传阅</a><span class="save">是</span></li>
                            <li><a href="javascript:;" class="btn_c">是否有附件</a><span class="save save_s">是</span></li>
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
                                    <%--<option value="1">系统(仅有系统管理员管理)</option>--%>
                                </select>
                            </div>
                            <div class="form_group">
                                <label for="classfiy" class="flowName">流程分类 <span class="save">*</span></label>
                                <select name="" id="classfiy" class="depName">
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
                                    <%--<option value="">请假登记</option>--%>
                                </select>
                            </div>
                            <div class="form_group">
                                <label for="delegate-type" class="flowName">委托类型<span class="save">*</span></label>
                                <select name="FREE_OTHER" id="delegate-type" class="depName">
                                    <option value="2" selected="selected">自由委托</option>
                                    <option value="1">仅允许委托当前步骤经办人</option>
                                    <option value="3">按步骤设置的经办权限委托</option>
                                    <option value="0">禁止委托</option>
                                </select>
                            </div>
                            <div class="form_group sex_r">
                                <label class="flowName">是否允许传阅<span class="save">*</span></label>
                                <input type="radio" name="sex" value="是" class="radio_s"><label class="sex_n ">是</label>
                                <input type="radio" name="sex" value="否" class="radio_f" checked><label
                                    class="sex_save">否</label>
                            </div>
                            <%--控件--%>
                            <div class="form_group block_n"
                                 style="padding-left: 210px;margin: -38px 0 38px 0;display: none">
                                <div class="title_3">
                                    <div class="title3_label">
                                        <span class="title_s">传阅人</span></div>
                                    <div class="select_put">
                                        <textarea name="txt" id="text_1" user_id="admin" value="admin"
                                                  disabled></textarea><a style="margin-left: 10px;cursor: pointer"
                                                                         id="add_f_1">添加</a><a>清空</a></div>
                                </div>
                                <div class="title_3">
                                    <div class="title3_label">
                                        <span class="title_s">传阅部门</span></div>
                                    <div class="select_put">
                                        <textarea name="txt" id="text_2" user_id="admin" value="admin"
                                                  disabled></textarea><a style="margin-left: 10px;cursor: pointer"
                                                                         id="add_f_2">添加</a><a>清空</a></div>
                                </div>
                                <div class="title_3">
                                    <div class="title3_label">
                                        <span class="title_s">传阅角色</span></div>
                                    <div class="select_put">
                                        <textarea name="txt" id="text_3" user_id="admin" value="admin"
                                                  disabled></textarea><a style="margin-left: 10px;cursor: pointer"
                                                                         id="add_f_3">添加</a><a>清空</a></div>
                                </div>
                            </div>

                            <div class="form_group sex_r">
                                <label class="flowName">是否允许上传附件<span class="save">*</span></label>
                                <input type="radio" name="sex_1" value="1" checked><label class="sex_n">是</label>
                                <input type="radio" name="sex_1" value="0"><label class="sex_save">否</label>

                            </div>
                            <div class="form_group sex_r">
                                <label class="flowName">是否启用版本控制<span class="save">*</span></label>
                                <input type="radio" name="sex_2" value="1" checked><label class="sex_n">是</label>
                                <input type="radio" name="sex_2" value="0"><label class="sex_save">否</label>

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
                            <div class="form_group Attachment">
                                <form action="" class="files"></form>
                            </div>
                            <div class="form_group form_icon files">
                                <form id="uploadimgform" target="uploadiframe" action="../upload?module=email"
                                      enctype="multipart/form-data" method="post">
                                    <label for="counteer" class="flowName">上传附件<span class="save">*</span></label>
                                    <input type="file" name="file" id="uploadinputimg" class="w-icon5"
                                           style="display:none;">
                                    <i class="icon_plus"></i><input type="text" value="上传附件" class="addfile"
                                                                    id="addfile" style="cursor: pointer">
                                    <i class="icon_plus"></i><input type="text" value="从文件柜选择附件" class="appendfile"
                                                                    id="appendfile" style="cursor: pointer">
                                    <%--<a href="#" id="uploadimg">上传</a>--%>
                                </form>


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
<script src="../../lib/laydate/laydate.js"></script>
<script src="../../js/workflow/work/workform.js"></script>

<script type="text/javascript">

    //时间控件调用
    /* var start = {
     elem: '#start_date',
     format: 'YYYY/MM/DD hh:mm:ss',
     /!* min: laydate.now(), //设定最小日期为当前日期*!/
     /!* max: '2099-06-16 23:59:59', //最大日期*!/
     istime: true,
     istoday: false,
     choose: function(datas){
     end.min = datas; //开始日选好后，重置结束日的最小日期
     end.start = datas //将结束日的初始值设定为开始日
     }
     };
     var end = {
     elem: '#end_date',
     format: 'YYYY/MM/DD hh:mm:ss',
     /!*min: laydate.now(),*!/
     /!*max: '2099-06-16 23:59:59',*!/
     istime: true,
     istoday: false,
     choose: function(datas){
     start.max = datas; //结束日选好后，重置开始日的最大日期
     }
     };
     laydate(start);
     laydate(end);
     */
    var ue = UE.getEditor('container');

    $(function () {
        /*预览表单*/
        $('.btn_h_3').click(function () {

        })


        /*所属部门控件*/
        $('#deptName').deptSelect();
        /*流程分类控件*/
        items();
        function items() {
            $.ajax({
                url: '<%=basePath%>workflow/flowclassify/flow',
                type: 'get',
                dataType: 'json',
                success: function (obj) {
                    if (obj.flag) {
                        var data = obj.datas;
                        var opt_li = '<option value="0"  class="levelleft0 selector"></option>';
                        opt_li = Child(data, opt_li, 0, -1);
                        $('#classfiy').html(opt_li);
                    }
                }
            });
        }

        function Child(datas, opt_li, level, parentId) {
            for (var i = 0; i < datas.length; i++) {
                if (level == 0 && i == 0) continue;
                var String = "";
                var space = ""
                for (var j = 0; j < level; j++) {
                    space += "├&nbsp;&nbsp;&nbsp;";
                }
                /* console.log("kongge"+space+"kongge")*/
                if (i == 0) {
                    String = space + "┌";
                }
                if (i != 0) {
                    String = space + "├";
                }
                if (i == datas.length - 1) {
                    String = space + "└";
                }
                if (parentId == datas[i].sortId) {
                    opt_li += '<option value="' + datas[i].sortId + '" selected="selected">' + String + datas[i].sortName + '</option>';
                } else {
                    opt_li += '<option value="' + datas[i].sortId + '">' + String + datas[i].sortName + '</option>';
                }

                /* console.log(datas[i].childs); */
                if (datas[i].childs != null) {
                    opt_li = Child(datas[i].childs, opt_li, level + 1, parentId);
                }
            }

            return opt_li;
        }


        //附件上传
        $('#addfile').on('click', function (ele) {
            $('#uploadinputimg').click();
        })
        $('#uploadinputimg').change(function (e) {
            var target = $(e.target);
            var file;
            if (target[0].files && target[0].files[0]) {
                file = target[0].files[0];
            }
            //console.log(file);
            if (file) {
                $.upload($('#uploadimgform'), function (res) {
                    console.log(res);
                    var data = res.obj;
                    var str = '';
                    var str1 = '';
                    for (var i = 0; i < data.length; i++) {
                        str += '<a href="<%=basePath %>download?' + data[i].attUrl + '" NAME="' + data[i].attachName + '*">' + data[i].attachName + '</a>';
                        str1 += '<input type="hidden" class="inHidden" value="' + data[i].aid + '@' + data[i].ym + '_' + data[i].attachId + ',">';
                    }
                    $('.Attachment').append(str + str1);
                });
            }
        });

        var flowIdFromPage = '${flowId}';
        /*定义流程属性查询*/
        /*表单控件*/
        function formAjax() {
            $.ajax({
                url: '<%=basePath%>form/allformlist',
                type: 'GET',
                dataType: 'json',
                success: function (data) {
                    if (data.flag) {
                        var data = data.datas;
                        var html = '';
                        for (var i = 0; i < data.length; i++) {
                            html += '<option value="" disabled>' + data[i].sortName + '</option>'
                            var form = data[i].form;
                            for (var j = 0; j < form.length; j++) {
                                html += '<option value="' + form[j].formId + '" >&nbsp;&nbsp;&nbsp;' + form[j].formName + '</option>'

                            }
                        }
                    }
                    $('#leave').html(html)


                }
            })
        }

        $('.radio_s').click(function () {
            $(".block_n").show();
        });
        $('.radio_f').click(function () {
            $(".block_n").hide();
        });
        $("#add_f_1").click(function () {
            user_id = 'text_1';
            $.popWindow("../common/selectUser");
        });
        $("#add_f_2").click(function () {
            dept_id = 'text_2';
            $.popWindow("../common/selectDept");
        })
        $("#add_f_3").click(function () {
            priv_id = 'text_3';
            $.popWindow("../common/selectPriv");
        })


        var flowId = '${flowId}';
        if (flowId != "") {
            $('.item_con').show();
            $('.btn_h_1').click(function () {
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
                            $('#class_f').html('<option value="1">固定流程<option/><option value="2">自由流程<option/>');

                        }
                    }
                });
                formAjax();

            })
        } else {
            $('.item1').show();
            formAjax();
        }
        $('.keepmsg').on('click', function () {
            var flowId = '${flowId}';
            if (flowId == null || flowId == "") {
                //保存
                var data = {
                    flowName: $('#projectName').val(),
                    flowNo: $('#orderID').val(),
                    deptId: $("#deptName option:selected").val(),
                    flowSort: $('#classfiy option:selected').val(),
                    flowType: $('#class_f option:selected').val(),
                    formId: $('#leave option:selected').val(),
                    freeOther: $('#delegate-type option:selected').val(),
                    flowDoc: $('input[name="sex_1"]:checked').val(),
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
                    flowName: $('#projectName').val(),
                    flowNo: $('#orderID').val(),
                    deptId: $("#deptName option:selected").val(),
                    flowSort: $('#classfiy option:selected').val(),
                    flowType: $('#class_f option:selected').val(),
                    formId: $('#leave option:selected').val(),
                    freeOther: $('#delegate-type option:selected').val(),
                    flowDoc: $('input[name="sex_1"]:checked').val(),
                    autoNum: $('#counteer').val(),
                    autoLen: $('#figure').val()
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
        /*设计步骤流程*/
        $('.btn_h_2').click(function () {
            $.ajax({
                type: "get",
                url: "<%=basePath%>flowProcess/findFlowId",
                dataType: "json",
                data: {
                    flowId: flowId
                },
                success: function (data) {
                    if (data.flag) {
                        var data = data.obj;
                        var html = '<caption class="clearfix"> <span class="priv_t">设计流程步骤</span> ' +
                            '<a href="<%=basePath %>flowSetting/processDesignTool?flowId=${flowId}" class="flowJpdl">流程设计器</a> ' +
                            '</caption>' +
                            '<tr><th>序号</th><th>名称</th><th>下一步骤</th><th>编辑该步骤的各项属性</th><th>操作</th></tr>';

                        for (var i = 0; i < data.length; i++) {
                            var prcsTo = data[i].prcsTo;
                            if (prcsTo == "") {
                                prcsTo = [data[i].prcsId] * 1 + 1
                            } else {
                                prcsTo = data[i].prcsTo
                            }
                            html += "<tr>" + "<td>" + data[i].prcsId + "</td>" + "<td>" + data[i].prcsName + "</td>" +
                                "<td>" + data[i].prcsTo + "</td>" + "<td style='text-align: center'></td>" + "<td>" + "<a href='javascript:void(0)'></a><a href='javascript:void(0)'></a>" + "</td>" + "</tr>";

                        }
                    }
                    $('#table_form').html(html);
                    checkAll();
                }
            });
        })

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
                            strData += "<tbody>" + "<tr>" + "<td>" + "<input type='checkbox' class='one'  timerId='" + data_d[i].tid + "'>" + "</td>" + "<td>" + data_d[i].typeName + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + data_d[i].userName + "</br>" + data_d[i].deptName + "</br>" + data_d[i].roleName + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + data_d[i].remindDate + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + data_d[i].lastTime + "</td>" + "<td>" + '<a href="javascript:void(0)" timerId="' + data_d[i].tid + '" class="privUp">修改</a>' + '<a class="del" href="javascript:void(0)" timerId="' + data_d[i].tid + '" >删除</a>' + "</td>" + "</tr>" + "</tbody>";
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
                '<a href="javascript:void (0)" class="newbuilt temp_n">新建</a> ' +
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
                    for (var i = 0; i < data.length; i++) {
                        html += "<tbody>" + "<tr>" + "<td>" + "<input type='checkbox' class='one'  seqId='" + data[i].seqId + "'>" + "</td>" + "<td>" + data[i].tplName + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + data[i].createTime + "</td>" + "<td>" + '<a href="javascript:void(0)" class="updata_c">修改</a>' + '<a class="del_temp" href="javascript:void(0)" seqId="' + data[i].seqId + '" >删除</a>' + "</td>" + "</tr>" + "</tbody>";
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
                            var tTypeStr = '';
                            if (data[i].tType == '1') {
                                tTypeStr = '打印模板'
                            } else {
                                tTypeStr = '首页呈批单'
                            }
                            html += "<tbody>" + "<tr>" + "<td>" + "<input type='checkbox' class='one' tId='" + data[i].tId + "'>" + "</td>" + "<td>" + data[i].tName + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + tTypeStr + "</td>" + "<td style='text-align: left;padding-left: 10px'>" + data[i].createTime + "</td>" + "<td>" + '<a href="javascript:void(0)"  tId="' + data[i].tId + '" class="fileUpdate">修改</a>' + '<a href="javascript:void(0)" class="del_priv"  tId="' + data[i].tId + '">删除</a>' + "</td>" + "</tr>" + "</tbody>";
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
                    userId = userId.split(',');
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
                    userId = userId.split(',');
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
                    userId = userId.split(',');
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
        function layerWin() {
            layer.open({
                title: '<p style="background: #2b7fe0;height: 43px;width: 100%;font-size: 16px;padding-left: 15px;color: #fff">新建</p>',
                shade: 0,
                content: '<div class="cont_pop">' +
                '<div class="con_flow clearfix">' +
                '<div class="over_f">' +
                '<p class="define_p flowtitle">模板基本信息</p>' +
                '<form class="pro_flow "><div class="con_form">' + '<div class="form_group">' +
                '<label for="projectName" class="flowName">模板名称</label>' +
                '<input type="text" id="tempName">' + '</div></div></form>' +
                '<p class="define_p flowtitle">流程过滤条件</p>' +
                '<form class="pro_flow "><div class="con_form con_form_c">' +
                '<div class="form_group">' + '<label for="deptName" class="flowName">工作流状态</label>' +
                '<select name=" FLOW_STATUS" id="FLOW_STATUS" class="depName"><option value="ALL">所有</option><option value="1">已结束</option><option value="0">执行中</option>' +
                '</select></div>' +
                '<div class="form_group">' + '<label for="deptName" class="flowName">查询范围</label>' +
                '<select name="FLOW_QUERY_TYPE" id="FLOW_QUERY_TYPE" class="depName"><option value="ALL">所有</option><option value="1">我发起的</option><option value="2">我经办的</option><option value="3">我管理的</option></select></div>' +
                '<div class="form_group"><label for="deptName" class="flowName">流程开始日期范围 </label>' +
                '<span>从</span><input type="text" class="put" id="start_date" name="PRCS_DATE1"><span>至</span><input type="text"class="put" id="end_date"><span>清空</span></div>' +
                '<div class="form_group">' +
                '<label for="deptName" class="flowName">名称/文号 </label><select name="PRCS_DATE1PRCS_DATE2PRCS_DATE3PRCS_DATE4BEGIN_USERBEGIN_NAMERUN_NAME" id="runName" class="depName"><option value="1">等于</option><option value="2">大于</option><option value="3">小于</option><option value="4">大于等于</option><option value="5">小于等于</option><option value="6">不等于</option><option value="7">开始为</option><option value="8" selected>包含</option><option value="9">结束为</option></select><input type="text"></div>' +
                '<div class="form_group">' +
                '<label for="deptName" class="flowName">公共附件名称 </label>' + '<select name="ATTACHMENT_NAME" id="attment" class="depName"><option value="1">等于</option><option value="2">小于</option><option value="2">大于</option><option value="2">不等于</option><option value="2">大于等于</option><option value="2">小于等于</option><option value="2">不等于</option><option value="2">开始为</option><option value="2">包含</option><option value="2">结束为</option></select><input type="text"></div>' +
                '<div class="form_group">' +
                '<label for="deptName" class="flowName">流程发起人</label>' +
                '<textarea name="txt" id="textPut" user_id="admin" value="admin" disabled></textarea>' +
                '<a style="margin-left: 10px;cursor: pointer" id="select_User">添加</a>' +
                '<a style="margin-left: 10px;cursor: pointer">清空</a>' + '</div></div></form>' +
                '<div class="jobName flowtitle">表单数据过滤条件</div>' +
                '<form class="pro_flow flow_r"><div class="con_form"><div class="form_group"><label for="deptName" class="flowName">字段</label>' +
                '<select name="" id="file_p" class="depName"></select></div>' +
                '<div class="form_group"><label for="deptName" class="flowName">条件</label><select name="" id="term" class="depName"><option value="1">等于</option><option value="2">小于</option><option value="2">大于</option><option value="2">不等于</option><option value="2">大于等于</option><option value="2">小于等于</option><option value="2">不等于</option><option value="2">开始为</option><option value="2">包含</option><option value="2">结束为</option><option value="2">为空</option></select></br>' +
                '<label for="deptName" class="flowName">值</label>' + '<input type="text" id="numval">' +
                '<div><a href="javascript:;" class="addbtn">添加字段条件</a></div>' +
                '<table class="table table_h" cellspacing="0" id="table_t">' + '<thead><tr>' +
                '<th style="text-align: center">编号</th><th style="text-align: center">表单条件描述</th><th style="text-align: center">操作</th></tr></thead>' + '</table>' +
                '<label for="deptName" class="flowName">表单条件公式</label><input type="text" id="query_d"></div></div></form>' +
                '<div class="jobName flowtitle">统计报表选项</div>' +
                '<form class="pro_flow flow_r"><div class="con_form"><div class="form_group"><label for="deptName" class="flowName">分组字段</label><select name="" id="group_s" class="depName">' +
                '</select>' + '<select name="" id="groupSort" class="depName">' +
                '<option value="ASC">升序</option><option value="DESC">降序</option></select></div><div class="plug_body form_group">' +
                '<div class="plug_body_left"><div class="list_title">显示在待办列表上的字段</div><div class="list_infomation" id="next_step_div">' +
                '<table cellspacing="0px" cellpadding="0px" width="100%" id="next_step_tab" class="next_step_tab"><tbody id="data_th"></tbody>' +
                '</table></div><div style="margin-top:10px;"><button class="btn" id="left_btn" type="button" style="margin-left:100px;">全选</button></div></div>' + '<div class="plug_body_center"><div class="change_right"><button type="button" style="width: 20px;height: 20px" id="btn_b1"></button></div><div class="change_left"><button type="button" style="width: 20px;height: 20px" id="btn_b2"></button></div></div>' +

                '<div class="plug_body_right"><div class="list_title">备选字段</div><div class="list_infomation" id="alternative_div">' +
                '<table cellspacing="0px" cellpadding="0px" width="100%" id="alternative_tab">' + '<tbody id="data_th_1"></tbody></table>' + '</div>' +
                '<div style="margin-top:10px;">' +
                '<button class="btn" id="right_btn" type="button"  style="margin-left:100px;">全选</button></div></div></div>' +
                '</div></form></div></div>' +
                '</div>',
                area: ['800px', '500px'],
                btn: ['保存', '关闭'],
                yes: function () {

                    var td = $("#data_th_1 td");
                    var viewStr = "";
                    for (var i = 0; i < td.length; i++) {
                        var name = $(td[i]).attr("name");
                        if (name) {
                            viewStr += "flow_data_${flowId}." + name + ","
                        }

                    }
                    var dataConditions = $('#fileDate').attr('fileds');
                    var groupadeStr;
                    var groupadeAdd = $('#group_s').find("option:selected").attr('fields');
                    var groupadeASC = $('#groupSort').find("option:selected").val();
                    groupadeStr = groupadeAdd + groupadeASC;

                    var nameAtr = $('#FLOW_STATUS').attr('name');//工作流状态
                    var nameVal = $('#FLOW_STATUS').find("option:selected").val();//ALL
                    var atrVal = nameAtr + "\r\n" + nameVal;
                    var query_scope = $('#FLOW_QUERY_TYPE').attr('name');//查询范围
                    var query_s_a = $('#FLOW_QUERY_TYPE').find("option:selected").val();//ALL
                    var scope_ALL = query_scope + "\r\n" + query_s_a;
                    var date1 = $('#start_date').attr('name')//开始时间
                    var date_num1 = $('#start_date').val();
                    var dateVal = date1 + "\r\n" + date_num1;
                    var date2 = $('#end_date').attr('name');//结束时间
                    var date_num2 = $('#end_date').val();
                    var endVal = date2 + "\r\n" + date_num2;
                    var num_r = $('#runName').attr('name');//名称文号
                    var num_a = $('#runName').find("option:selected").val();//ALL
                    var numVal = num_r + "\r\n" + num_a;
                    var attment = $('#attment').attr('name');//公共附件名称

                    var work_f = atrVal + scope_ALL + dateVal + endVal + numVal;


                    var data = {
                        'viewFields': viewStr,
                        'tplName': $('#tempName').val(),
                        'flowId': flowIdFromPage,
                        'dataConditions': dataConditions,
                        'groupFields': groupadeStr,
                        'condFormula': $('#query_d').val(),
                        'flowConditions': work_f,
                        'dataXml': ''
                    };
                    $.ajax({
                        type: 'GET',
                        url: '<%=basePath%> / flowSetDatas//newFlowQuertTpl',
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
                },
            })


            workInit(0,[],[],[])

            $('.addbtn').click(function () {
                var fields = $('#file_p').find("option:selected").attr('fields');
                var text_d = $('#file_p').find("option:selected").text();
                var term = $('#term').find("option:selected").text();
                var numval = $('#numval').val();
                if (term == "等于") {
                    term = "=";
                } else if (term == "大于") {
                    term = ">";
                } else if (term == "小于") {
                    term = "<";
                } else if (term == "不等于") {
                    term = "<>";
                } else if (term == "大于等于") {
                    term = ">=";
                } else if (term == "小于等于") {
                    term = "<=";
                } else if (term == "开始为") {
                    term = "begin";
                } else if (term == "包含") {
                    term = "include";
                } else if (term == "结束为") {
                    term = "end";
                } else if (term == "为空") {
                    term = "null";
                }
                var html = '<tbody><tr><td style="text-align: center"></td style="text-align: center"><td id="fileDate" fileds="' + fields + term + numval + '">\'' + text_d + '\'' + term + '\'' + numval + '\'</td><td style="text-align: center">删除</td></tr></tbody>'

                $('#table_t').append(html)

            })
            /*弹窗控件*/
            $("#select_User").click(function () {
                user_id = 'textPut';
                $.popWindow("../common/selectUser");
            });

        }
        var termFh=["=",">","<","<>",">=","<=","begin","include","end","null"];
        var fromIdtwo = 17;
        //type 0 新建 1修改
        function workInit(type,select,equals,groupBF) {
            //存放处理后的数据
            var equalsCons=[];
            var equalsCon={};
            //先按，分割
          var arrayCon =  equals.split(',');
          //没有，号 证明是数据
          if(arrayCon.length==0){
              arrayCon.push(equals);
          }
          //遍历每一项
          for(var i=0;i<arrayCon.length;i++){
             var constr= arrayCon[i];
             //获取分割符号
             var splitStr;
             for(var j=0;j<termFh.length;j++){
                 if(constr.indexOf(termFh[j]) > 0 ){
                     splitStr=termFh[j];
                     break;
                 }
             }
             if(splitStr){
              var key_value = constr.split(splitStr);
              if(key_value.length!=2){
                  //数据有问题，自己处理下
                  console.log("数据问题");
              }else{
                  equalsCon["key"]=key_value[0];
                  equalsCon["value"]=key_value[1];
                  equalsCon["splitStr"]=splitStr;
                  equalsCons.push(equalsCon);
              }
             }
          }
            /*分组字段*/
            var reg = /(flow_data_1.DATA_19)(ASC|DESC)/;
            var regAry = groupBF.match(reg)
            var groupAry = [];
            var obj = {};
            obj["key"]=regAry[1];
            obj["value"]=regAry[2];
            groupAry.push(obj);
            console.log(groupAry)



            workForm.init({
                    formhtmlurl: '../../form/formType',
                    resdata: {
                        fromId: fromIdtwo
                    },
                    flag: 3
                },
                function (data) {
                    console.log(data);
                    var str = '';
                    var htmll = '';
                    var htmlr = '';
                    var groupStr = '';
                    var htmltd='';
                    for (var i = 0; i < data.length; i++) {
                        if(type==1){
                            if(groupAry.length!==0){
                                groupAry.forEach(function (item, index) {
                                    if(('flow_data_${flowId}.'+data[i].name)==item.key){
                                        groupStr += '<option fields="flow_data_${flowId}.' + data[i].name + '" value="' + data[i].title + '">' + data[i].title + '</option>'
                                        $('#groupsort option:selected').val(item.value)
                                    }

                                })



                            }
                            if(equalsCons.length!==0){
                                equalsCons.forEach(function (item, index) {
                                    if(('flow_data_${flowId}.'+data[i].name)==item.key){
                                            htmltd += '<tbody><tr><td style="text-align: center"></td style="text-align: center"><td id="fileDate" fileds="' + item.key + item.splitStr + item.value + '">\'' + data[i].title + '\'' + item.splitStr + '\'' +  item.value + '\'</td><td style="text-align: center">删除</td></tr></tbody>'
                                    }
                                })

                            }
                            if(select.length!=0){
                                    select.forEach(function (item, index) {
                                        if (('flow_data_${flowId}.' + data[i].name) == item) {
                                            htmlr += '<tr><td name="' + data[i].name + '" class="td_d" style="cursor: pointer">' + data[i].title + '</td></tr>';
                                        } else {
                                            htmll += '<tr><td name="' + data[i].name + '" class="td_d" style="cursor: pointer">' + data[i].title + '</td></tr>';
                                            str += '<option fields="flow_data_${flowId}.' + data[i].name + '" value="' + data[i].title + '">' + data[i].title + '</option>';
                                            groupStr += '<option fields="flow_data_${flowId}.' + data[i].name + '" value="' + data[i].title + '">' + data[i].title + '</option>'
                                        }

                                    })

                                }else{
                                    htmll += '<tr><td name="' + data[i].name + '" class="td_d" style="cursor: pointer">' + data[i].title + '</td></tr>';
                                    str += '<option fields="flow_data_${flowId}.' + data[i].name + '" value="' + data[i].title + '">' + data[i].title + '</option>';
                                    groupStr += '<option fields="flow_data_${flowId}.' + data[i].name + '" value="' + data[i].title + '">' + data[i].title + '</option>'
                                }
                        }else{
                            htmll += '<tr><td name="' + data[i].name + '" class="td_d" style="cursor: pointer">' + data[i].title + '</td></tr>';
                            str += '<option fields="flow_data_${flowId}.' + data[i].name + '" value="' + data[i].title + '">' + data[i].title + '</option>';
                            groupStr += '<option fields="flow_data_${flowId}.' + data[i].name + '" value="' + data[i].title + '">' + data[i].title + '</option>'
                        }


                    }
                    $('#data_th').html(htmll);
                    $('#file_p').html(str);
                    $('#group_s').html(groupStr);
                    $('#data_th_1').html(htmlr);
                    $('#table_t').append(htmltd);
                    $('.td_d').each(function (index, item) {
                        $(item).click(function () {
                            $(this).addClass('bg_d');
                            $(this).attr('able', true);
                        })
                    })
                    $('#btn_b1').on('click', function () {
                        var td = $(".td_d");
                        for (var i = 0; i < td.length; i++) {
                            var able = $(td[i]).attr("able");
                            if (able) {
                                $(td[i]).appendTo("#tr_td").removeClass();
                            }
                        }
//                $('.bg_d').each(function (index, item) {
//                    $(item).click(function () {
//                        $('#btn_b2').on('click', function () {
//                            $(item).appendTo('#data_th').removeClass().addClass('bg_d')
//                        })
//                    })
//                })
                    })
                });
        }

        $('.table').on('click', '.temp_n', function () {
            layerWin();
        });
        /*配置查询模板修改*/
        $('.table').on('click', '.updata_c', function () {
            var tplId = $('.one').attr('seqId');
            $.ajax({
                type: 'GET',
                url: '<%=basePath%>/flowSetDatas/queryFlowQuertTplById',
                dataType: 'json',
                data: {
                    'tplId': tplId
                },
                success: function (data) {
                    console.log(data)
                    if (data.flag) {
                        var data = data.data;
                        var dataview = data.viewExtFields;
                        dataview = dataview.split(',')
                        var viewAttr = dataview;
                        var dataCon = data.dataConditions;
                        var groupBF = data.groupByFields;
                        layer.open({
                            title: '<p style="background: #2b7fe0;height: 43px;width: 100%;font-size: 16px;padding-left: 15px;color: #fff">新建</p>',
                            shade: 0,
                            content: '<div class="cont_pop">' +
                            '<div class="con_flow clearfix">' +
                            '<div class="over_f">' +
                            '<p class="define_p flowtitle">模板基本信息</p>' +
                            '<form class="pro_flow "><div class="con_form">' + '<div class="form_group">' +
                            '<label for="projectName" class="flowName">模板名称</label>' +
                            '<input type="text" id="tempName">' + '</div></div></form>' +
                            '<p class="define_p flowtitle">流程过滤条件</p>' +
                            '<form class="pro_flow "><div class="con_form con_form_c">' +
                            '<div class="form_group">' + '<label for="deptName" class="flowName">工作流状态</label>' +
                            '<select name=" FLOW_STATUS" id="FLOW_STATUS" class="depName"><option value="ALL">所有</option><option value="1">已结束</option><option value="0">执行中</option>' +
                            '</select></div>' +
                            '<div class="form_group">' + '<label for="deptName" class="flowName">查询范围</label>' +
                            '<select name="FLOW_QUERY_TYPE" id="FLOW_QUERY_TYPE" class="depName"><option value="ALL">所有</option><option value="1">我发起的</option><option value="2">我经办的</option><option value="3">我管理的</option></select></div>' +
                            '<div class="form_group"><label for="deptName" class="flowName">流程开始日期范围 </label>' +
                            '<span>从</span><input type="text" class="put" id="start_date" name="PRCS_DATE1"><span>至</span><input type="text"class="put" id="end_date"><span>清空</span></div>' +
                            '<div class="form_group">' +
                            '<label for="deptName" class="flowName">名称/文号 </label><select name="PRCS_DATE1PRCS_DATE2PRCS_DATE3PRCS_DATE4BEGIN_USERBEGIN_NAMERUN_NAME" id="runName" class="depName"><option value="1">等于</option><option value="2">大于</option><option value="3">小于</option><option value="4">大于等于</option><option value="5">小于等于</option><option value="6">不等于</option><option value="7">开始为</option><option value="8" selected>包含</option><option value="9">结束为</option></select><input type="text"></div>' +
                            '<div class="form_group">' +
                            '<label for="deptName" class="flowName">公共附件名称 </label>' + '<select name="ATTACHMENT_NAME" id="attment" class="depName"><option value="1">等于</option><option value="2">小于</option><option value="2">大于</option><option value="2">不等于</option><option value="2">大于等于</option><option value="2">小于等于</option><option value="2">不等于</option><option value="2">开始为</option><option value="2">包含</option><option value="2">结束为</option></select><input type="text"></div>' +
                            '<div class="form_group">' +
                            '<label for="deptName" class="flowName">流程发起人</label>' +
                            '<textarea name="txt" id="textPut" user_id="admin" value="admin" disabled></textarea>' +
                            '<a style="margin-left: 10px;cursor: pointer" id="select_User">添加</a>' +
                            '<a style="margin-left: 10px;cursor: pointer">清空</a>' + '</div></div></form>' +
                            '<div class="jobName flowtitle">表单数据过滤条件</div>' +
                            '<form class="pro_flow flow_r"><div class="con_form"><div class="form_group"><label for="deptName" class="flowName">字段</label>' +
                            '<select name="" id="file_p" class="depName"></select></div>' +
                            '<div class="form_group"><label for="deptName" class="flowName">条件</label><select name="" id="term" class="depName"><option value="1">等于</option><option value="2">小于</option><option value="2">大于</option><option value="2">不等于</option><option value="2">大于等于</option><option value="2">小于等于</option><option value="2">不等于</option><option value="2">开始为</option><option value="2">包含</option><option value="2">结束为</option><option value="2">为空</option></select></br>' +
                            '<label for="deptName" class="flowName">值</label>' + '<input type="text" id="numval">' +
                            '<div><a href="javascript:;" class="addbtn">添加字段条件</a></div>' +
                            '<table class="table table_h" cellspacing="0" id="table_t">' + '<thead><tr>' +
                            '<th style="text-align: center">编号</th><th style="text-align: center">表单条件描述</th><th style="text-align: center">操作</th></tr></thead>' + '</table>' +
                            '<label for="deptName" class="flowName">表单条件公式</label><input type="text" id="query_d"></div></div></form>' +
                            '<div class="jobName flowtitle">统计报表选项</div>' +
                            '<form class="pro_flow flow_r"><div class="con_form"><div class="form_group"><label for="deptName" class="flowName">分组字段</label><select name="" id="group_s" class="depName">' +
                            '</select>' + '<select name="" id="groupSort" class="depName">' +
                            '<option value="ASC">升序</option><option value="DESC">降序</option></select></div><div class="plug_body form_group">' +
                            '<div class="plug_body_left"><div class="list_title">显示在待办列表上的字段</div><div class="list_infomation" id="next_step_div">' +
                            '<table cellspacing="0px" cellpadding="0px" width="100%" id="next_step_tab" class="next_step_tab"><tbody id="data_th"></tbody>' +
                            '</table></div><div style="margin-top:10px;"><button class="btn" id="left_btn" type="button" style="margin-left:100px;">全选</button></div></div>' + '<div class="plug_body_center"><div class="change_right"><button type="button" style="width: 20px;height: 20px" id="btn_b1"></button></div><div class="change_left"><button type="button" style="width: 20px;height: 20px" id="btn_b2"></button></div></div>' +

                            '<div class="plug_body_right"><div class="list_title">备选字段</div><div class="list_infomation" id="alternative_div">' +
                            '<table cellspacing="0px" cellpadding="0px" width="100%" id="alternative_tab">' + '<tbody id="data_th_1"></tbody></table>' + '</div>' +
                            '<div style="margin-top:10px;">' +
                            '<button class="btn" id="right_btn" type="button"  style="margin-left:100px;">全选</button></div></div></div>' +
                            '</div></form></div></div>' +
                            '</div>',
                            area: ['800px', '500px'],
                            btn: ['保存', '关闭'],
                            yes: function () {


                                var td = $("#data_th_1 td");
                                var viewStr = "";
                                for (var i = 0; i < td.length; i++) {
                                    var name = $(td[i]).attr("name");
                                    if (name) {
                                        viewStr += "flow_data_${flowId}." + name + ","
                                    }

                                }
                                var dataConditions = $('#fileDate').attr('fileds');
                                var groupadeStr;
                                var groupadeAdd = $('#group_s').find("option:selected").attr('fields');
                                var groupadeASC = $('#groupSort').find("option:selected").val();
                                groupadeStr = groupadeAdd + groupadeASC;

                                var nameAtr = $('#FLOW_STATUS').attr('name');//工作流状态
                                var nameVal = $('#FLOW_STATUS').find("option:selected").val();//ALL
                                var atrVal = nameAtr + "\r\n" + nameVal;
                                var query_scope = $('#FLOW_QUERY_TYPE').attr('name');//查询范围
                                var query_s_a = $('#FLOW_QUERY_TYPE').find("option:selected").val();//ALL
                                var scope_ALL = query_scope + "\r\n" + query_s_a;
                                var date1 = $('#start_date').attr('name')//开始时间
                                var date_num1 = $('#start_date').val();
                                var dateVal = date1 + "\r\n" + date_num1;
                                var date2 = $('#end_date').attr('name');//结束时间
                                var date_num2 = $('#end_date').val();
                                var endVal = date2 + "\r\n" + date_num2;
                                var num_r = $('#runName').attr('name');//名称文号
                                var num_a = $('#runName').find("option:selected").val();//ALL
                                var numVal = num_r + "\r\n" + num_a;
                                var attment = $('#attment').attr('name');//公共附件名称

                                var work_f = atrVal + scope_ALL + dateVal + endVal + numVal;


                                var data = {
                                    'viewFields': viewStr,
                                    'tplName': $('#tempName').val(),
                                    'flowId': flowIdFromPage,
                                    'dataConditions': dataConditions,
                                    'groupFields': groupadeStr,
                                    'condFormula': $('#query_d').val(),
                                    'flowConditions': work_f,
                                    'dataXml': ''

                                };
                                $.ajax({
                                    type: 'GET',
                                    url: '<%=basePath%>/flowSetDatas/updateFlowQuertTpl',
                                    dataType: 'json',
                                    data: data,
                                    success: function (data) {
                                        if (data.flag) {
                                            alert('修改成功');
                                        } else {
                                            alert('修改失败');
                                        }
                                    }
                                })
                            },
                        })
                        workInit(1,viewAttr,dataCon,groupBF);
                        $('#tempName').val(data.tplName);
                        $('#query_d').val(data.condFormula);

                    }
                }
            })

        })
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
