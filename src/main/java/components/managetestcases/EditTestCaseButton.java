package components.managetestcases;

import core.TestCaseAppManager;
import sections.EditTestCaseMenu;

import javax.swing.*;

public class EditTestCaseButton extends JButton {

    private int testCaseId;

    public EditTestCaseButton(int testCaseId) {
        super("Edit");
        this.testCaseId = testCaseId;
        addActionListener(e -> openEditTestCaseDialog());
    }

    private void openEditTestCaseDialog() {
        // Show confirmation dialog
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit this test case?", "Edit Test Case", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // open new edit menu
            openNewEditMenu();
        }
    }

    private void openNewEditMenu() {

        // Delete content from dashboard
        TestCaseAppManager.getDashboard().removeAll();

        // Create new edit menu
        EditTestCaseMenu editTestCaseMenu = new EditTestCaseMenu(testCaseId);

        // Add edit menu to the main panel
        TestCaseAppManager.getDashboard().add(editTestCaseMenu);

        // Refresh main panel
        TestCaseAppManager.getDashboard().revalidate();
        TestCaseAppManager.getDashboard().repaint();
    }
}
