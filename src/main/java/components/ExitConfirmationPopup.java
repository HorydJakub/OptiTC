package components;

import javax.swing.*;

public class ExitConfirmationPopup extends JOptionPane {

    public ExitConfirmationPopup() {

        // If the user clicks the "Yes" button, exit the program
        if (showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", YES_NO_OPTION) == YES_OPTION) {
            System.exit(0);
        }
    }
}
