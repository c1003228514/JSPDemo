package com.cyt.jsp.dao;

import java.util.List;

import com.cyt.jsp.entity.Book;
import com.cyt.jsp.entity.Pageing;

public interface IBookDao {
	
	public List<Book> selectBooks();
	
	public Pageing selectBooksByCodition(String bname,String minPrice,String maxPrice,int pageNow,int pageSize);
	
	public void insertBook(Book b);
	
	public Book selectBookById(int id);
	
	public void updateBook(Book b);
	
	public void delete(int id);
}
