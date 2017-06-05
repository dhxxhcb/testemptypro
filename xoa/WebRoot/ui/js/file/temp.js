$(function () {
	$('.nav ul li').click(function () {
		$(this).find('.headli').addClass('one').end().siblings().find('.headli').removeClass('one');
	})
	$('#batchSettings').click(function () {
		$('.tabTypeTwo').show();
		$('.tabTypeOne').hide();
	})
	$('#visitJurisd').click(function () {
		$('.tabTypeOne').show();
		$('.tabTypeTwo').hide();
	})
})
