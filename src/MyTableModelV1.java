import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MyTableModelV1 implements TableModel {

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return "column"+columnIndex;
	}

	@Override
	public int getRowCount() {
		return 10;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return rowIndex+"--"+columnIndex;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex==0) return false;
		return true;

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String s = "change at: " + rowIndex+ "--- " + columnIndex + " newValue: " + aValue;
		System.out.println(s);
	}

}
