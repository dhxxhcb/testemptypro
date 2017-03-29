<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<title>Office Anywhere 2015版 网络智能办公系统</title>
<script type="text/javascript">
	var MYOA_JS_SERVER = "";
	var MYOA_STATIC_SERVER = "";
</script>

<script type="text/javascript">
	var cur_login_user_id = "admin";
	var cur_login_user_priv = "1";
	var gz_postfix = "";
	var static_server = "";

	self.moveTo(0, 0);
	self.resizeTo(screen.availWidth, screen.availHeight);
	self.focus();
</script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.tag.css">
<link rel="stylesheet" type="text/css" href="css/show_guide.css" />
<link rel="stylesheet" href="css/iconfont.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="js/puck.jquery_bootstrap.js"></script>
<script type="text/javascript" src="js/puck.t-os.other.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/webuploader.js"></script>
<script type="text/javascript" src="js/js_lang.js"></script>
<script type="text/javascript" src="js/sys_function_7a682d434e.js"></script>
<script type="text/javascript" src="js/plugin.js"></script>
<script type="text/javascript" src="js/sea.js"></script>
<script type="text/javascript" src="js/base64.min.js"></script>
<script src="js/module.js"></script>
<script type="text/javascript">
	var bEmailPriv = true;
	var bSmsPriv = true;
	var bTabStyle = true;
	var OA_TIME = new Date(2017, 03, 28, 11, 53, 14);
	var bInitWeather = true;
	var weatherCity = ConvertWeatherCity("北京_北京_北京");
	var menuExpand = "";
	var shortcutArray = Array(1, 4, 147, 8, 130, 5, 131, 9, 16, 15, 76, 62);
	var loginUser = {
		uid : 1,
		user_id : "admin",
		user_name : "系统管理员"
	};
	var logoutText = "轻轻的您走了，正如您轻轻的来……";
	var monInterval = {
		online : 120,
		sms : 30
	};
	var ispirit = "";
	var statusTextScroll = 60;
	var newSmsSoundHtml = "<object id='sms_sound' classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000' codebase='/static//ui/js/swflash.cab' width='0' height='0'><param name='movie' value='/static/wav/1.swf'><param name=quality value=high><embed id='sms_sound' src='flash/1.swf' width='0' height='0' quality='autohigh' wmode='opaque' type='application/x-shockwave-flash' plugspace='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash'></embed></object>";
	var show_ip = 1;
	var show_button = "0";
	var unit_name = '&nbsp;';
	var jsonURL0 = '%2Finc%2Fonline.php%3FPARA_URL2%3D%2Fgeneral%2Fipanel%2Fuser%2Fuser_info.php%26PARA_TARGET%3D_blank%26PARA_ID%3DWINDOW%26PARA_VALUE%3D1%26SHOW_IP%3D1%26PWD%3D%26OP_SMS%3D1';
	var jsonURL1 = '%2Finc%2Fuser_list%2Ftree.php%3FMANAGE_FLAG%3D0%26DEPT_ID%3D0%26PARA_URL1%3D%26PARA_URL2%3D%2Fgeneral%2Fipanel%2Fuser%2Fuser_info.php%26e%3D%26PARA_TARGET%3D_blank%26PRIV_NO%3D%26PARA_ID%3DWINDOW%26PARA_VALUE%3D1%26MODULE_ID%3D2%26SHOW_IP%3D1%26PWD%3D%26DEPT_PRIV%3D1%26ROLE_PRIV%3D2%26PRIV_NO_FLAG%3D0%26OP_SMS%3D1%26rand%3D2126085886';
	var user_total_count = "20";
	var portalLoadArray = [ {
		id : "5",
		src : "5",
		url : "/portal/personal/",
		title : "我的桌面",
		closable : true
	} ];
	var themeArray = [];
	themeArray["10"] = {
		src : "/static/images/themeswitch/theme_thumb_10.jpg",
		title : "宁静的思考"
	};
	themeArray["13"] = {
		src : "/static/images/themeswitch/theme_thumb_13.jpg",
		title : "现代或未来"
	};
	themeArray["15"] = {
		src : "/static/images/themeswitch/theme_thumb_15.jpg",
		title : "T-OS"
	};

	//-- 一级菜单 --
	var first_array = [];
	first_array = first_array.concat([ 'shortcut' ], [ "01", "10", "20", "30",
			"40", "45", "50", "65", "70", "90", "a0", "b0", "e0", "y0", "z0" ]);

	//-- 一级菜单对应的字体图标 --
	var module2iconfont = {
		"01" : "&#xe653;",
		"02" : "",
		"10" : "&#xe65a;",
		"13" : "&#xe648;",
		"20" : "&#xe655;",
		"30" : "&#xe612;",
		"40" : "&#xe611;",
		"45" : "&#xe645;",
		"50" : "&#xe64e;",
		"65" : "&#xe64c;",
		"70" : "&#xe64a;",
		"85" : "&#xe648;",
		"90" : "&#xe651;",
		"a0" : "&#xe649;",
		"b0" : "&#xe647;",
		"d0" : "&#xe652;",
		"dd" : "&#xe646;",
		"e0" : "&#xe613;",
		"y0" : "&#xe64b;",
		"z0" : "&#xe650;",
		"shortcut" : "&#xe65b;",
		"default" : "&#xe67a;"
	};

	//-- 系统消息提示条字体图标 --
	var msgTipIconfont = {
		"0" : "&#xe65d;",
		"1" : "&#xe61e;",
		"2" : "&#xe619;",
		"3" : "&#xe64f;",
		"4" : "&#xe61a;",
		"5" : "&#xe616;",
		"6" : "&#xe615;",
		"7" : "&#xe65a;",
		"8" : "&#xe638;",
		"9" : "&#xe618;",
		"10" : "&#xe63a;",
		"11" : "&#xe64d;",
		"12" : "&#xe61c;",
		"13" : "&#xe61d;",
		"14" : "&#xe65e;",
		"15" : "&#xe614;",
		"16" : "&#xe638;",
		"17" : "&#xe65b;",
		"24" : "&#xe617;",
		"message" : "&#xe65c;",
		"default" : ""
	};
	//-- 二级菜单 --
	var second_array = [];
	second_array["m01"] = [ "1", "3", "42", "643", "644", "634", "4", "147",
			"148", "7", "8", "9", "10", "16", "11" ];
	second_array["m10"] = [ "130", "5", "131", "132", "256", "229", "182",
			"183", "194", "637", "134" ];
	second_array["m20"] = [ "24", "196", "105", "119", "80", "96", "126", "85",
			"90", "108", "51", "150", "218", "219", "43" ];
	second_array["m30"] = [ "15", "36", "70", "76", "77", "115", "116", "185",
			"235", "535" ];
	second_array["m40"] = [ "59", "133", "64", "257" ];
	second_array["m45"] = [ "2", "74", "12", "13" ];
	second_array["m50"] = [ "27", "494", "502", "26", "122", "630", "55",
			"511", "224", "252" ];
	second_array["m65"] = [ "461", "466", "471" ];
	second_array["m70"] = [ "200", "202", "201", "203", "206", "209" ];
	second_array["m90"] = [ "65", "187", "186", "188", "189", "190", "191" ];
	second_array["ma0"] = [ "550", "551" ];
	second_array["mb0"] = [ "73", "62", "63", "34", "532" ];
	second_array["me0"] = [ "548", "549", "602" ];
	second_array["my0"] = [ "46", "227" ];
	second_array["mz0"] = [ "56", "57", "58", "69", "71", "72", "223", "639",
			"225", "236", "78", "178", "104", "121", "149", "84", "99", "100",
			"533", "101", "113", "198", "540", "626", "638", "38" ];
	second_array["mshortcut"] = shortcutArray;
	//-- 三级菜单 --
	var third_array = [];
	third_array["f134"] = [ "37", "135", "136", "226", "253", "254", "255",
			"536" ];
	third_array["f96"] = [ "97", "98", "114" ];
	third_array["f126"] = [ "179", "607", "539", "251", "127", "238", "128" ];
	third_array["f85"] = [ "86", "87", "88", "89", "137", "138", "222" ];
	third_array["f90"] = [ "91", "92", "152", "93", "94", "95", "118", "237" ];
	third_array["f108"] = [ "109", "110", "112" ];
	third_array["f51"] = [ "53", "54", "153", "217" ];
	third_array["f150"] = [ "239", "240" ];
	third_array["f43"] = [ "17", "18", "19" ];
	third_array["f12"] = [ "68", "66", "67" ];
	third_array["f13"] = [ "14", "40", "41", "44", "75" ];
	third_array["f27"] = [ "60", "61", "481", "482", "483", "484", "485",
			"486", "487", "488", "489", "490", "491", "492", "120" ];
	third_array["f494"] = [ "495", "496", "497", "498", "499", "500", "501" ];
	third_array["f502"] = [ "503", "505", "504" ];
	third_array["f26"] = [ "506", "507", "508", "515", "537" ];
	third_array["f122"] = [ "123", "124", "628", "125" ];
	third_array["f630"] = [ "631", "632", "633" ];
	third_array["f55"] = [ "514", "509", "29", "28", "129", "510" ];
	third_array["f224"] = [ "39", "512", "513" ];
	third_array["f252"] = [ "230", "231", "232", "629", "233", "234" ];
	third_array["f461"] = [ "462", "463", "464", "465" ];
	third_array["f466"] = [ "467", "468", "469", "470" ];
	third_array["f471"] = [ "472", "473", "474", "475" ];
	third_array["f203"] = [ "204", "205" ];
	third_array["f206"] = [ "207", "208" ];
	third_array["f191"] = [ "606", "192", "193", "221" ];
	third_array["f548"] = [ "640", "641", "642" ];
	third_array["f549"] = [ "601", "600" ];
	third_array["f602"] = [ "603", "604" ];
	third_array["f46"] = [ "21", "22" ];
	third_array["f56"] = [ "30", "31", "33", "32", "605" ];
	third_array["f57"] = [ "609", "103", "146", "107", "197", "228" ];
	third_array["f58"] = [ "538", "151", "6", "534" ];

	//-- 互联网自定义 --
	func_array["extWebApp"] = [ "ewp23", "ewp24", "ewp25", "ewp26", "ewp27",
			"ewp28", "ewp29", "ewp30", "ewp31", "ewp32", "ewp33", "ewp34",
			"ewp35", "ewp36" ];
	func_array["fewp23"] = [ "百度搜索", "http://baidu.com", "ewp_baidu.png" ];
	func_array["fewp24"] = [ "新浪网", "http://www.sina.com.cn", "ewp_sina.png" ];
	func_array["fewp25"] = [ "58同城", "http://www.58.com", "ewp_58.png" ];
	func_array["fewp26"] = [ "天气预报",
			"http://xapp.baidu.com/apps/baidu-weather/app.html",
			"ewp_weather.png" ];
	func_array["fewp27"] = [ "奇艺网", "http://qiyi.com", "ewp_qiyi.png" ];
	func_array["fewp28"] = [ "中国政府网", "http://www.gov.cn", "ewp_gov.png" ];
	func_array["fewp29"] = [ "天涯社区", "http://www.tianya.cn", "ewp_tianya.png" ];
	func_array["fewp30"] = [ "淘宝网", "http://www.taobao.com", "ewp_taobao.png" ];
	func_array["fewp31"] = [ "优酷网", "http://www.youku.com", "ewp_youku.png" ];
	func_array["fewp32"] = [ "百度贴吧", "http://tieba.baidu.com",
			"ewp_bdtieba.png" ];
	func_array["fewp33"] = [ "新浪体育", "http://sports.sina.com.cn",
			"ewp_sinas.png" ];
	func_array["fewp34"] = [ "新浪新闻", "http://news.sina.com.cn",
			"ewp_sinanews.png" ];
	func_array["fewp35"] = [ "百度mp3", "http://mp3.baidu.com", "ewp_bdmp3.png" ];
	func_array["fewp36"] = [ "虾米音乐", "http://xiami.com", "ewp_xiami.png" ];

	//-- 个人收藏 --
	func_array["extFav"] = [];

	//快捷菜单
	func_array["mshortcut"] = [ "快捷菜单", "shortcut" ];
	func_array["fshortcut"] = [ "快捷菜单",
			"person_info/index.php?MAIN_URL=shortcut", "", "" ];

	//-- 天气 --
	var weather_json = [ {
		"date" : "3\u670828\u65e5",
		"img1" : "1",
		"img2" : "0",
		"weather" : "\u591a\u4e91\u8f6c\u6674",
		"temperature" : "16\u2103~4\u2103",
		"wind" : "\u5fae\u98ce"
	}, {
		"date" : "3\u670829\u65e5",
		"img1" : "1",
		"img2" : "1",
		"weather" : "\u591a\u4e91",
		"temperature" : "18\u2103~7\u2103",
		"wind" : "\u5fae\u98ce\u8f6c3-4\u7ea7"
	}, {
		"date" : "3\u670830\u65e5",
		"img1" : "1",
		"img2" : "0",
		"weather" : "\u591a\u4e91\u8f6c\u6674",
		"temperature" : "16\u2103~5\u2103",
		"wind" : "\u5fae\u98ce"
	}, {
		"date" : "3\u670831\u65e5",
		"img1" : "0",
		"img2" : "0",
		"weather" : "\u6674",
		"temperature" : "19\u2103~5\u2103",
		"wind" : "\u5fae\u98ce"
	} ];

	//-- 当前系统主题
	var ostheme = 15;
	var timer_sms_mon = null;
	var timer_online_tree_ref = null;
	//微讯箱自动关闭时间，秒
	var closeNocPanel = null;
	var nocbox_close_timeout = 3;
	var timeLastLoadOnline = 0;
	var nextTabId = 0;
	var maxSendSmsId = 0;
	var newSmsArray = [];
	var selectedRecvSmsIdStr = selectedSendSmsIdStr = "";
	var uploadsuccess = "上传成功";
	var sendsuccess = "发送成功";
	var uploaderror = "上传失败";
	var uploadnumlimit = "最多上传5个附件";
	var uploadduplicate = "该文件已加入上传队列";
	var weathertip = "未开启天气预报";
	var unselectuser = "暂未选择发送人员";
	var no_content_tip = "发送内容不能为空";
	var theme_select_priv = 0;
	var theme_select_tip = '对不起，您没有换肤权限';
	theme_select_priv = 1;
</script>
<script type="text/javascript">
	seajs.config({

		alias : {
			'underscore' : 'js/backbone/underscore.js',
			'backbone' : 'js/backbone/backbone.min.js',
			'menu-aim' : 'js/jquery-1.10.2/jquery.menu-aim.js',
			'miniNotification' : 'miniNotification.js',
			'tDesktop' : 'js/tDesktop/puck.tDesktop.js'
		}
	});
</script>
<script>
	jQuery(function() {
		seajs.use([ 'tDesktop', 'backbone' ], function(tDesktop) {
			var tDesktop = new tDesktop.TDesktop;
			window.tDesktop = tDesktop;
		});
		//检测是否支持WebUploader
		if (!WebUploader.Uploader.support()) {
			alert('提示：您所使用的浏览器不支持WebUploader组件，该组件会影响系统内文件上传功能。如果您所使用的是IE浏览器，请尝试升级flash播放器');
		}
	});
	function formatCalendarTitle(cstring) {
		var transMap = [ {
			lable : '会议',
			key : 'meeting'
		}, {
			lable : '车辆',
			key : 'car'
		} ];
		jQuery.each(transMap, function(k, v) {
			var lable = v.lable;
			var tips = new RegExp("^" + lable + ":", "g");
			cstring = cstring.replace(tips, '<span class="calendar-title-tip">'
					+ lable + '：' + '</span><span>');
		});
		return cstring;
	}
</script>
<script>
	function show_feedback() {
		window.open("http://club.tongda2000.com/demand/");
	}
</script>
</head>
<body class="TOS">
	<style>
.vmPanel {
	padding-left: 9px;
	margin: 10px 0;
	background: url("img/sound_bg.png") no-repeat left top;
	height: 38px;
	line-height: 38px;
	cursor: pointer;
}

.vmContent {
	background: url("img/sound_bg.png") no-repeat right -38px;
	font-size: 12px;
	font-weight: bold;
	color: #668A0D;
	text-align: right;
	padding-right: 10px;
}

.vmContent .icoVoice,.vmContent .icoVoicePlaying,.vmContent .icoVoiceDown
	{
	float: left;
	width: 32px;
	height: 32px;
	margin-top: 4px;
	display: inline;
}

.vmContent .icoVoice {
	background: url("img/icon_sound.png") no-repeat 0 3px;
}

.vmContent .icoVoiceDown {
	background: url("imgs/icon_download.png") no-repeat -32px 0;
}

.vmContent .icoVoicePlaying {
	background: url("img/you_voice_play.gif") no-repeat 0 4px;
}

.vmPanel.vmYou {
	background-position: left top;
}

.vmPanel.vmYou .vmContent {
	background-position: right -38px;
}

.vmPanel.vmMe {
	background-position: left -76px;
}

.vmPanel.vmMe .vmContent {
	background-position: right -114px;
	color: #9e9e9e;
}

.vmPanel.vmMe .vmContent .icoVoice {
	background: url("imgs/icon_sound.png") no-repeat -31px 3px;
}

.vmPanel.vmMe .vmContent .icoVoiceDown {
	background: url("img/icon_download.png") no-repeat 0 0;
}

.vmPanel.vmMe .vmContent .icoVoicePlaying {
	background: url("img/me_voice_play.gif") no-repeat 0 5px;
}

.emotions {
	vertical-align: middle;
}

.imPanel,a.fmPanel,.lmPanel {
	margin: 5px 0;
}

a.fmPanel {
	border-radius: 2px;
	display: block;
	width: 182px;
	height: 40px;
	line-height: 40px;
	background: url(img/download.jpg) no-repeat;
	text-decoration: none;
}

a.fmPanel span {
	display: block;
	padding-left: 50px;
	background-position: 4px center;
	background-repeat: no-repeat;
	color: #9e9e9e;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}

.lmPanel {
	display: inline-block;
	height: 18px;
	padding-left: 20px;
	line-height: 18px;
	background: url(img/location.png) no-repeat;
}
</style>
	<script src="js/ispirit.js"></script>
	<script type="text/javascript">
		(function($) {

			var imageMsg = {
				init : function() {
					$(document)
							.delegate(
									".imPanel[node-type='tMImage']",
									"click",
									function(e) {
										var _href = $(this).attr('node-data');
										e.stopPropagation();

										if (typeof (window.external.PlayVoiceMsg) == "undefined") {
											mytop = (screen.availHeight - 510) / 2;
											myleft = (screen.availWidth - 660) / 2;
											window
													.open(
															_href,
															"imageShow",
															"height=510, width=660, top="
																	+ mytop
																	+ ", left="
																	+ myleft
																	+ ",toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
										} else {
											if (parent && parent.openURL) {
												parent.openURL(_href);
											}
										}
										return;
									});
				}
			}

			var voiceMsg = {
				"init" : function() {
					$(document)
							.delegate(
									".vmPanel[action-type='play']",
									"click",
									function(e) {
										e.stopPropagation();

										if (typeof ($(this).attr("status")) == "undefined")
											var status = "stop";
										else
											var status = $(this).attr("status");

										if (status == "stop") {
											$(this).attr("status", "palying");
											voiceMsg.play($(this));
											$(this).attr("title", "点击停止播放");
										} else {
											$(this).attr("status", "stop");
											voiceMsg.stop();
											$(this).attr("title", "点击播放");
										}
										return;
									});

					$(document).delegate(".vmPanel[action-type='download']",
							"click", function() {
								voiceMsg.download($(this));
							});
				},
				"play" : function(handler) {
					var voice_data = handler.attr("action-data");
					this.stop();
					handler.find("[un='voiceStatus']").attr("class",
							"icoVoicePlaying");
					if (typeof (window.external.PlayVoiceMsg) == "undefined") {

					} else {
						window.external.PlayVoiceMsg(voice_data);
					}
				},
				"stop" : function() {
					if (typeof (window.external.StopVoiceMsg) == "undefined") {
					} else {
						window.external.StopVoiceMsg("");
					}
					StopVoiceMsg();
				},
				"download" : function(handler) {
					var voice_data = handler.attr("action-data-url");
					window.open(voice_data);
				}
			}

			$(function() {
				replaceVMDom();
				voiceMsg.init();
				imageMsg.init();
			});

		})(jQuery);

		function replaceVMDom() {

			if (!window.external)
				return;

			if (typeof (window.external.OA_SMS) == "undefined") {
				//默认是下载不需要替换
			} else {
				if (!window.external.OA_SMS("", "", "GET_VERSION")
						|| window.external.OA_SMS("", "", "GET_VERSION") < '20121210') {
					var vm = jQuery(".vmPanel");
					vm
							.before("<span style='color:red'>系统提示：客户端版本过低，请升级客户端</span>");
					vm.remove();
				} else {

					//有通过后台传值判断精灵的部分不替换
					if (jQuery(".vmPanel").size() > 0) {
						var defaultaction = jQuery(".vmPanel").eq(0).attr(
								"action-type");
						if (defaultaction == "play"
								&& typeof (window.external.PlayVoiceMsg) != "undefined")
							return;

					} else {
						return;
					}

					jQuery(".vmPanel").each(
							function() {
								jQuery(this).attr({
									"action-type" : "play",
									"title" : "点击播放"
								});
								jQuery(this).find("[un='voiceStatus']").attr(
										"class", "icoVoice");
							});
				}
			}
		}

		function StopVoiceMsg() {
			jQuery("[un='voiceStatus']").attr("class", "icoVoice");
		}

		top.StopVoiceMsg = StopVoiceMsg;
	</script>
	<div id="north" class="navwrapper">
		<div id="infobar" class="navbar pull-right">
			<ul class="infonav">
				<li id="mobile_code" class="navin" data-placement="left"
					data-toggle="tooltip" data-original-title="下载移动版"><a
					href="javascript:;" id="code" class="nav-item iconfont">&#xe682;</a>
					<div class="code-wrap">
						<a href="#"><img src="img/ios_code.png">
						</a>
						<p>iOS版</p>
						<hr>
						<a href="#"><img src="img/android_code.png">
						</a>
						<p>Android版</p>
						<hr>
						<a href="#"><img src="img/ding_code.jpg">
						</a>
						<p>下载钉钉</p>
						<hr>
						<a href="#"><img src="img/wechat.jpg">
						</a>
						<p>通达OA公众号</p>
					</div></li>
				<li id="info_avater" class="navin" data-placement="left"
					data-toggle="tooltip" title="" data-original-title="我的OA账号"
					data-step="6"
					data-intro="<b style='display:block'>6、我的OA账号</b>鼠标移上显示个人账户信息。"
					data-position="left"><a href="javascript:;" id="avatar"
					class="nav-item iconfont">&#xe63e;</a>
					<div class="info-wrap">
						<div class="person-info-header clearfix">
							<div class="person-info-avator">
								<img src="img/attach_old.php" width="60" height="60"
									id="loginavatar">
							</div>
							<div class="person-info-content">
								<h6 class="person-info-name">
									<span>系统管理员</span>
									<div class="person-info-online">
										<i class="iconfont tip-1" id="online_flag"> &#xe63d; </i>
										<div class="person-info-tip" id="on_status">
											<a href="javascript:;" status="1" hidefocus="hidefocus">
												<i class="iconfont tip-1">&#xe63d;</i> <span
												class="info-tip-title">在线</span> </a> <a href="javascript:;"
												status="2" hidefocus="hidefocus"> <i
												class="iconfont tip-2">&#xe63c;</i> <span
												class="info-tip-title">忙碌</span> </a> <a href="javascript:;"
												status="3" hidefocus="hidefocus"> <i
												class="iconfont tip-3">&#xe63b;</i> <span
												class="info-tip-title">离开</span> </a>
										</div>
									</div>
								</h6>
								<p class="person-info-detail">
									<span class="person-info-department">北方测试研究公司</span> <span>-OA
										管理员</span>
								</p>
								<p class="person-info-detail" title=""></p>
							</div>
						</div>
						<div class="person-info-body">
							<a href="javascript:;" id="person_info" hidefocus="hidefocus">控制面板</a>
							<a href="javascript:;" id="logout" hidefocus="hidefocus">注销</a>
						</div>
					</div></li>
				<li class="navin" data-step="7"
					data-intro="<b style='display:block'>7、搜索</b>通过“搜索”，可以快速搜索用户、菜单、工作流、通讯簿、日程安排和在线帮助。"
					data-position="left"><a href="javascript:;" id="searchbar"
					class="nav-item searchbar iconfont" data-placement="bottom"
					data-toggle="tooltip" title="" data-original-title="搜索">&#xe603;</a>
				</li>
				<li class="navin" data-step="8"
					data-intro="<b style='display:block'>8、任务中心</b>点击进入“任务中心”，可以看到按时间和紧急程度排序的待办任务，并可快速建立任务。"
					data-position="left"><a href="javascript:;" id="totaskbar"
					class="nav-item iconfont" data-placement="bottom"
					data-toggle="tooltip" title="" data-original-title="任务中心">&#xe641;</a>
				</li>
				<li class="navin" data-step="9"
					data-intro="<b style='display:block'>9、企业社区</b>点击进入“企业社区”，促进企业信息交流与知识共享。"
					data-position="left"><a href="javascript:;" id="tosns"
					class="nav-item iconfont" data-placement="bottom"
					data-toggle="tooltip" title="" data-original-title="企业社区">&#xe67b;</a>
				</li>
				<li class="navin" data-step="10"
					data-intro="<b style='display:block'>10、更换皮肤</b>通达OA为您提供了完备的界面换肤功能，通过“更换皮肤”按钮，一触即换。"
					data-position="left"><a href="javascript:;" id="theme"
					class="nav-item iconfont" data-placement="bottom"
					data-toggle="tooltip" title="" data-original-title="换肤"
					style="font-size: 24px;">&#xe60f;</a></li>
				<li class="navin" data-step="11"
					data-intro="<b style='display:block'>11、通知中心</b>“通知中心”为您提供今日消息、事务提醒，增强网页微讯交流，支持文件分享与群发。"
					data-position="left"><a href="javascript:;" id="eastbar"
					class="nav-item iconfont" data-placement="bottom"
					data-toggle="tooltip" title="" data-original-title="通知中心">&#xe60b;</a>
				</li>
			</ul>
		</div>
		<div id="logo" class="pull-left">
			<a href="javascript:;"
				onClick="javascript:createTab('portal_5', '我的桌面', '/portal/personal/', '0');">
				<!--<img src="images/logo_simple.png"/>--> <img
				src="img/logo_simple.png" style="margin:8px 0 0 10px;" /> </a>
		</div>
		<div id="taskbar" class="pull-left">
			<div id="tabs_left_scroll" class="tabs-scroll scroll-left"></div>
			<div id="tabs_container" class="tabs-container"></div>
			<div id="tabs_right_scroll" class="tabs-scroll scroll-right"></div>
		</div>
	</div>
	<div id="funcbar" class="funcbar">
		<div id='funcmenu_switcher'>
			<span>导航菜单</span> <i class="funcmenu_switcher" data-step="1"
				data-intro="<b style='display:block'>1、导航菜单按钮的使用</b>您已进入到通达OA主操作界面，您可以点击“导航菜单”按钮，控制主菜单显隐。"
				data-position="right"></i>
		</div>
		<div id="funcbar_left"></div>
		<div id="funcbar_right">
			<i class="iconfont js-inOrg" data-placement="bottom"
				data-toggle="tooltip" title="" data-original-title="组织">&#xe67f;</i>
			<i class="iconfont js-inNocbox" data-placement="bottom"
				data-toggle="tooltip" title="" data-original-title="事务提醒">&#xe681;</i>
			<i class="iconfont js-inWeixun" style="font-size: 18px;"
				data-placement="bottom" data-toggle="tooltip" title=""
				data-original-title="微讯">&#xe605;</i>
		</div>
	</div>
	<div id="west" class="west">
		<div id="west-body-wrapper">
			<div class="west-body">
				<div class="menu-scroll scroll-up" style="display: block;"></div>
				<ul id="first_menu" class="first-menu" data-step="2"
					data-intro="<b style='display:block'>2、主菜单</b>利用“菜单导航”功能，您可以找到所需要的功能选项。"
					data-position="right" style="height: 414.333px;">
					<li data-submenu-id="second-menu-shortcut">
						<div id="mshortcut" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">快捷菜单</span>
						</div>
						<div id="second-menu-shortcut" class="second-panel"
							style="display: none; top: -22px; left: 200px;">
							<h4>
								快捷菜单<a href="javascript:;"
									onclick="window.createTab('fshortcut', func_array['fshortcut'][0], func_array['fshortcut'][1], func_array['fshortcut'][4]);"
									class="set-shortcut" id="set-shortcut"><i class="iconfont"></i>
								</a>
							</h4>
							<ul id="second-menulist-shortcut" class="second-menu clearfix">
								<li class=""><a id="f1" class="second-menu-item"
									title="电子邮件" href="javascript:;"
									onclick="createTab(1,'电子邮件','email','');" hidefocus="hidefocus">电子邮件</a>
								</li>
								<li class=""><a id="f4" class="second-menu-item"
									title="公告通知" href="javascript:;"
									onclick="createTab(4,'公告通知','notify/show','');"
									hidefocus="hidefocus">公告通知</a>
								</li>
								<li class=""><a id="f147" class="second-menu-item"
									title="新闻" href="javascript:;"
									onclick="createTab(147,'新闻','news/show','');"
									hidefocus="hidefocus">新闻</a>
								</li>
								<li class=""><a id="f8" class="second-menu-item"
									title="日程安排" href="javascript:;"
									onclick="createTab(8,'日程安排','calendar','');"
									hidefocus="hidefocus">日程安排</a>
								</li>
								<li class=""><a id="f130" class="second-menu-item"
									title="新建工作" href="javascript:;"
									onclick="createTab(130,'新建工作','workflow/new','');"
									hidefocus="hidefocus">新建工作</a>
								</li>
								<li class=""><a id="f5" class="second-menu-item"
									title="我的工作" href="javascript:;"
									onclick="createTab(5,'我的工作','workflow/list','');"
									hidefocus="hidefocus">我的工作</a>
								</li>
								<li class=""><a id="f131" class="second-menu-item"
									title="工作查询" href="javascript:;"
									onclick="createTab(131,'工作查询','workflow/query','');"
									hidefocus="hidefocus">工作查询</a>
								</li>
								<li class=""><a id="f9" class="second-menu-item"
									title="工作日志" href="javascript:;"
									onclick="createTab(9,'工作日志','diary/show','');"
									hidefocus="hidefocus">工作日志</a>
								</li>
								<li class=""><a id="f16" class="second-menu-item"
									title="个人文件柜" href="javascript:;"
									onclick="createTab(16,'个人文件柜','file_folder/index2.php','');"
									hidefocus="hidefocus">个人文件柜</a>
								</li>
								<li class=""><a id="f15" class="second-menu-item"
									title="公共文件柜" href="javascript:;"
									onclick="createTab(15,'公共文件柜','knowledge_management','');"
									hidefocus="hidefocus">公共文件柜</a>
								</li>
								<li class=""><a id="f76" class="second-menu-item"
									title="网络硬盘" href="javascript:;"
									onclick="createTab(76,'网络硬盘','netdisk','');"
									hidefocus="hidefocus">网络硬盘</a>
								</li>
								<li class=""><a id="f62" class="second-menu-item"
									title="讨论区" href="javascript:;"
									onclick="createTab(62,'讨论区','bbs','');" hidefocus="hidefocus">讨论区</a>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-01">
						<div id="m01" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">个人事务</span>
						</div>
						<div id="second-menu-01" class="second-panel"
							style="display: none; top: -22px; left: 200px;">
							<h4>个人事务</h4>
							<ul id="second-menulist-01" class="second-menu clearfix">
								<li class=""><a id="f1" class="second-menu-item"
									title="电子邮件" href="javascript:;"
									onclick="createTab(1,'电子邮件','email','');" hidefocus="hidefocus">电子邮件</a>
								</li>
								<li class=""><a id="f3" class="second-menu-item"
									title="消息管理" href="javascript:;"
									onclick="createTab(3,'消息管理','sms','');" hidefocus="hidefocus">消息管理</a>
								</li>
								<li class=""><a id="f42" class="second-menu-item"
									title="手机短信" href="javascript:;"
									onclick="createTab(42,'手机短信','mobile_sms','');"
									hidefocus="hidefocus">手机短信</a>
								</li>
								<li class=""><a id="f643" class="second-menu-item"
									title="邮件审批" href="javascript:;"
									onclick="createTab(643,'邮件审批','email/audit/','');"
									hidefocus="hidefocus">邮件审批</a>
								</li>
								<li class=""><a id="f644" class="second-menu-item"
									title="邮件审批日志" href="javascript:;"
									onclick="createTab(644,'邮件审批日志','email/audit_log/','');"
									hidefocus="hidefocus">邮件审批日志</a>
								</li>
								<li class=""><a id="f634" class="second-menu-item"
									title="智协同" href="javascript:;"
									onclick="createTab(634,'智协同','itask','');"
									hidefocus="hidefocus">智协同</a>
								</li>
								<li class=""><a id="f4" class="second-menu-item"
									title="公告通知" href="javascript:;"
									onclick="createTab(4,'公告通知','notify/show','');"
									hidefocus="hidefocus">公告通知</a>
								</li>
								<li class=""><a id="f147" class="second-menu-item"
									title="新闻" href="javascript:;"
									onclick="createTab(147,'新闻','news/show','');"
									hidefocus="hidefocus">新闻</a>
								</li>
								<li class=""><a id="f148" class="second-menu-item"
									title="投票" href="javascript:;"
									onclick="createTab(148,'投票','vote/show','');"
									hidefocus="hidefocus">投票</a>
								</li>
								<li class=""><a id="f7" class="second-menu-item"
									title="个人考勤" href="javascript:;"
									onclick="createTab(7,'个人考勤','attendance/personal','');"
									hidefocus="hidefocus">个人考勤</a>
								</li>
								<li class=""><a id="f8" class="second-menu-item"
									title="日程安排" href="javascript:;"
									onclick="createTab(8,'日程安排','calendar','');"
									hidefocus="hidefocus">日程安排</a>
								</li>
								<li class=""><a id="f9" class="second-menu-item"
									title="工作日志" href="javascript:;"
									onclick="createTab(9,'工作日志','diary/show','');"
									hidefocus="hidefocus">工作日志</a>
								</li>
								<li class=""><a id="f10" class="second-menu-item"
									title="通讯簿" href="javascript:;"
									onclick="createTab(10,'通讯簿','address/private','');"
									hidefocus="hidefocus">通讯簿</a>
								</li>
								<li class=""><a id="f16" class="second-menu-item"
									title="个人文件柜" href="javascript:;"
									onclick="createTab(16,'个人文件柜','file_folder/index2.php','');"
									hidefocus="hidefocus">个人文件柜</a>
								</li>
								<li class=""><a id="f11" class="second-menu-item"
									title="控制面板" href="javascript:;"
									onclick="createTab(11,'控制面板','person_info','');"
									hidefocus="hidefocus">控制面板</a>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-10">
						<div id="m10" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">工作流</span>
						</div>
						<div id="second-menu-10" class="second-panel"
							style="display: none;">
							<h4>工作流</h4>
							<ul id="second-menulist-10" class="second-menu clearfix">
								<li class=""><a id="f130" class="second-menu-item"
									title="新建工作" href="javascript:;"
									onclick="createTab(130,'新建工作','workflow/new','');"
									hidefocus="hidefocus">新建工作</a>
								</li>
								<li class=""><a id="f5" class="second-menu-item"
									title="我的工作" href="javascript:;"
									onclick="createTab(5,'我的工作','workflow/list','');"
									hidefocus="hidefocus">我的工作</a>
								</li>
								<li class=""><a id="f131" class="second-menu-item"
									title="工作查询" href="javascript:;"
									onclick="createTab(131,'工作查询','workflow/query','');"
									hidefocus="hidefocus">工作查询</a>
								</li>
								<li class=""><a id="f132" class="second-menu-item"
									title="工作监控" href="javascript:;"
									onclick="createTab(132,'工作监控','workflow/manage','');"
									hidefocus="hidefocus">工作监控</a>
								</li>
								<li class=""><a id="f256" class="second-menu-item"
									title="数据报表" href="javascript:;"
									onclick="createTab(256,'数据报表','workflow/report','');"
									hidefocus="hidefocus">数据报表</a>
								</li>
								<li class=""><a id="f229" class="second-menu-item"
									title="超时统计分析" href="javascript:;"
									onclick="createTab(229,'超时统计分析','workflow/timeout_stat','');"
									hidefocus="hidefocus">超时统计分析</a>
								</li>
								<li class=""><a id="f182" class="second-menu-item"
									title="工作委托" href="javascript:;"
									onclick="createTab(182,'工作委托','workflow/rule','');"
									hidefocus="hidefocus">工作委托</a>
								</li>
								<li class=""><a id="f183" class="second-menu-item"
									title="工作销毁" href="javascript:;"
									onclick="createTab(183,'工作销毁','workflow/destroy','');"
									hidefocus="hidefocus">工作销毁</a>
								</li>
								<li class=""><a id="f194" class="second-menu-item"
									title="流程日志查询" href="javascript:;"
									onclick="createTab(194,'流程日志查询','workflow/logs','');"
									hidefocus="hidefocus">流程日志查询</a>
								</li>
								<li class=""><a id="f637" class="second-menu-item"
									title="数据归档" href="javascript:;"
									onclick="createTab(637,'数据归档','workflow/archive','');"
									hidefocus="hidefocus">数据归档</a>
								</li>
								<li class="expand"><a id="f134" class="second-menu-item"
									title="工作流设置" href="javascript:;" onclick=""
									hidefocus="hidefocus">工作流设置</a>
								<ul id="third-menulist-f134" class="third-menu">
										<li><a id="f37" class="third-menu-item"
											href="javascript:;" title="设计表单"
											onclick="createTab(37,'设计表单','system/workflow/flow_form','');"
											hidefocus="hidefocus">设计表单</a>
										</li>
										<li><a id="f135" class="third-menu-item"
											href="javascript:;" title="设计流程"
											onclick="createTab(135,'设计流程','system/workflow/flow_guide','');"
											hidefocus="hidefocus">设计流程</a>
										</li>
										<li><a id="f136" class="third-menu-item"
											href="javascript:;" title="分类设置"
											onclick="createTab(136,'分类设置','system/workflow/flow_sort','');"
											hidefocus="hidefocus">分类设置</a>
										</li>
										<li><a id="f226" class="third-menu-item"
											href="javascript:;" title="参数设置"
											onclick="createTab(226,'参数设置','system/workflow/config','');"
											hidefocus="hidefocus">参数设置</a>
										</li>
										<li><a id="f253" class="third-menu-item"
											href="javascript:;" title="业务引擎设置"
											onclick="createTab(253,'业务引擎设置','system/workflow/flow_hook','');"
											hidefocus="hidefocus">业务引擎设置</a>
										</li>
										<li><a id="f254" class="third-menu-item"
											href="javascript:;" title="报表设置"
											onclick="createTab(254,'报表设置','system/workflow/flow_report','');"
											hidefocus="hidefocus">报表设置</a>
										</li>
										<li><a id="f255" class="third-menu-item"
											href="javascript:;" title="数据源管理"
											onclick="createTab(255,'数据源管理','system/workflow/flow_data','');"
											hidefocus="hidefocus">数据源管理</a>
										</li>
										<li><a id="f536" class="third-menu-item"
											href="javascript:;" title="管理日志"
											onclick="createTab(536,'管理日志','system/workflow/flow_log','');"
											hidefocus="hidefocus">管理日志</a>
										</li>
									</ul>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-20">
						<div id="m20" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">行政办公</span>
						</div>
						<div id="second-menu-20" class="second-panel"
							style="display: none;">
							<h4>行政办公</h4>
							<ul id="second-menulist-20" class="second-menu clearfix">
								<li class=""><a id="f24" class="second-menu-item"
									title="公告通知管理" href="javascript:;"
									onclick="createTab(24,'公告通知管理','notify/manage','');"
									hidefocus="hidefocus">公告通知管理</a>
								</li>
								<li class=""><a id="f196" class="second-menu-item"
									title="公告通知审批" href="javascript:;"
									onclick="createTab(196,'公告通知审批','notify/auditing','');"
									hidefocus="hidefocus">公告通知审批</a>
								</li>
								<li class=""><a id="f105" class="second-menu-item"
									title="新闻管理" href="javascript:;"
									onclick="createTab(105,'新闻管理','news/manage','');"
									hidefocus="hidefocus">新闻管理</a>
								</li>
								<li class=""><a id="f119" class="second-menu-item"
									title="投票管理" href="javascript:;"
									onclick="createTab(119,'投票管理','vote/manage','');"
									hidefocus="hidefocus">投票管理</a>
								</li>
								<li class=""><a id="f80" class="second-menu-item"
									title="日程安排查询" href="javascript:;"
									onclick="createTab(80,'日程安排查询','calendar/info','');"
									hidefocus="hidefocus">日程安排查询</a>
								</li>
								<li class=""><a id="f218" class="second-menu-item"
									title="词语过滤管理" href="javascript:;"
									onclick="createTab(218,'词语过滤管理','system/censor_words','');"
									hidefocus="hidefocus">词语过滤管理</a>
								</li>
								<li class=""><a id="f219" class="second-menu-item"
									title="信息过滤审核" href="javascript:;"
									onclick="createTab(219,'信息过滤审核','system/censor_check','');"
									hidefocus="hidefocus">信息过滤审核</a>
								</li>
								<li class="expand"><a id="f96" class="second-menu-item"
									title="工作计划" href="javascript:;" onclick=""
									hidefocus="hidefocus">工作计划</a>
								<ul id="third-menulist-f96" class="third-menu">
										<li><a id="f97" class="third-menu-item"
											href="javascript:;" title="工作计划查询"
											onclick="createTab(97,'工作计划查询','work_plan/show','');"
											hidefocus="hidefocus">工作计划查询</a>
										</li>
										<li><a id="f98" class="third-menu-item"
											href="javascript:;" title="工作计划管理"
											onclick="createTab(98,'工作计划管理','work_plan/manage','');"
											hidefocus="hidefocus">工作计划管理</a>
										</li>
										<li><a id="f114" class="third-menu-item"
											href="javascript:;" title="工作计划类型设置"
											onclick="createTab(114,'工作计划类型设置','work_plan/type','');"
											hidefocus="hidefocus">工作计划类型设置</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f126" class="second-menu-item"
									title="办公用品" href="javascript:;" onclick=""
									hidefocus="hidefocus">办公用品</a>
								<ul id="third-menulist-f126" class="third-menu">
										<li><a id="f179" class="third-menu-item"
											href="javascript:;" title="办公用品申领"
											onclick="createTab(179,'办公用品申领','office_product/apply','');"
											hidefocus="hidefocus">办公用品申领</a>
										</li>
										<li><a id="f607" class="third-menu-item"
											href="javascript:;" title="办公用品审批"
											onclick="createTab(607,'办公用品审批','office_product/dept_approval','');"
											hidefocus="hidefocus">办公用品审批</a>
										</li>
										<li><a id="f539" class="third-menu-item"
											href="javascript:;" title="办公用品发放"
											onclick="createTab(539,'办公用品发放','office_product/grant','');"
											hidefocus="hidefocus">办公用品发放</a>
										</li>
										<li><a id="f251" class="third-menu-item"
											href="javascript:;" title="办公用品报表"
											onclick="createTab(251,'办公用品报表','office_product/report','');"
											hidefocus="hidefocus">办公用品报表</a>
										</li>
										<li><a id="f127" class="third-menu-item"
											href="javascript:;" title="办公用品信息管理"
											onclick="createTab(127,'办公用品信息管理','office_product/product_manage','');"
											hidefocus="hidefocus">办公用品信息管理</a>
										</li>
										<li><a id="f238" class="third-menu-item"
											href="javascript:;" title="办公用品库管理"
											onclick="createTab(238,'办公用品库管理','office_product/depository_manage','');"
											hidefocus="hidefocus">办公用品库管理</a>
										</li>
										<li><a id="f128" class="third-menu-item"
											href="javascript:;" title="办公用品库存管理"
											onclick="createTab(128,'办公用品库存管理','office_product/inventory_manage','');"
											hidefocus="hidefocus">办公用品库存管理</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f85" class="second-menu-item"
									title="会议申请与安排" href="javascript:;" onclick=""
									hidefocus="hidefocus">会议申请与安排</a>
								<ul id="third-menulist-f85" class="third-menu">
										<li><a id="f86" class="third-menu-item"
											href="javascript:;" title="会议申请"
											onclick="createTab(86,'会议申请','meeting/apply','');"
											hidefocus="hidefocus">会议申请</a>
										</li>
										<li><a id="f87" class="third-menu-item"
											href="javascript:;" title="会议查询"
											onclick="createTab(87,'会议查询','meeting/query','');"
											hidefocus="hidefocus">会议查询</a>
										</li>
										<li><a id="f88" class="third-menu-item"
											href="javascript:;" title="会议管理"
											onclick="createTab(88,'会议管理','meeting/manage','');"
											hidefocus="hidefocus">会议管理</a>
										</li>
										<li><a id="f89" class="third-menu-item"
											href="javascript:;" title="会议室设置"
											onclick="createTab(89,'会议室设置','meeting/meeting_room','');"
											hidefocus="hidefocus">会议室设置</a>
										</li>
										<li><a id="f137" class="third-menu-item"
											href="javascript:;" title="管理员设置"
											onclick="createTab(137,'管理员设置','meeting/operator','');"
											hidefocus="hidefocus">管理员设置</a>
										</li>
										<li><a id="f138" class="third-menu-item"
											href="javascript:;" title="会议纪要"
											onclick="createTab(138,'会议纪要','meeting/summary','');"
											hidefocus="hidefocus">会议纪要</a>
										</li>
										<li><a id="f222" class="third-menu-item"
											href="javascript:;" title="会议室设备管理"
											onclick="createTab(222,'会议室设备管理','meeting/equipment','');"
											hidefocus="hidefocus">会议室设备管理</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f90" class="second-menu-item"
									title="车辆申请与安排" href="javascript:;" onclick=""
									hidefocus="hidefocus">车辆申请与安排</a>
								<ul id="third-menulist-f90" class="third-menu">
										<li><a id="f91" class="third-menu-item"
											href="javascript:;" title="车辆使用申请"
											onclick="createTab(91,'车辆使用申请','vehicle','');"
											hidefocus="hidefocus">车辆使用申请</a>
										</li>
										<li><a id="f92" class="third-menu-item"
											href="javascript:;" title="车辆使用查询"
											onclick="createTab(92,'车辆使用查询','vehicle/query','');"
											hidefocus="hidefocus">车辆使用查询</a>
										</li>
										<li><a id="f152" class="third-menu-item"
											href="javascript:;" title="部门审批管理"
											onclick="createTab(152,'部门审批管理','vehicle/dept_manage','');"
											hidefocus="hidefocus">部门审批管理</a>
										</li>
										<li><a id="f93" class="third-menu-item"
											href="javascript:;" title="车辆使用管理"
											onclick="createTab(93,'车辆使用管理','vehicle/checkup','');"
											hidefocus="hidefocus">车辆使用管理</a>
										</li>
										<li><a id="f94" class="third-menu-item"
											href="javascript:;" title="车辆维护管理"
											onclick="createTab(94,'车辆维护管理','vehicle/maintenance','');"
											hidefocus="hidefocus">车辆维护管理</a>
										</li>
										<li><a id="f95" class="third-menu-item"
											href="javascript:;" title="车辆信息管理"
											onclick="createTab(95,'车辆信息管理','vehicle/manage','');"
											hidefocus="hidefocus">车辆信息管理</a>
										</li>
										<li><a id="f118" class="third-menu-item"
											href="javascript:;" title="调度人员管理"
											onclick="createTab(118,'调度人员管理','vehicle/operator','');"
											hidefocus="hidefocus">调度人员管理</a>
										</li>
										<li><a id="f237" class="third-menu-item"
											href="javascript:;" title="油耗统计"
											onclick="createTab(237,'油耗统计','vehicle/oil_cost','');"
											hidefocus="hidefocus">油耗统计</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f108" class="second-menu-item"
									title="固定资产" href="javascript:;" onclick=""
									hidefocus="hidefocus">固定资产</a>
								<ul id="third-menulist-f108" class="third-menu">
										<li><a id="f109" class="third-menu-item"
											href="javascript:;" title="参数设置"
											onclick="createTab(109,'参数设置','asset/config','');"
											hidefocus="hidefocus">参数设置</a>
										</li>
										<li><a id="f110" class="third-menu-item"
											href="javascript:;" title="固定资产管理"
											onclick="createTab(110,'固定资产管理','asset/manage','');"
											hidefocus="hidefocus">固定资产管理</a>
										</li>
										<li><a id="f112" class="third-menu-item"
											href="javascript:;" title="固定资产查询"
											onclick="createTab(112,'固定资产查询','asset/query','');"
											hidefocus="hidefocus">固定资产查询</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f51" class="second-menu-item"
									title="图书管理" href="javascript:;" onclick=""
									hidefocus="hidefocus">图书管理</a>
								<ul id="third-menulist-f51" class="third-menu">
										<li><a id="f53" class="third-menu-item"
											href="javascript:;" title="图书录入"
											onclick="createTab(53,'图书录入','book/manage','');"
											hidefocus="hidefocus">图书录入</a>
										</li>
										<li><a id="f54" class="third-menu-item"
											href="javascript:;" title="图书查询"
											onclick="createTab(54,'图书查询','book/query','');"
											hidefocus="hidefocus">图书查询</a>
										</li>
										<li><a id="f153" class="third-menu-item"
											href="javascript:;" title="借还书管理"
											onclick="createTab(153,'借还书管理','book/borrow_manage','');"
											hidefocus="hidefocus">借还书管理</a>
										</li>
										<li><a id="f217" class="third-menu-item"
											href="javascript:;" title="图书管理设置"
											onclick="createTab(217,'图书管理设置','book/book_set','');"
											hidefocus="hidefocus">图书管理设置</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f150" class="second-menu-item"
									title="资源申请与管理" href="javascript:;" onclick=""
									hidefocus="hidefocus">资源申请与管理</a>
								<ul id="third-menulist-f150" class="third-menu">
										<li><a id="f239" class="third-menu-item"
											href="javascript:;" title="资源申请与管理"
											onclick="createTab(239,'资源申请与管理','source/manage','');"
											hidefocus="hidefocus">资源申请与管理</a>
										</li>
										<li><a id="f240" class="third-menu-item"
											href="javascript:;" title="周期性资源安排"
											onclick="createTab(240,'周期性资源安排','source/cyclesource','');"
											hidefocus="hidefocus">周期性资源安排</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f43" class="second-menu-item"
									title="组织机构信息" href="javascript:;" onclick=""
									hidefocus="hidefocus">组织机构信息</a>
								<ul id="third-menulist-f43" class="third-menu">
										<li><a id="f17" class="third-menu-item"
											href="javascript:;" title="单位信息查询"
											onclick="createTab(17,'单位信息查询','info/unit','');"
											hidefocus="hidefocus">单位信息查询</a>
										</li>
										<li><a id="f18" class="third-menu-item"
											href="javascript:;" title="部门信息查询"
											onclick="createTab(18,'部门信息查询','info/dept','');"
											hidefocus="hidefocus">部门信息查询</a>
										</li>
										<li><a id="f19" class="third-menu-item"
											href="javascript:;" title="用户信息查询"
											onclick="createTab(19,'用户信息查询','info/user','');"
											hidefocus="hidefocus">用户信息查询</a>
										</li>
									</ul>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-30">
						<div id="m30" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">知识管理</span>
						</div>
						<div id="second-menu-30" class="second-panel"
							style="display: none;">
							<h4>知识管理</h4>
							<ul id="second-menulist-30" class="second-menu clearfix">
								<li class=""><a id="f15" class="second-menu-item"
									title="公共文件柜" href="javascript:;"
									onclick="createTab(15,'公共文件柜','knowledge_management','');"
									hidefocus="hidefocus">公共文件柜</a>
								</li>
								<li class=""><a id="f36" class="second-menu-item"
									title="公共文件柜设置" href="javascript:;"
									onclick="createTab(36,'公共文件柜设置','system/file_folder','');"
									hidefocus="hidefocus">公共文件柜设置</a>
								</li>
								<li class=""><a id="f70" class="second-menu-item"
									title="安全文档中心" href="javascript:;"
									onclick="createTab(70,'安全文档中心','safe_doc','');"
									hidefocus="hidefocus">安全文档中心</a>
								</li>
								<li class=""><a id="f76" class="second-menu-item"
									title="网络硬盘" href="javascript:;"
									onclick="createTab(76,'网络硬盘','netdisk','');"
									hidefocus="hidefocus">网络硬盘</a>
								</li>
								<li class=""><a id="f77" class="second-menu-item"
									title="网络硬盘设置" href="javascript:;"
									onclick="createTab(77,'网络硬盘设置','system/netdisk','');"
									hidefocus="hidefocus">网络硬盘设置</a>
								</li>
								<li class=""><a id="f115" class="second-menu-item"
									title="图片浏览" href="javascript:;"
									onclick="createTab(115,'图片浏览','picture','');"
									hidefocus="hidefocus">图片浏览</a>
								</li>
								<li class=""><a id="f116" class="second-menu-item"
									title="图片浏览设置" href="javascript:;"
									onclick="createTab(116,'图片浏览设置','system/picture','');"
									hidefocus="hidefocus">图片浏览设置</a>
								</li>
								<li class=""><a id="f185" class="second-menu-item"
									title="OA知道" href="javascript:;"
									onclick="createTab(185,'OA知道','zhidao','');"
									hidefocus="hidefocus">OA知道</a>
								</li>
								<li class=""><a id="f235" class="second-menu-item"
									title="维基百科" href="javascript:;"
									onclick="createTab(235,'维基百科','wiki','');"
									hidefocus="hidefocus">维基百科</a>
								</li>
								<li class=""><a id="f535" class="second-menu-item"
									title="文档检索中心" href="javascript:;"
									onclick="createTab(535,'文档检索中心','index','');"
									hidefocus="hidefocus">文档检索中心</a>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-40">
						<div id="m40" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">智能门户</span>
						</div>
						<div id="second-menu-40" class="second-panel"
							style="display: none; top: -22px; left: 200px;">
							<h4>智能门户</h4>
							<ul id="second-menulist-40" class="second-menu clearfix">
								<li class=""><a id="f59" class="second-menu-item"
									title="我的门户" href="javascript:;"
									onclick="createTab(59,'我的门户','portal','');"
									hidefocus="hidefocus">我的门户</a>
								</li>
								<li class=""><a id="f133" class="second-menu-item"
									title="门户管理" href="javascript:;"
									onclick="createTab(133,'门户管理','system/portal/setting','');"
									hidefocus="hidefocus">门户管理</a>
								</li>
								<li class=""><a id="f64" class="second-menu-item"
									title="门户模版管理" href="javascript:;"
									onclick="createTab(64,'门户模版管理','system/portal/template','');"
									hidefocus="hidefocus">门户模版管理</a>
								</li>
								<li class=""><a id="f257" class="second-menu-item"
									title="门户内容管理" href="javascript:;"
									onclick="createTab(257,'门户内容管理','system/portal/content','');"
									hidefocus="hidefocus">门户内容管理</a>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-45">
						<div id="m45" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">管理中心</span>
						</div>
						<div id="second-menu-45" class="second-panel"
							style="display: none;">
							<h4>管理中心</h4>
							<ul id="second-menulist-45" class="second-menu clearfix">
								<li class=""><a id="f2" class="second-menu-item"
									title="管理中心门户" href="javascript:;"
									onclick="createTab(2,'管理中心门户','management_center/portal','');"
									hidefocus="hidefocus">管理中心门户</a>
								</li>
								<li class=""><a id="f74" class="second-menu-item"
									title="管理驾驶舱" href="javascript:;"
									onclick="createTab(74,'管理驾驶舱','management_center/cockpit','');"
									hidefocus="hidefocus">管理驾驶舱</a>
								</li>
								<li class="expand"><a id="f12" class="second-menu-item"
									title="管理中心设置" href="javascript:;" onclick=""
									hidefocus="hidefocus">管理中心设置</a>
								<ul id="third-menulist-f12" class="third-menu">
										<li><a id="f68" class="third-menu-item"
											href="javascript:;" title="全局设置"
											onclick="createTab(68,'全局设置','management_center/setting/global','');"
											hidefocus="hidefocus">全局设置</a>
										</li>
										<li><a id="f66" class="third-menu-item"
											href="javascript:;" title="分类设置"
											onclick="createTab(66,'分类设置','management_center/setting/class','');"
											hidefocus="hidefocus">分类设置</a>
										</li>
										<li><a id="f67" class="third-menu-item"
											href="javascript:;" title="权限设置"
											onclick="createTab(67,'权限设置','management_center/setting/priv','');"
											hidefocus="hidefocus">权限设置</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f13" class="second-menu-item"
									title="BI设计中心" href="javascript:;" onclick=""
									hidefocus="hidefocus">BI设计中心</a>
								<ul id="third-menulist-f13" class="third-menu">
										<li><a id="f14" class="third-menu-item"
											href="javascript:;" title="智能报表BI设计"
											onclick="createTab(14,'智能报表BI设计','bi_design/reportshop','');"
											hidefocus="hidefocus">智能报表BI设计</a>
										</li>
										<li><a id="f40" class="third-menu-item"
											href="javascript:;" title="工作流BI设计"
											onclick="createTab(40,'工作流BI设计','bi_design/workflow','');"
											hidefocus="hidefocus">工作流BI设计</a>
										</li>
										<li><a id="f41" class="third-menu-item"
											href="javascript:;" title="OA业务BI设计"
											onclick="createTab(41,'OA业务BI设计','bi_design/oa','');"
											hidefocus="hidefocus">OA业务BI设计</a>
										</li>
										<li><a id="f44" class="third-menu-item"
											href="javascript:;" title="外部业务BI设计"
											onclick="createTab(44,'外部业务BI设计','bi_design/external','');"
											hidefocus="hidefocus">外部业务BI设计</a>
										</li>
										<li><a id="f75" class="third-menu-item"
											href="javascript:;" title="管理驾驶舱设置"
											onclick="createTab(75,'管理驾驶舱设置','bi_design/cockpit','');"
											hidefocus="hidefocus">管理驾驶舱设置</a>
										</li>
									</ul>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-50">
						<div id="m50" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">人力资源</span>
						</div>
						<div id="second-menu-50" class="second-panel"
							style="display: none;">
							<h4>人力资源</h4>
							<ul id="second-menulist-50" class="second-menu clearfix">
								<li class=""><a id="f511" class="second-menu-item"
									title="员工自助查询" href="javascript:;"
									onclick="createTab(511,'员工自助查询','hr/self_find','');"
									hidefocus="hidefocus">员工自助查询</a>
								</li>
								<li class="expand"><a id="f27" class="second-menu-item"
									title="人事管理" href="javascript:;" onclick=""
									hidefocus="hidefocus">人事管理</a>
								<ul id="third-menulist-f27" class="third-menu">
										<li><a id="f60" class="third-menu-item"
											href="javascript:;" title="人事档案"
											onclick="createTab(60,'人事档案','hr/manage/staff_info','');"
											hidefocus="hidefocus">人事档案</a>
										</li>
										<li><a id="f61" class="third-menu-item"
											href="javascript:;" title="档案查询"
											onclick="createTab(61,'档案查询','hr/manage/query','');"
											hidefocus="hidefocus">档案查询</a>
										</li>
										<li><a id="f481" class="third-menu-item"
											href="javascript:;" title="合同管理"
											onclick="createTab(481,'合同管理','hr/manage/staff_contract','');"
											hidefocus="hidefocus">合同管理</a>
										</li>
										<li><a id="f482" class="third-menu-item"
											href="javascript:;" title="奖惩管理"
											onclick="createTab(482,'奖惩管理','hr/manage/staff_incentive','');"
											hidefocus="hidefocus">奖惩管理</a>
										</li>
										<li><a id="f483" class="third-menu-item"
											href="javascript:;" title="证照管理"
											onclick="createTab(483,'证照管理','hr/manage/staff_license','');"
											hidefocus="hidefocus">证照管理</a>
										</li>
										<li><a id="f484" class="third-menu-item"
											href="javascript:;" title="学习经历"
											onclick="createTab(484,'学习经历','hr/manage/staff_learn_experience','');"
											hidefocus="hidefocus">学习经历</a>
										</li>
										<li><a id="f485" class="third-menu-item"
											href="javascript:;" title="工作经历"
											onclick="createTab(485,'工作经历','hr/manage/staff_work_experience','');"
											hidefocus="hidefocus">工作经历</a>
										</li>
										<li><a id="f486" class="third-menu-item"
											href="javascript:;" title="劳动技能"
											onclick="createTab(486,'劳动技能','hr/manage/staff_labor_skills','');"
											hidefocus="hidefocus">劳动技能</a>
										</li>
										<li><a id="f487" class="third-menu-item"
											href="javascript:;" title="社会关系"
											onclick="createTab(487,'社会关系','hr/manage/staff_relatives','');"
											hidefocus="hidefocus">社会关系</a>
										</li>
										<li><a id="f488" class="third-menu-item"
											href="javascript:;" title="人事调动"
											onclick="createTab(488,'人事调动','hr/manage/staff_transfer','');"
											hidefocus="hidefocus">人事调动</a>
										</li>
										<li><a id="f489" class="third-menu-item"
											href="javascript:;" title="离职管理"
											onclick="createTab(489,'离职管理','hr/manage/staff_leave','');"
											hidefocus="hidefocus">离职管理</a>
										</li>
										<li><a id="f490" class="third-menu-item"
											href="javascript:;" title="复职管理"
											onclick="createTab(490,'复职管理','hr/manage/staff_reinstatement','');"
											hidefocus="hidefocus">复职管理</a>
										</li>
										<li><a id="f491" class="third-menu-item"
											href="javascript:;" title="职称评定"
											onclick="createTab(491,'职称评定','hr/manage/staff_title_evaluation','');"
											hidefocus="hidefocus">职称评定</a>
										</li>
										<li><a id="f492" class="third-menu-item"
											href="javascript:;" title="员工关怀"
											onclick="createTab(492,'员工关怀','hr/manage/staff_care','');"
											hidefocus="hidefocus">员工关怀</a>
										</li>
										<li><a id="f120" class="third-menu-item"
											href="javascript:;" title="人事分析"
											onclick="createTab(120,'人事分析','hr/manage/staff_analysis','');"
											hidefocus="hidefocus">人事分析</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f494" class="second-menu-item"
									title="招聘管理" href="javascript:;" onclick=""
									hidefocus="hidefocus">招聘管理</a>
								<ul id="third-menulist-f494" class="third-menu">
										<li><a id="f495" class="third-menu-item"
											href="javascript:;" title="招聘需求"
											onclick="createTab(495,'招聘需求','hr/recruit/requirements','');"
											hidefocus="hidefocus">招聘需求</a>
										</li>
										<li><a id="f496" class="third-menu-item"
											href="javascript:;" title="招聘计划"
											onclick="createTab(496,'招聘计划','hr/recruit/plan','');"
											hidefocus="hidefocus">招聘计划</a>
										</li>
										<li><a id="f497" class="third-menu-item"
											href="javascript:;" title="招聘计划审批"
											onclick="createTab(497,'招聘计划审批','hr/recruit/plan_approval','');"
											hidefocus="hidefocus">招聘计划审批</a>
										</li>
										<li><a id="f498" class="third-menu-item"
											href="javascript:;" title="人才库"
											onclick="createTab(498,'人才库','hr/recruit/hr_pool','');"
											hidefocus="hidefocus">人才库</a>
										</li>
										<li><a id="f499" class="third-menu-item"
											href="javascript:;" title="招聘筛选"
											onclick="createTab(499,'招聘筛选','hr/recruit/filter','');"
											hidefocus="hidefocus">招聘筛选</a>
										</li>
										<li><a id="f500" class="third-menu-item"
											href="javascript:;" title="招聘录用"
											onclick="createTab(500,'招聘录用','hr/recruit/recruitment','');"
											hidefocus="hidefocus">招聘录用</a>
										</li>
										<li><a id="f501" class="third-menu-item"
											href="javascript:;" title="人才分析"
											onclick="createTab(501,'人才分析','hr/recruit/analysis','');"
											hidefocus="hidefocus">人才分析</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f502" class="second-menu-item"
									title="培训管理" href="javascript:;" onclick=""
									hidefocus="hidefocus">培训管理</a>
								<ul id="third-menulist-f502" class="third-menu">
										<li><a id="f503" class="third-menu-item"
											href="javascript:;" title="培训计划"
											onclick="createTab(503,'培训计划','hr/training/plan','');"
											hidefocus="hidefocus">培训计划</a>
										</li>
										<li><a id="f505" class="third-menu-item"
											href="javascript:;" title="培训计划审批"
											onclick="createTab(505,'培训计划审批','hr/training/approval/','');"
											hidefocus="hidefocus">培训计划审批</a>
										</li>
										<li><a id="f504" class="third-menu-item"
											href="javascript:;" title="培训记录"
											onclick="createTab(504,'培训记录','hr/training/record','');"
											hidefocus="hidefocus">培训记录</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f26" class="second-menu-item"
									title="考勤管理" href="javascript:;" onclick=""
									hidefocus="hidefocus">考勤管理</a>
								<ul id="third-menulist-f26" class="third-menu">
										<li><a id="f506" class="third-menu-item"
											href="javascript:;" title="考勤审批"
											onclick="createTab(506,'考勤审批','attendance/manage/confirm/','');"
											hidefocus="hidefocus">考勤审批</a>
										</li>
										<li><a id="f507" class="third-menu-item"
											href="javascript:;" title="考勤记录"
											onclick="createTab(507,'考勤记录','attendance/manage/user_manage','');"
											hidefocus="hidefocus">考勤记录</a>
										</li>
										<li><a id="f508" class="third-menu-item"
											href="javascript:;" title="考勤统计"
											onclick="createTab(508,'考勤统计','attendance/manage/query','');"
											hidefocus="hidefocus">考勤统计</a>
										</li>
										<li><a id="f515" class="third-menu-item"
											href="javascript:;" title="值班排班管理"
											onclick="createTab(515,'值班排班管理','attendance/manage/on_duty','');"
											hidefocus="hidefocus">值班排班管理</a>
										</li>
										<li><a id="f537" class="third-menu-item"
											href="javascript:;" title="查岗质询登记"
											onclick="createTab(537,'查岗质询登记','attendance/manage/ask_duty','');"
											hidefocus="hidefocus">查岗质询登记</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f122" class="second-menu-item"
									title="绩效考核" href="javascript:;" onclick=""
									hidefocus="hidefocus">绩效考核</a>
								<ul id="third-menulist-f122" class="third-menu">
										<li><a id="f123" class="third-menu-item"
											href="javascript:;" title="考核项目设定"
											onclick="createTab(123,'考核项目设定','score/group','');"
											hidefocus="hidefocus">考核项目设定</a>
										</li>
										<li><a id="f124" class="third-menu-item"
											href="javascript:;" title="考核任务管理"
											onclick="createTab(124,'考核任务管理','score/flow','');"
											hidefocus="hidefocus">考核任务管理</a>
										</li>
										<li><a id="f628" class="third-menu-item"
											href="javascript:;" title="被考核人自评"
											onclick="createTab(628,'被考核人自评','score/self_assessment','');"
											hidefocus="hidefocus">被考核人自评</a>
										</li>
										<li><a id="f125" class="third-menu-item"
											href="javascript:;" title="进行考核"
											onclick="createTab(125,'进行考核','score/submit','');"
											hidefocus="hidefocus">进行考核</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f630" class="second-menu-item"
									title="积分管理" href="javascript:;" onclick=""
									hidefocus="hidefocus">积分管理</a>
								<ul id="third-menulist-f630" class="third-menu">
										<li><a id="f631" class="third-menu-item"
											href="javascript:;" title="积分录入"
											onclick="createTab(631,'积分录入','hr/integral/input','');"
											hidefocus="hidefocus">积分录入</a>
										</li>
										<li><a id="f632" class="third-menu-item"
											href="javascript:;" title="积分查询"
											onclick="createTab(632,'积分查询','hr/integral/query','');"
											hidefocus="hidefocus">积分查询</a>
										</li>
										<li><a id="f633" class="third-menu-item"
											href="javascript:;" title="积分项设置"
											onclick="createTab(633,'积分项设置','hr/integral/item_setting','');"
											hidefocus="hidefocus">积分项设置</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f55" class="second-menu-item"
									title="薪酬管理" href="javascript:;" onclick=""
									hidefocus="hidefocus">薪酬管理</a>
								<ul id="third-menulist-f55" class="third-menu">
										<li><a id="f514" class="third-menu-item"
											href="javascript:;" title="薪酬项目及保险设置"
											onclick="createTab(514,'薪酬项目及保险设置','hr/salary/insurance_para','');"
											hidefocus="hidefocus">薪酬项目及保险设置</a>
										</li>
										<li><a id="f509" class="third-menu-item"
											href="javascript:;" title="薪酬基数设置"
											onclick="createTab(509,'薪酬基数设置','hr/salary/staff_insurance','');"
											hidefocus="hidefocus">薪酬基数设置</a>
										</li>
										<li><a id="f29" class="third-menu-item"
											href="javascript:;" title="工资流程管理"
											onclick="createTab(29,'工资流程管理','hr/salary/manage','');"
											hidefocus="hidefocus">工资流程管理</a>
										</li>
										<li><a id="f28" class="third-menu-item"
											href="javascript:;" title="财务工资录入"
											onclick="createTab(28,'财务工资录入','hr/salary/submit','');"
											hidefocus="hidefocus">财务工资录入</a>
										</li>
										<li><a id="f129" class="third-menu-item"
											href="javascript:;" title="部门工资上报"
											onclick="createTab(129,'部门工资上报','hr/salary/report','');"
											hidefocus="hidefocus">部门工资上报</a>
										</li>
										<li><a id="f510" class="third-menu-item"
											href="javascript:;" title="福利管理"
											onclick="createTab(510,'福利管理','hr/salary/welfare_manage','');"
											hidefocus="hidefocus">福利管理</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f224" class="second-menu-item"
									title="人力资源设置" href="javascript:;" onclick=""
									hidefocus="hidefocus">人力资源设置</a>
								<ul id="third-menulist-f224" class="third-menu">
										<li><a id="f39" class="third-menu-item"
											href="javascript:;" title="考勤设置"
											onclick="createTab(39,'考勤设置','hr/setting/attendance','');"
											hidefocus="hidefocus">考勤设置</a>
										</li>
										<li><a id="f512" class="third-menu-item"
											href="javascript:;" title="人力资源管理员"
											onclick="createTab(512,'人力资源管理员','hr/setting/hr_manager','');"
											hidefocus="hidefocus">人力资源管理员</a>
										</li>
										<li><a id="f513" class="third-menu-item"
											href="javascript:;" title="HRMS代码设置"
											onclick="createTab(513,'HRMS代码设置','hr/setting/hr_code','');"
											hidefocus="hidefocus">HRMS代码设置</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f252" class="second-menu-item"
									title="在线考试" href="javascript:;" onclick=""
									hidefocus="hidefocus">在线考试</a>
								<ul id="third-menulist-f252" class="third-menu">
										<li><a id="f230" class="third-menu-item"
											href="javascript:;" title="题库管理"
											onclick="createTab(230,'题库管理','exam_manage/set_manage','');"
											hidefocus="hidefocus">题库管理</a>
										</li>
										<li><a id="f231" class="third-menu-item"
											href="javascript:;" title="试题管理"
											onclick="createTab(231,'试题管理','exam_manage/quiz_manage/','');"
											hidefocus="hidefocus">试题管理</a>
										</li>
										<li><a id="f232" class="third-menu-item"
											href="javascript:;" title="试卷管理"
											onclick="createTab(232,'试卷管理','exam_manage/paper_manage/','');"
											hidefocus="hidefocus">试卷管理</a>
										</li>
										<li><a id="f629" class="third-menu-item"
											href="javascript:;" title="主观题阅卷"
											onclick="createTab(629,'主观题阅卷','exam_manage/subject_score/','');"
											hidefocus="hidefocus">主观题阅卷</a>
										</li>
										<li><a id="f233" class="third-menu-item"
											href="javascript:;" title="考试信息管理"
											onclick="createTab(233,'考试信息管理','exam_manage/info_pub/','');"
											hidefocus="hidefocus">考试信息管理</a>
										</li>
										<li><a id="f234" class="third-menu-item"
											href="javascript:;" title="参加考试"
											onclick="createTab(234,'参加考试','exam_manage/exam_online','');"
											hidefocus="hidefocus">参加考试</a>
										</li>
									</ul>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-65">
						<div id="m65" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">公文管理</span>
						</div>
						<div id="second-menu-65" class="second-panel"
							style="display: none;">
							<h4>公文管理</h4>
							<ul id="second-menulist-65" class="second-menu clearfix">
								<li class="expand"><a id="f461" class="second-menu-item"
									title="发文管理" href="javascript:;" onclick=""
									hidefocus="hidefocus">发文管理</a>
								<ul id="third-menulist-f461" class="third-menu">
										<li><a id="f462" class="third-menu-item"
											href="javascript:;" title="发文拟稿"
											onclick="createTab(462,'发文拟稿','document/index.php/send/draft','');"
											hidefocus="hidefocus">发文拟稿</a>
										</li>
										<li><a id="f463" class="third-menu-item"
											href="javascript:;" title="发文核稿"
											onclick="createTab(463,'发文核稿','document/index.php/send/approve','');"
											hidefocus="hidefocus">发文核稿</a>
										</li>
										<li><a id="f464" class="third-menu-item"
											href="javascript:;" title="套红盖章"
											onclick="createTab(464,'套红盖章','document/index.php/send/seal','');"
											hidefocus="hidefocus">套红盖章</a>
										</li>
										<li><a id="f465" class="third-menu-item"
											href="javascript:;" title="发文列表"
											onclick="createTab(465,'发文列表','document/index.php/send/sendlist','');"
											hidefocus="hidefocus">发文列表</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f466" class="second-menu-item"
									title="收文管理" href="javascript:;" onclick=""
									hidefocus="hidefocus">收文管理</a>
								<ul id="third-menulist-f466" class="third-menu">
										<li><a id="f467" class="third-menu-item"
											href="javascript:;" title="收文登记"
											onclick="createTab(467,'收文登记','document/index.php/recv/register','');"
											hidefocus="hidefocus">收文登记</a>
										</li>
										<li><a id="f468" class="third-menu-item"
											href="javascript:;" title="领导批阅"
											onclick="createTab(468,'领导批阅','document/index.php/recv/approve','');"
											hidefocus="hidefocus">领导批阅</a>
										</li>
										<li><a id="f469" class="third-menu-item"
											href="javascript:;" title="收文分发"
											onclick="createTab(469,'收文分发','document/index.php/recv/outgiving','');"
											hidefocus="hidefocus">收文分发</a>
										</li>
										<li><a id="f470" class="third-menu-item"
											href="javascript:;" title="收文阅读"
											onclick="createTab(470,'收文阅读','document/index.php/recv/read','');"
											hidefocus="hidefocus">收文阅读</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f471" class="second-menu-item"
									title="基础设置" href="javascript:;" onclick=""
									hidefocus="hidefocus">基础设置</a>
								<ul id="third-menulist-f471" class="third-menu">
										<li><a id="f472" class="third-menu-item"
											href="javascript:;" title="参数设置"
											onclick="createTab(472,'参数设置','document/index.php/setting/config','');"
											hidefocus="hidefocus">参数设置</a>
										</li>
										<li><a id="f473" class="third-menu-item"
											href="javascript:;" title="主题词管理"
											onclick="createTab(473,'主题词管理','document/index.php/setting/keywords','');"
											hidefocus="hidefocus">主题词管理</a>
										</li>
										<li><a id="f474" class="third-menu-item"
											href="javascript:;" title="公文类型设置"
											onclick="createTab(474,'公文类型设置','document/index.php/setting/type','');"
											hidefocus="hidefocus">公文类型设置</a>
										</li>
										<li><a id="f475" class="third-menu-item"
											href="javascript:;" title="收文权限设置"
											onclick="createTab(475,'收文权限设置','document/index.php/setting/priv','');"
											hidefocus="hidefocus">收文权限设置</a>
										</li>
									</ul>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-70">
						<div id="m70" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">档案管理</span>
						</div>
						<div id="second-menu-70" class="second-panel"
							style="display: none;">
							<h4>档案管理</h4>
							<ul id="second-menulist-70" class="second-menu clearfix">
								<li class=""><a id="f200" class="second-menu-item"
									title="卷库管理" href="javascript:;"
									onclick="createTab(200,'卷库管理','roll_manage/roll_room','');"
									hidefocus="hidefocus">卷库管理</a>
								</li>
								<li class=""><a id="f202" class="second-menu-item"
									title="案卷管理" href="javascript:;"
									onclick="createTab(202,'案卷管理','roll_manage','');"
									hidefocus="hidefocus">案卷管理</a>
								</li>
								<li class=""><a id="f201" class="second-menu-item"
									title="文件管理" href="javascript:;"
									onclick="createTab(201,'文件管理','roll_manage/roll_file','');"
									hidefocus="hidefocus">文件管理</a>
								</li>
								<li class=""><a id="f209" class="second-menu-item"
									title="档案销毁" href="javascript:;"
									onclick="createTab(209,'档案销毁','roll_manage/destory','');"
									hidefocus="hidefocus">档案销毁</a>
								</li>
								<li class="expand"><a id="f203" class="second-menu-item"
									title="案卷借阅" href="javascript:;" onclick=""
									hidefocus="hidefocus">案卷借阅</a>
								<ul id="third-menulist-f203" class="third-menu">
										<li><a id="f204" class="third-menu-item"
											href="javascript:;" title="案卷借阅"
											onclick="createTab(204,'案卷借阅','roll_manage/roll_lend','');"
											hidefocus="hidefocus">案卷借阅</a>
										</li>
										<li><a id="f205" class="third-menu-item"
											href="javascript:;" title="借阅审批"
											onclick="createTab(205,'借阅审批','roll_manage/roll_lend/confirm.php','');"
											hidefocus="hidefocus">借阅审批</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f206" class="second-menu-item"
									title="档案统计" href="javascript:;" onclick=""
									hidefocus="hidefocus">档案统计</a>
								<ul id="third-menulist-f206" class="third-menu">
										<li><a id="f207" class="third-menu-item"
											href="javascript:;" title="借阅统计"
											onclick="createTab(207,'借阅统计','roll_manage/roll_statistic/lend.php','');"
											hidefocus="hidefocus">借阅统计</a>
										</li>
										<li><a id="f208" class="third-menu-item"
											href="javascript:;" title="案卷统计"
											onclick="createTab(208,'案卷统计','roll_manage/roll_statistic/roll.php','');"
											hidefocus="hidefocus">案卷统计</a>
										</li>
									</ul>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-90">
						<div id="m90" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">项目管理</span>
						</div>
						<div id="second-menu-90" class="second-panel"
							style="display: none;">
							<h4>项目管理</h4>
							<ul id="second-menulist-90" class="second-menu clearfix">
								<li class=""><a id="f65" class="second-menu-item"
									title="我的项目" href="javascript:;"
									onclick="createTab(65,'我的项目','project/portal','');"
									hidefocus="hidefocus">我的项目</a>
								</li>
								<li class=""><a id="f187" class="second-menu-item"
									title="我的任务" href="javascript:;"
									onclick="createTab(187,'我的任务','project/task','');"
									hidefocus="hidefocus">我的任务</a>
								</li>
								<li class=""><a id="f186" class="second-menu-item"
									title="项目查询" href="javascript:;"
									onclick="createTab(186,'项目查询','project/proj','');"
									hidefocus="hidefocus">项目查询</a>
								</li>
								<li class=""><a id="f188" class="second-menu-item"
									title="项目审批" href="javascript:;"
									onclick="createTab(188,'项目审批','project/approve','');"
									hidefocus="hidefocus">项目审批</a>
								</li>
								<li class=""><a id="f189" class="second-menu-item"
									title="项目文档" href="javascript:;"
									onclick="createTab(189,'项目文档','project/file','');"
									hidefocus="hidefocus">项目文档</a>
								</li>
								<li class=""><a id="f190" class="second-menu-item"
									title="项目问题" href="javascript:;"
									onclick="createTab(190,'项目问题','project/bug','');"
									hidefocus="hidefocus">项目问题</a>
								</li>
								<li class="expand"><a id="f191" class="second-menu-item"
									title="基础数据设置" href="javascript:;" onclick=""
									hidefocus="hidefocus">基础数据设置</a>
								<ul id="third-menulist-f191" class="third-menu">
										<li><a id="f606" class="third-menu-item"
											href="javascript:;" title="项目自定义设置"
											onclick="createTab(606,'项目自定义设置','project/setting/cust/sys','');"
											hidefocus="hidefocus">项目自定义设置</a>
										</li>
										<li><a id="f192" class="third-menu-item"
											href="javascript:;" title="项目权限设置"
											onclick="createTab(192,'项目权限设置','project/setting/priv','');"
											hidefocus="hidefocus">项目权限设置</a>
										</li>
										<li><a id="f193" class="third-menu-item"
											href="javascript:;" title="项目代码设置"
											onclick="createTab(193,'项目代码设置','project/setting/code','');"
											hidefocus="hidefocus">项目代码设置</a>
										</li>
										<li><a id="f221" class="third-menu-item"
											href="javascript:;" title="项目模板管理"
											onclick="createTab(221,'项目模板管理','project/setting/template','');"
											hidefocus="hidefocus">项目模板管理</a>
										</li>
									</ul>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-a0">
						<div id="ma0" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">ERP应用</span>
						</div>
						<div id="second-menu-a0" class="second-panel"
							style="display: none;">
							<h4>ERP应用</h4>
							<ul id="second-menulist-a0" class="second-menu clearfix">
								<li class=""><a id="f550" class="second-menu-item"
									title="应用中心" href="javascript:;"
									onclick="createTab(550,'应用中心','reportshop/workshop','');"
									hidefocus="hidefocus">应用中心</a>
								</li>
								<li class=""><a id="f551" class="second-menu-item"
									title="管理平台" href="javascript:;"
									onclick="createTab(551,'管理平台','reportshop/design/report','');"
									hidefocus="hidefocus">管理平台</a>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-b0">
						<div id="mb0" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">交流园地</span>
						</div>
						<div id="second-menu-b0" class="second-panel"
							style="display: none;">
							<h4>交流园地</h4>
							<ul id="second-menulist-b0" class="second-menu clearfix">
								<li class=""><a id="f73" class="second-menu-item"
									title="企业社区" href="javascript:;"
									onclick="createTab(73,'企业社区','sns','');" hidefocus="hidefocus">企业社区</a>
								</li>
								<li class=""><a id="f62" class="second-menu-item"
									title="讨论区" href="javascript:;"
									onclick="createTab(62,'讨论区','bbs','');" hidefocus="hidefocus">讨论区</a>
								</li>
								<li class=""><a id="f63" class="second-menu-item"
									title="论坛" href="javascript:;"
									onclick="createTab(63,'论坛','bbs2','');" hidefocus="hidefocus">论坛</a>
								</li>
								<li class=""><a id="f34" class="second-menu-item"
									title="讨论区设置" href="javascript:;"
									onclick="createTab(34,'讨论区设置','system/bbs','');"
									hidefocus="hidefocus">讨论区设置</a>
								</li>
								<li class=""><a id="f532" class="second-menu-item"
									title="专业视频会议" href="javascript:;"
									onclick="createTab(532,'专业视频会议','gbtmeet','');"
									hidefocus="hidefocus">专业视频会议</a>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-e0">
						<div id="me0" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">T10超能云中心平台</span>
						</div>
						<div id="second-menu-e0" class="second-panel"
							style="display: none;">
							<h4>T10超能云中心平台</h4>
							<ul id="second-menulist-e0" class="second-menu clearfix">
								<li class="expand"><a id="f548" class="second-menu-item"
									title="平台设置" href="javascript:;" onclick=""
									hidefocus="hidefocus">平台设置</a>
								<ul id="third-menulist-f548" class="third-menu">
										<li><a id="f640" class="third-menu-item"
											href="javascript:;" title="参数设置"
											onclick="createTab(640,'参数设置','ext_data/admin/setting','');"
											hidefocus="hidefocus">参数设置</a>
										</li>
										<li><a id="f641" class="third-menu-item"
											href="javascript:;" title="流程模型同步"
											onclick="createTab(641,'流程模型同步','ext_data/admin/model','');"
											hidefocus="hidefocus">流程模型同步</a>
										</li>
										<li><a id="f642" class="third-menu-item"
											href="javascript:;" title="交换历史记录"
											onclick="createTab(642,'交换历史记录','ext_data/admin/logs','');"
											hidefocus="hidefocus">交换历史记录</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f549" class="second-menu-item"
									title="信息接收与发布" href="javascript:;" onclick=""
									hidefocus="hidefocus">信息接收与发布</a>
								<ul id="third-menulist-f549" class="third-menu">
										<li><a id="f601" class="third-menu-item"
											href="javascript:;" title="信息接收"
											onclick="createTab(601,'信息接收','ext_data/info/recv','');"
											hidefocus="hidefocus">信息接收</a>
										</li>
										<li><a id="f600" class="third-menu-item"
											href="javascript:;" title="信息发布"
											onclick="createTab(600,'信息发布','ext_data/info/send','');"
											hidefocus="hidefocus">信息发布</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f602" class="second-menu-item"
									title="工作接收与处理" href="javascript:;" onclick=""
									hidefocus="hidefocus">工作接收与处理</a>
								<ul id="third-menulist-f602" class="third-menu">
										<li><a id="f603" class="third-menu-item"
											href="javascript:;" title="待办工作"
											onclick="createTab(603,'待办工作','ext_data/workflow/my','');"
											hidefocus="hidefocus">待办工作</a>
										</li>
										<li><a id="f604" class="third-menu-item"
											href="javascript:;" title="权限与规则设置"
											onclick="createTab(604,'权限与规则设置','ext_data/workflow/rule','');"
											hidefocus="hidefocus">权限与规则设置</a>
										</li>
									</ul>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-y0">
						<div id="my0" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">附件程序</span>
						</div>
						<div id="second-menu-y0" class="second-panel"
							style="display: none;">
							<h4>附件程序</h4>
							<ul id="second-menulist-y0" class="second-menu clearfix">
								<li class=""><a id="f227" class="second-menu-item"
									title="即时通讯" href="javascript:;"
									onclick="createTab(227,'即时通讯','im/show','');"
									hidefocus="hidefocus">即时通讯</a>
								</li>
								<li class="expand"><a id="f46" class="second-menu-item"
									title="实用信息" href="javascript:;" onclick=""
									hidefocus="hidefocus">实用信息</a>
								<ul id="third-menulist-f46" class="third-menu">
										<li><a id="f21" class="third-menu-item"
											href="javascript:;" title="电话区号查询"
											onclick="createTab(21,'电话区号查询','info/tel_no','');"
											hidefocus="hidefocus">电话区号查询</a>
										</li>
										<li><a id="f22" class="third-menu-item"
											href="javascript:;" title="邮政编码查询"
											onclick="createTab(22,'邮政编码查询','info/post_no','');"
											hidefocus="hidefocus">邮政编码查询</a>
										</li>
									</ul>
								</li>
							</ul>
						</div></li>
					<li data-submenu-id="second-menu-z0">
						<div id="mz0" hidefocus="hidefocus" class="first-menu-item">
							<i class="iconfont"></i><span class="first-menu-title">系统管理</span>
						</div>
						<div id="second-menu-z0" class="second-panel"
							style="display: none;">
							<h4>系统管理</h4>
							<ul id="second-menulist-z0" class="second-menu clearfix">
								<li class=""><a id="f69" class="second-menu-item"
									title="功能管理中心" href="javascript:;"
									onclick="createTab(69,'功能管理中心','system/module_center','');"
									hidefocus="hidefocus">功能管理中心</a>
								</li>
								<li class=""><a id="f71" class="second-menu-item"
									title="企业号管理" href="javascript:;"
									onclick="createTab(71,'企业号管理','system/qyapp','');"
									hidefocus="hidefocus">企业号管理</a>
								</li>
								<li class=""><a id="f72" class="second-menu-item"
									title="APP应用商店设置" href="javascript:;"
									onclick="createTab(72,'APP应用商店设置','system/app','');"
									hidefocus="hidefocus">APP应用商店设置</a>
								</li>
								<li class=""><a id="f223" class="second-menu-item"
									title="印章管理" href="javascript:;"
									onclick="createTab(223,'印章管理','system/seal_manage','');"
									hidefocus="hidefocus">印章管理</a>
								</li>
								<li class=""><a id="f639" class="second-menu-item"
									title="手机签章管理" href="javascript:;"
									onclick="createTab(639,'手机签章管理','system/mobile_seal','');"
									hidefocus="hidefocus">手机签章管理</a>
								</li>
								<li class=""><a id="f225" class="second-menu-item"
									title="定时任务管理" href="javascript:;"
									onclick="createTab(225,'定时任务管理','system/task','');"
									hidefocus="hidefocus">定时任务管理</a>
								</li>
								<li class=""><a id="f236" class="second-menu-item"
									title="紧急通知设置" href="javascript:;"
									onclick="createTab(236,'紧急通知设置','system/urgent_notify','');"
									hidefocus="hidefocus">紧急通知设置</a>
								</li>
								<li class=""><a id="f78" class="second-menu-item"
									title="界面设置" href="javascript:;"
									onclick="createTab(78,'界面设置','system/interface','');"
									hidefocus="hidefocus">界面设置</a>
								</li>
								<li class=""><a id="f178" class="second-menu-item"
									title="状态栏设置" href="javascript:;"
									onclick="createTab(178,'状态栏设置','system/status_text','');"
									hidefocus="hidefocus">状态栏设置</a>
								</li>
								<li class=""><a id="f104" class="second-menu-item"
									title="菜单设置" href="javascript:;"
									onclick="createTab(104,'菜单设置','system/menu','');"
									hidefocus="hidefocus">菜单设置</a>
								</li>
								<li class=""><a id="f121" class="second-menu-item"
									title="系统代码设置" href="javascript:;"
									onclick="createTab(121,'系统代码设置','system/code','');"
									hidefocus="hidefocus">系统代码设置</a>
								</li>
								<li class=""><a id="f149" class="second-menu-item"
									title="自定义字段设置" href="javascript:;"
									onclick="createTab(149,'自定义字段设置','system/field','');"
									hidefocus="hidefocus">自定义字段设置</a>
								</li>
								<li class=""><a id="f84" class="second-menu-item"
									title="数据库管理" href="javascript:;"
									onclick="createTab(84,'数据库管理','system/database','');"
									hidefocus="hidefocus">数据库管理</a>
								</li>
								<li class=""><a id="f99" class="second-menu-item"
									title="系统日志管理" href="javascript:;"
									onclick="createTab(99,'系统日志管理','system/log','');"
									hidefocus="hidefocus">系统日志管理</a>
								</li>
								<li class=""><a id="f100" class="second-menu-item"
									title="系统资源管理" href="javascript:;"
									onclick="createTab(100,'系统资源管理','system/res_manage','');"
									hidefocus="hidefocus">系统资源管理</a>
								</li>
								<li class=""><a id="f533" class="second-menu-item"
									title="附件管理" href="javascript:;"
									onclick="createTab(533,'附件管理','system/attachment','');"
									hidefocus="hidefocus">附件管理</a>
								</li>
								<li class=""><a id="f101" class="second-menu-item"
									title="系统访问控制" href="javascript:;"
									onclick="createTab(101,'系统访问控制','system/access_control','');"
									hidefocus="hidefocus">系统访问控制</a>
								</li>
								<li class=""><a id="f113" class="second-menu-item"
									title="系统参数设置" href="javascript:;"
									onclick="createTab(113,'系统参数设置','system/security','');"
									hidefocus="hidefocus">系统参数设置</a>
								</li>
								<li class=""><a id="f198" class="second-menu-item"
									title="系统接口设置" href="javascript:;"
									onclick="createTab(198,'系统接口设置','system/ext_user','');"
									hidefocus="hidefocus">系统接口设置</a>
								</li>
								<li class=""><a id="f540" class="second-menu-item"
									title="服务器监控" href="javascript:;"
									onclick="createTab(540,'服务器监控','system/monitor','');"
									hidefocus="hidefocus">服务器监控</a>
								</li>
								<li class=""><a id="f626" class="second-menu-item"
									title="三员安全管理" href="javascript:;"
									onclick="createTab(626,'三员安全管理','system/secure_rule','');"
									hidefocus="hidefocus">三员安全管理</a>
								</li>
								<li class=""><a id="f638" class="second-menu-item"
									title="T-ERPLinker数据源管理" href="javascript:;"
									onclick="createTab(638,'T-ERPLinker数据源管理','system/t-erplinker/data_source','');"
									hidefocus="hidefocus">T-ERPLinker数据源管理</a>
								</li>
								<li class=""><a id="f38" class="second-menu-item"
									title="系统信息" href="javascript:;"
									onclick="createTab(38,'系统信息','system/reg_view','');"
									hidefocus="hidefocus">系统信息</a>
								</li>
								<li class="expand"><a id="f56" class="second-menu-item"
									title="组织机构设置" href="javascript:;" onclick=""
									hidefocus="hidefocus">组织机构设置</a>
								<ul id="third-menulist-f56" class="third-menu">
										<li><a id="f30" class="third-menu-item"
											href="javascript:;" title="单位管理"
											onclick="createTab(30,'单位管理','system/unit','');"
											hidefocus="hidefocus">单位管理</a>
										</li>
										<li><a id="f31" class="third-menu-item"
											href="javascript:;" title="部门管理"
											onclick="createTab(31,'部门管理','system/dept','');"
											hidefocus="hidefocus">部门管理</a>
										</li>
										<li><a id="f33" class="third-menu-item"
											href="javascript:;" title="用户管理"
											onclick="createTab(33,'用户管理','system/user','');"
											hidefocus="hidefocus">用户管理</a>
										</li>
										<li><a id="f32" class="third-menu-item"
											href="javascript:;" title="角色与权限管理"
											onclick="createTab(32,'角色与权限管理','system/user_priv','');"
											hidefocus="hidefocus">角色与权限管理</a>
										</li>
										<li><a id="f605" class="third-menu-item"
											href="javascript:;" title="外部机构管理"
											onclick="createTab(605,'外部机构管理','system/ext_dept','');"
											hidefocus="hidefocus">外部机构管理</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f57" class="second-menu-item"
									title="行政办公设置" href="javascript:;" onclick=""
									hidefocus="hidefocus">行政办公设置</a>
								<ul id="third-menulist-f57" class="third-menu">
										<li><a id="f609" class="third-menu-item"
											href="javascript:;" title="日程安排设置"
											onclick="createTab(609,'日程安排设置','system/calendar','');"
											hidefocus="hidefocus">日程安排设置</a>
										</li>
										<li><a id="f103" class="third-menu-item"
											href="javascript:;" title="公共网址设置"
											onclick="createTab(103,'公共网址设置','system/url','');"
											hidefocus="hidefocus">公共网址设置</a>
										</li>
										<li><a id="f146" class="third-menu-item"
											href="javascript:;" title="工作日志设置"
											onclick="createTab(146,'工作日志设置','system/diary','');"
											hidefocus="hidefocus">工作日志设置</a>
										</li>
										<li><a id="f107" class="third-menu-item"
											href="javascript:;" title="公共通讯簿设置"
											onclick="createTab(107,'公共通讯簿设置','system/address','');"
											hidefocus="hidefocus">公共通讯簿设置</a>
										</li>
										<li><a id="f197" class="third-menu-item"
											href="javascript:;" title="公告通知设置"
											onclick="createTab(197,'公告通知设置','system/notify','');"
											hidefocus="hidefocus">公告通知设置</a>
										</li>
										<li><a id="f228" class="third-menu-item"
											href="javascript:;" title="模板管理"
											onclick="createTab(228,'模板管理','system/model','');"
											hidefocus="hidefocus">模板管理</a>
										</li>
									</ul>
								</li>
								<li class="expand"><a id="f58" class="second-menu-item"
									title="信息交流设置" href="javascript:;" onclick=""
									hidefocus="hidefocus">信息交流设置</a>
								<ul id="third-menulist-f58" class="third-menu">
										<li><a id="f538" class="third-menu-item"
											href="javascript:;" title="电子邮件设置"
											onclick="createTab(538,'电子邮件设置','system/email','');"
											hidefocus="hidefocus">电子邮件设置</a>
										</li>
										<li><a id="f151" class="third-menu-item"
											href="javascript:;" title="短信提醒设置"
											onclick="createTab(151,'短信提醒设置','system/remind','');"
											hidefocus="hidefocus">短信提醒设置</a>
										</li>
										<li><a id="f6" class="third-menu-item"
											href="javascript:;" title="手机短信设置"
											onclick="createTab(6,'手机短信设置','system/mobile_sms','');"
											hidefocus="hidefocus">手机短信设置</a>
										</li>
										<li><a id="f534" class="third-menu-item"
											href="javascript:;" title="即时通讯管理"
											onclick="createTab(534,'即时通讯管理','system/im','');"
											hidefocus="hidefocus">即时通讯管理</a>
										</li>
									</ul>
								</li>
							</ul>
						</div></li>
				</ul>
				<div class="menu-scroll scroll-down" style="display: block;"></div>
			</div>
		</div>
		<div class="west-footer">
			<span id="new_sms_sound"
				style="width:1px;height:1px;position:fixed;bottom:0px;left:0px;"></span>
			<ul class="ft-links clearfix">
				<li class="ft-link ft-link-icon"><a href="javascript:;"
					class="iconfont" onClick="createTab(59,'我的门户','portal','');"
					data-placement="top" data-toggle="tooltip" title=""
					data-original-title="我的门户" data-step="3"
					data-intro="<b style='display:block'>3、我的门户</b>点击打开“门户列表”区域，选择您想打开的门户。"
					data-position="top">&#xe60e;</a>
				</li>
				<li class="ft-link ft-link-icon"><a href="/module/help"
					class="iconfont" hidefocus="hidefocus" data-placement="top"
					data-toggle="tooltip" title="" data-original-title="在线帮助"
					target="_blank" data-step="4"
					data-intro="<b style='display:block'>4、在线帮助</b>“通达OA在线帮助”汇集了常见的用户问题，帮助用户快速掌握软件各项功能的使用。"
					data-position="top">&#xe61b;</a>
				</li>
				<li class="ft-link"><a href="javascript:;"
					style="height: 22px !important;font-size: 18px;"
					class="west-handle" data-step="5"
					data-intro="<b style='display:block'>5、图标模式</b>点击切换菜单模式。"
					data-position="top"><i class="iconfont left_arrow"
						data-placement="top" data-toggle="tooltip" title=""
						data-original-title="图标模式">&#xe636;</i><i
						class="iconfont right_arrow" data-placement="top"
						data-toggle="tooltip" title="" data-original-title="图标+文字模式">&#xe637;</i>
				</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="center" class="center">
		<div class="tosbg" id="tosbg">
			<div>
				<img src="img/logo_tos.png" /><a href="javascript:;"
					onClick="createTab('portal_5','我的桌面','../portal/personal/','');">我的桌面</a>
			</div>
		</div>
		<div id="notice_tip">
			<div id="notice_head"></div>
			<div id="notice_body"></div>
			<div id="notice_foot"></div>
		</div>
	</div>

	<ul class="msg-list">
		<div id="msg-ignore">
			<i class="iconfont"></i><span>忽略全部</span>
		</div>
	</ul>
	<div id="east" class="east">
		<ul class="nav nav-tabs">
			<li class="nav-pill active" panelType="today"><a
				href="javascript:;" class="pill-bg">今日</a>
			</li>
			<li class="nav-pill" panelType="msg"><a href="javascript:;"
				class="pill-bg">消息</a>
			</li>
			<li class="nav-pill" panelType="org"><a href="javascript:;"
				class="pill-bg">组织</a>
			</li>
		</ul>
		<div class="tab-content" id="east-tab">
			<div class="tab-pane pane-today active">
				<div class="dateArea" id="datetime">
					<div id="date" class="weather-date" title="2017年3月28日">
						<span>3月28日</span>星期二
					</div>
					<div id="mdate" title="农历 三月初一">农历三月初一</div>
				</div>
				<div class="mod" id="weatherarea">
					<div class="mod-hd">
						<span class="mod-hd-title">天气</span>
						<div class="city">
							<i id="changecity" class="iconfont">&#xe63f;</i>
						</div>
					</div>
					<div class="mod-bd">
						<span id="city"></span>
						<div id="weather" class="clearfix"></div>
						<div id="area_select" style="display: none">
							<div>
								<select id="w_province" onChange="InitCity(this.value);"></select>
								<select id="w_city" onChange="InitCounty(this.value);"></select>
								<select id="w_county"></select>
							</div>
							<div class="btns">
								<button type="button" class="btn btn-mini btn-primary"
									id="saveWeather">确定</button>
								<button type="button" class="btn btn-mini" id="closeWeather">取消</button>
							</div>
						</div>
					</div>
				</div>
				<div class="mod">
					<div class="mod-hd">
						<span class="mod-hd-title">日程</span>
					</div>
					<div class="mod-bd">
						<ul id="cal_list" class="calendar-list"></ul>
						<div class="notip" id="caltip">今日暂无日程</div>
					</div>
				</div>
				<div class="mod">
					<div class="mod-hd">
						<span class="mod-hd-title">提醒事项</span>
					</div>
					<div class="mod-bd">
						<ul id="remind_list" class="remind_list"></ul>
						<div class="notip" id="remindtip">今日暂无提醒</div>
					</div>
				</div>
			</div>
			<div class="tab-pane pane-msg">
				<div class="btn-group msg-tool" id="msg-tool">
					<button type="button" msg-panel="nocbox"
						class="btn btn-mini btn-primary">
						<span>事务提醒</span>
					</button>
					<button type="button" msg-panel="weixun" class="btn btn-mini">
						<span>微讯</span>
					</button>
				</div>
				<div id="nocbox" class="msg-panel active">
					<div class="noc" id="new_noc_panel">
						<div id="nocbox_tips" class="nocbox_tips">
							<div class="loading"></div>
						</div>
						<div id="nodata_tips" class="nodata_tips">
							<div class="">
								没有未读的事务提醒<a href="javascript:;" hidefocus="hidefocus"
									id="tohistory" class="tohistory">查看历史消息</a>
							</div>
						</div>
						<div class="noc-info" id="new_noc_title">
							共<span id="noc_item_num" class="noc_item_num">0</span>条消息记录
						</div>
						<div id="new_noc_list_wrapper">
							<div id="new_noc_list" class="new_noc_list"></div>
						</div>
						<div class="noc-nav-bar">
							<a href="javascript:;" hidefocus="hidefocus" id="ViewAllNoc"
								class="viewbtn"><i class="iconfont">&#xe60c;</i>全部已阅</a> <a
								href="javascript:;" hidefocus="hidefocus" id="ViewDetail"
								class="viewbtn"><i class="iconfont">&#xe609;</i>查看全部</a> <a
								href="javascript:;" hidefocus="hidefocus" class="noc-right"
								id="check_remind_histroy"><i class="iconfont">&#xe606;</i>历史消息</a>
						</div>
					</div>
				</div>
				<div id="weixun" class="msg-panel">
					<div class="weixun-panel active" id="recent">
						<ul class="recentlist" id="recentlist"></ul>
						<div class="rec_tips" id="rec_tips">暂无最近联系人</div>
						<div class="rec-ft">
							<button type="button" id="tosend"
								class="btn btn-info btn-mini pull-left">
								<i class="iconfont multi">&#xe605;</i>群发
							</button>
							<i class="iconfont refresh pull-right" title="刷新"
								id="refresh-rec">&#xe60a;</i> <i class="iconfont del pull-right"
								title="清空" id="clear-rec">&#xe644;</i>
						</div>

					</div>
					<div class="weixun-panel" id="send">
						<div class="sendwrapper">
							<a href="javascript:;" id="torecent">返回</a>
							<div class="input-append send-header">
								<input id="search" type="text"> <span
									class="send-inner-icon"><i
									class="iconfont send-info-size">&#xe603;</i>
								</span>
								<button tyle="button" class="send-info-btn btn" id="adduser">
									<i class="iconfont send-info-size">&#xe602;</i>
								</button>
							</div>
							<div class="send_mod">
								<div class="send_hd clearfix">
									<a href="javascript:;" id="clearall"
										class="clearall pull-right">清空</a>
								</div>
								<div class="send_bd user-tags" id="user-tags"></div>
								<div class="no-tag-tips" id="no-tag-tips">暂未选择任何联系人</div>
								<input type="hidden" id="userid" name="TO_UID"> <input
									type="hidden" id="username" name="TO_NAME">
							</div>
							<div>
								<a href="javascript:;" class="getmore" id="getmore">更多</a>
							</div>
							<div class="send-footer">
								<div id="uploader" class="uploader">
									<div class="btns pick">
										<div id="picker">选择文件</div>
									</div>
									<div id="uploadlist" class="uploader-list"></div>
								</div>
								<textarea id="sms_content" name="CONTENT"></textarea>
								<div class="send-footer-info clearfix">
									<input type="hidden" name="I_VER" value=""> <input
										type="hidden" name="C" value="">
									<button type="button" class="btn btn-primary pull-right"
										data-loading-text="正在发送" id="sms_send">发送</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane pane-org">
				<div class="btn-group org_tool" id="org_tool">
					<button type="button" class="btn btn-mini online-btn btn-primary"
						user-type="user_online">
						<span>在线</span><span class="user_online"></span>
					</button>
					<button type="button" class="btn btn-mini online-btn"
						user-type="user_all">
						<span>全部</span>
					</button>
				</div>
				<div class="org-panel" id="org_panel">
					<div id="user_online" class="online-panel">
						<div id="orgTree0"></div>
					</div>
					<div id="user_all" class="online-panel">
						<div id="orgTree1"></div>
					</div>
				</div>
			</div>
		</div>
		<a href="javascript:;" class="east-handle"><i
			class="iconfont left_arrow">&#xe637;</i>
		</a>
		<div class="chat-wrapper" id="chat-wrapper">
			<div class="chat_side">
				<!--<div id="smsbox_scroll_up" style="display: none;"></div>-->
				<div id="smsbox_list">
					<div id="smsbox_list_container" class="list-container"></div>
				</div>
				<!--<div id="smsbox_scroll_down" style="display: none;"></div>-->
			</div>
			<div class="chat_panel">
				<div class="chat-header">
					<h6 id="chat-title" class="chat-title"></h6>
					<span id="chat-status" class="chat-status"></span>
					<button type="button" class="close" id="smsbox_toolbar_del">×</button>
					<button type="button" class="close" id="smsbox_toolbar_shrink">-</button>
				</div>
				<div class="chat-body" id="smsbox_msg_container">
					<div id="moreHistoryMsg">
						<a target="_blank">点击查看更多</a><img src="img/loading.gif"
							style="display:none;">
					</div>
				</div>
				<div class="chat-footer" id="chat_uploader">
					<textarea id="smsbox_textarea"></textarea>
					<div class="send_area">
						<div class="send_tool">
							<a href="javascript:;" id="uploadBar"><i class="iconfont">&#xe642;</i>
							</a> <a href="javascript:;" id="quickBar"><i class="iconfont">&#xe643;</i>
							</a>
							<div class="quickReply" id="quickReplyPop">
								<select id="smsbox_rapid_reply"
									title="请到系统管理->系统代码->微讯快捷回复 进行设置">
									<option value="">快捷回复</option>
								</select>
								<div class="quickarrow"></div>
							</div>
						</div>
						<button class="btn btn-small btn-primary" id="smsbox_send_msg"
							data-loading-text="提交中">发送</button>
					</div>
				</div>
			</div>
			<div class="chat-delete" id="chat-delete">
				<div class="close_hd">
					关闭会话
					<button type="button" class="close" id="chatDeleteClose">×</button>
				</div>
				<div class="close_bd">关闭所有会话还是关闭当前会话？</div>
				<div class="close_ft">
					<button class="btn btn-mini btn-warning" type="button"
						id="closeAllChat">关闭所有</button>
					<button class="btn btn-mini" type="button" id="closeActiveChat">关闭当前</button>
				</div>
			</div>
		</div>
	</div>
	<div id="mask"></div>
	<!--聊天窗口-->

	<!-- lijun -->
	<div class="search-container">
		<!-- 关闭按钮 -->
		<div class="iconfont search-close-btn">&#xe621;</div>
		<!-- 搜索框 -->
		<div class="search-box">
			<span class="search-input"><input id="search-input"
				type="text" autocomplete="off"
				placeholder="搜索用户、菜单、工作流、通讯簿、日程、帮助...">
			</span> <span class="search-btn"><input id="search-btn" type="submit"
				value="搜索" search-type="user">
			</span>
		</div>

		<!-- 搜索结果返回区 -->
		<div class="search-results-wrapper">
			<!-- 搜索结果切换tab -->
			<ul class="search-results-tabs">
				<li class="user-tab active" search-type="user" searched=""><span>用户</span><span
					class="search-counter search-counter-user">(0)</span>
				</li>
				<li class="menu-tab" search-type="menu" searched=""><span>菜单</span><span
					class="search-counter search-counter-menu">(0)</span>
				</li>
				<li class="workflow-tab" search-type="workflow" searched=""><span>工作流</span><span
					class="search-counter search-counter-workflow">(0)</span>
				</li>
				<li class="contacts-tab" search-type="contacts" searched=""><span>通讯簿</span><span
					class="search-counter search-counter-contacts">(0)</span>
				</li>
				<li class="calendar-tab" search-type="calendar" searched=""><span>日程安排</span><span
					class="search-counter search-counter-calendar">(0)</span>
				</li>
				<li class="helper-tab" search-type="helper"><span><a
						href="/module/help" target="_blank">在线帮助</a>
				</span>
				</li>
			</ul>
			<!-- 陈列所有结果 -->
			<div class="search-results-container" id="search-results-container">
				<div class="search-results-iscroll">
					<ul class="search-results-user">
						<!-- 翻页插件容器 -->
						<div id="pagination-user" class="pagination"></div>
					</ul>
					<ul class="search-results-menu">
						<!-- 翻页插件容器 -->
						<div id="pagination-menu" class="pagination"></div>
					</ul>
					<ul class="search-results-workflow">
						<!-- 翻页插件容器 -->
						<div id="pagination-workflow" class="pagination"></div>
					</ul>
					<ul class="search-results-contacts">
						<!-- 翻页插件容器 -->
						<div id="pagination-contacts" class="pagination"></div>
					</ul>
					<ul class="search-results-calendar">
						<!-- 翻页插件容器 -->
						<div id="pagination-calendar" class="pagination"></div>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- 激光加载条(pulse bar) -->
	<div id="progressBar" class="done">
		<span id="flashBar"></span>
	</div>

	<!-- 消息(Message) -->
	<div id="mini-notification">
		<p>The notification has been successfully displayed</p>
	</div>

	<!-- lijun -->

	<!-- 主题切换 -->
	<div id="theme_panel" class="over-mask-layer">
		<div class="center">
			<div class="theme clearfix" id="theme_slider"></div>
		</div>
	</div>
	<div id="overlay_theme"></div>

</body>
<!--一级菜单-->
<script id="menuTmpl" type="text/x-jquery-tmpl">
<li data-submenu-id="second-menu-${menuId}">
	<div id="m${menuId}" hidefocus="hidefocus" class="first-menu-item"><i class="iconfont">${iconfont}</i><span class="first-menu-title">${menuText}</span></div>
	<div id="second-menu-${menuId}" class="second-panel">
		<h4>${menuText}</h4>
		<ul id="second-menulist-${menuId}" class="second-menu clearfix">  
		</ul>
	</div>
</li> 
</script>
<!--二级菜单-->
<script id="secondMenuTmpl" type="text/x-jquery-tmpl">
<li class="{{if expand !=false }}expand{{/if}}"><a id="${menuId}" class="second-menu-item" title="${menuText}" href="javascript:;" onclick="${actionType}" hidefocus="hidefocus">${menuText}</a>{{if expand !=false }}<ul id="third-menulist-${menuId}" class="third-menu"></ul>{{/if}}</li>
</script>
<!--三级菜单-->
<script id="thirdMenuTmpl" type="text/x-jquery-tmpl">
<li><a id="${menuId}" class="third-menu-item" href="javascript:;" title="${menuText}" onclick="${actionType}" hidefocus="hidefocus">${menuText}</a></li>
</script>
<!--系统消息提示条-->

<script type="text/template" id="item-template">
<div class="msg-wrapper  msg-id-${mid}">
	<div class="msg-icon iconfont">{{if msgTipIconfont[$data.mid]}}  ${msgTipIconfont[$data.mid]}  {{else}} ${msgTipIconfont[24]} {{/if}} </div>
	<p class="msg-title">${title}</p>
	<p class="msg-content">${msg}</p>
	<div class="msg-count">${num}</div>
	<div class="msg-close"></div>
    <div class="msg-op">
        <i>
            <svg version="1.1" id="图形" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="1024px" height="1024px" viewBox="0 0 1024 1024" enable-background="img/823d04c2301246f4a6e627c55b4729c1.gif" xml:space="preserve">
                <path fill="#272636" d="M746.662019 300c0-51.835575 42.044582-93.865831 93.865831-93.865831 51.851948 0 93.865831 42.029232 93.865831 93.865831 0 51.836599-42.013883 93.865831-93.865831 93.865831C788.706601 393.864808 746.662019 351.836599 746.662019 300zM89.604272 300c0-51.835575 42.043558-93.865831 93.864808-93.865831 51.822272 0 93.865831 42.029232 93.865831 93.865831 0 51.836599-42.043558 93.865831-93.865831 93.865831C131.648854 393.864808 89.604272 351.836599 89.604272 300zM418.132634 300c0-51.835575 42.013883-93.865831 93.866854-93.865831 51.821249 0 93.864808 42.029232 93.864808 93.865831 0 51.836599-42.043558 93.865831-93.864808 93.865831C460.146517 393.864808 418.132634 351.836599 418.132634 300z" transform="translate(0, 812) scale(1, -1)"/>
            </svg>
        </i>
        <div class="msg-op-btns">
            <div class="ignore-this">忽略此条</div>
            <div class="ignore-all">忽略全部</div>
            {{if $data.mid != "message" }}
            	<div class="mark-read">已阅此条</div>
            	<div class="mark-all">已阅全部</div>
            {{/if}}
        </div>
</div>
</div>
</script>
<!--天气-->
<script type="text/template" id="weather-templ">
<div class="tempimg">
    <img src="img/${img1}.png" /> 
    <img src="img/${img2}.png" /> 
    <div class="temperature">${temperature}</div>
</div>
<div class="temp">
    <span>${weather}</span>
    <span>${wind}</span>
</div>
</script>
<!--聊天窗口左侧人-->
<script id="chatUser-template" type="text/template">
<div class="chatuser ${unread}" group_id="${from_id}" user="${from_id}" online="${online_status}" >
    <img src="img/efcdb092c2c3430aa488c15380238784.gif" />
    <span class="fromname">${from_name}</span>
    <span class="count">
    {{if count>0}}
        ${count}
    {{/if}}
    </span>
    <i class="iconfont">&#xe621;</i>
</div>
</script>
<!--聊天窗口右侧消息-->
<script type="text/template" id="chatMsg-template">
<div class="chatmsg {{if $data.from_id == loginUser.uid }} to {{else}} from {{/if}} clearfix" sms_id="${sms_id}" type_id="${type_id}" url="${url}" from_type_name="${from_type_name}">
    <div class="chat-popbox-dialogbox-time">${time}</div>
    <div class="chat-popbox-dialogbox">
        <div class="chat-popbox-avatar">
            <img src="img/efcdb092c2c3430aa488c15380238784.gif" onerror='fixAvatar(${from_id});' class="ui-li-thumb"/>
        </div>
        <div class="chat-popbox-bg">{{html content}}</div>
    </div>
</div>
</script>
<!--会话部分-->
<script id="recentList-template" type="text/template">
<li>
	<a href="javascript:;" fromid="${from_id}" class="recentItem">
		<img src="img/efcdb092c2c3430aa488c15380238784.gif" class="rec_avatar" onerror='fixAvatar(${from_id});'/>
		<div class="rec_info">
		    <span class="rec_name">${from_name}</span>
		    <span class="rec_time">${time_stamp}</span>
		    <p class="rec_content">{{html content}}</p>
		</div>    
	</a>
</li>
</script>
<!--日程-->
<script id="calendar-template" type="text/template">
<li><a href="javascript:;" cal_id="${id}" cal_type="${type}" class="common-font"><span class="cal_content">{{html formatCalendarTitle(title) }}</span><span class="pull-right">${shortstart}</span></a></li>
</script>
<!--提醒事项-->
<script id="reminder-template" type="text/template">
<li><a href="javascript:;" data_id="${id}" class="common-font"><span class="cal_content">${title}</span><span class="pull-right">${appoint_time}</span></a></li>
</script>
<!--事务提醒模块-->
<script id="noc-template" type="text/template">
<div class="noc_item noc_item_${type_id}">
    <div class="noc_item_title">
        <a href="javascript:;" class="noc_item_read pull-right" type_id="${type_id}" title='查看全部'><i class="iconfont">&#xe609;</i></a>
        <a href="javascript:;" class="noc_item_cancel pull-right" type_id="${type_id}" title='全部已阅'><i class="iconfont">&#xe640;</i></a>
        <span>${type_name}</span>
    </div>
    <ul class="noc_item_data">
    </ul>
</div>
</script>
<!--事务提醒条目-->
<script id="nocitem-template" type="text/template">
<li id="noc_li_${sms_id}" sms_id="${sms_id}" url="${url}" type_id="${type_id}" class="">
    <a href="javascript:;" class="noc-subitem">
        <p class="noc_item_info">
            <span class="noc_item_time pull-right ">${send_time}</span>
            <span class="name">${from_name}</span>
        </p>
        <p class="noc_item_content">{{html content }}</p>
    </a>
</li>
</script>
<!-- 搜索模块的js模板 -->
<!-- 用户模板 -->
<script type="text/template" id="search-template-user">
    <li u_id="${uid}" userid="${userid}">
        <div class="user-avatar"><a class="user-main-page" href="ipanel/user/user_info.php?USER_ID=${userid}" target="_blank"><img src="img/3435cca2777b476fab2f63e0bcc01658.gif"></a></div>
        <div class="user-body">
            <a class="user-body-name user-main-page" href="ipanel/user/user_info.php?USER_ID=${userid}" target="_blank">${userName}</a> 
            {{if cur_login_user_id != userid}}
                {{if is_concern == 0}}
                    <button class="user-body-follow">关注</button>
                    <button class="user-body-hasfollow hide">已关注</button>
                {{else}}
                    <button class="user-body-follow hide">关注</button>
                    <button class="user-body-hasfollow">已关注</button>
                {{/if}}
            {{else}}
            {{/if}}
            <div>${department}</div>
            <div>{{if phoneNum}}电话：${phoneNum}{{/if}} &nbsp;&nbsp;&nbsp; {{if email}}邮箱：${email}{{/if}} &nbsp;&nbsp;&nbsp; {{if qq}}QQ：${qq}{{/if}}</div>
            <div>{{if signature}}签名：${signature}{{/if}}</div>
        </div>
        <div class="op-labels">
            {{if isPriv}}
                <!-- no right to access -->
            {{else}}
                <a href="status_bar/sms_back.php?TO_UID=${uid}&TO_NAME=${userName}" target="_blank"><button class="send-msg">微讯</button></a>
                <a href="email/new/?TO_ID=${userid}&TO_NAME=${userName}" target="_blank"><button class="send-email">邮件</button></a>
            {{/if}}
        </div>
    </li>
</script>
<!-- 菜单模板 -->
<script type="text/template" id="search-template-menu">
    <li menu_id="${menuId}" onclick="createTab('${menuId}','${menuTitle}','${menuUrl}','');">${menuTitle}</li>
</script>
<!-- 工作流模板 -->
<script type="text/template" id="search-template-workflow">
    <li class="workflow-search-results" url="${url}" run_id="${runId}">
        <a flow_id="${flowId}">${runName}</a>
        <div>工作流ID：<span>${runId}</span> &nbsp;<br />当前办理步骤：第 <span>${prcsId}</span> 步</div>
    </li>
</script>
<!-- 通讯簿模板 -->
<script type="text/template" id="search-template-contacts">
    <li u_id="${uid}">
        <div class="contacts-avatar"><img src="img/3435cca2777b476fab2f63e0bcc01658.gif"></div>
        <div class="contacts-body">
            <span class="contacts-name">${uName}</span>
            <div class="contacts-company">${company} ${department}</div>
            <div class="contacts-contact">{{if phoneNum}}电话：${phoneNum}{{/if}} &nbsp;&nbsp;&nbsp; {{if email}}邮箱：${email}{{/if}} &nbsp;&nbsp;&nbsp; {{if qq}}QQ：${qq}{{/if}}</div>
            <div class="contacts-address">{{if address}}地址：${address}{{/if}}</div>
        </div>
        <div class="op-labels">
        {{if groupName != '1'}}
            {{if groupName == '0'}}
                <a href="email/new/?TO_ID=${userid}&TO_NAME=${uName}" target="_blank"><button class="send-email">邮件</button></a>
            {{else}}
                {{if email}}
                    <a href="email/new/?TO_WEBMAIL=${email}" target="_blank"><button class="send-email">邮件</button></a>
                {{/if}}
            {{/if}}
        {{/if}}
        </div>
    </li>
</script>
<!-- 日程安排模板 -->
<script type="text/template" id="search-template-calendar">
    <li cal_id="${calId}">
            <a href="calendar/arrange/cal_note.php?CAL_ID=${calId}" target="_blank">${content}</a>
            <div class="calendarTime" >${calTime} — ${endTime}</div>
    </li>
</script>
</html>
<div id="overlay"></div>
<div style="display:none;"></div>
</body>
</html>