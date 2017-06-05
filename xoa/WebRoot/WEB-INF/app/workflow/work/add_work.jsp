<%--
  Created by IntelliJ IDEA.
  User: gsubo
  Date: 2017/5/22
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<head>
    <title>新建工作</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8 ? MYOA_CHARSET : htmlspecialchars($HTML_PAGE_CHARSET))?>" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/workflow/work/style.css" />
    <!--[if lte IE 8]>
<!--    <script type="text/javascript" src="/static/js/ccorrect_btn.js"></script>-->
<%--    <![endif]-->--%>

    <script type="text/javascript" >
        var MYOA_JS_SERVER = "";
        var MYOA_STATIC_SERVER = "";
    </script>
</head>
<link rel="stylesheet" type="text/css" href="../css/workflow/work/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/workflow/work/newwork.css" />
<link rel="stylesheet" type="text/css" href="../css/workflow/work/new.css">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/main_js/index.js"></script>
<script src="js/base/base.js"></script>
<!--<script src="/static/js/bootstrap/js/bootstrap.min.js"></script>-->
<script>
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
#flow_sort_nav > a:hover {
    text-decoration: none;
    color: #589Fff;
    font-weight: bold;
}
</style>
<head>
    <title>新建工作</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8 ? MYOA_CHARSET : htmlspecialchars($HTML_PAGE_CHARSET))?>" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../../css/workflow/work/style.css" />
    <script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script src="../../../js/base/base.js"></script>
</head>
<link rel="stylesheet" type="text/css" href="../../css/main/theme1/index.css"/>
<link rel="stylesheet" type="text/css" href="../../css/workflow/work/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../../css/workflow/work/newwork.css" />
<link rel="stylesheet" type="text/css" href="../../css/workflow/work/new.css">

<script type="text/javascript" src="../js/main_js/index.js"></script>

<script src="/static/js/bootstrap/js/bootstrap.min.js"></script>

<style type="text/css">

    .container-fluid{
        width: 100%;
        height:100%;
    }
    .cont_left{
        background: none !important;
        border-right: 1px solid #999 !important;
    }
    .all_ul{
        width: 100% !important;
        margin-left: 0% !important;
    }
    .tab_c{
        margin-left: 0% !important;
    }
    .one_all{
        height: 40px !important;
        width: 100% !important;
        border-left: none !important;
        border-right: none !important;
        border-radius: none !important;
    }
    .one_name{
        line-height: 40px !important;
        text-align: center;
    }
    .down_jiao{
        margin-left: 16%;
    }
    .two_all h1{
        margin-left: 27%;
    }

    .cont_left{
        width:15%;
    }
    .cont_rig{
        width:84%;
    }
    .rig_all{
        width:95%;
        height:100%;
        margin:auto;
    }
    .rig_cont ul li{
        width: 99%;
        height: 80px;
        border: 1px solid #cccccc;
        border-radius: 2px;
        background: #f9fbff;
        margin-top: 10px;
    }
    .rig_cont{
        overflow-y: scroll;
        height: 98%;
    }
    .rig_title img,.rig_title h1{
        float:left;
        margin-top:5px;
    }
    .rig_title img{
        margin-top:10px;
    }
    .rig_title h1{
        font-size: 15pt;
        font-weight: normal;
        font-family: '微软雅黑';
        margin-left: 12px;
        line-height: 35px;
    }
    .rig_left,.rig_mid,.rig_rig{
        float: left;
        height: 100%;
    }
    .rig_left,.rig_rig{
       width:30%;
    }
    .rig_mid{
        width:40%;
    }
    .liucheng,.liucheng1,.liucheng2{
        width:33%;
        height:100%;
        float: left;
    }
    .liucheng img,.liucheng h1,.liucheng1 img,.liucheng1 h1,.liucheng2 img,.liucheng2 h1{
        float:left;
    }
    .rig_rig div{
        width: 50%;
        float: left;
        margin-top: 14px;
    }
    .xinjian_img{
        margin-left: 39%;
    }
    .xinjian_h1{
        width: 146px;
        height: 20px;
        text-align: center;
    }
    .rig_left h1{
        font-size: 13pt;
        font-weight: bold;
        margin-left: 12px;
        margin-top: 17px;
    }
    .rig_left h2{
        margin-left: 12px;
        color: #b7b8b9;
        margin-top: 5px;
    }
    .liucheng h1,.liucheng1 h1,.liucheng2 h1{
        line-height: 80px;
        margin-left: 5px;
    }
    .liucheng img,.liucheng1 img,.liucheng2 img{
        margin-top: 31px;
    }
    .new_work{
        font-size: 16pt;
        font-weight: bold;
        margin-top: 9px;
    }
    .new-search{
        margin-top:8px !important;
    }
    .one_all{
        background: #f5f7f8 !important;
    }
    .tab_cone li .one_all:hover{
        background: #add2f8 !important;
    }
    .tab_cone{
        width: 104% !important;
        height:99% !important;
    }
    .er_img {
        margin-top: 5% !important;
        margin-left: 4% !important;
    }
    #searchbtn,.rig_mid h1,.rig_rig h1{
        cursor: pointer;
    }

    /*定义滚动条宽高及背景，宽高分别对应横竖滚动条的尺寸*/
    .rig_cont::-webkit-scrollbar{
        width: 0px;
        height: 16px;
        background-color: #f5f5f5;
    }
    /*定义滚动条的轨道，内阴影及圆角*/
    .rig_cont::-webkit-scrollbar-track{
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        border-radius: 10px;
        background-color: #f5f5f5;
    }
    /*定义滑块，内阴影及圆角*/
    .rig_cont::-webkit-scrollbar-thumb{
        /*width: 10px;*/
        height: 20px;
        border-radius: 10px;
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        background-color: #555;
    }

    #sort_cont li:hover{
        background: #e8f4fc;
    }
    .rig_mid h1:hover{
        color:#2b7fe0;
    }
    .quick h1:hover{
        color:#2b7fe0;
    }
    .xiangdao h1:hover{
        color:#2b7fe0;
    }
    #form_select{
        height: 28.4px !important;
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
    <div class="row-fluid title-row" style="background-color:#f8f8f8;z-index:99;border-bottom:1px solid #999;height:45px;">
        <div id="title" class="date">
            <img class="title_img" src="../../../img/workflow/work/add_work/new_work.png"><h3 class="new_work" style="margin-bottom:0px;">新建工作 </h3>
        </div>

        <div class="abs-right" style="position:fixed;">
            <div class="search_area form-search">
                <div class="input-append new-search">
                    <input type="text" class="search-query" id="form_select" name="form_select" placeholder="请输入流程名称">
                    <button type="submit" class="btn btn-primary" id="searchbtn" onclick="form_select()">查询</button>
                    <div class="btn-group" style="margin-left:8px;display: none;">
                        <a class="btn" style="zoom:1;font-weight:normal;" id="w_list_view" href="javascript:;" onclick=""><span>任务视图</span></a>
                    </div>

                    <div class="btn-group" style="margin-left:-1px;display: none;" >
                        <button class="btn" style="font-weight:normal;" id="w_task_view" onclick="to_old_new_work()" ><span>列表视图</span></button>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="cont" id="client">
        <div class="cont_left">
            <ul class="all_ul">
                <div class="tab_c list">

                    <ul class="tab_cone a yiji" >

                    </ul>
                </div>
            </ul>

        </div>
        <div class="cont_rig">
            <div class="rig_all">
                <div class="rig_title">
                    <img src="../../img/workflow/work/add_work/all_works.png" alt="">
                    <h1 class="title_name">常用工作</h1>
                </div>
                <div class="rig_cont">
                    <ul id="sort_cont">

                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
<script>
    $(function () {


        function init(){
            $.ajax({
                url:'../../workflow/flowclassify/flowByAuth',
                type:'get',
                dataType:'json',
                success:function(obj){
                    var data=obj.datas;
                    var str='';
                    /*console.log(data);
                    console.log(data.length);*/
                    for(var i=0;i<data.length;i++){
                        var er='';
                        for(var j=0;j<data[i].childs.length;j++){

                            if(data[i].childs[j].childs.length>0){
                                var three='';
                                for(var k=0;k<data[i].childs[j].childs.length;k++){
                                    three +='<li style="margin-left:18px;" class="three checked" menu_tid='+data[i].childs[j].childs[k].sortId+' url='+data[i].childs[j].childs[k].url+' title="'+data[i].childs[j].childs[k].sortName+'"><div class=""><img class="sanji_circle" src=""><h1 style="margin-left:28%;">'+data[i].childs[j].childs[k].sortName+'</h1></div></li>' ;
                                }
                                er += '<li class="two"  ><div url='+data[i].childs[j].url+' menu_tid='+data[i].childs[j].sortId+'  class="two_all click_erji  checked"  title="'+data[i].childs[j].sortName+'"><img class="erji_circle" src=""><h1>'+data[i].childs[j].sortName+'</h1><img class="er_img" src="../../img/workflow/work/add_work/right.png"></div><ul class="sanji" style="display:none;">'+three+'</ul></li>';

                            }else{

                                er += '<li class="two" ><div url='+data[i].childs[j].url+' menu_tid='+data[i].childs[j].sortId+' class="two_all  checked" title="'+data[i].childs[j].sortName+'"><img class="erji_circle" src=""><h1 class="erji_h1">'+data[i].childs[j].sortName+'</h1></div></li>';

                            }
                        }
                        if(data[i].childs==''){
                            str+='<li class="one person" id="administ"><div class="one_all checked" title="'+data[i].sortName+'" menu_tid='+data[i].sortId+'><img class="one_logo" src=""><h1 class="one_name" id="administ">'+data[i].sortName+'</h1></div><div class="two_menu"><ul class="erji b"  style="width:100%;display:none;"><li class="two"><div class="two_all">'+er+'</div></li></ul></div></li>';
                        }else{
                            str+='<li class="one person" id="administ"><div class="one_all checked" title="'+data[i].sortName+'" menu_tid='+data[i].sortId+'><img class="one_logo" src=""><h1 class="one_name" id="administ">'+data[i].sortName+'</h1><img class="down_jiao" src="../../img/workflow/work/add_work/right.png"></div><div class="two_menu"><ul class="erji b"  style="width:100%;display:none;"><li class="two"><div class="two_all">'+er+'</div></li></ul></div></li>';
                        }

                    }
                    var stt='<li class="one person" id="administ"><div class="one_all checked"><h1 class="one_name" id="administ">常用工作</h1></div></li><li class="one person" id="administ"><div class="one_all checked"><h1 class="one_name" id="administ">全部工作</h1></div></li>';
                    $(".tab_cone").html(stt+str);



                    //鼠标移动到一级菜单变样式，移出变回
                  $('.one_all').on('mouseover',function () {
                      $(this).css({

                          'color':'#006bb8',

                         'cursor':'pointer'
                      });
                  });
                  //移出
                  $('.one_all').on('mouseout',function () {
                     $(this).css({

                       'color':'#000'
                      });
                   });

                    //点击一级菜单。显示二级

                    $('.one_all').on('click',function () {
                        var top_one=$(this).parent().next('li').find('.one_all');
                        if ($(this).siblings().find('.erji').css('display')=='none') {
                            $(this).find('.down_jiao').attr('src','../../img/workflow/work/add_work/down.png');
                            $(this).siblings().find('.erji').show();
                            $(this).siblings().find('.erji').css('background','#e8f4fc');

                            /*top_one.css('border-top','1px solid #999');*/
                        }else{
                          $(this).find('.down_jiao').attr('src','../../img/workflow/work/add_work/right.png');
                            $(this).siblings().find('.erji').hide();
                           /* top_one.css('border-top','none');*/
                        }

                    });

                    //点击二级，出现三级
                    $('.click_erji').on('click',function () {
                        var san= $(this).siblings().html();
                        if ($(this).siblings('.sanji').css('display')=='none') {
                            $(this).find('.er_img').attr('src','../../img/workflow/work/add_work/down.png');
                            $(this).siblings('.sanji').show();

                        }else{
                           $(this).find('.er_img').attr('src','../../img/workflow/work/add_work/right.png');
                            $(this).siblings('.sanji').hide();
                        }

                    });


                    //二级菜单切换
                    $('.two_menu li').on('mouseover','.two_all',function(){

                        $(this).find('h1').css({
                            'color':'#2f8ae3',

                            'cursor':'pointer'
                        });
                        $(this).css('background','#ccebff');
                      /*  $(this).find('.erji_circle').attr('src','img/main_img/lan.png');*/

                    });
                    $('.two_menu li').on('mouseout','.two_all',function(){

                        $('.two_menu li .two_all').removeClass('xuan');
                        $(this).find('h1').css({
                            'color':'#000',
                           /* 'background':'#e8f4fc',*/
                        });
                        $(this).css('background','#e8f4fc');
                     /*   $(this).find('.erji_circle').attr('src','img/main_img/hei.png');*/
                    });


                    //点击二级菜单
                    $('.two_menu li').on('click','.two_all',function(){
                        var url=$(this).attr('url');
                        var menu_tid=$(this).parent().attr('menu_tid');
                        //console.log(url);
                        /*if(menu[url.replace('/','_')]){
                            url = menu[url.replace('/','_')];
                        }else{
                            url='http://192.168.0.17:81/gotophp.php?uid=admin&url='+url;
                        }*/

                        //判断标题id与iframeid是否相同
                        //console.log(url);
                        console.log($('#f_'+menu_tid).length>0);
                        if($('#f_'+menu_tid).length>0){
                            //页面一打开，切换显示
                            $('.all_content .iItem').hide();
                            $('#f_'+menu_tid).show();

                            $('#t_'+menu_tid).css({
                        /*        'background':'url(img/main_img/title_yes.png) 0px 4px no-repeat',*/
                                'color':'#2a588c',
                                'position':'relative',
                                'z-index':99999
                            })
                            $('#t_'+menu_tid).siblings().css({
                              /*  'background':'url(img/main_img/title_no.png) 0px 4px no-repeat',*/
                                'color':'#fff',
                                'position':'relative',
                                'z-index':999
                            })
                        }else{
                            if($(this).siblings('.sanji').length>0){
                            }else{
                                //页面不存在，新增 title和iframe

                                var titlestr = '<li class="choose" index="0;" id="t_'+menu_tid+'" title="'+$(this).find('h1').html()+'"><h1>'+$(this).find('h1').html()+'</h1><div class="img" style="display:none;"><img class="close"  src="img/main_img/icon.png"></div></li>';

                                var iframestr = '<div id="f_'+menu_tid+'" class="iItem" ><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';

                                $('.main_title ul').append(titlestr);

                                $('#t_'+menu_tid).siblings().attr('style','background: url(img/main_img/title_no.png) 0px 4px no-repeat;');
                                $('#t_'+menu_tid).siblings().css('color','#fff');
                                /* console.log($('#t_'+menu_tid).siblings()); */
                                $('.all_content').append(iframestr);
                                $('.all_content .iItem').hide();
                                $('#f_'+menu_tid).show();

                            }

                        }


                    });


                    //点击三级菜单，跳转页面。
                    $('.sanji').on('click','li',function(){
                        var url=$(this).attr('url');
                        console.log(url);
                        var menu_tid=$(this).attr('menu_tid');
             /*           console.log(url.split);
                        console.log(menu[url.split('/').join('_')]);
                        if(menu[url.split('/').join('_')]){
                            url = menu[url.split('/').join('_')];
                        }else{
                            url='http://192.168.0.17:81/gotophp.php?uid=admin&url='+url;
                        }*/

                        console.log(menu_tid);
                        if($('#f_'+menu_tid).length>0){
                            //页面一打开，切换显示
                            $('.all_content .iItem').hide();
                            $('#f_'+menu_tid).show();

                            $('#t_'+menu_tid).siblings().css({
                              /*  'background':'url(img/main_img/title_no.png) 0px 4px no-repeat',*/
                                'color':'#fff',
                                'position':'relative',
                                'z-index':999
                            });


                            $('#t_'+menu_tid).css({
                               /* 'background':'url(img/main_img/title_yes.png) 0px 4px no-repeat',*/
                                'color':'#2a588c',
                                'position':'relative',
                                'z-index':99999
                            })


                        }else{

                            //页面不存在，新增 title和iframe
                            var titlestrs = '<li class="choose " index="0;" id="t_'+menu_tid+'" title="'+$(this).find('h1').html()+'"><h1>'+$(this).find('h1').html()+'</h1><div class="img" style="display:none;"><img class="close" src="img/main_img/icon.png"></div></li>';

                            var iframestr = '<div id="f_'+menu_tid+'" class="iItem"><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';

                            $('.main_title ul').append(titlestrs);

                            $('#t_'+menu_tid).siblings().attr('style','background: url(img/main_img/title_no.png) 0px 4px no-repeat;');
                            $('#t_'+menu_tid).siblings().css('color','#fff');
                            $('.all_content').append(iframestr);
                            $('.all_content .iItem').hide();
                            $('#f_'+menu_tid).show();
                        }

                    });


                    //三级菜单切换
                    //三级菜单移入变样式
                    $('.sanji').on('mouseover','li',function(){
                        $(this).css({
                            /* 'background':'url(img/main_img/first_yes.png) 0px 1.4px no-repeat', */
                            'color':'#006bb8',
                            'cursor':'pointer'
                        });
                        /*$(this).find('img').attr('src','img/main_img/lan.png');*/

                    });
                    //三级菜单移出
                    $('.sanji').on('mouseout','li',function(){

                        /* $('.sanji li').removeClass('xuan'); */
                        $(this).css({
                            /* 'background':'url(img/main_img/first_no.png) 0px 0px no-repeat', */
                            'color':'#000'
                        });
                       /* $(this).find('img').attr('src','img/main_img/hei.png');*/
                    });


                    //success的后括号
                }
            });//ajax传入应用数据结束括号

        }//init方法结束


        init();//调用init()方法

        //右侧内容接口对接
        $('.tab_cone').on('click','.checked',function(){
            var sortId=$(this).attr('menu_tid');

            $('.title_name').html($(this).find('h1').text());

        /*  alert(sortId);*/
            $.ajax({
                url:'../../flow/flowAuthOrSearch',
                type:'get',
                dataType:'json',
                data:{
                    sortId:sortId
                },
                success:function(obj){
                    var data=obj.obj;
                    var str='';
                    console.log(data);
                    renderData(data);

                }
            })
        })

        $.ajax({
            url:'../../flow/flowAuthOrSearch',
            type:'get',
            dataType:'json',

            success:function(obj){
                var data=obj.obj;
                var str='';
                console.log(data);
                renderData(data);

            }
        })

        function renderData(data) {
            var str='';
            for(var i=0;i<data.length;i++){
                if(data[i].runName){
                    str+='<li class="sort_new" tid='+data[i].flowId+' sortId='+data[i].flowSort+'><div class="rig_left">'+
                        '<h1>'+data[i].flowName+'</h1><h2 class="runName">'+data[i].runName+'</h2></div>'+
                        '<div class="rig_mid">'+
                        '<div class="liucheng"><img src="../../img/workflow/work/add_work/sheji.png" alt=""><h1>流程设计图</h1></div>'+
                        '<div class="liucheng1"><img src="../../img/workflow/work/add_work/liucheng.png" alt=""><h1>流程表单</h1></div>'+
                        '<div class="liucheng2"><img src="../../img/workflow/work/add_work/speak.png" alt=""><h1>流程说明</h1></div></div>'+
                        '<div class="rig_rig"><div class="quick" formId='+data[i].formId+'><img class="xinjian_img"  src="../../img/workflow/work/add_work/xinjian.png" alt=""><h1 class="xinjian_h1" id="quick_new" >快速新建</h1></div>'+
                        '<div class="xiangdao"><img src="../../img/workflow/work/add_work/xiangdao.png" style="margin-left: 6%;" alt=""><h1>新建向导</h1></div></div></li>'
                }else{
                    str+='<li class="sort_new" tid='+data[i].flowId+' sortId='+data[i].flowSort+'><div class="rig_left">'+
                        '<h1>'+data[i].flowName+'</h1><h2 class="runName">未添加</h2></div>'+
                        '<div class="rig_mid">'+
                        '<div class="liucheng"><img src="../../img/workflow/work/add_work/sheji.png" alt=""><h1>流程设计图</h1></div>'+
                        '<div class="liucheng1"><img src="../../img/workflow/work/add_work/liucheng.png" alt=""><h1>流程表单</h1></div>'+
                        '<div class="liucheng2"><img src="../../img/workflow/work/add_work/speak.png" alt=""><h1>流程说明</h1></div></div>'+
                        '<div class="rig_rig"><div class="quick" formId='+data[i].formId+'><img class="xinjian_img"  src="../../img/workflow/work/add_work/xinjian.png" alt=""><h1 class="xinjian_h1"  id="quick_new" >快速新建</h1></div>'+
                        '<div class="xiangdao"><img src="../../img/workflow/work/add_work/xiangdao.png" style="margin-left: 6%;" alt=""><h1>新建向导</h1></div></div></li>'
                }
            }
            $('#sort_cont').html(str);
        }
        //查询按钮接口
        $('#searchbtn').on('click',function(){
            $('.title_name').html('全部工作');
            var text=$(this).siblings('#form_select').val();
            alert(text);
            $.ajax({
                url:'../../flow/flowAuthOrSearch',
                type:'get',
                dataType:'json',
                data:{
                    searchValue:text
                },
                success:function(obj){
                    if(obj.flag==true){
                        var data=obj.obj;
                        var str='';
                        console.log(data);
                        renderData(data);
                    }
                }
            })
        })

        //点击出现快速新建页面
        $('#sort_cont').on('click','.quick',function(){
           var formId= $(this).attr('formId');
      /*      alert(formId);*/
            user_id='quick';
            $.popWindow("workform?flowId="+formId+'&flowStep=1','快速新建页面','0','0','1500px','800px');
          /*  var form_datas={

            }
            $.ajax({
                type: "post",
                url: "../../workflow/work/workfastAdd",
                dataType: 'JSON',
                data: form_datas,
                success: function(obj){

                }
            })*/
        });

    })
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
        document.getElementById("client").style.height= winHeight - 50 +"px";
        document.getElementById("client").style.width= winWidth  +"px";

    }
    window.onresize=autodivheight;
</script>
