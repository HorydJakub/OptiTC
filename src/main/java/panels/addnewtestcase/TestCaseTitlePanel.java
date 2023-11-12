package panels.addnewtestcase;

import components.OptiTextField;

import javax.swing.*;
import java.awt.*;

public class TestCaseTitlePanel extends JPanel {

    private JLabel testCaseTitleLabel;
    private static OptiTextField testCaseTitleTextField;
    public TestCaseTitlePanel(String testCaseTitleLabelText, String testCaseTitleTextFieldText) {
        this.testCaseTitleLabel = new JLabel(testCaseTitleLabelText);
        testCaseTitleTextField = new OptiTextField(testCaseTitleTextFieldText,500, 30);
        add(testCaseTitleLabel);
        add(testCaseTitleTextField);
    }

    public static String getTestCaseTitleTextField() {
        return testCaseTitleTextField.getText();
    }

    public static void setTestCaseTitleTextField(String testCaseTitleTextFieldText) {
        testCaseTitleTextField.setText(testCaseTitleTextFieldText);
    }
}
