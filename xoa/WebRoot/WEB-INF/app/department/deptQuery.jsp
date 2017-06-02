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
    <title>部门信息查询</title>
    <link rel="stylesheet" type="text/css" href="../css/news/center.css"/>
    <link rel="stylesheet" type="text/css" href="../lib/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../lib/pagination/style/pagination.css"/>
    <link rel="stylesheet" type="text/css" href="../css/base.css" />
    <link rel="stylesheet" type="text/css" href="../css/news/new_news.css"/>
    <!-- 新闻管理  -->
    <link rel="stylesheet" type="text/css" href="../css/news/management_query.css" />
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script src="../js/news/page.js"></script>
    <script src="../lib/laydate.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
<!--navigation开始-->
<div class="step1">
    <div class="navigation  clearfix">
        <div class="left">
            <img src="../img/la2.png">
            <div class="news">
                <fmt:message code="news.title.new"/>
            </div>
            <select name="TYPE" class="button1 nav_type" id="select">
                <option value="0" selected=""><fmt:message code="news.th.type"/></option>
                <option value="01"><fmt:message code="news.th.company"/></option>
                <option value="02"><fmt:message code="news.th.media"/></option>
                <option value="03"><fmt:message code="news.th.industry"/></option>
                <option value="04"><fmt:message code="news.th.partner"/></option>
                <option value="05"><fmt:message code="news.th.client"/></option>
                <option value=""><fmt:message code="news.th.none"/></option>
            </select>
            <!-- 查询按钮 -->
            <!-- <div id="cx" class="submit">查询</div>	 -->
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
            <table id="tr_td">
                <thead>
                <tr>
                    <td class="th"><fmt:message code="global.lang.select"/></td>
                    <td class="th"><fmt:message code="notice.th.publisher"/></td>
                    <td class="th"><fmt:message code="notice.th.type"/></td>
                    <td class="th" style="position: relative"><fmt:message code="notice.th.releasescope"/></td>
                    <td class="th"><fmt:message code="notice.th.title"/></td>
                    <td class="th"><fmt:message code="notice.th.PostedTime"/></td>
                    <td class="th"><fmt:message code="news.title.query"/></td>
                    <td class="th"><fmt:message code="news.th.commentnew"/></td>
                    <td class="th"><fmt:message code="notice.th.state"/></td>
                    <td class="th"><fmt:message code="news.th.clicks"/></td>
                </tr>
                </thead>
                <tbody id="j_tb">

                </tbody>
            </table>
        </div>
    </div>
    <!--content部分结束-->
</div>





</body>
</html>
