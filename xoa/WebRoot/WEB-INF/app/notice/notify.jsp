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
    <link rel="stylesheet" type="text/css" href="css/notify.css" />
    <script src="lib/jquery-2.1.4.min.js" type="text/javascript"></script>
   <!--  <script src="js/layer-v3.0.3/layer/layer.js" type="text/javascript" charset="utf-8"></script> -->
    <!-- <script src="js/notify.js" type="text/javascript"></script> -->
    <script type="text/javascript">
    	$(function(){
    		
    			$.ajax({
						type:"get",
						url:"notifyList",
						dataType:'json',
						success:function(obj){
							var data=obj.obj;						
							var str='';
							for(var i=0;i<data.length;i++){
								str+='<tr class="TableLine1"><td nowrap align="center">'+data[i].name+'</td><td nowrap align="center">'+data[i].typeId+'</td><td nowrap align="center">'+data[i].subject+'</td><td class="onTd"><a href="javascript:;">'+data[i].content+'</a></td><td nowrap align="center">'+data[i].sendTime+'</td><td nowrap align="center">'+data[i].format+'</td><td nowrap align="center">'+data[i].readers+'</td><td nowrap><a href="javascript:;" title="查阅情况"> 查阅情况</a>&nbsp;<a href="javascript:;"> 生效</a>&nbsp;<a href="javascript:;" > 修改</a>&nbsp;<a href="javascript:;" class="aBtn"> 删除</a></td></tr>'
							}
							$('.TableHeader').append(str);
						}
				})
    	})
    	
    	/*  function jump () {
    		window.location.href="notice-edit.html";
    	}  */
    </script>
</head>

<body class="bodycolor">

<table border="0" width="95%" cellspacing="0" cellpadding="3" class="small" align="center">
  <tr>
    <td class="Big">
    	<img src="img/notify_open.gif" align="absmiddle">
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
      <th nowrap align="center" style="cursor:pointer;"><u>发布内容</u></th>
      <th nowrap align="center" style="cursor:pointer;"><u>创建时间</u>
      	<img border=0 src="img/arrow_down.gif" width="11" height="10">
      </th>
      <th nowrap align="center" style="cursor:pointer;"><u>生效日期</u></th>
      <th nowrap align="center" style="cursor:pointer;"><u>终止日期</u></th>
      <th nowrap align="center">状态</th>
      <th nowrap align="center">操作</th>
    </tr>

   <!--  <tr class="TableLine1">
      <td>&nbsp;<input type="checkbox" name="email_select" value="25" ></td>
      <td nowrap align="center"><u title="部门：北方测试研究公司" style="cursor:pointer">系统管理员</u></td>
      <td nowrap align="center"></td>
      <td style="cursor:pointer" title="角色：区域销售经理,OA 管理员,

人员：系统管理员">
			<font color=#0000FF><b>角色：</b></font>区域销售经理,OA 管理...<br>
			<font color=#0000FF><b>人员：</b></font>系统管理员<br></td>
      <td class="onTd">
      	<a href="javascript:;" title="" onclick="btnTxt('.div_table')">
      		<font color=red><b>仔细测试一下智能oa公告！！</b> 
      			<img src='img/arrow_up.gif' title='已置顶'>
      		</font>
      	</a> 
      </td>
      <td align="center">2017-01-22 00:00:00</td>
      <td nowrap align="center">2017-01-23</td>
      <td nowrap align="center">2017-02-12</td>
      <td nowrap align="center"><font color='#FF0000'>终止</font></td>
      <td nowrap>
            <a href="javascript:;" title="查阅情况"> 查阅情况</a>&nbsp;
            <a href="javascript:;"> 生效</a>&nbsp;
            <a href="javascript:;" onclick="jump()"> 修改</a>&nbsp;
         	<a href="javascript:;" class="aBtn"> 删除</a>
       </td>
    </tr> -->
    <!-- <tr class="TableLine2">
      <td>&nbsp;<input type="checkbox" name="email_select" value="26" ></td>
      <td nowrap align="center"><u title="部门：北方测试研究公司" style="cursor:pointer">系统管理员</u></td>
      <td nowrap align="center"></td>
      <td style="cursor:pointer" title="" ></td>
      <td class="onTd"><a href="javascript:;" title="" onclick="btnTxt('.div_table')"><font color=red><b>补补</b> <img src='img/arrow_up.gif' title='已置顶'></font></a> 
      </td>
      <td align="center">2017-01-15 00:00:00</td>
      <td nowrap align="center">2017-01-15</td>
      <td nowrap align="center">2017-02-08</td>
      <td nowrap align="center"><font color='#FF0000'>终止</font></td>
      <td nowrap>
            <a href="javascript:;" title="查阅情况"> 查阅情况</a>&nbsp;
            <a href="javascript:;"> 生效</a>&nbsp;
            <a href="javascript:;" > 修改</a>&nbsp;
        	<a href="javascript:;" class="aBtn"> 删除</a>
       </td>
    </tr> -->
   <!--  <tr class="TableLine1">
      <td>&nbsp;<input type="checkbox" name="email_select" value="31" ></td>
      <td nowrap align="center"><u title="部门：北方测试研究公司" style="cursor:pointer">系统管理员</u></td>
      <td nowrap align="center">决定</td>
      <td style="cursor:pointer" title="" ></td>
      <td class="onTd"><a href="javascript:;" title="早在 2006 年，苹果就联合（PRODUCT）RED（由 U2 主唱 Bono 成立的品牌），推出了一款红色配色的第二代 iPod nano，之后苹果又推出了多款印有 （PRODUCT）RED 的 iPod、保护壳、表带、耳机、蓝牙音箱等产品。" onclick="btnTxt('.div_table')"><font color=''>早在 2006 年，苹果就联合（PRODUCT）RED（由 U2 主唱...</font></a> 
      </td>
      <td align="center">2017-03-29 17:45:19</td>
      <td nowrap align="center">2017-03-29</td>
      <td nowrap align="center"></td>
      <td nowrap align="center"><font color=red>未发布</font></td>
      <td nowrap>
            <a href="javascript:;" > 修改</a>&nbsp;
         	<a href="javascript:;" class="aBtn"> 删除</a>
       </td>
    </tr> -->
    <!-- <tr class="TableLine2">
      <td>&nbsp;<input type="checkbox" name="email_select" value="30" ></td>
      <td nowrap align="center"><u title="部门：北方测试研究公司" style="cursor:pointer">系统管理员</u></td>
      <td nowrap align="center">决定</td>
      <td style="cursor:pointer" title="生产一部,生产二部,质检部,北方测试研究公司,北一测试研究院,"><font color=#0000FF><b>部门：</b></font>中国兵器工业信息中心...<br></td>
      <td  class="onTd"><a href="javascript:;" title="苹果又推出了多款印有 （PRODUCT）RED 的 iPod、保护壳、表带、耳机、蓝牙音箱等产品。" onclick="btnTxt('.div_table')"><font color=''>早在 2006 年，苹果就联合（PRODUCT）RED（由 U2 主唱...</font></a> 
      </td>
      <td align="center">2017-03-27 14:29:31</td>
      <td nowrap align="center">2017-03-27</td>
      <td nowrap align="center"></td>
      <td nowrap align="center"><font color='#00AA00'>生效</font></td>
      <td nowrap>
            <a href="javascript:;" title="查阅情况"> 查阅情况</a>&nbsp;
            <a href="javascript:;"> 终止</a>&nbsp;
            <a href="javascript:;" > 修改</a>&nbsp;
         	<a href="javascript:;" class="aBtn"> 删除</a>
      </td>
    </tr> -->
    <!-- <tr class="TableLine1">
      <td>&nbsp;<input type="checkbox" name="email_select" value="29" ></td>
      <td nowrap align="center"><u title="部门：北方测试研究公司" style="cursor:pointer">系统管理员</u></td>
      <td nowrap align="center">通知</td>
      <td style="cursor:pointer" title="角色：财务总监,"><font color=#0000FF><b>角色：</b></font>财务总监,<br></td>
      <td  class="onTd"><a href="javascript:;" title="" onclick="btnTxt('.div_table')"><font color=''>测试界面布局</font></a> 
      </td>
      <td align="center">2017-02-10 10:39:01</td>
      <td nowrap align="center">2017-02-10</td>
      <td nowrap align="center"></td>
      <td nowrap align="center"><font color='#00AA00'>生效</font></td>
      <td nowrap>
            <a href="javascript:;" title="查阅情况"> 查阅情况</a>&nbsp;
            <a href="javascript:;"> 终止</a>&nbsp;
            <a href="javascript:;" > 修改</a>&nbsp;
         	<a href="javascript:;" class="aBtn"> 删除</a>
      </td>
    </tr> -->
   <!--  <tr class="TableLine2">
      <td>&nbsp;<input type="checkbox" name="email_select" value="28" ></td>
      <td nowrap align="center"><u title="部门：北方测试研究公司" style="cursor:pointer">系统管理员</u></td>
      <td nowrap align="center"></td>
      <td style="cursor:pointer" title=""></td>
      <td  class="onTd"><a href="javascript:;" title="" onclick="btnTxt('.div_table')"><font color=''>哈哈哈哈哈哈</font></a> 
      </td>
      <td align="center">2017-01-18 00:00:00</td>
      <td nowrap align="center">2017-01-18</td>
      <td nowrap align="center">2017-01-18</td>
      <td nowrap align="center"><font color='#FF0000'>终止</font></td>
      <td nowrap>
            <a href="javascript:;" title="查阅情况"> 查阅情况</a>&nbsp;
            <a href="javascript:;"> 生效</a>&nbsp;
            <a href="javascript:;" > 修改</a>&nbsp;
         	<a href="javascript:;" class="aBtn"> 删除</a>
       </td>
    </tr> -->
   <!--  <tr class="TableLine1">
      <td>&nbsp;<input type="checkbox" name="email_select" value="27" ></td>
      <td nowrap align="center">
      	<u title="部门：北方测试研究公司" style="cursor:pointer">系统管理员</u>
      </td>
      <td nowrap align="center"></td>
      <td style="cursor:pointer" title=""></td>
      <td  class="onTd"><a href="javascript:;" title="" onclick="btnTxt('.div_table')"><font color=''>哈哈哈</font></a> 
      </td>
      <td align="center">2017-01-16 00:00:00</td>
      <td nowrap align="center">2017-01-16</td>
      <td nowrap align="center">2017-01-16</td>
      <td nowrap align="center"><font color='#FF0000'>终止</font></td>
      <td nowrap>
            <a href="javascript:;" title="查阅情况"> 查阅情况</a>&nbsp;
            <a href="javascript:;"> 生效</a>&nbsp;
            <a href="javascript:;" > 修改</a>&nbsp;
         	<a href="javascript:;" class="aBtn"> 删除</a>
      </td>
    </tr> -->

<tr class="TableControl">
<td colspan="19">
    <input type="checkbox" name="allbox" id="allbox_for" >
    	<label for="allbox_for">全选</label> &nbsp;
	     <a href="javascript:cancel_top('1');" title="批量设置置顶">
	     	<img src="img/add_top.gif" align="absMiddle">设置置顶
	     </a>&nbsp;
	     <a href="javascript:cancel_top('0');" title="批量取消置顶">
	     	<img src="img/cancel_top.gif" align="absMiddle">取消置顶
	     </a>&nbsp;
         <a href="javascript:delete_mail();" title="可删除所选公告中有权限删除的公告通知">
         	<img src="img/delete.gif" align="absMiddle">删除所选公告
         </a>&nbsp;
   		 <a href="javascript:delete_all();" title="可删除所有公告中有权限删除的公告通知">
    		<img src="img/delete.gif" align="absMiddle">删除全部公告
   		 </a>&nbsp;
    </td>
</tr>
</table>
	
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

	<div class="div_table" id="lay" style="display: none;">
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
	</div>

		
</html>
