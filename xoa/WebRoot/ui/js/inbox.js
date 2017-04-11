$(function () {
	
	$('.inbox_btn').on('click',function () {
		
		if ($(this).siblings('.ul_show').css('display')=='none') {
			$(this).find('div').removeClass('div_up').addClass('div_down')
			$(this).siblings('.ul_show').slideDown();
		}else{
			$(this).find('div').removeClass('div_down').addClass('div_up')
			$(this).siblings('.ul_show').slideUp();
		}
					
	})
	
	$('.page_left li').click(function () {
		$('.page_left li').removeClass('on');
		$(this).addClass('on');
	})
	
	/*$('.page_left li').mouseover(function () {
		$(this).css('background-color','#6f97bf');
		
	})
	$('.page_left li').mouseout(function () {
		$(this).css('background-color','#7eacdb');
		
	})*/
	
	
	
})
