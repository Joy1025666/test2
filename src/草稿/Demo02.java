package �ݸ�;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Demo02 extends JFrame {

	private JPanel contentPane;
	private JTextField txtKey;
	private JTable table;
	private JButton btnFind_1;
	private JButton btnFind_2;
	private JButton btnFind_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo02 frame = new Demo02();
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
	public Demo02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtKey = new JTextField();
		txtKey.setBounds(151, 65, 221, 33);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		JButton btnFind = new JButton("\u67E5\u8BE2");
		btnFind.setBounds(387, 67, 103, 28);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableModel model=table.getModel();
				System.out.println(model.getValueAt(0, 1));
			}
		});
		contentPane.add(btnFind);

		JLabel label = new JLabel("\u67E5\u8BE2\u5173\u952E\u5B57");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 22));
		label.setBounds(32, 67, 118, 24);
		contentPane.add(label);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(32, 160, 870, 234);
		contentPane.add(scrollPane);

		JFrame frame = new JFrame("���ʵ��"); // ʵ�����������
//		table.setAutoCreateRowSorter(true); //����
		String[] titles = { "ѧ��", "����", "�ɼ�"};// ���������ʾ������
		DefaultTableModel model=new DefaultTableModel(titles, 0);//����������ģ�͵ı����������(Ϊ0��)
		model.addRow(new Object[] {"1", "����", 89});//���ģ����������
		model.addRow(new Object[]{"2", "����", 99});	
//		table.isCellEditable(0,1);
//		File file=new File("c:\\Javatest\\student.txt");
//		try(BufferedReader br=new BufferedReader(new FileReader(file))){
//			String row=null;
//			while((row=br.readLine())!=null) {
//				model.addRow(row.split("\t"));
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		table = new JTable(model); //ʵ�������װ�ر��ģ��
//		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//���ñ��ģ��������
//		table.setRowSorter(sorter);//���ñ��������
////		sorter.setRowFilter(null);//�����ù�����������ʾȫ������
//		sorter.setRowFilter(RowFilter.regexFilter("��"));//��ָ����������ʽ��������
	
		
		scrollPane.setViewportView(table);
		
		
		btnFind_1 = new JButton("\u6309\u6570\u503C\u6392\u5E8F");
		btnFind_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFind_1.setBounds(510, 67, 135, 28);
		contentPane.add(btnFind_1);
		
		btnFind_2 = new JButton("\u5220\u9664");
		btnFind_2.setBounds(665, 67, 103, 28);
		contentPane.add(btnFind_2);
		
		btnFind_3 = new JButton("\u66F4\u65B0");
		btnFind_3.setBounds(799, 67, 103, 28);
		contentPane.add(btnFind_3);
	}
}
