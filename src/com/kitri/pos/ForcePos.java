package com.kitri.pos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import sun.security.krb5.internal.LoginOptions;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;

public class ForcePos extends JFrame {

	private JPanel contentPane;
	private JTextField userTf;
	private JTextField passTf;
	private RoundedButton rb_1;

	/*
	 * private String img;
	 * 
	 * public void inputIcon() { mageIcon �����Ҿ����� = new ImageIcon("�̹���.png"); Image
	 * �������̹��� = �����Ҿ�����.getImage(); //ImageIcon�� Image�� ��ȯ. Image ������̹��� =
	 * �������̹���.getScaledInstance(����, ����, java.awt.Image.SCALE_SMOOTH); ImageIcon
	 * ����Ⱦ����� = new ImageIcon(������̹���); //Image�� ImageIcon ���� img =
	 * System.getProperty("user.dir"); System.out.println(img); ImageIcon icon = new
	 * ImageIcon("userIcon.png"); Image image = icon.getImage(); Image image2 =
	 * image.getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING); ImageIcon
	 * icon2 = new ImageIcon(image2); System.out.println(icon2);
	 * lblNewLabel.setIcon(new ImageIcon()); ���丮 ��ο� ������ �ִ��� Ȯ���ϴ� ���� File f = new
	 * File("D:\\Workspace\\Project\\userIcon.png"); System.out.println(f.exists());
	 * Toolkit tk = Toolkit.getDefaultToolkit(); image =
	 * tk.getImage("D:\\Workspace\\Project\\userIcon.png");
	 * 
	 * jpanel = new JPanel() {
	 * 
	 * @Override public void paint(Graphics g) { g.drawImage(image, 0, 0, null);
	 * super.paintComponents(g); } };
	 * 
	 * add("Center", jpanel); add("North", new JLabel("�гο� �̹��� ���̱�"));
	 * setBounds(200, 200, 300, 300); contentPane.add(jpanel); setVisible(true);
	 * 
	 * }
	 */

	// ������
	public ForcePos() {
		super("ForcePos");

		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 15, 1326, 753);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ���ȭ�� �г�
		JPanel background = new JPanel() {

			@Override
			public void paintComponent(Graphics g) {
				Dimension d = getSize(); // �г��� ũ�⸦ ����
				ImageIcon image = new ImageIcon("D:\\Workspace\\Project\\src\\image\\Background.png"); // �̹�������.
				g.drawImage(image.getImage(), 0, 0, d.width, d.height, null); // Jpanel�� ũ�⿡ �°� �̹����� �׸���.
				setOpaque(false); // ����� �����ϰ� ��������
				super.paintComponent(g);

			}
		};
		background.setBounds(12, 10, 1326, 753);
		contentPane.add(background);
		background.setLayout(null);

		JPanel title = new JPanel();
		title.setOpaque(false);
		title.setBounds(12, 10, 1278, 83);
		background.add(title);
		title.setLayout(new BorderLayout(0, 0));

		JLabel Forcepos = new JLabel("Forcepos");
		Forcepos.setHorizontalTextPosition(SwingConstants.CENTER);
		Forcepos.setForeground(new Color(138, 43, 226));
		Forcepos.setHorizontalAlignment(SwingConstants.CENTER);
		Forcepos.setFont(new Font("���� ���", Font.BOLD, 70));
		title.add(Forcepos, BorderLayout.CENTER);

		// �α��� ȭ�� �г� ���� 
		JPanel user = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Dimension d = getSize();
				ImageIcon image = new ImageIcon("D:\\Workspace\\Project\\src\\image\\Usericon.png");
				g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		user.setOpaque(false);
		user.setBounds(328, 176, 153, 165);
		background.add(user);

		//���� �г�
		JPanel userP = new JPanel();
		userP.setOpaque(false);
		userP.setBounds(497, 176, 475, 165);
		background.add(userP);
		userP.setLayout(new BorderLayout(0, 0));
		
		//���� �ؽ�Ʈ�ʵ�
		userTf = new JTextField();
		userTf.setHorizontalAlignment(SwingConstants.CENTER);
		userTf.setFont(new Font("���� ���", Font.ITALIC, 40));
		userTf.setText("USER");
		userP.add(userTf, BorderLayout.CENTER);
		userTf.setColumns(10);

		//�н����� �г� ���� 
		JPanel pass = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Dimension d = getSize();
				ImageIcon image = new ImageIcon("D:\\Workspace\\Project\\src\\image\\KEY.png");
				g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			};
		};
		pass.setOpaque(false);

		pass.setBounds(328, 368, 153, 156);
		background.add(pass);

		//�н����� �г�
		JPanel passP = new JPanel();
		passP.setBounds(497, 368, 475, 156);
		background.add(passP);
		passP.setLayout(new BorderLayout(0, 0));
		
		//��й�ȣ�ؽ�Ʈ�ʵ�
		passTf = new JTextField();
		passTf.setHorizontalAlignment(SwingConstants.CENTER);
		passTf.setFont(new Font("���� ���", Font.ITALIC, 40));
		passTf.setText("****");
		passP.add(passTf, BorderLayout.CENTER);
		passTf.setColumns(10);

		//��ư �ΰ�
		JPanel SouthButt = new JPanel();
		SouthButt.setOpaque(false);
		SouthButt.setBounds(407, 584, 515, 111);
		background.add(SouthButt);
		SouthButt.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//�α��� ��ư
		//�ձ۰� ����� ��ư Ŭ���� ��ü ������ ���� 
		JButton loginB = new JButton("\uB85C\uADF8\uC778 ");
		RoundedButton rb = new RoundedButton("�α���");
		rb.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		loginB = rb;
		
		loginB.setForeground(new Color(240, 248, 255));
		loginB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginB.setSize(new Dimension(10, 10));
		loginB.setIconTextGap(1);
		loginB.setBackground(new Color(28, 94, 94));
		loginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		loginB.setFont(new Font("���� ���", Font.PLAIN, 50));
		SouthButt.add(loginB);

		//���� ��ư
		//�ձ۰� ����� ��ư Ŭ���� ��ü ������ ���� 
		JButton exitB = new JButton("\uC885\uB8CC");
		rb_1 = new RoundedButton("��   ��");
		rb_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 127, 80), new Color(255, 127, 80)));
		exitB = rb_1;
		
		
		exitB.setBackground(new Color(255, 99, 71));
		exitB.setForeground(new Color(240, 248, 255));
		exitB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitB.setIconTextGap(1);
		exitB.setMinimumSize(new Dimension(73, 23));
		exitB.setMaximumSize(new Dimension(73, 23));
		exitB.setFont(new Font("���� ���", Font.PLAIN, 50));
		SouthButt.add(exitB);

//		inputIcon();
		setResizable(false);
	}

	// ����
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForcePos frame = new ForcePos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
