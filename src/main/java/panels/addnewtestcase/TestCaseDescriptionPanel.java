package panels.addnewtestcase;

import components.OptiTextField;

import javax.swing.*;
import java.awt.*;

public class TestCaseDescriptionPanel extends JPanel {

    private JLabel testCaseDescriptionLabel;
    private OptiTextField testCaseDescriptionTextField;
    public TestCaseDescriptionPanel(String testCaseDescriptionLabelText, String testCaseDescriptionTextFieldText) {
        this.testCaseDescriptionLabel = new JLabel(testCaseDescriptionLabelText);
        this.testCaseDescriptionTextField = new OptiTextField(testCaseDescriptionTextFieldText, 500, 30);
        add(testCaseDescriptionLabel);
        add(testCaseDescriptionTextField);
    }
}
