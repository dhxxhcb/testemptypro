<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script src="js/base/base.js"></script>
 <title>Document</title>
 <style>
 *{
 margin:0;
 padding:0;
 font-family:'微软雅黑';
 }
 .lunbo{
 position: relative;
/*  width: 600px; */
 height: 50px;

 overflow: hidden;
 }
 ul{
 position:absolute;
 left: 0;
 top:0;
 width: 600px;
 height: auto;
 }
 ul li{
 width: 600px;
 height: 30px;
 line-height: 30px;
 font-size:16px;
 color:#fff;
 text-align: center
 }
 </style>
</head>
<body>
 <div class="lunbo">
	 <ul id="status_text">					
		<%--<li><fmt:message code="title.login.txt" /></li>
		<li><fmt:message code="title.login.tex" /></li>
		<li><fmt:message code="title.login.text" /></li>--%>
	</ul>
 </div>
   
<script>
    $(function(){
        $.ajax({
            type: "get",
            url: "<%=basePath%>/syspara/selectSysPara",
 /*           data:{
                paraName:STATUS_TEXT_MARQUEE
            },*/
            dataType: 'JSON',
            success: function (obj) {
                if(obj.flag==true){
                    var data=obj.object;
                    for(var i=0;i<data.length;i++){
                        var times=data[i].paraValue;

                    }
                    ajaxwenzi(times);
                }


            }
        })
        //轮播的文字和秒数的接口
        function ajaxwenzi(time) {
            $.ajax({
                type: "get",
                url: "<%=basePath%>/sys/getStatusText",
                dataType: 'JSON',
                success: function (obj) {
                    var objs=obj.object;
                    var str='';
                    if(obj.flag==true){
                        //后台没有对字符串进行分割的情况下
                      /*  for(var i=0;i<objs.length;i++){
                            var arr=objs[i].statusText.replace(/\n/g,',');
                            var srrs=arr.split(',')
                            for(var m=0;m<srrs.length;m++){
                                if(srrs[m]!=''){
                                    str+='<li>'+srrs[m]+'</li>'
                                }
                            }

                        }*/
                        //后台对字符串进行分割的情况下
                        for(var i=0;i<objs.length;i++){
                                if(objs[i]!=''){
                                    str+='<li>'+objs[i]+'</li>'
                                }
                        }
                        console.log(str);
                        $('#status_text').html(str);
                        shuffling.init(time);
                    }
                }
            })
        }

        //轮播功能
        var shuffling={//交易中心
            LIHEIGHT:0,
            ULTOP:0,
            timer:0,
            timers:0,
            time:0,
            status:true,
            init:function(times){
                this.LIHEIGHT=$('#status_text li').height();
                this.ULTOP=parseInt($('#status_text').css('top'));
                this.time=times;

                var me=this;
                $('#status_text').hover(function(){
                    me.status=false;
                },function(){
                    me.status=true;
                    if(me.timer!=null){
                        clearInterval(me.timer);
                        me.timer=null;
                        me.settime();
                    }
                })
                this.settime();
            },
            settime:function(){
                this.timer = setTimeout(this.movestep.bind(this), 1500)
            },
            movestep:function(){
                var me=this;
                if(me.status) {
                    me.timers = setInterval(function () {
                        if (me.ULTOP < me.LIHEIGHT) {
                            (me.ULTOP)++
                            $('#status_text').css('top', -me.ULTOP);
                        } else {
                            clearInterval(me.timers);
                            me.timers = null;
                            me.stoptime.call(shuffling);
                        }
                    }, this.time)
                }
            },
            stoptime:function(){
                if(this.timer!=null){
                    clearTimeout(this.timer);
                    this.timer=null;
                    this.ULTOP=0;
                }
                var arr=$('#status_text li');
                var arrs=Array.prototype.shift.apply(arr);
                arr.push(arrs);
                var fragment = document.createDocumentFragment();
                for (var i=0; i<arr.length; i++ ) {

                    fragment.appendChild(arr[i]);
                }
                $('#status_text').css('top',this.ULTOP)
                document.getElementById('status_text').appendChild(fragment);
                this.settime();
            }
        }


    })

</script>
</body>
</html>
