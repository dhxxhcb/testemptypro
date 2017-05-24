<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../lib/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../lib/pagination/style/pagination.css"/>
    <link rel="stylesheet" type="text/css" href="../css/base.css"/>
    <link rel="stylesheet" type="text/css" href="../css/news/center.css"/>
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script src="../js/news/page.js"></script>
    <script src="../lib/laydate.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../lib/layer/layer.js"></script>
    <script src="https://cdn.bootcss.com/jquery.form/4.2.1/jquery.form.js"></script>
    <style>
         .bx{width: 100%}
         .headDiv{
            width: 100%;
            height: 45px;
            border-bottom: #999 1px solid;
        }
         .divP{
            display: inline-block;
            height: 50px;
            line-height: 50px;
            font-size: 20px;
            margin-left: 30px;
        }
         #user_btn{
             float: right;
             display: inline-block;
             width: 85px;
             height:32px;
             text-align: center;
             line-height: 26px;
             margin-top: 7px;
             margin-right: 10.3%;
             font-size: 14px;
             cursor: pointer;
             background-color: #2f80d1;
             outline: none;
             border: #ccc 1px solid;
             color: #fff;
             border-radius: 5px;
         }
         .tab{
             width: 80%;
             margin: 0 auto;
             margin-top: 20px;
         }
         .tab table{
             width: 99%;
             font-size: 14px;
             margin: 0 auto;
         }
         .tab table tr{
             border: 1px solid #c0c0c0;
             cursor: pointer;
         }

         .tab table tr th{
             color: #2F5C8F;
             font-weight: normal;
         }
         .tab table tr:nth-child(odd){
             background-color: #fff;
         }
         .tab table tr:nth-child(even){
             background-color: #F6F7F9;
         }
         .tab table tr.userData:hover{
             background-color: #74d174;
         }
         .tab table tr th,.tab table tr td{
             padding:10px;
         }
         .tab table tr th,.tab table tr td{
             text-align: center;
         }
         .tab table a{
             text-decoration: none;
             text-align: left;
             display: inline-block;
             color:#2B7FE0;
         }
        .searchBox li {
            margin-bottom: 15px;
        }

        .searchBox li input[type="text"] {
            border: 1px solid #ccc;
            font-size: 14px;
            height: 32px;
            line-height: 34px;
            padding: 0 10px;
            width: 265px;
            float: left;
            border-radius: 4px;
            text-align: left;
        }

        .searchBox li input[type="text"]:focus {
            border-color: #0090e3;
        }

        .searchBox li label {
            height: 34px;
            width: 92px;
            line-height: 32px;
            text-align: right;
            margin-right: 10px;
            float: left;
            padding-right: 8px;
        }
    </style>
</head>
<body>
<div class="bx">
    <!--head开始-->
    <div class="headDiv">
        <p class="divP">系统架构管理</p>
        <input type="button" name="user_btn" id="user_btn" value="新建公司" />
    </div>

    <!--content部分开始-->
    <div>
        <div class="tab">
            <table id="tr_td" cellspacing="0" cellpadding="0" style="border-collapse:collapse;">
                <thead>
                <tr>
                    <td class="th">
                        <%--<fmt:message code="notice.th.title"/>--%>公司ID
                    </td>
                    <td class="th">
                        <%--<fmt:message code="news.th.type"/>--%>公司名称
                    </td>
                    <!-- <td class="th" style="position: relative"><fmt:message code="notice.title.Releasedate" />
                               <img style="position: absolute;margin-left:9px;cursor: pointer;" src="../img/05.png" alt=""/>
                             <img style="position: absolute;margin-top:13px;margin-left:9px;cursor: pointer;" src="../img/06.png " alt=""/>
                        </td> -->
                    <td class="th">
                        <%-- <fmt:message code="notice.title.Releasedate"/>--%>版本
                    </td>

                    <td class="th">
                        <%-- <fmt:message code="news.th.clicks"/>--%>是否组织
                    </td>
                    <td class="th">
                        <%--<fmt:message code="news.th.comment"/>--%>修改
                    </td>
                    <!-- <td class="th">发布部门</td> -->
                </tr>
                </thead>
                <tbody id="j_tb" class="tr_td">

                </tbody>
            </table>
        </div>


    </div>
    <!--content部分结束-->

</div>
</div>


<script>
    user_id = 'input_text1';//选人控件
    $(function () {
        var data = {
            read: $('.index_head .one').parent().attr('data_id'),
            typeId: $('#select').val() == 0 ? '' : $('#select').val(),
            nTime: $('#sendTime').val(),
            page: 1,
            pageSize: 5,
            useFlag: true,
            newsTime: '',
            lastEditTime: '',
            content: '',
            subject: ''

        };
        initPageList(function (pageCount) {
            console.log(pageCount);
            initPagination(pageCount, data.pageSize);
        });


        $(".index_head li").click(function () {

            $(this).find('span').addClass('one').parent().siblings('').find('span').removeClass('one');  // 删除其他兄弟元素的样式
            $(".news").html($(this).find('span').text());
            data.read = $(this).attr('data_id');
            data.typeId = $('#select').val() == 0 ? '' : $('#select').val();
            data.nTime = $('#sendTime').val();
            console.log(data);
            if (data.read == '' || data.read == 0) {
                $('.step1').show();
                $('.center').hide();
                initPageList(function (pageCount) {
                    initPagination(pageCount, data.pageSize);
                });
            } else if (data.read == 1) {
                $('.step1').hide();
                $('.center').show('');
                $('#subject').val('');
                $('#beginTime').val('');
                $('#endTime').val('');
                $('#select').val() == 0 ? '' : $('#select').val();
                $('#content').val('');
            }
        });
        function initPageList(cb) {
            var layerIndex = layer.load(0, {shade: false});
            /* 0代表加载的风格，支持0-2 */
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/users/getOrgManage.do",
                dataType: 'JSON',
                data: data,
                success: function (obj) {
                    layer.closeAll();
                    if (obj.object.length == 0) {
                        if ($('.index_head .one').parent().attr('data_id') == '0') {
                            layer.msg('<fmt:message code="notice.alert.nodatealert" />', {icon: 6});
                            var turnindex = setInterval(function () {
                                layer.closeAll();
                                $(".index_head li").eq(1).click();
                                clearInterval(turnindex);
                            }, 2 * 1000);
                        } else {
                            layer.msg('没有更多数据！', {icon: 6});
                        }
                        ;
                    } else {
                        var str = "";


                        for (var i = 0; i < obj.object.length; i++) {
                            var isOrgValue;
                            if (obj.object[i].isOrg == 1) {
                                isOrgValue = "是"
                            } else {
                                isOrgValue = "否"
                            }

                            str += "<tr><td><a href='###' style='color:#666;' oid=" + obj.object[i].oid + "  class='windowOpen'>" + obj.object[i].oid + "</ a></td>" +
                                    "<td><a href='###' style='color:#2B7FE0;' oid=" + obj.object[i].oid + " class='windowOpen'>" + obj.object[i].name + "</ a></td>" +
                                    "<td><a href='###'  style='color:#666;' oid=" + obj.object[i].oid + " class='windowOpen'>" + obj.object[i].version + "</ a></td>" +
                                    "<td><a href='###'  style='color:#666;' oid=" + obj.object[i].oid + "  class='windowOpen'>" + isOrgValue + "</ a></td>" +
                                    "<td><a href='###' oid=" + obj.object[i].oid + "  class='windowOpen thupdate'>" + '修改' + "</ a></td>";
                        }
                        var loadindex = setInterval(function () {
                            layer.closeAll();
                            $("#j_tb").html(str);
                            clearInterval(loadindex);
                        }, 1000);

                        if (cb) {
                            //alert(obj.totleNum);
                            cb(obj.totleNum);
                        }
                    }
                }
            })
        };

        function initPagination(totalData, pageSize) {
            $('.M-box3').pagination({
                totalData: totalData,
                showData: pageSize,
                jump: true,
                coping: true,
                homePage: '<fmt:message code="global.page.first" />',
                endPage: '<fmt:message code="global.page.last" />',
                prevContent: '<fmt:message code="global.page.pre" />',
                nextContent: '<fmt:message code="global.page.next" />',
                jumpBtn: '<fmt:message code="global.page.jump" />',
                callback: function (index) {
                    data.page = index.getCurrent();
                    console.log(index.getCurrent());
                    initPageList();
                }
            });
        };
        //新建公司
        $('#user_btn').click(function(){
            layer.open({
                title: '新建',
                shade: 0,
                content: '<div style="width: 462px"><form id="updatecom" action="${pageContext.request.contextPath}/users/editOrgManage.do">' +
                '<ul class="searchBox clearfix">' +
                '<li style="float: left">' +
                '<label>公司名称:</label><input type="text" name="name" value="">' +
                '</li>' +
                '<li style="float: left">' +
                '<label>版本:</label><input type="text" name="version"  value="">' +
                '</li>' +
                '<li style="float: left">' +
                '<label>是否组织:</label><input type="text" name="isOrg" value="">' +
                '</li>' +
                '</ul></form></div>',
                area: ['500px', '280px'],
                btn: ['确定', '取消'],
            })
        })


        $("#j_tb").on('click', '.thupdate', function () {
            var $oid = $(this).parents('tr').find('td')[0].innerText;
            var $name = jQuery($(this).parents('tr').find('td')[1]).text();
            var $version = $(this).parents('tr').find('td')[2].innerText;
            var $isOrg = $(this).parent().prev().text();
            if ($isOrg == '是') {
                $isOrg = 1;
            } else {
                $isOrg = 0;
            }
            var me = this;


            layer.open({
                title: '修改',
                shade: 0,
                content: '<div style="width: 462px"><form id="updatecom" action="${pageContext.request.contextPath}/users/editOrgManage.do">' +
                '<ul class="searchBox clearfix">' +
                '<li style="float: left">' +
                '<label>公司ID:</label><input type="text" name="oid" value="' + $oid + '" readonly="true" style="background: #fff">' +
                '</li>' +
                '<li style="float: left">' +
                '<label>公司名称:</label><input type="text" name="name" value="' + $name + '">' +
                '</li>' +
                '<li style="float: left">' +
                '<label>版本:</label><input type="text" name="version"  value="' + $version + '">' +
                '</li>' +
                '<li style="float: left">' +
                '<label>是否组织:</label><input type="text" name="isOrg" value="' + $isOrg + '">' +
                '</li>' +
                '</ul></form></div>',
                area: ['500px', '350px'],
                btn: ['确定', '取消'],
                yes: function (index) {
                    $('#updatecom').ajaxSubmit(function (json) {

                        for (var i = 0; i < json.object.length; i++) {
                            if (json.object[i].oid == $oid) {

                                $(me).parents('tr').find('td')[1].innerText = json.object[i].name;
                                $(me).parents('tr').find('td')[2].innerText = json.object[i].version;

                                if (json.object[i].isOrg == 1) {
                                    $(me).parents('tr').find('td')[3].innerText = '是'
                                } else {
                                    $(me).parents('tr').find('td')[3].innerText = '否'
                                }
                            }

                        }


                    })
                    location.reload();
                }
            })

        });


        $('.submit').click(function () {
            data.read = $('.index_head .one').parent().attr('data_id');
            data.typeId = $('#select').val();
            data.nTime = $('#sendTime').val();
            //console.log(read,typeId,nTime);
            initPageList();
        });
        //时间控件调用
        $('#btn_query').click(function () {

            data.subject = $('#subject_query').val();
            data.newsTime = $('#beginTime').val();
            data.lastEditTime = $('#endTime').val();
            data.typeId = $('#select_query').val() == 0 ? '' : $('#select_query').val();
            data.content = $('#content').val();
            initPageList();
            $('.step1').show();
            $('.center').hide();
        });
    });

    laydate({
        elem: '#sendTime', //目标元素。
        format: 'YYYY-MM-DD', //日期格式
        istime: true, //显示时、分、秒
    });
    //时间控件调用
    var start = {
        elem: '#beginTime',
        format: 'YYYY-MM-DD',
        /* min: laydate.now(), //设定最小日期为当前日期*/
        /* max: '2099-06-16 23:59:59', //最大日期*/
        istime: true,
        istoday: false,
        choose: function (datas) {
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas; //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#endTime',
        format: 'YYYY-MM-DD',
        /*min: laydate.now(),*/
        /*max: '2099-06-16 23:59:59',*/
        istime: true,
        istoday: false,
        choose: function (datas) {
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);


</script>
</body>


</html>








