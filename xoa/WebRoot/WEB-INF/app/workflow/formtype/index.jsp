<%--
  Created by IntelliJ IDEA.
  User: 王曰岐
  Date: 2017/5/11
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" type="text/css" href="../../lib/easyui/themes/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../../lib/easyui/themes/icon.css"/>
    <script type="text/javascript" src="../../js/jquery-1.9.1.js" ></script>
    <script type="text/javascript" src="../../lib/easyui/jquery.easyui.min.js" ></script>
    <script type="text/javascript" src="../../lib/easyui/tree.js" ></script>
    <script type="text/javascript" src="../js/index.js" ></script>
    <title>s首页</title>
	 <style>
        .new_excell_pic{
            border-radius: 0;border: none; width: 75px;height: 75px;margin-top: -7px;
        }
        .deldel{
            color: #fff;font-size: 12px;float: right;margin-right: 10px;margin-left: 10px;line-height: 28px;cursor: pointer;
        }
        .footer_span_space{
            color: #fff;font-size: 12px;float: right;margin-right: 10px;line-height: 28px;cursor: pointer;
        }
		.foot_span_zn {
			display: inline-block;
        	margin-left: 110px;
		}
		.foot_span_zn a {font-size:12px;color:#fff;}
        .edit{
            color: #fff;font-size: 12px;float: right;margin-right: 10px;margin-left: 10px;line-height: 28px;cursor: pointer;
        }
        .deldel_img{
            float: right;height: 15px;margin-top: 7px;
        }
        .edit_img{
            float: right;height: 15px;margin-top: 7px;
        }
        .new_excell_footer {
            width: 100%;
            height: 28px;
            position: relative;
            background-color: #f7bd00;
        }
        .new_excell_head {
            position: relative;
            width: 100%;
            height: 30px;
        }
        .new_excell_name {
            border-left: 4px solid #f7bd00;
            color: #f7bd00;
            position: absolute;
            bottom: 0;
            font-size: 16px;
            font-weight: 700;
            height: 20px;
            margin-left: 15px;
        }
        .new_excell_info {
            width: 100%;
            height: 113px;
            position: relative;
        }
        .new_excell_info_main {
            width: 95%;
            height: 62px;
            position: absolute;
            left: 5%;
            top: 14%;
        }

        .new_excell_info_other {
            position: absolute;
            top: 10px;
            height: 100%;
            margin: 0;
            list-style-type: none;
            left: 50%;
        }

        .new_excell_main {
            width: 330px;
            height: 171px;
            border: 1px solid #ddd;
            margin: auto;
            margin-top: 10px;
            border-radius: 5px;
			margin-left: 15px;
        }
        .new_excell_main:hover {
            border: 2px solid #59bdf0;
        }
        .new_excell {
            width: 360px;
            height: 191px;
            float:left;
           
        }
		.new_excell_center {
			    margin-left: 13%;
		}
        .new_excell_info_other span {
            margin-left: 10px;
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
    </style>
</head>
<body>

<div class="wrap">
    <div class="head">
        <div class="head_left"><h1>表单设计</h1></div>
        <div class="head_mid">
            <input class="inp" type="text" placeholder="输入表名称搜索">
            <div class="search"><h1>搜索</h1></div>
        </div>
        <div class="head_rig" id="head_rig"><h1>新建</h1></div>
    </div>

    <div class="cont">
        <div class="cont_left">
            <div class="left_all">
                <div class="ul_all" id="li_parent">
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                    <%--<li><img src="../../img/workflow/wenjian.png"><h1>公文管理</h1></li>--%>
                </div>
            </div>

        </div>

        <div class="cont_rig">
            
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
            url: '../../workflow/flowclassify/formJsTree',
            animate:true,
            lines:true,
            loadFilter: function(rows){
                //console.log(rows);
                return convert(rows.datas);
            },
            onClick:function(){
                getFlowList();
            }
        });



        //处理树结构
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

        function getFlowList(sortId) {
            $.post("../../form/formlistbysort  ",{formId:sortId} ,function (ret) {
                console.log(ret);
                if(ret.flag==true){
                   renderDatas(ret.datas);
                }else{
					noDatas();
				}
            },"json");
        }
		function noDatas() {
            var html="抱歉现在还没有表单，请您新建";
            $(".cont_rig").html(html);
        }
        function renderDatas(data) {
           var html="";
           for(var i =0 ;i<data.length;i++){
			     if(i%3==0) {html+='<div class="new_excell_center">';}
                 html+=  ' <div class="new_excell" id="new_excell1">'+
                    '<div class="new_excell_main">'+
                    '<a class="set" flow_id="'+data[i].formId+'" title="编辑"><div class="new_excell_head"><span class="new_excell_name">&nbsp;'+data[i].formName+'</span></div>'+
                    '<div class="new_excell_info"><div class="new_excell_info_main">'+
                   ' <div style="float: left;width: 250px;text-align: center;margin: 0 auto;">'+
                   ' <img src="http://devapp.gsubo.com/ui/erp_img/zb.png" class="new_excell_pic">'+
                   ' <ul class="new_excell_info_other">'+
                   ' <li><span class="new_excell_info_username">主表</span></li>'+
                    '<li style="font-size: 12px;height: 16px;line-height: 16px;"><span class="new_excell_info_time" style="margin-left: 13px;color: #999;">表类型</span></li>'+
                    '</ul>'+
                    '</div>'+
                    '</div>'+
                   ' <div style="position: absolute;bottom: 5px;left: 20px;"><div style="float: left;">'+
                    '<img src="" class="new_excell_info_img position_img" style="vertical-align: middle;">'+
                    '<span class="new_excell_info_username" style="font-size: 12px;margin-left: 5px;color: #999;">'+data[i].depName+'</span>'+
                   ' </div>'+
                    ' </div>'+
                   ' </div>'+
                    '</a>'+
                   ' <div class="new_excell_footer">'+
				   '<span class="foot_span_zn"><a href="#">智能</a></span>'+
				   '<span class="deldel">删除</span>'+
                   ' <img src="/ui/img/workflow/new_excell_info_img_bianji.png" class="deldel_img" >'+
                    '<span class="footer_span_space">&nbsp;|&nbsp;</span>'+
                '<span class="edit" >编辑</span>'+
                   '<img src="/ui/img/workflow/new_excell_info_img_shanchu.png" class="edit_img">'+
                    '</div>'+
                    '</div>'+
                    '</div>';
					if(i%3==2){html+='</div>';}
            }
			$(".cont_rig").html(html);
        }
			//function renderDatas() {
            //var html="11111";
           // var content = document.createTextNode("111111");
            //var p=document.createElement('p');
            //var div=document.getElementById('dd');
            //p.appendChild(content);
            //div.appendChild('p');
        //} 
})
</script>

</html>
