package com.kitri.pos.sales;
								//�Ǹ� ����ȭ���� �Ǹ� ���ȭ������ ����?
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
//import javax.swing.JSpinner;	//�ؽ�Ʈ�ʵ忡 ȭ��ǥ ���Ʒ�
//import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import javax.swing.JRadioButton;
import javax.swing.JScrollPane; //������Ʈ�� ��ũ��
import javax.swing.JTextField;
import java.awt.Dimension;	

public class ViewSalesCustomer extends JPanel {
	
	private JTable tableResult;
	
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField1;
	private JTable mainTable;

	/**
	 * Create the panel.
	 */
	public ViewSalesCustomer() {
		setSize(new Dimension(1144, 535));
		setLayout(null);
		
		JPanel salesMainTablePanel = new JPanel();//���̺� �г�
		salesMainTablePanel.setSize(new Dimension(1144, 535));
		salesMainTablePanel.setBounds(0, 0, 1144, 452);
		add(salesMainTablePanel);
		salesMainTablePanel.setLayout(null);
		
		JScrollPane mainScrollPane = new JScrollPane();//���̺� ��ũ��
		mainScrollPane.setSize(new Dimension(1144, 535));
		mainScrollPane.setBounds(14, 12, 1116, 428);
		salesMainTablePanel.add(mainScrollPane);
		
		mainTable = new JTable();
		mainScrollPane.setViewportView(mainTable);
		
		JPanel salesMainSearchPanel = new JPanel();//�Ʒ� �г�
		salesMainSearchPanel.setBounds(0, 452, 1144, 83);
		add(salesMainSearchPanel);
		salesMainSearchPanel.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(145, 12, 218, 46);
		salesMainSearchPanel.add(textField1);//�̸�
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(466, 12, 218, 46);
		salesMainSearchPanel.add(textField2);//�޴���
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(852, 12, 218, 46);
		salesMainSearchPanel.add(textField3);//����
		
		JLabel label = new JLabel("\uC774\uB984 :");//�̸�
		label.setBounds(54, 26, 77, 18);
		salesMainSearchPanel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\uD578\uB4DC\uD3F0 :");//�޴���
		lblNewLabel_1.setBounds(390, 26, 62, 18);
		salesMainSearchPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC0AD\uC81C :");//����
		lblNewLabel_2.setBounds(713, 26, 125, 18);
		salesMainSearchPanel.add(lblNewLabel_2);
		
		//[���̺�]
		//�ӽ� ���̺� �� ����
		
		String header[] = {"����� ID", "�̸�", "����ó", "����Ʈ"};
		String contents[][] = {
				{"1", "������", "010-1234-1234", "30000"},
				{"2", "������", "010-2345-2345", "3000"},
				{"3", "�ڱ���", "010-1111-2222", "30000"},
				{"4", "����Ź", "010-1324-1324", "30000"},
				{"5", "���ǿ�", "010-1324-3333", "30000"},
				{"6", "������", "010-2432-2432", "1000000000"}
		
		};
		
		DefaultTableModel tmodel = new DefaultTableModel(contents, header);
		
		tableResult = new JTable(tmodel);
		tableResult.setRowHeight(30);
		tableResult.setSize(new Dimension(1144, 535));
		mainScrollPane.setViewportView(tableResult);

	}
}
