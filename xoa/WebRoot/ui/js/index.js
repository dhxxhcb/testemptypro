	 var currentIndex=0;
$(function(){
	
	//tab«–ªª
	$('.tab_t').on('click','li',function(){
			var index=$(this).index();
			if(currentIndex!=index){
				currentIndex=index;
				$(".tab_t li").removeClass("yingy");
				$(this).addClass('yingy');
				
				var contents=$(".tab_c").find("ul");
                $(contents[index]).show();
                $(contents[index]).siblings().hide();
			}
			

	});
	

	
	$('#administ').on('click',function () {
		
		if ($(this).siblings('.erji').css('display')=='none') {
			$(this).find('.person_down').attr('src','img/up.png');
			$(this).siblings('.erji').show();
		}else{
			$(this).find('.person_down').attr('src','img/down.png');
			$(this).siblings('.erji').hide();
		}
					
	});
	
	$('#office').on('click',function () {
		
		if ($(this).parent().siblings('.sanji').css('display')=='none') {
			$(this).find('.office_img').attr('src','img/up.png');
			$(this).parent().siblings('.sanji').show();
		}else{
			$(this).find('.office_img').attr('src','img/down.png');
			$(this).parent().siblings('.sanji').hide();
		}
					
	});
	

	
	$('.cont_nav').on('click','li',function(){
			$(".cont_nav li").removeClass("infame");
			$(this).addClass('infame');
			
	});
	
	$('.close').on('click',function(){
		$('.gongzuoliu').remove();
	})
})

