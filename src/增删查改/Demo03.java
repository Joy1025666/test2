package ��ɾ���;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Demo03 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtKey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo03 frame = new Demo03();
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
	public Demo03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 171, 685, 314);
		contentPane.add(scrollPane);

		String[] titles = { "ѧ��", "����", "�ɼ�" };// ���������ʾ������
		DefaultTableModel model = new DefaultTableModel(titles, 0);// ����������ģ�͵ı����������(Ϊ0��)
		table = new JTable(model) { // ʵ�������װ�ر��ģ�� //********************************//
			public boolean isCellEditable(int rowIndex, int columnIndex) { // ��������ѧ�Ų��ɱ༭,����0��
				if (columnIndex == 0)
					return false;
				return true;
			}
		};

		File file = new File("c:\\Javatest\\student.txt");
		try (FileReader fr = new FileReader(file); // ʵ�����ַ��ļ���
				BufferedReader br = new BufferedReader(fr);) {// ʵ����������
			String row = null;
			while ((row = br.readLine()) != null) {// ���ж�ȡ����
				model.addRow(row.split("\t"));// ����ȡ���а��ָ�����ֳ��ַ��������������ģ�ͣ��ؼ�����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("\u67E5\u627E\u5173\u952E\u5B57");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 22));
		lblNewLabel.setBounds(15, 75, 115, 32);
		contentPane.add(lblNewLabel);

		txtKey = new JTextField();
		txtKey.setBounds(145, 75, 129, 38);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		JButton btnFind = new JButton("\u67E5\u8BE2"); /*************** ��ѯ ******************/
		btnFind.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);// ���ñ��ģ��������
				table.setRowSorter(sorter);// ���ñ��������
				sorter.setRowFilter(RowFilter.regexFilter(txtKey.getText()));// ��ָ����������ʽ��������

			}
		});
		btnFind.setBounds(312, 75, 82, 34);
		contentPane.add(btnFind);

		JButton btnSort = new JButton("\u6309\u6570\u503C\u6392\u5E8F"); /*************** ��ѧ������ ******************/
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);// ����������
				table.setRowSorter(sorter);// ���ñ���������
				ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
				// ���������ֶΣ�����Ϊ��1���ֶ�����
				sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
				sorter.setSortKeys(sortKeys);

			}
		});
		btnSort.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		btnSort.setBounds(433, 75, 159, 34);
		contentPane.add(btnSort);

		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
					if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������", "", JOptionPane.YES_NO_OPTION) == 0) {// ȷ���Ի���
						model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
						// �ӱ��������ɾ����,model1ΪDefaultTableModel���ͣ��������ֱ��ʹ�ñ���getSelectedRow������ȡ��ѡ�е���
					} else {
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");
					}
				}
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
					for (int i = 0; i < model.getRowCount(); i++) {// ����������ݣ����뼯����
						String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"
								+ model.getValueAt(i, 2).toString() + "\t";// ��ȡ�����ÿһ�е�ÿһ����Ԫ��
						bw.write(row);// ���ı��ļ�����������
						bw.newLine();// д��س�����
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		btnDelete.setBounds(627, 75, 82, 34);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("\u66F4\u65B0");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		btnUpdate.setBounds(736, 73, 82, 34);
		contentPane.add(btnUpdate);
	}
}
