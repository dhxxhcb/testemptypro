<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link href="../css/ueditor/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="../css/ueditor/site.css" rel="stylesheet" type="text/css" />
<link href="../css/ueditor/style.css" rel="stylesheet" type="text/css" />
<link href="../css/ueditor/transform.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" charset="utf-8"
	src="../js/jquery-1.10.2/jquery.min.js">
	
</script>

<script type="text/javascript">
	$(function() {

	    var formId='${formId}';
		$.ajax({
			type : 'get',
			url : 'formType',
			dataType : 'json',
			data : {
				'fromId' : formId
			},
			success : function(rsp) {
				var data1 = rsp.object;
				$("input:text").each(function() {
					this.value = data[this.name];
				});
				$("input:radio").each(function() {
					if (this.value == data[this.name]) {
						this.checked = true;
					}
				});
				$("input:checkbox").each(function() {
					if (this.value == data[this.name]) {
						this.checked = true;
					}
				});
				$("textarea").each(function() {
					this.value = data[this.name];
				});
				$("select").each(
						function() {
							$("select[name='" + this.name + "'] option").each(
									function() {
										if ($(this).val() == data[this.name]) {
											$(this).attr("selected", true);
										}
									});
						});
           str=data1.printModel;
			
			$("#a2").html(str);
			}

		});
	});
</script>
</head>

<body>
	<div class="container">
		<div class="row" id="a2">
			
		</div>
	</div>
</body>
</html>
