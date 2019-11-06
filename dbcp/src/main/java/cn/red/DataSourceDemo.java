package cn.red;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceDemo {
	public static void main(String[] args) {
		// 创建DataSource接口的实现类对象
		// 实现类, org.apache.commons.dbcp
		BasicDataSource dataSource = new BasicDataSource();
		// 连接数据库的4个最基本信息,通过对象方法setXXX设置进来
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mybase?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("199307");

		try {
			// 调用对象方法getConnection获取数据库的连接
			Connection con = dataSource.getConnection();
			System.out.println(con);
		} catch (SQLException ex) {
//					System.out.println(ex);
			throw new RuntimeException("数据库连接失败");
		}
	}

}