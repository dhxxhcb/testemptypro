<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<?
include_once("lib/puc/conn.php");
include_once("lib/puc/base.php");
?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="GBK">
		<title>选择部门</title>
	    <link rel="stylesheet" type="text/css" href="<?=GOS_UI_SERVER?>/ui/css/bootstrap/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="<?=GOS_UI_SERVER?>/ui/css/bootstrap/bootstrap-responsive.min.css"/>	
		<link rel="stylesheet" type="text/css" href="<?=GOS_UI_SERVER?>/ui/css/base.css"/>
		<script type="text/javascript" src="<?=GOS_UI_SERVER?>/ui/js/jquery/jquery-1.4.4.min.js"></script>
		<script type="text/javascript">
		  var col = '<?php echo $_GET['col']; ?>';
		  var k='----';	  
		  var b=''; 
		  var kong='';
		  var s='';
		  function child(a){
  	  	    var b=[];
  	  	   	  var leng=a.length;
  	  	   	  for(var i=0;i<leng;i++)
  	  	   	  {
  	  	   	  	 var obj={};
  	  	   	  	 obj.name=a[i].dname;
  	  	   	  	 obj.tId=a[i].did;
  	  	   	  	 obj.tid=a[i].did;
  	  	   	  	 obj.isParent=true;
  	  	   	  	 if(a[i].child!=""){
  	  	   	  	  obj.children= child(a[i].child);
  	  	   	  	 }
  	  	   	  	 b.push(obj);
  	  	   	  }
  	  	   	  return b;
  	  	 }  
		
		var setting = {

		};

		var zNodes =[
		
		];
			function chd(a){
			    var length=a.length;
			    for(var i=0;i<length;i++)
			    {  kong="|-----";  
			    	s+=child1(a[i]);
			    	b='';
			    }
			   
			    
			    return s;
			} 		
				function child1(a){ 	 				  
  	  	   	  	 var obj={};
  	  	   	  	 obj.name=a.dname;
  	  	   	  	 obj.tid=a.did;  
  	  	   	  	 b+='<li id='+obj.tid+' data-name='+obj.name+' onclick="clic(this)">'+kong+''+obj.name+'</li>'	  	   	    
  	  	   	  	 if(a.child){
  	  	   	  	 	 kong=kong+k;
  	  	   	  	 	for(var j=0;j<a.child.length;j++)
  	  	   	  	 	{   	  	   	  	 
  	  	   	    	  child1(a.child[j]);	
  	  	   	  	 	}

  	  	   	  	 }  	  	 
  	  	   	  return b;
  	  	   }
			$(function(){
	/* 			$.ajax({
					type:"get",
					url:"data.php",
					async:true,
					dataType:'json',
					success:function(obj){
						console.log(obj);
						zNodes=child(obj);
						$('#list').html(chd(obj));
						if (col) {
							var id = $("#ga-body-new [name='" + col + "']", window.parent.opener.document).val();
							if (id !="") {
								for(var i=0;i<a.length;i++){
									$('#'+a[i]).addClass('add1')
								}
							}
							return;
						}
						if(window.parent.opener.document.getElementById(window.parent.opener.dept_id).value!=''){
							var a=window.parent.opener.document.getElementById(window.parent.opener.dept_id).value.split(',');
							for(var i=0;i<a.length;i++){
								$('#'+a[i]).addClass('add1')
							}
						}
					}
				}); */

			})
			function ad(){
				$('#list li').addClass("add1")
			}
		    function re(){
				$('#list li').removeClass("add1")
			}
			function clic(a){
			console.log($(a).attr('class'))
				var s=$(a).attr("class");
				if(s==""){
					$(a).addClass('add1');
				}	
				else{
					$(a).removeClass('add1');
				}			
			}
			function queding(){
				var id=[];
				var name=[];
		    	var s= $("#list .add1");	  
		    	for(var i=0;i<s.length;i++){
		    		id[i]=s.eq(i).attr('id');
		    		name[i]=s.eq(i).attr('data-name');
		    	}  			  
				// 新的选部门逻辑
				if (col) {
					$("#ga-body-new [name='" + col + "']", window.parent.opener.document).val(id);
					$("#ga-body-new [name='" + col + "_UNSUBMIT']", window.parent.opener.document).val(name);
					window.close();
					return;
				}
		     window.parent.opener.document.getElementById(window.parent.opener.dept_id).value=id;
		     window.parent.opener.document.getElementById(window.parent.opener.dept).value=name;
		     window.close();
			}
		</script>
		<style type="text/css">
		html,body{width: 100%;height: 100%;overflow: auto;}
	     	.conbody{width: 98%;margin: 0 auto;height:80%;}
			#seach{margin: 4px 0 0 0;}
			.list{list-style-type: none;margin: 0;}
			.list li{width: 80%;color: #000;text-align: left;background-color:#fff;border: 1px solid #CCCCCC;border-radius:5px ;margin: 6px auto;padding:10px 0;}
		    .list>.add1{color: #fff;background-color: #339BB9;}
		    .window_1{width:100%; margin:0 auto;height:100%;border: 0;}
            .right{float: right;}
            .left{float: left;}
            .clear{overflow: hidden;width: 100%;height: 100%;}
            .cont{width: 220px;height:100%;position: relative;}
            .foot{height:50px;width: 100%;position: fixed;bottom: 0;text-align: right;background-color:whitesmoke;}
		    .foot input{margin: 10px 10px 10px 0;}
		</style>
	</head>
	<body>
				       	<center>
		 <h1>选择部门</h1>

					
     		<input type="button"  class="btn btn-primary" id="" value="全部添加" onclick="ad()"/>
     	    <input type="button"  class="btn btn-danger" id="" value="全部删除" onclick="re()"/>
     	</center> 
     	    <br>
     	    <ul class="list lead" id="list">
				<li id="585" data-name="科技部" onclick="clic(this)">|-----科技部</li><li id="583" data-name="国防部门" onclick="clic(this)">|-----国防部门</li><li id="582" data-name="科技部" onclick="clic(this)">|-----科技部</li><li id="581" data-name="技术部门" onclick="clic(this)">|-----技术部门</li><li id="580" data-name="科技部" onclick="clic(this)">|-----科技部</li><li id="599" data-name="地方" onclick="clic(this)">|-----地方</li><li id="600" data-name="bumen1" onclick="clic(this)">|---------bumen1</li><li id="588" data-name="测试部" onclick="clic(this)">|-----测试部</li><li id="513" data-name="董事会" onclick="clic(this)">|-----董事会</li><li id="482" data-name="项目部" onclick="clic(this)">|-----项目部</li><li id="510" data-name="你好部" onclick="clic(this)">|---------你好部</li><li id="509" data-name="可乐部" onclick="clic(this)">|---------可乐部</li><li id="508" data-name="哈哈部" onclick="clic(this)">|---------哈哈部</li><li id="490" data-name="商务部" onclick="clic(this)">|---------商务部</li><li id="485" data-name="开发部" onclick="clic(this)">|---------开发部</li><li id="390" data-name="产品部1" onclick="clic(this)">|---------产品部1</li><li id="578" data-name="霓虹啊" onclick="clic(this)">|-------------霓虹啊</li><li id="575" data-name="开发平台部" onclick="clic(this)">|-------------开发平台部</li><li id="579" data-name="技术部" onclick="clic(this)">|-----------------技术部</li><li id="392" data-name="平台开发部" onclick="clic(this)">|-----------------平台开发部</li><li id="393" data-name="iOS开发部" onclick="clic(this)">|-----------------iOS开发部</li><li id="396" data-name="Android开发部" onclick="clic(this)">|-----------------Android开发部</li><li id="387" data-name="市场部" onclick="clic(this)">|-----市场部</li><li id="388" data-name="运营部" onclick="clic(this)">|---------运营部</li><li id="486" data-name="渠道部" onclick="clic(this)">|---------渠道部</li><li id="397" data-name="客服部" onclick="clic(this)">|---------客服部</li><li id="601" data-name="测试部门2" onclick="clic(this)">|-----测试部门2</li><li id="586" data-name="测试" onclick="clic(this)">|-----测试</li><li id="587" data-name="测试的下属部门" onclick="clic(this)">|---------测试的下属部门</li><li id="592" data-name="2222" onclick="clic(this)">|-----2222</li>
     	    </ul>  	
     	    <br><br>			  
	 <div class="foot">
	 	<input type="button" class="n_but n_ok" value=""  onclick="queding()">
	 </div>
	</body>
</html>
