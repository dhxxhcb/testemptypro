<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>流程图DEMO</title>
    <link rel="stylesheet" type="text/css" href="../../lib/GooFlow/GooFlow.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/workflow/flowtype/default.css"/>
    <script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../lib/GooFlow/GooFunc.js"></script>
    <script type="text/javascript" src="../../lib/GooFlow/GooFlow.js"></script>
    <!-- <script type="text/javascript" src="../../js/workflow/json2.js"></script> -->
    <style>
        .myForm {
            display: block;
            margin: 0px;
            padding: 0px;
            line-height: 1.5;
            border: #ccc 1px solid;
            font: 12px Arial, Helvetica, sans-serif;
            margin: 5px 5px 0px 0px;
            border-radius: 4px;
        }

        .myForm .form_title {
            background: #428bca;
            padding: 4px;
            color: #fff;
            border-radius: 3px 3px 0px 0px;
        }

        .myForm .form_content {
            padding: 4px;
            background: #fff;
        }

        .myForm .form_content table {
            border: 0px
        }

        .myForm .form_content table td {
            border: 0px
        }

        .myForm .form_content table .th {
            text-align: right;
            font-weight: bold
        }

        .myForm .form_btn_div {
            text-align: center;
            border-top: #ccc 1px solid;
            background: #f5f5f5;
            padding: 4px;
            border-radius: 0px 0px 3px 3px;
        }

        #propertyForm {
            float: right;
            width: 260px
        }
    </style>
    <script type="text/javascript">
       jsondata1  = {
           "title": "",
           "nodes": {
               "demo_node_9": {"name": "桂中区", "left": 10, "top": 10, "type": "start round", "alt": true},
               "demo_node_10": {"name": "桂北区", "left": 10, "top": 81, "type": "start round", "alt": true},
               "demo_node_11": {"name": "桂西区", "left": 9, "top": 143, "type": "start round", "alt": true},
               "demo_node_12": {"name": "桂北区", "left": 11, "top": 290, "type": "start round", "alt": true},
               "demo_node_14": {"name": "桂东区", "left": 7, "top": 339, "type": "start round", "alt": true},
               "demo_node_2": {"name": "问候语2", "left": 232, "top": 104, "type": "chat", "alt": true}
           },
           "lines": {
               "demo_line_6": {"type": "lr", "M": 81.5, "from": "demo_node_9", "to": "demo_node_5", "name": ""},
               "demo_line_7": {"type": "lr", "M": 81.5, "from": "demo_node_10", "to": "demo_node_5", "name": ""},
               "demo_line_9": {"type": "lr", "M": 81.5, "from": "demo_node_11", "to": "demo_node_5", "name": ""}
           },
           "areas": {},
           "initNum": 61
       };
//jsondata  = {
//            "title": "",
//            "nodes": {
//            },
//            "lines": {
//            },
//            "areas": {},
//            "initNum": 61
//        };
$(function(){
	        var property = {
	            width: 1200,
	            height: 600,
	            toolBtns: ["start round", "end round", "task round", "node", "chat", "state", "plug", "join", "fork", "complex mix"],
	            haveHead: true,
	            headBtns: ["new", "open", "save", "undo", "redo", "reload"],//如果haveHead=true，则定义HEAD区的按钮
	            haveTool: true,
	            haveGroup: true,
	            useOperStack: true
	        };
	        var remark = {
	            cursor: "选择指针",
	            direct: "结点连线",
	            start: "入口结点",
	            end: "结束结点",
	            task: "任务结点",
	            node: "自动结点",
	            chat: "决策结点",
	            state: "状态结点",
	            plug: "附加插件",
	            fork: "分支结点",
	            join: "联合结点",
	            "complex mix": "复合结点",
	            group: "组织划分框编辑开关"
	        };
            var jsondata = {
                "title": "231321",
                "nodes" :{},
                "lines" :{},
            	"areas": {},
            	"initNum": 7
            }
            $.ajax({
                type:'get',
                url:'<%=basePath%>flowProcess/flowview',
                dataType:'json',
                data:{"flowId":${formId}},
                success:function(json){
                   // debugger;
                    if(json.flag){
                    	var designdata = json.object.designdata;
                    	var connections = json.object.connections;
                       	designdata.forEach(function(v,i){
                       		jsondata.nodes['node_'+i] = {
                        		name:v.prcsName,
                        		left:v.setLeft,
                        		type: "fork",
                        		top:v.setTop,
                        		type:v.prcsType
                        	} 
                       	});

                       	connections.forEach(function(v,i){
                       		//jsondata.lines['demo_line_'+i] ={"type": "lr", "M": 81.5, "from": "demo_node_"+i, "to": "demo_node_"+(i+1), "name": ""}
                       		jsondata.lines['line_'+i] = {
                        		type:v.prcsName,
                        		type:"sl",
                        		from:"node_"+i,
                        		to:"node_"+(i+1),
                        		name:"",
                        		"M": 81.5,
                        		alt:true
                        	} 
                       	});

                       
                    }else {
                        //jsondata={}
                    }
                                      	 console.log(JSON.stringify(jsondata));
                var demo = $.createGooFlow($("#demo"), property);
	            demo.setTitle("aaaaaaaaaaaa流程绘制");
	            demo.setNodeRemarks(remark);
	            demo.loadData(jsondata);
                } 
            });
           
            

      		

        var demo;
        var out;
        function Export() {
            document.getElementById("result").value = JSON.stringify(demo.exportData());
        }
        });
    </script>
</head>
<body>
<div id="demo" style="margin:10px"></div>
<input id="submit" type="button" value='导出结果' onclick="Export()"/>
<textarea id="result" row="6"></textarea>
</body>
</html>

