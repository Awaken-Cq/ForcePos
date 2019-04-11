package com.kitri.pos.stat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import com.kitri.pos.PosDto;

public class ViewStatMonthService implements ActionListener {

	private ViewStatMonth vm;

	// [������]
	public ViewStatMonthService(ViewStatMonth vm) {
		this.vm = vm;
	}

	// [ActionListener override]
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == vm.btnSearch) {
			search();
		}
	}

	// [��� �޼ҵ�]
	// <��ȸ ��ư Ŭ��> �̺�Ʈ
	public void search() {

		// TODO findMonthSell()�� ���ڰ��� �ʵ忡�� �޾ƿ��� �� & ��ȸ ��ư ���� �� �̺�Ʈ ������ ������ ����
		System.out.println("���� ��ȸ ��ư�� ���Ƚ��ϴ�.");

		// �޺��ڽ��� ���� ������
		// (���۳⵵)
//		int startYear = Integer.parseInt(vm.comboYear.getActionCommand());
		
		StatDao statDao = new StatDao(); // Dao ��ü
		Vector<PosDto> results = new Vector<PosDto>(); // select ����� ���õ� Dto Vector   //@@@@@@@

		// select ��� ����
//		results = statDao.findMonthSell(startYear); // DB select ��� ���� ����
		results = statDao.findMonthSell(2019); // DB select ��� ���� ����
		
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
			
			vm.tmodel.addRow(rows);
		}

		// ��� ���̺� ����
		vm.spShowTable.setViewportView(vm.tableResult);
	}

	// <�׷��� ����> �̺�Ʈ
//	public JFreeChart getChart() {
//		return null;
//	}

}
