<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title></title>
	<!-- <link rel="stylesheet" type="text/css" href="css/index.css"/> -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="css/main/theme1/m_reset.css"/>
	<link rel="stylesheet" type="text/css" href="css/main/theme1/cont.css"/>
	<style>
		@import url(m_reset.css);
	</style>
</head>

<body>
	<div class="wrapper">
		<div class="header">
			<ul>
				<li><span class="head_title active">个人门户</span></li>
				<li><span class="head_title">企业门户</span></li>
				<li><span class="head_title">管理门户</span></li>
			</ul>
		
		</div>
		<div class="main">
			<ul class="total">
				<li class="contain side">
					 <div class="s_head"><span class="model">常用功能</span><span class="more">管理</span></div>
					<div class="s_container">
						<ul>
							<li><span class="e_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span class="e_title">扣了我的坚持多久扣费接口杰克丹尼肯定是考虑考虑了陆克文jfk老师的可能看你说的那么，解放我可能是的空间<i style="background:url(http://devapp.gsubo.com/ui/img/mail/fileflag.png)"></i></span><span class="e_time">4月27日</span></li>
							<li><span><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title"><i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月21日</span></li>
							<li><span><img src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月20日</span></li>
						</ul>
					</div>
				</li>
				<li class="contain middle">
				<div class="s_head">
						<span class="model">邮件箱</span><span class="head_title sort active">全部邮件</span><span class="head_title sort">未读邮件</span><span class="head_title sort">已读邮件</span><span class="more"><a>更多</a></span>
					</div>
					<div class="s_container">
						<ul>
							<li><span class="e_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span class="e_title">扣了我的坚持多久扣费接口杰克丹尼肯定是考虑考虑了陆克文jfk老师的可能看你说的那么，解放我可能是的空间<i style="background:url(http://devapp.gsubo.com/ui/img/mail/fileflag.png)"></i></span><span class="e_time">4月27日</span></li>
							<li><span><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title"><i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月21日</span></li>
							<li><span><img src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月20日</span></li>
						</ul>
					</div>
				</li>
				<li class="contain side">
					 <div class="s_head">
						<span  class="model">邮件箱</span><span class="head_title sort active">全部邮件</span><span class="head_title sort">未读邮件</span><span class="head_title sort">已读邮件</span><span class="more"><a>更多</a></span>
					</div>
					<div class="s_container">
						<ul>
							<li><span class="e_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span class="e_title">扣了我的坚持多久扣费接口杰克丹尼肯定是考虑考虑了陆克文jfk老师的可能看你说的那么，解放我可能是的空间<i style="background:url(http://devapp.gsubo.com/ui/img/mail/fileflag.png)"></i></span><span class="e_time">4月27日</span></li>
							<li><span><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title">扣了我的坚持多久扣费接口杰克丹尼肯定是考虑考虑了陆克文jfk老师<i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title">扣了我的坚持多久扣费接口杰克丹尼肯定是考虑考虑了陆克文jfk老师<i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title">扣了我的坚持多久扣费接口杰克丹尼肯定是考虑考虑了陆克文jfk老师<i></i></span><span class="e_time">4月21日</span></li>
							<li><span><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title">扣了我的坚持多久扣费接口杰克丹尼肯定是考虑考虑了陆克文jfk老师<i></i></span><span class="e_time">4月20日</span></li>
						</ul>
					</div>
				</li>
				<li class="contain side">
					<div class="s_head">
						<span class="model">邮件箱</span><span class="head_title sort active">全部邮件</span><span class="head_title sort">未读邮件</span><span class="head_title sort">已读邮件</span><span class="more"><a>更多</a></span>
					</div>
					<div class="s_container">
						<ul>
							<li><span class="e_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span class="e_title">扣了我的坚持多久扣费接口杰克丹尼肯定是考虑考虑了陆克文jfk老师的可能看你说的那么，解放我可能是的空间<i style="background:url(http://devapp.gsubo.com/ui/img/mail/fileflag.png)"></i></span><span class="e_time">4月27日</span></li>
							<li><span><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title"><i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title"><i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title"><i></i></span><span class="e_time">4月21日</span></li>
							<li><span><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title"><i></i></span><span class="e_time">4月20日</span></li>
						</ul>
					</div>
				</li>
				<li class="contain middle">
					<div class="s_head">
						<span class="model">邮件箱</span><span class="head_title sort active">全部邮件</span><span class="head_title sort">未读邮件</span><span class="head_title sort">已读邮件</span><span class="more"><a>更多</a></span>
					</div>
					<div class="s_container">
						<ul>
							<li><span class="e_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span class="e_title">扣了我的坚持多久扣费接口杰克丹尼肯定是考虑考虑了陆克文jfk老师的可能看你说的那么，解放我可能是的空间<i style="background:url(http://devapp.gsubo.com/ui/img/mail/fileflag.png)"></i></span><span class="e_time">4月27日</span></li>
							<li><span><img class="e_img" src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title"><i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img class="e_img" src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img class="e_img" src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月21日</span></li>
							<li><span><img class="e_img" src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月20日</span></li>
						</ul>
					</div>
				</li>
				<li class="contain side">
					<div class="s_head">
						<span class="model">邮件箱</span><span class="head_title sort active">全部邮件</span><span class="head_title sort">未读邮件</span><span class="head_title sort">已读邮件</span><span class="more"><a>更多</a></span>
					</div>
					<div class="s_container">
						<ul>
							<li><span class="e_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span class="e_title">扣了我的坚持多久扣费接口杰克丹尼肯定是考虑考虑了陆克文jfk老师的可能看你说的那么，解放我可能是的空间<i style="background:url(http://devapp.gsubo.com/ui/img/mail/fileflag.png)"></i></span><span class="e_time">4月27日</span></li>
							<li><span><img class="e_img" src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></span><span  class="e_title"><i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img class="e_img" src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月24日</span></li>
							<li><span><img class="e_img" src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月21日</span></li>
							<li><span><img class="e_img" src=""></span><span  class="e_title"><i></i></span><span class="e_time">4月20日</span></li>
						</ul>
					</div>
				</li>
			</ul>
		</div>
    </div>
  
</body>
</html>

