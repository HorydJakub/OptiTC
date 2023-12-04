package panels.settings;

import components.OptiTextField;

import javax.swing.*;

public class UsernamePanel extends JPanel {

    private static OptiTextField textField = new OptiTextField(true, false);

    public UsernamePanel() {

        // Add label
        JLabel label = new JLabel("Username: ");

        // Add components to the panel
        add(label);
        add(textField);
    }

    public static OptiTextField getOptiTextField() {
        return textField;
    }
}
