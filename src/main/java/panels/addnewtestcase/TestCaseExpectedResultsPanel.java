package panels.addnewtestcase;

import components.OptiTextField;

import javax.swing.*;
import java.awt.*;

public class TestCaseExpectedResultsPanel extends JPanel {

    private JLabel testCaseExpectedResultsLabel;
    private OptiTextField testCaseExpectedResultsTextField;
    public TestCaseExpectedResultsPanel(String testCaseExpectedResultsLabelText, String testCaseExpectedResultsTextFieldText) {
        this.testCaseExpectedResultsLabel = new JLabel(testCaseExpectedResultsLabelText);
        this.testCaseExpectedResultsTextField = new OptiTextField(testCaseExpectedResultsTextFieldText, 500, 30);
        add(testCaseExpectedResultsLabel);
        add(testCaseExpectedResultsTextField);
    }
}
