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
    <title>用户信息查询</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/sys/userInfor.css"/>
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/sys/userInfor.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="content">
    <div class="headDiv">
        <p class="divP">用户信息查询</p>
    </div>
    <div class="left">
        <div class="collect">
            <div id="incum" class="divUP">
                <span class="spanUP liUp AUP">在职人员</span>
                <ul id="ULDown" style="display:none;">

                </ul>
            </div>
            <div><span class="spanUP liUp" id="OUTP">外出人员</span></div>
            <div><span class="spanUP liUp" id="ALLP">全部人员</span></div>
            <div><span class="spanUP liUp" id="QUERY">人员查询</span></div>
        </div>
    </div>
    <div class="right">
        <div class="queryUser" style="display: block;">
            <div class="title">
                <span>查询用户</span>
            </div>
            <table class="table" cellspacing="0" cellpadding="0" style="border-collapse:collapse;background-color: #fff">
                <tr>
                    <td class="blue_text">用户名：</td>
                    <td>
                        <input type="text" name="userId" class="inputTd"/>
                    </td>
                </tr>
                <tr>
                    <td class="blue_text">真实姓名：</td>
                    <td>
                        <input type="text" name="userName" class="inputTd"/>
                    </td>
                </tr>
                <tr>
                    <td class="blue_text">性别：</td>
                    <td>
                        <select name="sex">
                            <option value=""></option>
                            <option value="0">男</option>
                            <option value="1">女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="blue_text">部门：</td>
                    <td>
                        <select name="unit" id="department">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="blue_text">角色：</td>
                    <td>
                        <select name="user" id="selectUser">
                        </select>
                    </td>
                </tr>

                <tr>
                    <td colspan="2">
                        <div class="btn">
                            <input id="submit" type="button" value="查询"/>
                            <input id="export" type="button" value="导出"/>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div class="outPerson" style="display: none;">
            <div class="title">
                <span>外出人员</span>
            </div>
            <div class="tab" style="display: none;">
                <table cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
                    <tr class='tr_befor'>
                        <th width="">部门</th>
                        <th width="">角色</th>
                        <th width="">姓名</th>
                        <th width="">在线时长</th>
                        <th width="">性别</th>
                        <th width="">工作电话</th>
                        <th width="">手机</th>
                        <th width="">电子邮件</th>
                    </tr>
                </table>
            </div>
            <div class="noData" style="display: block;">
                <div class="bgImg">
                    <div class="IMG">
                        <img src="../img/sys/icon64_info.png"/>
                    </div>
                    <div class="TXT">无外出人员</div>
                </div>
            </div>
        </div>
        <div class="allPerson" style="display: none;">
            <div class="title">
                <span>全部人员</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
                    <tr class='trAllPerson'>
                        <th width="">部门</th>
                        <th width="">角色</th>
                        <th width="">姓名</th>
                        <th width="">在线时长</th>
                        <th width="">性别</th>
                        <th width="">工作电话</th>
                        <th width="">手机</th>
                        <th width="">电子邮件</th>
                    </tr>
                </table>
            </div>
        </div>
        <div class="userQuery" style="display: none;">
            <div class="title">
                <span>用户查询</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
                    <tr class='tr_befor'>
                        <th width="">部门</th>
                        <th width="">角色</th>
                        <th width="">姓名</th>
                        <th width="">在线时长</th>
                        <th width="">性别</th>
                        <th width="">工作电话</th>
                        <th width="">手机</th>
                        <th width="">电子邮件</th>
                    </tr>
                </table>
            </div>
        </div>
        <div class="conditionQuery" style="display: none;">
            <div class="title">
                <span>用户查询</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
                    <tr class='Condition'>
                        <th width="">部门</th>
                        <th width="">角色</th>
                        <th width="">姓名</th>
                        <th width="">在线时长</th>
                        <th width="">性别</th>
                        <th width="">工作电话</th>
                        <th width="">手机</th>
                        <th width="">电子邮件</th>
                    </tr>
                </table>
                <div class="backBtn">返回</div>
            </div>
        </div>
        <div class="childQuery" style="display: none;">
            <div class="title">
                <span>用户查询</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
                    <tr class='allCondition'>
                        <th width="">部门</th>
                        <th width="">姓名</th>
                        <th width="">角色</th>
                        <th width="">辅助角色</th>
                        <th width="">在线时长</th>
                        <th width="">性别</th>
                        <th width="">单位电话</th>
                        <th width="">部门电话</th>
                        <th width="">手机</th>
                        <th width="">电子邮件</th>
                    </tr>
                </table>
               <%-- <div class="backBtn">返回</div>--%>
            </div>
        </div>
    </div>
</div>
<script>
    $(function(){
        $('#department').deptSelect();
        $('#selectUser').privSelect();
    })
</script>
</body>
</html>

