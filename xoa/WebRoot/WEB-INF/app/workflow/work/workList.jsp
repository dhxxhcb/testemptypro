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
<style type="text/css">
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
</style>

</head>
<body>
<div class="bx">
    <!--head开始-->
    <div class="head w clearfix">
        <ul class="index_head">
            <li data_id="" id='db'>
				<a  href="#todo" data-toggle="tab">待办工作</a>
            </li>
            <li data_id="0" id='bj'>
				<a  href="#settles" data-toggle="tab">办结工作</a>
				
            </li>
			<li data_id="1" id='gz'>
				<a href="#concern" data-toggle="tab">关注工作</a>
			</li>
			<li data_id="" id='db'>
			<span class="">
				<a  href="#pending" data-toggle="tab">挂起工作</a>
				
            </li>
            <li data_id="0" id='bj'>
				<a href="#intrust" data-toggle="tab">委托工作</a>
            </li>
            <li data_id="1" id='gz'>
				<a  href="#data_all" data-toggle="tab">全部工作</a>
			</li>
        </ul>
    </div>
    <!--head通栏结束-->
	<!--搜索开始-->
	<div class="search_area search_normal" id="search_normal_div" pagetype="">
		<div class="form-search">
			<div class="input-append">
				<input type="text" id="search_para" class="span4 search-query" placeholder="请输入要查询的流水号或工作名称/文号">
				 <button type="button" id="normalSearchBtn" class="btn btn-primary">查询</button>
			</div>
			&nbsp;&nbsp;
			<button type="button" id="toAdvSearch" class="btn_checked">切换至高级查询</button>
		</div>
	</div>
<!--搜索结束-->
    <!--navigation开始-->
    <div class="step1">
	<div class="navigation  clearfix">
            <div class="left">
            <img src="../../img/la2.png">
			 <div class="news">全部新闻</div>
                <div class="data-operation">
					<div class="button-operation" style="width:1000px;">
						<button type="button" action="new_work" class="btn btn-success">新建工作</button>
						<button type="button" action="cancel_concern" class="btn btn-danger">取消关注</button>
						<form name="selected_export_form" id="selected_export_form" style="display: none;" method="post" action="data/work_to_export_concern.php">
							<input type="hidden" name="THE_ID_STR" id="THE_ID_STR" value="">
							<button type="submit" id="selected_export" class="btn btn-info">导出</button>
						</form>
						<button type="button" id="export" action="export_concern" class="btn btn-info">导出工作列表</button>
						<button type="button" action="refresh" class="btn btn-info">刷新</button>
					</div>
				</div>
				<div class="data-list">
				<table id='table1' class="table">
					 <thead>
                    <tr>
                        <td class="th">
                            标题
                        </td>
                        <td class="th">
                            所有类型
                        </td>
                       
                        <td class="th">
                            发布日期
                        </td>

                        <td class="th">
                            点击次数
                        </td>
                        <td class="th">
                            评论
                        </td>
                        <!-- <td class="th">发布部门</td> -->
                    </tr>
                    </thead>
					<tbody id="j_tb" calss="tr_td">
						<tr>
							<td>11</td>
							<td>11</td>
							<td>11</td>
							<td>11</td>
							<td>11</td>
						</tr>
						<tr>
							<td>22</td>
							<td>22</td>
							<td>22</td>
							<td>22</td>
							<td>22</td>
						</tr>
					</tbody>
				</table>
				</div>
            </div>

            <div class="right">
                <!-- 分页按钮-->
                <div class="M-box3"><span class="active">1</span><a href="javascript:;" data-page="2">2</a><a href="javascript:;" class="next">下页</a><input type="text" class="jump-ipt"><a href="javascript:;" class="jump-btn">跳转</a></div>

            </div>
        </div>
        <!--navigation结束-->

        <!--content部分开始-->
        <!--content部分结束-->
    </div>

    <!-- 新建新闻页面********************* -->
    <div class="step2" style="display: none;margin-left: 10px;">
		<table>
		<tr><td>1</td><td>2</td><td>3</td><td>4</td></tr>
		<tr><td>1</td><td>2</td><td>3</td><td>4</td></tr>
		<tr><td>1</td><td>2</td><td>3</td><td>4</td></tr>
		</table>
       </div>
    <!--content部分结束-->

    <!-- 新闻查询 ***********************-->
    <div class="step3" style="display:none; margin-left:10px">
       111111
    </div>
    <!--content部分结束-->
    <!--<script type="text/javascript">
    <!--
		 $("#db").click(function(){
		 		console.log('11');
				$('.step1').show();
				$('.step2').hide();
				$('.step3').hide();
				});
		$("#bj").click(function(){
		console.log('22');
			$('.step2').show();
			$('.step1').hide();
			$('.step3').hide();

		});
		$("#gz").click(function(){
		console.log('33');
			$('.step3').show();
			$('.step1').hide();
			$('.step2').hide();
		});
 
    </script>-->
</body>
</html>
