<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="library/tags" prefix="library" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
	<script src="js/jquery-1.11.2.js"></script>
	<script>
		function showHide(elem,aElem){
			$("#"+elem).toggle();
			if($(aElem).html()=="+"){
				$(aElem).html("-");
			}else{
				$(aElem).html("+");
			}
		}
	</script>
	<style>
		ul li {
			list-style: none;
		}
	</style>
  </head>
  
  <body>
  <library:navigation/>
  	<ul>
  		<li>
  		<a href="javascript:void(0)" onclick="showHide('elementId',this)">+</a>科技
  			<ul id="elementId" style="display:none">
  				<li>Java</li>
  				<li><a href="javascript:void(0)" onclick="showHide('c',this)">+</a>C
  					<ul id="c" style="display:none">
  						<li>C语言基础</li>
  					</ul>
  				</li>
  				<li>C</li>
  				<li>C</li>
  			</ul>
  		</li>
  	</ul>
  </body>
</html>
