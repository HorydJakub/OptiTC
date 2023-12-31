package panels.settings;

import components.OptiTextField;

import javax.swing.*;

public class UrlPanel extends JPanel {

    private static OptiTextField optiTextField;

    public UrlPanel() {

        // Add label
        JLabel label = new JLabel("URL: ");

        // Add text field
        optiTextField = new OptiTextField(true, false);

        // Add components to the panel
        add(label);
        add(optiTextField);
    }

    public static OptiTextField getOptiTextField() {
        return optiTextField;
    }
}
