package ��ɾ���;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;

public class Demo04 extends JFrame {

	private JPanel contentPane;
	private JTextField txtXh;
	private JTextField txtXm;
	private JTextField txtCj;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo04 frame = new Demo04();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Demo04() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblXh = new JLabel("\u5B66\u53F7\uFF1A");
		lblXh.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		lblXh.setBounds(109, 76, 75, 34);
		contentPane.add(lblXh);

		JLabel lblXm = new JLabel("\u59D3\u540D\uFF1A");
		lblXm.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		lblXm.setBounds(111, 157, 75, 34);
		contentPane.add(lblXm);

		JLabel lblCj = new JLabel("\u6210\u7EE9\uFF1A");
		lblCj.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		lblCj.setBounds(109, 236, 88, 34);
		contentPane.add(lblCj);

		txtXh = new JTextField();
		txtXh.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				File file = new File("c:\\Javatest\\stu.txt");
				String s = null;
				JLabel lblMsgXh = new JLabel("");
				lblMsgXh.setForeground(Color.RED);
				lblMsgXh.setFont(new Font("΢���ź�", Font.PLAIN, 25));
				lblMsgXh.setBounds(453, 76, 227, 34);
				contentPane.add(lblMsgXh);
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					while ((s = br.readLine()) != null) {
						if (s.contains(txtXh.getText())) {
							lblMsgXh.setText("ѧ���Ѿ�����");
						} else if (txtXh.getText().length() == 0) {
							lblMsgXh.setText("ѧ�Ų���Ϊ��");
						} else
							lblMsgXh.setText("");

					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		txtXh.setBounds(199, 77, 202, 39);
		contentPane.add(txtXh);
		txtXh.setColumns(10);

		txtXm = new JTextField();
		txtXm.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				JLabel lblMsgXm = new JLabel("");
				lblMsgXm.setForeground(Color.RED);
				lblMsgXm.setFont(new Font("΢���ź�", Font.PLAIN, 25));
				lblMsgXm.setBounds(465, 157, 259, 34);
				contentPane.add(lblMsgXm);
				if (txtXm.getText().length() == 0) {// ��ȡ�������������ݳ���
					lblMsgXm.setText("��������Ϊ��"); // ���þ�����Ϣ
					txtCj.requestFocus(); // ����������ȡ����
				} else if (txtXm.getText().matches("[\\\\u4E00-\\\\u9FA5]+")) {// ����ƥ������
					lblMsgXm.setText("�����������ַ�");
					txtXm.requestFocus();// ����������ȡ����
					txtXm.selectAll();// ȫѡ���е�����
				} else
					lblMsgXm.setText("");
			}
		});
		txtXm.setColumns(10);
		txtXm.setBounds(199, 157, 202, 39);
		contentPane.add(txtXm);

		txtCj = new JTextField();
		txtCj.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				JLabel lblMsgCj = new JLabel("");
				lblMsgCj.setForeground(Color.RED);
				lblMsgCj.setFont(new Font("΢���ź�", Font.PLAIN, 25));
				lblMsgCj.setBounds(448, 236, 500, 34);
				contentPane.add(lblMsgCj);
				if (txtCj.getText().length() == 0) {// ��ȡ�ɼ����������ݳ���
					lblMsgCj.setText("�ɼ�����Ϊ��");// ���þ�����Ϣ
					txtCj.requestFocus();// �ɼ�������ȡ����
				} else if (!txtCj.getText().matches("\\d+")) {// ����ƥ������
					lblMsgCj.setText("�ɼ�����������");
					txtCj.requestFocus();// �ɼ�������ȡ����
					txtCj.selectAll();// ȫѡ���е�����
				} else
					lblMsgCj.setText("");
			}
		});

		txtCj.setColumns(10);
		txtCj.setBounds(199, 237, 202, 39);
		contentPane.add(txtCj);

		JButton btnAdd = new JButton("\u589E\u52A0");
		btnAdd.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("c:\\Javatest\\stu.txt");
				try (FileWriter fw = new FileWriter(file, true)) {// �����ַ������
					fw.write(txtXh.getText() + "\t" + txtXm.getText() + "\t" + txtCj.getText() + "\r\n");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(88, 316, 113, 39);
		contentPane.add(btnAdd);

	}
}
