<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!-- saved from url=(0069)file:///C:/Users/gaosubo/Desktop/OA%E7%B2%BE%E7%81%B5_files/menu.html -->
<html><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <script type="text/javascript" src="../js/jquery-1.11.1.min.js">    </script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
     <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/spirit/ipanel.css">
    <link rel="stylesheet" type="text/css" href="../css/spirit/menu.css">
</head>
<body>
	<div class="wrap">
		<div class="body_top">
			<ul>
				<li>
					<span class="bg_icon icon1"></span>
				</li>
				<li>
					<span class="bg_icon icon2">
				</li>
				<li>
					<span class="bg_icon icon3">
				</li>
			</ul>
		</div>
		<div class="connect">
			<div class="li_0 li_li">
				<div class="app_head">
					<span class="tip_font">应用</span>
					<div class="tips">
						<sapn class="fresh_icon" title="刷新"></sapn>
						<span class="add_icon" title="添加应用"></span>
					</div>
				</div>
				<div class="app_connect yiji">
					<ul>
						<li>
							<div><span  class="head_pic"><img src="" alt=""/></span>
							<span title="yingyongmingcheng" class="yiji_title">个人设置</span>
							<span class="dianji"></span></div>
								<div>
									<ul>
										<li>
											<div><span  class="head_pic"><img src="" alt=""/></span>
							<span title="yingyongmingcheng" class="yiji_title">个人设置</span>
							<span class="dianji"></span></div>
											<div>
												<ul>
													<li>
							<div><span  class="head_pic"><img src="" alt=""/></span>
							<span title="yingyongmingcheng" class="yiji_title">个人设置</span>
							<span class="dianji"></span></div>
						</li>
												</ul>
											</div>
										</li>
									</ul>
								</div>
							
						</li>
						<li>
							<div><span  class="head_pic"><img src="" alt=""/></span>
							<span title="yingyongmingcheng" class="yiji_title">个人设置</span>
							<span class="dianji"></span></div>
						</li>
						<li>
							<div><span  class="head_pic"><img src="" alt=""/></span>
							<span title="yingyongmingcheng" class="yiji_title">个人设置</span>
							<span class="dianji"></span></div>
						</li>
					</ul>
				</div>
			</div>
			<div class="li_1 li_li cosp">
				<div>222</div>
			</div>
			<div class="li_2 li_li cosp">
				<div>333</div>
			</div>
		</div>
	
	</div>
</body>
<!--  <script type="text/javascript" src="js/utility.js"></script>
<script type="text/javascript" src="file:///C:/static/js/ispirit.js"></script>
<script type="text/javascript" src="js/ispirit.js"></script>-->


<script language="JavaScript">
	$.ajax({
	     url:'<%=basePath%>/showMenu',
	     type:'get',      
	     dataType:'json',
	     success:function(obj){
	     	console.log(obj.obj);
	     	if(obj.msg=='ok'){
	     		var obj=obj.obj;
	     		var li='';
	     		if(obj!=''){
	     			for(var i=0;i<obj.length;i++){
	     				var fchild=obj[i].child;
	     				li+='<li onclick="ss()"><div class="yiji_title "><span  class="head_pic"><img src="" alt=""/></span><span title="'+obj[i].name1+'" id="'+obj[i].id+'" class="appname">'+obj[i].name+'</span><span class="dianji"></span></div>';
	     				if(fchild.length!=0){
	     					li+='<div class="erji"><ul>';
	     					for(var j=0;j<fchild.length;j++){
	     						var schild=fchild[j].child;
	     						if(fchild[j].child!=''){
	     							li+='<li url="'+fchild[j].url+'"><div class="yiji_title"><span  class="head_pic"><img src="" alt=""/></span><span title="'+fchild[j].name1+'" id="'+fchild[j].id+'"  class="appname">'+fchild[j].name+'</span><span class="dianji"></span></div><div class="sanji"><ul>';
	     							for(var z=0;z<schild.length;z++){
	     								li+='<li url="'+schild[z].url+'"><div class="yiji_title"><span  class="head_pic"><img src="" alt=""/></span><span title="'+schild[z].name1+'" id="'+schild[z].id+'"  class="appname">'+schild[z].name+'</span></div></li>';
	     							}
	     							li+='</ul></div>';
	     						}else{
	     							li+='<li url="'+fchild[j].url+'"><div class="yiji_title"><span  class="head_pic"><img src="" alt=""/></span><span title="'+fchild[j].name1+'" id="'+fchild[j].id+'"  class="appname">'+fchild[j].name+'</span></div></li>';
	     						}
	     					}
	     					li+='</ul></div>';
	     				}
	     				li+='</li>';
	     			}
	     			$(".app_connect ul").html(li);
	     		}
	     	}else{
	     		document.write='可能除了点问题';
	     	}
	     	 
		 }
		
	});
	
	   	function ss(){
	   		/* alert("1"); */
	   	}
	   
</script>
<script language="JavaScript">
	$(function(){
		/***应用/组织/便签跳转***/
	   $(".body_top ul li").click(function(){
	   		var i=$(this).index();
	   		$(".connect div.li_"+i).removeClass("cosp").siblings("div").addClass('cosp');
	   });
	   /***应用二三级菜单展示隐藏***/
	   /* 	$(".app_connect ul li").click(function(){
	   		alert("des");
	   	}); */
	   	$(".app_connect ul ").on('click','li .yiji_title ',function(){
	   			alert("des");
	   		});		
	
	});
	
</script>
</html>