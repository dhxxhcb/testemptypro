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
    <title>管理邮件箱</title>
    <style type="text/css">
        *{margin: 0;padding: 0;}
        body{font-family: "微软雅黑";}
        .title{height: 60px;width: 100%;margin-left: 15px;}
        .title .div_title{font-size: 22px;}
        .TABLE tr{border: 1px solid #c0c0c0;}
        .TABLE tr td{padding: 6px;border-right: 1px solid #c0c0c0;display: table-cell;vertical-align: inherit;font-size: 12px;}
        #btn{display: block;margin: 0 auto;width: 70px;height: 28px;border: #ccc 1px solid;border-radius: 3px;cursor: pointer;text-align: center;line-height: 28px;}
        .TABLE table tr td input{border: 1px solid #C6C6C6;height: 22px;padding-left: 3px;width: 200px;}
        hr{border: #ddd 1px dashed;margin: 15px 0;}
        .TABLE_A tr{border: 1px solid #c0c0c0;}
        .TABLE_A table tr:nth-child(odd) {background-color: #F6F7F9;}
        .TABLE_A table tr:nth-child(even) {background-color: #fff;}
        .TABLE_A table tr th{color: #2F5C8F;font-size: 14px;padding: 6px;}
        .TABLE_A table tr td{font-size: 12px;padding: 6px;}
        .TABLE_A table tr td input[type="text"]{width: 50px;height: 22px;padding-left: 5px;}
        .set_btn{border-radius: 3px;padding: 3px 10px;font-size: 12px;color: #333;margin: 1px;text-decoration: none;text-align: center;cursor: pointer;border: #ccc 1px solid;display: inline-block;}
        .TABLE_A table tr td a{text-decoration: none;margin-left: 5px;color: #1687cb;}
    </style>
</head>
<body>
<div class="content">
    <div class="title">
        <div class="div_im"></div>
        <div class="div_title">添加邮件箱</div>
    </div>
    <div class="TABLE" style="width: 100%;">
        <form action="" method="get">
            <table cellspacing="0" cellpadding="0" width="40%" style="border-collapse:collapse;background-color: #fff;margin: 0 auto;">
                <tr>
                    <th colspan="2" style="text-align: center;background-color: #3691DA;color: #fff;font-weight: normal;padding: 6px;">添加邮件箱</th>
                </tr>
                <tr>
                    <td>序号：</td>
                    <td>
                        <input type="text" name="txt" id="txt1" value="" />
                    </td>
                </tr>
                <tr>
                    <td>名称：</td>
                    <td>
                        <input type="text" name="txt" id="txt2" value="" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div name="btn" id="btn" >
                            <div class="DIV_Txt">添加</div>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <hr />
    <div class="div_list">
        <div class="title">
            <div class="div_im"></div>
            <div class="div_title">管理邮件箱</div>
        </div>
        <div class="TABLE_A">
            <table cellspacing="0" cellpadding="0" style="border-collapse:collapse;width:70%;margin: 0 auto;">
                <tr class='befor'>
                    <th width="10%">编号</th>
                    <th width="10%">名称</th>
                    <th width="30%">占用空间</th>
                    <th width="30%">每页显示邮件数</th>
                    <th width="20%">操作</th>
                </tr>
                <tr>
                    <td style="text-align: center;"></td>
                    <td style="text-align: center;">收件箱</td>
                    <td>6,243,852 字节(约合5.95 M)</td>
                    <td style="text-align: center;">
                        <input type="text" name="pageIn" id="pageIn_1" value="11" />
                        <div class="set_btn">设置</div>
                    </td>
                    <td style="text-align: center;"></td>
                </tr>
                <tr>
                    <td style="text-align: center;"></td>
                    <td style="text-align: center;">草稿箱</td>
                    <td>823 字节(约合0.00 M)</td>
                    <td style="text-align: center;">
                        <input type="text" name="pageIn" id="pageIn_2" value="11" />
                        <div class="set_btn">设置</div>
                    </td>
                    <td style="text-align: center;"></td>
                </tr>
                <tr>
                    <td style="text-align: center;"></td>
                    <td style="text-align: center;">已发送</td>
                    <td>812,909 字节(约合0.78 M)</td>
                    <td style="text-align: center;">
                        <input type="text" name="pageIn" id="pageIn_3" value="11" />
                        <div class="set_btn">设置</div>
                    </td>
                    <td style="text-align: center;"></td>
                </tr>
                <tr>
                    <td style="text-align: center;"></td>
                    <td style="text-align: center;">废纸篓</td>
                    <td>65,704 字节 (约合0.06M)</td>
                    <td style="text-align: center;">
                        <input type="text" name="pageIn" id="pageIn_4" value="11" />
                        <div class="set_btn">设置</div>
                    </td>
                    <td style="text-align: center;"></td>
                </tr>
                <tr>
                    <td style="text-align: center;">1</td>
                    <td style="text-align: center;">其他邮件箱</td>
                    <td>0 字节 (约合0.00M)</td>
                    <td style="text-align: center;">
                        <input type="text" name="pageIn" class="pageIn" value="10" />
                        <div class="set_btn">设置</div>
                    </td>
                    <td style="text-align: center;">
                        <a href="javascript:;">编辑</a>
                        <a href="javascript:;">删除</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="5">
                        <span style="margin-left: 10%;">合计：</span><span id="num"></span>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>

