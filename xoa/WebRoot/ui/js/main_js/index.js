 		/*function AutoScroll(obj) {

            $(obj).find("#status_text:first").animate({
                marginTop: "-25px"
            }, 3000, function() {
                $(this).css({ marginTop: "0px" }).find("#status_text li:first").appendTo(this);
            });
        }
        $(document).ready(function() {
            var myar = setInterval('AutoScroll(".lunbo")', 1000)
            $(".lunbo").hover(function() { clearInterval(myar); }, function() { myar = setInterval('AutoScroll(".lunbo")', 1000) }); //当鼠标放上去的时候，滚动停止，鼠标离开的时候滚动开始
        });*/

/*	 var currentIndex=0;
	 var contIndex=0;
$(function(){
	
	//tab切换
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
	

	

	
	$('.cont_nav').on('click','li',function(){
			$(".cont_nav li").removeClass("infame");
			$(this).addClass('infame');
			
	});
	
	
})*/



