package com.kitri.pos.stat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kitri.pos.PosDto;

public class ViewStatDayService implements ActionListener {

	private ViewStatDay vd;

	// [������]
	public ViewStatDayService(ViewStatDay vd) {
		this.vd = vd;
	}

	// [ActionListener override]
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == vd.btnSearch) {
			search();
		}
	}

	// [��� �޼ҵ�]
	// <��ȸ ��ư Ŭ��> �̺�Ʈ
	public void search() {
		
		// TODO findDaySell()�� ���ڰ��� �ʵ忡�� �޾ƿ��� �� & ��ȸ ��ư ���� �� �̺�Ʈ ������ ������ ����
		System.out.println("�Ϻ� ��ȸ ��ư�� ���Ƚ��ϴ�.");
				
		// �޺��ڽ��� ���� ������ (�⵵, ��, ��)
		String year = vd.comboYear.getActionCommand();
		System.out.println(year);
		
		StatDao statDao = new StatDao(); // Dao ��ü
		Vector<String> rows = new Vector<String>(); // ��
		
		// select ��� ����
		PosDto result = statDao.findDaySell("2020", "08", "12"); // DB select ��� ���� ���� //@@@@@@@@@@
				
		// ���̺� �� ����
		rows.addElement(result.getSellDate());
		rows.addElement(Integer.toString(result.getStatTotalPrice()));
		rows.addElement(Integer.toString(result.getTotalTax()));
		rows.addElement(Integer.toString(result.getCashPrice()));
		rows.addElement(Integer.toString(result.getCardPrice()));
		rows.addElement(Integer.toString(result.getCustomerCount()));

		vd.tmodel.addRow(rows);

		// ��� ���̺� ����
		vd.spShowTable.setViewportView(vd.tableResult);
		
	}

	// <�׷��� ����> �̺�Ʈ
//		public JFreeChart getChart() {
//			return null;
//		}

}
