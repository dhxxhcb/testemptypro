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
    <link rel="stylesheet" type="text/css" href="../../lib/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../../lib/pagination/style/pagination.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/news/center.css"/>
    <script type="text/javascript" src="../../js/news/jquery-1.9.1.js"></script>
    <script src="../../js/news/page.js"></script>
    <script src="../lib/laydate.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/layer/layer.js"></script>
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
			})
			//表单分类接口
          function queryChild(datas,str_li,level){
              for(var i=0;i<datas.length;i++){
                var className="levelleft"+level;
               
                 str_li+='<tr><td><a  notifyId="" class="windowOpen '+className+'">'+datas[i].sortNo+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen '+className+'">'+datas[i].sortName+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">'+datas[i].formcounts+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">'+datas[i].departName+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">编辑|删除</a></td></tr>'
                 console.log(datas[i].childs);
                 if(datas[i].haveChild!=null&&datas[i].haveChild==1){
                    str_li = queryChild(datas[i].childs,str_li,level+1);
                 }
              }
              return str_li;
          }


				//表单分类接口
			function item(){
					$.ajax({
						url:'form',
						type:'get',
						dataType:'json',
						success:function(obj){
							var data=obj.datas;
							console.log(data);
							var str_li='';
							str_li=queryChild(data,str_li,0);
							
						
							$('#j_tb').html(str_li);
						}
					});
			}
			
			item();
			
			
			
			
				//流程分类接口
          function queryChild_biaodan(datas,str_li,level){
              for(var i=0;i<datas.length;i++){
                var className="levelleft"+level;
               
                 str_li+='<tr><td><a  notifyId="" class="windowOpen '+className+'">'+datas[i].sortNo+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen '+className+'">'+datas[i].sortName+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">'+datas[i].flowcounts+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">'+datas[i].departName+'</a></td>'+
		                        '<td><a notifyId="" class="windowOpen ">编辑|删除</a></td></tr>'
                 console.log(datas[i].childs);
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
							console.log(data);
							var str_li='';
							str_li=queryChild_biaodan(data,str_li,0);
							
						
							$('#c_biaodan').html(str_li);
						}
					});
			}
			
			items();

});

</script>
</body>



</html>
