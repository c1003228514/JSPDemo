<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.cyt.jsp.entity.*,java.util.*" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:set var="username" value="zhangsan" scope="request"></c:set>
	name:${username}<p>
	
	<jsp:useBean id="u" class="com.cyt.jsp.entity.User"></jsp:useBean>
	<c:set target="${u }" property="password" value="123456"></c:set>
	pass:${u.password }<p>
	
	username:<c:out value="${u.username }" default="lisi"></c:out> <p>
	
	<c:out value="<span>苏州</span>" escapeXml="true"></c:out><p>
	
	<c:remove var="username"/>
	username:${username } <p>
	
	Path:${path }
	
	<hr />
	<c:set var="age" value="23"></c:set>
	<%
	/* 	String age = (String)pageContext.getAttribute("age");
		if(Integer.parseInt(age) >= 19){
			out.print("成年");
		}else{
			out.print("未成年");
		} */
	%>
	<c:if test="${age >= 18 }">
		成年
	</c:if>
	<c:if test="${age < 18 }">
		未成年
	</c:if>
	<hr />
	
	<c:set var="score" value="56"></c:set>
	<c:choose>
		<c:when test="${score >= 90 }">优秀</c:when>
		<c:when test="${score >= 80 && score < 90 }">良好</c:when>
		<c:when test="${score >= 70 && score <80 }">中等</c:when>
		<c:when test="${score >= 60 && score <70 }">及格</c:when>
		<c:otherwise>不及格</c:otherwise>
	</c:choose>
	
	<hr />
	<c:forEach var="i" begin="1" end="9">
		<c:if test="${i%2 == 0 }">
			<c:forEach var="j" begin="1" end="${i }">
				<span style="color:red">${i }*${j }=${i*j }&nbsp;</span>
			</c:forEach>
		</c:if>
		<c:if test="${i%2 !=0 }">
			<c:forEach var="j" begin="1" end="${i }">
				<span style="color:green">${i }*${j }=${i*j }&nbsp;</span>
			</c:forEach>
		</c:if>
		<br />
	</c:forEach>
	
	
	
</body>
</html>