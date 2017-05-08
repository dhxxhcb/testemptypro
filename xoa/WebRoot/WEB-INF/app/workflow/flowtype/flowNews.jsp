<%--
  Created by IntelliJ IDEA.
  User: gaosubo
  Date: 2017/5/8
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建流程</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk" />
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
<link rel="stylesheet"type="text/css" href="css/validationEngine.jquery.min.css">
<script type="text/javascript" src="/inc/js_lang.php"></script>
<script src="js/jquery-1.10.2/jquery.min.js"></script>
<script src="js/jquery.validationEngine.min.js" type="text/javascript" charset="utf-8"></script>
<script>
    jQuery(document).ready(function(){
        jQuery("#form").validationEngine({promptPosition:"centerRight"});
    });
</script>
<body data-spy="scroll" data-target=".bs-docs-sidebar">
<link rel="stylesheet" type="text/css" href="css/dialog.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/workflow/style.css" />
<link rel="stylesheet" type="text/css" href="css/navigate.css" />
<link rel="stylesheet" type="text/css" href="css//autocomplete.css">
<link rel="stylesheet" type="text/css" href="css/workflow/cssstyle/style.css">
<link rel="stylesheet" type="text/css" href="css/new_flow.css">

<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap/contextmenu/bootstrap.contextmenu.min.js"></script>
<script type="text/javascript" src="js/attach.js"></script>
<script type="text/javascript" src="js/utility.js"></script>

<script src="js/module.js?v=150805"></script>
<!-- 未引该文件 -->
<!-- <script language="javascript" src="js/jquery.browser.js"></script> -->

<script type="text/javascript" src="js/jquery.curcss.js"></script>
<!--<script type="text/javascript" src="/static/js/jquery-1.5.1/jquery-ui.custom.min.js"></script>-->
<script language="javascript" src="js/jquery/jquery.ui.core.js"></script>
<script language="javascript" src="js/jquery.ui.widget.js"></script>
<script language="javascript" src="js/jquery.ui.position.js"></script>
<script type="text/javascript" src="js/jquery.ui.autocomplete.min.js"></script>
<script language="javascript" src="js/common.js"></script>
<script language="javascript" src="js/combobox.js"></script>




<script type="text/javascript" src="js/custom_plug.js"></script>
<script type="text/javascript" src="js/navigate.js"></script>

<script type="text/javascript" src="js/new_flow.js"></script>
<script type="text/javascript" src="js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="js/jquery.ui.selectable.js"></script>
<script type="text/javascript" src="js/selectableScroll.js"></script>
<style>
    #feedback { font-size: 1.4em; }
    .ui-selecting { background: rgb(114, 176, 207); }
    .ui-selected { background: rgb(64,148,189); color: white; }
</style>
<script type="text/javascript">
    var upload_limit=1,limit_type="php,php3,php4,php5,";
    var msg_tip = "确定要删除文件 '%s' 吗？";
    var FLOW_SORT='';
    var FORM_ID='';
    var FREE_OTHER='';
    var FLOW_TYPE='';
    var DEPT_ID='';
    var AUTO_EDIT='';
    var FREE_PRESET='';
    var FLOW_DOC='';
    var IS_VERSION='';
    var VIEW_PRIV='';
    var FORM_NAME='';
    var FLOW_READ_ONLY='';
    var all='全部表单';
    function checkFlowName(){
        jQuery.ajax({
            url: "checkFlowName.php",
            data: "FLOW_NAME="+jQuery('#step_val').val()+"&FLOW_ID="+jQuery('#FLOW_ID').val()+"&MODIFY_TYPE="+jQuery('#MODIFY_TYPE').val(),
            type: "GET",
            async: true,
            success: function(data){
                if(data != "1")
                {
                    alert(data);
                }
                else
                {
                    check_flow_type()
                }
            },
            error: function(data){
                alert(data.responseText);
            }
        });
    }
</script>
<script type="text/javascript">
    jQuery(function() {

        jQuery("#next_step_div").selectableScroll({ filter: 'tr',appendTo: '#next_step_dump_div'});
        jQuery("#alternative_div").selectableScroll({ filter: 'tr',appendTo: '#next_step_dump_div'});
    });
    if(window.external && typeof window.external.OA_SMS != 'undefined') //如果从OA精灵打开，则最大化窗口
    {
        var h = Math.min(800, screen.availHeight - 180),
            w = Math.min(1280, screen.availWidth - 180);
        window.external.OA_SMS(w, h, "SET_SIZE");
    }
</script>
<div name="body">
    <!-- 左侧导航部分开始 -->
    <div class="span3 bs-docs-sidebar" id="nav_left">
        <ul class="nav nav-list bs-docs-sidenav">
            <li class="active" name="basic" item="first">
                <a href="#basic" data-toggle="tab">
                    <i class="icon-chevron-right" style="margin-top:8px;"></i>
                    <span class="icon20-basic_hover">基本属性</span>
                </a>
            </li>
            <li class="" name="work_name" >
                <a href="#work_name"  data-toggle="tab">
                    <i class="icon-chevron-right" style="margin-top:8px;"></i>
                    <span class="icon20-work_name">工作名称/文号</span>
                </a>
            </li>
            <li class="" name="process_illustrate">
                <a href="#process_illustrate"  data-toggle="tab">
                    <i class="icon-chevron-right" style="margin-top:8px;"></i>
                    <span class="icon20-process_illustrate">流程说明</span>
                </a>
            </li>
            <li class="" name="expand_field"  item="last">
                <a href="#expand_field" data-toggle="tab">
                    <i class="icon-chevron-right" style="margin-top:8px;"></i>
                    <span class="icon20-expand_field">扩展字段</span>
                </a>
            </li>
        </ul>
    </div>
    <!-- 左侧导航部分结束 -->
    <!-- 右侧body主要部分的开始 -->
    <div class="nav-right-container" id="nav-right-container">
        <form action="new_flow/add.php" id="form" method="post" name="flow_type"  enctype="multipart/form-data">
            <div class="tab-content nav-right" style="border:0px solid red;">
                <div class="tab-pane active" id="basic">
                    <style>
                        .ui-menu {
                            width:216px;
                        }
                        .flow_content{
                            display: inline-block;
                        }
                    </style>
                    <!-- 基本属性页面 右侧头部的开始 -->
                    <div class="flow_top_type clearfix">
                        <div class="float_left"><span class="icon20-basic">基本属性</span></div>
                        <div class="step_name_intro">
                            <span  class="flow_intro">流程名称:</span>
                            <span class="flow_name"></span>

                        </div>
                    </div>
                    <!-- 基本属性页面 右侧头部的结束-->
                    <div style="clear: both;">
                        <div class="left_body">
                            <div class="f_field_block_small">
                                <div class="f_field_label"><span class="f_field_title">流程名称</span><span  class="f_field_required">*</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <input type="text" id="step_val" name="FLOW_NAME" value=>
                                </div>
                            </div>
                            <div class="f_field_block_small">
                                <div class="f_field_label"><span class="f_field_title">流程分类</span><span  class="f_field_required">*</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <select name="FLOW_SORT" style="width:220px;" id="FLOW_SORT">
                                        <option value=1>├公文管理</option>
                                        <option value=2>├行政管理</option>
                                        <option value=18>│├差旅管理</option>
                                        <option value=19>│├印章管理</option>
                                        <option value=20>│└其他</option>
                                        <option value=3>├人资管理</option>
                                        <option value=12>│├招聘管理</option>
                                        <option value=13>│├培训管理</option>
                                        <option value=14>│├岗位管理</option>
                                        <option value=15>│├考勤管理</option>
                                        <option value=16>│├薪酬管理</option>
                                        <option value=17>│└离职管理</option>
                                        <option value=4>├财务管理</option>
                                        <option value=21>│├财务管控</option>
                                        <option value=22>│└费用管理</option>
                                        <option value=9>├资产管理</option>
                                        <option value=37>│├固定资产</option>
                                        <option value=38>│└流动资产</option>
                                        <option value=10>├项目管理</option>
                                        <option value=39>│├工程项目</option>
                                        <option value=40>│├科研项目</option>
                                        <option value=42>│├研发项目</option>
                                        <option value=41>│└其他</option>
                                        <option value=11>├采购管理</option>
                                        <option value=31>│├采购报价</option>
                                        <option value=32>│├采购合同</option>
                                        <option value=33>│├采购到货</option>
                                        <option value=34>│└质检</option>
                                        <option value=6>├生产管理</option>
                                        <option value=35>│├订货生产管理</option>
                                        <option value=36>│└存货生产管理</option>
                                        <option value=7>├销售业务</option>
                                        <option value=23>│├售前跟进</option>
                                        <option value=24>│├销售过程管理</option>
                                        <option value=27>││├客户管理</option>
                                        <option value=28>││├订单管理</option>
                                        <option value=29>││├合同管理</option>
                                        <option value=30>││└报价管理</option>
                                        <option value=25>│├售后管理</option>
                                        <option value=26>│└销售相关</option>
                                        <option value=8>└其他</option>
                                    </select>
                                </div>
                            </div>
                            <div class="f_field_block_small">
                                <div class="f_field_label"><span class="f_field_title">表单</span><span  class="f_field_required">*</span></div>
                                <div class="f_field_ctrl_small clear" id="form_select">
                                    <select id="FORM_ID" name="FORM_ID" onchange="getFormField();"class="select_form">
                                        <option value="0" category="" node="root" level=""></option>
                                        <option value="62" category="财务管控">专项资金申请单</option><option value="58" category="财务管控">日常收支记录单</option><option value="56" category="财务管控">部门内资金划拨单</option><option value="25" category="财务管控">库存现金盘点表</option><option value="113" category="采购报价">采购及支出申请</option><option value="104" category="采购报价">采购报价审批单</option><option value="114" category="差旅管理">出差申请单</option><option value="109" category="差旅管理">出差申请单</option><option value="38" category="差旅管理">出差申请表</option><option value="107" category="订货生产管理">基层生产调度周报</option><option value="81" category="订货生产管理">异常报告处理单</option><option value="80" category="订货生产管理">项目（产品）执行下单表</option><option value="79" category="订货生产管理">品质异常通知单</option><option value="78" category="订货生产管理">生产变更通知单</option><option value="74" category="订货生产管理">产品测试问题报告</option><option value="73" category="订货生产管理">不合格品罚款通知单</option><option value="72" category="订货生产管理">生产事故调查表</option><option value="29" category="工程项目">工程变更申请通知单(ECN)</option><option value="20" category="公文管理">工作督办表</option><option value="13" category="公文管理">请示处理单</option><option value="12" category="公文管理">普通文件传阅单</option><option value="11" category="公文管理">会议纪要</option><option value="10" category="公文管理">公文会稿签发单</option><option value="9" category="公文管理">内部事项报批单</option><option value="8" category="公文管理">报告</option><option value="7" category="公文管理">签报</option><option value="6" category="公文管理">发文单-政府风格</option><option value="5" category="公文管理">收文单-政府风格</option><option value="4" category="公文管理">发文单-简洁风格</option><option value="3" category="公文管理">收文单-简洁风格</option><option value="2" category="公文管理">发文单-深沉风格</option><option value="1" category="公文管理">收文单-深沉风格</option><option value="48" category="固定资产">固定资产变动表</option><option value="27" category="固定资产">固定资产报废申请表</option><option value="26" category="固定资产">固定资产报修单</option><option value="24" category="固定资产">固定资产申请表</option><option value="23" category="固定资产">固定资产请购单</option><option value="86" category="客户管理">客户跟踪记录单</option><option value="99" category="售前跟进">市场活动企划单</option><option value="92" category="售前跟进">销售调查计划表</option><option value="89" category="售前跟进">市场信息反馈表</option><option value="84" category="售前跟进">潜在客户调查表</option><option value="45" category="招聘管理">增员申请表</option><option value="55" category="采购合同">合同审批单</option><option value="15" category="采购合同">采购申请表</option><option value="77" category="存货生产管理">设备故障维护工作申请单</option><option value="76" category="存货生产管理">事故登记表</option><option value="75" category="存货生产管理">工作改进报告</option><option value="93" category="订单管理">促销活动申请表</option><option value="112" category="费用管理">备用金申请</option><option value="111" category="费用管理">报销申请单</option><option value="103" category="费用管理">付款审批单</option><option value="102" category="费用管理">差旅报销单</option><option value="101" category="费用管理">差旅费报销清单</option><option value="95" category="费用管理">广告预算审批单</option><option value="61" category="费用管理">支票申领单</option><option value="60" category="费用管理">支出证明单</option><option value="59" category="费用管理">医疗费报销单</option><option value="57" category="费用管理">请款(借支)申请单</option><option value="54" category="费用管理">付款申请单</option><option value="53" category="费用管理">常用备用金申请单</option><option value="51" category="费用管理">报销申请单</option><option value="50" category="费用管理">预支工资申请</option><option value="49" category="费用管理">借款单</option><option value="105" category="科研项目">项目内部请示报告</option><option value="19" category="流动资产">计算机类设备报废申请表</option><option value="39" category="培训管理">培训需求表</option><option value="143" category="印章管理">xoa123</option><option value="142" category="印章管理">xoa</option><option value="122" category="印章管理">用印申请单</option><option value="32" category="印章管理">用印申请表</option><option value="108" category="采购到货">进存单</option><option value="131" category="岗位管理">固定资产处置表 </option><option value="120" category="岗位管理">人员转正申请单</option><option value="115" category="岗位管理">岗位说明书</option><option value="47" category="岗位管理">转正申请表</option><option value="46" category="岗位管理">职务任免审批表</option><option value="44" category="岗位管理">员工考核评定表</option><option value="40" category="岗位管理">人员异动表</option><option value="34" category="岗位管理">员工入职单</option><option value="87" category="合同管理">合同评审表</option><option value="85" category="合同管理">销售协议审批书</option><option value="31" category="其他">信息系统需求确认表</option><option value="30" category="其他">名片印刷登记单</option><option value="28" category="其他">会议使用申请表</option><option value="22" category="其他">公共活动场所使用申请单</option><option value="21" category="其他">工作请示处理表</option><option value="18" category="其他">档案查阅申请表</option><option value="17" category="其他">部门工作汇报单</option><option value="16" category="其他">用车申请表</option><option value="14" category="其他">办公用品申领表</option><option value="97" category="售后管理">客户投诉登记表</option><option value="90" category="售后管理">退换货申请单</option><option value="88" category="售后管理">客户投诉处理表</option><option value="82" category="报价管理">报价单</option><option value="117" category="考勤管理">请假登记单</option><option value="116" category="考勤管理">加班申请单</option><option value="43" category="考勤管理">外出登记单</option><option value="36" category="考勤管理">加班登记表</option><option value="35" category="考勤管理">请假申请表</option><option value="33" category="考勤管理">值班登记表</option><option value="91" category="销售相关">销售人员外出登记单</option><option value="83" category="销售相关">销售业绩评估表</option><option value="121" category="研发项目">项目费用预算单</option><option value="69" category="研发项目">研发项目立项申请报告</option><option value="68" category="研发项目">研发评估</option><option value="67" category="研发项目">需求处理</option><option value="66" category="研发项目">项目阶段考核</option><option value="64" category="研发项目">立项申请</option><option value="63" category="研发项目">BUG处理</option><option value="71" category="质检">产品质量检查报告</option><option value="65" category="其他">项目级别评估表</option><option value="106" category="薪酬管理">月绩效考核-自评表</option><option value="42" category="薪酬管理">停薪留职申请表</option><option value="41" category="薪酬管理">调薪申请表</option><option value="119" category="离职管理">人员离职申请单</option><option value="118" category="离职管理">人员离职交接</option><option value="37" category="离职管理">离职申请表</option><option value="127" category="其他">合同付款申请单</option><option value="126" category="其他">日常费用报销单</option><option value="100" category="其他">网站信息发布审批表</option><option value="98" category="其他">软件业务申请单</option><option value="96" category="其他">法律文件审核表</option><option value="94" category="其他">法律咨询表</option><option value="70" category="其他">智能测试表单</option><option value="145" category="未分类">222</option><option value="144" category="未分类">321</option><option value="136" category="未分类">员工培训班申请表</option><option value="133" category="未分类">员工外出学习审批表</option><option value="125" category="未分类">项目任务审批</option><option value="124" category="未分类">项目立项申请</option><option value="123" category="未分类">项目资金申请</option>
                                    </select>
                                    <input type="hidden" value="" name="form_id_work" />
                                    <a href="javascript:;" onclick="formView();return false;" class="view_form"><span class="icon18-void">预览表单</span></a>
                                </div>
                            </div>
                            <div class="f_field_block_small clear">
                                <div class="f_field_label"><span class="f_field_title">流程类型</span><span  class="f_field_required">*</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <select name="FLOW_TYPE" class="span2"  id="FLOW_TYPE">
                                        <option value="1" >固定流程</option>
                                        <option value="2" >自由流程</option>
                                    </select>
                                    <input type="hidden" value="" name="flow_type_work" />
                                </div>
                            </div>
                            <div class="f_field_block_small" id="FREE_SET" style="display:none;">
                                <div class="f_field_label"><span class="f_field_title">允许预设步骤</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <label class="radio" style="float:left;">
                                        <input type="radio" name="FREE_PRESET" category="1" value="1" checked > 是    				</label>
                                    <label class="radio" style="float:left;margin-left:15px;padding-bottom:5px;">
                                        <input type="radio" name="FREE_PRESET" category="0" value="0"> 否    				</label>
                                </div>
                            </div>
                            <div class="f_field_block_small clear">
                                <div class="f_field_label"><span class="f_field_title">委托类型</span><span  class="f_field_required">*</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <select name="FREE_OTHER" id="FREE_OTHER" style="width:220px;">
                                        <option value="2">自由委托</option>
                                        <option value="3">按步骤设置的经办权限委托</option>
                                        <option value="1">仅允许委托当前步骤经办人</option>
                                        <option value="0">禁止委托</option>
                                    </select>
                                    <a href="javascript:void(0);"  style="color:#3f9bca;" id="entrust" onclick='showTitle("entrust","entrust_tip",-120,40);'>
                                        <span class="icon18-illustration"></span>
                                    </a>
                                </div>
                            </div>
                            <div class="f_field_block_small" style="clear:both;">
                                <div class="f_field_label"><span class="f_field_title">是否允许上传附件</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <label class="radio" style="float:left;">
                                        <input type="radio" name="FLOW_DOC" value="1" checked> 是                    </label>
                                    <label class="radio"  style="float:left;margin-left:15px;padding-bottom:19px;">
                                        <input type="radio" name="FLOW_DOC"  value="0"> 否                    </label>
                                </div>
                            </div>
                            <div class="f_field_label clear" >
                                <div class="f_field_label"><span class="f_field_title">是否启用版本控制</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <label class="radio" style="float:left;">
                                        <input type="radio" name="IS_VERSION" value="1" checked > 是                    </label>
                                    <label class="radio" style="float:left;margin-left:15px;padding-bottom:19px;">
                                        <input type="radio" name="IS_VERSION" value="0"> 否                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="right_body">
                            <div class="f_field_block_small">
                                <div class="f_field_label"><span class="f_field_title">所属部门</span><span  class="f_field_required">*</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <select style="width:220px;" name="DEPT_ID" id="DEPT_ID">
                                        <option value="0">系统(仅由系统管理员管理)</option>
                                        <option value=1>├中国兵器工业信息中心</option>
                                        <option value=3>│└北京通达信科科技有限公司</option>
                                        <option value=17>│　└总经理</option>
                                        <option value=4>│　　├综合管理部</option>
                                        <option value=18>│　　│├人力资源部</option>
                                        <option value=19>│　　│├财务部</option>
                                        <option value=20>│　　│└行政部</option>
                                        <option value=5>│　　├市场营销部</option>
                                        <option value=39>│　　│├市场部</option>
                                        <option value=33>│　　││├品牌部</option>
                                        <option value=31>│　　││├网络营销中心</option>
                                        <option value=32>│　　││└商务中心</option>
                                        <option value=40>│　　│└销售部</option>
                                        <option value=7>│　　│　├北京销售部</option>
                                        <option value=28>│　　│　│├销售一组</option>
                                        <option value=29>│　　│　│├销售二组</option>
                                        <option value=30>│　　│　│├销售三组</option>
                                        <option value=27>│　　│　│└销售协作组</option>
                                        <option value=8>│　　│　└上海销售部</option>
                                        <option value=6>│　　├研发部</option>
                                        <option value=34>│　　│├产品部</option>
                                        <option value=9>│　　│├开发一部</option>
                                        <option value=10>│　　│├开发二部</option>
                                        <option value=11>│　　│├质量保证部</option>
                                        <option value=15>│　　│└设计部</option>
                                        <option value=41>│　　├项目部</option>
                                        <option value=42>│　　│├项目一部</option>
                                        <option value=43>│　　│└项目二部</option>
                                        <option value=16>│　　└生产部</option>
                                        <option value=38>│　　　├采购部</option>
                                        <option value=35>│　　　├生产一部</option>
                                        <option value=37>│　　　├生产二部</option>
                                        <option value=36>│　　　└质检部</option>
                                        <option value=2>└北方测试研究公司</option>
                                        <option value=14>　└北一测试研究院</option>
                                    </select>
                                </div>
                            </div>
                            <input type="hidden" name="DEPT_ID_OLD" value="">
                            <div class="f_field_block_small">
                                <div class="f_field_label"><span class="f_field_title">流程排序号</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <input type="text" class="span1" placeholder="0" name="FLOW_NO" value="" id="FLOW_NO" >
                                    <a href="javascript:void(0);"  style="color:#3f9bca;" id="flow_num" onclick='showTitle("flow_num","flow_num_tip",-30,40);'>
                                        <span class="icon18-illustration"></span>
                                    </a>
                                </div>
                            </div>
                            <div class="f_field_label clear" >
                                <div class="f_field_label"><span class="f_field_title">是否允许传阅</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <label class="radio" style="float:left;">
                                        <input type="radio"  name="VIEW_PRIV" value="1"   > 是    				</label>
                                    <label class="radio" style="float:left;margin-left:15px;padding-bottom:15px;">
                                        <input type="radio"  name="VIEW_PRIV" value="0" checked> 否    				</label>
                                </div>
                            </div>
                            <div class="f_field_label clear" style="display:none;" id="view_user">
                                <div class="f_field_label"><span class="f_field_title">传阅人</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <input type="hidden" name="VIEW_USER_ID" value="">
                                    <textarea style="width:200px;height:30px;" name="VIEW_USER_NAME" wrap="yes" readonly ></textarea>
                                    <a href="javascript:;" class="orgAdd" onClick="SelectUser('5','','VIEW_USER_ID', 'VIEW_USER_NAME','','flow_type')">选择</a>
                                    <a href="javascript:;" class="orgClear" onClick="ClearUser('VIEW_USER_ID', 'VIEW_USER_NAME')">清空</a>
                                </div>
                            </div>
                            <div class="f_field_label clear" style="display:none;" id="view_dept">
                                <div class="f_field_label"><span class="f_field_title">传阅部门</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <input type="hidden" name="VIEW_DEPT_ID" value="">
                                    <textarea style="width:200px;height:30px;" name="VIEW_DEPT_NAME" wrap="yes" readonly ></textarea>
                                    <a href="javascript:;" class="orgAdd" onClick="SelectDept('','VIEW_DEPT_ID', 'VIEW_DEPT_NAME','','flow_type')">选择</a>
                                    <a href="javascript:;" class="orgClear" onClick="ClearUser('VIEW_DEPT_ID', 'VIEW_DEPT_NAME')">清空</a>
                                </div>
                            </div>
                            <div class="f_field_label clear" style="display:none;" id="view_role">
                                <div class="f_field_label"><span class="f_field_title">传阅角色</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <input type="hidden" name="VIEW_ROLE_ID" value="">
                                    <textarea style="width:200px;height:30px;" name="VIEW_ROLE_NAME" wrap="yes" readonly ></textarea>
                                    <a href="javascript:;" class="orgAdd" onClick="SelectPriv('','VIEW_ROLE_ID', 'VIEW_ROLE_NAME','','flow_type')">选择</a>
                                    <a href="javascript:;" class="orgClear" onClick="ClearUser('VIEW_ROLE_ID', 'VIEW_ROLE_NAME')">清空</a>
                                </div>
                            </div>
                            <div class="f_field_label clear" >
                                <div class="f_field_label"><span class="f_field_title">更多操作项设置</span></div>
                                <div class="f_field_ctrl_small clear">
                                    <div class="flow_content">
                                        <label class="flow_content checkbox">
                                            <input type="checkbox" id="FLOW_ACTION_NOTIFY" name="FLOW_ACTION_NOTIFY" checked value="1" /><label for="FLOW_ACTION_NOTIFY">公告通知</label>
                                        </label>
                                        <label class="flow_content checkbox">
                                            <input type="checkbox" id="FLOW_ACTION_EMAIL" name="FLOW_ACTION_EMAIL" checked value="1" /><label for="FLOW_ACTION_EMAIL">内部邮件</label>
                                        </label>
                                        <label class="flow_content checkbox">
                                            <input type="checkbox" id="FLOW_ACTION_SAVE_AS" name="FLOW_ACTION_SAVE_AS" checked value="1" /><label for="FLOW_ACTION_SAVE_AS">转存</label>
                                        </label>
                                        <label class="flow_content checkbox">
                                            <input type="checkbox" id="FLOW_ACTION_SAVE" name="FLOW_ACTION_SAVE" checked value="1" /><label for="FLOW_ACTION_SAVE">归档</label>
                                        </label>
                                    </div>
                                    <div class="f_field_explain_label">
                        <span id="explain" class="f_field_explain_title_green">
                            设置表单打印页面更多操作以及工作办理页面分享和更多中的操作。                        </span>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div id="entrust_tip" style="display: none;background:#f8f2c2;">
                        <label>[委托类型说明：]<span class="close" style="margin-right:10px;" title="关闭" onclick='closeTip("entrust_tip");'>x</span></label>
                        <label><b>1.自由委托：</b>用户可以在工作委托模块中设置委托规则,可以为委托给任何人。</label>
                        <label><b>2.按步骤设置的经办权限委托：</b>仅能委托给流程步骤设置中经办权限范围内的人员</label>
                        <label><b>3.按实际经办人委托：</b>仅能委托给步骤实际经办人员。</label>
                        <label><b>4.禁止委托：</b>办理过程中不能使用委托功能。</label>
                        <label><b>注意：</b>只有自由委托才允许定义委托规则，委托后更新自己步骤为办理完毕，主办人变为经办人</label>
                    </div>
                    <div id="flow_num_tip" style="display: none;background:#f8f2c2;width:250px;">
                        <label>[流程排序号说明：]<span class="close" style="margin-right:10px;" title="关闭" onclick='closeTip("flow_num_tip");'>x</span></label>
                        <label>控制同一分类下流程的排序</label>
                    </div>							</div>
                <div class="tab-pane" id="work_name">
                    <div class="flow_top_type clearfix">
                        <div class="float_left"><span class="icon20-work_name">工作名称/文号</span></div>
                        <div class="step_name_intro">
                            <span  class="flow_intro">流程名称:</span>
                            <span class="flow_name"></span>

                        </div>
                    </div>
                    <div>
                        <div class="main_content" style="margin-right:20px;">
                            <div class="f_field_block">
                                <div class="f_field_label"><span class="f_field_title">文号表达式</span></div>
                                <div class="f_field_ctrl clear">
                                    <input type="text" style="width:220px;" name="AUTO_NAME"  value="">
                                    <a href="javascript:;" style="color:#3f9bca; text-decoration:none;display:none;" id="showTip"  onclick='showTitle("showTip","tip_intro");'>
                                        <span class="icon18-illustration"></span>
                                    </a>
                                </div>
                            </div>
                            <div class="f_field_block">
                                <div class="f_field_label"><span class="f_field_title">编号计数器</span></div>
                                <div class="f_field_ctrl clear">
                                    <input type="text" style="width:100px;" placeholder="0" name="AUTO_NUM" value="" id="AUTO_NUM" >
                                </div>
                            </div>
                            <div class="f_field_block">
                                <div class="f_field_label"><span class="f_field_title">编号位数</span></div>
                                <div class="f_field_ctrl clear">
                                    <input type="text" style="width:100px;" placeholder="0" name="AUTO_LEN" value="" id="AUTO_LEN" >
                                </div>
                            </div>
                            <div class="f_field_block"  style="margin-top: 12px;height:80px;">
                                <div  class="f_field_label"><span class="f_field_title">是否允许修改</span></div>
                                <div class="f_field_ctrl clear">
                                    <select name="AUTO_EDIT" id="AUTO_EDIT"  onchange="is_force()" style="float: left;width:170px;">
                                        <option value="1" >允许修改</option>
                                        <option value="0" >不允许修改</option>
                                        <option value="2" >仅允许输入前缀</option>
                                        <option value="3" >仅允许输入后缀</option>
                                        <option value="4" >仅允许输入前缀和后缀</option>
                                    </select>
                                    <label class="checkbox" style="float: left;margin-left:20px;margin-top:5px;display:none;" name="force" id="force" >
                                        <input type="checkbox"  name="FORCE_PRE_SET" value="1" > 强制    			</label>
                                </div>
                            </div>
                        </div>
                        <div class="main_content">
                            <div id='tip_intro' style="background:#fcfcfc;width:540px">
                                <div style="font-weight:bold;font-size:14px;">一、文号表达式说明</div>
                                <div style="margin-top:5px;">
                                    <div><span style="font-weight:bold;">表达式中可以使用以下特殊标记：</span></div>
                                    <div style="margin-top: 5px;">
                                        <span>{Y} ：表示年</span>
                                        <span style="margin-left: 98px;">{M} ：表示月</span>
                                        <span style="margin-left: 70px;">{D}：表示日</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>{H} ：表示时</span>
                                        <span style="margin-left: 98px;">{I} ：表示分</span>
                                        <span style="margin-left: 70px;">{S}：表示秒</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>{F} ：表示流程名</span>
                                        <span style="margin-left: 71px;">{U} ：表示用户姓名</span>
                                        <span style="margin-left: 32px;">{R}：表示角色</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>{FS}：表示流程分类名称</span>
                                        <span style="margin-left: 32px;">{SD}：表示短部门</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>{LD}：表示长部门</span>
                                        <span style="margin-left: 63px;">{RUN}：表示流水号</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>{N} ：表示编号，通过编号计数器取值并自动增加计数值</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>{NY} ：表示编号，每过一年编号重置一次</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>{NM} ：表示编号，每过一月编号重置一次</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>例如，表达式为：成建委发[{Y}]{N}号，同时设置自动编号显示长度为4，</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>则自动生成的文号如下：成建委发[2006]0001号。</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>例如，表达式为：BH{N}，同时设置自动编号显示长度为3，</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>则自动生成的文号如下：BH001。</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>例如，表达式为：{F}流程（{Y}年{M}月{D}日{H}:{I}）{U}，</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>则自动生成文号如：请假流程（2006年01月01日10:30）张三。</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>可以不填写自动文号表达式，则系统默认按以下格式，如：</span>
                                    </div>
                                    <div style="margin-top: 5px;">
                                        <span>请假流程(2006-01-01 10:30:30)。</span>
                                    </div>
                                </div>
                                <div style="font-weight:bold;font-size:14px;margin-top: 5px;">二、编号计数器说明</div>
                                <div style="margin-top: 5px;">
                                    <span>用于表达式编号标记</span>
                                </div>
                                <div style="font-weight:bold;font-size:14px;margin-top: 5px;">三、编号位数说明</div>
                                <div style="margin-top: 5px;">
                                    <span>为0表示按实际编号位数显示</span>
                                </div>
                            </div>

                        </div>
                    </div>							</div>
                <div class="tab-pane" id="process_illustrate">
                    <div class="flow_top_type clearfix">
                        <div class="float_left"><span class="icon20-process_illustrate">流程说明</span></div>
                        <div class="step_name_intro">
                            <span  class="flow_intro">流程名称:</span>
                            <span class="flow_name"></span>

                        </div>
                    </div>
                    <div class="form_type" style="height:200px;clear:both;">
                        <textarea id="TD_HTML_EDITOR_FLOW_DESC" name="TD_HTML_EDITOR_FLOW_DESC" rows="8" cols="60"></textarea>
                        <script type="text/javascript">//<![CDATA[
                        window.UEDITOR_CONFIG={"UEDITOR_HOME_URL":"\/module\/ueditor\/"};
                        //]]></script>
                        <script type="text/javascript">//<![CDATA[
                        window.HTML_MODEL_TYPE='01';
                        //]]></script>
                        <script type="text/javascript" src="js/ueditor.config.min.js?t=D5AC"></script>
                        <script type="text/javascript" src="js/ueditor.all.min.js?t=D5AC"></script>
                        <script type="text/javascript">//<![CDATA[
                        UE.dom.domUtils.on(window, 'load', function(){var ue = UE.getEditor('TD_HTML_EDITOR_FLOW_DESC', {"model_type":"01","initialFrameWidth":"830","initialFrameHeight":"150","attachmentId":"ATTACHMENT_ID_OLD","attachmentName":"ATTACHMENT_NAME_OLD","toolbars":[["bold","italic","insertorderedlist","insertunorderedlist","|","justifyleft","justifycenter","justifyright","justifyjustify","link","unlink","fontfamily","fontsize","forecolor","backcolor","insertimage","emotion","|","template","source","fullscreen"]],"lang":"zh-cn"});ue.ready(function(){typeof(editorLoaded) == 'function' && editorLoaded({editor:ue});ue.dirty = false;ue.on('contentChange',function(){ue.dirty = true;});});});
                        //]]></script>
                    </div>
                    <div class="f_field_block">
                        <div class="f_field_label"><span class="f_field_title">说明文档</span></div>
                        <div class="f_field_ctrl clear" style="margin-top:5px;">
                            <span>暂无</span>
                        </div>
                    </div>
                    <div class="f_field_block">
                    <div class="f_field_label"><span class="f_field_title">上传文档</span></div>
                    <div class="f_field_ctrl clear">
                        <script>ShowAddFile();</script>
                        <input type="hidden" name="ATTACHMENT_ID_OLD"    id="ATTACHMENT_ID_OLD"   value="">
                        <input type="hidden" name="ATTACHMENT_NAME_OLD"  id="ATTACHMENT_NAME_OLD" value="">
                    </div>
                </div>
            </div>
            <div class="tab-pane" id="expand_field">
                <!-- 右侧页面顶部 的开始-->
                <div class="flow_top_type clearfix">
                    <div class="float_left"><span class="icon20-expand_field">扩展字段</span></div>
                    <div class="step_name_intro">
                        <span  class="flow_intro">流程名称:</span>
                        <span class="flow_name"></span>

                    </div>
                </div>
                <!-- 右侧页面顶部 的结束-->
                <!-- 页面控件部分的开始 -->
                <div class="plug_body">
                    <!-- 右侧页面控件左侧部分开始 -->
                    <div class="plug_body_left">
                        <div class="list_title">显示在待办列表上的字段</div>
                        <div class="list_infomation" id="next_step_div">
                            <table cellspacing="0px" cellpadding="0px" width="100%" id="next_step_tab">
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <div style="margin-top:10px;">
                            <button class="btn" id="left_btn"  type="button" onclick="selectAll('left',1);" style="margin-left:100px;">全选</button>
                        </div>
                    </div>
                    <!-- 右侧页面控件左侧部分结束 -->
                    <!-- 右侧页面控件中间部分开始 -->
                    <div class="plug_body_center">
                        <div class="change_right">
                            <img src="/static/modules/workflow/system/images/right.png" id="change_right" onclick="selectPlug('next_step_tab','alternative_tab','left_btn',1);">
                        </div>
                        <div class="change_left">
                            <img src="/static/modules/workflow/system/images/left.png" id="change_left" onclick="selectPlug('alternative_tab','next_step_tab','right_btn',1);">
                        </div>
                    </div>
                    <!-- 右侧页面控件中间部分结束 -->
                    <!-- 右侧页面控件右侧部分开始 -->
                    <div class="plug_body_right">
                        <div class="list_title">备选字段</div>
                        <div class="list_infomation" id="alternative_div">
                            <table cellspacing="0px" cellpadding="0px" width="100%" id="alternative_tab">
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <div style="margin-top:10px;">
                            <button class="btn" id="right_btn" type="button" onclick="selectAll('right',1);" style="margin-left:100px;">全选</button>
                        </div>
                    </div>
                    <!-- 右侧页面控件右侧部分结束-->
                </div>
                <!-- 页面控件部分的结束 -->
                <div style="clear:both;color:green;margin-top:15px;">点击条目时，可以组合CTRL键进行多选</div>							</div>
    </div>
    <input type="hidden"  value=""  id="LIST_FLDS_STR"  name="LIST_FLDS_STR" >
    <input type="hidden"  value=""   name="FLOW_ID" id="FLOW_ID"   />
    <input type="hidden"  value=""   id="SORT_ID"  />
    <input type="hidden"  value="135"  name="targetTab" />
    <input type="hidden"  value="/general/system/workflow/flow_guide/index.php?FLOW_ID="  id="close_url" />
    <input type="hidden"  value="" name="OLD_FLOW_SORT" />
    <input type="hidden"  value=流程名称:: id="hidId" />
    <input type="hidden"  value="" id="old_form_id" />
    <input type="hidden"  value=""  id="MODIFY_TYPE"  name="MODIFY_TYPE" >

    </form>
</div>
</div>
<!-- 右侧body主要部分的结束 -->
<!-- 页面底部的开始 -->
<div class="work_bottom">
    <div class="work_center">
        <div class="btn_close">
            <button class="btn btn-warning"  type="button" onclick="close_flow()">关闭</button>
        </div>
        <div class="btn_save">
            <button class="btn btn-success" type="button" onclick="popping();">保存</button>
        </div>
        <div class="btn_next" name="btn_next">
            <button class="btn btn-primary next_step" type="button" >下一步</button>
        </div>
        <div class="btn_next"  name="btn_prev">
            <button class="btn" type="button" disabled="disabled" id="prev_step">上一步</button>
        </div>
    </div>
</div>
<!-- 页面底部的结束 -->
<script type="text/javascript">
    function ShowDialog(id,vTopOffset)
    {
        if("" != "COPY")
        {
            checkFlowName();
        }
        else
        {
            if(typeof arguments[1] == "undefined")
            {
                vTopOffset = 90;
            }
            var bb=(document.compatMode && document.compatMode!="BackCompat") ? document.documentElement : document.body;
            jQuery("#overlay").width("100%");
            jQuery("#overlay").height(Math.max(parseInt(bb.scrollHeight),parseInt(bb.offsetHeight))+"px");
            jQuery("#overlay").show();
            jQuery("#"+id).css({
                position: 'fixed',
                left: '50%',
                top: '50%',
                marginLeft: '-160px',
                marginTop: '-120px',
                lineHeight: '40px',
                color: '#666',
                fontSize: '14px',
                border: '1px solid #ccc',
                borderRadius: '3px',
                width: '300px',
                height: '170px',
                boxShadow: '0 0 5px #555',
                textAlign: 'center'
            }).show();
        }
    }
    function popping(){
        ShowDialog('save_keyword');
        if("" == "COPY")
        {
            document.getElementById("title").innerHTML = "请选择复制内容";
        }
    }
    function HideDialog(id)
    {
        jQuery("#overlay").hide();
        jQuery("#"+id).hide();
    }
</script>
</body>
</html>
