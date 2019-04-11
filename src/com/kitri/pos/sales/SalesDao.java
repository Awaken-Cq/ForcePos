package com.kitri.pos;

import java.nio.channels.MembershipKey;
import java.sql.*;
import java.util.Vector;

import com.kitri.pos.PosDto;
import com.kitri.pos.DBManager;

/*
	StatDao : ��� DB ���� �޼ҵ� ����
*/

public class SalesDao {

	// DB����� ����(����)�� ���� ��ü
	Connection conn = null;

	// �������� ����ϴ� state��ü
	PreparedStatement ps = null;

	Statement st = null;
	ResultSet rs = null;

	// ������ ��� (1��) ���� PosDto ��ü
	PosDto posDto = null;

	public Vector<PosDto> searchAll() {
		// ������ ��� (���� ��) ���� PosDto ��ü
		Vector<PosDto> list = new Vector<PosDto>();

		try {
			// DB ����
			conn = DBManager.getConnection();

			// ������ ����
			String query = "select * from MEMBERSHIP";
			ps = conn.prepareStatement(query);

			// ������ ����
			rs = ps.executeQuery();
			// ��� ����
			while (rs.next()) {

				posDto = new PosDto();

				posDto.setMembershipId(rs.getString(1));
				posDto.setMemberName(rs.getString(2));
				posDto.setPhone(rs.getString(3));
				posDto.setPoint(rs.getInt(4));

				list.add(posDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB ���� ����
				DBManager.dbClose(rs, ps, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ��� ����
		return list;
	}

	
	public Vector<PosDto> search(String name) {
		// ������ ��� (���� ��) ���� PosDto ��ü
		Vector<PosDto> list = new Vector<PosDto>();
		ViewSalesCustomer viewSalesCustomer = new ViewSalesCustomer();
		name = viewSalesCustomer.name.getText();
		try {
			// DB ����
			conn = DBManager.getConnection();

			// ������ ����
			String query = "select * from MEMBERSHIP"
					+ "where name = ?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, name);
			
			// ������ ����
			rs = ps.executeQuery();
			// ��� ����
			while (rs.next()) {

				posDto = new PosDto();

				posDto.setMembershipId(rs.getString(1));
				posDto.setMemberName(rs.getString(2));
				posDto.setPhone(rs.getString(3));
				posDto.setPoint(rs.getInt(4));

				list.add(posDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB ���� ����
				DBManager.dbClose(rs, ps, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ��� ����
		return list;
	}
	
}
