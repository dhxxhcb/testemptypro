$(function(){
    showMenus($('#ulList table'))
    //下一级菜单
    $('#ulList').on('click','.nextRank',function(){
        $(this).addClass('refresh').parents('tr').siblings().find('.nextRank').removeClass('refresh');
        $('.monoidalSet').show().siblings().hide();
        var id=$(this).parents('tr').attr('childId');
        twoLevelMenu(id,$('.childMenu'));

    })
    //一级菜单编辑
    $('#ulList').on('click','.editOne',function(){
        $('.editClass').show().siblings().hide();
        var id=$(this).parents('tr').attr('childId');
        editOneLevelMenu(id)
    })
    //一级菜单编辑确定按钮
    $('#btn1').click(function(){
        editSave()
    })
    //一级菜单编辑返回按钮
    $('#btn2').click(function(){
        $('input[name="mainId"]').val('');
        $('input[name="mainName"]').val('');
        $('input[name="mainName1"]').val('');
        $('input[name="mainName2"]').val('');
        $('input[name="mainImg"]').val('');
        $('.addClass').show().siblings().hide();
    })
    //增加一级菜单主分类显示
    $('#Addspan').click(function(){
        $('.addClass').show().siblings().hide();
    })
    //增加一级菜单确定按钮
    $('#addBtn').click(function(){
        AddClassA();
    })
    //增加一级菜单返回按钮
    $('#backBtn').click(function(){
        $('input[name="id"]').val('');
        $('input[name="name"]').val('');
        $('input[name="name1"]').val('');
        $('input[name="name2"]').val('');
        $('input[name="img"]').val('');
    })
    //删除一级菜单
    $('#ulList').on('click','.deleteMenu',function(){
        var id=$(this).parents('tr').attr('childId');
        deleteMenu(id);
    })
    //子菜单项设置返回按钮
    $('#childrenBtn').click(function(){
        $('.addClass').show().siblings().hide();
    })
    //新建子菜单
    $('#childBtn').click(function(){
        $('.AddChild').show().siblings().hide();
    })
    //新建子菜单确定按钮
    $('#btn_sure').click(function(){
        var id=$('.refresh').parents('tr').attr('childId')
        addChildMenu(id,$('.childMenu'));
    })
    //新建子菜单返回按钮
    $('#btn_back').click(function(){
        $('.monoidalSet').show().siblings().hide();
    })
    //子菜单编辑
    $('.tab').on('click','.editChilds',function(){
        $('.editChild').show().siblings().hide();
        var id=$(this).parents('tr').attr('childernId');
        var len=id.length;
        var pId=id.substr(0,len-2);
        editChildMenu(id);
        editParentId(pId);
    })
    //子菜单编辑确定按钮
    $('#edBtn_sure').click(function(){
        var id=$('.refresh').parents('tr').attr('childId');
        saveChildEdit(id,$('.childMenu'));

        //$('.monoidalSet').show().siblings().hide();
    })
    //子菜单编辑返回按钮
    $('#edBtn_back').click(function(){
        $('.monoidalSet').show().siblings().hide();
    })
    //子菜单删除
    $('.tab').on('click','.deleteChild',function(){
        var Eid=$(this).parents('tr').attr('childernId');
        var id=$('.refresh').parents('tr').attr('childId');
        //deleteChildMenu(Eid);
        deleteChildMenu(Eid,id,$('.childMenu'));
    })



    function AddClassA(){
        var data={
            'id':$('input[name="id"]').val(),
            'name':$('input[name="name"]').val(),
            'name1':$('input[name="name1"]').val(),
            'name2':$('input[name="name2"]').val(),
            'img':$('input[name="img"]').val()
        }
        $.ajax({
            type:'get',
            url:'../../addSysMenu',
            dataType:'json',
            data:data,
            success:function(rsp){
                if(rsp.flag==true){
                    alert('新增成功');
                }else{
                    alert('新增失败');
                }
                //document.url=location.href;
                location.reload();
            }
        })
    }
    function editOneLevelMenu(id){
        $.ajax({
            type:'get',
            url:'../../getTheFirstMenu',
            dataType:'json',
            data:{'id':id},
            success:function(rsp){
                var data1=rsp.object;
                $('.editClass input[name="mainId"]').val('');
                $('.editClass input[name="mainName"]').val('');
                $('.editClass input[name="mainName1"]').val('');
                $('.editClass input[name="mainName2"]').val('');
                $('.editClass input[name="mainImg"]').val('');

                $('.editClass input[name="mainId"]').val(data1.id);
                $('.editClass input[name="mainName"]').val(data1.name);
                $('.editClass input[name="mainName1"]').val(data1.name1);
                $('.editClass input[name="mainName2"]').val(data1.name2);
                $('.editClass input[name="mainImg"]').val(data1.img);
            }
        })
    }
    function editSave(){
        var data={
            'id':$('input[name="mainId"]').val(),
            'name':$('input[name="mainName"]').val(),
            'name1':$('input[name="mainName1"]').val(),
            'name2':$('input[name="mainName2"]').val(),
            'img':$('input[name="mainImg"]').val()
        }
        $.ajax({
            type:'get',
            url:'../../updateFirstMenu',
            dataType:'json',
            data:data,
            success:function(rsp){
                if(rsp.flag==true){
                    alert('修改成功');
                }else{
                    alert('修改失败');
                }
                location.reload();
            }
        })
    }
    function saveChildEdit(id,element){
        var data={
            'fId':$('.editChild input[name="editfId"]').val(),
            'parentId':$('.editChild select[name="editParentId"] option:checked').val(),
            'id':$('.editChild input[name="editId"]').val(),
            'name':$('.editChild input[name="editName"]').val(),
            'url':$('.editChild input[name="editUrl"]').val()
        }
        $.ajax({
            type:'post',
            url:'../../editSysFunction',
            dataType:'json',
            data:data,
            success:function(rsp){
                if(rsp.flag==true){
                    alert('修改成功');
                }else{
                    alert('修改失败');
                }
                $('.monoidalSet').show().siblings().hide();
                twoLevelMenu(id,element);
            }

        })

    }
    function addChildMenu(id,element){
        var data={
            'fId':$('input[name="addfId"]').val(),
            'parentId':$('select[name="addParentId"] option:checked').val(),
            'id':$('input[name="addId"]').val(),
            'name':$('input[name="addName"]').val(),
            'url':$('input[name="addUrl"]').val()
        }
        $.ajax({
            type:'post',
            url:'../../addFunction',
            dataType:'json',
            data:data,
            success:function(rsp){
                if(rsp.flag==true){
                    alert('新建成功');
                }else{
                    alert('新建失败');
                }
                $('.monoidalSet').show().siblings().hide();
                twoLevelMenu(id,element);
            }
        })
    }
    function editChildMenu(id){
        $.ajax({
            type:'get',
            url:'../../findChildMenu',
            dataType:'json',
            data:{'id':id},
            success:function(rsp){
                var data1=rsp.obj;
                $('.editChild input[name="editfId"]').val('');

                $('.editChild input[name="editId"]').val('');
                $('.editChild input[name="editName"]').val('');
                $('.editChild input[name="editUrl"]').val('');

                for(var i=0;i<data1.length;i++){
                    var chId=data1[i].id;
                    var nId=chId.substr(-2);
                    $('.editChild input[name="editfId"]').val(data1[i].fId);

                    $('.editChild input[name="editId"]').val(nId);
                    $('.editChild input[name="editName"]').val(data1[i].name);
                    $('.editChild input[name="editUrl"]').val(data1[i].url);
                }
            }
        })
    }
    function editParentId(pId){
        $.ajax({
            type:'get',
            url:'../../getTheFirstMenu',
            dataType:'json',
            data:{'id':pId},
            success:function(rsp){
                var data2=rsp.object;
                $('.editChild select[name="editParentId"] option:checked').html('');
                $('.editChild select[name="editParentId"] option:checked').html(data2.name);
                $('.editChild select[name="editParentId"] option:checked').val(pId);
            }
        })
    }
    function deleteChildMenu(Eid,id,element){
        var msg='确认删除？';
        if (confirm(msg)==true){
            $.ajax({
                type:'get',
                url:'../../deleteSysMenu',
                dataType:'json',
                data:{'id':Eid},
                success:function(){
                    $('.monoidalSet').show().siblings().hide();
                    twoLevelMenu(id,element);
                }
            })
            return true;
        }else{
            return false;
        }
    }
})

function showMenus(element){
    $.ajax({
        type:'get',
        url:'../../showMenu',
        dataType:'json',
        success:function(rsp){
            var data=rsp.obj;
            var str='';
            for(var i=0;i<data.length;i++){
                str+='<tr childId="'+data[i].id+'"><td width="45%"><span><img class="one_logo" src="../../img/main_img/'+data[i].img+'.png"></span><span class="margspan">'+data[i].id+'</span><span>'+data[i].name+'</span></td><td width="54.5%"><a href="javascript:;" class="editOne">编辑</a><a href="javascript:;" class="nextRank">下一级</a><a href="javascript:;" class="deleteMenu">删除</a></td></tr>'
            }
            element.append(str);
        }
    })
}
function twoLevelMenu(id,element){
    $('.add_children').remove();
    $.ajax({
        type:'get',
        url:'../../findChildMenu',
        dataType:'json',
        data:{'id':id},
        success:function(rsp){
            var data1=rsp.obj;
            var str="";
            for(var i=0;i<data1.length;i++){
                str+='<tr class="add_children" childernId="'+data1[i].id+'"><td width="40%"><span class="margspan" style="margin: 0 10px">'+data1[i].id+'</span><span>'+data1[i].name+'</span></td><td width="59.5%"><a href="javascript:;" class="editChilds">编辑</a><a href="javascript:;" class="deleteChild">删除</a><a href="javascript:;">添加权限</a><a href="javascript:;">删除权限</a></td></tr>'
            }
            element.after(str);
        }
    })
}
function deleteMenu(id){
    var msg='确认删除？';
    if (confirm(msg)==true){
        $.ajax({
            type:'get',
            url:'../../deleteSysMenu',
            dataType:'json',
            data:{'id':id},
            success:function(){
                location.reload();
            }
        })
        return true;
    }else{
        return false;
    }
}



