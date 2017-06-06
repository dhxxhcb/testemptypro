<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>工作日志</title>
    <link rel="stylesheet" type="text/css" href="../css/base.css"/>
    <link rel="stylesheet" type="text/css" href="../css/diary/workLog.css"/>
    <link rel="stylesheet" type="text/css" href="../css/diary/calendar.css"/>
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../js/diary/calendar.js/"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>

</head>
<style>

</style>
<body>
<%--头部--%>
<div class="head w clearfix">
    <ul class="index_head">
        <li data_id=""><span class="one headli1_1">日志信息</span><img class="headli1_2" src="../img/02.png" alt=""/>
        </li>
        <li data_id="0"><span class="headli2_1">日志检索</span>
        </li>
    </ul>
</div>
<%--中间部门--%>
<div class="headLog clearfix">
    <img src="../img/la2.png">
    <div class="">
        日志信息
    </div>
</div>
<%--内容部分左侧--%>
<div class="span3">
    <div class="diary-main-panel clearfix">
        <h3 class="diary-user-name">系统管理员</h3>
        <ul class="diary-types-box clearfix">
            <li data-type="all">
                <div class="diary-types-counter">196</div>
                <div class="diary-types-title">全部日志</div>
            </li>
            <li data-type="mine">
                <div class="diary-types-counter">161</div>
                <div class="diary-types-title">我的日志</div>
            </li>
            <li data-type="others">
                <div class="diary-types-counter">35</div>
                <div class="diary-types-title">他人日志</div>
            </li>
        </ul>
        <div class="diary-calendar-wrapper" id="calendar_" style="display: block;">
            <%--日历插件--%>
            <div id="ca"></div>
            <div id="diary-date-result" class="tags" style="border: none;"></div>
        </div>
        <%--高级搜索--%>
        <div id="diary-search-box">
            <form class="form-search" name="searchForm">
                <div class="search_">
                    <i class="icon-search"></i>
                    <i class="icon-chevron-down" id="triangle"></i>
                </div>

                <div id="diary-adv-search-box" class="diary-adv-search-box on" style="display:none">
                    <div class="control-group">
                        <div class="controls pull-right">
                            <a class="date-quicklink" data-cmd="recent3day" href="javascript:void(0)">三天内</a>
                            <a class="date-quicklink" data-cmd="recent1week" href="javascript:void(0)">本周</a>
                            <a class="date-quicklink" data-cmd="recent1month" href="javascript:void(0)">本月</a>
                        </div>
                        <label class="control-label"><b class="date">日期</b></label>
                        <div class="controls">
                            <input type="text" id="startdate">
                            至 <input type="text" id="enddate">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label"><b class="date">范围</b></label>
                        <div class="controls">
                            <select id="diarytype" class="input-medium " name="diarytype">
                                <option value="all">所有的</option>
                                <option value="mine">我自己的</option>
                                <option value="shared">共享给我的</option>
                                <option value="permission">有权限查看的</option>
                            </select>
                        </div>

                    </div>
                    <div id="dept-group" class="control-group">
                        <div class="dept-control pull-right">
                            <img src="../img/workLog/newlyBuild.png" alt="">
                            <img src="../img/workLog/delete.png" alt="">
                        </div>
                        <label class="control-label"><b class="date">部门</b></label>
                        <div class="controls">
                            <div id="dept-tags" class="tags"></div>
                            <input type="hidden" id="deptname" name="deptname">
                            <input type="hidden" id="depttext" name="depttext">
                        </div>
                    </div>

                    <div id="role-group" class="control-group">
                        <div class="role-control pull-right">
                            <img src="../img/workLog/newlyBuild.png" alt="">
                            <img src="../img/workLog/delete.png" alt="">
                        </div>
                        <label class="control-label"><b class="date">角色</b></label>
                        <div class="controls">
                            <div id="role-tags" class="tags"></div>
                            <input type="hidden" id="rolename" name="rolename">
                            <input type="hidden" id="roletext" name="roletext">
                        </div>
                    </div>
                    <div id="user-group" class="control-group">
                        <!-- Text input-->
                        <div class="user-control pull-right">
                            <img src="../img/workLog/newlyBuild.png" alt="">
                            <img src="../img/workLog/delete.png" alt="">
                        </div>
                        <label class="control-label"><b class="date">人员</b></label>
                        <div class="controls">
                            <div id="user-tags" class="tags"></div>
                            <input type="hidden" id="username" name="username">
                            <input type="hidden" id="usertext" name="usertext">
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Select Basic -->
                        <label class="control-label"><b class="date">日志表</b></label>
                        <div class="controls">
                            <select class="input-medium " id="diarydb" name="diarydb">
                                <option value="">当前日志</option>

                            </select>
                        </div>
                    </div>

                    <div class="control-group">
                        <button class="button_  button_query">查询</button>
                        <button class="button_">导出</button>
                    </div>
                </div>


            </form>
        </div>
    </div>

    <div class="writeLog">写日志</div>


    <%--<dl id="diary-cmt-list" class="diary-cmt-list">--%>
    <%--<dt>--%>
    <%--系统管理员 <i>回复了</i>--%>
    <%--</dt>--%>
    <%--<dd>--%>
    <%--<a target="_blank" href="show_diary.php?dia_id=216">《2017-05-12 星期五 工作日志》</a>--%>
    <%--</dd>--%>

    <%--</dl>--%>
</div>
<%--内容部分右侧--%>
<div class="content_right clearfix">
    <div class="button_news clearfix">
        <button class="btn active" type="button">看所有人的</button>
        <button class="btn" type="button">看自己的</button>
        <button class="btn" type="button">看其他人的</button>
    </div>

    <div class="details clearfix">
        你好

    </div>


</div>


</body>
<script>
    $(function () {
//        日历插件
        $('#ca').calendar({
            width: 320,
            height: 200,
            data: [
                {
                    date: '2015/12/24',
                    value: 'Christmas Eve'
                },
                {
                    date: '2015/12/25',
                    value: 'Merry Christmas'
                },
                {
                    date: '2016/01/01',
                    value: 'Happy New Year'
                }
            ],
            onSelected: function (view, date, data) {
                console.log('view:' + view)
                alert('date:' + date)
                console.log('data:' + (data || 'None'));

            }
        });
//    日历和高级查询的切换和隐藏
        $("#triangle").on('click', function () {
            $("#diary-adv-search-box").toggle();
            $("#calendar_").toggle();

            //  小箭头切换类名
            if ($("#diary-adv-search-box").css('display') == 'none') {
                $("#triangle").addClass("icon-chevron-down").removeClass("icon-chevron-up");

            } else {
                $("#triangle").addClass("icon-chevron-up").removeClass("icon-chevron-down");
                document.getElementById("diary-search-box").style.borderTop = "none"; //高级编辑的时候上边框为空

            }

        });


    })


</script>


</html>
