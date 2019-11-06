package cn.red.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static Connection conn;
	
	/*
	 * ������
	 */
	private DBUtils() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/mybase?serverTimezone=UTC";
			String username = "root";
			String password = "199307";
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException("���ݿ�����ʧ��");
		}
	}
	
	/**
	 * ��ȡ���Ӷ���
	 * @return
	 */
	public static Connection getConnection() {
		return conn;
	}
	
	/**
	 * �ر����Ӷ���
	 * @param conn
	 * @param state
	 * @param rs
	 */
	public static void close(Connection conn,Statement state,ResultSet rs) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(state!=null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}