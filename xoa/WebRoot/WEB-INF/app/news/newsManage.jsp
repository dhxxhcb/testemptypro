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
    <link rel="stylesheet" type="text/css" href="../css/news/new_news.css"/> 
    <!-- 新闻管理  --> 
    <link rel="stylesheet" type="text/css" href="../css/news/management_query.css" />          
    <script type="text/javascript" src="../js/news/jquery-1.9.1.js"></script>
    <script src="../js/news/page.js"></script>
    <script src="../lib/laydate.js"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
	<script src="../lib/pagination/js/jquery.pagination.min.js" type="text/javascript" charset="utf-8"></script>
	<!-- word文本编辑器 -->	
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
	<div class="step2" style="display: none;margin-left: 10px;">
	<!-- 中间部分 -->
	 <table class="newNews">
        <div class="nav_box clearfix">
            <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
            <div class="nav_t2" class="news">全部新闻</div>

            <!-- <div class="nav_t3">选择格式 -->
             <div class="nav_t3" > 
            	<select name="" class="sel">
                    <option value="" selected="">选择格式</option>
                    <option value="">1</option>
                    <option value="">2 </option>
                    <option value="">2 </option>
                    
                </select>
            
            </div>                
          <!--   <div class="nav_t4"><img src="../img/mg1.png" alt=""/></div> -->
        </div>
        <tbody>
        <tr>
            <td class="td_w">
                <!-- <div class="text1 blue_text">请选择新闻类型</div>
                <img class="text2" src="../img/mg1.png" alt=""/> -->
                <select name="" class="">
                    <option value="" selected="">请选择新闻类型</option>
                    <option value="">1</option>
                    <option value="">2 </option>
                    <option value="">2 </option>
                    
                </select>
            </td>
            <td>
                <input class="td_title1" id="ip1" type="text" value="请输入新闻标题..."/>
                <img class="td_title2" src="../img/mg2.png" alt=""/>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                按照部门发布：
            </td>
            <td>
                <input class="td_title1  release1" id="" type="text"/>
                <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>

                <div class="release3">添加</div>
                <div class="release4 empty">清空</div>

            </td>

        </tr>
        <tr>
            <td class="blue_text">
                发布时间：
            </td>
            <td>
                <input class="td_title1" id="ip3" type="text" value="请输入发布时间..."/>
                <a href="javascript:;" id="step_release2"><div class="release3">设置为当前时间</div></a>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                评论:
            </td>
            <td>            
                <select name="" class="">
                    <option value="" selected="">实名评论</option>
                    <option value="">1</option>
                    <option value="">2 </option>
                    <option value="">2 </option>
                    
                </select>
                
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                提醒：
            </td>
            <td class="remind">
                <div><input class="news_t1"  type="checkbox" checked/></div>
               <!--  <div><img src="../img/mg3.png" alt=""/></div> -->
                <div class="news_t">发送事物提醒消息</div>
                <div><input class="news_t1" type="checkbox" checked/></div>
                <!-- <div><img src="../img/mg4.png" alt=""/></div> -->
                <div class="news_t2">分享到企业社区</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                置顶：
            </td>
            <td class="top_box">
                <div><input class="news_t1" type="checkbox"/></div>
                <!-- <div><input type="checkbox" style="height:14px;width:14px;margin-top: 4px;"/></div> -->
                <!-- <div><img src="../img/mg4.png" alt=""/></div> -->
                <div class="news_t3">使新闻置顶，显示为重要</div>
                <input class="t_box" type="text" value="0"/>
                <div class="news_t4">天后结束置顶（0表示一直置顶）</div>
            </td>


        </tr>
        <tr>
            <td class="blue_text">
                内容简介：
            </td>
            <td class="abstract">
                <input class="abstract1" id="ip4" type="text"  maxlength="39" value="请输入内容..."/>
                <div class="abstract2">(最多输入39个字)</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                附件上传：
            </td>
            <td class="enclosure">
                <div><img src="../img/mg11.png" alt=""/></div>
                <div class="enclosure_t"><a href="#">添加附件</a></div>
                <div><img src="../img/mg12.png" alt=""/></div>
                <div class="enclosure_t"><a href="#">从文件柜和网络硬盘选择附件</a></div>
                <div><img src="../img/mg13.png" alt=""/></div>
                <div class="enclosure_t"><a href="#">批量插入图片</a></div>
                <div><img src="../img/mg14.png" alt=""/></div>
                <div class="enclosure_t"><a href="#">批量上传过</a></div>

            </td>


        </tr>
        <!--word编辑器-->
         <tr>
            <td colspan="2">
            
				<script id="container" name="content" type="text/plain" style="width: 100%;min-height: 200px;"></script>
				

            </td>
        </tr> 
        <tr>
            <td class="blue_text">
                关键字：
            </td>
            <td class="keyword">
                <input class="keyword_ip" id="ip5" type="text" value="请输入关键词..."/>
                <div class="keyword_t">自动获取关键字</div>
                <div class="keyword_t2">（您可以调整关键字内容，多个关键词请用" , "分割）</div>
        </tr>
        </tbody>
        
    </table>
    <div class="foot_mg">
        <img  id="hd" class="fot_1" src="../img/mg5.png" alt=""/> <!-- 发布 -->
        <img  id="rs"  src="../img/mg6.png" alt=""/> <!-- 保存 -->
    </div>
</div>
<!--新建新闻页面的修改页面  -->
<div class="step3" style="display: none;margin-left: 10px;">
	<!-- 中间部分 -->
	 <table class="newNews">
        <div class="nav_box clearfix">
            <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
            <div class="nav_t2" class="news">全部新闻</div>

            <!-- <div class="nav_t3">选择格式 -->
             <div class="nav_t3" > 
            	<select name="" class="sel">
                    <option value="" selected="">选择格式</option>
                    <option value="">1</option>
                    <option value="">2 </option>
                    <option value="">2 </option>
                    
                </select>
            
            </div>                
          <!--   <div class="nav_t4"><img src="../img/mg1.png" alt=""/></div> -->
        </div>
        <tbody>
        <tr>
            <td class="td_w">
                <!-- <div class="text1 blue_text">请选择新闻类型</div>
                <img class="text2" src="../img/mg1.png" alt=""/> -->
                <select name="" id="step3_type" class="">
                    <option value="" selected="">请选择新闻类型</option>
                    <option value="">1</option>
                    <option value="">2 </option>
                    <option value="">2 </option>
                    
                </select>
            </td>
            <td>
                <input class="td_title1" id="step3_ip1" type="text" value="请输入新闻标题..."/>
                <img class="td_title2" src="../img/mg2.png" alt=""/>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                按照部门发布：
            </td>
            <td>
                <input class="td_title1  release1" type="text"id="step3_ip2"/>
                <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>

                <div class="release3">添加</div>
                <div class="release4 empty">清空</div>

            </td>

        </tr>
        <tr>
            <td class="blue_text">
                发布时间：
            </td>
            <td>
                <input class="td_title1" id="step3_ip3" type="text" value="请输入发布时间..."/>
                <a href="javascript:;" id="step_release3"><div class="release3" >设置为当前时间</div></a>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                评论:
            </td>
            <td>            
                <select name="" class="">
                    <option value="" selected="">实名评论</option>
                    <option value="">1</option>
                    <option value="">2 </option>
                    <option value="">2 </option>
                    
                </select>
                
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                提醒：
            </td>
            <td class="remind">
                <div><input class="news_t1"  type="checkbox" checked/></div>
               <!--  <div><img src="../img/mg3.png" alt=""/></div> -->
                <div class="news_t">发送事物提醒消息</div>
                <div><input class="news_t1" type="checkbox" checked/></div>
                <!-- <div><img src="../img/mg4.png" alt=""/></div> -->
                <div class="news_t2">分享到企业社区</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                置顶：
            </td>
            <td class="top_box">
                <div><input class="news_t1" type="checkbox"/></div>
                <!-- <div><input type="checkbox" style="height:14px;width:14px;margin-top: 4px;"/></div> -->
                <!-- <div><img src="../img/mg4.png" alt=""/></div> -->
                <div class="news_t3">使新闻置顶，显示为重要</div>
                <input class="t_box" id="step3_ip6" type="text" value="0"/>
                <div class="news_t4">天后结束置顶（0表示一直置顶）</div>
            </td>


        </tr>
        <tr>
            <td class="blue_text">
                内容简介：
            </td>
            <td class="abstract">
                <input class="abstract1" id="step3_ip4" type="text"  maxlength="39" value="请输入内容..."/>
                <div class="abstract2">(最多输入39个字)</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                附件上传：
            </td>
            <td class="enclosure">
                <div><img src="../img/mg11.png" alt=""/></div>
                <div class="enclosure_t"><a href="#">添加附件</a></div>
                <div><img src="../img/mg12.png" alt=""/></div>
                <div class="enclosure_t"><a href="#">从文件柜和网络硬盘选择附件</a></div>
                <div><img src="../img/mg13.png" alt=""/></div>
                <div class="enclosure_t"><a href="#">批量插入图片</a></div>
                <div><img src="../img/mg14.png" alt=""/></div>
                <div class="enclosure_t"><a href="#">批量上传过</a></div>

            </td>


        </tr>
        <!--word编辑器-->
        <tr>
            <td colspan="2">
				<script id="container3" name="content" type="text/plain" style="width: 100%;min-height: 200px;"></script>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                关键字：
            </td>
            <td class="keyword">
                <input class="keyword_ip step3_5"" id="ip5" type="text" value="请输入关键词..."/>
                <div class="keyword_t">自动获取关键字</div>
                <div class="keyword_t2">（您可以调整关键字内容，多个关键词请用" , "分割）</div>
        </tr>
        </tbody>
        
    </table>
    <div class="foot_mg">
        <img  id="hd" class="fot_1" src="../img/mg5.png" alt=""/> <!-- 发布 -->
        <img  id="step3_rs"  src="../img/mg6.png" alt=""/> <!-- 保存 -->
    </div>
</div>


</div>
<!--content部分结束-->
	 
 <!-- 新闻查询 -->
    <div class="center" id="qt">   	
   <!--content部分开始-->
    <table class="clearfix total">
        <tbody>
        <tr>
            <td colspan="2" class="query_title">
                输入查询条件
            </td>
        </tr>
        <tr>
            <td class="td_w">
                格式：
            </td>
            <td>
                <select name="" class="se_1">
                    <option value="" selected="">全部</option>
                    <option value="">1</option>
                    <option value="">2 </option>
                    <option value="">2 </option>

                </select>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
               类型：
            </td>
            <td>
                <select name="" class="se_2">
                    <option value="" selected="">全部</option>
                    <option value="">1</option>
                    <option value="">2 </option>
                    <option value="">2 </option>

                </select>

            </td>

        </tr>
        <tr>
            <td class="blue_text">
               状态：
            </td>
            <td>
                <select name="" class="se_3">
                    <option value="" selected="">全部</option>
                    <option value="">1</option>
                    <option value="">2 </option>
                    <option value="">2 </option>

                </select>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                是否置顶:
            </td>
            <td>
                <select name="" class="se_4">
                    <option value="" selected="">全部</option>
                    <option value="">1</option>
                    <option value="">2 </option>
                    <option value="">2 </option>

                </select>

            </td>
        </tr>
        <tr>
            <td>标题:</td>
            <td>
                <input class="title_" type="text"/>
            </td>
        </tr>
        <tr class="release">
            <td>发布日期</td>
            <td>
                <!-- <div class="date"></div> -->
                <input id="beginTime "class="date" type="text"/>
                <div  class="c_t">至</div>
               <!--  <div class="date"></div> -->
               <input id="endTime" class="date" type="text"/>

            </td>
        </tr>
        <tr>
            <td>内容</td>
            <td>
                <!-- <div class="content_"></div> -->
                <input class="content_" type="text"/>
            </td>
        </tr>
        <tr class="clack_t">
            <td>点击次数</td>
            <td>
                <input class="c_time" type="text"/>
                <div class="c_t">至</div>
                <input class="c_time" type="text"/>
            </td>
        </tr>
        <tr class="operation">
            <td>操作</td>
            <td>
            	<div><input type="radio" name="radio"></div>
            	<div class="operation1">查询</div>
            	<div><input type="radio" name="radio"></div>
            	<div class="operation1">删除</div>
               <!--  <input type="radio" name="radio"></input>
                <input type="radio" name="radio">删除</input> -->
            </td>
        </tr>
        <tr class="table_b">
            <td colspan="2">
                    <div class="bt">确定</div>
                    <div>重填</div>
              
            </td>
        </tr>

        </tbody>
    </table>
</div>
<!--content部分结束-->
    	
<script>
$(function () {
			/* word文本编辑器 */
			 var ue = UE.getEditor('container');//新建新闻页面
			 var ue = UE.getEditor('container3');//修改新闻页面
		 
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
					$('.step3').hide();
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
                                       
                                        news = "<tr class='trs' rid='"+data.obj[i].newsId+"'><input class='input_hide' type='hidden' newsID='"+data.obj[i].newsId+"'><td><input  id='input1' name='' type='checkbox' value=''/></td>"+//选择
                               		   "<td class='name' nid='"+data.obj[i].newsId+"'>"+data.obj[i].providerName+"</td>"+//发布人
                                       "<td class='type' nid='"+data.obj[i].newsId+"'>"+data.obj[i].typeName+"</td>"+//类型
                                       "<td class='cli' name='"+data.obj[i].depName+"'><div id='break"+data.obj[i].newsId+"' class='break_td' title="+data.obj[i].depName+">"+'点击详情'+"</div></td>"+//发布范围
                                       "<td time='"+data.obj[i].subject+"'><a href='' newsId="+data.obj[i].newsId+" class='windowOpen'><div id='subject"+data.obj[i].newsId+"'>"+data.obj[i].subject+"</div></a></td>"+//标题
                                       "<td  class='tim'>"+data.obj[i].newsDateTime+"</td>"+//发布时间
                                       "<td class='data'>"+data.obj[i].clickCount+"</td>"+//点击数
                                       "<td class='num'>"+data.obj[i].newsId+"</td>"+//评论（条）
                                       "<td class='state'>生效</td>"+//状态
                                        "<td>"+
                                       		/*  "<a onclick='updateData("+data.obj[i].newsId+")'>"+"修改"+"</a>&nbsp"+ */
                                       	 	"<a  href='javascript:;' id='xg' tid='"+data.obj[i].newsId+"'>"+"修改"+"</a>&nbsp"+ 
											 "<a  href='javascript:;'>"+"管理评论"+"</a>&nbsp"+
											 "<a  href='javascript:;'>"+"终止"+"</a>&nbsp"+
											 /*"<a href='javascript:;' onclick='deleteData("+data.obj[i].newsId+"))'>"+"删除"+"</a>&nbsp"+ */
										 	 "<a href='javascript:;' id='deleteData'>"+"删除"+"</a>&nbsp"+ 
                                       "</td>"+//操作 
                                      /*  "<td>"+"修改  管理评论  终止  删除</td>"+//操作 */
                                     /*  "<td style='overflow: hidden;'>"+data.obj[i].newsId+"</td>"+ */
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
            	/* console.log(totalData+'---'+pageSize); */
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
							    /* 	console.log(index.getCurrent()); */
							    	initPageList();
							    }
							});
            }
            /* 新闻详情页 */
               $("#j_tb").on('click','.windowOpen',function(){
		            var nid=$(this).attr('newsId');
		            $.popWindow('detail?newsId='+nid);
		        });		        
		    /*删除时 调用的方法*/
			 $("#j_tb").on('click','#deleteData',function(){
			 		var attR=$(this).parents('tr').find('input.input_hide').attr('newsID');
			 		
		          	 alert(attR);
		           
			       var data = {
		           		"newsId":attR
		           	};
		           	$.ajax({
		           		data:data,
		           		type:"GET",
		           		dataType:"JSON",
		           		url:"<%=basePath%>news/deleteNews",
		           		success:function(){
		           			location.reload();
		           			//alert(data);
		           		}	           		
		           	});	           
		        });
		        
		        /* 新闻管理修改页面 */
		         $("#j_tb").on('click', '#xg', function(){  
		         	var id=$(this).attr('tid');
		         	alert(id);
		       		alert($(this).parent().parent().attr('rid')); 
		         	 if(id==$(this).parent().parent().attr('rid')){	
						 /* $("select:[id='step3_type'] option"). each( function () {
		                  	 if($(this).text()==$(this).parent().siblings('.type').text())
								{
								    $(this).attr("selected","selected"); 
								             
								}                 
                		});  */
						$("#step3_ip2").val($(this).parent().siblings('.name').text()); //发布人
						alert($(this).parent().siblings('.name').text()); //发布人
						//$(this).parent().siblings('.type').text(); //类型
						alert( $(this).parent().siblings('.cli').find('.break_td').text());//发布范围 
						alert( $(this).parent().siblings().find('.windowOpen div').text());//标题
						 $("#step3_ip1").val($(this).parent().siblings().find('.windowOpen div').text());//标题
						//alert($('#subject"+newID+"').text());
						//$("#step3_ip3").val($(this).parent().siblings('.tim').text());//发布时间
						alert($(this).parent().siblings('.data').text());//点击数
						alert($(this).parent().siblings('.num').text());//评论(条)
						alert($(this).parent().siblings('.state').text());//状态  
						
						 $('.step1').hide();
			          	 $('.center').hide();
						 $('.step2').hide();
						 $('.step3').show();
					 } 

		        });	
		        
		        //修改页面保存时调用的方法
		        $("#step3_rs").click(function(){
		        alert(111);
		         
					  var data = {
					  
					  "newsId":id,
					 	
					  
		           		/* "newsId":id,
		           		"providerName":$(this).parent().siblings('.name').text(),//发布人
		           		"typeName":$("#step3_ip4").val(),//发布范围
		           		"depName":$('#break"+newID+"').text(),//标题
		           		"subject":$('#subject"+newID+"').text(),//时间
		           		"tim":$(this).parent().siblings('.tim').text(),//点击数
		           		"data":$(this).parent().siblings('.data').text()//评论（条） */
		           
		           		
									           		
						 "subject": $("#step3_ip1").val(),    //标题 
							"newTime": $("#step3_ip3").val(),        //发布时间 
							"anonymityYn": 0 ,//评论类型(0-实名评论,1-匿名评论,2-禁止评论)
							 "format":  0 ,//新闻格式(0-普通格式,1-MHT格式,2-超链接)
							"typeId" :1,  //新闻类型
							"Publish":0,   //发布标识(0-未发布,1-已发布,2-已终止)
							"Top":0,   //是否置顶(0-否,1-是)
							"Keyword":$(".step3_5").val(),  //内容关键词
							"topDays": $("#step3_ip6").vla(),// 限制新闻置顶时间
							"Content":  00  ,//  新闻内容
							"attachmentId": 00,// 附件ID串
							"attachmentName": 00 ,//附件名称串
							"toId":  $("#step3_ip2").val(),//发布部门
							"privId": 0, //发布角色
							"userId":0,  //发布人员 */
		           		
			           	};
			           	$.ajax({
			           		data:data,
			           		type:"GET",
			           		dataType:"JSON",
			           		url:"<%=basePath%>news/updateNews",
			           		success:function(){
			           			location.reload();
			           			//alert(data);
			           			 initPageList();			           			
								 $('.step1').show();
					          	 $('.center').hide();
								 $('.step2').hide();
								 $('.step3').hide();
			           		},
				         	error:function(){
		            			alert("请求数据出错");
		            			return;
            		}   		
                       		
			           	});	
		        
		        });
		        
		        
		        
		        
				var now = null;
		        
		        function queryTime(){
			         function p(s) {
					    return s < 10 ? '0' + s: s;
					}
					
					var myDate = new Date();
					//获取当前年
					var year=myDate.getFullYear();
					//获取当前月
					var month=myDate.getMonth()+1;
					//获取当前日
					var date=myDate.getDate(); 
					var h=myDate.getHours();       //获取当前小时数(0-23)
					var m=myDate.getMinutes();     //获取当前分钟数(0-59)
					var s=myDate.getSeconds();  
					
					now=year+'-'+p(month)+"-"+p(date)+" "+p(h)+':'+p(m)+":"+p(s);
		        }
		        
		        //获取当前时间 修改时页面
		        $("#step_release3").click(function(){
		          queryTime();
		      	  $("#step3_ip3").val(now);
		        });
		        
		         //获取当前时间 新建时页面
		        $("#step_release2").click(function(){
		          queryTime();
		      	  $("#ip3").val(now);
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
   /* 保存数据 */
    $("#rs").on("click",function(){
         var data ={
                     subject:$("#ip1").val(), //新闻标题
	                 toId:$("#ip2").val(),	//发布部门
	                 newsDateTime:$("#ip3").val(),	//时间
	                 deprange:$("#ip4").val(),	//内容
	                 message:$("#ip5").val()	//关键字
                    };
                   /*  console.log(data); */
			alert(111);
                $.ajax({
                    url:"<%=basePath%>news/sendNews",
                    type:'get',
    
	       		data : data,
                   
                   success:function(json){
                        console.log(json+"111");
	           			$('.step1').show();
						$('.step2').hide();
						$('.center').hide();
	           		},	  
	           		error:function(){
	            		alert("请求数据出错");
	            		return;
            		}   		
                   
                });
                alert(222);
        });
        
        
        
   
  
</script>
</body>



</html>
