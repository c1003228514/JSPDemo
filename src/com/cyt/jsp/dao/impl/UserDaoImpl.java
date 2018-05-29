package com.cyt.jsp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cyt.jsp.dao.IUserDao;
import com.cyt.jsp.entity.User;
import com.cyt.jsp.util.JDBCutil;

public class UserDaoImpl implements IUserDao {

	@Override
	public User selectUserByName(String name) {
		Connection conn = JDBCutil.getInstance().getConnection();
		String sql = "select * from JA_USER where username=?";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setAdmin(rs.getString("admin"));
				user.setSex(rs.getString("sex"));
				user.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.getInstance().release(rs, pstm, conn);
		}
		return user;
	}

}
