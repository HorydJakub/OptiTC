package components.mainmenu;

import core.TestCaseAppManager;
import sections.SettingsMenu;

import javax.swing.*;

public class ConfigureConnectionToDatabaseButton extends JButton {

    public ConfigureConnectionToDatabaseButton() {
        super("Configure Connection to Database");

        // On click listener
        addActionListener(e -> {
            TestCaseAppManager.getDashboard().removeAll();
            TestCaseAppManager.getDashboard().add(new SettingsMenu());
            TestCaseAppManager.getDashboard().repaint();
            TestCaseAppManager.getDashboard().revalidate();
        });
    }
}
