package sections;

import components.HeaderPanel;
import components.TestCase;
import components.addnewtestcase.AddNewStepButton;
import components.managetestcases.SaveChangesButton;
import enumerates.Priorities;
import enumerates.Types;
import panels.addnewtestcase.*;

import javax.swing.*;

public class EditTestCaseMenu extends JPanel {

    private TestCase testCase;

    public EditTestCaseMenu(int testCaseId) {

        this.testCase = new TestCase(testCaseId);

        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create Header Panel
        HeaderPanel headerPanel = new HeaderPanel("Edit Test Case of ID: " + testCaseId);

        // Create Test Case Title Panel
        TestCaseTitlePanel testCaseTitlePanel = new TestCaseTitlePanel("Test Case Title:",  testCase.getTestCaseTitle(), true);

        // Create Test Case Description Panel
        TestCaseDescriptionPanel descriptionPanel = new TestCaseDescriptionPanel("Test Case Description:", true);

        // Create Test Case Priority Panel
        TestCasePriorityPanel priorityPanel = new TestCasePriorityPanel(true, testCase.getTestCasePriority());

        // Create Test Case Type Panel
        TestCaseTypePanel typePanel = new TestCaseTypePanel(true, testCase.getTestCaseType());

        // Get size of steps
        int sizeOfSteps = testCase.getTestCaseStepsValuesAsList().size();

        // Create container panel for AddStepPanel
        StepsContainerPanel stepsContainerPanel = new StepsContainerPanel(true, true);

        // Create AddStepPanel for each step
        for (int i = 0; i < sizeOfSteps; i++) {
            AddStepPanel addStepPanel = new AddStepPanel(i + 1, true);
            addStepPanel.getStepTextField().setText(testCase.getTestCaseStepsValuesAsList().get(i));
            stepsContainerPanel.add(addStepPanel);
        }

        // Create Test Case Expected Result Panel
        TestCaseExpectedResultsPanel expectedResultsPanel = new TestCaseExpectedResultsPanel("Expected Result:", testCase.getTestCaseExpectedResult(), true);

        // Refresh TestCaseDetails panel
        revalidate();
        repaint();

        // Add save changes button
        SaveChangesButton saveChangesButton = new SaveChangesButton(testCaseId);
        saveChangesButton.setAlignmentX(CENTER_ALIGNMENT);
        saveChangesButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to the main panel
        add(headerPanel);
        add(testCaseTitlePanel);
        add(descriptionPanel);
        add(priorityPanel);
        add(typePanel);
        add(stepsContainerPanel);
        add(expectedResultsPanel);
        add(saveChangesButton);
    }
}
