<%@page import="com.cyt.jsp.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		#outer{
			width: 600px;
			margin: 0 auto;
		}
		#outer .list table{
			width: 600px;
			border: 1px solid #ccc;
			text-align: center;
			font-size: 12pt;
		}
		#outer .list table tr{
			height: 30px;
		}
		#outer .list table ,#outer .list table th,#outer .list table td{
			border: 1px solid #ccc;
			border-collapse: collapse;
		}
		#outer .list table thead{
			background-color: #888;
		}
		#outer .list table tbody tr:hover {
			background-color: red;
			color: white;
		}
	</style>

</head>
<body>
	<%
		//获取图书集合
		List<Book> books = (List<Book>)request.getAttribute("books");
	%>
	<div id="outer">
		<div class="tit">
			<p style="color:red;font-size: 30px;text-align: center;">图书列表</p>
		</div>
		<hr />
		<div class="query">
		
		</div>
		<hr />
		<div class="list">
			<table>
				<thead>
					<tr>
						<th><input type="checkbox" name="flag"></th>
						<th>ID</th>
						<th>名称</th>
						<th>作者</th>
						<th>价格</th>
						<th>库存</th>
						<th>图片</th>
						<th>操作</th>
					</tr>
				</thead>
				<%
					if(books.size() > 0){
						for(Book b :books){
				%>
					<tbody>
						<tr>
							<td><input type="checkbox" name="bookId" value="<%=b.getBookId() %>"></td>
							<td><%=b.getBookId() %></td>
							<td><%=b.getBookName() %></td>
							<td><%=b.getAuthor() %></td>
							<td><%=b.getPrice() %></td>
							<td><%=b.getStoreCount() %></td>
							<td>图片</td>
							<td><a href="#">修改</a>||<a href="#">删除</a></td>
						</tr>
					</tbody>
				<%
						}
					}else{
				%>
					<tbody>
						<tr>
							<td colspan="7" style="color:red;font-size: 9pt">没有数据</td>
						</tr>
					</tbody>
				<%
					}
				%>
			</table>
		</div>
	</div>

</body>
</html>