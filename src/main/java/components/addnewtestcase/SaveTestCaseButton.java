package components.addnewtestcase;

import components.OptiTextField;
import core.PropertiesHandler;
import panels.addnewtestcase.*;
import sections.CreateNewTestCaseMenu;

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

        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    propertiesHandler.getSqlUrl(), propertiesHandler.getSqlUser(), propertiesHandler.getSqlPassword()
            );
            Statement statement = connection.createStatement();

            StringBuilder stepsConcatenated = new StringBuilder();
            for (String step : stepsTextFieldFromStepsContainerPanelValues) {
                stepsConcatenated.append(step).append("\n"); // Separating steps by newline
            }

            // Constructing the SQL INSERT statement
            String insertQuery = "INSERT INTO test_cases " +
                    "(testcase_name, testcase_description, testcase_priority, testcase_type, step, testcase_expected_results) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            // Creating prepared statement for SQL injection prevention and better performance
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, testCaseTitleValue);
            preparedStatement.setString(2, testCaseDescriptionValue);
            preparedStatement.setString(3, testCasePriorityValue);
            preparedStatement.setString(4, testCaseTypeValue);
            preparedStatement.setString(5, stepsConcatenated.toString()); // Inserting steps as concatenated string
            preparedStatement.setString(6, testCaseExpectedResultsValue);

            // Executing the insert query
            preparedStatement.executeUpdate();

            // Closing resources
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void showErrorMessage(List<String> listOfNotFieldWithDefaultValues) {
        if (!listOfNotFieldWithDefaultValues.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill out the following fields: " + listOfNotFieldWithDefaultValues);
        }
    }
}
