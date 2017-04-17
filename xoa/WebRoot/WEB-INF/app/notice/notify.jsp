<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html><!--<![endif]-->
 <head>
    <title>公告通知</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<link rel="stylesheet" type="text/css" href="../lib/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../css/notify.css" />
    <script src="../lib/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/laydate.js" type="text/javascript" charset="utf-8"></script>
   <!--  <script src="../js/layer-v3.0.3/layer/layer.js" type="text/javascript" charset="utf-8"></script> -->
    <!-- <script src="../js/notify.js" type="text/javascript"></script> -->
    <style type="text/css">
    	#noticeQuery{width: 100%;}
    	.TableBlock{background-color:#fff;border-color:#aaa;}
    	.inPole{font-size: 14px;}
		textarea{min-width: 30%;min-height: 30px;margin: 5px 5px;}
		.inPole a{display: inline-block;padding: 3px 5px;text-decoration: none;}
		.add_img .addImg{display: inline-block;width: 20px;height: 10px;overflow: hidden;position: relative;}
		.add_img .addImg img{height: 100%;}
		.add_img .addImg .addIcon{position: absolute;top: 0;left: 0;}
		.add_img .addImg .clearIcon{position: absolute;top: 0;left: -20px;}
		#noRead{width: 100%;}
		#noRead span{display: block;width: 50%;margin: 20px auto;padding: 20px 20px;font-size: 25px;text-align: center;background-color: #6fb4fa;color: #fff;}
		.title{font-size: 16px;color: #124164;font-weight: bold;margin-top:20px;margin-left:20px;display: inline-block;}
		
    </style>
    <script type="text/javascript">
    	$(function(){
    			var data1={
    				"page":1,
    				"pageSize":10,
    				"useFlag":true
    			};
    			$.ajax({
						type:'get',
						url:'notifyList',
						dataType:'json',
						data:data1,
						success:function(rsp){
							var data=rsp.obj;	
							console.log(data[0].name);				
							var str='';
							for(var i=0;i<data.length;i++){
								str+='<tr class="TableLine1"><td nowrap align="center">'+data[i].name+'</td><td nowrap align="center">'+data[i].typeId+'</td><td nowrap align="left"><a href="javascript:;">'+data[i].subject+'</a></td><td nowrap align="center">'+data[i].sendTime+'</td><td nowrap align="center">'+data[i].format+'</td><td nowrap><a href="javascript:;" title="查阅情况"> 查阅情况</a>&nbsp;<a href="javascript:;"> 生效</a>&nbsp;<a href="javascript:;" > 修改</a>&nbsp;<a href="javascript:;" class="aBtn" onclick="delate('+data[i].notifyId+')"> 删除</a></td></tr>';
								str1='<input type="hidden" id="'+data[i].notifyId+'">';
							}
							$('.TableHeader').after(str+str1); 
						}
				});
				
				$('.muJump ul li').click(function () {
	    			var index=$(this).index();
	    			$('.muJump ul li').removeClass('jumpOn');
	    			$(this).addClass('jumpOn');
	    			$('.content>div').eq(index).show().siblings().hide();
	    			
	    			if($('.content>div').eq(0).css('display')=='block'){
	    				$.ajax({
								type:'get',
								url:'unreadNotify',
								dataType:'json',
								data:data1,
								success:function(rsp){
									var data=rsp.flag;
									//alert(data);
									if(data==false){
										var timer=setTimeout(function(){
											$('.content>div').eq(1).show();
											$('.content>div').eq(0).hide();
											$('.muJump ul li').eq(1).addClass('jumpOn').siblings().removeClass('jumpOn');
											clearTimeout(timer);
										},2000);
										
									}else{
										alert('有数据');
									}
								}
						});
	    			}
	    			
	    		});
	    		
	    		
	    		
    	});
    	
    	function delate(id){
    		var msg='是否确认删除?';
    		if (confirm(msg)==true){ 
			  	
			  	 $.ajax({
						type:'get',
						url:'deleteById',
						dataType:'json',
						data:{'id':id},
						success:function(){
							
							location.reload();
						}
				}); 
				return true;
			 }else{ 
			 	return false; 
			 } 	
    	}    	
    	
    	
    	
    </script>
</head>

<body class="bodycolor">
<div class="muJump">
	<ul>
		<li><a href="javascript:;">未读公告</a></li>
		<li class="jumpOn"><a href="javascript:;">公告通知</a></li>
		<li><a href="javascript:;">公告查询</a></li>
	</ul>
</div>
<div class="content">
	<!-- 未读公告 -->
	<div id="noRead" style="display: none;">
		<table border="0" width="95%" cellspacing="0" cellpadding="3" class="small" align="center">
			<tr>
				<td>
					<div class="title">未读公告</div>
					<select name="TYPE" class="BigSelect" onChange="change_type(this.value);">
			          	<option value="0" selected>所有类型</option>
			         	<option value="01">决定</option>
						<option value="02">通知</option>
						<option value="03">通报</option>
						<option value="04">其他</option>
			          	<option value="05">无类型</option>
			       </select>
				</td>
				
			</tr>
			
		</table>
		<span>没有未读公告，2秒后自动跳到公告通知</span>
	</div>
	<!-- 公告通知 start -->
	<div id="notify" style="overflow-y: scroll;display:block;">
		<table border="0" width="95%" cellspacing="0" cellpadding="3" class="small" align="center">
		  <tr>
		    <td class="Big">
		    	<img src="../img/notify_open.gif" align="absmiddle">
		    	<span class="big3">公告通知</span>&nbsp;
		       <select name="TYPE" class="BigSelect" onChange="change_type(this.value);">
		          	<option value="0" selected>所有类型</option>
		         	<option value="01">决定</option>
					<option value="02">通知</option>
					<option value="03">通报</option>
					<option value="04">其他</option>
		          	<option value="05">无类型</option>
		       </select>
		    </td>
		    <!--<td align="center" ><input type="button" class="BigButton" onClick="window.open('new.php')" value=新建公告 ></td>-->
		    <td align="right" valign="bottom" class="small1">
		    	<div id="pageArea" class="pageArea">
					第<span id="pageNumber" class="pageNumber">1/1</span>页
					<a href="javascript:;" id="pageFirst" class="pageFirstDisable" title="首页"></a>
					  <a href="javascript:;" id="pagePrevious" class="pagePreviousDisable" title="上一页"></a>
					  <a href="javascript:;" id="pageNext" class="pageNextDisable" title="下一页"></a>
					  <a href="javascript:;" id="pageLast" class="pageLastDisable" title="末页"></a>
					  转到 第 <input type="text" size="3" class="SmallInput" name="page_no" id="page_no" onkeypress="input_page_no()" style='text-align:center;'> 页 
					  	<a href="javascript:goto_page();" id="pageGoto" class="pageGoto" title="转到"></a>
		    	</div>
		    </td>
		  </tr>
		</table>
		<table class="TableList" width="95%" align="center" cellspacing="0" cellpadding="0">
		  <tr class="TableHeader">
		     <!--  <th nowrap align="center">选择</th> -->
		      <th nowrap align="center">发布人</th>
		      <th nowrap align="center">类型</th>
		      <th nowrap align="center">标题</th>
		   
		      <th nowrap align="center" style="cursor:pointer;"><u>创建时间</u>
		      	<img border=0 src="../img/arrow_down.gif" width="11" height="10">
		      </th>
		      <!-- <th nowrap align="center" style="cursor:pointer;"><u>生效日期</u></th>
		      <th nowrap align="center" style="cursor:pointer;"><u>终止日期</u></th> -->
		      <th nowrap align="center">状态</th>
		      <th nowrap align="center">操作</th>
		    </tr>
		</table>
	</div> <!-- end -->
	
	<!-- 公告查询 -->
	<div id="noticeQuery" style="display: none;">
		<div class="title">公告通知查询</div>
		<table class="TableBlock" width="50%" align="center" border="1" style="margin: 20px auto;">
			  <form enctype="multipart/form-data" name="form1"></form>
			    <tbody><tr>
			      <td nowrap="" class="TableData">发布人：</td>
			      <td class="TableData">
			        <div class="inPole">
									<textarea name="txt" disabled></textarea>
									<span class="add_img">
										<span class="addImg">
											<img src="../img/org_select1.png" class="addIcon"/>
										</span>
										<a href="javascript:;" class="Add">添加</a>
									</span>
									<span class="add_img">
										<span class="addImg">
											<img src="../img/org_select2.png" class="clearIcon"/>
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
			        <option value="0" selected="">全部</option>
			        <option value="1">普通格式</option>
			        <option value="2">MHT格式</option>
			        <!--<option value="2">超级链接</option>-->
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
	</div><!-- end -->
	
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
			laydate(end);
			
			$(function(){
       			
       			$('input[type="submit"]').click(function () {
       				//alert('123');
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
					alert(data.typeId);
					$.ajax({
						type:"get",
						url:"notifyList",
						dataType:'json',
						data:data,
						success:function(){
							//alert(data.typeId);
							
						}
					});
				});
       		});
</script>

	<!-- <script type="text/javascript">
		
		function btnTxt (cName,sName) {
		  layer.open({
		  title:['公告详情','text-align: center;'],
		  type: 1,
		  area: ['600px', '360px'],
		  shadeClose: true, //点击遮罩关闭
		  content: $('#lay')
		  });

		}
	</script> -->
	
	
	
</body>

	<!-- <div class="div_table" id="lay" style="display: none;">
		<table class="TableBlock no-top-border " align="center" width="90%" cellspacing="0" cellpadding="0">
		   <tbody>
		   	<tr>
			   <td style="padding:0px" width="100%"> 
				     <table class="TableTop" cellpadding="0" width="100%" cellspacing="0">
				        <tbody>
					      	<tr>        
					        	<td class="center" width="100%">仔细测试一下智能oa公告！！</td>       
					     	</tr>
				    	</tbody>
				     </table>
			 	</td>
			 </tr>
		    <tr>
		      <td class="TableContent" align="right">
				      发布部门：<u title="部门：北方测试研究公司" style="cursor:hand">北方测试研究公司</u>&nbsp;&nbsp;
				     发布人：<u title="部门：北方测试研究公司" style="cursor:hand">系统管理员</u>&nbsp;&nbsp;
				      发布于：<i>2017-01-23</i>&nbsp;&nbsp;
		       </td>
		    </tr>
		    <tr>
		      <td colspan="2" class="rich-content content" style="height:300;font-size:12pt;" valign="top">
		好的好的  <br><br>
				<span id="showKeyword" class="small1"><a href="javascript:get_keyword();" class="A1" id="B1">显示本文关键词</a></span></td>
		   </tr>
		  </tbody>
		</table>
	</div> -->

		
</html>