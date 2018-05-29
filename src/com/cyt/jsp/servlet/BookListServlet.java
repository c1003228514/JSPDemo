package com.cyt.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyt.jsp.dao.IBookDao;
import com.cyt.jsp.dao.impl.BookDaoImpl;
import com.cyt.jsp.entity.Book;

@WebServlet(name="list",urlPatterns="/book/success")
public class BookListServlet extends HttpServlet {
	IBookDao bd = new BookDaoImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Book> books = bd.selectBooks();
		
		//查询之后，数据显示
		req.setAttribute("books", books);
		
		req.getRequestDispatcher("/jsp/day02/book.jsp").forward(req, resp);;
		
	}
	
}
