<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
	<style type="text/css">
		.login{
			width: 300px;
			margin: 0 auto;
			border: 1px solid #ccc;
			margin-top: 100px;
			height: 200px;
			padding: 20px 30px;
			box-sizing: border-box;
			background-color: #ccc;
		}
		
		.login table tr{
			height: 40px;
			font-size: 10pt;
		}
	</style>
	
</head>
<body>

	<div class="login">
		<!-- 登录不正确 -->
		<%
			String info = request.getParameter("info");
			if("1".equals(info)){
		%>
				<span style="color:red;font-size: 9pt">密码不正确</span>
		<%
			}else if("2".equals(info)){
				
		%>
			<span style="color:red;font-size: 9pt">用户名不存在</span>
		<%
			}
		
		%>
	
	
		<form action="<%=request.getContextPath() %>/user/login" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input  style="width: 50px;border-radius:6px;" type="submit" value="登录" /></td>
				<td style="text-align: right;"><input type="checkbox" name="flag" value="1" />记住密码</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align: center;"><a href="#">新用户注册</a></td>
			</tr>
		</table>
		</form>
	</div>

</body>
</html>