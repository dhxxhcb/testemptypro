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
    <title>新建工作</title>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8 ? MYOA_CHARSET : htmlspecialchars($HTML_PAGE_CHARSET))?>" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../../css/workflow/m_reset.css">
    <link rel="stylesheet" type="text/css" href="../../css/workflow/work/new_work.css">
    <link rel="stylesheet" type="text/css" href="../../css/workflow/work/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../lib/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/workflow/work/handle.css"/>
    <script type="text/javascript" src="../../js/news/jquery-1.9.1.js"></script>
    <script src="../../js/base/base.js"></script>
    <script src="../../js/workflow/work/workform.js"></script>
    <script src="../../lib/laydate.js"></script>
    <script src="../../lib/layer/layer.js"></script>
</head>

<style type="text/css">
    /*.modal-body {
     overflow: hidden !;
    }*/
    .cont{
        position: relative;
    }
    #tab_c{
        width:316px;
        height:100%;
        top:0;
        bottom:0;
        position: fixed;
       /* background: red;*/
        overflow-y: scroll;
        box-shadow: -2px 0 20px 0px #c4c4c4;
    }
    .cont_form{
        position: absolute;
        right: 320px;
    }
    #tab_c,.cont_form{
        float:left;
    }
    .tab_one,#tab_ctwo{
        width:100%;
        height:100%;
    }
    .cont_ctwo{
        width:100%;
        height:100%;
    }
    .cont_cone{
        width:100%;
        height:85%;
    }
   .tab_one{
        width:100%;
       height: 200%;
    }
    .cont_cone li{
        width: 85%;
        height:50px;
        margin:10px auto;
        border: 1px solid #cccccc;
        border-radius: 3px;

    }

    .one_all,.two_all{
        width:100%;
        height:50%;
    }
    .one_all{
        border-bottom: 1px solid #ccc;
    }
    #tab_ctwo ul{
        width:100%;
        height:100%;
        display:none;
    }
    .item_logo,.item_word{
        float:left;
    }
    .item_logo{
        width: 40px;
        height: 40px;
        margin-left: 3px;
        margin-top: 5px;
        background: #00a2d4;
    }
    .item_word{
        margin-top: 5px;
        margin-left: 7px;
    }
    .item_word h1{
        color: #4b4b4b;
        font-size: 10pt;
    }
    .item_word h2{
        color: #919191;
    }
    .position{
        position: absolute;
        right: 0px;
        top: 13px;
        clear: both;
    }
    .fujian_logo,.fujian_h1,.huiqian_logo,.huiqian_h1{
        float: left;

    }
    .fujian_logo{
        margin-top: 3px;
    }
    .huiqian_logo{
        margin-top: 10px;
    }
    .fujian_h1,.huiqian_h1{
        margin-left: 5px;
        font-size: 12pt;
/*        line-height: 40px;*/
    }
    .huiqian_h1{
        line-height: 40px;
    }
    .add_fujian{
        width: 85%;
        height: 40px;
        border-radius: 7px;
        /*border: none;*/
        background: #54a9fc;
        color: #fff;
        margin: auto;
        margin-left: 24px;
        text-align: center;
        line-height: 40px;
        outline: none;
    }
    .cont_ctwo li{
        width: 90%;
        height: 70px;
        border-radius: 3px;
        margin: auto;
        border:1px solid #cccccc;
        margin-top: 7px;
    }
    .huiqian_inp,.huiqian_send{
        float:left;
    }
    .huiqian_inp{
        width: 68%;
        height: 30px;
        border-radius: 3px;
        border: none;
        outline: none;
        text-align: left;
        border: 1px solid #cccccc;
        margin-left: 0px;
    }
    .huiqian_send{
        width: 24%;
        height: 30px;
        background: #ff9b30;
        color: #fff;
        margin-left: 8px;
        outline: none;
        border-radius: 3px;
        border: none;
    }
    .huiqian_word{
        width:80%;
        height:100%;
        margin-left: 4px;
    }
    .huiqian_word h1{
        margin-top: 8px;
    }
    .huiqian_word h2{
        color: #919191;
    }
    .huiqian_touxiang{
        margin-left: 2px;
    }
    .huiqian_touxiang,.huiqian_word{
        float: left;
    }
    .huiqian_word h3{
        overflow: hidden;/*内容超出后隐藏*/
        text-overflow: ellipsis;/* 超出内容显示为省略号*/
        white-space: nowrap;/*文本不进行换行*/

    }
    .huiqian_touxiang{
        width: 40px;
        height: 40px;
    }
    .layui-layer-page .layui-layer-content {

        overflow: hidden !important;
    }
    .foot li:hover {
        color:#fff !important;
        background:#4889f0 !important;
    }
    /*.choose{
       color:#fff;
        background:#4889f0 !important;
    }*/
    #remind_name,#jingban{
           height: 20px !important;
    }
    .workflow-node {
        padding: 0px !important;
    }
    .prcsName{
        width: 100%;
        height: 40px;
        background: url("../../../img/workflow/work/add_work/uncheck.png") no-repeat 20px center;
    }
    .prcsName h1 {
        text-align: center;
        line-height: 40px;
    }
    .prcsName_chang{
        color:#fff;
        background: #5B7FCB  url("../../../img/workflow/work/add_work/checked.png") no-repeat 20px center;
    }
    .fujian a,.huiqian a{
        width: 70px;
        height: 28px;
        display: block;
        text-decoration: none;
    }
    .top_one{
        position: absolute;
        top: 0px;
    }
    .top_two{
        position: absolute;
        top: 696px;
    }
    #tab_c{
        transition: all 1s ease 0s;
    }
    .list_table{
        border-width: medium;
        border-style: none;
        border-color: initial;
        border-collapse: collapse;
        word-wrap: break-word;
        table-layout: fixed;
    }
    .list_table .head {
        font-weight: 600;
    }
    .list_table td{
        border-bottom: #7F7F7F 1pt solid;
        /* border-left: #000000 2.25pt solid; */
        text-align: center;
        width: 50px;
        padding-bottom: 1px;
        padding-left: 1px;
        padding-right: 1px;
        vertical-align: middle;
        border-top: #7F7F7F 1pt solid;
        border-right: black 1pt solid;
        padding-top: 1px;
        padding: 0;
    }
</style>
<body>
<div class="body">
    <div class="head">
        <div id="title" class="abs_left">
            <h1 class="num"></h1>
            <h2 class="step"></h2>
            <select class="opt">
                <option>普通</option>
                <option>紧急</option>
            </select>
        </div>

        <div id="tab_t" class="abs_right">
            <ul>
                <li class="fujian"><a  href="#fu">附件</a></li>
                <li class="huiqian" ><a  href="#hui">会签</a></li>
                <li class="liucheng">流程</li>
                <li class="guanlian">关联</li>
            </ul>
        </div>
    </div>
    <div class="content">
        <form action="<%=basePath%>/workflow/work/nextwork"   id="ajaxform">
        <div class="cont" id="client">
            <div class="cont_form" id="a2">

            </div>
            <div id="tab_c">
                <div class="tab_one">
                    <div class="one_all" id="fu">
                        <ul class="cont_cone">
                            <li style="height:21px;position:relative;border:none;"><img class="fujian_logo" src="../../img/workflow/work/add_work/black.png"><h1 class="fujian_h1">附件</h1></li><div class="position"><img src="../../img/workflow/work/add_work/back.png"></div>
                            <li><div class="item_logo"></div><div class="item_word"><h1>Saas事业部5月...任务工单.xlsx</h1><h2>10.8k</h2></div></li>
                            <li><div class="item_logo"></div><div class="item_word"><h1>Saas事业部5月...任务工单.xlsx</h1><h2>10.8k</h2></div></li>
                            <li><div class="item_logo"></div><div class="item_word"><h1>Saas事业部5月...任务工单.xlsx</h1><h2>10.8k</h2></div></li>
                        </ul>
                        <button class="add_fujian">添加附件</button>
                    </div>
                    <div class="two_all" id="hui">
                        <ul class="cont_ctwo">
                            <li style="height:33px;border: none;"><img class="huiqian_logo" src="../../img/workflow/work/add_work/black.png"><h1 class="huiqian_h1">会签</h1></li>
                            <li style="height:33px;border: none;"><input type="text" class="huiqian_inp"><button class="huiqian_send">发送</button></li>
                            <li><div class="huiqian_touxiang"><img class="huiqian_logo" src="../../img/workflow/work/add_work/touxiang.png"></div><div class="huiqian_word"><h1>部门经理</h1><h2>2017年5月24日 15:34</h2><h3>会签意见会签意见会签意见会签意见会签意见</h3></div></li>
                            <li><div class="huiqian_touxiang"><img class="huiqian_logo" src="../../img/workflow/work/add_work/touxiang.png"></div><div class="huiqian_word"><h1>部门经理</h1><h2>2017年5月24日 15:34</h2><h3>会签意见会签意见会签意见会签意见会签意见</h3></div></li>
                        </ul>
                    </div>

                </div>
                <div id="tab_ctwo">
                    <ul class="cont_cthr" style="background: green;">
                        <li>流程</li>
                    </ul>
                    <ul class="cont_cfour" style="background: cyan;">
                        <li>关联</li>
                    </ul>
                </div>

            </div>
        </div>
        <div class="foot">
            <div class="foot_left">
                <ul>
                    <li class="left_li"><img class="left_img" src="../../img/workflow/work/add_work/sheji.png"><h1 class="left_h1">流程图</h1></li>
                    <li class="left_li"><img class="left_img" src="../../img/workflow/work/add_work/weituo.png"><h1 class="left_h1">委托</h1></li>
                    <li class="left_li"><img class="left_img" src="../../img/workflow/work/add_work/print.png"><h1 class="left_h1">打印</h1></li>
                    <li class="left_li" id="attach_name"><img class="left_img" src="../../img/workflow/work/add_work/lan.png"><h1 class="left_h1" >附件</h1></li>
                </ul>
            </div>
            <div class="foot_rig">
                <ul>
                    <li class="rig_li zhuanjiao"><h1 class="rig_h1">转交下一步</h1></li>
                    <li class="rig_li"><h1 class="rig_h1">保存</h1></li>
                    <li class="rig_li"><h1 class="rig_h1">保存返回</h1></li>
                    <li class="rig_li"><h1 class="rig_h1">取消</h1></li>
                </ul>
            </div>
        </div>
        </form>
    </div>

</div>
</body>
</html>
<script>
    $(function(){
        var flowId = $.getQueryString("flowId");
        var flowStep = $.getQueryString("flowStep");
        $('#tab_c').css('right',-($('#tab_c').width()))
        $('#tab_c').css('height',$('#tab_c').height()-$('.head').height()-$('.foot').height())
        $('#tab_c').css('top',$('.head').height())
        //引入方法
        workForm.init({
                formhtmlurl:'../../workflow/work/workfastAdd',//URL
                resdata:{
                    flowId:flowId
                },
                flowStep:flowStep,//预览
                target:'.cont_form'},
            
            function (data) {
                zhuanjiao(data);

                var obj=data.object.flowRun
                var  titleName=obj.runName;
                $('.num').html(titleName);

                var obj2=data.object.listFp[0];
                /*console.log(obj2);*/
                $('.step').html('主办：(第一步：'+obj2.prcsName+')');

                /*console.log($('.form_item'));*/


             });

            /* })*/

       //第一个
       $('.fujian').on('click',function(){
             $('.fujian').find('a').css('color','#fff');
              $('.huiqian').find('a').css('color','#4889f0');
              $(this).siblings().removeClass("check");
              $(this).addClass('check');
              $('#tab_c').css('right','0px')
              $('#tab_ctwo').hide();
              $('.tab_one').show();

       })
        //第二个
        $('.huiqian').on('click',function(){
            $('.fujian').find('a').css('color','#4889f0');
            $(this).find('a').css('color','#fff');
            $(this).siblings().removeClass("check");
            $(this).addClass('check');
            $('#tab_ctwo').hide();
            $('.tab_one').show();
            /*$('.one_all').hide();
            $('.tab_one').show();
            $('.cont_ctwo').show();*/

        })
        //第三个
        $('.liucheng').on('click',function(){
            $('.huiqian').find('a').css('color','#4889f0');
            $('.fujian').find('a').css('color','#4889f0');
            $(this).siblings().removeClass("check");
            $(this).addClass('check');
            $('.cont_cthr').siblings().hide();
            $('.tab_one').hide();
            $('#tab_ctwo').show();
            $('.cont_cthr').show();
        })
        //第四个
        $('.guanlian').on('click',function(){
            $('.huiqian').find('a').css('color','#4889f0');
            $('.fujian').find('a').css('color','#4889f0');
            $(this).siblings().removeClass("check");
            $(this).addClass('check');
            $('.cont_cfour').siblings().hide();
            $('.tab_one').hide();
            $('#tab_ctwo').show();
            $('.cont_cfour').show();
        })
        $('.position').on('click',function () {
            $('#tab_c').css('right',-$('#tab_c').width())
        })
        //点击左下角的附件
        $('#attach_name').on('click',function(){

            $('#tab_c').animate({right:'0px'},"slow");

        })
        function subPric(source,pos) {
            var strs= new Array(); //定义一数组
            strs=source.split(pos); //字符分割
           return strs;
        }
       function zhuanjiao(data) {
           //转交下一步
           var obj=data.object.flowRun
           var titleName=obj.runName;
           console.log(titleName);
           var prcsTo;
           for(var i=0;i<data.object.listFp.length;i++){
               var obj2=data.object.listFp[i];
               /*console.log(obj2.prcsTo);*/
               if(obj2.prcsTo!=""){
                   prcsTo= subPric(obj2.prcsTo,",");
                  /* console.log(prcsTo)*/
                   break;
               }
           }

           var prcsName='';

           if(prcsTo){
               for (var j=0;j<prcsTo.length;j++){
                   for(var i=0;i<data.object.listFp.length;i++){
                       var obj2=data.object.listFp[i];
                       /*console.log(obj2.prcsId==prcsTo);*/
                       if(obj2.prcsId== prcsTo[j]){
                           prcsName+='<div class="prcsName" style="" prcsId='+obj2.prcsId+'><h1>'+obj2.prcsName+'</h1></div>';
                       }
                   }
               }
           }

               $('.zhuanjiao').on('click',function(){
                   console.log($('.opt').val()==0?'':$('.opt').val());
                   //找到表格上的内容
                   var form_item=$('.cont_form .form_item');
                   var realData=[];
                    var radioArr = {};
                   for(var i=0;i<form_item.length;i++){
                       var baseData={};
                       var value="";
                       var obj = form_item.eq(i);
                       var datatype = obj.attr("data-type");
                       var key=obj.attr("name");
                       if(datatype=="select"){
                           value= obj.val()==0?'':form_item.eq(i).val();
                       }
                       if(datatype=="textarea" || datatype=="text" ){
                           value=obj.val();
                       }
                       if(datatype=="macros"){
                            if(obj.attr('type') == "text"){
                                value= obj.val();
                            }else{
                                value= obj.val()==0?'':form_item.eq(i).val();
                            }
                       }
                       if(obj.attr("type")=="radio"){
                           var name = obj.attr('name');
                            if(!radioArr[obj.attr('name')]){
                                radioArr[obj.attr('name')] = true;
                                if($("input[name='"+name+"']:checked")){

                                    value= $("input[name='"+name+"']:checked").val();
                                }else{
                                    value = '';
                                }
                            }
                       }
                       if(value != '' && value){
                           baseData["key"]=key;
                           baseData["value"]=value;
                           realData.push(baseData);
                       }

                   }

                   var obj3=data.object.flowRun;
                   console.log(obj3);
                   datas={
                       flowId:obj3.flowId,
                       formdata:JSON.stringify(realData),
                       runId:obj3.runId,
                       runName:obj3.runName,
                       beginTime:obj3.beginTime,
                       beginUser:obj3.beginUser
                   }

                    //保存表格数据的接口
                    $.ajax({
                        type: "post",
                        url: "../../workflow/work/nextwork",
                        dataType: 'JSON',
                        data: datas,
                        success: function(obj){
                            if(obj.flag==true){

                                //传入的参数
                                layer.open({
                                    type: 1,
                                    /* skin: 'layui-layer-rim', //加上边框 */
                                    offset: '80px',
                                    area: ['800px', '400px'],
                                    closeBtn: 0,
                                    title:titleName,
                                    content: '<div class="modal-body" style="max-height: 274px;">'+
                                    '<div class="work-prcs-title" id="op_user_show_info" style="margin-bottom: 10px;font-weight: normal;border-radius: 4px;-webkit-border-radius: 4px;">'+
                                    '当前步骤为第<font color="red">1</font>步[人力资源部拟定]<font color="red"><div self_type="self" style="display:inline;">系统管理员</div>'+
                                    '<div style="display:inline;">(办理中)</div></font></div><div class="work-prcs-block"><div class="work-prcs-title" id="prcs_title">'+
                                    '请选择下一步骤<div class="workflow-procs-nodes-op-wrap"><span id="all_check" style="display:none;"><i></i>全选</span></div></div>'+
                                    '<div class="work-prcs-content clearfix"><div class="workflow-procs-nodes-wrap"><ul id="workPrcsData" class="workflow-procs-nodes"><li class="workflow-node" id="next_prcs_2">'+
                                    prcsName+'<ol></ol> </li></ul></div><div class="workflow-procs-line"></div><div class="workflow-procs-nodes-result-wrap">'+
                                    '<ul id="work-next-prcs-block" class="workflow-procs-nodes-result" style="top: 0px;">'+
                                    '<li class="workflow-node-result clearfix " prcs_id_next="2">'+
                                    '<div class="workflow-node-title"><div class="workflow-node-title-text">上级主管核定</div><div class="workflow-node-ops"><input id="chose_user2" type="button" prcs_type="" gather_node_have_flag="0" class="btn btn-info user-op op-first users-add" prcs_back="" prcs_next="2" is_child_node="0" value="选择人员"></div> </div>'+
                                    '<div class="users-select-block"><div id="host_op_block_div2" class="clearfix">'+
                                    '  <input type="hidden" id="PRCS_OP_USER2" data_type="op_user_btn" name="PRCS_OP_USER2" value="admin">'+
                                    ' <input type="hidden" id="PRCS_BACK" name="PRCS_BACK" value=""><div class="sponsor">'+
                                    '<a href="#" class="prcs-op-uname" id="TOP_FLAG_SHOW2">主办人：</a><input type="hidden" id="TOP_FLAG2" name="TOP_FLAG2" value="0">'+
                                    '<div id="TOP_FLAG_SHOW2_menu" class="attach_div small" style="display: none; top: 33px; left: 153px;">'+
                                    '<a href="javascript:set_top(0,"2");">主办人：</a><a href="javascript:set_top(2,"2");">无主办人会签：</a>'+
                                    '<a href="javascript:set_top(1,"2");">先接收者主办：</a></div></div>'+
                                    '<textarea class="user-tags" id="remind_name" user_id="admin"></textarea></div>'+
                                    '<div id="prcs_op_block_div2" class="clearfix">'+
                                    '<input type="hidden" data_type="op_user_btn" id="PRCS_USER2" name="PRCS_USER2" value="admin,">'+
                                    '<div class="managers">经办人：</div><textarea class="user-tags" user_id="admin" id="jingban"></textarea>'+
                                    '</div></div></li></ul></div></div></div><div class="work-msg-block">'+
                                    '<div class="work-msg-title"><a id="msg-control" href="#"><img style="vertical-align: text-top;" src="../../img/workflow/work/add_work/form_down.png"></a> 向以下人员发送事务提醒消息</div>'+
                                    '<div class="work-msg-content" style="display: block;"><div class="clearfix">'+
                                    '<div data_type="next" class="work-msg-op-title">下一步骤：<span class="sms-check sms-bg " title="发送事务提醒"></span> <span class="mobile-check mobile-bg mobile-bg-static" title="发送手机短信" style="display:none;"></span>'+
                                    '<span class="email-check email-bg email-bg-static" title="发送Internet邮件"></span>'+
                                    '</div>'+
                                    '<div data_type="create" class="work-msg-op-title">发起人：<span class="sms-check sms-bg sms-bg-static" title="发送事务提醒"></span>'+
                                    '<span class="mobile-check mobile-bg mobile-bg-static" title="发送手机短信" style="display:none;"></span>'+
                                    '<span class="email-check email-bg email-bg-static" title="发送Internet邮件"></span></div>'+
                                    '<div data_type="managers" class="work-msg-op-title">全部经办人：<span class="sms-check sms-bg sms-bg-static" title="发送事务提醒"></span> <span class="mobile-check mobile-bg mobile-bg-static" title="发送手机短信" style="display:none;"></span>'+
                                    '<span class="email-check email-bg email-bg-static" title="发送Internet邮件"></span> </div> </div>'+
                                    '<div class="clearfix">'+
                                    '提醒指定步骤经办人： <input type="hidden" name="remind_others_id" id="remind_others_id" value="">'+
                                    '<textarea name="remind_others_name" id="remind_others_name" readonly="" style="width:376px;"></textarea>'+
                                    '<a class="orgAdd" id="others-add">选择</a>'+
                                    '<a class="orgClear" id="others-clear" href="javascript:ClearUser("remind_others_id", "remind_others_name");">清空</a>'+
                                    '</div>'+
                                    '<div class="work-msg-sms-block">'+
                                    '提醒内容：<input type="text" style="width: 600px;" name="SMS_CONTENT" id="SMS_CONTENT" value="您有新的工作需要办理，流水号：829，工作名称/文号：岗位说明书-企业(2017-05-25 18:47:35)">'+
                                    ' </div></div></div></div>',

                                    btn:['确认', '取消'],
                                    success: function(layero,index){
                                        //调取选人控件
                                        $('#chose_user2').on('click',function(){
                                            user_id='remind_name';
                                            $.popWindow("../../common/selectUser");
                                        })

                                        //底部选择人员
                                        $('#others-add').on('click',function(){
                                            user_id='remind_others_name';
                                            $.popWindow("../../common/selectUser");
                                        })
                                        //折叠
                                        $('#msg-control').on('click',function(){
                                            if($('#msg-control').find('img').attr('src')=='../../img/workflow/work/add_work/form_down.png'){
                                                $('#msg-control').find('img').attr('src','../../img/workflow/work/add_work/from_right.png')
                                            }else{
                                                $('#msg-control').find('img').attr('src','../../img/workflow/work/add_work/form_down.png')
                                            }
                                            $('.work-msg-content').slideToggle();
                                        });
                                        //点击下一步骤，样式的改变
                                        $('.workflow-procs-nodes-wrap').on('click','.prcsName',function(){
                                            $(this).siblings().removeClass('prcsName_chang');
                                            $(this).addClass('prcsName_chang');
                                            $(this).siblings().attr('check','0');
                                            $(this).attr('check','1');
                                        })

                                    },
                                    yes: function(index, layero){
                                        //按钮【按钮三】的回调

                                        //新建工作之后的保存接口，跳转到我的工作页面
                                        var ret=data.object.flowRun;
                                        var ret2=data.object.flowRunPrcs
                                      /*  console.log(ret);*/
                                        if($('.prcsName').attr('check')=='1'){
                                            var pId=$('.prcsName').attr('prcsId');
                                        }

                                        savedData={
                                            flowId:ret.flowId,
                                            runId:ret.runId,
                                            runName:ret.runName,
                                            beginTime:ret.beginTime,
                                            beginUser:ret.beginUser,
                                            prcsId:pId,
                                            prcsflag:1,
                                            flowPrcs:ret2.flowPrcs,
                                            jingbanUser:$('#remind_name').attr('user_id')
                                        }
                                       /* console.log(pId);*/
                                        console.log(savedData);

                                        //保存的接口
                                        $.ajax({
                                            type: "post",
                                            url: "../../workflow/work/saveWork",
                                            dataType: 'JSON',
                                            data: savedData,
                                            success: function (obj) {
                                                if(obj.flag==true){
                                                    alert('正确');
                                                    window.close();
                                                    parent.opener.location.href='workList';
                                                  /*  function clicke(){
                                                     alert("事件");
                                                     }*/

                                                }else{
                                                    alert('错误');
                                                   /* window.close();*/
                                                  /*  parent.opener.location.href='workList';*/

                                                }
                                            }
                                        });

                                        layer.closeAll();
                                    }
                                });
                            }else{
                                alert('错误');

                            }
                        }
                    })
               });

       }


    });
</script>
<script>
    //控制高度
    autodivheight();
    function autodivheight(){
        var winHeight=0;
        if (window.innerHeight)
            winHeight = window.innerHeight;
        else if ((document.body) && (document.body.clientHeight))
            winHeight = document.body.clientHeight;
        if (document.documentElement && document.documentElement.clientHeight)
            winHeight = document.documentElement.clientHeight;
        winWidth = document.documentElement.clientWidth;
        document.getElementById("client").style.height= winHeight - 104 +"px";
        document.getElementById("client").style.width= winWidth  +"px";

    }
    window.onresize=autodivheight;

</script>




