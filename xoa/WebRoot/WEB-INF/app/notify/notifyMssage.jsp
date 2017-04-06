<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公告通知查询</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
   <script type="text/javascript" src="js/puck.jquery_bootstrap.js"></script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>


  </head>
  

<body class="bodycolor">
<table border="0" width="90%" cellspacing="0" cellpadding="3" class="small">
  <tr>
    <td class="Big"><span class="big3"> 公告通知</span>
    </td>
  </tr>
</table>

<!-- form 表单设置enctype="multipart/form-data"后获取参数 -->
  <form action="addNotify"  method="post" id="notifyFrom">
  	<input type="hidden" id = "id" name = "id" value="${notify.notifyId}"/>
		<table class="TableBlock" width="550" align="center">
	    <tr>
	      <td nowrap class="TableData">发布人：</td>
	      <td class="TableData">
	        <input type="hidden" name="TO_ID" value="">
	        <textarea cols=35 name="TO_NAME" rows="3" class="BigStatic" wrap="yes" readonly></textarea>
	        <!-- <a>标签是超链接，也就是链接页面或者跳转页面用的 -->
	        <a href="javascript:;" class="orgAdd" onClick="SelectUser('4','','TO_ID', 'TO_NAME')">添加</a>
	        <a href="javascript:;" class="orgClear" onClick="ClearUser('TO_ID', 'TO_NAME')">清空</a>
	      </td>
	    </tr>
	    <tr>
	      <td nowrap class="TableData" width="100"> 格式：</td>
	      <td class="TableData">
	      <select name="FORMAT" class="BigSelect">
	        <option value="" selected>全部</option>
	        <option value="0">普通格式</option>
	        <option value="1">MHT格式</option>
	      </select>
	      </td>
	    </tr>
	    <tr>
	      <td nowrap class="TableData"> 类型：</td>
	      <td class="TableData"> 
	        <select name="TYPE_ID" class="BigSelect">
	          <option value="" selected>全部</option>
					<option value="01">决定</option>
					<option value="02">通知</option>
					<option value="03">通报</option>
					<option value="04">其他</option>
	        </select>&nbsp;
	      </td>
	    </tr>
	    <tr>
	      <td nowrap class="TableData" width="100"> 标题：</td>
	      <td class="TableData">
	        <input type="text" id = "subject" name="subject" size="33" maxlength="100" class="BigInput" value="${notify.subject}">
	      </td>
	    </tr>
	    <tr>
	      <td nowrap class="TableData" width="100"> 发布日期：</td>
	      <td class="TableData">
	        <input type="text" name="SEND_TIME_MIN" id="start_time" size="12" maxlength="10" class="BigInput" value="" onClick="WdatePicker()"/> 至&nbsp;
	        <input type="text" name="SEND_TIME_MAX" id="end_time" size="12" maxlength="10" class="BigInput" value="" onclick="WdatePicker({minDate:'#F{$dp.$D(\'start_time\')}'})"/>
	      </td>
	    </tr>
	    <tr>
	      <td nowrap class="TableData" width="100"> 内容：</td>
	      <td class="TableData">
	        <input type="text" name="CONTENT" size="33" maxlength="200" class="BigInput" value="">
	      </td>
	    </tr>
	    <tr align="center" class="TableControl">
	      <td colspan="2" nowrap>
	        <input type="button" value="保存" onclick="save()" class="BigButton">&nbsp;&nbsp;
	         
	      </td>
	     
	    </tr>
      </table>
    </form>
  </body>
  <script type="text/javascript" >
	   function save(){
	   		$.ajax({
    			url:'<%=basePath%>'+"addNotify",
    			type:"post",
    			<!-- serialize(),要求点一个按钮就将页面一的表单的值存起来，在页面二点击按钮将刚才保存的值分别在对应的框中弄出来 -->
    			data:$('#notifyFrom').serialize(),
    			<!-- java解析json,服务器端将数据转换成json字符串,客户端将json字符串转换为相应的javaBean,获取javaBean -->
    			dataType:"json",
                success: function(data) {
	                if(data==1){
	                	alert("成功");
	                	setTimeout(ss(),"500");
	                }else{
	                  alert("失败");
	                }
                }
            });
	   }
	   function ss(){
	   		window.location.href='<%=basePath%>'+"notifyList";
	   }
	</script>
</html>
