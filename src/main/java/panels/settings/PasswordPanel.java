package panels.settings;

import components.OptiTextField;

import javax.swing.*;

public class PasswordPanel extends JPanel {

    private static final OptiTextField textField = new OptiTextField(true, true);

    public PasswordPanel() {

        // Add label
        JLabel label = new JLabel("Password: ");

        // Add components to the panel
        add(label);
        add(textField);
    }

    public static OptiTextField getOptiTextField() {
        return textField;
    }
}
