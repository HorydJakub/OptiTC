package sections;

import components.HeaderPanel;
import components.TestCaseDescriptionPanel;
import components.TestCaseTitlePanel;

import javax.swing.*;

public class CreateNewTestCaseMenu extends JPanel {

    public CreateNewTestCaseMenu() {

        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create Header Panel
        HeaderPanel headerPanel = new HeaderPanel("Create New Test Case");

        // Create Test Case Title Panel
        TestCaseTitlePanel testCaseTitlePanel = new TestCaseTitlePanel("Test Case Title:", "Enter Test Case Title");

        // Create Test Case Description Panel
        TestCaseDescriptionPanel descriptionPanel = new TestCaseDescriptionPanel("Test Case Description:", "Enter Test Case Description");

        // Add components to the panel
        add(headerPanel);
        add(testCaseTitlePanel);
        add(descriptionPanel);
    }
}
