package panels.addnewtestcase;

import components.OptiTextField;
import components.addnewtestcase.RemoveSingleStepButton;

import javax.swing.*;

public class AddStepPanel extends JPanel {

    private OptiTextField stepTextField;
    private int stepNumber;

    public AddStepPanel(int stepNumber, boolean areFieldsEditable) {
        this.stepNumber = stepNumber;

        // Create Step Label
        JLabel stepLabel = new JLabel("Step: " + stepNumber);

        // Create Step TextField
        stepTextField = new OptiTextField("Please fill out this field!", 500, 30, areFieldsEditable);

        // Remove single step button only when stepNumber is greater than 1
        if (stepNumber > 1 && areFieldsEditable) {
            RemoveSingleStepButton removeSingleStepButton = new RemoveSingleStepButton();
            // Add components to the panel
            add(stepLabel);
            add(stepTextField);
            add(removeSingleStepButton);
        } else {
            // Add components to the panel without remove button
            add(stepLabel);
            add(stepTextField);
        }
    }

    public OptiTextField getStepTextField() {
        return stepTextField;
    }

    public int getStepId() {
        return stepNumber;
    }

    public void updateStepNumber(int newStepNumber) {
        stepNumber = newStepNumber;
        // Zaktualizuj etykietę kroku
        JLabel stepLabel = (JLabel) getComponent(0);
        stepLabel.setText("Step: " + newStepNumber);
    }
}


