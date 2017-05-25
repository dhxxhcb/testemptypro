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
    <title>首页</title>
	<%--<link rel="stylesheet" href="../css/base.css" />
	<link rel="stylesheet" type="text/css" href="../css/common/addpage.css"/>
	<link rel="stylesheet" href="../lib/pagination/style/pagination.css" />--%>
	<link rel="stylesheet" href="../css/sys/companyinfo.css" />
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
        <script src="../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
        <script src="../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
        <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>

   <%-- <script type="text/javascript" src="../js/sys/companyinfo.js"></script>--%>
    <style type="text/css">
    </style>
	</head>
	<body>
    <div class="content">
        <div class="headDiv">
            <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
            <div class="divP">单位管理</div>
        </div>
        <div class="tab">

                <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
                    <tr>
                        <td>单位名称：</td>
                        <td>
                            <input type="text" name="company" class="inputTd" placeholder="北京集团总部"/>
                            <span style="font-size: 12px;color: #666;">软件注册后，请不要随意修改单位名称，这会导致需要重新注册</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">电话：</td>
                        <td>
                            <input type="text" name="company" class="inputTd" placeholder=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">传真：</td>
                        <td>
                            <input type="text" name="company" class="inputTd" placeholder=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">邮编：</td>
                        <td>
                            <input type="text" name="company" class="inputTd" placeholder=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">地址：</td>
                        <td>
                            <input type="text" name="company" class="inputTd" placeholder=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">网站：</td>
                        <td>
                            <input type="text" name="company" class="inputTd" placeholder=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">电子信箱：</td>
                        <td>
                            <input type="text" name="company" class="inputTd" placeholder=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">开户行：</td>
                        <td>
                            <input type="text" name="company" class="inputTd" placeholder=""/>
                        </td>
                    </tr>
                    <tr>
                        <td class="blue_text">账号：</td>
                        <td>
                            <input type="text" name="company" class="inputTd" placeholder=""/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">单位简介</td>
                    </tr>
                    <tr>
                        <td>附件文档：</td>
                        <td class="enclosure"></td>
                    </tr>
                    <tr>
                        <td>附件上传：</td>
                        <td class="files">
                            <form id="uploadimgform" target="uploadiframe"  action="../upload?module=sys" enctype="multipart/form-data" method="post" >
                                <input type="file" name="file" id="uploadinputimg"  class="w-icon5" style="display:none;">
                                <a href="#" id="uploadimg"><div class="div_upload_im"><img src="../img/mg11.png" alt=""/></div>附件上传</a>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div id="container" style="width: 99.9%;min-height: 300px;" name="content" type="text/plain"></div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="btn">
                                <input id="submit" type="button" value="保存单位设置"/>
                            </div>
                        </td>
                    </tr>
                </table>
        </div>
    </div>
</body>
    <script type="text/javascript">
        var ue = UE.getEditor('container');
        var res;
        $(function(){
            //附件上传
            $('#uploadimg').on('click', function(ele) {
                $('#uploadinputimg').click();
            })
            $('#uploadinputimg').change(function(e){
                var target = $(e.target);
                var file;
                if(target[0].files && target[0].files[0]){
                    file=target[0].files[0];
                }
                if(file){
                    $.upload($('#uploadimgform'),function(res){
                        var data=res.obj;
                        var str='';
                        var str1='';
                        for(var i=0;i<data.length;i++){
                            str+='<a href="<%=basePath %>download?'+data[i].attUrl+'" NAME="'+data[i].attachName+'*">'+data[i].attachName+'</a>';
                            str1+='<input type="hidden" class="inHidden" value="'+data[i].aid+'@'+data[i].ym+'_'+data[i].attachId+',">';
                        }
                        $('.enclosure').append(str+str1);
                    });
                }
            });
        })
    </script>
</html>

<%--
<div><img class="left_img" src="../img/mg12.png" alt=""/></div>
<div class="enclosure_t"><a href="#">从文件柜和网络硬盘选择附件</a></div>--%>
