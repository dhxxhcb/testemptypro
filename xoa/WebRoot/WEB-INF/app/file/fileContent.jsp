<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'fileContent.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/cabinet.css">

<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
<script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>

<style>
input {border: none;outline: none;display: inline-block;background: #fff;}
input:hover {background: #eaf2ff;padding: 5px;}
.ss{margin-top:6px;position: relative;}
.ss a{font-size: 14px;display: block;font-family: 微软雅黑;letter-spacing: 1px;position: absolute;left: 25px;top: 1px;color: #fff;}
.one{width:90px;height: 28px;background: url("img/file/cabinet01.png") no-repeat;}
.one a{height: 28px;  line-height: 28px;}
.two{width:90px;height: 28px;background: url("img/file/cabinet02.png") no-repeat;}
.two a{height: 28px;  line-height: 28px;}
.three{width: 70px;height: 28px;background: url("img/file/cabinet03.png") no-repeat;}
.three a{height: 28px;  line-height: 26px;color:#000;left:30px;}
.four{width: 90px;height: 28px;background: url("img/file/cabinet04.png") no-repeat;}
.four a{height: 28px;  line-height: 26px;color:#000;}
#file_Tachr tr td:last-of-type a{display:block;width:40px;height:22px;background: url("img/file/cabinet08.png") no-repeat;text-align:center;line-height:22px;}
.boto{margin-top: 8px;}
.boto a{display:inline-block;width: 56px;height:24px;position: relative;}
.boto a span{position:absolute;display:block;height:24px;top:0px;left:22px;line-height:24px;text-align: center;letter-spacing: 2px;}
.boto a.ONE{background: url("img/file/cabinet07.png") no-repeat;}
.boto a.TWO{background: url("img/file/cabinet09.png") no-repeat;}
.boto a.THREE{background: url("img/file/cabinet10.png") no-repeat;}
.boto a.FOUR{background: url("img/file/cabinet12.png") no-repeat;}
.boto a.FIVE{background: url("img/file/cabinet11.png") no-repeat;}
.TITLE{margin-left: 10px;color: #2B7FE0;}
.trBtn{background-color:#D3E7FA !important;}
</style>
<script type="text/javascript">
$(function(){
    /* $("#contentAdd").attr("href","${pageContext.request.contextPath }/file/contentAdd?sortId="+${sortId}); */
	$.ajax({
						type:'post',
						url:'<%=basePath%>file/catalog',
						dataType:'json',
						data:{'sortId':${sortId},'sortType':${sortType},'postType':${postType}},
						success:function(data){
						var files='';
							for(var i=0;i<data.length;i++){
							    if(data[i].fileType=="file"){
							        files+="  <tr class='contentTr' sortId='"+data[i].sortId+"' TYPE='"+data[i].fileType+"' contentId='"+data[i].contentId+"'><td><input class=\"checkChild\" type=\"checkbox\" conId='"+data[i].contentId+"' name=\"check\" value=\"\" > <a class='TITLE' href=\"${pageContext.request.contextPath }/file/catContent?contentId="+data[i].contentId+"\">"+data[i].subject+ "  </a></td>  <td><img style='width:18px;' src=\"img/file/cabinet@.png\" alt=\"\"/>"+''+ "  </td> <td> "+data[i].sendTime+ "  </td><td> "+data[i].contentId+ "  </td><td><a href='javascript:;' class='editBtn'>编辑</a></td></tr>"
							    }
							}
							$("#file_Tachr").html(files);
                            $(".checkChild").click(function () {
                                var state=$(this).prop("checked");
                                if(state==true){
                                    $(this).prop("checked",true);
                                }else{
                                    $('#checkedAll').prop("checked",false);
                                    $(this).prop("checked",false);
                                }
                             var child =   $(".checkChild");
                                for(var i=0;i<child.length;i++){
                                   var childstate= $(child[i]).prop("checked");
                                    if(state!=childstate){
                                        return
                                    }
                                }
                                $('#checkedAll').prop("checked",state);
                            })


						}
				});


    $('#checkedAll').click(function(){
        var state =$(this).prop("checked");

        if(state==true){
            $(this).prop("checked",true);
           // $('.contentTr').addClass('trBtn');
            $(".checkChild").prop("checked",true);

        }else{
            $(this).prop("checked",false);
           // $('.contentTr').removeClass('trBtn');
            $(".checkChild").prop("checked",false);;
        }
    })


    $('.FOUR').click(function(){
        var TYPE=$('.w .trBtn').attr('TYPE');
        var id=$('.w .trBtn').attr('sortId');
        var fileId=[];
        $(".checkChild:checkbox:checked").each(function(){
           var conId=$(this).attr("conId")
            fileId.push(conId);
        })

           var msg='<fmt:message code="global.lang.sure" />';
           if (confirm(msg)==true){
                 $.ajax({
                     type:'post',
                     url:'${pageContext.request.contextPath }/file/batchDeleteConId',
                     dataType:'json',
                     data:{'fileId':fileId},
                     success:function(){
                     location.reload();
                     }
                 });
               return true;
           }else{
               return false;
           }



    })

    $('.w').on('click','.editBtn',function(){
        var TYPE=$('.w .trBtn').attr('TYPE');
        var id=$('.w .trBtn').attr('sortId');
        var idT=$('.w .trBtn').attr('contentId');
        //alert(idT);
        $.popWindow('/file/contentAdd?contentId='+idT,'编辑','0','0','1500px','800px');
    })


});




	</script>
</head>

<body style="background-color: #EBEBEB">
<div class="head w clearfix">
    <div class="ss one"> <a id="contentAdd" href="${pageContext.request.contextPath }/file/contentAdd?sortId=${sortId}&text=${text}">新建文件</a></div>
    <div class="ss two"> <a href="${pageContext.request.contextPath }/file/temp">批量上传</a></div>
    <div class="ss three"> <a  class="SEARCH" href="${pageContext.request.contextPath }/file/temp">查询</a></div>
    <div class="ss four"> <a href="${pageContext.request.contextPath }/file/temp">全局搜索</a></div>
</div>
<!--middle部分开始-->
<div class="w">
    <div class="wrap">
        <table class="w">
            <thead>
            <tr>
                <td class="th"><fmt:message code="file.th.name"/></td>
                <td class="th"><fmt:message code="email.th.file"/></td>
                <td class="th" style="position: relative">
                    <fmt:message code="notice.th.PostedTime"/>
                    <img style="position: absolute;margin-left:9px;cursor: pointer;" src="img/file/cabinet05.png" alt=""/>
                    <img style="position: absolute;margin-top:10px;margin-left:9px;cursor: pointer;"
                         src="img/file/cabinet06.png " alt=""/>
                </td>
                <td class="th" style="position: relative">
                    <fmt:message code="file.th.Sort"/>
                    <img style="position: absolute;margin-left:9px;cursor: pointer;" src="img/file/cabinet05.png" alt=""/>
                    <img style="position: absolute;margin-top:10px;margin-left:9px;cursor: pointer;"
                         src="img/file/cabinet06.png " alt=""/>
                </td>
                <td class="th"><fmt:message code="notice.th.operation"/></td>
            </tr>
            </thead>
            <tbody id="file_Tachr">
            </tbody>
        </table>
    </div>
</div>
	<!--bottom 部分开始-->
<div class="bottom w">
    <div class="checkALL">
        <input id="checkedAll" type="checkbox" name="" value="" >
        <label for="checkedAll"><fmt:message code="notice.th.allchose"/></label>
    </div>
    <div class="boto">
        <a class="ONE" href="javascript:;"><span>签阅</span></a>
    </div>
    <div class="boto">
        <a class="TWO" href="javascript:;"><span>复制</span></a>
    </div>
    <div class="boto">
        <a class="THREE" href="javascript:;"><span>剪切</span></a>
    </div>
    <div class="boto">
        <a class="FOUR" href="javascript:;"><span>删除</span></a>
    </div>
    <div class="boto">
        <a class="FIVE" href="javascript:;"><span>下载</span></a>
    </div>

</div>

<!--bottom 部分结束-->
</body>
</html>
