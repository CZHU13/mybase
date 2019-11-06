package cn.red.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/*
 * ����properties�ļ�
 * IO��ȡ�ļ�
 */
public class JDBCUtilsConfig {
	private static Connection conn;
	private static String url; 
	private static String username; 
	private static String password; 
	private static String driver; 
	
	/*
	 * ������
	 */
	private JDBCUtilsConfig() {
		
	}
	
	static {
		try {
			readConfig();

			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException("���ݿ�����ʧ��");
		}
	}
	
	
	private static void readConfig() throws IOException {
		//ʹ����ļ�����DBUtils2.class.getClassLoader()
		//����getResourceAsStream("")��getResource("")���������ڻ�ȡ����·����ָ���������ļ�
		InputStream in = JDBCUtilsConfig.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		prop.load(in);
		
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
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