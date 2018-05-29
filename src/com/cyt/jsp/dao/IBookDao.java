package com.cyt.jsp.dao;

import java.util.List;

import com.cyt.jsp.entity.Book;

public interface IBookDao {
	
	public List<Book> selectBooks();
	
	public void insertBook(Book b);
	
	public Book selectBookById(int id);
	
	public void updateBook(Book b);
	
	public void delete(int id);
}
