package components.managetestcases;

import components.OptiTextField;
import core.SqlBuilder;
import panels.addnewtestcase.*;
import sections.EditTestCaseMenu;

import javax.swing.*;
import java.util.List;

public class SaveChangesButton extends JButton {

    private int testCaseId;
    private List<OptiTextField> stepsTextFieldFromStepsContainerPanel;
    private List<String> stepsTextFieldFromStepsContainerPanelValues;

  public SaveChangesButton(int testCaseId) {
            super("Save Changes");
            this.testCaseId = testCaseId;
            addActionListener(e -> {
                stepsTextFieldFromStepsContainerPanel = EditTestCaseMenu.getStepsContainerPanel().getStepsTextFieldFromStepsContainerPanel();
                stepsTextFieldFromStepsContainerPanelValues =  stepsTextFieldFromStepsContainerPanel.stream()
                        .map(OptiTextField::getText)
                        .toList();
                saveChanges();
            });
        }

        private void saveChanges() {
            // Show confirmation dialog
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to save changes?", "Save Changes", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                SqlBuilder.updateTestCaseTitle(testCaseId, TestCaseTitlePanel.getTestCaseTitleTextField());
                SqlBuilder.updateTestCaseDescription(testCaseId, TestCaseDescriptionPanel.getTestCaseDescriptionTextField());
                SqlBuilder.updateTestCasePriority(testCaseId, TestCasePriorityPanel.getPriorityComboBox());
                SqlBuilder.updateTestCaseType(testCaseId, TestCaseTypePanel.getTypeComboBox());
                SqlBuilder.updateTestCaseSteps(testCaseId, stepsTextFieldFromStepsContainerPanelValues);
                SqlBuilder.updateTestCaseExpectedResult(testCaseId, TestCaseExpectedResultsPanel.getTestCaseExpectedResultsTextField());
            }
        }
}
