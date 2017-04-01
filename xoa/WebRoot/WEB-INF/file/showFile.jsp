<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showFile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="JavaScript" src="js/tree/jquery-1.4.2.js"></script>
<script language="JavaScript" src="js/tree/jquery-ztree-2.5.js"></script>
<script language="JavaScript" src="js/tree/tree.js"></script>
<link type="text/css" rel="stylesheet" href="css/tree/menu.css" />
<link rel="stylesheet" href="css/tree/zTreeStyle.css" type="text/css">
  </head>
  <body>
 <!-- <c:forEach items="${json }"  var="sort"> -->
 <ul id="tt" class="easyui-tree">   
    <li>   
        <span>Folder</span>   
        <ul>   
            <li>   
                <span>Sub Folder 1</span>   
                <ul>   
                    <li>   
                        <span><a href="#">File 11</a></span>   
                    </li>   
                    <li>   
                        <span>File 12</span>   
                    </li>   
                    <li>   
                        <span>File 13</span>   
                    </li>   
                </ul>   
            </li>   
            <li>   
                <span>File 2</span>   
            </li>   
            <li>   
                <span>File 3</span>   
            </li>   
        </ul>   
    </li>   
    <li>   
        <span>File21</span>   
    </li>   
</ul>  
 
	<div id="west">
    <div class=""></div>
    <ul>
       
       <li>
       <a href="" onclick="" target="" title="" id="" >
       <span><img src="" width="16" height="16" align="absmiddle">${sort.sort_id} </span>
       </a>
       </li>
       <div id="" class="moduleContainer treeList">
       </div>    
       <div id="" class="moduleContainer"> </div>
       </c:forEach>
    </ul>
    <div id="MenuBottom"></div>
 </body>
</html>
