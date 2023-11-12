package components.addnewtestcase;

import components.OptiTextField;
import panels.addnewtestcase.*;
import sections.CreateNewTestCaseMenu;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveTestCaseButton extends JButton {

    private final HashMap<String, String> testCaseDetails = new HashMap<>();

    public SaveTestCaseButton(String saveTestCaseButtonText) {
        super(saveTestCaseButtonText);

        addActionListener(e -> {
            fillTestCaseDetails();
            List<String> listOfNotFieldWithDefaultValues = getNotFilledFieldsList();
            if (listOfNotFieldWithDefaultValues.isEmpty()) {
                int confirmationDialogResult = showConfirmationDialog();
                if (confirmationDialogResult == JOptionPane.YES_OPTION) {
                    printTestCaseDetails();
                }
            } else {
                showErrorMessage(listOfNotFieldWithDefaultValues);
            }
        });
    }

    private void fillTestCaseDetails() {
        testCaseDetails.put("Title", TestCaseTitlePanel.getTestCaseTitleTextField());
        testCaseDetails.put("Description", TestCaseDescriptionPanel.getTestCaseDescriptionTextField());
        testCaseDetails.put("Priority", TestCasePriorityPanel.getPriorityComboBox());
        testCaseDetails.put("Type", TestCaseTypePanel.getTypeComboBox());
        testCaseDetails.put("Expected Results", TestCaseExpectedResultsPanel.getTestCaseExpectedResultsTextField());
        CreateNewTestCaseMenu.getStepsTextFieldFromStepsContainerPanel().forEach(stepTextField -> {
            testCaseDetails.put("Step " + (CreateNewTestCaseMenu.getStepsTextFieldFromStepsContainerPanel().indexOf(stepTextField) + 1), stepTextField.getText());
        });

    }

    private List<String> getNotFilledFieldsList() {
        return testCaseDetails.entrySet().stream()
                .filter(entry -> entry.getValue().equals("Please fill out this field!"))
                .map(Map.Entry::getKey)
                .toList();
    }

    private int showConfirmationDialog() {
        return JOptionPane.showConfirmDialog(null, "Would You Like to Save this Test Case?", "Warning", JOptionPane.YES_NO_OPTION);
    }

    private void printTestCaseDetails() {
        testCaseDetails.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private void showErrorMessage(List<String> listOfNotFieldWithDefaultValues) {
        if (!listOfNotFieldWithDefaultValues.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill out the following fields: " + listOfNotFieldWithDefaultValues);
        }
    }
}
