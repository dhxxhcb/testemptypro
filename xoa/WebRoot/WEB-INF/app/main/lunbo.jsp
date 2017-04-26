<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
 <title>Document</title>
 <style>
 *{
 margin:0;
 padding:0;
 }
 .lunbo{
 position: relative;
/*  width: 600px; */
 height: 50px;

 overflow: hidden;
 }
 ul{
 position:absolute;
 left: 0;
 top:0;
 width: 600px;
 height: auto;
 }
 ul li{
 width: 600px;
 height: 40px;
 line-height: 40px;
 font-size:16px;
 color:#fff;
 text-align: center
 }
 </style>
</head>
<body>
 <div class="lunbo">
	 <ul id="status_text">					
		<li>心通达OA</li>
		<li>中国协同OA软件领跑者</li>
		<li>体验科技关怀   共创美好未来</li>
	</ul>
 </div>
   
<script>
 function lunbo(id,height){
  var ul=$(id);
  var liFirst=ul.find('li:first');
  $(id).animate({top:height}).animate({"top":0},0,function(){
  var clone=liFirst.clone();
  $(id).append(clone);
  liFirst.remove();
  })
 }
 setInterval("lunbo('ul','-40px')",3000);
</script>
</body>
</html>
