package com.cyt.jsp.entity;

public class Book {
	private Integer bookId;
	private String bookName;
	private String author;
	private double price;
	private int storeCount;
	private String bookImg;
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStoreCount() {
		return storeCount;
	}
	public void setStoreCount(int storeCount) {
		this.storeCount = storeCount;
	}
	public String getBookImg() {
		return bookImg;
	}
	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
	public Book(Integer bookId, String bookName, String author, double price,
			int storeCount, String bookImg) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.storeCount = storeCount;
		this.bookImg = bookImg;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
}
