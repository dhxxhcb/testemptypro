<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!-- saved from url=(0079)file:///C:/Users/gaosubo/Desktop/OA%E7%B2%BE%E7%81%B5_files/saved_resource.html -->
<html><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <script type="text/javascript">
        var MYOA_JS_SERVER = "";
        var MYOA_STATIC_SERVER = "";
    </script>
    <link rel="stylesheet" type="text/css" href="../css/spirit/ipanel.css">
    <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
   <!--  <script src="../js/spirit/ispirit.js"></script> -->
    <!-- <script src="../js/spirit/index_ispirit.js"></script> -->
    <script>
       
    </script>
    <style>
        html, body {
            overflow: hidden;
        }

        #bottom {
            height: 0px;
        }
    </style>
</head>


<body marginwidth="0" marginheight="0">
<div id="tabs">
    <ul id="nav_menu">
        <li id="li_1"><a id="menu_1" href="javascript:view_menu(&#39;1&#39;);" hidefocus="hidefocus" title="导航菜单"
                         class="active"><span class="yy_icon"></span><span>应用</span></a></li>
        <li id="li_2"><a id="menu_2" href="javascript:view_menu(&#39;2&#39;);" hidefocus="hidefocus" title="组织机构及人员"
                         class=""><span class="zz_icon"></span><span>组织</span></a></li>
        <!-- <li id="li_3"><a id="menu_3" href="javascript:view_menu(&#39;3&#39;);" hidefocus="hidefocus" title="微讯" class=""><span>微讯</span></a></li>-->
        <li id="li_4"><a id="menu_4" href="javascript:view_menu(&#39;4&#39;);" hidefocus="hidefocus" title="云便签"
                         class=""><span class="bq_icon"></span><span>便签</span></a></li>
    </ul>
</div>
<div id="panels_container" style="height: 531px;">
    <div id="panel_menu" class="panel" style="height: 100%; display: block;">
        <iframe id="menu" name="menu" src="menu.html"
                data-src="/general/ipanel/menu.php?ISPIRIT=1&amp;I_VER=2&amp;MENU_UI_HIDE=" allowtransparency="true"
                border="0" frameborder="0" framespacing="0" marginheight="0" marginwidth="0"
                style="width: 100%; height: 531px;"></iframe>
    </div>

    <div id="panel_org" class="panel" style="display: none;">
        <iframe id="org" name="org" src="zz"
                data-src="/general/ipanel/user/?ISPIRIT=1&amp;I_VER=2" allowtransparency="true" border="0"
                frameborder="0" framespacing="0" marginheight="0" marginwidth="0"
                style="width: 100%; height: 531px;"></iframe>
    </div>
    <!--
       <div id="panel_smsbox" class="panel" style="display: none;">
           <iframe id="smsbox" name="smsbox" src="./saved_resource(2).html" data-src="/general/ipanel/smsbox/?ISPIRIT=1&amp;I_VER=2" allowtransparency="true" border="0" frameborder="0" framespacing="0" marginheight="0" marginwidth="0" style="width: 100%; height: 531px;"></iframe>
       </div>
       -->
    <div id="panel_note" class="panel" style="display: none;">
        <iframe id="note" name="note" src="bq"
                data-src="/general/ipanel/note/?ISPIRIT=1&amp;I_VER=2" allowtransparency="true" border="0"
                frameborder="0" framespacing="0" marginheight="0" marginwidth="0"
                style="width: 100%; height: 531px;"></iframe>
    </div>
</div>

<div id="bottom">
    <span id="bottom_left"></span>
    <span id="bottom_center" style="width: 0px;"></span>
    <span id="bottom_right"></span>
</div>

</body>
</html>