<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!DOCTYPE html>
<html>
 <head>
    <title>选择部门</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="stylesheet" type="text/css" href="css/select.css" />
	<script src="js/ispirit.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/select.js"></script>
	<link rel="stylesheet" type="text/css" href="css/ui.dynatree.css">
	<link rel="stylesheet" type="text/css" href="css/org_select.css">
	<script type="text/javascript" src="js/js_lang.php"></script>
	<script type="text/javascript" src="js/tree.js"></script>
</head>



<!-- <script Language="JavaScript"> -->
<!-- var query_string = "MODULE_ID=5&PRIV_OP="; -->
<!-- var parent_window = jQuery.browser.msie ? parent.dialogArguments.document : parent.opener.document; -->
<!-- var form_name = "form1";  -->
<!-- var context = jQuery(parent_window).find('form[name="' + form_name + '"]'); -->
<!-- var to_id_field = context.find("[name='TO_ID']").get(0) || jQuery("[name='TO_ID']", parent_window).get(0); -->
<!-- var to_name_field = context.find("[name='TO_NAME']").get(0) || jQuery("[name='TO_NAME']", parent_window).get(0); -->
<!-- var item_url = "item.php"; -->
<!-- var single_select = false; -->

<!-- jQuery.noConflict(); -->
<!-- (function($){ -->
   <!-- $(document).ready(function($){ -->
      <!-- load_init(); -->
      
      <!-- //默认加载部门的人员选中状态 -->
      <!-- init_item('dept'); -->
   <!-- }); -->
<!-- })(jQuery); -->
<!-- </script> -->
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
<div id="tree"><ul class="dynatree-container dynatree-no-connector"><li class="dynatree-lastsib"><span class="dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span class="dynatree-checkbox"></span><img src="/static/images/org/root.png" alt=""><a href="#" class="dynatree-title" title="中国兵器工业集团">中国兵器工业集团</a></span><ul><li class=""><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-exp-cd dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="中国兵器工业信息中心">中国兵器工业信息中心</a></span></li><li class="dynatree-lastsib"><span class="dynatree-node dynatree-folder dynatree-has-children dynatree-lazy dynatree-lastsib dynatree-exp-cdl dynatree-ico-cf"><span class="dynatree-expander"></span><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="北方测试研究公司">北方测试研究公司</a></span></li></ul></li></ul></div>
 
   </div>
   <div class="right" id="dept_item">
<div class="block-right" id="dept_item_2"><div class="block-right-header" title="北方测试研究公司">北方测试研究公司</div><div class="block-right-add">全部添加</div><div class="block-right-remove">全部删除</div><div class="block-right-item" item_id="admin" item_name="系统管理员" user_id="admin" title="OA 管理员 [北方测试研究公司]"><span class="name">系统管理员<span class="status"> (在线)</span></span></div></div>   </div>
</div>
		
	<!-- //结束 -->
	<div id="south">
	   <input type="button" class="BigButtonA" value="确定" onclick="close_window();">&nbsp;&nbsp;
	</div>
</body>
</html>
