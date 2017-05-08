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
		<title><fmt:message code="email.title.mailquery" /></title><!-- 邮件查询 -->
		<link rel="stylesheet" type="text/css" href="../lib/laydate.css"/>
		<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/laydate.js" type="text/javascript" charset="utf-8"></script>
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
			<div class="title"><fmt:message code="email.title.querymail" /></div>
			<div class="tab">
				<form action="" method="get">
					<table border="1" cellspacing="0" cellpadding="0" width="99%">
						<tr>
							<td><fmt:message code="email.th.maillist" />：</td>
							<td>
								<input type="radio" name="COPY_TIME" value="" id="COPY_TIME" checked="">
								<label for="COPY_TIME"><fmt:message code="email.th.nowmaillist" /></label>
							</td>
						</tr>
						<tr>
							<td><fmt:message code="email.th.chosebox" />：</td>
							<td>
								<select name="BOX" class="BigSelect">
							        <option value="1" ATTR="inbox"><fmt:message code="email.title.inbox" /></option>
							        <option value="2" ATTR="drafts"><fmt:message code="email.title.draftbox" /></option>
							        <option value="3" ATTR="outbox"><fmt:message code="email.title.sent" /></option>
							        <option value="4" ATTR="recycle"><fmt:message code="email.title.wastebasket" /></option>
						        </select>
							</td>
						</tr>
						<tr>
							<td><fmt:message code="email.th.mailtype" />：</td>
							<td>
								<select name="READ_FLAG" class="BigSelect">
						          	<option value=""><fmt:message code="email.th.own" /></option>
						          	<option value="0"><fmt:message code="email.th.unread" /></option>
						         	<option value="1"><fmt:message code="email.th.read" /></option>
						        </select>
							</td>
						</tr>
						<tr>
							<td><fmt:message code="global.lang.date" />：</td>
							<td>
								<input class="laydate-icon" id="start"> &nbsp;<fmt:message code="global.lang.to" />&nbsp;
								<input class="laydate-icon" id="end">
							</td>
						</tr>
						<tr>
							<td><fmt:message code="email.th.sender" />：</td>
							<td>
								<input type="text" name="txt" id="txt1" value="" />
							</td>
						</tr>
						<tr>
							<td><fmt:message code="email.th.mailmajor" />：</td>
							<td>
								<input type="text" name="txt" id="txt2" value="" />
							</td>
						</tr>
						<tr>
							<td><fmt:message code="email.th.mailcontent" />：</td>
							<td>
								<input type="text" name="txt" id="txt3" value="" />
							</td>
						</tr>
						<!-- <tr>
							<td><fmt:message code="email.th.mailcontent" />：</td>
							<td>
								<input type="text" name="txt" id="txt4" value="" />
							</td>
						</tr>
						<tr>
							<td><fmt:message code="email.th.mailcontent" />：</td>
							<td>
								<input type="text" name="txt" id="txt5" value="" />
							</td>
						</tr> -->
						<tr>
							<td><fmt:message code="email.th.filefolder" />：</td>
							<td>
								<input type="text" name="txt" id="txt6" value="" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" name="btn" id="btn" value="<fmt:message code="global.lang.query" />" />
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
			
			$(function(){
				$('#btn').click(function(){
					var ATTR=$('.BigSelect option:checked').attr('ATTR');
					var startTime=$('#start').val();
					var endTime=$('#end').val();
					var Title=$('#txt2').val();
					var cont=$('#txt3').val();
					var Attach=$('#txt6').val();
					//alert(Title+':::::'+cont+'::::::'+Attach);
					var data={
						'flag':ATTR,
						'page':1,
						'pageSize':10,
						'useFlag':true,
						'userID':'admin',
						'startDate':startTime,
						'endDate':endTime,
						'subject':Title,
						'content':cont,
						'attachmentName':Attach
					}
					$.ajax({
							type:'get',
							url:'showEmail',
							dataType:'json',
							data:data,
							success:function(rsp){
								var data1=rsp.obj;
							}
					}) 
				})
			})
			
			
			
		</script>
	</body>
</html>

