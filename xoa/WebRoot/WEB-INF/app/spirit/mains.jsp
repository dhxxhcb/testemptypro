<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- saved from url=(0058)file:///C:/Users/gaosubo/Desktop/OA%E7%B2%BE%E7%81%B5.html -->
<html>
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OA精灵</title>

<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<script type="text/javascript">
	
</script>
<link rel="stylesheet" type="text/css"
	href="../css/spirit/ispirit_index.css">
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<!-- <script type="text/javascript"
	src="../js/spirit/sys_function_7a682d434e.js"></script> -->
<!-- <script type="text/javascript" src="../js/spirit/ispirit.js"></script> -->
<!-- <script type="text/javascript" src="../js/spirit/ispirit_index.js"></script> -->
<script>
  
	var MYOA_JS_SERVER = "${paraName}";
	var MYOA_STATIC_SERVER = "${paraValue}";
	(function($) {
		$(document).ready(function($) {
			window.external.OA_SMS("WINDOW_CAPTION","${paraValue}", "INIT");
		});
	})(jQuery);
</script>
<style type="text/css">
html,body {
	width: 100%;
	height: 100%;
}
</style>
</head>


<body>
	<div id="ipanel_container" style="height: 563px;">
		<iframe id="ipanel" name="ipanel" src="dh" allowtransparency="true"
			border="0" frameborder="0" framespacing="0" marginheight="0"
			marginwidth="0" style="width:100%;height:100%;"></iframe>
	</div>
	<div id="status_bar">
		<table border="0" width="100%" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<td class="left"><a id="online_link"
						href="http://192.168.0.23/ispirit/index.php?I_VER=2#"
						onclick="javascript:ViewOnlineUser();" title="共 20 人，1 人在线">
							在线<span id="user_count" title="共 20 人，1 人在线">1</span>人 </a></td>
					<td class="center"><span id="new_sms"></span> <span
						id="new_sms_sound" style="width:1px;height:1px;"></span></td>
					<td class="right"><span id="new_letter"></span> 未注册</td>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>