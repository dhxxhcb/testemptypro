;;$(function(){
	$.extend({
		popWindow:function(url,top,left,width,height) {
			
			var top = top || '100';
			var left = left || '300';
			var width = width || '640';
			var height = height || '500';
			var specs = 'top='+top+',left='+left+',width='+width+',height='+height;
			window.open(url,'hh',specs);
	    }
	});
	$.extend({
		getQueryString:function(name) {
	        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	        var r = window.location.search.substr(1).match(reg);
	        if (r != null) return unescape(r[2]);
	        return null;
	    }
	});
	
	
	
	
	
})
