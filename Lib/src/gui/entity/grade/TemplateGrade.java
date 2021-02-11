package gui.entity.grade;

import javax.swing.table.AbstractTableModel;

//import domain.Grade;

@SuppressWarnings("serial")
public class TemplateGrade extends AbstractTableModel {
	
	protected PanelGradeManagement gradeManagementFrame;
	//private static List<Grade> currentValue;
	

	@Override
	public int getColumnCount() {
		return 4;
	}
	
	/**
	 * Fetches the column names of this TableModel.
	 */
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		
		// First Column Header
		case 0:
			return "#";
			
		// Second Column Header
		case 1:
			return "Name";
				
		// Third Column Header
		case 2:
			return "Sample Test # 1";
			
		// Fourth Column Header
		case 3:
			return "Sample Test # 2";
			
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
