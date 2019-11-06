package cn.red;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	//����BasicDataSource�����
	private static BasicDataSource datasource = new BasicDataSource();
	
	//��̬����飬����BasicDataSource�����е����ã��Զ���
	static{
		//���ݿ�������Ϣ,�����
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/mybase?serverTimezone=UTC");
		datasource.setUsername("root");
		datasource.setPassword("199307");
		//�������ӳ��е�������������,��ѡ��
		datasource.setInitialSize(10);//��ʼ����������
		datasource.setMaxActive(8);//�����������
		datasource.setMaxIdle(5);//��������
		datasource.setMinIdle(1);//��С����
	}
	
	
	//���徲̬����,����BasicDataSource��Ķ���
	public static DataSource getDataSource(){
		return datasource;
	}
}
