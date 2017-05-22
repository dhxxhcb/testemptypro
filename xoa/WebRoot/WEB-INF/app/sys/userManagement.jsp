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
    <meta charset="UTF-8">
    <title>用户管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/sys/userManagement.css"/>
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="content">
    <div class="headDiv">
        <p class="divP">用户管理-管理范围（全体）</p>
    </div>
    <div class="left">
        <div class="collect">

            <ul>
                <li class="liUp">在职人员</li>
                <li class="liUp">离职人员/外部人员</li>
                <li class="liUp">最近新增用户</li>
                <li class="liUp">用户查询或导出</li>
                <li class="liUp">用户导入</li>
                <li class="liUp">批量用户个性设置</li>
                <li class="liUp">提醒空密码用户</li>
                <li class="liUp">导出RTX格式</li>
                <li class="liUp">退出用户客户端登录</li>
            </ul>
        </div>
    </div>
    <div class="right">
        <div class="header">
            <span class="USER">新建用户</span><span class="post">（总经理）</span>
            <input type="button" name="btn" id="btn" value="新建用户" />
        </div>
        <div class="title">
            <span class="USER">新建用户</span><span class="post">（总经理）</span>
            <select name="allUser">
                <option value="01">所有用户</option>
                <option value="02">允许登录用户</option>
                <option value="03">禁止登录用户</option>
            </select>
            <span class="explain">说明：密码为空用户显示为红色,禁止登录用户显示为灰色</span>
        </div>
        <div class="tab">
            <table cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
                <tr class='tr_befor'>
                    <th width="6%">
                        <input type="checkbox" name="checkbox" id="checkbox" value="" style="width:13px;height:13px;" />
                    </th>
                    <th width="6%">用户名</th>
                    <th width="8%">真实姓名</th>
                    <th width="6%">部门</th>
                    <th width="6%">排班</th>
                    <th width="6%">角色</th>
                    <th width="8%">管理范围</th>
                    <th width="28%">最后访问</th>
                    <th width="16%">闲置</th>
                    <th width="10%">操作</th>
                </tr>

            </table>
        </div>
        <div class="bottom w">
            <div class="checkALL">
                <input id="checkedAll" type="checkbox" name="" value="" >
                <label for="checkedAll" style="font-size: 14px;">全选</label>

            </div>
            <div class="boto">
                <a class="ONE" href="javascript:;"><span>删除</span></a>
            </div>
            <div class="boto">
                <a class="TWO" href="javascript:;"><span>清空在线时长</span></a>
            </div>
            <div class="boto">
                <a class="THREE" href="javascript:;"><span>清空密码</span></a>
            </div>
            <div class="boto">
                <a class="FOUR" href="javascript:;"><span>禁止登录</span></a>
            </div>
            <div class="boto">
                <a class="FIVE" href="javascript:;"><span>提醒空密码用户</span></a>
            </div>
            <div class="boto">
                <a class="FIVE" href="javascript:;"><span>批量调换部门</span></a>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        /*$('.collect ul li').click(function () {

         })*/
        $('#btn').click(function(){
            $.popWindow('addUsers','<fmt:message code="global.lang.reply" />','0','0','1500px','800px');
        })
    })
</script>
</body>
</html>
