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
    <tbody id="tableDapt">

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
                success: function (data) {
                    var news = "";
                    for (var i = 0; i < data.obj.length; i++) {
                        news += "<tr><td>"+data.obj[i].deptName+"</td>"+//部门名称
                            "<td>"+data.obj[i].manager +"</td>"+// 部门主管
                            "<td>"+data.obj[i].assistantId+"</td>"+// 部门助理
                            "<td>"+data.obj[i].leader1+"</td>"+// 主管领导
                            "<td>"+data.obj[i].leader2 +"</td>"+// 分管领导
                            "<td>"+data.obj[i].telNo +"</td>"+// 电话
                            "<td>"+data.obj[i].faxNo+"</td>"+// 传真
                            "<td>"+data.obj[i].deptAddress+"</td>"+// 地址
                            "<td>"+data.obj[i].deptFunc+"</td></tr>";//部门职能
                    }
                    $("#tableDapt").html(news);
                }
            });


    })

</script>


</html>
