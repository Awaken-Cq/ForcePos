package com.kitri.pos;

import java.io.*;
import java.sql.*;
import java.util.Vector;

//��������Ҷ� �޾ƾ��ϴ� ��
//���� ID, ���� �н�����, �̸� , ����

public class UserDao {

	// ȸ������Ʈ Ŭ����
	UserList mList;

	// DB����� �ʿ�
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// �⺻������
	public UserDao() {

	}

	//
	public UserDao(UserList mList) {
		this.mList = mList;
	}
	// ����Ʈ�� ���� ������ ���´�.

	// ȸ�� �˻�
	public Vector<UserDto> getMemberList() {

		Vector<UserDto> row = new Vector<UserDto>(); // Jtable�� ���� �� //�����ڵ�, �̸�, �з�

//			Connection con = null; //����
//			PreparedStatement ps = null; //���
//			ResultSet rs = null; //���

		con = getConnection();

		String select = "select *" + "from members" + "order by name asc";
		try {
			ps = con.prepareStatement(select);
			rs = ps.executeQuery();

			while (rs.next()) {

				int user_code = rs.getInt(1);
				String pw = rs.getString(2);
				String id = rs.getString(3);
				String authority = rs.getNString(4);
				String name = rs.getString(5);

				UserDto userdto = new UserDto();
				userdto.setUserCode(user_code);
				userdto.setPw(pw);
				userdto.setId(id);
				userdto.setAuthority(authority);
				userdto.setName(name);

				row.add(userdto);

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// TODO Auto-generated method stub
		return row;
	}

	// ȸ����
	public boolean updateMember(UserDto dto) {

		boolean result = false;

//			Connection con = null;
//			PreparedStatement ps = null;
//			
		con = getConnection();

		String update = "update members set name= ?, pw= ?" + "where id = ? and pw = ?";

		try {

			ps = con.prepareStatement(update);

			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getId());
			ps.setString(4, dto.getPw());

			int r = ps.executeUpdate();

			if (r > 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// ȸ����������
	public boolean deleteMember(String id, String pw) {

		boolean result = false;
//			Connection con = null;
//			PreparedStatement ps = null;

		con = getConnection();
		String delete = "delete" + "from members " + "where id = ? and pw = ?";

		try {

			ps = con.prepareStatement(delete);
			ps.setString(1, id);
			ps.setString(2, pw);

			int r = ps.executeUpdate();

			if (r > 0) {
				result = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// ȸ�����
	public boolean insertMember(UserDto userdto) {

		boolean result = false;

//			Connection con = null;
//			PreparedStatement ps = null;

		con = getConnection();

		String insert = "insert into members(user_code, pw, id, authority, name) values(USER_CODE_SEQ.NEXTVAL, ?, ?, ?, ?)";
		try {

			ps = con.prepareStatement(insert);

//				ps.setInt(1, userdto.getUserCode());
			ps.setString(1, userdto.getPw());
			ps.setString(2, userdto.getId());
			ps.setString(3, userdto.getAuthority());
			ps.setString(4, userdto.getName());

			int r = ps.executeUpdate(); // ���� >> ����

			if (r > 0) {
				System.out.println("ȸ������ ���� ");
				result = true;
			} else {
				System.out.println("ȸ������ ����");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //finally {
//
//			if (rs != null)
//				try {
//					rs.close();
//				} catch (SQLException ex) {
//				}
//			if (ps != null)
//				try {
//					ps.close();
//				} catch (SQLException ex) {
//				}
//			if (con != null)
//				try {
//					con.close();
//				} catch (SQLException ex) {
//				}
//
//		}
		return result;
	}

	// innerClass "DB �����ϴ���..."
	public Connection getConnection() {

		String user = "kitri";
		String pw = "kitri";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				con = DriverManager.getConnection(url, user, pw);
				System.out.println("DB���� �����߽��ϴ�.");
			} catch (SQLException e) {
				System.out.println("DB���� �����߽��ϴ�.");
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("�˼�����.");
			e.printStackTrace();
		} //finally {
//
//			if (rs != null)
//				try {
//					rs.close();
//				} catch (SQLException ex) {
//				}
//			if (ps != null)
//				try {
//					ps.close();
//				} catch (SQLException ex) {
//				}
//			if (con != null)
//				try {
//					con.close();
//				} catch (SQLException ex) {
//				}
//
//		}
		return con;
	}

}
