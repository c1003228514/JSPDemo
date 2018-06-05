package com.cyt.jsp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���ݿ�����Ӷ��� //ʹ�õ���ģʽ
 * @author gdwu
 *
 */
public class JDBCutil {
	private static JDBCutil jdbcUtil;
	private Connection conn;
	
	//��������
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private JDBCutil() {
		
	}
	/**
	 * ���ص���ģʽ��ʵ������
	 * @return
	 */
	public static JDBCutil getInstance() {
		if (jdbcUtil == null) {
			synchronized (JDBCutil.class) {
				if (jdbcUtil == null) {
					jdbcUtil = new JDBCutil();
				}
			}
		}
		return jdbcUtil;
	}
	/**
	 * ������ݿ����Ӷ���
	 * @return
	 */
	public Connection getConnection(){
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql0512", "root", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * �ͷ���Դ
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public void release(ResultSet rs ,Statement st ,Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(st != null){
					try {
						st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						if(conn != null){
							try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}
