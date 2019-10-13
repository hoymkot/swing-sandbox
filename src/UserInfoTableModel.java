

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class UserInfoTableModel implements TableModel{

	
	private List<UserInfo> userList;
	
	UserInfoTableModel(List<UserInfo> userList) {
		this.userList = userList;
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "ID";
		} else if (columnIndex == 1) {
			return "Name";
		} else if (columnIndex == 2) {
			return "Age";
		} else {
			return "Fault";
		}
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return userList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		UserInfo user = userList.get(rowIndex);
		if (columnIndex == 0) {
			return "" + user.getId();
		} else if (columnIndex == 1) {
			return user.getName();
		} else if (columnIndex == 2) {
			return user.getAge();
		} else {
			return "Fault";
		}
		
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex != 0) return true;
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String info = rowIndex + "--" + columnIndex + " value changed to" + aValue.toString();
		JOptionPane.showMessageDialog(null,info);
		
		UserInfo user = userList.get(rowIndex);
		if (columnIndex == 0) {
			user.setId(Integer.parseInt((String) aValue));
		} else if (columnIndex == 1) {
			user.setName((String) aValue);
		} else if (columnIndex == 2) {
			user.setAge(Integer.parseInt((String) aValue));
		} else {
		}
	}

	
	
}
