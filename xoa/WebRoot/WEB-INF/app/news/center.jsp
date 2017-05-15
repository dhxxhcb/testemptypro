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
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../lib/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../lib/pagination/style/pagination.css"/>
    <link rel="stylesheet" type="text/css" href="../css/base.css"/>
    <link rel="stylesheet" type="text/css" href="../css/news/center.css"/>
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script src="../js/news/page.js"></script>
    <script src="../lib/laydate.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/layer/layer.js"></script>

</head>
<body>
<div class="bx">
    <!--head开始-->
    <div class="head w clearfix">
        <ul class="index_head">
           <li data_id="0"><span class="one headli1_1"><fmt:message
                    code="news.title.unread"/></span><img class="headli1_2" src="../img/02.png" alt=""/>
            </li>
            
            <li data_id=""><span class="headli2_1"><fmt:message
                    code="news.title.new"/></span><img src="../img/02.png" alt="" class="headli2_2"/>
            </li>
                    
           <li data_id="1"><span class="headli3"><fmt:message code="news.title.query"/></span></li> 
           
        </ul>
    </div>
    <!--head通栏结束-->

    <!--navigation开始-->
    <div class="step1">
        <div class="navigation  clearfix">
            <div class="left">

                <img src="../img/la2.png"> 
                
                <div class="news">
                    <fmt:message code="news.title.new"/>
                </div>                
               <select name="TYPE" class="button1 nav_type" id="select">
                    <option value="0" selected="">
                        <fmt:message code="news.th.type"/>
                    </option>
                    <option value="01">
                        <fmt:message code="news.th.company"/>
                    </option>
                    <option value="02">
                        <fmt:message code="news.th.media"/>
                    </option>
                    <option value="03">
                        <fmt:message code="news.th.industry"/>
                    </option>
                    <option value="04">
                        <fmt:message code="news.th.partner"/>
                    </option>
                    <option value="05">
                        <fmt:message code="news.th.client"/>
                    </option>
                    <option value="">
                        <fmt:message code="news.th.none"/>
                    </option>
                </select>
                <div>
                    <div class="nav_date">
                        <fmt:message code="global.lang.date"/>
                        :
                    </div>
                    <input class="button1" id="sendTime">
                </div>
                <!-- 查询按钮 -->
                <div id="cx" class="submit">
                    <fmt:message code="global.lang.query"/>
                </div>
            </div>
            
            <div class="right">
                <!-- 分页按钮-->
                <div class="M-box3">
                </div>

            </div>

        </div>

        <!--navigation结束-->

        <!--content部分开始-->
        <div>
            <div>
                <table  id="tr_td">
                    <thead>
                    <tr>
                        <td class="th">
                            <fmt:message code="notice.th.title"/>
                        </td>
                        <td class="th">
                            <fmt:message code="news.th.type"/>
                        </td>
                        <!-- <td class="th" style="position: relative"><fmt:message code="notice.title.Releasedate" />
                               <img style="position: absolute;margin-left:9px;cursor: pointer;" src="../img/05.png" alt=""/>
                             <img style="position: absolute;margin-top:13px;margin-left:9px;cursor: pointer;" src="../img/06.png " alt=""/> 
                        </td> -->
                        <td class="th">
                            <fmt:message code="notice.title.Releasedate"/>
                        </td>

                        <td class="th">
                            <fmt:message code="news.th.clicks"/>
                        </td>
                        <td class="th">
                            <fmt:message code="news.th.comment"/>
                        </td>
                        <!-- <td class="th">发布部门</td> -->
                    </tr>
                    </thead>
                    <tbody id="j_tb" calss="tr_td">
                    
                    </tbody>
                </table>
            </div>


        </div>
        <!--content部分结束-->

    </div>
</div>
<!-- 新闻查询 -->
<!-- <div class="center" style="width:100%;margin-top: 50px;display: none;"> -->
<!-- 新闻nav部分 -->

<div class="center" id="qt">
	 <div class="navigation  clearfix">
            <div class="left">
                <img src="../img/la2.png">                 
                <div class="news">
                    	新闻查询
                </div>                              
	</div> 
	
    <div class="login">
        <div class="header">
            <fmt:message code="global.lang.inputquerycondition"/>
        </div>
        <form id="empty">
        <div class="middle">
            <div class="le publisher">
                <div class="color" style="width:105px;">
                    <fmt:message code="notice.th.publisher"/> ：
                </div>
                <input id="input_text1" type="text"/>
                <div style="margin-right:23px; color:#207BD6">
                     <a href="javascript:;" id="query_adduser"><fmt:message code="global.lang.add"/></a>
                </div>
                <div>
                    <a href="javascript:;"  onclick="clearData()"><fmt:message code="global.lang.empty"/> </a>
                </div>
            </div>
            <div class="le subject">
                <div class="color" style="width:105px;">
                    <fmt:message code="notice.th.title"/> ：</div>
                <input id="subject_query " class="input_text2" type="text"/>
            </div>
            <div class="le date">
                <div class="color" style="width:105px;"><fmt:message code="notice.title.Releasedate"/> ：</div>  
                <input id="beginTime"class="input_text3" type="text"/>
                <div class="color">
                    <fmt:message code="global.lang.to"/>
                </div>
                
               <div><input id="endTime" class="input_text4" type="text"/></div> 
            </div>
            <div class="le ce1">
                <div class="color" style="width:105px;"><fmt:message code="news.title.new"/> ：</div>
            <div> 
                 <select name="TYPE"  class="button1 input_text5" id="select_query">
                        <option value="0" selected="">
                            <fmt:message code="news.th.type"/>
                        </option>
                        <option value="01">
                            <fmt:message code="news.th.company"/>
                        </option>
                        <option value="02">
                            <fmt:message code="news.th.media"/>
                        </option>
                        <option value="03">
                            <fmt:message code="news.th.industry"/>
                        </option>
                        <option value="04">
                            <fmt:message code="news.th.partner"/>
                        </option>
                        <option value="05">
                            <fmt:message code="news.th.client"/>
                        </option>
                        <option value="">
                            <fmt:message code="news.th.none"/>
                        </option>
                    </select>
                </div>

            </div>
            <div class="le ce2">
                <div class="color" style="width:105px;"><fmt:message code="notice.th.content"/>:</div>          
              	<input id="content" class="input_text6" type="text"/>
            </div>
        </div>
         </form>
        <div class="icons">
          <!--   <img id="btn_query" style="margin-right:30px; cursor: pointer;" src="../img/3query.png" alt=""/>
            <img style="margin-right:30px; cursor: pointer;" src="../img/4query.png" alt=""/>
            <img style=" cursor: pointer;" src="../img/5query.png" alt=""/> -->
            <div id="btn_query">查询</div>
            <div class="export">导出</div>
            <div  class="filling" onclick="Refillings()">重填</div>
        </div>
    </div>
   
</div>
<!--footer部分结束-->
</div>

<script>
user_id='input_text1';//选人控件       	
    $(function () {    	   
        var data = {
            read: $('.index_head .one').parent().attr('data_id'),
            typeId: $('#select').val() == 0 ? '' : $('#select').val(),
            nTime: $('#sendTime').val(),
            page: 1,
            pageSize: 5,
            useFlag: true,
            newsTime: '',
            lastEditTime: '',
            content: '',
            subject: ''

        };
        initPageList(function (pageCount) {
            console.log(pageCount);
            initPagination(pageCount, data.pageSize);
        });


        $(".index_head li").click(function () {

            $(this).find('span').addClass('one').parent().siblings('').find('span').removeClass('one');  // 删除其他兄弟元素的样式
            $(".news").html($(this).find('span').text());
            data.read = $(this).attr('data_id');
            data.typeId = $('#select').val() == 0 ? '' : $('#select').val();
            data.nTime = $('#sendTime').val();
            console.log(data);
            if (data.read == '' || data.read == 0) {
                $('.step1').show();
                $('.center').hide();
                initPageList(function (pageCount) {
                    initPagination(pageCount, data.pageSize);
                });
            } else if (data.read == 1) {
                $('.step1').hide();
                $('.center').show('');
                $('#subject').val('');
                $('#beginTime').val('');
                $('#endTime').val('');
                $('#select').val() == 0 ? '' : $('#select').val();
                $('#content').val('');
            }
        });
        function initPageList(cb) {
            var layerIndex = layer.load(0, {shade: false}); /* 0代表加载的风格，支持0-2 */
            $.ajax({
                type: "get",
                url: "<%=basePath%>news/newsManage",
                dataType: 'JSON',
                data: data,
                success: function (obj) {
                    layer.closeAll();
                    if (obj.obj.length == 0) {
                        if ($('.index_head .one').parent().attr('data_id') == '0') {
                            layer.msg('<fmt:message code="notice.alert.nodatealert" />', {icon: 6});
                            var turnindex = setInterval(function () {
                                layer.closeAll();
                                $(".index_head li").eq(1).click();
                                clearInterval(turnindex);
                            }, 2 * 1000);
                        } else {
                            layer.msg('没有更多数据！', {icon: 6});
                        };
                    } else {
                        var str = "";
                        for (var i = 0; i < obj.obj.length; i++) {
                            str += "<tr><td><a href='#' newsId=" + obj.obj[i].newsId + " class='windowOpen'>" + obj.obj[i].subject + "</ a></td>" +
                                    "<td><a href='#' style='color:#2B7FE0' newsId=" + obj.obj[i].newsId + " class='windowOpen'>" + obj.obj[i].typeName + "</ a></td>" +
                                    "<td><a href='#' newsId=" + obj.obj[i].newsId + " class='windowOpen'>" + obj.obj[i].newsDateTime + "</ a></td>" +
                                    "<td><a href='#' newsId=" + obj.obj[i].newsId + " class='windowOpen'>" + obj.obj[i].clickCount + "</ a></td>" +
                                    "<td><a href='#' newsId=" + obj.obj[i].newsTime + " class='windowOpen'>" + '0' + "</ a></td>";
                        }
                        var loadindex = setInterval(function () {
                            layer.closeAll();
                            $("#j_tb").html(str);
                            clearInterval(loadindex);
                        }, 1000);

                        if (cb) {
                            //alert(obj.totleNum);
                            cb(obj.totleNum);
                        }
                    }
                }
            })
        };

        function initPagination(totalData, pageSize) {
            $('.M-box3').pagination({
                totalData: totalData,  
                showData: pageSize,
                jump: true,
                coping: true,
                homePage: '<fmt:message code="global.page.first" />',
                endPage: '<fmt:message code="global.page.last" />',
                prevContent: '<fmt:message code="global.page.pre" />',
                nextContent: '<fmt:message code="global.page.next" />',
                jumpBtn: '<fmt:message code="global.page.jump" />',
                callback: function (index) {
                    data.page = index.getCurrent();
                    console.log(index.getCurrent());
                    initPageList();
                }
            });
        }

        /* 新闻详情页 */
        $("#j_tb").on('click', '.windowOpen', function () {
            var nid = $(this).attr('newsId');
            $.popWindow('detail?newsId=' + nid, '1111');
        });
        $('.submit').click(function () {
            data.read = $('.index_head .one').parent().attr('data_id');
            data.typeId = $('#select').val();
            data.nTime = $('#sendTime').val();
            //console.log(read,typeId,nTime);
            initPageList();
        });
        //时间控件调用
        $('#btn_query').click(function () {

            data.subject = $('#subject_query').val();
            data.newsTime = $('#beginTime').val();
            data.lastEditTime = $('#endTime').val();
            data.typeId = $('#select_query').val() == 0 ? '' : $('#select_query').val();
            data.content = $('#content').val();
            initPageList();
            $('.step1').show();
            $('.center').hide();
        });
    });
 
    laydate({
        elem: '#sendTime', //目标元素。
        format: 'YYYY-MM-DD', //日期格式
        istime: true, //显示时、分、秒
    });
  //时间控件调用
    var start = {
        elem: '#beginTime',
        format: 'YYYY-MM-DD',
        /* min: laydate.now(), //设定最小日期为当前日期*/
        /* max: '2099-06-16 23:59:59', //最大日期*/
        istime: true,
        istoday: false,
        choose: function (datas) {
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas; //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#endTime',
        format: 'YYYY-MM-DD',
        /*min: laydate.now(),*/
        /*max: '2099-06-16 23:59:59',*/
        istime: true,
        istoday: false,
        choose: function (datas) {
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);
    /* 新闻查询重填 */
	function Refillings(){
		document.getElementById("empty").reset();  
	}
/* 新闻查询清空 */	
	function clearData(){
		$("#input_text1").val("");
	}
/* 选人控件 */
$("#query_adduser").on("click",function(){
   		user_id = "input_text1";
       	$.popWindow("../common/selectUser");      		 		 
       	});  

</script>
</body>


</html>
