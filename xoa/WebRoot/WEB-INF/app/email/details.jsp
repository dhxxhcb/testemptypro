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
    <title>邮件详情</title>
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css">
        div table tr td p{margin: 0;padding: 0;}
        body{font-family: "微软雅黑";font-size: 10pt;width: 100%;}
        .detailsContent{width: 90%;margin: 20px auto;}
        table{width: 100%;}
        table tr td a{text-decoration: none;}
        table tr td:first-of-type{width: 70px;padding-left: 10px;}
        table tr td:last-of-type{text-align: left;padding-left: 20px;}
        .detailsContent .p_txt{margin-top: 10px;padding: 0 10px;border-top: #ccc 1px solid;}
    </style>
    <script type="text/javascript">
        $(function () {
            var id=$.getQueryString('id');
            $.ajax({
                type:'get',
                url:'queryByID',
                dataType:'json',
                data:{'emailId':id,'flag':''},
                success:function(rsp){
                    var data2=rsp.object;
                    var sendTime=new Date((data2.sendTime)*1000).Format('yyyy-MM-dd hh:mm');
                    var str='';
                    var stra='';
                    var arr=new Array();
                    arr=data2.attachmentName.split('*');
                    $('.p_txt').find('p').remove();

                    if(data2.attachmentName!='' && data2.copyName!=''){
                        for(var i=0;i<(arr.length-1);i++){
                            stra+='<div><a href="javascript:;"><img src="../img/icon_print_07.png"/>'+arr[i]+'</a></div>';
                        }
                        str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td>抄送人：</td><td>'+data2.copyName+'</td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr><tr><td>附件：</td><td class="attachment">'+stra+'</td></tr>';
                    } else if(data2.attachmentName=='' && data2.copyName!=''){
                        str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td>抄送人：</td><td>'+data2.copyName+'</td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr>';
                    } else if(data2.attachmentName!='' && data2.copyName ==''){
                        for(var i=0;i<(arr.length-1);i++){
                            stra+='<div><a href="javascript:;"><img src="../img/icon_print_07.png"/>'+arr[i]+'</a></div>';
                        }
                        str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr><tr><td>附件：</td><td class="attachment">'+stra+'</td></tr>';
                    } else{
                        str='<tr><td width="8%"><fmt:message code="email.th.main" />：</td><td width="72%">'+data2.subject+'</td></tr><tr><td><fmt:message code="email.th.sender" />：</td><td>'+data2.users.userName+'</td></tr><tr><td><fmt:message code="email.th.recipients" />：</td><td><span><img src="../img/icon_read_3_07.png"/>'+data2.emailList[0].toName+'</span></td></tr><tr><td><fmt:message code="email.th.time" />：</td><td>'+sendTime+'</td></tr>';
                    }

                    $('.Table').append(str);
                    $('.p_txt').append('<p>'+data2.content+'</p>');
                }
            });

        }) ;
    </script>
</head>
<body>
    <div class="detailsContent">
        <table class="Table"  cellspacing="0" cellpadding="0">

        </table>
        <div class="p_txt">

        </div>
    </div>
</body>
</html>
