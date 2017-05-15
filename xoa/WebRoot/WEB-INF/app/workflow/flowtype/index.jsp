<%--
  Created by IntelliJ IDEA.
  User: 王曰岐
  Date: 2017/5/11
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
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
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <link rel="stylesheet" type="text/css" href="../../css/workflow/index.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/easyui/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/easyui/icon.css"/>
    <script type="text/javascript" src="../../js/jquery-1.9.1.js" ></script>
    <script type="text/javascript" src="../../js/easyui/jquery.easyui.min.js" ></script>
    <script type="text/javascript" src="../../js/easyui/tree.js" ></script>
    <script type="text/javascript" src="../js/index.js" ></script>
    <title>s首页</title>
</head>
<body>

<div class="wrap">
    <div class="head">
        <div class="head_left"><h1>流程设计</h1></div>
        <div class="head_mid">
            <input class="inp" type="text" placeholder="输入表名称搜索">
            <div class="search"><h1>搜索</h1></div>
        </div>
        <div class="head_rig"><h1>新建</h1></div>
    </div>

    <div class="cont">
        <div class="cont_left">
            <div class="left_all">
                <h1 class="sort">流程分类</h1>
                <div class="ul_all" id="li_parent">
                    <%--<li><img src="/../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                </div>
            </div>

        </div>

        <div class="cont_rig">
            <div class="rig_every"></div>
            <div class="rig_every"></div>
            <div class="rig_every"></div>
            <div class="rig_every"></div>
            <div class="rig_every"></div>
            <div class="rig_every"></div>
        </div>





    </div>



    <div class="footer">

    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
       //获取左侧分类
        $('#li_parent').tree({
            url: '/workflow/flowclassify/flowJsTree',
            loadFilter: function(rows){
                console.log(rows);
                return convert(rows.datas);
            }
        });

        function convert(rows){
            function exists(rows, parentId){
                for(var i=0; i<rows.length; i++){
                    if (rows[i].sortId == parentId) return true;
                }
                return false;
            }
            var nodes = [];
            // get the top level nodes
            for(var i=0; i<rows.length; i++){
                var row = rows[i];
                if (!exists(rows, row.sortParent)){
                    nodes.push({
                        id:row.sortId,
                        text:row.sortName
                    });
                }
            }
            var toDo = [];
            for(var i=0; i<nodes.length; i++){
                toDo.push(nodes[i]);
            }
            while(toDo.length){
                var node = toDo.shift();	// the parent node
                // get the children nodes
                for(var i=0; i<rows.length; i++){
                    var row = rows[i];
                    if (row.sortParent == node.id){
                        var child = {id:row.sortId,text:row.sortName};
                        if (node.children){
                            node.children.push(child);
                        } else {
                            node.children = [child];
                        }
                        toDo.push(child);
                    }
                }
            }
            return nodes;
        }

//        $.post("/workflow/flowclassify/flowJsTree",{} ,function (ret) {
//              console.log(ret);
//              if(ret.flag==true){
//
//
////                  var str_li="";
////                  console.log(ret.datas)
////                  str_li=  queryChild(ret.datas,str_li,0);
////                  console.log(str_li)
////                  $("#li_parent").html(str_li);
////                  $("#li_parent ul li").hide();
////                  $(".show").click(function(event)
////                  {
////                      event.stopPropagation();
////                  var level=    $(this).attr("level");
////                      console.log(level);
////                      if($(this).find(".show").attr("showable")=="true"){
////                          if(level==0){
////                              $(this).find(".show").hide();
////                              $(this).find(".show").attr("showable",false);
////                          }
////                      }else{
////                          $(this).find(".show").show();
////                          $(this).find(".show").attr("showable",true);
////                      }
////                  });
//              }
//        },"json");

//        //表单分类递归
//        function queryChild(datas,str_li,level){
//            for(var i=0;i<datas.length;i++){
//                var className=datas[i].sortId+level;
//                str_li+='<li class="show" level="'+level+'" showable="false"><img src="/../img/workflow/wenjian.png"><h1>'+datas[i].sortName+'</h1>' +
//                         '<ul id="'+className+'" class="hideOrToggle">'  ;
//                if(datas[i].childs!=null){
//                    console.log($("#"+className));
//                    str_li = queryChild(datas[i].childs,str_li,level+1);
//                }
//                str_li += '</ul></li>';
//            }
//            return str_li;
//        }//表单递归结束



    })
</script>

</html>
