package components;

import javax.swing.*;
import java.awt.*;

public class TestCaseTitlePanel extends JPanel {

    JLabel testCaseTitleLabel;
    OptiTextField testCaseTitleTextField;

    public TestCaseTitlePanel(String testCaseTitleLabelText, String testCaseTitleTextFieldText) {
        this.testCaseTitleLabel = new JLabel(testCaseTitleLabelText);
        this.testCaseTitleTextField = new OptiTextField(testCaseTitleTextFieldText);
        testCaseTitleTextField.setPreferredSize(new Dimension(500, 30));
        add(testCaseTitleLabel);
        add(testCaseTitleTextField);
    }
}
