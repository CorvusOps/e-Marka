package gui.entity.student;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Student;

@SuppressWarnings("serial")
public class TemplateStudent extends AbstractTableModel {
	
	/**
	 * The link to the student management frame that this TableModel is owned by.
	 * This is used to refer to the student repository object in there.
	 */
	protected PanelStudentManagement studentManagementFrame;
	
	/**
	 * Cache of this TableModel. Refreshed only when refresh() is called.
	 */
	private static List<Student> currentValue;
	
	/**
	 * Fixed column count of this TableModel, set to 4.
	 */
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
			return "Student Number";
			
		// Second Column Header
		case 1:
			return "Name";
				
		// Third Column Header
		case 2:
			return "Address";
			
		// Fourth Column Header
		case 3:
			return "Section";
			
		default:
			return null;
		
		}
	}
	
	/**
	 * Depending on the current value of the internal cache,
	 * this returns its size.
	 */
	@Override
	public int getRowCount() {
		if(currentValue == null)
			return 0;
		
		return currentValue.size();
	}
	
	/**
	 * Gets the value at the specified row and column.
	 * Apparently, each row of the JTable should point to a Student object in currentValue,
	 * and the column value is each field of Student.
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(currentValue == null)
			return null;
		
		// Get the student object at the specified row,
		// which coincidentally, is the same index in the currentValue List.
		Student student = currentValue.get(rowIndex);
		
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
	
	/**
	 * Refreshes this TableModel with new data. Also prompts the JTable to redraw everything
	 * with fireTableDataChanged().
	 */
	public void refresh() {
		currentValue = studentManagementFrame.studentRepository.getAll();
		fireTableDataChanged();
	}


}
