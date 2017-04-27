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
				<div class="app_connect yiji">
					<ul></ul>
				</div>
	</div>
</body>
 <script type="text/javascript" src="/js/utility.js"></script>

<script type="text/javascript" src="../js/ispirit.js"></script>


<script language="JavaScript">
	var menu = {
		"email":"email/index",
		"notify_show":"notice/index",
		"news_show":"news/index",
		"file_folder/index2.php":"fileHome",
		"system/file_folder":"showFileBySort_id",
		"diary_show":"diary/index",
		"news_manage":"news/manage",
		"notify_manage":"notice/manage",
		"knowledge_management":"file/home",
		"system_file_folder":"file/setIndex"
	};
	$.ajax({
	     url:'<%=basePath%>/showMenu',
	     type:'get',      
	     dataType:'json',
	     success:function(obj){
	     	if(obj.msg=='ok'){
	     		var obj=obj.obj;
	     		var li='';
	     		if(obj!=''){
	     			for(var i=0;i<obj.length;i++){
	     				var fchild=obj[i].child;
	     				li+='<li><div class="yiji_title"><span  class="head_pic"><img src="../img/main_img/'+obj[i].img+'.png" alt="img"/></span><span title="'+obj[i].name1+'" id="'+obj[i].id+'" class="appname">'+obj[i].name+'</span><span class="dianji before"></span></div>';
	     				if(fchild.length!=0){
	     					li+='<div class="erji common"><ul>';
	     					for(var j=0;j<fchild.length;j++){
	     						var schild=fchild[j].child;
	     						if(fchild[j].child!=''){
	     							li+='<li ><div class="yiji_title" url="'+fchild[j].url+'" onClick="opennew(this)"><span  class="head_pic"><img src="../img/main_img/hei.png" alt="erimg"/></span><span title="'+fchild[j].name1+'" id="'+fchild[j].id+'"  class="appname">'+fchild[j].name+'</span><span class="dianji before"></span></div><div class="sanji common"><ul>';
	     							for(var z=0;z<schild.length;z++){
	     								li+='<li ><div class="yiji_title" url="'+schild[z].url+'" onClick="opennew(this)"><span  class="head_pic"><img src="../img/main_img/hei.png" alt=""/></span><span title="'+schild[z].name1+'" id="'+schild[z].id+'"  class="appname">'+schild[z].name+'</span></div></li>';
	     							}
	     							li+='</ul></div>';
	     						}else{
	     							li+='<li><div class="yiji_title"  url="'+fchild[j].url+'" onClick="opennew(this)"><span  class="head_pic"><img src="../img/main_img/hei.png" alt=""/></span><span title="'+fchild[j].name1+'" id="'+fchild[j].id+'"  class="appname">'+fchild[j].name+'</span></div></li>';
	     						}
	     					}
	     					li+='</ul></div>';
	     				}
	     				li+='</li>';
	     			}
	     			$(".app_connect ul").html(li);
	     		}
	     	} 
		 }
		
	});
	   function opennew(e){
	   		var url=$(e).attr('url');
	   		var id=$(event.currentTarget).find('span.appname').attr('id');
	   		if(url.indexOf('/')>0){
				url = url.replace('/','_')
			}
			if(menu[url]){
				url="/xoa/"+menu[url];
			}else{
	   			url='http://192.168.0.17:81/gotophp.php?uid=admin&url='+url;
	   		}  
			if(typeof(window.external.OA_SMS)!='undefined'){
				window.external.OA_SMS(url,"MAX","OPEN_URL");
			}
		}
</script>
<script language="JavaScript">
	$(function(){
	   /***应用二三级菜单展示隐藏***/
	   	$(".app_connect ul").on('click','li .yiji_title',function(){
			if($(this).siblings('div.common').css('display')=='none'){
				$(this).children('span:eq(2)').removeClass('before').addClass('after');
				$(this).siblings('div.common').slideDown(100).children('ul li');
			}else{
				$(this).children('span:eq(2)').removeClass('after').addClass('before');
				$(this).siblings('div.common').slideUp(100);
			}
	   	});		
		
	});
	
</script>
</html>