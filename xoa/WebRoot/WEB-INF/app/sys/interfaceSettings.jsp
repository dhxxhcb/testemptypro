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
    <title>界面设置</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <!--<link rel="stylesheet" type="text/css" href="../css/sys/addUser.css"/>-->
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/ajaxupload.js" type="text/javascript" charset="utf-8"></script>
    <script></script>
    <style type="text/css">
        table tr td {
            border: 1px solid rgb(192, 192, 192) !important;
        }
        #TableHeader { border: 1px solid rgb(192, 192, 192);}
        #TableHeader { border: 1px solid rgb(192, 192, 192);}
    </style>
</head>
<body class="bodycolor">
<table border="0" width="100%" cellspacing="0" cellpadding="3" class="small">
    <tbody><tr>
        <td class="Big"><b><span class="big1"> 界面设置</span></b>
        </td>
    </tr>
    </tbody></table>

<table class="TableBlock" width="600" align="center">
    <form enctype="multipart/form-data" action="update.php" method="post" name="form1"></form>


    <tbody><tr>
        <td colspan="2" class="TableHeader">浏览器窗口标题</td>
    </tr>
    <tr>
        <td nowrap="" class="TableData" id="TableData">浏览器窗口标题：</td>
        <td nowrap="" class="TableData" id="TableData">
            <input type="text" name="IE_TITLE" class="BigInput" size="40" maxlength="100" value="心通达OA办公系统" id="ie_title">&nbsp;
        </td>
    </tr>
    <tr>
        <td colspan="2" class="TableHeader">主界面</td>
    </tr>
    <tr>
        <td nowrap="" class="TableData" id="TableData">主界面-顶部大标题文字：</td>
        <td nowrap="" class="TableData" id="TableData">
            <input type="text" name="BANNER_TEXT" class="BigInput" size="40" maxlength="100" value="" id="BigInput_topwz">&nbsp;
        </td>
    </tr>
    <tr>
        <td nowrap="" class="TableData">主界面-底部状态栏置中文字：</td>
        <td nowrap="" class="TableData">
            <textarea class="BigInput" cols="44" rows="3" id="status_text"></textarea><br>多行文字可以实现轮换显示    </td>
    </tr>
    <tr>
        <td nowrap="" class="TableData">主界面-顶部图标：</td>
        <td nowrap="" class="TableData">
            <input type="file" name="ATTACHMENT" size="30" class="BigInput" title="选择附件文件">
            <br>JPG、GIF、PNG格式，<span class="big4">注意：图像名称不能含有中文</span>
        </td>
    </tr>
    <tr>
        <td nowrap="" class="TableData">主界面-顶部图标宽度：</td>
        <td nowrap="" class="TableData">
            <input type="text" name="IMG_WIDTH" class="BigInput" size="10" maxlength="100" value="110" id="img_width">&nbsp;像素    </td>
    </tr>
    <tr>
        <td nowrap="" class="TableData">主界面-顶部图标高度：</td>
        <td nowrap="" class="TableData">
            <input type="text" name="IMG_HEIGHT" class="BigInput" size="10" maxlength="100" value="40" id="img_height">&nbsp;像素&nbsp;(建议高度小于50像素)
        </td>
    </tr>
    <tr>
        <td colspan="2" class="TableHeader">界面主题</td>
    </tr>
    <tr>
        <td nowrap="" class="TableData">选择界面主题：</td>
        <td nowrap="" class="TableData">
            <input type="checkbox" name="THEME_SELECT" id="theme_select" checked=""><label for="THEME_SELECT">允许用户选择界面主题</label>
        </td>
    </tr>
    <tr>
        <td nowrap="" class="TableData">默认界面主题：</td>
        <td nowrap="" class="TableData">
            <select name="THEME" id="theme">
                <option value="1">传统风格</option>
                <option value="2">时尚风格</option>
            </select>
        </td>
    </tr>
    <tr>
        <td colspan="2" class="TableHeader">用户头像</td>
    </tr>
    <tr>
        <td nowrap="" class="TableData">用户上传头像：</td>
        <td nowrap="" class="TableData">
            <input type="checkbox" name="AVATAR_UPLOAD" id="avatar_upload" checked=""><label for="AVATAR_UPLOAD">允许用户上传头像</label>
        </td>
    </tr>
    <tr>
        <td nowrap="" class="TableData">用户上传头像最大宽度：</td>
        <td nowrap="" class="TableData">
            <input type="text"class="BigInput" size="10" maxlength="11" value="128" id="avatar_width">&nbsp;像素    </td>
    </tr>
    <tr>
        <td nowrap="" class="TableData">用户上传头像最大高度：</td>
        <td nowrap="" class="TableData">
            <input type="text" class="BigInput" size="10" maxlength="11" value="128" id="avatar_height">&nbsp;像素    </td>
    </tr>

    <tr>
        <td colspan="2" class="TableHeader">注销提示文字</td>
    </tr>
    <tr>
        <td nowrap="" class="TableData" width="150">用户点击注销时，显示这里设置的文字：</td>
        <td nowrap="" class="TableData">
            <textarea name="LOG_OUT_TEXT" class="BigInput" cols="44" rows="3" id="log_out_text">您真的要走吗？</textarea><br>
        </td>
    </tr>
    <tr>
        <td colspan="2" class="TableHeader">OA精灵</td>
    </tr>
    <tr>
        <td nowrap="" class="TableData">窗口标题：</td>
        <td nowrap="" class="TableData">
            <input type="text" name="IM_WINDOW_CAPTION" class="BigInput" size="40" maxlength="100" value="心通达OA">&nbsp;
        </td>
    </tr>
    <tr>
        <td nowrap="" class="TableControl" colspan="2" align="center">
            <input type="button" value="确定" class="BigButton" onclick="alert("界面设置已修改");">
        </td>
    </tr>

    </tbody></table>
</div>
</body>
<script type="text/javascript">
    function saveData(){
        var datas={
        ieTitle:$("#ie_title").val(),
        bannertText:$("#BigInput_topwz").val(),
        statusText:;$("#status_text").val(),
        imgWidth:$("#img_width").val(),
        imgHeight:$("#img_height").val(),
        themeSelect:$("#theme_select").is(':checked'),
        theme:$("#theme").val(),
        avatarUpload:$("#avatar_upload").is(':checked'),
        avatarWidth:$("#avatar_width").val(),
        avatarHeight:$("#avatar_height").val(),
        LOG_OUT_TEXT:$("#log_out_text").val()
        //attachMentId:$
        //$("#MYTABLE_BKGROUND").val
    };
        $.ajax({
            url:"../../sys/getInterfaceInfo",
            type:"post",
            datatType:"json",
            data:datas,
            success:function(data){
                alert("界面设置已修改")；
            }
        })
    }
    function test(){
        alert("界面设置已修改");
    }
</script>
</html>