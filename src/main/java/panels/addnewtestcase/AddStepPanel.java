package panels.addnewtestcase;

import components.OptiTextField;
import components.addnewtestcase.RemoveSingleStepButton;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class AddStepPanel extends JPanel {

    private OptiTextField stepTextField;

    public AddStepPanel(int stepNumber) {

        // Create Step Label
        JLabel stepLabel = new JLabel("Step: " + stepNumber);

        // Create Step TextField
        stepTextField = new OptiTextField("Please fill out this field!", 500, 30);

        // Remove single step button only when stepNumber is greater than 1
        if (stepNumber > 1) {
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
}


