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
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/echarts/echarts.common.min.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css">

    </style>
</head>
<body>
<div class="content">
    <div class="head w clearfix">
        <ul class="index_head">
            <li data_id="0"><span class="one headli">日志概况</span><img src="../img/02.png" alt=""/>
            </li>
            <li data_id=""><span class="headli">年度数据</span><img src="../img/02.png" alt=""/>
            </li>
            <li data_id=""><span class="headli">时段统计</span><img src="../img/02.png" alt=""/>
            </li>
            <li data_id="1"><span class="headli" style="margin-top: 4px;">日志管理</span></li>
        </ul>
    </div><!--标题导航结束-->
    <div class="journalSurvey" style="display: none;">
        <div class="title">
            <span class="news">日志概况</span>
        </div>
        <div class="table">
            <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                <tr>
                    <td colspan="2">日志概况</td>
                </tr>
                <tr>
                    <td width="20%">总统计天数：</td>
                    <td width="80%"></td>
                </tr>
                <tr>
                    <td width="20%">总访问量：</td>
                    <td width="80%"></td>
                </tr>
                <tr>
                    <td width="20%">今年访问量：</td>
                    <td width="80%"></td>
                </tr>
                <tr>
                    <td width="20%">本月访问量：</td>
                    <td width="80%"></td>
                </tr>
                <tr>
                    <td width="20%">今日访问量：</td>
                    <td width="80%"></td>
                </tr>
                <tr>
                    <td width="20%">平均每日访问量：</td>
                    <td width="80%"></td>
                </tr>
            </table>
        </div>
        <div class="tabTwo">
            <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                <tr>
                    <td colspan="4">最近10条日志</td>
                </tr>
                <tr>
                    <td>系统管理员</td>
                    <td>2017-05-27 13:30:02</td>
                    <td>192.168.0.176</td>
                    <td>登录日志</td>
                </tr>
            </table>
        </div>
    </div><!--日志概况结束-->
    <div class="yearData">
        <div class="title">
            <span class="news">年度数据</span>
            <select name="yeay" class="selectYear" id="select">
                <option value="01">2017年</option>
            </select>
            <select name="month" class="selectMonth">
                <option value="01">1月</option>
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
                <option value="12">12月</option>
            </select>
        </div>
        <div class="yearEcharts">
            <div id="main" style="width: 600px;height:400px;"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

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
            name: '销量',
            type: 'bar',
            data: [0, 0, 67, 140, 5, 0, 0, 0, 0, 0, 0, 0]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>

