package gui.entity.component;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Subject;
import domain.WrittenWorks;

@SuppressWarnings("serial")
public class TemplateWW extends AbstractTableModel {
	
	protected PanelComponentWW wwManagementFrame;
	private static List<WrittenWorks> currentValue;

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
		if(currentValue == null)
			return 0;
		
		return currentValue.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(currentValue == null)
			return null;
		
		WrittenWorks writtenWorks = currentValue.get(rowIndex);

		switch(columnIndex) {

		case 0:
			return writtenWorks.getwrittenWorks_title();

		case 1:
			return writtenWorks.getwrittenWorks_total();
		
		default:
			return null;
		
		}
	} 
	
	public void refresh() {
		currentValue = wwManagementFrame.wwRepository.getAll();
		fireTableDataChanged();
	}
	
	public void refreshWithSubject(Subject subject) {
		currentValue = wwManagementFrame.wwRepository.getByWWSubjectID(subject);
		fireTableDataChanged();
	}


}
