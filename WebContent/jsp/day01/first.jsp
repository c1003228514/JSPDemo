<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	当前时间:<%=new Date() %>	<p>
	
	<%!
		String name = "zhangsan";
	
		public String getName(){
			
			return name;
		}
	%>
	
	姓名:<%=name %> <p>
	姓名:<%=getName() %>
	<hr/>
	<%
		
	%>
	
	

</body>
</html>