package sections;

import components.HeaderPanel;
import panels.mainmenu.AuthorsPanel;
import panels.mainmenu.ConnectionToDatabasePanel;

import javax.swing.*;

public class MainMenu extends JPanel {

    public MainMenu() {
        // Set the layout of the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Main menu header
        HeaderPanel headerPanel = new HeaderPanel("Main Menu");

        // Connection to database panel
        ConnectionToDatabasePanel connectionToDatabasePanel = new ConnectionToDatabasePanel();

        // Authors panel
         AuthorsPanel authorsPanel = new AuthorsPanel();

        // Add components to the panel
        add(headerPanel);
        add(authorsPanel);
        add(connectionToDatabasePanel);
    }
}
