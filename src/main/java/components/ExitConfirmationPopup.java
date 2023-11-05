package components;

import javax.swing.*;

public class ExitConfirmationPopup extends JOptionPane {

    public ExitConfirmationPopup() {
        int result = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to exit?",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION
        );
        System.exit(0);
    }
}
