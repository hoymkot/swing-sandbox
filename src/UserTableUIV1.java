import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class UserTableUIV1 {

	public static void main(String[] args) {

		UserTableUIV1 lu = new UserTableUIV1();
		lu.setupUI();
		

	}

	private void setupUI() {
JFrame jf= new JFrame("JTable-TableModelSample");
		
		jf.setSize(300,200);
		FlowLayout fl = new FlowLayout();
		jf.setLayout(fl);
		JTable table = new JTable();
		List<UserInfo> users = getUserList();
		UserInfoTableModel tm = new UserInfoTableModel(users);
		table.setModel(tm);
		
		for (int i = 0; i< table.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(40);
		}
		table.setRowHeight(20);
		
		JScrollPane sp = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(200,70));
		sp.setAutoscrolls(true);
		table.addColumn(new TableColumn(3));
		JComboBox c = new JComboBox();
		c.addItem("Hunan");
		c.addItem("Changsa");
		c.addItem("zhuhai");
		c.setSelectedIndex(0);
		table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(c));
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				int c = table.getSelectedColumn();
				Object value = table.getValueAt(r, c);
				String info = r + " row " + c + " column value: " + value.toString();
				JOptionPane.showMessageDialog(null, info);
			}
		})
		;
		
		jf.add(sp);
		jf.setDefaultCloseOperation(3);
		jf.setVisible(true);
		
	}
	

	private List<UserInfo> getUserList() {
		List<UserInfo> users = new ArrayList<UserInfo>();
		for (int i = 0 ; i< 100;i++) {
			UserInfo user = new UserInfo();
			user.setId(i+1);
			user.setAge(20+i);
			user.setName("User " + i);
			users.add(user);
		}
		return users;
	}

}
