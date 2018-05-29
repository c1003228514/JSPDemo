package com.cyt.jsp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cyt.jsp.dao.IBookDao;
import com.cyt.jsp.entity.Book;
import com.cyt.jsp.util.JDBCutil;

public class BookDaoImpl implements IBookDao {

	@Override
	public List<Book> selectBooks() {
		Connection conn = JDBCutil.getInstance().getConnection();
		String sql = "select * from JA_BOOK";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			books = this.getListBooks(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.getInstance().release(rs, pstm, conn);
		}
		return books;
	}

	private List<Book> getListBooks(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<>();
		
		while(rs.next()) {
			Book b = new Book();
			b.setBookId(rs.getInt("bookid"));
			b.setBookName(rs.getString("bookname"));
			b.setAuthor(rs.getString("author"));
			b.setBookImg(rs.getString("bookimg"));
			b.setPrice(rs.getDouble("price"));
			b.setStoreCount(rs.getInt("storecount"));
			
			books.add(b);
		}
		return books;
	}

	@Override
	public void insertBook(Book b) {
		Connection conn = JDBCutil.getInstance().getConnection();
		String sql = "insert into JA_BOOK (bookname,author,price,storecount) values (?,?,?,?)";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, b.getBookName());
			pstm.setString(2, b.getAuthor());
			pstm.setDouble(3, b.getPrice());
			pstm.setInt(4, b.getStoreCount());
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			JDBCutil.getInstance().release(null, pstm, conn);
		}
	}

	@Override
	public Book selectBookById(int id) {
		Connection conn = JDBCutil.getInstance().getConnection();
		String sql = "select * from JA_BOOK where bookid=?";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Book b = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				b = new Book();
				b.setBookId(rs.getInt("bookid"));
				b.setAuthor(rs.getString("author"));
				b.setBookImg(rs.getString("bookimg"));
				b.setBookName(rs.getString("bookname"));
				b.setPrice(rs.getDouble("price"));
				b.setStoreCount(rs.getInt("storecount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCutil.getInstance().release(rs, pstm, conn);
		}
		return b;
	}

	@Override
	public void updateBook(Book b) {
		Connection conn = JDBCutil.getInstance().getConnection();
		String sql = "update JA_BOOK set bookname=?,author=?,price=?,storecount=? where bookid=?";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, b.getBookName());
			pstm.setString(2, b.getAuthor());
			pstm.setDouble(3, b.getPrice());
			pstm.setInt(4, b.getStoreCount());
			
			pstm.setInt(5, b.getBookId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCutil.getInstance().release(null, pstm, conn);
		}
	}

	@Override
	public void delete(int id) {
		Connection conn = JDBCutil.getInstance().getConnection();
		String sql = "delete from JA_BOOK where bookid=?";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCutil.getInstance().release(null, pstm, conn);
		}
	}
}
