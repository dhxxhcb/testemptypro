var workForm = {
    option : {
        formhtmlurl :domain+ '/form/formType',
        formid : 1,
        target:"",
        flowStep:1,//-1预览
        listFp:'',
        pageModel:'',
        eleObject:{}
    },
    init:function(options,cb){
        var _this = this;
        $.extend( _this.option, options );
        if(options.flag == '3'){

             return _this.getSearchData(cb);
        }
       // $.extend( _this.option, options );
        _this.buildHTML(cb);
    },
    render:function(){
        this.ReBuild();
        this.MacrosRender();
        this.RadioRender();
        this.DateRender();
        this.ListRender();
        this.filter();//表单流程权限控制
        return   this.option.eleObject;
    },
    ListRender:function () {
        var that = this;
        this.option.eleObject.find('.list').each(function () {
            var _this = $(this);
            var tableStr = '<table name="'+_this.attr('name')+'" id="'+_this.attr('name')+'" class="list_table form_item list">';
            var lv_title = $(this).attr('lv_title').split('`');
            var lv_size = $(this).attr('lv_size').split('`');
            var lv_coltype = $(this).attr('lv_coltype').split('`');
            var titleTd = '<td>操作</td>'
            var tdStr = '<td><button class="add_btn">新增</button></td>';
            var addtr ='<td><a style="" title="删除" class="delete_row" href="javascript:void(0)"><img src="/img/workflow/delete.png"></a></td>';
            for(var i=0;i<lv_title.length-1;i++){
                titleTd+=('<td>'+lv_title[i] +'</td>');
                tdStr+='<td></td>';

                switch (lv_coltype[i]){
                    case 'text':
                        addtr+='<td><input type="text" style="width: '+lv_size[i]+'px"></td>';
                        break;
                    case 'textarea':
                        addtr+='<td><textarea style="width: '+lv_size[i]+'px"></textarea></td>';
                        break;
                    case 'select':
                        addtr+='<td><select style="width: '+lv_size[i]+'px"></select></td>';
                        break;
                    case 'radio':
                        addtr+='<td><input style="width: '+lv_size[i]+'px" type="radio"></td>';
                        break;
                    case 'checkbox':
                        addtr+='<td><input style="width: '+lv_size[i]+'px" type="checkbox"></td>';
                        break;
                    case 'datetime':
                        addtr+='<td>'+new Date().Format('yyyy-MM-dd')+'</td>';
                        break;
                    case 'dateAndTime':
                        break;
                    default:
                        addtr+='<td><input type="text"></td>';
                }
            }
            tableStr+=('<tr class="head">'+titleTd+'</tr>');
            tableStr+=('<tr>'+tdStr+'</tr>');
            tableStr+='</table>';
            _this.before(tableStr);

            _this.prev().on("click",'.delete_row',function () {
                $(this).parent().parent().remove();
            });
            _this.prev().find('.add_btn').on('click',function () {

                $(this).parent().parent().before('<tr>'+addtr+'</tr>');
            });
            _this.remove();
        });
    },
    filter:function() {
        var that = this;
        if(that.option.flowStep && that.option.flowStep  != -1){
            //var steptOpt =  this.option.listFp[this.option.flowStep-1];
            that.option.listFp.forEach(function (v,i) {
                if(v.prcsId == that.option.flowStep){
                    var steptOpt = v;
                    that.option.eleObject.find('.form_item').each(function(){
                        var _this = $(this);
                        if(steptOpt.prcsItem.indexOf(_this.attr("title")) == -1){
                            if(_this.attr("data-type") == 'macros'){
                                _this.val('');
                            }
                            _this.attr("disabled","disabled")
                        }else{
                            if(_this.attr("data-type") == 'macros'){
                                if(_this.is('input')){
                                    _this.attr("readonly","readonly");
                                }
                            }
                        }
                    });
                }
            });

        }
    },
    RadioRender:function(){
        this.option.eleObject.find('input[data-type="radio"]').each(function(){
            var _this = $(this);
            var name = _this.attr('name');
            var title = _this.attr('title');
            var radio_field = _this.attr("radio_field").split('`');
            var checked = _this.attr('orgchecked');
            var eleStr = "";
            radio_field.forEach(function(v,i){
                if(v){
                    var checked = "";
                    if(v == checked){
                        checked="checked";
                    }
                    eleStr+='<input name="'+name+'" data-type="radio" title="'+title+'" value="'+v+'" type="radio" class="form_item"/>'+v+' ';
                }
            });
            _this.before(eleStr);
            _this.remove();

        });

    },
    ReBuild:function(ele){
        var target = {};
        if(ele){
            target = ele;
        }else{
            target = this.option.eleObject;
        }
        target.find('link').each(function () {
            var href = $(this).attr('href');
            var link = domain+'/tdold'+href.substring(22);
            $(this).attr('href',domain+'/tdold'+href.substring(22));
        });
        target.find("input").each(function(){
            var _this = $(this);
            var cssLink = '';
            if(_this.attr('hidden')){
                _this.attr("orghidden",_this.attr('hidden'));
                _this.removeAttr("hidden");
            }
            if(_this.attr("class") &&  _this.attr("class").indexOf('AUTO') > -1){
                _this.attr("data-type","macros");
            }else if(_this.attr("class") &&  _this.attr("class").indexOf('list') > -1){
                _this.attr("data-type","listing");
            }
            else{
                _this.attr("data-type",$(this).attr("type"));
            }
            _this.addClass("form_item");
            _this.attr("id",$(this).attr("name"));
        });
        //list
        target.find("img.LIST_VIEW").each(function () {
             var _this = $(this);
             var datafrom = _this.attr('datatype')=='1'?'inData':'outData';
             var listStr = '<input name="'+_this.attr('name')+'" style="'+_this.attr('style')+'"  id="'+_this.attr('name')+'" title="'+_this.attr('title')+'" type="text" class="form_item list" data-type="listing"  datafrom="'+datafrom+'" lv_field="'+_this.attr('lv_field')+'" lv_title="'+_this.attr('lv_title')+'" lv_size="'+_this.attr('lv_size')+'" lv_colvalue="'+_this.attr('lv_colvalue')+'" lv_sum="'+_this.attr('lv_sum')+'" width="'+_this.attr('width')+'" height="'+_this.attr('height')+'" lv_coltype="'+_this.attr('lv_coltype')+'" lv_cal="'+_this.attr('lv_cal')+'"/>';
            _this.before(listStr);
            _this.remove();
        });
        //
        target.find('img.DATE').each(function(){
            var _this = $(this);
            var objprev = _this.prev();
            if(_this.attr('hidden')){
                _this.attr("orghidden",_this.attr('hidden'));
                _this.removeAttr("hidden");
            }

            var inputObj = '<input name="'+objprev.attr('name')+'" title="'+objprev.attr('title')+'" class="form_item laydate-icon" data-type="calendar" id="'+objprev.attr('name')+'" value="'+_this.attr('date_format')+'"  date_format="'+_this.attr('date_format')+'"/>';
            objprev.remove();
            _this.before(inputObj);
            _this.remove();
        });
        //
        target.find("textarea").each(function(){
            if( $(this).attr('hidden')){
                $(this).attr("orghidden",_this.attr('hidden'));
                $(this).removeAttr("hidden");
            }
            $(this).addClass("form_item");
            $(this).attr("data-type","textarea");
            $(this).attr("id",$(this).attr("name"));
        });
        target.find("select").each(function () {

            var _this = $(this);
            $(this).addClass("form_item");
            if(_this.attr('hidden')){
                _this.attr("orghidden",_this.attr('hidden'));
                _this.removeAttr("hidden");
            }
            $(this).attr("data-type","select");
            $(this).attr("id",$(this).attr("name"));
        });
        target.find("img.RADIO").each(function(){
            var _this = $(this);
            if(_this.attr('hidden')){
                _this.attr("orghidden",_this.attr('hidden'));
                _this.removeAttr("hidden");
            }
            var radioStr = ' <input name="'+_this.attr('name')+'" checked="checked" id="'+_this.attr('name')+'" title="'+_this.attr('title')+'" type="radio"  radio_field="'+_this.attr('radio_field')+'" orgchecked="'+_this.attr('radio_checked')+'" classname="radio" class="form_item" data-type="radio" />';
            _this.before(radioStr);

            _this.remove();
        });
    },
    MacrosRender:function(){
        var that = this;
        var flagStr = "";
        that.option.eleObject.find(".AUTO").each(function(index,obj){
            if($(this).attr("orghidden") == 1){
                $(this).attr("hidden","1");
            }
            if(that.tool.MacrosDate.option[$(this).attr("datafld")]){
                flagStr+=($(this).attr("datafld")+',');
            }
        });
        that.tool.MacrosDate.ready(flagStr,function(MacrosDate){
            that.option.eleObject.find(".AUTO").each(function(index,obj){

                if(that.tool.MacrosDate.option[$(this).attr("datafld")]){
                    var selectObj = $('<select id="'+$(this).attr('name')+'" title="'+$(this).attr('title')+'" data-type="'+$(this).attr('data-type')+'" style="'+$(this).attr('style')+'" datafld="'+$(this).attr('datafld')+'" class="form_item AUTO"></select>');
                    that.tool.getMacrosDate($(this).attr("datafld"))(selectObj);
                    $(this).before(selectObj);
                    $(this).remove();
                }else{
                    $(this).val(that.tool.getMacrosDate($(this).attr("datafld")));
                }

            });

        });

    },
    DateRender:function(){
        this.option.eleObject.find(".laydate-icon").each(function(){
            var _this = $(this);
            var divObj = '<input name="'+_this.attr('name')+'" title="'+_this.attr('title')+'" class="form_item laydate-icon" data-type="calendar" id="'+_this.attr('name')+'"   date_format="'+_this.attr('date_format')+'"/>';
            _this.before(divObj);
            _this.remove();
        });
        this.option.eleObject.find(".laydate-icon").on("click",function(){
            var format = $(this).attr("date_format");
            var formatArr = '';
            if(format.split(' ').length > 1){
                formatArr = format.split(' ')[0].toUpperCase() + " " +format.split(' ')[1].toLowerCase();
            }else{
                formatArr = format.split(' ')[0].toUpperCase();
            }
            laydate({istime: true,format:formatArr});
        });
    },
    buildHTML:function(cb){
        var that = this;
        layer.load();
        that.tool.ajaxHtml(that.option.resdata,function (res) {
            if(res.flag){
                var formObj = res.object.flowFormType || res.object;
                if(formObj.printModel != ''){
                    //$(that.option.target).html(formObj.printModel);
                    if(that.option.flowStep != -1){
                        that.option.listFp = res.object.listFp
                    }
                    that.option.eleObject = $('<div>'+formObj.printModel+'</div>');
                    $(that.option.target).html(that.render());
                    layer.closeAll();
                }else{
                    layer.closeAll();
                    layer.msg('没有加载到数据。。', {icon: 6});
                    var noformdata = '<div class="cont_rig" style="text-align: center;margin-top: 200px;"><div class="noData_out"><div class="noDatas_pic"><img src="../../img/workflow/img_nomessage_03.png"></div><div class="noDatas">抱歉现在还没有表单，请您新建</div></div></div>'
                    $(that.option.target).html(noformdata);
                }
            }else{
                layer.closeAll();
            }
            if(cb){
                return cb(res);
            }
            return cb;
        });
    },
    getSearchData:function (cb) {
        var that = this;
        this.tool.ajaxHtml(this.option.resdata,function (data) {
            var formObj = data.object;
            that.option.eleObject = $('<div>'+formObj.printModel+'</div>');
            that.ReBuild();
            var arr = [];
            that.option.eleObject.find(".form_item").each(function () {
                var _this = $(this);
                var item = {
                    name:_this.attr('name'),
                    title:_this.attr("title"),
                    dataType:_this.attr('data-type')
                }
                arr.push(item);
            });
            cb(arr);
        })
    },
    tool:{
        MacrosDate:{
            option:{
                SYS_LIST_DEPT:true,//部门列表
                SYS_LIST_USER:true,//人员列表
                SYS_LIST_PRIV:true,//角色列表
                SYS_LIST_PRIV_ONLY:true,
                SYS_LIST_PRIV_OTHER:true,
                SYS_LIST_PRCSUSER1:true,
                SYS_LIST_PRCSUSER2:true,
                SYS_LIST_MANAGER1:true,
                SYS_LIST_MANAGER2:true,
                SYS_LIST_MANAGER3:true,
                SYS_LIST_SQL:true
            },
            data:{},
            SYS_LIST_DEPT :function(target){
                return target.deptSelect();//dept List
            },
            SYS_LIST_USER:function(target){
                var optionStr = '<option value="">请选择用户</option>';
                workForm.tool.MacrosDate.data.sYS_LIST_USER.forEach(function (v,i) {
                    optionStr+='<option value="'+v.uid+'">'+v.name+'</option>';
                });
                return target.html(optionStr);
            },
            SYS_LIST_PRIV:function (target) {
                var optionStr = '<option value="">请选择角色</option>';
                workForm.tool.MacrosDate.data.sYS_LIST_PRIV.forEach(function (v,i) {
                    optionStr+='<option value="'+v.userPriv+'">'+v.privName+'</option>';
                });
                return target.html(optionStr);
            },
            SYS_DATE_CN : function(){
                return new Date().Format("yyyy年MM月dd日");
            },
            SYS_DATE_CN_SHORT3 : function(){
                return new Date().Format("yyyy年");
            },
            SYS_DATE_CN_SHORT4 : function(){
                return new Date().Format("yyyy");
            },
            SYS_DATE_CN_SHORT1 : function(){
                return new Date().Format("yyyy年MM月");
            },
            SYS_DATE_CN_SHORT2 : function(){
                return new Date().Format("MM月dd日");
            },
            SYS_TIME : function(){
                return new Date().Format("yyyy-MM-dd  hh:mm:ss");
            },
            SYS_DATETIME : function(){
                return new Date().Format("yyyy-MM-dd  hh:mm:ss");
            },
            SYS_WEEK : function(){
                return "日一二三四五六".charAt(new Date().getDay());//星期几
            },
            SYS_USERID : function(){
                return workForm.tool.MacrosDate.data.sYS_USERID;
            },
            SYS_USERNAME : function(obj){
                return workForm.tool.MacrosDate.data.sYS_USERNAME;
            },
            SYS_DEPTNAME : function(){
                return workForm.tool.MacrosDate.data.sYS_DEPTNAME;
            },
            SYS_DEPTNAME_SHORT : function(){
                return workForm.tool.MacrosDate.data.sYS_DEPTNAME_SHORT;
            },
            SYS_USERPRIV : function(){
                return workForm.tool.MacrosDate.data.sYS_USERPRIV;
            },
            SYS_USERPRIVOTHER : function(){
                return workForm.tool.MacrosDate.data.sYS_USERPRIVOTHER;
            },
            SYS_USERNAME_DATE : function(){
                return workForm.tool.MacrosDate.data.sYS_USERNAME+' '+new Date().Format("yyyy-MM-dd");
            },
            SYS_USERNAME_DATETIME : function(){
                return workForm.tool.MacrosDate.data.sYS_USERNAME+' '+new Date().Format("yyyy-MM-dd hh:mm:ss");
            },
            SYS_FORMNAME : function(){
                return "";
            },
            SYS_RUNNAME : function(){
                return "";
            },
            SYS_RUNDATE : function(){
                return "";
            },
            SYS_RUNDATETIME : function(){
                return "";
            },
            SYS_RUNID : function(){
                return "";
            },
            SYS_AUTONUM : function(){
                return "";
            },
            SYS_AUTONUM_YEAR : function(){
                return "";
            },
            SYS_AUTONUM_MONTH : function(){
                return "";
            },
            SYS_IP : function(){
                return "";
            },
            SYS_MANAGER1 : function(){
                return "";
            },
            SYS_MANAGER2 : function(){
                return "";
            },
            SYS_MANAGER3 : function(){
                return "";
            },
            SYS_SQL : function(){
                return "";
            },

            SYS_DATE:function(){
                return new Date().Format("yyyy-MM-dd");
            },
            ready:function(options,cb){
                var that = this;
                $.ajax({
                    type: "get",
                    async: false,
                    url: "../../form/qureyCtrl?controlId=Macro&option="+options,
                    dataType: 'JSON',
                    success: function (res) {
                        that["data"] = res.object;
                        cb(that);
                    }
                })
            }
        },
        getMacrosDate:function(flag){
            return this.MacrosDate[flag];
        },
        ajaxHtml:function (data,cb) {
            var that = this;
            $.ajax({
                type: "get",
                url: workForm.option.formhtmlurl,
                dataType: 'JSON',
                data:  data,
                success: function (res) {
                    if(cb){
                        cb(res);
                    }
                },
                error:function(e){
                    console.log(e);
                }
            });
        },
        Date_format:function(date, format)
        {
            date = date.split(/\D/);
            format = format.split(/[^yMdhHms]+/);
            var real_format = 'y-M-d H:m:s';
            for(var k in format)
            {
                if((/([yMdhHms])+/).test(format[k]))
                {
                    // 兼容两位年份的情况
                    if(format[k]=='y' || format[k]=='yy')
                    {
                        if(78<=date[k] && 99>=date[k])
                        {
                            date[k] = '19' + date[k];
                        }
                        else
                        {
                            date[k] = '20' + date[k];
                        }
                    }
                    real_format = real_format.replace(RegExp.$1, date[k]);
                }
            }
            var date_now = new Date();
            var o =
                {
                    "M+" : date_now.getMonth()+1, //month
                    "d+" : date_now.getDate(),    //day
                    "h+" : '00',   //hour
                    "H+" : '00',   //hour
                    "m+" : '00', //minute
                    "s+" : '00' //second
                    // "q+" : Math.floor((date_now.getMonth()+3)/3),  //quarter
                    // "S" : date_now.getMilliseconds() //millisecond
                };
            if(/(y+)/.test(real_format))
            {
                real_format = real_format.replace(RegExp.$1,(date_now.getFullYear().toString()));
            }
            for(var k in o)
                if(new RegExp("("+ k +")").test(real_format))
                    real_format = real_format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
            return real_format;
        }
    }
}