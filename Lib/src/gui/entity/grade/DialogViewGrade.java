package gui.entity.grade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.Grade;
import domain.GradePT;
import domain.GradeQA;
import domain.GradeWW;
import domain.PerformanceTasks;
import domain.QuarterlyAssessment;
import domain.Subject;
import domain.WrittenWorks;

@SuppressWarnings("serial")
public class DialogViewGrade extends JDialog {

	/**
	 * The link to the student management frame that this Dialog is owned by. This
	 * is used to refer to the student repository object in there.
	 */
	protected PanelGradeManagement gradeManagementFrame;

	private JPanel jpnlViewGrade;
	
	private Map<Integer, JTextField> writtenWorkFields;
	private Map<Integer, JTextField> performanceTaskFields;
	private Map<Integer, JTextField> quarterlyAssessmentFields;
	
	private Grade boundGrade;

	/**
	 * Create the dialog.
	 */
	public DialogViewGrade() {
		/* This Dialog's Properties */
		setPreferredSize(new Dimension(580, 530));
		setMinimumSize(new Dimension(580, 530));
		setTitle("VIEW AND UPDATE GRADE");
		setBounds(100, 100, 470, 300);
		getContentPane().setLayout(new BorderLayout());
		/* END OF jtxtfldSection */

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		jpnlViewGrade = new JPanel();
		jpnlViewGrade.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollPane.setViewportView(jpnlViewGrade);
		GridBagLayout gbl_jpnlViewGrade = new GridBagLayout();
		gbl_jpnlViewGrade.columnWidths = new int[] { 0, 0 };
		gbl_jpnlViewGrade.rowHeights = new int[] { 0, 0 };
		gbl_jpnlViewGrade.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_jpnlViewGrade.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		jpnlViewGrade.setLayout(gbl_jpnlViewGrade);

		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(jpnlButtons, BorderLayout.SOUTH);
		/* END OF jpnlButtons */

		/* jbtnOk - save student button */
		JButton jbtnSave = new JButton("SAVE");
		jbtnSave.setActionCommand("SAVE");
		jpnlButtons.add(jbtnSave);
		// When this button is clicked, execute actionPerformed
		jbtnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Subject subject = (Subject) gradeManagementFrame.cmbSubject.getSelectedItem();
				
				List<GradeWW> updatedGradeWW = new ArrayList<>();
				Set<Integer> writtenWorkIds = writtenWorkFields.keySet();
				for(Integer writtenWorkId : writtenWorkIds)
					updatedGradeWW.add(new GradeWW(0, 0, writtenWorkId, Integer.parseInt(writtenWorkFields.get(writtenWorkId).getText())));
				boundGrade.setGradeWW(updatedGradeWW);
				
				List<GradePT> updatedGradePT = new ArrayList<>();
				Set<Integer> performanceTaskIds = performanceTaskFields.keySet();
				for(Integer performanceTaskId : performanceTaskIds)
					updatedGradePT.add(new GradePT(0, 0, performanceTaskId, Integer.parseInt(performanceTaskFields.get(performanceTaskId).getText())));
				boundGrade.setGradePT(updatedGradePT);
				
				List<GradeQA> updatedGradeQA = new ArrayList<>();
				Set<Integer> quarterlyAssessmentIds = quarterlyAssessmentFields.keySet();
				for(Integer quarterlyAssessmentId : quarterlyAssessmentIds)
					updatedGradeQA.add(new GradeQA(0, 0, quarterlyAssessmentId, Integer.parseInt(quarterlyAssessmentFields.get(quarterlyAssessmentId).getText())));
				boundGrade.setGradeQA(updatedGradeQA);
			
				gradeManagementFrame.gradeRepository.update(boundGrade);
				
				JOptionPane.showMessageDialog(null, "Successfully updated grade");
				setVisible(false);
				gradeManagementFrame.gradeTableModel.refreshWithSubject(subject);
			}
		});
		getRootPane().setDefaultButton(jbtnSave);
		/* END OF jbtnOk */

		/* jbtnCancel - hides this dialog box */
		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jpnlViewGrade.removeAll();
				setVisible(false);
			}
		});
		jpnlButtons.add(jbtnCancel);
		/* END OF jbtnCancel */
	}

	public void initialize(Grade grade, String studentName) {
		this.boundGrade = grade;
		
		jpnlViewGrade.removeAll();

		JLabel lblFirstName = new JLabel("Name: " + studentName);
		lblFirstName.setFont(new Font("Segoe UI", Font.BOLD, 15));
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 0;
		gbc_lblFirstName.insets = new Insets(10, 0, 0, 0);
		jpnlViewGrade.add(lblFirstName, gbc_lblFirstName);
		/* END OF lblFirstName */
		
		JLabel lblSubject = new JLabel("Grades in " + gradeManagementFrame.cmbSubject.getSelectedItem());
		lblSubject.setFont(new Font("Segoe UI", Font.BOLD, 15));
		GridBagConstraints gbc_lblSubject = new GridBagConstraints();
		gbc_lblSubject.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSubject.gridx = 0;
		gbc_lblSubject.gridy = 1;
		gbc_lblSubject.insets = new Insets(10, 0, 0, 0);
		jpnlViewGrade.add(lblSubject, gbc_lblSubject);
		/* END OF lblFirstName */

		/**
		 * Retrieve all the components by Grade ? or erm idk xD Give jlabels and
		 * jtextfields depends on the ave and remark Instantiate alot of object
		 * 
		 * 
		 * List<Integer> ids = new ArrayList<>(); for(GradeWW gradeWw :
		 * grade.getGradeWW()) ids.add(gradeWw.getWrittenWorks_id());
		 */

		/*
		 * 1. Get the grade object 2. Iterate over each written work grade, then
		 * calculate its percentage - Example, one grade for a component has GRADE: 25
		 * TOTAL: 30 - Another: GRADE: 30 TOTAL: 35
		 * 
		 * Calculate the total of grades, and total of component totals GRADE TOTAL: 55
		 * COMPONENT TOTAL: 65 PERCENTAGE: 84.615384 FINAL (WITH WEIGHT 30%): 25.38461%
		 * 
		 * 3. Iterate over each perf task, then calculate its percentage 4. Iterate over
		 * each quarterly assessment, then calculate its percentage
		 */

		// computation

		List<WrittenWorks> writtenWorks = gradeManagementFrame.wwRepository.getAll(
				grade.getGradeWW().stream().map(gradeWW -> gradeWW.getWrittenWorks_id()).collect(Collectors.toList()));
		Map<Integer, WrittenWorks> writtenWorkMap = new HashMap<>();
		for (WrittenWorks writtenWork : writtenWorks)
			writtenWorkMap.put(writtenWork.getwrittenWorks_id(), writtenWork);
		int writtenWorkTotalGrade = 0, writtenWorkComponentsTotal = 0;
		for (GradeWW gradeWW : grade.getGradeWW()) {
			writtenWorkTotalGrade += gradeWW.getGradesWW();
			writtenWorkComponentsTotal += writtenWorkMap.get(gradeWW.getWrittenWorks_id()).getwrittenWorks_total();
		}

		double writtenWorkWeightedGrade = (((double) writtenWorkTotalGrade / writtenWorkComponentsTotal) * 50 + 50) * .30;

		// UI stuff
		JLabel jlblWrittenWorkHeader = new JLabel("WRITTEN WORKS");
		jlblWrittenWorkHeader.setFont(new Font("Segoe UI", Font.BOLD, 16));
		jlblWrittenWorkHeader.setForeground(Color.BLUE);
		GridBagConstraints gbc_jlblWrittenWorkHeader = new GridBagConstraints();
		gbc_jlblWrittenWorkHeader.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblWrittenWorkHeader.gridx = 0;
		gbc_jlblWrittenWorkHeader.gridy = 2;
		gbc_jlblWrittenWorkHeader.insets = new Insets(10, 0, 0, 0);
		gbc_jlblWrittenWorkHeader.gridwidth  = 3;
		jpnlViewGrade.add(jlblWrittenWorkHeader, gbc_jlblWrittenWorkHeader);
		
		JLabel jlblTotalHeader = new JLabel("Total");
		jlblTotalHeader.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		GridBagConstraints gbc_jlblTotalHeader = new GridBagConstraints();
		gbc_jlblTotalHeader.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblTotalHeader.gridx = 2;
		gbc_jlblTotalHeader.gridy = 2;
		gbc_jlblTotalHeader.insets = new Insets(10, 0, 0, 0);
		jpnlViewGrade.add(jlblTotalHeader, gbc_jlblTotalHeader);

		int currentRow = 3;
		Map<Integer, GradeWW> gradeWWMap = new HashMap<>();
		for (GradeWW gradeWW : grade.getGradeWW())
			gradeWWMap.put(gradeWW.getWrittenWorks_id(), gradeWW);

		writtenWorkFields = new HashMap<>();
		for (WrittenWorks writtenWork : writtenWorks) {
			JLabel jlblWrittenWork = new JLabel(writtenWork.getwrittenWorks_title());
			jlblWrittenWork.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_jlblWrittenWork = new GridBagConstraints();
			gbc_jlblWrittenWork.fill = GridBagConstraints.HORIZONTAL;
			gbc_jlblWrittenWork.gridx = 0;
			gbc_jlblWrittenWork.gridy = currentRow;
			gbc_jlblWrittenWork.insets = new Insets(10, 0, 0, 0);
			jpnlViewGrade.add(jlblWrittenWork, gbc_jlblWrittenWork);

			JTextField jtxtWrittenWorkGrade = new JTextField(
					"" + gradeWWMap.get(writtenWork.getwrittenWorks_id()).getGradesWW(), 10);
			jtxtWrittenWorkGrade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_jtxtWrittenWorkGrade = new GridBagConstraints();
			gbc_jtxtWrittenWorkGrade.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtWrittenWorkGrade.gridx = 1;
			gbc_jtxtWrittenWorkGrade.gridy = currentRow;
			gbc_jtxtWrittenWorkGrade.insets = new Insets(10, 10, 0, 10);
			
			JLabel jlblWrittenWorkTotal = new JLabel("/ " + writtenWork.getwrittenWorks_total());
			GridBagConstraints gbc_jlblWrittenWorkTotal = new GridBagConstraints();
			jlblWrittenWorkTotal.setFont(new Font("Segoe UI", Font.BOLD, 15));
			gbc_jlblWrittenWorkTotal.fill = GridBagConstraints.HORIZONTAL;
			gbc_jlblWrittenWorkTotal.gridx = 2;
			gbc_jlblWrittenWorkTotal.gridy = currentRow;
			gbc_jlblWrittenWorkTotal.insets = new Insets(10, 10, 0, 10);
			
			jpnlViewGrade.add(jtxtWrittenWorkGrade, gbc_jtxtWrittenWorkGrade);
			writtenWorkFields.put(writtenWork.getwrittenWorks_id(), jtxtWrittenWorkGrade);
			jpnlViewGrade.add(jlblWrittenWorkTotal, gbc_jlblWrittenWorkTotal);

			currentRow++;
		}

		// computation
		List<PerformanceTasks> performanceTasks = gradeManagementFrame.ptRepository.getAll(
				grade.getGradePT().stream().map(gradePT -> gradePT.getPerformanceTasks_id()).collect(Collectors.toList()));
		Map<Integer, PerformanceTasks> performanceTaskMap = new HashMap<>();
		for (PerformanceTasks performanceTask : performanceTasks)
			performanceTaskMap.put(performanceTask.getPerformanceTasks_id(), performanceTask);
		int performanceTaskTotalGrade = 0, performanceTaskComponentsTotal = 0;
		for (GradePT gradePT : grade.getGradePT()) {
			performanceTaskTotalGrade += gradePT.getGradesPT();
			performanceTaskComponentsTotal += performanceTaskMap.get(gradePT.getPerformanceTasks_id()).getPerformanceTasks_total();
		}
		double performanceTaskWeightedGrade = (((double) performanceTaskTotalGrade / performanceTaskComponentsTotal) * 50 + 50) * 0.50;

		// UI Stuff
		JLabel jlblPerformanceTaskHeader = new JLabel("PERFORMANCE TASKS");
		jlblPerformanceTaskHeader.setFont(new Font("Segoe UI", Font.BOLD, 16));
		jlblPerformanceTaskHeader.setForeground(Color.BLUE);
		GridBagConstraints gbc_jlblPerformanceTaskHeader = new GridBagConstraints();
		gbc_jlblPerformanceTaskHeader.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblPerformanceTaskHeader.gridx = 0;
		gbc_jlblPerformanceTaskHeader.gridy = currentRow;
		gbc_jlblPerformanceTaskHeader.insets = new Insets(10, 0, 0, 0);
		jpnlViewGrade.add(jlblPerformanceTaskHeader, gbc_jlblPerformanceTaskHeader);

		currentRow++;
		Map<Integer, GradePT> gradePTMap = new HashMap<>();
		for (GradePT gradePT : grade.getGradePT())
			gradePTMap.put(gradePT.getPerformanceTasks_id(), gradePT);

		performanceTaskFields = new HashMap<>();
		for (PerformanceTasks performanceTask : performanceTasks) {
			JLabel jlblPerformanceTasks = new JLabel(performanceTask.getPerformanceTasks_title());
			jlblPerformanceTasks.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_jlblPerformanceTask = new GridBagConstraints();
			gbc_jlblPerformanceTask.fill = GridBagConstraints.HORIZONTAL;
			gbc_jlblPerformanceTask.gridx = 0;
			gbc_jlblPerformanceTask.gridy = currentRow;
			gbc_jlblPerformanceTask.insets = new Insets(10, 0, 0, 0);
			jpnlViewGrade.add(jlblPerformanceTasks, gbc_jlblPerformanceTask);

			JTextField jtxtPerformanceTaskGrade = new JTextField(
					"" + gradePTMap.get(performanceTask.getPerformanceTasks_id()).getGradesPT(), 10);
			jtxtPerformanceTaskGrade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_jtxtPerformanceTaskGrade = new GridBagConstraints();
			gbc_jtxtPerformanceTaskGrade.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtPerformanceTaskGrade.gridx = 1;
			gbc_jtxtPerformanceTaskGrade.gridy = currentRow;
			gbc_jtxtPerformanceTaskGrade.insets = new Insets(10, 10, 0, 10);
			
			JLabel jlblPerformanceTasksTotal = new JLabel("/ " + performanceTask.getPerformanceTasks_total());
			jlblPerformanceTasksTotal.setFont(new Font("Segoe UI", Font.BOLD, 15));
			GridBagConstraints gbc_jlblPerformanceTasksTotal = new GridBagConstraints();
			gbc_jlblPerformanceTasksTotal.fill = GridBagConstraints.HORIZONTAL;
			gbc_jlblPerformanceTasksTotal.gridx = 2;
			gbc_jlblPerformanceTasksTotal.gridy = currentRow;
			gbc_jlblPerformanceTasksTotal.insets = new Insets(10, 10, 0, 10);
			
			jpnlViewGrade.add(jtxtPerformanceTaskGrade, gbc_jtxtPerformanceTaskGrade);
			performanceTaskFields.put(performanceTask.getPerformanceTasks_id(), jtxtPerformanceTaskGrade);
			jpnlViewGrade.add(jlblPerformanceTasksTotal, gbc_jlblPerformanceTasksTotal);

			currentRow++;
		}

		// computation
		List<QuarterlyAssessment> quarterlyAssessment = gradeManagementFrame.qaRepository.getAll(grade.getGradeQA()
				.stream().map(gradeQA -> gradeQA.getQuarterlyAssessment_id()).collect(Collectors.toList()));
		Map<Integer, QuarterlyAssessment> quarterlyAssessmentMap = new HashMap<>();
		for (QuarterlyAssessment quarterlyAssessments : quarterlyAssessment)
			quarterlyAssessmentMap.put(quarterlyAssessments.getquarterlyAssessment_id(), quarterlyAssessments);
		int quarterlyAssessmentTotalGrade = 0, quarterlyAssessmentComponentsTotal = 0;
		for (GradeQA gradeQA : grade.getGradeQA()) {
			quarterlyAssessmentTotalGrade += gradeQA.getGradesQA();
			quarterlyAssessmentComponentsTotal += quarterlyAssessmentMap.get(gradeQA.getQuarterlyAssessment_id())
					.getquarterlyAssessment_total();
		}
		double quarterlyAssessmentWeightedGrade = (((double) quarterlyAssessmentTotalGrade
				/ quarterlyAssessmentComponentsTotal) * 50 + 50) * 0.20;

		// UI Stuff
		JLabel jlblQuarterlyAssessmentHeader = new JLabel("QUARTERLY ASSESSMENT");
		jlblQuarterlyAssessmentHeader.setFont(new Font("Segoe UI", Font.BOLD, 16));
		jlblQuarterlyAssessmentHeader.setForeground(Color.BLUE);
		GridBagConstraints gbc_jlblQuarterlyAssessmentHeader = new GridBagConstraints();
		gbc_jlblQuarterlyAssessmentHeader.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblQuarterlyAssessmentHeader.gridx = 0;
		gbc_jlblQuarterlyAssessmentHeader.gridy = currentRow;
		gbc_jlblQuarterlyAssessmentHeader.insets = new Insets(10, 0, 0, 0);
		jpnlViewGrade.add(jlblQuarterlyAssessmentHeader, gbc_jlblQuarterlyAssessmentHeader);

		currentRow++;
		Map<Integer, GradeQA> gradeQAMap = new HashMap<>();
		for (GradeQA gradeQA : grade.getGradeQA())
			gradeQAMap.put(gradeQA.getQuarterlyAssessment_id(), gradeQA);

		quarterlyAssessmentFields = new HashMap<>();
		for (QuarterlyAssessment quarterlyAssessments : quarterlyAssessment) {
			JLabel jlblQuarterlyAssessment = new JLabel(quarterlyAssessments.getquarterlyAssessment_title());
			jlblQuarterlyAssessment.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_jlblQuarterlyAssessment = new GridBagConstraints();
			gbc_jlblQuarterlyAssessment.fill = GridBagConstraints.HORIZONTAL;
			gbc_jlblQuarterlyAssessment.gridx = 0;
			gbc_jlblQuarterlyAssessment.gridy = currentRow;
			gbc_jlblQuarterlyAssessment.insets = new Insets(10, 0, 0, 0);
			jpnlViewGrade.add(jlblQuarterlyAssessment, gbc_jlblQuarterlyAssessment);

			JTextField jtxtQuarterlyAssessmentGrade = new JTextField(
					"" + gradeQAMap.get(quarterlyAssessments.getquarterlyAssessment_id()).getGradesQA(), 10);
			jtxtQuarterlyAssessmentGrade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_jtxtQuarterlyAssessmentGrade = new GridBagConstraints();
			gbc_jtxtQuarterlyAssessmentGrade.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtQuarterlyAssessmentGrade.gridx = 1;
			gbc_jtxtQuarterlyAssessmentGrade.gridy = currentRow;
			gbc_jtxtQuarterlyAssessmentGrade.insets = new Insets(10, 10, 0, 10);
			
			JLabel jlblQuarterlyAssessmentTotal = new JLabel("/ " + quarterlyAssessments.getquarterlyAssessment_total());
			jlblQuarterlyAssessmentTotal.setFont(new Font("Segoe UI", Font.BOLD, 15));
			GridBagConstraints gbc_jlblQuarterlyAssessmentTotal = new GridBagConstraints();
			gbc_jlblQuarterlyAssessmentTotal.fill = GridBagConstraints.HORIZONTAL;
			gbc_jlblQuarterlyAssessmentTotal.gridx = 2;
			gbc_jlblQuarterlyAssessmentTotal.gridy = currentRow;
			gbc_jlblQuarterlyAssessmentTotal.insets = new Insets(10, 10, 0, 10);
			
			jpnlViewGrade.add(jtxtQuarterlyAssessmentGrade, gbc_jtxtQuarterlyAssessmentGrade);
			quarterlyAssessmentFields.put(quarterlyAssessments.getquarterlyAssessment_id(), jtxtQuarterlyAssessmentGrade);
			jpnlViewGrade.add(jlblQuarterlyAssessmentTotal, gbc_jlblQuarterlyAssessmentTotal);

			currentRow++;
		}

		// Final Grade
		double FinalGrade = writtenWorkWeightedGrade + performanceTaskWeightedGrade + quarterlyAssessmentWeightedGrade;

		JLabel jlblWeightedGrade = new JLabel("Weighted Grade per Component ");
		jlblWeightedGrade.setFont(new Font("Segoe UI", Font.BOLD, 16));
		jlblWeightedGrade.setForeground(Color.RED);
		GridBagConstraints gbc_jlblWeightedGrade = new GridBagConstraints();
		gbc_jlblWeightedGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblWeightedGrade.gridx = 0;
		gbc_jlblWeightedGrade.gridy = currentRow;
		gbc_jlblWeightedGrade.insets = new Insets(10, 0, 0, 0);
		jpnlViewGrade.add(jlblWeightedGrade, gbc_jlblWeightedGrade);

		currentRow++;

		JLabel jlblWrittenWorkWeightedGrade = new JLabel("Written Work Weighted Score (30%) ");
		jlblWrittenWorkWeightedGrade.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		GridBagConstraints gbc_jlblWrittenWorkWeightedGrade = new GridBagConstraints();
		gbc_jlblWrittenWorkWeightedGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblWrittenWorkWeightedGrade.gridx = 0;
		gbc_jlblWrittenWorkWeightedGrade.gridy = currentRow;
		gbc_jlblWrittenWorkWeightedGrade.insets = new Insets(10, 0, 0, 0);
		jpnlViewGrade.add(jlblWrittenWorkWeightedGrade, gbc_jlblWrittenWorkWeightedGrade);

		JTextField jtxtWrittenWorkWeightedGrade = new JTextField(" " + String.format("%.2f", writtenWorkWeightedGrade), 10);
		jtxtWrittenWorkWeightedGrade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtWrittenWorkWeightedGrade.setEditable(false);
		GridBagConstraints gbc_jtxtWrittenWorkWeightedGrade = new GridBagConstraints();
		gbc_jtxtWrittenWorkWeightedGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtWrittenWorkWeightedGrade.gridx = 1;
		gbc_jtxtWrittenWorkWeightedGrade.gridy = currentRow;
		gbc_jtxtWrittenWorkWeightedGrade.insets = new Insets(10, 10, 0, 10);
		jpnlViewGrade.add(jtxtWrittenWorkWeightedGrade, gbc_jtxtWrittenWorkWeightedGrade);
		// writtenWorkFields.put(quarterlyAssessments.getquarterlyAssessment_id(),
		// jtxtQuarterlyAssessmentGrade);

		currentRow++;

		JLabel jlblPerformanceTaskGrade = new JLabel("Performance Task Weighted Score (50%) ");
		jlblPerformanceTaskGrade.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		GridBagConstraints gbc_jlblPerformanceTaskGrade = new GridBagConstraints();
		gbc_jlblPerformanceTaskGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblPerformanceTaskGrade.gridx = 0;
		gbc_jlblPerformanceTaskGrade.gridy = currentRow;
		gbc_jlblPerformanceTaskGrade.insets = new Insets(10, 0, 0, 0);
		jpnlViewGrade.add(jlblPerformanceTaskGrade, gbc_jlblPerformanceTaskGrade);

		JTextField jtxtPerformanceTaskGrade = new JTextField("" + String.format("%.2f", performanceTaskWeightedGrade), 10);
		jtxtPerformanceTaskGrade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtPerformanceTaskGrade.setEditable(false);
		GridBagConstraints gbc_jtxtPerformanceTaskGrade = new GridBagConstraints();
		gbc_jtxtPerformanceTaskGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtPerformanceTaskGrade.gridx = 1;
		gbc_jtxtPerformanceTaskGrade.gridy = currentRow;
		gbc_jtxtPerformanceTaskGrade.insets = new Insets(10, 10, 0, 10);
		jpnlViewGrade.add(jtxtPerformanceTaskGrade, gbc_jtxtPerformanceTaskGrade);

		currentRow++;

		JLabel jlblQuarterlyAssessmentGrade = new JLabel("Quarterly Assessment Weighted Score (20%) ");
		jlblQuarterlyAssessmentGrade.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		GridBagConstraints gbc_jlblQuarterlyAssessmentGrade = new GridBagConstraints();
		gbc_jlblQuarterlyAssessmentGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblQuarterlyAssessmentGrade.gridx = 0;
		gbc_jlblQuarterlyAssessmentGrade.gridy = currentRow;
		gbc_jlblQuarterlyAssessmentGrade.insets = new Insets(10, 0, 0, 0);
		jpnlViewGrade.add(jlblQuarterlyAssessmentGrade, gbc_jlblQuarterlyAssessmentGrade);

		JTextField jtxtQuarterlyAssessmentGrade = new JTextField("" + String.format("%.2f", quarterlyAssessmentWeightedGrade), 10);
		jtxtQuarterlyAssessmentGrade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtQuarterlyAssessmentGrade.setEditable(false);
		GridBagConstraints gbc_jtxtQuarterlyAssessmentGrade = new GridBagConstraints();
		gbc_jtxtQuarterlyAssessmentGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtQuarterlyAssessmentGrade.gridx = 1;
		gbc_jtxtQuarterlyAssessmentGrade.gridy = currentRow;
		gbc_jtxtQuarterlyAssessmentGrade.insets = new Insets(10, 10, 0, 10);
		jpnlViewGrade.add(jtxtQuarterlyAssessmentGrade, gbc_jtxtQuarterlyAssessmentGrade);

		currentRow++;

		JLabel jlblFinalGrade = new JLabel("SUBJECT FINAL GRADE");
		jlblFinalGrade.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_jlblFinalGrade = new GridBagConstraints();
		gbc_jlblFinalGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblFinalGrade.gridx = 0;
		gbc_jlblFinalGrade.gridy = currentRow;
		gbc_jlblFinalGrade.insets = new Insets(10, 0, 0, 0);
		jpnlViewGrade.add(jlblFinalGrade, gbc_jlblFinalGrade);

		JTextField jtxtFinalGrade = new JTextField("" + String.format("%.2f", FinalGrade), 10);
		jtxtFinalGrade.setFont(new Font("Segoe UI", Font.BOLD, 17));
		jtxtFinalGrade.setEditable(false);
		GridBagConstraints gbc_jtxtFinalGrade = new GridBagConstraints();
		gbc_jtxtFinalGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtFinalGrade.gridx = 1;
		gbc_jtxtFinalGrade.gridy = currentRow;
		gbc_jtxtFinalGrade.insets = new Insets(10, 10, 0, 10);
		jpnlViewGrade.add(jtxtFinalGrade, gbc_jtxtFinalGrade);

		currentRow++;

		final String Remark = FinalGrade >= 75.0 ? "PASSED" : "FAILED";
		
		JLabel jlblRemark = new JLabel("Remarks");
		jlblRemark.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 16));		
		jtxtFinalGrade.setFont(new Font("Segoe UI", Font.BOLD, 17));
		jtxtFinalGrade.setEditable(false);
		GridBagConstraints gbc_jlblRemark = new GridBagConstraints();
		gbc_jlblRemark.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblRemark.gridx = 0;
		gbc_jlblRemark.gridy = currentRow;
		gbc_jlblRemark.insets = new Insets(10, 0, 0, 0);
		jpnlViewGrade.add(jlblRemark, gbc_jlblRemark);

		JTextField jtxtRemark = new JTextField(Remark);
		jtxtRemark.setFont(new Font("Segoe UI", Font.BOLD, 17));
		jtxtRemark.setEditable(false);
		
		if(FinalGrade >= 75.0)
			jtxtRemark.setForeground(Color.BLUE);
		else
			jtxtRemark.setForeground(Color.RED);
		
		GridBagConstraints gbc_jtxtRemark = new GridBagConstraints();
		gbc_jtxtRemark.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtRemark.gridx = 1;
		gbc_jtxtRemark.gridy = currentRow;
		gbc_jtxtRemark.insets = new Insets(10, 10, 0, 10);
		jpnlViewGrade.add(jtxtRemark, gbc_jtxtRemark);

		// how to call this collectors/ lists stuff to be computed ?
		// is it like while(quarterlyAssessmentIds.next()) eme eme

		revalidate();
	}

	/**
	 * Initialize a method accept a grade object OK: step 1: retrieve the grade of
	 * student from crudgrade by studentNumber OK: step 2: retrieve components step
	 * 3: loop the component objects / make jlabel = title and jtext field = actual
	 * grade step 4: set text / jtextfield at current grade at the component step 6:
	 * revalidated hierarchy
	 * 
	 * 
	 */

}
