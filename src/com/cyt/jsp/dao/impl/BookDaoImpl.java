package com.cyt.jsp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cyt.jsp.dao.IBookDao;
import com.cyt.jsp.entity.Book;
import com.cyt.jsp.entity.Pageing;
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
		String sql = "insert into JA_BOOK (bookname,author,price,storecount,bookimg) values (?,?,?,?,?)";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, b.getBookName());
			pstm.setString(2, b.getAuthor());
			pstm.setDouble(3, b.getPrice());
			pstm.setInt(4, b.getStoreCount());
			pstm.setString(5, b.getBookImg());
			
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

	@Override
	public Pageing selectBooksByCodition(String bname, String minPrice,
			String maxPrice,int pageNow,int pageSize) {
		Connection conn = JDBCutil.getInstance().getConnection();
		String sql = "select * from JA_BOOK where 1=1 ";
		
		if (bname != null && !"".equals(bname.trim())) {
			sql += " and bookName like '%"+bname+"%' ";
		}
		if (minPrice != null && !"".equals(minPrice) && (maxPrice == null || "".equals(maxPrice))) {
			sql += " and price >= "+Double.parseDouble(minPrice);
		}
		if (maxPrice != null && !"".equals(maxPrice) && (minPrice == null || "".equals(minPrice))) {
			sql += " and price <= "+Double.parseDouble(maxPrice);
		}
		if (minPrice != null && !"".equals(minPrice) && maxPrice != null && !"".equals(maxPrice)) {
			sql += " and price between "+Double.parseDouble(minPrice) +" and "+Double.parseDouble(maxPrice);
		}
		
		sql += " limit ?,? ";
		
		Pageing p = new Pageing();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Book> books = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, (pageNow-1)*pageSize);
			pstm.setInt(2, pageSize);
			rs = pstm.executeQuery();
			books = this.getListBooks(rs);
			
			
			p.setBooks(books);
			p.setPageNow(pageNow);
			p.setPageSize(pageSize);
			
			int rowCount = (int) this.getRowCount(bname, minPrice, maxPrice);
			int pageCount = 0;
			if (rowCount % pageSize == 0) {
				pageCount = rowCount /pageSize;
			}else {
				pageCount = rowCount /pageSize + 1;
			}
			p.setPageCount(pageCount);
			p.setRowCount(rowCount);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.getInstance().release(rs, pstm, conn);
		}
		return p;
	}
	
	private long getRowCount(String bname, String minPrice,
			String maxPrice) {
		Connection conn = JDBCutil.getInstance().getConnection();
		String sql = "select count(*) from JA_BOOK where 1=1 ";
		
		if (bname != null && !"".equals(bname.trim())) {
			sql += " and bookName like '%"+bname+"%' ";
		}
		if (minPrice != null && !"".equals(minPrice) && (maxPrice == null || "".equals(maxPrice))) {
			sql += " and price >= "+Double.parseDouble(minPrice);
		}
		if (maxPrice != null && !"".equals(maxPrice) && (minPrice == null || "".equals(minPrice))) {
			sql += " and price <= "+Double.parseDouble(maxPrice);
		}
		if (minPrice != null && !"".equals(minPrice) && maxPrice != null && !"".equals(maxPrice)) {
			sql += " and price between "+Double.parseDouble(minPrice) +" and "+Double.parseDouble(maxPrice);
		}
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				return rs.getLong(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.getInstance().release(rs, pstm, conn);
		}
		
		return 0;
	}
	
}
