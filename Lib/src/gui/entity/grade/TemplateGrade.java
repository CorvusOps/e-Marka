package gui.entity.grade;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.PerformanceTasks;
import domain.QuarterlyAssessment;
import domain.Subject;
import domain.WrittenWorks;
import domain.Grade;

@SuppressWarnings("serial")
public class TemplateGrade extends AbstractTableModel {
	
	protected PanelGradeManagement gradeManagementFrame;
	private static List<Grade> currentValue;
	private List<WrittenWorks> writtenWorkList;
	private List<PerformanceTasks> performanceTaskList;
	private List<QuarterlyAssessment> quarterlyAssessmentList;


	@Override
	public int getColumnCount() {
		
		int finalSum = 0;
		finalSum += 2;
		
		if(writtenWorkList == null)
			finalSum += 0;
		else
			finalSum += writtenWorkList.size();
		
		if(performanceTaskList == null)
			finalSum += 0;
		else
			finalSum += performanceTaskList.size();
		
		if(quarterlyAssessmentList == null)
			finalSum += 0;
		else
			finalSum += quarterlyAssessmentList.size();
		
		return finalSum;
	}
	
	/**
	 * Fetches the column names of this TableModel.
	 */
	@Override
	public String getColumnName(int columnIndex) {
		
		if(columnIndex == 0)
			return "#";

		else if(columnIndex == 1)
			return "Name";

		else if(columnIndex >= 2 && columnIndex < (writtenWorkList.size() + 2))
			return writtenWorkList.get(columnIndex - 2).getwrittenWorks_title();
		
		else if(columnIndex >= writtenWorkList.size() + 2 && columnIndex < (writtenWorkList.size() + performanceTaskList.size() + 2))
			return performanceTaskList.get(columnIndex - (writtenWorkList.size() + 2)).getPerformanceTasks_title();
		
		else if(columnIndex >= writtenWorkList.size() + performanceTaskList.size() + 2 && columnIndex < (writtenWorkList.size() + performanceTaskList.size() + quarterlyAssessmentList.size() + 2))
			return quarterlyAssessmentList.get(columnIndex - (writtenWorkList.size() + performanceTaskList.size() + 2)).getquarterlyAssessment_title();
		
		else
			return null;

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
		
		Grade grade = currentValue.get(rowIndex);
		
		if(columnIndex == 0)
			return grade.getStudentNumber();

		else if(columnIndex == 1)
			return grade.getStudentName();

		else if(columnIndex >= 2 && columnIndex < (writtenWorkList.size() + 2))
			return grade.getGradeWW().get(columnIndex - 2).getGradesWW();
		
		else if(columnIndex >= writtenWorkList.size() + 2 && columnIndex < (writtenWorkList.size() + performanceTaskList.size() + 2))
			return grade.getGradePT().get(columnIndex - (writtenWorkList.size() + 2)).getGradesPT();
		
		else if(columnIndex >= writtenWorkList.size() + performanceTaskList.size() + 2 && columnIndex < (writtenWorkList.size() + performanceTaskList.size() + quarterlyAssessmentList.size() + 2))
			return grade.getGradeQA().get(columnIndex - (writtenWorkList.size() + performanceTaskList.size() + 2)).getGradesQA();
		
		else
			return null;

	}
	
	public void refreshWithSubject(Subject subject) {
		currentValue = gradeManagementFrame.gradeRepository.getAllBySubjectId(subject);
		writtenWorkList = gradeManagementFrame.wwRepository.getByWWSubjectID(subject);
		performanceTaskList = gradeManagementFrame.ptRepository.getByPTSubjectID(subject);
		quarterlyAssessmentList = gradeManagementFrame.qaRepository.getByQASubjectID(subject);
		fireTableStructureChanged();
		fireTableDataChanged();
	}



}
