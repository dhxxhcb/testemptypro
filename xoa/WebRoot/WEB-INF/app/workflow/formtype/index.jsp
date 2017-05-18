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
    <link rel="stylesheet" type="text/css" href="../../lib/ueditor/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/workflow/index.css"/>
    <link rel="stylesheet" type="text/css" href="../../lib/easyui/themes/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../../lib/easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/news/center.css"/>
    <script type="text/javascript" src="../../js/jquery-1.9.1.js" ></script>
    <script src="../../lib/laydate.js"></script>
    <script type="text/javascript" src="../../lib/easyui/jquery.easyui.min.js" ></script>
    <script type="text/javascript" src="../../lib/easyui/tree.js" ></script>
    <script type="text/javascript" src="../js/index.js" ></script>
    <script src="../../lib/layer/layer.js"></script>
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
        .conter{
			width:500px;
			height:800px;
			margin:auto;
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
			float:left;
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
		.f_field_ctrl input{
			color:#000;
		}
		.f_field_block {
			width: 100%;
    		height: 68px;
		    margin-top: 52px;
		    margin-bottom: 4px;
		    display: block;
		    text-align: left;
		}
		.inp{
			width: 221px;
			height: 32px;
			border-radius: 4px;
		}
	/*	#layui-layer2{
			border-radius:10px;
		}*/
		.center{
			height:400px !important;
		}
		.delete_flow,.edit_liucheng{
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
			    font-size: 14px;
			    color: #333;
			    overflow: hidden;
			    background-color: #2b7fe0 ;
			    border-radius: 2px 2px 0 0;
			}
			.layui-layer-page .layui-layer-btn {
				    padding-top: 10px;
				    text-align: center;
				}
    </style>
</head>
<body>

<div class="wrap">
    <div class="head">
        <div class="head_left"><h1>表单设计</h1></div>
        <div class="head_mid">
            <input id="form_value" class="inp" type="text" placeholder="输入表名称搜索">
            <div id="btn_search" class="search"><h1>搜索</h1></div>
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
		$("#btn_search").click(function(){
		var value =$("#form_value").val();
		   $.post("../../form/formBySearch",{searchValue:value} ,function(ret){
       
		   if(ret.flag==true){
                   renderDatas(ret.datas);
                }else{
					noDatas();
				}
		 
		   },"json")
		
		})
		
       //获取左侧分类
       $('#li_parent').tree({
            url: '../../workflow/flowclassify/formJsTree',
            animate:true,
            lines:true,
            loadFilter: function(rows){
                //console.log(rows);
                return convert(rows.datas);
            },
            onClick:function(node){
                getFlowList(node.id);
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
            $.post("../../form/formlistbysort",{sortId:sortId} ,function (ret) {
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
				   '<span class="foot_span_bdznsjq" onclick="bdznsjq();">表单智能设计器</span>'+
				   '<span class="foot_span_yulanbiaodan" onclick="yulanbiaodan();">预览表单</span>'+
				   '<span class="foot_span_zn"><a href="#">智能</a></span>'+
				   '<span class="deldel" id="deldel">删除</span>'+
                   ' <img src="../../img/workflow/new_excell_info_img_bianji.png" class="deldel_img" >'+
                    '<span class="footer_span_space">&nbsp;|&nbsp;</span>'+
                '<span class="edit" id="edit">编辑</span>'+
                   '<img src="../../img/workflow/new_excell_info_img_shanchu.png" class="edit_img">'+
                    '</div>'+
                    '</div>'+
                    '</div>';
					if(i%3==2){html+='</div>';}
            }
			$(".cont_rig").html(html);
        }
		
//新增	
	$('#head_rig').on('click',function(){
		layer.open({
		  type: 1,
		  /* skin: 'layui-layer-rim', //加上边框 */
		  offset: '80px',
		  area: ['600px', '400px'], //宽高
		  title:$(this).find('h1').text(),
		  closeBtn: 0,
		  content: '<div id="" class="layui-layer-content" style="height: 298px;overflow:-Scroll;overflow-y:hidden;"><div class="conter"><div class="f_title"><div class="f_field_block"><div class="f_field_label" style="width:100px;float:left"><span class="f_field_title">表单名称:</span></div>'+
	'<div class="f_field_ctrl clear"><input type="text" class="inp name_biaodan" name="SORT_NAME" size="30" maxlength="100" value="" id="sort_name" style="margin-left: 0px;margin-top: 0px";></div></div><span class="f_field_title" style="width:100px;float:left">表单父分类:</span><div class="f_field_ctrl clear"><select name="SORT_PARENT" id="sort_parent"></select><span>（为空为一级分类）</span></div>'+
	'<div class="f_field_block"><div class="f_field_label" style="width:100px;float:left"><span class="f_field_title">所属部门:</span></div><div class="f_field_ctrl clear"><select class="select_duplicate_sort" name="DEPT_ID" id="dept_id"><option value="0" class="levelleft0">所有部门</option></select></div></div></div></div></div>',

		  btn:['保存', '关闭'],
		  yes: function(index, layero){
				//按钮【按钮三】的回调
				/*alert($('.name_biaodan').val());*/
				var url="../../form/newForm";
				var data={
					//sortNo:$('#sort_no').val(),
					formSort:$('#sort_parent  option:checked').attr('value'),
					deptId:$('#dept_id  option:checked').attr('value'),
					formName:$('#sort_name').val(),
				};

			  
					if($('.name_biaodan').val()==''){
						alert('表单名称不能为空');
					}else{
						/* alert('0k');*/
						/*     alert($('#sort_parent  option:checked').attr('value'));*/
						var layerIndex = layer.load(0, {shade: false});
						$.ajax({
							url:url,
							type:'get',
							data:data,
							dataType:'json',
							success:function(obj){
								/*layer.closeAll();*/
								if(obj.flag==true){
									// items();
									//item();
								}
							}
						});
						layer.closeAll();
					}
			}
		});
		//父表单（表单）
		var opt_li='<option value="0"  class="levelleft0"></option>';
		opt_li=Child(formdata,opt_li,0,-1);
		$('#sort_parent').html(opt_li);

		//部门共用

		var opt_li_dep='<option value="0"  class="levelleft0">所有部门</option>';

		opt_li_dep = departmentChild(departmentData,opt_li_dep,0,-1);
		console.log(departmentData)
		$('#dept_id').html(opt_li_dep);

	});





//部门遍历方法
function departmentChild(datas,opt_li,level,dept){
	for(var i=0;i<datas.length;i++){
		var String="";
		var space=""
		for(var j=0;j<level;j++){
			space+="├&nbsp;&nbsp;&nbsp;";
		}
	   /* console.log("kongge"+space+"kongge")*/
		if(i==0){
			String=space+"┌";
		}else
		if(i!=0){
			String=space+"├";
		}else
		if(i==datas.length-1){
			String=space+"└";
		}
		if(dept==datas[i].deptId){
			opt_li+='<option value="'+datas[i].deptId+'" selected="selected">'+String+datas[i].deptName+'</option>';
		}else{
			opt_li+='<option value="'+datas[i].deptId+'">'+String+datas[i].deptName+'</option>';
		}
   /* 	console.log(datas[i].childs);*/
		if(datas[i].childs!=null){
			opt_li = departmentChild(datas[i].childs,opt_li,level+1,dept);
		}
	}
	return opt_li;
}
var departmentData =new Array();
    //部门接口
    function departmentAjax(){
        $.ajax({
            url:'../../department/getAlldept',
            type:'get',
            dataType:'json',
            success:function(obj){
                var data=obj.obj;
                departmentData= digui(data,0);
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
		   if(datas[i].sortName=='未定义'){

			   str_li+='<tr ><td><div class="img"></div><a  notifyId="" class="sort windowOpen '+className+'">'+datas[i].sortNo+'</a></td>'+
				   '<td><a notifyId="" class="windowOpen '+className+'">'+datas[i].sortName+'</a></td>'+
				   '<td><a notifyId="" class="windowOpen ">'+datas[i].formcounts+'</a></td>'+
				   '<td><a notifyId="" class="windowOpen ">'+datas[i].departName+'</a></td>'+
				   '<td class="tds"></td></tr>'
		   }else{
			   str_li+='<tr class="trs" ><td class="xuhao"><div class="img "></div><a  notifyId="" class="sort windowOpen '+className+'">'+datas[i].sortNo+'</a></td>'+
				   '<td class="mingcheng"><a notifyId="" class="biao_name windowOpen '+className+'">'+datas[i].sortName+'</a></td>'+
				   '<td class="biaodanshu"><a notifyId="" class="windowOpen ">'+datas[i].formcounts+'</a></td>'+
				   '<td class="bumen"><a notifyId="" class="windowOpen ">'+datas[i].departName+'</a></td>'+
				   '<td class="tds"><a notifyId="" class="edit_biaodan" tid="'+datas[i].sortId+'" parent_id="'+datas[i].sortParent+'" name="编辑表单分类">编辑</a><a notifyId="" class="delete_biaodan" tid="'+datas[i].sortId+'" parent_id="'+datas[i].sortParent+'" name="表单删除">|删除</a></td></tr>'
		   }
			 /* console.log(datas[i].childs); */
			 if(datas[i].childs!=null){
				str_li = queryChild(datas[i].childs,str_li,level+1);
	  
			 }
		  }
		  return str_li;
	  }
//表单递归结束

	//流程分类递归
	function queryChild_flow(datas,str_li,level){
		for(var i=0;i<datas.length;i++){
			var className="levelleft"+level;
			if(datas[i].sortName=='未定义'){
				str_li+='<tr ><td ><a  notifyId="" class="windowOpen '+className+'">'+datas[i].sortNo+'</a></td>'+
					'<td><a notifyId="" class="windowOpen '+className+'">'+datas[i].sortName+'</a></td>'+
					'<td><a notifyId="" class="windowOpen ">'+datas[i].flowcounts+'</a></td>'+
					'<td><a notifyId="" class="windowOpen ">'+datas[i].departName+'</a></td>'+
					'<td></td></tr>'
			}else{
				str_li+='<tr class="trs"><td class="xuhao"><a  notifyId="" class="windowOpen '+className+'">'+datas[i].sortNo+'</a></td>'+
					'<td class="mingcheng"><a notifyId="" class="windowOpen '+className+'">'+datas[i].sortName+'</a></td>'+
					'<td class="biaodanshu"><a notifyId="" class="windowOpen ">'+datas[i].flowcounts+'</a></td>'+
					'<td class="bumen"><a notifyId="" class="windowOpen ">'+datas[i].departName+'</a></td>'+
					'<td class="tds"><a notifyId="" class="edit_liucheng" tid="'+datas[i].sortId+'" parent_id="'+datas[i].sortParent+'" name="编辑流程分类">编辑</a><a notifyId="" class="delete_flow" tid="'+datas[i].sortId+'" parent_id="'+datas[i].sortParent+'" name="流程删除">|删除</a></td></tr>'
			}

			/*   console.log(datas[i].childs); */
			if(datas[i].childs!=null){
				str_li = queryChild_flow(datas[i].childs,str_li,level+1);
			}
		}
		return str_li;
	}


    //部门遍历方法
function departmentChild(datas,opt_li,level,dept){
	for(var i=0;i<datas.length;i++){
		var String="";
		var space=""
		for(var j=0;j<level;j++){
			space+="├&nbsp;&nbsp;&nbsp;";
		}
	   /* console.log("kongge"+space+"kongge")*/
		if(i==0){
			String=space+"┌";
		}else
		if(i!=0){
			String=space+"├";
		}else
		if(i==datas.length-1){
			String=space+"└";
		}
		if(dept==datas[i].deptId){
			opt_li+='<option value="'+datas[i].deptId+'" selected="selected">'+String+datas[i].deptName+'</option>';
		}else{
			opt_li+='<option value="'+datas[i].deptId+'">'+String+datas[i].deptName+'</option>';
		}
   /* 	console.log(datas[i].childs);*/
		if(datas[i].childs!=null){
			opt_li = departmentChild(datas[i].childs,opt_li,level+1,dept);
		}
	}
	return opt_li;
}
          //父表单递归方法（表单）

  function Child(datas,opt_li,level,parentId){

	  for(var i=0;i<datas.length;i++){
		  if(level==0&&i==0) continue;
		var String="";
		var space=""
		for(var j=0;j<level;j++){
				space+="├&nbsp;&nbsp;&nbsp;";
		}
	   /* console.log("kongge"+space+"kongge")*/
		  if(i==0){
			  String=space+"┌";
		  }
		  if(i!=0){
			  String=space+"├";
		  }
		  if(i==datas.length-1){
			  String=space+"└";
		  }
		  if(parentId==datas[i].sortId){
			  opt_li+='<option value="'+datas[i].sortId+'" selected="selected">'+String+datas[i].sortName+'</option>';
		  }else{
			  opt_li+='<option value="'+datas[i].sortId+'">'+String+datas[i].sortName+'</option>';
		  }

		 /* console.log(datas[i].childs); */
		 if(datas[i].childs!=null){
			opt_li = Child(datas[i].childs,opt_li,level+1,parentId);
		 }
	  }

	  return opt_li;
  }

           var formdata={};
				//表单分类接口
			function item(){
					$.ajax({
						url:'../../workflow/formtype/form',
						type:'get',
						dataType:'json',
						success:function(obj){
						   if(obj.flag){
						   		var data=obj.datas;
						   		/* console.log(data); */
								var str_li='';
								str_li=queryChild(data,str_li,0);
                                formdata={};
								formdata=data;
                                $('#j_tb').html("");
								$('#j_tb').html(str_li);
						   }
						}
					});
			}
			item();


			
			
			
			
			function yulanbiaodan(){
				$.post('../../form/previews',{},function(obj){
						console.log(obj);
					});
			}
			function bdznsjq(){
				$.post('../../form/designer',{},function(obj){
						console.log(obj);
					});
			}
})

</script>

</html>
