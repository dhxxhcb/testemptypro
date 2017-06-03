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
    <title>用户详情</title>
    <link rel="stylesheet" type="text/css" href="../css/sys/uesrDetails.css"/>
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="content">
    <div class="header">
        <div class="basisInfor">
            <div class="imgHead">
                <div class="img"></div>
                <div class="button">
                    <div class="microNews">微讯</div>
                    <div class="Mail">邮件</div>
                </div>
            </div>
            <div class="information">
                <div class="uName">
                    <span style="font-size: 16px;" class="userName"></span>
                    <div style="float: right;">
                        <span>关注</span>
                        <span>0</span>
                        <span style="margin: 0 15px;color: #000;">|</span>
                        <span>粉丝</span>
                        <span>0</span>
                    </div>

                </div>
                <p style="margin-top: 15px;font-size: 14px;" class="deptName"></p>
                <p style="margin-top: 15px;font-size: 14px;" class="userPrivName"></p>
                <div class="follow">关注</div>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="userData">
            <div style="margin-left: 2%;">资料</div>
            <div class="excelLeft">
                <table class="table1" border="" cellspacing="1" cellpadding="1" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td width="30%">姓名：</td>
                        <td class="userName"></td>
                    </tr>
                    <tr>
                        <td>部门：</td>
                        <td  class="deptName"></td>
                    </tr>
                    <tr>
                        <td>其他部门：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>角色：</td>
                        <td class="userPrivName"></td>
                    </tr>
                    <tr>
                        <td>辅助角色：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>职务：</td>
                        <td></td>
                    </tr>
                </table>
                <table class="table2" border="" cellspacing="0" cellpadding="0" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td width="30%">手机：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>电话：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>传真：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Email：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>QQ：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>MSN：</td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <div class="excelright">
                <table class="table2" border="" cellspacing="0" cellpadding="0" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td width="30%">性别：</td>
                        <td class="sex"></td>
                    </tr>
                    <tr>
                        <td>生日：</td>
                        <td class="birthday"></td>
                    </tr>
                    <tr>
                        <td>生肖：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>星座：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>血型：</td>
                        <td></td>
                    </tr>
                </table>
                <table class="table2" border="" cellspacing="0" cellpadding="0" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td width="30%">岗位名称：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>岗位要求：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>岗位职责：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>直属上级：</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>直属下级：</td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    $(function(){
        var uid=$.getQueryString('uid');
        $.ajax({
            type:'get',
            url:'/user/findUserByuid',
            dataType:'json',
            data:{'uid':uid},
            success:function(res){
                var data=res.object;
                var SEX='';
                if(data.sex==0){
                    SEX='男';
                }else{
                    SEX='女';
                }
                $('.userName').text(data.userName);
                $('.deptName').text(data.deptName);
                $('.userPrivName').text(data.userPrivName);
                $('.sex').text(SEX);
                $('.birthday').text(data.birthday);
            }
        })
    })
</script>
</body>
</html>