package components.addnewtestcase;

import panels.addnewtestcase.AddStepPanel;
import panels.addnewtestcase.StepsContainerPanel;

import javax.swing.*;

public class AddNewStepButton extends JButton {

    private final StepsContainerPanel stepsContainerPanel;
    private static int currentStepCount = 1;
    private final int maximumNumberOfSteps = 10;

    public AddNewStepButton(StepsContainerPanel stepsContainerPanel) {
        super("Add New Step");
        this.stepsContainerPanel = stepsContainerPanel;

        // Set button alignment
        setAlignmentX(JButton.CENTER_ALIGNMENT);

        // Add action listener
        addActionListener(e -> {
            addNewStep();
        });
    }

    public static void decrementStepsCount() {
        currentStepCount--;
    }

    public static void setCurrentStepCount(int sizeOfSteps) {
        currentStepCount = sizeOfSteps;
    }


    private void addNewStep() {
        if (currentStepCount < maximumNumberOfSteps) {
            currentStepCount++;
            AddStepPanel newAddStepPanel = new AddStepPanel(currentStepCount, stepsContainerPanel, true);
            stepsContainerPanel.add(newAddStepPanel);
            stepsContainerPanel.revalidate();
            stepsContainerPanel.repaint();
        } else {
            JOptionPane.showMessageDialog(stepsContainerPanel, "Maximum number of steps reached.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void resetStepsCount() {
        currentStepCount = 1;
    }
}