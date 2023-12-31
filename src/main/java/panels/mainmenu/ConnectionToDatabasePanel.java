package panels.mainmenu;

import components.mainmenu.ConfigureConnectionToDatabaseButton;
import core.SqlBuilder;

import javax.swing.*;

public class ConnectionToDatabasePanel extends JPanel {

    private JLabel connectionStatusLabel;
    private ConfigureConnectionToDatabaseButton configureConnectionToDatabaseButton;
    public ConnectionToDatabasePanel() {

        // Set the layout of the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        if (SqlBuilder.isConnected()) {
            connectionStatusLabel = new JLabel("You are connected to database. You can start using the application.");
            // Set dark green color for the text if connected to database
            connectionStatusLabel.setForeground(new java.awt.Color(0, 100, 0));

        } else {
            connectionStatusLabel = new JLabel("Not connected to database. Please click on button below to configure your connection.");
        }

        // Set the alignment of the object to the center
        connectionStatusLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Set top margin
        connectionStatusLabel.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0));

        // Set bigger font size
        connectionStatusLabel.setFont(connectionStatusLabel.getFont().deriveFont(20.0f));

        // Set italics
        connectionStatusLabel.setFont(connectionStatusLabel.getFont().deriveFont(connectionStatusLabel.getFont().getStyle() | java.awt.Font.ITALIC));

        // Authors panel

        // Set red color for the text if not connected to database
        if (!SqlBuilder.isConnected()) {
            connectionStatusLabel.setForeground(java.awt.Color.RED);
        }

        // Add components to the panel
        add(connectionStatusLabel);

        // if not connected to database, add button to configure connection
        if (!SqlBuilder.isConnected()) {
            configureConnectionToDatabaseButton = new ConfigureConnectionToDatabaseButton();
            configureConnectionToDatabaseButton.setAlignmentX(CENTER_ALIGNMENT);
            add(configureConnectionToDatabaseButton);
        }

        if (SqlBuilder.isConnected()) {
            TestCasesStatisticsPanel testCasesStatisticsPanel = new TestCasesStatisticsPanel();

            // Set max width and height for the panel
            testCasesStatisticsPanel.setMaximumSize(new java.awt.Dimension(700, 500));
            add(testCasesStatisticsPanel);
        }
    }
}
