package panels.addnewtestcase;

import components.addnewtestcase.ResetFieldsTestCaseButton;
import components.addnewtestcase.SaveTestCaseButton;

import javax.swing.*;

public class FinishCreatingTestCasePanel extends JPanel {

    private JButton saveTestCaseButton;
    private ResetFieldsTestCaseButton clearFieldsButton;
    private JButton cancelButton;
    public FinishCreatingTestCasePanel() {

        // Create Save Test Case Button
        saveTestCaseButton = new SaveTestCaseButton("Save Test Case");

        // Create Clear Fields Button
        clearFieldsButton = new ResetFieldsTestCaseButton("Clear Fields");

        // Create Cancel Button
        cancelButton = new JButton("Cancel");

        // Add components to the panel
        add(saveTestCaseButton);
        add(clearFieldsButton);
        add(cancelButton);
    }
}
