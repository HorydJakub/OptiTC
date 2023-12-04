package sections;

import components.*;
import components.addnewtestcase.AddNewStepButton;
import enumerates.Priorities;
import enumerates.Types;
import panels.addnewtestcase.TestCaseDescriptionPanel;
import panels.addnewtestcase.TestCaseExpectedResultsPanel;
import panels.addnewtestcase.*;

import javax.swing.*;

public class CreateNewTestCaseMenu extends JPanel {

    private static final StepsContainerPanel stepsContainerPanel = new StepsContainerPanel(true, false);
    public CreateNewTestCaseMenu() {

        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create Header Panel
        HeaderPanel headerPanel = new HeaderPanel("Create New Test Case");

        // Create Test Case Title Panel
        TestCaseTitlePanel testCaseTitlePanel = new TestCaseTitlePanel("Test Case Title:");

        // Create Test Case Description Panel
        TestCaseDescriptionPanel descriptionPanel = new TestCaseDescriptionPanel("Test Case Description:", true);

        // Create Test Case Priority Panel
        TestCasePriorityPanel priorityPanel = new TestCasePriorityPanel(true, Priorities.MEDIUM);

        // Create Test Case Type Panel
        TestCaseTypePanel typePanel = new TestCaseTypePanel(true, Types.FUNCTIONAL);

        // Create container panel for AddStepPanel and Add New Step Button
        new StepsContainerPanel(true, false);

        // Create new step button
        AddNewStepButton addNewStepButton = new AddNewStepButton(stepsContainerPanel);

        // Create Test Case Expected Result Panel
        TestCaseExpectedResultsPanel expectedResultsPanel = new TestCaseExpectedResultsPanel("Expected Result:", true);

        // Create Finish Creating Test Case Panel
        FinishCreatingTestCasePanel finishCreatingTestCasePanel = new FinishCreatingTestCasePanel();

        // Add components to the main panel
        add(headerPanel);
        add(testCaseTitlePanel);
        add(descriptionPanel);
        add(priorityPanel);
        add(typePanel);
        add(stepsContainerPanel);
        add(addNewStepButton);
        add(expectedResultsPanel);
        add(finishCreatingTestCasePanel);
    }

    public static StepsContainerPanel getStepsContainerPanel() {
        return stepsContainerPanel;
    }
}
