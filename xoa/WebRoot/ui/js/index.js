	 var currentIndex=0;
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
	
	$('.close').on('click',function(){
		$('.gongzuoliu').remove();
	})
})



/*function BlinkTitle()
{
    var t = blinkTitleType;
    var l = '';
    if(t=="sms")
       l = td_lang.inc.msg_37;//"您有新的短信提醒！"
    else if(t=="noc")
       l = td_lang.inc.msg_132;//"您有新的事务提醒！"
    else if(t=="sms&noc")
       l = td_lang.inc.msg_133;//"您有新的短消息和事务提醒！"
        
    document.title = document.title == "　　　　　　　　" ?  l: "　　　　　　　　";
}

function ResetTitle()
{
    window.clearInterval(blinkTitleInterval);
    document.title = documentTitle;
}

function show_feedback()
{
    window.open("http://club.tongda2000.com/demand/");
}*/
