<%--
  Created by IntelliJ IDEA.
  User: gaosubo
  Date: 2017/5/10
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设计流程</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <link rel="stylesheet" type="text/css" href="../../css/flowtypeY/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/flowtypeY/css/bootstrap-responsive.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/flowtypeY/css/demo.css">
    <script type="text/javascript" src="../../js/flowtypeY/js/jquery-2.1.2.min.js"></script>
    <script type="text/javascript" src="../../js/flowtypeY/js/bootstrap.min.js"></script>
    <style type="text/css">
        .zt {
            position: absolute;
            left: 0;
            top: 63px;
            bottom: 0;
            overflow: auto;
            width: 100%
        }

        .zt a {
            display: block;
            margin: 0 auto;
            padding: 10px 0;
            width: 100%;
            text-indent: 30px;
            color: #333;
            font-weight: 700;
        }

        .zt a:hover {
            background-color: #ddecff;
            color: #2aaed6
        }

        .zt .active {
            background-color: #ddecff;
            color: #2aaed6
        }

        .dingbu img {
            height: 24px
        }

        .dingbu {
            width: 100%;
            text-align: left;
            border-bottom: 1px solid #9ab8cf;
            text-indent: 15px;
            text-indent: 0;
            text-align: center;
            height: 50px;
            background-color: #fff;
            border: none;
            width: 206px;
            -webkit-box-shadow: 3px 3px 3px #e5e5e5;
            -moz-box-shadow: 3px 3px 3px #e5e5e5;
            box-shadow: 3px 3px 3px #e5e5e5;
        }

        hr {
            margin: 10px 0;
        }

        .cont {
            width: 210px;;
            height: 100%;
            position: relative;
            margin-right: -210px;
            background: #ebeff5;
        }
    </style>
    <script type="text/javascript">
        $(function () {

            $(".zt a").click(function () {
                $(".zt a").removeClass("active");
                var s = $(this).attr("url");
                $(this).addClass("active");
                $("#iframe_if").attr('src', s)
            });

        })
    </script>
</head>
<body>
<div class="clear fater">
    <div class="cont left_li left" style="background-color:#f9fafe ;">
        <div class="content_wrap">
            <div class="zTreeDemoBackground left">
                <div class="dingbu">
                    <h4 style="text-align:left;line-height:50px;text-indent: 30px;    color: #457dc1;">编辑应用</h4>
                </div>
                <div class="zt">
                    <a href="" url="" class="s1 active">设计流程</a>
                    <ul>
                        <li>定义流程属性</li>
                        <li>设计流程步骤</li>
                        <li>预览表单</li>
                        <li>导入</li>
                    </ul>
                    <a href="" url="" class="s2">管理权限</a>
                    <ul>
                        <li></li>
                    </ul>
                    <a class="fazer" href="" url="" >定时任务</a>
                    <ul>
                        <li></li>
                    </ul>
                    <a class="fazer" href="#" url="">配置查询模板</a>
                    <ul>
                        <li></li>
                    </ul>
                    <a class="fazers" href="" url="" style="">应用版式文件</a>
                    <ul>
                        <li></li>
                    </ul>
                    <%--<a href="" url="" class="glyy">关联应用设置</a>--%>
                    <%--<a href="#" url="" class="xzgt">协作沟通设置</a>--%>
                    <%--<input type="hidden" id="bbsp" value="">--%>
                    <%--<a href="" id="qiye" url=""> 发布到本企业 </a>--%>
                </div>
            </div>
        </div>
    </div>
    <div class="mod_con">
        <div class="mod_con_d">
            <div class="mod_con_di">
                <div class="window_1" id="iframe_if">
                    <div class="head_right">
                        <div class="head_right_top">
                            <a class="b_but right head_right_but"
                               style="top: 10px;position: absolute;/* display: inline-block; */font-weight: 500;right: 32px;border-color: #fd9162;color: #fff;background-color: #fd9162;width: 100px;height: 30px;line-height: 30px;font-size: 16px;border-radius: 3px;/* float: right; */"
                               href="" onclick="">返回</a>
                        </div>
                    </div>
                    <div style="overflow-y: auto; height: 536px;" id="table_box">
                        <div class="modal-hd"
                             style="float: left;color: #333333;padding: 20px;font-size: 16px;font-weight: bold;background-color: #fff;border-bottom: none;padding-bottom: 10px;">
                            编辑应用&nbsp;&gt;&nbsp;应用类型设置
                        </div>
                        <div class="midden">
                            <div id="stepheader">
                            </div>

                            <div id="step1" class="modalo">


                                <table class="table table-bordered">
                                    <tbody>
                                    <tr>
                                        <th colspan="3" style="padding: 0;border-bottom: none;">
                                            <div class="modal-hd">应用类型设置</div>
                                        </th>
                                    </tr>
                                    <tr>
                                        <td class="title1">应用名称：</td>
                                        <td>
                                            <input type="text" name="APP_NAME" id="gapp_name"
                                                   style="height:30px;width:300px;margin-bottom: 0;" value="111">
                                        </td>
                                        <td class="sign_td">
                                            <img src="./tanhao.png" style="width:16px;" class="td_img">应用的名字。
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>应用类别：</td>
                                        <td>
                                            <select name="APP_TYPE" id="gapp_type"
                                                    style="width: 300px;margin-bottom: 0;">
                                                <option value="0" selected="">通用APP</option>
                                                <!--<option value='1'   disabled="">查询APP</option>
                                                <option value='2'   disabled="">图表APP</option>   不能用暂时先去掉20160418zw -->
                                            </select>
                                        </td>
                                        <td class="sign_td">
                                            <img src="./tanhao.png" style="width:16px;" class="td_img">应用类型主要是通用APP，默认已经选中。
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>流程形态：</td>
                                        <td style="width: 380px;">
                                            <button class="btn_0" id="flow_style_btn" data_value="0"
                                                    style="margin-left: 0px;" title="标准型：普通应用，用来录入主表和从表数据，不支持流程流转">标准型
                                            </button>
                                            <button class="btn_1 select" id="flow_style_btn" data_value="1"
                                                    title="工作流节点：流程型应用，主要是从一个应用转交到下一个应用。例如从请假申请应用到请假审批应用。">工作流节点
                                            </button>
                                            <button class="btn_2" id="flow_style_btn" data_value="2"
                                                    title="工作流子流程：流程型应用，是在一个应用内部进行流转，以及流转到以一个应用。例如在请假审批中实现主管审批，财务审批，审批后跳转到下一个应用。">
                                                工作流子流程
                                            </button>
                                        </td>
                                        <td class="sign_td">
                                            <img src="./tanhao.png" style="width:16px;" class="td_img">标准型应用是普通型应用，工作流节点是应用到应用转交，工作流子流程是应用内部转交。
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>选择主表：</td>
                                        <td>


                                            <textarea name="TAB_NAME" id="tab_name" cols="30" rows="2" class="BigStatic"
                                                      wrap="yes" style="height: 30px!important;margin-bottom: 0;"
                                                      readonly=""></textarea>

                                            <input id="tab_id" type="hidden" name="tab_id" value="">
                                            <a href="javascript:;" class="orgAdd"
                                               onclick="tc_1(&#39;tab_name&#39;,&#39;tab_id&#39;)"
                                               style="margin-left: 6px;">选择</a>
                                        </td>
                                        <td class="sign_td">
                                            <img src="./tanhao.png" style="width:16px;" class="td_img">应用中包含的主表，只能选择一个。
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>选择从表：</td>
                                        <td>
                                            <input id="ctab_id" type="hidden" name="ctab_id" value="">
                                            <textarea id="ctab_name" cols="30" name="ctab_name" rows="2"
                                                      class="BigStatic" wrap="yes" readonly=""></textarea>
                                            <br><a href="javascript:;" class="orgAdd"
                                                   onclick="tc_2(&#39;ctab_name&#39;,&#39;ctab_id&#39;)"
                                                   style="margin-left: 6px;">选择</a>
                                            <br><br><a href="javascript:;" class="orgClear"
                                                       onclick="aa(&#39;#ctab_name&#39;,&#39;#ctab_id&#39;)"
                                                       style="margin-left: 6px;">清空</a>
                                        </td>
                                        <td class="sign_td">
                                            <img src="./tanhao.png" style="width:16px;" class="td_img">应用中包含的从表，可以选择0到多个。
                                        </td>
                                    </tr>

                                    </tbody>
                                </table>
                                <div class="modal-ft">
                                    <button type="button" class="ok" id="next1">保存设置</button>
                                </div>
                            </div>

                            <div id="step2" style="display:none;">
                                <link rel="stylesheet" type="text/css" href="./base.css">
                                <script type="text/javascript" src="./base.js.下载"></script>
                                <script type="text/javascript">
                                    _pro1_('ok', '恭喜您完成应用类型设置！');
                                </script>
                                <table class="pro">
                                    <tbody>
                                    <tr>
                                        <td height="20" colspan="2" align="right"></td>
                                    </tr>
                                    <tr>
                                        <td class="pro_left"><i class="pro_img pro_ok"></i></td>
                                        <td class="pro_right" style="text-align:left">恭喜您完成应用类型设置！</td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div id="myModal_1" class="modal hide fade" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel" aria-hidden="true"
                             style="background-color:#f8f8f8;width:562px;">
                            <div class="modal-header" style="padding: 5px 15px;background-color: #3477c6;">
                                <img class="close" data-dismiss="modal" aria-hidden="true" src="./img_close_x.png"
                                     style="margin-top: 10px;opacity: 1.1;">
                                <h4 id="myModalLabel" style="font-weight:500;font-size: 16.5px;">
                                    选&nbsp;择&nbsp;主&nbsp;表</h4>
                            </div>
                            <div class="search_box" style="height:30px;border-bottom: 1px solid #e5e5e5;padding: 10px;">

                                <input id="tex" type="text" placeholder="输入主表名称搜索">
                                <button class="header_search_btn">搜索</button>
                            </div>
                            <div class="modal-body" id="d1">
                                <table class="t0" id="modal-body_table">
                                    <tbody>
                                    <tr>
                                        <th colspan="3">CRM</th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435178162772689096" data_text="潜在客户">潜在客户
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435191938472211071" data_text="客户管理">客户管理
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435222243544273588" data_text="会员管理">会员管理
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435874489173391033" data_text="销售目标">销售目标
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435874619849364689" data_text="竞争对手">竞争对手
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435874678730154683" data_text="客户合同">客户合同
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435874732444262992" data_text="市场活动">市场活动
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435874879720175246" data_text="商务活动">商务活动
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435874954597649199" data_text="客户移交">客户移交
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114441163008261743095" data_text="客户投诉管理">客户投诉管理
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114441163103115150908" data_text="客户反馈管理">客户反馈管理
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114441163202613913963" data_text="客户回访管理">客户回访管理
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="tr">
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114470635010404701442" data_text="客户跟进">客户跟进
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114569740570278606971" data_text="门店巡访">门店巡访
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <table class="t1" id="modal-body_table">
                                    <tbody>
                                    <tr>
                                        <th colspan="3">采购</th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435888438230954118" data_text="供应商管理">供应商管理
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435890957498572629" data_text="采购订单">采购订单
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435894408715761720" data_text="采购入库">采购入库
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435897199907569641" data_text="采购退货">采购退货
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435939090939709175" data_text="采购付款">采购付款
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435939209452094386" data_text="采购发票">采购发票
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="tr">
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114933453319748338042" data_text="报修单">报修单
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <table class="t2" id="modal-body_table">
                                    <tbody>
                                    <tr>
                                        <th colspan="3">库存</th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435875902017060774" data_text="仓库管理">仓库管理
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435877468634940787" data_text="货位管理">货位管理
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435879020923816951" data_text="品牌管理">品牌管理
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435880253328050295" data_text="产品管理">产品管理
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435882078158993700" data_text="库存管理">库存管理
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435883842965979881" data_text="库存调整">库存调整
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435886588528627620" data_text="货位调整">货位调整
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114649385201365729038" data_text="库存入库">库存入库
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114649432599283339070" data_text="库存出库">库存出库
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="tr"></tr>
                                    </tbody>
                                </table>
                                <table class="t3" id="modal-body_table">
                                    <tbody>
                                    <tr>
                                        <th colspan="3">销售</th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435899907834786927" data_text="销售订单">销售订单
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435903054898266869" data_text="销售出库">销售出库
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435906828816256433" data_text="销售退货">销售退货
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435911524359723583" data_text="销售换货">销售换货
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435939308308259586" data_text="销售付款">销售付款
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114435939395149794249" data_text="销售发票">销售发票
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="tr"></tr>
                                    </tbody>
                                </table>
                                <table class="t4" id="modal-body_table">
                                    <tbody>
                                    <tr>
                                        <th colspan="3">财务</th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114450707948735973924" data_text="公司信息">公司信息
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114454111218778956617" data_text="费用报销">费用报销
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114454144528183469748" data_text="出差费用报销">出差费用报销
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="tr">
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114574161665218801518" data_text="借款">借款
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114930861473716847779" data_text="付款表">付款表
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <table class="t5" id="modal-body_table">
                                    <tbody>
                                    <tr>
                                        <th colspan="3">行政办公</th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114453243657585974145" data_text="日常采购">日常采购
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114453282002876486740" data_text="固定资产">固定资产
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114453286388033820076" data_text="会议室管理">会议室管理
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114453288923859132294" data_text="物品管理">物品管理
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114453289026991438923" data_text="物品领用">物品领用
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114470663312118431018" data_text="会议申请">会议申请
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="tr">
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114569732645225635343" data_text="通用审批">通用审批
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114574184951490354784" data_text="合同">合同
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <table class="t6" id="modal-body_table">
                                    <tbody>
                                    <tr>
                                        <th colspan="3">人力资源</th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114452207712446801581" data_text="请假">请假
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114452220420928400421" data_text="加班">加班
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114452231280416460140" data_text="出差">出差
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114563046979140153901" data_text="外出登记">外出登记
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114920519916655030346" data_text="员工离职表">员工离职表
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114920573344849810192" data_text="转正表">转正表
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="tr"></tr>
                                    </tbody>
                                </table>
                                <table class="t7" id="modal-body_table">
                                    <tbody>
                                    <tr>
                                        <th colspan="3">行业应用</th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114887625523723399873" data_text="销控表">销控表
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114887778635033737549" data_text="采购申请表单">采购申请表单
                                            </button>
                                        </td>
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114918134545807549652" data_text="团队确认单">团队确认单
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="tr">
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114918166579791869089" data_text="七彩蝶">七彩蝶
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <table class="t8" id="modal-body_table">
                                    <tbody>
                                    <tr>
                                        <th colspan="3">个人应用</th>
                                    </tr>
                                    <tr class="tr">
                                        <td>
                                            <button class="tcc_btn" onclick="tcc_btn($(this))"
                                                    value="101114918067573484308464" data_text="七彩蝶流程表单">七彩蝶流程表单
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-body" id="d2"></div>
                            <div class="modal-footer"
                                 style="text-align: right;padding: 10px;border-top: 1px solid #e5e5e5;">
                                <a href="https://app.gsubo.com/gapp/gapp_manage/new.php?gid=101014930268333273668317&amp;step=1&amp;tids=0&amp;gname=111#"
                                   class="n_but" data-dismiss="modal" aria-hidden="true"
                                   style="font-weight: 500;border: 1px solid #4192ee;color: #4192ee;background-color: #fff;width: 56px!important;height: 20px;line-height: 20px;font-size: 15px; border-radius: 4px;text-align: center;margin-bottom: 5px;">取消</a>
                                <a href="https://app.gsubo.com/gapp/gapp_manage/new.php?gid=101014930268333273668317&amp;step=1&amp;tids=0&amp;gname=111#"
                                   class="n_but" onclick="tcc_btn_sub($(this))" data-dismiss="modal" aria-hidden="true"
                                   style="font-weight: 500;border: 1px solid #4192ee;color: #fff;background-color: #4093f3;width: 86px!important;height: 20px;line-height: 20px;font-size: 15px; border-radius: 4px;text-align: center;margin-bottom: 5px;">确定</a>

                            </div>
                        </div>
                        <div id="myModal_2" class="modal hide fade" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel" aria-hidden="true"
                             style="background-color:#f8f8f8;width:562px;">
                            <div class="modal-header" style="padding: 5px 15px;background-color: #3477c6;">
                                <img class="close" data-dismiss="modal" aria-hidden="true" src="./img_close_x.png"
                                     style="margin-top: 10px;opacity: 1.1;">
                                <h4 id="myModalLabel" style="font-weight:500;font-size: 16.5px;">
                                    选&nbsp;择&nbsp;主&nbsp;表</h4>
                            </div>
                            <div class="search_box" style="height:30px;border-bottom: 1px solid #e5e5e5;padding: 10px;">

                                <input id="tex" type="text" placeholder="输入主表名称搜索">
                                <button class="header_search_btn">搜索</button>
                            </div>
                            <div class="modal-body" id="d1">
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114537874467486002302"
                                            data_text="固定资产管理明细表">固定资产管理明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114543963360774886145"
                                            data_text="数据表">数据表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114887625759782026250"
                                            data_text="销控从表">销控从表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114887778770011668510"
                                            data_text="采购申请明细表单">采购申请明细表单
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114893728988195289554"
                                            data_text="考核">考核
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114893729621037095405"
                                            data_text="KPI">KPI
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114917979502277816860"
                                            data_text="结算单">结算单
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114930871213105471177"
                                            data_text="付款明细表">付款明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114930875088770955625"
                                            data_text="付款明细测试">付款明细测试
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114932695877127908061"
                                            data_text="采购申请单明细">采购申请单明细
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943104897346794055"
                                            data_text="报损申请明细表">报损申请明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943107537865240742"
                                            data_text="菜类明细表">菜类明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943121177929042473"
                                            data_text="豆制品明细表">豆制品明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943126063423287689"
                                            data_text="其他明细表">其他明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943142575374901230"
                                            data_text="猪肉类明细表">猪肉类明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943143378120734532"
                                            data_text="鲜花类明细表">鲜花类明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943150605746817553"
                                            data_text="禽类明细表">禽类明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943158839465112180"
                                            data_text="牛肉类明细表">牛肉类明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943175009679749431"
                                            data_text="冷冻货明细表">冷冻货明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943821062754282449"
                                            data_text="前厅部明细表">前厅部明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943825808836420796"
                                            data_text="会议流程明细表">会议流程明细表
                                    </button>
                                </li>
                                <li>
                                    <button class="tcc_btn" onclick="tcc_btn1($(this))" value="101114943832435888691647"
                                            data_text="餐饮部明细表">餐饮部明细表
                                    </button>
                                </li>
                            </div>
                            <div class="modal-body" id="d3"></div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
