<%--需把局部样式归并为一个通用或符合公告管理的公共样式，
接口对完需调整--%>

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
	<link rel="stylesheet" type="text/css" href="../css/news/new_news.css"/>	
	<!-- word文本编辑器 -->	
	<script src="../lib/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
	<script src="../lib/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
    <style>
        .btn_ok{
            width:100px;
            height:40px;
            background: #f0f0f0;
            float:left;
            margin-left:30px;
            border-radius: 4px;
            font-size:18px;
            text-align: center;
            line-height: 40px;
        }
        .foot_mg{
            width: 23%;
            height: 50px;
            margin: 10px auto;
        }
        .start_end_time{
            display: inline-block;
            float: left;
            border: none;
            width: 400px;
            height: 20px;


        }
        .td_title1{
            border:none !important;
            color:#000 !important;
        }
        .step2{
            margin-left:2%;
        }
        .news_t{
            width: 139px !important;
        }
        .news_t h1,.news_two h1{
            line-height: 23px;
            text-align: center;
        }
        .news_two{
            width: 139px;
            margin-top: 3px;
        }
        .add_print,.add_down,.add_nochose{
            float:left;
            margin-top:10px;
        }
        .add_print,.add_down{
            width: 152px;

        }
        .add_nochose{
            width: 195px;
            text-align: center;
           line-height:20px;
        }
        .add_print h1,.add_down h1{
            color: #000;
            line-height: 20px;
            text-align: center;
        }
        .add_show,.textTop{
            float:left;
        }
        .add_show{
            line-height: 24px;
            /* text-align: -webkit-auto; */
            text-align: center;
        }
        .zhiding{
            margin-top:3px;
        }
        .title a{
            color: #287fe0;
        }
        .empty {

            color: #999 !important;

        }
        /*table{
            text-align: center;
        }*/
    </style>
</head>
<body>
<div class="bx">
    <!--标题栏-->
    <div class="head w clearfix">
        <ul class="index_head">
           <li data_id=""><span class="one headli1_1">
               <%--<fmt:message  code="news.th.newsmanage"/>--%>
               公告管理
           </span><img class="headli1_2" src="../img/02.png" alt=""/>
            </li>
            <li data_id="0"><span class="headli2_1">
                <%--<fmt:message code="news.th.newbuild"/>--%>
            新建公告
            </span><img src="../img/02.png" alt="" class="headli2_2"/>
            </li>
                    
           <li data_id="1"><span class="headli3">
               <%--<fmt:message code="news.title.query"/>--%>
           公告查询
           </span></li>
            <li data_id="2" style="display:none;"><span class="headli4">
               <%--<fmt:message code="news.title.query"/>--%>
           公告统计
           </span></li>
           
        </ul>
    </div>

    <!--表单选项显示-->
    <div class="step1"> 
    <div class="navigation  clearfix">
        <div class="left">
			 <img src="../img/la2.png">
           <div class="news">
                    <%--<fmt:message code="news.title.new"/>--%>
               管理公告通知
           </div>  
             <select name="TYPE" class="button1 nav_type" id="select">
				<option value="0" selected="">所有类型</option>
				<option tid="01">决定</option>
				<option tid="02">通知</option>
				<option tid="03">通报</option>
				<option tid="04">其他</option>
				<option tid="">无类型</option>
			</select>
			 <div id="cx" class="submit">
                    <fmt:message code="global.lang.query"/>
             </div>
        </div>

        <!-- 分页按钮-->
        <div class="right">
                <div class="M-box3"></div>
            </div>
    </div>

    <!--table表单  标题栏 -->
    <div>
        <div>
            <table id="tr_td">
                <thead>
                	<tr>
                		<td class="th">选择</td>
                    	<td class="th">发布人</td>
                    	<td class="th">类型</td>
                    	<td class="th" >发布范围</td>
	                    <td class="th">标题</td>
	                    <td class="th">发布时间</td>
	                    <td class="th">生效日期</td>
	                    <td class="th">终止日期</td>
	                    <td class="th">状态</td>
	                    <td class="th">操作</td>
	                </tr>
                </thead>
                <tbody id="j_tb"></tbody>
                </table>
            </div>
        </div>
    </div>


    <!-- ************************************ -->
    <!-- 新建公告 -->
	<div class="step2" style="display: none;">
	 <table class="newNews">
        <div class="nav_box clearfix">
            <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
            <div class="nav_t2" class="news">新建公告通知 </div>

            <!-- <div class="nav_t3">选择格式 -->
             <div class="nav_t3" > 
            	<select name="" class="sel" id="add_sel">

                    <option value="0" selected>普通格式</option>
                    <option value="1">MHT格式</option>
                    <option value="2">超级链接</option>
                </select>
            </div>
        </div>
         <!-- 二级选项 -->
        <tbody>
        <tr>
            <td class="td_w">
                <select name="" class="type_notice" id="add_type_notice">
                    <option value="">选择公告类型</option>
                    <option value="01">决定</option>
                    <option value="02">通知</option>
                    <option value="03">通报</option>
                    <option value="04">其他</option>
                </select>
            </td>
            <td>
                <div class="td_title1">
                    <!-- 需调整 -->
                    <input type="text" name="titileTime" id="add_titileTime"  style="height: 20px; width: 255px; margin-left: -4.2px; margin-top: -1px;"
                           placeholder="请输入标题..." >
                    <!-- 后续需要调整 -->
                    <button ></button>
                    <%--请输入发布时间...--%>
                </div>
                <img class="td_title2" src="../img/mg2.png" alt=""/>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                按部门发布：
            </td>
            <td>
                <textarea readonly="readonly" class=" td_title1  release1" id="add_texta"  dataid=""   resize="auto" ></textarea>
                <img class="td_title2 release2" src="../img/mg2.png" alt=""/>
                <div class="release3" >添加</div>
                <div class="release4 empty">清空</div>
            </td>
        </tr>



        <!--- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->
        <!-- 需调整样式 建议采取div展示和隐藏模式  或者可以采取盒子格式 -->
        <tr>
            <td class="blue_text">
                按人员发布：
            </td>
            <td>
                <textarea readonly="readonly" id="add_selectUser" class="td_title1  release1"></textarea>
                <img class="td_title2 release3" src="../img/mg2.png" alt=""/>
                <div class="release3" id="add_selectUserbtn">添加</div>
                <div class="release4 empty">清空</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                按角色发布：
            </td>
            <td>
                <textarea readonly="readonly" class="td_title1  release1"></textarea>
                <img class="td_title2 release4" src="../img/mg2.png" alt=""/>
                <div class="release3">添加</div>
                <div class="release4 empty">清空</div>
            </td>
        </tr>
        <!--- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

        <tr>
            <td class="blue_text">发布时间：</td>
            <td>
                <div class="td_title1">
                    <!-- 需引入时间插件 -->
                    <input type="text" id="add_newDate"  name="publishTime" class="publishTime" style="height: 20px; width: 255px; margin-left: -4.2px; margin-top: -1px;">
                </div>
                <img class="td_title2 release2" src="../img/mg2.png" alt=""/>

                <div class="release3">重置当前时间</div>
            </td>
        </tr>

        <tr>
            <td class="blue_text">有效期：</td>
            <td>
                <div class="td_title1 start_end_time">
                    <!-- 引入时间控件 和 css 调整  -->
                    <input type="text"  name="startTime" id="start_add" class="startTime" style="height: 20px; width: 130px; margin-left: -4.2px; margin-top: -1px;">
                    至
                    <input type="text"  name="endTime" id="end_add" class="endTime" style="height: 20px;width: 130px;  margin-top: -1px;">
                    为空为手动终止
                </div>
            </td>
        </tr>

        <!-- 复选框样式调整  -->
        <tr>
            <td class="blue_text">事物提醒：</td>
            <td class="remind">
                <div class="news_t">
                    <input type="checkbox" name="remind" ><h1>发送事务提醒消息</h1>
                </div>
                <div class="news_two">
                    <input type="checkbox" name="remind" ><h1>分享到企业社区</h1>
                </div>
            </td>
        </tr>

        <tr>
            <td class="blue_text">置顶：</td>
            <td class="top_box">
                <div>
                    <input type="checkbox" name="textTop" id="textTop" class="textTop">
                    <h1 class="add_show">使公告置顶，显示为重要</h1>
                </div>
                <div class="t_box">
                    <input type="text" name="textDay" id="textDay" class="textDay" value="0"
                           style="height: 20px; width: 40px; margin-left: -5.2px; margin-top: -1px;">
                </div>
                <div class="zhiding">天后结束置顶,0表示一直置顶</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">内容简介：</td>
            <td class="abstract">
                <div class="abstract1">
                    <input type="text"  name="summny" id="add_summny" class="summny" style="height: 20px; width: 255px; margin-left: -4.2px; margin-top: -1px;">
                </div>
                <div class="abstract2">(最多输入39个字)</div>
            </td>
        </tr>

        <!-- 需调整 -->
        <tr>
            <td class="blue_text">附件与权限：</td>
            <td class="enclosure">
                <div><img src="../img/mg11.png" alt=""/></div>
                <div class="enclosure_t">添加附件</div>
                <div><img src="../img/mg12.png" alt=""/></div>
                <div class="enclosure_t">从文件柜和网络硬盘选择附件</div>
                <div><img src="../img/mg13.png" alt=""/></div>
                <div class="enclosure_t">批量插入图片</div>
                <div><img src="../img/mg14.png" alt=""/></div>
                <div class="enclosure_t">批量上传过</div><br/>
                <div class="add_down">
                    <input type="checkbox" name="textEnclosure" class="textEnclosure">
                    <h1>允许下载Office附件</h1>
                </div>
                <div class="add_print">
                    <input type="checkbox" name="textEnclosure" class="textEnclosure" >
                    <h1>允许打印Office附件</h1>
                </div>

                <%--<input >--%>
                <h1 class="add_nochose"> 都不选中则只能阅读附件内容</h1>

            </td>
        </tr>

        <!--word编辑器-->
        <tr>
            <td colspan="2">
				<div id="container" name="content" type="text/plain" style="width: 100%;min-height: 200px;"></div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                关键字：
            </td>
            <td class="keyword">
                <input class="keyword_ip">请输入关键字</input>
                <div class="keyword_t">自动获取关键字</div>
                <div>您可以调整关键字内容多个关键词请用分割</div>
        </tr>
        </tbody>
        
    </table>
    <div class="foot_mg">
        <div  id="add_send" value="1" type="publish" class="fot_1 btn_ok">发布</div>
        <div  id="add_baocun" value="0" type="save" class="btn_ok">保存</div>
    </div>
</div>
</div>



<!--content部分结束-->

    
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
                <input id="beginTime"class="input_text3" type="text"/>
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
    user_id='';
$(function () {
    $('#add_selectUserbtn').click(function(){
        user_id='add_selectUser';
        $.popWindow("../common/selectUser");
    });



			/* word文本编辑器 */
			 var ue = UE.getEditor('container');
		 
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
					url: "<%=basePath%>notice/notifyList",
					dataType: 'JSON',
					data: data,
					success: function(data){
						console.log(data);
						var news = "";
                           for (var i = 0; i < data.obj.length; i++) {
                           	var toTypeName = ""
                        		if(data.obj[i].toId != ""){
                        			toTypeName+="部门";
                        		}
                        		if(data.obj[i].privId != ""){
                        			toTypeName+=",角色";
                        		}
                        		if(data.obj[i].userId != ""){
                        			toTypeName+=",用户";
                        		}
                               	 news ="<tr notifyId="+data.obj[i].notifyId+"><td><input  id='input1' name='' type='checkbox' value=''/></td>"+
                               	       "<td><a href='#' notifyId="+data.obj[i].notifyId+" class='windowOpen'>"+data.obj[i].name+"</ a></td>"+
                                       "<td><a href='#' notifyId="+data.obj[i].notifyId+" class='windowOpen'>"+data.obj[i].typeName+"</ a></td>"+
                                       "<td><a href='#' notifyId="+data.obj[i].notifyId+" class='windowOpen'>"+toTypeName+"</ a></td>"+
                                       "<td class='title' notifyId="+data.obj[i].notifyId+"><a href='#'  class='windowOpen'>"+data.obj[i].subject+"</ a></td>"+
                                       "<td class='send_time'><a href='#' notifyId="+data.obj[i].notifyId+" class='windowOpen'>"+data.obj[i].notifyDateTime.split(' ')[0]+"</a></td>"+
                                       "<td class='start_time'><a href='#' notifyId="+data.obj[i].notifyId+" class='windowOpen'>"+data.obj[i].notifyDateTime.split(' ')[0]+"</a></td>"+
                                       "<td class='end_time'><a href='#' notifyId="+data.obj[i].notifyId+" class='windowOpen'>"+data.obj[i].notifyDateTime.split(' ')[0]+"</a></td>"+
                                       "<td>"+"生效</td>"+//状态
                                       "<td>"+"<a notifyId="+data.obj[i].notifyId+" class='notice_change'>修改</a>    <a class='notice_delete' notifyId="+data.obj[i].notifyId+">删除</a></td>"+//操作
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
            /*公告详情页 */
               $("#j_tb").on('click','.title',function(){

		            var nid=$(this).attr('notifyId');

		            $.popWindow('detail?notifyId='+nid);
		        });
		        /* 新闻查询按钮 */
        		$('.submit').click(function (){
					data.read = $('.index_head .one').parent().attr('data_id');
					data.typeId = $('#select option:checked').attr("tid");
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

       //新建公告通知
        $('#add_send').on('click',function(){

         var data_notice={
             subject:$('#add_titileTime').val(),//标题
             toId:$('#add_texta').val(),//部门发布范围
             format:$('#add_sel option:checked').attr('value'),//格式
             typeId:$('#add_type_notice option:checked').attr('value'),//公告类型
             userId:$('#add_selectUser').attr("dataid"),//按人员发布
             privId:'',//按角色发布
             attachmentId:'',//附件ID串
             attachmentName:'',//附件名称串
             download:$(".textEnclosure").is(':checked')==false?0:1,//是否允许下载office附件(0-不允许,1-允许)
             subjectColor:'',//标题颜色
             keyword:$('.keyword_ip').val(),//内容关键词
             topDays:$('#textDay').val(),//置顶天数
             publish:$(this).attr('value'),//发布标识(0-未发布,1-已发布,2-待审批,3-未通过)
             top:$("#add_textTop").is(':checked')==false?0:1,//是否置顶(0-否,1-是),
             summary:$('#add_summny').val(),//内容简介
             content:ue.getContent(),//内容
             sendTimes:$('#add_newDate').val(),//发布时间
             beginDates:$('#start_add').val(),//开始日期
             endDates:$('#end_add').val()  //结束日期
         }

         console.log(data_notice);
            add_notice(data_notice);

         })

         function add_notice(data_notice){

            /* var layerIndex = layer.load(0, {shade: false});*/
             $.ajax({
                 type: "post",
                 url: "<%=basePath%>notice/addNotify",
                 dataType: 'json',
                 data: data_notice,
                 success: function (obj) {
                     console.log(obj);
                   if(obj.flag==true){
                       window.location.reload();
                   }

                 },

             });
         }

     /*add_notice();*/
            //修改公告通知管理
           $('#j_tb').on('click','.notice_change',function(){
               var tid=$(this).attr('notifyId');
               $('.step1').hide();
               $('.step2').show();
               $('.center').hide();
                //公告详情
               $.ajax({
                   url: "getOneById",
                   type: "get",
                   data:{
                       notifyId:tid
                   },
                   dataType: 'json',
                   success: function (obj) {
                       console.log(obj.object);
                       var data=obj.object;
                       var sendTime=new Date((data.sendTime)*1000).Format('yyyy-MM-dd hh:mm');
                       var beginDate=new Date((data.beginDate)*1000).Format('yyyy-MM-dd hh:mm');
                       $('#add_titileTime').val(data.subject);
                       $('#add_texta').val(data.toId);
                       $('#add_selectUser').val(data.userId);
                       $('.td_title1').val(data.privId);//角色
                       $('#add_newDate').val(data.sendTime);
                       $('#start_add').val(data.beginDate);
                       $('#end_add').val(data.endDate);
                       $('#add_selectUser').val(data.userId);
                   }

               })

              /* var title=$(this).parent().siblings('.title').find('a').text();
               alert(title);
               var send_time=$(this).parent().siblings('.send_time').find('a').text();
               var start_time=$(this).parent().siblings('.start_time').find('a').text();
               var end_time=$(this).parent().siblings('.end_time').find('a').text();*/
               /*  window.location.reload();
                //跳转页面
                $('.step1').hide();
                $('.step2').show();
                $('.center').hide();*/

                //添加到修改页面



               $.ajax({
                    url: "updateNotify",
                    type: "get",
                    data:{
                        notifyId:tid,
                        subject:$('#add_titileTime').val(),//标题
                        toId:$('#add_texta').val(),//部门发布范围
                        format:$('#add_sel option:checked').attr('value'),//格式
                        typeId:$('#add_type_notice option:checked').attr('value'),//公告类型
                        userId:$('#add_selectUser').val(),//按人员发布
                        privId:'',//按角色发布
                        attachmentId:'',//附件ID串
                        attachmentName:'',//附件名称串
                        download:$(".textEnclosure").is(':checked')==false?0:1,//是否允许下载office附件(0-不允许,1-允许)
                        subjectColor:'',//标题颜色
                        keyword:$('.keyword_ip').val(),//内容关键词
                        topDays:$('#textDay').val(),//置顶天数
                        publish:$(this).attr('value'),//发布标识(0-未发布,1-已发布,2-待审批,3-未通过)
                        top:$("#add_textTop").is(':checked')==false?0:1,//是否置顶(0-否,1-是),
                        summary:$('#add_summny').val(),//内容简介
                        content:ue.getContent(),//内容
                        sendTimes:$('#add_newDate').val(),//发布时间
                        beginDates:$('#start_add').val(),//开始日期
                        endDates:$('#end_add').val()  //结束日期

                    },
                    dataType: 'json',
                    success: function (obj) {

                        if(obj.flag==true){
                            window.location.reload();
                        }

                    }
                })
            });



            //删除公告通知管理
            $('#j_tb').on('click','.notice_delete',function(){

                var tid=$(this).attr('notifyId');
                $.ajax({
                    url: "<%=basePath%>notice/deleteById",
                    type: "get",
                    data:{
                        notifyId:tid
                    },
                    dataType: 'json',
                    success: function (obj) {
                        window.location.reload();
                    }
                })
            })



});
    laydate({
         elem: '#add_newDate', //目标元素。
         format: 'YYYY-MM-DD hh:mm:ss', //日期格式
         istime: true, //显示时、分、秒
    });
   
   //查询公告时间控件调用
   var start = {
     elem: '#beginTime',
     format: 'YYYY/MM/DD hh:mm:ss',
    min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16 23:59:59', //最大日期
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
     min: laydate.now(),
     max: '2099-06-16 23:59:59',
     istime: true,
     istoday: false,
     choose: function(datas){
       start.max = datas; //结束日选好后，重置开始日的最大日期
     }
   };

    /*新建公告时间控件调用*/

    var starts = {
        elem: '#start_add',
        format: 'YYYY/MM/DD hh:mm:ss',
        min: laydate.now(), //设定最小日期为当前日期
        max: '2099-06-16 23:59:59', //最大日期
        istime: true,
        istoday: false,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas; //将结束日的初始值设定为开始日
        }
    };
    var ends = {
        elem: '#end_add',
        format: 'YYYY/MM/DD hh:mm:ss',
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
    laydate(starts);
    laydate(ends);

</script>


</body>



</html>
