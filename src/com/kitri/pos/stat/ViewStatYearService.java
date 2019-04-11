package com.kitri.pos.stat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.kitri.pos.PosDto;

public class ViewStatYearService implements ActionListener {

	private ViewStatYear vy;

	// [������]
	public ViewStatYearService(ViewStatYear vy) {
		this.vy = vy;
	}

	// [ActionListener override]
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == vy.btnSearch) {
			search();
		}
	}
	
	// [��� �޼ҵ�]
	// <��ȸ ��ư Ŭ��> �̺�Ʈ
		public void search() {
			// TODO findYearSell()�� ���ڰ��� �ʵ忡�� �޾ƿ��� �� & ��ȸ ��ư ���� �� �̺�Ʈ ������ ������ ����
			System.out.println("������ ��ȸ ��ư�� ���Ƚ��ϴ�.");

			// �޺��ڽ��� ���� ������
			// (���۳⵵)
//			int startYear = Integer.parseInt(vy.comboStartYear.getActionCommand());
//			int endYear = Integer.parseInt(vy.comboEndYear.getActionCommand());
			
			StatDao statDao = new StatDao(); // Dao ��ü
			Vector<PosDto> results = new Vector<PosDto>(); // ���� ���

			// select ��� ����
//			results = statDao.findYearSell(startYear, endYear); // DB select ��� ���� ����
			results = statDao.findYearSell(2019, 2020); // DB select ��� ���� ����
			
			// ���̺� �� ����
			int size = results.size();

			for(int i = 0; i < size; i++) {		
				Vector<String> rows = new Vector<String>(); // ��

				rows.addElement(results.get(i).getSellDate());
				rows.addElement(Integer.toString(results.get(i).getStatTotalPrice()));
				rows.addElement(Integer.toString(results.get(i).getTotalTax()));
				rows.addElement(Integer.toString(results.get(i).getCashPrice()));
				rows.addElement(Integer.toString(results.get(i).getCardPrice()));
				rows.addElement(Integer.toString(results.get(i).getCustomerCount()));
				vy.tmodel.addRow(rows);
			}
			
			// ��� ���̺� ����
			vy.spShowTable.setViewportView(vy.tableResult);
		}
		
		// <�׷��� ����> �̺�Ʈ
//		public JFreeChart getChart() {
//			return null;
//		}

}
