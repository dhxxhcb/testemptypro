<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!-- saved from url=(0082)file:///C:/Users/gaosubo/Desktop/OA%E7%B2%BE%E7%81%B5_files/saved_resource(1).html -->
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
    <link rel="stylesheet" type="text/css" href="../css/spirit/style.css">
    <link rel="stylesheet" type="text/css" href="../css/spirit/ipanel.css">
    <link rel="stylesheet" type="text/css" href="../css/spirit/user_online.css">
    <link rel="stylesheet" type="text/css" href="../css/spirit/ui.dynatree.css">
    <!--<script type="text/javascript" src="./js_lang.php"></script>-->
    <script type="text/javascript" src="../jstree.js"></script>
    <script type="text/javascript" src="../jsispirit.js"></script>
    <script type="text/javascript" src="../jsjquery.min.js"></script>
    <script type="text/javascript" src="../jsjquery-ui.custom.min.js"></script>
    <script type="text/javascript" src="../jsjquery.cookie.js"></script>
    <script type="text/javascript" src="../jsjquery.dynatree.min.js"></script>
    <script type="text/javascript" src="../jsorg.js"></script>
    <script type="text/javascript">
        var ispirit = "1";
        var bEmailPriv = true;
        var bSmsPriv = true;
        var online_ui = "1";
        var online_ui_1 = "0";
        var online_ui_2 = "";
        var online_ui_4 = "";
        var op_sms = "1";
        var jsonURL0 = '/inc/online.php?PARA_URL2=/general/ipanel/user/user_info.php&PARA_TARGET=_blank&PARA_ID=ISPIRIT&PARA_VALUE=1&SHOW_IP=1&PWD=e60266ac02274b66&OP_SMS=1';
        var jsonURL1 = '/inc/user_list/tree.php?MANAGE_FLAG=0&DEPT_ID=0&PARA_URL1=&PARA_URL2=/general/ipanel/user/user_info.php&e=&PARA_TARGET=_blank&PRIV_NO=&PARA_ID=ISPIRIT&PARA_VALUE=1&MODULE_ID=2&SHOW_IP=1&PWD=e60266ac02274b66&DEPT_PRIV=1&ROLE_PRIV=2&PRIV_NO_FLAG=0&OP_SMS=1&rand=599191886';
        var orgTree0 = orgTree1 = null;
        var online_ref_sec = '120';
        var online_last_ref = (new Date()).getTime();
        var online_ref_interval = all_ref_interval = null;
        var online_uid_str = "";
        var online_client_str = "";
        var on_status_str = "";
        var online_uid_array = new Array();
        var online_client_array = new Array();
        var on_status_array = new Array();
        var useIspiritCache = (typeof(window.external.OA_SMS) == 'undefined' || typeof(window.top.bIMLogin) == 'undefined' || (typeof(window.console) != 'undefined' && typeof(window.console.OaSms) != 'undefined')) ? false : true;
        var useIspiritCache0 = 1;
        var useIspiritCache1 = 1;
        var exclude_uid_str = "";
        var show_ip = true;
        var para_url1 = "";
        var para_url2 = "";
        var para_id = "ISPIRIT";
        var para_value = "1";
        var para_target = "_blank";

        function init() {
            jQuery("#body").height(jQuery(window).height() - jQuery("#sub_tabs").outerHeight());
        }

        window.onresize = init;
    </script>
</head>


<body onload="init();window.setTimeout(init, 1);" marginwidth="0" marginheight="0">
<div id="sub_tabs" class="sub_tabs">
    <ul id="sub_tabs_ul">
        <li><a href="javascript:;" title="人员" index="1" module="org" class="active"><span
                class="dropdown-containter"><label id="label_org">在线</label><span class="dropdown"></span></span></a>
        </li>
        <li><a href="javascript:;" title="分组" index="2" module="user_group"><span class="dropdown-containter">分组<span
                class="dropdown"></span></span></a></li>
        <li><a href="javascript:;" title="最近联系人" index="3" module="recent"><span>最近</span></a></li>
        <li><a href="javascript:;" title="群组" index="4" module="im_group"><span>群组</span></a></li>
    </ul>
    <a id="org_refresh" href="javascript:;" title="刷新"></a>
</div>
<div id="sub_menu_org" class="sub_menu" style="width: 110px; display: none;">
    <a href="javascript:;" index="0" class="active">显示在线人员</a>
    <a href="javascript:;" index="1" class="">显示全部人员</a>
</div>
<div id="sub_menu_user_group" class="sub_menu" style="width:110px;">
    <a href="javascript:;" index="0" class="active">我的自定义组</a>
    <a href="javascript:;" index="1" class="">公共自定义组</a>
</div>
<div id="body" style="height: 549px;">
    <div id="modules">
        <div id="module_org" class="container moduleContainer" style="display: block;">
            <div id="sub_module_org_0" class="module-block" style="">
                <ul class="dynatree-container dynatree-no-connector">
                    <li class="dynatree-lastsib"><span
                            class="dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><img
                            src="../img/spirit/root.png" alt=""><a
                            href="http://192.168.0.23/general/ipanel/user/?ISPIRIT=1&amp;I_VER=2#"
                            class="dynatree-title" title="中国兵器工业集团">中国兵器工业集团</a></span>
                        <ul>
                            <li class="dynatree-lastsib"><span
                                    class="dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span
                                    class="dynatree-expander"></span><a
                                    href="http://192.168.0.23/general/ipanel/user/?ISPIRIT=1&amp;I_VER=2#"
                                    class="dynatree-title" title="北方测试研究公司">北方测试研究公司</a></span>
                                <ul>
                                    <li class="dynatree-lastsib"><span
                                            class="dynatree-node dynatree-lastsib dynatree-exp-cl dynatree-ico-c"><span
                                            class="dynatree-connector" style="display: none;"></span><img
                                            src="../img/spirit/U01.png" alt=""><a
                                            href="http://192.168.0.23/general/ipanel/user/?ISPIRIT=1&amp;I_VER=2#"
                                            class="dynatree-title">系统管理员</a></span></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div id="sub_module_org_1" class="module-block" style="display:none;"></div>
        </div>
        <div id="module_user_group" class="container module-block" style="display:none;"></div>
        <div id="module_recent" class="container module-block" style="display:none;"></div>
        <div id="module_im_group" class="container module-block" style="display:none;"></div>
    </div>

    <div id="module_user_group_op_menu" class="attach_div small" style="width:80px;">
        <a op="msg" href="javascript:;"><span>微讯</span></a>
        <a op="email" href="javascript:;"><span>邮件</span></a>
    </div>

</div>
<script>
    if (window.external && typeof window.external.OA_SMS != 'undefined') {
        window.external.OA_SMS('', '', 'FRESH');
        setTimeout(function () {
            window.external.OA_SMS('', '', 'FRESH');
        }, 500);
    }
</script>

</body>
</html>