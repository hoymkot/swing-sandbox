import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTable;

public class TestJTable {

	public static void main(String[] args) {

		JFrame jf= new JFrame("Form Test");
		jf.setSize(300,400);
		FlowLayout fl = new FlowLayout();
		jf.setLayout(fl);
		JTable table = new JTable();
		MyTableModelV1 tm = new MyTableModelV1();
		table.setModel(tm);
		jf.add(table);
		jf.setDefaultCloseOperation(3);
		jf.setVisible(true);

	}

}
