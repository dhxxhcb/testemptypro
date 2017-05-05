<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>王曰岐的测试</title>
        <!-- 配置文件 -->  
        <script type="text/javascript" src="../lib/ueditor/ueditor.config.js"></script>  
        <!-- 编辑器源码文件 -->  
        <script type="text/javascript" src="../lib/ueditor/ueditor.all.js"></script>  
        <!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->  
        <script type="text/javascript" src="../lib/ueditor/lang/zh-cn/zh-cn.js"></script>  
</head>
<body>

		<textarea id="myEditor" name="content">
		</textarea>
		
	<!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('myEditor');
    </script>
    
</body>
</html>