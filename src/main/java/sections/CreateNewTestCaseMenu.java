package sections;

import javax.swing.*;

public class CreateNewTestCaseMenu extends JPanel {

    public CreateNewTestCaseMenu() {

        JLabel createNewTestCaseLabel = new JLabel("Create New Test Case");
        add(createNewTestCaseLabel);

        // Create buttons and fields
        JLabel testCaseNameLabel = new JLabel("Test Case Name");
        JTextField testCaseNameTextField = new JTextField("Test Case Name");

        JLabel testCaseDescriptionLabel = new JLabel("Test Case Description");
        JTextField testCaseDescriptionTextField = new JTextField("Test Case Description");

        JLabel testCasePriorityLabel = new JLabel("Test Case Priority");
        JTextField testCasePriorityTextField = new JTextField("Test Case Priority");

        JLabel testCaseSeverityLabel = new JLabel("Test Case Severity");
        JTextField testCaseSeverityTextField = new JTextField("Test Case Severity");

        JLabel testCaseTypeLabel = new JLabel("Test Case Type");
        JTextField testCaseTypeTextField = new JTextField("Test Case Type");

        JLabel testCaseCategoryLabel = new JLabel("Test Case Category");
        JTextField testCaseCategoryTextField = new JTextField("Test Case Category");

        JLabel testCasePreconditionsLabel = new JLabel("Test Case Preconditions");
        JTextField testCasePreconditionsTextField = new JTextField("Test Case Preconditions");

        // Set layout manager, button is under label, buttons and labels are in 3 rows and 2 columns
        setLayout(new java.awt.GridLayout(7, 2));

        // Add buttons and fields to the panel
        add(testCaseNameLabel);
        add(testCaseNameTextField);
        add(testCaseDescriptionLabel);
        add(testCaseDescriptionTextField);
        add(testCasePriorityLabel);
        add(testCasePriorityTextField);
        add(testCaseSeverityLabel);
        add(testCaseSeverityTextField);
        add(testCaseTypeLabel);
        add(testCaseTypeTextField);
        add(testCaseCategoryLabel);
        add(testCaseCategoryTextField);
        add(testCasePreconditionsLabel);
        add(testCasePreconditionsTextField);
    }
}
