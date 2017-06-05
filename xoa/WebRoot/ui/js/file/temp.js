$(function () {
    var used=[];
	var data={};
    var userId={};
    var newUser={};
    var manageUser={};
    var delUser={};
    var downUser={};
    var shareUser={};
    var owner={};
    var signUser={};
    var review={};
    var description={};


	$('.nav ul li').click(function () {

       var span = $('.nav ul li span');
       for(var i=0;i<span.length;i++){
         	if($(span[i]).attr('class')=='headli one'){
                renderDate($(span[i]).attr("id"));
                renderShow($(this).find('span').attr("id"));
			};
	   }
        $(this).find('.headli').addClass('one').end().siblings().find('.headli').removeClass('one');
		cleanDate($(this).find('span').attr("id"));

	})
function renderShow(id) {
    if(id=='visit'){
    	if(userId['data']){
            $('#Senduser').val(userId['data'].userStr);
            $('#SendCompany').val(userId['data'].deptStr);
            $('#SendPriv').val(userId['data'].roleStr);
		}

    };
    if(id=='add'){
    	if(newUser['data']){
            $('#Senduser').val(newUser['data'].userStr);
            $('#SendCompany').val(newUser['data'].deptStr);
            $('#SendPriv').val(newUser['data'].roleStr);
		}

    };
    if(id=='edit'){
        if(manageUser['data']){
            $('#Senduser').val(manageUser['data'].userStr);
            $('#SendCompany').val(manageUser['data'].deptStr);
            $('#SendPriv').val(manageUser['data'].roleStr);
        }

    };
    if(id=='comment'){
        if(review['data']){
            $('#Senduser').val(review['data'].userStr);
            $('#SendCompany').val(review['data'].deptStr);
            $('#SendPriv').val(review['data'].roleStr);
        }

    };
    if(id=='download'){
        if(downUser['data']){
            $('#Senduser').val(downUser['data'].userStr);
            $('#SendCompany').val(downUser['data'].deptStr);
            $('#SendPriv').val(downUser['data'].roleStr);
        }

    };
    if(id=='sign'){
        if(signUser['data']){
            $('#Senduser').val(signUser['data'].userStr);
            $('#SendCompany').val(signUser['data'].deptStr);
            $('#SendPriv').val(signUser['data'].roleStr);
        }

    };
    if(id=='all'){
        if(owner['data']){
            $('#Senduser').val(owner['data'].userStr);
            $('#SendCompany').val(owner['data'].deptStr);
            $('#SendPriv').val(owner['data'].roleStr);
        }

    };
    if(id=='delete'){
        if(delUser['data']){
            $('#Senduser').val(delUser['data'].userStr);
            $('#SendCompany').val(delUser['data'].deptStr);
            $('#SendPriv').val(delUser['data'].roleStr);
        }

    };

}
function cleanDate(id) {
    for(var i=0;i<used.length;i++){
    	if(used[i]==id){
    		return;
		}
	}
    $('#Senduser').val("");
    $('#SendCompany').val("");
    $('#SendPriv').val("");
}
function renderDate(id) {
    if(id=='visit'){
        userId["user"]=$('#Senduser').attr('user_id');
        userId["dept"]=$('#SendCompany').attr('deptid');
        userId["role"]=$('#SendPriv').attr('userpriv');
        userId["data"]={
            userStr:$('#Senduser').val(),
            deptStr:$('#SendCompany').val(),
            roleStr:$('#SendPriv').val(),
		}
        data["userId"]=userId;
        used.push('visit');
    };
    if(id=='add'){
        newUser["user"]=$('#Senduser').attr('user_id');
        newUser["dept"]=$('#SendCompany').attr('deptid');
        newUser["role"]=$('#SendPriv').attr('userpriv');
        newUser["data"]={
            userStr:$('#Senduser').val(),
            deptStr:$('#SendCompany').val(),
            roleStr:$('#SendPriv').val(),
        }
        data["newUser"]=newUser;
        used.push('add');
    };
    if(id=='edit'){
        manageUser["user"]=$('#Senduser').attr('user_id');
        manageUser["dept"]=$('#SendCompany').attr('deptid');
        manageUser["role"]=$('#SendPriv').attr('userpriv');
        manageUser["data"]={
            userStr:$('#Senduser').val(),
            deptStr:$('#SendCompany').val(),
            roleStr:$('#SendPriv').val(),
        }
        data["manageUser"]=manageUser;
        used.push('edit');
    };
    if(id=='delete'){
        delUser["user"]=$('#Senduser').attr('user_id');
        delUser["dept"]=$('#SendCompany').attr('deptid');
        delUser["role"]=$('#SendPriv').attr('userpriv');
        delUser["data"]={
            userStr:$('#Senduser').val(),
            deptStr:$('#SendCompany').val(),
            roleStr:$('#SendPriv').val(),
        }
        data["delUser"]=delUser;
        used.push('delete');
    };
    if(id=='comment'){
        review["user"]=$('#Senduser').attr('user_id');
        review["dept"]=$('#SendCompany').attr('deptid');
        review["role"]=$('#SendPriv').attr('userpriv');
        review["data"]={
            userStr:$('#Senduser').val(),
            deptStr:$('#SendCompany').val(),
            roleStr:$('#SendPriv').val(),
        }
        data["review"]=review;
        used.push('comment');
    };
    if(id=='download'){
        downUser["user"]=$('#Senduser').attr('user_id');
        downUser["dept"]=$('#SendCompany').attr('deptid');
        downUser["role"]=$('#SendPriv').attr('userpriv');
        downUser["data"]={
            userStr:$('#Senduser').val(),
            deptStr:$('#SendCompany').val(),
            roleStr:$('#SendPriv').val(),
        }
        data["downUser"]=downUser;
        used.push('download');
    };
    if(id=='sign'){
        signUser["user"]=$('#Senduser').attr('user_id');
        signUser["dept"]=$('#SendCompany').attr('deptid');
        signUser["role"]=$('#SendPriv').attr('userpriv');
        signUser["data"]={
            userStr:$('#Senduser').val(),
            deptStr:$('#SendCompany').val(),
            roleStr:$('#SendPriv').val(),
        }
        data["signUser"]=signUser;
        used.push('sign');
    };
    if(id=='all'){
        owner["user"]=$('#Senduser').attr('user_id');
        owner["dept"]=$('#SendCompany').attr('deptid');
        owner["role"]=$('#SendPriv').attr('userpriv');
        owner["data"]={
            userStr:$('#Senduser').val(),
            deptStr:$('#SendCompany').val(),
            roleStr:$('#SendPriv').val(),
        }
        data["owner"]=owner;
        used.push('all');
    };
}

    //批量设置点击事件
	$('#batchSettings').click(function () {
		$('.tabTypeTwo').show();
		$('.tabTypeOne').hide();
	})
	//访问权限点击事件
	$('#visitJurisd').click(function () {
		$('.tabTypeOne').show();
		$('.tabTypeTwo').hide();
	})
    $('#addJurisd').click(function () {
        $('.tabTypeOne').show();
        $('.tabTypeTwo').hide();
    })
    $('#editJurisd').click(function () {
        $('.tabTypeOne').show();
        $('.tabTypeTwo').hide();
    })
    $('#deleteJurisd').click(function () {
        $('.tabTypeOne').show();
        $('.tabTypeTwo').hide();
    })
    $('#commentJurisd').click(function () {
        $('.tabTypeOne').show();
        $('.tabTypeTwo').hide();
    })
    $('#downloadJurisd').click(function () {
        $('.tabTypeOne').show();
        $('.tabTypeTwo').hide();
    })
    $('#signJurisd').click(function () {
        $('.tabTypeOne').show();
        $('.tabTypeTwo').hide();
    })
    $('#owner').click(function () {
        $('.tabTypeOne').show();
        $('.tabTypeTwo').hide();
    })

	//获取地址栏参数
    var sortId=$.getQueryString('sortId');

	$('#btnSure').click(function(){

        var span = $('.nav ul li span');
        console.log(span);
        for(var i=0;i<span.length;i++){
        	console.log('for');
            if($(span[i]).attr('class')=='headli one'){
                renderDate($(span[i]).attr("id"));
            };
        }
        data['sortId']=sortId
		console.log(data);
       /* $.post("<%=basePath%>file/setFileAuth",{auth:JSON.stringify(data)},function (ret) {
            alert(ret);
        });*/
        saveJurisd(data);
        // if($('#visit').attr('class')=='headli one'){
			// alert('1');
        // }else if($('#add').attr('class')=='headli one'){
			// alert('2');
        // }else if($('#edit').attr('class')=='headli one'){
        //     alert('3');
        // }else if($('#delete').attr('class')=='headli one'){
        //     alert('4');
        // }else if($('#comment').attr('class')=='headli one'){
        //     alert('5');
        // }else if($('#download').attr('class')=='headli one'){
        //     alert('6');
        // }else if($('#sign').attr('class')=='headli one'){
        //     alert('7');
        // }else if($('#all').attr('class')=='headli one'){
        //     alert('8');
        // }
	})


})
//保存接口
function saveJurisd(data){
    $.ajax({
        type:'post',
        url:domain+'file/setFileAuth',
        dataType:'json',
        data:data,
        success:function(res){
            console.log('res.flag');
        }
    })
}