package panels.settings;

import components.OptiTextField;
import enumerates.SupportedDatabases;

import javax.swing.*;

public class DatabaseConnectionInfoPanel extends JPanel {

    public DatabaseConnectionInfoPanel() {

        // Add label
        JLabel label = new JLabel("Currently supported databases: " + SupportedDatabases.MYSQL.getName() + ". Do not forget to create 'optitc' database before save!");

        // Set font size
        label.setFont(label.getFont().deriveFont(15.0f));

        // Set font style
        label.setFont(label.getFont().deriveFont(java.awt.Font.BOLD));

        // Center text
        label.setHorizontalAlignment(JLabel.CENTER);

        // Top margin
        label.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        // Add components to the panel
        add(label);
    }
}
