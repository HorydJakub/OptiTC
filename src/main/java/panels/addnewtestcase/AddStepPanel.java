package panels.addnewtestcase;

import components.OptiTextField;

import javax.swing.*;

public class AddStepPanel extends JPanel {

    public JLabel stepLabel;
    public OptiTextField stepTextField;
    public AddStepPanel(int stepNumber) {

        // Create Step Label
        stepLabel = new JLabel("Step: " + stepNumber);

        // Create Step TextField
        stepTextField = new OptiTextField("Enter Step", 500, 30);

        // Add components to the panel
        add(stepLabel);
        add(stepTextField);
    }
}


