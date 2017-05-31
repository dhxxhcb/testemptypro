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
<head>
    <meta charset="UTF-8">
    <title><fmt:message code="news.th.newsDetail"/></title>
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css">
        body {
            padding: 0;
            margin: 0;
            font-family: "微软雅黑";
            width: 100%;
        }

        /* .detailsContent{width: 100%;overflow: hidden;background-color: #f6f7f9;} */
        .detailsContent {
            width: 100%;
            overflow: hidden;
        }

        .detailsContent .title {
            width: 100%;
            text-align: center;
            height: 60px;
            line-height: 60px;
            color: #2a588c;
            font-size: 25px;
            font-weight: bold;
        }

        .infor {
            width: 100%;
            overflow: hidden;
            height: 40px;
            background-color: #d3e7fa;
        }

        .infor ul {
            list-style: none;
            overflow: hidden;
            float: right;
            margin-top: 10px;
        }

        .infor ul li {
            float: left;
            margin-right: 20px;
            font-size: 14px;
        }

        .infor ul li span {
            font-size: 14px;
        }

        .divContent {
            width: 100%;
        }

        .divContent .divTxt {
            margin: 20px 20px;
        }

        .divContent .divTxt p {
            font-size: 14px;
            color: #444;
            line-height: 25px;
        }

        .divContent .keyWord {
            margin: 0 0 10px 50px;
        }

        .divContent .keyWord span {
            margin-right: 10px;
            color: #2b7fe0;
        }

        .btnImg {
            width: 100%;
        }

        .btnImg .margin {
            width: 370px;
            margin: 20px auto;
        }

        .btnImg .margin a {
            margin-right: 20px;
        }

        .spanbreak {
            width: 60px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            display: inline-block;
        }
        .font_ {
            font-weight: bold;
            font-size: 16px;
            margin-left: 20px;
            font-family: "微软雅黑";
        }
        .img_ {
            width: 20px;
            height: 20px;
            margin-right: 5px;
            vertical-align: middle;
        }
    </style>
    <script type="text/javascript">
        $(function () {

            var nid = $.getQueryString('newsId');

            $.ajax({
                type: 'get',
                url: 'getOneById',
                dataType: 'json',
                data: {'newsId': nid},
                success: function (rsp) {
                    var data1 = rsp.object;
                    var str = '';

                    var toTypeName = "";
                    if (rsp.object.toId != "") {
                        toTypeName += "部门";
                    }
                    if (rsp.object.privId != "") {
                        toTypeName += ",角色";
                    }
                    if (rsp.object.userId != "") {
                        toTypeName += ",用户";
                    }

                    $('.title').text(data1.subject);
                    str = '<li><div style="display: inline-block; position: relative;top: -4px"><fmt:message code="news.th.postdept" />：</div><div class="spanbreak" title="' + toTypeName + '">' + toTypeName + '</div></li><li><span><fmt:message code="notice.th.publisher" />：</span><span>' + data1.users.userName + '</span></li><li><span><fmt:message code="notice.th.PostedTime" />：</span><span>' + data1.newsDateTime + '</span></li>';
                    $('ul').append(str);
                    $('.divTxt').append('<p>' + data1.content + '</p>');
                    var str1 = "";
                    var arr = new Array();
                    arr = data1.attachment;
                    if (data1.attachmentName != '') {
                        for (var i = 0; i < (arr.length); i++) {
                            str1 += '<div class="font_">附件文件：<a href="<%=basePath %>download?' + arr[i].attUrl + '"><img class="img_" src="../img/enclosure.png"/>' + arr[i].attachName + '</a></div>';
                        }
//                        str1 += '<tr><td class="attachment">' + data1.attachmentName + '</td></tr>';
                        $('.Table').append(str1);
                    }

                }
            });

        });
    </script>
</head>
<body>
<div class="detailsContent">
    <div class="title"></div>
    <div class="infor">
        <ul>

        </ul>
    </div>
    <div class="divContent">
        <div class="divTxt">
        </div>
        <div class="divContent1" style="border-top:1px solid #dedede; padding-top:10px;">
            <table class="Table" cellspacing="0" cellpadding="0">
            </table>
        </div>
    </div>
</div>
</body>
</html>

