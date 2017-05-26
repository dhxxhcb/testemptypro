<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link href="../css/ueditor/bootstrap.css" rel="stylesheet" type="text/css" />
    <!--[if lte IE 6]>
    <link rel="stylesheet" type="text/css" href="${ctx }/styles/bootstrap/2.2.2/css/bootstrap-ie6.css">
    <![endif]-->
    <!--[if lte IE 7]>
    <link rel="stylesheet" type="text/css" href="${ctx }/styles/bootstrap/2.2.2/css/ie.css">
    <![endif]-->
    <link href="../css/ueditor/site.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="../css/ueditor/styleUpdate.css">
    <link rel="stylesheet" href="../css/base.css">
    <script src="../../js/workflow/work/workform.js"></script>
</head>
<body>
<script type="text/javascript">
    var pluginId = 0;
</script>


<div class="container" style="padding-top: 5px; padding-left: 5px;overflow: auto;">
    <span id="formtitle" class="title">请假申请单</span>
    <div class="title_nav" class="clearfix">
        <p class="nav-left">表单智能设计器:您需要先布局,才可以拖拽右侧的组件到左侧内容里设计工作流表单</p>
        <p class="nav-right">
            <a href="javascript:void(0)" class="updateForm">保存表单</a>
            <a href="javascript:void(0)" class="save_f">浏览</a>
            <a href="javascript:void(0)" class="save_f">生成版本</a>
            <a href="javascript:void(0)" class="save_f">关闭</a>
        </p>
    </div>
    <form method="post" id="saveform" name="saveform" action="" class="clearfix">
        <input type="hidden" name="fields" id="fields" value="${form.fieldNum }">

        <div class="row" id="content">
            <%--<div class="span2">--%>
            <ul class="nav nav-list">
                <li class="nav-header">
                    <div class="header_l">表单控件</div>
                    <div class="header_r">扩展控件</div>
                </li>

                <li><a href="javascript:void(0);" type="text"  class="btn btn-link">
                    <img src="../img/icon_textbox_03.png" alt="">单行文本框
                </a></li>
                <li><a href="javascript:void(0);" type="textarea"  class="btn btn-link">
                    <img src="../img/icon_multiplelinetextbox_03.png" alt="">多行文本框</a></li>
                <li><a href="javascript:void(0);" type="select"  class="btn btn-link">
                    <img src="../img/icon_dropmenu_03.png" alt="">下拉菜单</a></li>
              <li><a href="javascript:void(0);" type="radios"  class="btn btn-link">
                    <img src="../img/icon_radiobutton_03.png" alt="">单选框</a></li>
                <li><a href="javascript:void(0);" type="radio"  class="btn btn-link">
                    <img src="../img/icon_radiobutton_03.png" alt="">单选框2</a></li>
            <li><a href="javascript:void(0);" type="checkboxs"  class="btn btn-link">
                    <img src="../img/icon_checkbox_03.png" alt="">复选框</a></li>
                <li><a href="javascript:void(0);" type="checkbox"  class="btn btn-link">
                    <img src="../img/icon_checkbox_03.png" alt="">复选框2</a></li>
                <li><a href="javascript:void(0);" type="macros" class="btn btn-link">
                    <img src="../img/icon_hongcontrol_03.png" alt="">宏控件</a></li>
                <li><a href="javascript:void(0);">
                    <img src="../img/icon_calendar_03.png" alt="">日历控件</a></li>
                <li><a href="javascript:void(0);">
                    <img src="../img/icon_calculator_03.png" alt="">计算控件</a></li>
                <%--<li><a href="javascript:void(0);" onclick="formDesign.exec('progressbar');" class="btn btn-link">进度条</a></li>
                 <li><a href="javascript:void(0);" onclick="formDesign.exec('qrcode');" class="btn btn-link">二维码</a></li>
                 <li><a href="javas cript:void(0);" onclick="formDesign.exec('more');" class="btn btn-link">一起参与...</a></li>
--%>
            </ul>
            <%--</div>--%>
        </div>
        <div class="span10">
            <script id="formEditor" type="text/plain" style="width:100%;">${form.originalHtml}</script>

            <script type="text/javascript" charset="utf-8" src="../js/jquery-1.9.1.js"></script>
            <script type="text/javascript" charset="utf-8" src="../js/base/base.js"> </script>
            <script type="text/javascript" charset="utf-8" src="../lib/ueditor/ueditor.config.js"></script>
            <script type="text/javascript" charset="utf-8" src="../lib/ueditor/ueditor.all.js"> </script>
            <script type="text/javascript" charset="utf-8" src="../lib/ueditor/lang/zh-cn/zh-cn.js"></script>
            <script type="text/javascript" charset="utf-8" src="../lib/ueditor/formdesign/formdesign.v4.js"></script>
            <!-- script start-->
            <script type="text/javascript">
                var  formDesign = {}
                $(function () {
                    var formid = $.getQueryString("formId")
                    var type = $.getQueryString("type")
                    $("#content .nav-list ").on("click",'a',function(){

                        formDesign.exec($(this).attr('type'));
                    })
                var formEditor = UE.getEditor('formEditor',{
                    toolleipi:true,//是否显示，设计器的 toolbars
                    textarea: 'design_content',
                    //这里可以选择自己需要的工具按钮名称,此处仅选择如下五个
                    toolbars:[[
                        'fullscreen', 'source', '|', 'undo', 'redo', '|','bold', 'italic', 'underline', 'fontborder', 'strikethrough',  'removeformat', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist','|', 'fontfamily', 'fontsize', '|', 'indent', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|',  'link', 'unlink',  '|',  'horizontal',  'spechars',  'wordimage', '|', 'inserttable', 'deletetable',  'mergecells',  'splittocells']],
                    //focus时自动清空初始化时的内容
                    //autoClearinitialContent:true,
                    //关闭字数统计
                    wordCount:false,
                    //关闭elementPath
                    elementPathEnabled:false,
                    //默认的编辑区域高度
                    initialFrameHeight:470,
                    //编辑器宽度
//                            initialFrameWidth: auto,

                    iframeCssUrl:"../css/ueditor/bootstrap.css" //引入自身 css使编辑器兼容你网站css
                    //更多其他参数，请参考ueditor.config.js中的配置项
                });
                    formEditor.ready(function() {

                        if(type == 'edit'){
                            $.ajax({
                                type: "get",
                                url: "../form/formType",
                                dataType: 'JSON',
                                data: {
                                    fromId :formid
                                },
                                success: function (res) {
                                    var formObj = $('<div>'+res.object.printModel+'</div>');
                                    console.log(formObj.prop("outerHTML"))
                                    workForm.ReBuild(formObj);
                                    $('#formtitle').html(res.object.formName);
                                    formEditor.setContent(formObj.html(),true);
                                }
                            });
                        }
                    });
                   formDesign = {

                    /*执行控件*/
                    exec : function (method) {
                        formEditor.execCommand(method);
                    },
                    /*
                     Javascript 解析表单
                     template 表单设计器里的Html内容
                     fields 字段总数
                     */
                    parse_form:function(template,fields)
                    {
                        debugger;

                        //正则  radios|checkboxs|select 匹配的边界 |--|  因为当使用 {} 时js报错 (plugins|fieldname|fieldflow)
                        var preg =  /(\|-<span(((?!<span).)*plugins=\"(radios|checkboxs|select)\".*?)>(.*?)<\/span>-\||<(img|input|textarea|select).*?(<\/select>|<\/textarea>|\/>))/gi,preg_attr =/(\w+)=\"(.?|.+?)\"/gi,preg_group =/<input.*?\/>/gi;
                        if(!fields) fields = 0;

                        var template_parse = template,template_data = new Array(),add_fields=new Object(),checkboxs=0;

                        var pno = 0;
                        template.replace(preg, function(plugin,p1,p2,p3,p4,p5,p6){
                            var parse_attr = new Array(),attr_arr_all = new Object(),name = '', select_dot = '' , is_new=false;
                            var p0 = plugin;
                            var tag = p6 ? p6 : p4;
                            //alert(tag + " \n- t1 - "+p1 +" \n-2- " +p2+" \n-3- " +p3+" \n-4- " +p4+" \n-5- " +p5+" \n-6- " +p6);

                            if(tag == 'radios' || tag == 'checkboxs')
                            {
                                plugin = p2;
                            }else if(tag == 'select')
                            {
                                plugin = plugin.replace('|-','');
                                plugin = plugin.replace('-|','');
                            }
                            plugin.replace(preg_attr, function(str0,attr,val) {
                                if(attr=='name')
                                {
                                    if(val=='NEWFIELD')
                                    {
                                        is_new=true;
                                        fields++;
                                        val = 'data_'+fields;
                                    }
                                    name = val;
                                }
                                if(tag=='select' && attr=='value')
                                {
                                    if(!attr_arr_all[attr]) attr_arr_all[attr] = '';
                                    attr_arr_all[attr] += select_dot + val;
                                    select_dot = ',';
                                }else
                                {
                                    attr_arr_all[attr] = val;
                                }
                                var oField = new Object();
                                oField[attr] = val;
                                parse_attr.push(oField);
                            })
                            /*alert(JSON.stringify(parse_attr));return;*/
                            if(tag =='checkboxs') /*复选组  多个字段 */
                            {
                                plugin = p0;
                                plugin = plugin.replace('|-','');
                                plugin = plugin.replace('-|','');
                                var name = 'checkboxs_'+checkboxs;
                                attr_arr_all['parse_name'] = name;
                                attr_arr_all['name'] = '';
                                attr_arr_all['value'] = '';
                                attr_arr_all['content'] = '<span plugins="checkboxs"  title="'+attr_arr_all['title']+'">';
                                var dot_name ='', dot_value = '';
                                p5.replace(preg_group, function(parse_group) {
                                    var is_new=false,option = new Object();
                                    parse_group.replace(preg_attr, function(str0,k,val) {
                                        if(k=='name')
                                        {
                                            if(val=='NEWFIELD')
                                            {
                                                is_new=true;
                                                fields++;
                                                val = 'data_'+fields;
                                            }
                                            attr_arr_all['name'] += dot_name + val;
                                            dot_name = ',';
                                        }
                                        else if(k=='value')
                                        {
                                            attr_arr_all['value'] += dot_value + val;
                                            dot_value = ',';
                                        }
                                        option[k] = val;
                                    });

                                    if(!attr_arr_all['options']) attr_arr_all['options'] = new Array();
                                    attr_arr_all['options'].push(option);
                                    if(!option['checked']) option['checked'] = '';
                                    var checked = option['checked'] ? 'checked="checked"' : '';
                                    attr_arr_all['content'] +='<input type="checkbox" name="'+option['name']+'" value="'+option['value']+'" fieldname="' + attr_arr_all['fieldname'] + option['fieldname'] + '" fieldflow="' + attr_arr_all['fieldflow'] + '" '+checked+'/>'+option['value']+'&nbsp;';

                                    if(is_new)
                                    {
                                        var arr = new Object();
                                        arr['name'] = option['name'];
                                        arr['plugins'] = attr_arr_all['plugins'];
                                        arr['fieldname'] = attr_arr_all['fieldname'] + option['fieldname'];
                                        arr['fieldflow'] = attr_arr_all['fieldflow'];
                                        add_fields[option['name']] = arr;
                                    }

                                });
                                attr_arr_all['content'] += '</span>';
                                //parse
                                template = template.replace(plugin,attr_arr_all['content']);
                                template_parse = template_parse.replace(plugin,'{'+name+'}');
                                template_parse = template_parse.replace('{|-','');
                                template_parse = template_parse.replace('-|}','');
                                template_data[pno] = attr_arr_all;
                                checkboxs++;
                            }else if(name)
                            {
                                if(tag =='radios') /*单选组  一个字段*/
                                {
                                    plugin = p0;
                                    plugin = plugin.replace('|-','');
                                    plugin = plugin.replace('-|','');
                                    attr_arr_all['value'] = '';
                                    attr_arr_all['content'] = '<span plugins="radios" name="'+attr_arr_all['name']+'" title="'+attr_arr_all['title']+'">';
                                    var dot='';
                                    p5.replace(preg_group, function(parse_group) {
                                        var option = new Object();
                                        parse_group.replace(preg_attr, function(str0,k,val) {
                                            if(k=='value')
                                            {
                                                attr_arr_all['value'] += dot + val;
                                                dot = ',';
                                            }
                                            option[k] = val;
                                        });
                                        option['name'] = attr_arr_all['name'];
                                        if(!attr_arr_all['options']) attr_arr_all['options'] = new Array();
                                        attr_arr_all['options'].push(option);
                                        if(!option['checked']) option['checked'] = '';
                                        var checked = option['checked'] ? 'checked="checked"' : '';
                                        attr_arr_all['content'] +='<input type="radio" name="'+attr_arr_all['name']+'" value="'+option['value']+'"  '+checked+'/>'+option['value']+'&nbsp;';

                                    });
                                    attr_arr_all['content'] += '</span>';

                                }else
                                {
                                    attr_arr_all['content'] = is_new ? plugin.replace(/NEWFIELD/,name) : plugin;
                                }
                                //attr_arr_all['itemid'] = fields;
                                //attr_arr_all['tag'] = tag;
                                template = template.replace(plugin,attr_arr_all['content']);
                                template_parse = template_parse.replace(plugin,'{'+name+'}');
                                template_parse = template_parse.replace('{|-','');
                                template_parse = template_parse.replace('-|}','');
                                if(is_new)
                                {
                                    var arr = new Object();
                                    arr['name'] = name;
                                    arr['plugins'] = attr_arr_all['plugins'];
                                    arr['title'] = attr_arr_all['title'];
                                    arr['orgtype'] = attr_arr_all['orgtype'];
                                    arr['fieldname'] = attr_arr_all['fieldname'];
                                    arr['fieldflow'] = attr_arr_all['fieldflow'];
                                    add_fields[arr['name']] = arr;
                                }
                                template_data[pno] = attr_arr_all;
                            }
                            pno++;
                        })
                        var view = template.replace(/{\|-/g,'');
                        view = view.replace(/-\|}/g,'');
                        var parse_form = new Object({
                            'fields':fields,//总字段数
                            'template':template,//完整html
                            'parse':view,
                            'data':template_data,//控件属性
                            'add_fields':add_fields//新增控件
                        });
                        return JSON.stringify(parse_form);
                    },
                    /*type  =  save 保存设计 versions 保存版本  close关闭 */
                    fnCheckForm : function ( type ) {

                        if(formEditor.queryCommandState( 'source' ))
                            formEditor.execCommand('source');//切换到编辑模式才提交，否则有bug

                        if(formEditor.hasContents()){
                            formEditor.sync();/*同步内容*/
                            //--------------以下仅参考-----------------------------------------------------------------------------------------------------
                            var type_value='',fields=$("#fields").val(),formeditor='';

                            if( typeof type!=='undefined' ){
                                type_value = type;
                            }
                            //获取表单设计器里的内容
                            formeditor=formEditor.getContent();
                            //解析表单设计器控件
                           // var parse_form = this.parse_form(formeditor,fields);

                            alert(formid);
                            //异步提交数据
                            $.ajax({
                                type: 'POST',
                                url : 'updateFormType',
                                //dataType : 'json',
                                data : {
                                   'formId':formid,
                                    'printModel':formeditor
                                },
                                success : function(data){
                                   if(data) {
                                        alert('表单保存成功');
                                      // window.location.href='${ctx}/config/form';
                                    } else {
                                        alert('表单保存失败');
                                    }
                                }
                            });
                        } else {
                            alert('表单内容不能为空！')
                            $('#submitbtn').button('reset');
                            return false;
                        }
                    } ,
                    /*预览表单*/
                    fnReview : function (){
                        if(formEditor.queryCommandState( 'source' ))
                            formEditor.execCommand('source');/*切换到编辑模式才提交，否则部分浏览器有bug*/
                        if(formEditor.hasContents()){
                            formEditor.sync();       /*同步内容*/
                            alert("你点击了预览,请自行处理....");
                            return false;
                            //--------------以下仅参考-------------------------------------------------------------------
                            /*设计form的target 然后提交至一个新的窗口进行预览*/
                            document.saveform.target="mywin";
                            window.open('','mywin',"menubar=0,toolbar=0,status=0,resizable=1,left=0,top=0,scrollbars=1,width=" +(screen.availWidth-10) + ",height=" + (screen.availHeight-50) + "\"");

                            document.saveform.action="";
                            document.saveform.submit(); //提交表单
                        } else {
                            alert('表单内容不能为空！');
                            return false;
                        }
                    }
                };
                });
            </script>
            <!-- script end -->
        </div>

    </form>

</body>
<script type="text/javascript">
    $(function () {
        var $width=$(window).width();
        $('.span10').width($width-330);
    })


</script>
</html>
