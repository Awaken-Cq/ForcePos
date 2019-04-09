package com.kitri.pos;

import java.sql.*;

//��������Ҷ� �޾ƾ��ϴ� ��
//���� ID, ���� �н�����, �̸� , ����

public class UserDao {

	Connection conn = null; // DB����� ����(����)�� ���� ��ü
	PreparedStatement pstm = null; // SQL ���� ��Ÿ���� ��ü
	ResultSet rs = null; // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü

	// �⺻ ������
	public UserDao() {

	}

	public void register(PosDto posdto) {

		conn = getConnection();
		String insert = "INSERT INTO MEMBERS(USER_CODE, PW, ID, AUTHORITY, NAME) VALUES(?, ?, ?, ?, ?)";
		try {
			pstm = conn.prepareStatement(insert);

			pstm.setInt(1, posdto.getUserCode());
			pstm.setString(2, posdto.getPw());
			pstm.setString(3, posdto.getId());
			pstm.setString(4, posdto.getAuthority());
			pstm.setString(5, posdto.getName());

			int result = pstm.executeUpdate();

			if (result > 0) {
				System.out.println(posdto.getName() + "���� DB ����");
			} else {
				System.out.println("DB�������");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public Connection getConnection() {

		String user = "kitri";
		String pw = "kitri";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			System.out.print("Database�� ���Ἲ��.\n");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB ����̹� �ε� ���� :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB ���ӽ��� : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
		return conn;
	};

	
	public static void main(String[] args) {
		new UserDao();
//		System.out.println();
	}
}
