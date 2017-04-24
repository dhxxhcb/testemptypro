<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!--[if IE 6 ]>
<html class="ie6 lte_ie6 lte_ie7 lte_ie8 lte_ie9"> <![endif]-->
<!--[if lte IE 6 ]>
<html class="lte_ie6 lte_ie7 lte_ie8 lte_ie9"> <![endif]-->
<!--[if lte IE 7 ]>
<html class="lte_ie7 lte_ie8 lte_ie9"> <![endif]-->
<!--[if lte IE 8 ]>
<html class="lte_ie8 lte_ie9"> <![endif]-->
<!--[if lte IE 9 ]>
<html class="lte_ie9"> <![endif]-->
<!--[if (gte IE 10)|!(IE)]><!-->
<html><!--<![endif]-->
<head>
    <title>工作日志</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>
    <!--[if lte IE 8]>
    <script type="text/javascript" src="../js/ccorrect_btn.js"></script>
    <![endif]-->

    <script type="text/javascript">
        var MYOA_JS_SERVER = "";
        var MYOA_STATIC_SERVER = "";
    </script>
</head>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/diary.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.tag.css">
<link rel="stylesheet" type="text/css" href="../css/jquery.ux.calendar.css">
<link rel="stylesheet" type="text/css" href="../css/index.css">

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.ux.calendar.js"></script>
<script src="../js/wdatepicker.js"></script>
<script src="../js/attach.js"></script>
<script type="text/javascript" src="../js/js_lang.js"></script>
<script type="text/javascript" src="../js/diaryscrolltop.js"></script>
<script>
    function export_excel() {
        //document.searchForm.action = "export2.php";
        //document.searchForm.submit();
    }
    //如果从OA精灵打开，则最大化窗口
    if (window.external && typeof window.external.OA_SMS != 'undefined') {
        var h = Math.min(800, screen.availHeight - 180),
                w = Math.min(1280, screen.availWidth - 180);
        window.external.OA_SMS(w, h, "SET_SIZE");
    }
    var G_obj_diaryinfo = {
        serverTimestamp: 1491977028000,
        isMain: 0,
        fromUser: '',
        fromUserName: ''
    };
    $(document).ready(function () {
        if (jQuery && jQuery.fn.tooltip) {

        }
        $(".diary-users-toggle").click(function () {
            if ($('.diary-viewpart').is(':visible')) {
                $(".diary-viewpart").hide();
                $(".diary-viewall").show();
                $(this).html("收起");
            }
            else {
                $(".diary-viewpart").show();
                $(".diary-viewall").hide();
                $(this).html("展开");
            }
        });
        //lijun add the delegation click handler for the imgs of diary module
        $('#diarylist').delegate('.feed-txt-summary img', 'click', function () {

            var aid = $(this).attr('title');
            var aname;
            var src = $(this).attr('src').replace(/NAME=(.+)/g, function () {
                aname = arguments[1];
            });
            //window.open('/inc/image_view.php?ATTACHMENT_ID='+aid+'&ATTACHMENT_NAME='+aname+'&MODULE=diary');
            // window.open('/inc/image_view.php?MEDIA_URL='+encodeURIComponent(this.src));
        });
    })
    function sms_back() {
        var to_uid = document.getElementById("nodiary_user_id").value;
        var to_name = document.getElementById("nodiary_user_name").value;
        var top = (screen.availHeight - 340) / 2;
        var left = (screen.availWidth - 500) / 2;
        // window.open("/general/status_bar/sms_back.php?TO_UID="+ to_uid + "&TO_NAME=" + to_name + "&CONTENT=请注意提交工作日志",'','height=340,width=500,,status=0,toolbar=no,menubar=no,location=no,scrollbars=no,top='+top+',left='+left+',resizable=yes');
    }
</script>
<style>
    html, body {
        overflow: auto;
        -webkit-overflow-scrolling: touch;
    }

    @media only screen
    and (min-device-width: 768px)
    and (max-device-width: 1024px) {
        html, body {
            height: 100%;
        }
    }
</style>
</head>

<div id="pageloading" style="display: none;">正在加载...</div>
<div id="submiting" style="display: none;">正在提交...</div>
<div id="shareModal" class="modal hide" tabindex="-1" role="dialog" aria-labelledby="shareModal" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="shareModalLabel">共享</h3>
    </div>
    <div class="modal-body">
        <form name="shareform">
            <div id="share-group" class="control-group">
                <div class="share-control pull-right">
                    <button type="button" id="share-plus" class="btn btn-mini"><i class="icon-plus"></i></button>
                    <button type="button" id="share-trash" class="btn btn-mini"><i class="icon-trash"></i></button>
                </div>
                <label class="control-label"><b>人员</b></label>

                <div class="controls">
                    <div id="share-tags"></div>
                    <input type="hidden" id="sharename" name="sharename"/>
                    <input type="hidden" id="sharetext" name="sharetext"/>
                </div>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button id="shareSubmit" class="btn btn-primary">确定</button>
        <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
    </div>
</div>

<div class="wrapper">
    <div class="container">
        <div class="holder-40"></div>
        <div class="row">
            <!-- 显示日志-->
            <div class="span9">
                <div class="row">
                    <div class="span3">
                        <button class="btn btn-info btn-large" type="button" onclick="location='default.html'">
                            写日志
                        </button>
                    </div>
                    <div id="diary-type-switcher" class="span6">
                        <div class="btn-group pull-right">
                            <button data-diary-type="all" class="btn" type="button">看所有人的</button>
                            <button data-diary-type="mine" class="btn active btn-primary" type="button">看自己的</button>
                            <button data-diary-type="others" class="btn" type="button">看其他人的</button>
                        </div>
                    </div>
                </div>
                <!--<iframe src="mine.html" style="width: 100% ; height: 500px;"></iframe>-->
                <div id="diary-user-tip">
                    <div class="diary-dept-time">
                    </div>
                    <div class="diary-users">
                        <span class="diary-viewpart"></span>
                        <span class="diary-viewall"></span><span id="count"></span>人无动态
                    </div>
                    <span class="diary-msg">
                        <a class="diary-users-toggle" href="javascript:void(0)"></a>
                        <a class="diary-send-msg" href="javascript:sms_back();">发微讯</a>
                    </span>
                    <input type="hidden" id="nodiary_user_id">
                    <input type="hidden" id="nodiary_user_name">
                </div>


                <div id="diarylist" class="feedlist">
                    <div class="feed  feed-text" id="diary-feed-213" data-diary-id="213">
                        <div class="feed-avatar">
                            <div class="blog-info">
                                <a target="_blank" href="../ipanel/user/user_info.php?USER_ID=admin&amp;WINDOW=1"
                                   data-avatar="/inc/attach_old.php?ATTACHMENT_ID=avatar&amp;ATTACHMENT_NAME=1.jpg&amp;DIRECT_VIEW=1&amp;r=29748"
                                   td-user-id="admin" title="系统管理员" class="blog-avatar" hidefocus="hidefocus"> <img
                                        src="../img/1.jpg"> 系统管理员 </a>
                            </div>
                        </div>
                        <div class="feed-content-holder pop">
                            <div class="ui-poptip-arrow ui-poptip-arrow-10">
                                <em>◆</em>
                                <span>◆</span>
                            </div>
                            <div class="feed-container-top">
                            </div>
                            <div class="pop-content clearfix">
                                <div class="feed-hd">
                                    <div class="feed-time" title="2017-03-30" data-timestamp="1490839844">
                                        3月30日 10:10
                                    </div>
                                    <div class="feed-basic">
                                        <a target="_blank"
                                           href="../ipanel/user/user_info.php?USER_ID=admin&amp;WINDOW=1"
                                           class="feed-user" hidefocus="hidefocus"> 系统管理员 </a>
                                        <span class="feed-dept" title="北方测试研究公司"> 北方测试研究公司 </span>
                                        <span class="feed-priv"> OA 管理员 </span>
                                        <span class="feed-type">工作日志</span>
                                    </div>
                                </div>
                                <div class="feed-bd">
                                    <h4 class="feed-title"><a target="_blank"
                                                              href="show_diary.php?dia_id=213&amp;diary_copy_time=">2017-03-30
                                        周四 日志</a></h4>

                                    <div class="feed-ct">
                                        <div class="feed-txt-full rich-content">
                                            <div class="feed-txt-summary">
                                                哟哟哟
                                            </div>
                                            <div class="feed-txt-more">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="feed-attachments">
                                    </div>
                                    <div class="feed-act">
                                        <!--<a _tmplitem="1"  href="#">赞</a>-->
                                        <a href="javascript:void(0)" data-cmd="readers" hidefocus="hidefocus">浏览</a>
                                        <a href="javascript:void(0)" data-cmd="addtop" hidefocus="hidefocus">置顶</a>
                                        <a href="javascript:void(0)" data-cmd="del" hidefocus="hidefocus">删除</a>
                                        <a href="new/edit.php?dia_id=213&amp;IS_MAIN=1" data-cmd="edit"
                                           hidefocus="hidefocus">编辑</a>
                                        <a href="javascript:void(0)" data-cmd="share" hidefocus="hidefocus">共享</a>
                                        <a href="javascript:void(0)" data-cmd="reply" hidefocus="hidefocus"
                                           data-cmt-count="0">评论(0)</a>
                                    </div>
                                </div>
                            </div>
                            <div class="feed-ft J_FeedFooter ui-poptip-container" style="display:none">
                                <div class="ui-poptip-arrow ui-poptip-arrow-11">
                                    <em>◆</em>
                                    <span>◆</span>
                                </div>
                            </div>
                            <div class="feed-ext-body">
                                <div class="feed-ext-add-comment">
                                    <form target="" action="" name="feed-comment-form">
                                        <div class="feed-ext-add-comment-to"></div>
                                        <textarea name="TD_HTML_EDITOR_feed-submit-cmt-context-213"
                                                  class="feed-submit-cmt-context"></textarea>
                                        <button type="button" data-cmd="replySubmit" data-loading-text="提交中..."
                                                class="btn btn-primary feed-submit-cmt-btn">提交
                                        </button>
                                        <input type="hidden" name="comment-to" value=""/>
                                        <input type="hidden" name="comment-id" value=""/>
                                        <input type="hidden" name="comment-type" value=""/>
                                        <input type="hidden" name="diary-id" value="213"/>

                                        <div class="feed-ext-comment-sms-op"></div>
                                        <div class="feed-ext-comment-sms-advcomment">
                                            <label> <input type="checkbox" name="advcomment" class="advcomment"/>高级评论
                                            </label>
                                        </div>
                                    </form>
                                </div>
                                <ul class="feed-ext-list">
                                </ul>
                            </div>
                            <div class="feed-ext-body-readers">
                                <div class="feed-ext-readers">
                                </div>
                            </div>
                            <div class="feed-container-bottom">
                            </div>
                            <div class="post-flag-panel">
                            </div>
                        </div>
                    </div>
                    <div class="feed  feed-text" id="diary-feed-212" data-diary-id="212">
                        <div class="feed-avatar">
                            <div class="blog-info">
                                <a target="_blank" href="../ipanel/user/user_info.php?USER_ID=admin&amp;WINDOW=1"
                                   data-avatar="/inc/attach_old.php?ATTACHMENT_ID=avatar&amp;ATTACHMENT_NAME=1.jpg&amp;DIRECT_VIEW=1&amp;r=20910"
                                   td-user-id="admin" title="系统管理员" class="blog-avatar" hidefocus="hidefocus"> <img
                                        src="../img/1.jpg"> 系统管理员 </a>
                            </div>
                        </div>
                        <div class="feed-content-holder pop">
                            <div class="ui-poptip-arrow ui-poptip-arrow-10">
                                <em>◆</em>
                                <span>◆</span>
                            </div>
                            <div class="feed-container-top">
                            </div>
                            <div class="pop-content clearfix">
                                <div class="feed-hd">
                                    <div class="feed-time" title="2017-03-09" data-timestamp="1490337453">
                                        3月24日 14:37
                                    </div>
                                    <div class="feed-basic">
                                        <a target="_blank"
                                           href="../ipanel/user/user_info.php?USER_ID=admin&amp;WINDOW=1"
                                           class="feed-user" hidefocus="hidefocus"> 系统管理员 </a>
                                        <span class="feed-dept" title="北方测试研究公司"> 北方测试研究公司 </span>
                                        <span class="feed-priv"> OA 管理员 </span>
                                        <span class="feed-type">工作日志</span>
                                    </div>
                                </div>
                                <div class="feed-bd">
                                    <h4 class="feed-title"><a target="_blank"
                                                              href="show_diary.php?dia_id=212&amp;diary_copy_time=">2017-03-09
                                        星期四 工作日志</a></h4>

                                    <div class="feed-ct">
                                        <div class="feed-txt-full rich-content">
                                            <div class="feed-txt-summary">
                                                体育局C
                                            </div>
                                            <div class="feed-txt-more">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="feed-attachments">
                                    </div>
                                    <div class="feed-act">
                                        <!--<a _tmplitem="2"  href="#">赞</a>-->
                                        <a href="javascript:void(0)" data-cmd="readers" hidefocus="hidefocus">浏览</a>
                                        <a href="javascript:void(0)" data-cmd="addtop" hidefocus="hidefocus">置顶</a>
                                        <a href="javascript:void(0)" data-cmd="del" hidefocus="hidefocus">删除</a>
                                        <a href="new/edit.php?dia_id=212&amp;IS_MAIN=1" data-cmd="edit"
                                           hidefocus="hidefocus">编辑</a>
                                        <a href="javascript:void(0)" data-cmd="share" hidefocus="hidefocus">共享</a>
                                        <a href="javascript:void(0)" data-cmd="reply" hidefocus="hidefocus"
                                           data-cmt-count="0">评论(0)</a>
                                    </div>
                                </div>
                            </div>
                            <div class="feed-ft J_FeedFooter ui-poptip-container" style="display:none">
                                <div class="ui-poptip-arrow ui-poptip-arrow-11">
                                    <em>◆</em>
                                    <span>◆</span>
                                </div>
                            </div>
                            <div class="feed-ext-body">
                                <div class="feed-ext-add-comment">
                                    <form target="" action="" name="feed-comment-form">
                                        <div class="feed-ext-add-comment-to"></div>
                                        <textarea name="TD_HTML_EDITOR_feed-submit-cmt-context-212"
                                                  class="feed-submit-cmt-context"></textarea>
                                        <button type="button" data-cmd="replySubmit" data-loading-text="提交中..."
                                                class="btn btn-primary feed-submit-cmt-btn">提交
                                        </button>
                                        <input type="hidden" name="comment-to" value=""/>
                                        <input type="hidden" name="comment-id" value=""/>
                                        <input type="hidden" name="comment-type" value=""/>
                                        <input type="hidden" name="diary-id" value="212"/>

                                        <div class="feed-ext-comment-sms-op"></div>
                                        <div class="feed-ext-comment-sms-advcomment">
                                            <label> <input type="checkbox" name="advcomment" class="advcomment"/>高级评论
                                            </label>
                                        </div>
                                    </form>
                                </div>
                                <ul class="feed-ext-list">
                                </ul>
                            </div>
                            <div class="feed-ext-body-readers">
                                <div class="feed-ext-readers">
                                </div>
                            </div>
                            <div class="feed-container-bottom">
                            </div>
                            <div class="post-flag-panel">
                            </div>
                        </div>
                    </div>

                    <div class="feed  feed-text" id="diary-feed-211" data-diary-id="211">
                        <div class="feed-avatar">
                            <div class="blog-info">
                                <a target="_blank" href="../ipanel/user/user_info.php?USER_ID=admin&amp;WINDOW=1"
                                   data-avatar="/inc/attach_old.php?ATTACHMENT_ID=avatar&amp;ATTACHMENT_NAME=1.jpg&amp;DIRECT_VIEW=1&amp;r=13410"
                                   td-user-id="admin" title="系统管理员" class="blog-avatar" hidefocus="hidefocus"><img
                                        src="../img/1.jpg"> 系统管理员 </a>
                            </div>
                        </div>
                        <div class="feed-content-holder pop">
                            <div class="ui-poptip-arrow ui-poptip-arrow-10">
                                <em>◆</em>
                                <span>◆</span>
                            </div>
                            <div class="feed-container-top">
                            </div>
                            <div class="pop-content clearfix">
                                <div class="feed-hd">
                                    <div class="feed-time" title="2017-03-09" data-timestamp="1489036475">
                                        3月9日 13:14
                                    </div>
                                    <div class="feed-basic">
                                        <a target="_blank"
                                           href="../ipanel/user/user_info.php?USER_ID=admin&amp;WINDOW=1"
                                           class="feed-user" hidefocus="hidefocus"> 系统管理员 </a>
                                        <span class="feed-dept" title="北方测试研究公司"> 北方测试研究公司 </span>
                                        <span class="feed-priv"> OA 管理员 </span>
                                        <span class="feed-type">工作日志</span>
                                    </div>
                                </div>
                                <div class="feed-bd">
                                    <h4 class="feed-title"><a target="_blank"
                                                              href="show_diary.php?dia_id=211&amp;diary_copy_time=">2017-03-07
                                        星期二 工作日志</a></h4>

                                    <div class="feed-ct">
                                        <div class="feed-txt-full rich-content">
                                            <div class="feed-txt-summary">
                                                阿然
                                            </div>
                                            <div class="feed-txt-more">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="feed-attachments">
                                        <span class="attach_link attach_link_block" onmouseover="showMenu(this.id);"
                                              id="attach_45ca90ed" style="white-space: inherit;"><img
                                                src="/static/../img/file_type/png.gif" align="absmiddle"/> <a
                                                class="attach_name"
                                                href="/inc/attach.php?AID=3691&amp;MODULE=diary&amp;YM=1703&amp;ATTACHMENT_ID=1170903277&amp;ATTACHMENT_NAME=20170307170602.png">20170307170602.png</a></span>

                                        <div id="attach_45ca90ed_menu" class="attach_div" title="20170307170602.png">
                                            <a href="/inc/attach.php?AID=3691&amp;MODULE=diary&amp;YM=1703&amp;ATTACHMENT_ID=1170903277&amp;ATTACHMENT_NAME=20170307170602.png">下载</a>
                                            <a href="javascript:;" data-group="45ca90ed"
                                               data-url="%2Finc%2Fattach.php%3FAID%3D3691%26MODULE%3Ddiary%26YM%3D1703%26ATTACHMENT_ID%3D1170903277%26ATTACHMENT_NAME%3D20170307170602.png"
                                               onclick="ShowImageGallery(this)">播放</a>
                                            <a href="javascript:;"
                                               onclick="SaveFile('diary,3691@1703_1170903277','20170307170602.png');">转存</a>
                                        </div>
                                    </div>
                                    <div class="feed-act">
                                        <!--<a _tmplitem="3"  href="#">赞</a>-->
                                        <a href="javascript:void(0)" data-cmd="readers" hidefocus="hidefocus">浏览</a>
                                        <a href="javascript:void(0)" data-cmd="addtop" hidefocus="hidefocus">置顶</a>
                                        <a href="javascript:void(0)" data-cmd="del" hidefocus="hidefocus">删除</a>
                                        <a href="new/edit.php?dia_id=211&amp;IS_MAIN=1" data-cmd="edit"
                                           hidefocus="hidefocus">编辑</a>
                                        <a href="javascript:void(0)" data-cmd="share" hidefocus="hidefocus">共享</a>
                                        <a href="javascript:void(0)" data-cmd="reply" hidefocus="hidefocus"
                                           data-cmt-count="0">评论(0)</a>
                                    </div>
                                </div>
                            </div>
                            <div class="feed-ft J_FeedFooter ui-poptip-container" style="display:none">
                                <div class="ui-poptip-arrow ui-poptip-arrow-11">
                                    <em>◆</em>
                                    <span>◆</span>
                                </div>
                            </div>
                            <div class="feed-ext-body">
                                <div class="feed-ext-add-comment">
                                    <form target="" action="" name="feed-comment-form">
                                        <div class="feed-ext-add-comment-to"></div>
                                        <textarea name="TD_HTML_EDITOR_feed-submit-cmt-context-211"
                                                  class="feed-submit-cmt-context"></textarea>
                                        <button type="button" data-cmd="replySubmit" data-loading-text="提交中..."
                                                class="btn btn-primary feed-submit-cmt-btn">提交
                                        </button>
                                        <input type="hidden" name="comment-to" value=""/>
                                        <input type="hidden" name="comment-id" value=""/>
                                        <input type="hidden" name="comment-type" value=""/>
                                        <input type="hidden" name="diary-id" value="211"/>

                                        <div class="feed-ext-comment-sms-op"></div>
                                        <div class="feed-ext-comment-sms-advcomment">
                                            <label> <input type="checkbox" name="advcomment" class="advcomment"/>高级评论
                                            </label>
                                        </div>
                                    </form>
                                </div>
                                <ul class="feed-ext-list">
                                </ul>
                            </div>
                            <div class="feed-ext-body-readers">
                                <div class="feed-ext-readers">
                                </div>
                            </div>
                            <div class="feed-container-bottom">
                            </div>
                            <div class="post-flag-panel">
                            </div>
                        </div>
                    </div>
                    <div class="feed  feed-text" id="diary-feed-210" data-diary-id="210">
                        <div class="feed-avatar">
                            <div class="blog-info">
                                <a target="_blank" href="../ipanel/user/user_info.php?USER_ID=admin&amp;WINDOW=1"
                                   data-avatar="/inc/attach_old.php?ATTACHMENT_ID=avatar&amp;ATTACHMENT_NAME=1.jpg&amp;DIRECT_VIEW=1&amp;r=12299"
                                   td-user-id="admin" title="系统管理员" class="blog-avatar" hidefocus="hidefocus"> <img
                                        src="../img/1.jpg">系统管理员 </a>
                            </div>
                        </div>
                        <div class="feed-content-holder pop">
                            <div class="ui-poptip-arrow ui-poptip-arrow-10">
                                <em>◆</em>
                                <span>◆</span>
                            </div>
                            <div class="feed-container-top">
                            </div>
                            <div class="pop-content clearfix">
                                <div class="feed-hd">
                                    <div class="feed-time" title="2017-03-09" data-timestamp="1489036428">
                                        3月9日 13:13
                                    </div>
                                    <div class="feed-basic">
                                        <a target="_blank"
                                           href="../ipanel/user/user_info.php?USER_ID=admin&amp;WINDOW=1"
                                           class="feed-user" hidefocus="hidefocus"> 系统管理员 </a>
                                        <span class="feed-dept" title="北方测试研究公司"> 北方测试研究公司 </span>
                                        <span class="feed-priv"> OA 管理员 </span>
                                        <span class="feed-type">个人日志</span>
                                    </div>
                                </div>
                                <div class="feed-bd">
                                    <h4 class="feed-title"><a target="_blank"
                                                              href="show_diary.php?dia_id=210&amp;diary_copy_time=">2017-03-07
                                        星期二 工作日志</a></h4>

                                    <div class="feed-ct">
                                        <div class="feed-txt-full rich-content">
                                            <div class="feed-txt-summary">
                                                Gakki《冰血暴》第三季首支预告片释出！Ewan McGregor饰演的双胞胎中的弟弟和Carrie Coon亮相！北京时间4月20日早开播。
                                            </div>
                                            <div class="feed-txt-more">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="feed-attachments">
                                        <span class="attach_link attach_link_block" onmouseover="showMenu(this.id);"
                                              id="attach_83d5ecd5" style="white-space: inherit;"><img
                                                src="/static/../img/file_type/png.gif" align="absmiddle"/> <a
                                                class="attach_name"
                                                href="/inc/attach.php?AID=3690&amp;MODULE=diary&amp;YM=1703&amp;ATTACHMENT_ID=-2083132203&amp;ATTACHMENT_NAME=20170307170318.png">20170307170318.png</a></span>

                                        <div id="attach_83d5ecd5_menu" class="attach_div" title="20170307170318.png">
                                            <a href="/inc/attach.php?AID=3690&amp;MODULE=diary&amp;YM=1703&amp;ATTACHMENT_ID=-2083132203&amp;ATTACHMENT_NAME=20170307170318.png">下载</a>
                                            <a href="javascript:;" data-group="83d5ecd5"
                                               data-url="%2Finc%2Fattach.php%3FAID%3D3690%26MODULE%3Ddiary%26YM%3D1703%26ATTACHMENT_ID%3D-2083132203%26ATTACHMENT_NAME%3D20170307170318.png"
                                               onclick="ShowImageGallery(this)">播放</a>
                                            <a href="javascript:;"
                                               onclick="SaveFile('diary,3690@1703_-2083132203','20170307170318.png');">转存</a>
                                        </div>
                                    </div>
                                    <div class="feed-act">
                                        <!--<a _tmplitem="4"  href="#">赞</a>-->
                                        <a href="javascript:void(0)" data-cmd="readers" hidefocus="hidefocus">浏览</a>
                                        <a href="javascript:void(0)" data-cmd="addtop" hidefocus="hidefocus">置顶</a>
                                        <a href="javascript:void(0)" data-cmd="del" hidefocus="hidefocus">删除</a>
                                        <a href="new/edit.php?dia_id=210&amp;IS_MAIN=1" data-cmd="edit"
                                           hidefocus="hidefocus">编辑</a>
                                        <a href="javascript:void(0)" data-cmd="reply" hidefocus="hidefocus"
                                           data-cmt-count="0">评论(0)</a>
                                    </div>
                                </div>
                            </div>
                            <div class="feed-ft J_FeedFooter ui-poptip-container" style="display:none">
                                <div class="ui-poptip-arrow ui-poptip-arrow-11">
                                    <em>◆</em>
                                    <span>◆</span>
                                </div>
                            </div>
                            <div class="feed-ext-body">
                                <div class="feed-ext-add-comment">
                                    <form target="" action="" name="feed-comment-form">
                                        <div class="feed-ext-add-comment-to"></div>
                                        <textarea name="TD_HTML_EDITOR_feed-submit-cmt-context-210"
                                                  class="feed-submit-cmt-context"></textarea>
                                        <button type="button" data-cmd="replySubmit" data-loading-text="提交中..."
                                                class="btn btn-primary feed-submit-cmt-btn">提交
                                        </button>
                                        <input type="hidden" name="comment-to" value=""/>
                                        <input type="hidden" name="comment-id" value=""/>
                                        <input type="hidden" name="comment-type" value=""/>
                                        <input type="hidden" name="diary-id" value="210"/>

                                        <div class="feed-ext-comment-sms-op"></div>
                                        <div class="feed-ext-comment-sms-advcomment">
                                            <label> <input type="checkbox" name="advcomment" class="advcomment"/>高级评论
                                            </label>
                                        </div>
                                    </form>
                                </div>
                                <ul class="feed-ext-list">
                                </ul>
                            </div>
                            <div class="feed-ext-body-readers">
                                <div class="feed-ext-readers">
                                </div>
                            </div>
                            <div class="feed-container-bottom">
                            </div>
                            <div class="post-flag-panel">
                            </div>
                        </div>
                    </div>

                </div>
                <div id="diary-pagination" class="pagination pull-right">
                </div>
            </div>
            <!-- 右侧日历部分-->
            <div class="span3">
                <div class="diary-main-panel">
                    <h3 class="diary-user-name">系统管理员</h3>
                    <ul class="diary-types-box clearfix">
                        <li data-type="all">
                            <div class="diary-types-counter">194</div>
                            <div class="diary-types-title">全部日志</div>
                        </li>
                        <li data-type="mine">
                            <div class="diary-types-counter">159</div>
                            <div class="diary-types-title">我的日志</div>
                        </li>
                        <li data-type="others">
                            <div class="diary-types-counter">35</div>
                            <div class="diary-types-title">他人日志</div>
                        </li>
                    </ul>
                    <div class="diary-calendar-wrapper">
                        <div id="diary-calendar" class="dot-loading">
                        </div>
                        <div id="diary-date-result"></div>
                    </div>
                    <div id="diary-search-box">
                        <form class="form-search" name="searchForm">
                            <i class="icon-search"></i>
                            <input id="diary-search-query" class="diary-search-query" type="text"
                                   hidefocus="hidefocus"/>
                            <a href="javascript:void(0)" class="adv-search-handler" data-placement="bottom"
                               data-toggle="tooltip" title="高级搜索"><i class="icon-chevron-down"></i></a>

                            <div id="diary-adv-search-box" class="diary-adv-search-box">
                                <div class="control-group">
                                    <div class="controls pull-right">
                                        <a class="date-quicklink" data-cmd="recent3day"
                                           href="javascript:void(0)">三天内</a>
                                        <a class="date-quicklink" data-cmd="recent1week"
                                           href="javascript:void(0)">本周</a>
                                        <a class="date-quicklink" data-cmd="recent1month"
                                           href="javascript:void(0)">本月</a>
                                    </div>
                                    <label class="control-label" for="input01"><b>日期</b></label>

                                    <div class="controls">
                                        <input type="text" id="startdate" name="startdate" placeholder="起始日期"
                                               class="input-mini " onclick="WdatePicker({dateFmt:'yyyy-M-d'})">
                                        至 <input type="text" id="enddate" name="enddate" placeholder="结束日期"
                                                 class="input-mini " onclick="WdatePicker({dateFmt:'yyyy-M-d'})">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label"><b>范围</b></label>

                                    <div class="controls">
                                        <select id="diarytype" class="input-medium " name="diarytype">
                                            <option value="all">所有的</option>
                                            <option value="mine">我自己的</option>
                                            <option value="shared">共享给我的</option>
                                            <option value="permission">有权限查看的</option>
                                        </select>
                                    </div>

                                </div>
                                <div id="dept-group" class="control-group">
                                    <!-- Text input-->
                                    <div class="dept-control pull-right">
                                        <button type="button" id="dept-plus" class="btn btn-mini"><i
                                                class="icon-plus"></i></button>
                                        <button type="button" id="dept-trash" class="btn btn-mini"><i
                                                class="icon-trash"></i></button>
                                    </div>
                                    <label class="control-label"><b>部门</b></label>

                                    <div class="controls">
                                        <div id="dept-tags"></div>
                                        <input type="hidden" id="deptname" name="deptname"/>
                                        <input type="hidden" id="depttext" name="depttext"/>
                                    </div>
                                </div>

                                <div id="role-group" class="control-group">
                                    <!-- Text input-->
                                    <div class="role-control pull-right">
                                        <button type="button" id="role-plus" class="btn btn-mini"><i
                                                class="icon-plus"></i></button>
                                        <button type="button" id="role-trash" class="btn btn-mini"><i
                                                class="icon-trash"></i></button>
                                    </div>
                                    <label class="control-label"><b>角色</b></label>

                                    <div class="controls">
                                        <div id="role-tags"></div>
                                        <input type="hidden" id="rolename" name="rolename"/>
                                        <input type="hidden" id="roletext" name="roletext"/>
                                    </div>
                                </div>
                                <div id="user-group" class="control-group">
                                    <!-- Text input-->
                                    <div class="user-control pull-right">
                                        <button type="button" id="user-plus" class="btn btn-mini"><i
                                                class="icon-plus"></i></button>
                                        <button type="button" id="user-trash" class="btn btn-mini"><i
                                                class="icon-trash"></i></button>
                                    </div>
                                    <label class="control-label"><b>人员</b></label>

                                    <div class="controls">
                                        <div id="user-tags"></div>
                                        <input type="hidden" id="username" name="username"/>
                                        <input type="hidden" id="usertext" name="usertext"/>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <!-- Select Basic -->
                                    <label class="control-label"><b>日志表</b></label>

                                    <div class="controls">
                                        <select class="input-medium " id="diarydb" name="diarydb">
                                            <option value="">当前日志</option>

                                        </select>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <button class="btn btn-info" type="button" id="adv-search-btn"><i
                                            class="icon-search icon-white"></i>查询
                                    </button>
                                    &nbsp;&nbsp;
                                    <button class="btn btn-info" type="button" onClick="export_excel();">导出</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div style="display:none">
    <textarea id="TD_HTML_EDITOR_" name="TD_HTML_EDITOR_" rows="8" cols="60"></textarea>
    <script type="text/javascript">//<![CDATA[
    window.UEDITOR_CONFIG = {"UEDITOR_HOME_URL": "\/module\/ueditor\/"};
    //]]></script>
    <script type="text/javascript">//<![CDATA[
    window.HTML_MODEL_TYPE = '';
    //]]></script>
    <script type="text/javascript" src="../js/ueditor.config.min.js"></script>
    <script type="text/javascript" src="../js/ueditor.all.min.js"></script>
    <script type="text/javascript">//<![CDATA[
    UE.dom.domUtils.on(window, 'load', function () {
        var ue = UE.getEditor('TD_HTML_EDITOR_', {
            "initialFrameWidth": "100%",
            "initialFrameHeight": "200",
            "attachmentId": "ATTACHMENT_ID_OLD",
            "attachmentName": "ATTACHMENT_NAME_OLD",
            "lang": "zh-cn"
        });
        ue.ready(function () {
            typeof(editorLoaded) == 'function' && editorLoaded({editor: ue});
            ue.dirty = false;
            ue.on('contentChange', function () {
                ue.dirty = true;
            });
        });
    });
    //]]></script>
</div>
<script src="../js/jquery.tmpl.min.js"></script>
<script src="../js/bootstrap.paginator.min.js"></script>
<script src="../js/bootstrap.tag.js"></script>
<script src="../js/module.js"></script>
<script src="../js/index.js"></script>
</body>

<script id="cmtTmpl" type="text/x-jquery-tmpl">
<li class="feed-cmt-list-item ${type}" data-cmt-id="${id}" data-comment-to-id="${comment_id}">
    <a href="javascript:void(0);" td-user-id="${from_id}" class="feed-cmt-list-user">



</script>

<script id="feedTmpl" type="text/x-jquery-tmpl"> 
<div class="feed  feed-text" id="diary-feed-${dia_id}" data-diary-id="${dia_id}"> 
    <div class="feed-avatar"> 
        <div class="blog-info"> 
            <a target="_blank" href="../ipanel/user/user_info.php?USER_ID=${author_user_id}&WINDOW=1" data-avatar="${author_photo}"  td-user-id="${author_user_id}" 
                title="${author_user_name}"  class="blog-avatar"  hidefocus="hidefocus"> 
               <img src="../img/15541fad59614d05b356672fd15b535b.gif" />
               ${author_user_name}
            </a> 
        </div> 
    </div> 
    <div class="feed-content-holder pop"> 
        <div class="ui-poptip-arrow ui-poptip-arrow-10"> 
            <em>◆</em> 
            <span>◆</span> 
        </div>       
        <div class="feed-container-top"> 
        </div> 
        <div class="pop-content clearfix"> 
            <div class="feed-hd">
                <div class="feed-time" title="${dia_date}" data-timestamp="${dia_time}">
                    {{html formatTime(dia_time)}}
                </div>
                <div class="feed-basic"> 
                    <a target="_blank" href="../ipanel/user/user_info.php?USER_ID=${author_user_id}&WINDOW=1" class="feed-user" hidefocus='hidefocus'> 
                       ${author_user_name} 
                    </a>  
                    <span class="feed-dept" title="${author_dept_name}"> 
                       ${author_short_dept_name} 
                    </span>   
                    <span class="feed-priv"> 
                       ${author_priv_name} 
                    </span> 
                    <span class="feed-type">${dia_type}</span>                   
                </div> 
            </div> 
            <div class="feed-bd"> 
                <h4 class="feed-title"> 
                    <a target="_blank" href="${more_url}">${subject}</a>
                </h4>  
                <div class="feed-ct"> 
                    <div class="feed-txt-full rich-content"> 
                        <div class="feed-txt-summary">                                         
                            {{html content_all}} 
                        </div> 
                        <div class="feed-txt-more"> 
                        </div> 
                    </div> 
                </div>
                <div class="feed-attachments">
                    {{html attachments}}
                </div>   
                <div class="feed-act"> 
                    <!--<a href="#">赞</a>-->
                    <a href="javascript:void(0)" data-cmd="readers" hidefocus="hidefocus">浏览</a>
                    {{if top_flag == "1"}} 
                    <a href="javascript:void(0)" data-cmd="deltop"  hidefocus="hidefocus">取消置顶</a> 
                    {{else}}
                    <a href="javascript:void(0)" data-cmd="addtop"  hidefocus="hidefocus">置顶</a>
                     {{/if}} 
                    {{if del_flag == "1"}} 
                        <a href="javascript:void(0)" data-cmd="del" hidefocus="hidefocus">删除</a> 
                    {{/if}} 
                    {{if edit_flag == "1"}} 
                        <a href="new/edit.php?dia_id=${dia_id}&IS_MAIN=1" data-cmd="edit" hidefocus="hidefocus">编辑</a> 
                    {{/if}} 
                    {{if share_flag == "1"}} 
                        <a href="javascript:void(0)" data-cmd="share" hidefocus="hidefocus" >共享</a> 
                    {{/if}} 
                    {{if reply_flag == "1"}} 
                        <a href="javascript:void(0)" data-cmd="reply" hidefocus="hidefocus" data-cmt-count="${comment_count}" >评论(${comment_count})</a> 
                    {{/if}} 
                </div>             
            </div> 
       </div> 
       <div class="feed-ft J_FeedFooter ui-poptip-container" style="display:none"> 
           <div class="ui-poptip-arrow ui-poptip-arrow-11"> 
               <em>◆</em> 
               <span>◆</span> 
           </div> 
       </div> 
       <div class="feed-ext-body"> 
           <div class="feed-ext-add-comment"> 
               <form target="" action="" name="feed-comment-form"> 
                   <div class="feed-ext-add-comment-to"></div> 
                   <textarea name="TD_HTML_EDITOR_feed-submit-cmt-context-${dia_id}" class="feed-submit-cmt-context"></textarea> 
                   <button type="button" data-cmd="replySubmit" data-loading-text="提交中..." class="btn btn-primary feed-submit-cmt-btn">提交</button> 
                   <input type="hidden" name="comment-to" value="" /> 
                   <input type="hidden" name="comment-id" value="" /> 
                   <input type="hidden" name="comment-type" value="" /> 
                   <input type="hidden" name="diary-id" value="${dia_id}" /> 
                   <div class="feed-ext-comment-sms-op"></div>
                   <div class="feed-ext-comment-sms-advcomment">
                       <label>
                           <input type="checkbox" name="advcomment" class="advcomment" />高级评论                       </label>
                   </div>
               </form> 
           </div> 
           <ul class="feed-ext-list"> 
           </ul> 
       </div> 
       <div class="feed-ext-body-readers"> 
           <div class="feed-ext-readers">
           </div>
       </div>
       <div class="feed-container-bottom"> 
       </div> 
       <div class="post-flag-panel"> 
       </div> 
   </div> 
</div> 



</script>
</html>