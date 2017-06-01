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
	<meta charset="UTF-8">
	<title>系统信息</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<link rel="stylesheet" type="text/css" href="../css/sys/addUser.css"/>
	<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
	<script src="../js/ajaxupload.js" type="text/javascript" charset="utf-8"></script>
	<script>

	</script>
	<style type="text/css">
		.TableBlock {
			border: 1px #cccccc solid;
			line-height: 20px;
			font-size: 9pt;
			border-collapse: collapse;
		}
		.TableBlock .TableContent td, .TableBlock td.TableContent {
			background: #f2f2f2;
			border-bottom: 1px #cccccc solid;
			border-right: 1px #cccccc solid;
			padding: 3px;
			height: 30px;
		}
		.TableContent {
			/* BACKGROUND: #4897e8; */
		}
		.TableBlock .TableData td, .TableBlock td.TableData {
			background: #FFFFFF;
			border-bottom: 1px #cccccc solid;
			border-right: 1px #cccccc solid;
			padding: 3px;
			height: 30px;
			border-top:1px #cccccc solid;
		}
		.TableData {
			BACKGROUND: #FFFFFF;
			COLOR: #000000;
		}
		td, th {
			display: table-cell;
			vertical-align: inherit;
		}
		tr {
			display: table-row;
			vertical-align: inherit;
			border-color: inherit;
		}
		table {
			width: 94%;
			margin: 0 auto;
			font-size: 14px;
			margin-top: 10px;
			margin-bottom: 15px;
		}
	</style>
</head>
<body>
<table border="0" width="100%" cellspacing="0" cellpadding="3" class="small">
	<tbody>
	<tr>
		<td class="Big">
			<img src="/static/images/sys_config.gif" width="22" height="20" align="absmiddle"><span class="big3">  心通达OA系统信息</span>
			<input type="button" value="开发团队" class="BigButton" onclick="ShowDialog('developer');">
		</td>
	</tr>
	</tbody>
</table>
<table class="TableBlock" width="800" align="center" id="TableBlock"></table>
<script type="text/javascript">
    <!--
    $(function(){
            $.ajax({
                url:'../../sys/getSysMessage',
                type:'get',
                dataType:'json',
                success:function(data){
                    var str='<tbody><tr class="TableHeader">'+
                        '<td nowrap="" colspan="2" align="center"><b>+心通达OA - 系统信息</b></td></tr>'+
                        '<tr><td nowrap="" class="TableContent" width="150"><b>&nbsp;软件名称：</b></td>'+
                        '<td class="TableData">'+data.object.softName+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;系统版本：</b></td>'+
                        '<td class="TableData">'+data.object.softVersion+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;版本号：</b></td>'+
                        '<td class="TableData">'+data.object.softVersionNO+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;服务器路径：</b></td>'+
                        '<td class="TableData">'+data.object.serverPath +'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;jdk版本：</b></td>'+
                        '<td class="TableData">'+data.object.jdkVersion+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;组织机构名称：</b></td>'+
                        '<td class="TableData">'+data.object.orgName+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;机器码：</b></td>'+
                        '<td class="TableData">'+data.object.machineCode+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;软件序列号：</b></td>'+
                        '<td class="TableData">'+data.object.softSerialNo+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;用户信息：</b></td>'+
                        '<td nowrap="" class="TableData">'+data.object.userInfo+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;授权信息说明文字：</b></td>'+
                        '<td nowrap="" class="TableData">'+data.object.reloadAuthorizationstr+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;授权单位：</b></td>'+
                        '<td nowrap="" class="TableData">'+data.object.authorizationUnit+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;授权机器码：</b></td>'+
                        '<td nowrap="" class="TableData">'+data.object.authorizationCode+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;授权开始日期：</b></td>'+
                        '<td nowrap="" class="TableData">'+data.object.authorizationBeginDate+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;授权结束日期：</b></td>'+
                        '<td nowrap="" class="TableData">'+data.object.authorizationEndDate +'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;OA用户数限制：</b></td>'+
                        '<td nowrap="" class="TableData">'+data.object.oaUserLimit+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;移动用户数限制：</b></td>'+
                        '<td nowrap="" class="TableData">'+data.object.mobileTeriminalLimit+'</td></tr>'+
                        '<tr><td nowrap="" class="TableContent"><b>&nbsp;pc用户数限制：</b></td>'+
                        '<td nowrap="" class="TableData">'+data.object.pcTerminalLimit +'</td></tr></tbody>';
                    $("#TableBlock").html(str);
                }
            })
        }
    );
    //-->
</script>
</body>
</html>
