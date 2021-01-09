package 草稿;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.ImageIcon;

public class Demo03 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo03 window = new Demo03();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Demo03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("成绩管理系统");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Demo03.class.getResource("/image/72.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("学生成绩管理（s）");
		mnNewMenu.setMnemonic('s');
		menuBar.add(mnNewMenu);
		
		JSeparator separator = new JSeparator();
		menuBar.add(separator);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon(Demo03.class.getResource("/image/g1.png")));
		toolBar.add(btnNewButton);
	}

}
