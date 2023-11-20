package sections;

import components.*;
import components.addnewtestcase.AddNewStepButton;
import panels.addnewtestcase.TestCaseDescriptionPanel;
import panels.addnewtestcase.TestCaseExpectedResultsPanel;
import panels.addnewtestcase.*;

import javax.swing.*;

public class CreateNewTestCaseMenu extends JPanel {

    private static StepsContainerPanel stepsContainerPanel = new StepsContainerPanel();
    public CreateNewTestCaseMenu() {

        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create Header Panel
        HeaderPanel headerPanel = new HeaderPanel("Create New Test Case");

        // Create Test Case Title Panel
        TestCaseTitlePanel testCaseTitlePanel = new TestCaseTitlePanel("Test Case Title:", "Please fill out this field!");

        // Create Test Case Description Panel
        TestCaseDescriptionPanel descriptionPanel = new TestCaseDescriptionPanel("Test Case Description:", "Please fill out this field!");

        // Create Test Case Priority Panel
        TestCasePriorityPanel priorityPanel = new TestCasePriorityPanel();

        // Create Test Case Type Panel
        TestCaseTypePanel typePanel = new TestCaseTypePanel();

        // Create container panel for AddStepPanel and Add New Step Button
        stepsContainerPanel = new StepsContainerPanel();

        // Create new step button
        AddNewStepButton addNewStepButton = new AddNewStepButton(stepsContainerPanel);

        // Create Test Case Expected Result Panel
        TestCaseExpectedResultsPanel expectedResultsPanel = new TestCaseExpectedResultsPanel("Expected Result:", "Please fill out this field!");

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
