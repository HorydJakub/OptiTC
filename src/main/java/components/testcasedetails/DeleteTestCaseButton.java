package components.testcasedetails;

import core.SqlBuilder;
import core.TestCaseAppManager;
import sections.ManageTestCasesMenu;

import javax.swing.*;

public class DeleteTestCaseButton extends JButton {

    public DeleteTestCaseButton(int testCaseId) {
        super("Delete Test Case");

        addActionListener(e -> deleteTestCaseById(testCaseId));
    }

    private void deleteTestCaseById(int testCaseId) {

        // Show confirmation dialog
        int confirmationDialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this test case?", "Delete Test Case", JOptionPane.YES_NO_OPTION);
        if (confirmationDialogResult == JOptionPane.YES_OPTION) {
            // Delete test case from database
            SqlBuilder.deleteTestCaseById(testCaseId);

            // Redirect to Manage Test Cases Menu
            redirectToManageTestCasesMenu();
        }
    }

    private void redirectToManageTestCasesMenu() {
        ManageTestCasesMenu manageTestCasesMenu = new ManageTestCasesMenu();
        TestCaseAppManager.getDashboard().removeAll();
        TestCaseAppManager.getDashboard().add(manageTestCasesMenu);
        TestCaseAppManager.getDashboard().revalidate();
        TestCaseAppManager.getDashboard().repaint();
    }
}
