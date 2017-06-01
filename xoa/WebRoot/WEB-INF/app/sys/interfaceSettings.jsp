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
    <link rel="stylesheet" type="text/css" href="../css/sys/addUser.css"/>
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/ajaxupload.js" type="text/javascript" charset="utf-8"></script>
    <script></script>
</head>
<body>
<body class="bodycolor" onload="Load();">
<table border="0" width="100%" cellspacing="0" cellpadding="3" class="small">
  <tbody><tr>
    <td class="Big"><img src="/static/images/sys_config.gif" width="22" height="20" align="absmiddle"><b><span class="big1"> 界面设置</span></b>
    </td>
  </tr>
</tbody></table>

<table class="TableBlock" width="600" align="center">
  <form enctype="multipart/form-data" action="update.php" method="post" name="form1"></form>
  
  
   <tbody><tr>
    <td colspan="2" class="TableHeader">浏览器窗口标题</td>
   </tr>
   <tr>
    <td nowrap="" class="TableData">浏览器窗口标题：</td>
    <td nowrap="" class="TableData">
        <input type="text" name="IE_TITLE" class="BigInput" size="40" maxlength="100" value="心通达OA办公系统">&nbsp;
    </td>
   </tr>
   <tr>
    <td colspan="2" class="TableHeader">主界面</td>
   </tr>
   <tr>
    <td nowrap="" class="TableData">主界面-顶部大标题文字：</td>
    <td nowrap="" class="TableData">
        <input type="text" name="BANNER_TEXT" class="BigInput" size="40" maxlength="100" value="">&nbsp;
    </td>
   </tr>
   <tr>
    <td nowrap="" class="TableData">主界面-顶部大标题样式：</td>
    <td nowrap="" class="TableData">
        <input type="hidden" name="FONT_FAMILY" value="">
        <input type="hidden" name="FONT_SIZE" value="14pt">
        <input type="hidden" name="FONT_COLOR" value="">
        <input type="hidden" name="FONT_FILTER" value="Shadow(Direction=120, color=null)">
        <a id="font_family_link" href="javascript:;" class="dropdown" onclick="showMenu(this.id, 1);" hidefocus="true" style="font-family:;"><span>字体</span></a>&nbsp;&nbsp;
        <a id="font_size_link" href="javascript:;" class="dropdown" onclick="showMenu(this.id, 1);" hidefocus="true"><span>四号</span></a>&nbsp;&nbsp;
        <a id="font_color_link" href="javascript:;" class="dropdown" onclick="showMenu(this.id, 1);" hidefocus="true" style="color:;"><span>颜色</span></a>&nbsp;&nbsp;
        <a id="font_filter_link" href="javascript:;" class="dropdown" onclick="showMenu(this.id, 1);" hidefocus="true"><span>投影</span></a>&nbsp;&nbsp;
    </td>
   </tr>
   <tr>
    <td nowrap="" class="TableData">主界面-底部状态栏置中文字：</td>
    <td nowrap="" class="TableData">
        <textarea name="STATUS_TEXT" class="BigInput" cols="44" rows="3"></textarea><br>多行文字可以实现轮换显示    </td>
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
        <input type="text" name="IMG_WIDTH" class="BigInput" size="10" maxlength="100" value="110">&nbsp;像素    </td>
   </tr>
   <tr>
    <td nowrap="" class="TableData">主界面-顶部图标高度：</td>
    <td nowrap="" class="TableData">
        <input type="text" name="IMG_HEIGHT" class="BigInput" size="10" maxlength="100" value="40">&nbsp;像素&nbsp;(建议高度小于50像素)
    </td>
   </tr>
   <tr>
    <td nowrap="" class="TableData">自定义桌面背景图片：</td>
    <td nowrap="" class="TableData">
        <select name="MYTABLE_BKGROUND">
          <option value="-1">禁止自定义</option>
          <option value="100">限制大小100KB</option>
          <option value="200">限制大小200KB</option>
          <option value="300">限制大小300KB</option>
          <option value="500" selected="">限制大小500KB</option>
          <option value="1024">限制大小1MB</option>
          <option value="2048">限制大小2MB</option>
          <option value="0">不限制大小</option>
        </select> 设置用户自定义桌面背景图片的最大尺寸    </td>
   </tr>
   <tr>
    <td colspan="2" class="TableHeader">界面主题</td>
   </tr>
   <tr>
    <td nowrap="" class="TableData">选择界面主题：</td>
    <td nowrap="" class="TableData">
        <input type="checkbox" name="THEME_SELECT" id="THEME_SELECT" checked=""><label for="THEME_SELECT">允许用户选择界面主题</label>
    </td>
   </tr>
   <tr>
    <td nowrap="" class="TableData">默认界面主题：</td>
    <td nowrap="" class="TableData">
        <select name="THEME">
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
        <input type="checkbox" name="AVATAR_UPLOAD" id="AVATAR_UPLOAD" checked=""><label for="AVATAR_UPLOAD">允许用户上传头像</label>
    </td>
   </tr>
   <tr>
    <td nowrap="" class="TableData">用户上传头像最大宽度：</td>
    <td nowrap="" class="TableData">
        <input type="text" name="AVATAR_WIDTH" class="BigInput" size="10" maxlength="11" value="128">&nbsp;像素    </td>
   </tr>
   <tr>
    <td nowrap="" class="TableData">用户上传头像最大高度：</td>
    <td nowrap="" class="TableData">
        <input type="text" name="AVATAR_HEIGHT" class="BigInput" size="10" maxlength="11" value="128">&nbsp;像素    </td>
   </tr>
  
   <tr>
    <td colspan="2" class="TableHeader">注销提示文字</td>
   </tr>
   <tr>
    <td nowrap="" class="TableData" width="150">用户点击注销时，显示这里设置的文字：</td>
    <td nowrap="" class="TableData">
        <textarea name="LOG_OUT_TEXT" class="BigInput" cols="44" rows="3">您真的要走吗？</textarea><br>
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
        <input type="hidden" name="WEATHER_CITY_NAME" value="0">
        <input type="hidden" name="ATTACHMENT_NAME" value="">
        <input type="hidden" name="ATTACHMENT_NAME1" value="">
        <input type="button" value="确定" class="BigButton" onclick="sendForm();">
    </td>
   </tr>
  
</tbody></table>

<div id="font_family_link_menu" class="attach_div" style="font-size:14px;">
  <a href="javascript:set_font_family('');">默认字体</a>
  <a href="javascript:set_font_family('宋体');" style="font-family:宋体;">宋体</a>
  <a href="javascript:set_font_family('黑体');" style="font-family:黑体;">黑体</a>
  <a href="javascript:set_font_family('楷体');" style="font-family:楷体;">楷体</a>
  <a href="javascript:set_font_family('隶书');" style="font-family:隶书;">隶书</a>
  <a href="javascript:set_font_family('幼圆');" style="font-family:幼圆;">幼圆</a>
  <a href="javascript:set_font_family('Arial');" style="font-family:Arial;">Arial</a>
  <a href="javascript:set_font_family('Courier New');" style="font-family:Courier New;">Courier New</a>
  <a href="javascript:set_font_family('Fixedsys');" style="font-family:Fixedsys;">Fixedsys</a>
  <a href="javascript:set_font_family('Georgia');" style="font-family:Georgia;">Georgia</a>
  <a href="javascript:set_font_family('Tahoma');" style="font-family:Tahoma;">Tahoma</a>
  <a href="javascript:set_font_family('Verdana');" style="font-family:Verdana;">Verdana</a>
</div>
<div id="font_size_link_menu" class="attach_div">
  <a href="javascript:set_font_size('', '大小');">默认大小</a>
  <a href="javascript:set_font_size('10pt', '五号');">五号</a>
  <a href="javascript:set_font_size('12pt', '小四');">小四</a>
  <a href="javascript:set_font_size('14pt', '四号');">四号</a>
  <a href="javascript:set_font_size('15pt', '小三');">小三</a>
  <a href="javascript:set_font_size('16pt', '三号');">三号</a>
  <a href="javascript:set_font_size('18pt', '小二');">小二</a>
  <a href="javascript:set_font_size('22pt', '二号');">二号</a>
  <a href="javascript:set_font_size('24pt', '小一');">小一</a>
  <a href="javascript:set_font_size('26pt', '一号');">一号</a>
</div>
<div id="font_color_link_menu" style="display:none;">
</div>
<div id="font_filter_link_menu" class="attach_div">
  <a href="javascript:set_font_filter('', '效果');">默认效果</a>
  <a href="javascript:set_font_filter('1', '投影');">投影</a>
  <a href="javascript:set_font_filter('2', '发光');">发光</a>
</div>
<div id="font_filter_color_menu" style="display:none;">
</div>
</body>
</body>
</html>
