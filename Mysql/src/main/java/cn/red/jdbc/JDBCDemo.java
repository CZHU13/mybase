package cn.red.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author zc285
 * JDBC�������ݿⲽ��
 * 1.ע������
          ��֪JVMʹ�õ�����һ�����ݿ�����
 * 2.��ȡ����
    ʹ��JDBC���࣬��ɶ�mysql���ݿ������
   3.��ȡ����ִ��ƽ̨
   ��ȡ���Ӷ����ȡ��SQL����ִ�ж���
   4.ִ��sql���
   ʹ��ִ���߶��������ݿ�ִ��SQL���
   5.�������
   6.�ͷ���Դ һ��close
 */
public class JDBCDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//1.ע������
	    //ʹ��java.sql.DriverManager�ྲ̬����registerDriver(Driver driver);
		//Driver����һ���ӿڣ��������ݣ�MySQL���������ʵ����com.mysql.jdbc.Driver
		//DriverManager.registerDriver(new Driver());
		//������Դ���룬ע��2����������
		Class.forName("com.mysql.cj.jdbc.Driver");//����  cj

		/*
		 * 2.������ݿ������
		 * DriverManager.getConnection(String url, String user, String password),��ȡ
		 * ����ֵ��Connection�ӿڵ�ʵ���࣬��mysql����������
		jdbc:mysql://ip��ַ:�˿ں�/���ݿ���
	    @CallerSensitive
	    public static Connection getConnection(String url,
	        String user, String password) throws SQLException {
	        java.util.Properties info = new java.util.Properties();
	
	        if (user != null) {
	            info.put("user", user);
	        }
	        if (password != null) {
	            info.put("password", password);
	        }
	
	        return (getConnection(url, info, Reflection.getCallerClass()));
	    }
		 */
		String url = "jdbc:mysql://localhost:3306/mybase?serverTimezone=UTC";//����?serverTimezone=UTC
		String username = "root";
		String password = "199307";
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		
		
		/*
		 * 3.��ȡ����ִ��ƽ̨.��ȡ���Ӷ����ȡ��SQL����ִ�ж���
		 * conn�������Statement�ӿڵ�ʵ���࣬��mysql����������
		 */
		Statement state = conn.createStatement();
		
		
		/*
		 * 4.ִ��sql���
		 * ͨ��ִ���߶������SQL��䣬��ȡ���ݿ���SQL���
		 * int executeUpdate(String sql) ִ�����ݿ��е�SQL��䣬insert update delete
		 */
		//insert
		
		
		String deleteSql = "delete from sort where sname= '����'";
		int row = state.executeUpdate(deleteSql);
		if(row == 1) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
		
		String insertSql = "INSERT INTO sort(sname,sprice,sdesc) VALUES ('����',1999,'ROG̫����')";
		row = state.executeUpdate(insertSql);
		if(row == 1) {
			System.out.println("д��ɹ�");
		}else {
			System.out.println("д��ʧ��");
		}
		
		String updateSql = "update sort set sprice = 1999 where sid = 1";
		row = state.executeUpdate(updateSql);
		if(row == 1) {
			System.out.println("���³ɹ�");
		}else {
			System.out.println("����ʧ��");
		}
		/*
		 * ִ��SQL����ȡ�����
		 * ResultSet executeQuery(String sql) ִ��SQL����е�select��ѯ
		 * ����ֵResultSet�ӿڵ�ʵ�������ʵ������mysql������
		 ResultSet �ӿڵķ���boolean next() ,����ֵΪtrue���н����������ֵΪfalse��û�н����
		 */
		String selectSql = "select * from sort";
		ResultSet rs = state.executeQuery(selectSql);
		while(rs.next()) {
			System.out.println(rs.getInt("sid")+" "+rs.getString("sname")+" "+
		rs.getDouble("sprice")+" "+rs.getString("sdesc"));
		}
		
		//6.�ͷ���Դ
		state.close();
		conn.close();
	}
}