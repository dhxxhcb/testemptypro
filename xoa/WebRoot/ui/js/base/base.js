;;$(function(){
	$.extend({
		popWindow:function(url,top,left,width,height) {
			var top = top || '200';
			var left = left || '300';
			var width = width || '640';
			var height = height || '600';
			window.open(url,top,left,width,height);
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