<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>Insert title here</title>
<style>
	html {
		height:100%;
	}
	body {
		height:100%;
	}


</style>
<link rel="stylesheet" type="text/css" href="../css/easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/easyui/icon.css">
<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
alert("我进来了!");
$("#fileTree").tree({
	onClick : function(node){
		//alert(node.id);  // 在用户点击的时候提示
		var url="${pageContext.request.contextPath }/file/content?sortType=5&sortId="+node.id+"&text="+node.text;
		$("#mainFram").attr("src", url);
	}
   });
});       
 function cabinet(num){
            if(num=='1'){
               $("#fileTransfor").empty();
                $("#personal").css("background-color","#F0F4F7");
                $("#public").css("background-color","#fff");
              $.ajax({
                Type: "GET",
                url: "${pageContext.request.contextPath}/file/writeTree",
                dataType:'json',
                success: function (data) {
                   $("#fileTransfor").append("<ul id=\"fileTree\" class=\"easyui-tree\"data-options=\"method:'get',animate:true\" ></ul>");
                   $("#fileTree").tree({
	                 data : data,
	                 onClick : function(node){
		         //alert(node.id);  // 在用户点击的时候提示
		            var url="${pageContext.request.contextPath }/file/content?sortType=5&sortId="+node.id+"&text="+node.text;
		            $("#mainFram").attr("src", url);
	                 }
                      });
                 }
                  }); 
             }
             if(num=='2'){
              $("#fileTransfor").empty();
                $("#public").css("background-color","#F0F4F7");
                $("#personal").css("background-color","#fff");
               $.ajax({
                 Type: "GET",
                url: "${pageContext.request.contextPath}/file/writeTreePerson",
                dataType:'json',
                success: function (data) {
                   $("#fileTransfor").html("<ul id=\"fileTree\" class=\"easyui-tree\"data-options=\"method:'get',animate:true\" ></ul>");
                   
                   $("#fileTree").tree({
	                 data : data,
	                 onClick : function(node){
		             //alert(node.id);  // 在用户点击的时候提示
		             var url="${pageContext.request.contextPath }/file/content?sortType=4&sortId="+node.id+"&text="+node.text;
		            $("#mainFram").attr("src", url);
	                 }
                       });
                 }
                  });        
            }
    
    }
        

     
</script>
</head>
<body>
<div style="height: 100%">

    <div  style="width: 20%; float: left;  overflow: auto ;height: 100%;background-color: #F0F4F7;border:1px solid #000;">
       <div onclick="cabinet('1')" id="personal" style="width:49%;height:30px;line-height:30px;   float: left;border:1px solid #c0c0c0;text-align: center;">公共文件柜</div>
       <div onclick="cabinet('2')" id="public"  style="width:49%;height:30px;line-height:30px;  float: left;border:1px solid #c0c0c0;text-align: center;">个人文件柜</div>
        <div id="fileTransfor" style="margin-top: 28px ;width:100%;overflow-x: hidden;">
                <ul id="fileTree" class="easyui-tree"
					data-options="url:'writeTree',method:'get',animate:true" >
				</ul>
        </div>
    </div>
    <div style="height: 100% ;">
        <iframe id="mainFram"  src="" style=" width:79%;height:100%;"></iframe>
    </div>
</div>
</body>
</html>