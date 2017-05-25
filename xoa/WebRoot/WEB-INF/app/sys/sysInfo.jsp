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
<table class="TableBlock" width="800" align="center">
	<tbody>
	  <tr class="TableHeader">
		<td nowrap="" colspan="2" align="center" onclick="alert('北京通达信科科技有限公司')"><b>心通达OA - 系统信息</b></td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent" width="150"><b>&nbsp;软件名称：</b></td>
		<td class="TableData">
			<!--<a href="javascript:ShowDialog('show_ver');">对应版本的说明</a>-->
		</td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;版权所有：</b></td>
		<td class="TableData">
		  
		</td>
	  </tr>
		<tr>
		<td nowrap="" class="TableContent"><b>&nbsp;OA版本：</b></td>
		<td class="TableData"></td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;Web服务版本号：</b></td>
		<td class="TableData"></td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;数据库版本号：</b></td>
		<td class="TableData"></td>
	  </tr>

	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;iOS版本号：</b></td>
		<td class="TableData"></td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;Andriod版本号：</b></td>
		<td class="TableData"></td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;精灵版本：</b></td>
		<td class="TableData"></td>
	  </tr>
	 <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;HTTP服务器软件：</b></td>
		<td nowrap="" class="TableData"></td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;HTTP端口号：</b></td>
		<td nowrap="" class="TableData"></td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;数据库软件：</b></td>
		<td nowrap="" class="TableData"></td>
	  </tr>

	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;用户单位：</b></td>
		<td nowrap="" class="TableData"></td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;实际用户数：</b></td>
		<td nowrap="" class="TableData"></td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;软件注册：</b></td>
		<td nowrap="" class="TableData"></td>
	  </tr>

	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;OA用户数限制：</b></td>
		<td nowrap="" class="TableData"></td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;IM用户数限制：</b></td>
		<td nowrap="" class="TableData"></td>
	  </tr>
	  <tr>
		<td nowrap="" class="TableContent"><b>&nbsp;分支机构数限制：</b></td>
		<td nowrap="" class="TableData"></td>
	  </tr>
	</tbody>
</table>
</body>
</html>
