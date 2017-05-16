<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>流程图DEMO</title>
<link rel="stylesheet" type="text/css" href="../../lib/GooFlow/GooFlow.css"/>
<link rel="stylesheet" type="text/css" href="../../css/workflow/flowtype/default.css"/>
<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../../lib/GooFlow/GooFunc.js"></script>
<script type="text/javascript" src="../../lib/GooFlow/GooFlow.js"></script>
<script type="text/javascript">
jsondata={"title":"10086网状流程","nodes":{"demo_node_9":{"name":"桂中区","left":10,"top":10,"type":"start round","width":24,"height":24,"alt":true},"demo_node_10":{"name":"桂北区","left":10,"top":81,"type":"start round","width":24,"height":24,"alt":true},"demo_node_11":{"name":"桂西区","left":9,"top":143,"type":"start round","width":24,"height":24,"alt":true},"demo_node_12":{"name":"桂北区","left":11,"top":290,"type":"start round","width":24,"height":24,"alt":true},"demo_node_14":{"name":"桂东区","left":7,"top":339,"type":"start round","width":24,"height":24,"alt":true},"demo_node_2":{"name":"问候语2","left":232,"top":104,"type":"chat","width":86,"height":24,"alt":true},"demo_node_3":{"name":"问候语3","left":220,"top":260,"type":"chat","width":86,"height":24,"alt":true},"demo_node_4":{"name":"问候语4","left":222,"top":327,"type":"chat","width":86,"height":24,"alt":true},"demo_node_5":{"name":"停机判断","left":107,"top":47,"type":"fork","width":86,"height":24,"alt":true},"demo_node_13":{"name":"停机判断2","left":103,"top":289,"type":"fork","width":86,"height":24,"alt":true},"demo_node_20":{"name":"停机菜单","left":355,"top":12,"type":"join","width":86,"height":24,"alt":true},"demo_node_21":{"name":"正常菜单","left":368,"top":362,"type":"join","width":86,"height":24,"alt":true},"demo_node_27":{"name":"延时停机","left":492,"top":13,"type":"node","width":86,"height":24,"alt":true},"demo_node_28":{"name":"开机","left":491,"top":62,"type":"node","width":86,"height":24,"alt":true},"demo_node_29":{"name":"缴费","left":466,"top":162,"type":"node","width":86,"height":24,"alt":true},"demo_node_30":{"name":"历史话费查询","left":591,"top":116,"type":"node","width":111,"height":24,"alt":true},"demo_node_1":{"name":"问候语1","left":228,"top":42,"type":"chat","width":86,"height":24,"alt":true},"demo_node_38":{"name":"积分查询","left":506,"top":261,"type":"complex mix","width":86,"height":24,"alt":true},"demo_node_39":{"name":"剩余资源查询","left":499,"top":312,"type":"complex mix","width":107,"height":24,"alt":true},"demo_node_40":{"name":"常用业务办理","left":491,"top":356,"type":"complex mix","width":110,"height":24,"alt":true},"demo_node_42":{"name":"网络服务","left":492,"top":397,"type":"complex mix","width":86,"height":24,"alt":true},"demo_node_43":{"name":"转人工服务","left":479,"top":457,"type":"state","width":91,"height":24,"alt":true},"demo_node_44":{"name":"话费查询","left":477,"top":213,"type":"state","width":86,"height":24,"alt":true},"demo_node_52":{"name":"实时话费查询","left":609,"top":212,"type":"node","width":107,"height":24,"alt":true},"demo_node_54":{"name":"网络专区投诉","left":639,"top":399,"type":"task","width":106,"height":24,"alt":true},"demo_node_55":{"name":"普通转人工","left":641,"top":456,"type":"task","width":109,"height":24,"alt":true},"demo_node_59":{"name":"10088","left":500,"top":514,"type":"task","width":86,"height":24,"alt":true}},"lines":{"demo_line_6":{"type":"lr","M":81.5,"from":"demo_node_9","to":"demo_node_5","name":""},"demo_line_7":{"type":"lr","M":81.5,"from":"demo_node_10","to":"demo_node_5","name":""},"demo_line_9":{"type":"lr","M":81.5,"from":"demo_node_11","to":"demo_node_5","name":""},"demo_line_14":{"type":"sl","from":"demo_node_12","to":"demo_node_13","name":""},"demo_line_15":{"type":"lr","M":78.5,"from":"demo_node_14","to":"demo_node_13","name":""},"demo_line_17":{"type":"tb","M":152,"from":"demo_node_5","to":"demo_node_2","name":"F"},"demo_line_18":{"type":"tb","M":239,"from":"demo_node_13","to":"demo_node_3","name":"T"},"demo_line_19":{"type":"tb","M":383.5,"from":"demo_node_13","to":"demo_node_4","name":"F"},"demo_line_22":{"type":"lr","M":339,"from":"demo_node_4","to":"demo_node_21","name":""},"demo_line_23":{"type":"lr","M":337.5,"from":"demo_node_2","to":"demo_node_21","name":""},"demo_line_26":{"type":"lr","M":366.5,"from":"demo_node_3","to":"demo_node_20","name":""},"demo_line_31":{"type":"tb","M":176.5,"from":"demo_node_20","to":"demo_node_29","name":"4"},"demo_line_32":{"type":"tb","M":25.5,"from":"demo_node_20","to":"demo_node_27","name":"1"},"demo_line_33":{"type":"tb","M":128,"from":"demo_node_20","to":"demo_node_30","name":"3"},"demo_line_34":{"type":"tb","M":74.5,"from":"demo_node_20","to":"demo_node_28","name":"2"},"demo_line_36":{"type":"tb","M":21.5,"from":"demo_node_5","to":"demo_node_1","name":"T"},"demo_line_37":{"type":"lr","M":367,"from":"demo_node_1","to":"demo_node_20","name":""},"demo_line_45":{"type":"tb","M":225,"from":"demo_node_21","to":"demo_node_44","name":"1"},"demo_line_46":{"type":"tb","M":274.5,"from":"demo_node_21","to":"demo_node_38","name":"2"},"demo_line_47":{"type":"tb","M":325.5,"from":"demo_node_21","to":"demo_node_39","name":"3"},"demo_line_48":{"type":"sl","from":"demo_node_21","to":"demo_node_40","name":"4"},"demo_line_49":{"type":"tb","M":411.5,"from":"demo_node_21","to":"demo_node_42","name":"5"},"demo_line_50":{"type":"tb","M":470.5,"from":"demo_node_21","to":"demo_node_43","name":"0"},"demo_line_51":{"type":"sl","from":"demo_node_44","to":"demo_node_30","name":"2"},"demo_line_53":{"type":"sl","from":"demo_node_44","to":"demo_node_52","name":"1"},"demo_line_56":{"type":"sl","from":"demo_node_43","to":"demo_node_55","name":"0"},"demo_line_57":{"type":"sl","from":"demo_node_43","to":"demo_node_54","name":"1"},"demo_line_58":{"type":"sl","from":"demo_node_42","to":"demo_node_54","name":"0"},"demo_line_60":{"type":"sl","from":"demo_node_43","to":"demo_node_59","name":"2","alt":true}},"areas":{},"initNum":61};
var JSON;JSON||(JSON={}),function(){function f(a){return a<10?"0"+a:a}function quote(a){return escapable.lastIndex=0,escapable.test(a)?'"'+a.replace(escapable,function(a){var b=meta[a];return typeof b=="string"?b:"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})+'"':'"'+a+'"'}function str(a,b){var c,d,e,f,g=gap,h,i=b[a];i&&typeof i=="object"&&typeof i.toJSON=="function"&&(i=i.toJSON(a)),typeof rep=="function"&&(i=rep.call(b,a,i));switch(typeof i){case"string":return quote(i);case"number":return isFinite(i)?String(i):"null";case"boolean":case"null":return String(i);case"object":if(!i)return"null";gap+=indent,h=[];if(Object.prototype.toString.apply(i)==="[object Array]"){f=i.length;for(c=0;c<f;c+=1)h[c]=str(c,i)||"null";return e=h.length===0?"[]":gap?"[\n"+gap+h.join(",\n"+gap)+"\n"+g+"]":"["+h.join(",")+"]",gap=g,e}if(rep&&typeof rep=="object"){f=rep.length;for(c=0;c<f;c+=1)typeof rep[c]=="string"&&(d=rep[c],e=str(d,i),e&&h.push(quote(d)+(gap?": ":":")+e))}else for(d in i)Object.prototype.hasOwnProperty.call(i,d)&&(e=str(d,i),e&&h.push(quote(d)+(gap?": ":":")+e));return e=h.length===0?"{}":gap?"{\n"+gap+h.join(",\n"+gap)+"\n"+g+"}":"{"+h.join(",")+"}",gap=g,e}}"use strict",typeof Date.prototype.toJSON!="function"&&(Date.prototype.toJSON=function(a){return isFinite(this.valueOf())?this.getUTCFullYear()+"-"+f(this.getUTCMonth()+1)+"-"+f(this.getUTCDate())+"T"+f(this.getUTCHours())+":"+f(this.getUTCMinutes())+":"+f(this.getUTCSeconds())+"Z":null},String.prototype.toJSON=Number.prototype.toJSON=Boolean.prototype.toJSON=function(a){return this.valueOf()});var cx=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,escapable=/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,gap,indent,meta={"\b":"\\b","\t":"\\t","\n":"\\n","\f":"\\f","\r":"\\r",'"':'\\"',"\\":"\\\\"},rep;typeof JSON.stringify!="function"&&(JSON.stringify=function(a,b,c){var d;gap="",indent="";if(typeof c=="number")for(d=0;d<c;d+=1)indent+=" ";else typeof c=="string"&&(indent=c);rep=b;if(!b||typeof b=="function"||typeof b=="object"&&typeof b.length=="number")return str("",{"":a});throw new Error("JSON.stringify")}),typeof JSON.parse!="function"&&(JSON.parse=function(text,reviver){function walk(a,b){var c,d,e=a[b];if(e&&typeof e=="object")for(c in e)Object.prototype.hasOwnProperty.call(e,c)&&(d=walk(e,c),d!==undefined?e[c]=d:delete e[c]);return reviver.call(a,b,e)}var j;text=String(text),cx.lastIndex=0,cx.test(text)&&(text=text.replace(cx,function(a){return"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)}));if(/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,"@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,"]").replace(/(?:^|:|,)(?:\s*\[)+/g,"")))return j=eval("("+text+")"),typeof reviver=="function"?walk({"":j},""):j;throw new SyntaxError("JSON.parse")})}();
var property={
	width:1200,
	height:600,
	toolBtns:["start round","end round","task round","node","chat","state","plug","join","fork","complex mix"],
	haveHead:true,
	headBtns:["new","open","save","undo","redo","reload"],//如果haveHead=true，则定义HEAD区的按钮
	haveTool:true,
	haveGroup:true,
	useOperStack:true
};
var remark={
	cursor:"选择指针",
	direct:"结点连线",
	start:"入口结点",
	"end":"结束结点",
	"task":"任务结点",
	node:"自动结点",
	chat:"决策结点",
	state:"状态结点",
	plug:"附加插件",
	fork:"分支结点",
	"join":"联合结点",
	"complex mix":"复合结点",
	group:"组织划分框编辑开关"
};
var demo;
$(document).ready(function(){
	demo=$.createGooFlow($("#demo"),property);
		  demo.setTitle("aaaaaaaaaaaa流程绘制");
	demo.setNodeRemarks(remark);
	//demo.onItemDel=function(id,type){
	//	return confirm("确定要删除该单元吗?");
	//}
	demo.loadData(jsondata);
});
var out;
function Export(){
    document.getElementById("result").value=JSON.stringify(demo.exportData());
}
</script>
</head>
<body>
<div id="demo" style="margin:10px"></div>
<input id="submit" type="button" value='导出结果' onclick="Export()"/>
<textarea id="result" row="6"></textarea>
</body>
</html>

