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
    <title>新建用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/sys/addUser.css"/>
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/ajaxupload.js" type="text/javascript" charset="utf-8"></script>
    <script>
        user_id='senduser1';
        var res
        $(function(){
            //选人控件
            $("#selectUser1").on("click",function(){
                user_id='senduser1';
                $.popWindow("../common/selectUser");
            });
            $("#selectUser2").on("click",function(){
                user_id='senduser2';
                $.popWindow("../common/selectUser");
            });

            $('#tr_Up').click(function(){
                $('.trOption').toggle();
            })
            $('#trOther').click(function(){
                $('.otherOption').toggle();
            })
           /* var radioValOA=$('input:radio[name="notLogin"]:checked').val();
            var radioValOther=$('input:radio[name="notMobileLogin"]:checked').val();*/

            $('#btn1').click(function(){
                if($('input[name="userId"]').val()==''){
                    alert('请填写用户名');
                    return;
                }
                if($('input[name="userName"]').val()==''){
                    alert('请填写真实姓名');
                    return;
                }
                var notLogin=$('input:radio[name="notLogin"]:checked').val();
                var notMobileLogin=$('input:radio[name="notMobileLogin"]:checked').val();
                var isLunar='';
                var mobilNoHidden='';
                if($('input[name="isLunar"]').prop('checked')==true){
                    isLunar=1;
                }else{
                    isLunar=0;
                }
                if($('input[name="mobilNoHidden"]').prop('checked')==true){
                    mobilNoHidden=0;
                }else{
                    mobilNoHidden=1;
                }
                var data= {
                    'userId': $('input[name="userId"]').val(),
                    'userName': $('input[name="userName"]').val(),
                    'userPrivName': $('#senduser1').attr('user_id'),
                    'deptId': $('select[name="deptId"] option:checked').val(),
                    'userNo': $('input[name="userNo"]').val(),
                    'postPriv': $('select[name="postPriv"] option:checked').val(),
                    'imRange': $('select[name="imRange"] option:checked').val(),
                    'notLogin': notLogin,
                    'notMobileLogin': notMobileLogin,
                    'bindIp':$('#bindIp').val(),
                    'remark':$('#remark').val(),
                    'password':$('input[name="password"]').val(),
                    'sex':$('select[name="sex"] option:checked').val(),
                    'birthday':$('input[name="birthday"]').val(),
                    'isLunar':isLunar,
                    'mobilNo':$('input[name="mobilNo"]').val(),
                    'mobilNoHidden':mobilNoHidden,
                    'email':$('input[name="email"]').val(),
                    'telNoDept':$('input[name="telNoDept"]').val()
                }
                $.ajax({
                    type:'post',
                    url:'/user/addUser',
                    dataType:'json',
                    data:data,
                    success:function(rsp){
                        if(rsp.flag == true){
                            alert('新建成功');
                        }else{
                            alert('新建失败');
                        }
                        //window.close()
                        //parent.opener.location.reload()
                    }
                })
            })
        })
    </script>
</head>
<body>
<div class="content">
    <div class="title">
        <span class="titleTxt">新建用户</span><span>（总经理）</span>
    </div>
    <form action="" method="post" name="form1">
        <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff">
            <tr>
                <td colspan="2">用户基本信息</td>
            </tr>
            <tr>
                <td width="15%">用户名：</td>
                <td width="70%">
                    <input type="text" name="userId" value="">
                </td>
            </tr>
            <tr>
                <td width="15%">真实姓名：</td>
                <td width="70%">
                    <input type="text" name="userName" value="">
                </td>
            </tr>
            <tr>
                <td width="15%">主角色：</td>
                <td width="70%">
                    <textarea name="txt" id="senduser1" user_id='admin' value=""></textarea>
                    <a href="javascript:;" id="selectUser1" class="Add ">添加</a>
                </td>
            </tr>
            <tr>
                <td width="15%">部门：</td>
                <td width="70%">
                    <select id="department" name="deptId" style="width: 200px;">

                    </select>
                    <a href="jaavascript:;">指定其它所属部门</a>
                </td>
            </tr>
            <tr>
                <td width="15%">用户排序号：</td>
                <td width="70%">
                    <input type="text" name="userNo" value="">
                    <span>用于同角色用户的排序，不能是大于65535的数字</span>
                </td>
            </tr>

            <tr>
                <td colspan="2">用户权限信息</td>
            </tr>
            <tr>
                <td width="15%">管理范围：</td>
                <td width="70%">
                    <select name="postPriv">
                        <option value="01">本部门</option>
                        <option value="02">全体</option>
                        <option value="03">指定部门</option>
                    </select>
                    <span>在管理型模块中起约束作用</span>
                </td>
            </tr>
            <tr>
                <td width="15%">访问控制：</td>
                <td width="70%">
                    <div class="spanChech">
                          <input type="checkbox" name="notViewUser" value="">
                          <span>禁止查看用户列表</span>
                         <input type="checkbox" name="notViewTable" value="">
                          <span>禁止显示桌面</span>
                         <input type="checkbox" name="useingKey" value="">
                          <span>使用USB KEY登录</span>
                         <input type="checkbox" name="usingFinger" value="">
                          <span>使用指纹验证</span>
                     </div>
                    <div class="divRadio" style="float: left">
                        <input type="radio" name="notLogin" value="0">
                        <span>允许登录OA系统</span>
                        <input type="radio" name="notLogin" value="1">
                        <span>禁止登录OA系统 </span>
                        <input type="radio" name="notMobileLogin" value="">
                        <span>允许登录手机客户端（不受OA用户数限制）</span>
                        <input type="radio" name="notMobileLogin" value="">
                        <span>禁止登录手机客户端</span>
                    </div>

                </td>
            </tr>
            <tr>
                <td width="15%">即时通讯使用权限：</td>
                <td width="70%">
                    <select name="imRange">
                        <option value="1">允许使用</option>
                        <option value="2">禁止使用</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td width="15%">
                    <span>通讯白名单：</span>
                    <p>按角色设置</p>
                    <a href="javascript:;">按人员、部门设置</a>
                </td>
                <td width="70%">
                    <div class="inPole">
                        <textarea name="txt" id="senduser2" user_id='admin' value="admin" disabled style="height: 30px;min-height: 30px;"></textarea>
                        <span class="add_img" style="margin-left: 10px">
									<a href="javascript:;" id="selectUser2" class="Add ">添加</a>
								</span>
                        <span class="add_img">
									<a href="javascript:;" class="clear">清除</a>
								</span>
                        <p>属于以上所选角色的人员可以给此用户发送邮件和微讯，角色和人员设置均为空则不限制</p>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2"><a href="javascript:;" id="trOther" style="text-decoration: none;">其他选项</a></td>
            </tr>
            <tr style="display: none" class="otherOption">
                <td colspan="2">
                    <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff;width: 100%;margin-top:0;">
                        <tr>
                            <td width="15%">考勤排班类型：</td>
                            <td width="70%">
                                <select name="twoSele">
                                    <option value="01">正常班</option>
                                    <option value="01">全日班</option>
                                    <option value="01">轮班制</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">内部邮箱容量：</td>
                            <td width="70%">
                                <input type="text" name="SUMMARY" value="500">
                                <span>MB 为空则表示不限制大小</span>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">个人文件柜容量：</td>
                            <td width="70%">
                                <input type="text" name="SUMMARY" value="500">
                                <span>MB 为空则表示不限制大小</span>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">是否启用POP3功能：</td>
                            <td width="70%">
                            <span class="spanChech">
                                <input type="checkbox" name="SUMMARY" value="500">
                                <span>是</span>
                            </span>

                            </td>
                        </tr>
                        <tr>
                            <td width="15%">是否启用邮件发送限制：</td>
                            <td width="70%">
                                <span class="spanChech">
                                    <input type="checkbox" name="SUMMARY" value="500">
                                    <span>是 开启后将会限制内部收件人数一次最多20人</span>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">禁用Internet邮箱：</td>
                            <td width="70%">
                                <span class="spanChech">
                                    <input type="checkbox" name="SUMMARY" value="500">
                                    <span>禁止使用Internet邮件功能</span>
                                </span>

                            </td>
                        </tr>
                        <tr>
                            <td width="15%">Internet邮箱数量：</td>
                            <td width="70%">
                                <input type="text" name="SUMMARY" value="">
                                <span> 个 为空则表示不限制数量</span>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">每个Internet邮箱容量：</td>
                            <td width="70%">
                                <input type="text" name="SUMMARY" value="">
                                <span> MB 为空则表示不限制大小</span>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">绑定IP地址：</td>
                            <td width="70%">
                                <textarea name="txt" id="bindIp" value="" style="height: 30px;min-height: 30px;"></textarea>
                                <p>为空则该用户不绑定固定的IP地址，绑定多个IP地址用英文逗号(,)隔开</p>
                                <p>也可以绑定IP段，如“192.168.0.60,192.168.0.100-192.168.0.200”</p>
                                <p>表示192.168.0.60或192.168.0.100到192.168.0.200这个范围内都可以登录</p>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">备注：</td>
                            <td width="70%">
                                <textarea name="txt" id="remark" value="" style="height: 30px;min-height: 30px;"></textarea>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <%--<tr>
                <td width="15%">考勤排班类型：</td>
                <td width="70%">
                    <select name="twoSele">
                        <option value="01">正常班</option>
                        <option value="01">全日班</option>
                        <option value="01">轮班制</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td width="15%">内部邮箱容量：</td>
                <td width="70%">
                    <input type="text" name="SUMMARY" value="500">
                    <span>MB 为空则表示不限制大小</span>
                </td>
            </tr>
            <tr>
                <td width="15%">个人文件柜容量：</td>
                <td width="70%">
                    <input type="text" name="SUMMARY" value="500">
                    <span>MB 为空则表示不限制大小</span>
                </td>
            </tr>
            <tr>
                <td width="15%">是否启用POP3功能：</td>
                <td width="70%">
                    <span class="spanChech">
                        <input type="checkbox" name="SUMMARY" value="500">
                        <span>是</span>
                    </span>

                </td>
            </tr>
            <tr>
                <td width="15%">是否启用邮件发送限制：</td>
                <td width="70%">
                    <span class="spanChech">
                        <input type="checkbox" name="SUMMARY" value="500">
                        <span>是 开启后将会限制内部收件人数一次最多20人</span>
                    </span>
                </td>
            </tr>
            <tr>
                <td width="15%">禁用Internet邮箱：</td>
                <td width="70%">
                    <span class="spanChech">
                        <input type="checkbox" name="SUMMARY" value="500">
                        <span>禁止使用Internet邮件功能</span>
                    </span>

                </td>
            </tr>
            <tr>
                <td width="15%">Internet邮箱数量：</td>
                <td width="70%">
                    <input type="text" name="SUMMARY" value="">
                    <span> 个 为空则表示不限制数量</span>
                </td>
            </tr>
            <tr>
                <td width="15%">每个Internet邮箱容量：</td>
                <td width="70%">
                    <input type="text" name="SUMMARY" value="">
                    <span> MB 为空则表示不限制大小</span>
                </td>
            </tr>
            <tr>
                <td width="15%">绑定IP地址：</td>
                <td width="70%">
                    <textarea name="txt" id="senduser2" user_id='admin' value="admin" style="height: 30px;min-height: 30px;"></textarea>
                    <p>为空则该用户不绑定固定的IP地址，绑定多个IP地址用英文逗号(,)隔开</p>
                    <p>也可以绑定IP段，如“192.168.0.60,192.168.0.100-192.168.0.200”</p>
                    <p>表示192.168.0.60或192.168.0.100到192.168.0.200这个范围内都可以登录</p>
                </td>
            </tr>
            <tr>
                <td width="15%">备注：</td>
                <td width="70%">
                    <textarea name="txt" id="senduser3" user_id='admin' value="admin" style="height: 30px;min-height: 30px;"></textarea>
                </td>
            </tr>--%>


            <tr>
                <td colspan="2"><a href="javascript:;" id="tr_Up" style="text-decoration: none;">用户可自定义选项</a></td>
            </tr>
            <tr style="display: none" class="trOption">
                <td colspan="2">
                    <table cellspacing="0" cellpadding="0" class="tab" style="border-collapse:collapse;background-color: #fff;width: 100%;margin-top:0;">
                        <tr>
                            <td width="15%">密码：</td>
                            <td width="70%">
                                <input type="password" name="password" value="">
                                <span>8-20位，必须同时包含字母和数字</span>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">性别：</td>
                            <td width="70%">
                                <select name="sex">
                                    <option value="0">男</option>
                                    <option value="1">女</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">生日：</td>
                            <td width="70%">
                    <span class="spanChech">
                        <input type="text" name="birthday" value="">
                        <input type="checkbox" name="isLunar" value="">
                        <span>是农历生日</span>
                    </span>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">界面主题：</td>
                            <td width="70%">
                                <select name="THEME" class="BigSelect">
                                    <option value="1">2008版经典主题：儒雅深沉</option>
                                    <option value="2">2008版经典主题：清新怡然</option>
                                    <option value="9">2009版经典主题：生命与自然之美</option>
                                    <option value="10">2010版梦幻灵动主题：宁静的思考</option>
                                    <option value="13">2013版梦幻灵动主题：现代或未来</option>
                                    <option value="15">2015版梦幻灵动主题：T-OS</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">手机：</td>
                            <td width="70%">
                                <input type="text" name="mobilNo" value="">
                                <span class="spanChech">
                                    <input type="checkbox" name="mobilNoHidden" value="">
                                    <span>手机号码不公开</span>
                                    <p>填写后可接收OA系统发送的手机短信，手机号码不公开仍可接收短信</p>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">电子邮件：</td>
                            <td width="70%">
                                <input type="email" name="email" value="">
                            </td>
                        </tr>
                        <tr>
                            <td width="15%">工作电话：</td>
                            <td width="70%">
                                <input type="text" name="telNoDept" value="">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <%--<tr>
                <td width="15%">密码：</td>
                <td width="70%">
                    <input type="password" name="SUMMARY" value="">
                    <span>8-20位，必须同时包含字母和数字</span>
                </td>
            </tr>
            <tr>
                <td width="15%">性别：</td>
                <td width="70%">
                    <select name="sex">
                        <option value="01">男</option>
                        <option value="01">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td width="15%">生日：</td>
                <td width="70%">
                    <span class="spanChech">
                        <input type="text" name="SUMMARY" value="">
                        <input type="checkbox" name="SUMMARY" value="">
                        <span>是农历生日</span>
                    </span>
                </td>
            </tr>
            <tr>
                <td width="15%">界面主题：</td>
                <td width="70%">
                    <select name="THEME" class="BigSelect">
                        <option value="1">2008版经典主题：儒雅深沉</option>
                        <option value="2">2008版经典主题：清新怡然</option>
                        <option value="9">2009版经典主题：生命与自然之美</option>
                        <option value="10">2010版梦幻灵动主题：宁静的思考</option>
                        <option value="13">2013版梦幻灵动主题：现代或未来</option>
                        <option value="15">2015版梦幻灵动主题：T-OS</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td width="15%">手机：</td>
                <td width="70%">
                    <input type="text" name="SUMMARY" value="">
                    <span class="spanChech">
                        <input type="checkbox" name="SUMMARY" value="">
                        <span>手机号码不公开</span>
                        <p>填写后可接收OA系统发送的手机短信，手机号码不公开仍可接收短信</p>
                    </span>
                </td>
            </tr>
            <tr>
                <td width="15%">电子邮件：</td>
                <td width="70%">
                    <input type="email" name="SUMMARY" value="">
                </td>
            </tr>
            <tr>
                <td width="15%">工作电话：</td>
                <td width="70%">
                    <input type="text" name="SUMMARY" value="">
                </td>
            </tr>--%>
            <tr>
                <td colspan="2">
                    <div class="div_btn">
                        <input type="button" class="inpuBtn" id="btn1" value="新建" />
                        <input type="button" class="inpuBtn" id="btn2" value="返回" />
                    </div>

                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    $(function(){
        $('#department').deptSelect();
    })
</script>
</body>
</html>
