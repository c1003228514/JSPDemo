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
import com.cyt.jsp.entity.Pageing;

@WebServlet(name="list",urlPatterns="/book/success")
public class BookListServlet extends HttpServlet {
	IBookDao bd = new BookDaoImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//接收查询条件
		String bname = req.getParameter("queryName");
		String minPrice = req.getParameter("minPrice");
		String maxPrice = req.getParameter("maxPrice");
		
		//接收客户端传递的分页数据 当前页 每页显示多少条
		String pageNow = req.getParameter("pageNow");
		String pageSize = req.getParameter("pageSize");
		
		pageNow = pageNow==null?"1":pageNow;
		pageSize = pageSize==null?"2":pageSize;
		
		//List<Book> books = bd.selectBooks();
		//List<Book> books = bd.selectBooksByCodition(bname, minPrice, maxPrice,Integer.parseInt(pageNow),Integer.parseInt(pageSize));
		Pageing paging = bd.selectBooksByCodition(bname, minPrice, maxPrice,Integer.parseInt(pageNow),Integer.parseInt(pageSize));
		
		//查询之后，数据显示
		req.setAttribute("paging", paging);
		req.setAttribute("queryName", bname);
		req.setAttribute("minPrice", minPrice);
		req.setAttribute("maxPrice", maxPrice);
		
		req.getRequestDispatcher("/jsp/day03/book.jsp").forward(req, resp);;
		
	}
	
}
