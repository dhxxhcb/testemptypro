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
    <meta charset="UTF-8">
    <title>系统日志管理</title>
    <link rel="stylesheet" type="text/css" href="../css/sys/journal.css"/>
    <link rel="stylesheet" type="text/css" href="../lib/laydate.css"/>
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/echarts/echarts.common.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/laydate.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/sys/journal.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css">

    </style>
</head>
<body>
<div class="content">
    <div class="head w clearfix">
        <ul class="index_head">
            <li id="survey"><span class="one headli">日志概况</span><img src="../img/02.png" alt=""/>
            </li>
            <li id="DATA"><span class="headli">年度数据</span><img src="../img/02.png" alt=""/>
            </li>
            <li id="statistics"><span class="headli">时段统计</span><img src="../img/02.png" alt=""/>
            </li>
            <li id="administration"><span class="headli" style="margin-top: 4px;">日志管理</span></li>
        </ul>
    </div><!--标题导航结束-->
    <div class="mainCon" style="width: 100%;">
        <div class="journalSurvey" style="display: block;">
            <div class="title">
                <span class="news">日志概况</span>
            </div>
            <div class="table">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td colspan="2" style="text-align: center;color: #2F5C8F;font-weight: bold;">日志概况</td>
                    </tr>
                    <tr>
                        <td width="20%">总统计天数：</td>
                        <td width="80%" class="totalDay"></td>
                    </tr>
                    <tr>
                        <td width="20%">总访问量：</td>
                        <td width="80%" class="totalCount"></td>
                    </tr>
                    <tr>
                        <td width="20%">今年访问量：</td>
                        <td width="80%" class="yearCount"></td>
                    </tr>
                    <tr>
                        <td width="20%">本月访问量：</td>
                        <td width="80%" class="mouthCount"></td>
                    </tr>
                    <tr>
                        <td width="20%">今日访问量：</td>
                        <td width="80%" class="dayCount"></td>
                    </tr>
                    <tr>
                        <td width="20%">平均每日访问量：</td>
                        <td width="80%" class="averageDayCount"></td>
                    </tr>
                </table>
            </div>
            <div class="tabTwo">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr class="newly">
                        <td colspan="4" style="color: #2F5C8F;font-weight: bold;">最近10条日志</td>
                    </tr>
                </table>
            </div>
        </div><!--日志概况结束-->
        <div class="yearData" style="display: none">
            <div class="title">
                <span class="news">年度数据</span>
                <select name="yeay" class="selectYear" id="select">
                    <option value="2017">2017年</option>
                </select>
                <select name="month" class="selectMonth" id="seleMonth">
                    <%--<option value="01">1月</option>
                    <option value="02">2月</option>
                    <option value="03">2月</option>
                    <option value="04">4月</option>
                    <option value="05">5月</option>
                    <option value="06">6月</option>
                    <option value="07">7月</option>
                    <option value="08">8月</option>
                    <option value="09">9月</option>
                    <option value="10">10月</option>
                    <option value="11">11月</option>
                    <option value="12">12月</option>--%>
                </select>
            </div>
            <div class="yearEcharts">
                <div id="monthData" style="width: 900px;height:300px;margin: 0 auto;"></div>
            </div>
            <div class="tabTwo">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr class="yearJournal">
                        <td colspan="4">2017年度按月访问数据</td>
                    </tr>
                    <%--<tr>
                        <td>1月</td>
                        <td>0%</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>2月</td>
                        <td>0%</td>
                        <td>0</td>
                    </tr>--%>
                </table>
            </div>
            <div class="dateEcharts">
                <div id="todyData" style="width: 900px;height:300px;margin: 0 auto;"></div>
            </div>
            <div class="tabTwo">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td colspan="4">05月份按日访问数据</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>0%</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>0%</td>
                        <td>0</td>
                    </tr>
                </table>
            </div>
        </div><%--年度数据统计结束--%>
        <div class="timeInterval" style="display: none">
            <div class="title">
                <span class="news">时段统计</span>
            </div>
            <div class="hourEcharts">
                <div id="hourData" style="width: 900px;height:300px;margin: 0 auto;"></div>
            </div>
            <div class="tabTwo">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td colspan="4">总访问量小时分布数据</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>0%</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>0%</td>
                        <td>0</td>
                    </tr>
                </table>
            </div>
        </div><%--时段统计结束--%>
        <div class="journalQuery" style="display: none;">
            <div class="title">
                <span class="news">系统日志查询</span>
            </div>
            <div class="table">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff;width: 40%;">
                    <tr>
                        <td width="25%">日志表：</td>
                        <td>
                            <input type="radio" name="radio">
                            <span>当前日志 </span>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">日志类型：</td>
                        <td>
                            <select id="journalType" style="width: 150px;height: 25px;">

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">用户：</td>
                        <td>
                            <div class="inPole">
                                <textarea name="txt" id="senduser" user_id='admin' value="admin" disabled style="min-width: 200px;min-height: 50px;"></textarea>
                                <span class="add_img" style="margin-left: 10px">
                                    <a href="javascript:;" id="selectUser" class="Add ">添加</a>
                                </span>
                                <span class="add_img">
                                    <a href="javascript:;" class="clear">清除</a>
                                </span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">起始时间：</td>
                        <td>
                            <%--<input type="text" name="timer" id="startTimer">--%>
                            <input type="text" class="laydate-icon" id="start">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">截止时间：</td>
                        <td>
                            <%--<input type="text" name="timer" id="endTimer">--%>
                                <input type="text" class="laydate-icon" id="end">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">IP地址：</td>
                        <td>
                            <input type="text" name="timer" id="IP">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">备注：</td>
                        <td>
                            <input type="text" name="timer" id="remarks">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">操作类型：</td>
                        <td>
                            <input type="radio" name="TYPE">
                            <span>查询</span>
                            <input type="radio" name="TYPE">
                            <span>导出</span>
                            <input type="radio" name="TYPE">
                            <span>删除</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="blue_text">
                            <div class="sureBtn">
                                <input type="button" name="Btn" id="Btn" value="确定" />
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
            <hr style="width: 100%;border-color: #ddd;border: #eee 1px solid;margin-top: 15px;"/>
            <div class="title">
                <span class="news">清空系统日志</span>
            </div>
            <div class="emptyBtn" id="emptyBtn">清空系统日志</div>
        </div><%--系统日志查询结束--%>
    </div>
</div>
<script type="text/javascript">
    var user_id='senduser';
    var res
    $(function(){
        //选人控件
        $("#selectUser").on("click",function(){
            user_id='senduser';
            $.popWindow("../common/selectUser");
        });
    })
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('monthData'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '2017年度按月访问统计',
            left:'45%',
            textStyle:{
                fontSize:14
            },
            textAlign:'center'

        },
        tooltip: {},
        legend: {
        },
        xAxis: {
            data: ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"]
        },
        yAxis: {},
        series: [{
            name: '访问量',
            type: 'bar',
            data: [0, 0, 67, 140, 5, 0, 0, 0, 0, 0, 0, 0]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('todyData'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '05月份按日访问统计',
            left:'45%',
            textStyle:{
                fontSize:14
            },
            textAlign:'center'

        },
        tooltip: {},
        legend: {
        },
        xAxis: {
            data: ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"]
            /*data: ["1","4","7","10","13","16","19","22","25","28","31"]*/
        },
        yAxis: {},
        series: [{
            name: '访问量',
            type: 'bar',
            data: [0, 0, 5, 39, 72, 1, 0, 99, 67, 25, 29, 13, 0, 0, 27, 23, 14, 38, 72, 7, 0, 38, 100, 200, 157, 102, 82, 0, 0, 0, 128]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('hourData'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '总访问量小时分布统计',
            left:'45%',
            textStyle:{
                fontSize:14
            },
            textAlign:'center'

        },
        tooltip: {},
        legend: {
        },
        xAxis: {
            data: ["0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"]
        },
        yAxis: {},
        series: [{
            name: '访问量',
            type: 'bar',
            data: [0, 0, 0, 0, 0, 0, 0, 1, 122, 177, 167, 36, 149, 159, 136, 190, 113, 59, 21, 6, 1, 0, 0]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    //时间控件调用
    var start = {
        elem: '#start',
        format: 'YYYY/MM/DD hh:mm:ss',
        /* min: laydate.now(), //设定最小日期为当前日期*/
        /* max: '2099-06-16 23:59:59', //最大日期*/
        istime: true,
        istoday: false,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#end',
        format: 'YYYY/MM/DD hh:mm:ss',
        /*min: laydate.now(),*/
        /*max: '2099-06-16 23:59:59',*/
        istime: true,
        istoday: false,
        choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);
</script>
</body>
</html>
