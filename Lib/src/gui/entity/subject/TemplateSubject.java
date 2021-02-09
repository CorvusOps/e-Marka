package gui.entity.subject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Subject;

@SuppressWarnings("serial")
public class TemplateSubject extends AbstractTableModel {
	
	/**
	 * The link to the subject management frame that this TableModel is owned by.
	 * This is used to refer to the subject repository object in there.
	 */
	protected PanelSubjectManagement subjectManagementFrame;
	
	/**
	 * Cache of this TableModel. Refreshed only when refresh() is called.
	 */
	private static List<Subject> currentValue;
	
	/**
	 * Fixed column count of this TableModel, set to 3.
	 */
	@Override
	public int getColumnCount() {
		return 3;
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
			return "Description";
			
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
	 * Apparently, each row of the JTable should point to a Subject object in currentValue,
	 * and the column value is each field of Subject.
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(currentValue == null)
			return null;
		
		// Get the subject object at the specified row,
		// which coincidentally, is the same index in the currentValue List.
		Subject subject = currentValue.get(rowIndex);
		
		// Depending on what columnIndex is given,
		// return the proper field of the subject
		switch(columnIndex) {
		
		// First Column - Id
		case 0:
			return subject.getId();
			
		// Second Column - name
		case 1:
			return subject.getName();
			
		// Third Column - address
		case 2:
			return subject.getDescription();
		
		default:
			return null;
		
		}
	}
	
	/**
	 * Refreshes this TableModel with new data. Also prompts the JTable to redraw everything
	 * with fireTableDataChanged().
	 */
	public void refresh() {
		currentValue = subjectManagementFrame.subjectRepository.getAll();
		fireTableDataChanged();
	}

}
