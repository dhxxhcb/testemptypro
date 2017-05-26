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
    <title>用户管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/sys/userManagement.css"/>
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="content">
    <div class="headDiv">
        <p class="divP">用户管理-管理范围（全体）</p>
    </div>
    <div class="left">
        <div class="collect">
            <div id="incum" class="divUP">
                <span class="spanUP liUp AUP">在职人员</span>
                    <ul id="ULDown" style="display:none;">

                    </ul>
            </div>
            <div><span class="spanUP liUp">离职人员/外部人员</span></div>
            <div><span class="spanUP liUp">最近新增用户</span></div>
            <div><span class="spanUP liUp">用户查询或导出</span></div>
            <div><span class="spanUP liUp">用户导入</span></div>
            <div><span class="spanUP liUp">批量用户个性设置</span></div>
            <div><span class="spanUP liUp">提醒空密码用户</span></div>
            <div><span class="spanUP liUp">导出RTX格式</span></div>
            <div><span class="spanUP liUp">退出用户客户端登录</span></div>
        </div>
    </div>
    <div class="right">
        <div class="header">
            <span class="USER">新建用户</span><span class="post">（总经理）</span>
            <input type="button" name="btn" id="btn" value="新建用户" />
        </div>
        <div class="title">
            <span class="USER">新建用户</span><span class="post">（总经理）</span>
            <select name="allUser">
                <option value="01">所有用户</option>
                <option value="02">允许登录用户</option>
                <option value="03">禁止登录用户</option>
            </select>
            <span class="explain">说明：密码为空用户显示为红色,禁止登录用户显示为灰色</span>
        </div>
        <div class="tab">
            <table cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
                <tr class='tr_befor'>
                    <th width="4%">
                        <input type="checkbox" name="checkbox" id="checkbox" value="" style="width:13px;height:13px;" />
                    </th>
                    <th width="8%">用户名</th>
                    <th width="8%">真实姓名</th>
                    <th width="8%">部门</th>
                    <th width="8%">排班</th>
                    <th width="14%">角色</th>
                    <th width="8%">管理范围</th>
                    <th width="18%">最后访问</th>
                    <th width="8%">闲置</th>
                    <th width="16%">操作</th>
                </tr>

            </table>
        </div>
        <div class="bottom w">
            <div class="checkALL">
                <input id="checkedAll" type="checkbox" name="" value="" >
                <label for="checkedAll" style="font-size: 14px;">全选</label>

            </div>
            <div class="boto">
                <a class="ONE" href="javascript:;"><span>删除</span></a>
            </div>
            <div class="boto">
                <a class="TWO" href="javascript:;"><span>清空在线时长</span></a>
            </div>
            <div class="boto">
                <a class="THREE" href="javascript:;"><span>清空密码</span></a>
            </div>
            <div class="boto">
                <a class="FOUR" href="javascript:;"><span>禁止登录</span></a>
            </div>
            <div class="boto">
                <a class="FIVE" href="javascript:;"><span>提醒空密码用户</span></a>
            </div>
            <div class="boto">
                <a class="FIVE" href="javascript:;"><span>批量调换部门</span></a>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#btn').click(function(){
            $.popWindow('../addUsers','新建用户','0','0','800px','600px');
        })

        getChDept($('#ULDown'),30);
        $('.AUP').click(function(){
            //$('#ulList').slideToggle();
            if($('#ULDown').css('display')=='block'){
                $(this).addClass('liUp').removeClass('liDown');
                $('#ULDown').slideUp();
            }else{
                $(this).addClass('liDown').removeClass('liUp');
                $('#ULDown').slideDown();
            }
        })

        //部门人员情况列表
        $('#ULDown').on('click','.childdept',function(){
            var  that = $(this);
            var deptid=that.attr('deptid');
            $('.childdept').removeClass('on');
            that.addClass('on')
            getChDept(that.next(),deptid);
            that.next().slideToggle();
            deptById(deptid,$('.tr_befor'));

        })

        //删除人员


        //部门人员树状图方法
        function getChDept(element,deptId){

            $.ajax({
                url:'/department/getChDept',
                type:'get',
                data:{'deptId':deptId },
                dataType:'json',
                success:function(data){

                    if(deptId==30){
                        var str = '';
                        data.obj.forEach(function(v,i){
                            if(v.deptName){
                                str+='<li><span deptid="'+v.deptId+'" class="childdept"><img style="margin-left: 42px;margin-right: 5px" src="../img/main_img/company_logo.png" alt=""><a href="#" class="dynatree-title" title="'+v.deptName+'">'+v.deptName+'</a></span><ul></ul></li>';
                            }else{
                                str+='<li><span deptid="'+v.deptId+'" class="childdept"><span><img style="margin-left: 65px;margin-right: 5px" src="../img/main_img/man.png" alt=""></span><img style="margin-left: 65px;margin-right: 5px" src="../img/main_img/man.png" alt=""><a href="#" class="dynatree-title" title="'+v.userName+'">'+v.userName+'</a></span><ul></ul></li>';
                            }
                        });
                    }else{
                        var str = '';
                        data.obj.forEach(function(v,i){
                            if(v.deptName){
                                str+='<li><span deptid="'+v.deptId+'" class="childdept"><img style="margin-left: 65px;margin-right: 5px" src="../img/main_img/company_logo.png" alt=""><a href="#" class="dynatree-title" title="'+v.deptName+'">'+v.deptName+'</a></span><ul></ul></li>';
                            }else{
                                if(v.sex==0){
                                    str+='<li><span deptid="'+v.deptId+'" class="childdept"><img style="margin-left: 65px;margin-right: 5px" src="../img/main_img/man.png" alt=""><a href="#" class="dynatree-title" title="'+v.userName+'">'+v.userName+'</a></span><ul></ul></li>';
                                }else if(v.sex==1){
                                    str+='<li><span deptid="'+v.deptId+'" class="childdept"><img style="margin-left: 65px;margin-right: 5px" src="../img/main_img/women.png" alt=""><a href="#" class="dynatree-title" title="'+v.userName+'">'+v.userName+'</a></span><ul></ul></li>';
                                }
                            }

                        });
                    }
                    element.html(str);
                }
            })
        }

        //人员列表展示
        function deptById(id,element){
            $('.tab').find('.userData').remove();
            $.ajax({
                url:'/user/getByDeptId',
                type:'get',
                dataType:'json',
                data:{'deptId':id},
                success:function(rsp){
                    var data1=rsp.obj;
                    console.log(data1);
                    var str='';
                    for(var i=0;i<data1.length;i++){
                        str+='<tr class="userData"><td><input type="checkbox" name="checkbox" id="checkboxs" value="" style="width:13px;height:13px;" /></td>'+
                            '<td>'+data1[i].userId+'</td><td>'+data1[i].userName+'</td><td>'+data1[i].deptName+'</td><td></td><td>'+data1[i].userPrivName+'</td><td>'+data1[i].postPriv+'</td>'+
                            '<td></td><td></td><td><a href="javascript:;" style="margin-right: 5px;">编辑</a><a href="javascript:;">菜单权限查看 </a></td></tr>';
                    }

                    element.after(str);
                }
            })
        }
    })

</script>
</body>
</html>
