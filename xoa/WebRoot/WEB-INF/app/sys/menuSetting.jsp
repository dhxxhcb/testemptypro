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
    <title>菜单设置</title>
    <link rel="stylesheet" type="text/css" href="css/menuSetting.css"/>
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
                        <tr>
                            <td width="55%"><span>01 个人事务</span></td>
                            <td width="44.5%">
                                <a href="javascript:;">编辑</a>
                                <a href="javascript:;">下一级</a>
                                <a href="javascript:;">删除</a>
                            </td>
                        </tr>
                        <tr>
                            <td><span>10 工作流</span></td>
                            <td>
                                <a href="javascript:;">编辑</a>
                                <a href="javascript:;">下一级</a>
                                <a href="javascript:;">删除</a>
                            </td>
                        </tr>
                        <tr>
                            <td><span>20 行政办公</span></td>
                            <td>
                                <a href="javascript:;">编辑</a>
                                <a href="javascript:;">下一级</a>
                                <a href="javascript:;">删除</a>
                            </td>
                        </tr>
                        <tr>
                            <td><span>30 知识管理</span></td>
                            <td>
                                <a href="javascript:;">编辑</a>
                                <a href="javascript:;">下一级</a>
                                <a href="javascript:;">删除</a>
                            </td>
                        </tr>
                        <tr>
                            <td><span>40 智能门户</span></td>
                            <td>
                                <a href="javascript:;">编辑</a>
                                <a href="javascript:;">下一级</a>
                                <a href="javascript:;">删除</a>
                            </td>
                        </tr>
                        <tr>
                            <td><span>45 管理中心</span></td>
                            <td>
                                <a href="javascript:;">编辑</a>
                                <a href="javascript:;">下一级</a>
                                <a href="javascript:;">删除</a>
                            </td>
                        </tr>
                    </table>
                </div>
                <div><span class="spanUP liUp">错误子菜单列表</span></div>
                <div><span class="spanUP liUp">菜单备份/恢复</span></div>
                <div><span class="spanUP liUp">菜单设置</span></div>
            </div>
        </div>
    </div>
    <div class="right">
        <div class="editClass">
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
                                <input type="button" class="inpuBtn" id="btn1" value="新建" />
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
                        <td width="40%"><span>01 电子邮件</span></td>
                        <td width="59.5%">
                            <a href="javascript:;">编辑</a>
                            <a href="javascript:;">删除</a>
                            <a href="javascript:;">添加权限</a>
                            <a href="javascript:;">删除权限</a>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%"><span>02 消息管理</span></td>
                        <td width="59.5%">
                            <a href="javascript:;">编辑</a>
                            <a href="javascript:;">删除</a>
                            <a href="javascript:;">添加权限</a>
                            <a href="javascript:;">删除权限</a>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%"><span>04 手机短信</span></td>
                        <td width="59.5%">
                            <a href="javascript:;">编辑</a>
                            <a href="javascript:;">删除</a>
                            <a href="javascript:;">添加权限</a>
                            <a href="javascript:;">删除权限</a>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%"><span>07 邮件审批</span></td>
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
        </div>
        <!--<div class="superPassword">
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
                        <td width="40%"><span>01 电子邮件</span></td>
                        <td width="59.5%">
                            <a href="javascript:;">编辑</a>
                            <a href="javascript:;">删除</a>
                            <a href="javascript:;">添加权限</a>
                            <a href="javascript:;">删除权限</a>
                        </td>
                    </tr>

                </table>
            </div>
        </div>-->
    </div>
</div>
</body>
</html>

