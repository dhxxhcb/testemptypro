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
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/sys/menuSetting.js" type="text/javascript" charset="utf-8"></script>
    <style>
        .trTextP p{margin-bottom: 15px;}
    </style>
</head>
<body>
<div class="content">
    <div class="left">
        <div class="header">
            <span class="divP">菜单主分类设置</span>
        </div>
        <div class="collect">
            <div id="incum" class="divUP">
                <span class="spanUP liUp" id="Addspan">增加菜单主分类</span>
                <div id="ulList">
                    <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">

                    </table>
                </div>
                <div><span class="spanUP liUp">错误子菜单列表</span></div>
                <div><span class="spanUP liUp">菜单备份/恢复</span></div>
                <div><span class="spanUP liUp">菜单设置</span></div>
            </div>
        </div>
    </div>
    <div class="right">
        <div class="addClass" style="display: block;">
            <div class="header">
                <span class="divP">增加菜单主分类</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff;width: 55%;">
                    <tr>
                        <td>主菜单分类代码：</td>
                        <td>
                            <input type="text" style="width: 80px;" name="id" class="inputTd" value="" />
                            <span>代码请尽量间隔开，2位数字</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">菜单名称：(简体中文)</td>
                        <td>
                            <input type="text" name="name" class="inputTd" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">菜单名称：(繁体中文)</td>
                        <td>
                            <input type="text" name="name1" class="inputTd" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">菜单名称：(English)</td>
                        <td>
                            <input type="text" name="name2" class="inputTd" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">菜单名称：(扩展一)</td>
                        <td>
                            <input type="text" name="name2" class="inputTd" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">菜单名称：(扩展二)</td>
                        <td>
                            <input type="text" name="name2" class="inputTd" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">菜单名称：(扩展三)</td>
                        <td>
                            <input type="text" name="name2" class="inputTd" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">图片名：</td>
                        <td>
                            <input type="text" name="img" class="inputTd" value=""/>
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
                            <input type="text" name="mainId" class="inputTd" value="01" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">菜单名称：(简体中文)：</td>
                        <td>
                            <input type="text" name="mainName" class="inputTd" value="个人事务"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">菜单名称：(繁体中文)</td>
                        <td>
                            <input type="text" name="mainName1" class="inputTd" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">菜单名称：(English)</td>
                        <td>
                            <input type="text" name="mainName2" class="inputTd" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">图片名：</td>
                        <td>
                            <input type="text" name="mainImg" class="inputTd" value="mytable"/>
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
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff;width: 50%">
                    <tr>
                        <td colspan="2">个人事务：</td>
                    </tr>
                    <tr class="childMenu">
                        <td colspan="2" class="blue_text">
                            <div class="childBtn">
                                <input type="button" name="childBtn" id="childBtn" value="增加子菜单项" />
                            </div>
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
        <%--<div class="superPassword" style="display: none">
            <div class="header">
                <span class="divP"> 输入超级密码</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff;width:60%;">
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
                            <div class="passBtn">
                                <input type="button" name="passBtn" id="passwSure" value="确定" />
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>--%><%--超级密码结束--%>
        <div class="AddChild" style="display:none;">
            <div class="header">
                <span class="divP"> 新建子菜单项</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff;width:75%;">
                    <tr>
                        <td width="25%">子菜单项ID：</td>
                        <td width="70%">
                            <input type="text" name="addfId" value="">
                            <p style="font-size: 12px;">说明：用户添加的菜单项ID务必大于1000，小于10000；1000以内及10000以上为系统保留</p>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">上级菜单：</td>
                        <td width="70%">
                            <select name="addParentId" id="menuTree" style="width: 204px;">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">子菜单项代码：</td>
                        <td width="70%">
                            <input type="text" name="addId" value="">
                            <p style="font-size: 12px;">说明：此代码为两位，作为排序之用。在同一父菜单下的平级菜单，该代码不能重复</p>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">子菜单名称：(简体中文)</td>
                        <td width="70%">
                            <input type="text" name="addName" value="">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">子菜单模块路径：</td>
                        <td width="70%">
                            <input type="text" name="addUrl" value="">
                            <input type="checkbox" name="check">
                            <span style="font-size: 12px;">在新窗口打开该菜单</span>
                        </td>
                    </tr>
                    <tr class="trTextP">
                        <td colspan="2">
                            <p style="font-size: 12px;font-weight: bold;">说明：子菜单模块路径定义方式，应根据此菜单项的类型决定:</p>
                            <p><span style="font-size: 12px;font-weight: bold;">类型一，此菜单下仍存在下级菜单：</span><span style="font-size: 12px;">则填写@英文名称，格式如：@mail，对应的图片是：OA安装目录/webroot/static/images/menu/@mail.gif，注意：请一定要以@开头</span></p>
                            <p><span style="font-size: 12px;font-weight: bold;">类型二，此菜单挂接OA系统中的模块：</span><span style="font-size: 12px;">则填写程序路径，格式如：email，则实际对应的路径是：OA安装目录/webroot/general/email，对应的图片是：OA安装目录/webroot/static/images/menu/email.gif</span></p>
                            <p><span style="font-size: 12px;font-weight: bold;">类型三，此菜单挂接外部的B/S结构的系统：</span><span style="font-size: 12px;">则填写该系统网址，格式如：http://TD_MYOA_WEB_SITE，注意：请一定要以http://开头</span></p>
                            <p><span style="font-size: 12px;font-weight: bold;">类型四，此菜单挂接外部的C/S结构或单机版系统：</span><span style="font-size: 12px;">则填写可执行文件路径，格式如：file://c:/abc.exe，注意：请一定要以file://开头，后面的程序路径用斜杠或反斜杠均可,对应的图片是：OA安装目录/webroot/static/images/menu/abc.gif </span></p>
                        </td>
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
        </div><%--新建子菜单结束--%>
        <div class="editChild" style="display:none;">
            <div class="header">
                <span class="divP"> 编辑子菜单项</span>
            </div>
            <div class="tab">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff;width:65%;">
                    <tr>
                        <td width="25%">子菜单项ID：</td>
                        <td width="70%">
                            <input type="text" name="editfId" value="">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">上级菜单：</td>
                        <td width="70%">
                            <select name="editParentId" id="menuTrees">

                            </select>
                            <span style="font-size: 12px;">在管理型模块中起约束作用</span>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">子菜单项代码：</td>
                        <td width="70%">
                            <input type="text" name="editId" value="">
                            <p style="font-size: 12px;">说明：此代码为两位，作为排序之用。在同一父菜单下的平级菜单，该代码不能重复</p>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">子菜单名称：(简体中文)</td>
                        <td width="70%">
                            <input type="text" name="editName" value="">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">子菜单模块路径：</td>
                        <td width="70%">
                            <input type="text" name="editUrl" value="">
                            <input type="checkbox" name="check">
                            <span style="font-size: 12px;">在新窗口打开该菜单</span>
                        </td>
                    </tr>
                    <tr class="trTextP">
                        <td colspan="2">
                            <p style="font-size: 12px;font-weight: bold;">说明：子菜单模块路径定义方式，应根据此菜单项的类型决定:</p>
                            <p><span style="font-size: 12px;font-weight: bold;">类型一，此菜单下仍存在下级菜单：</span><span style="font-size: 12px;">则填写@英文名称，格式如：@mail，对应的图片是：OA安装目录/webroot/static/images/menu/@mail.gif，注意：请一定要以@开头</span></p>
                            <p><span style="font-size: 12px;font-weight: bold;">类型二，此菜单挂接OA系统中的模块：</span><span style="font-size: 12px;">则填写程序路径，格式如：email，则实际对应的路径是：OA安装目录/webroot/general/email，对应的图片是：OA安装目录/webroot/static/images/menu/email.gif</span></p>
                            <p><span style="font-size: 12px;font-weight: bold;">类型三，此菜单挂接外部的B/S结构的系统：</span><span style="font-size: 12px;">则填写该系统网址，格式如：http://TD_MYOA_WEB_SITE，注意：请一定要以http://开头</span></p>
                            <p><span style="font-size: 12px;font-weight: bold;">类型四，此菜单挂接外部的C/S结构或单机版系统：</span><span style="font-size: 12px;">则填写可执行文件路径，格式如：file://c:/abc.exe，注意：请一定要以file://开头，后面的程序路径用斜杠或反斜杠均可,对应的图片是：OA安装目录/webroot/static/images/menu/abc.gif </span></p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="div_btn">
                                <input type="button" class="inpuBtn" id="edBtn_sure" value="确定" />
                                <input type="button" class="inpuBtn" id="edBtn_back" value="返回" />
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div> <%--编辑子菜单项结束--%>
        <div class="addJurisd" style="display: none">
            <div class="tab">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff;width:80%;">
                    <tr>
                        <th colspan="2" class="oneTd">添加菜单权限</th>
                    </tr>
                    <tr>
                        <td>已授权范围（角色）：</td>
                        <td id="PRIV"></td>
                    </tr>
                    <tr>
                        <td>添加授权范围（角色）：</td>
                        <td>
                            <div class="inPole">
                                <textarea name="txt" id="privDuser" user_id='admin' value="admin" disabled style="min-width: 300px;min-height:50px;"></textarea>
                                <span class="add_img" style="margin-left: 10px">
                                    <a href="javascript:;" id="selectPriv" class="Add ">添加</a>
                                </span>
                                        <span class="add_img">
                                    <a href="javascript:;" class="clearPriv">清除</a>
                                </span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>已授权范围（人员）：</td>
                        <td id="USER"></td>
                    </tr>
                    <tr>
                        <td>添加授权范围（人员）：</td>
                        <td>
                            <div class="inPole">
                                <textarea name="txt" id="senduser" user_id='admin' value="admin" disabled style="min-width: 300px;min-height:50px;"></textarea>
                                <span class="add_img" style="margin-left: 10px">
                                    <a href="javascript:;" id="selectUser" class="Add ">添加</a>
                                </span>
                                <span class="add_img">
                                    <a href="javascript:;" class="clearUser">清除</a>
                                </span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="div_btn">
                                <input type="button" class="inpuBtn" id="addBtn_sure" value="确定" />
                                <input type="button" class="inpuBtn" id="addBtn_back" value="返回" />
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>    <%--添加权限--%>
    </div>
</div>
<script type="text/javascript">
    var user_id='senduser';
    var priv_id='privDuser';
    $(function(){
        //$('#menuTree').deptSelect();
        selectMenu($('#menuTrees'));
        selectMenu($('#menuTree'));
        $("#selectUser").on("click",function(){
            user_id='senduser';
            $.popWindow("../common/selectUser");
        });
        $("#selectPriv").on("click",function(){
            priv_id='privDuser';
            $.popWindow("../common/selectPriv");
        });
        $('.clearPriv').click(function(){
            $('#privDuser').val('');
        })
        $('.clearUser').click(function(){
            $('#senduser').val('');
        })
    })
    function selectMenu(element){
        $.ajax({
            type:'get',
            url:'../../showMenu',
            dataType:'json',
            success:function(rsp){
                var data=rsp.obj;
                var str='';
                for(var i=0;i<data.length;i++){
                    if(data[i].child.length>0){
                        for(var j=0;j<data[i].child.length;j++){
                            str+='<option value="'+data[i].id+'">'+data[i].name+'</option><option value="'+data[i].child[j].id+'">&nbsp'+data[i].child[j].name+'</option>';
                        }
                    }else{
                        str+='<option value="'+data[i].id+'">'+data[i].name+'</option>';
                    }
                }
                element.append(str);
            }
        })
    }
</script>
</body>
</html>

