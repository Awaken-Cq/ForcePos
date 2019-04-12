package com.kitri.pos;

import java.io.*;
import java.sql.*;
import java.util.Vector;

import com.kitri.pos.db.DBManager;

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

		con = DBManager.getConnection();

		String select = "select *" + "from members";

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
			System.out.println("��� ����");
			e1.printStackTrace();
		} //finally {
//			try {
//				DBManager.dbClose(ps, con);
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}

		// TODO Auto-generated method stub
		return row;
	}

	// ȸ����
	public boolean updateMember(UserDto dto) throws SQLException {

		boolean result = false;

//			Connection con = null;
//			PreparedStatement ps = null;
//			
		con = DBManager.getConnection();

		String update = "update members set name= ?, pw= ?" + "where id = ? and pw = ?";

		try {

			ps = con.prepareStatement(update);

			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getId());
			ps.setString(4, dto.getPw());

			int r = ps.executeUpdate();

			if (r > 0) {
				System.out.println("DB������ �Ϸ�Ǿ����ϴ�.");
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("DB������ �����߽��ϴ�.");
			e.printStackTrace();
		} finally {
			DBManager.dbClose(ps, con);
		}
		return result;
	}

	// ȸ����������
	public boolean deleteMember(String id, String pw) {

		boolean result = false;
//			Connection con = null;
//			PreparedStatement ps = null;

		con = DBManager.getConnection();
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
		} finally {
			try {
				DBManager.dbClose(ps, con);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return result;
	}

	// ȸ�����
	public boolean insertMember(UserDto userdto) {

		boolean result = false;

//			Connection con = null;
//			PreparedStatement ps = null;

		con = DBManager.getConnection();

		String insert = "insert into members(user_code, pw, id, authority, name) values(USER_CODE_SEQ.NEXTVAL, ?, ?, ?, ?)";
		try {

			ps = con.prepareStatement(insert);

//			ps.setInt(1, userdto.getUserCode());
			ps.setString(1, userdto.getPw());
			ps.setString(2, userdto.getId());
			ps.setString(3, userdto.getAuthority());
			ps.setString(4, userdto.getName());
						
			int r = ps.executeUpdate(); // ���� >> ����
			String str = Integer.toString(r);
			if (str == null) {
				System.out.println("ȸ������ ����");
			}
			
			if (r > 0) {
				System.out.println("ȸ������ ���� ");
				result = true;
			} 

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}  finally {
			try {
				DBManager.dbClose(ps, con);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return result;
	}

}
