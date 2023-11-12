package sections;

import components.*;
import panels.addnewtestcase.TestCaseDescriptionPanel;
import panels.addnewtestcase.TestCaseExpectedResultsPanel;
import panels.addnewtestcase.*;

import javax.swing.*;

public class CreateNewTestCaseMenu extends JPanel {

    private JPanel stepsContainerPanel;
    private int currentStepCount = 1;
    private final int maximumNumberOfSteps = 10;
    public CreateNewTestCaseMenu() {

        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create Header Panel
        HeaderPanel headerPanel = new HeaderPanel("Create New Test Case");

        // Create Test Case Title Panel
        TestCaseTitlePanel testCaseTitlePanel = new TestCaseTitlePanel("Test Case Title:", "Enter Test Case Title");

        // Create Test Case Description Panel
        TestCaseDescriptionPanel descriptionPanel = new TestCaseDescriptionPanel("Test Case Description:", "Enter Test Case Description");

        // Create Test Case Priority Panel
        TestCasePriorityPanel priorityPanel = new TestCasePriorityPanel();

        // Create Test Case Type Panel
        TestCaseTypePanel typePanel = new TestCaseTypePanel();

        // Create Add Step Panel
        AddStepPanel addStepPanel = new AddStepPanel(currentStepCount);

        // Create container panel for AddStepPanel and Add New Step Button
        stepsContainerPanel = new JPanel();
        stepsContainerPanel.setLayout(new BoxLayout(stepsContainerPanel, BoxLayout.Y_AXIS));
        stepsContainerPanel.add(addStepPanel);

        // Create new step button
        JButton addNewStepButton = getjButton();

        // Create Test Case Expected Result Panel
        TestCaseExpectedResultsPanel expectedResultsPanel = new TestCaseExpectedResultsPanel("Expected Result:", "Enter Expected Result");

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

    private JButton getjButton() {
        JButton addNewStepButton = new JButton("Add New Step");

        // put button to the center
        addNewStepButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

        // Add new step button action listener
        addNewStepButton.addActionListener(e -> {
            if (currentStepCount < maximumNumberOfSteps) {
                AddStepPanel newAddStepPanel = new AddStepPanel(currentStepCount+1);
                stepsContainerPanel.add(newAddStepPanel);
                currentStepCount++;
                revalidate();
                repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Maximum number of steps reached.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        return addNewStepButton;
    }
}
