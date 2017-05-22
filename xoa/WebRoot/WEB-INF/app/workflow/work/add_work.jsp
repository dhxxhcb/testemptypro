<%--
  Created by IntelliJ IDEA.
  User: gsubo
  Date: 2017/5/22
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<!--[if IE 6 ]> <html class="ie6 lte_ie6 lte_ie7 lte_ie8 lte_ie9"> <![endif]-->
<!--[if lte IE 6 ]> <html class="lte_ie6 lte_ie7 lte_ie8 lte_ie9"> <![endif]-->
<!--[if lte IE 7 ]> <html class="lte_ie7 lte_ie8 lte_ie9"> <![endif]-->
<!--[if lte IE 8 ]> <html class="lte_ie8 lte_ie9"> <![endif]-->
<!--[if lte IE 9 ]> <html class="lte_ie9"> <![endif]-->
<!--[if (gte IE 10)|!(IE)]><!--><html><!--<![endif]-->
<head>
    <title>新建工作</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8 ? MYOA_CHARSET : htmlspecialchars($HTML_PAGE_CHARSET))?>" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <!--[if lte IE 8]>
    <script type="text/javascript" src="/static/js/ccorrect_btn.js"></script>
    <![endif]-->

    <script type="text/javascript" >
        var MYOA_JS_SERVER = "";
        var MYOA_STATIC_SERVER = "";
    </script>
</head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/newwork.css" />
<link rel="stylesheet" type="text/css" href="css/new.css">
<script type="text/javascript" src="/inc/js_lang.php"></script>
<script type="text/javascript" src="/static/js/jquery-1.10.2/jquery.min.js"></script>
<!--<script src="/static/js/bootstrap/js/bootstrap.min.js"></script>-->
if(window.external && typeof window.external.OA_SMS != 'undefined') //如果从OA精灵打开，则最大化窗口
{
var h = Math.min(800, screen.availHeight - 180);
var w = Math.min(1280, screen.availWidth - 80);
window.external.OA_SMS(w, h, "SET_SIZE");
}
</script>
<style type="text/css">
#flow_sort_nav > a{
text-decoration:none;
color:#666666;
font-size: 18px;
font-weight:bold;
}
#flow_sort_nav > a:hover{
text-decoration:none;
color:#589Fff;
font-weight:bold;

}
#flow_sort_nav > a:active{
text-decoration:none;
color:#589Fff;
font-weight:bold;
}
div.pointer{
background:url(/general/system/workflow/flow_form/css/images/pointer.png) no-repeat 100% 15%;
width:16px;
height:30px;
float:left;
position: relative;
margin-top: 8px;

}
</style>
<script type="text/javascript">
var loading='<div class="loading">正在加载，请稍候...</div>';
var load_error = '<div class="message">加载数据失败</div>';
var quick_flow_tips = '此工作要求强制输入%s，确定进入新建向导？';
</script>
<body>
<input id="cur_user" type="hidden" value="1">
<div class="container-fluid">
    <div class="row-fluid title-row" style="position:fixed;background-color:#f8f8f8;z-index:99;border-bottom:1px solid #ddd;height:60px;">
        <div id="title" class="date">
            <h3 style="margin-bottom:0px;">
                新建工作                </h3>
        </div>

        <div class="abs-right" style="position:fixed;">
            <div class="search_area form-search">
                <!--
                <div class="navbar">
                    <ul class="nav">
                        <li class="dropdown">
                            <button class="btn dropdown-toggle" id="compositor_id"><span class="icon-arrow-down" compositor_id="0"></span>最近使用&nbsp;<span class="caret"></span></button>
                            <ul class="dropdown-menu" >
                                <li><a href="#" ><span class="icon-arrow-up" compositor_id="1"></span>最近使用&nbsp;<span class="caret"></span></a></li>
                                <li><a href="#" ><span class="icon-arrow-down" compositor_id="2"></span>名称&nbsp;<span class="caret"></span></a></li>
                                <li><a href="#" ><span class="icon-arrow-up" compositor_id="3"></span>名称&nbsp;<span class="caret"></span></a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                -->
                <div class="input-append new-search">
                    <input type="text" class="search-query" id="form_select" name="form_select" placeholder="请输入流程名称">
                    <button type="submit" class="btn btn-primary" id="searchbtn" onclick="form_select()">查询</button>
                    <div class="btn-group" style="margin-left:8px;">
                        <a class="btn" style="zoom:1;font-weight:normal;" id="w_list_view" href="javascript:;" onclick=""><span>任务视图</span></a>
                    </div>

                    <div class="btn-group" style="margin-left:-1px;" >
                        <button class="btn" style="font-weight:normal;" id="w_task_view" onclick="to_old_new_work()" ><span>列表视图</span></button>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div style="padding-left: 200px;margin-top: 60px;font-size:14px;font-family: Simsun, Arial, sans-serif;padding-top: 3px;">
        <div class="pointer" style="position:absolute;left: 190px;top:63px;">&nbsp;</div>&nbsp;
        <div id="flow_sort_nav" class="" style="margin-top:12px;display:inline-block; color: #3D80B5;"></div>
    </div>
    <div id="taskbox" class="row-fluid" style="margin-top: -36px;" >
        <div class="left" style="position: absolute;">
            <div class="tabbable tabs-left" id="tabs-271640">
                <ul class="nav nav-tabs" id="f_new_block">

                </ul>
            </div>
        </div>
        <div class="child_menu" id="child_menu"></div>
        <div class="right">
            <div class="count-title" id="count-title"></div>
            <div class="new-tab-content">
                <div class="tab-pane active" style="margin-top:31px;">
                    <ul class='taskblock' id="panel-inbox">
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" id="user_id" name="user_id" value="admin">
    <input type="hidden" id="sort_id" name="sort_id" value="">
    <input type="hidden" id="user_priv" name="user_other_priv" value="1">
    <input type="hidden" id="user_other_priv" name="user_other_priv" value="1">
    <input type="hidden" id="user_dept" name="user_dept" value="2">
    <input type="hidden" id="user_other_dept" name="user_other_dept" value="">
</div>
<!--by yzx to show flow explanation -->
<!--<div id="div_explanation" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-header  hide_title">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	        <h3 id="myModalLabel">
	            流程说明	        </h3>
	    </div>
	    <div class="modal-body dump_window_body" id="div_explanation_body">
	    </div>
	    <div class="modal-footer dump_window_footer">
	        <button id="hide_window_close" class="btn" data-dismiss="modal" aria-hidden="true">
	            关闭	        </button>
	    </div>
	</div>-->
<!-- end -->
</body>
</html>
<script id="f_new_blockTmpl" type="text/x-jsrender">
	{{for runData}}
        <li class="{{:className}}" data-submenu-id="{{:sort_id}}">
            <a id="inbox_{{:count}}" sort_id="{{:sort_id}}" sort_parent="" class="inbox" data-toggle="tab"  href="#" hidefocus="hidefocus" onclick="flow_sort_list({{:sort_id}},'',this)"  title="{{:sort_name}}"><i class="icon icon-inbox"></i>{{:sort_name}}<em></em></a>
            {{if child_category.length!=0}}
                <div id="{{:sort_id}}" class="child_menu">
                     <h4 style="color: rgb(47, 128, 209);font-weight: bold;">{{:sort_name}}</h4>
                     {{for child_category}}
                        <a class="filter_2" sort_id="{{:SORT_ID}}" sort_parent="{{:SORT_PARENT}}" style="color: rgb(88, 159, 224);font-weight: bold;" data-toggle="tab"  href="#" hidefocus="hidefocus" onclick="flow_sort_list({{:SORT_ID}},'',this)"  title="{{:REAL_NAME}}">{{:SORT_NAME}}<em></em></a>
                        {{if child_category.length!=0}}
                            <ul style="margin-left:0px;">
                            {{for child_category}}
                                <li> <a sort_id="{{:SORT_ID}}" sort_parent="{{:SORT_PARENT}}" style="color: #666666;font-size:12px;" data-toggle="tab"  href="#" hidefocus="hidefocus" onclick="flow_sort_list({{:SORT_ID}},'',this)"  title="{{:REAL_NAME}}">{{:SORT_NAME}}<em></em></a> </li>
                                {{for child_category_all}}
                                    <li style="margin-left:0;"> <a sort_id="{{:SORT_ID}}" sort_parent="{{:SORT_PARENT}}" style="color: #666666;font-size:12px;" data-toggle="tab"  href="#" hidefocus="hidefocus" onclick="flow_sort_list({{:SORT_ID}},'',this)"  title="{{:REAL_NAME}}">{{:SORT_NAME}}<em></em></a> </li>
                                {{/for}}
                            {{/for}}
                            </ul>
                        {{/if}}
                     {{/for}}
                </div>
            {{/if}}

        </li>
	{{/for}}
</script>

<script id="panel-inboxTmpl" type="text/x-jsrender">
	{{for runData}}
		<li class='new-task-item clearfix'>
			<div class='task-item-op pull-right'>
				<div class='btn-group'>
                	<button class='btn btn-success' onClick="quick_flow('{{:flow_id}}', '新建工作 - {{:flow_name}}', '{{:edit_str}}', '{{:trigger}}')" item_id='".$TCID."'  action='cal_ok_quick'>
                    	快速新建                	</button>
            	</div>
                <div class='btn-group'>
                	<button class='btn btn-warning' item_id='".$TCID."' onclick="guide_flow('{{:flow_id}}', '新建工作 - {{:flow_name}}')" action='delay'>
                         新建向导                	</button>
                </div>
            </div>
            <div class='new-item-info pull-left'>
                <h4 title="{{:flow_names}} 【单击为新建向导，双击为快速新建】" onclick="javascript: clearTimeout(this.timer); this.timer=setTimeout(function(){guide_flow('{{:flow_id}}', '新建工作 - {{:flow_name}}');},300);" ondblclick="javascript: clearTimeout(this.timer);quick_flow('{{:flow_id}}', '新建工作 - {{:flow_name}}', '{{:edit_str}}', '{{:trigger}}');"><span class='new-item-run-name'>{{:flow_name}}</span></h4>
                <p title="{{:flow_time}}">{{:flow_times}}</p>
            </div>
            <div class='new-item-time new_flow_img pull-left' title="点击查看流程设计图" onClick="view_graph({{:flow_id}})">
            	<span class='new-item-time-span'>流程设计图</span>
            </div>
            <div class='new-item-time new_form_img pull-left'  title="点击查看表单模板" onClick="view_form({{:flow_id}},{{:form_id}})">
            	<span class='new-item-time-span'>流程表单</span>
            </div>
            <div class='new-item-time new_content_img pull-left' title="点击查看流程说明" onClick="show_explanation({{:flow_id}})">
            	<span class='new-item-time-span'>流程说明</span>
            </div>
		</li>
	{{/for}}
</script>

<script>
    $(window).resize((function(){
        var timer = null,
            sizes = ['w900', 'w1200'];
        var response = function(){
            var w = $(window).width();
            var h = $(window).height();
            var cls = sizes[w >=1170 ? 1 : 0];
            $('html').removeClass(sizes.join(' ')).addClass(cls);
            $('div .child_menu').height(h-65);
        };
        return function(){
            timer && clearTimeout(timer);
            timer = setTimeout(response, 100);
        }
    })()).resize();
</script>