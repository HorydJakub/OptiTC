package components.addnewtestcase;

import components.OptiTextField;
import core.SqlBuilder;
import core.TestCaseAppManager;
import panels.addnewtestcase.*;
import sections.CreateNewTestCaseMenu;
import sections.TestCaseAddedMenu;

import javax.swing.*;
import java.util.ArrayList;
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
        AddNewStepButton.resetStepsCount();
    }

    private void fillTestCaseDetails() {
        testCaseDetails.put("Title", TestCaseTitlePanel.getTestCaseTitleTextField());
        testCaseDetails.put("Description", TestCaseDescriptionPanel.getTestCaseDescriptionTextField());
        testCaseDetails.put("Priority", TestCasePriorityPanel.getPriorityComboBox());
        testCaseDetails.put("Type", TestCaseTypePanel.getTypeComboBox());
        testCaseDetails.put("Expected Results", TestCaseExpectedResultsPanel.getTestCaseExpectedResultsTextField());

        testCaseDetails.entrySet().removeIf(entry -> entry.getKey().startsWith("Step"));

        List<OptiTextField> stepsTextFieldFromStepsContainerPanel = CreateNewTestCaseMenu.getStepsContainerPanel().getStepsTextFieldFromStepsContainerPanel();

        for (int i = 0; i < stepsTextFieldFromStepsContainerPanel.size(); i++) {
            String stepKey = "Step " + (i + 1);
            String stepText = stepsTextFieldFromStepsContainerPanel.get(i).getText();
            testCaseDetails.put(stepKey, stepText);
        }
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
        List<OptiTextField> stepsTextFieldFromStepsContainerPanel = CreateNewTestCaseMenu.getStepsContainerPanel().getStepsTextFieldFromStepsContainerPanel();
        List<String> stepsTextFieldFromStepsContainerPanelValues = stepsTextFieldFromStepsContainerPanel.stream()
                .map(OptiTextField::getText)
                .toList();
        String testCaseExpectedResultsValue = TestCaseExpectedResultsPanel.getTestCaseExpectedResultsTextField();

        SqlBuilder.sendNewTestCaseToDatabase(testCaseTitleValue, testCaseDescriptionValue, testCasePriorityValue, testCaseTypeValue, stepsTextFieldFromStepsContainerPanelValues, testCaseExpectedResultsValue);
    }

    private void showErrorMessage(List<String> listOfNotFieldWithDefaultValues) {
        List<String> orderedFields = new ArrayList<>();

        // Add fields to the list in the preferred order
        orderedFields.add("Title");
        orderedFields.add("Description");
        orderedFields.addAll(listOfNotFieldWithDefaultValues.stream()
                .filter(field -> !field.equals("Title") && !field.equals("Description") && !field.equals("Expected Results"))
                .toList());
        orderedFields.add("Expected Results");

        // Create a formatted message with sorted fields
        StringBuilder message = new StringBuilder("Please fill out the following fields: ");

        for (String field : orderedFields) {
            if (listOfNotFieldWithDefaultValues.contains(field)) {
                // If the field should not be filled, apply red font color
                message.append("<font color='red'>").append(field).append("</font>").append(", ");
            } else {
                message.append(field).append(", ");
            }
        }

        // Remove the last comma and space
        if (!message.isEmpty()) {
            message.setLength(message.length() - 2);
        }

        // Show the message with HTML formatting for color
        JOptionPane.showMessageDialog(null, "<html>" + message + "</html>");
    }

}

