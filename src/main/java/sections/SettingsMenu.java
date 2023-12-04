package sections;

import components.HeaderPanel;
import core.PropertiesHandler;
import panels.settings.*;

import javax.swing.*;

public class SettingsMenu extends JPanel {

    public SettingsMenu() {

        // Add layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create header
        HeaderPanel header = new HeaderPanel("Settings");

        // Create DatabaseConnectionInfoPanel
        DatabaseConnectionInfoPanel databaseConnectionInfoPanel = new DatabaseConnectionInfoPanel();

        // Create UrlPanel
        UrlPanel urlPanel = new UrlPanel();

        // Create UsernamePanel
        UsernamePanel usernamePanel = new UsernamePanel();

        // Create PasswordPanel
        PasswordPanel passwordPanel = new PasswordPanel();

        // Create DatabaseSettingsButtonsPanel
        DatabaseSettingsButtonsPanel databaseSettingsButtonsPanel = new DatabaseSettingsButtonsPanel();

        // Get data from default.properties file
        PropertiesHandler propertiesHandler = new PropertiesHandler();
        UrlPanel.getOptiTextField().setText(propertiesHandler.getSqlUrl());
        UsernamePanel.getOptiTextField().setText(propertiesHandler.getSqlUser());
        PasswordPanel.getOptiTextField().setText(propertiesHandler.getSqlPassword());

        // Add components to the panel
        add(header);
        add(databaseConnectionInfoPanel);
        add(urlPanel);
        add(usernamePanel);
        add(passwordPanel);
        add(databaseSettingsButtonsPanel);

    }
}
