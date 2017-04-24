;;$(function(){
	$.extend({
		popWindow:function(url,top,left,width,height) {
			var top = top || '200';
			var left = left || '300';
			var width = width || '440';
			var height = height || '600';
			window.open(url,'hh','top='+top+',left='+left+',width='+width+',height='+height);
			//window.open ('../../../../lib/api/org/user/index.php#', 'hh', 'height=420, width=800, top=200, left=400')
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
