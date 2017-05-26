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
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <title>菜单设置</title>
    <link rel="stylesheet" type="text/css" href="../css/sys/menuSetting.css"/>
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/sys/menuSetting.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="content">
    <div class="left">
        <div class="header">
            <span class="divP">菜单主分类设置</span>
        </div>
        <div class="collect">
            <div id="incum" class="divUP">
                <span class="spanUP liUp">增加菜单主分类</span>
                <div id="ulList">
                    <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                        <%--<tr>
                            <td width="55%"><span class="margspan">01</span><span>个人事务</span></td>
                            <td width="44.5%">
                                <a href="javascript:;">编辑</a>
                                <a href="javascript:;">下一级</a>
                                <a href="javascript:;">删除</a>
                            </td>
                        </tr>--%>
                    </table>
                </div>
                <div><span class="spanUP liUp">错误子菜单列表</span></div>
                <div><span class="spanUP liUp">菜单备份/恢复</span></div>
                <div><span class="spanUP liUp">菜单设置</span></div>
            </div>
        </div>
    </div>
    <div class="right">
        <div class="addClass">
            <div class="header">
                <span class="divP">增加菜单主分类</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td>主菜单分类代码：</td>
                        <td>
                            <input type="text" style="width: 80px;" name="unitName" class="inputTd" value="" />
                            <span>代码请尽量间隔开，2位数字</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">菜单名称：(简体中文)：</td>
                        <td>
                            <input type="text" name="telNo" class="inputTd" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">图片名：</td>
                        <td>
                            <input type="text" name="faxNo" class="inputTd" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="div_btn">
                                <input type="button" class="inpuBtn" id="addBtn" value="确定" />
                                <input type="button" class="inpuBtn" id="backBtn" value="返回" />
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div><%--增加菜单主分类--%>
        <div class="editClass" style="display:none;">
            <div class="header">
                <span class="divP">编辑菜单主分类</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td>主菜单分类代码：</td>
                        <td>
                            <input type="text" name="unitName" class="inputTd" value="01" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">菜单名称：(简体中文)：</td>
                        <td>
                            <input type="text" name="telNo" class="inputTd" value="个人事务"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">图片名：</td>
                        <td>
                            <input type="text" name="faxNo" class="inputTd" value="mytable"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="div_btn">
                                <input type="button" class="inpuBtn" id="btn1" value="确定" />
                                <input type="button" class="inpuBtn" id="btn2" value="返回" />
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="monoidalSet" style="display:none;">
            <div class="header">
                <span class="divP"> 子菜单项设置</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td colspan="2">个人事务：</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="blue_text">
                            <div class="childBtn">
                                <input type="button" name="childBtn" id="childBtn" value="增加子菜单项" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%"><span class="margspan">01</span><span>电子邮件</span></td>
                        <td width="59.5%">
                            <a href="javascript:;">编辑</a>
                            <a href="javascript:;">删除</a>
                            <a href="javascript:;">添加权限</a>
                            <a href="javascript:;">删除权限</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="blue_text">
                            <div class="childrenBtn">
                                <input type="button" name="childrenBtn" id="childrenBtn" value="返回" />
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div><%--子菜单项设置--%>
        <div class="superPassword" style="display: none">
            <div class="header">
                <span class="divP"> 输入超级密码</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td colspan="2">说明：第一次进入时密码为空，可在“系统管理-组织机构设置-角色与权限管理”中找到“超级密码设置”</td>
                    </tr>
                    <tr>
                        <td width="35%">请输入超级密码：</td>
                        <td width="63%">
                            <input type="text" name="userId" value="">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="blue_text">
                            <div class="childBtn">
                                <input type="button" name="childBtn" id="passwSure" value="确定" />
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div><%--超级密码结束--%>
        <div class="editChild" style="display:none;">
            <div class="header">
                <span class="divP"> 编辑子菜单项</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff;width:65%;">
                    <tr>
                        <td width="25%">子菜单项ID：</td>
                        <td width="70%">
                            <input type="text" name="userId" value="">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">上级菜单：</td>
                        <td width="70%">
                            <select name="postPriv">
                                <option value="01">本部门</option>
                                <option value="02">全体</option>
                                <option value="03">指定部门</option>
                            </select>
                            <span>在管理型模块中起约束作用</span>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">子菜单项代码：</td>
                        <td width="70%">
                            <input type="text" name="userId" value="">
                            <p>说明：此代码为两位，作为排序之用。在同一父菜单下的平级菜单，该代码不能重复</p>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">子菜单名称：(简体中文)</td>
                        <td width="70%">
                            <input type="text" name="userId" value="">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">子菜单模块路径：</td>
                        <td width="70%">
                            <input type="text" name="userId" value="">
                            <input type="checkbox" name="check">
                            <span>在新窗口打开该菜单</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="div_btn">
                                <input type="button" class="inpuBtn" id="btn_sure" value="确定" />
                                <input type="button" class="inpuBtn" id="btn_back" value="返回" />
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div> <%--编辑子菜单项结束--%>
    </div>
</div>
</body>
</html>

