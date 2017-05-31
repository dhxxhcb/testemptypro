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
	<link rel="stylesheet" type="text/css" href="../../css/news/center.css"/>
	<link rel="stylesheet" type="text/css" href="../../lib/laydate.css"/>
	<link rel="stylesheet" type="text/css" href="../../lib/pagination/style/pagination.css"/>
	<link rel="stylesheet" type="text/css" href="../../css/base.css" />
	<link rel="stylesheet" type="text/css" href="../../css/news/new_news.css"/>
	<!-- 新闻管理  -->
	<link rel="stylesheet" type="text/css" href="../../css/news/management_query.css" />
	<script type="text/javascript" src="../../js/news/jquery-1.9.1.js"></script>
	<script src="../../js/news/page.js"></script>
	<script src="../../lib/laydate.js"></script>
	<script src="../../js/base/base.js" type="text/javascript" charset="utf-8"></script>
	<script src="../../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
	<!-- word文本编辑器 -->
	<script src="../../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
	<script src="../../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
	<script src="../../js/news/page.js"></script>
	<script src="../../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
	<style type="text/css">
		span.host-span {
			background: url(images/host.png) no-repeat;
			padding-left: 12px;
		}
		.operation_text_left {
			padding-left: 20px;
		}
		.operation_text_left {
			padding-left: 20px;
		.button-operation {
			float: left;
			padding-top: 4px;
		}
		.navigation .right {
			float: right;
			margin-top: -141px;
		}
		.btn-success {
			border: 1px solid #359947;
			color: #ffffff;
			background-color: #35aa47;
			background-image: -moz-linear-gradient(top, #35aa47, #35aa47);
			background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#35aa47), to(#35aa47));
			background-image: -webkit-linear-gradient(top, #35aa47, #35aa47);
			background-image: -o-linear-gradient(top, #35aa47, #35aa47);
			background-image: linear-gradient(to bottom, #35aa47, #35aa47);
			background-repeat: repeat-x;
			filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff35aa47', endColorstr='#ff35aa47', GradientType=0);
			filter: progid:DXImageTransform.Microsoft.gradient(enabled = false);
			width: 100px;
			height: 35px;
		}
		.btn-danger {
			border: 1px solid #c6322a;
			color: #ffffff;
			background-color: #d84a38;
			background-image: -moz-linear-gradient(top, #dd4b39, #d14836);
			background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#dd4b39), to(#d14836));
			background-image: -webkit-linear-gradient(top, #dd4b39, #d14836);
			background-image: -o-linear-gradient(top, #dd4b39, #d14836);
			background-image: linear-gradient(to bottom, #dd4b39, #d14836);
			background-repeat: repeat-x;
			filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffdd4b39', endColorstr='#ffd14836', GradientType=0);
			filter: progid:DXImageTransform.Microsoft.gradient(enabled = false);
			width: 100px;
			height: 35px;
		}
		form {
			margin: 0 0 20px;
		}
		.btn-info {
			border: 1px solid #46b8da;
			color: #ffffff;
			background-color: #5bc0de;
			background-image: -moz-linear-gradient(top, #5bc0de, #5bc0de);
			background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#5bc0de), to(#5bc0de));
			background-image: -webkit-linear-gradient(top, #5bc0de, #5bc0de);
			background-image: -o-linear-gradient(top, #5bc0de, #5bc0de);
			background-image: linear-gradient(to bottom, #5bc0de, #5bc0de);
			background-repeat: repeat-x;
			filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff5bc0de', endColorstr='#ff5bc0de', GradientType=0);
			filter: progid:DXImageTransform.Microsoft.gradient(enabled = false);
			width: 100px;
			height: 35px;
		}
		.step1_title {
			width: 6%;
			display: inline-block;
			float: left;
			margin-top: 28px;
		}
		.navigation {
			heihgt: 70px;
			/* display: inline-block; */
			/* float: left; */
			width:100%;
		}
		.navigation .left .news {
			/* font-size: 14px; */
			margin-left: 5px;
			font-family: "微软雅黑";
			margin-top: px;
			margin-right: 40px;
			font-size: 22px;
			color: #494d59;
			margin-top: 5px;
		}
		.navigation .left img {
			float: left;
			margin-top: 30px;
			margin-right: 5px;
			width: 25px;
			height: 24px;
		}
		.ui-state-default, .ui-widget-content .ui-state-default, .ui-widget-header .ui-state-default {
			background-color: #f5f5f4;
			background-image: none;
		}
		.ui-state-default, .ui-widget-content .ui-state-default, .ui-widget-header .ui-state-default th {
			border-bottom: 0px;
		}

		.ui-state-default, .ui-widget-content .ui-state-default, .ui-widget-header .ui-state-default {
			border: 1px solid #d3d3d3;
			background: #f5f5f5 url(images/fhbg.gif) 50% 50% repeat-x;
			font-weight: normal;
			color: #555555;
		}
		.ui-jqgrid .ui-jqgrid-hdiv {
			position: relative;
			margin: 0em;
			padding: 0em;
			overflow-x: hidden;
			border-left: 0px none !important;
			border-top: 0px none !important;
			border-right: 0px none !important;
		}
		.ui-jqgrid .ui-jqgrid-view, .ui-jqgrid .ui-jqgrid-pager {
			font-family: inherit;
		}
		.ui-jqgrid .ui-jqgrid-view, .ui-jqgrid .ui-jqgrid-pager {
			background-color: #fff;
			font-family: Microsoft YaHei,Simsun,Verdana,Arial,sans-serif;
			font-size: 9pt;
		}
		#gbox_gridTable {
			border: 1px solid #d3d3d3;
			-moz-border-radius: 2px, 2px, 0px, 0px;
			-webkit-border-radius: 2px, 2px, 0px, 0px;
			border-radius: 4px 4px 0px 0px;
		}
		.ui-jqgrid {
			border-left: 1px solid #d3d3d3;
			border-right: 1px solid #d3d3d3;
		}

		.ui-jqgrid {
			position: relative;
		}
		.head {
			border-bottom: 1px solid #9E9E9E;
			padding-bottom: 3px;
			height: 43px;
			background-color:#e4eff8;
		}
		.head li {
			width: 120px;
			text-align: center;
			height: 28px;
			line-height: 28px;
			display: inline-block;
			float: left;
			font-family: "微软雅黑";
			font-size: 14px;
			margin-left: 20px;
			margin-top: 6px;
			cursor: pointer;
		}
		.index_head li{
			border-right: 1px solid #b4c1ca;
			height: 37px;
		}
		.index_head li:hover{
			background-color: #F5F5F5;
			padding-bottom: 6px;
			color: blue;
			border: 0px;
			cursor: pointer;
		}
	</style>
	<style type="text/css">
		.search_area {
			padding: 8px 0px;
			margin: 0 auto;
			text-align: center;
			margin-top: 0px;
			background-color: #f5f5f5;
			border-bottom: 1px solid #dddddd;
		}
		.search_area {
			padding: 8px 0px;
			margin: 0 auto;
			text-align: center;
			margin-top: 0px;
			background-color: #f5f5f5;
			border-bottom: 1px solid #dddddd;
		}
		.form-search .input-append{
			margin-bottom: 0;
		}
		.form-search .input-append{
			display: inline-block;
			margin-bottom: 0;
			vertical-align: middle;
		}
		.form-search .input-append .search-query {
			-webkit-border-radius: 14px 0 0 14px;
			-moz-border-radius: 14px 0 0 14px;
			border-radius: 14px 0 0 14px;
		}
		.search_normal .input-append .btn {
			vertical-align: middle;
			/* background-color: #f5f5f4; */
		}
		input.search-query {
			padding-right: 14px;
			padding-right: 4px \9;
			padding-left: 14px;
			padding-left: 4px \9;
			margin-bottom: 0;
		}
		.btn-primary {
			border: 1px solid #3079ed;
			color: #ffffff;
			background-color: #4b8cf7;
			background-image: -moz-linear-gradient(top, #4d90fe, #4787ed);
			background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#4d90fe), to(#4787ed));
			background-image: -webkit-linear-gradient(top, #4d90fe, #4787ed);
			background-image: -o-linear-gradient(top, #4d90fe, #4787ed);
			background-image: linear-gradient(to bottom, #4d90fe, #4787ed);
			background-repeat: repeat-x;
			filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff4d90fe', endColorstr='#ff4787ed', GradientType=0);
			filter: progid:DXImageTransform.Microsoft.gradient(enabled = false);
		}
		input.span4, textarea.span4,.uneditable-input.span4 {
			width: 286px;
		}
		.span4 search-query{
			width:316px;
			height:30px;
		}
		.btn_checked {
			position: relative;
			padding: 4px 12px;
			margin: 0;
			color: #333;
			text-shadow: 0 1px 0 #fff;
			white-space: nowrap;
			font-family: Simsun, Arial, sans-serif;
			font-weight: bold;
			font-size: 13px;
			text-align: center;
			vertical-align: middle;
			-webkit-background-clip: padding;
			-moz-background-clip: padding;
			background-clip: padding;
			cursor: default;
			background-color: #f3f3f3;
			background-image: -moz-linear-gradient(top, #f5f5f5, #f1f1f1);
			background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#f5f5f5), to(#f1f1f1));
			background-image: -webkit-linear-gradient(top, #f5f5f5, #f1f1f1);
			background-image: -o-linear-gradient(top, #f5f5f5, #f1f1f1);
			background-image: linear-gradient(to bottom, #f5f5f5, #f1f1f1);
			background-repeat: repeat-x;
			filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#fff5f5f5', endColorstr='#fff1f1f1', GradientType=0);
			border: 1px solid #dcdcdc;
			-webkit-border-radius: 2px;
			-moz-border-radius: 2px;
			border-radius: 2px;
			-webkit-box-shadow: none;
			-moz-box-shadow: none;
			box-shadow: none;
		}
		#table1 {
			border-collapse: collapse;
			border-spacing: 0;
			margin-top: 6px;
			width: 700px;
			float: left;
		}
		.inp {
			height: 24px;
			width: 200px;
			height: 27px;
			border-radius: 6px;
			margin-top: 16px;
			margin-left: 97px;
		}
		.inp, .search {
			float: left;
		}
		.navigation .right {
			float: right;
			margin-top: 0px;
		}
		.subsearch {
			width: 63px;
			height: 33px;
			line-height: 28px;
			margin-top: 18px;
			margin-left: 10px;
			text-align: center;
			background-image: url(../../img/center_q.png);
			background-repeat: no-repeat;
			color: #fff;
			cursor: pointer;
			font-family: "微软雅黑";
		}
		.button-operation {
			float: left;
			padding-top: 4px;
		}
		.btn-success {
			border: 1px solid #359947;
			color: #ffffff;
			background-color: #35aa47;
			background-image: -moz-linear-gradient(top, #35aa47, #35aa47);
			background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#35aa47), to(#35aa47));
			background-image: -webkit-linear-gradient(top, #35aa47, #35aa47);
			background-image: -o-linear-gradient(top, #35aa47, #35aa47);
			background-image: linear-gradient(to bottom, #35aa47, #35aa47);
			background-repeat: repeat-x;
			filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff35aa47', endColorstr='#ff35aa47', GradientType=0);
			filter: progid:DXImageTransform.Microsoft.gradient(enabled = false);
			height: 30px;
			width: 70px;
		}
		.btn-info {
			border: 1px solid #46b8da;
			color: #ffffff;
			background-color: #5bc0de;
			background-image: -moz-linear-gradient(top, #5bc0de, #5bc0de);
			background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#5bc0de), to(#5bc0de));
			background-image: -webkit-linear-gradient(top, #5bc0de, #5bc0de);
			background-image: -o-linear-gradient(top, #5bc0de, #5bc0de);
			background-image: linear-gradient(to bottom, #5bc0de, #5bc0de);
			background-repeat: repeat-x;
			filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff5bc0de', endColorstr='#ff5bc0de', GradientType=0);
			filter: progid:DXImageTransform.Microsoft.gradient(enabled = false);
			height: 30px;
			width: 70px;
		}
		.head .one {
			background-color: #2F8AE3;
			font-size: 14px;
			color: #ffffff;
			border-radius: 20px;
		}
	</style>

</head>
<body>
<div class="bx">
	<!--head开始-->
	<div class="head w clearfix">
		<ul class="index_head">
			<li><span class="headli1_1">代办工作</span><img class="headli1_2" src="../../img/02.png" alt="">
			</li>

			<li><span class="headli2_1 endWork"  id="endWork">办结工作</span><img src="../../img/02.png" alt="" class="headli2_2">
			</li>
			<li><span class="headli3">关注</span><img src="../../img/02.png" alt="" class="headli2_2"></li>
			<li><span class="headli1_1 hungwork"  id="hungwork">挂起工作</span><img class="headli1_2" src="../../img/02.png" alt="">
			</li>

			<li><span class="headli2_1">委托</span><img src="../../img/02.png" alt="" class="headli2_2">
			</li>

			<li id="allwork" class="allwork"><span class="headli3 allwork"  id="allwork">全部工作</span></li>

		</ul>
	</div>
	<!--head通栏结束-->

	<!--navigation开始-->
	<div>
		<div class="step">
			<div class="navigation  clearfix">
				<div class="left">
					<img src="../../img/la2.png">
					<div class="news">待办工作</div>
					<div class="button-operation">
						<button type="button" action="new_work" class="btn btn-success">新建工作</button>
						<button type="button" action="intrust" class="btn btn-info">委托</button>
						<button type="button" action="pending" class="btn btn-info">挂起</button>
						<button type="button" action="comment" class="btn btn-info">批注</button>
						<form name="selected_export_form" id="selected_export_form" style="display: none;" method="post" action="data/work_to_export.php?ispirit_export=1">
							<input type="hidden" name="THE_ID_STR" id="THE_ID_STR" value="">
							<button type="submit" id="selected_export" class="btn btn-info">导出</button>
						</form>
						<button type="button" id="export" action="export" class="btn btn-info">导出工作列</button>
						<button type="button" action="refresh" class="btn btn-info">刷新</button>
					</div>
					<input id="flow_search_value" class="inp" type="text" placeholder="&nbsp;请输名称搜索">
					<div id="btn_search" class="search"><h1 style="cursor:pointer;" class='subsearch'>搜索</h1></div>
				</div>
				<div class="right">
					<!-- 分页按钮-->
					<div class="M-box3"></div>
				</div>
			</div>

			<!--navigation结束-->

			<!--content部分开始-->
			<div>
				<div>
					<table id="tr_td">
						<thead>
						<tr>
							<td class="th">
								流水号
							</td>
							<td class="th">
								公文名称/文号
							</td>
							<td class="th">
								我经办的步骤
							</td>

							<td class="th">
								发起人
							</td>
							<td class="th">
								状态
							</td>
							<td class="th">
								到达时间
							</td>
							<td class="th">
								已停留
							</td>
							<td class="th">
								操作
							</td>

						</tr>
						</thead>
						<tbody id="dbgz" class="tr_td">

						</tbody>
					</table>
				</div>
			</div>
			<!--content部分结束-->

		</div>
		<div class="step" style='display:none;'>
			<div class="navigation  clearfix">
				<div class="left">
					<img src="../../img/la2.png">
					<div class="news">办结工作</div>
					<input id="flow_search_value" class="inp" type="text" placeholder="&nbsp;请输名称搜索">
					<div id="btn_search" class="search"><h1 style="cursor:pointer;">搜索</h1></div>
				</div>
				<div class="right">
					<!-- 分页按钮-->
					<div class="M-box3" id="bjgz"></div>
				</div>
			</div>
			<!--navigation结束-->

			<!--content部分开始-->
			<div>
				<div>
					<table id="tr_td">
						<thead>
						<tr>
							<td class="th">
								流水号
							</td>
							<td class="th">
								公文名称/文号
							</td>
							<td class="th">
								我经办的步骤
							</td>

							<td class="th">
								发起人
							</td>
							<td class="th">
								办结时间
							</td>
							<td class="th">
								流程状态
							</td>
							<td class="th">
								操作
							</td>
						</tr>
						</thead>
						<tbody id="bjwork" class="tr_td">
						</tbody>
					</table>
				</div>
			</div>
			<!--content部分结束-->

		</div>
		<div class="step" style='display:none;'>
			<div class="navigation  clearfix">
				<div class="left">
					<img src="../../img/la2.png">
					<div class="news">关注工作</div>
					<input id="flow_search_value" class="inp" type="text" placeholder="&nbsp;请输名称搜索">
					<div id="btn_search" class="search"><h1 style="cursor:pointer;">搜索</h1></div>
				</div>
				<div class="right">
					<!-- 分页按钮-->
					<div class="M-box3" id="gzgz"></div>
				</div>
			</div>

			<!--navigation结束-->

			<!--content部分开始-->
			<div>
				<div>
					<table id="tr_td">
						<thead>
						<tr>
							<td class="th">
								流水号
							</td>
							<td class="th">
								公文名称/文号
							</td>
							<td class="th">
								我经办的步骤
							</td>

							<td class="th">
								发起人
							</td>
							<td class="th">
								办结时间
							</td>
							<td class="th">
								流程状态
							</td>
							<td class="th">
								操作
							</td>
						</tr>
						</thead>
						<tbody id="j_tb" class="tr_td">
						<tr>
							<td class="th">
								111
							</td>
							<td class="th">
								11
							</td>
							<td class="th">
								1111
							</td>

							<td class="th">
								111
							</td>
							<td class="th">
								111
							</td>
							<td class="th">
								11111
							</td>
							<td class="th">
								11111
							</td>
						</tr>
						<tr>
							<td class="th">
								22
							</td>
							<td class="th">
								112
							</td>
							<td class="th">
								11112
							</td>

							<td class="th">
								111
							</td>
							<td class="th">
								1112
							</td>
							<td class="th">
								111112
							</td>
							<td class="th">
								111112
							</td>

						</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!--content部分结束-->

		</div>

		<div class="step" style='display:none;'>
			<div class="navigation  clearfix">
				<div class="left">
					<img src="../../img/la2.png">
					<div class="news">挂起工作</div>
					<input id="flow_search_value" class="inp" type="text" placeholder="&nbsp;请输名称搜索">
					<div id="btn_search" class="search"><h1 style="cursor:pointer;">搜索</h1></div>
				</div>
				<div class="right">
					<!-- 分页按钮-->
					<div class="M-box3" id="gqgz"></div>
				</div>
			</div>

			<!--navigation结束-->

			<!--content部分开始-->
			<div>
				<div>
					<table id="tr_td">
						<thead>
						<tr>
							<td class="th">
								流水号
							</td>
							<td class="th">
								公文名称/文号
							</td>
							<td class="th">
								我经办的步骤
							</td>

							<td class="th">
								发起人
							</td>
							<td class="th">
								办结时间
							</td>
							<td class="th">
								流程状态
							</td>
							<td class="th">
								操作
							</td>
						</tr>
						</thead>
						<tbody id="gqwork" class="tr_td">

						</tbody>
					</table>
				</div>
			</div>
			<!--content部分结束-->

		</div>

		<div class="step" style='display:none;'>
			<div class="navigation  clearfix">
				<div class="left">
					<img src="../../img/la2.png">
					<div class="news">委托工作</div>
					<input id="flow_search_value" class="inp" type="text" placeholder="&nbsp;请输名称搜索">
					<div id="btn_search" class="search"><h1 style="cursor:pointer;">搜索</h1></div>
				</div>
				<div class="right">
					<!-- 分页按钮-->
					<div class="M-box3"></div>
				</div>
			</div>

			<!--navigation结束-->

			<!--content部分开始-->
			<div>
				<div>
					<table id="tr_td">
						<thead>
						<tr>
							<td class="th">
								流水号
							</td>
							<td class="th">
								公文名称/文号
							</td>
							<td class="th">
								我经办的步骤
							</td>

							<td class="th">
								发起人
							</td>
							<td class="th">
								办结时间
							</td>
							<td class="th">
								流程状态
							</td>
							<td class="th">
								操作
							</td>
						</tr>
						</thead>
						<tbody id="j_tb" class="tr_td">
						<tr>
							<td class="th">
								111
							</td>
							<td class="th">
								11
							</td>
							<td class="th">
								1111
							</td>

							<td class="th">
								111
							</td>
							<td class="th">
								111
							</td>
							<td class="th">
								11111
							</td>
							<td class="th">
								11111
							</td>
						</tr>
						<tr>
							<td class="th">
								22
							</td>
							<td class="th">
								112
							</td>
							<td class="th">
								11112
							</td>

							<td class="th">
								111
							</td>
							<td class="th">
								1112
							</td>
							<td class="th">
								111112
							</td>
							<td class="th">
								111112
							</td>

						</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!--content部分结束-->

		</div>

		<div class="step" style='display:none;'>
			<div class="navigation  clearfix">
				<div class="left">
					<img src="../../img/la2.png">
					<div class="news">全部工作</div>
					<input id="flow_search_value" class="inp" type="text" placeholder="&nbsp;请输名称搜索">
					<div id="btn_search" class="search"><h1 style="cursor:pointer;">搜索</h1></div>
				</div>
				<div class="right">
					<!-- 分页按钮-->
					<div class="M-box3" id="qbgz_page"></div>
				</div>
			</div>

			<!--navigation结束-->

			<!--content部分开始-->
			<div>
				<div>
					<table id="tr_td">
						<thead>
						<tr>
							<td class="th">
								流水号
							</td>
							<td class="th">
								流程类型
							</td>
							<td class="th">
								工作名称/文号
							</td>

							<td class="th">
								发起人
							</td>
							<td class="th">
								我的经办步骤
							</td>
							<td class="th">
								步骤状态
							</td>
						</tr>
						</thead>
						<tbody id="qbgz" class="tr_td">

						</tbody>
					</table>
				</div>
			</div>
			<!--content部分结束-->

		</div>
	</div>

</div>
<script type="text/javascript">
    <!--
    var datas = {
        page: 1,
        pageSize:10,
        useFlag: true,
        userId:'admin',
    };
    $(function(){
        $(".index_head li").click(function(){
            $(this).addClass("one").siblings().removeClass("one");
            var index=$(this).index();
            var head_title=$(this).text();
            $('.news').text(head_title);
            $(".step").eq(index).show().siblings().hide();
        });
//处理数据状态字段
        function handleData(data){
            switch(data){
                case 1:
                    str='未接收';
                    break;
                case 2:
                    str='办理中';
                    break;
                case 3:
                    str='转交下一步，下一步经办人无人接收';
                    break;
                case 4:
                    str='已办结';
                    break;
                case 5:
                    str='自由流程预设步骤';
                    break;
                case 6:
                    str='已挂起';
                    break;
                default:
                    str='办理中';
            }
        }
        $(document).ready(function(){
            initPageList_db(function (pageCount) {
                console.log(pageCount);
                initPagination_db(pageCount, datas.pageSize);
            },1);
        })

        $('#allwork').click(function(){
                initPageList_qb(function (pageCount) {
                    console.log(pageCount);
                    initPagination_qb(pageCount,datas.pageSize);
                },page);

            }
        );

        $('#endWork').click(function(){
                initPageList_bj(function (pageCount) {
                    console.log(pageCount);
                    initPagination_bj(pageCount,datas.pageSize);
                },page);

            }
        );

        $('#hungwork').click(function(){
                initPageList_gq(function (pageCount) {
                    console.log(pageCount);
                    initPagination_gq(pageCount,datas.pageSize);
                },page);

            }
        );

        function initPageList_qb(cb) {
            //var layerIndex = layer.load(0, {shade: false}); /* 0代表加载的风格，支持0-2 */
            $.ajax({
                url:'../../workflow/work/selectAll?page=1&pageSize=5&useFlag=true&userId=admin',
                type:'get',
                dataType:'json',
                //data:datas,
                success:function(data){
                    console.log(data);
                    var length=data.obj.length;
                    var str='';
                    for(var i=0;i<length;i++){
                        var status=handleData(data.obj[i].delFlag);
                        var str= str+'<tr><td class="th">'+data.obj[i].runId+'</td>'+
                            '<td class="th">流程类型</td>'+
                            '<td class="th">'+data.obj[i].flowRun.runName+'</td>'+
                            '<td class="th">'+data.obj[i].userName+'</td>'+
                            '<td class="th">我的步骤流程</td>'+
                            '<td class="th">'+status+'</td>';
                        //$('#dbgz').html(str);
                    }
                    $('#qbgz').html(str);
                    if (cb) {
                        alert(data.totleNum);
                        cb(data.totleNum);
                    }
                }
            })
        };

        function initPagination_qb(totalData, pageSize) {
            $('.M-box3').pagination({
                totalData: totalData,
                showData: pageSize,
                jump: true,
                coping: true,
                homePage:'',
                endPage: '',
                //prevContent: '',
                //nextContent: '',
                //jumpBtn: '',
                callback: function (index) {
                    var page = index.getCurrent();
                    console.log(index.getCurrent());
                    initPageList_qb(function (pageCount) {
                        console.log(pageCount);
                        initPagination_qb(pageCount, datas.pageSize);
                    } ,page);
                }
            });
        }

        function initPageList_db(cb,page){
            var datas ={
                page:page,
                pageSize:10,
                useFlag:true,
                userId:'admin',
            };
            $.ajax({
                url:'../../workflow/work/selectWork',
                type:'get',
                dataType:'json',
                data:datas,
                success:function(data){
                    console.log(data);
                    var length=data.obj.length;
                    var str='';
                    for(var i=0;i<length;i++){
                        var status=handleData(data.obj[i].prcsFlag);
                        var str= str+'<tr><td class="th">'+data.obj[i].runId+'</td>'+
                            '<td class="th">'+data.obj[i].flowRun.runName+'</td>'+
                            '<td class="th"></td><td class="th">'+data.obj[i].userName+'</td>'+
                            '<td class="th">'+status+'</td><td class="th"></td>'+
                            '<td class="th"></td>'+
                            '<td style="text-align:left;" title="主办导出删除">'+
                            '<a href="javascript:"><span class="host-span">主办</span></a>'+
                            '<a href=""><span class="operation_text_left">导出</span></a>'+
                            '<a href="javascript:">'+
                            '<span class="operation_text_left">删除</span></a></td></tr>';
                        //$('#dbgz').html(str);
                    }
                    $('#dbgz').html(str);
                    if (cb) {
                        alert(data.totleNum);
                        cb(data.totleNum);
                    }
                }
            });
        }

        function initPagination_db(totalData, pageSize) {
            $('.M-box3').pagination({
                totalData: totalData,
                showData: pageSize,
                jump: true,
                coping: true,
                homePage:'',
                endPage: '',
                //prevContent: '',
                //nextContent: '',
                //jumpBtn: '',
                callback: function (index) {
                    var page = index.getCurrent();
                    console.log(index.getCurrent());
                    initPageList_db(function (pageCount) {
                        console.log(pageCount);
                        initPagination_db(pageCount, datas.pageSize);
                    } ,page);
                }
            });
        }

        function initPageList_bj(cb,page){
            var datas ={
                page:page,
                pageSize:10,
                useFlag:true,
                userId:'admin',
            };
            $.ajax({
                url:'../../workflow/work/selectEndWord',
                //http://192.168.0.21/xoa/workflow/work/selectEndWord?page=1&pageSize=5&useFlag=true&userId=admin
                type:'get',
                dataType:'json',
                data:datas,
                success:function(data){
                    console.log(data);
                    var length=data.obj.length;
                    var str='';
                    for(var i=0;i<length;i++){
                        var status=handleData(data.obj[i].prcsFlag);
                        var str= str+'<tr><td class="th">'+data.obj[i].runId+'</td>'+
                            '<td class="th">'+data.obj[i].flowRun.runName+'</td>'+
                            '<td class="th">我经办的步骤</td><td class="th">'+data.obj[i].userName+'</td>'+
                            '<td class="th">'+data.obj[i].deliverTime+'</td><td class="th">流程状态</td>'+
                            '<td style="text-align:left;" title="主办导出删除">'+
                            '<a href="javascript:"><span class="host-span">主办</span></a>'+
                            '<a href=""><span class="operation_text_left">导出</span></a>'+
                            '<a href="javascript:">'+
                            '<span class="operation_text_left">删除</span></a></td></tr>';
                        //$('#dbgz').html(str);
                    }
                    $('#bjwork').html(str);
                    if (cb) {
                        alert(data.totleNum);
                        cb(data.totleNum);
                    }
                }
            });
        }


        function initPagination_bj(totalData, pageSize) {
            $('.M-box3').pagination({
                totalData: totalData,
                showData: pageSize,
                jump: true,
                coping: true,
                homePage:'',
                endPage: '',
                //prevContent: '',
                //nextContent: '',
                //jumpBtn: '',
                callback: function (index) {
                    var   page = index.getCurrent();
                    console.log(index.getCurrent());
                    initPageList_bj(function (pageCount) {
                        console.log(pageCount);
                        initPagination_bj(pageCount, datas.pageSize);
                    } ,page);
                }
            });
        }

        function initPageList_gq(cb,page){
            var datas ={
                page:page,
                pageSize:10,
                useFlag:true,
                userId:'admin',
            };
            $.ajax({
                url:'../../workflow/work/selectHang',
                //http://192.168.0.21/xoa/workflow/work/selectHang?page=1&pageSize=5&useFlag=true&userId=admin
                type:'get',
                dataType:'json',
                data:datas,
                success:function(data){
                    console.log(data);
                    var length=data.obj.length;
                    var str='';
                    for(var i=0;i<length;i++){
                        var status=handleData(data.obj[i].prcsFlag);
                        var str= str+'<tr><td class="th">'+data.obj[i].runId+'</td>'+
                            '<td class="th">'+data.obj[i].flowRun.runName+'</td>'+
                            '<td class="th">我经办的步骤</td><td class="th">'+data.obj[i].userName+'</td>'+
                            '<td class="th">'+data.obj[i].deliverTime+'</td><td class="th">流程状态</td>'+
                            '<td style="text-align:left;" title="主办导出删除">'+
                            '<a href="javascript:"><span class="host-span">主办</span></a>'+
                            '<a href=""><span class="operation_text_left">导出</span></a>'+
                            '<a href="javascript:">'+
                            '<span class="operation_text_left">删除</span></a></td></tr>';
                        //$('#dbgz').html(str);
                    }
                    $('#gqwork').html(str);
                    if (cb) {
                        alert(data.totleNum);
                        cb(data.totleNum);
                    }
                }
            });
        }


        function initPagination_gq(totalData, pageSize) {
            $('.M-box3').pagination({
                totalData: totalData,
                showData: pageSize,
                jump: true,
                coping: true,
                homePage:'',
                endPage: '',
                //prevContent: '',
                //nextContent: '',
                //jumpBtn: '',
                callback: function (index) {
                    var   page = index.getCurrent();
                    console.log(index.getCurrent());
                    initPageList_gq(function (pageCount) {
                        console.log(pageCount);
                        initPagination_gq(pageCount, datas.pageSize);
                    } ,page);
                }
            });
        }


    });
    //-->
</script>

</body>
</html>
