package panels.testcasedetails;

import components.managetestcases.EditTestCaseButton;
import components.testcasedetails.DeleteTestCaseButton;

import javax.swing.*;

public class TestCaseDetailsButtonsPanel extends JPanel {

    public TestCaseDetailsButtonsPanel(int testCaseId) {

        // Create Delete Test Case Button
        DeleteTestCaseButton deleteTestCaseButton = new DeleteTestCaseButton(testCaseId);

        // Edit Test Case Button
        EditTestCaseButton editTestCaseButton = new EditTestCaseButton(testCaseId);

        // Add components to the panel
        add(deleteTestCaseButton);
        add(editTestCaseButton);
    }
}
