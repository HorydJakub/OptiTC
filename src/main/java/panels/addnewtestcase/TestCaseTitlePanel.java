package panels.addnewtestcase;

import components.OptiTextField;

import javax.swing.*;

public class TestCaseTitlePanel extends JPanel {

    private JLabel testCaseTitleLabel;
    private static final OptiTextField testCaseTitleTextField = new OptiTextField(false, false);
    public TestCaseTitlePanel(String testCaseTitleLabelText) {
        this.testCaseTitleLabel = new JLabel(testCaseTitleLabelText);
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
