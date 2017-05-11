<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>

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
	.cabinet_left { 
		    width: 20%; 
		    float: left;  
		    overflow: auto ;
		    height: 100%;
		    background-color: #F0F4F7;
		    border:1px solid #d9d9d9;
	}
	.cabinet_right {
		 width:79%;
		 height:100%;
		 border-left-width: 0px;
		 border-right-width: 0px;
		 border-top-width: 0px;
	}


</style>
<link rel="stylesheet" type="text/css" href="../css/easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/easyui/icon.css">
<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
$("#fileTree").tree({
	onClick : function(node){
		//alert(node.id);  // 在用户点击的时候提示
		var url="${pageContext.request.contextPath }/file/content?sortType=4&postType=2&sortId="+node.id+"&text="+node.text;
		$("#mainFram").attr("src", url);
	}
   });
});       
 /*function cabinet(num){
            if(num=='1'){
               $("#fileTransfor").empty();
               /!*  $("#personal").css("background-color","#F0F4F7");
                $("#public").css("background-color","#fff"); *!/
                $("#personal").css({backgroundColor:"#F0F4F7"});
                $("#public").css({backgroundColor:"#FFF"});
                
                
                
                
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
		            var url="${pageContext.request.contextPath }/file/content?sortType=5&postType=1&sortId="+node.id+"&text="+node.text;
		            $("#mainFram").attr("src", url);
	                 }
                      });
                 }
                  }); 
             }
             if(num=='2'){
              $("#fileTransfor").empty();
                $("#public").css({"background-color":"#F0F4F7"});
                $("#personal").css({"background-color":"#fff"});
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
		             var url="${pageContext.request.contextPath }/file/content?sortType=4&postType=2&sortId="+node.id+"&text="+node.text;
		             $("#mainFram").attr("src", url);
	                 }
                       });
                 }
                  });        
            }
    
    }*/
        

     
</script>
</head>
<body>
<div style="height: 100%">

    <div  class="cabinet_left">
      <!--  <div onclick="cabinet('1')" id="personal" style="width:49%;height:30px;line-height:30px;   float: left;border:1px solid #c0c0c0;text-align: center;"><fmt:message code="main.public"/></div>
       <div onclick="cabinet('2')" id="public"  style="width:49%;height:30px;line-height:30px;  float: left;border:1px solid #c0c0c0;text-align: center;"><fmt:message code="main.personnel"/></div> -->
       
      <div onclick="cabinet('2')" id="public"  style="width:50%;height:40px;line-height:40px;  float: left;text-align: center;"><fmt:message code="main.personnel"/></div>
        <div onclick="" id="personal" style="width:100%;height:40px;line-height:40px;padding-left: 15px;   float: left;text-align: left;"><fmt:message code="main.public"/></div>


        <div id="fileTransfor" style="margin-left: 15px;margin-top: 28px ;width:100%;overflow-x: hidden;">
                <ul id="fileTree" class="easyui-tree"
					data-options="url:'writeTreePerson',method:'get',animate:true" >
				</ul>
        </div>
    </div>
    <div style="height: 100% ;">
        <iframe id="mainFram"  src="" class="cabinet_right"></iframe>
    </div>
</div>
</body>
</html>