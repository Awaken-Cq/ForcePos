package com.kitri.pos;

import java.io.*;
import java.sql.*;

//��������Ҷ� �޾ƾ��ϴ� ��
//���� ID, ���� �н�����, �̸� , ����

public class UserDao {

	private BufferedReader in;
	PosDto posdto;
	// ������ Ŭ���� ��ü���� �� ������ ȣ��
	Administrator ad = new Administrator();
	Connection conn = null; // DB����� ����(����)�� ���� ��ü
	PreparedStatement pstm = null; // SQL ���� ��Ÿ���� ��ü
	ResultSet rs = null; // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü

	// �⺻ ������
	public UserDao() {
		super();
		in = new BufferedReader(new InputStreamReader(System.in));
		registerMenu();
	}

	public void registerMenu() {

		int USER_CODE = 0;
		String pw = null;
		String id = null;
		String authority = null;
		String name = null;

		try {
			System.out.print("�����ڵ��Է��ϼ���.");
			USER_CODE = Integer.parseInt(in.readLine());
			System.out.print("��й�ȣ�Է��ϼ���.");
			pw = in.readLine().trim();
			System.out.println();
			System.out.print("���̵��Է��ϼ���.");
			id = in.readLine().trim();
			System.out.print("�����Է��ϼ���.");
			authority = in.readLine().trim();
			System.out.print("�̸��Է��ϼ���.");
			name = in.readLine().trim();
//			System.out.print("������");
		
			register(posdto);
		} catch (IOException e) {

			e.printStackTrace();
		}

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
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
				}
				conn.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
			this.posdto = posdto;
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
//		System.out.println("������");
//		System.out.println();
	}
}
