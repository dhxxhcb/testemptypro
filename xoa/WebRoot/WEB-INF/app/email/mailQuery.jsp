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
		<title>邮件查询</title>
		<link rel="stylesheet" type="text/css" href="css/laydate.css"/>
		<script src="js/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/laydate.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			html,body{width: 100%;font-family: "微软雅黑";font-size: 14px;}
			.content{width: 600px;margin: 0 auto;}
			.title{width: 100%;text-align: center;line-height: 40px;}
			table tr td{padding: 5px 5px;border-color: #ddd;}
			#btn{display: block;margin: 0 auto;outline: none;border: none;border-radius: 3px;padding: 3px 8px;cursor: pointer;}
			#btn:hover{background-color: #9fbdee;color: #fff;}
		</style>
	</head>
	<body>
		<div class="content">
			<div class="title">查询邮件</div>
			<div class="tab">
				<form action="" method="get">
					<table border="1" cellspacing="0" cellpadding="0" width="99%">
						<tr>
							<td>邮件表：</td>
							<td>
								<input type="radio" name="COPY_TIME" value="" id="COPY_TIME" checked="">
								<label for="COPY_TIME">当前邮件表</label>
							</td>
						</tr>
						<tr>
							<td>选择邮箱：</td>
							<td>
								<select name="BOX" class="BigSelect">
							        <option value="1">收件箱</option>
							        <option value="2">草稿箱</option>
							        <option value="3">已发送</option>
							        <option value="4">废纸篓</option>
						        </select>
							</td>
						</tr>
						<tr>
							<td>邮件状态：</td>
							<td>
								<select name="READ_FLAG" class="BigSelect">
						          	<option value="">所有</option>
						          	<option value="0">未读</option>
						         	<option value="1">已读</option>
						        </select>
							</td>
						</tr>
						<tr>
							<td>日期：</td>
							<td>
								<input class="laydate-icon" id="start"> &nbsp;至&nbsp;
								<input class="laydate-icon" id="end">
							</td>
						</tr>
						<tr>
							<td>发件人：</td>
							<td>
								<input type="text" name="txt" id="txt" value="" />
							</td>
						</tr>
						<!-- <tr>
							<td>邮件关键词：</td>
							<td>
								<input type="text" name="txt" id="txt" value="" />
							</td>
						</tr> -->
						<tr>
							<td>邮件主题包含文字：</td>
							<td>
								<input type="text" name="txt" id="txt" value="" />
							</td>
						</tr>
						<tr>
							<td>邮件内容[查询词1]：</td>
							<td>
								<input type="text" name="txt" id="txt" value="" />
							</td>
						</tr>
						<tr>
							<td>邮件内容[查询词2]：</td>
							<td>
								<input type="text" name="txt" id="txt" value="" />
							</td>
						</tr>
						<tr>
							<td>邮件内容[查询词3]：</td>
							<td>
								<input type="text" name="txt" id="txt" value="" />
							</td>
						</tr>
						<tr>
							<td>附件文件名包含文字：</td>
							<td>
								<input type="text" name="txt" id="txt" value="" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" name="btn" id="btn" value="查询" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
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
			     end.start = datas //将结束日的初始值设定为开始日
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
			laydate(end);
		</script>
	</body>
</html>

