package components.addnewtestcase;

import core.ConstantValues;
import panels.addnewtestcase.*;
import sections.CreateNewTestCaseMenu;

import javax.swing.*;

public class ResetFieldsButton extends JButton {

    public ResetFieldsButton() {
        super("Reset Fields");

        // Action listener on click
        addActionListener(e -> showConfirmationPopup());
    }

    private void showConfirmationPopup() {
        int confirmationDialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel creating this test case?", "Warning", JOptionPane.YES_NO_OPTION);
        if (confirmationDialogResult == JOptionPane.YES_OPTION) {
            // Reset all fields to default values
            resetAllFieldsToDefaultValues();
        }
    }

    private void resetAllFieldsToDefaultValues() {

        // Reset Test Case Title Panel
        TestCaseTitlePanel.setTestCaseTitleTextField(ConstantValues.DEFAULT_VALUE_FOR_EMPTY_FIELD);

        // Reset Test Case Description Panel
        TestCaseDescriptionPanel.setTestCaseDescriptionTextField(ConstantValues.DEFAULT_VALUE_FOR_EMPTY_FIELD);

        // Reset Test Case Priority Panel
        TestCasePriorityPanel.setPriorityComboBox(ConstantValues.DEFAULT_VALUE_FOR_PRIORITY_COMBO_BOX);

        // Reset Test Case Type Panel
        TestCaseTypePanel.setTypeComboBox(ConstantValues.DEFAULT_VALUE_FOR_TYPE_COMBO_BOX);

        // Reset Add Step Panel
        CreateNewTestCaseMenu.getStepsTextFieldFromStepsContainerPanel().forEach(stepTextField ->
                stepTextField.setText(ConstantValues.DEFAULT_VALUE_FOR_EMPTY_FIELD)
        );

        // Reset Test Case Expected Result Panel
        TestCaseExpectedResultsPanel.setTestCaseExpectedResultsTextField(ConstantValues.DEFAULT_VALUE_FOR_EMPTY_FIELD);
    }
}
