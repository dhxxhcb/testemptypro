/*document.write(" <script language=\"javascript\" src="\/com\/js/base/base.js \" > <\/script>"); */

document.write("<script language=javascript src='js/base/base.js'></script>");



$(function(){
	//邮件tab切换
	$('.s_head').on('click','li',function(){
		
		$(".s_head li").removeClass("active");
		$(this).addClass('active');
		 if($(this).attr('id')=='all_m'){
			/* init(); */
			$('.all_mail').css("display","block");
			$('.no_read').css("display","none");
			$('.read').css("display","none");
		}else if($(this).attr('id')=='weidu'){
			$('.no_read').css("display","block");
			$('.all_mail').css("display","none");
			
			$('.read').css("display","none");
		} else{
			$('.read').css("display","block");
			$('.no_read').css("display","none");
			$('.all_mail').css("display","none");
			
			
		}
	});
		 
		 
		 
		//公告tab切换
			$('.notice_head').on('click','li',function(){
				$(".notice_head li").removeClass("active");
				$(this).addClass('active');
				 if($(this).attr('id')=='all_notice'){
				
					$('.notify').css("display","block");
					$('.no_read_notice').css("display","none");
				
				}else{
					$('.no_read_notice').css("display","block");
					$('.notify').css("display","none");

				} 
		
			})
			
			//文件柜tab切换
			$('.wenjian_head').on('click','li',function(){
				$(".wenjian_head li").removeClass("active");
				$(this).addClass('active');
				 if($(this).attr('id')=='pets'){
					 $('.pets_wenjian').css("display","block");
						$('.people_wenjian').css("display","none");
					
				
				}else{
					$('.people_wenjian').css("display","block");
					$('.pets_wenjian').css("display","none");

				} 
		
			})
	//邮件接口
	$.ajax({
		url:'email/showEmail',
		type:'get',
		data:{
			flag:'inbox',
			page:1,
			pageSize:5,
			useFlag:'true',
			// userID:'admin'
		},
		dataType:'json',
		success:function(obj){
			var data=obj.obj;
			
			/*console.log(data);*/
			var li='';
			var read_li='';
			var all_li='';

			for(var i=0;i<data.length;i++){
				
				for(var j=0;j<data[i].emailList.length;j++){
					/*console.log(data[i].emailList[j]);*/
					if(data[i].emailList[j].readFlag==0){
						
						var sendTime=new Date((data[i].sendTime)*1000).Format('yyyy-MM-dd hh:mm');
						li += '<li><div class="e_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></div><h1 class="e_name">'+data[i].emailList[j].toName+'</h1><a href="/email/details?id='+data[i].emailList[j].emailId+'" style="color:#000;" class="public_title" target="_blank"><h2 emil-tid="'+data[i].emailList[j].emailId+'" class="e_title">'+data[i].content+'</h2></a><h3 class="e_time">'+sendTime+'</h3></li>'
					}else if(data[i].emailList[j].readFlag==1){
						var sendTime=new Date((data[i].sendTime)*1000).Format('yyyy-MM-dd hh:mm');
						read_li += '<li><div class="e_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></div><h1 class="e_name">'+data[i].emailList[j].toName+'</h1><a href="/email/details?id='+data[i].emailList[j].emailId+'" style="color:#000;" class="public_title" target="_blank"><h2 emil-tid="'+data[i].emailList[j].emailId+'" class="e_title">'+data[i].subject+'</h2></a><h3 class="e_time">'+sendTime+'</h3></li>'
					}
					
					var sendTime=new Date((data[i].sendTime)*1000).Format('yyyy-MM-dd hh:mm');
					all_li += '<li><div class="e_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></div><h1 class="e_name">'+data[i].emailList[j].toName+'</h1><a href="/email/details?id='+data[i].emailList[j].emailId+'" style="color:#000;" class="public_title" target="_blank"><h2 emil-tid="'+data[i].emailList[j].emailId+'" class="e_title">'+data[i].subject+'</h2></a><h3 class="e_time">'+sendTime+'</h3></li>'
				}
				
				
			}
			$('.all_mail').html(all_li);
			
			$('.read').html(read_li);
			//判断有没有未读邮件
			if(li.length>0){
				$('.no_read').html(li);
			}else{
				sli='<li><h1 style="margin-left:3%;">暂无未读邮件</h1></li>';
				$('.no_read').html(sli);
				
			}
			
		}
	})
	//点击邮件更多，显示邮件页面
	$('.more').on('click',function(){
		var tid=$(this).attr('tid');
		var url=$(this).attr('url');
		if($('#f_'+tid).length>0){
			$('.all_content .iItem').hide();
				$('#f_'+tid).show();
				
				$('#t_'+tid).css({
					'background':'url(img/main_img/title_yes.png) 0px 4px no-repeat',
					'color':'#2a588c',
					'position':'relative',
					'z-index':99999
				})
				$('#t_'+tid).siblings().css({
					'background':'url(img/main_img/title_no.png) 0px 4px no-repeat',
					'color':'#fff',
					'position':'relative',
					'z-index':999
				})
		}else{
			var titlestrs = '<li class="choose " index="0;" id="t_'+tid+'" title="电子邮件"><h1>电子邮件</h1><div class="img" style="display:none;"><img class="close" src="img/main_img/icon.png"></div></li>';
			var iframestr = '<div id="f_'+tid+'" class="iItem"><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';
			$('.main_title ul').append(titlestrs);
			$('#t_'+tid).siblings().attr('style','background: url(img/main_img/title_no.png) -1px 2px no-repeat; ');	
			$('#t_'+tid).siblings().css('color','#fff');
			$('.all_content').append(iframestr);
			$('.all_content .iItem').hide();
			$('#f_'+tid).show();
		}
	})
	/*}*/
	
	//日志接口
	$.ajax({
		url:'diary/getIndex',
		type:'get',
		data:{
			page:1,
			pageSize:5,
			useFlag:'true',
			userId:'admin'
		},
		dataType:'json',
		success:function(obj){
			var data=obj.obj;
		/*	console.log(data);*/
			var str_li='';
			for(var i=0;i<data.length;i++){
				/*console.log(data[0].userName);*/
				str_li += '<li><div class="d_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></div><h1 class="d_name">'+data[i].userName+'</h1><h2 class="d_title">'+data[i].content+'</h2><h3 class="d_time">'+data[i].diaDate+'</h3></li>'
				/*console.log(str_li);*/
			}
			
			$('.all_daily').html(str_li);
		}
	})

	
	//点击邮日志更多，显示邮件页面
	$('.daily_more').on('click',function(){
		var tid=$(this).attr('tid');

		var url=$(this).attr('url');

		if($('#f_'+tid).length>0){
			$('.all_content .iItem').hide();
				$('#f_'+tid).show();
				
				$('#t_'+tid).css({
					'background':'url(img/main_img/title_yes.png) 0px 4px no-repeat',
					'color':'#2a588c',
					'position':'relative',
					'z-index':99999
				})
				$('#t_'+tid).siblings().css({
					'background':'url(img/main_img/title_no.png) 0px 4px no-repeat',
					'color':'#fff',
					'position':'relative',
					'z-index':999
				})
		}else{
			var titlestrs = '<li class="choose " index="0;" id="t_'+tid+'" title="工作日志"><h1>工作日志</h1><div class="img" style="display:none;"><img class="close" src="img/main_img/icon.png"></div></li>';
			var iframestr = '<div id="f_'+tid+'" class="iItem"><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';
			$('.main_title ul').append(titlestrs);
			$('#t_'+tid).siblings().attr('style','background: url(img/main_img/title_no.png) 0px 4px no-repeat; ');	
			$('#t_'+tid).siblings().css('color','#fff');
			$('.all_content').append(iframestr);
			$('.all_content .iItem').hide();
			$('#f_'+tid).show();
		}
	})
	
	//全部公告接口
	$.ajax({
		url:"notice/notifyList",
		type:'get',
		data:{
			read:'',
			page:1,
			pageSize:5,
			useFlag:'true'
			
		},
		dataType:'json',
		success:function(obj){
			var data=obj.obj;
			console.log(data);
			var str_li='';
			for(var i=0;i<data.length;i++){
				var time=data[i].notifyDateTime.slice(0,10);
				console.log(time);
				str_li += '<li><div class="n_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></div><h1 class="n_name">'+data[i].name+'</h1><a href="/notice/detail?notifyId='+data[i].notifyId+'" style="color:#000;" class="public_title" target="_blank"><h2 class="n_title" data-tid="'+data[i].notifyId+'">'+data[i].content+'</h2></a><h3 class="n_time">'+time+'</h3></li>'
				/*console.log(str_li);*/
			}
			
			$('.notify').html(str_li);
		}
	})
	
	//公告接口
	$.ajax({
		url:"notice/notifyList",
		type:'get',
		data:{
			read:0,
			page:1,
			pageSize:5,
			useFlag:'true'
			
		},
		dataType:'json',
		success:function(obj){
			var data=obj.obj;
			/*console.log(data[0].notifyId);*/
			console.log(data);
           /* console.log(data[1].notifyId)*/
			var str_li='';
			if(data.length>0){
				for(var i=0;i<data.length;i++){
					var time=data[i].notifyDateTime.slice(0,10);
					/*console.log(time);*/
					str_li += '<li><div class="n_img"><img src="http://devapp.gsubo.com/file0/E101000001/avatar/332841055.1325694304.jpg"></div><h1 class="n_name">'+data[i].name+'</h1><a href="/notice/detail?notifyId='+data[i].notifyId+'" style="color:#000;" class="public_title" target="_blank"><h2 class="n_title" data-tid="'+data[i].notifyId+'">'+data[i].subject+'</h2></a><h3 class="n_time">'+time+'</h3></li>'
				/*	console.log(str_li);*/
				}
				
				$('.no_read_notice').html(str_li);
			}else{
				li='<li class="no_notice"><h1>暂无未读公告</h1></li>';
				$('.no_read_notice').html(li);
			}
			
		}
	})
	
		//点击公告更多，显示公告页面
	$('.more_notice').on('click',function(){
		var tid=$(this).attr('tid');
		var url=$(this).attr('url');
		if($('#f_'+tid).length>0){
			$('.all_content .iItem').hide();
				$('#f_'+tid).show();
				
				$('#t_'+tid).css({
					'background':'url(img/main_img/title_yes.png) 0px 4px no-repeat',
					'color':'#2a588c',
					'position':'relative',
					'z-index':99999
				})
				$('#t_'+tid).siblings().css({
					'background':'url(img/main_img/title_no.png) 0px 4px no-repeat',
					'color':'#fff',
					'position':'relative',
					'z-index':999
				})
		}else{
			var titlestrs = '<li class="choose " index="0;" id="t_'+tid+'" title="公告通知"><h1>公告通知</h1><div class="img" style="display:none;"><img class="close" src="img/main_img/icon.png"></div></li>';
			var iframestr = '<div id="f_'+tid+'" class="iItem"><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';
			$('.main_title ul').append(titlestrs);
			$('#t_'+tid).siblings().attr('style','background: url(img/main_img/title_no.png) 0px 4px no-repeat; ');	
			$('#t_'+tid).siblings().css('color','#fff');
			$('.all_content').append(iframestr);
			$('.all_content .iItem').hide();
			$('#f_'+tid).show();
		}
	})
	
	
	
	//公共文件柜接口
	$.ajax({
		url:"file/writeTree",
		type:'get',
		dataType:'json',
		success:function(obj){
			
			console.log(obj);
			var wenjian_li='';
			if(obj.length>0){
				for(var i=0;i<obj.length;i++){
					
					wenjian_li += '<li class="all_li"><div><img src="img/main_img/wenjian.png" style="    margin-left: 8%;"></div><h1 style="    height: 20px;    line-height: 20px; text-align: center;">'+obj[i].text+'</h1></li>'
					/*console.log(str_li);*/
				}
				
				$('.pets_wenjian').html(wenjian_li);
			}else{
				li='<li class="no_notice"><h1>暂无未读公告</h1></li>';
				$('.pets_wenjian').html(li);
			}
			
		}
	})
	
	
	//个人文件柜接口
	$.ajax({
		url:"file/writeTreePerson",
		type:'get',
		dataType:'json',
		success:function(obj){
			
			console.log(obj);
			var wenjian_li='';
			if(obj.length>0){
				for(var i=0;i<obj.length;i++){
					
					wenjian_li += '<li class="all_li"><div><img src="img/main_img/wenjian.png" style="    margin-left: 8%;"></div><h1 style="    height: 20px;    line-height: 20px; text-align: center;">'+obj[i].text+'</h1></li>'
					/*console.log(str_li);*/
				}
				
				$('.people_wenjian').html(wenjian_li);
			}else{
				li='<li class="no_notice"><h1>暂无未读公告</h1></li>';
				$('.people_wenjian').html(li);
			}
			
		}
	})


    //点击文件柜更多，显示文件柜页面
    $('.more_wenjian').on('click',function(){
        var tid=$(this).attr('tid');
        var url=$(this).attr('url');
        alert(tid);
        alert(url);
        if($('#f_'+tid).length>0){
            $('.all_content .iItem').hide();
            $('#f_'+tid).show();

            $('#t_'+tid).css({
                'background':'url(img/main_img/title_yes.png) 0px 4px no-repeat',
                'color':'#2a588c',
                'position':'relative',
                'z-index':99999
            })
            $('#t_'+tid).siblings().css({
                'background':'url(img/main_img/title_no.png) 0px 4px no-repeat',
                'color':'#fff',
                'position':'relative',
                'z-index':999
            })
        }else{
            var titlestrs = '<li class="choose " index="0;" id="t_'+tid+'" title="文件柜"><h1>公共文件柜</h1><div class="img" style="display:none;"><img class="close" src="img/main_img/icon.png"></div></li>';
            var iframestr = '<div id="f_'+tid+'" class="iItem"><iframe id="every_module" src="'+url+'" frameborder="0" scrolling="yes" height="100%" width="100%" noresize="noresize" tid="2"></iframe></div>';
            $('.main_title ul').append(titlestrs);
            $('#t_'+tid).siblings().attr('style','background: url(img/main_img/title_no.png) 0px 4px no-repeat; ');
            $('#t_'+tid).siblings().css('color','#fff');
            $('.all_content').append(iframestr);
            $('.all_content .iItem').hide();
            $('#f_'+tid).show();
        }
    })
	
})



