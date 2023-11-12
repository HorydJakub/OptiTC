package components.addnewtestcase;

import core.ConstantValues;
import enumerates.Priorities;
import panels.addnewtestcase.TestCaseDescriptionPanel;
import panels.addnewtestcase.TestCasePriorityPanel;
import panels.addnewtestcase.TestCaseTitlePanel;
import panels.addnewtestcase.TestCaseTypePanel;
import sections.CreateNewTestCaseMenu;

import javax.swing.*;

public class ResetFieldsTestCaseButton extends JButton {

    public ResetFieldsTestCaseButton(String text) {
        super(text);

        // Add listener on click
        addActionListener(e -> {
            System.out.println("Clearing fields...");
            clearFields();
        });
    }

    private void clearFields() {
        // Clear fields
        TestCaseTypePanel.setTypeComboBox("");
        TestCaseTitlePanel.setTestCaseTitleTextField("");
    }
}
