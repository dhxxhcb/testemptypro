$(function () {
	
	$('.a1').click(function () {
		var str='<tr class="tian"><td>抄送：</td><td><textarea id="copeNameText" name="txt" disabled></textarea><span class="add_img"><span class="addImg"></span><a href="javascript:;" id="selectUserO" class="Add">添加</a><span class="add_img"><span class="addImg"></span><a href="javascript:;" class="clearCC">清除</a></span></td></tr>';
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
		var str='<tr class="mis"><td>密送：</td><td><textarea id="secritText" name="txt" disabled></textarea><span class="add_img"><span class="addImg"></span><a href="javascript:;" id="selectUserT" class="Add">添加</a><span class="add_img"><span class="addImg"></span><a href="javascript:;" class="clearBCC">清除</a></span></td></tr>';
		var txt=$(this).text();
		if (txt=='添加密送') {
			$(this).text('隐藏密送');
			$('.append_tr').after(str);
		}else{
			$(this).text('添加密送');
			$('.mis').remove();
		}
	})
	
	$('.clear').click(function(){
		$('#senduser').val('');
	})
	$('.TABLE').on('click','.clearCC',function(){
        $('#copeNameText').val('');
	})
	$('.TABLE').on('click','.clearBCC',function(){
        $('#secritText').val('');
	})
	
})
