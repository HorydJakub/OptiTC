package components.addnewtestcase;

import panels.addnewtestcase.AddStepPanel;

import javax.swing.*;
import java.awt.*;

public class AddNewStepButton extends JButton {

    private final JPanel stepsContainerPanel;
    private static int currentStepCount = 1;
    private final int maximumNumberOfSteps = 10;

    public AddNewStepButton(JPanel stepsContainerPanel) {
        super("Add New Step");
        this.stepsContainerPanel = stepsContainerPanel;

        // Set button alignment
        setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add action listener
        addActionListener(e -> addNewStep());
    }

    private void addNewStep() {
        if (currentStepCount < maximumNumberOfSteps) {
            currentStepCount++;
            AddStepPanel newAddStepPanel = new AddStepPanel(currentStepCount, true);
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