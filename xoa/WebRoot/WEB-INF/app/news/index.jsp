<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../css/news/center.css"/>
</head>
<body>
<!--head开始-->
<div class="head w clearfix">
    <ul>
        <li class="one">全部新闻</li>
        <li>未读新闻</li>
        <li>新闻查询</li>
    </ul>
</div>
<!--head通栏结束-->
<!--navigation开始-->
<div class="navigation w clearfix">
<div class="left">
    <img src="../img/01.png">
    <div class="news">全部新闻</div>
    <div class="button1">
        <div>文件夹</div>
        <img src="../img/v.png">
    </div>
    <div >
        <div style="font-size: 15px;">日期 :</div>
        <div class="button1">
            <div>2017-03-24</div>
            <img src="../img/v.png">
        </div>

    </div>
    <div class="button1" style="background-color:#F99C0F;padding: 0 10px">查询</div>
</div>
<div class="right">
    <div class="one">《上页</div>
    <div>1</div>
    <div>2</div>
    <div>3</div>
    <div>4</div>
    <div>...</div>
    <div class="one">下页 》</div>
</div>

</div>
<!--navigation结束-->

<!--content部分开始-->
<div class="w">
    <div class="wrap">
        <table class="w">
            <thead>
            <tr >
                <td class="th">标题</td>
                <td class="th">类型</td>
                <td class="th">发布时间</td>
                <td class="th">点击次数</td>
                <td class="th">评论（条）</td>
            </tr>
            </thead>
            <tbody id="j_tb">
            <tr>
                <td>
                    团队调高效率的方法
                </td>
                <td>行业资讯</td>
                <td>2017-04-14  10:55</td>
                <td>01</td>
                <td>20</td>
            </tr>
            <tr>
                <td>
                    团队调高效率的方法
                </td>
                <td>行业资讯</td>
                <td>2017-04-14  10:55</td>
                <td>01</td>
                <td>20</td>
            </tr>
            <tr>
                <td>
                    团队调高效率的方法
                </td>
                <td>行业资讯</td>
                <td>2017-04-14  10:55</td>
                <td>01</td>
                <td>20</td>

            </tr>
            <tr>
                <td>
                    团队调高效率的方法
                </td>
                <td>行业资讯</td>
                <td>2017-04-14  10:55</td>
                <td>01</td>
                <td>20</td>

            </tr>
            <tr>
                <td>
                    团队调高效率的方法
                </td>
                <td>行业资讯</td>
                <td>2017-04-14  10:55</td>
                <td>01</td>
                <td>20</td>

            </tr>
            <tr>
                <td>
                    团队调高效率的方法
                </td>
                <td>行业资讯</td>
                <td>2017-04-14  10:55</td>
                <td>01</td>
                <td>20</td>

            </tr>
            </tbody>
        </table>
    </div>


</div>
<!--content部分结束-->

<!--footer部分开始-->
<div class="footer w clearfix">
 <div>快捷操作</div>
 <div>标识所有的新闻为已读</div>

</div>


<!--footer部分结束-->

</body>

<script>

    // 1. 获得要操作的对象
    var tBody = document.getElementById("j_tb");
    var trs = tBody.children;//只会获得子标签节点，孙子标签节点大大的不要
    // 2. 隔行变色
    for(var i=0;i<trs.length;i++){
        if(i%2==0){
            trs[i].style.backgroundColor = "#F6F7F9";
        }else {
            trs[i].style.backgroundColor = "#fff";
        }
        // 3. 鼠标移入当前行的时候，让当前行的背景颜色 变成白色
        var bg ;
        trs[i].onmouseover =function (){
            bg = this.style.backgroundColor;//将当前的颜色先存起来
            this.style.backgroundColor = "#D3E7FA";
        }
        trs[i].onmouseout = function (){
            this.style.backgroundColor = bg;
        }
    }

</script>
</html>