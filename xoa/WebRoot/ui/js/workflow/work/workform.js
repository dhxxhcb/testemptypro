var workForm = {
    formhtmlurl : '../../form/formType',
    render:function(){
        this.bindDateEvent();
    },
    bindDateEvent:function(){
        console.log( $('img.DATE').length);
        //过滤老版本数据

        var olddata = $('img.DATE');
        for(var i=0;i< olddata.length;i++){
            var obj = olddata.eq(i);
            var objprev = obj.prev();
            var date_format =  obj.attr('date_format');
            var name = objprev.attr('name')
            // var laydate = 'laydate({istime: true,format:"YYYY-MM-DD hh:mm:ss"})';
            var laydate = 'laydate({istime: true})';
            //var inputObj = '<div id="'+name+'" date_format="'+date_format+'" name="'+name+'"  style="'+objprev.attr('style')+'" title="'+objprev.attr('title')+'" class="laydate-icon form_item" onclick="'+laydate+'"></div>';
            var inputObj = '<div id="'+name+'" date_format="'+date_format+'" name="'+name+'"  style="'+objprev.attr('style')+'" title="'+objprev.attr('title')+'" class="laydate-icon form_item" onclick="laydate({istime: true,format:"'+date_format+'"})"></div>';

            olddata.eq(i).prev().remove();
            olddata.eq(i).before(inputObj);
            olddata.eq(i).remove();

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
    }
}