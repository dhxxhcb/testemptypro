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
		.wrap{
			    margin-left: 1%;
    			margin-top: 1%;
		}
		.head .headli1_1 {
			  width:99px !important;

		}
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
		.new_liucheng{
			    margin-left: 83%;
			    background: #138eee;
			    color: #fff;
			    border-radius: 6px;
		}
		#tr_td{
			    text-align: center;
		}
		.levelleft1{
		   margin-left:30%;
		}
		.levelleft2{
		   margin-left:60%;
		}
		.change{
				width:85px;
			    background-color: #2F8AE3;
			    font-size: 14px;
			    color: #ffffff;
			    border-radius: 20px;
		}
		#liucheng{
			width: 85px !important; 
			    margin-left: 78px;
			        margin-top: 7px;
		}
		#biaodan{
			    width: 85px !important;
    			margin-left: 15px;
    			margin-top: 9px;
		}
		#liucheng h1,#biaodan h1{
			width:100%;
			text-align:center;
			line-height:26px;
		}
		.headli1_2{
			    margin-left: -137px !important;
    			margin-top: 5px !important;
		}
		.conter{
			width:500px;
			height:800px;
			margin:auto;
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
		    margin-top: 4px;
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
	</style>
</head>
<body>
<div class="bx">
    <!--head开始-->
    <div class="head w clearfix">
        <ul class="index_head">
           <li data_id="0" id="biaodan" class="change"><h1>表单分类</h1></li>
             </span><img class="headli1_2" src="../../img/02.png" alt=""/>
            <li data_id="" id="liucheng"><h1 class="headli2_1">流程分类</h1></li>
                    
           
           
        </ul>
    </div>
    <!--head通栏结束-->
	
	        <!--content部分开始-->
        <div>
            <div class="wrap">
            	<div class="table_head">
            		<div class="sort_liucheng"><h1>表单分类列表</h1></div>
            		<div class="new_liucheng"><h1>新建表单分类</h1></div>
            	</div>
            	<div class="tab_t">
            		<div class="tab_tone">
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
				$(".clearfix li").removeClass("change");
				$(this).addClass('change');
				 if($(this).attr('id')=='biaodan'){
				
					$('.tab_tone').css("display","block");
					$('.tab_ttwo').css("display","none");
					$('.sort_liucheng h1').html('表单分类列表');
					$('.new_liucheng h1').html('新建表单分类');
				
				}else{
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
						  title:'新建表单分类',
						  content: '<div class="conter"><div class="f_title"><span class="f_field_title">表单父分类</span><span class="f_field_required">*</span>'+
						  			'<div class="f_field_ctrl clear"><select name="SORT_PARENT" id="sort_parent"></select><span>（为空为一级分类）</span></div>'+
						  			'<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">表单分类排序号</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><input type="text" name="SORT_NO" class="inp" value="0" id="sort_no"></div></div>'+
						  			'<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">表单分类名称</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><input type="text" class="inp" name="SORT_NAME" size="30" maxlength="100" value="" id="sort_name"></div></div>'+
						  			'<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">所属部门</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><select class="select_duplicate_sort" name="DEPT_ID" id="dept_id"><option>所有部门</option></select></div></div>'+
						  			'</div></div>',

						  btn:['保存', '关闭'],
						  btn1: function(index, layero){
                              //按钮【按钮二】的回调

                              //return false 开启该代码可禁止点击该按钮关闭
                          }
						});

                        /*<option value="1">├中国兵器工业信息中心</option>*/
                       /* <option value="3">│└北京通达信科科技有限公司</option><option value="17">│　└总经理</option><option value="4">│　　├综合管理部</option>*/
                       /* <option value="18">│　　│├人力资源部</option><option value="19">│　　│├财务部</option><option value="20">│　　│└行政部</option><option value="5">│　　├市场营销部</option><option value="39">│　　│├市场部</option><option value="33">│　　││├品牌部</option>*/
                      /*  <option value="31">│　　││├网络营销中心</option><option value="32">│　　││└商务中心</option><option value="40">│　　│└销售部</option><option value="7">│　　│　├北京销售部</option><option value="28">│　　│　│├销售一组</option><option value="29">│　　│　│├销售二组</option><option value="30">│　　│　│├销售三组</option><option value="27">│　　│　│└销售协作组</option><option value="8">│　　│　└上海销售部</option><option value="6">│　　├研发部</option><option value="34">│　　│├产品部</option><option value="9">│　　│├开发一部</option><option value="10">│　　│├开发二部</option><option value="11">│　　│├质量保证部</option><option value="15">│　　│└设计部</option><option value="41">│　　├项目部</option><option value="42">│　　│├项目一部</option><option value="43">│　　│└项目二部</option><option value="16">│　　└生产部</option><option value="38">│　　　├采购部</option><option value="35">│　　　├生产一部</option><option value="37">│　　　├生产二部</option><option value="36">│　　　└质检部</option><option value="2">└北方测试研究公司</option><option value="14">　└北一测试研究院</option>*/
						var opt_li='<option value="0"  class="levelleft0"></option>';
						opt_li=Child(formdata,opt_li,0);
						$('#sort_parent').html(opt_li);
                        var opt_li_dep='<option value="0"  class="levelleft0">所有部门</option>';

                        opt_li_dep = departmentChild(departmentData,opt_li_dep,0);
                        console.log(departmentData)
                        $('#dept_id').html(opt_li_dep);

					});	
					//编辑
						$('#j_tb').on('click','.edit_biaodan',function(){
							
							layer.open({
							  type: 1,
							  /* skin: 'layui-layer-rim', //加上边框 */
							  area: ['600px', '400px'], //宽高
							  title:'编辑表单分类',
							  content:  '<div class="conter"><div class="f_title"><span class="f_field_title">表单父分类</span><span class="f_field_required">*</span>'+
                              '<div class="f_field_ctrl clear"><select name="SORT_PARENT" id="sort_parent"></select><span>（为空为一级分类）</span></div>'+
                              '<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">表单分类排序号</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><input type="text" name="SORT_NO" class="inp" value="0" id="sort_no"></div></div>'+
                              '<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">表单分类名称</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><input type="text" class="inp" name="SORT_NAME" size="30" maxlength="100" value="" id="sort_name"></div></div>'+
                              '<div class="f_field_block"><div class="f_field_label"><span class="f_field_title">所属部门</span><span class="f_field_required">*</span></div><div class="f_field_ctrl clear"><select class="select_duplicate_sort" name="DEPT_ID" id="dept_id"><option>所有部门</option></select></div></div>'+
                              '</div></div>'
							}); 
						/* 	$('.conter') */
					
						});
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
			
			//表单分类接口
          function queryChild(datas,str_li,level){
              for(var i=0;i<datas.length;i++){
                var className="levelleft"+level;
               
                 str_li+='<tr><td><a  notifyId="" class="windowOpen '+className+'">'+datas[i].sortNo+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen '+className+'">'+datas[i].sortName+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">'+datas[i].formcounts+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">'+datas[i].departName+'</a></td>'+
		                        '<td class="tds"><a notifyId="" class="edit_biaodan">编辑</a><a notifyId="" class="delete_biaodan">|删除</a></td></tr>'
		                   
                 /* console.log(datas[i].childs); */
                 if(datas[i].haveChild!=null&&datas[i].haveChild==1){
                    str_li = queryChild(datas[i].childs,str_li,level+1);
          
                 }
              }
              return str_li;
          
          }
    //部门遍历方法
    function departmentChild(datas,opt_li,level){
        for(var i=0;i<datas.length;i++){
            var String="";
            var space=""
            for(var j=0;j<level;j++){
                space+="├&nbsp;&nbsp;&nbsp;";
            }
            console.log("kongge"+space+"kongge")
            if(i==0){
                String=space+"┌";
            }else
            if(i!=0){
                String=space+"├";
            }else
            if(i==datas.length-1){
                String=space+"└";
            }

            opt_li+='<option value="'+datas[i].deptId+'">'+String+datas[i].deptName+'</option>';
        	console.log(datas[i].childs);
            if(datas[i].childs!=null){
                opt_li = departmentChild(datas[i].childs,opt_li,level+1);
            }
        }
        return opt_li;
    }
          //父表单方法
          function Child(datas,opt_li,level){
              for(var i=1;i<datas.length;i++){
                var String="";
                  var space=""
                for(var j=0;j<level;j++){
                        space+="├&nbsp;&nbsp;&nbsp;";
                }
                console.log("kongge"+space+"kongge")
                  if(i==1){
                      String=space+"┌";
                  }
                  if(i!=1){
                      String=space+"├";
                  }
                  if(i==datas.length-1){
                      String=space+"└";
                  }
		          opt_li+='<option value="'+datas[i].sortId+'">'+String+datas[i].sortName+'</option>';
                 /* console.log(datas[i].childs); */
                 if(datas[i].haveChild!=null&&datas[i].haveChild==1){
                    opt_li = Child(datas[i].childs,opt_li,level+1);
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
								formdata=data;
								
								$('#j_tb').html(str_li);
						   }
						}
					});
			}

			item();

				//流程分类接口
          function queryChild_biaodan(datas,str_li,level){
              for(var i=0;i<datas.length;i++){
                var className="levelleft"+level;
               
                 str_li+='<tr ><td><a  notifyId="" class="windowOpen '+className+'">'+datas[i].sortNo+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen '+className+'">'+datas[i].sortName+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">'+datas[i].flowcounts+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">'+datas[i].departName+'</a></td>'+
		                        '<td><a notifyId="" class="edit_liucheng">编辑</a><a notifyId="" class="delete">|删除</a></td></tr>'
               /*   console.log(datas[i].childs); */
                 if(datas[i].haveChild!=null&&datas[i].haveChild==1){
                    str_li = queryChild_biaodan(datas[i].childs,str_li,level+1);
                 }
              }
              return str_li;
          }


				//流程分类接口
			function items(){
					$.ajax({
						url:'flow',
						type:'get',
						dataType:'json',
						success:function(obj){
							var data=obj.datas;
							/* console.log(data); */
							var str_li='';
							str_li=queryChild_biaodan(data,str_li,0);
							
						
							$('#c_biaodan').html(str_li);
						}
					});
			}
			
			items();
			

			
			
			
	/* 	//新建表单中表父单接口的数据
		 function addChild_biaodan(datas,str_li,level){
              for(var i=0;i<datas.length;i++){
                var className="levelleft"+level;
               
                 str_li+='<tr ><td><a  notifyId="" class="windowOpen '+className+'">'+datas[i].sortNo+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen '+className+'">'+datas[i].sortName+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">'+datas[i].flowcounts+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">'+datas[i].departName+'</a></td>'+
		                        '<td><a notifyId="" class="edit_liucheng">编辑</a><a notifyId="" class="delete">|删除</a></td></tr>'
               /*   console.log(datas[i].childs); */
               /*   if(datas[i].haveChild!=null&&datas[i].haveChild==1){
                    str_li = addChild_biaodan(datas[i].childs,str_li,level+1);
                 }
              }
              return str_li;
          }


				//新建表单中表父单接口
			function add_biaodan(){
					$.ajax({
						url:'form',
						type:'get',
						dataType:'json',
						success:function(obj){
							var data=obj.datas;
							/* console.log(data); */
						/* 	var str_li='';
							str_li=addChild_biaodan(data,str_li,0);
							
						
							$('#sort_parent').html(str_li);
						}
					});
			}
			
			add_biaodan();  */

		


});

</script>
</body>



</html>
