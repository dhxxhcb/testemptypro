<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>公告查询</title>
		<meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<link rel="stylesheet" type="text/css" href="../lib/laydate.css"/>
		
		<script src="../lib/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/laydate.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
		html,body{width: 100%;height: 100%;font-family: "微软雅黑";font-size: 14px;}
			.inPole{font-size: 14px;}
			textarea{min-width: 30%;min-height: 30px;margin: 5px 5px;}
			.inPole a{display: inline-block;padding: 3px 5px;text-decoration: none;}
			 .add_img .addImg{display: inline-block;width: 20px;height: 10px;overflow: hidden;position: relative;}
			 .add_img .addImg img{height: 100%;}
			 .add_img .addImg .addIcon{position: absolute;top: 0;left: 0;}
			 .add_img .addImg .clearIcon{position: absolute;top: 0;left: -20px;}
		</style>
	</head>
	<body>
		<table class="TableBlock" width="550" align="center" border="1">
		  <form enctype="multipart/form-data" name="form1"></form>
		    <tbody><tr>
		      <td nowrap="" class="TableData">发布人：</td>
		      <td class="TableData">
		        <!--<input type="hidden" name="TO_ID" value="">
		        <textarea cols="35" name="TO_NAME" rows="3" class="BigStatic" wrap="yes" readonly=""></textarea>-->
		        <!--<a href="javascript:;" class="orgAdd">添加</a>
		        <a href="javascript:;" class="orgClear">清空</a>-->
		        <div class="inPole">
								<textarea name="txt" disabled></textarea>
								<span class="add_img">
									<span class="addImg">
										<img src="img/org_select1.png" class="addIcon"/>
									</span>
									<a href="javascript:;" class="Add">添加</a>
								</span>
								<span class="add_img">
									<span class="addImg">
										<img src="img/org_select2.png" class="clearIcon"/>
									</span>
									<a href="javascript:;" class="clear">清除</a>
								</span>
							</div>
		      </td>
		    </tr>
		    <tr>
		      <td nowrap="" class="TableData" width="100"> 格式：</td>
		      <td class="TableData">
		      <select name="FORMAT" class="BigSelect">
		        <option value="" selected="">全部</option>
		        <option value="0">普通格式</option>
		        <option value="1">MHT格式</option>
		       <!--  <option value="2">超级链接</option> -->
		      </select>
		      </td>
		    </tr>
		    <tr>
		      <td nowrap="" class="TableData"> 类型：</td>
		      <td class="TableData">
		        <select name="TYPE_ID" class="BigSelect">
		          <option value="" selected="">全部</option>
		          <option value="01">决定</option>
				  <option value="02">通知</option>
				  <option value="03">通报</option>
				  <option value="04">其他</option>
		        </select>&nbsp;
		      </td>
		    </tr>
		    <tr>
		      <td nowrap="" class="TableData" width="100"> 发布状态：</td>
		      <td class="TableData">
		      <select name="PUBLISH" class="BigSelect">
		        <option value="" selected="">全部</option>
		        <option value="0">未发布</option>
		        <option value="1">已发布</option>
		      </select>
		      </td>
		    </tr>
		    <tr>
		      <td nowrap="" class="TableData" width="100"> 是否置顶：</td>
		      <td class="TableData">
		      <select name="TOP" class="BigSelect">
		        <option value="" selected="">全部</option>
		        <option value="0">未置顶</option>
		        <option value="1">已置顶</option>
		      </select>
		      </td>
		    </tr>
		    <tr>
		      <td nowrap="" class="TableData" width="100"> 标题：</td>
		      <td class="TableData">
		        <input type="text" name="SUBJECT" size="33" maxlength="100" class="BigInput" value="">
		      </td>
		    </tr>
		    <tr>
		      <td nowrap="" class="TableData" width="100"> 发布日期：</td>
		      <td class="TableData">
		        <!-- <input type="text" id="start_time" name="SEND_TIME_MIN" size="12" maxlength="10" class="BigInput" value="" onclick="WdatePicker()"> &nbsp;至&nbsp;         
		        <input type="text" name="SEND_TIME_MAX" size="12" maxlength="10" class="BigInput" value="" onclick="WdatePicker({minDate:'#F{$dp.$D(\'start_time\')}'})"> -->
		        <input class="laydate-icon" id="start"> &nbsp;至&nbsp;
		        <input class="laydate-icon" id="end">
		      </td>
		    </tr>
		    <tr>
		      <td nowrap="" class="TableData" width="100"> 内容：</td>
		      <td class="TableData">
		        <input type="text" name="CONTENT" size="33" maxlength="200" class="BigInput" value="">
		      </td>
		    </tr>
		    <tr>
		      <td nowrap="" class="TableData" width="100"> 生效状态：</td>
		      <td class="TableData">
		      <select name="STAT" class="BigSelect">
		        <option value="" selected="">全部</option>
		        <option value="1">待生效</option>
		        <option value="2">已生效</option>
		        <option value="3">已终止</option>
		      </select>
		      </td>
		    </tr>
		    <tr>
		      <td nowrap="" class="TableData" width="100"> 操作：</td>
		      <td class="TableData">
		        <input type="radio" name="OPERATION" id="OPERATION1" value="1" checked=""><label for="OPERATION1">查询</label>
		        <input type="radio" name="OPERATION" id="OPERATION2" value="2"><label for="OPERATION2">删除</label>
		        <input type="radio" name="OPERATION" id="OPERATION3" value="3"><label for="OPERATION3">导出excel文件</label>
		      </td>
		    </tr>
		    <tr align="center" class="TableControl">
		      <td colspan="2" nowrap="">
		        <input type="submit" value="确定" class="BigButton">&nbsp;&nbsp;
		        <input type="reset" value="重填" class="BigButton">&nbsp;&nbsp;
		      </td>
		    </tr>
		  </tbody>
		</table>
		<script type="text/javascript">
			
			//时间控件调用
			var start = {
			  elem: '#start',
			  format: 'YYYY/MM/DD hh:mm:ss',
			 /* min: laydate.now(), //设定最小日期为当前日期*/
			 /* max: '2099-06-16 23:59:59', //最大日期*/
			  istime: true,
			  istoday: false,
			  choose: function(datas){
			     end.min = datas; //开始日选好后，重置结束日的最小日期
			     end.start = datas; //将结束日的初始值设定为开始日
			  }
			};
			var end = {
			  elem: '#end',
			  format: 'YYYY/MM/DD hh:mm:ss',
			  /*min: laydate.now(),*/
			  /*max: '2099-06-16 23:59:59',*/
			  istime: true,
			  istoday: false,
			  choose: function(datas){
			    start.max = datas; //结束日选好后，重置开始日的最大日期
			  }
			};
			laydate(start);
			laydate(end);//
			
       		$(function(){
       			
       			$('input[type="submit"]').click(function () {
					var typeId=$('select[name="TYPE_ID"] option:checked').val();
					var forMat=$('select[name="FORMAT"] option:checked').val();
					var subject=$('input[name="SUBJECT"]').val();
					var content=$('input[name="CONTENT"]').val();
					var data={
						'typeId':typeId,
						'sendTime':'2017-04-03 10:28:35',
						'subject':subject,
						'content':content,
						'format':forMat
					};
					
					$.ajax({
						type:"get",
						url:"notifyList",
						dataType:'json',
						data:data,
						success:function(){
						/* alert(data.length); */
							console('1223');
						}
					});
				});
       		});
    	</script>
	</body>
</html>

