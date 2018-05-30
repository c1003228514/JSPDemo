<%@page import="com.cyt.jsp.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String username = "zhangsan";
		request.setAttribute("uname", username);
		
		User user = new User();
		user.setUsername("jim");
		user.setPassword("123456");
		
		pageContext.setAttribute("user", user);
	%>
	姓名:<%=username %><p>
	姓名:${uname }<p>
	姓名:<%=request.getAttribute("uname") %><p>
	
	User:${user}<p>
	姓名:${user.getUsername()} <p>
	
	姓名:${user.username }  <p>
	
	
	
	
	
	
</body>
</html>