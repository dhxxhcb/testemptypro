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
                </select>
            </div>
            <div class="yearEcharts" style="position: relative">
                <div style="width: 100%;text-align: center;position: absolute;top: 15px;font-size: 14px;"><span>2017</span>年度按月访问数据</div>
                <div id="monthData" style="width: 900px;height:300px;margin: 0 auto;"></div>
            </div>
            <div class="tabTwo">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr class="yearJournal">
                        <td colspan="4">2017年度按月访问数据</td>
                    </tr>
                </table>
            </div>
            <div class="dateEcharts" style="position: relative">
                <div style="width: 100%;text-align: center;position: absolute;top: 15px;font-size: 14px;"><span class="monthSpan">1</span>月份按日访问数据</div>
                <div id="todyData" style="width: 900px;height:300px;margin: 0 auto;"></div>
            </div>
            <div class="tabTwo">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr class="monthJournal">
                        <td colspan="4"><span class="monthSpan">1</span>月份按日访问数据</td>
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
                    <tr class="period">
                        <td colspan="4">总访问量小时分布数据</td>
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
                            <input type="radio" name="radio" checked>
                            <span>当前日志 </span>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">日志类型：</td>
                        <td>
                            <select id="journalType" style="width: 150px;height: 25px;">
                                <option value="">所有日志</option>
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
                            <input type="text" class="laydate-icon" id="start">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%">截止时间：</td>
                        <td>
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
                            <input type="radio" name="TYPE" value="1" class="Query">
                            <span>查询</span>
                            <input type="radio" name="TYPE" value="2" class="Export">
                            <span>导出</span>
                            <input type="radio" name="TYPE" value="3" class="Delete">
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
            <hr style="width: 99.8%;border-color: #ddd;border: #eee 1px solid;margin-top: 15px;"/>
            <div class="title">
                <span class="news">清空系统日志</span>
            </div>
            <div class="emptyBtn" id="emptyBtn">清空系统日志</div>
        </div><%--系统日志查询结束--%>
        <div class="queryResult" style="display:none;">
            <div class="title">
                <span class="news">查询结果（最多显示300条记录）</span>
                <span class="news">查询的条数：</span>
                <input type="text" name="num" class="num" value="">
                <input type="button" name="numBtn" id="numBtn" class="numBtn" value="查询">
            </div>
            <div class="tabTwo">
                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff;width: 90%;">
                    <tr class="queryJournalList">
                        <th>选择</th>
                        <th>用户姓名</th>
                        <th>时间</th>
                        <th>IP地址</th>
                        <th>IP所在地</th>
                        <th>日志类型</th>
                        <th>备注</th>
                    </tr>
                    <tr>
                        <td colspan="7" style="text-align: left">
                            <input id="checkedAll" type="checkbox" name="check" value="" style="margin-left: 20px;" >
                            <label for="checkedAll">全选</label>
                            <input type="button" name="delete" id="delete" class="numBtn" value="删除">
                        </td>
                    </tr>
                </table>
                <div class="divBack" id="divBack">返回</div>
            </div>
        </div><%--查询结果列表结束--%>
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

</script>
</body>
</html>

