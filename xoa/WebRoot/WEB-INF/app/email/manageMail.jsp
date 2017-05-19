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
    <title>管理邮件箱</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css">
        *{margin: 0;padding: 0;}
        body{font-family: "微软雅黑";}
        .title{height: 60px;width: 100%;margin-left: 15px;}
        .title .div_im img{width: 23px;margin-right:10px;float: left;margin-top: 9px;}
        .title .div_title{font-size: 22px;float: left}
        .TABLE tr{border: 1px solid #c0c0c0;}
        .TABLE tr td{padding: 6px;border-right: 1px solid #c0c0c0;display: table-cell;vertical-align: inherit;font-size: 12px;}
        #btn{display: block;margin: 0 auto;width: 70px;height: 28px;border: #ccc 1px solid;border-radius: 3px;cursor: pointer;text-align: center;line-height: 28px;}
        #BTN{width: 168px;overflow: hidden;margin: 0 auto;}
        #BTN .DIV_BTN{float: left;width: 70px;height:28px;border: #ccc 1px solid;border-radius: 3px;cursor: pointer;text-align: center;line-height: 28px;}
        #btnReturn{margin-left: 20px}
        .TABLE table tr td input{border: 1px solid #C6C6C6;height: 22px;padding-left: 3px;width: 200px;}
        hr{border: #ddd 1px dashed;margin: 15px 0;}
        .TABLE_A tr{border: 1px solid #c0c0c0;}
        .TABLE_A table tr:nth-child(odd) {background-color: #F6F7F9;}
        .TABLE_A table tr:nth-child(even) {background-color: #fff;}
        .TABLE_A table tr th{color: #2F5C8F;font-size: 14px;padding: 6px;}
        .TABLE_A table tr td{font-size: 12px;padding: 6px;}
        .TABLE_A table tr td input[type="text"]{width: 50px;height: 22px;padding-left: 5px;}
        .set_btn{border-radius: 3px;padding: 3px 10px;font-size: 12px;color: #333;margin: 1px;text-decoration: none;text-align: center;cursor: pointer;border: #ccc 1px solid;display: inline-block;}
        .TABLE_A table tr td a{text-decoration: none;margin-left: 10px;color: #1687cb;}
    </style>
</head>
<body>
<div class="content">
    <div class="DIV_LIST">
        <div class="title">
            <div class="div_im">
                <img src="../img/icon_addEmail_03.png">
            </div>
            <div class="div_title">添加邮件箱</div>
        </div>
        <div class="TABLE" style="width: 100%;">
            <form action="" method="get">
                <table cellspacing="0" cellpadding="0" width="40%" style="border-collapse:collapse;background-color: #fff;margin: 0 auto;">
                    <tr>
                        <th colspan="2" style="text-align: center;background-color: #3691DA;color: #fff;font-weight: normal;padding: 6px;">添加邮件箱</th>
                    </tr>
                    <tr>
                        <td>序号：</td>
                        <td>
                            <input type="text" name="txt" id="txt1" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>名称：</td>
                        <td>
                            <input type="text" name="txt" id="txt2" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div name="btn" id="btn" >
                                <div class="DIV_Txt" id="AddFolder">添加</div>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <hr />
        <div class="div_list">
            <div class="title">
                <div class="div_im">
                    <img src="../img/icon_manageEmail_03.png">
                </div>
                <div class="div_title">管理邮件箱</div>
            </div>
            <div class="TABLE_A">
                <table cellspacing="0" cellpadding="0" style="border-collapse:collapse;width:99%;margin: 0 auto;">
                    <tr class='befor'>
                        <th width="10%">编号</th>
                        <th width="10%">名称</th>
                        <%--<th width="30%">占用空间</th>
                        <th width="30%">每页显示邮件数</th>--%>
                        <th width="20%">操作</th>
                    </tr>
                    <tr>
                        <td style="text-align: center;"></td>
                        <td style="text-align: center;">收件箱</td>
                       <%-- <td>6,243,852 字节(约合5.95 M)</td>
                        <td style="text-align: center;">
                            <input type="text" name="pageIn" id="pageIn_1" value="11" />
                            <div class="set_btn">设置</div>
                        </td>--%>
                        <td style="text-align: center;"></td>
                    </tr>
                    <tr>
                        <td style="text-align: center;"></td>
                        <td style="text-align: center;">草稿箱</td>
                       <%-- <td>823 字节(约合0.00 M)</td>
                        <td style="text-align: center;">
                            <input type="text" name="pageIn" id="pageIn_2" value="11" />
                            <div class="set_btn">设置</div>
                        </td>--%>
                        <td style="text-align: center;"></td>
                    </tr>
                    <tr>
                        <td style="text-align: center;"></td>
                        <td style="text-align: center;">已发送</td>
                       <%-- <td>812,909 字节(约合0.78 M)</td>
                        <td style="text-align: center;">
                            <input type="text" name="pageIn" id="pageIn_3" value="11" />
                            <div class="set_btn">设置</div>
                        </td>--%>
                        <td style="text-align: center;"></td>
                    </tr>
                    <tr class="last_tr">
                        <td style="text-align: center;"></td>
                        <td style="text-align: center;">废纸篓</td>
                       <%-- <td>65,704 字节 (约合0.06M)</td>
                        <td style="text-align: center;">
                            <input type="text" name="pageIn" id="pageIn_4" value="11" />
                            <div class="set_btn">设置</div>
                        </td>--%>
                        <td style="text-align: center;"></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div class="DIV_EDIT_LIST" style="display:none;">
        <div class="title">
            <div class="div_im">
                <img src="../img/icon_manageEmail_03.png">
            </div>
            <div class="div_title">邮件箱编辑</div>
        </div>
        <div class="TABLE" style="width: 100%;">
            <form action="" method="get">
                <table cellspacing="0" cellpadding="0" width="40%" style="border-collapse:collapse;background-color: #fff;margin: 0 auto;">
                    <tr>
                        <th colspan="2" style="text-align: center;background-color: #3691DA;color: #fff;font-weight: normal;padding: 6px;">添加邮件箱</th>
                    </tr>
                    <tr>
                        <td>序号：</td>
                        <td>
                            <input type="text" name="txt" id="txt1" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>名称：</td>
                        <td>
                            <input type="text" name="txt" id="txt2" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div name="btn" id="BTN" >
                                <div class="DIV_BTN" id="btnSure">确定</div>
                                <div class="DIV_BTN" id="btnReturn">返回</div>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
       $('#AddFolder').click(function(){
           var Number=$('#txt1').val();
           var Name=$('#txt2').val();
           var data={
                'boxNo':Number,
               'boxName':Name
           }
           $.ajax({
               type:'post',
               url:'saveEmailBox',
               dataType:'json',
               data:data,
               success:function(){
                   location.reload();
               }
           })

       })

        //新建文件夹展示
        setOtherMail ()

        //删除文件夹
        $('.TABLE_A').on('click','.deleteList',function(){
            var id=$(this).parents('tr').attr('boxId');
            deleteFolder (id)
        })

        //编辑文件夹
        $('.TABLE_A').on('click','.editList',function(){
            $('.DIV_LIST').css('display','none');
            $('.DIV_EDIT_LIST').css('display','block');
            //alert('1')
        })
    })
    function setOtherMail (){
        var data={
            'page':1,
            'pageSize':6,
            'useFlag':true
        }
        $.ajax({
            type:'GET',
            url:'showEmailBox',
            dataType:'json',
            data:data,
            success:function(rsp){
                var data2=rsp.obj;
                var str='';
                for(var i=0;i<data2.length;i++){
                    str+='<tr boxId="'+data2[i].boxId+'"><td style="text-align: center;">'+data2[i].boxNo+'</td><td style="text-align: center;">'+data2[i].boxName+'</td><td style="text-align: center;"><a class="editList" href="javascript:;">编辑</a><a class="deleteList" href="javascript:;">删除</a></td></tr>'
                }
                $('.TABLE_A table').append(str);
            }
        })
    }
    function deleteFolder (id){
        var data={
            'page':1,
            'pageSize':6,
            'useFlag':true,
            'boxId':id
        }
        var msg='<fmt:message code="global.lang.sure" />';
        if (confirm(msg)==true){
            $.ajax({
                type:'GET',
                url:'deleteBoxEmail',
                dataType:'json',
                data:data,
                success:function(){
                    location.reload();
                }
            });
            return true;
        }else{
            return false;
        }

    }
</script>
</body>
</html>
