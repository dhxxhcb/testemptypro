<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>部门信息查询</title>
    <link rel="stylesheet" type="text/css" href="../css/base.css"/>
    <link rel="stylesheet" type="text/css" href="../css/news/new_news.css"/>
    <link rel="stylesheet" type="text/css" href="../css/dept/deptQuery.css"/>
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
<div class="headDept clearfix">
    <img src="../img/la2.png">
    <div class="">
        部门/成员单位查询
    </div>
</div>
<!--content部分开始-->

<table id="tr_td">
    <thead>
    <tr>
        <td class="th">部门/成员单位</td>
        <td class="th">部门主管</td>
        <td class="th">部门助理</td>
        <td class="th">主管领导</td>
        <td class="th">分管领导</td>
        <td class="th">电话</td>
        <td class="th">传真</td>
        <td class="th">地址</td>
        <td class="th">职能</td>
    </tr>
    </thead>
    <tbody id="j_tb">
    <tr class="">
        <td>1</td>
        <td class="">系统管理员</td>
        <td class="">公司动态</td>
        <td>管理部</td>
        <td>
            <div>提供一个ebXML框架</div>
        </td>
        <td class="">2017-05-12 18:11:46</td>
        <td class="">53</td>
        <td class="">119</td>
        <td>1</td>
    </tr>
    <tr class="">
        <td>1</td>
        <td class="">系统管理员</td>
        <td class="">公司动态</td>
        <td>管理部</td>
        <td>
            <div>提供一个ebXML框架</div>
        </td>
        <td class="">2017-05-12 18:11:46</td>
        <td class="">53</td>
        <td class="">119</td>
        <td>1</td>
    </tr>
    <tr class="">
        <td>1</td>
        <td class="">系统管理员</td>
        <td class="">公司动态</td>
        <td>管理部</td>
        <td>
            <div>提供一个ebXML框架</div>
        </td>
        <td class="">2017-05-12 18:11:46</td>
        <td class="">53</td>
        <td class="">119</td>
        <td>1</td>
    </tr>
    <tr>
        <td>中国兵器工业信息中心</td>
        <td>系统管理员</td>
        <td>公司动态</td>
        <td>管理部</td>
        <td></td>
        <td></td>
        <td></td>
        <td>北京市海淀区车道沟10号</td>
        <td style="padding:5px;width:10%;">
            中国兵器工业信息中心隶属于中国兵器工业集团公司，从事高新技术研究开发的事业单位。中心经过十几年的建设和开拓发展，在信息技术领域中拥有一支实力雄厚的专业技术队伍。拥有近100个地面站构成的卫星通信系统、由16个子系统组成的集团公司计算机网络管理信息系统和集团公司Internet网站以及计算机、通信设施等近千万元的固定资产。中心愿以先进的技术手段在IT技术开发、卫星通信及其它通信工程、网络技术、信息系统的集成、软件开发和Internet技术等领域为社会各界提供服务。愿与同行及广大用户广泛合作，满怀信心在新世纪共创新的辉煌。
        </td>
    </tr>
    <div id="dept_id">5555555555555</div>

    </tbody>
</table>
<!--content部分结束-->


</body>
<script>
//    $(function () {
//        var opt_li_dep = '<option value="0"  class="levelleft0">所有部门</option>';
//        departmentAjax(function (departmentData) {
//            opt_li_dep = departmentChild(departmentData, opt_li_dep, 0, deptId);
//            $('#dept_id').html(opt_li_dep);
//        });
//        //部门遍历方法
//
//        function departmentChild(datas, opt_li, level, dept) {
//            for (var i = 0; i < datas.length; i++) {
//                var String = "";
//                var space = ""
//                for (var j = 0; j < level; j++) {
//                    space += "├&nbsp;&nbsp;&nbsp;";
//                }
//                /* console.log("kongge"+space+"kongge")*/
//                if (i == 0) {
//                    String = space + "┌";
//                } else if (i != 0) {
//                    String = space + "├";
//                } else if (i == datas.length - 1) {
//                    String = space + "└";
//                }
//                if (dept == datas[i].deptId) {
//                    opt_li += String + datas[i].deptName;
//                } else {
//                    opt_li +=String + datas[i].deptName;
//                }
//                /* 	console.log(datas[i].childs);*/
//                if (datas[i].childs != null) {
//                    opt_li = departmentChild(datas[i].childs, opt_li, level + 1, dept);
//                }
//            }
//            return opt_li;
//        }
//
//        //部门接口
//        function departmentAjax(callback) {
//            $.ajax({
//                url: '../../department/getAlldept',
//                type: 'get',
//                dataType: 'json',
//                success: function (obj) {
//                    var data = obj.obj;
//                    var departmentData = digui(data, 0);
//                    callback(departmentData);
//                }
//            });
//        }
//
//        function digui(datas, departId) {
//            var data = new Array();
//            for (var i = 0; i < datas.length; i++) {
//                if (datas[i].deptParent == departId) {
//                    datas[i]["childs"] = digui(datas, datas[i].deptId);
//                    data.push(datas[i]);
//                }
//            }
//            return data;
//        }
//
//
//    })

    $(function(){
        $.ajax({
                url: '../../department/getAlldept',
                type: 'get',
                dataType: 'json',
                success: function (obj) {












                }
            });


    })

</script>


</html>
