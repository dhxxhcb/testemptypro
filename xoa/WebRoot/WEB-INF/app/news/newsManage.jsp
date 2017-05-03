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
    <link rel="stylesheet" type="text/css" href="../css/base.css" />     <link rel="stylesheet" type="text/css" href="../css/news/news.css" /> 
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script src="../js/news/page.js"></script>
    <script src="../lib/laydate.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
	<script src="../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
	
		<link rel="stylesheet" type="text/css" href="../css/news/new_news.css"/>		
		<script src="../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
		<script src="../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>

		
</head>
<body>
<div class="bx">
    <!--head开始-->
    <div class="head w clearfix">
        <ul class="index_head">
           <li data_id=""><span class="one headli1_1"><fmt:message
                    code="news.th.newsmanage"/></span><img class="headli1_2" src="../img/02.png" alt=""/>
            </li>
            
            <li data_id="0"><span class="headli2_1"><fmt:message
                    code="news.th.newbuild"/></span><img src="../img/02.png" alt="" class="headli2_2"/>
            </li>
                    
           <li data_id="1"><span class="headli3"><fmt:message code="news.title.query"/></span></li> 
           
        </ul>
    </div>
    <!--head通栏结束-->
    
    <!--navigation开始-->
    <div class="step1"> 
    <div class="navigation  clearfix">
        <div class="left">
            <!-- <img src="../img/01.png" style="width:28px;height:28px; margin-right:5px;"> -->
			 <img src="../img/la2.png"> 
           <!--  <div class="news">全部新闻</div> -->
           <div class="news">
                    <fmt:message code="news.title.new"/>
           </div>  
            <!-- <select name="TYPE" class="button1" style="float: left;" id="select"> -->
             <select name="TYPE" class="button1 nav_type" id="select">          
				<option value="0" selected="">所有类型</option>
				<option value="01">公司动态</option>
				<option value="02">媒体关注</option>
				<option value="03">行业资讯</option>
				<option value="04">合作伙伴新闻</option>
				<option value="05">客户新闻</option>
				<option value="">无类型</option>
			</select>
			<!-- 查询按钮 -->
			 <!-- <div id="cx" class="submit">查询</div>	 -->
			 <div id="cx" class="submit">
                    <fmt:message code="global.lang.query"/>
             </div>
        </div>


       <!--   <div class="right">
            分页按钮
            <div class="M-box3"></div>
        </div> -->
        
        
       	<div class="right">
                <!-- 分页按钮-->
                <div class="M-box3">
                </div>

            </div>
        

    </div>

    <!--navigation结束-->

    <!--content部分开始-->
    <div>
        <div>
            <table id="tr_td">
                <thead>
                	<tr>
                		<td class="th">选择</td>
                    	<td class="th">发布人</td>
                    	<td class="th">类型</td>
                    	<td class="th" style="position: relative">发布范围</td>
	                    <td class="th">标题</td>
	                    <td class="th">发布时间</td>
	                    <td class="th">点击数</td>
	                    <td class="th">评论（条）</td>
	                    <td class="th">状态</td>
	                    <td class="th">操作</td>
	                   
	                </tr>
                </thead>
                <tbody id="j_tb">
	                                                            
                </tbody>
                
            </table>
        </div>
    </div>
    
    <!--content部分结束-->
    </div>
    <!-- 新建新闻 -->
	<!-- <div class="step2"  style="width:100%;margin-top: 50px;display: none;"> -->
	<div class="step2" style="display: none;">
	<!-- 中间部分 -->
	 <table class="newNews">
        <div class="nav_box clearfix">
            <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
            <div class="nav_t2" class="news">全部新闻</div>

            <div class="nav_t3">选择格式</div>
            <div class="nav_t4"><img src="../img/mg1.png" alt=""/></div>
        </div>
        <tbody>
        <tr>
            <td class="td_w">
                <div class="text1 blue_text">请选择新闻类型</div>
                <img class="text2" src="../img/mg1.png" alt=""/>
            </td>
            <td>
                <div class="td_title1">请输入发布时间...</div>
                <img class="td_title2" src="../img/mg2.png" alt=""/>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                按照部门发布：
            </td>
            <td>
                <div class="td_title1  release1"></div>
                <img class="td_title2 release2" src="../img/mg2.png" alt=""/>

                <div class="release3">添加</div>
                <div class="release4 empty">清空</div>

            </td>

        </tr>
        <tr>
            <td class="blue_text">
                发布时间：
            </td>
            <td>
                <div class="td_title1">请输入新闻标题...</div>
                <img class="td_title2 release2" src="../img/mg2.png" alt=""/>

                <div class="release3">设置为当前时间</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                评论:
            </td>
            <td>
                <div class="comment1">实名评论</div>
                <img class="comment2" src="../img/mg1.png" alt=""/>

            </td>
        </tr>
        <tr>
            <td class="blue_text">
                提醒：
            </td>
            <td class="remind">
                <!--<div><input type="checkbox" checked/></div>-->
                <div><img src="../img/mg3.png" alt=""/></div>
                <div class="news_t">发送事物提醒消息</div>
                <!--<div><input type="checkbox" checked/></div>-->
                <div><img src="../img/mg4.png" alt=""/></div>
                <div>分享到企业社区</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                置顶：
            </td>
            <td class="top_box">
                <!--<div><input type="checkbox"/></div>-->
                <div><img src="../img/mg4.png" alt=""/></div>
                <div>使新闻置顶，显示为重要</div>
                <div class="t_box">0</div>
                <div>天后结束置顶（0表示一直置顶）</div>
            </td>


        </tr>
        <tr>
            <td class="blue_text">
                内容简介：
            </td>
            <td class="abstract">
                <div class="abstract1">请选择新闻类型</div>
                <div class="abstract2">(最多输入39个字)</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                附件上传：
            </td>
            <td class="enclosure">
                <div><img src="../img/mg11.png" alt=""/></div>
                <div class="enclosure_t">添加附件</div>
                <div><img src="../img/mg12.png" alt=""/></div>
                <div class="enclosure_t">从文件柜和网络硬盘选择附件</div>
                <div><img src="../img/mg13.png" alt=""/></div>
                <div class="enclosure_t">批量插入图片</div>
                <div><img src="../img/mg14.png" alt=""/></div>
                <div class="enclosure_t">批量上传过</div>

            </td>


        </tr>
        <!--word编辑器-->
        <tr>
            <td colspan="2">


            </td>
        </tr>
        <tr>
            <td class="blue_text">
                关键字：
            </td>
            <td class="keyword">
                <div class="keyword_ip">请输入关键字</div>
                <div class="keyword_t">自动获取关键字</div>
                <div>（您可以调整关键字内容，多个关键词请用" , "分割）</div>
        </tr>
        </tbody>
    </table>
</div>


</div>
<!--content部分结束-->
	
	
	
	
	
	
	<!-- <div class="login">
	        <div class="header">输入查询条件</div>
	        <div class="middle">
	            <div class="le publisher">
	                <div class="color"style="width:105px;">发布人：</div>
	                <div><input style="height:50px;width:279px;margin-left:0px;margin-right: 15px;" type="text" /></div>
	                <div style="margin-right:23px; color:#207BD6">添加</div>
	                <div>清空</div>
	            </div>
	            <div class="le subject">
	                <div class="color"style="width:105px;">标题：</div>
	                <div><input id="subject" style="height:26px;width:279px;margin-left:0px;margin-right: 15px;" type="text"/></div>
	            </div>
				<div class="le date">
	                <div class="color"style="width:105px;">发布日期：</div>
	                <div><input id="beginTime" style="height:24px;width:119px;margin-left:0px;margin-right: 11px;" type="text"/></div>
	                <div class="color">至</div>
	                <div> <input id="endTime" style="height:24px;width:119px;margin-left:11px;" type="text"/></div>
	            </div>
	           	<div class="le ce1">
	                <div class="color"style="width:105px;">类型：</div>
	                <div>            
		                <select name="TYPE" style="height:24px;width:119px;margin-left:0px;" class="button1" style="float: left;" id="select">
							<option value="0" selected="">所有类型</option>
							<option value="01">公司动态</option>
							<option value="02">媒体关注</option>
							<option value="03">行业资讯</option>
							<option value="04">合作伙伴新闻</option>
							<option value="05">客户新闻</option>
							<option value="">无类型</option>
						</select>
					</div>
	
	            </div>
	            <div class="le ce2">
	                <div class="color">内容:</div>
	                <div><input id="content"  style="height:25px;width:279px;margin-left:80px;" type="text"/></div>
	
	            </div>
	        </div>
	        <div class="icons">
	            <img id="btn_query" style="margin-right:30px; cursor: pointer;" src="../img/3query.png" alt=""/>
	            <img style="margin-right:30px; cursor: pointer;"  src="../img/4query.png" alt=""/>
	            <img style=" cursor: pointer;" src="../img/5query.png" alt=""/>
	        </div>
	    </div> -->
	</div>
    
   <!--  <div class="center" style="width:100%;margin-top: 50px;display: none;"> -->
   <!-- <div class="center" id="qt">
    	 <div class="login">
	        <div class="header">输入查询条件</div>
	        <div class="middle">
	            <div class="le publisher">
	                <div class="color"style="width:105px;">发布人：</div>
	                <div><input style="height:50px;width:279px;margin-left:0px;margin-right: 15px;" type="text" /></div>
	                <div style="margin-right:23px; color:#207BD6">添加</div>
	                <div>清空</div>
	            </div>
	            <div class="le subject">
	                <div class="color"style="width:105px;">标题：</div>
	                <div><input id="subject" style="height:26px;width:279px;margin-left:0px;margin-right: 15px;" type="text"/></div>
	            </div>
				<div class="le date">
	                <div class="color"style="width:105px;">发布日期：</div>
	                <div><input id="beginTime" style="height:24px;width:119px;margin-left:0px;margin-right: 11px;" type="text"/></div>
	                <div class="color">至</div>
	                <div> <input id="endTime" style="height:24px;width:119px;margin-left:11px;" type="text"/></div>
	            </div>
	           	<div class="le ce1">
	                <div class="color"style="width:105px;">类型：</div>
	                <div>            
		                <select name="TYPE" style="height:24px;width:119px;margin-left:0px;" class="button1" style="float: left;" id="select">
							<option value="0" selected="">所有类型</option>
							<option value="01">公司动态</option>
							<option value="02">媒体关注</option>
							<option value="03">行业资讯</option>
							<option value="04">合作伙伴新闻</option>
							<option value="05">客户新闻</option>
							<option value="">无类型</option>
						</select>
					</div>
	
	            </div>
	            <div class="le ce2">
	                <div class="color">内容:</div>
	                <div><input id="content"  style="height:25px;width:279px;margin-left:80px;" type="text"/></div>
	
	            </div>
	        </div>
	        <div class="icons">
	            <img id="btn_query" style="margin-right:30px; cursor: pointer;" src="../img/3query.png" alt=""/>
	            <img style="margin-right:30px; cursor: pointer;"  src="../img/4query.png" alt=""/>
	            <img style=" cursor: pointer;" src="../img/5query.png" alt=""/>
	        </div>
	    </div>
    </div> -->
    
    <!-- 新闻查询 -->
    <div class="center" id="qt">
    <div class="login">
        <div class="header">
            <fmt:message code="global.lang.inputquerycondition"/>
        </div>
        <div class="middle">
            <div class="le publisher">
                <div class="color" style="width:105px;">
                    <fmt:message code="notice.th.publisher"/> ：
                </div>
                <input id="input_text1" type="text"/>
                <div style="margin-right:23px; color:#207BD6">
                    <fmt:message code="global.lang.add"/>
                </div>
                <div>
                    <fmt:message code="global.lang.empty"/>
                </div>
            </div>
            <div class="le subject">
                <div class="color" style="width:105px;">
                    <fmt:message code="notice.th.title"/> ：</div>
                <input id="subject_query " class="input_text2" type="text"/>
            </div>
            <div class="le date">
                <div class="color" style="width:105px;"><fmt:message code="notice.title.Releasedate"/> ：</div>  
                <input id="beginTime "class="input_text3" type="text"/>
                <div class="color">
                    <fmt:message code="global.lang.to"/>
                </div>
                
               <div><input id="endTime" class="input_text4" type="text"/></div> 
            </div>
            <div class="le ce1">
                <div class="color" style="width:105px;"><fmt:message code="news.title.new"/> ：</div>
            <div> 
                 <!-- <select name="TYPE"  class="button1 input_text5" id="select_query"> --> 
                   <select name="TYPE"  class="button1 input_text5" id="select"> 
                 
                        <option value="0" selected="">
                            <fmt:message code="news.th.type"/>
                        </option>
                        <option value="01">
                            <fmt:message code="news.th.company"/>
                        </option>
                        <option value="02">
                            <fmt:message code="news.th.media"/>
                        </option>
                        <option value="03">
                            <fmt:message code="news.th.industry"/>
                        </option>
                        <option value="04">
                            <fmt:message code="news.th.partner"/>
                        </option>
                        <option value="05">
                            <fmt:message code="news.th.client"/>
                        </option>
                        <option value="">
                            <fmt:message code="news.th.none"/>
                        </option>
                    </select>
                </div>

            </div>
            <div class="le ce2">
                <div class="color" style="width:105px;"><fmt:message code="notice.th.content"/>:</div>          
              	<input id="content" class="input_text6" type="text"/>
            </div>
        </div>
        <div class="icons">
            <img id="btn_query" style="margin-right:30px; cursor: pointer;" src="../img/3query.png" alt=""/>
            <img style="margin-right:30px; cursor: pointer;" src="../img/4query.png" alt=""/>
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
					$('.step2').hide();
					$('.center').hide();
					initPageList();
				}else if(data.read == 1){
					$('.step1').hide();
					$('.step2').hide();
					$('.center').show('');
					$('#subject').val('');
					$('#beginTime').val('');
					$('#endTime').val('');
					$('#select').val()==0?'':$('#select').val();
					$('#content').val('');
				}else  if( data.read == 0){
					$('.step1').hide();
					$('.step2').show();
					$('.center').hide();
				
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
