package gui.entity.component;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.PerformanceTasks;
import domain.QuarterlyAssessment;
import domain.Subject;

@SuppressWarnings("serial")
public class TemplatePT extends AbstractTableModel {
	
	protected PanelComponentPT ptManagementFrame;
	private static List<PerformanceTasks> currentValue;
	

	@Override
	public int getColumnCount() {
		return 2;
	}
	
	/**
	 * Fetches the column names of this TableModel.
	 */
	@Override
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
		
		PerformanceTasks performanceTasks = currentValue.get(rowIndex);

		switch(columnIndex) {

		case 0:
			return performanceTasks.getPerformanceTasks_title();

		case 1:
			return performanceTasks.getPerformanceTasks_total();
		
		default:
			return null;
		
		}
	} 
	
	public void refresh() {
		currentValue = ptManagementFrame.ptRepository.getAll();
		fireTableDataChanged();
	}
	
	public void refreshWithSubject(Subject subject) {
		currentValue = ptManagementFrame.ptRepository.getByPTSubjectID(subject);
		fireTableDataChanged();
	}


}
