package com.kitri.pos;


import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class UserList {

	Vector<UserDto> data;
	Vector<String> userColumn;
	
	
	//====================//
	Administrator administrator;
	UserDao userDao;


	// �⺻������
	public UserList() {

//		UserDao dao = new UserDao();
//		row = dao.getMemberList(); // ���̺��� ������ select 
//		cols = new Vector<String>(getColum());
//		jTable = new JTable(model);
//		jTable.setFont(new Font("���� ���", Font.PLAIN, 20));
//		pane = new JScrollPane(jTable);
//		jTable.addMouseListener(this);
//
//		userDao = new UserDao();
//		data = userDao.getMemberList();
//		data = new Vector<UserDto>(data);
//
//		userColumn = new Vector<String>();
//		userColumn.addElement("�����ڵ�");
//		userColumn.addElement("pw");
//		userColumn.addElement("id");
//		userColumn.addElement("aurthority");
//		userColumn.addElement("name");
//
//		
//		int size = data.size();
//		
//		for (int i = 0; i < size; i++) {
//			// ��
//			Vector<String> row = new Vector<String>();
//		
//
//			// ���ڸ� ���ڷ� ��ȯ �࿡ �߰�
//			row.addElement(data.get(i).getUserCode() +"");
//			row.addElement(data.get(i).getPw());
//			row.addElement(data.get(i).getId());
//			row.addElement(data.get(i).getAuthority());
//			row.addElement(data.get(i).getName());
//
//			administrator.tm = new DefaultTableModel(userColumn, data);
//			administrator.tm.addRow(row);


		}
	}
//}
