<%--
  Created by IntelliJ IDEA.
  User: gsubo
  Date: 2017/6/3
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>=
<head>
    <title>日志详情</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../../css/workflow/work/style.css" />
    <script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/base/base.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" >
        var MYOA_JS_SERVER = "";
        var MYOA_STATIC_SERVER = "";
    </script>
</head>
<link rel="stylesheet" type="text/css" href="../../css/workflow/work/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../../css/workflow/work/diary.css">
<link rel="stylesheet" type="text/css" href="../../css/workflow/work/bootstrap.tag.css">

<%--<script src="../../js/jquery-1.9.1.js"></script>--%>
<script src="../../js/workflow/work/attach.js"></script>
<script src="../../js/workflow/work/jquery.ux.attachmenu.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<style>
    .feed-cmt-list-item{
        border-top: none;
    }
</style>

<body>
<div id="shareModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="shareModal" aria-hidden="true">
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
                <label class="control-label" ><b>人员</b></label>
                <div class="controls">
                    <div id="share-tags">  </div>
                    <input type="hidden" id="sharename" name="sharename" />
                    <input type="hidden" id="sharetext" name="sharetext" />
                </div>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button id="shareSubmit" class="btn btn-primary">确定</button>
        <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
    </div>
</div>
<div id="diary-detail-bg">	</div>
<div id="diary-fixed-box" style="display:none">
    <ul>
        <li class="prev">
            <a href="show_diary.php?dia_id=215&diary_copy_time=" class="icon-chevron-left"></a>
        </li>
    </ul>
</div>
<div id="diary-detail-container" class="container" data-diary-id="216">
    <div id="diary-detail-header">
        <a target="_blank" href="../ipanel/user/user_info.php?USER_ID=admin&WINDOW=1" class="diary-detail-title">
            <h1 class="shoutest"></h1>
        </a>
        <div class="diary-detail-ext-header">
            <span class="diary-detail-dept"> 北方测试研究公司 </span>
            <span class="diary-detail-priv"> OA 管理员 </span>
        </div>

    </div>

    <div id="diary-detail-content" class="feed">
        <div class="pop-content clearfix">
            <div class="feed-hd">
                <div class="feed-time" title=""></div>
                <div class="feed-basic">
                        <span class="feed-type">
                            工作日志                        </span>
                </div>
            </div>
            <div class="feed-bd">
                <h4 class="feed-title"></h4>
                <div class="feed-ct">
                    <div class="feed-txt-full rich-content">
                        <div class="feed-txt-summary">
                            <div class="jjl_body"></div>
                        </div>
                    </div>
                </div>
                <div class="feed-attachments">
                    <span class='attach_link attach_link_block' onmouseover='showMenu(this.id);' id="attach_f93fd4e5" style='white-space: inherit;'><img src="/static/images/file_type/png.gif" align="absmiddle"> <a class="attach_name" href="/inc/attach.php?AID=3915&MODULE=diary&YM=1705&ATTACHMENT_ID=-113257243&ATTACHMENT_NAME=20170512103353.png">20170512103353.png</a></span>
                    <div id="attach_f93fd4e5_menu" class="attach_div" title="20170512103353.png"><a href="/inc/attach.php?AID=3915&MODULE=diary&YM=1705&ATTACHMENT_ID=-113257243&ATTACHMENT_NAME=20170512103353.png">下载</a>
                        <a href="javascript:;" data-group="f93fd4e5" data-url="%2Finc%2Fattach.php%3FAID%3D3915%26MODULE%3Ddiary%26YM%3D1705%26ATTACHMENT_ID%3D-113257243%26ATTACHMENT_NAME%3D20170512103353.png" onClick="ShowImageGallery(this)">播放</a>
                        <a href="javascript:;" onClick="SaveFile('diary,3915@1705_-113257243','20170512103353.png');">转存</a>
                    </div><span class='attach_link attach_link_block' onmouseover='showMenu(this.id);' id="attach_bae766b7" style='white-space: inherit;'><img src="/static/images/file_type/jpg.gif" align="absmiddle"> <a class="attach_name" href="/inc/attach.php?AID=3916&MODULE=diary&YM=1705&ATTACHMENT_ID=-1159240009&ATTACHMENT_NAME=20170512103435.jpg">20170512103435.jpg</a></span>
                    <div id="attach_bae766b7_menu" class="attach_div" title="20170512103435.jpg"><a href="/inc/attach.php?AID=3916&MODULE=diary&YM=1705&ATTACHMENT_ID=-1159240009&ATTACHMENT_NAME=20170512103435.jpg">下载</a>
                        <a href="javascript:;" data-group="f93fd4e5" data-url="%2Finc%2Fattach.php%3FAID%3D3916%26MODULE%3Ddiary%26YM%3D1705%26ATTACHMENT_ID%3D-1159240009%26ATTACHMENT_NAME%3D20170512103435.jpg" onClick="ShowImageGallery(this)">播放</a>
                        <a href="javascript:;" onClick="SaveFile('diary,3916@1705_-1159240009','20170512103435.jpg');">转存</a>
                    </div>                    </div>
                <div class="feed-act">
                    <a href="javascript:void(0)" data-cmd="del" hidefocus="hidefocus">
                        删除                            </a>
                    <a href="new/edit.php?dia_id=216&DIARY_FROM=1&diary_copy_time=" data-cmd="edit" hidefocus="hidefocus">
                        编辑                            </a>
                    <a href="javascript:void(0)" data-cmd="addtop" hidefocus="hidefocus">
                        置顶                            </a>
                    <a href="javascript:void(0)" data-cmd="share" hidefocus="hidefocus" >共享</a>
                    <a data-cmd="reply" hidefocus="hidefocus" data-cmt-count="0">
                        评论(0)                        </a>
                </div>
            </div>
        </div>
    </div>

    <div id="footer">
        <div class="previous-page">
            <a href="show_diary.php?dia_id=215&diary_copy_time=">
                上一篇                    </a>
        </div>
    </div>
    <div class="feed-ext-detailreaders"></div>
    <div class="feed-ext-body">
        <ul class="feed-ext-list ">
        </ul>
        <div class="feed-ext-add-comment">
            <form target="" action="" name="feed-comment-form">
                <div class="feed-ext-add-comment-to">
                </div>
                <textarea name="TD_HTML_EDITOR_feed-submit-cmt-context-216" class="feed-submit-cmt-context"></textarea>
                <button type="button" data-cmd="replySubmit" class="btn btn-primary feed-submit-cmt-btn">
                    提交                    </button>
                <input type="hidden" name="comment-to" value="">
                <input type="hidden" name="comment-id" value="">
                <input type="hidden" name="comment-type" value="">
                <input type="hidden" name="diary-id" value="216">
                <div class="feed-ext-comment-sms-op">
                    <label class='sms-remind-label'><input type="checkbox" name="SMS_REMIND" id="SMS_REMIND" checked>发送事务提醒消息</label>                    </div>
                <div class="feed-ext-comment-sms-advcomment">
                    <label>
                        <input type="checkbox" name="advcomment" class="advcomment" />高级评论
                    </label>
                </div>
            </form>
        </div>

    </div>
</div>
<div style="display:none">
    <textarea id="TD_HTML_EDITOR_" name="TD_HTML_EDITOR_" rows="8" cols="60"></textarea>
    <script type="text/javascript">
    window.UEDITOR_CONFIG={"UEDITOR_HOME_URL":"\/module\/ueditor\/"};
    </script>
    <script type="text/javascript">
    window.HTML_MODEL_TYPE='';
   </script>
    <script type="text/javascript" src="../../js/workflow/work/ueditor.config.min.js"></script>
    <%--<script type="text/javascript" src="../../js/workflow/work/ueditor.all.min.js"></script>--%>
    <script type="text/javascript">
    UE.dom.domUtils.on(window, 'load', function(){var ue = UE.getEditor('TD_HTML_EDITOR_', {"initialFrameWidth":"100%","initialFrameHeight":"200","attachmentId":"ATTACHMENT_ID_OLD","attachmentName":"ATTACHMENT_NAME_OLD","lang":"zh-cn"});ue.ready(function(){typeof(editorLoaded) == 'function' && editorLoaded({editor:ue});ue.dirty = false;ue.on('contentChange',function(){ue.dirty = true;});});});
   ></script>
</div>
</body>

<script src="../../js/workflow/work/jquery.tmpl.min.js"></script>
<script src="../../js/bootstrap.tag.js"></script>
<script src="../../js/workflow/work/module.js"></script>
<script id="cmtTmpl" type="text/x-jquery-tmpl">
<li class="feed-cmt-list-item  >
    <a href="javascript:void(0); class="feed-cmt-list-user"></a>

        回复<a href="javascript:void(0);"  hidefocus="hidefocus" class="feed-cmt-list-user"></a>

    <div class="feed-cmt-list-ext">

        <a class="feed-cmt-del-handle" href="javascript:void(0);" hidefocus="hidefocus">删除</a>

        <a class="feed-cmt-reply-handle"  href="javascript:void(0);" hidefocus="hidefocus">回复</a>

        <span class="feed-cmt-list-time"  ></span>
    </div>
    <div class="feed-cmt-content"></div>
    <div class="feed-cmt-attachments"></div>
</li>
</script>

<script src="../../js/workflow/work/GM.js"></script>
<script>
    $(function () {

        var nid=$.getQueryString('id');

        $.ajax({
            type:'get',
            url:'../../diary/getConByDiaId',
            dataType:'json',
            data:{'diaId':nid},
            success:function(rsp){
               console.log(rsp);
               var name=rsp.object.userName;//用户
               var feed_time=rsp.object.diaTime;//顶部时间
                var feed_title=rsp.object.subject;//标题
                var jjl_body=rsp.object.content;//内容
               $('.shoutest').html(name);
               $('.feed-time').html(feed_time);
                $('.feed-title').html(feed_title);
                $('.jjl_body').html(jjl_body);


            }
        });

    }) ;
</script>
<script>
    /*(function(win, $){
        var tDiaryDetail = {
            init: function(){
                this.bindEvent();
                this.replyFeed(216);
                this.getReaders(216);
            },
            Router: {
                DelFeed: 'op_diary.php',
                ShareFeed: 'op_diary.php',
                GetReply: 'get_diary_comment.php',
                DelReply: 'op_diary_comment.php',
                GetSharelist: 'get_diary_share.php',
                SubmitComment: 'op_diary_comment.php',
                GetReaders: 'get_diary_readers.php',
                GetTOP: 'get_diary_top.php'
            },
            bindEvent: function(){
                var self = this;
                $('#diary-detail-container').on('click.diarycmd', '[data-cmd]', function(){
                    var $this = $(this),
                        $panel = $this.parents('[data-diary-id]').first(),
                        diaryId = $panel.attr('data-diary-id'),
                        cmd = $this.attr('data-cmd');

                    switch(cmd){
                        case 'replyComment':
                            self.replyComment(diaryId, $this.attr('data-cmt-id'), $this.attr('data-to-id'), $this.attr('data-to-text'), 'sub')
                            break;
                        case 'replySubmit':
                            self.submitReply(diaryId);
                            break;
                        case 'delReply':
                            self.delReply(diaryId, $this.attr('data-cmt-id'), $this.attr('data-cmt-type'));
                            break;
                        case 'share':
                            self.share(diaryId);
                            break;
                        case 'del':
                            self.deleteFeed(diaryId);
                            break;
                        case 'addtop':
                            self.addTop(diaryId);
                            break;
                        case 'deltop':
                            self.delTop(diaryId);
                            break;
                        default:
                            break;
                    }
                });

                $('#share-plus').click(function(){
                    var module_id = 'diary',
                        to_id = "sharename",
                        to_name = "sharetext",
                        manage_flag,
                        form_name = "shareform";

                    window.org_select_callbacks = window.org_select_callbacks || {};

                    window.org_select_callbacks.add = function(item_id, item_name){
                        self.sharetags.add({ value: item_id, text: item_name });
                    };
                    window.org_select_callbacks.remove = function(item_id, item_name){
                        self.sharetags.remove(item_id);
                    };
                    window.org_select_callbacks.clear = function(){

                    };

                    SelectUser('9',module_id, to_id, to_name, manage_flag, form_name);
                    return false;
                });

                $('#share-trash').click(function(){
                    self.sharetags.clear();
                });

                $('#shareSubmit').click($.proxy(this.shareSubmit, this));


                $(".advcomment").change(function (){
                    var ischecked = $(this).prop('checked');
                    if($("#diary-detail-container").width()==720){
                        var areawidth=$(".feed-submit-cmt-context").width();
                    }
                    else{
                        console.log(0);
                    }
                    if(ischecked){
                        var $textarea = $(".feed-submit-cmt-context")[0];
                        $textarea.value = $textarea.value.replace(/\n/ig, '</br>');
                        replaceEditor($textarea,{
                            width:areawidth,
                            height:85,
                            toolbar: 'Feedback'
                        });
                        $(this).parents('.feed-ext-comment-sms-advcomment').hide();
                    }
                })
            },


            /!*replyFeed: function(id){
                var $list = $('#diary-detail-container .feed-ext-list');
                this.getReply(id, $list);
            },*!/
            getReply: function(id, $list){
                var self = this;
                $.get(this.Router.GetReply, { DIA_ID: id }, function(d){
                    $('#diary-detail-container').find('.feed-ext-comment-sms-op').html(d.sms_op);
                    if(d && typeof d.comment_data == 'object'){
                        $list.html(self.replyRender(d.comment_data));
                        $.attachmenu();
                    }
                });
            },
            getReaders: function(id){
                var self = this;
                $('.feed-ext-detailreaders').html("");
                $.get(self.Router.GetReaders, { DIA_ID: id }, function(d){
                    if(d == ""){
                        $('.feed-ext-detailreaders').html('<span>暂无人员浏览</span>');
                    }
                    else{
                        $('.feed-ext-detailreaders').html("");
                        $.each(d, function(){
                            $('.feed-ext-detailreaders').append('<span class="readersname">'+this.text+'</span>');
                        });
                        $("<span>已浏览</span>").appendTo($('.feed-ext-detailreaders'));
                    }
                });
            },
            delReply: function(dia_id, cmt_id, type){
                var self = this;
                this.confirm('删除后无法恢复，是否删除该评论?', function(){
                    $.get(self.Router.DelReply, { id: cmt_id, op: 'del', 'comment-type': type }, function(flag){
                        if(flag == 'ok'){
                            var selector = type != 'sub'
                                ? '.feed-ext-list .feed-cmt-list-item[data-cmt-id="' + cmt_id + '"]'
                                : '.feed-ext-list .feed-cmt-list-item.sub[data-cmt-id="' + cmt_id + '"]';
                            self.notify('删除成功。');

                            $('#diary-detail-container').find(selector).hide();
                            if( type != 'sub'){
                                self.setDiaryCounter(dia_id, -1);
                                $('#diary-detail-container').find('[data-comment-to-id="' + cmt_id + '"]').hide();
                            }
                        }else{
                            self.notify('删除失败。');
                        }
                    });
                });
            },

            deleteFeed: function(id){
                var self = this;
                this.confirm('删除后无法恢复，是否删除该日志?', function(){
                    $.get(self.Router.DelFeed, { diary_id: id, op: 'del' }, function(flag){
                        if(flag == 'ok'){
                            self.notify('删除成功。');
                            window.close();
                            //$('#diary-feed-' + id).remove();
                        }else{
                            self.notify('删除失败。');
                        }
                    });
                });
            },

            addTop: function(id){
                var self = this;
                $.get(self.Router.GetTOP, { diary_id: id, op: 'add' }, function(flag){
                    if(flag == 'ok'){
                        self.notify("置顶成功");
                        window.location.reload();
                    }else{
                        self.notify("置顶失败");
                    }
                });

            },

            delTop: function(id){
                var self = this;
                $.get(self.Router.GetTOP, { diary_id: id, op: 'del' }, function(flag){
                    if(flag == 'ok'){
                        self.notify("取消置顶成功");
                        window.location.reload();
                    }else{
                        self.notify("取消置顶失败");
                    }
                });

            },

            submitReply: function(id){
                var self = this,
                    $context = $('#diary-detail-container'),
                    $form = $context.find('form[name="feed-comment-form"]'),
                    data = $form.serializeArray(),
                    $button = $form.find('.feed-submit-cmt-btn');
                isHtml = $context.find("[name='advcomment']").prop('checked'),
                    context = isHtml
                        ? getEditorHtml("feed-submit-cmt-context-"+id)
                        : jQuery.trim($form.find('textarea.feed-submit-cmt-context').val()).replace(/\n/ig, "</br>");
                data.push({
                    name: 'op',
                    value: 'add'
                });
                if( context == ''){
                    return;
                }
                data.push({
                    name: 'TD_HTML_EDITOR_feed-submit-cmt-context',
                    value: context
                });

                $button.button('loading');

                $.post(self.Router.SubmitComment, data, function(ret){
                    if(ret && ret.flag == 'ok'){
                        self.setDiaryCounter(id, 1);
                        self.replyFeed(id);
                    }else{
                        self.notify('评论失败。');
                    }
                    $button.button('reset');
                    try{
                        isHtml && setHtml("feed-submit-cmt-context-"+id);
                    }catch(e){}
                    $form.find('textarea.feed-submit-cmt-context').val('');
                });

            },
            replyComment: function(diaryId, cmtId, toId, toText, cmtType){
                var $context = $('#diary-detail-container'),
                    $cmtForm = $context.find('form[name="feed-comment-form"]'),
                    $cmtTo = $cmtForm.find('.feed-ext-add-comment-to'),
                    $inputTo = $cmtForm.find('input[name="comment-to"]'),
                    $cmtId = $cmtForm.find('input[name="comment-id"]'),
                    $cmtType = $cmtForm.find('input[name="comment-type"]'),
                    $diaryId = $cmtForm.find('input[name="diary-id"]'),
                    api = $cmtTo.data('tags') || $cmtTo.tags().data('tags');

                $inputTo.val(toId);
                $cmtId.val(cmtId);
                $cmtType.val(cmtType);
                $diaryId.val(diaryId);

                api.clear();
                api.options.callbacks.remove = function(){
                    $inputTo.val('');
                    $cmtId.val('');
                    $cmtType.val('');
                };
                api.add({
                    value: toId,
                    text: '回复：' + toText
                });
            },
            setDiaryCounter: function(dia_id, n){
                var $replyCounter = $('#diary-detail-container').find('[data-cmt-count]'),
                    counter = parseInt( $replyCounter.attr('data-cmt-count') ) + n;
                $replyCounter.attr('data-cmt-count', counter);
                $replyCounter.html('评论(' + counter + ')');
            },

            share: function(id){
                $('#shareModal').modal('show');
                var self = this;
                self.sharetags = $('#share-tags').data('tags') || $('#share-tags').tags().data('tags');
                $('#share-tags').attr('data-diary-id', id);
                self.sharetags.clear();
                $.get(self.Router.GetSharelist, { diary_id: id }, function(d){
                    d = d || [];
                    var username, usertext;
                    $.each(d, function(){
                        self.sharetags.add(this);
                        username += this.value + ',';
                        usertext += this.text + ',';
                    });
                    $('#sharename').val(username);
                    $('#sharetext').val(usertext);
                });
            },
            shareSubmit: function(){
                var self = this,
                    data = $('#share-tags').data('tags').serialize();
                data['diary_id'] = $('#share-tags').attr('data-diary-id');
                data['op'] = 'share';
                $.get(self.Router.ShareFeed, data, function(flag){
                    if(flag == 'ok'){
                        self.notify('共享成功。');
                    }else{
                        self.notify('共享失败。');
                    }
                });
            },
            replyRender: function(c){
                var tmpl = $('#cmtTmpl');
                return tmpl.tmpl(c);
            },
            notify: function(c){
                alert(c);
            },
            confirm: function(txt, func){
                confirm(txt) && $.isFunction(func) && func();
            }
        };

        $(function(){
            tDiaryDetail.init();

            GM.init({
                normal_actions: {
                    L: {
                        name : "上一篇日志",
                        action : function(){
                            var $target = $('#footer .previous-page a');
                            if($target.size()){
                                win.location = $target.attr('href');
                            }
                        }
                    },
                    R: {
                        name : "下一篇日志",
                        action : function(){
                            var $target = $('#footer .next-page a');
                            if($target.size()){
                                win.location = $target.attr('href');
                            }
                        }
                    }
                }
            });

        });

    })(window, jQuery)*/
</script>
</html>

