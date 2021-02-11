package gui.entity.component;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TemplateWW extends AbstractTableModel {
	
	protected PanelComponentWW wwManagementFrame;
	//private static List<Grade> currentValue;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	/**
	 * Fetches the column names of this TableModel.
	 */
	
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		
		// First Column Header
		case 0:
			return "Title";
			
		// Second Column Header
		case 1:
			return "Total";
			
		default:
			return null;
		
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	public int getRowCount() {
		if(currentValue == null)
			return 0;
		
		return currentValue.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(currentValue == null)
			return null;
		
		// Get the student object at the specified row,
		// which coincidentally, is the same index in the currentValue List.
		Grade grade = currentValue.get(rowIndex);
		
		// Depending on what columnIndex is given,
		// return the proper field of the student
		switch(columnIndex) {
		
		// First Column - student number
		case 0:
			return student.getStudentNumber();
			
		// Second Column - name
		case 1:
			return student.getFirstName() + " " + student.getLastName();
			
		// Third Column - address
		case 2:
			return student.getAddress();
			
		// Fourth Column - section
		case 3:
			return student.getSection();
		
		default:
			return null;
		
		}
	}
	
	public void refresh() {
		currentValue = studentManagementFrame.studentRepository.getAll();
		fireTableDataChanged();
	}
	
	*/

}
