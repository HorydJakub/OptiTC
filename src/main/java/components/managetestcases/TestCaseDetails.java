package components.managetestcases;

import components.HeaderPanel;
import components.TestCase;
import panels.addnewtestcase.*;

import javax.swing.*;

public class TestCaseDetails extends JPanel {

    private TestCase testCase;
    public TestCaseDetails(int testCaseId) {
        this.testCase = new TestCase(testCaseId);

        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create Header Panel
        HeaderPanel headerPanel = new HeaderPanel("Test Case Details of: " + testCaseId);

        // Create Test Case Title Panel
        TestCaseTitlePanel testCaseTitlePanel = new TestCaseTitlePanel("Test Case Title:", testCase.getTestCaseTitle(), false);

        // Create Test Case Description Panel
        TestCaseDescriptionPanel descriptionPanel = new TestCaseDescriptionPanel("Test Case Description:", testCase.getTestCaseDescription(), false);

        // Create Test Case Priority Panel
        TestCasePriorityPanel priorityPanel = new TestCasePriorityPanel(false, testCase.getTestCasePriority());

        // Create Test Case Type Panel
        TestCaseTypePanel typePanel = new TestCaseTypePanel(false, testCase.getTestCaseType());

        // Get size of steps
        int sizeOfSteps = testCase.getTestCaseStepsValuesAsList().size();

        // Create container panel for AddStepPanel
        StepsContainerPanel stepsContainerPanel = new StepsContainerPanel(false);

        // Create AddStepPanel for each step
        for (int i = 0; i < sizeOfSteps; i++) {
            AddStepPanel addStepPanel = new AddStepPanel(i + 1, false);
            addStepPanel.getStepTextField().setText(testCase.getTestCaseStepsValuesAsList().get(i));
            stepsContainerPanel.add(addStepPanel);
        }

        // Create Test Case Expected Result Panel
        TestCaseExpectedResultsPanel expectedResultsPanel = new TestCaseExpectedResultsPanel("Expected Result:", testCase.getTestCaseExpectedResult(), false);

        // Refresh TestCaseDetails panel
        revalidate();
        repaint();


        // Add components to the main panel
        add(headerPanel);
        add(testCaseTitlePanel);
        add(descriptionPanel);
        add(priorityPanel);
        add(typePanel);
        add(stepsContainerPanel);
        add(expectedResultsPanel);
    }


}
