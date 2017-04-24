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
    <link rel="stylesheet" type="text/css" href="../lib/laydate.css"/>
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script src="../js/news/page.js"></script>
    <script src="../lib/laydate.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(function () {
            var GG = {
                "kk": function (mm) {
                 	var read = $('.index_head .one').parent().attr('data_id');
					var typeId = $('#select').val()==0?'':$('#select').val();
					var nTime = $('#test').val();
					console.log(read,typeId,nTime);
					ajax_data(read,typeId,nTime);
                }
            };
            $("#page").initPage(71, 1, GG.kk);

           $(".index_head li").click(function (){
				console.log('qqq');
                $(this).find('span').addClass('one').parent().siblings('').find('span').removeClass('one');  // 删除其他兄弟元素的样式
                $(".news").html($(this).find('span').text());
				var read = $(this).attr('data_id');
				var typeId = $('#select').val()==0?'':$('#select').val();
				var nTime = $('#test').val();
				console.log(read,typeId,nTime);
				if(read == ''||read == 0){
					$('.step1').show();
					$('.center').hide();
					ajax_data(read,typeId,nTime);
				}else if(read == 1){
					$('.step1').hide();
					$('.center').show();
				}
				
            })
            function ajax_data(read,typeId,nTime){
            	$.ajax({
					type: "get",
					url: "<%=basePath%>news/newsShow",
					dataType: 'JSON',
					data: {
						page:1,
						pageSize:5,
						useFlag:true,
						read:read,
						typeId:typeId,
						nTime:nTime
					},
					success: function(data){
						console.log(data);
						var news = "";
                           for (var i = 0; i < data.obj.length; i++) {
                               news = "<tr><td><a href='' newsId="+data.obj[i].newsId+" class='windowOpen'>"+data.obj[i].subject+"</ a></td>"+
                                       "<td><a href='' newsId="+data.obj[i].newsId+" class='windowOpen'>"+data.obj[i].typeName+"</ a></td>"+
                                       "<td><a href='' newsId="+data.obj[i].newsId+" class='windowOpen'>"+data.obj[i].newsTime+"</ a></td>"+
                                       "<td><a href='' newsId="+data.obj[i].newsId+" class='windowOpen'>"+data.obj[i].clickCount+"</ a></td>"+
                                       "<td><a href='' newsId="+data.obj[i].newsTime+" class='windowOpen'>"+data.obj[i].read+"</ a></td>"+news;
                           }
						
						$("#j_tb").html(news);
					}   
				})
            }
            
            /* 新闻详情页 */
               $("#j_tb").on('click','.windowOpen',function(){
		            var nid=$(this).attr('newsId');
		            $.popWindow('detail?newsId='+nid);
		        });
        		$('.submit').click(function (){
					var read = $('.index_head .one').parent().attr('data_id');
					var typeId = $('#select').val();
					var nTime = $('#test').val();
					console.log(read,typeId,nTime);
					ajax_data(read,typeId,nTime);
				})
        });
		
 


    </script>
    <style type="text/css">
		.head li{
			width: 154px;
			text-align: left;
		}
		.center .login {
		    width: 550px;
		    height: 336px;
		    margin: 0px auto;
		}
		
		.center .login .header {
		    height: 31px;
		    line-height: 31px;
		    background-color: #3791DA;
		    color: #fff;
		    font-size: 14px;
		    text-align: center;
		    border-radius: 4px 4px 0px 0px;
		}
		.center .login .middle {
		    /*border-bottom:2px solid #DCDCDC;*/
		    border: 1px solid #DCDCDC;
		
		}
		.center .login .middle .color{
		    color:#2A588C;
		}
		.center .login .middle .le{
		    margin-left:25px;
		
		}
		.center .login .publisher {
		    height:50px;
		    line-height:50px;
		    /*border:2px dashed black;*/
		    margin-top:20px;
		}
		.center .login .publisher div{
		    float: left;
		}
		.center .login .subject {
		    height:26px;
		    line-height:26px;
		    /*border:2px dashed black;*/
		    margin-top:18px;
		}
		.center .login .subject div {
		    float: left;
		
		}
		.center .login .date {
		    height:24px;
		    line-height:24px;
		    /*border:2px dashed black;*/
		    margin-top:13px;
		}
		.center .login .date div {
		    float: left;
		}
		.center .login .ce1 {
		    height:25px;
		    line-height:25px;
		    /*border:2px dashed black;*/
		    margin-top:13px;
		}
		.center .login .ce1 div {
		    float: left;
		}
		.center .login .ce2 {
		    height:26px;
		    line-height:26px;
		    /*border:2px dashed black;*/
		    margin-top:17px;
		    margin-bottom:15px;
		}
		.center .login .ce2 div {
		    float: left;
		}
		.center .login .icons {
		    height:58px;
		    line-height:58px;
		    text-align: center;
		    border:1px solid #DCDCDC;
		
		}
		.center .logins .icon .img {
		    float: left;
		}
		input{
     		border: 1px solid #ccc;
     	}
	</style>
</head>
<body>
<div class="bx">
    <!--head开始-->
    <div class="head w clearfix">
        <ul class="index_head">
            <li data_id=""><span class="one" style="width: 112px;display: inline-block;text-align: center;">全部新闻</span><img src="../img/02.png" alt="" style="width: 2px;width: 2px;margin: 0 10px;margin-left: 30px;"/></li>
            <li data_id="0"><span style="width: 112px;display: inline-block;text-align: center;">未读新闻</span><img src="../img/02.png" alt="" style="width: 2px;width: 2px;margin: 0 10px;margin-left: 30px;"/></li>
            <li data_id="1"><span style="width: 112px;display: inline-block;text-align: center;">新闻查询</span></li>
        </ul>
    </div>
    <!--head通栏结束-->

    <!--navigation开始-->
    <div class="step1"> 
    <div class="navigation  clearfix">
        <div class="left">
            <img src="../img/01.png">

            <div class="news">全部新闻</div>
            <select name="TYPE" class="button1" style="float: left;" id="select">
				<option value="0" selected="">所有类型</option>
				<option value="01">公司动态</option>
				<option value="02">媒体关注</option>
				<option value="03">行业资讯</option>
				<option value="04">合作伙伴新闻</option>
				<option value="05">客户新闻</option>
				<option value="">无类型</option>
			</select>
            <div>
                <div style="font-size: 15px; margin-left:28px; ">日期 :</div>
                <input class="button1" id="test">
            </div>
            <img  class="submit" style="margin-left:24px;margin-top:13px; cursor: pointer;" src="../img/03.png" alt=""/>
        </div>


        <div class="right">

            <!-- 分页按钮-->
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
                    	<td class="th" style="position: relative">发布时间
	                        <img style="position: absolute;margin-left:9px;cursor: pointer;" src="../img/05.png" alt=""/>
	                        <img style="position: absolute;margin-top:13px;margin-left:9px;cursor: pointer;"
	                             src="../img/06.png " alt=""/>
	                    </td>
	                    <td class="th">点击次数</td>
	                    <td class="th">评论（条）</td>
	                    <td class="th">发布部门</td>
	                </tr>
                </thead>
                <tbody id="j_tb">                                                                                           
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
    </div>
    <div class="center" style="width:100%;margin-top: 50px;display: none;">
    	 <div class="login">
	        <div class="header">输入查询条件</div>
	        <div class="middle">
	            <div class="le publisher">
	                <div class="color">发布人：</div>
	                <div><input style="height:50px;width:279px;margin-left:56px;margin-right: 15px;" type="text" /></div>
	                <div style="margin-right:23px; color:#207BD6">添加</div>
	                <div>清空</div>
	            </div>
	            <div class="le subject">
	                <div class="color">标题：</div>
	                <div><input style="height:26px;width:279px;margin-left:69px;margin-right: 15px;" type="text"/></div>
	            </div>
	            <div class="le date">
	                <div class="color">发布日期：</div>
	                <div><input style="height:24px;width:119px;margin-left:38px;margin-right: 11px;" type="text"/></div>
	                <div class="color">至</div>
	                <div> <input  style="height:24px;width:119px;margin-left:11px;" type="text"/></div>
	            </div>
	            <div class="le ce1">
	                <div class="color">内容：</div>
	                <div><input  style="height:25px;width:279px;margin-left:70px;"   type="text"/></div>
	
	            </div>
	            <div class="le ce2">
	                <div class="color">内容:</div>
	                <div><input   style="height:25px;width:279px;margin-left:80px;" type="text"/></div>
	
	            </div>
	        </div>
	        <div class="icons">
	            <img style="margin-right:30px; cursor: pointer;" src="../img/3query.png" alt=""/>
	            <img style="margin-right:30px; cursor: pointer;"  src="../img/4query.png" alt=""/>
	            <img style=" cursor: pointer;" src="../img/5query.png" alt=""/>
	        </div>
	    </div>
    </div>


    <!--footer部分结束-->
</div>
<script>
	//时间控件调用
   laydate({
     elem: '#test', //目标元素。
     format: 'YYYY-MM-DD hh:mm:ss', //日期格式
     istime: true, //显示时、分、秒
   });
   
   //时间控件调用
   var start = {
     elem: '#start',
     format: 'YYYY/MM/DD hh:mm:ss',
    /* min: laydate.now(), //设定最小日期为当前日期*/
    /* max: '2099-06-16 23:59:59', //最大日期*/
     istime: true,
     istoday: false,
     choose: function(datas){
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas; //将结束日的初始值设定为开始日
     }
   };
   var end = {
     elem: '#end',
     format: 'YYYY/MM/DD hh:mm:ss',
     /*min: laydate.now(),*/
     /*max: '2099-06-16 23:59:59',*/
     istime: true,
     istoday: false,
     choose: function(datas){
       start.max = datas; //结束日选好后，重置开始日的最大日期
     }
   };
   laydate(start);
   laydate(end);
</script>
</body>



</html>