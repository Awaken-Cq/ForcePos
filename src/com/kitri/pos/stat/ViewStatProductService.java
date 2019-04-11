package com.kitri.pos.stat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.kitri.pos.PosDto;

public class ViewStatProductService implements ActionListener {

	private ViewStatProduct vp;

	// [������]
	public ViewStatProductService(ViewStatProduct vp) {
		this.vp = vp;
	}

	// [ActionListener override]
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == vp.btnSearch) {
			search();
		}
	}

	// [��� �޼ҵ�]
	// <��ȸ ��ư Ŭ��> �̺�Ʈ
	public void search() {
		// TODO findProductSell()�� ���ڰ��� �ʵ忡�� �޾ƿ��� �� & ��ȸ ��ư ���� �� �̺�Ʈ ������ ������ ����
				System.out.println("��ȸ ��ư�� ���Ƚ��ϴ�.");

				// �޺��ڽ��� ���� ������
				// (���۳⵵)
//				int startYear = Integer.parseInt(vm.comboYear.getActionCommand());
				
				
				StatDao statDao = new StatDao(); // Dao ��ü
				Vector<PosDto> results = new Vector<PosDto>(); // select ����� ���õ� Dto Vector   //@@@@@@@

				// select ��� ����
//				results = statDao.findMonthSell(startYear); // DB select ��� ���� ����
				results = statDao.findProductSell("����", "2019", "05"); // DB select ��� ���� ����
				
				// ���̺� �� ����
				int size = results.size();

				for(int i = 0; i < size; i++) {
					Vector<String> rows = new Vector<String>(); // ��
//					String header[] = { "�������", "��ǰ�ڵ�", "��ǰ�з�", "��ǰ��", "�ǸŰ�", "�Ǹż���", "�����հ�", "������" };
					rows.addElement(Integer.toString(results.get(i).getRanking()));
					rows.addElement(results.get(i).getProductCode());
					rows.addElement(results.get(i).getMajorLevel());					
					rows.addElement(results.get(i).getProductName());
					rows.addElement(Integer.toString(results.get(i).getPrice()));
					rows.addElement(Integer.toString(results.get(i).getPurchase()));
					rows.addElement(Integer.toString(results.get(i).getSellCount()));
					rows.addElement(Integer.toString(results.get(i).getStatTotalPrice()));		
					rows.addElement(results.get(i).getCompany());		
					
					vp.tmodel.addRow(rows);
				}

				// ��� ���̺� ����
				vp.spShowTable.setViewportView(vp.tableResult);
	}
	
	// <�׷��� ����> �̺�Ʈ
//	public JFreeChart getChart() {
//		return null;
//	}

}
