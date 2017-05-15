<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html>
 <head>
    <title>选择部门</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/common/style.css" />
	<link rel="stylesheet" type="text/css" href="../css/common/select.css" />
<!-- 	<link rel="stylesheet" type="text/css" href="../css/common/ui.dynatree.css"> -->
	<link rel="stylesheet" type="text/css" href="../css/common/org_select.css">
	<link rel="stylesheet" type="text/css" href="../lib/easyui/themes/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../lib/easyui/themes/icon.css"/>
	<script type="text/javascript" src="../js/jquery-1.9.1.js"></script> 
	<script src="../js/base/base.js"></script> 
	<script type="text/javascript" src="../lib/easyui/jquery.easyui.min.js" ></script>
    <script type="text/javascript" src="../lib/easyui/tree.js" ></script>
</head>




<style>
#dept_menu{
    overflow-x: auto;
}
.left_choose ul li div,.left_choose ul li h1,.left_choose ul img{
	float:left;
}
.left_choose ul img{
	<!-- margin-top:8px; -->
}
.left_choose ul li{
	width:80%;
	height:20px;
	<!-- background:red; -->
	margin-top:10px;
}
.mar{
	margin-left:10%;
}
.name li{
	list-style-type:none;
}
.choose{
	background:#D6E4EF !important;
}
</style>
<body>
	<!-- //开始 -->
		<!-- //头部 -->
		
		<div id="north">
   <div id="navMenu" style="width:auto;">
      <a href="#" title="已选人员" class="tab_btn"  block="selected" hidefocus="hidefocus"><span>已选</span></a>
      <a href="#" title="按部门选择" block="dept" hidefocus="hidefocus" class=" tab_btn active"><span>部门</span></a>
      <a href="#" title="按角色选择" class="tab_btn" block="priv" hidefocus="hidefocus"><span>角色</span></a>
      <a href="#" title="按分组选择" class="tab_btn" block="group" hidefocus="hidefocus"><span>分组</span></a>
      <a href="#" title="从在线人员选择" class="tab_btn" block="online" hidefocus="hidefocus"><span>在线</span></a>
      <a href="#" block="query" class="tab_btn" hidefocus="hidefocus" style="display:none;"><span>搜索</span></a>
   </div>
   <div id="navRight" style="float:right;">
      <div class="search">
         <div class="search-body">
            <div class="search-input"><input notlogin_flag="" id="keyword" type="text" value=""></div>
            <div id="search_clear" class="search-clear" style="display:none;"></div>
         </div>
      </div>
   </div>
</div>
		
		<!-- //内容 -->
	<div>
		<div class="main-block" id="deptBox" style="display:block;">
			   <div class="left moduleContainer" id="dept_menu">
				   <div class="tree">
					   	<ul class="dynatree-container dynatree-no-connector" id="deptOrg">
					   	</ul>
				   </div>
			 
			   </div>
			   <div class="right" id="dept_item">
					<div class="block-right" id="dept_item_2">
						<!-- 部门名 -->
						<div class="block-right-header" title=""></div>
						
						<div class="block-right-add">全部添加</div>
						<div class="block-right-remove">全部删除</div>
						<div class="block-right-item" uid="1" item_name="系统管理员" user_id="admin" title="OA管理员 ">
							<span class="name">系统管理员<span class="status"> (在线)</span></span>
						</div>
						<div class="userItem">

						</div>
					</div>   
				</div>
		</div>
		<!-- 已选 -->
		<div class="main-block" id="selectedDox" >
			   <div class="left moduleContainer" id="dept_menu">
				   <div class="tree">
					   	<ul class="dynatree-container dynatree-no-connector" id="deptOrg">
					   	</ul>
				   </div>
			 
			   </div>
			   <div class="right" id="dept_item">
					<div class="block-right" id="dept_item_2">
						<!-- 部门名 -->
						
						<div class="block-right-remove">全部删除</div>
						
						<div class="userItem">

						</div>
					</div>   
				</div>
		</div>
		<!-- 角色 -->
		<div class="main-block" id="priDox" >
			   <div class="left moduleContainer" id="dept_menu">
				   <div class="tree">
					   	<ul class="dynatree-container dynatree-no-connector" id="deptOrg">
					   	</ul>
				   </div>
			 
			   </div>
			   <div class="right" id="dept_item">
					<div class="block-right" id="dept_item_2">
						<!-- 部门名 -->
						
						<div class="block-right-remove">全部删除</div>
						
						<div class="userItem">

						</div>
					</div>   
				</div>
		</div>
		<!-- 分组 -->
		<div class="main-block" id="groupDox" >
			   <div class="left moduleContainer" id="dept_menu">
				   <div class="tree">
					   	<ul class="dynatree-container dynatree-no-connector" id="deptOrg">
					   	</ul>
				   </div>
			 
			   </div>
			   <div class="right" id="dept_item">
					<div class="block-right" id="dept_item_2">
						<!-- 部门名 -->
						
						<div class="block-right-remove">全部删除</div>
						
						<div class="userItem">

						</div>
					</div>   
				</div>
		</div>
	</div>
	<!-- //结束 -->
	<div id="south">
	   <input type="button" class="BigButtonA" value="确定" onclick="close_window();">&nbsp;&nbsp;
	</div>
</body>
	<script>
				function close_window(){
					var itemsArr = $('#selectedDox .userItem .block-right-item');
					console.log(itemsArr.length);
					var selectItemsId = '';
					var selectItemsName = '';
					var selectUid = '';
					for(var i=0;i<itemsArr.length;i++){
						var obj = itemsArr.eq(i);
						selectItemsId+=(obj.attr("user_id")+',');
						selectItemsName+=(obj.attr("item_name")+',');
						selectUid+=(obj.attr("uid")+',');
					};
					//alert(selectItemsId);
					parent.opener.document.getElementById(parent.opener.user_id).value=selectItemsName;
					parent.opener.document.getElementById(parent.opener.user_id).setAttribute('dataid',selectUid);
					parent.opener.document.getElementById(parent.opener.user_id).setAttribute('user_id',selectItemsId);
					window.close();
				}
		$(function(){

			$('#deptOrg').tree({  
				url: '../department/getChDept?deptId=20',
				animate:true, 
				
				loadFilter: function(rows){
					return convert(rows.obj);
				},
				onClick:function(node){
		            alert(node.id);
		        },
		        onBeforeExpand:function(node,param){
		        	  $('#deptOrg').tree('options').url = "../department/getChDept?deptId=" + node.id;// change the url      
		        }

			});  
			function TreeNode(id,text,state,children){
				this.id = id;
				this.text = text;
				this.state = state;
				this.children = children;
			}
			function convert(data){
				console.log(data);
				var arr = [];
				data.forEach(function(v,i){
					var node = new TreeNode(v.deptId,v.deptName,"closed") 
					
					arr.push(node);
				});
				return arr;
			}
				//组织
				$('.tab_btn').click(function(){
					var type = $(this).attr('block');
					$(this).addClass("active").siblings().removeClass('active');
					switch(type){
						case "selected":
							$('#selectedDox').show().siblings().hide();
							break;
						case "dept":
							$('#deptBox').show().siblings().hide();
							break;
						case "priv":
						
							break;
						case "group":
						
							break;
						case "query":
						
							break;
					}
				});
				function getChDept(target,deptId){
					$.ajax({
						url:'../department/getChDept',
						type:'get',	
						data:{
							deptId:deptId
						},		
						dataType:'json',
						success:function(data){
						/* if() */
							if(deptId==20){
								var str = '';
								data.obj.forEach(function(v,i){
									if(v.deptName){
										str+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span class="dynatree-checkbox"></span><img src="../img/main_img/company_logo.png" alt=""><a href="#" class="dynatree-title" title="'+v.deptName+'">'+v.deptName+'</a></span><ul style="margin-left:10%;"></ul></li>';
									}else{
										str+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span class="dynatree-checkbox"></span><img src="../img/main_img/company_logo.png" alt=""><a href="#" class="dynatree-title" title="'+v.deptName+'">'+v.userName+'</a></span><ul style="margin-left:10%;"></ul></li>';
									}
									
								});
							}else{
								var str = '';
								var tr = '';
								data.obj.forEach(function(v,i){
										if(v.deptName){
										str+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span class=""></span><a href="#" class="dynatree-title" title="'+v.deptName+'">'+v.deptName+'</a></span><ul style="margin-left:10%;"></ul></li>';
									}else{
										if(v.sex==0){
											tr+='<div class="block-right-item" item_id="'+v.uid+'" item_name="'+v.userName+'" user_id="'+v.userId+'" uid="'+v.uid+'" title="'+v.userName+'"><span class="name">'+v.userName+' '+v.userPrivName+'<span class="status"> </span></span></div>';
										}else if(v.sex==1){
											tr+='<div class="block-right-item" item_id="'+v.uid+'" item_name="'+v.userName+'" user_id="'+v.userId+'" uid="'+v.uid+'" title="'+v.userName+'"><span class="name">'+v.userName+' '+v.userPrivName+'<span class="status"></span></span></div>';
										}
									}
								});
							}
							target.html(str);
							$('#deptBox .userItem').html(tr);
						}
					})
				}
				$('#dept_item').on("click",".block-right-item",function(){
					var that = $(this);
					if(that.attr('class').indexOf('active') > 0){
						that.removeClass("active");
						
					}else{
						//var addstr='<div class="block-right-item" item_id="admin" item_name="'+v.userName+'" user_id="'+v.uid+'" title="'+v.userName+'"><span class="name">'+v.userName+' '+v.userPrivName+'<span class="status"></span></span></div>';
						var divObj = $(that.prop("outerHTML"));
						divObj.addClass("active");
						that.addClass("active");
						$('#selectedDox .userItem').append(divObj);
					}
					
				});
				//getChDept($('#deptOrg'),20);
				
				$('.tree .dynatree-container').on('click','.childdept',function(){
								var  that = $(this);
								getChDept(that.next(),that.attr('deptid'));
								var title=that.find('a').text();
								$('.block-right-header').html(title);
				});
							
				$('.block-right').on('mouseover','div',function(){
					$(this).addClass('hover');
				});	
				$('.block-right').on('mouseout','div',function(){
					$(this).removeClass('hover');
				});	
					
		
		});
	</script>
</html>
