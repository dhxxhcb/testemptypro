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
    <link rel="stylesheet" type="text/css" href="../../lib/ueditor/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/dept/deptManagement.css"/>
    <link rel="stylesheet" type="text/css" href="../../lib/easyui/themes/easyui.css"/>
   <link rel="stylesheet" type="text/css" href="../../lib/easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/news/center.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/dept/new_news.css"/>
   <script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script src="../lib/laydate.js"></script>
  <%-- <script type="text/javascript" src="../lib/easyui/jquery.easyui.min.js"></script>--%>
   <%-- <script type="text/javascript" src="../lib/easyui/tree.js"></script>--%>
   <%-- <script type="text/javascript" src="../js/index.js"></script>--%>
  <%--  <script src="../lib/layer/layer.js"></script>--%>
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
            width: 355px;
            margin-top: 8px;
            float: right !important;;
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
            width: 207px;
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
<body style="overflow:scroll;overflow-y: auto;overflow-x:hidden;">
<%--新建部门--%>
<div class="step1" style="display: block;margin-left: 10px;">
    <!-- 中间部分 -->
    <table class="newNews">
        <div class="nav_box clearfix">
            <div class="nav_t1"><img src="../../img/sys/new_dept.png"></div>
            <div class="nav_t2" class="news">新建部门/成员单位-当前节点：[北京公司]</div>
            <div class="head_rig" id="head_rig">
                <h1 style='cursor:pointer;' class="new_dept" onclick="newDept()" >新建部门/成员单位</h1>
                <h1 style='cursor:pointer;' class="import">导入</h1>
                <h1 style='cursor:pointer;' class="export">导出</h1>
            </div>
        </div>

        <tbody>
        <tr>
            <td class="td_w blue_text">
                部门排序号:
            </td>
            <td>
                <input class="td_title1" type="text" placeholder="" id="deptNo"/>
                <div class="tit"> 3位数字，用于同一级次部门排序，不能重复</div>

            </td>
        </tr>
        <tr>
            <td class="td_w blue_text">
                部门名称:
            </td>
            <td>
                <input class="td_title1" id="deptName" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="td_w blue_text">
                上级部门:
            </td>
            <td>
                <select name="DEPT_PARENT" class="BigSelect" id="deptParent">
                    <option value="0">无</option>
                    <option value="1">├中国兵器工业信息中心</option>
                    <option value="3">│└北京通达信科科技有限公司</option>
                    <option value="17">│　└总经理</option>
                    <option value="4">│　　├综合管理部</option>
                    <option value="18">│　　│├人力资源部</option>
                    <option value="19">│　　│├财务部</option>
                    <option value="20">│　　│└行政部</option>
                    <option value="5">│　　├市场营销部</option>
                    <option value="39">│　　│├市场部</option>
                    <option value="33">│　　││├品牌部</option>
                    <option value="31">│　　││├网络营销中心</option>
                    <option value="32">│　　││└商务中心</option>
                    <option value="40">│　　│└销售部</option>
                    <option value="7">│　　│　├北京销售部</option>
                    <option value="28">│　　│　│├销售一组</option>
                    <option value="29">│　　│　│├销售二组</option>
                    <option value="30">│　　│　│├销售三组</option>
                    <option value="27">│　　│　│└销售协作组</option>
                    <option value="8">│　　│　└上海销售部</option>
                    <option value="6">│　　├研发部</option>
                    <option value="34">│　　│├产品部</option>
                    <option value="9">│　　│├开发一部</option>
                    <option value="10">│　　│├开发二部</option>
                    <option value="11">│　　│├质量保证部</option>
                    <option value="15">│　　│└设计部</option>
                    <option value="41">│　　├项目部</option>
                    <option value="42">│　　│├项目一部</option>
                    <option value="43">│　　│└项目二部</option>
                    <option value="16">│　　└生产部</option>
                    <option value="38">│　　　├采购部</option>
                    <option value="35">│　　　├生产一部</option>
                    <option value="37">│　　　├生产二部</option>
                    <option value="36">│　　　└质检部</option>
                    <option value="2">└北方测试研究公司</option>
                    <option value="14">　└北一测试研究院</option>
                </select>

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
                <input class="td_title1 time_coumon" id="telNo" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="blue_text">
                传真 :
            </td>
            <td>
                <input class="td_title1 time_coumon" id="faxNo" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="blue_text">
                地址 :
            </td>
            <td>
                <input class="td_title1 time_coumon" id="deptAddress" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="blue_text">
                部门职责 :
            </td>
            <td>
                <textarea name="" cols="60" rows="5" id="deptFunc"></textarea>

            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="button" class="new_but" id="new">新建</button>
            </td>
        </tr>

        </tbody>
    </table>
</div>

<%--编辑部门--%>
<div class="step2" style="display: none;margin-left: 10px;">
    <!-- 中间部分 -->
    <table class="newNews">
        <div class="nav_box clearfix">
            <div class="nav_t1"><img src="../../img/sys/new_dept.png"></div>
            <div class="nav_t2" class="news">编辑部门/成员单位-当前节点：[北京公司]</div>
            <div class="head_rig" id="head_rig_">
                <h1 style='cursor:pointer;' class="new_dept" onclick="newDept()" >新建部门/成员单位</h1>
                <h1 style='cursor:pointer;' class="import">导入</h1>
                <h1 style='cursor:pointer;' class="export">导出</h1>
            </div>
        </div>

        <tbody>
        <tr>
            <td class="td_w blue_text">
                部门排序号:
            </td>
            <td>
                <input class="td_title1" type="text" placeholder="" id="deptNo_"/>
                <div class="tit"> 3位数字，用于同一级次部门排序，不能重复</div>

            </td>
        </tr>
        <tr>
            <td class="td_w blue_text">
                部门名称:
            </td>
            <td>
                <input class="td_title1" id="deptName_" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="td_w blue_text">
                上级部门:
            </td>
            <td>
                <select name="DEPT_PARENT" class="BigSelect" id="deptParent_">
                    <option value="0">无</option>
                    <option value="1">├中国兵器工业信息中心</option>
                    <option value="3">│└北京通达信科科技有限公司</option>
                    <option value="17">│　└总经理</option>
                    <option value="4">│　　├综合管理部</option>
                    <option value="18">│　　│├人力资源部</option>
                    <option value="19">│　　│├财务部</option>
                    <option value="20">│　　│└行政部</option>
                    <option value="5">│　　├市场营销部</option>
                    <option value="39">│　　│├市场部</option>
                    <option value="33">│　　││├品牌部</option>
                    <option value="31">│　　││├网络营销中心</option>
                    <option value="32">│　　││└商务中心</option>
                    <option value="40">│　　│└销售部</option>
                    <option value="7">│　　│　├北京销售部</option>
                    <option value="28">│　　│　│├销售一组</option>
                    <option value="29">│　　│　│├销售二组</option>
                    <option value="30">│　　│　│├销售三组</option>
                    <option value="27">│　　│　│└销售协作组</option>
                    <option value="8">│　　│　└上海销售部</option>
                    <option value="6">│　　├研发部</option>
                    <option value="34">│　　│├产品部</option>
                    <option value="9">│　　│├开发一部</option>
                    <option value="10">│　　│├开发二部</option>
                    <option value="11">│　　│├质量保证部</option>
                    <option value="15">│　　│└设计部</option>
                    <option value="41">│　　├项目部</option>
                    <option value="42">│　　│├项目一部</option>
                    <option value="43">│　　│└项目二部</option>
                    <option value="16">│　　└生产部</option>
                    <option value="38">│　　　├采购部</option>
                    <option value="35">│　　　├生产一部</option>
                    <option value="37">│　　　├生产二部</option>
                    <option value="36">│　　　└质检部</option>
                    <option value="2">└北方测试研究公司</option>
                    <option value="14">　└北一测试研究院</option>
                </select>

            </td>
        </tr>
        <tr>
            <td class="blue_text">部门主管（选填）:</td>
            <td>
                <input class="td_title1  release1" id="manager_" type="text"/>
                <%-- <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                <div class="release3">添加</div>
                <div class="release4 empty">清空</div>

            </td>
        </tr>
        <tr>
            <td class="blue_text">部门助理（选填）:</td>
            <td>
                <input class="td_title1  release1" id="assistantId_" type="text"/>
                <%-- <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                <div class="release3">添加</div>
                <div class="release4 empty" onclick="empty('query_privId')">清空</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">上级主管领导（选填）:</td>
            <td>
                <input class="td_title1  release1" id="leader1_" dataid="" type="text"/>
                <%--  <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                <div class="release3" id="query_adduser_">添加</div>
                <div class="release4 empty" onclick="empty('query_userId')">清空</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">上级分管领导（选填）:</td>
            <td>
                <input class="td_title1  release1" id="leader2_" dataid="" type="text"/>
                <%--  <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                <div class="release3" id="query_adduser_">添加</div>
                <div class="release4 empty" onclick="empty('query_userId')">清空</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                电话 :
            </td>
            <td>
                <input class="td_title1 time_coumon" id="telNo_" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="blue_text">
                传真 :
            </td>
            <td>
                <input class="td_title1 time_coumon" id="faxNo_" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="blue_text">
                地址 :
            </td>
            <td>
                <input class="td_title1 time_coumon" id="deptAddress_" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="blue_text">
                部门职责 :
            </td>
            <td>
                <textarea name="" cols="60" rows="5" id="deptFunc_"></textarea>

            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="button" class="new_but" id="new_">保存修改</button>
                <span id="dapaId_" style="display: none"></span>
            </td>
        </tr>

        </tbody>
    </table>
</div>


</body>

<script>
    $(function(){
        // 添加部门的
        $("#new").on("click",function(){
            alert(1111);
            var data = {
                "deptName": $("#deptName").html(),    // 部门名称
                "telNo": $("#telNo").val(),      //电话
                "faxNo":$("#faxNo").val(),  //传真
                "deptAddress": $("#deptAddress").val(),// 部门地址
                "deptNo":   $("#deptNo").val(),//  部门排序号
                "deptParent":  $('#deptParent option:checked').attr('value'),//上级部门ID
                "isOrg": "", //是否是分支机构(0-否,1-是)
                "orgAdmin":"",//机构管理员
                "deptEmailAuditsIds":"", //保密邮件审核人
                "weixinDeptId":"",  // null
                "dingdingDeptId":"",//叮叮对应部门id
                "gDept":'',// 是否全局部门(0-否,1-是)
                "manager":' ',//部门主管
                "assistantId":"",//部门助理
                "leader1":"",//上级主管领导
                "leader2":'',//上级分管领导
                "deptFunc":$("#deptFunc").val(),//部门职能
                "avatar": "",    // 头像
                " userName": "",      // 用户名字
                "uid":"",  // 用户uid
                "userPrivName": "",// 用户角色名字
                "type":  "" ,//   返回类型
            };
            /*  console.log(data); */
            if(data.deptParent==0){
                alert("上级部门不能为空!");
                return false;
            }else{
                $.ajax({
                    url:"<%=basePath%>../department/addDept",
                    type:'post',
                    dataType:"JSON",
                    data : data,
                    success:function(data){
                        console.log(data);

                    },
                    error:function(e){
                        console.log(e);
                    }
                });
            }
        });









    })




</script>

</html>
