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
    <link rel="stylesheet" type="text/css" href="../../lib/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../../lib/pagination/style/pagination.css"/>
    <script type="text/javascript" src="../../js/news/jquery-1.9.1.js"></script>
    <script src="../../js/base/base.js"></script>
    <script src="../../js/workflow/work/workform.js"></script>
    <script src="../../lib/laydate.js"></script>
    <script src="../../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../../lib/layer/layer.js"></script>
</head>

<style type="text/css">
    .cont{
        position: relative;
    }
    #tab_c{
        width:22%;
        height:100%;
        position: absolute;
        right: -316px;
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
        height:100%;
    }
    .cont_cone li{
        width: 85%;
        height:50px;
        margin:10px auto;
        border: 1px solid #cccccc;
        border-radius: 3px;

    }
 /*   #tab_ctwo{
        display:none;
    }*/
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
</style>

<body>
<div class="body">
    <div class="head">
        <div id="title" class="abs_left">
            <h1 class="num">NO.767 督查督办</h1>
            <h1 class="step">主办（第一步 : 督查内容填写 2017-5-24 13:58）</h1>
            <select>
                <option>普通</option>
                <option>紧急</option>
            </select>
        </div>

        <div id="tab_t" class="abs_right">
            <ul>
                <li class="fujian">附件</li>
                <li class="huiqian">会签</li>
                <li class="liucheng">流程</li>
                <li class="guanlian">关联</li>
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="cont" id="client">
            <div class="cont_form">

            </div>
            <div id="tab_c">
                <div class="tab_one">
                    <div class="one_all">
                        <ul class="cont_cone">
                            <li style="height:21px;position:relative;border:none;"><img class="fujian_logo" src="../../img/workflow/work/add_work/black.png"><h1 class="fujian_h1">附件</h1></li><div class="position"><img src="../../img/workflow/work/add_work/back.png"></div>
                            <li><div class="item_logo"></div><div class="item_word"><h1>Saas事业部5月...任务工单.xlsx</h1><h2>10.8k</h2></div></li>
                            <li><div class="item_logo"></div><div class="item_word"><h1>Saas事业部5月...任务工单.xlsx</h1><h2>10.8k</h2></div></li>
                            <li><div class="item_logo"></div><div class="item_word"><h1>Saas事业部5月...任务工单.xlsx</h1><h2>10.8k</h2></div></li>
                        </ul>
                        <button class="add_fujian">添加附件</button>
                    </div>
                    <div class="two_all">
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
                    <li class="left_li"><img class="left_img" src="../../img/workflow/work/add_work/lan.png"><h1 class="left_h1">附件</h1></li>
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
    </div>

</div>
</body>
</html>
<script>
    $(function(){
        var formid = $.getQueryString("formId");
        workForm.init({
                formhtmlurl:'../../form/formType',
                formid:formid,
                target:$('.cont_form')},
            function(data){
                console.log(data);
            });
        //右侧tab切换
       /* var currentIndex=0;
        var index;
        $('.abs_right').on('click','li',function(){
            index=$(this).index();
            console.log(index);
            if(currentIndex!=index){
                currentIndex=index;
                $("#tab_t li").removeClass("check");
                $(this).addClass('check');
                //内容
                var contents=$("#tab_c").find("ul");

                $(contents[index]).show();
                $(contents[index]).siblings().hide();
            }

        });*/
       //第一个
       $('.fujian').on('click',function(){

           $(this).siblings().removeClass("check");
           $(this).addClass('check');
            $('#tab_c').animate({right:'0px'},"slow");
            $('#tab_ctwo').hide();
            $('.tab_one').show();
            $('.one_all').show();
       })
        //第二个
        $('.huiqian').on('click',function(){
            $(this).siblings().removeClass("check");
            $(this).addClass('check');
            $('.one_all').hide();
            $('#tab_ctwo').hide();
            $('.tab_one').show();
            $('.cont_ctwo').show();
        })
        //第三个
        $('.liucheng').on('click',function(){
            $(this).siblings().removeClass("check");
            $(this).addClass('check');
            $('.cont_cthr').siblings().hide();
            $('.tab_one').hide();
            $('#tab_ctwo').show();
            $('.cont_cthr').show();
        })
        //第四个
        $('.guanlian').on('click',function(){
            $(this).siblings().removeClass("check");
            $(this).addClass('check');
            $('.cont_cfour').siblings().hide();
            $('.tab_one').hide();
            $('#tab_ctwo').show();
            $('.cont_cfour').show();
        })

        //转交下一步
        $('.zhuanjiao').on('click',function(){
            /*alert('111');*/
            $(this).css({
                'color':'#fff',
                'background':'#4889f0'
            });

            layer.open({
                type: 1,
                /* skin: 'layui-layer-rim', //加上边框 */
                offset: '80px',
                area: ['600px', '400px'], //宽高
                title:$(this).find('h1').text(),
                closeBtn: 0,
                content: '内容',

                btn:['确认', '取消'],
                yes: function(index, layero){
                    //按钮【按钮三】的回调
                    /*alert($('.name_biaodan').val());*/
                    layer.closeAll();
                }
            });

        })
    });
</script>
<script>
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




