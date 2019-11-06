package cn.red.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.red.util.JDBCUtilsConfig;

/*
 *  ʹ��QueryRunner��,ʵ�ֶ����ݱ���
 *  insert delete update
 *  ����QueryRunner��ķ��� update (Connection con,String sql,Object...param)
 *  Object...param �ɱ����,Object����,SQL�������?ռλ��
 *  ���ݿ����Ӷ���,�Զ���Ĺ����ഫ��
 */
public class QueryRunnerDemo {
	private static Connection con = JDBCUtilsConfig.getConnection();

	/*
	 * ���巽��,ʹ��QueryRunner��ķ���update�����ݱ���,��������
	 */
	@Test
	public void insert() throws SQLException {
		// ����QueryRunner�����
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO sort (sname,sprice,sdesc)VALUES(?,?,?)";
		// ������?ռλ����ʵ�ʲ���,д��������
		Object[] params = { "������Ʒ", 289.32, "����������Ʒ" };
		// ����QueryRunner��ķ���updateִ��SQL���
		int row = qr.update(con, sql, params);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}

	/*
	 * ���巽��,ʹ��QueryRunner��ķ���update�����ݱ���,��������
	 */
	@Test
	public void update() throws SQLException {
		// ����QueryRunner�����
		QueryRunner qr = new QueryRunner();
		// д�޸����ݵ�SQL���
		String sql = "UPDATE sort SET sname=?,sprice=?,sdesc=? WHERE sid=?";
		// ����Object����,�洢?�еĲ���
		Object[] params = { "����", 100.88, "���˽�õ�廨", 4 };
		// ����QueryRunner����update
		int row = qr.update(con, sql, params);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}

	/*
	 * ���巽��,ʹ��QueryRunner��ķ���update�����ݱ���,�h������
	 */
	@Test
	public void delete() throws SQLException {
		//����QueryRunner�����
		QueryRunner qr = new QueryRunner();	
		//дɾ����SQL���
		String sql = "DELETE FROM sort WHERE sname=?";
		//����QueryRunner����update
		int row = qr.update(con, sql, "������Ʒ");
		System.out.println(row);
		/*
		 *  �ж�insert,update,deleteִ���Ƿ�ɹ�
		 *  �Է���ֵrow�ж�
		 *  if(row>0) ִ�гɹ�
		 */
		DbUtils.closeQuietly(con);
	}
}