package components.addnewtestcase;

import components.OptiTextField;
import core.PropertiesHandler;
import core.SqlBuilder;
import core.TestCaseAppManager;
import panels.addnewtestcase.*;
import sections.CreateNewTestCaseMenu;
import sections.TestCaseAddedMenu;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveTestCaseButton extends JButton {

    private final HashMap<String, String> testCaseDetails = new HashMap<>();

    public SaveTestCaseButton() {
        super("Save Test Case");
        addActionListener(e -> {
            fillTestCaseDetails();
            List<String> listOfNotFieldWithDefaultValues = getNotFilledFieldsList();
            if (listOfNotFieldWithDefaultValues.isEmpty()) {
                int confirmationDialogResult = showConfirmationDialog();
                if (confirmationDialogResult == JOptionPane.YES_OPTION) {
                    uploadTestCaseToDataBase();
                    showConfirmationMenu();
                }
            } else {
                showErrorMessage(listOfNotFieldWithDefaultValues);
            }
        });
    }

    private void showConfirmationMenu() {
        TestCaseAppManager.getDashboard().removeAll();
        TestCaseAppManager.getDashboard().add(new TestCaseAddedMenu());
        TestCaseAppManager.getDashboard().revalidate();
        TestCaseAppManager.getDashboard().repaint();
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

    private void uploadTestCaseToDataBase() {
        String testCaseTitleValue = TestCaseTitlePanel.getTestCaseTitleTextField();
        String testCaseDescriptionValue = TestCaseDescriptionPanel.getTestCaseDescriptionTextField();
        String testCasePriorityValue = TestCasePriorityPanel.getPriorityComboBox();
        String testCaseTypeValue = TestCaseTypePanel.getTypeComboBox();
        List<OptiTextField> stepsTextFieldFromStepsContainerPanel = CreateNewTestCaseMenu.getStepsTextFieldFromStepsContainerPanel();
        List<String> stepsTextFieldFromStepsContainerPanelValues = stepsTextFieldFromStepsContainerPanel.stream()
                .map(OptiTextField::getText)
                .toList();
        String testCaseExpectedResultsValue = TestCaseExpectedResultsPanel.getTestCaseExpectedResultsTextField();

        SqlBuilder.sendNewTestCaseToDatabase(testCaseTitleValue, testCaseDescriptionValue, testCasePriorityValue, testCaseTypeValue, stepsTextFieldFromStepsContainerPanelValues, testCaseExpectedResultsValue);
    }

    private void showErrorMessage(List<String> listOfNotFieldWithDefaultValues) {
        if (!listOfNotFieldWithDefaultValues.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill out the following fields: " + listOfNotFieldWithDefaultValues);
        }
    }
}
