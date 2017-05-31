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
            width:26%;
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
            line-height: 5px;
        }
        .notice_change,.notice_delete,#add_send,#add_baocun,.release3{
            cursor: pointer;
        }
        .release3{
            margin-top:0px !important;
            line-height: 26px;
        }
    </style>
</head>
<body>
<div class="bx">
    <!--标题栏-->
    <div class="head w clearfix">
        <ul class="index_head">
           <li data_id=""><span class="one headli1_1">
              <fmt:message  code="notice.th.notifymanage"/>
           </span><img class="headli1_2" src="../img/02.png" alt=""/>
            </li>
            <li data_id="0"><span class="headli2_1">
                <fmt:message code="notice.th.buildnotify"/>
            </span><img src="../img/02.png" alt="" class="headli2_2"/>
            </li>
                    
           <li data_id="1"><span class="headli3">
              <fmt:message code="notice.title.announcementquery"/>
           </span></li>
            <li data_id="2" style="display:none;"><span class="headli4">
               <fmt:message code="notice.th.notifycount"/>
           </span></li>
           
        </ul>
    </div>

    <!--表单选项显示-->
    <div class="step1"> 
    <div class="navigation  clearfix">
        <div class="left">
			 <img src="../img/la2.png">
           <div class="news">
                    <fmt:message code="notice.th.managenotifynotice"/>
           </div>  
             <select name="TYPE" class="button1 nav_type" id="select">
				<option value="0" selected=""> <fmt:message code="notice.type.alltype"/></option>
				<option tid="01"><fmt:message code="notice.type.Decision"/></option>
				<option tid="02"> <fmt:message code="notice.type.notice"/></option>
				<option tid="03"><fmt:message code="notice.type.Bulletin"/></option>
				<option tid="04"> <fmt:message code="notice.type.other"/></option>
				<option tid=""> <fmt:message code="notice.type.notype"/></option>
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
                		<td class="th"><fmt:message code="notice.th.chose"/></td>
                    	<td class="th"><fmt:message code="notice.th.publisher"/></td>
                    	<td class="th"><fmt:message code="notice.th.type"/></td>
                    	<td class="th" ><fmt:message code="notice.th.releasescope"/></td>
	                    <td class="th"><fmt:message code="notice.th.title"/></td>
	                    <td class="th"><fmt:message code="notice.th.PostedTime"/></td>
	                    <td class="th"><fmt:message code="notice.th.effectivedate"/></td>
	                    <td class="th"><fmt:message code="notice.th.endDate"/></td>
	                    <td class="th"><fmt:message code="notice.th.state"/></td>
	                    <td class="th"><fmt:message code="notice.th.operation"/></td>
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
            <div class="nav_t2" class="news"><fmt:message code="notice.th.newnotify"/> </div>

            <!-- <div class="nav_t3">选择格式 -->
             <div class="nav_t3" > 
            	<select name="" class="sel" id="add_sel">

                    <option value="0" selected><fmt:message code="notice.format.Commonformat"/></option>
                    <option value="1"><fmt:message code="notice.format.MHTformat"/></option>
                    <option value="2"><fmt:message code="notice.format.hyperlink"/></option>
                </select>
            </div>
        </div>
         <!-- 二级选项 -->
        <tbody>
        <tr>
            <td class="td_w">
                <select name="" class="type_notice" id="add_type_notice">
                    <option value=""><fmt:message code="notice.th.chosenotifytype"/></option>
                    <option value="01"><fmt:message code="notice.type.Decision"/></option>
                    <option value="02"><fmt:message code="notice.type.notice"/></option>
                    <option value="03"><fmt:message code="notice.type.Bulletin"/></option>
                    <option value="04"><fmt:message code="notice.type.other"/></option>
                </select>
            </td>
            <td>
                <div class="td_title1">
                    <!-- 需调整 -->

                    <input type="text" name="titileTime" id="add_titileTime"  style="height: 20px; width: 255px; margin-left: -4.2px; margin-top: -1px;"
                           placeholder=" <fmt:message code="global.lang.printsubject"/>..." >

                    <!-- 后续需要调整 -->
                    <button ></button>
                    <%--请输入发布时间...--%>
                </div>
                <img class="td_title2" src="../img/mg2.png" alt=""/>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
               <fmt:message code="notice.th.IssuedByDepartment"/>：
            </td>
            <td>
                <textarea readonly="readonly" class=" td_title1  release1" id="add_texta"  dataid=""   resize="auto" ></textarea>
                <img class="td_title2 release2" src="../img/mg2.png" alt=""/>
                <div class="release3" ><fmt:message code="global.lang.add"/></div>
                <div class="release4 empty"><fmt:message code="global.lang.empty"/></div>
            </td>
        </tr>



        <!--- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->
        <!-- 需调整样式 建议采取div展示和隐藏模式  或者可以采取盒子格式 -->
        <tr>
            <td class="blue_text">
                <fmt:message code="notice.th.somebody"/>：
            </td>
            <td>
                <textarea readonly="readonly" id="adds_selectUser" class="td_title1  release1"></textarea>
                <img class="td_title2 release3" src="../img/mg2.png" alt=""/>
                <div class="release3" id="adds_selectUserbtn"><fmt:message code="global.lang.add"/></div>
                <div class="release4 empty"><fmt:message code="global.lang.empty"/></div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
               <fmt:message code="notice.th.role"/>：
            </td>
            <td>
                <textarea readonly="readonly" id="add_selectjuese" class="td_title1  release1"></textarea>
                <img class="td_title2 release4" src="../img/mg2.png" alt=""/>
                <div class="release3"><fmt:message code="global.lang.add"/></div>
                <div class="release4 empty"><fmt:message code="global.lang.empty"/></div>
            </td>
        </tr>
        <!--- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

        <tr>
            <td class="blue_text"><fmt:message code="notice.th.PostedTime"/>：</td>
            <td>
                <div class="td_title1">
                    <!-- 需引入时间插件 -->
                    <input type="text" id="add_newDate"  name="publishTime" class="publishTime" style="height: 20px; width: 255px; margin-left: -4.2px; margin-top: -1px;">
                </div>
                <img class="td_title2 release2" src="../img/mg2.png" alt=""/>

                <div class="release3"><fmt:message code="notice.th.ResetToCurrentTime"/></div>
            </td>
        </tr>

        <tr>
            <td class="blue_text"><fmt:message code="notice.th.validity"/>：</td>
            <td>
                <div class="td_title1 start_end_time">
                    <!-- 引入时间控件 和 css 调整  -->
                    <input type="text"  name="startTime" id="start_add" class="startTime" style="height: 20px; width: 130px; margin-left: -4.2px; margin-top: -1px;">
                   <fmt:message code="global.lang.to"/>
                    <input type="text"  name="endTime" id="end_add" class="endTime" style="height: 20px;width: 130px;  margin-top: -1px;">
                    <fmt:message code="notice.th.null"/>
                </div>
            </td>
        </tr>

        <!-- 复选框样式调整  -->
        <tr>
            <td class="blue_text"><fmt:message code="notice.th.reminder"/>：</td>
            <td class="remind">
                <div class="news_t">
                    <input type="checkbox" name="remind" ><h1><fmt:message code="notice.th.remindermessage"/></h1>
                </div>
                <div class="news_two">
                    <input type="checkbox" name="remind" ><h1><fmt:message code="notice.th.share"/></h1>
                </div>
            </td>
        </tr>

        <tr>
            <td class="blue_text"><fmt:message code="notice.th.top"/>：</td>
            <td class="top_box">
                <div>
                    <input type="checkbox" name="textTop" id="textTop" class="textTop">
                    <h1 class="add_show"><fmt:message code="notice.th.topMajor"/></h1>
                </div>
                <div class="t_box">
                    <input type="text" name="textDay" id="textDay" class="textDay" value="0"
                           style="height: 20px; width: 40px; margin-left: -5.2px; margin-top: -1px;">
                </div>
                <div class="zhiding"><fmt:message code="notice.th.endTop"/></div>
            </td>
        </tr>
        <tr>
            <td class="blue_text"><fmt:message code="notice.th.contentValidity"/>：</td>
            <td class="abstract">
                <div class="abstract1">
                    <input type="text"  name="summny" id="add_summny" class="summny" style="height: 20px;    color: #000; width: 255px; margin-left: -4.2px; margin-top: -1px;">
                </div>
                <div class="abstract2"><fmt:message code="notice.th.contentHigh"/></div>
            </td>
        </tr>

        <!-- 需调整 -->
        <tr>
            <td class="blue_text"><fmt:message code="notice.th.fileUpload"/>：</td>
            <td class="enclosure">
                <div><img src="../img/mg11.png" alt=""/></div>
                <div class="enclosure_t"><fmt:message code="notice.th.addfile"/></div>
                <div><img src="../img/mg12.png" alt=""/></div>
                <div class="enclosure_t"><fmt:message code="notice.th.net"/></div>
                <div><img src="../img/mg13.png" alt=""/></div>
                <div class="enclosure_t"><fmt:message code="notice.th.poto"/></div>
                <div><img src="../img/mg14.png" alt=""/></div>
                <div class="enclosure_t"><fmt:message code="notice.th.up"/></div><br/>
                <div class="add_down">

                    <input type="checkbox" name="textEnclosure" class="textEnclosure">
                    <h1><fmt:message code="notice.th.office"/></h1>
                </div>
                <div class="add_print">
                    <input type="checkbox" name="textEnclosure" class="textEnclosure" >
                    <h1><fmt:message code="notice.th.printoffice"/></h1>
                </div>

                <%--<input >--%>
                <h1 class="add_nochose"> <fmt:message code="notice.th.noselect"/></h1>

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
               <fmt:message code="notice.th.keyWord"/>：
            </td>
            <td class="keyword">
                <input class="keyword_ip"><fmt:message code="global.th.printkey"/></input>
                <div class="keyword_t"><fmt:message code="notice.th.AutomaticKeywordAcquisition"/></div>
                <div><fmt:message code="notice.th.keyContent"/></div>
        </tr>
        </tbody>
        
    </table>
    <div class="foot_mg">
        <div  id="add_send" value="1" type="publish" class="fot_1 btn_ok"><fmt:message code="global.lang.publish"/></div>
        <div  id="add_baocun" value="0" type="save" class="btn_ok"><fmt:message code="global.lang.save"/></div>
    </div>
</div>
    <%--修改--%>
    <div class="step3" style="display: none;">
        <table class="newNews">
            <div class="nav_box clearfix">
                <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
                <div class="nav_t2" class="news"><fmt:message code="notice.th.newnotify"/> </div>

                <!-- <div class="nav_t3">选择格式 -->
                <div class="nav_t3" >
                    <select name="" class="sel" id="add_sel">

                        <option value="0" selected><fmt:message code="notice.format.Commonformat"/></option>
                        <option value="1"><fmt:message code="notice.format.MHTformat"/></option>
                        <option value="2"><fmt:message code="notice.format.hyperlink"/></option>
                    </select>
                </div>
            </div>
            <!-- 二级选项 -->
            <tbody>
            <tr>
                <td class="td_w">
                    <select name="" class="type_notice" id="add_type_notice">
                        <option value=""><fmt:message code="notice.th.chosenotifytype"/></option>
                        <option value="01"><fmt:message code="notice.type.Decision"/></option>
                        <option value="02"><fmt:message code="notice.type.notice"/></option>
                        <option value="03"><fmt:message code="notice.type.Bulletin"/></option>
                        <option value="04"><fmt:message code="notice.type.other"/></option>
                    </select>
                </td>
                <td>
                    <div class="td_title1">
                        <!-- 需调整 -->

                        <input type="text" name="titileTime" id="add_titileTime"  style="height: 20px; width: 255px; margin-left: -4.2px; margin-top: -1px;"
                               placeholder=" <fmt:message code="global.lang.printsubject"/>..." >

                        <!-- 后续需要调整 -->
                        <button ></button>
                        <%--请输入发布时间...--%>
                    </div>
                    <img class="td_title2" src="../img/mg2.png" alt=""/>
                </td>
            </tr>
            <tr>
                <td class="blue_text">
                    <fmt:message code="notice.th.IssuedByDepartment"/>：
                </td>
                <td>
                    <textarea readonly="readonly" class=" td_title1  release1" id="add_texta"  dataid=""   resize="auto" ></textarea>
                    <img class="td_title2 release2" src="../img/mg2.png" alt=""/>
                    <div class="release3" ><fmt:message code="global.lang.add"/></div>
                    <div class="release4 empty"><fmt:message code="global.lang.empty"/></div>
                </td>
            </tr>



            <!--- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->
            <!-- 需调整样式 建议采取div展示和隐藏模式  或者可以采取盒子格式 -->
            <tr>
                <td class="blue_text">
                    <fmt:message code="notice.th.somebody"/>：
                </td>
                <td>
                    <textarea readonly="readonly" id="add_selectUser" class="td_title1  release1"></textarea>
                    <img class="td_title2 release3" src="../img/mg2.png" alt=""/>
                    <div class="release3" id="add_selectUserbtn"><fmt:message code="global.lang.add"/></div>
                    <div class="release4 empty"><fmt:message code="global.lang.empty"/></div>
                </td>
            </tr>
            <tr>
                <td class="blue_text">
                    <fmt:message code="notice.th.role"/>：
                </td>
                <td>
                    <textarea readonly="readonly" id="add_selectjuese" class="td_title1  release1"></textarea>
                    <img class="td_title2 release4" src="../img/mg2.png" alt=""/>
                    <div class="release3"><fmt:message code="global.lang.add"/></div>
                    <div class="release4 empty"><fmt:message code="global.lang.empty"/></div>
                </td>
            </tr>
            <!--- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

            <tr>
                <td class="blue_text"><fmt:message code="notice.th.PostedTime"/>：</td>
                <td>
                    <div class="td_title1">
                        <!-- 需引入时间插件 -->
                        <input type="text" id="adds_newDate"  name="publishTime" class="publishTime" style="height: 20px; width: 255px; margin-left: -4.2px; margin-top: -1px;">
                    </div>
                    <img class="td_title2 release2" src="../img/mg2.png" alt=""/>

                    <div class="release3"><fmt:message code="notice.th.ResetToCurrentTime"/></div>
                </td>
            </tr>

            <tr>
                <td class="blue_text"><fmt:message code="notice.th.validity"/>：</td>
                <td>
                    <div class="td_title1 start_end_time">
                        <!-- 引入时间控件 和 css 调整  -->
                        <input type="text"  name="startTime" id="starts_add" class="startTime" style="height: 20px; width: 130px; margin-left: -4.2px; margin-top: -1px;">
                        <fmt:message code="global.lang.to"/>
                        <input type="text"  name="endTime" id="ends_add" class="endTime" style="height: 20px;width: 130px;  margin-top: -1px;">
                        <fmt:message code="notice.th.null"/>
                    </div>
                </td>
            </tr>

            <!-- 复选框样式调整  -->
            <tr>
                <td class="blue_text"><fmt:message code="notice.th.reminder"/>：</td>
                <td class="remind">
                    <div class="news_t">
                        <input type="checkbox" name="remind" ><h1><fmt:message code="notice.th.remindermessage"/></h1>
                    </div>
                    <div class="news_two">
                        <input type="checkbox" name="remind" ><h1><fmt:message code="notice.th.share"/></h1>
                    </div>
                </td>
            </tr>

            <tr>
                <td class="blue_text"><fmt:message code="notice.th.top"/>：</td>
                <td class="top_box">
                    <div>
                        <input type="checkbox" name="textTop" id="textTop" class="textTop">
                        <h1 class="add_show"><fmt:message code="notice.th.topMajor"/></h1>
                    </div>
                    <div class="t_box">
                        <input type="text" name="textDay" id="textDay" class="textDay" value="0"
                               style="height: 20px; width: 40px; margin-left: -5.2px; margin-top: -1px;">
                    </div>
                    <div class="zhiding"><fmt:message code="notice.th.endTop"/></div>
                </td>
            </tr>
            <tr>
                <td class="blue_text"><fmt:message code="notice.th.contentValidity"/>：</td>
                <td class="abstract">
                    <div class="abstract1">
                        <input type="text"  name="summny" id="add_summny" class="summny" style="height: 20px;    color: #000; width: 255px; margin-left: -4.2px; margin-top: -1px;">
                    </div>
                    <div class="abstract2"><fmt:message code="notice.th.contentHigh"/></div>
                </td>
            </tr>

            <!-- 需调整 -->
            <tr>
                <td class="blue_text"><fmt:message code="notice.th.fileUpload"/>：</td>
                <td class="enclosure">
                    <div><img src="../img/mg11.png" alt=""/></div>
                    <div class="enclosure_t"><fmt:message code="notice.th.addfile"/></div>
                    <div><img src="../img/mg12.png" alt=""/></div>
                    <div class="enclosure_t"><fmt:message code="notice.th.net"/></div>
                    <div><img src="../img/mg13.png" alt=""/></div>
                    <div class="enclosure_t"><fmt:message code="notice.th.poto"/></div>
                    <div><img src="../img/mg14.png" alt=""/></div>
                    <div class="enclosure_t"><fmt:message code="notice.th.up"/></div><br/>
                    <div class="add_down">

                        <input type="checkbox" name="textEnclosure" class="textEnclosure">
                        <h1><fmt:message code="notice.th.office"/></h1>
                    </div>
                    <div class="add_print">
                        <input type="checkbox" name="textEnclosure" class="textEnclosure" >
                        <h1><fmt:message code="notice.th.printoffice"/></h1>
                    </div>

                    <%--<input >--%>
                    <h1 class="add_nochose"> <fmt:message code="notice.th.noselect"/></h1>

                </td>
            </tr>

            <!--word编辑器-->
            <tr>
                <td colspan="2">
                    <div id="containers" name="content" type="text/plain" style="width: 100%;min-height: 200px;"></div>
                </td>
            </tr>
            <tr>
                <td class="blue_text">
                    <fmt:message code="notice.th.keyWord"/>：
                </td>
                <td class="keyword">
                    <input class="keyword_ip"><fmt:message code="global.th.printkey"/></input>
                    <div class="keyword_t"><fmt:message code="notice.th.AutomaticKeywordAcquisition"/></div>
                    <div><fmt:message code="notice.th.keyContent"/></div>
            </tr>
            </tbody>

        </table>
        <div class="foot_mg">
            <div  id="add_send" value="1" type="publish" class="fot_1 btn_ok"><fmt:message code="global.lang.publish"/></div>
            <div  id="add_baocun" value="0" type="save" class="btn_ok"><fmt:message code="global.lang.save"/></div>
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
    //修改
    $('#add_selectUserbtn').click(function(){
        user_id='add_selectUser';
        $.popWindow("../common/selectUser");
    });
    //新增
    $('#adds_selectUserbtn').click(function(){
        user_id='adds_selectUser';
        $.popWindow("../common/selectUser");
    });



			/* word文本编辑器 */
			//修改---插件
			 var ue = UE.getEditor('container');

			 //新增ue插件
            var ue = UE.getEditor('containers');
		 
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
                    $('.step3').hide();
					$('.center').hide();
					initPageList();
				}else if(data.read == 1){
					$('.step1').hide();
					$('.step2').hide();
                    $('.step3').hide();
					$('.center').show('');
					$('#subject').val('');
					$('#beginTime').val('');
					$('#endTime').val('');
					$('#select').val()==0?'':$('#select').val();
					$('#content').val('');
				}else  if( data.read == 0){
					$('.step1').hide();
					$('.step2').hide();
                    $('.step3').show();
					$('#add_send').attr('ac','add');
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
                                       "<td class='title' notifyId="+data.obj[i].notifyId+"><a href='#'  class='windowOpen'>"+data.obj[i].subject+"</a></td>"+
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
		        /* 公告查询按钮 */
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
         var action=$(this).attr("ac");

         alert(action);
            var data_notice={
                subject:$('#add_titileTime').val(),//标题
                toId:$('#add_texta').val(),//部门发布范围
                format:$('#add_sel option:checked').attr('value'),//格式
                typeId:$('#add_type_notice option:checked').attr('value'),//公告类型
                userId:$('#adds_selectUser').attr("dataid"),//按人员发布
                privId:'',//按角色发布
                attachmentId:'',//附件ID串
                attachmentName:'',//附件名称串
                download:$(".down").is(':checked')==false?0:1,//是否允许下载office附件(0-不允许,1-允许)
                subjectColor:'',//标题颜色
                keyword:$('.keyword_ip').val(),//内容关键词
                topDays:$('#textDay').val(),//置顶天数
                publish:$(this).attr('value'),//发布标识(0-未发布,1-已发布,2-待审批,3-未通过)
                top:$("#add_textTop").is(':checked')==false?0:1,//是否置顶(0-否,1-是),
                summary:$('#add_summny').val(),//内容简介
                content:ue.getContent(),//内容
                sendTimes:$('#adds_newDate').val(),//发布时间
                beginDates:$('#starts_add').val(),//开始日期
                endDates:$('#ends_add').val()  //结束日期
            }
         if(action=="update"){
                var noId=$(this).attr("noId");
             data_notice['lastEditTimes']=$('#add_newDate').val();
             data_notice['notifyId']=noId;
             update(data_notice);
         }else{
             //空数据
             $('#add_selectUser').val();//选人
             $('#add_texta').val();//选部门
             $('#add_texta').val();//选角色
             $('#add_selectjuese').val();//角色
             $('#add_newDate').val();//发布时间
             $('#start_add').val();//起始时间
             $('#end_add').val();//结束时间
             /*$('#add_selectUser').val(data.userId);*/
             /*$('#add_type_notice').selected(data.typeName);*/
             $("#add_type_notice").find("option[value=选择公告类型]").attr("selected",true);//类型
            /* if(data.top==1){
                 $('#textTop').prop('checked',true);//是否置顶
             };*/

             ue.setContent();//内容

             $("#add_sel").find("option[value=普通格式]").attr("selected",true);//格式
             $('#add_summny').val();//内容
             $('.keyword_ip').val();//关键词
             /*add_notice(data_notice);*/
         }

         })
        //新建保存的数据接口
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

        //修改保存的数据接口
        function update(data_notice){
            $.ajax({
                url: "updateNotify",
                type: "get",
                data: data_notice,
                dataType: 'json',
                success: function (obj) {

                    if(obj.flag==true){
                        window.location.reload();
                    }

                }
            })
        }

     /*add_notice();*/
            //修改公告通知管理
           $('#j_tb').on('click','.notice_change',function(){

               var tid=$(this).attr('notifyId');
               $('.step1').hide();
               $('.step2').show();
               $('.step3').hide();
               $('#add_send').attr('ac',"update");
               $('#add_send').attr('noId',tid);
               $('.center').hide();
               ue.ready(function(){
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
                           var sendTime=new Date((data.sendTime)*1000).Format('yyyy-MM-dd hh:mm');
                           var beginDate=new Date((data.beginDate)*1000).Format('yyyy-MM-dd hh:mm');
                           $('#add_titileTime').val(data.subject);
                           $('#add_texta').val(data.toId);
                           $('#add_selectUser').val(data.userrange);//选人
                           $('#add_texta').val(data.toId);//选部门
                           $('#add_texta').val(data.toId);//选角色
                           $('#add_selectjuese').val(data.privId);//角色
                           $('#add_newDate').val(data.notifyDateTime);//发布时间
                           $('#start_add').val(data.beginDate);//起始时间
                           $('#end_add').val(data.endDate);//结束时间
                           /*$('#add_selectUser').val(data.userId);*/
                           /*$('#add_type_notice').selected(data.typeName);*/
                           $("#add_type_notice").find("option[value="+data.typeId+"]").attr("selected",true);//类型
                           if(data.top==1){
                               $('#textTop').prop('checked',true);//是否置顶
                           };

                           ue.setContent(data.content);//内容
                           if(data.top==1){
                               $('.print').prop('checked',true);//是否打印
                           }
                           if(data.top==1){
                               $('.down').prop('checked',true);//是否下载
                           }
                            $('#textDay').val(data.topDays)//置顶天数

                           $("#add_sel").find("option[value="+data.format+"]").attr("selected",true);//格式
                            $('#add_summny').val(data.summary);//内容
                           $('.keyword_ip').val(data.keyword);//关键词
                       }

                   })
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



           /*    $.ajax({
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
                        download:$(".down").is(':checked')==false?0:1,//是否允许下载office附件(0-不允许,1-允许)
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
                })*/
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
    //修改
    laydate({
         elem: '#add_newDate', //目标元素。
         format: 'YYYY-MM-DD hh:mm:ss', //日期格式
         istime: true, //显示时、分、秒
    });

    //新增时间控件
    laydate({
        elem: '#adds_newDate', //目标元素。
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
    //修改-----开始时间
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
    //新增-----开始时间
    var starts_zeng = {
        elem: '#starts_add',
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
    //修改----结束时间
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
    //新增----结束时间
    var ends_zeng = {
        elem: '#ends_add',
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
    laydate(starts_zeng);
    laydate(ends_zeng);
    laydate(ends);

</script>


</body>



</html>
