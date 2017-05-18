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
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../lib/ueditor/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../../lib/pagination/style/pagination.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/news/center.css"/>
    <script type="text/javascript" src="../../js/news/jquery-1.9.1.js"></script>
    <script src="../../js/news/page.js"></script>
    <script src="../../lib/laydate.js"></script>
    <script src="../../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../../lib/layer/layer.js"></script>
	<style>
		.sort_liucheng,.new_liucheng{
		    width: 100px;
		    height: 25px;
		    margin-bottom: 5px;
		    background: #red;
		    float: left;
		    margin-top: -3px;
		}
		.sort_liucheng h1,.new_liucheng h1{
			text-align:center;
			line-height: 25px;
		}
		.table_head{
			width: 100%;
			height: 32px;
			position: relative;
		}
		.new_liucheng{
			background: #138eee;
			color: #fff;
			border-radius: 6px;
			position: absolute;
			right: 3px;
			cursor: pointer;
		}
		.edit_biaodan,.delete_biaodan{
			cursor: pointer;
		}
		#tr_td{
			    text-align: center;
		}
	</style>
</head>
<body>
<div class="bx">
    <!--head开始-->
    <div class="head w clearfix">
        <ul class="index_head">
        
            <li data_id="0"><span class="one headli1_1">表单分类</span><img class="headli1_2" src="../../img/02.png" alt=""/>
            </li>
            <li data_id="0"><span class="headli1_1">流程分类</span>
            </li>
        </ul>
    </div>
    <!--head通栏结束-->
	
	        <!--content部分开始-->
        <div>
        <div class="wrap">
            <div class="navigation  clearfix">
            <div class="left">
                <img src="../../img/workflow/classfiy.png"> 
                <div class="news">公告通知</div>                
                <!-- 查询按钮 -->
            </div>
            <div class="right">
               <div id="cx" class="btn_new">查询</div>
            </div>
        </div>
            	<div class="tab_t">
            		<div class="tab_tone">
            			<table id="tr_td">
		                    <thead>
		                    <tr>
		                        <td class="th"> 序号 </td>
		                        <td class="th">
		                           		名称		
		                        </td>
		                        <td class="th">
		                          	表单数量
		                        </td>
		
		                        <td class="th">
		                            		所属部门
		                        </td>
		                        <td class="th">
		                            	操作
		                        </td>
		                        <!-- <td class="th">发布部门</td> -->
		                    </tr>
		                    </thead>
		                    <tbody id="j_tb">
								
		                    </tbody>
		                    
		                </table>
            		</div>
            		 
	                
	                <div class="tab_ttwo" style="display:none;">
            			<table id="tr_td">
		                    <thead>
		                    <tr>
		                        <td class="th">
		                         	  序号
		                        </td>
		                        <td class="th">
		                           		名称		
		                        </td>
		                        <td class="th">
		                          	表单数量
		                        </td>
		
		                        <td class="th">
		                            		所属部门
		                        </td>
		                        <td class="th">
		                            	操作
		                        </td>
		                        <!-- <td class="th">发布部门</td> -->
		                    </tr>
		                    </thead>
		                    <tbody id="c_biaodan">
								<!-- <tr><td><a  notifyId="" class="windowOpen '+className+'">1</a></td>
			                        <td><a notifyId="" class="windowOpen '+className+'">行政管理</a></td>
			                        <td><a notifyId="" class="windowOpen '+className+'">3</a></td>
			                        <td><a notifyId="" class="windowOpen '+className+'">全部部门</a></td>
			                        <td><a notifyId="" class="windowOpen '+className+'">编辑|删除</a></td>
		                        </tr> -->
		                    </tbody>
		                    
		                </table>
            		</div>
            	</div>

            </div>


        </div>
        <!--content部分结束-->
        
                  <!--  内容 -->
                  
                  
    
</div>

<!--footer部分结束-->
</div>
<script>
$(function () {
			//tab切换

			$('.clearfix').on('click','li',function(){
				$(".clearfix li").find("span").removeClass("one");
				$(this).find('span').addClass('one');
				 if($(this).attr('id')=='biaodan'){
				
					$('.tab_tone').css("display","block");
					$('.tab_ttwo').css("display","none");
					$('.sort_liucheng h1').html('表单分类列表');
					$('.new_liucheng h1').html('新建表单分类');
				
				}else {
					$('.tab_ttwo').css("display","block");
					$('.tab_tone').css("display","none");
					$('.sort_liucheng h1').html('流程分类列表');
					$('.new_liucheng h1').html('新建流程分类');
				} 
			});
			
					//新增	
					$('.new_liucheng').on('click',function(){
						layer.open({
						  type: 1,
						  /* skin: 'layui-layer-rim', //加上边框 */
						  offset: '80px',
						  area: ['600px', '400px'], //宽高
						  title:$(this).find('h1').text(),
							closeBtn: 0,
						  content: '<div class="conter"><div class="f_title"><span class="f_field_title">表单父分类</span><span class="f_field_required">*</span>'+
						  			'<div class="f_field_ctrl clear"><select name="SORT_PARENT" id="sort_parent"></select><span>（为空为一级分类）</span></div>'+
						  			'<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">表单分类排序号</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><input type="number" name="SORT_NO" class="inp" value="0" id="sort_no"></div></div>'+
						  			'<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">表单分类名称</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><input type="text" class="inp name_biaodan" name="SORT_NAME" size="30" maxlength="100" value="" id="sort_name"></div></div>'+
						  			'<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">所属部门</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><select class="select_duplicate_sort" name="DEPT_ID" id="dept_id"><option>所有部门</option></select></div></div>'+
						  			'</div></div>',

						  btn:['保存', '关闭'],
                          yes: function(index, layero){
                                //按钮【按钮三】的回调
								/*alert($('.name_biaodan').val());*/
								var url="";
								var data={
                                    sortNo:$('#sort_no').val(),
                                    parentId:$('#sort_parent  option:checked').attr('value'),
                                    departmentId:$('#dept_id  option:checked').attr('value')

                                };

                              if($('.new_liucheng').find('h1').text()=='新建表单分类'){
                                  url='formSave';
                                  tabType=0;
                                  data["formName"]= $('#sort_name').val();
							  }else{
                                  tabType=1;
                                  url='flowSave';
                                  data["flowName"]= $('#sort_name').val();
							  }
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
                                                    items();
                                                    item();
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

					//编辑的接口
						function edit(){
                          /*  var url="";
                            var data={
                                sortNo:$('#sort_no').val(),
                                parentId:$('#sort_parent  option:checked').attr('value'),
                                departmentId:$('#dept_id  option:checked').attr('value')

                            };*/

                            $.ajax({
                                url:url,
                                type:'get',
                                data:data,
                                dataType:'json',
                                success:function(obj){

                                    if(obj.flag==true){
                                        items();
                                        item();
                                        /*window.location.reload();*/
                                    }
                                    console.log(obj)
                                }
                            });
						}
						edit();


						var url="";
						var data="";
					//编辑
						$('#j_tb').on('click','.edit_biaodan',function(){
                            var id=$(this).attr('tid');
                           /* alert(id);*/
                            //获取序号
							var num=$(this).parent().siblings('.xuhao').find('a').text();
                            //获取名称
                            var form_name=$(this).parent().siblings('.mingcheng').find('a').text();
                            //获取数量
                            var form_num=$(this).parent().siblings('.biaodanshu').find('a').text();
                            //获取部门
                            var form_dept=$(this).parent().siblings('.bumen').find('a').text();
                            //获取父表单

                            var parent_id=$(this).attr('parent_id');


							layer.open({
							  type: 1,
							  /* skin: 'layui-layer-rim', //加上边框 */
							  area: ['600px', '400px'], //宽高
							  title:$(this).attr('name'),
							  content:  '<div class="conter"><div class="f_title"><span class="f_field_title">表单父分类</span><span class="f_field_required">*</span>'+
                              '<div class="f_field_ctrl clear"><select name="SORT_PARENT" id="sort_parent"></select><span>（为空为一级分类）</span></div>'+
                              '<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">表单分类排序号</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><input type="text" name="SORT_NO" class="inp" value="'+num+'" id="sort_no"></div></div>'+
                              '<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">表单分类名称</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><input type="text" class="inp" name="SORT_NAME" size="30" maxlength="100" value="'+form_name+'" id="sort_name"></div></div>'+
                              '<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">所属部门</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><select class="select_duplicate_sort" name="DEPT_ID" id="dept_id"></select></div></div>'+
                              '</div></div>',
                                btn:['保存', '关闭'],
                                yes: function(index, layero){
                                    //按钮【按钮三】的回调

                             //表单编辑
                                        url='formUpdate';
                                        tabType=0;
                                        data={
                                            sortNo:$('#sort_no').val(),
                                            parentId:$('#sort_parent  option:checked').attr('value'),
                                            departmentId:$('#dept_id  option:checked').attr('value'),
                                            formName:$('#sort_name').val(),
                                            formId:id
										}

								//流程编辑
                              /*          tabType=1;
                                        url='flowUpdate';
                                        data={
                                            flowName:$('#sort_name').val(),
                                            flowId:id
                                        }*/


                                    if($('.name_biaodan').val()==''){
                                        alert('表单名称不能为空');
                                    }else{

                                        var layerIndex = layer.load(0, {shade: false});
                                        edit();

                                        layer.closeAll();
                                    }
                                }
							});

                            /*$(".selector").find("option[value='+parent_id+']").attr("selected",true);*/
                            //父表单

                            var opt_li='<option value="0"  class="levelleft0 selector"></option>';
                            opt_li=Child(formdata,opt_li,0,parent_id);
                            $('#sort_parent').html(opt_li);

                            //部门

                            var opt_li_dep='<option value="0"  class="levelleft0">'+form_dept+'</option>';

                            opt_li_dep = departmentChild(departmentData,opt_li_dep,0,form_dept);
                            console.log(departmentData)
                            $('#dept_id').html(opt_li_dep);
					
						});//编辑结束

						var url="";
						var data="";
						//流程编辑
						$('#c_biaodan').on('click','.edit_liucheng',function() {
                            var id = $(this).attr('tid');
							alert(id);
                            //获取序号
                            var num = $(this).parent().siblings('.xuhao').find('a').text();
                            //获取名称
                            var form_name = $(this).parent().siblings('.mingcheng').find('a').text();
                            //获取数量
                            var form_num = $(this).parent().siblings('.biaodanshu').find('a').text();
                            //获取部门
                            var form_dept = $(this).parent().siblings('.bumen').find('a').text();
                            //获取父表单

                            var parent_id = $(this).attr('parent_id');


                            layer.open({
                                type: 1,
								/* skin: 'layui-layer-rim', //加上边框 */
                                area: ['600px', '400px'], //宽高
                                title: $(this).attr('name'),
                                content: '<div class="conter"><div class="f_title"><span class="f_field_title">表单父分类</span><span class="f_field_required">*</span>' +
                                '<div class="f_field_ctrl clear"><select name="SORT_PARENT" id="sort_parent"></select><span>（为空为一级分类）</span></div>' +
                                '<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">表单分类排序号</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><input type="text" name="SORT_NO" class="inp" value="' + num + '" id="sort_no"></div></div>' +
                                '<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">表单分类名称</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><input type="text" class="inp" name="SORT_NAME" size="30" maxlength="100" value="' + form_name + '" id="sort_name"></div></div>' +
                                '<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">所属部门</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><select class="select_duplicate_sort" name="DEPT_ID" id="dept_id"></select></div></div>' +
                                '</div></div>',
                                btn: ['保存', '关闭'],
                                yes: function (index, layero) {
                                    //按钮【按钮三】的回调
									/*alert($('.name_biaodan').val());*/
									/*      var url="";
                                    var data={
                                        sortNo:$('#sort_no').val(),
                                        parentId:$('#sort_parent  option:checked').attr('value'),
                                        departmentId:$('#dept_id  option:checked').attr('value')

                                    };*/
									/*alert($('.edit_biaodan').attr('name'));*/
									/*if($('.edit_biaodan').attr('name')=='编辑表单分类'){
                                        url='formUpdate';
                                        tabType=0;
                                        data={
                                            formName:$('#sort_name').val(),
                                            formId:id
                                        }
                                    }else{*/
                                        tabType=1;
                                        url='flowUpdate';
                                        data={
                                            sortNo:$('#sort_no').val(),
                                            parentId:$('#sort_parent  option:checked').attr('value'),
                                            departmentId:$('#dept_id  option:checked').attr('value'),
                                            flowName:$('#sort_name').val(),
                                            flowId:id
                                        }


                                    if($('.name_biaodan').val()==''){
                                        alert('表单名称不能为空');
                                    }else{

                                        var layerIndex = layer.load(0, {shade: false});

                                       edit();
                                        layer.closeAll();
                                    }
                                }
						})
                            var opt_li='<option value="0"  class="levelleft0 selector"></option>';
                            opt_li=Child(flowdata,opt_li,0,parent_id);
                            $('#sort_parent').html(opt_li);

                            //部门

                            var opt_li_dep='<option value="0"  class="levelleft0">'+form_dept+'</option>';

                            opt_li_dep = departmentChild(departmentData,opt_li_dep,0,form_dept);
                            console.log(departmentData)
                            $('#dept_id').html(opt_li_dep);
					})


    var departmentData =new Array();
    //部门接口
    function departmentAjax(){
        $.ajax({
            url:'/department/getAlldept',
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
          }//表单递归结束

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
						url:'form',
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



    		var flowdata={};
				//流程分类接口
			function items(){
					$.ajax({
						url:'flow',
						type:'get',
						dataType:'json',
						success:function(obj){
                            if(obj.flag){
                                var data=obj.datas;
								/* console.log(data); */
                                var str_li='';
                                str_li=queryChild_flow(data,str_li,0);
                                flowdata={};
                                flowdata=data;
                                $('#c_biaodan').html("");
                                $('#c_biaodan').html(str_li);
                            }
						}
					});
			}
			
			items();

			//删除接口

			function form_delete(){
                $.ajax({
                    url:url,
                    type:'get',
                    data:data,
                    dataType:'json',
                    success:function(obj){
                        console.log(obj);
                        if(obj.flag==false){
                            var msg=obj.msg
                            alert(msg)
                        }else{
                            alert('删除成功');
                            items();
                            item();
                            /*window.location.reload();*/
                        }

                    }
                });
			}

			/*form_delete();*/

			var url="";
			var data={};
			
			//表单删除
			$('#tr_td').on('click','.delete_biaodan',function(){
			    alert('确定删除？');
			    var tid=$(this).attr('tid');
			   /* alert(tid);*/


                    url='formDelete';
                    data={
                        formId:tid
					}

                form_delete();
			})
		/*	流程删除*/

			$('#c_biaodan').on('click','.delete_flow',function(){
				alert('确定删除？');
				var tid=$(this).attr('tid');
				/* alert(tid);*/


				url='flowDelete';
				 data={
				 flowId:tid
				 }

				form_delete();

			})

});

</script>
</body>
</html>
