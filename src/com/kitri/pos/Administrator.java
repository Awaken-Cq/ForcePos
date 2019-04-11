package com.kitri.pos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;

import javax.swing.border.EmptyBorder;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.LineBorder;

public class Administrator extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JTextField userTf; //���̵� �Է�
	private JTextField passTf; //�н����� �Է�
	private JTextField nameTf; //�̸� �Է�
	private JTextField notice; //����â
	private ForcePos frame; //����������
	private UserDto userdto; //Dto
	private UserDao userdao; //Dao
	private UserList userList; //��������Ʈ
	private JComboBox authority; // ����
//	private JRadioButton job1, job2; // �޺��ڽ��ȿ� ����, ������
	String arrJob[] = { "����", "������" };
	private String auth = "F"; //���� ���� ����
	private DefaultTableModel tm;
	private JTable table;
	private boolean result = false; // �μ�Ʈ ����� ����
	JPanel pMonitor;

	// ȸ����� �г�
	JPanel pRegister = new JPanel();
	// ȸ�����̺� �г�
	JPanel pTable = new JPanel();

	CardLayout card = new CardLayout();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Administrator administrator = new Administrator();

					administrator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	public void showFrameTest() {
//		frame1.setVisible(true);
//		frame.dispose();
//	}
	
	public static void tableCellCenter(JTable table) {
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // ����Ʈ���̺��������� ����
		
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // �������� ���������� CENTER��

		TableColumnModel tcm = table.getColumnModel(); // ������ ���̺��� �÷����� ������

		// ��ü ���� ����
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

	//������
	public void showFrame() {
		frame = new ForcePos();
		this.setVisible(false);
		frame.setVisible(true);
	}

// ���������� ���̺�
//	public Administrator(JTable table) {
//		this.table = table;
//	}

	// ����, ������ ������
	public Administrator(String id, UserList userList) {

		this.userList = userList;
		UserDao userDao = new UserDao();

	}

	public Administrator() {

		setFont(new Font("���� ���", Font.BOLD, 20));
		setTitle("Force.pos");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 15, 1326, 753);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pStatusBar = new JPanel();
		pStatusBar.setBackground(new Color(0, 0, 128));
		pStatusBar.setBounds(0, 0, 1308, 51);
		contentPane.add(pStatusBar);
		pStatusBar.setLayout(null);

		JLabel titleLabel = new JLabel("Force. pos");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(new Color(0, 0, 128));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("���� ���", Font.BOLD, 25));
		titleLabel.setBounds(14, 8, 241, 31);
		pStatusBar.add(titleLabel);

		notice = new JTextField();
		notice.setFont(new Font("���� ���", Font.PLAIN, 20));
		notice.setText("\uC0C1\uD488\uBA85(..)\uB294 \uC720\uD1B5\uAE30\uD55C\uC774 \uC9C0\uB0AC\uC2B5\uB2C8\uB2E4.");
		notice.setHorizontalAlignment(SwingConstants.CENTER);
		notice.setBounds(258, 8, 726, 31);
		pStatusBar.add(notice);
		notice.setColumns(10);

		String colName[] = { "�����ڵ�", "�����̸�", "�з�" };
		Object data[][] = { { "1", "������", "�ְ�1" }, { "2", "�����", "�߰�1" }, { "3", "�ɱ״�", "�ְ�2" },
				{ "4", "�־Ʒ�", "�߰�2" } };

		JLabel dateLabel = new JLabel("2019-04-01 \uC624\uD6C4 5:01");
		dateLabel.setBackground(new Color(0, 0, 128));
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setForeground(new Color(255, 255, 255));
		dateLabel.setFont(new Font("���� ���", Font.PLAIN, 20));
		dateLabel.setBounds(1016, 8, 278, 31);
		pStatusBar.add(dateLabel);

		JPanel pMainBtn = new JPanel();
		pMainBtn.setBackground(new Color(255, 255, 255));
		pMainBtn.setBounds(0, 585, 1144, 120);
		contentPane.add(pMainBtn);
		pMainBtn.setLayout(null);

		JLabel idLabel = new JLabel("\uAD00\uB9AC\uC790");
		idLabel.setBackground(new Color(105, 105, 105));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("���� ���", Font.BOLD, 20));
		idLabel.setBounds(860, 0, 201, 120);
		pMainBtn.add(idLabel);

		JButton mBtnInven = new JButton("\uC7AC\uACE0");
		mBtnInven.setBackground(new Color(28, 94, 94));
		mBtnInven.setForeground(new Color(255, 255, 255));
		mBtnInven.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnInven.setBounds(0, 0, 157, 120);
		pMainBtn.add(mBtnInven);

		JButton mBtnSale = new JButton("\uD310\uB9E4");
		mBtnSale.setBackground(new Color(99, 166, 166));
		mBtnSale.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnSale.setForeground(new Color(255, 255, 255));
		mBtnSale.setBounds(156, 0, 157, 120);
		pMainBtn.add(mBtnSale);

		JButton mBtnCalc = new JButton("\uC815\uC0B0");
		mBtnCalc.setBackground(new Color(28, 94, 94));
		mBtnCalc.setForeground(new Color(255, 255, 255));
		mBtnCalc.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnCalc.setBounds(313, 0, 157, 120);
		pMainBtn.add(mBtnCalc);

		JButton mBtnStat = new JButton("\uD1B5\uACC4");
		mBtnStat.setBackground(new Color(99, 166, 166));
		mBtnStat.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnStat.setForeground(new Color(255, 255, 255));
		mBtnStat.setBounds(470, 0, 157, 120);
		pMainBtn.add(mBtnStat);

		JButton mBtnAccount = new JButton("\uACC4\uC815");
		mBtnAccount.setBackground(new Color(28, 94, 94));
		mBtnAccount.setForeground(new Color(255, 255, 255));
		mBtnAccount.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnAccount.setBounds(626, 0, 157, 120);
		pMainBtn.add(mBtnAccount);

		JPanel pSellFunction = new JPanel();
		pSellFunction.setBackground(new Color(0, 0, 128));
		pSellFunction.setBounds(1144, 50, 164, 655);
		contentPane.add(pSellFunction);
		pSellFunction.setLayout(null);

		
		//������� ��ư
		JButton userInsert = new JButton("\uC720\uC800\uB4F1\uB85D");
		userInsert.setForeground(new Color(255, 255, 255));
		userInsert.setBackground(new Color(0, 0, 128));
		userInsert.setFont(new Font("���� ���", Font.BOLD, 20));
		userInsert.setBounds(0, 10, 164, 120);
		pSellFunction.add(userInsert);

		//�������� ��ư
		JButton userUpdate = new JButton("\uC720\uC800\uC218\uC815");
		userUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		userUpdate.setBackground(new Color(100, 149, 237));
		userUpdate.setForeground(new Color(255, 255, 255));
		userUpdate.setFont(new Font("���� ���", Font.BOLD, 20));
		userUpdate.setBounds(0, 130, 164, 120);
		pSellFunction.add(userUpdate);

		
		//�������� ��ư
		JButton userDelete = new JButton("\uC720\uC800\uC0AD\uC81C");
		userDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		userDelete.setBackground(new Color(0, 0, 128));
		userDelete.setForeground(new Color(255, 255, 255));
		userDelete.setFont(new Font("���� ���", Font.BOLD, 20));
		userDelete.setBounds(0, 260, 164, 120);
		pSellFunction.add(userDelete);

		JButton sBtnPdChange = new JButton("\uCD9C\uACB0");
		sBtnPdChange.setBackground(new Color(100, 149, 237));
		sBtnPdChange.setForeground(new Color(255, 255, 255));
		sBtnPdChange.setFont(new Font("���� ���", Font.BOLD, 20));
		sBtnPdChange.setBounds(0, 390, 164, 120);
		pSellFunction.add(sBtnPdChange);

		JButton logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logout.setBackground(new Color(255, 69, 0));
		logout.setForeground(new Color(255, 255, 255));
		logout.setFont(new Font("���� ���", Font.BOLD, 20));
		logout.setBounds(0, 520, 164, 120);
		pSellFunction.add(logout);

		pMonitor = new JPanel();
		pMonitor.setSize(new Dimension(1144, 533));
		pMonitor.setBackground(new Color(255, 255, 255));
		pMonitor.setBounds(0, 50, 1144, 533);
		contentPane.add(pMonitor);

		pRegister.setBackground(SystemColor.desktop);
		pRegister.setBorder(new LineBorder(new Color(0, 0, 0)));
		pRegister.setLayout(null);

		JPanel prInput = new JPanel();
		prInput.setBorder(new LineBorder(new Color(0, 0, 0)));
		prInput.setBounds(451, 10, 356, 513);
		prInput.setLayout(new GridLayout(11, 1, 0, 0));
		pRegister.add(prInput);

		tm = new DefaultTableModel(data, colName);

		pTable.setBounds(0, 0, 10, 10);
		pMonitor.add(pTable);
		table = new JTable(tm);

		table.setRowHeight(60);
		tableCellCenter(table);
		table.getColumn("�����ڵ�").setPreferredWidth(5);
		pTable.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		pTable.add(scrollPane);
		scrollPane.setBounds(0, 5, 1144, 528);

		//ī�巹�̾ƿ����.
		pMonitor.setLayout(card);
		pMonitor.add("pTable", pTable);
		pMonitor.add("pRegister", pRegister);
		card.show(pMonitor, "pTable");

		JPanel panel = new JPanel();
		prInput.add(panel);

//		pRegister.setBackground(SystemColor.desktop);
//		pRegister.setBorder(new LineBorder(new Color(0, 0, 0)));
//		pMonitor.add(pRegister, "name_39053666565740");
//		pRegister.setLayout(null);
//		JPanel prInput = new JPanel();
//		prInput.setBorder(new LineBorder(new Color(0, 0, 0)));
//		prInput.setBounds(456, 10, 356, 513);
//		pRegister.add(prInput);
//		prInput.setLayout(new GridLayout(9, 1, 0, 0));

		JLabel userIdLabel = new JLabel("\uC720\uC800ID");
		userIdLabel.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInput.add(userIdLabel);

		//ȸ����� - �������̵��Է�
		userTf = new JTextField();
		prInput.add(userTf);
		userTf.setColumns(10);
		JLabel passWLabel_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		passWLabel_1.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInput.add(passWLabel_1);
		
		//ȸ�����  - �н������Է�
		passTf = new JTextField();
		prInput.add(passTf);
		passTf.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInput.add(lblNewLabel_2);

		
		//ȸ����� - �̸��Է�
		nameTf = new JTextField();
		prInput.add(nameTf);
		nameTf.setColumns(10);
		JLabel lblNewLabel_3 = new JLabel("\uAD8C\uD55C");
		lblNewLabel_3.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInput.add(lblNewLabel_3);

		// ���ѹ迭
		authority = new JComboBox(arrJob);
		prInput.add(authority);
//		authority.getName();
//		System.out.println(authority);
		authority.getSelectedItem();

		
		//�Ʒ���ư�г�
		JPanel pB = new JPanel();
		prInput.add(pB);
		pB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//Ȯ�ι�ư
		JButton ok = new JButton("\uD655\uC778");
		ok.setMargin(new Insets(2, 20, 2, 20));
		ok.setHorizontalTextPosition(SwingConstants.CENTER);
		ok.setFont(new Font("���� ���", Font.PLAIN, 20));
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		pB.add(ok);

		//��ҹ�ư
		JButton cancel = new JButton("\uCDE8\uC18C");
		cancel.setMargin(new Insets(2, 20, 2, 20));
		cancel.setBackground(new Color(255, 99, 71));
		cancel.setHorizontalTextPosition(SwingConstants.CENTER);
		cancel.setFont(new Font("���� ���", Font.BOLD, 20));
		pB.add(cancel);

		//�̺�Ʈ ������ ���
		userInsert.addActionListener(this);
		userDelete.addActionListener(this);
		logout.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
//		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
//		celAlignCenter.setHorizontalAlignment(table);
	}

	//ȸ�����â�� �Էµ� ���� ������
	public UserDto getViewData() {

//		BufferedReader in;
//		in = new BufferedReader(new InputStreamReader(System.in));
		UserDto userdto = new UserDto();

		try {

//			System.out.print("�����ڵ� �Է� �ٶ�.");
//			int user_code = Integer.parseInt(in.readLine());
//			System.out.println("�н����� �Է¹ٶ�");
			userdto.setPw(passTf.getText());
//			System.out.println("���̵� �Է¹ٶ�");
			userdto.setId(userTf.getText());
//			System.out.println("���� �Է¹ٶ�");
			userdto.setAuthority(auth); // string
			userdto.setName(nameTf.getText());
//			System.out.println("�̸� �Է¹ٶ�");

		} catch (NumberFormatException e) {
			System.out.println("�Է½���");
			e.printStackTrace();
		}

		// ���Ѽ��� �� ������ �ְ� ���É��� �� ���� ���´�.

//		dto.setUserCode(userCode);

		return userdto;

	}

//	public String isSelect() {
//
//		Object ob = authority.getSelectedItem();
//
//		if (ob.equals("����")) {
//			auth = "F";
//		} else {
//			auth = "T";
//		}
//
//		return auth;
//	
//		char ch;
//		
//		if (job2.isSelected()) {
//			ch = auth.charAt(0);
//			auth = "T";
//		} else if(job1.isSelected()) {
//			ch = auth.charAt(0);
//			auth = "F";
//		}
//		
//		return auth;

//	}

	// ȸ�������ȿ���˻�.
	private boolean insertUser() {

		boolean result = true;

		UserDto userDto = getViewData();
		UserDao userDao = new UserDao();

//		boolean result = userDao.insertMember(userDto);

		if (result) {
			JOptionPane.showMessageDialog(this, "����� �Ϸ�Ǿ����ϴ�. �����մϴ�.");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "����� ���еǾ����ϴ�.");
			result = false;
		}
		return result;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object ob = e.getActionCommand();

		// ȸ������̶������.
		if (ob.equals("�������")) {
			card.show(pMonitor, "pRegister");
//			userdao = new UserDao();
//			System.out.println("������Ϲ�ư");
//			userdto = new UserDto();
//			userdao.insertMember(userdto);  
//			DefaultTableModel tm = (DefaultTableModel) table.getModel();
//			String add[] = {"1", "���ǿ�", "�ְ�"};
//			tm.addRow(add);
//			UserDao userdao = new UserDao();
//			userdao.register(posdto);	
//			getViewData();

		}

		if (ob.equals("��������")) {
			
		}

		// ������ ���������� ����
		if (ob.equals("��������")) {
			// ���̺��� ���� ������ ���ȣ
			int number = table.getSelectedRow();
//			System.out.println(number);
			DefaultTableModel tm = (DefaultTableModel) table.getModel();
			if (number >= 0 && number < table.getRowCount()) {
				tm.removeRow(number);
			}
		}

		// Ȯ���� ������ �������â
		if (ob.equals("Ȯ��")) {
//			System.out.println("Ȯ�ε�Ͽ�");
			insertUser();
			UserDto result = getViewData();
			UserDao userdao = new UserDao();
			userdao.insertMember(result);
		}

		// ��ҹ�ư�� ������ ���ÿ� �ٽ� ���̺�ȭ������.
		if (ob.equals("���")) {
//			System.out.println("��ҹ�ư���");
			card.show(pMonitor, "pTable");
		}

		// ���״�� �α׾ƿ� �������������� �Ѿ.
		if (ob.equals("�α׾ƿ�")) {
			this.setVisible(false);
			ForcePos forcePos = new ForcePos();
			forcePos.setVisible(true);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object ob = e.getItem();

		System.out.println(ob);

	}
}
