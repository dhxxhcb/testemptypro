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
			<img src="../img/la2.png">           
           <div class="news">
                    <fmt:message code="news.title.new"/>
           </div>            
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
	<div class="step2" style="display: none;margin-left: 10px;">
	<!-- 中间部分 -->
	 <table class="newNews">
        <div class="nav_box clearfix">
            <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
            <div class="nav_t2" class="news">新建新闻</div>
             <div class="nav_t3" > 
            	<select name="" class="sel format" id="query_format">
                    <option value="" selected="">全部</option>
			        <option value="0">普通格式</option>
			        <option value="1">MHT格式</option>
			        <option value="2">超链接格式</option>                    
                </select>            
            </div>                
        </div>
        <tbody>
        <tr>
            <td class="td_w">
                <!-- <div class="text1 blue_text">请选择新闻类型</div>
                <img class="text2" src="../img/mg1.png" alt=""/> -->
                <select name="" class="typeId" id="query_typeId">
                    <option value="">&nbsp;选择新闻类型</option>
		          	<option value="01">公司动态</option>
					<option value="02">媒体关注</option>
					<option value="03">行业资讯</option>
					<option value="04">合作伙伴新闻</option>
					<option value="05">客户新闻</option>                    
                </select>
            </td>
            <td>
                <input class="td_title1" id="query_subject" type="text"  placeholder="请输入新闻标题..."/>
                <img class="td_title2" src="../img/mg2.png" alt=""/>
            </td>
        </tr>
        <tr>
            <td class="blue_text">  按照部门发布：</td>
            <td>
                <input class="td_title1  release1"  id="query_toId" type="text"/>
                <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>
               <!--  <div class="release3">添加</div>
                <div class="release4 empty">清空</div> -->
                <div class="release3" style="color:#dfdfdf">添加</div>
                <div class="release4 empty" style="color:#dfdfdf">清空</div> 
            </td>
        </tr>
        <tr>
            <td class="blue_text">  按照角色发布：</td>
            <td>
                <input class="td_title1  release1" id="query_privId" type="text"/>
                <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>
                <div class="release3" style="color:#dfdfdf">添加</div>
                <div class="release4 empty" style="color:#dfdfdf">清空</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">  按照人员发布：</td>
            <td>
                <input class="td_title1  release1" id="query_userId" dataid="" type="text"/>
                <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>
                <div class="release3" id="query_adduser">添加</div>
                <div class="release4 empty" style="color:#dfdfdf;">清空</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
           		  发布时间：
            </td>
            <td>
                <input class="td_title1 time_coumon" id="query_newTime" type="text" placeholder="请输入发布时间..."/>
                <a href="javascript:;" id="step_release2"><div class="release3">设置为当前时间</div></a>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
           		 评论:
            </td>
            <td>            
                <select name="" class="anonymityYn" id="query_anonymityYn">
                    <option value="0">实名评论</option>
          			<option value="1">匿名评论</option>
          			<option value="2">禁止评论</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
              	  提醒：
            </td>
            <td class="remind">
                <div><input class="news_t1"  type="checkbox" checked/></div>
             
                <div class="news_t">发送事物提醒消息</div>
                <div><input class="news_t1" type="checkbox" checked/></div>
               
                <div class="news_t2">分享到企业社区</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
               	 置顶：
            </td>
            <td class="top_box">
                <div><input class="news_t1 " id="query_top" type="checkbox"/></div>
                <!-- <div><input type="checkbox" style="height:14px;width:14px;margin-top: 4px;"/></div> -->
                <!-- <div><img src="../img/mg4.png" alt=""/></div> -->
                <div class="news_t3">使新闻置顶，显示为重要</div>
                <input class="t_box" id="add_topDate" type="text" value="0"/>
                <div class="news_t4">天后结束置顶（0表示一直置顶）</div>
            </td>		
        </tr>
        <tr>
            <td class="blue_text">
              	  内容简介：
            </td>
            <td class="abstract">
                <input class="abstract1" id="ip4" type="text"  maxlength="39" placeholder="请输入内容..."/>
                <div class="abstract2">(最多输入30个字)</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
               	 附件上传：
            </td>
            <td class="enclosure">
            	<div id="query_uploadArr">

            	</div><br>
                <div><img src="../img/mg11.png" alt=""/></div>
               <!--  <div class="enclosure_t"><a href="#">添加附件</a></div> -->
                <div>
	                <form id="uploadimgform" target="uploadiframe"  action="../upload?module=news" enctype="multipart/form-data" method="post" >
						<input type="file" name="file" id="uploadinputimg"  class="w-icon5" style="display:none;">
						<a id="uploadimg" style="cursor: pointer;">添加附件</a>
					</form>
				</div>
                <div><img class="left_img" src="../img/mg12.png" alt=""/></div>
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
				<script class="content" id="container" name="content" type="text/plain" style="width: 100%;min-height: 200px;"></script>			
            </td>
        </tr> 
        <tr>
            <td class="blue_text">
               	 关键字：
            </td>
            <td class="keyword">
                <input class="keyword_ip" id="query_keyword" type="text" placeholder="请输入关键词..."/>
                <div class="keyword_t">自动获取关键字</div>
                <div class="keyword_t2">（您可以调整关键字内容，多个关键词请用" , "分割）</div>
        </tr>
        </tbody>        
    </table>
    <div class="foot_mg">
       <!--<img  id="hd" type="publish" class="fot_1 btn_ok" src="../img/mg5.png" alt=""/> 
        <img  id="rs" type="save" class="btn_ok"  src="../img/mg6.png" alt=""/>  -->
        <div class="btn_">
	        <div  id="hd" type="publish" class="fot_1 btn_ok">发布</div>
			<div  id="rs" type="save" class="btn_style btn_ok">保存</div>
        </div>
    </div>
</div>

<!--新建新闻页面的修改页面  -->
<div class="step3" style="display:none ;margin-left: 10px;">
	<!-- 中间部分 -->
	 <table class="newNews">
        <div class="nav_box clearfix">
            <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
            <div class="nav_t2" class="news">全部新闻</div>           
             <div class="nav_t3" > 
            	<select name="" class="sel" id="format_">
                    <option value="" selected="">全部</option>
			        <option value="0">普通格式</option>
			        <option value="1">MHT格式</option>
			        <option value="2">超链接格式</option>        
                </select>            
            </div>                        
        </div>
        <tbody>
        <tr>
            <td class="td_w">
                <!-- <div class="text1 blue_text">请选择新闻类型</div>
                <img class="text2" src="../img/mg1.png" alt=""/> -->
                <select name="" id="step3_type" class="">
					<option value="">&nbsp;选择新闻类型</option>
					<option value="01">公司动态</option>
					<option value="02">媒体关注</option>
					<option value="03">行业资讯</option>
					<option value="04">合作伙伴新闻</option>
					<option value="05">客户新闻</option>                    
                </select>
            </td>
            <td>
                <input class="td_title1 subject" id="step3_ip1" type="text" placeholder="请输入新闻标题..."/>
                <img class="td_title2" src="../img/mg2.png" alt=""/>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                	按照部门发布：
            </td>
            <td>
                <input class="td_title1  release1 toId" type="text"id="step3_ip2"/>
                <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>
                <div class="release3">添加</div>
                <div class="release4 empty">清空</div>
                 
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                	按照角色发布：
            </td>
            <td>
                <input class="td_title1  release1 toId" type="text"id="privId_"/>
                <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>
                <div class="release3">添加</div>
                <div class="release4 empty">清空</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                	按照人员发布：
            </td>
            <td>
                <input class="td_title1  release1 toId" type="text"id="userId_"/>
                <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>
                <div class="release3" id="adduser_" style="cursor: pointer;">添加</div>
                <div class="release4 empty">清空</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                	发布时间：
            </td>
            <td>
                <input class="td_title1 newTime" id="step3_ip3"  class="step3_te" type="text" placeholder="请输入发布时间..."/>
                <a href="javascript:;" id="step_release3"><div class="release3" >设置为当前时间</div></a>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                	评论:
            </td>
            <td>            
                <select name="step3_anonymityYn" class="" id="anonymityYn_">
                    <option value="0">实名评论</option>
			        <option value="1">匿名评论</option>
			        <option value="2">禁止评论</option>                    
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
                <div><input class="news_t1" id="top_" type="checkbox"/></div>             
                <div class="news_t3">使新闻置顶，显示为重要</div>
                <input class="t_box topDays" id="topDays" type="text" placeholder="0"/>
                <div class="news_t4">天后结束置顶（0表示一直置顶）</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
              	  内容简介：
            </td>
            <td class="abstract">
                <input class="abstract1 Content" id="step3_ip4" type="text"  maxlength="39" placeholder="请输入内容..."/>
                <div class="abstract2">(最多输入39个字)</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
             	   附件上传：
            </td>
            <td class="enclosure">
            	<div id="query_uploadArr_">
            	</div><br>
                <div><img src="../img/mg11.png" alt=""/></div>
               <!--  <div class="enclosure_t"><a href="#">添加附件</a></div> -->
                <div style="cursor: pointer;">
	                <form  id="uploadimgform_" target="uploadiframe"  action="../upload?module=news" enctype="multipart/form-data" method="post" >
						<input type="file" name="file" id="uploadinputimg_"  class="w-icon5" style="display:none;">
						<a id="uploadimg_">添加附件</a>
					</form>
				</div>
            	
                <!-- <div><img src="../img/mg11.png" alt=""/></div>
                <div class="enclosure_t"><a href="#">添加附件</a></div> -->
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
				<script id="container3" name="content" type="text/plain" style="width: 100%;min-height: 200px;">


				</script>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                关键字：
            </td>
            <td class="keyword">
                <input class="keyword_ip step3_5 Keyword" id="ip5" type="text" placeholder="请输入关键词..."/>
                <div class="keyword_t">自动获取关键字</div>
                <div class="keyword_t2">（您可以调整关键字内容，多个关键词请用" , "分割）</div>
        </tr>
        </tbody>
        
    </table>
    <div class="foot_mg">
        <img  id="hd" class="fot_1 submit_ok" src="../img/mg5.png" alt=""/> <!-- 发布 -->
        <img  id="step3_rs" class="submit_ok"   src="../img/mg6.png" alt=""/> <!-- 保存 -->
       	<input id="hidden_id" type='hidden' value="">
    </div>
</div>


</div>
<!--content部分结束-->
	 
 <!-- 新闻查询 -->
    <div class="center" id="qt">   	
   <!--content部分开始-->
   <!-- 新闻nav部分 -->
	<div class="nav_box clearfix">
        <div class="nav_t1"><img src="../img/la2.png"></div>
        <div class="nav_t2" class="news">新闻查询</div>
	</div>     
                          
    <table class="clearfix total">
        <tbody>
        <tr>
            <td colspan="2" class="query_title">
                输入查询条件
            </td>
        </tr>
        <tr>
            <td class="td_w size_color">
                格式：
            </td>
            <td>
                <select name="" class="format" id="format">
                    <option value="" selected="">全部</option>
			        <option value="0">普通格式</option>
			        <option value="1">MHT格式</option>
			        <option value="2">超链接格式</option>

                </select>
            </td>
        </tr>
        <tr>
            <td class="blue_text size_color">
               类型：
            </td>
            <td>
                <select name="" class="typeId" id="type_id">
                    <option value="" selected="">全部</option>
		          	<option value="01">公司动态</option>
					<option value="02">媒体关注</option>
					<option value="03">行业资讯</option>
					<option value="04">合作伙伴新闻</option>
					<option value="05">客户新闻</option>

                </select>

            </td>

        </tr>
        <tr>
            <td class="blue_text size_color">
               状态：
            </td>
            <td>
                <select name="" class="publish">
                    <option value="" selected="">全部</option>
			        <option value="0">未发布</option>
			        <option value="1">已发布</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="blue_text size_color">
                	是否置顶:
            </td>
            <td>
                <select name="" class="top">
				    <option value="" selected="">全部</option>
			        <option value="0">未置顶</option>
			        <option value="1">已置顶</option>
                </select>

            </td>
        </tr>
        <tr>
            <td class="size_color">
           		 标题:
            </td>
            <td>
                <input class="title_" id="subject" type="text"/>
            </td>
        </tr>
        <tr class="release">
            <td class="size_color">
           		 发布日期:
            </td>
            <td>
                <input id="beginTime"class="date" type="text"/>
                <div  class="c_t">至</div>
               <input id="endTime" class="date" type="text"/>

            </td>
        </tr>
        <tr>
            <td class="size_color">内容:</td>
            <td>
                <!-- <div class="content_"></div> -->
                <input class="content_" type="text"/>
            </td>
        </tr>
        <tr class="clack_t">
            <td class="size_color">点击次数:</td>
            <td>
                <input class="c_time c_time1" type="text"/>
                <div class="c_t">至</div>
                <input class="c_time c_time2" type="text"/>
            </td>
        </tr>
        <tr class="operation">
            <td class="size_color">操作:</td>
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
                    <div class="bt determine">确定</div>
                    <div>重填</div>
              
            </td>
        </tr>

        </tbody>
    </table>
</div>
<!--content部分结束-->
    	
<script>
	user_id='query_userId';//选人控件
	/* 保存页面附件添加 */
	$(function () {
			$('#uploadimg').click(function(){
				$('#uploadinputimg').click();  
			});
			$('#uploadinputimg').change(function(e){
				var target = $(e.target);
				var file;
				if(target[0].files && target[0].files[0]){
					file=target[0].files[0];
				}
				console.log(file);
				if(file){
					$.upload($('#uploadimgform'),function(res){
						console.log(res);
						var str = "";
						var str1="";
						res.obj.forEach(function(v,i){
							console.log(v.attachId);
							
							str+='<a class="ATTACH_a" NAME="'+v.attachName+'*" href="<%=basePath %>download?'+v.attUrl+'">'+v.attachName+'</a><br>';
							str1+='<input type="hidden" class="inHidden" NAME="'+v.attachName+'*" value="'+v.aid+'@'+v.ym+'_'+v.attachId+',">';
						});
						console.log(str);
						$('#query_uploadArr').append(str+str1);
						
					});
				}
			});
			 /* 修改页面的附件插件 */
			$('#uploadimg_').click(function(){
				$('#uploadinputimg_').click();  
			});
			$('#uploadinputimg_').change(function(e){
				var target = $(e.target);
				var file;
				if(target[0].files && target[0].files[0]){
					file=target[0].files[0];
				}
				console.log(file);
				if(file){
					$.upload($('#uploadimgform_'),function(res){
						console.log(res);
						var str = "";
						var str1="";
						res.obj.forEach(function(v,i){
							console.log(v.attachId);
							
							str+='<a class="ATTACH_a" NAME="'+v.attachName+'*" href="<%=basePath %>download?'+v.attUrl+'">'+v.attachName+'</a><br>';
							str1+='<input type="hidden" NAME="'+v.attachName+'*"  class="inHidden" value="'+v.aid+'@'+v.ym+'_'+v.attachId+',">';
						});
						console.log(str);
						$('#query_uploadArr_').append(str+str1);
						
					});
				}
			}); 
		
	
			/* word文本编辑器 */
			 var ue = UE.getEditor('container');//新建新闻页面
			 var sue = UE.getEditor('container3');//修改新闻页面
			
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
				format:'',
				publish:'',
				top:'',
				clickCount:'',
				click:'',
				typeId:0

            };
           function clearData(){
           		data.read = '';
				data.typeId = '';
				data.nTime = '';
				data.newsTime = '';
				data.lastEditTime='';
				data.content='';
				data.subject='';
				data.format='';
				data.publish='';
				data.top='';
				data.clickCount='';
				data.click='';
				data.typeId=0;
           }
           initPageList(function(pageCount){
           		 initPagination(pageCount,data.pageSize);
           });          		  
           $(".index_head li").click(function (){
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
						var news = "";
                           for (var i = 0; i < data.obj.length; i++) {                          
                                       news = "<tr class='trs' rid='"+data.obj[i].newsId+"'><input class='input_hide' type='hidden' newsID='"+data.obj[i].newsId+"'><td><input  id='input1' name='' type='checkbox' value=''/></td>"+//选择
                               		   "<td class='name' nid='"+data.obj[i].newsId+"'>"+data.obj[i].providerName+"</td>"+//发布人
                                       "<td class='type' nid='"+data.obj[i].newsId+"'>"+data.obj[i].typeName+"</td>"+//类型
                                       "<td class='cli' name='"+data.obj[i].depName+"'><div id='break"+data.obj[i].newsId+"' class='break_td' title="+data.obj[i].depName+">"+'点击详情'+"</div></td>"+//发布范围
                                       "<td time='"+data.obj[i].subject+"'><a  style='color:#2B7FE0'  href='#' newsId="+data.obj[i].newsId+" class='windowOpen'><div id='subject"+data.obj[i].newsId+"'>"+data.obj[i].subject+"</div></a></td>"+//标题
                                       "<td  class='tim'>"+data.obj[i].newsDateTime+"</td>"+//发布时间
                                       "<td class='data'>"+data.obj[i].clickCount+"</td>"+//点击数
                                       "<td class='num'>"+data.obj[i].newsId+"</td>"+//评论（条）
                                       "<td class='state'>"+data.obj[i].publish+"</td>"+//状态
                                        "<td>"+
                                       	 	"<a  href='javascript:;' id='xg' tid='"+data.obj[i].newsId+"'>"+"修改"+"</a>&nbsp"+ 
											 /* "<a  href='javascript:;'>"+"管理评论"+"</a>&nbsp"+
											 "<a  href='javascript:;'>"+"终止"+"</a>&nbsp"+ */
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
            };
            function initPagination(totalData,pageSize){
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
		        /*  alert(attR); */		           
			     var data = {
		           		"newsId":attR
		           	};
		           	/* 调用插件弹窗 */
		           	var msg='是否确认删除?';
					if (confirm(msg)==true){
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
						return true;
					 }else{ 
					 	return false; 
					 }
		           	
		        
		        });
		        
		        /* 新闻管理修改页面 */
		         $("#j_tb").on('click', '#xg', function(){  
		         	var sue = UE.getEditor('container3');//修改新闻页面
		         	var id=$(this).attr('tid');
		         	 if(id==$(this).parent().parent().attr('rid')){	               		
					//新闻详情获得内容：
					sue.ready(function(){
						$.ajax({
		                    url:"<%=basePath%>news/getOneById ",
		                    type:'get',
		                	dataType:"JSON",
			       			data : {
			       				"newsId":id,			
			       			},		                   
		                   success:function(data){
		                        $('#step3_type  option:checked').attr(data.object.codes.codeName),//类型
								$("#step3_ip2").val(); //发布人
								$("#step3_ip4").val();//发布范围 
								$("#step3_ip1").val(data.object.subject);//标题	
								$("#anonymityYn  option:checked").attr(data.object.anonymityYn),//类型					
								$("#step3_ip3").val(data.object.newsDateTime);//发布时间
								/* $(this).parent().siblings('.data').text();//点击数
								$(this).parent().siblings('.num').text();//评论(条)
								$(this).parent().siblings('.state').text();//状态  
								*/	
								$("#hidden_id").val(data.object.newsId);
								$(".step3_5").val(data.object.keyword);                     
		                        sue.setContent(data.object.content);
		                        		                       
			           		},	  
			           		error:function(){
			            		alert("请求数据出错");
			            		return;
		            		}   				                   
		                });															
					});																 	
						 $('.step1').hide();
			          	 $('.center').hide();
						 $('.step2').hide();
						 $('.step3').show(); 
					 } 
		        });	
		     
		        
		        //修改页面保存时调用的方法
		         $(".submit_ok").click(function(){	
		         	var aId_='';
					var uId_='';
					for(var i=0;i<$('.query_uploadArr_  .inHidden').length;i++){
						aId_ += $('#query_uploadArr_ .inHidden').eq(i).val();
						uId_ += $('#query_uploadArr_ .inHidden').eq(i).attr('NAME');
					}
        			         
					  var data = {	
					  		"newsId":$("#hidden_id").val(),	 		       			           		
							"subject": $("#step3_ip1").val(),    //标题 
							"newTime": $("#step3_ip3").val(),      //发布时间 					
							"keyword":$("#ip5").val(),  //内容关键词
							"topDays": $("#topDays").val(),// 限制新闻置顶时间
							"content":  sue.getContent(),//  新闻内容							
							"toId":  $("#step3_ip2").val(),//发布部门	
							"anonymityYn": $("#anonymityYn_").val(), //评论类型(0-实名评论,1-匿名评论,2-禁止评论)							
							"format":$("#format_ option:checked").attr('value'),//新闻格式(0-普通格式,1-MHT格式,2-超链接)
							"typeId":$("#query_typeId").val(),
							"publish":0,  // 发布标识(0-未发布,1-已发布,2-已终止)							
							"top":$("top_").eq(0).is(':checked')==false?0:1,//是否置顶(0-否,1-是)
							"clickCount":'0',//点击数
							"lastEditor":'1',//最后编辑人
							"lastTime":new Date().Format('yyyy-MM-dd hh:mm:ss'),//最后编辑时间
                      		"subjectColor":'1',//新闻标题颜色
                      		"compressContent":'1',//压缩后的新闻内容
                            "summary":$("#ip4").val(),//新闻内容简介  */
                           "attachmentId":aId_,//附件ID串
                      		"attachmentName":uId_,//附件名称串
                        	"privId":$("#privId_").attr("dataid"),//发布 -
                         	"userId":$("#userId_").attr("dataid"),//发布用户 -
                         	"readers": ''//发布角色 						           		
			           	}; 
			            console.log(data);
			            if($(this).attr("step3_type") == "publish"){
			           		data.publish = '1';
			           	}
		                $.ajax({
		                    url:"<%=basePath%>news/updateNews",
		                    type:'get',
		                    dataType:"JSON",		    
			       			 data : data,		                   
		                   	success:function(data){
		                        console.log(data);		           			 				           			
									 $('.step1').show();
						          	 $('.center').hide();
									 $('.step2').hide();
									 $('.step3').hide(); 
									/*  initPageList(); */
								  location.reload();
			           		},	  
			           		error:function(e){
			            		console.log(e);			            		
		            		}   		                  
		                });      
			        }); 
			        /* 选人控件修改页面 */
			        $("#adduser_").on("click",function(){
   					user_id = "privId_";
       		 		$.popWindow("../common/selectUser");
       		 		 
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
		        
		   laydate({
		        elem: '.td_title1', //目标元素。
		        format: 'YYYY-MM-DD', //日期格式
		        istime: true, //显示时、分、秒
		    });
		        
		        //获取当前时间 修改时页面
		        $("#step_release3").click(function(){
		          queryTime();
		      	  $("#step3_ip3").val(now);
		        });
		        
		         //获取当前时间 新建时页面
		        $("#step_release2").click(function(){
		          queryTime();
		      	  $("#query_newTime").val(now);
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
				/* 保存数据 */
			    $(".btn_ok").on("click",function(){
			    	var aId='';
					var uId='';
					for(var i=0;i<$('#query_uploadArr .inHidden').length;i++){
						aId += $('#query_uploadArr .inHidden').eq(i).val();
						uId += $('#query_uploadArr .inHidden').eq(i).attr('NAME');
					}
					console.log(aId);
					console.log(uId);
			        var data = {	  		       			           												           		
							"subject": $("#query_subject").val(),    //标题 
							"newTime": $("#query_newTime").val(),      //发布时间 					
							"keyword":$("#query_keyword").val(),  //内容关键词
							"topDays": $("#add_topDate").val(),// 限制新闻置顶时间
							"content":  ue.getContent()  ,//  新闻内容							
							"toId":  '',//发布部门	
							"anonymityYn": $("#query_format").val(),
							"format":$("#query_format").val(),//新闻格式(0-普通格式,1-MHT格式,2-超链接)
							"typeId":$("#query_typeId").val(),
							"publish":0,  // 发布标识(0-未发布,1-已发布,2-已终止)							
							"top":$("#query_top").eq(0).is(':checked')==false?0:1,//是否置顶(0-否,1-是)
                      		"subjectColor":'',//新闻标题颜色
                            "summary":' ',//新闻内容简介  */
                            "attachmentId":aId,//附件ID串
                      		"attachmentName":uId,//附件名称串
                        	"privId":'',//发布 -
                         	"userId":$("#query_userId").attr("dataid"),//发布用户 -
			           	};
			           	if($(this).attr("type") == "publish"){
			           		data.publish = '1';
			           	}
			          /*  console.log(data); */
		                $.ajax({
		                    url:"<%=basePath%>news/sendNews",
		                    type:'get',
		                    dataType:"JSON",		    
			       			data : data,		                   
		                   	success:function(data){
		                        	alert("发布成功");	           			 				           			
									 $('.step1').show();
						          	 $('.center').hide();
									 $('.step2').hide();
									 $('.step3').hide();
									/*  initPageList(); */
									 location.reload();
			           		},	  
			           		error:function(e){
			            		console.log(e)			            		
		            		}   		                  
		                });     
   				 });
   				$("#query_adduser").on("click",function(){
   					user_id = "query_userId";
       		 		$.popWindow("../common/selectUser");
       		 		 
       		 	});
        
       /* 新闻管理查询的确定按钮 */
          $('.determine').click(function () {
					data.format=$("#format").val(); //新闻格式(0-普通格式,1-MHT格式,2-超链接)
					data.typeId=$("#type_id").val();
					data.publish=$(".publish").val();//发布标识(0-未发布,1-已发布,2-已终止)
					data.top=$(".top").val(); //是否置顶(0-否,1-是)
					data.subject=$("#subject").val();//标题
					data.newsTime= $("#beginTime").val();
					data.lastEditTime=$("#endTime").val();//发布日期
					data.content=$("#beginTime").val(); //内容
					data.clickCount=$(".c_time1").val();
					data.click=$(".c_time2").val();//点击次数   
					data.read="";
					initPageList();
					clearData();
               		$('.step1').show();
					$('.step2').hide();
					$('.center').hide();
        		});
			});

		laydate({
		     elem: '#query_newTime', //目标元素。
		     format: 'YYYY-MM-DD hh:mm:ss', //日期格式
		     istime: true, //显示时、分、秒
		   });
   		laydate({
		     elem: '#step3_ip3', //目标元素。
		     format: 'YYYY-MM-DD hh:mm:ss', //日期格式
		     istime: true, //显示时、分、秒
		   });
   
   //时间控件调用
   var start = {
     elem: '#beginTime',
     format: 'YYYY/MM/DD',
     min: laydate.now(), //设定最小日期为当前日期*/
     max: '2099-06-16 23:59:59', //最大日期*/
     istime: true,
     istoday: false,
     choose: function(datas){
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas; //将结束日的初始值设定为开始日
     }
   };
   var end = {
     elem: '#endTime',
     format: 'YYYY/MM/DD',
     min: laydate.now(),
     max: '2099-06-16 23:59:59',
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
