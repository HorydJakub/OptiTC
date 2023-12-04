package panels.addnewtestcase;

import components.OptiTextField;

import javax.swing.*;

public class TestCaseExpectedResultsPanel extends JPanel {

    private static OptiTextField testCaseExpectedResultsTextField;
    public TestCaseExpectedResultsPanel(String testCaseExpectedResultsLabelText, boolean isEditable) {
        JLabel testCaseExpectedResultsLabel = new JLabel(testCaseExpectedResultsLabelText);
        testCaseExpectedResultsTextField = new OptiTextField(isEditable, false);
        add(testCaseExpectedResultsLabel);
        add(testCaseExpectedResultsTextField);
    }

    public static String getTestCaseExpectedResultsTextField() {
        return testCaseExpectedResultsTextField.getText();
    }

    public static void setTestCaseExpectedResultsTextField(String testCaseExpectedResultsTextFieldText) {
        testCaseExpectedResultsTextField.setText(testCaseExpectedResultsTextFieldText);
    }
}
