var workForm = {
    option : {
        formhtmlurl : '../../form/formType',
        formid : 1,
        target:""
    },
    init:function(options,cb){
        var _this = this;
        $.extend( _this.option, options );
        _this.buildHTML(cb);
    },
    render:function(){
        this.ReBuild();
        this.MacrosRender();
        this.RadioRender();
        this.DateRender();
    },
    filter:function(){
        this.MacrosRender();
    },
    RadioRender:function(){
        $('input[data-type="radio"]').each(function(){
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
                    eleStr+='<input name="'+name+'" title="'+title+'" type="radio" class="form_item"/>'+v+' ';
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
            target = $("body");
        }
        target.find("input").each(function(){
            var _this = $(this);
            if(_this.attr("class") &&  _this.attr("class").indexOf('AUTO') > -1){
                _this.attr("data-type","macros");
            }else{
                _this.attr("data-type",$(this).attr("type"));
            }
            _this.addClass("form_item");
            _this.attr("id",$(this).attr("name"));
        });
        target.find('img.DATE').each(function(){
            var _this = $(this);
            var objprev = _this.prev();
            var inputObj = '<input name="'+objprev.attr('name')+'" title="'+objprev.attr('title')+'" class="form_item laydate-icon" data-type="calendar" id="'+objprev.attr('name')+'" value="'+_this.attr('date_format')+'"  date_format="'+_this.attr('date_format')+'"/>';
            objprev.remove();
            _this.before(inputObj);
            _this.remove();
        });
        target.find("textarea").each(function(){
            $(this).addClass("form_item");
            $(this).attr("data-type","textarea");
            $(this).attr("id",$(this).attr("name"));
        });
        target.find("img.RADIO").each(function(){
            var _this = $(this);
            var radioStr = ' <input name="'+_this.attr('name')+'" checked="checked" id="'+_this.attr('name')+'" title="'+_this.attr('title')+'" type="radio"  radio_field="'+_this.attr('radio_field')+'" orgchecked="'+_this.attr('radio_checked')+'" classname="radio" class="form_item" data-type="radio" />';
            _this.before(radioStr);
            _this.remove();
        });
    },
    MacrosRender:function(){
        that = this;
        var flagStr = "";
        $(".AUTO").each(function(index,obj){
            if(that.tool.MacrosDate.option[$(this).attr("datafld")]){
                flagStr+=($(this).attr("datafld")+',');
            }
        });
        that.tool.MacrosDate.ready(flagStr,function(MacrosDate){
            $(".AUTO").each(function(index,obj){
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
        $(".laydate-icon").each(function(){
            var _this = $(this);
            var divObj = '<input name="'+_this.attr('name')+'" title="'+_this.attr('title')+'" class="form_item laydate-icon" data-type="calendar" id="'+_this.attr('name')+'"   date_format="'+_this.attr('date_format')+'"/>';
            _this.before(divObj);
            _this.remove();
        });
        $(".laydate-icon").on("click",function(){
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
        $.ajax({
            type: "get",
            url: that.option.formhtmlurl,
            dataType: 'JSON',
            data:  that.option.resdata,
            success: function (res) {
                if(res.flag){
                    var formHtml = res.object.flowFormType || res.object;

                    // that.option.target.html(res.object.printModel);
                    if(formHtml.printModel != ''){
                        that.option.target.html(formHtml.printModel);
                        that.render();
                        layer.closeAll();
                    }else{
                        layer.closeAll();
                        layer.msg('没有加载到数据。。', {icon: 6});
                        var noformdata = '<div class="cont_rig" style="text-align: center;margin-top: 200px;"><div class="noData_out"><div class="noDatas_pic"><img src="../../img/workflow/img_nomessage_03.png"></div><div class="noDatas">抱歉现在还没有表单，请您新建</div></div></div>'
                        that.option.target.html(noformdata);
                    }

                }else{
                    layer.closeAll();
                }
                if(cb){
                    return cb(res);
                }
                return cb;

            }
        });
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
                return "";
            },
            SYS_DATE_CN_SHORT3 : function(){
                return "";
            },
            SYS_DATE_CN_SHORT4 : function(){
                return "";
            },
            SYS_DATE_CN_SHORT1 : function(){
                return "";
            },
            SYS_DATE_CN_SHORT2 : function(){
                return "";
            },
            SYS_TIME : function(){
                return "";
            },
            SYS_DATETIME : function(){
                return "";
            },
            SYS_WEEK : function(){
                return "";
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
                return workForm.tool.MacrosDate.data.sYS_USERNAME+' '+new Date().Format("yyyy-MM-dd hh:mm:ss");
            },
            SYS_USERNAME_DATETIME : function(){
                return "";
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