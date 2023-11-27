package components.managetestcases;

import javax.swing.*;

public class TestCaseDetails extends JPanel {

    public TestCaseDetails(int testCaseId) {
        JLabel testCaseIdLabel = new JLabel("Test Case ID: " + testCaseId);
        add(testCaseIdLabel);
    }
}
