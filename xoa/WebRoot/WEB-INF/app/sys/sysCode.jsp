<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<title>系统代码设置</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<link rel="stylesheet" type="text/css" href="../css/sys/addUser.css"/>
	<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
	<script src="../js/ajaxupload.js" type="text/javascript" charset="utf-8"></script>
	<script>

	</script>
	<style type="text/css">
		.bodycolor {
			BACKGROUND: #f6f7f9;
			padding-top: 5px;
		}
		.small {
			font-size: 9pt;
			width: 100%;
			margin-top: 14px;
		}
		.head {
			text-align: center;
			font-size: 22px;
			margin-top: 16px;
			border-bottom: #999 1px solid;
		}
		.menuList {
			display: block;
			width: 100%;
			padding-left: 30px;
			font-size: 14px;
			height: 40px;
			line-height: 40px;
			border-bottom: #ddd 1px solid;
			cursor: pointer;
		}
		.menuList span {
			color:black;
		}
		#bodycolor{
			margin-top: 10px;
			border-bottom: #ddd 1px solid;
		}
		.TableBlock {
			border: 1px #dddddd solid;
			line-height: 20px;
			font-size: 9pt;
			border-collapse: collapse;
		}
		.TableBlock_sub {
			width: 32%;
			margin: 0 auto;
			font-size: 14px;
			margin-top: 10px;
		}
		.TableHeader {
			COLOR: #383838;
			FONT-WEIGHT: bold;
			FONT-SIZE: 9pt;
			background: #fff;
			line-height: 40px;
			border-bottom: 1px #dddddd solid;
		}
		.TableBlock .TableFooter td, .TableBlock .TableControl td, .TableBlock td.TableFooter, .TableBlock td.TableControl {
			background: #FFFFFF;
			border: 1px #dddddd solid;
			padding: 3px;
			height: 30px;
		}
		.TableControl {
			background: #FFFFFF;
			border-top: 1px #dddddd solid;
		}
		.TableData {
			BACKGROUND: #FFFFFF;
			COLOR: #000000;
		}
		tr {
			display: table-row;
			vertical-align: inherit;
			border-color: inherit;
		}
		.TableBlock .TableData td, .TableBlock td.TableData {
			background: #FFFFFF;
			border-bottom: 1px #dddddd solid;
			border-top: 1px #dddddd solid;
			border-right: 1px #dddddd solid;
			padding: 3px;
			height: 30px;
		}
		.TableBlock {
			border: 1px #cccccc solid;
			line-height: 20px;
			font-size: 9pt;
			border-collapse: collapse;
		}
		.TableBlock .TableContent td, .TableBlock td.TableContent {
			background: #f2f2f2;
			border-bottom: 1px #cccccc solid;
			border-right: 1px #cccccc solid;
			padding: 3px;
			height: 30px;
		}
		.TableContent {
			/* BACKGROUND: #4897e8; */
		}
		.TableBlock .TableData td, .TableBlock td.TableData {
			background: #FFFFFF;
			border-bottom: 1px #cccccc solid;
			border-right: 1px #cccccc solid;
			padding: 3px;
			height: 30px;
		}
		.TableData {
			BACKGROUND: #FFFFFF;
			COLOR: #000000;
		}
		td, th {
			display: table-cell;
			vertical-align: inherit;
		}
		tr {
			display: table-row;
			vertical-align: inherit;
			border-color: inherit;
		}
		#west {
			width: 220px;
			position: absolute;
			top: 0;
			left: 0;
			bottom: 0;
			overflow: auto;
		}
		#center {
			position: absolute;
			top: 0px;
			bottom: 0;
			left: 220px;
			right: 0;
			overflow: hidden;
		}
		li a:link span, li a:visited span {
			display: block;
			line-height: 35px;
			padding-left: 16px;
			cursor: pointer;
		}
		tbody {
			display: table-row-group;
			vertical-align: middle;
			border-color: inherit;
		}
		/*定义滚动条宽高及背景，宽高分别对应横竖滚动条的尺寸*/
		.west::-webkit-scrollbar{
			width: 2px;
			height: 2px;
			background-color: #f5f5f5;
		}
		/*定义滚动条的轨道，内阴影及圆角*/
		.west::-webkit-scrollbar-track{
			-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
			border-radius: 10px;
			background-color: #f5f5f5;
		}
		/*定义滑块，内阴影及圆角*/
		.west::-webkit-scrollbar-thumb{
			/*width: 10px;*/
			height: 20px;
			border-radius: 10px;
			-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
			background-color: #555;
		}
		.west table{
			width: 99%;
			margin: 0 auto;
			font-size: 12px;
		}
		.Big {
			border-bottom: 1px solid #c0c0c0;
		}
		.big3{
			font-size: 16px;
		}
	</style>
</head>
<body marginwidth="0" marginheight="0" class="bodycolor">
<div id="west" class="west">
	<div class="head">代码主分类设置</div>
	<ul>
		<li class="menuList">
			<a  onclick="showMain();" target="code_edit" title="增加代码主分类" id="link_1"><span>增加代码主分类</span></a>
		</li>
		<div id="module_1" class="moduleContainer" style="">
			<table class="TableBlock" width="100%" id="TableBlock">
			</table>
		</div>
	</ul>
</div>
<div id="center">
	<!--<iframe src="new.php" id="code_edit" name="code_edit" frameborder="0"></iframe>-->
	<div  id="bodycolor" style="display:block;">
		<div class="small">
			<span class="big3"> 增加代码主分类</span>
		</div>
		<br>
		<table class="TableBlock" width="450" align="center" id="TableBlock_center" style="display:block">
			<tbody>
			<tr>
				<td nowrap="" class="TableData" width="120">代码编号：</td>
				<td nowrap="" class="TableData">
					<input type="text" id="BigInput_codeNo" class="BigInput" size="20" maxlength="100" value="">&nbsp;
				</td>
			</tr>
			<tr>
				<td nowrap="" class="TableData" width="120">排序号：</td>
				<td nowrap="" class="TableData">
					<input type="text" id="BigInput_codeOrder" class="BigInput" size="20" maxlength="100" value="">
				</td>
			</tr>
			<tr>
				<td nowrap="" class="TableData">代码名称：(简体中文)</td>
				<td nowrap="" class="TableData">
					<input type="text" id="BigInput_codeName" class="BigInput" size="20" maxlength="100" value="">&nbsp;
				</td>
			</tr>
			<tr>
				<td nowrap="" class="TableControl" colspan="2" align="center">
					<input type="button" value="确定" class="BigButton" onclick="addMainClassify();"/>
					<!--<input type="button" value="返回" class="BigButton" onclick="location='blank.php'">-->
				</td>
			</tr>
			</tbody>
		</table>
	</div>
	<table class="TableBlock_sub" align="center" id="TableBlock_sub"></table>
</div>
<script type="text/javascript">
    <!--
    $.ajax({
        url:'../../code/syscode/getAllSysCode',
        type:'get',
        dataType:'json',
        //data:datas,
        success:function(data){
            //console.log(data);
            var length=data.obj.length;
            var str_classify ='<tbody>';
            for(var i=0;i<length;i++){
                var status=data.obj[i].codeNo;
                if(data.obj[i].codeFlag==0){
                    var str_classify= str_classify+'<tr class="TableData" title="'+data.obj[i].codeName+'">'+
                        '<td><b>'+data.obj[i].codeName+'</b></td>'+
                        '<td nowrap="">'+
                        '<a onclick="mainMenuedit()" target="user_main"'+
                        'codeId='+data.obj[i].codeId+' codeorder='+data.obj[i].codeOrder+' codeName='+data.obj[i].codeName+'>'+
                        '编辑</a>&nbsp;'+
                        '<a onclick=\'getLevelData("'+status+'");\' target="code_edit"> 下一级</a>&nbsp;'+
                        '</td></tr>';
                }else if(data.obj[i].codeFlag==1){
                    var str_classify= str_classify+'<tr class="TableData" title="'+data.obj[i].codeName+'">'+
                        '<td><b>'+data.obj[i].codeName+'</b></td>'+
                        '<td nowrap="">'+
                        '<a onclick="mainMenuedit()" target="user_main"'+
                        'codeId='+data.obj[i].codeId+' codeorder='+data.obj[i].codeOrder+' codeName='+data.obj[i].codeName+'>'+
                        '编辑</a>&nbsp;'+
                        '<a onclick=\'getLevelData("'+status+'");\' target="code_edit"> 下一级</a>&nbsp;'+
                        '</td></tr>'+
                        '<a onclick=""> 删除</a>';
                }
                //$('#dbgz').html(str);
            }
            var str_classify=str_classify+'</tbody>'
            $('#TableBlock').html(str_classify);
        }
    })
    //-->

    function getLevelData(status){
        var datas ={
            parentNo:status,
        };
        $.ajax({
            url:'../../code/getCode',
            //http://192.168.0.21/code/getCode?parentNo=SYS_LOG
            type:'get',
            data:datas,
            dataType:'json',
            //data:datas,
            success:function(data){
                //console.log(data);
                $("#TableBlock_center").css("display","none");
                $(".big3").text('代码设置项');
                var str_sublevel='<tbody><tr class="TableHeader" align="center">'+
                    '<td nowrap="" title="外部信息类型" colspan="2">&nbsp;&nbsp;<b>外部信息类型</b>&nbsp;&nbsp;'+
                    '</td></tr>'+
                    '<tr><td class="TableControl" align="center" colspan="2">'+
                    '<input type="button" value="增加代码项" class="BigButton" onclick="">'+
                    '</td></tr>';
                var str_length=data.obj.length;
                for(var i=0;i<str_length;i++){
                    str_sublevel=str_sublevel+'<tr class="TableData"><td nowrap="" title="'+data.obj[i].codeName+'">'+
                        '&nbsp;<b>&nbsp;&nbsp;'+data.obj[i].codeName+'</b>&nbsp;'+
                        '</td><td nowrap="">&nbsp;'+
                        '<a href="edit.php?CODE_ID=532&amp;IS_MAIN="> 编辑</a>&nbsp;&nbsp;</td></tr>';
                }
                str_sublevel=str_sublevel+'</tbody>';
                $("#TableBlock_sub").show().html(str_sublevel);
            }
        });
    }
    function mainMenuedit(){
        var codeId=$(this).attr('codeId'),
            codeorder=$(this).attr('codeorder'),
            codeName=$(this).attr('codeName');
        $(".big3").text('编辑代码主分类');
        var str_edit='<div class="bodycolor">'+
            '<table border="0" width="100%" cellspacing="0" cellpadding="3" class="small"><tbody><tr>'+
            '<td class="Big"><img src="/static/images/edit.gif" width="22" height="20" align="absmiddle">'+
            '<span class="big3"> 编辑代码主分类</span>'+
            '</td></tr></tbody></table><br>'+
            '<table class="TableBlock" width="450" align="center">'+
            '<tbody><tr><td nowrap="" class="TableData" width="120">代码编号：</td>'+
            '<td nowrap="" class="TableData">'+
            '<input type="text" name="CODE_NO" class="BigInput" size="20" id="BigInput_num" value="">&nbsp;'+
            '</td></tr><tr>'+
            '<td nowrap="" class="TableData">排序号：</td><td nowrap="" class="TableData">'+
            '<input type="text" name="" class="BigInput" size="20" id="BigInput_order" value="">&nbsp;'+
            '</td></tr><tr><td nowrap="" class="TableData">代码名称：(简体中文)</td>'+
            '<td nowrap="" class="TableData">'+
            '<input type="text"name="" class="BigInput" size="20" id="BigInput" value="">&nbsp;'+
            '</td></tr><tr>'+
            '<td nowrap="" class="TableControl" colspan="2" align="center"><input type="hidden" name="CODE_ID" value="180">'+
            '<input type="button" value="确定" class="BigButton" onclick="submit_form();" codeId="'+codeId+'">&nbsp;&nbsp;'+
            '</td>'+
            '</tr></tbody></table>'+
            '</div>';
        $('#TableBlock_sub').empty().html(str_edit);
    }
    function submit_form(){
        var form_num=$("#BigInput_num").val();
        var	form_order=$("#BigInput_order").val();
        var	form_name=$("#BigInput").val();
        var form_Id=$(this).val("codeId");
        var datas={
            //代码ID
            codeId:form_Id,
            //代码编号
            codeNo:form_num,
            //代码名称
            codeName:form_name,
            //排序号
            codeOrder:form_order
        }
        $.ajax({
            url:'../../code/syscode/update',
            type:'get',
            data:datas,
            dataType:'json',
            //data:datas,
            success:function(data){

            }
        })
    }

    function addMainClassify(){
        var	codeNo=$("#BigInput_codeNo").val(),
            codeOrder=$("#BigInput_codeOrder").val(),
            codeName=$("#BigInput_codeName").val();
        var codeNoData={codeNo:codeNo};
        var codeOrderData={codeOrder:codeOrder};
        var addData={
            codeNo:codeNo,
            codeOrder:codeOrder,
            codeName:codeName,
            codeFlag:1,
        };
        $.ajax({
            url:'../../code/isCodeNoExits',
            type:'get',
            dataType:'json',
            data:codeNoData,
            success:function (data){
                if(data.flag==true){
                    alert('代码编号已存在请重新输入');
                }else{
                    $.ajax({
                        url:'../../code/isCodeOrderExits',
                        type:'get',
                        dataType:'json',
                        data:codeOrderData,
                        success: function (data){
                            if(data.flag==true){
                                alert('排序号已存在请重新输入');
                            }else{
                                $.ajax({
                                    url:'../../code/addSysMainCode',
                                    type:'get',
                                    data:addData,
                                    dataType:'json',
                                    success: function(){
                                        $.ajax({
                                            url:'../../code/syscode/getAllSysCode',
                                            type:'get',
                                            dataType:'json',
                                            //data:datas,
                                            success:function(data){
                                                //console.log(data);
                                                var length=data.obj.length;
                                                var str_classify ='<tbody>';
                                                for(var i=0;i<length;i++){
                                                    var status=data.obj[i].codeNo;
                                                    if(data.obj[i].codeFlag==0){
                                                        var str_classify= str_classify+'<tr class="TableData" title="'+data.obj[i].codeName+'">'+
                                                            '<td><b>'+data.obj[i].codeName+'</b></td>'+
                                                            '<td nowrap="">'+
                                                            '<a onclick="mainMenuedit()" target="user_main"'+
                                                            'codeId='+data.obj[i].codeId+' codeorder='+data.obj[i].codeOrder+' codeName='+data.obj[i].codeName+'>'+
                                                            '编辑</a>&nbsp;'+
                                                            '<a onclick=\'getLevelData("'+status+'");\' target="code_edit"> 下一级</a>&nbsp;'+
                                                            '</td></tr>';
                                                    }else if(data.obj[i].codeFlag==1){
                                                        var str_classify= str_classify+'<tr class="TableData" title="'+data.obj[i].codeName+'">'+
                                                            '<td><b>'+data.obj[i].codeName+'</b></td>'+
                                                            '<td nowrap="">'+
                                                            '<a onclick="mainMenuedit()" target="user_main"'+
                                                            'codeId='+data.obj[i].codeId+' codeorder='+data.obj[i].codeOrder+' codeName='+data.obj[i].codeName+'>'+
                                                            '编辑</a>&nbsp;'+
                                                            '<a onclick=\'getLevelData("'+status+'");\' target="code_edit"> 下一级</a>&nbsp;'+
                                                            '</td></tr>'+
                                                            '<a onclick="">删除</a>';
                                                    }
                                                    //$('#dbgz').html(str);
                                                }
                                                var str_classify=str_classify+'</tbody>'
                                                $('#TableBlock').html(str_classify);
                                            }
                                        })
                                    }
                                })
                            }
                        }
                    })
                }
            }
        })
    }
    function showMain(){
        $(".big3").text("增加代码主分类");
        $("#TableBlock_sub").hide();
        $("#TableBlock_center").show();
    }
</script>
</body>
</html>