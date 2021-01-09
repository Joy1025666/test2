package �ݸ�;

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
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Demo01 extends JFrame {

	private JPanel contentPane;
	private JTextField textxm;
	private JTextField textxh;
	private JTextField textcj;
	private JLabel lblcj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo01 frame = new Demo01();
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
	public boolean checkInputCj() {
		if (textcj.getText().length() == 0) {// ��ȡ�ɼ����������ݳ���
			lblcj.setText("�ɼ�����Ϊ��");// ���þ�����Ϣ
			textcj.requestFocus();// �ɼ�������ȡ����
			return false;
		} else if (!textcj.getText().matches("\\d+")) {// ����ƥ������
			lblcj.setText("�ɼ�����������");
			textcj.requestFocus();// �ɼ�������ȡ����
			textcj.selectAll();// ȫѡ���е�����
			return false;
		}
		lblcj.setText("");
		return true;
	}

	public Demo01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblxm = new JLabel("\u59D3\u540D");
		lblxm.setFont(new Font("΢���ź�", Font.BOLD, 30));
		lblxm.setBounds(129, 95, 81, 60);
		contentPane.add(lblxm);

		JLabel lblxh = new JLabel("\u5B66\u53F7");
		lblxh.setFont(new Font("΢���ź�", Font.BOLD, 30));
		lblxh.setBounds(129, 185, 81, 60);
		contentPane.add(lblxh);

		JLabel lblcj = new JLabel("\u6210\u7EE9");
		lblcj.setFont(new Font("΢���ź�", Font.BOLD, 30));
		lblcj.setBounds(129, 278, 81, 60);
		contentPane.add(lblcj);

		

		textxm = new JTextField();
		textxm.setBounds(239, 109, 348, 35);
		contentPane.add(textxm);
		textxm.setColumns(10);

		textxh = new JTextField();
		textxh.setColumns(10);
		textxh.setBounds(239, 203, 348, 35);
		contentPane.add(textxh);

		textcj = new JTextField();
//		textcj.addKeyListener(new KeyAdapter() { //���ӳɼ����������¼�
//			@Override
//			public void keyPressed(KeyEvent arg0) {// �������̼�������
//				if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {//����ǻس���
//					if (checkInputCj()) {
//						btnAdd.requestFocus();
//					}
//				}
//			}
//		});
//		textcj.addFocusListener(new FocusAdapter() {//���ı������ӽ�������¼�
//			@Override
//			public void focusLost(FocusEvent arg0) {// �����ı���ʧȥ����
//				checkInputCj();
//			}
//		});
		textcj.setColumns(10);
		textcj.setBounds(239, 289, 348, 35);
		contentPane.add(textcj);

		JButton btnAdd = new JButton("\u589E\u52A0");
		btnAdd.addActionListener(new ActionListener() { //����ť���Ӽ����¼�
			public void actionPerformed(ActionEvent arg0) {// ������굥��
				checkInputCj(); //�����������ݼ���
			}
		});
		btnAdd.setFont(new Font("΢���ź�", Font.BOLD | Font.ITALIC, 25));
		btnAdd.setBounds(129, 380, 103, 47);
		contentPane.add(btnAdd);
	}
}
