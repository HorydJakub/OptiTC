package panels.testcasedetails;

import components.testcasedetails.DeleteTestCaseButton;

import javax.swing.*;

public class TestCaseDetailsButtonsPanel extends JPanel {

    public TestCaseDetailsButtonsPanel(int testCaseId) {

        // Create Delete Test Case Button
        DeleteTestCaseButton deleteTestCaseButton = new DeleteTestCaseButton(testCaseId);

        // Add components to the panel
        add(deleteTestCaseButton);
    }
}
