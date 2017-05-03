$(function () {
	
	$('.a1').click(function () {
		var str='<tr class="tian"><td>抄送：</td><td><textarea name="txt" disabled></textarea><span class="add_img"><span class="addImg"><a href="javascript:;" class="Add">添加</a></span><span class="add_img"><span class="addImg"><img src="img/org_select2.png" class="clearIcon"/></span><a href="javascript:;" class="clear">清除</a></span></td></tr>';
		var txt=$(this).text();
		if (txt=='添加抄送') {
			$(this).text('隐藏抄送');
			$('.append_tr').after(str);
		}else{
			$(this).text('添加抄送');
			$('.tian').remove();
		}
	})
	
	$('.a2').click(function () {
		var str='<tr class="mis"><td>密送：</td><td><textarea name="txt" disabled></textarea><span class="add_img"><span class="addImg"><a href="javascript:;" class="Add">添加</a></span><span class="add_img"><span class="addImg"><img src="img/org_select2.png" class="clearIcon"/></span><a href="javascript:;" class="clear">清除</a></span></td></tr>';
		var txt=$(this).text();
		if (txt=='添加密送') {
			$(this).text('隐藏密送');
			$('.append_tr').after(str);
		}else{
			$(this).text('添加密送');
			$('.mis').remove();
		}
	})
	
	
	
})
