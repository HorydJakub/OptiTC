package sections;

import components.HeaderPanel;
import components.managetestcases.TestCasesTable;
import core.TestCaseAppManager;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ManageTestCasesMenu extends JPanel {

    public ManageTestCasesMenu() {

        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create Header Panel
        HeaderPanel headerPanel = new HeaderPanel("Manage Test Cases");

        // Create Test Cases Table
        TestCasesTable testCasesTable = new TestCasesTable();

        // Get table header
        JTableHeader tableHeader = testCasesTable.getTableHeader();

        // Set max width of the table header
        tableHeader.setMaximumSize(new Dimension(TestCaseAppManager.getDashboard().getWidthOfDashboard(), 100));

        // Add components to the main panel
        add(headerPanel);
        add(testCasesTable.getTableHeader());
        add(testCasesTable);
    }
}
