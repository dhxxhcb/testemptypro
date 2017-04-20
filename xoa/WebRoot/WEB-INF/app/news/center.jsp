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
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../css/news/page.css">
    <link rel="stylesheet" type="text/css" href="../css/news/center.css"/>
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script src="../js/news/page.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(function () {
            var GG = {
                "kk": function (mm) {
                  
				
					$.ajax({
						type:"get",
						url:"<%=basePath%>news/newsShow",
						dataType:'json',
						data:{page:mm,pageSize:"10",useFlag:"true"},
						success:function(data){
						/* alert("第" + mm + "页"); */
						/* var data1=rsp.obj[0].clickCount */	
							
                            var news = "";
                            for (var i = 0; i < data.obj.length; i++) {
                                news = "<tr><td>"+data.obj[i].subject+"</td>"+
                                        "<td>"+data.obj[i].typeId+"</td>"+
                                        "<td>"+data.obj[i].newsTime+"</td>"+
                                        "<td><a href='' noticeId="+data.obj[i].newsTime+" class='windowOpen'>"+data.obj[i].clickCount+"</ a></td>"+
                                        "<td>"+data.obj[i].read+"</td>"+news;
                            }
							
							$("#j_tb").html(news);
							
						}
					});
					
				
    
					
                    
                }
            };
            $("#page").initPage(71, 1, GG.kk);

            $("li").click(function(){
                $(this).siblings('li').removeClass('one');  // 删除其他兄弟元素的样式
                $(this).addClass("one");
                if($(this).text()=="未读新闻"||$(this).text()=="全部新闻"||$(this).text()=="新闻查询"){
                $(".news").html($(this).text());
                }
                
               /* alert($(this).text());*/
            });
            
            /* 新闻详情页 */
               $("#j_tb").on('click','.windowOpen',function(){
            var nid=$(this).attr('noticeId');
            $.popWindow('detail?nid='+nid);
        });
        
        });

 


    </script>
</head>
<body>
<div class="bx">
    <!--head开始-->
    <div class="head w clearfix">
        <ul>
            <li class="one">全部新闻</li>
            <li style="width:2px;"><img src="../img/02.png" alt=""/></li>
            <li>未读新闻</li>
            <li style="width:2px;"><img src="../img/02.png" alt=""/></li>
            <li>新闻查询</li>
        </ul>
    </div>
    <!--head通栏结束-->

    <!--navigation开始-->
    <div class="navigation  clearfix">
        <div class="left">
            <img src="../img/01.png">

            <div class="news">全部新闻</div>
            <div class="button1">
                <div style="margin-right:98px;">文件夹</div>
                <img src="../img/v.png">
            </div>
            <div>
                <div style="font-size: 15px; margin-left:28px; ">日期 :</div>
                <div class="button1">
                    <div style="margin-right:61px;">2017-03-24</div>
                    <img src="../img/v.png">
                </div>

            </div>
            <img style="margin-left:24px;margin-top:20px; cursor: pointer;" src="../img/03.png" alt=""/>
        </div>


        <div class="right">

            <ul class="page" maxshowpageitem="0" pagelistcount="1" id="page"></ul>

        </div>

    </div>

    <!--navigation结束-->

    <!--content部分开始-->
    <div class="w">
        <div class="wrap">
            <table class="w">
                <thead>
                <tr>
                    <td class="th">标题</td>
                    <td class="th">类型</td>
                    <td class="th"  >
                        发布时间

                         <img style="position: absolute;margin-left:9px;cursor: pointer;" src="../img/05.png" alt=""/>
                         <img  style="position: absolute;margin-top:13px;margin-left:9px;cursor: pointer;" src="../img/06.png " alt=""/>
                    </td>
                    <td class="th">点击次数</td>
                    <td class="th">评论（条）</td>
                </tr>
                </thead>
                <tbody id="j_tb">
                <tr>
                    <td>
                        团队调高效率的方法
                    </td>
                    <td>行业资讯</td>
                    <td>2017-04-14 10:55</td>
                    <td>01</td>
                    <td>20</td>
                </tr>
                <tr>
                    <td>
                        团队调高效率的方法
                    </td>
                    <td>行业资讯</td>
                    <td>2017-04-14 10:55</td>
                    <td>01</td>
                    <td>20</td>
                </tr>
                <tr>
                    <td>
                        团队调高效率的方法
                    </td>
                    <td>行业资讯</td>
                    <td>2017-04-14 10:55</td>
                    <td>01</td>
                    <td>20</td>

                </tr>
                <tr>
                    <td>
                        团队调高效率的方法
                    </td>
                    <td>行业资讯</td>
                    <td>2017-04-14 10:55</td>
                    <td>01</td>
                    <td>20</td>

                </tr>
                <tr>
                    <td>
                        团队调高效率的方法
                    </td>
                    <td>行业资讯</td>
                    <td>2017-04-14 10:55</td>
                    <td>01</td>
                    <td>20</td>

                </tr>
                <tr>
                    <td>
                        团队调高效率的方法
                    </td>
                    <td>行业资讯</td>
                    <td>2017-04-14 10:55</td>
                    <td>01</td>
                    <td>20</td>

                </tr>
                </tbody>
            </table>
        </div>


    </div>
    <!--content部分结束-->

    <!--footer部分开始-->
    <div class="footer w clearfix">
        <div>快捷操作:</div>
        <div class="read">
            <img src="../img/read.png" alt=""/>
        </div>

    </div>


    <!--footer部分结束-->
</div>

</body>



</html>
