package 草稿;

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
		if (textcj.getText().length() == 0) {// 获取成绩输入框的内容长度
			lblcj.setText("成绩不能为空");// 设置警告信息
			textcj.requestFocus();// 成绩输入框获取焦点
			return false;
		} else if (!textcj.getText().matches("\\d+")) {// 正则匹配整数
			lblcj.setText("成绩必须是整数");
			textcj.requestFocus();// 成绩输入框获取焦点
			textcj.selectAll();// 全选当中的内容
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
		lblxm.setFont(new Font("微软雅黑", Font.BOLD, 30));
		lblxm.setBounds(129, 95, 81, 60);
		contentPane.add(lblxm);

		JLabel lblxh = new JLabel("\u5B66\u53F7");
		lblxh.setFont(new Font("微软雅黑", Font.BOLD, 30));
		lblxh.setBounds(129, 185, 81, 60);
		contentPane.add(lblxh);

		JLabel lblcj = new JLabel("\u6210\u7EE9");
		lblcj.setFont(new Font("微软雅黑", Font.BOLD, 30));
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
//		textcj.addKeyListener(new KeyAdapter() { //增加成绩输入框键盘事件
//			@Override
//			public void keyPressed(KeyEvent arg0) {// 监听键盘键入内容
//				if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {//如果是回车键
//					if (checkInputCj()) {
//						btnAdd.requestFocus();
//					}
//				}
//			}
//		});
//		textcj.addFocusListener(new FocusAdapter() {//给文本框增加焦点监听事件
//			@Override
//			public void focusLost(FocusEvent arg0) {// 监听文本框失去焦点
//				checkInputCj();
//			}
//		});
		textcj.setColumns(10);
		textcj.setBounds(239, 289, 348, 35);
		contentPane.add(textcj);

		JButton btnAdd = new JButton("\u589E\u52A0");
		btnAdd.addActionListener(new ActionListener() { //给按钮增加监听事件
			public void actionPerformed(ActionEvent arg0) {// 监听鼠标单击
				checkInputCj(); //进行输入数据检验
			}
		});
		btnAdd.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 25));
		btnAdd.setBounds(129, 380, 103, 47);
		contentPane.add(btnAdd);
	}
}
