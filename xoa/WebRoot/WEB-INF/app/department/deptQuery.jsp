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
    <style>

    </style>
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

</body>
<script>
    $(function(){
        var departmentData =new Array();
        //部门接口
        function departmentAjax(){
            $.ajax({
                url:'/department/getAlldept',
                type:'get',
                dataType:'json',
                success:function(obj){
                    var data=obj.obj;
                    var  departmentData= digui(data,0);
                    var str_li='';
                    str_li=queryChild(data,str_li,0);
                    console.log(str_li)
                    $("#tableDapt").html(str_li);
                }
            });
        }


        departmentAjax();
        function digui(datas,departId) {
            var data=new Array();
            for(var i=0;i<datas.length;i++){
                if(datas[i].deptParent==departId){
                    datas[i]["childs"]=digui(datas,datas[i].deptId);
                    data.push(datas[i]);
                }
            }
            return data;
        }

        //表单分类递归
        function queryChild(datas,str_li,level){
            for(var i=0;i<datas.length;i++){
                var className="levelleft"+level;
                if(datas[i].deptName=='未定义'){
                    str_li += "<tr><td>"+datas[i].deptName+"</td>"+//部门名称
                        "<td>"+datas[i].manager +"</td>"+// 部门主管
                        "<td>"+datas[i].assistantId+"</td>"+// 部门助理
                        "<td>"+datas[i].leader1+"</td>"+// 主管领导
                        "<td>"+datas[i].leader2 +"</td>"+// 分管领导
                        "<td>"+datas[i].telNo +"</td>"+// 电话
                        "<td>"+datas[i].faxNo+"</td>"+// 传真
                        "<td>"+datas[i].deptAddress+"</td>"+// 地址
                        "<td>"+datas[i].deptFunc+"</td></tr>";//部门职能
                }else{
                    str_li += "<tr><td class='"+className+"' style='padding-left: "+level*10+"px'>"+datas[i].deptName+"</td>"+//部门名称
                        "<td>"+datas[i].manager +"</td>"+// 部门主管
                        "<td>"+datas[i].assistantId+"</td>"+// 部门助理
                        "<td>"+datas[i].leader1+"</td>"+// 主管领导
                        "<td>"+datas[i].leader2 +"</td>"+// 分管领导
                        "<td>"+datas[i].telNo +"</td>"+// 电话
                        "<td>"+datas[i].faxNo+"</td>"+// 传真
                        "<td>"+datas[i].deptAddress+"</td>"+// 地址
                        "<td>"+datas[i].deptFunc+"</td></tr>";//部门职能
                }
                /* console.log(datas[i].childs); */
                if(datas[i].childs!=null){
                    str_li = queryChild(datas[i].childs,str_li,level+1);

                }
            }
            return str_li;
        }//表单递归结束

    })

</script>


</html>
