package panels.addnewtestcase;

import components.addnewtestcase.ResetFieldsButton;
import components.addnewtestcase.SaveTestCaseButton;

import javax.swing.*;

public class FinishCreatingTestCasePanel extends JPanel {

    private JButton saveTestCaseButton;
    private JButton resetFieldsButton;
    public FinishCreatingTestCasePanel() {

        // Create Save Test Case Button
        saveTestCaseButton = new SaveTestCaseButton();

        // Create Cancel Button
        resetFieldsButton = new ResetFieldsButton();

        // Add components to the panel
        add(saveTestCaseButton);
        add(resetFieldsButton);
    }
}
