package com.kitri.pos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class UserList implements MouseListener {

	Vector<UserDto> row;
	Vector<String> cols;
	//====================//
	DefaultTableModel model;
	JTable jTable;
	JScrollPane pane;
//	UserDao dao;

	// �⺻������
	public UserList() {

		UserDao dao = new UserDao();
		
		row = dao.getMemberList();
		cols = new Vector<String>(getColum());


		jTable = new JTable(model);
		jTable.setFont(new Font("���� ���", Font.PLAIN, 20));
		pane = new JScrollPane(jTable);
	
		Administrator ad = new Administrator();
//		ad.pTable.add(row, cols);

		jTable.addMouseListener(this);

	}

	// Jtable �÷�
	Vector<String> getColum() {
		
		cols = new Vector<String>();

		cols.add("�����ڵ�");
		cols.add("�н�����");
		cols.add("���̵�");
		cols.add("����");
		cols.add("�̸�");

		return cols;
	}

	// Jtable ���� ����
	public void jtableRefresh() {

		UserDao userdao = new UserDao();
//		DefaultTableModel model = new DefaultTableModel(userdao.getMemberList(), getColum());
//		jTable.setModel(model);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		int r = jTable.getSelectedRow();
		String id = (String) jTable.getValueAt(r, 0);
//		Administrator ad = new Administrator();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
