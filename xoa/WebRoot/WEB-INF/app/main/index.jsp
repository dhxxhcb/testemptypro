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
		<title><fmt:message code="global.page.first" /></title>
	    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		
		<link rel="stylesheet" type="text/css" href="css/main/theme1/bootstrap-responsive.min.css"/>
		
		<link rel="stylesheet" type="text/css" href="css/main/theme1/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/main/theme1/index.css"/>
		<link rel="stylesheet" type="text/css" href="css/main/theme1/cont.css"/>
		<script type="text/javascript" src="js/jquery-1.9.1.js"></script>  
		<script type="text/javascript" src="js/main_js/index.js"></script> 
		<script type="text/javascript" src="js/main_js/cont.js"></script> 
		<!-- <script src="js/jquery.js"></script> -->
		<script src="js/base/base.js"></script>
		<style>
			.two .two_all:hover{
				color:#2f8ae3;
				cursor: pointer;
			}
			.sanji .three:hover{
				color:#2f8ae3;
				cursor: pointer;
			}
			.three h1{
				margin-left:6%;
			}
			.side_all{
				/*width:0px;*/
				height:100%;
				/*background: red;*/
				position: absolute;
				right:0px;
				top:0px;
				z-index:20;
			}
			.checks{
				background: #fff;
			}
			.position{
				width:0px;
				height:100%;
				position: absolute;
				right:0px;
				top:0px;
				background: #fafafa;
				box-shadow: -2px 0 20px 0px #c4c4c4;
			}
		</style>
	</head>
	<body>
		<div class="wrap">
			<div class="head">
				<div class="head_left"><img src="img/main_img/LOGO.png" style="margin-top:2%;margin-left: 8%;"></div>
				<div class="head_mid">
					<div class="left_scroll"></div>
					<div class="main_title">
						<ul>
						<!-- <li style="background:#eef1f8;"><h1>首页标签</h1><img src="img/main_img/icon.png"></li> -->
							<li class="gongzuoliu" left='0' id='t_0' title='我的桌面'><h1><fmt:message code="global.my.Desktop" /></h1></li>
						</ul>
					</div>
					<div class="right_scroll"></div>
				</div>
				<!-- 右侧的小logo -->
				<div id="taskbar_right" class="head_rig">
			         <a id="task_center" hidefocus="hidefocus" title="搜索" data-step="5" data-intro="<b style='display:block'>搜索</b>点击进入“任务中心”，可以看到按时间和紧急程度排序的待办任务，并可快速建立任务" data-position="left"></a>
			         <a id="sns"  hidefocus="hidefocus" title="提醒" data-step="6" data-intro="<b style='display:block'>提醒 </b>点击进入“企业社区”，促进企业信息交流与知识共享" data-position="left"></a>
			         <a id="help"  hidefocus="hidefocus" title="主题 " data-step="7" data-intro="<b style='display:block'>主题 </b>“通达OA在线帮助”汇集了常见的用户问题，帮助用户快速掌握软件各项功能的使用" data-position="left" target="_blank"></a>
			   <%--      <a id="person_info"  hidefocus="hidefocus" title="设置" data-step="8" data-intro="<b style='display:block'>设置</b>点击进入“控制面板”，可以进行界面设置、个人信息设置、账号与安全设置" data-position="left"></a>--%>
			         <a id="theme"  hidefocus="hidefocus" title="注销" data-step="9" data-intro="<b style='display:block'>更换皮肤</b>通达OA为您提供了完备的界面换肤功能，通过“更换皮肤”按钮，一触即换" data-position="left"></a>
			         
		      	</div>
			</div>

			<div class="cont" id="client" style="position: relative;">
				<ul class="side_all">
					<li class="position" id="admin-side0">
						<div class="skin">

							<h2 style="width: 90%;height:100%;line-height: 45px;text-align: center;font-size: 10pt;font-weight: bold;">搜索</h2>
							<img id="go_back" src="img/main_img/close.png" alt="" style="margin-top: 16px;">
						</div>
						<div style="margin-top: 20px">
							<input type="text" class="huiqian_inp">
							<button class="huiqian_send">搜索</button>
						</div>

					</li>
					<li class="position" id="admin-side1">
						<div class="skin">

							<div class="tixing_tab_t">
								<ul class="tixing_title">
									<li class="tixing_check">待办</li>
									<li>邮件</li>
									<li>公告</li>
								</ul>
							</div>
							<img id="go_back" class="tixing_img" src="img/main_img/close.png" alt="" style="margin-left: 24px;margin-top: 16px;">
						</div>
						<div style="margin-top:5px"  id="tixing_tab_c">
							<ul class="tixing_one">
								<li class="tixing_one_all" style="background: red;">
									<div class="tixing_every">
										<div class="company">
											<h1>同事小C</h1>
											<div class="jinji">紧急</div>
											<h2 class="company_time">30分钟前</h2>
										</div>
										<h1 class="thing">您有新的工作需要办理</h1>
										<div class="liushuihao"><h1>流水号：<span>926</span></h1></div>
										<div class="work_name"><h1>工作名称/文号：<span>内部事项报销(2016-06-06 12:19)</span></h1></div>
									</div>

								</li>
								<li class="tixing_one_all" style="background: cyan;">
									<div class="tixing_every">
										<div class="company">
											<h1>同事小C</h1>
											<div class="jinji">紧急</div>
											<h2 class="company_time">30分钟前</h2>
										</div>
										<h1 class="thing">您有新的工作需要办理</h1>
										<div class="liushuihao"><h1>流水号：<span>926</span></h1></div>
										<div class="work_name"><h1>工作名称/文号：<span>内部事项报销(2016-06-06 12:19)</span></h1></div>
									</div>

								</li>
								<li class="tixing_one_all" style="background: cyan;">
									<div class="tixing_every">
										<div class="company">
											<h1>同事小C</h1>
											<div class="jinji">紧急</div>
											<h2 class="company_time">30分钟前</h2>
										</div>
										<h1 class="thing">您有新的工作需要办理</h1>
										<div class="liushuihao"><h1>流水号：<span>926</span></h1></div>
										<div class="work_name"><h1>工作名称/文号：<span>内部事项报销(2016-06-06 12:19)</span></h1></div>
									</div>

								</li>
							</ul>
							<ul class="tixing_one" style="display: none;">
								<li class="tixing_one_all" style="background: red;">
									<div class="tixing_every">
										<div class="company">
											<h1>同事小C</h1>
											<div class="jinji">紧急</div>
											<h2 class="company_time">30分钟前</h2>
										</div>
										<h1 class="thing">您有新的工作需要办理</h1>
										<div class="liushuihao"><h1>流水号：<span>926</span></h1></div>
										<div class="work_name"><h1>工作名称/文号：<span>内部事项报销(2016-06-06 12:19)</span></h1></div>
									</div>

								</li>
								<li class="tixing_one_all" style="background: cyan;">
									<div class="tixing_every">
										<div class="company">
											<h1>同事小C</h1>
											<div class="jinji">紧急</div>
											<h2 class="company_time">30分钟前</h2>
										</div>
										<h1 class="thing">您有新的工作需要办理</h1>
										<div class="liushuihao"><h1>流水号：<span>926</span></h1></div>
										<div class="work_name"><h1>工作名称/文号：<span>内部事项报销(2016-06-06 12:19)</span></h1></div>
									</div>

								</li>
							</ul>
							<ul class="tixing_one" style="display: none;">
								<li class="tixing_one_all" style="background: red;">
									<div class="tixing_every">
										<div class="company">
											<h1>同事小C</h1>
											<div class="jinji">紧急</div>
											<h2 class="company_time">30分钟前</h2>
										</div>
										<h1 class="thing">您有新的工作需要办理</h1>
										<div class="liushuihao"><h1>流水号：<span>926</span></h1></div>
										<div class="work_name"><h1>工作名称/文号：<span>内部事项报销(2016-06-06 12:19)</span></h1></div>
									</div>

								</li>
							</ul>
						</div>
					</li>
					<li class="position" id="admin-side2">
						<div class="skin">
							<h2 style="width:88%;height:100%;line-height: 45px;text-align: center;font-size: 10pt;font-weight: bold;">换肤</h2>
							<img id="go_back" src="img/main_img/close.png" alt="" style="margin-top: 16px;">
						</div>
						<img src="img/main_img/skin.png" alt="" style="margin-top: 20px;margin-left: 17px;">
					</li>
					<li class="position" id="admin-side3">


							<div class="per_back">
								<img id="go_back" class="yonghu_img" src="img/main_img/close.png" alt="" style="margin-top: 10px;">
								<div class="per_all">
									<div style="width: 50px;height:50px;margin:auto;background: pink;"><img src="" alt=""></div>
									<h1>陈家旭</h1>
									<h2>视觉设计师</h2>
									<h3>产品研发部</h3>
								</div>
							</div>
							<button class="per_shezhi"><img src="img/main_img/per_shezhi.png" alt="">设置</button>
							<button class="per_suoding"><img src="img/main_img/per_suoding.png" alt="">锁定</button>
							<button class="per_zhuxiao" id="per_zhuxiao"><img src="img/main_img/per_zhuxiao.png" alt="">注销</button>
					</li>
				</ul>
				<div class="cont_left">
					<ul class="all_ul">
						<div class="tab_t">
							<ul class="top_ul">
								<li class="yingy" id="use"><fmt:message code="global.lang.apply" /></li>
								<li id="orgnize"><fmt:message code="global.lang.tissue" /></li>
							</ul>
						</div>
						<div class="tab_c list">
								<ul class="tab_cone a yiji" >
								</ul>
							<ul class="tab_ctwo a" id="deptOrg" style="display:none;">
							</ul>
						</div>
						
					</ul>
				</div>
				<div class="cont_rig">
					<div class="all_content" style="width:100%;height:100%;">
							<!-- 我的桌面 -->
							<div id='f_0' class="iItem">
									<!-- <div class="wrapper"> -->
										<div class="header">
											<ul>
												<li><span class="head_title active">首页门户</span></li>
												<li><span class="head_title">应用门户</span></li>
												<li><span class="head_title">管理门户</span></li>
											</ul>
										
										</div>
										<div class="main">
											<ul class="total">
												<li class="contain side">
													 <div class="s_head">
														<span  class="model">常用功能</span>
														<!-- <span class="more"><a>管理</a></span> -->
													</div>
													<div class="s_container">
														<div class="every_logo" menu_tid="0116" url="notice/index"><img src="img/spirit/menu/notice.png"><h2>公告</h2></div>
														<div class="every_logo" menu_tid="0101" url="email/index"><img src="img/spirit/menu/mail.png"><h2>邮件</h2></div>
														<div class="every_logo" menu_tid="0124" url="http://192.168.0.17:81/gotophp.php?uid=admin&url=calendar"><img src="img/spirit/menu/data.png"><h2>日程</h2></div>
														<div class="every_logo" menu_tid="0117" url="news/index"><img src="img/spirit/menu/news.png"><h2>新闻</h2></div>
														<div class="every_logo" menu_tid="3001" url="file/home"><img src="img/spirit/menu/nor.png"><h2>文件柜</h2></div>
														<div class="every_logo" menu_tid="0128" url="diary/index"><img src="img/spirit/menu/daily.png"><h2>日志</h2></div>
													</div>
												</li>
												<li class="contain middle">
												 <div class="s_head">
														<span  class="model">邮件箱</span>
														<ul class="mail_title">
															<li class="head_title sort  active" id="all_m">全部邮件</li>
															<li class="head_title sort " id="weidu">未读邮件</li>
															<li class="head_title sort " id="yidu">已读邮件</li>
														</ul>
														
														<span class="more" tid="0101" url="email/index"><a>更多</a></span>
													</div>
													<div class="e_mail">
														<ul class="all_mail">

														</ul>
														<ul class="read" style="display:none;">
														</ul>
													</div>
												</li>
												<li class="contain side">
													 <div class="s_head">
														<span  class="model" >日志</span><span class="more_daily"><a class="daily_more" tid="0128" url="diary/index">更多</a></span>
													</div>
													<div class="daily">
														<ul class="all_daily">

														</ul>
													</div>
												</li>
												<li class="contain side">
													 <div class="s_head">
														<span  class="model">日程安排</span><span class="more"><a>添加</a></span>
													</div>
													<div class="s_container">
														<img style="width:100%;height:100%" src="img/spirit/menu/richenganpai.png">
													</div>
												</li>
												<li class="contain middle">
													 <div class="notice_head">
														<span  class="model">公告</span>
														<ul class="notice_list">
															<li class="head_title sort active actives" id="all_notice">全部公告</li>
															<li class="head_title sort" id="weidu_notice">未读公告</li>
														</ul>
														
														<span class="more_notice" tid="0116" url="notice/index"><a style="    color: #fff;">更多</a></span>
													</div>
													<div class="tainer">
														<ul class="notify">
														</ul>
														<ul class="no_read_notice" style="display:none;">
														
														</ul>	
													</div>
												</li>
												<li class="contain side">
													 <div class="wenjian_head">
														<span  class="model">文件柜</span>
														<ul class="wenjian_list">
															<li class="head_title sort active actives" id="pets">公共文件</li>
															<li class="head_title sort"  id="person">个人文件</li>
														</ul>
														
														<span class="wenjian_span more_wenjian"  tid="3001" url="file/home"><a style="color: #fff;" >更多</a></span>
													</div>
													<div class="s_cont">
														<ul class="pets_wenjian" >
														</ul>
														<ul class="people_wenjian" style="display:none;">
														</ul>
														
													</div>
												</li>
											</ul>
										</div>


							</div>

							<div id='' class="iItem"><iframe  id="every_module" src="" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div>
							
					</div>
				</div>
			</div>
			<div class="foot">
				 <!-- <div class="foot_left"><a href="download.html" target="_blank"><h1>点击下载PC客户端</h1></a></div> -->
				
				<!-- <div class="lunbo">
					 <ul id="status_text">					
						 <li>Office　Anywhere　 &nbsp2015版</li>
						 <li>中国协同OA软件领跑者</li>
						 <li>体验科技关怀   共创美好未来</li>
					</ul>			
				 </div> -->
				<div style="width: 569px;height: 50px;margin: auto;"><iframe  id="every_module" src="lunbo" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize"></iframe></div>
				
		<!-- 		<div class="foot_rig"><a href="xitong.html" target="_blank"><h2>心通达 &nbsp 年付版本</h2></a></div> -->
				
				
				  
		</div>
	</body>
	<script>
		$(function(){

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
				"system_file_folder":"file/setIndex",
				"system_workflow_flow_guide":"flow/type/index",
				"system_workflow_flow_form":"workflow/formtype/index",
				"file_folder_index2.php":"file/persionBox",
				"system_workflow_flow_sort":"workflow/flowclassify/index",
				"system_unit":"sys/companyInfo",
				"system_dept":"common/deptManagement",
				"system_org_manage":"sys/organizational",
				"workflow_new":"workflow/work/addwork",
				"workflow_list":"workflow/work/workList",
				"system_user":"common/userManagement",
                "system_user_priv":"common/roleManagement",
				"system_status_text":"sys/statusBar",
				"system_interface":"sys/interfaceSettings",
				"system_reg_view":"sys/sysInfo",
				"system_menu":"sys/menuSetting",
				"system_log":"sys/journal",
				"system_code":"common/systemCode",
				"info_unit":"sys/unitInfor",
				"info_dept":"department/deptQuery",
				"info_user":"sys/userInfor"
			};
			
			$('.cont_nav').on('click','li',function(){
				$(".cont_nav li").removeClass("infame");
				$(this).addClass('infame');
				
			});
            //内容右侧tab切换
            var currentIndex=4;
            var index;
            $('#taskbar_right').on('click','a',function(){
                index=$(this).index();
                console.log(index);
                if(currentIndex!=index){
                    currentIndex=index;
                    $("#taskbar_right a").removeClass('logo_checks');
                    $(this).addClass('logo_checks');
                    //内容
                    var contents=$(".side_all").find(".position");
                   $(contents[index]).animate({width:"300px"});
                    $(contents[index]).siblings().css('width','0px');
                }

            });

            //内容右侧 提醒下的tab切换
            var currentIndexTwo=9;
            var index;
            $('.tixing_tab_t').delegate('li','click',function(){
                index=$(this).index();
                console.log(index);
                if(currentIndexTwo!=index){
                    currentIndexTwo=index;
                    $(".tixing_tab_t li").removeClass("tixing_check");
                    $(this).addClass("tixing_check");
                    //内容
                    var contents=$("#tixing_tab_c").find("ul");
                    $(contents[index]).show();
                    $(contents[index]).siblings().hide();
                }

            });
			//点击返回按钮，右边内容收回
            $('.position').on('click','#go_back',function () {

				$('.position').animate({width:"0px"});
            });
			//鼠标移入左三角，变色
			$('.left_scroll').on('mouseover',function(){
				$(this).css('background','url(img/main_img/tabs_arrow.png) -71px 0px no-repeat'); 
			});
			
			$('.left_scroll').on('mouseout',function(){
				$(this).css('background','url(img/main_img/tabs_arrow.png) -10px 0px no-repeat'); 
			})
			
			//鼠标移入右三角，变色
			$('.right_scroll').on('mouseover',function(){
				$(this).css('background','url(img/main_img/tabs_arrow.png) -98px 0px no-repeat'); 
			});
			
			$('.right_scroll').on('mouseout',function(){
				$(this).css('background','url(img/main_img/tabs_arrow.png) -37px 0px no-repeat'); 
			})

			
			//鼠标移入，右边logo变颜色，移出变回。
			//one

			/*$('#task_center').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_two.png) 0px -5px no-repeat')
			});
			$('#task_center').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_one.png) 0px -5px no-repeat')
			});

			//two

			$('#sns').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_two.png) -77px -5px no-repeat')
			});
			$('#sns').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_one.png) -77px -5px no-repeat')
			});

			//three

			$('#help').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_two.png) -148px -5px no-repeat')
			});
			$('#help').on('mouseout',function(){
                $(this).css('background','url(img/main_img/right_one.png) -148px -5px no-repeat')
            });

			//four

			$('#theme').on('mouseover',function(){
				$(this).css('background','url(img/main_img/right_two.png)  -225px -5px no-repeat')
			});
			$('#theme').on('mouseout',function(){
				$(this).css('background','url(img/main_img/right_one.png)  -225px -5px no-repeat')
			});*/

            //鼠标点击，右边logo变颜色
            $('#task_center').on('click',function(){
                $(this).css('background','url(img/main_img/right_three.png) 0px -5px no-repeat')
                $(this).siblings('#sns').css('background','url(img/main_img/right_one.png) -77px -5px no-repeat');
                $(this).siblings('#help').css('background','url(img/main_img/right_one.png) -148px -5px no-repeat');
                $(this).siblings('#theme').css('background','url(img/main_img/right_one.png) -225px -5px no-repeat');
            });
            $('#sns').on('click',function(){
                $(this).css('background','url(img/main_img/right_three.png) -77px -5px no-repeat')
                $(this).siblings('#task_center').css('background','url(img/main_img/right_one.png) 0px -5px no-repeat');
                $(this).siblings('#help').css('background','url(img/main_img/right_one.png) -148px -5px no-repeat');
                $(this).siblings('#theme').css('background','url(img/main_img/right_one.png) -225px -5px no-repeat');
            });
            $('#help').on('click',function(){
                $(this).css('background','url(img/main_img/right_three.png) -148px -5px no-repeat')
                $(this).siblings('#task_center').css('background','url(img/main_img/right_one.png) 0px -5px no-repeat');
                $(this).siblings('#sns').css('background','url(img/main_img/right_one.png) -77px -5px no-repeat');
                $(this).siblings('#theme').css('background','url(img/main_img/right_one.png) -225px -5px no-repeat');
            });
            $('#theme').on('click',function(){
                $(this).css('background','url(img/main_img/right_three.png)  -225px -5px no-repeat')
                $(this).siblings('#task_center').css('background','url(img/main_img/right_one.png) 0px -5px no-repeat');
                $(this).siblings('#sns').css('background','url(img/main_img/right_one.png) -77px -5px no-repeat');
                $(this).siblings('#help').css('background','url(img/main_img/right_one.png) -148px -5px no-repeat');
            });


			//点击注销按钮
			$('#admin-side3').on('click','#per_zhuxiao',function(){
			    window.close();
			    window.open('logOut');
			})

		//底部文字滚动
	/* 	var lunbo='';
		  function lunbo(id,height){
			  var ul=$(id);
			  var liFirst=ul.find('li:first');
			  $(id).animate({top:height}).animate({"top":0},0,function(){
			  var clone=liFirst.clone();
			  $(id).append(clone);
			  liFirst.remove();
			  })
		} 
		 	 setInterval("lunbo('#status_text','-50px')",3000);  */
		function init(){
			 $.ajax({
					url:'showMenu',
					type:'get',						
					dataType:'json',
					success:function(obj){
							var data= obj.obj;
							var str=''; 
						console.log(data);
							for(var i=0;i<data.length;i++){
								var er='';
								/* http://192.168.0.17:88/general/system/user/index.php?uid=admin */
								for(var j=0;j<data[i].child.length;j++){
									/* var url=data[i].child[j].url; */
									if(data[i].child[j].child.length>0){
										var three='';
										for(var k=0;k<data[i].child[j].child.length;k++){						
								 			three +='<li class="three" menu_tid='+data[i].child[j].child[k].id+' url='+data[i].child[j].child[k].url+' title="'+data[i].child[j].child[k].name+'"><img class="sanji_circle" src="img/main_img/hei.png"><h1 style="margin-left:6%;">'+data[i].child[j].child[k].name+'</h1></li>' ; 	
								 		}
								 		er += '<li class="two"  menu_tid='+data[i].child[j].id+'><div url='+data[i].child[j].url+'  class="two_all click_erji"  title="'+data[i].child[j].name+'"><img class="erji_circle" src="img/main_img/hei.png"><h1>'+data[i].child[j].name+'</h1><img class="er_img" src="img/main_img/down.png"></div><ul class="sanji" style="display:none;">'+three+'</ul></li>';
									
									}else{
										
										er += '<li class="two" menu_tid='+data[i].child[j].id+'><div url='+data[i].child[j].url+' class="two_all" title="'+data[i].child[j].name+'"><img class="erji_circle" src="img/main_img/hei.png"><h1 class="erji_h1">'+data[i].child[j].name+'</h1></div></li>';
										
									} 
								} 
								str+='<li class="one person" id="administ"><div class="one_all" title="'+data[i].name+'"><img class="one_logo" src="img/main_img/'+data[i].img+'.png"><h1 class="one_name" id="administ">'+data[i].name+'</h1><img class="down_jiao" src="img/main_img/down.png"></div><div class="two_menu"><ul class="erji b"  style="width:100%;display:none;"><li class="two"><div class="two_all">'+er+'</div></li></ul></div></li>'; 
							}   

						$(".tab_cone").html(str);
						
						 
						
						//鼠标移动到一级菜单变样式，移出变回
						$('.one_all').on('mouseover',function () {
							$(this).css({
									'background':'url(img/main_img/first_yes.png) 0px 0px no-repeat',
									'color':'#006bb8',
									/* 'border':'1px solid #999', */
									'cursor':'pointer'
								});
						});
						//移出
						$('.one_all').on('mouseout',function () {
							$(this).css({
									'background':'url(img/main_img/first_no.png) 0px -0px no-repeat',
									'color':'#000'
								});
						});
							
						//点击一级菜单。显示二级
						
					 	$('.one_all').on('click',function () {
							var top_one=$(this).parent().next('li').find('.one_all');
							if ($(this).siblings().find('.erji').css('display')=='none') {
								 $(this).find('.down_jiao').attr('src','img/main_img/up.png'); 
								
								/* $(this).css('background','#cde2fa'); */
								$(this).siblings().find('.erji').show();
								$(this).siblings().find('.erji').css('background','#e8f4fc');
								
								/* console.log($(this).parent().next('li').find('.one_all')); */
								top_one.css('border-top','1px solid #999');
							}else{
								 $(this).find('.down_jiao').attr('src','img/main_img/down.png'); 
								$(this).siblings().find('.erji').hide();
								top_one.css('border-top','none');
							}
							
						
										
						});

							//点击二级，出现三级
						$('.click_erji').on('click',function () {
							var san= $(this).siblings().html();
							 if ($(this).siblings('.sanji').css('display')=='none') {
								$(this).find('.er_img').attr('src','img/main_img/up.png');
								$(this).siblings('.sanji').show();	
								
							}else{
								$(this).find('.er_img').attr('src','img/main_img/down.png');
								$(this).siblings('.sanji').hide();
							}
									
						});
						
					
						//二级菜单切换
						/*$('.two_menu li').on('mouseover','.two_all',function(){
						
								$(this).find('h1').css({
									'color':'#2f8ae3',
									 'cursor':'pointer'
								});
								 $(this).find('.erji_circle').attr('src','img/main_img/lan.png'); 
								
						});
						$('.two_menu li').on('mouseout','.two_all',function(){
							
								$('.two_menu li .two_all').removeClass('xuan');
								$(this).find('h1').css('color','#000');
								 $(this).find('.erji_circle').attr('src','img/main_img/hei.png'); 
						});*/
						

						//点击二级菜单
						$('.two_menu li').on('click','.two_all',function(){

                            //给我的工作标签添加click事件
                            console.log($(this).parent().attr('menu_tid')=='1020');
                            if($(this).parent().attr('menu_tid')=='1020'){
                                $(this).parent().click();
                            }

						    $(this).find('.erji_circle').attr('src','img/main_img/lan.png');
						    $(this).find('h1').attr('style','color:#2f8ae3');
						    $(this).parent('.two').siblings().find('.erji_circle').attr('src','img/main_img/hei.png');
                            $(this).parent('.two').siblings().find('h1').attr('style','color:#000');
                            $(this).parents('.one').siblings().find('h1').attr('style','color:#000');
                            $(this).parents('.one').siblings().find('.erji_circle').attr('src','img/main_img/hei.png');
                            $(this).parents('.one').siblings().find('.sanji_circle').attr('src','img/main_img/hei.png');
                            var url=$(this).attr('url');
							var menu_tid=$(this).parent().attr('menu_tid'); 
							//console.log(url);
							if(menu[url.replace('/','_')]){
								url = menu[url.replace('/','_')];
							}else{
								url='http://192.168.0.17:81/gotophp.php?uid=admin&url='+url;
							}

							//判断标题id与iframeid是否相同
							//console.log(url);
							console.log($('#f_'+menu_tid).length>0);
							if($('#f_'+menu_tid).length>0){
								//页面一打开，切换显示
								$('.all_content .iItem').hide();
								$('#f_'+menu_tid).show();
								
								$('#t_'+menu_tid).css({
									'background':'url(img/main_img/title_yes.png) 0px 4px no-repeat',
									'color':'#2a588c',
									'position':'relative',
									'z-index':99999
								})
								$('#t_'+menu_tid).siblings().css({
									'background':'url(img/main_img/title_no.png) 0px 4px no-repeat',
									'color':'#fff',
									'position':'relative',
									'z-index':999
								})
							}else{
								if($(this).siblings('.sanji').length>0){
                                    $(this).find('.erji_circle').attr('src','img/main_img/hei.png');
                                    $(this).find('h1').attr('style','color:#000');
										/* return  false; */
									//console.log($(this).siblings('.sanji').length>0);
								}else{
									//页面不存在，新增 title和iframe

									var titlestr = '<li class="choose" index="0;" id="t_'+menu_tid+'" title="'+$(this).find('h1').html()+'"><h1>'+$(this).find('h1').html()+'</h1><div class="img" style="display:none;"><img class="close"  src="img/main_img/icon.png"></div></li>';
									
									var iframestr = '<div id="f_'+menu_tid+'" class="iItem" ><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';
									
									$('.main_title ul').append(titlestr);
									
									$('#t_'+menu_tid).siblings().attr('style','background: url(img/main_img/title_no.png) 0px 4px no-repeat;');
									$('#t_'+menu_tid).siblings().css('color','#fff');
									/* console.log($('#t_'+menu_tid).siblings()); */
									$('.all_content').append(iframestr);
									$('.all_content .iItem').hide();
									$('#f_'+menu_tid).show();
								
								}
								
							}
							
								
						});		
						

							//点击三级菜单，跳转页面。
							$('.sanji').on('click','li',function(){
                                $(this).find('img').attr('src','img/main_img/lan.png');
                                $(this).find('h1').attr('style','color:#2f8ae3');
                                $(this).siblings().find('.sanji_circle').attr('src','img/main_img/hei.png');
                                $(this).siblings().find('h1').attr('style','color:#000');
                                $(this).parents('.one').siblings().find('h1').attr('style','color:#000');
                                $(this).parents('.one').siblings().find('.sanji_circle').attr('src','img/main_img/hei.png');
								var url=$(this).attr('url'); 
								console.log(url);
							 	var menu_tid=$(this).attr('menu_tid');  
								console.log(url.split);
								console.log(menu[url.split('/').join('_')]);
								if(menu[url.split('/').join('_')]){
									url = menu[url.split('/').join('_')];
								}else{
									url='http://192.168.0.17:81/gotophp.php?uid=admin&url='+url;
								}
								
								console.log(menu_tid);
								if($('#f_'+menu_tid).length>0){
									//页面一打开，切换显示
									$('.all_content .iItem').hide();
                                    $('#f_'+menu_tid).show();

                                    $('#t_'+menu_tid).siblings().css({
                                        'background':'url(img/main_img/title_no.png) 0px 4px no-repeat',
                                        'color':'#fff',
                                        'position':'relative',
                                        'z-index':999
                                    });


										$('#t_'+menu_tid).css({
										'background':'url(img/main_img/title_yes.png) 0px 4px no-repeat',
										'color':'#2a588c',
										'position':'relative',
										'z-index':99999
									})

								
								}else{ 
									
									//页面不存在，新增 title和iframe
									var titlestrs = '<li class="choose " index="0;" id="t_'+menu_tid+'" title="'+$(this).find('h1').html()+'"><h1>'+$(this).find('h1').html()+'</h1><div class="img" style="display:none;"><img class="close" src="img/main_img/icon.png"></div></li>';
									
									var iframestr = '<div id="f_'+menu_tid+'" class="iItem"><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';
									
									$('.main_title ul').append(titlestrs);

                                    $('#t_'+menu_tid).siblings().attr('style','background: url(img/main_img/title_no.png) 0px 4px no-repeat;');
                                    $('#t_'+menu_tid).siblings().css('color','#fff');
									$('.all_content').append(iframestr);
									$('.all_content .iItem').hide();
									$('#f_'+menu_tid).show();
								}
								
					        });
								
						
						//三级菜单切换
						 //三级菜单移入变样式
						/*$('.sanji').on('mouseover','li',function(){
							$(this).css({
									/!* 'background':'url(img/main_img/first_yes.png) 0px 1.4px no-repeat', *!/
									'color':'#006bb8',
									'cursor':'pointer'
								});
							 $(this).find('img').attr('src','img/main_img/lan.png'); 
							
						});*/
						//三级菜单移出
						/*$('.sanji').on('mouseout','li',function(){
							
								/!* $('.sanji li').removeClass('xuan'); *!/
								$(this).css({
									/!* 'background':'url(img/main_img/first_no.png) 0px 0px no-repeat', *!/
									'color':'#000'
								});
								 $(this).find('img').attr('src','img/main_img/hei.png'); 
						});*/
						

					//success的后括号
					}		
				});//ajax传入应用数据结束括号 
			  
		}//init方法结束
				
			
			init();//调用init()方法
							//移入
						$('.main_title').on('mouseover','li',function(){
							
							$(this).find('.close').attr('src','img/main_img/delet_yuan.png');
						 	$(this).find('.img').show();
						}) ;
						//移出
						$('.main_title').on('mouseout','li',function(){
							
							$(this).find('.img').hide();
						 
						}) ;
						
						//点击标题栏
						$('.main_title ').on('click','li',function(){
							
						    $('.main_title li').removeClass('change');
							$(this).addClass('change');
							var t_this=$(this).attr('id');
						
							var num=t_this.split('_')[1];
							  if($('#f_'+num).length>0){
							 	console.log($('#f_'+num).length);
							 	$('.all_content .iItem').hide();
								$('#f_'+num).show();
					
							} 
							$(this).siblings().css({
										'background':'url(img/main_img/title_no.png) 0px 4px no-repeat',
										'color':'#fff',
										'position':'relative',
										'z-index':999
									})
							$(this).css({
										'background':'url(img/main_img/title_yes.png) 0px 4px no-repeat',
										'color':'#2a588c',
										'position':'relative',
										'z-index':99999
							})
							
						});
						//删除
					
			
					//点击删除
						$('.main_title').on('click','.close',function(){
						
							var re=$(this).parent().parent().attr('id');
							console.log(re);
							var delet=re.split('_')[1];
							console.log(delet);
								console.log($('#t_'+delet).prev());
						 	/*  	console.log($('#f_'+delet).next()); */
						 	/* if($('#f_'+delet).next()){
						 		$('#t_'+delet).next().attr('style','background:url(img/main_img/title_yes.png) -1px 2px no-repeat; position: relative; z-index: 99999;');	
						 	 	$(this).parent().parent().remove();
						 	  $('#f_'+delet).next().show();
						 	  
						 	   $('#f_'+delet).remove(); 
						 	}else{ */
						 		$('#t_'+delet).siblings().attr('style','background:url(img/main_img/title_no.png) 0px 4px no-repeat; ');
                            	$('#t_'+delet).siblings().css('color','#fff');
						 		$('#t_'+delet).prev().attr('style','background:url(img/main_img/title_yes.png) 0px 4px no-repeat; position: relative; z-index: 99999;');
						 	 	
						 	 	$(this).parent().parent().remove();
						 	 	if($('#f_'+delet).prev().find('iframe').attr('src')==''){
						 	 	    $('#f_0').show();
                                    $('#f_'+delet).remove();
								}else{
                                    $('#f_'+delet).prev().show();
                                    $('#f_'+delet).remove();
                                }

						 	 	
						 	/*     
						 	} */
						 	   

						 	/* var  li= $(this).parents('li'); */
						 
						}) ;
				
				//tab 切换
					$('.tab_t').on('click','li',function(){
						
							$(".tab_t li").removeClass("yingy");
							$(this).addClass('yingy');
							 if($(this).attr('id')=='use'){
								/* init(); */
								$('.tab_cone').css("display","block");
								$('.tab_ctwo').css("display","none");
							}else{
								$('.tab_cone').css("display","none");
								$('.tab_ctwo').css("display","block");
							} 
							
					})
			var bl=false;
					var numthree;
            var numTwo;
				//向左移动
				$('.right_scroll').on('click',function(){
					/* console.log($('.main_title li').length>=6); */
					if(!bl){
					 if(numTwo<=6 ){
                         bl=true;
					     return;
					 }
                    	numTwo--;
					     	$('.left_scroll').show();
							$('.main_title li').animate({left:"-=100px"});
							$('.main_title ul').animate({width:"+=110px"});

					}
				})
				//向右移动
					$('.left_scroll').on('click',function(){
					    if(bl){
                            numTwo++;
                            if(numTwo==numthree){
                                bl=false;
							}

						}
					console.log($('.main_title li').length>=8);
					if($('.main_title li').length>=6){
                        $('.right_scroll').show();
						$('.main_title li').animate({left:"+=100px"});
						
						if($('.main_title li:nth-child(1)').attr('left')==0){
							$('.main_title li:nth-child(1)').css('left','0px');
						}
						
					}
				});
				
				//组织
				$('.all_ul .tab_ctwo').on('click','.childdept',function(){
					var  that = $(this);
					
					getChDept(that.next(),that.attr('deptid'));
				});
				function getChDept(target,deptId){
					$.ajax({
						url:'department/getChDept',
						type:'get',	
						data:{
							deptId:deptId
						},		
						dataType:'json',
						success:function(data){
						/* if() */
							if(deptId==30){
								var str = '';
								data.obj.forEach(function(v,i){
									if(v.deptName){
										str+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib"><span></span><img src="img/spirit/icon_department.png" alt=""><a href="#" class="dynatree-title" title="'+v.deptName+'">'+v.deptName+'</a></span><ul style="margin-left:10%;"></ul></li>';
									}else{

											str+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children "><span><img src="img/main_img/man.png" alt=""></span><img src="img/main_img/man.png" alt=""><a href="#" class="dynatree-title" title="'+v.userName+'">'+v.userName+'</a></span><ul style="margin-left:10%;"></ul></li>';
										
									}
									
								});
							}else{
								var str = '';
								data.obj.forEach(function(v,i){
									if(v.deptName){
										str+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children f"><span class=""></span><img src="img/spirit/icon_company.png" alt=""><a href="#" class="dynatree-title" title="'+v.deptName+'">'+v.deptName+'</a></span><ul style="margin-left:10%;"></ul></li>';
									}else{
										if(v.sex==0){
										
											str+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children"><span></span><img src="img/main_img/man.png" alt=""><a href="#" class="dynatree-title" title="'+v.userName+'">'+v.userName+'</a></span><ul style="margin-left:10%;"></ul></li>';
										}else if(v.sex==1){
											str+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children"><span></span><img src="img/main_img/women.png" alt=""><a href="#" class="dynatree-title" title="'+v.userName+'">'+v.userName+'</a></span><ul style="margin-left:10%;"></ul></li>';
										}
										
										
									}
									
								});
							}
							
							
							target.html(str);
						}
					})
				}
				
					getChDept($('#deptOrg'),20);
					
					/* 我的桌面的 js代码 */
					
					/* var lh=$(".s_container ul li").height();
					$(".s_container ul li span").css("line-height",lh + 'px');
					$(window).resize(function(){
						var lh=$(".s_container ul li").height();
						$(".s_container ul li span").css("line-height",lh + 'px');
					}); */
					//点击常用功能里面的div,进行页面跳转。
					$('.s_container').on('click','.every_logo',function(){
						var  tid=$(this).attr('menu_tid');
						var url=$(this).attr('url');
						console.log(tid);
						console.log(url);
						
						if($('#f_'+tid).length>0){
							$('.all_content .iItem').hide();
								$('#f_'+tid).show();
								
								$('#t_'+tid).css({
									'background':'url(img/main_img/title_yes.png) 0px 4px no-repeat',
									'color':'#2a588c',
									'position':'relative',
									'z-index':99999
								})
								$('#t_'+tid).siblings().css({
									'background':'url(img/main_img/title_no.png) 0px 4px no-repeat',
									'color':'#fff',
									'position':'relative',
									'z-index':999
								})
						}else{
							var titlestrs = '<li class="choose " index="0;" id="t_'+tid+'" title="'+$(this).find('h2').html()+'"><h1>'+$(this).find('h2').html()+'</h1><div class="img" style="display:none;"><img class="close" src="img/main_img/icon.png"></div></li>';
							var iframestr = '<div id="f_'+tid+'" class="iItem"><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';
							
							/* $('#f_'+tid+' iframe').attr('src',url); */
					
							$('.main_title ul').append(titlestrs);
							$('#t_'+tid).siblings().attr('style','background: url(img/main_img/title_no.png) -1px 2px no-repeat; ');	
							$('#t_'+tid).siblings().css('color','#fff');
							$('.all_content').append(iframestr);
							$('.all_content .iItem').hide();
							$('#f_'+tid).show();
						}
						
						
						
					/* 	if($('#f_'+menu_tid).length>0){
								//页面一打开，切换显示
								$('.all_content .iItem').hide();
								$('#f_'+menu_tid).show();
								
								$('#t_'+menu_tid).css({
									'background':'url(img/main_img/title_yes.png) -1px 2px no-repeat',
									'position':'relative',
									'z-index':99999
								})
								$('#t_'+menu_tid).siblings().css({
									'background':'url(img/main_img/title_no.png) -1px 2px no-repeat',
									'position':'relative',
									'z-index':999
								})
							}else{
								if($(this).siblings('.sanji').length>0){
										/* return  false; */
									//console.log($(this).siblings('.sanji').length>0);
								/* }else{
									//页面不存在，新增 title和iframe

									var titlestr = '<li class="choose" index="0;" id="t_'+menu_tid+'" title="'+$(this).find('h1').html()+'"><h1>'+$(this).find('h1').html()+'</h1><div class="img" style="display:none;"><img class="close"  src="img/main_img/icon.png"></div></li>';
									
									var iframestr = '<div id="f_'+menu_tid+'" class="iItem" ><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';
									
									$('.main_title ul').append(titlestr);
									
									$('#t_'+menu_tid).siblings().attr('style','background: url(img/main_img/title_no.png) -1px 2px no-repeat;');
									
									/* console.log($('#t_'+menu_tid).siblings()); */
							/* 		$('.all_content').append(iframestr);
									$('.all_content .iItem').hide();
									$('#f_'+menu_tid).show();
								
								}
								
							}  */
						
					})
		
		});
	</script>
	<script>
		autodivheight();
		function autodivheight(){ 
		  var winHeight=0;
		  if (window.innerHeight)
		   winHeight = window.innerHeight;
		  else if ((document.body) && (document.body.clientHeight))
		   winHeight = document.body.clientHeight;
		  if (document.documentElement && document.documentElement.clientHeight)
		   winHeight = document.documentElement.clientHeight;
		   winWidth = document.documentElement.clientWidth;
		  document.getElementById("client").style.height= winHeight - 101 +"px";
		  document.getElementById("client").style.width= winWidth  +"px";
		  
		 }
 window.onresize=autodivheight; 
	</script>
	
</html>
