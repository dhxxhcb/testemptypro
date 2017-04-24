<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!-- saved from url=(0069)file:///C:/Users/gaosubo/Desktop/OA%E7%B2%BE%E7%81%B5_files/menu.html -->
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
    <link rel="stylesheet" type="text/css" href="../css/spirit/menu.css">
</head>


<body onload="view_menu(1);init();window.setTimeout(init, 1);" marginwidth="0" marginheight="0">
<div id="sub_tabs" class="sub_tabs">
    <a id="my_fav" href="javascript:;"><span>我的常用菜单</span></a>
    <a id="menu_refresh" href="javascript:window.location.reload();" title="刷新该页面"></a>
    <img id="expand_link" onclick="menu_expand();" src="images/green_minus.gif" title="展开/折叠菜单" style="display:;">
</div>

<div id="body" style="height: 500px;">

    <!-- OA树开始-->
    <ul id="menu">
        <li class="L1"><a href="javascript:c(&#39;m01&#39;);" id="m01"><span><i class="mytable"></i> 个人事务</span></a>
        </li>
        <ul id="m01d" style="display:none;" class="U1">
            <li class="L22"><a href="javascript:a(&#39;email&#39;,&#39;1&#39;,0);" id="f1"><span>电子邮件</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;sms&#39;,&#39;3&#39;,0);" id="f3"><span>消息管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;mobile_sms&#39;,&#39;42&#39;,0);" id="f42"><span>手机短信</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;email/audit/&#39;,&#39;643&#39;,0);" id="f643"><span>邮件审批</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;email/audit_log/&#39;,&#39;644&#39;,0);"
                               id="f644"><span>邮件审批日志</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;itask&#39;,&#39;634&#39;,0);" id="f634"><span>智协同</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;notify/show&#39;,&#39;4&#39;,0);" id="f4"><span>公告通知</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;news/show&#39;,&#39;147&#39;,0);" id="f147"><span>新闻</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;vote/show&#39;,&#39;148&#39;,0);" id="f148"><span>投票</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;attendance/personal&#39;,&#39;7&#39;,0);"
                               id="f7"><span>个人考勤</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;calendar&#39;,&#39;8&#39;,0);" id="f8"><span>日程安排</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;diary/show&#39;,&#39;9&#39;,0);" id="f9"><span>工作日志</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;address/private&#39;,&#39;10&#39;,0);" id="f10"><span>通讯簿</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;file_folder/index2.php&#39;,&#39;16&#39;,0);" id="f16"><span>个人文件柜</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;person_info&#39;,&#39;11&#39;,0);" id="f11"><span>控制面板</span></a>
            </li>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;m10&#39;);" id="m10"><span><i class="workflow"></i> 工作流</span></a>
        </li>
        <ul id="m10d" style="display:none;" class="U1">
            <li class="L22"><a href="javascript:a(&#39;workflow/new&#39;,&#39;130&#39;,0);" id="f130"><span>新建工作</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;workflow/list&#39;,&#39;5&#39;,0);" id="f5"><span>我的工作</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;workflow/query&#39;,&#39;131&#39;,0);"
                               id="f131"><span>工作查询</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;workflow/manage&#39;,&#39;132&#39;,0);"
                               id="f132"><span>工作监控</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;workflow/report&#39;,&#39;256&#39;,0);"
                               id="f256"><span>数据报表</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;workflow/timeout_stat&#39;,&#39;229&#39;,0);" id="f229"><span>超时统计分析</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;workflow/rule&#39;,&#39;182&#39;,0);" id="f182"><span>工作委托</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;workflow/destroy&#39;,&#39;183&#39;,0);"
                               id="f183"><span>工作销毁</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;workflow/logs&#39;,&#39;194&#39;,0);"
                               id="f194"><span>流程日志查询</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;workflow/archive&#39;,&#39;637&#39;,0);"
                               id="f637"><span>数据归档</span></a></li>
            <li class="L21"><a href="javascript:c(&#39;f134&#39;);" id="f134"><span>工作流设置</span></a></li>
            <ul id="f134d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;system/workflow/flow_form&#39;,&#39;37&#39;,0);"
                                  id="f37"><span>设计表单</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/workflow/flow_guide&#39;,&#39;135&#39;,0);"
                                  id="f135"><span>设计流程</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/workflow/flow_sort&#39;,&#39;136&#39;,0);"
                                  id="f136"><span>分类设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/workflow/config&#39;,&#39;226&#39;,0);"
                                  id="f226"><span>参数设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/workflow/flow_hook&#39;,&#39;253&#39;,0);"
                                  id="f253"><span>业务引擎设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/workflow/flow_report&#39;,&#39;254&#39;,0);" id="f254"><span>报表设置</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;system/workflow/flow_data&#39;,&#39;255&#39;,0);"
                                  id="f255"><span>数据源管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/workflow/flow_log&#39;,&#39;536&#39;,0);"
                                  id="f536"><span>管理日志</span></a></li>
            </ul>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;m20&#39;);" id="m20"><span><i class="erp"></i> 行政办公</span></a></li>
        <ul id="m20d" style="display:none;" class="U1">
            <li class="L22"><a href="javascript:a(&#39;notify/manage&#39;,&#39;24&#39;,0);" id="f24"><span>公告通知管理</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;notify/auditing&#39;,&#39;196&#39;,0);"
                               id="f196"><span>公告通知审批</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;news/manage&#39;,&#39;105&#39;,0);"
                               id="f105"><span>新闻管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;vote/manage&#39;,&#39;119&#39;,0);"
                               id="f119"><span>投票管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;calendar/info&#39;,&#39;80&#39;,0);" id="f80"><span>日程安排查询</span></a>
            </li>
            <li class="L21"><a href="javascript:c(&#39;f96&#39;);" id="f96"><span>工作计划</span></a></li>
            <ul id="f96d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;work_plan/show&#39;,&#39;97&#39;,0);"
                                  id="f97"><span>工作计划查询</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;work_plan/manage&#39;,&#39;98&#39;,0);"
                                  id="f98"><span>工作计划管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;work_plan/type&#39;,&#39;114&#39;,0);" id="f114"><span>工作计划类型设置</span></a>
                </li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f126&#39;);" id="f126"><span>办公用品</span></a></li>
            <ul id="f126d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;office_product/apply&#39;,&#39;179&#39;,0);" id="f179"><span>办公用品申领</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;office_product/dept_approval&#39;,&#39;607&#39;,0);"
                                  id="f607"><span>办公用品审批</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;office_product/grant&#39;,&#39;539&#39;,0);" id="f539"><span>办公用品发放</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;office_product/report&#39;,&#39;251&#39;,0);" id="f251"><span>办公用品报表</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;office_product/product_manage&#39;,&#39;127&#39;,0);"
                                  id="f127"><span>办公用品信息管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;office_product/depository_manage&#39;,&#39;238&#39;,0);"
                                  id="f238"><span>办公用品库管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;office_product/inventory_manage&#39;,&#39;128&#39;,0);"
                                  id="f128"><span>办公用品库存管理</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f85&#39;);" id="f85"><span>会议申请与安排</span></a></li>
            <ul id="f85d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;meeting/apply&#39;,&#39;86&#39;,0);"
                                  id="f86"><span>会议申请</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;meeting/query&#39;,&#39;87&#39;,0);"
                                  id="f87"><span>会议查询</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;meeting/manage&#39;,&#39;88&#39;,0);"
                                  id="f88"><span>会议管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;meeting/meeting_room&#39;,&#39;89&#39;,0);" id="f89"><span>会议室设置</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;meeting/operator&#39;,&#39;137&#39;,0);"
                                  id="f137"><span>管理员设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;meeting/summary&#39;,&#39;138&#39;,0);"
                                  id="f138"><span>会议纪要</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;meeting/equipment&#39;,&#39;222&#39;,0);" id="f222"><span>会议室设备管理</span></a>
                </li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f90&#39;);" id="f90"><span>车辆申请与安排</span></a></li>
            <ul id="f90d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;vehicle&#39;,&#39;91&#39;,0);"
                                  id="f91"><span>车辆使用申请</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;vehicle/query&#39;,&#39;92&#39;,0);"
                                  id="f92"><span>车辆使用查询</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;vehicle/dept_manage&#39;,&#39;152&#39;,0);" id="f152"><span>部门审批管理</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;vehicle/checkup&#39;,&#39;93&#39;,0);"
                                  id="f93"><span>车辆使用管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;vehicle/maintenance&#39;,&#39;94&#39;,0);" id="f94"><span>车辆维护管理</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;vehicle/manage&#39;,&#39;95&#39;,0);"
                                  id="f95"><span>车辆信息管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;vehicle/operator&#39;,&#39;118&#39;,0);" id="f118"><span>调度人员管理</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;vehicle/oil_cost&#39;,&#39;237&#39;,0);"
                                  id="f237"><span>油耗统计</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f108&#39;);" id="f108"><span>固定资产</span></a></li>
            <ul id="f108d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;asset/config&#39;,&#39;109&#39;,0);"
                                  id="f109"><span>参数设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;asset/manage&#39;,&#39;110&#39;,0);"
                                  id="f110"><span>固定资产管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;asset/query&#39;,&#39;112&#39;,0);"
                                  id="f112"><span>固定资产查询</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f51&#39;);" id="f51"><span>图书管理</span></a></li>
            <ul id="f51d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;book/manage&#39;,&#39;53&#39;,0);" id="f53"><span>图书录入</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;book/query&#39;,&#39;54&#39;,0);"
                                  id="f54"><span>图书查询</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;book/borrow_manage&#39;,&#39;153&#39;,0);" id="f153"><span>借还书管理</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;book/book_set&#39;,&#39;217&#39;,0);"
                                  id="f217"><span>图书管理设置</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f150&#39;);" id="f150"><span>资源申请与管理</span></a></li>
            <ul id="f150d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;source/manage&#39;,&#39;239&#39;,0);"
                                  id="f239"><span>资源申请与管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;source/cyclesource&#39;,&#39;240&#39;,0);" id="f240"><span>周期性资源安排</span></a>
                </li>
            </ul>
            <li class="L22"><a href="javascript:a(&#39;system/censor_words&#39;,&#39;218&#39;,0);" id="f218"><span>词语过滤管理</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;system/censor_check&#39;,&#39;219&#39;,0);" id="f219"><span>信息过滤审核</span></a>
            </li>
            <li class="L21"><a href="javascript:c(&#39;f43&#39;);" id="f43"><span>组织机构信息</span></a></li>
            <ul id="f43d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;info/unit&#39;,&#39;17&#39;,0);" id="f17"><span>单位信息查询</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;info/dept&#39;,&#39;18&#39;,0);" id="f18"><span>部门信息查询</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;info/user&#39;,&#39;19&#39;,0);" id="f19"><span>用户信息查询</span></a>
                </li>
            </ul>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;m30&#39;);" id="m30"><span><i class="knowledge"></i> 知识管理</span></a>
        </li>
        <ul id="m30d" style="display:none;" class="U1">
            <li class="L22"><a href="javascript:a(&#39;knowledge_management&#39;,&#39;15&#39;,0);"
                               id="f15"><span>公共文件柜</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/file_folder&#39;,&#39;36&#39;,0);"
                               id="f36"><span>公共文件柜设置</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;safe_doc&#39;,&#39;70&#39;,0);" id="f70"><span>安全文档中心</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;netdisk&#39;,&#39;76&#39;,0);" id="f76"><span>网络硬盘</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;system/netdisk&#39;,&#39;77&#39;,0);"
                               id="f77"><span>网络硬盘设置</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;picture&#39;,&#39;115&#39;,0);" id="f115"><span>图片浏览</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;system/picture&#39;,&#39;116&#39;,0);"
                               id="f116"><span>图片浏览设置</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;zhidao&#39;,&#39;185&#39;,0);" id="f185"><span>OA知道</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;wiki&#39;,&#39;235&#39;,0);" id="f235"><span>维基百科</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;index&#39;,&#39;535&#39;,0);" id="f535"><span>文档检索中心</span></a>
            </li>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;m40&#39;);" id="m40"><span><i class="portal"></i> 智能门户</span></a></li>
        <ul id="m40d" style="display:none;" class="U1">
            <li class="L22"><a href="javascript:a(&#39;portal&#39;,&#39;59&#39;,0);" id="f59"><span>我的门户</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/portal/setting&#39;,&#39;133&#39;,0);" id="f133"><span>门户管理</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;system/portal/template&#39;,&#39;64&#39;,0);" id="f64"><span>门户模版管理</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;system/portal/content&#39;,&#39;257&#39;,0);" id="f257"><span>门户内容管理</span></a>
            </li>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;m45&#39;);" id="m45" class="active"><span><i
                class="management_center"></i> 管理中心</span></a></li>
        <ul id="m45d" class="U1">
            <li class="L22"><a href="javascript:a(&#39;management_center/portal&#39;,&#39;2&#39;,0);" id="f2"><span>管理中心门户</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;management_center/cockpit&#39;,&#39;74&#39;,0);" id="f74"><span>管理驾驶舱</span></a>
            </li>
            <li class="L21"><a href="javascript:c(&#39;f12&#39;);" id="f12"><span>管理中心设置</span></a></li>
            <ul id="f12d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;management_center/setting/global&#39;,&#39;68&#39;,0);"
                                  id="f68"><span>全局设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;management_center/setting/class&#39;,&#39;66&#39;,0);"
                                  id="f66"><span>分类设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;management_center/setting/priv&#39;,&#39;67&#39;,0);"
                                  id="f67"><span>权限设置</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f13&#39;);" id="f13"><span>BI设计中心</span></a></li>
            <ul id="f13d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;bi_design/reportshop&#39;,&#39;14&#39;,0);" id="f14"><span>智能报表BI设计</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;bi_design/workflow&#39;,&#39;40&#39;,0);" id="f40"><span>工作流BI设计</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;bi_design/oa&#39;,&#39;41&#39;,0);"
                                  id="f41"><span>OA业务BI设计</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;bi_design/external&#39;,&#39;44&#39;,0);" id="f44"><span>外部业务BI设计</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;bi_design/cockpit&#39;,&#39;75&#39;,0);" id="f75"><span>管理驾驶舱设置</span></a>
                </li>
            </ul>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;m50&#39;);" id="m50"><span><i class="hr"></i> 人力资源</span></a></li>
        <ul id="m50d" style="display:none;" class="U1">
            <li class="L21"><a href="javascript:c(&#39;f27&#39;);" id="f27"><span>人事管理</span></a></li>
            <ul id="f27d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_info&#39;,&#39;60&#39;,0);" id="f60"><span>人事档案</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/query&#39;,&#39;61&#39;,0);"
                                  id="f61"><span>档案查询</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_contract&#39;,&#39;481&#39;,0);"
                                  id="f481"><span>合同管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_incentive&#39;,&#39;482&#39;,0);"
                                  id="f482"><span>奖惩管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_license&#39;,&#39;483&#39;,0);"
                                  id="f483"><span>证照管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_learn_experience&#39;,&#39;484&#39;,0);"
                                  id="f484"><span>学习经历</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_work_experience&#39;,&#39;485&#39;,0);"
                                  id="f485"><span>工作经历</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_labor_skills&#39;,&#39;486&#39;,0);"
                                  id="f486"><span>劳动技能</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_relatives&#39;,&#39;487&#39;,0);"
                                  id="f487"><span>社会关系</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_transfer&#39;,&#39;488&#39;,0);"
                                  id="f488"><span>人事调动</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_leave&#39;,&#39;489&#39;,0);" id="f489"><span>离职管理</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_reinstatement&#39;,&#39;490&#39;,0);"
                                  id="f490"><span>复职管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_title_evaluation&#39;,&#39;491&#39;,0);"
                                  id="f491"><span>职称评定</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_care&#39;,&#39;492&#39;,0);" id="f492"><span>员工关怀</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;hr/manage/staff_analysis&#39;,&#39;120&#39;,0);"
                                  id="f120"><span>人事分析</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f494&#39;);" id="f494"><span>招聘管理</span></a></li>
            <ul id="f494d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;hr/recruit/requirements&#39;,&#39;495&#39;,0);"
                                  id="f495"><span>招聘需求</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/recruit/plan&#39;,&#39;496&#39;,0);"
                                  id="f496"><span>招聘计划</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/recruit/plan_approval&#39;,&#39;497&#39;,0);"
                                  id="f497"><span>招聘计划审批</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/recruit/hr_pool&#39;,&#39;498&#39;,0);"
                                  id="f498"><span>人才库</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/recruit/filter&#39;,&#39;499&#39;,0);"
                                  id="f499"><span>招聘筛选</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/recruit/recruitment&#39;,&#39;500&#39;,0);"
                                  id="f500"><span>招聘录用</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/recruit/analysis&#39;,&#39;501&#39;,0);" id="f501"><span>人才分析</span></a>
                </li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f502&#39;);" id="f502"><span>培训管理</span></a></li>
            <ul id="f502d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;hr/training/plan&#39;,&#39;503&#39;,0);"
                                  id="f503"><span>培训计划</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/training/approval/&#39;,&#39;505&#39;,0);" id="f505"><span>培训计划审批</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;hr/training/record&#39;,&#39;504&#39;,0);" id="f504"><span>培训记录</span></a>
                </li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f26&#39;);" id="f26"><span>考勤管理</span></a></li>
            <ul id="f26d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;attendance/manage/confirm/&#39;,&#39;506&#39;,0);"
                                  id="f506"><span>考勤审批</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;attendance/manage/user_manage&#39;,&#39;507&#39;,0);"
                                  id="f507"><span>考勤记录</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;attendance/manage/query&#39;,&#39;508&#39;,0);"
                                  id="f508"><span>考勤统计</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;attendance/manage/on_duty&#39;,&#39;515&#39;,0);"
                                  id="f515"><span>值班排班管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;attendance/manage/ask_duty&#39;,&#39;537&#39;,0);"
                                  id="f537"><span>查岗质询登记</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f122&#39;);" id="f122"><span>绩效考核</span></a></li>
            <ul id="f122d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;score/group&#39;,&#39;123&#39;,0);"
                                  id="f123"><span>考核项目设定</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;score/flow&#39;,&#39;124&#39;,0);"
                                  id="f124"><span>考核任务管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;score/self_assessment&#39;,&#39;628&#39;,0);" id="f628"><span>被考核人自评</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;score/submit&#39;,&#39;125&#39;,0);"
                                  id="f125"><span>进行考核</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f630&#39;);" id="f630"><span>积分管理</span></a></li>
            <ul id="f630d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;hr/integral/input&#39;,&#39;631&#39;,0);"
                                  id="f631"><span>积分录入</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/integral/query&#39;,&#39;632&#39;,0);"
                                  id="f632"><span>积分查询</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/integral/item_setting&#39;,&#39;633&#39;,0);"
                                  id="f633"><span>积分项设置</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f55&#39;);" id="f55"><span>薪酬管理</span></a></li>
            <ul id="f55d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;hr/salary/insurance_para&#39;,&#39;514&#39;,0);"
                                  id="f514"><span>薪酬项目及保险设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/salary/staff_insurance&#39;,&#39;509&#39;,0);"
                                  id="f509"><span>薪酬基数设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/salary/manage&#39;,&#39;29&#39;,0);"
                                  id="f29"><span>工资流程管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/salary/submit&#39;,&#39;28&#39;,0);"
                                  id="f28"><span>财务工资录入</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;hr/salary/report&#39;,&#39;129&#39;,0);" id="f129"><span>部门工资上报</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;hr/salary/welfare_manage&#39;,&#39;510&#39;,0);"
                                  id="f510"><span>福利管理</span></a></li>
            </ul>
            <li class="L22"><a href="javascript:a(&#39;hr/self_find&#39;,&#39;511&#39;,0);"
                               id="f511"><span>员工自助查询</span></a></li>
            <li class="L21"><a href="javascript:c(&#39;f224&#39;);" id="f224"><span>人力资源设置</span></a></li>
            <ul id="f224d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;hr/setting/attendance&#39;,&#39;39&#39;,0);" id="f39"><span>考勤设置</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;hr/setting/hr_manager&#39;,&#39;512&#39;,0);" id="f512"><span>人力资源管理员</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;hr/setting/hr_code&#39;,&#39;513&#39;,0);" id="f513"><span>HRMS代码设置</span></a>
                </li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f252&#39;);" id="f252"><span>在线考试</span></a></li>
            <ul id="f252d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;exam_manage/set_manage&#39;,&#39;230&#39;,0);"
                                  id="f230"><span>题库管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;exam_manage/quiz_manage/&#39;,&#39;231&#39;,0);"
                                  id="f231"><span>试题管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;exam_manage/paper_manage/&#39;,&#39;232&#39;,0);"
                                  id="f232"><span>试卷管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;exam_manage/subject_score/&#39;,&#39;629&#39;,0);"
                                  id="f629"><span>主观题阅卷</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;exam_manage/info_pub/&#39;,&#39;233&#39;,0);" id="f233"><span>考试信息管理</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;exam_manage/exam_online&#39;,&#39;234&#39;,0);"
                                  id="f234"><span>参加考试</span></a></li>
            </ul>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;m65&#39;);" id="m65"><span><i class="document"></i> 公文管理</span></a>
        </li>
        <ul id="m65d" style="display:none;" class="U1">
            <li class="L21"><a href="javascript:c(&#39;f461&#39;);" id="f461"><span>发文管理</span></a></li>
            <ul id="f461d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;document/index.php/send/draft&#39;,&#39;462&#39;,0);"
                                  id="f462"><span>发文拟稿</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;document/index.php/send/approve&#39;,&#39;463&#39;,0);"
                                  id="f463"><span>发文核稿</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;document/index.php/send/seal&#39;,&#39;464&#39;,0);"
                                  id="f464"><span>套红盖章</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;document/index.php/send/sendlist&#39;,&#39;465&#39;,0);"
                                  id="f465"><span>发文列表</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f466&#39;);" id="f466"><span>收文管理</span></a></li>
            <ul id="f466d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;document/index.php/recv/register&#39;,&#39;467&#39;,0);"
                                  id="f467"><span>收文登记</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;document/index.php/recv/approve&#39;,&#39;468&#39;,0);"
                                  id="f468"><span>领导批阅</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;document/index.php/recv/outgiving&#39;,&#39;469&#39;,0);"
                                  id="f469"><span>收文分发</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;document/index.php/recv/read&#39;,&#39;470&#39;,0);"
                                  id="f470"><span>收文阅读</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f471&#39;);" id="f471"><span>基础设置</span></a></li>
            <ul id="f471d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;document/index.php/setting/config&#39;,&#39;472&#39;,0);"
                                  id="f472"><span>参数设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;document/index.php/setting/keywords&#39;,&#39;473&#39;,0);"
                                  id="f473"><span>主题词管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;document/index.php/setting/type&#39;,&#39;474&#39;,0);"
                                  id="f474"><span>公文类型设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;document/index.php/setting/priv&#39;,&#39;475&#39;,0);"
                                  id="f475"><span>收文权限设置</span></a></li>
            </ul>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;m70&#39;);" id="m70"><span><i class="roll_manage"></i> 档案管理</span></a>
        </li>
        <ul id="m70d" style="display:none;" class="U1">
            <li class="L22"><a href="javascript:a(&#39;roll_manage/roll_room&#39;,&#39;200&#39;,0);" id="f200"><span>卷库管理</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;roll_manage&#39;,&#39;202&#39;,0);"
                               id="f202"><span>案卷管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;roll_manage/roll_file&#39;,&#39;201&#39;,0);" id="f201"><span>文件管理</span></a>
            </li>
            <li class="L21"><a href="javascript:c(&#39;f203&#39;);" id="f203"><span>案卷借阅</span></a></li>
            <ul id="f203d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;roll_manage/roll_lend&#39;,&#39;204&#39;,0);" id="f204"><span>案卷借阅</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;roll_manage/roll_lend/confirm.php&#39;,&#39;205&#39;,0);"
                                  id="f205"><span>借阅审批</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f206&#39;);" id="f206"><span>档案统计</span></a></li>
            <ul id="f206d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;roll_manage/roll_statistic/lend.php&#39;,&#39;207&#39;,0);"
                                  id="f207"><span>借阅统计</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;roll_manage/roll_statistic/roll.php&#39;,&#39;208&#39;,0);"
                                  id="f208"><span>案卷统计</span></a></li>
            </ul>
            <li class="L22"><a href="javascript:a(&#39;roll_manage/destory&#39;,&#39;209&#39;,0);"
                               id="f209"><span>档案销毁</span></a></li>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;m90&#39;);" id="m90"><span><i class="project"></i> 项目管理</span></a>
        </li>
        <ul id="m90d" style="display:none;" class="U1">
            <li class="L22"><a href="javascript:a(&#39;project/portal&#39;,&#39;65&#39;,0);" id="f65"><span>我的项目</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;project/task&#39;,&#39;187&#39;,0);" id="f187"><span>我的任务</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;project/proj&#39;,&#39;186&#39;,0);" id="f186"><span>项目查询</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;project/approve&#39;,&#39;188&#39;,0);"
                               id="f188"><span>项目审批</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;project/file&#39;,&#39;189&#39;,0);" id="f189"><span>项目文档</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;project/bug&#39;,&#39;190&#39;,0);"
                               id="f190"><span>项目问题</span></a></li>
            <li class="L21"><a href="javascript:c(&#39;f191&#39;);" id="f191"><span>基础数据设置</span></a></li>
            <ul id="f191d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;project/setting/cust/sys&#39;,&#39;606&#39;,0);"
                                  id="f606"><span>项目自定义设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;project/setting/priv&#39;,&#39;192&#39;,0);" id="f192"><span>项目权限设置</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;project/setting/code&#39;,&#39;193&#39;,0);" id="f193"><span>项目代码设置</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;project/setting/template&#39;,&#39;221&#39;,0);"
                                  id="f221"><span>项目模板管理</span></a></li>
            </ul>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;ma0&#39;);" id="ma0"><span><i class="reportshop"></i> ERP应用</span></a>
        </li>
        <ul id="ma0d" style="display:none;" class="U1">
            <li class="L22"><a href="javascript:a(&#39;reportshop/workshop&#39;,&#39;550&#39;,0);"
                               id="f550"><span>应用中心</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;reportshop/design/report&#39;,&#39;551&#39;,0);" id="f551"><span>管理平台</span></a>
            </li>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;mb0&#39;);" id="mb0"><span><i class="comm"></i> 交流园地</span></a></li>
        <ul id="mb0d" style="display:none;" class="U1">
            <li class="L22"><a href="javascript:a(&#39;sns&#39;,&#39;73&#39;,0);" id="f73"><span>企业社区</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;bbs&#39;,&#39;62&#39;,0);" id="f62"><span>讨论区</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;bbs2&#39;,&#39;63&#39;,0);" id="f63"><span>论坛</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/bbs&#39;,&#39;34&#39;,0);" id="f34"><span>讨论区设置</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;gbtmeet&#39;,&#39;532&#39;,0);" id="f532"><span>专业视频会议</span></a>
            </li>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;me0&#39;);" id="me0"><span><i class="ext_data"></i> T10超能云中心平台</span></a>
        </li>
        <ul id="me0d" style="display:none;" class="U1">
            <li class="L21"><a href="javascript:c(&#39;f548&#39;);" id="f548"><span>平台设置</span></a></li>
            <ul id="f548d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;ext_data/admin/setting&#39;,&#39;640&#39;,0);"
                                  id="f640"><span>参数设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;ext_data/admin/model&#39;,&#39;641&#39;,0);" id="f641"><span>流程模型同步</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;ext_data/admin/logs&#39;,&#39;642&#39;,0);" id="f642"><span>交换历史记录</span></a>
                </li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f549&#39;);" id="f549"><span>信息接收与发布</span></a></li>
            <ul id="f549d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;ext_data/info/recv&#39;,&#39;601&#39;,0);" id="f601"><span>信息接收</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;ext_data/info/send&#39;,&#39;600&#39;,0);" id="f600"><span>信息发布</span></a>
                </li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f602&#39;);" id="f602"><span>工作接收与处理</span></a></li>
            <ul id="f602d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;ext_data/workflow/my&#39;,&#39;603&#39;,0);" id="f603"><span>待办工作</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;ext_data/workflow/rule&#39;,&#39;604&#39;,0);"
                                  id="f604"><span>权限与规则设置</span></a></li>
            </ul>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;my0&#39;);" id="my0"><span><i class="info"></i> 附件程序</span></a></li>
        <ul id="my0d" style="display:none;" class="U1">
            <li class="L21"><a href="javascript:c(&#39;f46&#39;);" id="f46"><span>实用信息</span></a></li>
            <ul id="f46d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;info/tel_no&#39;,&#39;21&#39;,0);"
                                  id="f21"><span>电话区号查询</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;info/post_no&#39;,&#39;22&#39;,0);"
                                  id="f22"><span>邮政编码查询</span></a></li>
            </ul>
            <li class="L22"><a href="javascript:a(&#39;im/show&#39;,&#39;227&#39;,0);" id="f227"><span>即时通讯</span></a>
            </li>
        </ul>
        <li class="L1"><a href="javascript:c(&#39;mz0&#39;);" id="mz0"><span><i class="system"></i> 系统管理</span></a></li>
        <ul id="mz0d" style="display:none;" class="U1">
            <li class="L21"><a href="javascript:c(&#39;f56&#39;);" id="f56"><span>组织机构设置</span></a></li>
            <ul id="f56d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;system/unit&#39;,&#39;30&#39;,0);" id="f30"><span>单位管理</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;system/dept&#39;,&#39;31&#39;,0);" id="f31"><span>部门管理</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;system/user&#39;,&#39;33&#39;,0);" id="f33"><span>用户管理</span></a>
                </li>
                <li class="L3"><a href="javascript:a(&#39;system/user_priv&#39;,&#39;32&#39;,0);"
                                  id="f32"><span>角色与权限管理</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/ext_dept&#39;,&#39;605&#39;,0);"
                                  id="f605"><span>外部机构管理</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f57&#39;);" id="f57"><span>行政办公设置</span></a></li>
            <ul id="f57d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;system/calendar&#39;,&#39;609&#39;,0);"
                                  id="f609"><span>日程安排设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/url&#39;,&#39;103&#39;,0);"
                                  id="f103"><span>公共网址设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/diary&#39;,&#39;146&#39;,0);"
                                  id="f146"><span>工作日志设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/address&#39;,&#39;107&#39;,0);"
                                  id="f107"><span>公共通讯簿设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/notify&#39;,&#39;197&#39;,0);"
                                  id="f197"><span>公告通知设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/model&#39;,&#39;228&#39;,0);"
                                  id="f228"><span>模板管理</span></a></li>
            </ul>
            <li class="L21"><a href="javascript:c(&#39;f58&#39;);" id="f58"><span>信息交流设置</span></a></li>
            <ul id="f58d" style="display:none;background-color:#fff;">
                <li class="L3"><a href="javascript:a(&#39;system/email&#39;,&#39;538&#39;,0);"
                                  id="f538"><span>电子邮件设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/remind&#39;,&#39;151&#39;,0);"
                                  id="f151"><span>短信提醒设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/mobile_sms&#39;,&#39;6&#39;,0);"
                                  id="f6"><span>手机短信设置</span></a></li>
                <li class="L3"><a href="javascript:a(&#39;system/im&#39;,&#39;534&#39;,0);"
                                  id="f534"><span>即时通讯管理</span></a></li>
            </ul>
            <li class="L22"><a href="javascript:a(&#39;system/module_center&#39;,&#39;69&#39;,0);"
                               id="f69"><span>功能管理中心</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/qyapp&#39;,&#39;71&#39;,0);"
                               id="f71"><span>企业号管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/app&#39;,&#39;72&#39;,0);" id="f72"><span>APP应用商店设置</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;system/seal_manage&#39;,&#39;223&#39;,0);"
                               id="f223"><span>印章管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/mobile_seal&#39;,&#39;639&#39;,0);"
                               id="f639"><span>手机签章管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/task&#39;,&#39;225&#39;,0);" id="f225"><span>定时任务管理</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;system/urgent_notify&#39;,&#39;236&#39;,0);" id="f236"><span>紧急通知设置</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;system/interface&#39;,&#39;78&#39;,0);"
                               id="f78"><span>界面设置</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/status_text&#39;,&#39;178&#39;,0);"
                               id="f178"><span>状态栏设置</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/menu&#39;,&#39;104&#39;,0);"
                               id="f104"><span>菜单设置</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/code&#39;,&#39;121&#39;,0);" id="f121"><span>系统代码设置</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;system/field&#39;,&#39;149&#39;,0);"
                               id="f149"><span>自定义字段设置</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/database&#39;,&#39;84&#39;,0);"
                               id="f84"><span>数据库管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/log&#39;,&#39;99&#39;,0);"
                               id="f99"><span>系统日志管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/res_manage&#39;,&#39;100&#39;,0);"
                               id="f100"><span>系统资源管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/attachment&#39;,&#39;533&#39;,0);"
                               id="f533"><span>附件管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/access_control&#39;,&#39;101&#39;,0);" id="f101"><span>系统访问控制</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;system/security&#39;,&#39;113&#39;,0);"
                               id="f113"><span>系统参数设置</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/ext_user&#39;,&#39;198&#39;,0);"
                               id="f198"><span>系统接口设置</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/monitor&#39;,&#39;540&#39;,0);"
                               id="f540"><span>服务器监控</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/secure_rule&#39;,&#39;626&#39;,0);"
                               id="f626"><span>三员安全管理</span></a></li>
            <li class="L22"><a href="javascript:a(&#39;system/t-erplinker/data_source&#39;,&#39;638&#39;,0);" id="f638"><span>T-ERPLinker数据源管理</span></a>
            </li>
            <li class="L22"><a href="javascript:a(&#39;system/reg_view&#39;,&#39;38&#39;,0);" id="f38"><span>系统信息</span></a>
            </li>
        </ul>
    </ul>
</div>
<div id="menu_code_1" style="display:none;"><br>&lt;li class="L1"&gt;&lt;a href="javascript:c('m01');" id="m01"&gt;&lt;span&gt;&lt;i
    class="mytable"&gt;&lt;/i&gt; 个人事务&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul id="m01d" style="display:none;"
    class="U1"&gt;<br>&lt;li class="L22"&gt;&lt;a href="javascript:a('email','1',0);" id="f1"&gt;&lt;span&gt;电子邮件&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('sms','3',0);" id="f3"&gt;&lt;span&gt;消息管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('mobile_sms','42',0);" id="f42"&gt;&lt;span&gt;手机短信&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('email/audit/','643',0);" id="f643"&gt;&lt;span&gt;邮件审批&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('email/audit_log/','644',0);" id="f644"&gt;&lt;span&gt;邮件审批日志&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('itask','634',0);" id="f634"&gt;&lt;span&gt;智协同&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('notify/show','4',0);" id="f4"&gt;&lt;span&gt;公告通知&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('news/show','147',0);" id="f147"&gt;&lt;span&gt;新闻&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('vote/show','148',0);" id="f148"&gt;&lt;span&gt;投票&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('attendance/personal','7',0);" id="f7"&gt;&lt;span&gt;个人考勤&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('calendar','8',0);" id="f8"&gt;&lt;span&gt;日程安排&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('diary/show','9',0);" id="f9"&gt;&lt;span&gt;工作日志&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('address/private','10',0);" id="f10"&gt;&lt;span&gt;通讯簿&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('file_folder/index2.php','16',0);" id="f16"&gt;&lt;span&gt;个人文件柜&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('person_info','11',0);" id="f11"&gt;&lt;span&gt;控制面板&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('m10');" id="m10"&gt;&lt;span&gt;&lt;i class="workflow"&gt;&lt;/i&gt; 工作流&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="m10d" style="display:none;" class="U1"&gt;<br>&lt;li class="L22"&gt;&lt;a
    href="javascript:a('workflow/new','130',0);" id="f130"&gt;&lt;span&gt;新建工作&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('workflow/list','5',0);" id="f5"&gt;&lt;span&gt;我的工作&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('workflow/query','131',0);" id="f131"&gt;&lt;span&gt;工作查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('workflow/manage','132',0);" id="f132"&gt;&lt;span&gt;工作监控&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('workflow/report','256',0);" id="f256"&gt;&lt;span&gt;数据报表&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('workflow/timeout_stat','229',0);" id="f229"&gt;&lt;span&gt;超时统计分析&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('workflow/rule','182',0);" id="f182"&gt;&lt;span&gt;工作委托&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('workflow/destroy','183',0);" id="f183"&gt;&lt;span&gt;工作销毁&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('workflow/logs','194',0);" id="f194"&gt;&lt;span&gt;流程日志查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('workflow/archive','637',0);" id="f637"&gt;&lt;span&gt;数据归档&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f134');"
    id="f134"&gt;&lt;span&gt;工作流设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f134d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('system/workflow/flow_form','37',0);" id="f37"&gt;&lt;span&gt;设计表单&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/workflow/flow_guide','135',0);" id="f135"&gt;&lt;span&gt;设计流程&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/workflow/flow_sort','136',0);" id="f136"&gt;&lt;span&gt;分类设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/workflow/config','226',0);" id="f226"&gt;&lt;span&gt;参数设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/workflow/flow_hook','253',0);" id="f253"&gt;&lt;span&gt;业务引擎设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/workflow/flow_report','254',0);" id="f254"&gt;&lt;span&gt;报表设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/workflow/flow_data','255',0);" id="f255"&gt;&lt;span&gt;数据源管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/workflow/flow_log','536',0);" id="f536"&gt;&lt;span&gt;管理日志&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('m20');" id="m20"&gt;&lt;span&gt;&lt;i class="erp"&gt;&lt;/i&gt; 行政办公&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="m20d" style="display:none;" class="U1"&gt;<br>&lt;li class="L22"&gt;&lt;a
    href="javascript:a('notify/manage','24',0);" id="f24"&gt;&lt;span&gt;公告通知管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('notify/auditing','196',0);" id="f196"&gt;&lt;span&gt;公告通知审批&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('news/manage','105',0);" id="f105"&gt;&lt;span&gt;新闻管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('vote/manage','119',0);" id="f119"&gt;&lt;span&gt;投票管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('calendar/info','80',0);" id="f80"&gt;&lt;span&gt;日程安排查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f96');" id="f96"&gt;&lt;span&gt;工作计划&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>
    &lt;ul id="f96d" style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('work_plan/show','97',0);" id="f97"&gt;&lt;span&gt;工作计划查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('work_plan/manage','98',0);" id="f98"&gt;&lt;span&gt;工作计划管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('work_plan/type','114',0);" id="f114"&gt;&lt;span&gt;工作计划类型设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f126');"
    id="f126"&gt;&lt;span&gt;办公用品&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f126d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('office_product/apply','179',0);" id="f179"&gt;&lt;span&gt;办公用品申领&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('office_product/dept_approval','607',0);" id="f607"&gt;&lt;span&gt;办公用品审批&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('office_product/grant','539',0);" id="f539"&gt;&lt;span&gt;办公用品发放&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('office_product/report','251',0);" id="f251"&gt;&lt;span&gt;办公用品报表&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('office_product/product_manage','127',0);" id="f127"&gt;&lt;span&gt;办公用品信息管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('office_product/depository_manage','238',0);" id="f238"&gt;&lt;span&gt;办公用品库管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('office_product/inventory_manage','128',0);" id="f128"&gt;&lt;span&gt;办公用品库存管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f85');"
    id="f85"&gt;&lt;span&gt;会议申请与安排&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f85d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('meeting/apply','86',0);" id="f86"&gt;&lt;span&gt;会议申请&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('meeting/query','87',0);" id="f87"&gt;&lt;span&gt;会议查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('meeting/manage','88',0);" id="f88"&gt;&lt;span&gt;会议管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('meeting/meeting_room','89',0);" id="f89"&gt;&lt;span&gt;会议室设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('meeting/operator','137',0);" id="f137"&gt;&lt;span&gt;管理员设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('meeting/summary','138',0);" id="f138"&gt;&lt;span&gt;会议纪要&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('meeting/equipment','222',0);" id="f222"&gt;&lt;span&gt;会议室设备管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f90');"
    id="f90"&gt;&lt;span&gt;车辆申请与安排&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f90d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a href="javascript:a('vehicle','91',0);"
    id="f91"&gt;&lt;span&gt;车辆使用申请&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('vehicle/query','92',0);" id="f92"&gt;&lt;span&gt;车辆使用查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('vehicle/dept_manage','152',0);" id="f152"&gt;&lt;span&gt;部门审批管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('vehicle/checkup','93',0);" id="f93"&gt;&lt;span&gt;车辆使用管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('vehicle/maintenance','94',0);" id="f94"&gt;&lt;span&gt;车辆维护管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('vehicle/manage','95',0);" id="f95"&gt;&lt;span&gt;车辆信息管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('vehicle/operator','118',0);" id="f118"&gt;&lt;span&gt;调度人员管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('vehicle/oil_cost','237',0);" id="f237"&gt;&lt;span&gt;油耗统计&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f108');"
    id="f108"&gt;&lt;span&gt;固定资产&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f108d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('asset/config','109',0);" id="f109"&gt;&lt;span&gt;参数设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('asset/manage','110',0);" id="f110"&gt;&lt;span&gt;固定资产管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('asset/query','112',0);" id="f112"&gt;&lt;span&gt;固定资产查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f51');" id="f51"&gt;&lt;span&gt;图书管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>
    &lt;ul id="f51d" style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('book/manage','53',0);" id="f53"&gt;&lt;span&gt;图书录入&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('book/query','54',0);" id="f54"&gt;&lt;span&gt;图书查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('book/borrow_manage','153',0);" id="f153"&gt;&lt;span&gt;借还书管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('book/book_set','217',0);" id="f217"&gt;&lt;span&gt;图书管理设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f150');" id="f150"&gt;&lt;span&gt;资源申请与管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>
    &lt;ul id="f150d" style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('source/manage','239',0);" id="f239"&gt;&lt;span&gt;资源申请与管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('source/cyclesource','240',0);" id="f240"&gt;&lt;span&gt;周期性资源安排&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/censor_words','218',0);" id="f218"&gt;&lt;span&gt;词语过滤管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/censor_check','219',0);" id="f219"&gt;&lt;span&gt;信息过滤审核&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f43');"
    id="f43"&gt;&lt;span&gt;组织机构信息&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f43d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('info/unit','17',0);" id="f17"&gt;&lt;span&gt;单位信息查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('info/dept','18',0);" id="f18"&gt;&lt;span&gt;部门信息查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('info/user','19',0);" id="f19"&gt;&lt;span&gt;用户信息查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('m30');" id="m30"&gt;&lt;span&gt;&lt;i class="knowledge"&gt;&lt;/i&gt; 知识管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="m30d" style="display:none;" class="U1"&gt;<br>&lt;li class="L22"&gt;&lt;a
    href="javascript:a('knowledge_management','15',0);"
    id="f15"&gt;&lt;span&gt;公共文件柜&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L22"&gt;&lt;a
    href="javascript:a('system/file_folder','36',0);"
    id="f36"&gt;&lt;span&gt;公共文件柜设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L22"&gt;&lt;a
    href="javascript:a('safe_doc','70',0);" id="f70"&gt;&lt;span&gt;安全文档中心&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('netdisk','76',0);" id="f76"&gt;&lt;span&gt;网络硬盘&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/netdisk','77',0);" id="f77"&gt;&lt;span&gt;网络硬盘设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('picture','115',0);" id="f115"&gt;&lt;span&gt;图片浏览&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/picture','116',0);" id="f116"&gt;&lt;span&gt;图片浏览设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('zhidao','185',0);" id="f185"&gt;&lt;span&gt;OA知道&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('wiki','235',0);" id="f235"&gt;&lt;span&gt;维基百科&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('index','535',0);" id="f535"&gt;&lt;span&gt;文档检索中心&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('m40');" id="m40"&gt;&lt;span&gt;&lt;i class="portal"&gt;&lt;/i&gt; 智能门户&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="m40d" style="display:none;" class="U1"&gt;<br>&lt;li class="L22"&gt;&lt;a href="javascript:a('portal','59',0);"
    id="f59"&gt;&lt;span&gt;我的门户&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L22"&gt;&lt;a
    href="javascript:a('system/portal/setting','133',0);" id="f133"&gt;&lt;span&gt;门户管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/portal/template','64',0);" id="f64"&gt;&lt;span&gt;门户模版管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/portal/content','257',0);" id="f257"&gt;&lt;span&gt;门户内容管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('m45');" id="m45" class="active"&gt;&lt;span&gt;&lt;i
    class="management_center"&gt;&lt;/i&gt; 管理中心&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul id="m45d"
    class="U1"&gt;<br>&lt;li class="L22"&gt;&lt;a href="javascript:a('management_center/portal','2',0);" id="f2"&gt;&lt;span&gt;管理中心门户&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('management_center/cockpit','74',0);" id="f74"&gt;&lt;span&gt;管理驾驶舱&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f12');"
    id="f12"&gt;&lt;span&gt;管理中心设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f12d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('management_center/setting/global','68',0);" id="f68"&gt;&lt;span&gt;全局设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('management_center/setting/class','66',0);" id="f66"&gt;&lt;span&gt;分类设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('management_center/setting/priv','67',0);" id="f67"&gt;&lt;span&gt;权限设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f13');"
    id="f13"&gt;&lt;span&gt;BI设计中心&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f13d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('bi_design/reportshop','14',0);" id="f14"&gt;&lt;span&gt;智能报表BI设计&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('bi_design/workflow','40',0);" id="f40"&gt;&lt;span&gt;工作流BI设计&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('bi_design/oa','41',0);" id="f41"&gt;&lt;span&gt;OA业务BI设计&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('bi_design/external','44',0);" id="f44"&gt;&lt;span&gt;外部业务BI设计&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('bi_design/cockpit','75',0);" id="f75"&gt;&lt;span&gt;管理驾驶舱设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('m50');" id="m50"&gt;&lt;span&gt;&lt;i class="hr"&gt;&lt;/i&gt; 人力资源&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="m50d" style="display:none;" class="U1"&gt;<br>&lt;li class="L21"&gt;&lt;a href="javascript:c('f27');" id="f27"&gt;&lt;span&gt;人事管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>
    &lt;ul id="f27d" style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('hr/manage/staff_info','60',0);"
    id="f60"&gt;&lt;span&gt;人事档案&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('hr/manage/query','61',0);" id="f61"&gt;&lt;span&gt;档案查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_contract','481',0);" id="f481"&gt;&lt;span&gt;合同管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_incentive','482',0);" id="f482"&gt;&lt;span&gt;奖惩管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_license','483',0);" id="f483"&gt;&lt;span&gt;证照管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_learn_experience','484',0);" id="f484"&gt;&lt;span&gt;学习经历&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_work_experience','485',0);" id="f485"&gt;&lt;span&gt;工作经历&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_labor_skills','486',0);" id="f486"&gt;&lt;span&gt;劳动技能&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_relatives','487',0);" id="f487"&gt;&lt;span&gt;社会关系&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_transfer','488',0);" id="f488"&gt;&lt;span&gt;人事调动&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_leave','489',0);" id="f489"&gt;&lt;span&gt;离职管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_reinstatement','490',0);" id="f490"&gt;&lt;span&gt;复职管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_title_evaluation','491',0);" id="f491"&gt;&lt;span&gt;职称评定&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_care','492',0);" id="f492"&gt;&lt;span&gt;员工关怀&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/manage/staff_analysis','120',0);" id="f120"&gt;&lt;span&gt;人事分析&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f494');"
    id="f494"&gt;&lt;span&gt;招聘管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f494d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('hr/recruit/requirements','495',0);" id="f495"&gt;&lt;span&gt;招聘需求&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/recruit/plan','496',0);" id="f496"&gt;&lt;span&gt;招聘计划&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/recruit/plan_approval','497',0);" id="f497"&gt;&lt;span&gt;招聘计划审批&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/recruit/hr_pool','498',0);" id="f498"&gt;&lt;span&gt;人才库&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/recruit/filter','499',0);" id="f499"&gt;&lt;span&gt;招聘筛选&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/recruit/recruitment','500',0);" id="f500"&gt;&lt;span&gt;招聘录用&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/recruit/analysis','501',0);" id="f501"&gt;&lt;span&gt;人才分析&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f502');"
    id="f502"&gt;&lt;span&gt;培训管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f502d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('hr/training/plan','503',0);" id="f503"&gt;&lt;span&gt;培训计划&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/training/approval/','505',0);" id="f505"&gt;&lt;span&gt;培训计划审批&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/training/record','504',0);" id="f504"&gt;&lt;span&gt;培训记录&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f26');" id="f26"&gt;&lt;span&gt;考勤管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>
    &lt;ul id="f26d" style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('attendance/manage/confirm/','506',0);" id="f506"&gt;&lt;span&gt;考勤审批&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('attendance/manage/user_manage','507',0);" id="f507"&gt;&lt;span&gt;考勤记录&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('attendance/manage/query','508',0);" id="f508"&gt;&lt;span&gt;考勤统计&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('attendance/manage/on_duty','515',0);" id="f515"&gt;&lt;span&gt;值班排班管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('attendance/manage/ask_duty','537',0);" id="f537"&gt;&lt;span&gt;查岗质询登记&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f122');"
    id="f122"&gt;&lt;span&gt;绩效考核&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f122d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('score/group','123',0);" id="f123"&gt;&lt;span&gt;考核项目设定&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('score/flow','124',0);" id="f124"&gt;&lt;span&gt;考核任务管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('score/self_assessment','628',0);" id="f628"&gt;&lt;span&gt;被考核人自评&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('score/submit','125',0);" id="f125"&gt;&lt;span&gt;进行考核&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f630');"
    id="f630"&gt;&lt;span&gt;积分管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f630d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('hr/integral/input','631',0);"
    id="f631"&gt;&lt;span&gt;积分录入&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('hr/integral/query','632',0);"
    id="f632"&gt;&lt;span&gt;积分查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('hr/integral/item_setting','633',0);" id="f633"&gt;&lt;span&gt;积分项设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f55');" id="f55"&gt;&lt;span&gt;薪酬管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>
    &lt;ul id="f55d" style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('hr/salary/insurance_para','514',0);" id="f514"&gt;&lt;span&gt;薪酬项目及保险设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/salary/staff_insurance','509',0);" id="f509"&gt;&lt;span&gt;薪酬基数设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/salary/manage','29',0);" id="f29"&gt;&lt;span&gt;工资流程管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/salary/submit','28',0);" id="f28"&gt;&lt;span&gt;财务工资录入&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/salary/report','129',0);" id="f129"&gt;&lt;span&gt;部门工资上报&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/salary/welfare_manage','510',0);" id="f510"&gt;&lt;span&gt;福利管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('hr/self_find','511',0);" id="f511"&gt;&lt;span&gt;员工自助查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f224');"
    id="f224"&gt;&lt;span&gt;人力资源设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f224d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('hr/setting/attendance','39',0);"
    id="f39"&gt;&lt;span&gt;考勤设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('hr/setting/hr_manager','512',0);" id="f512"&gt;&lt;span&gt;人力资源管理员&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('hr/setting/hr_code','513',0);" id="f513"&gt;&lt;span&gt;HRMS代码设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f252');"
    id="f252"&gt;&lt;span&gt;在线考试&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f252d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('exam_manage/set_manage','230',0);" id="f230"&gt;&lt;span&gt;题库管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('exam_manage/quiz_manage/','231',0);" id="f231"&gt;&lt;span&gt;试题管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('exam_manage/paper_manage/','232',0);" id="f232"&gt;&lt;span&gt;试卷管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('exam_manage/subject_score/','629',0);" id="f629"&gt;&lt;span&gt;主观题阅卷&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('exam_manage/info_pub/','233',0);" id="f233"&gt;&lt;span&gt;考试信息管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('exam_manage/exam_online','234',0);" id="f234"&gt;&lt;span&gt;参加考试&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('m65');" id="m65"&gt;&lt;span&gt;&lt;i class="document"&gt;&lt;/i&gt; 公文管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="m65d" style="display:none;" class="U1"&gt;<br>&lt;li class="L21"&gt;&lt;a href="javascript:c('f461');" id="f461"&gt;&lt;span&gt;发文管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>
    &lt;ul id="f461d" style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('document/index.php/send/draft','462',0);" id="f462"&gt;&lt;span&gt;发文拟稿&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('document/index.php/send/approve','463',0);" id="f463"&gt;&lt;span&gt;发文核稿&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('document/index.php/send/seal','464',0);" id="f464"&gt;&lt;span&gt;套红盖章&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('document/index.php/send/sendlist','465',0);" id="f465"&gt;&lt;span&gt;发文列表&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f466');"
    id="f466"&gt;&lt;span&gt;收文管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f466d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('document/index.php/recv/register','467',0);" id="f467"&gt;&lt;span&gt;收文登记&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('document/index.php/recv/approve','468',0);" id="f468"&gt;&lt;span&gt;领导批阅&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('document/index.php/recv/outgiving','469',0);" id="f469"&gt;&lt;span&gt;收文分发&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('document/index.php/recv/read','470',0);" id="f470"&gt;&lt;span&gt;收文阅读&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f471');"
    id="f471"&gt;&lt;span&gt;基础设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f471d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('document/index.php/setting/config','472',0);" id="f472"&gt;&lt;span&gt;参数设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('document/index.php/setting/keywords','473',0);" id="f473"&gt;&lt;span&gt;主题词管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('document/index.php/setting/type','474',0);" id="f474"&gt;&lt;span&gt;公文类型设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('document/index.php/setting/priv','475',0);" id="f475"&gt;&lt;span&gt;收文权限设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('m70');" id="m70"&gt;&lt;span&gt;&lt;i class="roll_manage"&gt;&lt;/i&gt; 档案管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="m70d" style="display:none;" class="U1"&gt;<br>&lt;li class="L22"&gt;&lt;a
    href="javascript:a('roll_manage/roll_room','200',0);" id="f200"&gt;&lt;span&gt;卷库管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('roll_manage','202',0);" id="f202"&gt;&lt;span&gt;案卷管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('roll_manage/roll_file','201',0);" id="f201"&gt;&lt;span&gt;文件管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f203');"
    id="f203"&gt;&lt;span&gt;案卷借阅&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f203d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('roll_manage/roll_lend','204',0);" id="f204"&gt;&lt;span&gt;案卷借阅&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('roll_manage/roll_lend/confirm.php','205',0);" id="f205"&gt;&lt;span&gt;借阅审批&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f206');"
    id="f206"&gt;&lt;span&gt;档案统计&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f206d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('roll_manage/roll_statistic/lend.php','207',0);" id="f207"&gt;&lt;span&gt;借阅统计&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('roll_manage/roll_statistic/roll.php','208',0);" id="f208"&gt;&lt;span&gt;案卷统计&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('roll_manage/destory','209',0);" id="f209"&gt;&lt;span&gt;档案销毁&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('m90');" id="m90"&gt;&lt;span&gt;&lt;i class="project"&gt;&lt;/i&gt; 项目管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="m90d" style="display:none;" class="U1"&gt;<br>&lt;li class="L22"&gt;&lt;a
    href="javascript:a('project/portal','65',0);" id="f65"&gt;&lt;span&gt;我的项目&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('project/task','187',0);" id="f187"&gt;&lt;span&gt;我的任务&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('project/proj','186',0);" id="f186"&gt;&lt;span&gt;项目查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('project/approve','188',0);" id="f188"&gt;&lt;span&gt;项目审批&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('project/file','189',0);" id="f189"&gt;&lt;span&gt;项目文档&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('project/bug','190',0);" id="f190"&gt;&lt;span&gt;项目问题&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f191');"
    id="f191"&gt;&lt;span&gt;基础数据设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f191d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('project/setting/cust/sys','606',0);" id="f606"&gt;&lt;span&gt;项目自定义设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('project/setting/priv','192',0);" id="f192"&gt;&lt;span&gt;项目权限设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('project/setting/code','193',0);" id="f193"&gt;&lt;span&gt;项目代码设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('project/setting/template','221',0);" id="f221"&gt;&lt;span&gt;项目模板管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('ma0');" id="ma0"&gt;&lt;span&gt;&lt;i class="reportshop"&gt;&lt;/i&gt; ERP应用&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="ma0d" style="display:none;" class="U1"&gt;<br>&lt;li class="L22"&gt;&lt;a
    href="javascript:a('reportshop/workshop','550',0);"
    id="f550"&gt;&lt;span&gt;应用中心&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L22"&gt;&lt;a
    href="javascript:a('reportshop/design/report','551',0);" id="f551"&gt;&lt;span&gt;管理平台&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('mb0');" id="mb0"&gt;&lt;span&gt;&lt;i class="comm"&gt;&lt;/i&gt; 交流园地&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="mb0d" style="display:none;" class="U1"&gt;<br>&lt;li class="L22"&gt;&lt;a href="javascript:a('sns','73',0);"
    id="f73"&gt;&lt;span&gt;企业社区&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L22"&gt;&lt;a
    href="javascript:a('bbs','62',0);" id="f62"&gt;&lt;span&gt;讨论区&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('bbs2','63',0);" id="f63"&gt;&lt;span&gt;论坛&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/bbs','34',0);" id="f34"&gt;&lt;span&gt;讨论区设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('gbtmeet','532',0);" id="f532"&gt;&lt;span&gt;专业视频会议&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('me0');" id="me0"&gt;&lt;span&gt;&lt;i class="ext_data"&gt;&lt;/i&gt;
    T10超能云中心平台&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul id="me0d" style="display:none;" class="U1"&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f548');"
    id="f548"&gt;&lt;span&gt;平台设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f548d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('ext_data/admin/setting','640',0);" id="f640"&gt;&lt;span&gt;参数设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('ext_data/admin/model','641',0);" id="f641"&gt;&lt;span&gt;流程模型同步&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('ext_data/admin/logs','642',0);" id="f642"&gt;&lt;span&gt;交换历史记录&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f549');" id="f549"&gt;&lt;span&gt;信息接收与发布&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>
    &lt;ul id="f549d" style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('ext_data/info/recv','601',0);"
    id="f601"&gt;&lt;span&gt;信息接收&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('ext_data/info/send','600',0);"
    id="f600"&gt;&lt;span&gt;信息发布&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li class="L21"&gt;&lt;a
    href="javascript:c('f602');" id="f602"&gt;&lt;span&gt;工作接收与处理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul
    id="f602d" style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('ext_data/workflow/my','603',0);" id="f603"&gt;&lt;span&gt;待办工作&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('ext_data/workflow/rule','604',0);" id="f604"&gt;&lt;span&gt;权限与规则设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('my0');" id="my0"&gt;&lt;span&gt;&lt;i class="info"&gt;&lt;/i&gt; 附件程序&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="my0d" style="display:none;" class="U1"&gt;<br>&lt;li class="L21"&gt;&lt;a href="javascript:c('f46');" id="f46"&gt;&lt;span&gt;实用信息&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>
    &lt;ul id="f46d" style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('info/tel_no','21',0);" id="f21"&gt;&lt;span&gt;电话区号查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('info/post_no','22',0);" id="f22"&gt;&lt;span&gt;邮政编码查询&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('im/show','227',0);" id="f227"&gt;&lt;span&gt;即时通讯&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L1"&gt;&lt;a href="javascript:c('mz0');" id="mz0"&gt;&lt;span&gt;&lt;i class="system"&gt;&lt;/i&gt; 系统管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;ul
    id="mz0d" style="display:none;" class="U1"&gt;<br>&lt;li class="L21"&gt;&lt;a href="javascript:c('f56');" id="f56"&gt;&lt;span&gt;组织机构设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>
    &lt;ul id="f56d" style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('system/unit','30',0);" id="f30"&gt;&lt;span&gt;单位管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/dept','31',0);" id="f31"&gt;&lt;span&gt;部门管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/user','33',0);" id="f33"&gt;&lt;span&gt;用户管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/user_priv','32',0);" id="f32"&gt;&lt;span&gt;角色与权限管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/ext_dept','605',0);" id="f605"&gt;&lt;span&gt;外部机构管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f57');"
    id="f57"&gt;&lt;span&gt;行政办公设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f57d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('system/calendar','609',0);"
    id="f609"&gt;&lt;span&gt;日程安排设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('system/url','103',0);" id="f103"&gt;&lt;span&gt;公共网址设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/diary','146',0);" id="f146"&gt;&lt;span&gt;工作日志设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/address','107',0);" id="f107"&gt;&lt;span&gt;公共通讯簿设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/notify','197',0);" id="f197"&gt;&lt;span&gt;公告通知设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/model','228',0);" id="f228"&gt;&lt;span&gt;模板管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L21"&gt;&lt;a href="javascript:c('f58');"
    id="f58"&gt;&lt;span&gt;信息交流设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br> &lt;ul id="f58d"
    style="display:none;background-color:#fff;"&gt;<br>&lt;li class="L3"&gt;&lt;a
    href="javascript:a('system/email','538',0);" id="f538"&gt;&lt;span&gt;电子邮件设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/remind','151',0);" id="f151"&gt;&lt;span&gt;短信提醒设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/mobile_sms','6',0);" id="f6"&gt;&lt;span&gt;手机短信设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L3"&gt;&lt;a href="javascript:a('system/im','534',0);" id="f534"&gt;&lt;span&gt;即时通讯管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/module_center','69',0);" id="f69"&gt;&lt;span&gt;功能管理中心&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/qyapp','71',0);" id="f71"&gt;&lt;span&gt;企业号管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/app','72',0);" id="f72"&gt;&lt;span&gt;APP应用商店设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/seal_manage','223',0);" id="f223"&gt;&lt;span&gt;印章管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/mobile_seal','639',0);" id="f639"&gt;&lt;span&gt;手机签章管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/task','225',0);" id="f225"&gt;&lt;span&gt;定时任务管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/urgent_notify','236',0);" id="f236"&gt;&lt;span&gt;紧急通知设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/interface','78',0);" id="f78"&gt;&lt;span&gt;界面设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/status_text','178',0);" id="f178"&gt;&lt;span&gt;状态栏设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/menu','104',0);" id="f104"&gt;&lt;span&gt;菜单设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/code','121',0);" id="f121"&gt;&lt;span&gt;系统代码设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/field','149',0);" id="f149"&gt;&lt;span&gt;自定义字段设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/database','84',0);" id="f84"&gt;&lt;span&gt;数据库管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/log','99',0);" id="f99"&gt;&lt;span&gt;系统日志管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/res_manage','100',0);" id="f100"&gt;&lt;span&gt;系统资源管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/attachment','533',0);" id="f533"&gt;&lt;span&gt;附件管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/access_control','101',0);" id="f101"&gt;&lt;span&gt;系统访问控制&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/security','113',0);" id="f113"&gt;&lt;span&gt;系统参数设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/ext_user','198',0);" id="f198"&gt;&lt;span&gt;系统接口设置&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/monitor','540',0);" id="f540"&gt;&lt;span&gt;服务器监控&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/secure_rule','626',0);" id="f626"&gt;&lt;span&gt;三员安全管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/t-erplinker/data_source','638',0);" id="f638"&gt;&lt;span&gt;T-ERPLinker数据源管理&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;li
    class="L22"&gt;&lt;a href="javascript:a('system/reg_view','38',0);" id="f38"&gt;&lt;span&gt;系统信息&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;<br>&lt;/ul&gt;<br>
</div>
<div id="menu_code_2" style="display:none;"></div>
<div id="menu_code_3" style="display:none;"></div>
<div id="menu_code_4" style="display:none;"></div>
<div id="menu_code_5" style="display:none;"></div>
<script type="text/javascript" src="js/utility.js"></script>
<script type="text/javascript" src="file:///C:/static/js/ispirit.js"></script>
<script type="text/javascript" src="js/ispirit.js"></script>
<script language="JavaScript">
    function init() {
        var bb = (document.compatMode && document.compatMode != "BackCompat") ? document.documentElement : document.body;
        try {
            $("body").style.height = (bb.clientHeight - $("sub_tabs").offsetHeight) + 'px';
        } catch (e) {
        }
    }

    window.onresize = (function (t) {
        return function () {
            t && clearTimeout(t);
            t = setTimeout(init, 300);
        }
    })();

    var sub_menu = "1";
    function view_menu(id) {
        set_current("");
        if ($("menu").innerHTML.toLowerCase().indexOf("<li") >= 0)
            $("menu_code_" + sub_menu).innerText = $("menu").innerHTML;

        if ($("menu_code_" + id).innerText == "" || isUndefined($("menu_code_" + id).innerText)) {
            $("menu").innerHTML = "<img src='/static/images/loading.gif' align='absMiddle'> 加载中，请稍候……";
            if (id == 2) args = "MENU_TYPE=SHORTCUT&OA_SUB_WINDOW=0&MENU_DISPLAY=";
            else if (id == 3) args = "MENU_TYPE=OA&OA_SUB_WINDOW=0";
            else if (id == 4) args = "MENU_TYPE=FAV&OA_SUB_WINDOW=0";
            else if (id == 5) args = "MENU_TYPE=FIS&OA_SUB_WINDOW=0";
            else args = "OA_SUB_WINDOW=0";
            _get("menu_code.php", args, update_menu, true);
        }
        else {
            $("menu").innerHTML = $("menu_code_" + id).innerText;
        }

        $('expand_link').style.display = (id == "2" || id == "4") ? 'none' : '';

        if ($('link_' + sub_menu))
            $('link_' + sub_menu).className = "";

        if ($('link_' + id))
            $('link_' + id).className = "active";
        sub_menu = id;
        setCookie("MENU_UI_1", id);
    }
    function update_menu(req) {
        if (req.status == 200) {
            if (req.responseText == "")
                $("menu").innerHTML = "<div style='padding:10px;'>无可访问菜单</div>";
            else {
                $("menu").innerHTML = req.responseText;
                if (sub_menu == 2) c('mMENU_SHORTCUT');
            }
        }
        else {
            $("menu").innerHTML = "<div style='padding:10px;'>错误：" + req.status + "</div>";
        }
    }

    var cur_id = "", cur_expand = "";
    var flag = 0, sflag = 0;

    //-------- 菜单点击事件 -------
    function c(id) {
        var targetid, targetelement;
        var strbuf;

        var el = $(id);
        if (!el)
            return;
        //-------- 如果点击了展开或收缩按钮---------
        targetid = el.id + "d";
        targetelement = $(targetid);
        var expandUL = $(cur_expand + "d");
        var expandLink = $(cur_expand);

        if (targetelement.style.display == "none") {
            if (expandUL && expandLink && el.id.substr(0, 1) == "m") {
                expandLink.className = "";
                expandUL.style.display = 'none';
            }
            if (el.id.substr(0, 1) == "m")
                cur_expand = el.id;
            el.className = "active";
            targetelement.style.display = '';

            menu_flag = 0;
            if (sub_menu != '2' && sub_menu != '4')
                $("expand_link").src = "/static/images/green_minus.gif";
        }
        else {
            el.className = "";
            targetelement.style.display = "none";

            menu_flag = 1;
            if (sub_menu != '2' && sub_menu != '4')
                $("expand_link").src = "/static/images/green_plus.gif";
            var links = document.getElementsByTagName("A");
            for (i = 0; i < links.length; i++) {
                el = links[i];
                if (el.parentNode.className.toUpperCase() == "L1" && el.className == "active" && el.id.substr(0, 1) == "m") {
                    menu_flag = 0;
                    if (sub_menu != '2' && sub_menu != '4')
                        $("expand_link").src = "/static/images/green_minus.gif";
                    break;
                }
            }
        }
    }
    //-------- 打开网址 -------
    function a(URL, id, open_window) {
        set_current(id);
        var URL2 = URL;

        if (URL.substr(0, 7) != "http://" && URL.substr(0, 6) != "ftp://") {
            URL = "/general/" + URL + "?_cmid=" + id;
        }
        if (URL2.substr(0, 8) == "https://")
            URL = URL2;
        if (URL.indexOf(".") < 0 && URL.indexOf("?") < 0 && URL.indexOf("#") < 0 && URL.substring(URL.length - 1) != "/")
            URL += "/";
        openURL(URL, open_window);

    }
    function b(URL, id, open_window) {
        set_current(id);
        URL = "/app/" + URL;
        openURL(URL, open_window);
    }
    function e(URL, id, open_window) {
        set_current(id);
        URL = "/hr/" + URL;
        openURL(URL, open_window);
    }
    //-------- 菜单全部展开/收缩 -------
    var menu_flag = 1;
    function menu_expand() {
        if (sub_menu == "2") return;
        if (menu_flag == 1)
            $("expand_link").src = "/static/images/green_minus.gif";
        else
            $("expand_link").src = "/static/images/green_plus.gif";

        menu_flag = 1 - menu_flag;

        var links = document.getElementsByTagName("A");
        for (i = 0; i < links.length; i++) {
            var el = links[i];
            if (el.parentNode.className.toUpperCase() == "L1" || el.parentNode.className.toUpperCase() == "L21") {
                var elUL = $(el.id + "d");
                if (menu_flag == 0) {
                    elUL.style.display = '';
                    el.className = "active";
                }
                else {
                    elUL.style.display = "none";
                    el.className = "";
                }
            }
        }
    }

    //-------- 打开windows程序 -------
    function winexe(NAME, PROG) {
        URL = "/general/winexe/?PROG=" + PROG + "&NAME=" + NAME;
        var d = new Date();
        window.open("/ispirit/go.php?CUR_UID=1&SID=aaice7qefidm31ika2ig2jti10&URL=" + escape(URL), d.getTime(), "height=100,width=350,status=0,toolbar=no,menubar=yes,location=no,scrollbars=yes,top=0,left=0,resizable=no");
    }

    function set_current(id) {
        cur_link = $("f" + cur_id)
        if (cur_link)
            cur_link.className = "";
        cur_link = $("f" + id);
        if (cur_link)
            cur_link.className = "active";
        cur_id = id;
    }

    function openURL(URL, open_window) {
        if (open_window == 1 && 0) {
            mytop = (screen.availHeight - 500) / 2 - 30;
            myleft = (screen.availWidth - 780) / 2;
            window.open(URL, "", "height=500,width=780,status=0,toolbar=no,menubar=yes,location=no,scrollbars=yes,top=" + mytop + ",left=" + myleft + ",resizable=yes");
            window.close();

        }
        else {
            parent.openURL(URL, open_window, 1);
        }
    }
    if (window.external && typeof window.external.OA_SMS != 'undefined') {
        window.external.OA_SMS('', '', 'FRESH');
        setTimeout(function () {
            window.external.OA_SMS('', '', 'FRESH');
        }, 500);
    }
</script>


</body>
</html>