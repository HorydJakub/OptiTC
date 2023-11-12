package panels.addnewtestcase;

import components.OptiTextField;

import javax.swing.*;
import java.awt.*;

public class TestCaseExpectedResultsPanel extends JPanel {

    private JLabel testCaseExpectedResultsLabel;
    private static OptiTextField testCaseExpectedResultsTextField;
    public TestCaseExpectedResultsPanel(String testCaseExpectedResultsLabelText, String testCaseExpectedResultsTextFieldText) {
        this.testCaseExpectedResultsLabel = new JLabel(testCaseExpectedResultsLabelText);
        testCaseExpectedResultsTextField = new OptiTextField(testCaseExpectedResultsTextFieldText, 500, 30);
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
