/**
 * Created by gaosubo-sheji on 2017/6/2.
 */
$(function(){
    //在职人员树状图展示
    getChDept($('#ULDown'),30);
    $('.AUP').click(function(){
        //$('#ulList').slideToggle();
        if($('#ULDown').css('display')=='block'){
            $(this).addClass('liUp').removeClass('liDown');
            $('#ULDown').slideUp();
        }else{
            $(this).addClass('liDown').removeClass('liUp');
            $('#ULDown').slideDown();
        }
    })
    //人员查询点击事件
    $('#QUERY').click(function(){
        $('.queryUser').show().siblings().hide();
    })
    //全部人员点击事件
    $('#ALLP').click(function(){
        $('.allPerson').show().siblings().hide();
        var data={'choice':1};
        queryAllPerson(data,$('.trAllPerson'));
    })
    //外出人员点击事件
    $('#OUTP').click(function(){
        $('.outPerson').show().siblings().hide();
    })
    //查询按钮点击事件
    $('#submit').click(function(){
        $('.conditionQuery').show().siblings().hide();
        var data={
            'userId':$('input[name="userId"]').val(),
            'userName':$('input[name="userName"]').val(),
            'sex:':$('select[name="sex"] option:checked').val(),
            'deptId':$('select[name="unit"] option:checked').val(),
            'userPrivNo':$('select[name="user"] option:checked').val(),
            'choice':1
        }
        queryAllPerson(data,$('.Condition'));
    })
})

//部门人员树状图方法
function getChDept(element,deptId){

    $.ajax({
        url:'/department/getChDept',
        type:'get',
        data:{'deptId':deptId },
        dataType:'json',
        success:function(data){

            if(deptId==30){
                var str = '';
                data.obj.forEach(function(v,i){
                    if(v.deptName){
                        str+='<li><span deptid="'+v.deptId+'" class="childdept"><img style="margin-left: 42px;margin-right: 5px" src="../img/main_img/company_logo.png" alt=""><a href="#" class="dynatree-title" title="'+v.deptName+'">'+v.deptName+'</a></span><ul></ul></li>';
                    }else{
                        str+='<li><span deptid="'+v.deptId+'" class="childdept"><span><img style="margin-left: 65px;margin-right: 5px" src="../img/main_img/man.png" alt=""></span><img style="margin-left: 65px;margin-right: 5px" src="../img/main_img/man.png" alt=""><a href="#" class="dynatree-title" title="'+v.userName+'">'+v.userName+'</a></span><ul></ul></li>';
                    }
                });
            }else{
                var str = '';
                data.obj.forEach(function(v,i){
                    if(v.deptName){
                        str+='<li><span deptid="'+v.deptId+'" class="childdept"><img style="margin-left: 65px;margin-right: 5px" src="../img/main_img/company_logo.png" alt=""><a href="#" class="dynatree-title" title="'+v.deptName+'">'+v.deptName+'</a></span><ul></ul></li>';
                    }else{
                        if(v.sex==0){
                            str+='<li><span deptid="'+v.deptId+'" class="childdept"><img style="margin-left: 65px;margin-right: 5px" src="../img/main_img/man.png" alt=""><a href="#" class="dynatree-title" title="'+v.userName+'">'+v.userName+'</a></span><ul></ul></li>';
                        }else if(v.sex==1){
                            str+='<li><span deptid="'+v.deptId+'" class="childdept"><img style="margin-left: 65px;margin-right: 5px" src="../img/main_img/women.png" alt=""><a href="#" class="dynatree-title" title="'+v.userName+'">'+v.userName+'</a></span><ul></ul></li>';
                        }
                    }

                });
            }
            element.html(str);
        }
    })
}
//查询所有人员
function queryAllPerson(data,element){
    $('.loopData').remove();
    $.ajax({
        type:'get',
        url:'../getUserbyCondition',
        dataType:'json',
        data:data,
        success:function(res){
            var data1=res.obj;
            var str='';
            for(var i=0;i<data1.length;i++){
                var txt=data1[i].sex==0?'男':'女';
                str+='<tr class="loopData"><td>'+data1[i].dep.deptName+'</td><td>'+data1[i].userPrivName+'</td><td>'+data1[i].userName+'</td><td>'+data1[i].online+'</td><td>'+txt+'</td><td>'+data1[i].telNoDept+'</td><td>'+data1[i].mobilNo+'</td><td>'+data1[i].email+'</td></tr>'
            }
            element.after(str);
        }
    })
}