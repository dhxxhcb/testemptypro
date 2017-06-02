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
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <title>单位信息查询</title>
    <link rel="stylesheet" href="../css/sys/companyinfo.css" />
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="content">
    <div class="headDiv">
        <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
        <div class="divP">单位信息</div>
    </div>
    <div class="tab">
        <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
            <tr>
                <td colspan="2" style="color:#2F5C8F;font-weight: bold;">单位信息</td>
            </tr>
            <tr>
                <td width="20%">单位名称：</td>
                <td class="unitName"></td>
            </tr>
            <tr>
                <td width="20%" class="blue_text">电话：</td>
                <td class="telNo"></td>
            </tr>
            <tr>
                <td width="20%" class="blue_text">传真：</td>
                <td class="faxNo"></td>
            </tr>
            <tr>
                <td width="20%" class="blue_text">邮编：</td>
                <td class="postNo"></td>
            </tr>
            <tr>
                <td width="20%" class="blue_text">地址：</td>
                <td class="address"></td>
            </tr>
            <tr>
                <td width="20%" class="blue_text">网站：</td>
                <td class="url"></td>
            </tr>
            <tr>
                <td width="20%" class="blue_text">电子信箱：</td>
                <td class="email"></td>
            </tr>
            <tr>
                <td width="20%" class="blue_text">开户行：</td>
                <td class="bankName"></td>
            </tr>
            <tr>
                <td width="20%" class="blue_text">账号：</td>
                <td class="bankNo"></td>
            </tr>
            <tr>
                <td colspan="2" style="color:#2F5C8F;font-weight: bold;">单位简介</td>
            </tr>
            <tr>
                <td width="20%">附件文档：</td>
                <td class="enclosure"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="container" style="width: 99.9%;min-height: 300px;" name="content" type="text/plain"></div>
                </td>
            </tr>
        </table>
    </div>
</div>
<script type="text/javascript">
    var ue = UE.getEditor('container');
    $(function(){
        ue.ready(function() {
            $.ajax({
                type: 'get',
                url: '/sys/showUnitManage',
                dataType: 'json',
                success: function (res) {
                    var data = res.object;
                    var str = '';
                    var arr = new Array();
                    arr = data.attachment;
                    $('.unitName').text(data.unitName);
                    $('.telNo').text(data.telNo);
                    $('.faxNo').text(data.faxNo);
                    $('.postNo').text(data.postNo);
                    $('.address').text(data.address);
                    $('.url').text(data.url);
                    $('.email').text(data.email);
                    $('.bankName').text(data.bankName);
                    $('.bankNo').text(data.bankNo);
                    if (data.attachmentName != '') {
                        for (var i = 0; i < arr.length; i++) {
                            str += '<div><a href="<%=basePath %>download?' + arr[i].attUrl + '"><img src="../img/icon_print_07.png"/>' + arr[i].attachName + '</a></div>';
                        }
                    }
                    $('.enclosure').append(str);
                    ue.setContent(data.content);
                }
            })
        })
    })
</script>
</body>
</html>

