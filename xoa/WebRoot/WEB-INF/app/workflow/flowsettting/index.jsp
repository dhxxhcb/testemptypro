<%--
  Created by IntelliJ IDEA.
  User: 王曰岐
  Date: 2017/5/20
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <li>
            <a href="javascript:void(0)" class="btn_click btn_h btn"><img src="../../img/workflow/flowsetting/icon_workprocess_03.png" alt="">流程主页</a>

        </li>
        <li class="list1">
            <a href="javascript:void(0)" class="btn_click btn_h btn1"><img src="../../img/workflow/flowsetting/icon_workprocess_03.png" alt="">设计流程<i class="icon_d"></i></a>
            <ul class="hide_list1 hide">
                <li><a href="javascript:void(0)" class="btn_h"><i class="icon"></i>定义流程属性</a>
                </li>
                <li><a href="javascript:void(0)" class="btn_h"><i class="icon"></i>设计流程步骤</a>
                </li>
                <li><a href="javascript:void(0)" class="btn_h"><i class="icon"></i>预览表单</a>
                </li>
                <li><a href="javascript:void(0)" class="btn_h"><i class="icon"></i>导入</a></li>
            </ul>
        </li>
        <li>
            <a href="javascript:void(0)" class="btn_click btn_h btn2">
                <img src="../../img/workflow/flowsetting/icon_authoritymanagement_03.png" alt="">管理权限</a>
        </li>
        <li><a href="javascript:void(0)" class="btn_click btn_h btn3"><img src="../../img/workflow/flowsetting/icon_timedtask_03.png" alt="">定时任务</a>
        </li>
        <li><a href="javascript:void(0)" class="btn_click btn_h btn4"><img src="../../img/workflow/flowsetting/icon_searchtemplate_03.png" alt="">配置查询模板</a>
        </li>
        <li><a href="javascript:void(0)" class="btn_click btn_h btn5"><img src="../../img/workflow/flowsetting/icon_layoutfiles_03.png" alt="">应用版式文件</a>
        </li>
        <li><a href="javascript:void(0)" class="btn_click btn_h btn6"><img src="../../img/workflow/flowsetting/icon_others_03.png" alt="">其他 <i class="icon_d"></i></a></li>
    </ul >

    <div class="cont_r">
       <%--管理权限表格--%>
        <table class="table" cellspacing="0">
            <caption>
                <a href="javascript:void (0)">新建</a>
                <a href="javascript:void (0)">删除</a>
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
                <td class="sector" >所有部门</td>
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
      <%--定义流程属性--%>
           <div class="con_flow">
               <div class="define_r clearfix">
                   <h3>定义流程属性</h3>
                   <span><a href="javascript:void(0)">保存</a></span>
               </div>
               <p>基本属性</p>
               <form class="pro_flow">
                   <div class="con_form">
                       <div class="form_group">
                           <label for="projectName" class="flowName">流程名称 <span class="save">*</span></label>
                           <input type="text" id="projectName" placeholder="请假申请">
                       </div>
                       <div class="form_group">
                           <label for="orderID" class="flowName">流程排序号 <span class="save">*</span></label>
                           <input type="text" id="orderID">
                       </div>
                       <div class="form_group">
                           <label for="deptName" class="flowName">所属部门 <span class="save">*</span></label>
                           <input type="text" id="deptName">
                           <select  id="sel_dpt">
                               <option value="">系统</option>
                               <option value="">系统</option>
                               <option value="">系统</option>
                           </select>
                       </div>
                   </div>
               </form>
           </div>


    </div>

</div>

</body>
<script src="../../js/jquery-1.10.2/jquery.min.js"></script>

<script type="text/javascript">
    $(function () {
        $('.btn1').click(function (event) {
            $('.hide_list1').toggle();
            event.stopPropagation();
        });
        $('.btn2').click(function (event) {
            $('.table').show();
            event.stopPropagation();

        });

        $('#checkAll').on('click',function () {
            $('.one').prop('checked',$(this).prop('checked'));
        });
        $('.one').click(function () {
            $('#checkAll').prop('checked',$('.one').length==$('.one:checked').length?true:false);
        })

















    })


</script>

</html>
