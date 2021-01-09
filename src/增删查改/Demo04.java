package 增删查改;

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
		lblXh.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		lblXh.setBounds(109, 76, 75, 34);
		contentPane.add(lblXh);

		JLabel lblXm = new JLabel("\u59D3\u540D\uFF1A");
		lblXm.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		lblXm.setBounds(111, 157, 75, 34);
		contentPane.add(lblXm);

		JLabel lblCj = new JLabel("\u6210\u7EE9\uFF1A");
		lblCj.setFont(new Font("微软雅黑", Font.PLAIN, 25));
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
				lblMsgXh.setFont(new Font("微软雅黑", Font.PLAIN, 25));
				lblMsgXh.setBounds(453, 76, 227, 34);
				contentPane.add(lblMsgXh);
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					while ((s = br.readLine()) != null) {
						if (s.contains(txtXh.getText())) {
							lblMsgXh.setText("学号已经存在");
						} else if (txtXh.getText().length() == 0) {
							lblMsgXh.setText("学号不能为空");
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
				lblMsgXm.setFont(new Font("微软雅黑", Font.PLAIN, 25));
				lblMsgXm.setBounds(465, 157, 259, 34);
				contentPane.add(lblMsgXm);
				if (txtXm.getText().length() == 0) {// 获取姓名输入框的内容长度
					lblMsgXm.setText("姓名不能为空"); // 设置警告信息
					txtCj.requestFocus(); // 姓名输入框获取焦点
				} else if (txtXm.getText().matches("[\\\\u4E00-\\\\u9FA5]+")) {// 正则匹配中文
					lblMsgXm.setText("姓名必须是字符");
					txtXm.requestFocus();// 姓名输入框获取焦点
					txtXm.selectAll();// 全选当中的内容
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
				lblMsgCj.setFont(new Font("微软雅黑", Font.PLAIN, 25));
				lblMsgCj.setBounds(448, 236, 500, 34);
				contentPane.add(lblMsgCj);
				if (txtCj.getText().length() == 0) {// 获取成绩输入框的内容长度
					lblMsgCj.setText("成绩不能为空");// 设置警告信息
					txtCj.requestFocus();// 成绩输入框获取焦点
				} else if (!txtCj.getText().matches("\\d+")) {// 正则匹配整数
					lblMsgCj.setText("成绩必须是整数");
					txtCj.requestFocus();// 成绩输入框获取焦点
					txtCj.selectAll();// 全选当中的内容
				} else
					lblMsgCj.setText("");
			}
		});

		txtCj.setColumns(10);
		txtCj.setBounds(199, 237, 202, 39);
		contentPane.add(txtCj);

		JButton btnAdd = new JButton("\u589E\u52A0");
		btnAdd.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("c:\\Javatest\\stu.txt");
				try (FileWriter fw = new FileWriter(file, true)) {// 创建字符输出流
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
