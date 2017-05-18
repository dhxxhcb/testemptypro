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
		<%--<link rel="stylesheet" type="text/css" href="../lib/pagination/style/pagination.css"/>--%>
		<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/laydate.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
		<%--<script src="../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>--%>
		<style type="text/css">
			html,body{width: 100%;font-family: "微软雅黑";font-size: 14px;}
			.content{width: 99%;margin: 0 auto;}
			.title{width: 100%;text-align: left;line-height: 40px;}
			/*.tab table tr td{padding: 5px 5px;border-color: #ddd;}*/
			#btn{display: block;margin: 0 auto;width:70px;height:28px;background-color: #f6f6f6;border:#ccc 1px solid;border-radius: 3px;cursor: pointer;text-align: center;line-height: 28px;}
			#btn:hover{background-color: #fff;border-color:bbb;}
			#btn .DIV_Img,#btn .DIV_Txt{float: left}
			#btn .DIV_Img{margin: 3px 5px 3px 10px;}
			#btn .DIV_Txt{height:28px;line-height: 28px;}
			/*.tac table{border-color:#ddd;}*/
			.tac table tr{border: 1px solid #c0c0c0;}
			.tac table tr:nth-child(odd){background-color: #F6F7F9;}
			.tac table tr:nth-child(even){background-color: #fff;}
			.tac table tr th{padding: 10px;border-color: #ddd;font-size:14px;font-weight: normal;color: #2F5C8F;}
			.tac table tr td{padding: 10px;border-color: #ddd;font-size: 12px;text-align:center;}
			.tac table tr td a{text-decoration: none;color:#2B7FE0;}
			.tac table tr td #but{cursor: pointer;}
			.tac table tr:last-of-type td{text-align: right;}
			.Hover td img{width: 16px;}
			.Hover td:last-of-type img{width: 18px}
			.tac table .Hover:hover{background-color: #dbecff;}
			.title{height: 60px;width:100%;}
			.title .title_img img{width: 23px;margin-right:10px;float: left;margin-top: 9px;}
			.title .div_span{font-size: 22px;float: left;}
			.tab{width: 100%}
			.tab table{margin:0 auto;}
			.tab table tr{border: 1px solid #c0c0c0;}
			.tab table tr td,.tab table tr th{padding: 10px;}
			.tab table tr td{border-right: 1px solid #c0c0c0;}
			.tab table tr td input{height: 22px;}
			.tab table tr td select{height: 25px;}
			.M-box3{margin-top:10px;float:right;margin-right: 7px;}
			.M-box3 a{margin: 0 3px;width: 29px;height: 29px;line-height: 29px;font-size: 12px;text-decoration: none;}
			.M-box3 .active{margin: 0px 3px;width: 29px;height: 29px;line-height: 29px;background: #2b7fe0;font-size: 12px;border: 1px solid #2b7fe0;}
			.jump-ipt{margin: 0 3px;width: 29px;height: 29px;line-height: 29px;font-size: 12px;}
			.M-box3 a:hover{background: #2b7fe0;}
		</style>
	</head>
	<body>
		<div class="content">
			<div class="title">
				<div class="title_img">
					<img src="../img/icon_QUERY.png">
				</div>
				<div class="div_span"><fmt:message code="email.title.querymail" /></div>
			</div>
			<div class="tab">
				<form action="" method="get">
					<table cellspacing="0" cellpadding="0" width="60%" style="border-collapse:collapse;background-color: #fff">
						<tr>
						<th colspan="2" style="text-align: center;background-color: #3691DA;color: #fff;font-weight: normal;">输入查询条件</th>
					</tr>
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
								<div name="btn" id="btn" >
									<div class="DIV_Img"><img src="../img/icon_refer.png" alt=""></div>
									<div class="DIV_Txt"><fmt:message code="global.lang.query" /></div></div>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="tac" style="display:none;">
					<table cellspacing="0" cellpadding="0" style="border-collapse:collapse;width:99%;">
						<tr class='befor'>
							<th width="6%">
								<input type="checkbox" name="checkbox" id="checkbox" value="" />
							</th>
							<th width="6%"><fmt:message code="notice.th.state" /></th>
							<th width="6%"><fmt:message code="email.th.sign" /></th>
							<th width="16%"><fmt:message code="email.th.sender" /></th>
							<th width="40%" class="theme"><fmt:message code="email.th.main" /></th>
							<th width="16%"><fmt:message code="global.lang.date" /></th>
							<th width="10%"><fmt:message code="email.th.file" /></th>
						</tr>
						<tr>
							<td colspan="7">
								<div class="M-box3"></div>
								<input type="button" name="but" id="but" value="返回">
							</td>
						</tr>
					</table>
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
                    $('.tac').find('.Hover').remove();
					$('.tab').css('display','none');
					$('.tac').css('display','block');
					var ATTR=$('.BigSelect option:checked').attr('ATTR');
					var startTime=$('#start').val();
					var endTime=$('#end').val();
					var Title=$('#txt2').val();
					var cont=$('#txt3').val();
					var Attach=$('#txt6').val();
					//alert(ATTR);
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
								var str='';

								for(var i=0;i<data1.length;i++){
										var sendTime=new Date((data1[i].sendTime)*1000).Format('yyyy-MM-dd');
										if(data1[i].emailList[0].readFlag==1){
											if(data1[i].attachmentId!=''){
												str+='<tr class="Hover"><td><input type="checkbox" name="checkbox" id="checkbox" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:left;"><a href="javascript:;">'+data1[i].subject+'</a></td><td>'+sendTime+'</td><td><img src="../img/icon_accessory_03.png"/></td></tr>';
											}else{
												str+='<tr class="Hover"><td><input type="checkbox" name="checkbox" id="checkbox" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:left;"><a href="javascript:;">'+data1[i].subject+'</a></td><td>'+sendTime+'</td><td>&nbsp</td></tr>';
											}
											
										} else if(data1[i].emailList[0].readFlag==0){
											if(data1[i].attachmentId!=''){
												str+='<tr class="Hover"><td><input type="checkbox" name="checkbox" id="checkbox" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:left;"><a href="javascript:;">'+data1[i].subject+'</a></td><td>'+sendTime+'</td><td><img src="../img/icon_accessory_03.png"/></td></tr>';
											}else{
												str+='<tr class="Hover"><td><input type="checkbox" name="checkbox" id="checkbox" value="" /></td><td><img src="../img/icon_read_2_03.png"/></td><td width="6%"><img src="../img/icon_star_kong_03.png"/></td><td width="6%">'+data1[i].users.userName+'</td><td class="theme_a" style="text-align:left;"><a href="javascript:;">'+data1[i].subject+'</a></td><td>'+sendTime+'</td><td>&nbsp</td></tr>';
											}
										}
										
									}
									$('.befor').after(str);
							}
					})
				})
				
				$('#but').click(function(){
					$('.tac').find('.Hover').remove();
					$('.tac').css('display','none');
					$('.tab').css('display','block');
				})

                //分页
                function initPagination(totalData,pageSize){
                    $('.M-box3').pagination({
                        totalData:totalData, //数据总条数
                        showData:pageSize,   //每页条目数
                        jump:true,
                        coping:true,
                        homePage:'<fmt:message code="global.page.first" />',
                        endPage:'<fmt:message code="global.page.last" />',
                        prevContent:'<fmt:message code="global.page.pre" />',
                        nextContent:'<fmt:message code="global.page.next" />',
                        jumpBtn:'<fmt:message code="global.page.jump" />',
                        callback:function(index){
                            data.page = index.getCurrent();
                            console.log(index.getCurrent());
                            HVersion();
                        }
                    });
                }
			})
			
			
			
		</script>
	</body>
</html>

