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
	<link rel="stylesheet" type="text/css" href="../css/common/ui.dynatree.css">
	<link rel="stylesheet" type="text/css" href="../css/common/org_select.css">
	<script type="text/javascript" src="../js/jquery-1.9.1.js"></script> 
	<script src="../js/base/base.js"></script> 
<!-- 	<script src="js/ispirit.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/select.js"></script> -->
		<!-- <script type="text/javascript" src="js/js_lang.php"></script>
	<script type="text/javascript" src="js/tree.js"></script> -->
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
</style>
<body>
	<!-- //开始 -->
		<!-- //头部 -->
		
		<div id="north">
   <div id="navMenu" style="width:auto;">
      <a href="#" title="已选人员" block="selected" hidefocus="hidefocus"><span>已选</span></a>
      <a href="#" title="按部门选择" block="dept" hidefocus="hidefocus" class="active"><span>部门</span></a>
      <a href="#" title="按角色选择" block="priv" hidefocus="hidefocus"><span>角色</span></a>
      <a href="#" title="按分组选择" block="group" hidefocus="hidefocus"><span>分组</span></a>
      <a href="#" title="从在线人员选择" block="online" hidefocus="hidefocus"><span>在线</span></a>
      <a href="#" block="query" hidefocus="hidefocus" style="display:none;"><span>搜索</span></a>
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
		
		<div class="main-block" id="block_dept" style="display:block;">
			   <div class="left moduleContainer" id="dept_menu">
				   <div class="tree">
					   	<ul class="dynatree-container dynatree-no-connector" id="deptOrg">
					   	</ul>
				   </div>
			 
			   </div>
			   <div class="right" id="dept_item">
					<div class="block-right" id="dept_item_2">
						<!-- 部门名 -->
						<div class="block-right-header" title="">北京高速波软件按有限公司</div>
						
						<div class="block-right-add">全部添加</div>
						<div class="block-right-remove">全部删除</div>
						<div class="block-right-item" item_id="admin" item_name="系统管理员" user_id="admin" title="OA 管理员 [北方测试研究公司]">
							<span class="name">系统管理员<span class="status"> (在线)</span></span>
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
		$(function(){
				//组织
				
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
							if(deptId==0){
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
										
											tr+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span></span><img src="../img/main_img/man.png" alt=""><a href="#" class="dynatree-title" title="'+v.userName+'">'+v.userName+'</a></span><ul style="margin-left:10%;"></ul></li>';
										}else if(v.sex==1){
											tr+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span></span><img src="../img/main_img/women.png" alt=""><a href="#" class="dynatree-title" title="'+v.userName+'">'+v.userName+'</a></span><ul style="margin-left:10%;"></ul></li>';
										}
										
										
									}
								});
							}
							
							
							target.html(str);
							$('.name').html(tr);
							
							$('.tree .dynatree-container').on('click','.childdept',function(){
								var  that = $(this);
								
								getChDept(that.next(),that.attr('deptid'));
								var title=that.find('a').text();
								$('.block-right-header').html(title);
							});
						}
					})
				}
				
					getChDept($('#deptOrg'),0);
					
				$('.block-right').on('mouseover','div',function(){
					$(this).css('background','#D6E4EF');
				})	
				$('.block-right').on('mouseout','div',function(){
					$(this).css('background','#fff');
				})	
					
		
		});
	</script>
	<script>
</html>
