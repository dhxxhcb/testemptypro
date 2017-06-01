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
	<title>系统代码设置</title>
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
		<style type="text/css">
		#west {
			width: 220px;
			position: absolute;
			top: 0;
			left: 0;
			bottom: 0;
			overflow: auto;
		}
		#center {
			position: absolute;
			top: 0px;
			bottom: 0;
			left: 220px;
			right: 0;
			overflow: hidden;
		}
	</style>
	</style>
</head>
<body marginwidth="0" marginheight="0">
<div id="west">
	<div class="head"><img src="/static/images/menu/system.gif" align="absMiddle">代码主分类设置</div>
	<ul>
		<li><a href="new.php" onclick="" target="code_edit" title="增加代码主分类" id="link_1"><span>增加代码主分类</span></a></li>
		<div id="module_1" class="moduleContainer" style=""><table class="TableBlock" width="100%"><tbody><tr class="TableData" title="外部信息类型">
			<td>
				<b>外部信息类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=531" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=531" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="排班类型">
			<td>
				<b>排班类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=466" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=466" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="值班类型">
			<td>
				<b>值班类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=471" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=471" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="项目类型">
			<td>
				<b>项目类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=180" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=180" target="code_edit"> 下一级</a>&nbsp;<a href="javascript:delete_code(180,'PROJ_TYPE','项目类型');"> 删除</a></td></tr><tr class="TableData" title="项目费用类型">
			<td>
				<b>项目费用类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=183" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=183" target="code_edit"> 下一级</a>&nbsp;<a href="javascript:delete_code(183,'PROJ_COST_TYPE','项目费用类型');"> 删除</a></td></tr><tr class="TableData" title="项目文档类型">
			<td>
				<b>项目文档类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=187" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=187" target="code_edit"> 下一级</a>&nbsp;<a href="javascript:delete_code(187,'PROJ_DOC_TYPE','项目文档类型');"> 删除</a></td></tr><tr class="TableData" title="项目角色类型">
			<td>
				<b>项目角色类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=191" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=191" target="code_edit"> 下一级</a>&nbsp;<a href="javascript:delete_code(191,'PROJ_ROLE','项目角色类型');"> 删除</a></td></tr><tr class="TableData" title="提醒类型">
			<td>
				<b>提醒类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=1" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=1" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="工作日志类型">
			<td>
				<b>工作日志类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=135" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=135" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="日程安排类型">
			<td>
				<b>日程安排类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=138" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=138" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="公告通知类型">
			<td>
				<b>公告通知类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=20" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=20" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="新闻类型">
			<td>
				<b>新闻类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=21" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=21" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="办公用品类别">
			<td>
				<b>办公用品类别</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=151" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=151" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="同类设备名称">
			<td>
				<b>同类设备名称</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=439" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=439" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="车辆类型">
			<td>
				<b>车辆类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=49" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=49" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="车辆维护类型">
			<td>
				<b>车辆维护类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=492" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=492" target="code_edit"> 下一级</a>&nbsp;<a href="javascript:delete_code(492,'VEHICLE_REPAIR_TYPE','车辆维护类型');"> 删除</a></td></tr><tr class="TableData" title="车辆性质">
			<td>
				<b>车辆性质</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=556" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=556" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="油卡使用状态">
			<td>
				<b>油卡使用状态</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=565" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=565" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="HTML模板类型">
			<td>
				<b>HTML模板类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=512" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=512" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="微讯快捷回复">
			<td>
				<b>微讯快捷回复</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=505" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=505" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="公文分类">
			<td>
				<b>公文分类</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=498" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=498" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="职称">
			<td>
				<b>职称</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=143" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=143" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="用工类型">
			<td>
				<b>用工类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=144" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=144" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="学历">
			<td>
				<b>学历</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=170" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=170" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="在职状态">
			<td>
				<b>在职状态</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=449" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=449" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="政治面貌">
			<td>
				<b>政治面貌</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=455" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=455" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="固定资产维护类型">
			<td>
				<b>固定资产维护类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=486" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=486" target="code_edit"> 下一级</a>&nbsp;<a href="javascript:delete_code(486,'ASSET_KEEP_TYPE','固定资产维护类型');"> 删除</a></td></tr><tr class="TableData" title="产品类别">
			<td>
				<b>产品类别</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=40" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=40" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="客户来源">
			<td>
				<b>客户来源</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=41" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=41" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="客户类型">
			<td>
				<b>客户类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=42" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=42" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="销售方式">
			<td>
				<b>销售方式</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=43" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=43" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="行业属性">
			<td>
				<b>行业属性</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=44" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=44" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="企业性质">
			<td>
				<b>企业性质</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=45" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=45" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="客户服务类型">
			<td>
				<b>客户服务类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=46" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=46" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="合同类型定义">
			<td>
				<b>合同类型定义</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=47" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=47" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="地区">
			<td>
				<b>地区</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=48" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=48" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="采购订单类型">
			<td>
				<b>采购订单类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=142" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=142" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="档案密级">
			<td>
				<b>档案密级</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=196" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=196" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="凭证类别">
			<td>
				<b>凭证类别</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=197" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=197" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="文件紧急等级">
			<td>
				<b>文件紧急等级</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=198" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=198" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="文件分类">
			<td>
				<b>文件分类</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=199" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=199" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="公文类别">
			<td>
				<b>公文类别</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=200" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=200" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="RSS订阅类别">
			<td>
				<b>RSS订阅类别</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=152" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=152" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="套红模板类别">
			<td>
				<b>套红模板类别</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=464" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=464" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="敏感词语过滤模块">
			<td>
				<b>敏感词语过滤模块</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=166" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=166" target="code_edit"> 下一级</a>&nbsp;</td></tr><tr class="TableData" title="系统日志类型">
			<td>
				<b>系统日志类型</b>
			</td>
			<td nowrap="">
				<a href="edit.php?IS_MAIN=&amp;CODE_ID=22" target="user_main"> 编辑</a>&nbsp;
				<a href="func/?CODE_ID=22" target="code_edit"> 下一级</a>&nbsp;</td></tr></tbody></table></div>
		<li><a href="func/no_link.php" onclick="" target="code_edit" title="错误代码列表" id="link_2"><span>错误代码列表</span></a></li>
		<li><a href="imp_exp/" onclick="" target="code_edit" title="代码备份/恢复" id="link_3"><span>代码备份/恢复</span></a></li>
	</ul>
</div>
<div id="center">
	<!--<iframe src="new.php" id="code_edit" name="code_edit" frameborder="0"></iframe>-->
</div>
</body>
</html>
