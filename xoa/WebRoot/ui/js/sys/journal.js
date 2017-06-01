
$(function(){
    journalSurveyShow();
    journalListShow();
    //日志概况点击事件
    $('#survey').click(function(){
        $(this).find('span').addClass('one');
        $(this).siblings().find('span').removeClass('one');
        $('.journalSurvey').show().siblings().hide();
        journalSurveyShow();
    })
    //年度数据点击事件
    $('#DATA').click(function(){
        $(this).find('span').addClass('one');
        $(this).siblings().find('span').removeClass('one');
        $('.yearData').show().siblings().hide();
        selectMonth();

    })
    //时段统计点击事件
    $('#statistics').click(function(){
        $(this).find('span').addClass('one');
        $(this).siblings().find('span').removeClass('one');
        $('.timeInterval').show().siblings().hide();
        periodStatistics();
    })
    //日志管理点击事件
    $('#administration').click(function(){
        $(this).find('span').addClass('one');
        $(this).siblings().find('span').removeClass('one');
        $('.journalQuery').show().siblings().hide();
        allJournalType();
        $('.Query').prop('checked',true);
    })
    //查询结果页返回按钮点击事件
    $('#divBack').click(function(){
        $('.journalQuery').show().siblings().hide();
    })
    //日志查询确定点击事件
    $('.sureBtn').on('click','#Btn',function(){
        //单选框选中事件
        if($('input[name="TYPE"]:checked').val()==1){//选中查询
            $('.queryResult').show().siblings().hide();
            queryShow();
        }else if($('input[name="TYPE"]:checked').val()==2){//选中导出
            journalExport();
        }else{                                          //选中删除
            journalDelete();
        }
    })
    //复选框全选点击事件
    $('#checkedAll').click(function(){
        var state =$(this).prop("checked");
        if(state==true){
            $(this).prop("checked",true);
            $(".checkChild").prop("checked",true);
        }else{
            $(this).prop("checked",false);
            $(".checkChild").prop("checked",false);;
        }
    })
    //查询列表删除事件
    $('#delete').click(function(){
        var fileId=[];
        $(".checkChild:checkbox:checked").each(function(){
            var conId=$(this).attr("logId");
            fileId.push(conId);
        })
        //alert(fileId);
        deleteAllJournal(fileId);
    })
    //日志概况显示数据
    function journalSurveyShow(){
        $.ajax({
            type:'get',
            url:'../../sys/getLogMessage',
            dataType:'json',
            success:function(rsp){
                var data=rsp.object;
                $('.totalDay').text(data.totalDay);
                $('.totalCount').text(data.totalCount);
                $('.yearCount').text(data.yearCount);
                $('.mouthCount').text(data.mouthCount);
                $('.dayCount').text(data.dayCount);
                $('.averageDayCount').text(data.averageDayCount);
            }
        })
    }
    //日志显示列表
    function journalListShow(){
        $.ajax({
            type:'get',
            url:'../../sys/getTenLog',
            dataType:'json',
            success:function(rsp){
                var data=rsp.object;
                var str='';
                for(var i=0;i<data.length;i++){
                    var sendTime=new Date(data[i].time).Format('yyyy-MM-dd hh:mm');
                    str+='<tr class="newData"><td>'+data[i].userName+'</td><td>'+sendTime+'</td><td>'+data[i].ip+'</td><td>'+data[i].typeName+'</td></tr>'
                }
                $('.newly').after(str);
            }
        })
    }
    //月份显示
    function selectMonth(){
        $('#seleMonth').find('option').remove();
        var data={
            'year':$('#select option:checked').val()
        }
        $.ajax({
            type:'get',
            url:'../../sys/getMonth',
            dataType:'json',
            data:data,
            success:function(rsp){
                var str='';
                for(var i=1;i<rsp.object+1;i++){
                    str+='<option value="'+i+'">'+i+'月</option>';
                }
                $('#seleMonth').append(str);
                monthJournal();
            }
        })
    }
    //月份改变事件
    $('#seleMonth').change(function(){
        var opt=$('#seleMonth option:checked').val();
        $('.monthSpan').text(opt);
        monthJournal()
    })
    //日志月度访问数据、日访问数据
    function monthJournal(){
        $('.dayData').remove();
        $('.monthData').remove();
        var data={
            'year':$('#select option:checked').val(),
            'month':$('#seleMonth option:checked').val()
        }
        $.ajax({
            type:'get',
            url:'../../sys/getEachMouthLogData',
            dataType:'json',
            data:data,
            success:function(rsp){
                if(rsp.flag){
                    var data1=rsp.object.monthData;//月度访问数据
                    var data2=rsp.object.dayData;//日访问数据
                    var str='';
                    var str1='';
                    var i=0;
                    for(var j=0;j<data1[i].length;j++){
                        str+='<tr class="monthData"><td>'+(j+1)+'月</td><td>'+data1[i+1][j]+'</td><td>'+data1[i][j]+'</td></tr>'
                    }
                    $('.yearJournal').after(str);
                    for(var n=0;n<data2[i].length;n++){
                        str1+='<tr class="dayData"><td>'+(n+1)+'</td><td>'+data2[i+1][n]+'</td><td>'+data2[i][n]+'</td></tr>'
                    }
                    $('.monthJournal').after(str1);
                }
            }
        })
    }
    //时段统计数据
    function periodStatistics(){
        $.ajax({
            type:'get',
            url:'../../sys/getHourLog',
            dataType:'json',
            success:function(rsp){
                if(rsp.flag){
                    var data=rsp.obj;
                    var str='';
                    var i=0;
                    for(var j=0;j<data[i].length;j++){
                        str+='<tr><td>'+j+'</td><td>'+data[i+1][j]+'</td><td>'+data[i][j]+'</td></tr>';
                    }
                    $('.period').after(str);
                }
            }
        })
    }
    //日志类型
    function allJournalType(){
        $.ajax({
            type:'get',
            url:'../../sys/getLogType',
            dataType:'json',
            success:function(rsp){
                var data=rsp.obj;
                var str='';
                for(var i=0;i<data.length;i++){
                    str+='<option value="'+data[i].codeNo+'">'+data[i].codeName+'</option>'
                }
                $('#journalType').append(str);
            }
        })
    }
    //查询日志显示列表
    function queryShow(){
        $('.AllData').remove();
        var id=$('#senduser').attr('dataid');
        if(!id){
            id='';
        }
        var data={
            'type':$('#journalType option:checked').val(),
            'uid':id,
            'startTime':$('#start').val(),
            'endTime':$('#end').val(),
            'ip':$('#IP').val(),
            'remark':$('#remarks').val()
        }
        $.ajax({
            type:'get',
            url:'../../sys/logManage',
            dataType:'json',
            data:data,
            success:function(res){
                var data1=res.obj;
                var str='';
                for(var i=0;i<data1.length;i++){
                    var sendTime=new Date(data1[i].time).Format('yyyy-MM-dd hh:mm');
                    str+='<tr class="AllData"><td><input logId="'+data1[i].logId+'" class="checkChild" type="checkbox" name="checke" value=""></td><td>'+data1[i].userName+'</td><td>'+sendTime+'</td><td>'+data1[i].ip+'</td><td>'+data1[i].ipLocation+'</td><td>'+data1[i].typeName+'</td><td>'+data1[i].remark+'</td></tr>';
                }
                $('.queryJournalList').after(str);
                $(".checkChild").click(function () {
                    var state=$(this).prop("checked");
                    if(state==true){
                        $(this).prop("checked",true);
                    }else{
                        $('#checkedAll').prop("checked",false);
                        $(this).prop("checked",false);
                    }
                    var child =   $(".checkChild");
                    for(var i=0;i<child.length;i++){
                        var childstate= $(child[i]).prop("checked");
                        if(state!=childstate){
                            return
                        }
                    }
                    $('#checkedAll').prop("checked",state);
                })
            }
        })
    }
    //查询数据导出
    function journalExport(){
        var id=$('#senduser').attr('dataid');
        if(!id){
            id='';
        }
        var data={
            'type':$('#journalType option:checked').val(),
            'uid':id,
            'startTime':$('#start').val(),
            'endTime':$('#end').val(),
            'ip':$('#IP').val(),
            'remark':$('#remarks').val()
        }
        $.ajax({
            type:'post',
            url:'../../sys/exportLogXls',
            dataType:'json',
            data:data,
            success:function(){
                alert('导出成功');
            }
        })
    }
    //查询数据删除
    function journalDelete(){
        var id=$('#senduser').attr('dataid');
        if(!id){
            id='';
        }
        var data={
            'type':$('#journalType option:checked').val(),
            'uid':id,
            'startTime':$('#start').val(),
            'endTime':$('#end').val(),
            'ip':$('#IP').val(),
            'remark':$('#remarks').val()
        }
        var msg='确定要删除吗？';
        if (confirm(msg)==true){
            $.ajax({
                type:'post',
                url:'../../sys/deleteSyslog',
                dataType:'json',
                data:data,
                success:function(res){
                    console.log(res.flag);
                }
            });
            return true;
        }else{
            return false;
        }
    }
    //列表删除（可多条）
    function deleteAllJournal(id){
        var msg='确定要删除吗？';
        if (confirm(msg)==true){
            $.ajax({
                type:'post',
                url:'../../sys/deleteLogByIds',
                dataType:'json',
                data:{'ids':id},
                success:function(res){
                    console.log(res.json);
                }
            })
            return true;
        }else{
            return false;
        }
    }
})
