<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>公告通知</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<link rel="stylesheet" href="css/iconfont.css">
	<link href="js/layer/skin/layer.css" rel="stylesheet">
	<link href="css/laydate.css" rel="stylesheet" />
	<script type="text/javascript" src="js/puck.jquery_bootstrap.js"></script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>
  </head>
  <body>
  		<div>
	    		<form enctype="multipart/form-data" action="<%=basePath%>notifyList"  method="post" name="form1">
	    		<table>
	    			<tr>
	    				<td>类型：</td>
	    				<td>
	    					 <select name="type_id" class="BigSelect">
		         			 	<option value="" >全部</option>
		         			 	<!-- 回显 -->
								<option value="01" <c:if test="${type_id eq '01'}">selected</c:if> >决定</option>
								<option value="02" <c:if test="${type_id eq '02'}">selected</c:if> >通知</option>
								<option value="03" <c:if test="${type_id eq '03'}">selected</c:if> >通报</option>
								<option value="04" <c:if test="${type_id eq '04'}">selected</c:if> >其他</option>
		        			</select>
	    				</td>
	    				<td> 发布日期: </td>
	    				<td>
	    					<input type="text" class="form-control layer-date" readonly="readonly" id="date1" name="date1" 
	    					 value="${date1}" style="width:186px; background-color: #fff;" />
	    				</td>
	    				<td></td>
	    				<td>
	    					<input type="submit" value="查询">
	    					<a href="<%=basePath%>notifyMessage">添加</a>
	    				</td>
	    			</tr>
	    		</table>
	    	</form>
    	</div>
    	<div>
    		<table>
    		 <thead>
    		 	<tr>
    		 		<th>序号</th>
    		 		<th>名称</th>
    		 		<th>时间</th>
    		 		<th>操作</th>
    		 	</tr>
    		 </thead>
    		 <!-- 循环遍历，输出除某个元素以外的元素或输出指定元素。注意：varStatus 表示当前集合的状态。items 用于接收集合对象，var 定义对象接收从集合里遍历出的每一个元素 -->
    		 <c:forEach items = "${list}" var = "n" varStatus="index">
    		  <tr>
    		  	<td>${index.count}</td>
    		    <td>${n.subject}</td>
    		    <td>
    		    	<fmt:formatDate value="${n.sendTime}" pattern="yyyy/MM/dd  HH:mm:ss" />
    		    </td>
    		    <td>
    		    <a href="<%=basePath%>notifyMessage?notfyId=${n.notifyId}">编辑</a>
    		    	<input type="button" onclick = "deleteMessage(${n.notifyId})" value="删除">
    		    </td>
    		  </tr>
    		</c:forEach>
    		</table>
    	</div>
  </body>
  		<!-- layerDate plugin javascript -->
  	<script type="text/javascript" src="js/layer/laydate/laydate.dev.js"></script>
	<script>
		//日期范围限制
		var date1 = {
			elem : '#date1',
			format : 'YYYY-MM-DD',
			max : '2099-06-16', //最大日期
			istime : false,
			istoday : false,
			choose : function(datas) {
				
			}
		};
		laydate(date1);
		
	</script>
	<script>
		function deleteMessage(id){
			$.ajax({
    			url:'<%=basePath%>'+"deleteMessage",
    			type:"post",
    			data:{"id":id},
    			dataType:"json",
    			success:function(result){
    				if(result=="1") {
    					alert("操作成功");
    					window.location.href='<%=basePath%>'+"notifyList";
    				}else {
    				  alert("删除失败、请刷新页面后再次操作");
    				}
    			}
    		});
		}
	</script>
</html>
