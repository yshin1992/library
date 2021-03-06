<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>login.html</title>
	<meta charset="UTF-8">
    <meta name="keywords" content="libray,图书馆">
    <meta name="description" content="图书馆管理系统">
	<style>
		div{
			font-size:1.5em;
			width:100%;
		}
		table{
			width:500px;
			text-align:center;
		}
		.tdTitle{
			width:200px;
			text-align:right;
			font-style:weight;
		}
		.tdValue{
			text-align:left;
		}
		.error{
			font-size:12px;
			color:red;
		}
	</style>
	<script src="js/jquery-1.11.2.js"></script>
	<script>
    if (window != top){
		top.location.href = location.href;
	}
	$(document).ready(function() {
		$(":button").click(function() {
			var userId = $(":text").val();
			var pswd = $(":password").val();
			//清除空格
			userId = userId.replace(/\s/g, "");
			pswd = pswd.replace(/\s/g, "");
			if (userId == "") {
				$("#errorId").html("*用户名不能为空");
			}
			if (pswd == "") {
				$("#errorPswd").html("*密码不能为空");
			}
			if (userId != "" && pswd != ""){
				$("form").submit();
			}
		});
	})
</script>
  </head>
  
  <body>
  <center>
  	<div>图书馆管理系统</div>
    <form method="post" action="login.do">
    <table>
    	<tr>
    		<td class="tdTitle">类型:</td>
    		<td class="tdValue"><select name="userType">
    				<option value="student">学生</option>
    				<option value="teacher">教师</option>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<td class="tdTitle">账号:</td>
    		<td class="tdValue"><input type="text" name="userId" />
    							<span id="errorId" class="error"><c:out value="${requestScope.loginerror }"/></span>
    		</td>
    	</tr>
    	<tr>
    		<td class="tdTitle">密码:</td>
    		<td class="tdValue"><input type="password" name="password"/><span id="errorPswd" class="error"></span></td>
    	</tr>
    	<tr>
    		<td colspan="2" >
    		<!-- 这里的button的name不能为submit，否则会导致提交失效 -->
    			<input type="button" value="提交"/>&nbsp;&nbsp;
    			<input type="reset" name="reset" value="重置"/>
    		</td>
    	</tr>
    </table>
    </form>
   </center>
  </body>
</html>

