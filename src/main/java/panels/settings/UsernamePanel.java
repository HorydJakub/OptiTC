package panels.settings;

import components.OptiTextField;

import javax.swing.*;

public class UsernamePanel extends JPanel {

    private static OptiTextField textField;

    public UsernamePanel() {

        // Add label
        JLabel label = new JLabel("Username: ");

        // Add text field
        textField = new OptiTextField("Please fill out this field!", 500, 30, true);

        // Add components to the panel
        add(label);
        add(textField);
    }

    public static OptiTextField getOptiTextField() {
        return textField;
    }
}
