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
     <link rel="stylesheet" type="text/css" href="../css/news/center.css"/>
    <link rel="stylesheet" type="text/css" href="../lib/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="../lib/pagination/style/pagination.css"/>
    <link rel="stylesheet" type="text/css" href="../css/base.css" />
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script src="../js/news/page.js"></script>
    <script src="../lib/laydate.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
	<script src="../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
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
     	#input1 {
     		width:12px;
     		hight:12px;
     	}
     	.break_td{
     		width: 100px;
		    overflow: hidden;
		    text-overflow: ellipsis;
		    white-space: nowrap;
     	}
     	#cx {
     		background-image:url(../img/center_q.png);
     		background-repeat:no-repeat;
     		width:60px;
     		hieght:30px;
     		line-height:30px;
     		margin-top: 18px;
     		margin-left: 10px;
     		text-align:center;
     		color:#fff;
     		cursor: pointer;
     		font-family: "微软雅黑";
     	}
	</style>
</head>
<body>
<div class="bx">
    <!--head开始-->
    <div class="head w clearfix">
        <ul class="index_head">
            <li data_id=""><span class="one" style="width: 112px;display: inline-block;text-align: center;"><fmt:message code="news.th.newsmanage" /></span><img src="../img/02.png" alt="" style="width: 2px;width: 2px;margin: 0 10px;margin-left: 30px;"/></li>
            <li data_id="0"><span style="width: 112px;display: inline-block;text-align: center;"><fmt:message code="news.th.newbuild" /></span><img src="../img/02.png" alt="" style="width: 2px;width: 2px;margin: 0 10px;margin-left: 30px;"/></li>
            <li data_id="1"><span style="width: 112px;display: inline-block;text-align: center;"><fmt:message code="news.title.query" /></span></li>
        </ul>
    </div>
    <!--head通栏结束-->

    <!--navigation开始-->
    <div class="step1"> 
    <div class="navigation  clearfix">
        <div class="left">
            <img src="../img/01.png" style="width:25px;height:25px; margin-right:5px;">

            <div class="news"><fmt:message code="news.th.allnews" /></div>
            <select name="TYPE" class="button1" style="float: left;" id="select">
				<option value="0" selected=""><fmt:message code="news.th.type" /></option>
				<option value="01"><fmt:message code="news.th.company" /></option>
				<option value="02"><fmt:message code="news.th.media" /></option>
				<option value="03"><fmt:message code="news.th.industry" /></option>
				<option value="04"><fmt:message code="news.th.partner" /></option>
				<option value="05"><fmt:message code="news.th.client" /></option>
				<option value=""><fmt:message code="news.th.none" />
			</select>
			 <!-- <img  class="submit" style="width:55px;height:30px;margin-top: 18px;margin-left: 10px;" class="submit" style="margin-left:24px;margin-top:13px; cursor: pointer;" src="../img/03.png" alt=""/> -->
			 <div  class="submit" id="cx">查询</div>	
        </div>


          <div class="right">

            <!-- 分页按钮-->
            <div class="M-box3"></div>

        </div>

    </div>

    <!--navigation结束-->

    <!--content部分开始-->
    <div class="w">
        <div class="wrap">
            <table class="w">
                <thead>
                	<tr>
                		<td class="th"><fmt:message code="global.lang.select" /></td>
                    	<td class="th"><fmt:message code="notice.th.publisher" /></td>
                    	<td class="th"><fmt:message code="notice.th.type" /></td>
                    	<td class="th" style="position: relative"><fmt:message code="notice.th.releasescope" /></td>
	                    <td class="th"><fmt:message code="notice.th.title" /></td>
	                    <td class="th"><fmt:message code="notice.th.PostedTime" /></td>
	                    <td class="th"><fmt:message code="news.th.clicknumber" /></td>
	                    <td class="th"><fmt:message code="news.th.commentnew" /></td>
	                    <td class="th"><fmt:message code="notice.th.state" /></td>
	                    <td class="th"><fmt:message code="notice.th.operation" /></td>
	                   
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
        <div><input id='input1' name="" type="checkbox" value="" /><fmt:message code="notice.th.allchose" /></div>
        <div><fmt:message code="news.th.deletenews" /></div>
        <div><fmt:message code="news.th.querysituation" /></div>
        <div><fmt:message code="news.th.quittop" /></div>
        <div><fmt:message code="news.th.deleteall" /></div>
        <div><fmt:message code="news.th.end" /></div>
        <div><fmt:message code="news.th.effective" /></div>

    </div>
    </div>
    <div class="center" style="width:100%;margin-top: 50px;display: none;">
    	 <div class="login">
	        <div class="header"><fmt:message code="global.lang.inputquerycondition" /></div>
	        <div class="middle">
	            <div class="le publisher">
	                <div class="color"><fmt:message code="notice.th.publisher" />：</div>
	                <div><input style="height:50px;width:279px;margin-left:56px;margin-right: 15px;" type="text" /></div>
	                <div style="margin-right:23px; color:#207BD6"><fmt:message code="global.lang.add" /></div>
	                <div><fmt:message code="global.lang.empty" /></div>
	            </div>
	            <div class="le subject">
	                <div class="color"><fmt:message code="notice.th.title" />：</div>
	                <div><input id="subject" style="height:26px;width:279px;margin-left:69px;margin-right: 15px;" type="text"/></div>
	            </div>
				<div class="le date">
	                <div class="color"><fmt:message code="notice.title.Releasedate" />：</div>
	                <div><input id="beginTime" style="height:24px;width:119px;margin-left:45px;margin-right: 11px;" type="text"/></div>
	                <div class="color"><fmt:message code="global.lang.to" /></div>
	                <div> <input id="endTime" style="height:24px;width:119px;margin-left:11px;" type="text"/></div>
	            </div>
	           	<div class="le ce1">
	                <div class="color"><fmt:message code="notice.th.type" />：</div>
	                <div>            
		                <select name="TYPE" style="height:24px;width:119px;margin-left:71px;" class="button1" style="float: left;" id="select">
							<option value="0" selected=""><fmt:message code="news.th.type" /></option>
							<option value="01"><fmt:message code="news.th.company" /></option>
				            <option value="02"><fmt:message code="news.th.media" /></option>
				            <option value="03"><fmt:message code="news.th.industry" /></option>
				            <option value="04"><fmt:message code="news.th.partner" /></option>
				             <option value="05"><fmt:message code="news.th.client" /></option>
				             <option value=""><fmt:message code="news.th.none" /></option>
						</select>
					</div>
	
	            </div>
	            <div class="le ce2">
	                <div class="color"><fmt:message code="notice.th.content" />:</div>
	                <div><input id="content"  style="height:25px;width:279px;margin-left:80px;" type="text"/></div>
	
	            </div>
	        </div>
	        <div class="icons">
	            <img id="btn_query" style="margin-right:30px; cursor: pointer;" src="../img/3query.png" alt=""/>
	            <img style="margin-right:30px; cursor: pointer;"  src="../img/4query.png" alt=""/>
	            <img style=" cursor: pointer;" src="../img/5query.png" alt=""/>
	        </div>
	    </div>
    </div>


    <!--footer部分结束-->
</div>
<script>
$(function () {
            var data = {
                read : $('.index_head .one').parent().attr('data_id'),
				typeId : $('#select').val()==0?'':$('#select').val(),
				nTime : $('#sendTime').val(),
				page:1,
				pageSize:5,
				useFlag:true,
				newsTime:'',
				lastEditTime:'',
				content:'',
				subject:'',
				typeId:0

            };
           initPageList(function(pageCount){
           		 initPagination(pageCount,data.pageSize);
           });
          
		  
           $(".index_head li").click(function (){
				console.log('qqq');
                $(this).find('span').addClass('one').parent().siblings('').find('span').removeClass('one');  // 删除其他兄弟元素的样式
                $(".news").html($(this).find('span').text());
				data.read = $(this).attr('data_id');
				data.typeId = $('#select').val()==0?'':$('#select').val();
				data.nTime = $('#sendTime').val();
				console.log(data);
				if(data.read == ''){
					$('.step1').show();
					$('.center').hide();
					initPageList();
				}else if(data.read == 1 || data.read == 0){
					$('.step1').hide();
					$('.center').show('');
					$('#subject').val('');
					$('#beginTime').val('');
					$('#endTime').val('');
					$('#select').val()==0?'':$('#select').val();
					$('#content').val('');
				}
				
            });
            function initPageList(cb){
            	$.ajax({
					type: "get",
					url: "<%=basePath%>news/newsShow",
					dataType: 'JSON',
					data: data,
					success: function(data){
						console.log(data);
						var news = "";
                           for (var i = 0; i < data.obj.length; i++) {
                               	 news = "<tr><td><input  id='input1' name='' type='checkbox' value=''/></td>"+//选择
                               		   "<td>"+data.obj[i].providerName+"</td>"+//发布人
                                       "<td>"+data.obj[i].typeName+"</td>"+//类型
                                       "<td><div class='break_td' title="+data.obj[i].depName+">"+'点击详情'+"</div></td>"+//发布范围
                                       "<td><a href='' newsId="+data.obj[i].newsId+" class='windowOpen'>"+data.obj[i].subject+"</a></td>"+//标题
                                       "<td>"+data.obj[i].newsDateTime+"</td>"+//发布时间
                                       "<td>"+data.obj[i].clickCount+"</td>"+//点击数
                                       "<td>"+data.obj[i].newsId+"</td>"+//评论（条）
                                       "<td>"+"生效</td>"+//状态
                                       "<td>"+"修改  管理评论  终止  删除</td>"+//操作
                                       news;
                           }
                           
							
						$("#j_tb").html(news);
						if(cb){
							cb(data.totleNum);
						}
					}   
				})
            }
            function initPagination(totalData,pageSize){
            	console.log(totalData+'---'+pageSize);
            	$('.M-box3').pagination({
							    totalData:totalData,
							    showData:pageSize,
							    jump:true,
							    coping:true,
							    homePage:'<fmt:message code="global.page.first" />',
							    endPage:'<fmt:message code="global.page.last" />',
							    prevContent:'<fmt:message code="global.page.pre" />',
							    nextContent:'<fmt:message code="global.page.next" />',
							    jumpBtn:'<fmt:message code="global.page.jump" />',
							    callback:function(index){
							    	data.page = index.getCurrent();
							    	console.log(index.getCurrent());
							    	initPageList();
							    }
							});
            }
            /* 新闻详情页 */
               $("#j_tb").on('click','.windowOpen',function(){
		            var nid=$(this).attr('newsId');
		            $.popWindow('detail?newsId='+nid);
		        });
		        /* 新闻查询按钮 */
        		$('.submit').click(function (){
					data.read = $('.index_head .one').parent().attr('data_id');
					data.typeId = $('#select').val();
					data.nTime = $('#sendTime').val();
					//console.log(read,typeId,nTime);
					initPageList();
				});
				//时间控件调用
  
   $('#btn_query').click(function (){
		
		data.subject = $('#subject').val();
		data.beginTime = $('#beginTime').val();
		data.endTime = $('#endTime').val();
		data.typeId =  $('#select').val()==0?'':$('#select').val();
		data.content = $('#content').val();
		initPageList();
		$('.step1').show();
		$('.center').hide();
	});
});
	 laydate({
     elem: '#sendTime', //目标元素。
     format: 'YYYY-MM-DD hh:mm:ss', //日期格式
     istime: true, //显示时、分、秒
   });
   
   //时间控件调用
   var start = {
     elem: '#beginTime',
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
     elem: '#endTime',
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
