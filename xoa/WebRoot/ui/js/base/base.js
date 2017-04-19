;;$(function(){
	$.extend({
		popWindow:function(url,top,left,width,height) {
			var top = top || '100';
			var left = left || '100';
			var width = width || '800';
			var height = height || '800';
			window.open(url,"",top,left,width,height);
	    }
	});
	
	
	
	
	
})
