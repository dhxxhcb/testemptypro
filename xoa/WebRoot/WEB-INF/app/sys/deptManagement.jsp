<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <link rel="stylesheet" type="text/css" href="../lib/ueditor/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../css/dept/deptManagement.css"/>
    <link rel="stylesheet" type="text/css" href="../lib/easyui/themes/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../lib/easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="../css/base.css"/>
    <link rel="stylesheet" type="text/css" href="../css/news/center.css"/>
    <link rel="stylesheet" type="text/css" href="../css/dept/new_news.css"/>
    <script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
    <script src="../lib/laydate.js"></script>
    <script type="text/javascript" src="../lib/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../lib/easyui/tree.js"></script>
    <script type="text/javascript" src="../js/index.js"></script>
    <script src="../lib/layer/layer.js"></script>
    <title>s首页</title>
    <style>
        .noDatas {
            margin-top: 10px;
        }

        .noDatas_pic {
            margin-top: 20%;
        }

        .noData_out {
            margin: 0 auto;
            text-align: center;
        }

        .foot_span_show {
            float: right;
            color: white;
            line-height: 28px;
            margin-right: 15px;
            cursor: pointer
        }

        .head_rig h1 {
            width: 78px;
            height: 30px;
            font-size: 13px !important;
            background-image: url(../img/workflow/btn_new_nor_03.png), url(../img/workflow/icon_plus_03.png);
            cursor: pointer;
            background-repeat: no-repeat;
        }

        #cont_left::-webkit-scrollbar {
            width: 10px;
        }

        #cont_left::-webkit-scrollbar-corner {
            background: #82AFFF;
        }

        .head_rig {
            width: 25%;
            margin-top: 0px;
            float: right;
        }
        .head_rig h1 {
            float: left;
            margin-right:20px;
        }

        .inp {
            height: 24px;
        }

        .search {
            width: 72px;
            height: 29px;
            margin-top: 16px;
            background: #fff;
        }

        .search h1 {
            text-align: center;
            color: #fff;
            font-size: 14px;
            line-height: 28px;
            background-image: url(../img/workflow/btn_check_nor_03.png);
            background-repeat: no-repeat;
        }

        .cont {
            width: 102%;
            height: 95%;
            overflow-y: scroll;
        }

        .head {
            border-bottom: 1px solid #9E9E9E;
            height: 44px;
        }

        .cont_rig {
            overflow-y: scroll;
            width: 84%;
            height: 95%;
        }

        .new_excell_pic {
            border-radius: 0;
            border: none;
            width: 73px;
            height: 73px;
            margin: 10px 24px 10px 20px;
        }

        .head_rig h1 :hover {
            cursor: pointer;
        }

        .deldel {
            color: #fff;
            font-size: 12px;
            float: right;
            margin-right: 10px;
            margin-left: 5px;
            line-height: 28px;
            cursor: pointer;
        }

        .footer_span_space {
            color: #fff;
            font-size: 12px;
            float: right;
            margin-right: 10px;
            line-height: 28px;
            cursor: pointer;
        }

        .foot_span_show {
            margin-left: 9px;
        }

        .edit {
            color: #fff;
            font-size: 12px;
            float: right;
            margin-right: 10px;
            margin-left: 5px;
            line-height: 28px;
            cursor: pointer;
        }

        .search h1 :hover {
            cursor: pointer;
        }

        .deldel_img {
            float: right;
            height: 15px;
            margin-top: 7px;
        }

        .edit_img {
            float: right;
            height: 15px;
            margin-top: 7px;
        }

        .deldel_yulan {
            float: right;
            height: 15px;
            margin-top: 7px;
            margin-right: 0px;
            cursor: pointer;
            margin-left: -4px;
        }

        .new_excell_footer {
            width: 100%;
            height: 28px;
            position: relative;
            background-color: #59bdf0;
        }

        .new_excell_head {
            position: relative;
            width: 100%;
            height: 30px;
        }

        .new_excell_name {
            border-left: 4px solid #59bdf0;
            color: #59bdf0;
            position: absolute;
            bottom: 0;
            font-size: 16px;
            font-weight: 700;
            height: 24px;
            margin-left: 20px;
        }

        .new_excell_info {
            width: 100%;
            height: 123px;
            position: relative;
        }

        .new_excell_center {
            margin-left: 6%;
            margin-top: 10px;
        }

        .new_excell_info_main {
            width: 100%;
            height: 62px;
            position: absolute;

        }

        .new_excell_info_other {
            position: absolute;
            top: 10px;
            height: 100%;
            margin-left: 45px;
            margin-top: 10px;
            list-style-type: none;
            left: 20%;
        }

        .new_excell_main {
            width: 332px;
            height: 181px;
            border: 1px solid #ddd;
            margin: auto;
            margin-top: 10px;
            border-radius: 5px;
        }

        .new_excell_main:hover {
            border: 2px solid #59bdf0;
        }

        .new_excell_info_mian_pic {
            float: left;
        }

        .new_excell {
            width: 360px;
            height: 191px;
            float: left;
            margin-left: 0px;
            margin-right: 0px;
        }

        .new_excell_info_other span {
            margin-left: 10px;
            color: black;
        }

        .new_excell_info_other li {
            height: 50%;
            line-height: 24px;
            font-size: 20px;
        }

        user agent stylesheet
        li {
            display: list-item;
            text-align: -webkit-match-parent;
        }

        .conter {
            width: 461px;
            height: 800px;
            margin: auto;
        }

        .f_field_title {
            display: inline-block;
            font-size: 12px;
            font-weight: bold;
            height: 18px;
            line-height: 41px;
            margin-left: 2px;
            margin-right: 2px;
        }

        .f_field_required {
            color: red;
            font-size: 12px;
            margin-top: 0px;
            margin-left: 2px;
            margin-right: 2px;
        }

        .f_field_ctrl {
            margin-top: 5px;
            margin-left: 2px;
            float: left;
        }

        select {

            height: 32px;
            width: 220px;
            border-radius: 4px;
            border: 1px solid #cccccc;
            background-color: #ffffff;
        }

        .f_field_title {
            font-size: 12px;
            font-weight: bold;
            margin-left: 2px;
            margin-right: 2px;
        }

        .f_field_required {
            color: red;
            font-size: 12px;
            margin-top: 0px;
            margin-left: 2px;
            margin-right: 2px;
        }

        .f_field_ctrl {
            margin-top: 5px;
            margin-left: 2px;
        }

        .f_field_ctrl input {
            color: #000;
        }

        .f_field_block {
            width: 100%;
            height: 68px;
            margin-top: 70px;
            margin-bottom: 4px;
            display: block;
            text-align: left;
        }

        .inp {
            width: 221px;
            height: 32px;
            border-radius: 4px;
        }

        /*	#layui-layer2{
                border-radius:10px;
            }*/
        .center {
            height: 400px !important;
        }

        .delete_flow, .edit_liucheng {
            cursor: pointer;
        }

        /*<img src="img/workflow/one.png">*/
        /*.img{
            width:20px;
            height:20px;
            background: red;
        }
            .img,.sort{
                    float:left;
                }*/
        .layui-layer-title {
            padding: 0 80px 0 20px;
            height: 42px;
            line-height: 42px;
            border-bottom: 1px solid #eee;
            font-size: 16px;
            color: #fff;
            overflow: hidden;
            background-color: #2b7fe0;
            border-radius: 2px 2px 0 0;
        }

        .layui-layer-page .layui-layer-btn {
            padding-top: 10px;
            text-align: center;
        }

        .cont_left {
            width: 15%;
            height: 95%;
            border-right: 1px solid #000;
            overflow-y: scroll;
        }
    </style>
</head>
<body>

<div class="wrap" style="margin-left:0px !important;">
    <div class="head">
        <div class="head_left">
            <img src="../img/newsManages2_1.png" alt="">
            <h1>部门/成员单位管理</h1>
        </div>
       <%-- <div class="head_mid">
            <input id="form_value" class="inp" type="text" placeholder="输入表名称搜索">
            <div id="btn_search" class="search">
                <h1 style='cursor:pointer;'>搜索</h1></div>
        </div>--%>
        <div class="head_rig" id="head_rig">
            <h1 style='cursor:pointer;'>新建</h1>
            <h1 style='cursor:pointer;'>新建</h1>
            <h1 style='cursor:pointer;'>新建</h1>


        </div>


    </div>

    <div class="cont">
        <div class="cont_left" id="cont_left">
            <div class="left_all">
                <ul>
                    <li class="lis">
                        部门列表

                        <ul class="tab_ctwo a" id="deptOrg" style="display:block;">
                            <!-- <li>

                            </li> -->
                            123456

                        </ul>
                    </li>
                    <li>部门批量设置</li>
                    <li>公共自定义组</li>
                    <li>修正部门级别</li>
                </ul>


            </div>

        </div>

        <div class="cont_rig">
            <!-- 部门右侧页面 -->
           <%-- <iframe src="<%=basePath%>" width="100%" height="100%"> ceshi</iframe>--%>


            <div class="step2" style="display: block;margin-left: 10px;">
                <!-- 中间部分 -->
                <table class="newNews">
                    <div class="nav_box clearfix">
                        <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
                        <div class="nav_t2" class="news">新建部门/成员单位-当前节点：[北京高速波软件有限公司]</div>
                    </div>
                    <tbody>
                    <tr>
                        <td class="td_w blue_text">
                            部门排序号:
                        </td>
                        <td>
                            <input class="td_title1" id="" type="text" placeholder=""/>
                            <div> 3位数字，用于同一级次部门排序，不能重复</div>

                        </td>
                    </tr>
                    <tr>
                        <td class="td_w blue_text">
                            部门名称:
                        </td>
                        <td>
                            <input class="td_title1" id="" type="text" placeholder=""/>

                        </td>
                    </tr>
                    <tr>
                        <td class="td_w blue_text">
                            上级部门:
                        </td>
                        <td>
                            <input class="td_title1" id="" type="text" placeholder=""/>

                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">部门主管（选填）:</td>
                        <td>
                            <input class="td_title1  release1" id="query_toId" type="text"/>
                            <%-- <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                            <div class="release3">添加</div>
                            <div class="release4 empty">清空</div>

                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">部门助理（选填）:</td>
                        <td>
                            <input class="td_title1  release1" id="query_privId" type="text"/>
                            <%-- <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                            <div class="release3">添加</div>
                            <div class="release4 empty" onclick="empty('query_privId')">清空</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">上级主管领导（选填）:</td>
                        <td>
                            <input class="td_title1  release1" id="query_userId" dataid="" type="text"/>
                            <%--  <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                            <div class="release3" id="query_adduser">添加</div>
                            <div class="release4 empty" onclick="empty('query_userId')">清空</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">上级分管领导（选填）:</td>
                        <td>
                            <input class="td_title1  release1" id="query_userId" dataid="" type="text"/>
                            <%--  <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                            <div class="release3" id="query_adduser">添加</div>
                            <div class="release4 empty" onclick="empty('query_userId')">清空</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">
                            电话 :
                        </td>
                        <td>
                            <input class="td_title1 time_coumon" id="" type="text" placeholder=""/>

                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">
                            传真 :
                        </td>
                        <td>
                            <input class="td_title1 time_coumon" id="" type="text" placeholder=""/>

                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">
                            地址 :
                        </td>
                        <td>
                            <input class="td_title1 time_coumon" id="" type="text" placeholder=""/>

                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">
                            部门职责 :
                        </td>
                        <td>
                            <textarea name="" cols="60" rows="5"></textarea>

                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div style="border:1px solid #dedede;height:30px;width:50px;">新建</div>
                        </td>
                    </tr>

                    </tbody>
                </table>
            </div>























        </div>
    </div>
</div>
</body>
<script
        type="text/javascript">
    $(function () {
        //部门列表
        $('.left_all .tab_ctwo').on('click', '.childdept', function () {
            var that = $(this);

            getChDept(that.next(), that.attr('deptid'));
        });
        function getChDept(target, deptId) {
            $.ajax({
                url: '../department/getChDept',
                type: 'get',
                data: {
                    deptId: deptId
                },
                dataType: 'json',
                success: function (data) {
                    /* if() */
                    if (deptId == 30) {
                        var str = '';
                        data.obj.forEach(function (v, i) {
                            if (v.deptName) {
                                str += '<li><span deptid="' + v.deptId + '" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span></span><img src="../img/main_img/company_logo.png" alt=""><a href="#" class="dynatree-title" title="' + v.deptName + '">' + v.deptName + '</a></span><ul style="margin-left:10%;"></ul></li>';
                            } else {


                                str += '<li><span deptid="' + v.deptId + '" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span><img src="../img/main_img/man.png" alt=""></span><img src="img/main_img/man.png" alt=""><a href="#" class="dynatree-title" title="' + v.userName + '">' + v.userName + '</a></span><ul style="margin-left:10%;"></ul></li>';


                            }

                        });
                    } else {
                        var str = '';
                        data.obj.forEach(function (v, i) {
                            if (v.deptName) {
                                str += '<li><span deptid="' + v.deptId + '" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span class=""></span><a href="#" class="dynatree-title" title="' + v.deptName + '">' + v.deptName + '</a></span><ul style="margin-left:10%;"></ul></li>';
                            } else {
                                if (v.sex == 0) {

                                    str += '<li><span deptid="' + v.deptId + '" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span></span><img src="../img/main_img/man.png" alt=""><a href="#" class="dynatree-title" title="' + v.userName + '">' + v.userName + '</a></span><ul style="margin-left:10%;"></ul></li>';
                                } else if (v.sex == 1) {
                                    str += '<li><span deptid="' + v.deptId + '" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span></span><img src="../img/main_img/women.png" alt=""><a href="#" class="dynatree-title" title="' + v.userName + '">' + v.userName + '</a></span><ul style="margin-left:10%;"></ul></li>';
                                }


                            }

                        });
                    }

                    target.html(str);
                }
            })
        }

        getChDept($('#deptOrg'), 20);


    });


</script>

</html>
