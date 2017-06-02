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
		}
		.TableBlock {
			border: 1px #dddddd solid;
			line-height: 20px;
			font-size: 9pt;
			border-collapse: collapse;
		}
		table {
			width: 0 !important;
			margin: 0 auto;
			font-size: 14px;
			margin-top: 10px;
			border-collapse: collapse;
			border-spacing: 0;
		}
		table .TableBlock_sub{
			width: -1%;
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
	</style>
</head>
<body marginwidth="0" marginheight="0">
<div id="west">
	<div class="head"><img src="/static/images/menu/system.gif" align="absMiddle">代码主分类设置</div>
	<ul>
		<li>
			<a href="new.php" onclick="" target="code_edit" title="增加代码主分类" id="link_1"><span>增加代码主分类</span></a>
		</li>
		<div id="module_1" class="moduleContainer" style="">
			<table class="TableBlock" width="100%" id="TableBlock">
			</table>
		</div>
		<li>
			<a href="func/no_link.php" onclick="" target="code_edit" title="错误代码列表" id="link_2"><span>错误代码列表</span></a>
		</li>
		<li>
			<a href="imp_exp/" onclick="" target="code_edit" title="代码备份/恢复" id="link_3"><span>代码备份/恢复</span></a>
		</li>
	</ul>
</div>
<div id="center" class="bodycolor">
	<!--<iframe src="new.php" id="code_edit" name="code_edit" frameborder="0"></iframe>-->
	<div  id="bodycolor">
		<table border="0" width="100%" cellspacing="0" cellpadding="3" class="small">
			<tbody>
			<tr>
				<td class="Big"><img src="/static/images/menu/system.gif" width="22" height="20" align="absmiddle"><span class="big3"> 代码项设置</span>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
	<table class="TableBlock_sub" align="center" id="TableBlock_sub"></table>
	<div align="center">
		<input type="button" value="返回" class="BigButton" onclick="location='../blank.php'">
	</div>
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
                var str_classify= str_classify+'<tr class="TableData" title="'+data.obj[i].codeName+'">'+
                    '<td><b>'+data.obj[i].codeName+'</b></td>'+
                    '<td nowrap="">'+
                    '<a onclick="mainMenuedit()" target="user_main"'+
                    'codeId='+data.obj[i].codeId+' codeorder='+data.obj[i].codeOrder+' codeName='+data.obj[i].codeName+'>'+
                    '编辑</a>&nbsp;'+
                    '<a onclick=\'getLevelData("'+status+'");\' target="code_edit"> 下一级</a>&nbsp;'+
                    '</td></tr>';
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
                $("#TableBlock_sub").html(str_sublevel);
            }
        });
    }
    function mainMenuedit(){
        var codeId=$(this).attr('codeId'),
            codeorder=$(this).attr('codeorder'),
            codeName=$(this).attr('codeName');
        var str_edit='<div class="bodycolor">'+
            '<table border="0" width="100%" cellspacing="0" cellpadding="3" class="small"><tbody><tr>'+
            '<td class="Big"><img src="/static/images/edit.gif" width="22" height="20" align="absmiddle">'+
            '<span class="big3"> 编辑代码主分类</span>'+
            '</td></tr></tbody></table><br>'+
            '<table class="TableBlock" width="450" align="center">'+
            '<form action="../../code/syscode/update" method="post" name="form1" onsubmit=""></form>'+
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
            '<input type="submit" value="确定" class="BigButton" onclick="submit_form();" codeId="'+codeId+'">&nbsp;&nbsp;'+
            '<input type="button" value="返回" class="BigButton" onclick=""></td>'+
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
</script>
</body>
</html>