var workForm = {
    formhtmlurl : '../../form/formType',
    render:function(){
        this.DateRender();
        this.ReBuild();
        this.MacrosRender();
    },
    ReBuild:function(){
        $("input").each(function(){
            $(this).addClass("form_item");
            $(this).attr("id",$(this).attr("name"));
        });
        $("textarea").each(function(){
            $(this).addClass("form_item");
            $(this).attr("id",$(this).attr("name"));
        });

    },
    MacrosRender:function(){
        that = this;
        $(".AUTO").each(function(){

            $(this).val(that.tool.getMacrosDate($(this).attr("datafld")));
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
    buildHTML:function(target,formid){
        var that = this;
        $.ajax({
            type: "get",
            url: that.formhtmlurl,
            dataType: 'JSON',
            data: {
                fromId :formid
            },
            success: function (res) {

                target.html(res.object.printModel);
                that.render();
            }
        });
    },
    tool:{
        MacrosDate:{
            SYS_DATE:function(){
                return new Date().Format("yyyy-MM-dd");
            }
        },
        getMacrosDate:function(flag){
            return MacrosDate[flag];
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