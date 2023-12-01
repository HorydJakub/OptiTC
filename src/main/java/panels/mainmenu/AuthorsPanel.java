package panels.mainmenu;

import javax.swing.*;

public class AuthorsPanel extends JPanel {

    public AuthorsPanel() {
        // Set the layout of the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // JLabel info about authors
        JLabel authorsInfoLabel = new JLabel("The application was created by: Jakub Horyd and Przemyslaw Drygas");

        // Set aligment of the object to the center
        authorsInfoLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Set font size
        authorsInfoLabel.setFont(authorsInfoLabel.getFont().deriveFont(20.0f));

        // Set top margin
        authorsInfoLabel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        // Add components to the panel
        add(authorsInfoLabel);
    }
}
