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
   <%-- <link rel="stylesheet" type="text/css" href="../css/dept/new_news.css"/>--%>
    <script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
    <script src="../lib/laydate.js"></script>
    <script type="text/javascript" src="../lib/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../lib/easyui/tree.js"></script>
    <script type="text/javascript" src="../js/index.js"></script>
    <script src="../lib/layer/layer.js"></script>
    <title>s首页</title>
    <style>
        html,
        body,
        .wrap{
            width:100%;
            height:100%;
           /* overflow: hidden;*/
        }
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
        .head_rig  .import {
            width: 56px;
            height: 30px;
            font-size: 13px !important;
            cursor: pointer;
            background-repeat: no-repeat;
            background-image: url(../img/sys/import.png);
            padding-left: 25px;
        }
        .head_rig  .export {
            width: 56px;
            height: 30px;
            font-size: 13px !important;
            cursor: pointer;
            background-repeat: no-repeat;
            background-image: url(../img/sys/export.png);
            padding-left: 25px;
        }
        .head_rig .new_dept {
            width: 130px;
            height: 30px;
            font-size: 13px !important;
            background-image:url(../img/sys/dept_personnel.png);
            cursor: pointer;
            background-repeat: no-repeat;
            color: #fff;
        }

        #cont_left::-webkit-scrollbar {
            width: 0px;
        }

        #cont_left::-webkit-scrollbar-corner {
            /*background: #82AFFF;*/
        }

        .head_rig {
            width: 29%;
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
            border-bottom: 1px solid #dedede;
            height: 42px;
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


        .center {
            height: 400px !important;
        }

        .delete_flow, .edit_liucheng {
            cursor: pointer;
        }

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
    </style>
</head>
<body style="overflow:scroll;overflow-y: hidden;overflow-x:hidden;">

<div class="wrap" style="margin-left:0px !important;">
    <div class="head">
        <div class="head_left">
            <img src="../img/sys/dept.png" alt="">
            <h1>部门/成员单位管理</h1>
        </div>
    </div>

    <div class="cont">
        <div class="cont_left" id="cont_left">
            <ul>
                <li class="liUp dept_li" id="dept_lis">部门列表</li>
                <li class="pick" style="display: none;">
                    <ul class="tab_ctwo a" id="deptOrg">
                        <!-- <li>

                        </li> -->
                    </ul>
                </li>
                <li class="liUp dept_li">离职人员/外部人员</li>
                <li class="liUp dept_li">公共自定义组</li>
                <li class="liUp dept_li">修正部门级别</li>

            </ul>
        </div>

        <div class="cont_rig">
            <!-- 部门右侧页面 -->
           <%-- <iframe src="<%=basePath%>department/newDeptManagement/" width="100%" height="100%"></iframe>--%>
          <%--  <%@ include file="new_deptManagement.jsp" %>--%>
            <jsp:include page="new_deptManagement.jsp"/>

        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    //新建部门/成员单位按钮
    function newDept(){

//        $("#telNo").val("ceshi");
//        alert("ceshi");
        $(".step1").show();
        $(".step2").hide();
    };

    $(function () {
        /*左侧点击事件显示隐藏*/
        $("#dept_lis").on('click', function () {

            if ($(this).siblings('.pick').css('display') == 'none') {
                $(this).siblings('.pick').show();
                $(this).addClass("liDown").removeClass("liUp");
            } else {
                $(this).siblings('.pick').hide();
                $(this).addClass("liUp").removeClass("liDown");
            }
        });
        //部门列表
        $('.cont_left .tab_ctwo').on('click', '.childdept', function () {
            var that = $(this);
            getChDept(that.next(), that.attr('deptid')); //调用左侧部门接口


            var deptid=that.attr('deptid');
            $('.childdept').removeClass('on');
            that.addClass('on')
            that.next().toggle();  //显示和隐藏左侧部门列表的切换效果

            deptById(deptid); //调编辑详情的接口


        });
        function getChDept(target, deptId) {
            $.ajax({
                url: '../department/getChDeptfq',
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
                                str += '<li><span  deptid="' + v.deptId + '" class="childdept"><span></span><img src="../img/main_img/company_logo.png" alt=""><a href="#" class="dynatree-title" title="' + v.deptName + '">' + v.deptName + '</a></span><ul style="margin-left:10%;display:none;"></ul></li>';
                            } else {
                                str += '<li><span deptid="' + v.deptId + '" class="childdept"><span><img src="../img/main_img/man.png" alt=""></span><img src="img/main_img/man.png" alt=""><a href="#" class="dynatree-title" title="' + v.userName + '">' + v.userName + '</a></span><ul style="margin-left:10%;display:none;"></ul></li>';
                            }
                        });
                    } else {
                        var str = '';
                        data.obj.forEach(function (v, i) {
                            if (v.deptName) {
                                str += '<li><span deptid="' + v.deptId + '" class="childdept"><span class=""></span><a href="#" class="dynatree-title" title="' + v.deptName + '">' + v.deptName + '</a></span><ul style="margin-left:10%;display:none;"></ul></li>';
                            } else {
//                                if (v.sex == 0) {
//
//                                    str += '<li><span deptid="' + v.deptId + '" class="childdept"><span></span><img src="../img/main_img/man.png" alt=""><a href="#" class="dynatree-title" title="' + v.userName + '">' + v.userName + '</a></span><ul style="margin-left:10%;"></ul></li>';
//                                } else if (v.sex == 1) {
//                                    str += '<li><span deptid="' + v.deptId + '" class="childdept"><span></span><img src="../img/main_img/women.png" alt=""><a href="#" class="dynatree-title" title="' + v.userName + '">' + v.userName + '</a></span><ul style="margin-left:10%;"></ul></li>';
//                                }
                            }
                        });
                    }
                    target.html(str);
                }
            })
        }
        getChDept($('#deptOrg'),20); //根据地区，北京集团

        //编辑部门 详情
        function deptById(id){

            $.ajax({
                url:'../department/getDeptById',
                type:'get',
                dataType:'json',
                data:{'deptId':id},
                success:function(data){
                    $(".step1").hide();
                    $(".step2").show();
                    $("#deptNo_").val(data.object.deptNo); // 部门排序号
                    $("#deptName_").val(data.object.deptName); // 部门名称
                    $("#deptParent_").val(data.object.deptParent); // 上级部门ID

                    $("#query_toId_").val(data.object.manager); //部门主管
                    $("#query_Satrap_").val(data.object.assistantId); // 部门助理
                    $("#query_UpAssistant_").val(data.object.leader1); // 上级主管领导
                    $("#query_UpSatrap_").val(data.object.leader2); // 上级分管领导
                    $("#telNo_").val(data.object.telNo); // 电话
                    $("#faxNo_").val(data.object.faxNo); // 传真
                    $("#deptAddress_").val(data.object.deptAddress); // 地址
                    $("#deptFunc_").val(data.object.deptFunc); // 部门职责
                    $("#dapaId_").html(data.object.deptId);
                }
            })
        }
    // 编辑的保存修改按钮
        $("#new_").on("click",function(){
//            alert($("#dapaId_").html());
            var data = {
                'deptId':$("#dapaId_").html(),
                "deptName": $("#deptName_").val(),    // 部门名称
                "telNo": $("#telNo_").val(),      //电话
                "faxNo":$("#faxNo_").val(),  //传真
                "deptAddress": $("#deptAddress_").val(),// 部门地址
                // "deptParent":  $('#deptParent_ option:checked').attr('value'),上级部门ID
                "isOrg": "", //是否是分支机构(0-否,1-是)
                "orgAdmin":"",//机构管理员
                "deptEmailAuditsIds":"", //保密邮件审核人
                "weixinDeptId":"",  // null
                "dingdingDeptId":"",//叮叮对应部门id
                "gDept":'',// 是否全局部门(0-否,1-是)
                "manager": $("#query_toId_").attr("dataid"),//部门主管
                "assistantId": $("#query_Satrap_").attr("dataid"),//部门助理
                "leader1": $("#query_UpAssistant_").attr("dataid"),//上级主管领导
                "leader2": $("#query_UpSatrap_").attr("dataid"),//上级分管领导
                "deptFunc":$("#deptFunc_").val(),//部门职能
                "avatar": "",    // 头像
                " userName": "",      // 用户名字
                "uid":"",  // 用户uid
                "userPrivName": "",// 用户角色名字
                "type":  "" ,//   返回类型
            };
            /*  console.log(data); */
                $.ajax({
                    url:"<%=basePath%>../department/editDept",
                    type:'post',
                    dataType:"JSON",
                    data : data,
                    success:function(data){
                        location.reload();
                        console.log(data);
                        alert("修改成功！");
                    },
                    error:function(e){
                        console.log(e);
                    }
                });

        });







    });


</script>

</html>
