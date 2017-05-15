<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!-- saved from url=(0082)file:///C:/Users/gaosubo/Desktop/OA%E7%B2%BE%E7%81%B5_files/saved_resource(1).html -->
<html><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <script type="text/javascript">
        var MYOA_JS_SERVER = "";
        var MYOA_STATIC_SERVER = "";
    </script>
    <link rel="stylesheet" type="text/css" href="../css/spirit/style.css">
    <link rel="stylesheet" type="text/css" href="../css/spirit/ipanel.css">
    <link rel="stylesheet" type="text/css" href="../css/main/theme1/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="../css/main/theme1/index.css"/>
    <link rel="stylesheet" type="text/css" href="../css/spirit/user_online.css">
    <link rel="stylesheet" type="text/css" href="../css/spirit/ui.dynatree.css">
    <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        function init() {
            jQuery("#body").height(jQuery(window).height() - jQuery("#sub_tabs").outerHeight());
        }

        window.onresize = init;
    </script>
</head>


<body onload="init();window.setTimeout(init, 1);" marginwidth="0" marginheight="0">
<div id="sub_tabs" class="sub_tabs">
    <ul id="sub_tabs_ul">
        <li><a href="javascript:;" title="人员" index="1" module="org" class="active"><span
                class="dropdown-containter"><label id="label_org">在线</label><span class="dropdown"></span></span></a>
        </li>
        <li><a href="javascript:;" title="分组" index="2" module="user_group"><span class="dropdown-containter">分组<span
                class="dropdown"></span></span></a></li>
        <li><a href="javascript:;" title="最近联系人" index="3" module="recent"><span>最近</span></a></li>
        <li><a href="javascript:;" title="群组" index="4" module="im_group"><span>群组</span></a></li>
    </ul>
    <a id="org_refresh" href="javascript:;" title="刷新"></a>
</div>
<div id="sub_menu_org" class="sub_menu" style="width: 110px; display: none;">
    <a href="javascript:;" index="0" class="active">显示在线人员</a>
    <a href="javascript:;" index="1" class="">显示全部人员</a>
</div>
<div id="sub_menu_user_group" class="sub_menu" style="width:110px;">
    <a href="javascript:;" index="0" class="active">我的自定义组</a>
    <a href="javascript:;" index="1" class="">公共自定义组</a>
</div>
<div id="body" style="height: calc(100% - 40px);">
    <div id="modules">
        <div id="module_org" class="container moduleContainer" style="display: block;">
            <div id="sub_module_org_0" class="module-block" style="">
                <ul class="dynatree-container dynatree-no-connector tab_ctwo" id="deptOrg">
                </ul>
            </div>
            <div id="sub_module_org_1" class="module-block" style="display:none;"></div>
        </div>
        <div id="module_user_group" class="container module-block" style="display:none;"></div>
        <div id="module_recent" class="container module-block" style="display:none;"></div>
        <div id="module_im_group" class="container module-block" style="display:none;"></div>
    </div>

    <div id="module_user_group_op_menu" class="attach_div small" style="width:80px;">
        <a op="msg" href="javascript:;"><span>微讯</span></a>
        <a op="email" href="javascript:;"><span>邮件</span></a>
    </div>

</div>

<script>
	//组织
		$('#sub_module_org_0 .tab_ctwo').on('click','.childdept',function(){
			var  that = $(this);
			console.log(that.attr("drop"));
			if(that.attr("drop")=="true"){
			 that.attr("drop",false);
			 removeChdept(that.next());
			}else{
			  that.attr("drop",true);
			  getChDept(that.next(),that.attr('deptid'));
			
			}
			
			
		});
		function removeChdept(target){
		
		   target.html("");
		}
		function getChDept(target,deptId){
			$.ajax({
				url:'<%=basePath%>/department/getChDept',
				type:'get',	
				data:{
					deptId:deptId
				},		
				dataType:'json',
				success:function(data){
					
					if(deptId==0){
						var str = '';
						data.obj.forEach(function(v,i){
							if(v.deptName){
								str+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span class="dynatree-checkbox"></span><img src="../img/main_img/company_logo.png" alt=""><a href="#" class="dynatree-title" title="'+v.deptName+'">'+v.deptName+'</a></span><ul style="margin-left:20px;"></ul></li>';
							}else{
								str+='<li onclick="openwin(this)"><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span class="dynatree-checkbox"></span><img src="../img/main_img/company_logo.png" alt=""><a href="#" class="dynatree-title" uid="'+v.uid+'" title="'+v.userName+'">'+v.userName+'</a></span><ul style="margin-left:20px;"></ul></li>';
							}
							
						});
					}else{
						var str = '';
						data.obj.forEach(function(v,i){
							if(v.deptName){
								str+='<li><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" title="'+v.deptName+'">'+v.deptName+'</a></span><ul style="margin-left:20px;"></ul></li>';
							}else{
								str+='<li onclick="openwin(this)"><span deptid="'+v.deptId+'" class="childdept dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef"><span class="dynatree-checkbox"></span><a href="#" class="dynatree-title" uid="'+v.uid+'" title="'+v.userName+'">'+v.userName+'</a></span><ul style="margin-left:20px;"></ul></li>';
							}
							
						});
					}
					
					
					target.html(str);
				}
			})
		}
			getChDept($('#deptOrg'),20);
			function openwin(e){
				var uid=$(e).find("a.dynatree-title").attr("uid");
				var uname=$(e).find("a.dynatree-title").attr("title");
				window.external.OA_SMS(uid,uname,"SEND_MSG");
			}
</script>

</body>
</html>