<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
	<meta http-equiv='X-UA-Compatible' content='IE=10,chrome=1' />
	<link rel="stylesheet" type="text/css"
		  href="../css/ueditor/bootstrap.css" />
	<link rel="stylesheet" type="text/css"
		  href="../css/ueditor/cool_form.css" />
	<title>222</title>
	<script src="../js/jquery-1.10.2/jquery.min.js"></script>
	<script src="../js/ueditor/bootstrap.min.js"></script>
	<script src="../js/ueditor/sea.js"></script>
	<script>
        var form_id = "145";
        seajs.config({
            base : '/static/js/',
            alias : {
                "jquery" : "../js/jquery-1.10.2/jquery.min.js",
                "bootstrap" : "../js/ueditor/bootstrap.min.js",
                "base" : "/static/js/arale/base/1.1.1/base"
            }
        })

        var FormDesigner = {
            $event : $({}),
            on : function() {
                this.$event.on.apply(this.$event, arguments);
            },
            off : function() {
                this.$event.off.apply(this.$event, arguments);
            },
            trigger : function() {
                this.$event.trigger.apply(this.$event, arguments);
            }
        };

        FormDesigner
            .on(
                'editorLoaded',
                function(e, ue) {
                    if (ue && ue.editor) {
                        UE.utils
                            .loadFile(
                                ue.editor.document,
                                {
                                    tag : "link",
                                    rel : "stylesheet",
                                    type : "text/css",
                                    href : "../css/ueditor/form_design.css"
                                });
                        ue.editor
                            .addListener(
                                'beforeshowcontextmenu',
                                function(type, items, evt) {
                                    evt = evt || window.event;
                                    var el = evt.target
                                        || evt.srcElement;
                                    var thePlugins = GetFieldTypeByTag(el);
                                    var thePluginsName = getPluginType(el);//标准控件名称
                                    if (!thePlugins) {
                                        return;
                                    }
                                    //自定义控件名称
                                    var custom_controls = jQuery(
                                        "#custom_controls_json")
                                        .val();
                                    if (custom_controls != ""
                                        && typeof (custom_controls) != "undefined") {
                                        custom_controls = eval("("
                                            + custom_controls
                                            + ")");
                                        for ( var i = 0; i < custom_controls.length; i++) {
                                            var _class = el
                                                    .getAttribute("className")
                                                || el
                                                    .getAttribute("class");
                                            if (_class) {
                                                var control_name = 'td_'
                                                    + _class
                                                        .toLowerCase();
                                                if (custom_controls[i].PKEY == control_name) {
                                                    thePluginsName = custom_controls[i].NAME;
                                                }
                                            }

                                        }
                                    }
                                    var item = {
                                        //label: ue.editor.getLang( "contextMenu."+thePlugins),
                                        label : thePluginsName
                                        + '属性',
                                        className : '',
                                        onclick : function() {
                                            UE.plugins[thePlugins].editdom = el;
                                            ue.editor
                                                .execCommand(thePlugins);
                                        }
                                    };
                                    items.push(item);
                                    var deleteitem = {
                                        label : ue.editor
                                            .getLang("contextMenu.delete"),
                                        className : 'edui-for-delete',
                                        onclick : function() {
                                            if (window
                                                    .confirm('确认删除该控件吗？')) {
                                                UE.plugins[thePlugins].editdom = '';
                                                UE.dom.domUtils
                                                    .remove(el,
                                                        false);
                                            }
                                        }
                                    };
                                    items.push(deleteitem);
                                });
                    }
                });

        editorLoaded = function(ue) {
            FormDesigner.trigger('editorLoaded', ue);
        }
	</script>
</head>
<body>
<div id="container-scroller">
	<div id='designer'>
		<div class="menubar-container">
			<div class="menubar">
				<h1>222</h1>
				<div class="abs-right">
					<button class="btn btn-primary btn-small" onclick="send();">保存</button>
					<button class="btn btn-info btn-small" onclick="viewForm();">预览</button>
					<button class="btn btn-info btn-small" onclick="send(1);">生成版本</button>
					<button class="btn btn-danger btn-small" onclick="myclose();">关闭</button>
				</div>
			</div>
		</div>
		<div class='main-container'>
			<div class='sidebar-container'>
				<div class="widget-container">
					<div class="widget-group"
						 style="float:left; width:100px; border-right: 1px solid #cbcccc;">
						<h3 class="widget-group-title" id="standard_div"
							onclick="hideDiv(1, this);"
							style="cursor:pointer; line-height:28px;">
							<span class="icon-arrow" style="margin-left:4px;">标准控件</span>
						</h3>
					</div>
					<div class="widget-group">
						<h3 class="widget-group-title" id="custom_div"
							onclick="hideDiv(2, this);"
							style="cursor:pointer; line-height:28px; background-image:none; background-color:rgb(221, 221, 221);">
							<span class="icon-arrow" style="margin-left:7px;">扩展控件</span>
						</h3>
					</div>
				</div>
			</div>
			<div class='sidebar-container' style="margin-top:33px;">
				<div class="widget-container">
					<div class="widget-group" id="standard_controls">
						<div id="widget-group-task" class="widget-group-content">
							<ul class="widget-group-items-list">
								<li id="td_text" class="td_text" onclick="exec_cmd('td_text')"><i></i><span>单行输入框</span>
								</li>
								<li id="td_textarea" class="td_textarea"
									onclick="exec_cmd('td_textarea')"><i></i><span>多行输入框</span>
								</li>
								<li id="td_select" class="td_select"
									onclick="exec_cmd('td_select')"><i></i><span>下拉菜单</span>
								</li>
								<li id="td_radio" class="td_radio"
									onclick="exec_cmd('td_radio')"><i></i><span>单选框</span>
								</li>
								<li id="td_checkbox" class="td_checkbox"
									onclick="exec_cmd('td_checkbox')"><i></i><span>复选框</span>
								</li>
								<li id="td_listview" class="td_listview"
									onclick="exec_cmd('td_listview')"><i></i><span>列表控件</span>
								</li>
								<li id="td_macro" class="td_macro"
									onclick="exec_cmd('td_macro')"><i></i><span>宏控件</span>
								</li>
								<li id="td_calendar" class="td_calendar"
									onclick="exec_cmd('td_calendar')"><i></i><span>日历控件</span>
								</li>
								<li id="td_calc" class="td_calc" onclick="exec_cmd('td_calc')"><i></i><span>计算控件</span>
								</li>
								<li id="td_orgselect" class="td_orgselect"
									onclick="exec_cmd('td_orgselect')"><i></i><span>部门人员控件</span>
								</li>
								<li id="td_websign" class="td_websign"
									onclick="exec_cmd('td_websign')"><i></i><span>签章控件</span>
								</li>
								<li id="td_dataselection" class="td_dataselection"
									onclick="exec_cmd('td_dataselection')"><i></i><span>数据选择控件</span>
								</li>
								<li id="td_extdataselection" class="td_extdataselection"
									onclick="exec_cmd('td_extdataselection')"><i></i><span>外部数据选择控件</span>
								</li>
								<li id="td_formdataselection" class="td_formdataselection"
									onclick="exec_cmd('td_formdataselection')"><i></i><span>表单数据控件</span>
								</li>
								<li id="td_progressbar" class="td_progressbar"
									onclick="exec_cmd('td_progressbar')"><i></i><span>进度条控件</span>
								</li>
								<li id="td_imageupload" class="td_imageupload"
									onclick="exec_cmd('td_imageupload')"><i></i><span>图片上传控件</span>
								</li>
								<li id="td_fileupload" class="td_fileupload"
									onclick="exec_cmd('td_fileupload')"><i></i><span>附件上传控件</span>
								</li>
								<li id="td_qrcode" class="td_qrcode"
									onclick="exec_cmd('td_qrcode')"><i></i><span>二维码控件</span>
								</li>
								<li id="td_mobilesign" class="td_mobilesign"
									onclick="exec_cmd('td_mobilesign')"><i></i><span>移动签章控件</span>
								</li>
								<li id="td_mobilewritesign" class="td_mobilewritesign"
									onclick="exec_cmd('td_mobilewritesign')"><i></i><span>移动手写签章控件</span>
								</li>
							</ul>
						</div>
					</div>
					<div class="widget-group" id="custom_controls"
						 style="display:none;">
						<div id="widget-group-task-custom" class="widget-group-content">
							<ul class="widget-group-items-list">
								<li id="td_custom_yyaccount"
									onclick="exec_cmd('td_custom_yyaccount')"><span>用友ERP账套记账</span>
								</li>
								<li id="td_custom_kdaccount"
									onclick="exec_cmd('td_custom_kdaccount')"><span>金蝶ERP账套记账</span>
								</li>
								<li id="td_custom_wfpreview"
									onclick="exec_cmd('td_custom_wfpreview')"><span>指定工作查看控件</span>
								</li>
								<li id="td_custom_help" onclick="exec_cmd('td_custom_help')"><span>帮助控件</span>
								</li>
								<input type='hidden' id='custom_controls_json'
									   value='[ { "PKEY": "td_custom_yyaccount", "NAME": "用友ERP账套记账" }, { "PKEY": "td_custom_kdaccount", "NAME": "金蝶ERP账套记账" }, { "PKEY": "td_custom_wfpreview", "NAME": "指定工作查看控件" }, { "PKEY": "td_custom_help", "NAME": "帮助控件" } ]'>
							</ul>
						</div>
					</div>

					<!--
                <div class="widget-group">
                    <h3 class="widget-group-title" onclick="hideDiv(this);" style="cursor:pointer;">
                        <img class="custom_img" src="/static/modules/workflow/images/fold.png" style="-webkit-filter: invert(0.8); filter: invert(0.8);">
                        <span class="icon-arrow">标准控件</span>

                    </h3>
                    <div id="widget-group-task" class="widget-group-content">
                        <ul class="widget-group-items-list">
                            <li id="td_text" class="td_text" onclick="exec_cmd('td_text')"><i></i><span>单行输入框</span></li><li id="td_textarea" class="td_textarea" onclick="exec_cmd('td_textarea')"><i></i><span>多行输入框</span></li><li id="td_select" class="td_select" onclick="exec_cmd('td_select')"><i></i><span>下拉菜单</span></li><li id="td_radio" class="td_radio" onclick="exec_cmd('td_radio')"><i></i><span>单选框</span></li><li id="td_checkbox" class="td_checkbox" onclick="exec_cmd('td_checkbox')"><i></i><span>复选框</span></li><li id="td_listview" class="td_listview" onclick="exec_cmd('td_listview')"><i></i><span>列表控件</span></li><li id="td_macro" class="td_macro" onclick="exec_cmd('td_macro')"><i></i><span>宏控件</span></li><li id="td_calendar" class="td_calendar" onclick="exec_cmd('td_calendar')"><i></i><span>日历控件</span></li><li id="td_calc" class="td_calc" onclick="exec_cmd('td_calc')"><i></i><span>计算控件</span></li><li id="td_orgselect" class="td_orgselect" onclick="exec_cmd('td_orgselect')"><i></i><span>部门人员控件</span></li><li id="td_websign" class="td_websign" onclick="exec_cmd('td_websign')"><i></i><span>签章控件</span></li><li id="td_dataselection" class="td_dataselection" onclick="exec_cmd('td_dataselection')"><i></i><span>数据选择控件</span></li><li id="td_extdataselection" class="td_extdataselection" onclick="exec_cmd('td_extdataselection')"><i></i><span>外部数据选择控件</span></li><li id="td_formdataselection" class="td_formdataselection" onclick="exec_cmd('td_formdataselection')"><i></i><span>表单数据控件</span></li><li id="td_progressbar" class="td_progressbar" onclick="exec_cmd('td_progressbar')"><i></i><span>进度条控件</span></li><li id="td_imageupload" class="td_imageupload" onclick="exec_cmd('td_imageupload')"><i></i><span>图片上传控件</span></li><li id="td_fileupload" class="td_fileupload" onclick="exec_cmd('td_fileupload')"><i></i><span>附件上传控件</span></li><li id="td_qrcode" class="td_qrcode" onclick="exec_cmd('td_qrcode')"><i></i><span>二维码控件</span></li><li id="td_mobilesign" class="td_mobilesign" onclick="exec_cmd('td_mobilesign')"><i></i><span>移动签章控件</span></li><li id="td_mobilewritesign" class="td_mobilewritesign" onclick="exec_cmd('td_mobilewritesign')"><i></i><span>移动手写签章控件</span></li>
                        </ul>
                    </div>
                </div>
                                        <div class="widget-group">
                        <h3 class="widget-group-title" onclick="hideDiv(this);" style="cursor:pointer;">
                            <img class="custom_img" src="/static/modules/workflow/images/fold.png" style="-webkit-filter: invert(0.8); filter: invert(0.8);">
                            <span class="icon-arrow">扩展控件</span>
                        </h3>
                        <div id="widget-group-task-custom" class="widget-group-content">
                            <ul class="widget-group-items-list">
                                <li id="td_custom_yyaccount" onclick="exec_cmd('td_custom_yyaccount')"><i style="background-image:url(/general/system/workflow/flow_form/cool_form/custom_controls/yyaccount/image/yyaccount.png);"></i><span>用友ERP账套记账</span></li><li id="td_custom_kdaccount" onclick="exec_cmd('td_custom_kdaccount')"><i style="background-image:url(/general/system/workflow/flow_form/cool_form/custom_controls/kdaccount/image/kdaccount.png);"></i><span>金蝶ERP账套记账</span></li><li id="td_custom_wfpreview" onclick="exec_cmd('td_custom_wfpreview')"><i style="background-image:url(/general/system/workflow/flow_form/cool_form/custom_controls/wfpreview/image/wfpreview.png);"></i><span>指定工作查看控件</span></li><li id="td_custom_help" onclick="exec_cmd('td_custom_help')"><i style="background-image:url(/general/system/workflow/flow_form/cool_form/custom_controls/help/image/help.png);"></i><span>帮助控件</span></li>                                    <input type='hidden' id='custom_controls' value='[ { "PKEY": "td_custom_yyaccount", "NAME": "用友ERP账套记账" }, { "PKEY": "td_custom_kdaccount", "NAME": "金蝶ERP账套记账" }, { "PKEY": "td_custom_wfpreview", "NAME": "指定工作查看控件" }, { "PKEY": "td_custom_help", "NAME": "帮助控件" } ]'>
                            </ul>
                        </div>
                    </div>

                -->
				</div>
				<!--
            <div class="splitter-bar-horizontal"></div>
            -->
			</div>
			<!--分割栏-->
			<div class="splitter-bar-vertical"></div>
			<div class="diagram-container" style="overflow:hidden;">
				<div id="flow-editor-wrapper" class="hide">
					<form action="submit.php" method="post" name="form1">
						<textarea id="flowEditor" name="flowEditor"></textarea>
						<input type="hidden" name="TD_HTML_EDITOR_FORM_HTML_DATA"
							   id="TD_HTML_EDITOR_FORM_HTML_DATA" value=""> <input
							type="hidden" name="CLOSE_FLAG" value=""> <input
							type="hidden" name="FORM_ID" value="145">
					</form>
				</div>
				<div id="flow-ueditor-wrapper">
						<textarea id="TD_HTML_EDITOR_CONTENT"
								  name="TD_HTML_EDITOR_CONTENT" rows="8" cols="60"></textarea>
					<script type="text/javascript">
                        //
                        window.UEDITOR_CONFIG = {
                            "UEDITOR_HOME_URL" : "\/module\/ueditor\/"
                        };
                        //
					</script>
					<script type="text/javascript">
                        //
                        window.HTML_MODEL_TYPE = '';
                        //
					</script>
					<script type="text/javascript"
							src="../lib/ueditor/ueditor.config.js"></script>
					<script type="text/javascript" src="../lib/ueditor/ueditor.all.js"></script>
					<script type="text/javascript">
                        //
                        UE.dom.domUtils
                            .on(
                                window,
                                'load',
                                function() {
                                    var ue = UE
                                        .getEditor(
                                            'TD_HTML_EDITOR_CONTENT',
                                            {
                                                "initialFrameWidth" : "100%",
                                                "initialFrameHeight" : "550",
                                                "attachmentId" : "ATTACHMENT_ID_OLD",
                                                "attachmentName" : "ATTACHMENT_NAME_OLD",
                                                "toolbars" : [ [
                                                    "source",
                                                    "td_js_script",
                                                    "pasteplain",
                                                    "undo",
                                                    "redo",
                                                    "|",
                                                    "searchreplace",
                                                    "selectall",
                                                    "cleardoc",
                                                    "removeformat",
                                                    "|",
                                                    "bold",
                                                    "italic",
                                                    "underline",
                                                    "strikethrough",
                                                    "forecolor",
                                                    "backcolor",
                                                    "paragraph",
                                                    "fontfamily",
                                                    "fontsize",
                                                    "insertcode",
                                                    "insertorderedlist",
                                                    "insertunorderedlist",
                                                    "|",
                                                    "autotypeset",
                                                    "indent",
                                                    "lineheight",
                                                    "justifyleft",
                                                    "justifycenter",
                                                    "justifyright",
                                                    "justifyjustify",
                                                    "rowspacingtop",
                                                    "rowspacingbottom",
                                                    "|",
                                                    "insertimage",
                                                    "inserttable",
                                                    "link",
                                                    "unlink",
                                                    "emotion",
                                                    "template",
                                                    "|",
                                                    "horizontal",
                                                    "spechars",
                                                    "fullscreen" ] ],
                                                "lang" : "zh-cn"
                                            });
                                    ue
                                        .ready(function() {
                                            typeof (editorLoaded) == 'function'
                                            && editorLoaded({
                                                editor : ue
                                            });
                                            ue.dirty = false;
                                            ue
                                                .on(
                                                    'contentChange',
                                                    function() {
                                                        ue.dirty = true;
                                                    });
                                        });
                                });
                        //
					</script>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
    UEDITOR_CONFIG.iframeCssUrl = '/general/workflow/assets/form.css';
    UEDITOR_CONFIG.allHtmlEnabled = true;
	/*UEDITOR_CONFIG.removeFormatAttributes = '';
	 UEDITOR_CONFIG.removeFormatTags = '';*/
    UEDITOR_CONFIG.disabledTableInTable = false;
    UEDITOR_CONFIG.autoClearinitialContent = false;
    UEDITOR_CONFIG.doctypeFix = false;
    UE.jQueryAdapterMode = true;
    UEDITOR_CONFIG.elementPathEnabled = true;
    //UEDITOR_CONFIG.initialStyle = '';
    UE.plugins['td_text'] = function() {
        var me = this, thePlugins = 'td_text';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                       /*  iframeUrl : '../lib/ueditor/formdesign/text.html', */
                        iframeUrl : '../lib/ueditor/formdesign/text.html', 
                        name : thePlugins,
                        editor : this,
                        title : '单行输入框',
                        cssRules : "width:270px;height:320px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_textarea'] = function() {
        var me = this, thePlugins = 'td_textarea';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/textarea/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '多行输入框',
                        cssRules : "width:310px;height:300px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>多行输入框: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_select'] = function() {
        var me = this, thePlugins = 'td_select';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/select/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '下拉菜单',
                        cssRules : "width:490px;height:310px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>下拉菜单: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_radio'] = function() {
        var me = this, thePlugins = 'td_radio';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/radio/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '单选框',
                        cssRules : "width:380px;height:340px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>单选框: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_checkbox'] = function() {
        var me = this, thePlugins = 'td_checkbox';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/checkbox/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '复选框',
                        cssRules : "width:390px;height:210px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>复选框: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_listview'] = function() {
        var me = this, thePlugins = 'td_listview';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/listview/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '列表控件',
                        cssRules : "width:960px;height:425px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>列表控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_macro'] = function() {
        var me = this, thePlugins = 'td_macro';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/macro/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '宏控件',
                        cssRules : "width:390px;height:250px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>宏控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_calendar'] = function() {
        var me = this, thePlugins = 'td_calendar';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/calendar/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '日历控件',
                        cssRules : "width:390px;height:230px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>日历控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_calc'] = function() {
        var me = this, thePlugins = 'td_calc';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/calc/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '计算控件',
                        cssRules : "width:390px;height:310px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>计算控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_orgselect'] = function() {
        var me = this, thePlugins = 'td_orgselect';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/orgselect/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '部门人员控件',
                        cssRules : "width:390px;height:210px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>部门人员控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_websign'] = function() {
        var me = this, thePlugins = 'td_websign';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/websign/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '签章控件',
                        cssRules : "width:390px;height:260px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>签章控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_dataselection'] = function() {
        var me = this, thePlugins = 'td_dataselection';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/dataselection/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '数据选择控件',
                        cssRules : "width:510px;height:350px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>数据选择控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_extdataselection'] = function() {
        var me = this, thePlugins = 'td_extdataselection';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/extdataselection/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '外部数据选择控件',
                        cssRules : "width:510px;height:350px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>外部数据选择控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_formdataselection'] = function() {
        var me = this, thePlugins = 'td_formdataselection';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/formdataselection/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '表单数据控件',
                        cssRules : "width:510px;height:350px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>表单数据控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_progressbar'] = function() {
        var me = this, thePlugins = 'td_progressbar';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/progressbar/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '进度条控件',
                        cssRules : "width:390px;height:210px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>进度条控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_imageupload'] = function() {
        var me = this, thePlugins = 'td_imageupload';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/imageupload/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '图片上传控件',
                        cssRules : "width:390px;height:210px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>图片上传控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_fileupload'] = function() {
        var me = this, thePlugins = 'td_fileupload';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/fileupload/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '附件上传控件',
                        cssRules : "width:390px;height:160px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>附件上传控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_qrcode'] = function() {
        var me = this, thePlugins = 'td_qrcode';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/qrcode/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '二维码控件',
                        cssRules : "width:390px;height:260px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>二维码控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_mobilesign'] = function() {
        var me = this, thePlugins = 'td_mobilesign';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/mobilesign/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '移动签章控件',
                        cssRules : "width:390px;height:210px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>移动签章控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_mobilewritesign'] = function() {
        var me = this, thePlugins = 'td_mobilewritesign';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './controls/mobilewritesign/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '移动手写签章控件',
                        cssRules : "width:410px;height:220px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>移动手写签章控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_custom_yyaccount'] = function() {
        var me = this, thePlugins = 'td_custom_yyaccount';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './custom_controls/yyaccount/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '用友ERP账套记账',
                        cssRules : "width:410px;height:300px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>用友ERP账套记账: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_custom_kdaccount'] = function() {
        var me = this, thePlugins = 'td_custom_kdaccount';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './custom_controls/kdaccount/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '金蝶ERP账套记账',
                        cssRules : "width:410px;height:300px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>金蝶ERP账套记账: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_custom_wfpreview'] = function() {
        var me = this, thePlugins = 'td_custom_wfpreview';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './custom_controls/wfpreview/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '指定工作查看控件',
                        cssRules : "width:310px;height:100px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>指定工作查看控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };
    UE.plugins['td_custom_help'] = function() {
        var me = this, thePlugins = 'td_custom_help';
        me.commands[thePlugins] = {
            execCommand : function() {
                var dialog = new UE.ui.Dialog(
                    {
                        iframeUrl : './custom_controls/help/prop_dialog.php?e=ue&FORM_ID=145',
                        name : thePlugins,
                        editor : this,
                        title : '帮助控件',
                        cssRules : "width:310px;height:300px;",
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                dialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                dialog.close(false);
                            }
                        } ]
                    });
                dialog.render();
                dialog.open();
                me.ui._dialogs[thePlugins + 'Dialog'] = dialog;
                me.currentField = thePlugins;
            }
        };
        var popup = new baidu.editor.ui.Popup({
            editor : this,
            content : '',
            className : 'edui-bubble',
            _edittext : function() {
                baidu.editor.plugins[thePlugins].editdom = popup.anchorEl;
                me.execCommand(thePlugins);
                this.hide();
            },
            _delete : function() {
                if (window.confirm('确认删除该控件吗？')) {
                    baidu.editor.plugins[thePlugins].editdom = '';
                    baidu.editor.dom.domUtils.remove(this.anchorEl, false);
                }
                this.hide();
            },
            showPop : function(e) {
                var self = this;
                this.clearHideTimer();
                this.hidetimer = setTimeout(function() {
                    self.showAnchor(e);
                }, 100);

            },
            clearHideTimer : function() {
                this.hidetimer && clearTimeout(this.hidetimer);
            }
        });
        popup.render();
		/*
		 me.addListener( 'mouseover', function( t, evt ) {
		 evt = evt || window.event;
		 var el = evt.target || evt.srcElement;
		 var plugins = GetFieldTypeByTag(el);
		 if ( plugins==thePlugins) {
		 var html = popup.formatHtml(
		 '<nobr>帮助控件: <span onclick=$$._edittext() class="edui-clickable">编辑</span>&nbsp;&nbsp;<span onclick=$$._delete() class="edui-clickable">删除</span></nobr>' );
		 if ( html ) {
		 popup.getDom( 'content' ).innerHTML = html;
		 popup.anchorEl = el;
		 //popup.showAnchor( popup.anchorEl );
		 popup.showPop( popup.anchorEl );
		 } else {
		 popup.hide();
		 }
		 }
		 });
		 */
        jQuery(popup.getDom('content')).on('mouseover', function(t, evt) {
            popup.clearHideTimer();
        });
    };

    //['/general/workflow/assets/form.css', '/static/modules/workflow/system/flow_form/css/form_design.css'];
    UE
        .registerUI(
            'td_js_script',
            function(editor, uiname) {
                var me = this;
                // 创建dialog
                var jsDialog = new UE.ui.Dialog(
                    {

                        // 指定弹出层路径
                        iframeUrl : 'awyq',
                        // 编辑器实例
                        editor : editor,
                        // dialog 名称
                        name : 'js',
                        // dialog 标题
                        title : 'JS脚本',

                        // dialog 外围 css
                        cssRules : "width:600px;height:350px;",

                        //如果给出了buttons就代表dialog有确定和取消
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                jsDialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                jsDialog.close(false);
                            }
                        } ]
                    });

                editor.ready(function() {
                    //UE.utils.cssRule('td_js_script', 'img.td_js_script{vertical-align: middle;}', editor.document);
                });

                var iconUrl = '/static/modules/workflow/system/flow_form/css/images/td_js_script.gif';
                var tmpLink = document.createElement('a');
                tmpLink.href = iconUrl;
                tmpLink.href = tmpLink.href;
                iconUrl = tmpLink.href;

                var jsBtn = new UE.ui.Button(
                    {
                        name : uiname,
                        title : 'JS脚本',
                        //需要添加的额外样式，指定icon图标
                        cssRules : 'background: url("'
                        + iconUrl
                        + '") no-repeat center center !important',
                        onclick : function() {
                            //渲染dialog
                            jsDialog.render();
                            jsDialog.open();
                            me.currentField = "js";
                            me.ui._dialogs['jsDialog'] = jsDialog;
                        }
                    });

                //当点到编辑内容上时，按钮要做的状态反射
                editor.addListener('selectionchange', function() {
                    var state = editor.queryCommandState(uiname);
                    if (state == -1) {
                        jsBtn.setDisabled(true);
                        jsBtn.setChecked(false);
                    } else {
                        jsBtn.setDisabled(false);
                        jsBtn.setChecked(state);
                    }
                });

                return jsBtn;
            });
    UE
        .registerUI(
            'td_css_script',
            function(editor, uiname) {
                var me = this;
                // 创建dialog
                var cssDialog = new UE.ui.Dialog(
                    {

                        // 指定弹出层路径
                        iframeUrl : 'awyq',
                        // 编辑器实例
                        editor : editor,
                        // dialog 名称
                        name : 'css',
                        // dialog 标题
                        title : 'CSS样式',

                        // dialog 外围 css
                        cssRules : 'width:600px; height: 350px;',

                        //如果给出了buttons就代表dialog有确定和取消
                        buttons : [ {
                            className : 'edui-okbutton',
                            label : '确定',
                            onclick : function() {
                                cssDialog.close(true);
                            }
                        }, {
                            className : 'edui-cancelbutton',
                            label : '取消',
                            onclick : function() {
                                cssDialog.close(false);
                            }
                        } ]
                    });

                editor.ready(function() {
                    //UE.utils.cssRule('td_css_script', 'img.td_css_script{vertical-align: middle;}', editor.document);
                });

                var iconUrl = '/static/modules/workflow/system/flow_form/css/images/td_css_script.gif';
                var tmpLink = document.createElement('a');
                tmpLink.href = iconUrl;
                tmpLink.href = tmpLink.href;
                iconUrl = tmpLink.href;

                var cssBtn = new UE.ui.Button(
                    {
                        name : uiname,
                        title : 'CSS样式',
                        //需要添加的额外样式，指定icon图标
                        cssRules : 'background: url("'
                        + iconUrl
                        + '") no-repeat center center !important',
                        onclick : function() {
                            //渲染dialog
                            cssDialog.render();
                            cssDialog.open();
                            me.currentField = "css";
                            me.ui._dialogs['cssDialog'] = cssDialog;
                        }
                    });

                //当点到编辑内容上时，按钮要做的状态反射
                editor.addListener('selectionchange', function() {
                    var state = editor.queryCommandState(uiname);
                    if (state == -1) {
                        cssBtn.setDisabled(true);
                        cssBtn.setChecked(false);
                    } else {
                        cssBtn.setDisabled(false);
                        cssBtn.setChecked(state);
                    }
                });

                return cssBtn;
            });
    UE
        .registerUI(
            'td_macro_mark',
            function(editor, uiname) {
                var me = this;
                // 创建dialog
                var macroDialog = new UE.ui.Dialog({

                    // 指定弹出层路径
                    iframeUrl : './toolbar/macro/dialog.php',
                    // 编辑器实例
                    editor : editor,
                    // dialog 名称
                    name : 'macro',
                    // dialog 标题
                    title : '宏标记',

                    // dialog 外围 css
                    cssRules : 'width:600px; height: 350px;',

                    //如果给出了buttons就代表dialog有确定和取消
                    buttons : [ {
                        className : 'edui-okbutton',
                        label : '确定',
                        onclick : function() {
                            macroDialog.close(true);
                        }
                    }, {
                        className : 'edui-cancelbutton',
                        label : '取消',
                        onclick : function() {
                            macroDialog.close(false);
                        }
                    } ]
                });

                editor.ready(function() {
                    //UE.utils.cssRule('td_macro_mark', '.edui-for-td_macro_mark edui-dialog-body{width:500px;height:350px;}', editor.document);
                });

                var iconUrl = '/static/modules/workflow/system/flow_form/css/images/td_macro.gif';
                var tmpLink = document.createElement('a');
                tmpLink.href = iconUrl;
                tmpLink.href = tmpLink.href;
                iconUrl = tmpLink.href;

                var macroBtn = new UE.ui.Button(
                    {
                        name : uiname,
                        title : '宏标记',
                        //需要添加的额外样式，指定icon图标
                        cssRules : 'background: url("'
                        + iconUrl
                        + '") no-repeat center center !important',
                        onclick : function() {
                            //渲染dialog
                            macroDialog.render();
                            macroDialog.open();
                        }
                    });

                //当点到编辑内容上时，按钮要做的状态反射
                editor.addListener('selectionchange', function() {
                    var state = editor.queryCommandState(uiname);
                    if (state == -1) {
                        macroBtn.setDisabled(true);
                        macroBtn.setChecked(false);
                    } else {
                        macroBtn.setDisabled(false);
                        macroBtn.setChecked(state);
                    }
                });

                return macroBtn;
            });
</script>
<script type="text/javascript"
		src="../js/ueditor/cool_form_operation.ue.js"></script>
<script type="text/javascript">
    (function($) {
        $(window).resize((function() {
            var t;
            return function() {
                t && clearTimeout(t);
                t = setTimeout(function() {
                    var ue = UE.instants.ueditorInstant0;
                    ue.setHeight(GetEditContentHeight());
                }, 300);
            }
        })());

        $('body')
            .keydown(
                function(e) {
                    var $target = $(e.target);
                    if (e.which == 8) {
                        return $target
                                .is('input:enabled,textarea:enabled')
                            && !$target
                                .is('input[readOnly],textarea[readOnly]');
                    }
                });
    })(jQuery);
</script>
<script>
    function getPluginType(pObj) {
        var pType = "";
        if (typeof pObj != "undefined") {
            with (pObj) {
                var _tagName = tagName;
                var _class = getAttribute("className")
                    || getAttribute("class");
                var _type = getAttribute("type");
                switch (_tagName) {
                    case "INPUT":
                        if (_type == "checkbox") {
                            pType = "复选框";
                        } else if (_type == "text") {
                            if (_class == "AUTO") {
                                pType = "宏控件";
                            } else if (_class == "CALC") {
                                pType = "计算控件";
                            } else {
                                pType = "单行输入框";
                            }
                        }
                        break;
                    case "TEXTAREA":
                        pType = "多行输入框";
                        break;
                    case "SELECT":
                        if (_class == "AUTO") {
                            pType = "宏控件";
                        } else {
                            pType = "下拉菜单";
                        }
                        break;
                    case "IMG":
                        if (_class == "LIST_VIEW") {
                            pType = "列表控件";
                        } else if (_class == "DATE") {
                            pType = "日历控件";
                        } else if (_class == "USER") {
                            pType = "部门人员控件";
                        } else if (_class == "SIGN") {
                            pType = "签章控件";
                        } else if (_class == "RADIO") {
                            pType = "单选框";
                        } else if (_class == "PROGRESSBAR") {
                            pType = "进度条控件";
                        } else if (_class == "IMGUPLOAD") {
                            pType = "图片上传控件";
                        } else if (_class == "FILEUPLOAD") {
                            pType = "附件上传控件";
                        } else if (_class == "QRCODE") {
                            pType = "二维码控件";
                        } else if (_class == "MOBILE_SEAL") {
                            pType = "移动签章控件";
                        } else if (_class == "MOBILE_WRITE_SEAL") {
                            pType = "移动手写签章控件";
                        } else {
                            pType = "未知控件";
                        }
                        break;
                    case "BUTTON":
                        if (_class == "DATA") {
                            pType = "数据选择控件";
                        } else if (_class == "FETCH") {
                            pType = "表单数据控件";
                        } else if (_class == "DATA_EXT") {
                            pType = "外部数据选择";
                        }
                        break;
                }
            }
        }
        return pType;
    }
    function myclose() {
        var msg = '关闭表单设计器前，保存对表单的修改？';
        if (window.confirm(msg)) {
            document.form1.CLOSE_FLAG.value = "1";
            send();
        } else
            window.close();
    }
    function viewForm() {
        window.open("/general/workflow/form_view.php?FORM_ID=145",
            "form_view_145",
            "menubar=0,toolbar=0,status=0,resizable=1,left=0,top=0,scrollbars=1,width="
            + (screen.availWidth - 10) + ",height="
            + (screen.availHeight - 50) + "\"");
    }

    function checkClose() {
        if (event.clientX > document.body.clientWidth - 20
            && event.clientY < 0 || event.altKey)
            window.event.returnValue = '您确定退出表单设计器吗';
    }

    function hideDiv(para) {
        var obj_s = jQuery("#standard_controls");
        var obj_c = jQuery("#custom_controls");
        // console.log();
        if (para == 1) {
            if (obj_s.css("display") == "none") {
                obj_s.css("display", "block");
                obj_c.css("display", "none");
                jQuery("#custom_div").css({
                    "background-image" : "none",
                    "background-color" : "rgb(221, 221, 221)"
                });
                jQuery("#standard_div").css({
                    "background-image" : "none",
                    "background-color" : "#F1F1F1"
                });
            }
        } else {
            if (obj_c.css("display") == "none") {
                obj_c.css("display", "block");
                obj_s.css("display", "none");
                jQuery("#standard_div").css({
                    "background-image" : "none",
                    "background-color" : "rgb(221, 221, 221)"
                });
                jQuery("#custom_div").css({
                    "background-image" : "none",
                    "background-color" : "#F1F1F1"
                });
            }
        }
    }
</script>
</body>
</html>
