<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
	<style>
		body{
		}
		.bgPink{
			background-color: #FF5E59;
			color:white;
			font-weight: bold;
		}
		a{
			color:gray;
			text-decoration: none;
		}
	</style>
	
  </head>
  
  <body>
    <span class="bgPink">友情链接</span>
    &nbsp;&nbsp;<a href="http://www.baidu.com" target="_blank">百度</a>
  </body>
</html>
