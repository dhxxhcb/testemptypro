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
    <title>新建文件</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/email/writeMail.css"/>
    <script src="../lib/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/email/writeMail.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/ajaxupload.js" type="text/javascript" charset="utf-8"></script>
    <style>
        table{margin-top:10px;}
        table tr td{padding-left:10px;}
        .files a{text-decoration: none;}
    </style>
</head>
<body>
<table class="TABLE" border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
                <tr class="append_tr">
                    <td width="10%">文件名称：</td>
                    <td width="89%"><input type="text" id="txt1" value="" class="input_txt" /></td>
                </tr>
                <tr>
                    <td>排列序号：</td>
                    <td>
                        <input type="text" id="txt2" value="" class="input_txt" />
                    </td>
                </tr>
                <tr>
                    <td width="10%">
                        <p>文件内容：</p>

                    </td>
                    <td width="89%">
                        <script id="container" style="width: 99.9%;min-height: 300px;" name="content" type="text/plain"></script>
                     </td>
                 </tr>
                 <tr class="Attachment" style="width:100%;">
                       <td width="10%">附件文档：</td>
                       <td width="89%"   class="files" id="files_txt"></td>
                 </tr>
                  <tr>
                        <td>新建附件：</td>
                         <td>
                                <input type="radio" name="radio" id="radio" ><span>Word文档</span>
                                <input type="radio" name="radio" id="radio" ><span>Excel文档</span>
                                <input type="radio" name="radio" id="radio" ><span>PPT文档</span>
                                <span>附件名：</span><input type="text" name="txt" id="TXT">
                                <input type="button" name="button" id="oBtn" value="新建附件">
                         </td>
                   </tr>

                <tr>
                <td><fmt:message code="email.th.filechose" />：</td>
            <td class="files">

                <form id="uploadimgform" target="uploadiframe"  action="../upload?module=file" enctype="multipart/form-data" method="post" >
                    <input type="file" name="file" id="uploadinputimg"  class="w-icon5" style="display:none;">
                    <a href="javascript:;" id="uploadimg">上传</a>
                </form>

             </td>
                </tr>
                <tr>
                    <td>附件说明：</td>
                    <td><input type="text" name="txt" id="txt3" class="txt"></td>
                 <tr>
                <tr>
                <td colspan="2">
                <div class="div_btn">
                <input type="button" id="btn1" value="确定" />
                <input type="button" id="btn2" value="返回" />
                </div>

                </td>
                </tr>
                </table>


    <script type="text/javascript">
            var ue = UE.getEditor('container');
            $(function(){
                //附件上传方法
                $('#uploadimg').on('click', function(ele) {
                    user_id='senduser';
                    $('#uploadinputimg').click();
                })
                $('.TABLE').on('click','#selectUserO',function(){
                    user_id='copeNameText';
                    $.popWindow("../common/selectUser");
                })
                $('.TABLE').on('click','#selectUserT',function(){
                    user_id='secritText';
                    $.popWindow("../common/selectUser");
                })
                $('#uploadinputimg').change(function(e){
                    var target = $(e.target);
                    var file;
                    if(target[0].files && target[0].files[0]){
                        file=target[0].files[0];
                    }

                    if(file){
                        $.upload($('#uploadimgform'),function(res){
                            //console.log(res);
                            var data=res.obj;
                            var str='';
                            var str1='';
                            for(var i=0;i<data.length;i++){
                                str+='<a href="<%=basePath %>download?'+data[i].attUrl+'" NAME="'+data[i].attachName+'*">'+data[i].attachName+'</a>';
                                str1+='<input type="hidden" class="inHidden" value="'+data[i].aid+'@'+data[i].ym+'_'+data[i].attachId+',">';
                            }

                            $('.Attachment td').eq(1).append(str+str1);

                        });
                    }
                });

                var sortId=$.getQueryString('sortId')
                var txt="${text}";
                alert(txt);

                if ($.getQueryString('contentId')){
                    var conId=$.getQueryString('contentId');
                    ue.ready(function(){

                        $.ajax({
                            type:'post',
                            url:'${pageContext.request.contextPath}/file/getContentById',
                            dataType:'json',
                            data:{'contentId':conId},
                            success:function(rsp){
                                $('#txt1').val('');
                                $('#txt2').val('');
                                ue.setContent('');
                                $('#files_txt').val('');
                                $('#txt3').val('');

                                $('#txt1').val(rsp.subject);
                                $('#txt2').val(rsp.contentNo);
                                ue.setContent(rsp.content);
                                $('#files_txt').val(rsp.attachmentName);
                                $('#txt3').val(rsp.attachmentDesc);

                            }
                        })
                     })
                    //编辑保存
                    $("#btn1").on("click",function(){
                        var subject=$('#txt1').val();
                        var contentNo=$('#txt2').val();
                        var html = ue.getContent();
                        var attach=$('.Attachment td').eq(1).find('a');
                        var attachmentDesc=$('#txt3').val();
                        var aId='';
                        var uId='';
                        for(var i=0;i<$('.Attachment td .inHidden').length;i++){
                            aId += $('.Attachment td .inHidden').eq(i).val();
                        }
                        for(var i=0;i<$('.Attachment td .inHidden').length;i++){
                            uId += attach.eq(i).attr('NAME');
                        }
                        var data={
                            'contentId':conId,
                            'subject':subject,
                            'contentNo':contentNo,
                            'content':html,
                            'attachmentId':aId,
                            'attachmentName':uId,
                            'attachmentDesc':attachmentDesc
                        };

                        $.ajax({
                            type:'post',
                            url:'${pageContext.request.contextPath}/file/updateContent',
                            dataType:'json',
                            data:data,
                            success:function(data1){
                                var flag=data1.flag;
                                if (flag==true){
                                    alert('修改成功');
                                    window.close();
                                    window.opener.document.location.reload()
                                }else{
                                    alert('修改失败');
                                }

                            }
                        });
                    })

                }else{
                    //点击保存
                    $("#btn1").on("click",function(){
                        var subject=$('#txt1').val();
                        var contentNo=$('#txt2').val();
                        var html = ue.getContent();
                        var attach=$('.Attachment td').eq(1).find('a');
                        var attachmentDesc=$('#txt3').val();
                        var aId='';
                        var uId='';
                        for(var i=0;i<$('.Attachment td .inHidden').length;i++){
                            aId += $('.Attachment td .inHidden').eq(i).val();
                        }
                        for(var i=0;i<$('.Attachment td .inHidden').length;i++){
                            uId += attach.eq(i).attr('NAME');
                        }
                        var data={
                            'sortId':sortId,
                            'subject':subject,
                            'contentNo':contentNo,
                            'content':html,
                            'attachmentId':aId,
                            'attachmentName':uId,
                            'attachmentDesc':attachmentDesc
                        };

                        $.ajax({
                            type:'post',
                            url:'${pageContext.request.contextPath}/file/saveContent',
                            dataType:'json',
                            data:data,
                            success:function(data1){
                                var flag=data1.flag;
                                if (flag==true){
                                    alert('新建成功');

                                    //parent.opener.location.reload()
                                }else{
                                    alert('新建失败');
                                }

                            }
                        });
                    })
                }
                //返回按钮
                $('#btn2').click(function(){
                    $('#txt1').val('');
                    $('#txt2').val('');
                    ue.setContent('');
                    $('#files_txt').val('');
                    $('#txt3').val('');
                    window.close();
                })
            })



            </script>
</body>
</html>


