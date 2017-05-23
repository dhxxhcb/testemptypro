<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/" ;
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

</head>
<body>
<div class="bx">
    <!--head开始-->
    <br/>
    <h6>多企业管理</h6>
    </hr>

        <!--content部分开始-->
        <div>
            <div>
                <table id="tr_td">
                    <thead>
                    <tr>
                        <td class="th">
                            <%--<fmt:message code="notice.th.title"/>--%>公司id
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
                    <tbody id="j_tb" calss="tr_td">

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
                        };
                    } else {
                        var str = "";


                        for (var i = 0; i < obj.object.length; i++) {
                            var isOrgValue;
                            if(obj.object[i].isOrg == 1){
                                isOrgValue = "是"
                            }else{
                                isOrgValue = "否"
                            }

                            str += "<tr><td><a href='#' style='color:#666;' oid=" + obj.object[i].oid + "  class='windowOpen'>" + obj.object[i].oid + "</ a></td>" +
                                    "<td><a href='#' style='color:#2B7FE0;' oid=" + obj.object[i].oid + " class='windowOpen'>" + obj.object[i].name + "</ a></td>" +
                                    "<td><a href='#'  style='color:#666;' oid=" + obj.object[i].oid + " class='windowOpen'>" + obj.object[i].version + "</ a></td>" +
                                    "<td><a href='#'  style='color:#666;' oid=" + obj.object[i].oid + "  class='windowOpen'>" + isOrgValue + "</ a></td>" +
                                    "<td><a href='#'  style='color:#666;' oid=" + obj.object[i].oid + "  class='windowOpen'>" + '修改' + "</ a></td>";
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




        $("#j_tb").on('click', '.windowOpen', function () {
            var oid = $(this).attr('oid');

            //$.popWindow('detail?oid=' + oid, '');


            var top = top || '100';
            var left = left || '300';
            var width = width || '640';
            var height = height || '500';
            var specs = 'top='+top+',left='+left+',width='+width+',height='+height;
            window.open("users/getOrgManageById?oid=1001","aa",specs);

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








