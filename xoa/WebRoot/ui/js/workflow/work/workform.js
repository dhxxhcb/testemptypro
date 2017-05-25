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
        this.DateRender();
        this.ReBuild();
        this.MacrosRender();
        this.RadioRender();
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
    ReBuild:function(){
        $("input").each(function(){
            $(this).addClass("form_item");
            $(this).attr("data-type",$(this).attr("type"));
            $(this).attr("id",$(this).attr("name"));
        });
        $("textarea").each(function(){
            $(this).addClass("form_item");
            $(this).attr("id",$(this).attr("name"));
        });
        $('img.RADIO').each(function(){
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
                $(this).val(that.tool.getMacrosDate($(this).attr("datafld")));
            });

        });

    },
    DateRender:function(){
        //过滤老版本数据
        var olddata = $('img.DATE');
        for(var i=0;i< olddata.length;i++){
            var obj = olddata.eq(i);
            var objprev = obj.prev();
            var date_format =  obj.attr('date_format');
            var name = objprev.attr('name')
            var inputObj = '<div id="'+name+'" date_format="'+date_format+'" name="'+name+'"  style="'+objprev.attr('style')+'" title="'+objprev.attr('title')+'" class="laydate-icon form_item" ></div>';
            olddata.eq(i).prev().remove();
            olddata.eq(i).before(inputObj);
            olddata.eq(i).remove();
            $(".laydate-icon").on("click",function(){
                var format = $(this).attr("date_format");
                var formatArr = format.split(' ')[0].toUpperCase() + " " +format.split(' ')[1].toLowerCase();
                laydate({istime: true,format:formatArr});
            });
        }
        $('img.DATE').prev().on("click",function(){
            console.log(22);
            laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})
        })
    },
    buildHTML:function(cb){
        var that = this;
        $.ajax({
            type: "get",
            url: that.option.formhtmlurl,
            dataType: 'JSON',
            data: {
                flowId :that.option.formid
            },
            success: function (res) {

                that.option.target.html(res.object.printModel);
                that.render();
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
                return "";
            },
            SYS_USERNAME : function(obj){
                console.log(workForm.tool.MacrosDate)
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
                return "";
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
                        console.log(res.object);
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