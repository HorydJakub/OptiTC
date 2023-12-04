package panels.addnewtestcase;

import components.OptiTextField;

import javax.swing.*;
import java.awt.*;

public class TestCaseDescriptionPanel extends JPanel {

    private JLabel testCaseDescriptionLabel;
    private static OptiTextField testCaseDescriptionTextField;
    public TestCaseDescriptionPanel(String testCaseDescriptionLabelText, boolean isEditable) {
        this.testCaseDescriptionLabel = new JLabel(testCaseDescriptionLabelText);
        testCaseDescriptionTextField = new OptiTextField(isEditable, false);
        add(testCaseDescriptionLabel);
        add(testCaseDescriptionTextField);
    }

    public static String getTestCaseDescriptionTextField() {
        return testCaseDescriptionTextField.getText();
    }

    public static void setTestCaseDescriptionTextField(String testCaseDescriptionTextFieldText) {
        testCaseDescriptionTextField.setText(testCaseDescriptionTextFieldText);
    }
}
