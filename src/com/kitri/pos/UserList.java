package com.kitri.pos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserList implements MouseListener {

	Vector v;
	Vector cols;
	//====================//
	DefaultTableModel model;
	JTable jTable;
	JScrollPane pane;
	UserDao dao;

	// �⺻������
	public UserList() {

		UserDao dao = new UserDao();
		v = dao.getMemberList();
		cols = getColum();

		model = new DefaultTableModel(v, cols);

		jTable = new JTable(model);
		pane = new JScrollPane(jTable);

		jTable.addMouseListener(this);

	}

	// Jtable �÷�
	private Vector getColum() {
		Vector col = new Vector();

		col.add("�����ڵ�");
		col.add("�н�����");
		col.add("���̵�");
		col.add("����");
		col.add("�̸�");

		return col;
	}

	// Jtable ���� ����
	public void jtableRefresh() {

		dao = new UserDao();
		DefaultTableModel model = new DefaultTableModel(dao.getMemberList(), getColum());
		jTable.setModel(model);

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
