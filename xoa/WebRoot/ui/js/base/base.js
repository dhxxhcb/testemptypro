;;var domain = document.location.origin;
$(function(){
	$.extend({
		popWindow:function(url,title,top,left,width,height) {
			
			var top = top || '100';
			var left = left || '300';
			var width = width || '640';
			var height = height || '500';
			var specs = 'top='+top+',left='+left+',width='+width+',height='+height;
			window.open(url,title,specs);
	    }
	});
    $.fn.deptSelect = function(args){
    	var _this = $(this);
		$.ajax({
            url:domain+"/department/getAlldept",
            type:'get',
            data:{},
            dataType:'json',
			success:function(obj){
                console.log(obj)
                var data=obj.obj;
                departmentData= digui(data,0);
                var str = departmentChild(departmentData,'<option >请选择部门</option>',0,-1);
                _this.html(str);
			},
			error:function(){

			}
		});
	}
	$.extend({
		getQueryString:function(name) {
	        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	        var r = window.location.search.substr(1).match(reg);
	        if (r != null) return unescape(r[2]);
	        return null;
	    }
	});
	$.extend({
		upload:function(e,cb){
			if(!$('#uploadiframe').is('iframe')){
				$("body").append('<iframe id="uploadiframe" style="display:none;"  class="uploadiframe" name="uploadiframe" ></iframe>');
			}
			e.submit();
			var l = $('#uploadiframe'),a=null;
			 var f = setInterval(function(){
				 try{
					 a = l.contents().find("body").text()
				 }catch(i){
					 console.log("上传接口存在跨域", i);
					 clearInterval(f);
				 }
				 if(a){
//					console.log(a);
					clearInterval(f);
					l.contents().find("body").html("");
					var c = {};
					try{ c = JSON.parse(a); a={} } catch (i) {a = {};alert("你的上传大小超出上限", i) } 
					cb(c);
				 }
			 },300);
		}
	});
})
Date.prototype.Format = function(fmt)   
{
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));

  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}
//部门遍历方法
function digui(datas,departId) {
    var data=new Array();
    for(var i=0;i<datas.length;i++){
        if(datas[i].deptParent==departId){
            datas[i]["childs"]=digui(datas,datas[i].deptId);
            data.push(datas[i]);
        }
    }
    return data;
}
//部门遍历方法
function departmentChild(datas,opt_li,level,dept){
    for(var i=0;i<datas.length;i++){
        var String="";
        var space=""
        for(var j=0;j<level;j++){
            space+="├&nbsp;";
        }
		/* console.log("kongge"+space+"kongge")*/
        if(i==0){
            String=space+"┌";
        }else
        if(i!=0){
            String=space+"├";
        }else
        if(i==datas.length-1){
            String=space+"└";
        }
        if(dept==datas[i].deptId){
            opt_li+='<option value="'+datas[i].deptId+'" selected="selected">'+String+datas[i].deptName+'</option>';
        }else{
            opt_li+='<option value="'+datas[i].deptId+'">'+String+datas[i].deptName+'</option>';
        }
		/* 	console.log(datas[i].childs);*/
        if(datas[i].childs!=null){
            opt_li = departmentChild(datas[i].childs,opt_li,level+1,dept);
        }
    }
    return opt_li;
}
