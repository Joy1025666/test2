package 增删查改;

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

		String[] titles = { "学号", "姓名", "成绩" };// 定义数组表示表格标题
		DefaultTableModel model = new DefaultTableModel(titles, 0);// 定义表格数据模型的表格标题和行数(为0行)
		table = new JTable(model) { // 实例化表格装载表格模型 //********************************//
			public boolean isCellEditable(int rowIndex, int columnIndex) { // 设置所有学号不可编辑,即第0列
				if (columnIndex == 0)
					return false;
				return true;
			}
		};

		File file = new File("c:\\Javatest\\student.txt");
		try (FileReader fr = new FileReader(file); // 实例化字符文件流
				BufferedReader br = new BufferedReader(fr);) {// 实例化缓冲流
			String row = null;
			while ((row = br.readLine()) != null) {// 按行读取数据
				model.addRow(row.split("\t"));// 将读取的行按分隔符拆分成字符串数组存入数据模型，关键代码
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("\u67E5\u627E\u5173\u952E\u5B57");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		lblNewLabel.setBounds(15, 75, 115, 32);
		contentPane.add(lblNewLabel);

		txtKey = new JTextField();
		txtKey.setBounds(145, 75, 129, 38);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		JButton btnFind = new JButton("\u67E5\u8BE2"); /*************** 查询 ******************/
		btnFind.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);// 设置表格模型排序器
				table.setRowSorter(sorter);// 设置表格排序器
				sorter.setRowFilter(RowFilter.regexFilter(txtKey.getText()));// 按指定的正则表达式过滤数据

			}
		});
		btnFind.setBounds(312, 75, 82, 34);
		contentPane.add(btnFind);

		JButton btnSort = new JButton("\u6309\u6570\u503C\u6392\u5E8F"); /*************** 按学号排序 ******************/
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);// 设置排序器
				table.setRowSorter(sorter);// 设置表格的排序器
				ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
				// 设置排序字段，下例为第1个字段升序
				sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
				sorter.setSortKeys(sortKeys);

			}
		});
		btnSort.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnSort.setBounds(433, 75, 159, 34);
		contentPane.add(btnSort);

		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
					if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？", "", JOptionPane.YES_NO_OPTION) == 0) {// 确定对话框
						model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
						// 从表格数据中删除行,model1为DefaultTableModel类型，排序后不能直接使用表格的getSelectedRow方法获取被选中的行
					} else {
						JOptionPane.showMessageDialog(null, "请选择要删除的行");
					}
				}
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
					for (int i = 0; i < model.getRowCount(); i++) {// 遍历表格数据，加入集合中
						String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"
								+ model.getValueAt(i, 2).toString() + "\t";// 获取表格中每一行的每一个单元格
						bw.write(row);// 向文本文件中增加数据
						bw.newLine();// 写入回车换行
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnDelete.setBounds(627, 75, 82, 34);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("\u66F4\u65B0");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnUpdate.setBounds(736, 73, 82, 34);
		contentPane.add(btnUpdate);
	}
}
